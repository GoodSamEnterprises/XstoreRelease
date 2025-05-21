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
 * BZ27921          231018    [Internal] Incorrect return tender options for when you combine Verified Return with Web Order Return in the same transaction
 *===================================================================
 */

package caw.pos.tender.validation;

import javax.inject.Inject;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.tender.validation.ValidateTenderAvailabilityRule;

/**
 *
 */
public class CawValidateTenderAvailabilityRule
        extends ValidateTenderAvailabilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    /* 
     * @see dtv.pos.tender.validation.ValidateTenderAvailabilityRule#validate()
     */
    @Override
    public IValidationResult validate() {

        //This class is used to check if a tender option can be used in tender or not.
        //But we checked that in "caw.pos.shared.visibilityrules.CawRefundTenderCheck"
        //So this class will always pass.
        return SimpleValidationResult.getPassed();
    }

}
