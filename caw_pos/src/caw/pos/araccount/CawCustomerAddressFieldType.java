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
 * BZ29515          220219    [ADS Feedback] Duplicate cardholder address in the ‘address’ and ‘address2’ fields for credit application
 *===================================================================
 */

package caw.pos.araccount;

/**
 *
 */
public enum CawCustomerAddressFieldType {
    ADDRESS1(1), 
    ADDRESS2(2), 
    ADDRESS3(3), 
    ADDRESS4(4), 
    ADDRESS_TYPE(5), 
    APARTMENT(6), 
    CITY(7), 
    POSTAL_CODE(8), 
    STATE(9), 
    COUNTRY(10);

    private int field;

    CawCustomerAddressFieldType(int fieldName) {

        this.field = fieldName;
    }

    /**
     * @return the field
     */
    public int getField() {

        return field;
    }

}
