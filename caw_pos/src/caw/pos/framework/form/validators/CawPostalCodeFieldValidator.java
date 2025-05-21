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
 * BZ26742          180718    [New Requirement] Update QAS results include the entered or existing customer address as an option
 *===================================================================
 */

package caw.pos.framework.form.validators;

import java.util.regex.Pattern;

import dtv.pos.framework.form.IHasAddressFields;
import dtv.pos.framework.form.validators.IEditModelFieldValidator;
import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.form.IEditModelField;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.util.StringUtils;

/**
 * Validate Postal code field
 * require the 9-digit code for Postal code, apply for US only
 * Refer to ShippingPostalCodeValidator
 */
public class CawPostalCodeFieldValidator implements IEditModelFieldValidator<String> {

    public static final String US_POSTAL_CODE_PATTERN = "^[0-9]{5}(-[0-9]{4})?$";

    public static final String US_COUNTRY             = "US";
    
    public static final String CA_POSTAL_CODE_PATTERN = "^[abceghjklmnprstvxyABCEGHJKLMNPRSTVXY][0-9][abceghjklmnprstvwxyzABCEGHJKLMNPRSTVWXYZ] [0-9][abceghjklmnprstvwxyzABCEGHJKLMNPRSTVWXYZ][0-9]$";

    public static final String CA_COUNTRY             = "CA";

    public CawPostalCodeFieldValidator() {

    }

    @Override
    public IValidationResult validateField(IEditModel argEditModel,
            IEditModelField<String> argField) {

        IValidationResult result = SimpleValidationResult.getPassed();
        if (argField.isAvailable()) {
            Object fieldValue = argEditModel.getValue(argField.getFieldKey());
            if (fieldValue != null) {
                String countryCode = StringUtils.nonNull(argEditModel
                        .getValue(IHasAddressFields.COUNTRY_FIELD));
                String postalCode = fieldValue.toString();
                if (US_COUNTRY.compareToIgnoreCase(countryCode) == 0) {
                   //Valid format: xxxxx or xxxxx-xxxx
                    boolean valid = Pattern
                            .matches(US_POSTAL_CODE_PATTERN, postalCode);
                    if (!valid) {
                        return SimpleValidationResult
                                .getFailed("_addressInvalidPostalCodeMessageUS");
                    }
                }
                
                if (CA_COUNTRY.compareToIgnoreCase(countryCode) == 0) {
                    //Valid format: ?#? #?#
                    boolean valid = Pattern
                            .matches(CA_POSTAL_CODE_PATTERN, postalCode);
                    if (!valid) {
                        return SimpleValidationResult
                                .getFailed("_addressInvalidPostalCodeMessageCA");
                    }
                }
            }
        }
        return result;
    }
}
