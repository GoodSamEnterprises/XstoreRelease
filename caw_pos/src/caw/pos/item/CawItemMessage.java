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
 * BZ29625          080419    [New Requirement] - Auto-Renewal Item Specific Receipts
 *===================================================================
 */

package caw.pos.item;

public class CawItemMessage {
    private String _messageId;
    private String _specificMessage;
    private String _stringMessage;


    public CawItemMessage( String argMessageId,
            String argSpecificMessage, String argAdjAmount) {

        super();
        _messageId = argMessageId;
        _specificMessage = argSpecificMessage;
        _stringMessage = argAdjAmount;
    }

    /**
     * @return the messageId
     */
    public String getMessageId() {
        return _messageId;
    }

    /**
     * @param argMessageId the messageId to set
     */
    public void setMessageId(String argMessageId) {
        _messageId = argMessageId;
    }

    /**
     * @return the specificMessage
     */
    public String getSpecificMessage() {
        return _specificMessage;
    }

    /**
     * @param argSpecificMessage the specificMessage to set
     */
    public void setSpecificMessage(String argSpecificMessage) {
        _specificMessage = argSpecificMessage;
    }

    /**
     * @return the stringMessage
     */
    public String getStringMessage() {
        return _stringMessage;
    }

    /**
     * @param argStringMessage the stringMessage to set
     */
    public void setStringMessage(String argStringMessage) {
        _stringMessage = argStringMessage;
    }

}
