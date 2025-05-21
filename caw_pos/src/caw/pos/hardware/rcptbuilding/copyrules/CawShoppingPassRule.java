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
 * BZ23265          200917    Implement issue "Create Good Sam Visa" card function
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import caw.tenderauth.impl.eigen.CawGoodSamVisaShoppingPassReferenceData;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;

/**
 *
 */
public class CawShoppingPassRule extends AbstractRcptCopyRule {

    /*Begin BZ-23265*/
    @Override
    protected boolean doesRuleApply(Object argSource) {

        if (argSource instanceof CawGoodSamVisaShoppingPassReferenceData) {
            return true;
        }
        return false;
    }
    /*End BZ-23265*/

}
