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
 * BZ26896          260718    [New Requirement] Add security override for Paid Out transaction greater than the configured max
 *===================================================================
 */

package caw.pos.till.fundxfer;

import java.math.BigDecimal;

import dtv.pos.framework.validation.ValidationResult;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractSecuredValidationRule;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.IReasonCode;

/**
 *
 */
public class CawValidateFundXferAmountRule
        extends AbstractSecuredValidationRule {

    /* (non-Javadoc)
     * @see dtv.pos.till.fundxfer.ValidateFundXferAmountRule#validate()
     */
    @Override
    public IValidationResult validate() {

        IValidationResult result = IValidationResult.SUCCESS;
        BigDecimal amount = getScopedValue(ValueKeys.ENTERED_TILL_AMOUNT);
        IReasonCode reasonCode = getScopedValue(ValueKeys.SELECTED_REASON_CODE);

        // Check that fund transfer amount falls into the correct min and max range
        if ((amount == null) || NumberUtils
                .isGreaterThan(reasonCode.getMinimumAmt(), amount)) {
            result = SimpleValidationResult.getFailed("_validatemessage14");
        } else if (NumberUtils
                .isGreaterThan(amount, reasonCode.getMaximumAmt())) {
            result = ValidationResult.getOverridable(FF
                    .getTranslatable("_validatemessage13"), getPrivilege());
        }

        return result;
    }
}
