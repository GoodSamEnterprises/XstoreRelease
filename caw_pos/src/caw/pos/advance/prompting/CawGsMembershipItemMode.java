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
 * BZ24324          021117    Membership validation prompt should be distinguish when joining in GS club and GS RS (Roadside assistance)
 *===================================================================
 */

package caw.pos.advance.prompting;

/**
 *
 */
public class CawGsMembershipItemMode {

    private String  itemId;

    private Boolean isAuto;

    public String getItemId() {

        return itemId;
    }

    public void setItemId(String argItemId) {

        itemId = argItemId;
    }

    public Boolean getIsAuto() {

        return isAuto;
    }

    public void setIsAuto(Boolean argIsAuto) {

        isAuto = argIsAuto;
    }

}
