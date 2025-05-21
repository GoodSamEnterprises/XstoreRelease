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
 * 
 *===================================================================
 */

package caw.pos.tender.voucher;

import static caw.tenderauth.impl.eigen.constants.CawEigenConstants.XPAY_GIFT_CARD;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.inject.Inject;

import dtv.pos.common.CommonHelper;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.validation.TenderAmountData;
import dtv.pos.tender.voucher.PromptVoucherTenderAmtOp;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawPromptVoucherTenderAmtOp extends PromptVoucherTenderAmtOp {

    @Inject
    private CommonHelper _commonHelper;

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        if (getScopedValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM) != null) {
            getScopedValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                    .setVoucherTypeCode(XPAY_GIFT_CARD);
        }
        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        TenderAmountData amountData = getScopedValue(ValueKeys.CURRENT_TENDER_AMOUNT_DATA);
        BigDecimal tenderAmount = amountData.getEnteredAmount();
        tenderAmount = _commonHelper.roundCurrency(tenderAmount);
        if (tenderLine.getTenderStatusCode()
                .equalsIgnoreCase(TenderStatus.TENDER.getName())) {
            tenderLine.setAmount(tenderAmount);

            if (_tenderHelper.isForeignTender(tenderLine.getTender())) {
                int localRoundingDigits = ConfigurationMgr
                        .getLocalCurrencyScale();

                BigDecimal exchangeRate = _tenderHelper
                        .getExchangeRate(tenderLine.getTender()
                                .getCurrencyId(), _stationState
                                        .getRetailLocationId());
                tenderLine.setExchangeRate(exchangeRate);
                BigDecimal amt = getBigDecimal(argEvent);
                tenderLine.setForeignAmount(amt);
                amt = amt
                        .divide(exchangeRate, localRoundingDigits, RoundingMode.UP);
                tenderLine.setAmount(amt);
            }
        } else {
            tenderLine.setAmount(tenderAmount.negate());
        }
        return HELPER.completeResponse();
    }
}
