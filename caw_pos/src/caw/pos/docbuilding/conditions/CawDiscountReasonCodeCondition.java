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
 * BZ26629          300718    [New Requirement] Add a prompt to capture discount code when the Retail Coupon discount reason is selected
 * BZ27053          080818    [1.6.3][26629] Redundant inputted retail coupon code before displays on receipt/Order service after modify discount items or transaction.
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.pricing.discount.CawDiscountCouponHelper;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.trl.impl.RetailPriceModifierModel;

/**
 * The CawDiscountReasonCodeCondition
 */
public class CawDiscountReasonCodeCondition
        extends AbstractInvertableCondition {

    @Inject
    private CawDiscountCouponHelper _cawDiscountCouponHelper;

    /**
     * The _logger logger
     */
    private static final Logger     _logger = LogManager
            .getLogger(CawDiscountReasonCodeCondition.class);

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof RetailPriceModifierModel) {
            RetailPriceModifierModel retailPrice = (RetailPriceModifierModel) argSource;
            String discountReasonCode = retailPrice.getDiscountReasonCode();
            _logger.info("The discount reason code is " + discountReasonCode);
            // BZ27053 start
            if (!retailPrice.getVoid()) {
                boolean valid = _cawDiscountCouponHelper
                        .isEnableReasonCode(CawConstants.DISCOUNT_REASON_TYPE_CODE, discountReasonCode);
                return valid;
            }
            // BZ27053 end

        }

        return false;
    }

}
