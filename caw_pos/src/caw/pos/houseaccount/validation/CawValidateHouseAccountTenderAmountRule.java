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
 * BZ26289          120718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27199          200818    [Internal] Cannot complete Sale Transaction which used any tender types with special customer Club#:W7705280824
 *===================================================================
 */

package caw.pos.houseaccount.validation;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.tender.CawTenderConstants;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.houseaccount.validation.ValidateHouseAccountTenderAmountRule;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * The CawValidateHouseAccountTenderAmountRule class
 */
public class CawValidateHouseAccountTenderAmountRule
        extends ValidateHouseAccountTenderAmountRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    public IValidationResult validate() {

        //Begin BZ26289 added
        if (_transactionScope != null) {

            /**
             * Identify House Account
             */
            IPosTransaction pos = _transactionScope.getTransaction();
            if (CawCustomerUtil.isHouseAccountPayment(pos)) {
                return IValidationResult.SUCCESS;
            }
            // BZ27199 start
            ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
            if (tenderLine != null && !CawTenderConstants.AR_ACCOUNT
                    .equalsIgnoreCase(tenderLine.getTenderId())) {
                return IValidationResult.SUCCESS;
            }
            // BZ27199 end
        }
        //End BZ26289

        return super.validate();
    }
}
