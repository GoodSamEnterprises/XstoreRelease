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
 * BZ27310          220818    [Internal]Work Order Service is Offline screen displays 
 *                            incorrectly when Response is:404 Not Found is returned from EBS
 *===================================================================
 */

package caw.pos.workorder.op;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.data2.access.IQueryResultList;
import dtv.pos.common.PromptKey;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractListPromptOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawWorkOrderSearchOp extends AbstractListPromptOp {

    private static final Logger            _logger = LogManager
            .getLogger(CawWorkOrderSearchOp.class);

    private static final IXstDataActionKey SELECT  = XstDataActionKey
            .valueOf("SELECT");

    @Inject
    protected WorkOrderHelper              _workOrderHelper;

    @Inject
    private IBusyState                     _busyState;

    /* Get prompt.
     * @see dtv.pos.iframework.op.IPromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_WORK_ORDER_LIST");
    }

    /* Get work order account list.
     * @see dtv.pos.framework.op.AbstractListPromptOp#getPromptList(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected Object[] getPromptList(IXstEvent argParamIXstEvent) {

        IRetailTransaction trans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        IQueryResultList<CawWorkOrderEBSQueryResult> queryResults = null;
        Object[] workOrders = null;

        if (trans != null) {
            try {
                int retailLocationId = _stationState.getRetailLocationId();
                int workstationId = _stationState.getWorkstationId();
                String currentCustomerId = CawWorkOrderHelper.getInstance()
                        .getCurrentCustomerId(trans.getCustomerParty());
                String maxResult = CawConfigurationMgr.getMaxNumberOfResults();

                _busyState.start(CawConstants.BUSY_STATE_MSG);
                queryResults = CawWorkOrderHelper.getInstance()
                        .searchWorkOrderEBS(retailLocationId, workstationId, currentCustomerId, maxResult);
                _busyState.end();
            } catch (Exception ex) {
                _busyState.end();
                _logger.error("Work Order Search, can not find work order: "
                        + ex.getMessage());
            }
        }

        if (queryResults != null && queryResults.size() > 0) {
            workOrders = queryResults.toArray();
        }
        //BZ27310 removed check unavailable//
        return workOrders;
    }

    /* Get empty result prompt.
     * @see dtv.pos.framework.op.AbstractListPromptOp#getEmptyListPromptKey()
     */
    @Override
    protected PromptKey getEmptyListPromptKey() {

        //BZ27310 removed check unavailable//
        if (!CawUtilFunction.allowEBSConnection()
                || !CawWorkOrderHelper.getInstance().isEbsOnline()) {
            return PromptKey.valueOf("CAW_WORK_ORDER_UNAVAILABLE");
        }
        return PromptKey.valueOf("CAW_WORK_ORDER_NOT_FOUND");
    }

    /* Handle action.
     * @see dtv.pos.framework.op.AbstractListPromptOp#handleDataAction(dtv.pos.iframework.action.IXstDataAction)
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey actionKey = argEvent.getActionKey();

        if (actionKey == SELECT) {
            Object data = argEvent.getData();
            if (data instanceof CawWorkOrderEBSQueryResult) {
                CawWorkOrderEBSQueryResult selectedWorkOrderResult = (CawWorkOrderEBSQueryResult) data;
                _transactionScope
                        .setValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT, selectedWorkOrderResult);
                return HELPER.completeResponse();
            }
        }
        return super.handleDataAction(argEvent);
    }

    /* Process to next OP.
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }

}
