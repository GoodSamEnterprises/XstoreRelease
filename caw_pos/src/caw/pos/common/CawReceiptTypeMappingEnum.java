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
 * BZ63054          080424    [API Change] - Format of the Submit Order API response is changed.
 *===================================================================
 */

package caw.pos.common;


/**
 *
 */
public enum CawReceiptTypeMappingEnum {

    NOT_SPECIFIED("0", "NotSpecified"),
    EMAIL_ONLY("2", "Email"),
    PRINT_ONLY("1", "Print"),
    PRINT_EMAIL("4", "PrintAndEmail"),
    NO_RECEIPTS("8", "NONE");
    
    private final String key;
    private final String value;
    /**
     * 
     */
    private CawReceiptTypeMappingEnum(String argKey, String argValue) {

        key = argKey;
        value = argValue;
    }
    
    /**
     * @return the key
     */
    public String getKey() {
    
        return key;
    }
    
    /**
     * @return the value
     */
    public String getValue() {
    
        return value;
    }
    
}
