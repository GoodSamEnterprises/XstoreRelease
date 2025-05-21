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
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.FormKey;
import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.maint.PromptRejectOrderOp;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawPromptRejectOrderOp extends PromptRejectOrderOp {

    private static final String ORDER_PROMPT_KEY  = "OrderPromptKey";
    private static final String PARTIAL_UPDATE    = "PARTIAL_UPDATE";

    public static final String ORDER_FORM_KEY     = "ORDER_MAINTENANCE_DETAIL";

    private String             _orderPromptKey    = null;

    private String             _itemPromptKey     = null;

    private String             _promptQtyChainKey = null;

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        if (this.hasOrderItemSelection()) {
            this.setPromptKey(this._itemPromptKey);
        } else {
            this.setPromptKey(this._orderPromptKey);
        }
        this.initializeOrderItemsToProcess();
        return super.handleOpExec(argEvent);
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        if (argEvent instanceof IXstDataAction) {
            IXstDataAction action = (IXstDataAction) argEvent;
            if (PARTIAL_UPDATE.equals(action.getActionKey().toString())) {
                return this.HELPER.getCompleteStackChainResponse(OpChainKey.valueOf(this._promptQtyChainKey));
            }
        }
        return super.handlePromptResponse(argEvent);
    }

    private boolean hasOrderItemSelection() {

        boolean hasItemSelection = false;
        List<IOrderLine> orderLines = this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
        if (orderLines == null || orderLines.isEmpty()) {
            List<IOrderLine> itemSelections = this.getOrderItemsFromModel();
            hasItemSelection = itemSelections != null && !itemSelections.isEmpty();
        }
        return hasItemSelection;
    }

    private List<IOrderLine> getOrderItemsFromModel() {

        List<IOrderLine> orderLines = null;
        CawOrderDetailEditModel orderModel = (CawOrderDetailEditModel) this._modeProvider.get().getStationModel()
                .getEditModel(FormKey.valueOf("ORDER_MAINTENANCE_DETAIL"));
        orderLines = orderModel.getSelectedOrderLines();
        if (orderLines == null || orderLines.isEmpty()) {
            orderLines = orderModel.getSelectedOrderLines();
        }
        return orderLines;
    }

    private void initializeOrderItemsToProcess() {

        List<IOrderLine> orderLines = this
                .getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
        if (orderLines == null) {
            orderLines = this.getOrderItemsFromModel();
            this.setScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS, orderLines);
        }
    }

    @Override
    public void setParameter(String argName, String argValue) {

        if (ORDER_PROMPT_KEY.equalsIgnoreCase(argName)) {
            this._orderPromptKey = argValue;
        } else if ("ItemPromptKey".equalsIgnoreCase(argName)) {
            this._itemPromptKey = argValue;
        } else if ("PromptQtyChainKey".equalsIgnoreCase(argName)) {
            this._promptQtyChainKey = argValue;
        } else {
            super.setParameter(argName, argValue);
        }

    }

}
