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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import dtv.pos.common.FormKey;
import dtv.pos.iframework.IModeController;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.order.OrderUtil;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawOrderLineRejectValidationRule extends AbstractValidationRule {

    private List<String>                _acceptedStatuses = new ArrayList<String>();

    @Inject
    protected Provider<IModeController> _modeProvider;

    @Inject
    private OrderUtil                   _orderUtil;

    @Override
    public IValidationResult validate() {

        List<IOrderLine> orderLines = this.getApplicableOrderLines();
        if (orderLines != null && !orderLines.isEmpty()) {
            boolean hasInvalidOrderLine = orderLines.stream()
                    .anyMatch((dtl) -> {
                        return !this.isValidOrderLine(dtl);
                    });
            if (!hasInvalidOrderLine) {
                return IValidationResult.SUCCESS;
            }
        }
        return SimpleValidationResult
                .getFailed("_orderMaintenanceDetailValidationError");
    }

    private boolean isValidOrderLine(IOrderLine argOrderLine) {

        return this._orderUtil.isSourcedFromLocation(argOrderLine, this._stationState.getRetailLocationId())
                && this._acceptedStatuses.contains(argOrderLine.getStatusCode());
    }

    //get selected item
    @SuppressWarnings("unchecked")
    protected List<IOrderLine> getApplicableOrderLines() {

        CawOrderDetailEditModel orderModel = (CawOrderDetailEditModel) this._modeProvider
                .get().getStationModel().getEditModel(FormKey.valueOf("ORDER_MAINTENANCE_DETAIL"));
        List<IOrderLine> orderLines = null;
        if (orderModel != null && orderModel.getOrderItemLines() != null) {
            orderLines = orderModel.getSelectedOrderLines();
            //if no item is selected, get all item of the order 
            if (orderLines == null || orderLines.isEmpty()) {
                orderLines = (List<IOrderLine>) orderModel.getOrderItemLines().getModel().getElements();
            }
        }
        return orderLines;
    }

    //only allow reject item has status in (POLLED, ACCEPTED, RESERVED)
    public void setAcceptedStatuses(List<String> argAcceptedStatuses) {

        this._acceptedStatuses = argAcceptedStatuses;
    }

    protected List<String> getAcceptedStatues() {

        return this._acceptedStatuses;
    }

}
