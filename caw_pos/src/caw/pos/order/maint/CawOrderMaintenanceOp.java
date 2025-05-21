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
 * BZ46682          131021    [Internal] Partial Rejected items does not display on the Order Maintenance screen - BOPIS
 *===================================================================
 */

package caw.pos.order.maint;

import caw.pos.common.CawValueKeys;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.maint.OrderMaintenanceOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawOrderMaintenanceOp extends OrderMaintenanceOp {

    @Override
    protected CawOrderDetailEditModel createModel() {

        IOrder selectedOrder = this.getScopedValue(ValueKeys.SELECTED_ORDER);
        CawOrderDetailEditModel detailModel = new CawOrderDetailEditModel(selectedOrder);
        return detailModel;
    }

    @Override
    protected IOpResponse handleBeforeDataAction(IXstEvent argEvent) {

        CawOrderDetailEditModel model = (CawOrderDetailEditModel) this.getModel();
        if (model.getModeledOrder() == null) {
            return this.HELPER.getOpChainRollBackRequest();
        } else {
            if (this.getScopedValue(CawValueKeys.IS_REJECT_ORDER) != null
                    && Boolean.valueOf(this.getScopedValue(CawValueKeys.IS_REJECT_ORDER))) {
                model.refreshOrderLines();
            }
            this.clearScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
            this.clearScopedValue(CawValueKeys.IS_REJECT_ORDER);
            this.clearScopedValue(CawValueKeys.ORDER_LINE_DETAILS_PARTIAL_UPDATE_QTY);
            this.clearScopedValue(ValueKeys.SELECTED_REASON_CODE);
            this.clearScopedValue(CawValueKeys.ORDER_REJECTED_LINES);
            this.clearScopedValue(CawValueKeys.CAW_ORDER_QUANTITIES);/*BZ46682*/
            return super.handleBeforeDataAction(argEvent);
        }
    }
}
