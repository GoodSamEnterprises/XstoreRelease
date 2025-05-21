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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ46381          110821    IDS Payment - Should be able to scan a barcode of IDS Customer Number and IDS WO Number when doing a RV Service Payment Search in Xstore
 *===================================================================
 */

package caw.pos.register.rvpayment;

import javax.inject.Inject;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.common.CawConstants;
import caw.pos.common.CawPropertyUtils;
import caw.pos.ejournal.CawTransactionSearchHelper;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawRvPaymentEnableVisibilityRule extends AbstractVisibilityRule{
    private static final String EVENT_TYPE = "type";
    private static final String EVENT_SCAN = "SCAN";

    @Inject
    private CawTransactionSearchHelper   _cawTransactionSearchHelper;

    private String                     actionType_;/*BZ46381*/
    
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        AccessLevel accessLevel = AccessLevel.DENIED;
        String enableRvPayment = _cawTransactionSearchHelper.getCodeValue(CawConstants.CAW_RV_PAYMENT_ENABLE);
        if (CawConstants.TRUE_STRING.equalsIgnoreCase(enableRvPayment)) {
            accessLevel = AccessLevel.GRANTED;
        } 
        /*BEGIN BZ46381*/
        else if (EVENT_SCAN.equalsIgnoreCase(actionType_)) {
            CawHardwareHelper.getInstance().sendBeepScanner(CawHardwareHelper.getInstance().getScanner()
                    ,CawHardwareHelper.getInstance().getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
        }
        /*END BZ46381*/
        return accessLevel;
    }

    /*BEGIN BZ46381*/
    @Override
    public void setParameter(String argName, String argValue) {
        if (EVENT_TYPE.equalsIgnoreCase(argName)) {
            this.actionType_ = argValue.toString();
        } else {
            super.setParameter(argName, argValue);
        }
    }
    /*END BZ46381*/

}
