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

import caw.pos.register.ufa.CawUFAConstants;

import dtv.pos.hardware.rcptbuilding.copyrules.TenderControlTransTypeRule;
import dtv.xst.dao.tsn.ITenderControlTransaction;

/**
 *
 */
public class CawRcptUFATransTypeRule extends TenderControlTransTypeRule {

    private String transactionTypeCode_;

    public CawRcptUFATransTypeRule() {

        super();
        transactionTypeCode_ = "PAID_OUT";
    }

    @Override
    public void setParameter(String argName, Object argValue) {

        if ("TYPE".equalsIgnoreCase(argName)) {
            transactionTypeCode_ = argValue.toString();
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /**
     * Validate that the rule is applied when 
     * 1. Tender Control Transaction
     * 2. Paid out Type (Declared type="PAID_OUT" at ReceiptCopyRule tab in rcptConfig.xml
     * 3. Reason Code is determined for Purchase of Used Firearm
     */
    @Override
    protected boolean doesRuleApply(Object argSource) {

        if (!(argSource instanceof ITenderControlTransaction)) {
            return false;
        }

        ITenderControlTransaction tran = (ITenderControlTransaction) argSource;
        if (transactionTypeCode_.equalsIgnoreCase(tran.getTypeCode())) {
            String reasonCode = tran.getReasonCode();
            if (reasonCode != null && CawUFAConstants.UFA_REASON_CODE
                    .equalsIgnoreCase(reasonCode)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return the transactionTypeCode
     */
    public String getTransactionTypeCode() {

        return transactionTypeCode_;
    }

    /**
     * @param argTransactionTypeCode the transactionTypeCode to set
     */
    public void setTransactionTypeCode(String argTransactionTypeCode) {

        transactionTypeCode_ = argTransactionTypeCode;
    }

}
