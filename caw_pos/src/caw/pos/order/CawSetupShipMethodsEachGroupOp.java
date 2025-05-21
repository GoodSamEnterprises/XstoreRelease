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
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * BZ38389          091020    [Internal] The content on Shipping Exception screen are not indicated fully all items are into the same Shipping group.
 * BZ38387          091020    [Internal] Xstore should not make a call Shipping API at Add tender button when doing Cancel Delivery_Order 
 *===================================================================
 */

package caw.pos.order;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import caw.pos.common.CawValueKeys;

import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.inv.IShipperMethod;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawSetupShipMethodsEachGroupOp extends Operation {
    
    @Inject
    private OrderMgr _orderMgr;
    /* BEGIN BZ38387 */
    @Override
    public boolean isOperationApplicable() {
        return CawShippingRateHelper.getInstance().isNewDeliveryOrder(_orderMgr);
    }
    /* END BZ38387 */

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg) {

        List<CawShippingGroupsModel> shippingGroupModels = getScopedValue(CawValueKeys.CAW_SHIPPING_GROUP_MODEL);

        Integer groupId = _transactionScope.getValue(CawValueKeys.CAW_GROUP_ID);

        if (groupId != null && CollectionUtils.isNotEmpty(shippingGroupModels)) {

            return getOpResponse(groupId.intValue(), shippingGroupModels);

        }

        return HELPER.completeResponse();

    }

    /**
     * @param groupId
     * @param shippingGroupModels
     * @return
     */
    public IOpResponse getOpResponse(int groupId,
            List<CawShippingGroupsModel> shippingGroupModels) {

        List<IShipperMethod> shipperMethods = null;
        CawShippingGroupsModel shippingGroupModel = null;

        try {
            shippingGroupModel = shippingGroupModels.get(groupId);

            if (shippingGroupModel != null) {

                shipperMethods = CawShippingRateHelper.getInstance().getShippingMethods(shippingGroupModel);

                if (CollectionUtils.isNotEmpty(shipperMethods)) {

                    setScopedValue(CawValueKeys.CAW_SHIPPER_METHODS, shipperMethods);

                    _transactionScope.setValue(CawValueKeys.CAW_GROUP_ID, shippingGroupModel.getGroupId());
                    return HELPER.getWaitStackChainResponse(OpChainKey
                            .valueOf("CAW_PROMPT_SHIPPING_METHODS"));
                }
                else if (CollectionUtils.isEmpty(shipperMethods)
                        && (CollectionUtils.isNotEmpty(shippingGroupModel.getShippingItemsModels()))) {
                    // SHOW WARNING MESSAGE
                    IFormattable[] args = new IFormattable[1];
                    /* BEGIN BZ38389 */
                    StringBuffer listItemIds = CawShippingRateHelper
                            .getInstance().getListItemIds(shippingGroupModel
                                    .getShippingItemsModels());
                    if (listItemIds != null && listItemIds.length() > 0) {
                        args[0] = FormattableFactory.getInstance()
                                .getSimpleFormattable(listItemIds.toString());
                    }
                    /* END BZ38389 */
                    removeItemsNotAppliedShippingFee(shippingGroupModel.getShippingItemsModels());
                    int nextGroupId = groupId + 1;                    
                    _transactionScope.setValue(CawValueKeys.CAW_GROUP_ID, nextGroupId);
                    
                    return HELPER.getPromptResponse(PromptKey
                            .valueOf("EBS_SHIPPING_HAS_ERROR"), args);
                }
            }
        } catch (Exception ex) {
            // Could not find group to show, then finish 
            return HELPER.completeResponse();
        }

        return HELPER.completeResponse();
    }
    
    /**
     * @param shippingItemsModels
     */
    public void removeItemsNotAppliedShippingFee(List<CawShippingItemsModel> shippingItemsModels) {
        
        IOrder currentOrder = this._orderMgr.getCurrentOrder();
        
        List<IOrderLine> currentOrderLines = currentOrder.getOrderLines();

        List<IOrderLine> newOrderLines = new ArrayList<IOrderLine>();
        
        for (CawShippingItemsModel cawShippingItemsModel : shippingItemsModels) {

            for (IOrderLine orderLine : currentOrderLines) {
                newOrderLines.add(orderLine);
                if (orderLine.getItem() != null
                        && orderLine.getItem().getItemId()
                                .equals(cawShippingItemsModel.getItemCode())) {
                    orderLine.setVoid(true);
                    orderLine.getShadowedSaleItem().setVoid(true);
                } 
            }
            currentOrderLines = newOrderLines;
            currentOrder.setOrderLines(currentOrderLines);
            newOrderLines = new ArrayList<IOrderLine>();
            _orderMgr.setCurrentOrder(currentOrder);
        }
    }
}
