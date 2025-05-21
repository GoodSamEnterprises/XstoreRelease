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
 * BZ38353          091020    [Internal] Need to be shown SKU items also shipping rate value of each service level displaying on the Shipping method screen.
 * BZ38387          091020    [Internal] Xstore should not make a call Shipping API at Add tender button when doing Cancel Delivery_Order
 * BZ38382          121020    [Internal] Shipping via/method should only be applied to line item when Xstore is completed selected method and fee for all items into transaction.
 * BZ38442          131020    [TASK] Handling about calculate shipping Fee of Delivery order included a regular item, restricted item with additional freight, and freight quote item
 *===================================================================
 */
package caw.pos.order;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import caw.pos.common.CawValueKeys;
import caw.pos.shippingfee.CawGetListsShippingFee;

import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractListPromptOp;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IReversibleOp;
import dtv.pos.inventory.ship.ShipperMethodFactory;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.inv.IShipperMethod;

/**
 *
 */
public class CawPromptShipMethodsEachGroupOp extends AbstractListPromptOp implements IReversibleOp {
    
    @Inject
    private TransactionScope        _transScope;

    @Inject
    private OrderMgr _orderMgr;
    /* BEGIN BZ38387 */
    @Override
    public boolean isOperationApplicable() {
        return CawShippingRateHelper.getInstance().isNewDeliveryOrder(_orderMgr);
    }
    /* END BZ38387 */
    /* BEGIN BZ38353 */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        Integer curentGroupId = _transScope.getValue(CawValueKeys.CAW_GROUP_ID);
        List<CawShippingGroupsModel> shippingGroupModels = getScopedValue(CawValueKeys.CAW_SHIPPING_GROUP_MODEL);
        List<CawShippingItemsModel> shippingItemsModels = null;
        IFormattable[] args = new IFormattable[1];
        
