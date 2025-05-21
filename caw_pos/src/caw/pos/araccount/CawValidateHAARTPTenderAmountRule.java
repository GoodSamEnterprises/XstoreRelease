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
 * BZ24402          141117    Can't complete the transaction with Third-party tender
 * BZ27813          181018    [New Requirement] Credit Limit VALIDATION is displaying for AR and Third Party if tender amount is greater than $1000
 *===================================================================
 */

package caw.pos.araccount;

import static dtv.util.NumberUtils.isGreaterThan;

import java.math.BigDecimal;

import caw.pos.common.CawConstants;

import dtv.pos.houseaccount.validation.ValidateHouseAccountTenderAmountRule;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.validation.TenderAmountData;
import dtv.util.NumberUtils;
import dtv.xst.dao.cat.ICustomerConsumerChargeAccount;
import dtv.xst.dao.ttr.IAccountReceivableTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

public class CawValidateHAARTPTenderAmountRule
        extends ValidateHouseAccountTenderAmountRule {

    /** {@inheritDoc} */
    @Override
    public IValidationResult validate() {

        // BZ27813 start
        IAccountReceivableTenderLineItem lineItem = null;

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);

        if (tenderLine instanceof IAccountReceivableTenderLineItem) {

            lineItem = (IAccountReceivableTenderLineItem) tenderLine;

            if (CawConstants.THIRD_PARTY.equals(lineItem.getTenderId())) {

                return IValidationResult.SUCCESS;

            }

        }

        ICustomerConsumerChargeAccount account = getScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT);

        TenderAmountData amountData = getScopedValue(ValueKeys.CURRENT_TENDER_AMOUNT_DATA);

        if ((account == null)
                || !NumberUtils.isPositive(amountData.getBalanceDue())) {
            // not tendering house account or balance due to the customer, no further validaition needed
            return IValidationResult.SUCCESS;
        }

        BigDecimal creditLimit = account.getCreditLimit();

        BigDecimal newAccountBalance = NumberUtils.add(account
                .getAccountBalance(), amountData.getNewTenderTotal());

        if (isGreaterThan(newAccountBalance, creditLimit)) {
            // credit limit exceeded
            return SimpleValidationResult.getFailed("_cawOverTenderedAR");
        }

        return IValidationResult.SUCCESS;
        // BZ27813 end
    }
}
