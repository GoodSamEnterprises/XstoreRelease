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
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 *===================================================================
 */

package caw.pos.advance.prompting;

/**
 *
 */
public enum CawNonPhysicalType {
    ITEM_TYPCODE_GS_MEMBERSHIP("GSMEMBERSHIP"), ITEM_SUBTYPE_GC_JOIN("GCJOIN"), ITEM_SUBTYPE_GC_RENEW("GC_RENEW");

    private final String physicalType;

    private CawNonPhysicalType(String type) {

        this.physicalType = type;
    }

    public String getPhysicalType() {

        return physicalType;
    }

}
