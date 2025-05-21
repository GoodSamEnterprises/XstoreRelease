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
 * BZ25927          140518    [1.4.0] Confirm the added privileges for the EVERYONE ROLE
 *===================================================================
 */

package caw.pos.assistance.access;

import dtv.pos.framework.validation.ValidationResult;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.util.validation.AbstractValidationRule;

/**
 *
 */
public class CawLoginBackOfficeValidation extends AbstractValidationRule {

    /* (non-Javadoc)
     * @see dtv.pos.iframework.validation.IValidationRule#validate()
     */
    private static final String CAW_LOG_IN_BACK_OFFICE = "CAW_LOG_IN_BACK_OFFICE";

    @Override
    public IValidationResult validate() {

        return ValidationResult.getOverridable(FF
                .getTranslatable("_failedLoginBackOffice"), _securityUtil
                        .getPrivilege(CAW_LOG_IN_BACK_OFFICE));
    }
}
