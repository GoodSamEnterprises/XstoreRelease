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
 * BZ29372          150218    [Requirement] PLCC Account Lookup - ID Verification Screen new request
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

/**
 * The Enum defines the card type
 */
public enum CawAccountCardType {
    SELECT_CARD_TYPE("0", "Select ID Type"),
    DRIVER_LICENSE("1", "Driver’s License"), 
    GOVERNMENT_ISSUED_ID("2", "Government Issued ID"), 
    MILITARY_ID("3", "Military ID"), 
    PASSPORT("4", "Passport");

    private final String type;

    private final String name;

    private CawAccountCardType(String typeCard, String nameCard) {

        this.type = typeCard;
        this.name = nameCard;
    }

    /**
     * @return the type
     */
    public String getType() {

        return type;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }
}
