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
 * BZ26289          110718    New Requirement - Enable A/R Payment Functionality in Xstore
 *===================================================================
 */

package caw.pos.houseaccount.validation;

import java.math.BigDecimal;

import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractValidationRule;
import dtv.util.NumberUtils;
import dtv.xst.dao.cat.ICustomerConsumerChargeAccount;

/**
 * The CawValidateHouseAccountPaymentAmtRule
 */
public class CawValidateHouseAccountPaymentAmtRule
        extends AbstractValidationRule {

    
    @Override
    public IValidationResult validate() {

        BigDecimal amount = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);

        ICustomerConsumerChargeAccount account = getScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT);

        if (NumberUtils.isZeroOrNull(amount) || (account == null)) {
            return SimpleValidationResult.getFailed("_validatemessage57");
        }

        return IValidationResult.SUCCESS;
    }

}
