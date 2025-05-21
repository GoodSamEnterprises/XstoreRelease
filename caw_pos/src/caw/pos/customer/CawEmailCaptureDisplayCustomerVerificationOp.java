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
 * BZ45995          141021    [New requirement] Email capture when good sam membership is sold
 * BZ46837          191021    [Internal]Email Capture - Xstore advances to 'the Membership Number prompt' instead 'the Edit Customer screen' when selecting No on the Pinpad customer verification screen.
 *===================================================================
 */

package caw.pos.customer;

import caw.pos.common.CawValueKeys;

/**
 *
 */
public class CawEmailCaptureDisplayCustomerVerificationOp extends CawDisplayCustomerVerificationOp {

    @Override
    public boolean isOperationApplicable() {
        boolean result = false;
        
        boolean isShowable = super.isOperationApplicable();
        Boolean isEmailCaptureSuccess = getScopedValue(CawValueKeys.IS_MEMBERSHIP_EMAIL_CAPTURED);
        
        if (isEmailCaptureSuccess != null) {
            result = isShowable && isEmailCaptureSuccess;
        }
        
        return result;
    }
}
