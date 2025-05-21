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
 * BZ32517          251019   [New Requirement] SKU prompt required prior to swipe gift cards for the refund activation to track inventory.
 *===================================================================
 */

package caw.pos.tender.voucher;

import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.CreateVoucherTenderLineItemOp;
import dtv.pos.tender.voucher.config.ActivityConfig;
import dtv.util.StringUtils;
import dtv.xst.dao.ttr.IVoucher;
import dtv.xst.dao.ttr.IVoucherTenderLineItem;

/**
 *
 */
public class CawCreateVoucherTenderLineItemOp
        extends CreateVoucherTenderLineItemOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        super.handleOpExec(argEvent);
        getScopedValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                .setVoucherTypeCode(CawEigenConstants.XPAY_GIFT_CARD);
        return HELPER.completeResponse();
    }
    /*BEGIN BZ32517*/
    @SuppressWarnings("deprecation")
    @Override
    protected void setVoucherData(IVoucherTenderLineItem itemLineItem, IVoucher voucher,
            ActivityConfig activityConfig) {
        if (activityConfig.getValidateLocalBalance()) {
            itemLineItem.setVoucher(voucher);
        } else if (voucher != null) {
            itemLineItem.setVoucherTypeCode(voucher.getVoucherTypeCode());
            itemLineItem.setEffectiveDate(voucher.getEffectiveDate());
            itemLineItem.setExpirationDate(voucher.getExpirationDate());
            itemLineItem.setFaceValueAmount(voucher.getFaceValueAmount());
            itemLineItem.setIssueDatetimestamp(voucher.getIssueDatetimestamp());
            itemLineItem.setIssueTypeCode(voucher.getIssueTypeCode());
            itemLineItem.setUnspentBalanceAmount(voucher.getUnspentBalanceAmount());
            itemLineItem.setVoucherStatusCode(voucher.getVoucherStatusCode());
            itemLineItem.setVoucher(voucher);
            String sku = getScopedValue(CawValueKeys.CAW_SKU_TYPE);
            if (!StringUtils.isEmpty(sku)) {
                itemLineItem.setOrigSTAN(sku);
            }
        }
    }
    /*END BZ32517*/
}