        if (curentGroupId != null
                && CollectionUtils.isNotEmpty(shippingGroupModels)) {
            shippingItemsModels = CawShippingRateHelper.getInstance()
                    .getListShippingItemsByGroup(shippingGroupModels, curentGroupId);

            if (CollectionUtils.isNotEmpty(shippingItemsModels)) {
                StringBuffer listItemIds = CawShippingRateHelper.getInstance()
                        .getListItemIds(shippingItemsModels);

                if (listItemIds != null && listItemIds.length() > 0) {
                    args[0] = FormattableFactory.getInstance()
                            .getSimpleFormattable(listItemIds.toString());
                }

            }
        }
        return new IFormattable[] { args[0] };
    }
    /* END BZ38353 */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("ORDER_SHIPPING_METHOD");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        IShipperMethod shippingMethod = (IShipperMethod) argEvent.getData();

        List<CawShippingGroupsModel> shippingGroupModels = getScopedValue(CawValueKeys.CAW_SHIPPING_GROUP_MODEL);

        Integer curentGroupId = _transScope.getValue(CawValueKeys.CAW_GROUP_ID);
        // APPLY CURRENT SHIPPING METHODS BEFOR NEXT GROUP
        if (curentGroupId != null && curentGroupId.intValue() != 0) {
            curentGroupId = curentGroupId - 1;
        }
        // Apply Methods selected for items
        /* BEGIN BZ38382 */
        CawShippingRateHelper.getInstance().assignShipMethodsToAllItems(shippingGroupModels, _orderMgr, shippingMethod, curentGroupId);
        /* END BZ38382 */
        // Calculate the Shipping fee
        if (shippingMethod != null
                && CollectionUtils.isNotEmpty(shippingGroupModels)
                && curentGroupId != null) {
            calculateFeebyGroup(shippingGroupModels, shippingMethod, curentGroupId);
        }

        return this.HELPER.completeResponse();
    }
    
    /**
     * @param shippingGroupModels
     * @param shippingMethod
     * @param curentGroupId
     */
    @SuppressWarnings("unchecked")
    public void calculateFeebyGroup(List<CawShippingGroupsModel> shippingGroupModels, IShipperMethod shippingMethod,int groupId) {

        HashMap<String, BigDecimal> totalShippingFee = _transScope.getValue(CawValueKeys.TEMP_SHIPPING_FEE);
        List<CawShipperMethodAPIModel> shipperMethodAPIModels;
        
        if (CollectionUtils.isNotEmpty(shippingGroupModels)) {

            for (CawShippingGroupsModel shippingGroupsModel : shippingGroupModels) {

                shipperMethodAPIModels = shippingGroupsModel.getShipperMethodAPIModels();

                if (CollectionUtils.isNotEmpty(shipperMethodAPIModels)) {

                    for (CawShipperMethodAPIModel shipperMethodAPIModel : shipperMethodAPIModels) {

                        if (shippingMethod != null
                                && shippingMethod.getShipperId() != null
                                && shippingMethod.getShipperId().equals(shipperMethodAPIModel.getShipperMethodId())) {

                            totalShippingFee.put(String.valueOf(groupId), shipperMethodAPIModel.getFeeTotal());// BZ38442

                            _transScope.setValue(CawValueKeys.TEMP_SHIPPING_FEE, totalShippingFee);
                            break;
                        }
                    }
                }
            }
        }
        CawGetListsShippingFee.setTotalOrderShippingFee(totalShippingFee);
    }

    @Override
    protected PromptKey getEmptyListPromptKey() {

        return PromptKey.valueOf("ORDER_NO_SHIPPING_METHODS");
    }

    @Override
    protected Object[] getPromptList(IXstEvent argArg0) {

        List<CawShippingGroupsModel> shippingGroupModels = getScopedValue(CawValueKeys.CAW_SHIPPING_GROUP_MODEL);

        Integer curentGroupId = _transScope.getValue(CawValueKeys.CAW_GROUP_ID);

        List<IShipperMethod> shippingMethods = null;

        for (CawShippingGroupsModel cawShippingGroupsModel : shippingGroupModels) {

            if (curentGroupId.intValue() == cawShippingGroupsModel.getGroupId()) {
                shippingMethods = CawShippingRateHelper.getInstance().getShippingMethods(cawShippingGroupsModel);
                break;
            }
        }

        if (CollectionUtils.isEmpty(shippingMethods)) {
            shippingMethods = ShipperMethodFactory.getInstance().getShipperMethods();
        }

        return shippingMethods != null ? shippingMethods.toArray() : null;
    }

    @Override
    public IOpResponse handleOpReverse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey key = argEvent.getActionKey();

        Integer curentGroupId = _transScope.getValue(CawValueKeys.CAW_GROUP_ID);
        
        List<CawShippingGroupsModel> shippingGroupModels = getScopedValue(CawValueKeys.CAW_SHIPPING_GROUP_MODEL);
        
        List<IShipperMethod> shippingMethods = null;

        if (key == XstDataActionKey.valueOf("EXIT") && curentGroupId != null
                && curentGroupId.intValue() != 0) {
            // CLICK BACK
            curentGroupId = curentGroupId.intValue() - 1;

            _transScope.setValue(CawValueKeys.CAW_GROUP_ID, curentGroupId);

            return super.handleDataAction(argEvent);

        } else if (key == XstDataActionKey.valueOf("ACCEPT")
                && curentGroupId != null) {
            // CLICK OK APPLY CURRENT SHIPPING METHODS            
            if (CollectionUtils.isNotEmpty(shippingGroupModels)) {
                for (CawShippingGroupsModel cawShippingGroupsModel : shippingGroupModels) {
                    if (curentGroupId.intValue() == cawShippingGroupsModel
                            .getGroupId()) {
                        shippingMethods = CawShippingRateHelper.getInstance()
                                .getShippingMethods(cawShippingGroupsModel);
                        break;
                    }

                }
            }
            if (CollectionUtils.isNotEmpty(shippingMethods)) {
                _transScope.setValue(CawValueKeys.CAW_SHIPPER_METHODS, shippingMethods);
            }
            // SHOW NEXT GROUP
            curentGroupId = curentGroupId.intValue() + 1;
            _transScope.setValue(CawValueKeys.CAW_GROUP_ID, curentGroupId);
            
            return super.handleDataAction(argEvent);
            
        } else if (key == XstDataActionKey.valueOf("EXIT")) {
            // EXIT AND CLEAR VARIABLES
            _transScope.setValue(CawValueKeys.CAW_GROUP_ID, 0);
            _transScope.setValue(CawValueKeys.CAW_SHIPPER_METHODS, new ArrayList<IShipperMethod>());
            _transScope.setValue(CawValueKeys.TEMP_SHIPPING_FEE, new HashMap<String, BigDecimal>());
            /* BEGIN BZ38382 */
            CawShippingRateHelper.getInstance().assignShipMethodsToAllItems(shippingGroupModels, _orderMgr, null, curentGroupId);
            /* END BZ38382 */
            return HELPER.silentErrorResponse();
        }

        return super.handleDataAction(argEvent);
    }
}
