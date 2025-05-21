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

import java.util.Date;

import caw.pos.common.CawValueKeys;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.util.DateUtils;

/**
 * This function is used to validate Expired date. validation based on : date input, character, blank
 */
public class CawValidateGsShoppingPassExpDate extends AbstractValidationRule {

    @Override
    public IValidationResult validate() {

        String expDateString = getScopedValue(CawValueKeys.SHOPPING_PASS_EXP);

        if (expDateString == null) {
            return SimpleValidationResult.getFailed("_nullValueExpDt");
        }

        if (expDateString.length() != 4) {
            return SimpleValidationResult.getFailed("_nullValueExpDt");
        }

        Date expDate = DateUtils.parseDtvExpirationDate(expDateString);

        if (expDate == null) {
            IFormattable msgDate = IFormattable.EMPTY;
            IFormattable msg = FF.getTranslatable("_nullValueExpDt", msgDate);
            return SimpleValidationResult.getFailed(msg);
        }

        return IValidationResult.SUCCESS;
    }
}
