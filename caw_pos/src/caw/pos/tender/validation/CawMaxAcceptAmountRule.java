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
 * BZ28534          241218    [New requirement][BZ-27969] All CW roles will be restricted by the new tender limit requirements.
 *===================================================================
 */

package caw.pos.tender.validation;

import static dtv.pos.framework.validation.ValidationResult.getOverridable;
import static dtv.pos.iframework.validation.IValidationResult.SUCCESS;
import static dtv.util.NumberUtils.isGreaterThan;

import java.math.BigDecimal;
import java.util.Currency;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.CommonHelper;
import dtv.pos.iframework.type.TenderUsageCodeType;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;
import dtv.pos.tender.validation.*;
import dtv.util.CurrencyUtils;
import dtv.util.Money;
import dtv.xst.dao.sec.IGroup;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.tnd.ITenderUserSettings;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * A clone of MaxAcceptAmountRule rule with new condition.
 * NEW: BigDecimal newTenderTotal = argData.getEnteredAmount();
 * OLD: BigDecimal newTenderTotal = _commonHelper.roundCurrency(data.getNewTenderTotal());
 */
public class CawMaxAcceptAmountRule extends AbstractSecuredTenderRule {

    private static final Logger _logger = LogManager.getLogger(CawMaxAcceptAmountRule.class);

    @Inject
    private TenderHelper        _tenderHelper;
    @Inject
    private CommonHelper        _commonHelper;

    /* (non-Javadoc)
     * @see dtv.pos.tender.validation.AbstractSecuredTenderRule#validateNonChangeTender(dtv.pos.tender.validation.TenderAmountData)
     */
    @Override
    protected IValidationResult validateNonChangeTender(TenderAmountData argData) {

        IValidationResult result = SUCCESS;
        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        TenderUsageCodeType tenderUsage = getScopedValue(ValueKeys.CURRENT_TENDER_USAGE_CODE);

        IGroup group = _stationState.getSystemUser().getPrimaryGroup();
        if (group == null) {
            _logger.warn("system user (operatorId='" + _stationState.getSystemUser().getOperatorId()
                    + "') has no primary group");
        }

        ITenderUserSettings settings = _tenderHelper.getTenderSettings(tenderLine.getTenderId(), tenderUsage, group);
        BigDecimal maximum = _commonHelper.roundCurrency(new Money(settings.getMaximumAcceptAmount(),
                CurrencyUtils.getCurrency(tenderLine.getCurrencyId())));

        if (maximum != null) {
            BigDecimal newTenderTotal = argData.getEnteredAmount();

            if (isGreaterThan(newTenderTotal, maximum)) {
                ITender tender = tenderLine.getTender();
                Currency currency = Currency.getInstance(tender.getCurrencyId());
                Money moneyAmount = new Money(newTenderTotal, currency);
                Money moneyMax = new Money(maximum, currency);

                IFormattable amount = FF.getSimpleFormattable(moneyAmount, FormatterType.MONEY);
                IFormattable max = FF.getSimpleFormattable(moneyMax, FormatterType.MONEY);
                IFormattable tenderName = FF.getLiteral(tender.getDescription());
                IFormattable errorMessage = FF
                        .getTranslatable("_tenderAmountHigherThanAllowed", new IFormattable[] { amount, max, tenderName });

                result = getOverridable(errorMessage, getPrivilege());
            }
        }

        return result;
    }

}
