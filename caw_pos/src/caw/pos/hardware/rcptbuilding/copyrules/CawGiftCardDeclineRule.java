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
 * BZ23697          041017    Decline receipt is printed for EMV- Fall back card
 * BZ23697          051017    Decline receipt is printed for EMV- Fall back card
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;

public class CawGiftCardDeclineRule extends AbstractRcptCopyRule {

    @Override
    protected boolean doesRuleApply(Object argSource) {

        if (argSource instanceof CawMiraResponse
                && ((CawMiraResponse) argSource)
                        .getRequest() instanceof CawMiraGiftCardRequest) {
            if (((CawMiraResponse) argSource).getIsDeclinedActionCode()) {
                return true;
            }
        }

        return false;
    }

}
