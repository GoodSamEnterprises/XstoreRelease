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
 * BZ26270          060718    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ38070          240920    UPC needs to print on Order Transaction Receipts per existing CW Functionality
 * BZ38347          081020    [Internal] - The Pick Slip receipt is printed Incorrectly with an item No UPC
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import org.apache.commons.lang3.StringUtils;
import caw.pos.common.CawConfigurationMgr;
import caw.pos.register.CawUPCHelper;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.register.giftreceipt.GiftReceiptPrintItemDataModel;
import dtv.xst.dao.cwo.impl.WorkOrderLineItemModel;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.*;

public class CawUpcLineItemOnReceiptCondition
        extends AbstractInvertableCondition {

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (CawConfigurationMgr.displayUpcLineOnReceipt()) {
            if (argSource instanceof WorkOrderLineItemModel) {
                //Ignore UPC in Work Order line item
                return false;
            }
            if (argSource instanceof ISaleReturnLineItem) {
                return CawUPCHelper.getInstance()
                        .isUpcExisted((ISaleReturnLineItem) argSource);
            } else if (argSource instanceof GiftReceiptPrintItemDataModel) {
                GiftReceiptPrintItemDataModel giftItem = (GiftReceiptPrintItemDataModel) argSource;
                ISaleReturnLineItem saleLine = giftItem.getItem();
                return CawUPCHelper.getInstance().isUpcExisted(saleLine);
            //BEGIN BZ38070
            } else if (argSource instanceof IOrderLine) {

                ISaleReturnLineItem order = ((IOrderLine) argSource)
                        .getShadowedSaleItem();
                if (order == null) {
                    // In case pick slip order receipt
                    String itemId = (((IOrderLine) argSource).getItemId());
                    CawUPCHelper.getInstance().addUpc(itemId, itemId);
                    String UpcText = CawUPCHelper.getInstance().getUpcText(itemId, itemId);
                    if (StringUtils.isNotEmpty(UpcText)) {
                        return true;
                    } else {
                        return false; // BZ 38347
                    }
                }
                return CawUPCHelper.getInstance().isUpcExisted(order);
            } // END BZ38070
        }
        return false;
    }
}
