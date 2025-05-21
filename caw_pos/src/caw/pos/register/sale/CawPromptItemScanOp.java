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
 * 24275            151117    unable to scan sale receipts on scan screen.
 * BZ27287          210818    [1.6.11] WO Redirect the WO refund to tender option screen to prevent adding the new items
 * BZ27379          120918    [1.6.15] WO Xstore reflects the discount incorrectly for the WO line item
 * BZ34287          161219    [Internal] Xstore show HDE when input sale receipt barcode manually
 * BZ34438          271219    [Defect 33595] Xstore add many serialized coupons with same serial number
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ41379          022221    Requirement - Disabled Mixed Order Transactions in Xstore
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *===================================================================
 */

package caw.pos.register.sale;

import static dtv.xst.dao.trl.SaleItemType.SALE;

import java.util.List;

import javax.inject.Inject;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.register.rvpayment.CawRvPaymentModel;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.pos.register.ItemMixingHelper;
import dtv.pos.register.sale.PromptItemScanOp;
import dtv.pos.spring.ValueKeys;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;

/**
 *  Prompt the purchase of used firearm reason if the item return is Purchase Used Firearm.
 */
public class CawPromptItemScanOp extends PromptItemScanOp {

    // Start BZ41379
    @Inject
    private OrderMgr _orderMgr;
    // End BZ41379
    
    // BZ27287 start
    @Inject
    private ItemMixingHelper _itemMixingHelper;

    @Override
    //If transaction bar code is scanned, create the dummy transaction barcode input.
    //Currently handle for barcode version 3 with transaction barcode length as 23.
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        String tranBarcode = argEvent.getStringData();
        if (tranBarcode != null && tranBarcode.startsWith("T")
                && tranBarcode.length() == 23) {
            //CawScannerDummy.instance.scanOccurred(tranBarcode); //BZ34287
            CawHardwareHelper.getInstance().enterBarcodeSaleReceipts(tranBarcode); //BZ34287
            return HELPER.silentErrorResponse();
        }
        return super.handlePromptEvent(argEvent);
    }

    /*BEGIN BZ44917*/
    @Override
    public IOpResponse getPromptResponse(IXstEvent argEvent, PromptKey argPromptKey, IFormattable[] argPromptArgs) {
        List<CawRvPaymentModel> rvSelectedItems = _transactionScope.getValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_LIST);
        if(rvSelectedItems != null && rvSelectedItems.size() > 0) {
            return this.handlePromptResponse(argEvent);
        }
        return super.getPromptResponse(argEvent, argPromptKey, argPromptArgs);
    }
    /*END BZ44917*/
    /**
     * Disable input.
     *
     * @param argEvent the event
     * @return true, if successful
     */
    @Override
    public boolean disableInput(IXstEvent argEvent) {

        IPosTransaction pos = _transactionScope.getTransaction();
        Boolean valid = _transactionScope.getValue(CawValueKeys.IS_ACCOUNT_PAYMENT);

        if (pos != null && (CawCustomerUtil.isHouseAccountPayment(pos)
                || CawWorkOrderHelper.getInstance().isWorkOrderRedundStatus(pos)
                || (valid != null && CawCustomerUtil.isAccountPayment(pos, valid.booleanValue())))
                || isExistOrderItem(pos)) {/*BZ41379*/
            //BZ27379 added condition for WO refund status
            /*BZ29387 added condition for Account Payment transaction*/
            return true;
    }
        return !_itemMixingHelper.isItemAllowedInTransaction(SALE, pos);
    }
    
    /*BEGIN BZ34438: in case user scan a lower case coupon id, need to upper case it to match DB*/
    /* (non-Javadoc)
     * @see dtv.pos.register.AbstractItemScanOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        /*BEGIN BZ44917*/
        List<CawRvPaymentModel> rvSelectedItems = _transactionScope.getValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_LIST);
        if (rvSelectedItems != null && rvSelectedItems.size() > 0) {
            CawRvPaymentModel rvItem = rvSelectedItems.get(0);
            this.setScopedValue(ValueKeys.ENTERED_ITEM_ID, rvItem.getItemCode());
            this.setScopedValue(ValueKeys.ENTERED_ITEM_QUANTITY, rvItem.getRvQty());
            this.setScopedValue(ValueKeys.ENTERED_ITEM_PRICE,rvItem.getRvAmount());
            this.setScopedValue(CawValueKeys.CAW_RV_PROPERTIES,rvItem.getProperties());
            this.setScopedValue(CawValueKeys.CAW_RV_PROPERTIES_SUBMIT_ORDER,rvItem.getProperties()); //BZ53752
            rvSelectedItems.remove(rvItem);
        }else {
        /*END BZ44917*/
            String itemId = argEvent.getStringData().toUpperCase();
            this.setScopedValue(ValueKeys.ENTERED_ITEM_ID, itemId);
        }
        return super.handlePromptResponse(argEvent);
    }
    /*END BZ34438*/
    
    /*BEGIN BZ28036*/
    /* (non-Javadoc)
     * override this method to skip prompt enter item when "sell item" button on the purchase history tab is clicked.
     * @see dtv.pos.register.sale.PromptItemScanOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        String itemselectedID = _transactionScope
                .getValue(CawValueKeys.ITEM_SELECTED) != null
                        ? _transactionScope.getValue(CawValueKeys.ITEM_SELECTED)
                                .getItemId()
                        : null;
        if (_transactionScope
                .getValue(CawValueKeys.IS_SELECT_SALE_TRANSACTION) != null
                && !StringUtils.isEmpty(itemselectedID)) {
            this.setScopedValue(ValueKeys.ENTERED_ITEM_ID, itemselectedID);
            _transactionScope
                    .clearValue(CawValueKeys.IS_SELECT_SALE_TRANSACTION);
            return super.handlePromptResponse(argEvent);

        } else if (_transactionScope
                .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null) {
            return HELPER.getStartChainResponse(OpChainKey.valueOf("NEW_RETURN"));
        } 
        return super.handleOpExec(argEvent);
    }
    /*END BZ28036*/
    /*BEGIN BZ41379*/
    private boolean isExistOrderItem(IPosTransaction pos) {

        if (pos != null) {
            IOrder currentOrder = this._orderMgr.getCurrentOrder();
            if (currentOrder != null && !currentOrder.getOrderLines().isEmpty()) {
                /*BEGIN BZ44528*/
                List<IOrderLine> orderLines = currentOrder.getOrderLines();
                ISaleReturnLineItem lineItem = null;
                for (IOrderLine orderLine : orderLines) {
                    lineItem = orderLine.getShadowedSaleItem();
                    if (lineItem != null && !StringUtils.isEmpty(lineItem.getStringProperty(CawConstants.WONDERSIGN_CART_ID))) {
                        return false;
                    }
                }
                /*END BZ44528*/
                return true;
            }
        }
        return false;
    }
    /*END BZ41379*/
}
