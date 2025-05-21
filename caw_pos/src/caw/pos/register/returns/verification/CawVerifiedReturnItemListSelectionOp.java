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
 * BZ34226          271219    [New Requirement] Add Warning beeps for any prompt requiring action
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ46111          111021    [UAT] Electric World Phase 1 Mixed Transaction Return Error
 * BZ47329          111021    [Internal] Electric World Phase 1 - HDE when returning an EW order item then voiding it on the Sale screen.
 *===================================================================
 */

package caw.pos.register.returns.verification;

import static dtv.hardware.types.InputType.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.CawPropertyUtils;
import caw.pos.common.CawValueKeys;
import caw.pos.register.CawReturnLineItemFilter;

import dtv.data2.access.IDataModel;
import dtv.hardware.types.InputType;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.RetailTransactionListModel;
import dtv.pos.register.returns.*;
import dtv.pos.register.returns.verification.VerifiedReturnItemListSelectionOp;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.*;
import dtv.xst.query.results.CustomerTransHistoryResult;

public class CawVerifiedReturnItemListSelectionOp extends VerifiedReturnItemListSelectionOp implements IXstEventObserver {

    private static final Logger          _logger = LogManager
            .getLogger(CawVerifiedReturnItemListSelectionOp.class);
    
    @Inject
    private ReturnManager _returnMgr;

    private static final IXstEventType[] EVENTS = new IXstEventType[] { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION, INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE };

    @Override
    public IXstEventType[] getObservedEvents() {

        return EVENTS;
    }

    /* BEGIN BZ46111 */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        
        if (argEvent instanceof IXstDataAction) {
            if (((IXstDataAction) argEvent).getActionKey() == XstDataActionKey.YES) {

                return handleNotVerifiedReturn();
            } else if (((IXstDataAction) argEvent).getActionKey() == XstDataActionKey.NO) {

                this._returnMgr.setCurrentOrigTransactionId(null);
                setOpState(null);
    
                return this.HELPER.getStartChainResponse(OpChainKey.valueOf("RETURN_ITEM_AUTHORIZE"));
            }
        }
        
        return super.handleOpExec(argEvent);
    }
    /* END BZ46111 */
    
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        if (!(argEvent instanceof IXstAction)) {
            CawHardwareHelper.getInstance().sendBeepScanner(CawHardwareHelper
                    .getInstance().getScanner(), CawHardwareHelper.getInstance()
                            .getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
            return HELPER.waitResponse();
        }
        return super.handlePromptEvent(argEvent);
    }

    /*BEGIN BZ28036*/
    /* (non-Javadoc)
     * override this method to highlight the item line which has selected item.
     * @see dtv.pos.register.returns.verification.VerifiedReturnItemListSelectionOp#getSelectedIndices(java.lang.Object[])
     */
    @Override
    protected Integer[] getSelectedIndices(Object[] argList) {
        int index = -1;
        if (_transactionScope
                .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null) {
            _transactionScope
            .clearValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION);
            CustomerTransHistoryResult itemSelected = _transactionScope.getValue(CawValueKeys.ITEM_SELECTED);
            ISaleReturnLineItem lineItem = null;
            for (int i = 0; i < argList.length; i++) {
                Object o = argList[i];
                if (o instanceof ISaleReturnLineItem) {
                    lineItem = (ISaleReturnLineItem) o;
                    if (lineItem.getItemId().equals(itemSelected.getItemId())
                            && lineItem.getQuantity()
                                    .equals(itemSelected.getQty())) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index != -1 ? new Integer[] {index}
                : super.getSelectedIndices(argList);
    }
    /*END BZ28036*/
    
    /* BEGIN BZ46111 */
    @Override
    protected Object[] getPromptList(IXstEvent argEvent) {
        IRetailTransaction originalTrans = getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION);
        List<IRetailTransactionLineItem> tranItems = originalTrans.getRetailTransactionLineItems();
        CawReturnLineItemFilter lineItemFilter = new CawReturnLineItemFilter(new RetailTransactionListModel.GroupingFilter());
        List<? extends IDataModel> displayItems = lineItemFilter.filter(tranItems, _transactionScope);
        setScopedValue(ValueKeys.CURRENT_VERIFIED_RETURN_ITEMS, displayItems);
        return displayItems.toArray();
    }
    
    protected IOpResponse handleNotVerifiedReturn() {

        ReturnItemType returnItemType = getScopedValue(ValueKeys.RETURN_ITEM_TYPE);
        OpChainKey chainKey = returnItemType.getChainKey();

        if (chainKey != null) {
            return this.HELPER.getStartChainResponse(chainKey);
        }

        _logger.error("There is no chain key specified for return item type "
                + returnItemType.getName());
        return this.HELPER.errorNotifyResponse();
    }

    @Override
    protected IOpResponse getEmptyListPromptResponse() {
        if (_transactionScope.getValue(CawReturnLineItemFilter.IS_NO_ORDER_IN_OB) != null) {
    
            Boolean isNoOrderInOb = _transactionScope.getValue(CawReturnLineItemFilter.IS_NO_ORDER_IN_OB);
            if (isNoOrderInOb) {
                _transactionScope.clearValue(CawReturnLineItemFilter.IS_NO_ORDER_IN_OB);
                /*BEGIN 47329*/
                _transactionScope.clearValue(TransactionScopeKeys.RETURNING_WITH_GIFT_RECEIPT);
                this._returnMgr.setCurrentReturnType(ReturnType.UNVERIFIED);
                /*END 47329*/
                return this.HELPER.getPromptResponse(PromptKey.valueOf("RETURN_VERIFICATION_NOT_FOUND"), new dtv.i18n.IFormattable[0]);
            }
        }
        
        return super.getEmptyListPromptResponse();
    }
    /* END BZ46111 */
}
