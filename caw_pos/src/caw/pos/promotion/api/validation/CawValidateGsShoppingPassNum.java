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
 * Req/Bug ID#          ddMMyy    Description
 * BZ24153              231017    Error message should be displayed on 'Enter Shopping Pass Number' & Expired date field when pressing 'Next' to by pass GS visa information
 *===================================================================
 */

package caw.pos.promotion.api.validation;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.util.validation.AbstractValidationRule;

/**
 * This function is used to check for token entering. Validation based on: blank
 */
public class CawValidateGsShoppingPassNum extends AbstractValidationRule {

    @Inject
    private TransactionScope _transactionScope;

    @Override
    public IValidationResult validate() {

        String GSSPNumber = getScopedValue(CawValueKeys.SHOPPING_PASS_NUMBER);
        if (GSSPNumber != null && GSSPNumber
                .equals(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase())) {
            _transactionScope
                    .setValue(CawValueKeys.REQUEST_TIMEOUT, HttpStatus.REQUEST_TIMEOUT
                            .getReasonPhrase());
            return SimpleValidationResult
                    .getFailed("_authProcessFailedOffline");
        }
        if (GSSPNumber == null || GSSPNumber.equalsIgnoreCase("")) {
            return SimpleValidationResult
                    .getFailed("_invalidGoodSamShoppingPassNumber");
        }

        return IValidationResult.SUCCESS;
    }
}
