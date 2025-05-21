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
 * BZ27248          210818    Warranty Items from S&I are not associated with the items covered
 * BZ31943          170719    [Port BZ31529 to 5.0]Xstore did not capture the coupon code for WO discount from S/I
 *===================================================================
 */

package caw.pos.workorder.op;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderConstants;

import dtv.hardware.types.HardwareType;
import dtv.pos.common.OpChainKey;
import dtv.pos.customer.account.type.CustomerItemAccountDetailType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawWorkOrderReAddWarrantyItemOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderReAddWarrantyItemOp.class);

    @Override
    public boolean isOperationApplicable() {

        List<String> warrantyItems = _transactionScope
                .getValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY);

        if (warrantyItems != null && warrantyItems.size() > 0) {
            return true;
        }

        return false;
    }

    @Inject
    private WorkOrderHelper _workOrderHelper;

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        List<String> warrantyItems = _transactionScope
                .getValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY);
        ISaleReturnLineItem newWOLineItem = null;

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();

        try {
            if (account != null) {
                ISaleReturnLineItem lineItem = null;
                List<ICustomerItemAccountDetail> listDetails = account
                        .getCustItemAccountDetails();
                Map<String, BigDecimal> discountList = new HashMap<String, BigDecimal>(); /* BZ31943 */

                for (ICustomerItemAccountDetail detailLine : listDetails) {
                    if (warrantyItems != null && warrantyItems.size() > 0) {
                        for (String itemId : warrantyItems) {
                            if (detailLine
                                    .getRetailLineItem() instanceof ISaleReturnLineItem) {
                                lineItem = (ISaleReturnLineItem) detailLine
                                        .getRetailLineItem();

                                if (lineItem != null && lineItem.getItemId()
                                        .equals(itemId)) {
                                    newWOLineItem = ItemLocator.getLocator()
                                            .getSaleLineItem(lineItem
                                                    .getItem(), SaleItemType.WORK_ORDER, false, true, HardwareType.KEYBOARD);

                                    newWOLineItem
                                            .setForceZeroExtendedAmt(false);
                                    newWOLineItem.setQuantity(lineItem
                                            .getQuantity());

                                    setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, lineItem
                                            .getUnitPrice());

                                    for (IRetailPriceModifier discount : lineItem
                                            .getRetailPriceModifierByTypeCode(CawWorkOrderConstants.CAW_ITEM_AMT_PROMPT)) {
                                        discountList.put(discount.getDiscountReasonCode(), discount.getAmount()); /* BZ31943 */
                                    }

                                    setScopedValue(CawValueKeys.WO_LIST_DISCOUNT, discountList);
                                    setScopedValue(ValueKeys.CURRENT_SALE_LINE, newWOLineItem);
                                    setScopedValue(ValueKeys.CURRENT_ACCOUNT_DETAIL_TYPE, CustomerItemAccountDetailType.PART);

                                    warrantyItems.remove(itemId);

                                    return HELPER
                                            .getWaitStackChainResponse(OpChainKey
                                                    .valueOf("ADD_WORK_ORDER_ITEM"));
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception ex) {
            _logger.error("Can not read add warranty Item to transaction"
                    + ex.getMessage());
        }

        return HELPER.completeResponse();
    }

}
