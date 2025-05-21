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
 * BZ26972          010818    [1.6.2] Missing item UPC on gift receipt when doing reissues Gift receipt transaction
 *===================================================================
 */

package caw.pos.register.giftreceipt;

import caw.pos.register.CawUPCHelper;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.giftreceipt.*;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.ISaleReturnLineItem;

public class CawAddGiftRcptSourcesOp extends AddGiftRcptSourcesOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        // Begin BZ26972
        GiftReceiptDataList<GiftReceiptDataList<GiftReceiptPrintItemDataModel>> argList;
        argList = getScopedValue(ValueKeys.GIFT_RECEIPT_SOURCES);
        for (GiftReceiptDataList<GiftReceiptPrintItemDataModel> list : argList) {
            for (GiftReceiptPrintItemDataModel model : list) {

                ISaleReturnLineItem lineItem = model.getItem();
                CawUPCHelper.getInstance().addUpc(lineItem);
            }
        }
        // End BZ26972
        return super.handleOpExec(argEvent);

    }
}
