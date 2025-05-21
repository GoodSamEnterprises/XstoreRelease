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
 * Req/Bug ID#          ddMMyy    Description
 * BZ24539              171117    Disable Warranty Receipt in POS
 *== ================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;

/**
 *
 */
public class CawNoPrintWarrantyTransactionRule extends AbstractRcptCopyRule {

    @Override
    protected boolean doesRuleApply(Object argSource) {

        return false;
    }

}
