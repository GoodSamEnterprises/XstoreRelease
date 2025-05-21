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
import java.util.stream.Collectors;

import javax.inject.Inject;

import dtv.pos.order.OrderHelper;
import dtv.pos.order.maint.OrderDetailEditModel;
import dtv.ui.model.ICombinedListModel;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawOrderDetailEditModel extends OrderDetailEditModel {

    private IOrder              _order;

    private CawOrderItemListModel  _orderItemListModel;

    @Inject
    private OrderHelper         _orderHelper;

    public CawOrderDetailEditModel(IOrder argSelectedOrder) {

        super(argSelectedOrder);
        this._order = argSelectedOrder;
        List<IOrderLine> nonVoidedLines = super.getOrderItems();
        this._orderItemListModel = new CawOrderItemListModel(nonVoidedLines);
    }

    public ICombinedListModel<?> getOrderItemLines() {

        return this._orderItemListModel;
    }

    public List<IOrderLine> getSelectedOrderLines() {

        List<IOrderLine> orderLines = null;
        List<?> elements = this.getOrderItemLines().getSelectedElements();
        if (elements != null) {
            orderLines = elements.stream().filter((li) -> {
                return li instanceof IOrderLine;
            }).map((li) -> {
                return (IOrderLine) li;
            }).collect(Collectors.toList());
        }
        return orderLines;
    }

    @Override
    protected void addSimpleFields() {

        super.addSimpleFields();
        this.addField("orderItemLines", ICombinedListModel.class, 10);
    }

    public void refreshOrderLines() {
        this._orderItemListModel.refreshOrderLines(this._orderHelper, this._order, _stationState.getRetailLocationId());
    }
}
