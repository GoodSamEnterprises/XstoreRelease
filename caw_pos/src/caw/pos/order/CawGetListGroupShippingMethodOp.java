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
 * BZ38387          091020    [Internal] Xstore should not make a call Shipping API at Add tender button when doing Cancel Delivery_Order
 *===================================================================
 */

package caw.pos.order;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import caw.pos.common.CawUtilFunction;
import caw.pos.common.CawValueKeys;
import caw.pos.shippingfee.CawGetListsShippingFee;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawGetListGroupShippingMethodOp extends Operation {

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

        if (CawUtilFunction.allowEBSConnection()) {
            IOrder currentOrder = null;
            IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
            currentOrder = this._orderMgr.getCurrentOrder();
            // Is Ship to Customer
            List<CawShippingGroupsModel> shippingGroupsModels = CawShippingRateHelper
                    .getInstance().getShippingGroupModels(trans, currentOrder);
            if (CollectionUtils.isNotEmpty(shippingGroupsModels)) {
                setScopedValue(CawValueKeys.CAW_SHIPPING_GROUP_MODEL, shippingGroupsModels);
                CawGetListsShippingFee.setShippingGroupsModels(shippingGroupsModels);
                _transactionScope.setValue(CawValueKeys.CAW_GROUP_ID, 0);
                _transactionScope.setValue(CawValueKeys.TEMP_SHIPPING_FEE, new HashMap<String, BigDecimal>());
                
                CawGetListsShippingFee.setTotalOrderShippingFee(null);

            } else {
                // Display Process Offline
                return HELPER.getPromptResponse(PromptKey.valueOf("EBS_SHIPPING_OFFLINE"));
            }
        } else {
            // Display Process Offline
            return HELPER.getPromptResponse(PromptKey.valueOf("EBS_SHIPPING_OFFLINE"));
        }

        return HELPER.completeResponse();
    }
}
