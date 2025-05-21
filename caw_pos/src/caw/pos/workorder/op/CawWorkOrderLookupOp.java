/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ26207          190718    New Requirement - Enable Work Order Functionality
 * BZ26945          300718    Work Order Item Not On File screen title is incorrect
 * BZ27051          030818    [1.6.3] Retry/Esc instead of Back/Esc button displays on Word Order Cross Store.
 * BZ27120          090818    [WorkOrder] Cross store prompt should be displayed when lookup any cross store workorder
 * BZ27166          130818    [1.6.7] WO Blank white screen when complete WO deposit
 * BZ27246          200818    Unlocking WO from S&I causes Work Order Offline screen to display when you attempt to select Work Order Complete in Xstore
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 * BZ30754          160519    [PORT 30531 to 5.0] [Prod] Unable to complete the WO if WO deposit is created in xstore offline mode
 * BZ31520          250619    [Port BZ31207 to 5.0][Work Order] clicking back after selecting a WO throws error message
 * BZ30530          300719    [New Requirement] Change the message verbiage for work order deposit error
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import caw.pos.workorder.common.*;

import dtv.data2.access.IDataModel;
import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.customer.account.AccountManager;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.cat.ICustomerAccount;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawWorkOrderLookupOp extends Operation {

    private static final Logger      _logger = LogManager
            .getLogger(CawWorkOrderLookupOp.class);

    @Inject
    private Provider<AccountManager> _amProvider;

    @Inject
    private IBusyState               _busyState;

    @Inject
    protected FormattableFactory     _ff;

    /* The idea, get work order account info from S&I, if it is not exist in database,
     * then create a new work order account with info, then deposit and store it in database.
     * Later, when lookup that account for performing a complete, retrieve work order account 
     * from database.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IOpResponse response = handleWorkOrder();
        if (response != null) {
            return response;
        } else {
            return HELPER.getPromptResponse(PromptKey
                    .valueOf("CAW_WORK_ORDER_DATA_ERROR"), promptMessage(false, false, null)); /* BZ30530 */
        }
    }

    /**
     * Display message on prompt.
     * @return
     */
    protected IFormattable[] promptMessage(boolean isCrossStore,
            boolean isExistedDeposit, String woNumber) {

        IFormattable[] args = new IFormattable[2];

        // Begin BZ26945
        if (isCrossStore) {
            args[0] = _ff
                    .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_CROSS_STORE);
            args[1] = _ff
                    .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_CROSS_STORE_MESSAGE);
        } else if (isExistedDeposit) {
            // Begin BZ27246
            args[0] = _ff.getSimpleFormattable(String.format(_ff
                    .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_HAS_DEPOSIT)
                    .toString(), woNumber));
            args[1] = _ff.getSimpleFormattable(String.format(_ff
                    .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_HAS_DEPOSIT_MSG)
                    .toString(), woNumber));
            // End BZ27246
        } else {
            /* BEGIN BZ30530 */
            if (!CawUtilFunction.allowEBSConnection() || !CawWorkOrderHelper.getInstance().isEbsOnline()) {
                args[0] = _ff.getTranslatable("_woUnavailable");
                args[1] = _ff.getTranslatable("_woUnavailableMsg");
            } else {
                args[0] = _ff.getTranslatable("_woDataError");
                args[1] = _ff.getTranslatable("_woDataErrorMsg");
            }
            /* END BZ30530 */
        }
        // End BZ26945
        return args;
    }

    /**
     * handle case of WorkOrder
     * @return
     */
    protected IOpResponse handleWorkOrder() {

        try {
            CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                    .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
            IRetailTransaction trans = _transactionScope
                    .getTransaction(TransactionType.RETAIL_SALE);
            if (workOrderResult != null && trans != null) {

                String workOrderNumber = workOrderResult.getWoNumber();
                String status = workOrderResult.getWoPosStatusDescription();
                int orgStoreId = CawUtilFunction
                        .vInt(workOrderResult.getOriginatingRetailLocationId());
                if (status != null) {
                    if (orgStoreId != _stationState.getRetailLocationId()) {
                        //BZ27120: Do not allow to do cross store
                        AccountManager am = _amProvider.get();
                        am.clear();
                        return HELPER.getPromptResponse(PromptKey
                                .valueOf(CawWorkOrderConstants.CAW_WORK_ORDER_CROSS_STORE_PROMPT), promptMessage(true, false, null));
                    } else {
                        //Try to retrieve work order account from database.
                        IDataModel model = CawWorkOrderHelper.getInstance().retrieveAccount(workOrderResult); /*BZ30754*/
                        if (CawWorkOrderConstants.OPEN
                                .equalsIgnoreCase(status)) {

                            if (model != null) {
                                return HELPER.getPromptResponse(PromptKey
                                        .valueOf(CawWorkOrderConstants.CAW_WORK_ORDER_CROSS_STORE_PROMPT), promptMessage(false, true, workOrderNumber));
                            }
                            return callLookupWorkOrder(workOrderResult); //BZ27378
                        } else if (CawWorkOrderConstants.DEPOSIT
                                .equalsIgnoreCase(status)) {
                            /*ICustomerAccount account = null;*/
                            if (model != null
                                    && model instanceof ICustomerAccount) {

                                return callLookupWorkOrder(workOrderResult); //BZ27378
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("handleWorkOrder-1", ex);
        }

        return null;
    }

    /**
     * BZ27378
     * call lookup work order.
     * @return
     */
    private IOpResponse callLookupWorkOrder(
            CawWorkOrderEBSQueryResult workOrderResult) {

        List<CawWorkOrderItem> wolistItems = null;
        try {
            int retailLocationId = _stationState.getRetailLocationId();
            int workstationId = _stationState.getWorkstationId();
            _busyState.start(CawConstants.BUSY_STATE_MSG);
            wolistItems = CawWorkOrderHelper.getInstance()
                    .lookupWorkOrderEBS(retailLocationId, workstationId, workOrderResult
                            .getWoNumber());
            _busyState.end();
        } catch (Exception ex) {
            _busyState.end();
            _logger.error("WO lookup error: " + ex.getMessage());
        }
        if (wolistItems != null) {
            _busyState.startPermanent(CawConstants.BUSY_STATE_MSG); /*BZ31520*/
            workOrderResult.setWoItems(wolistItems);
            _logger.debug("WO start CAW_NEW_WORK_ORDER_CHAIN opchain.");
            return HELPER.getStartChainResponse(OpChainKey
                    .valueOf("CAW_NEW_WORK_ORDER_CHAIN"));
        }
        return null;
    }
}
