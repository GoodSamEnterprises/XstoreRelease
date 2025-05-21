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
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import caw.pos.tender.voucher.CawVoucherBalanceReloadActiveInfo;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;

/**
 *
 */
public class CawBalanceReloadActiveReceiptRule extends AbstractRcptCopyRule {

    @Override
    protected boolean doesRuleApply(Object argArg0) {

        if (argArg0 instanceof CawVoucherBalanceReloadActiveInfo) {
            return true;

        } else {
            return false;
        }
    }

}
