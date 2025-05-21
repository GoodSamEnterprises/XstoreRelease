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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa.rcpt;

/**
 *
 */
public class CawRcptUFATransNoTypeRule extends CawRcptUFATransTypeRule {

    public CawRcptUFATransNoTypeRule() {

        super();
    }

    /**
     * Validate that the rule is applied when 
     * 1. Tender Control Transaction
     * 2. Paid out Type (Declared type="PAID_OUT" at ReceiptCopyRule tab in rcptConfig.xml
     * 3. Reason Code is determined for Purchase of Used Firearm
     */
    @Override
    protected boolean doesRuleApply(Object argSource) {

        boolean print = super.doesRuleApply(argSource);

        return !print;
    }
}
