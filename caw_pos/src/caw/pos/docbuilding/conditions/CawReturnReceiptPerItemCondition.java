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
 * BZ23372          101017    [DEV] Printing a special receipt to attach to 
 *                            returned items to aid disposition/restocking
 * BZ27010          080818    [PROD][1.5.0]Returned Merchandise Receipt is printing incorrectly for all reason codes
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.pricing.discount.CawDiscountCouponHelper;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawReturnReceiptPerItemCondition
        extends AbstractInvertableCondition {

    @Inject
    private CawDiscountCouponHelper _cawDiscountCouponHelper;

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem lineItem = (ISaleReturnLineItem) argSource;
            String code = lineItem.getReturnReasonCode();
            if (code != null && code.length() > 0 && _cawDiscountCouponHelper
                    .isEnableReasonCode(CawConstants.RETURN_REASON_TYPE_CODE, code)) {
                /* BZ27028 added, removed code of BZ26629 */
                return true;
            }
        }
        return false;
    }
}
