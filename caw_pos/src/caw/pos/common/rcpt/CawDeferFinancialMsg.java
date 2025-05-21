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
 * BZ33319          040321    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 *===================================================================
 */

package caw.pos.common.rcpt;

/**
 *
 */
public class CawDeferFinancialMsg {

    private String  message;

    private boolean isBoldMsg;

    /**
     * 
     */
    public CawDeferFinancialMsg(String argMessage, boolean argBoldMsg) {

        super();
        this.message = argMessage;
        this.isBoldMsg = argBoldMsg;
    }

    /**
     * 
     */
    public CawDeferFinancialMsg() {

        super();
    }

    /**
     * @return the message
     */
    public String getMessage() {

        return message;
    }

    /**
     * @param argMessage the message to set
     */
    public void setMessage(String argMessage) {

        message = argMessage;
    }

    /**
     * @return the isBoldMsg
     */
    public boolean isBoldMsg() {

        return isBoldMsg;
    }

    /**
     * @param argIsBoldMsg the isBoldMsg to set
     */
    public void setBoldMsg(boolean argIsBoldMsg) {

        isBoldMsg = argIsBoldMsg;
    }

}
