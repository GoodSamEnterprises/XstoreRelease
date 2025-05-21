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
 * BZ24537          171117    [Payment] Gift cards do not partial auth, auto decline if there is not enough balance on the card
 *===================================================================
 */

package caw.pos.tender.validation;

import java.math.BigDecimal;

import javax.inject.Inject;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.iframework.type.VoucherActivityCodeType;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;
import dtv.pos.tender.validation.TenderAmountData;
import dtv.pos.tender.voucher.config.ActivityConfig;
import dtv.pos.tender.voucher.config.VoucherConfig;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawValidateGiftCardAmtRefundRule extends AbstractValidationRule {

    @Inject
    private TenderHelper _tenderHelper;

    /** {@inheritDoc} */
    @Override
    public IValidationResult validate() {

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        if (TenderStatus.REFUND.matches(tenderLine)) {
            String voucherType = getScopedValue(ValueKeys.SELECTED_VOUCHER_TYPE);
            VoucherActivityCodeType type = getScopedValue(ValueKeys.SELECTED_VOUCHER_ACTIVITY);
            TenderAmountData amountData = getScopedValue(ValueKeys.CURRENT_TENDER_AMOUNT_DATA);

            VoucherConfig voucherConfig = _tenderHelper.getVoucherRootConfig()
                    .getVoucherConfig(voucherType);

            ActivityConfig actConfig = voucherConfig.getActivityConfig(type);

            BigDecimal maxAmount = actConfig.getMaximumAmount() == null
                    ? BigDecimal.valueOf(Long.MAX_VALUE)
                    : actConfig.getMaximumAmount();

            if (amountData == null) {
                return SimpleValidationResult.getFailed("_validatemessage17");
            }

            if ((maxAmount != null)
                    && (maxAmount.compareTo(amountData.getBigDecimal()) < 0)) {
                IFormattable param = FF
                        .getSimpleFormattable(maxAmount, FormatterType.MONEY);
                return SimpleValidationResult
                        .getFailed(FF.getTranslatable("_priceAboveMax", param));
            }
        }

        return IValidationResult.SUCCESS;
    }
}
