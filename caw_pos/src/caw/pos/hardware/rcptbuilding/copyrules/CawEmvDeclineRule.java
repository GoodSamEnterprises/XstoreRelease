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
 * BZ23356          011017    CWS Will Require a Printed Decline Receipt for EMV Tenders
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import caw.tenderauth.impl.eigen.CawDeclinedReferenceData;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;

public class CawEmvDeclineRule extends AbstractRcptCopyRule {

    @Override
    protected boolean doesRuleApply(Object argSource) {

        if (argSource instanceof CawDeclinedReferenceData) {
            return true;
        }
        return false;
    }

}
