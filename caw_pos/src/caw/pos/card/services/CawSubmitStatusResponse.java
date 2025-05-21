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
 * BZ28247          111218    [New Requirement] Move Xstore integration to Card Service version 2
 * 
 *===================================================================
 */

package caw.pos.card.services;

/**
 * The CawSubmitStatusResponse
 */
public class CawSubmitStatusResponse {

    /**
     *  The CawSubmitStatusResponse constructor
     */
    public CawSubmitStatusResponse(String argPrescreenId, int argCardType, String argCardTypeDescription) {
        super();
        prescreenId = argPrescreenId;
        cardType = argCardType;
        cardTypeDescription = argCardTypeDescription;
    }

    private String prescreenId;

    private int    cardType;

    private String cardTypeDescription;

    /**
     * @return the prescreenId
     */
    public String getPrescreenId() {
        return prescreenId;
    }

    /**
     * @param argPrescreenId the prescreenId to set
     */
    public void setPrescreenId(String argPrescreenId) {
        prescreenId = argPrescreenId;
    }

    /**
     * @return the cardType
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * @param argCardType the cardType to set
     */
    public void setCardType(int argCardType) {
        cardType = argCardType;
    }

    /**
     * @return the cardTypeDescription
     */
    public String getCardTypeDescription() {
        return cardTypeDescription;
    }

    /**
     * @param argCardTypeDescription the cardTypeDescription to set
     */
    public void setCardTypeDescription(String argCardTypeDescription) {
        cardTypeDescription = argCardTypeDescription;
    }

}
