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
 * BZ23637          280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 *===================================================================
 */

package caw.pos.advance.prompting;

import caw.pos.common.CawPropertyUtils;

/**
 *
 */
public enum CawCustomerGroupType {
    RETL(3, CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME, CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME), CLUB(24, CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_OLD_NAME, CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_NEW_NAME), CREW(25, CawPropertyUtils.CUSTOMER_GROUP_TYPE_CREW_OLD_NAME, CawPropertyUtils.CUSTOMER_GROUP_TYPE_CREW_NEW_NAME), WHSL(26, CawPropertyUtils.CUSTOMER_GROUP_TYPE_WHSL_OLD_NAME, CawPropertyUtils.CUSTOMER_GROUP_TYPE_WHSL_NEW_NAME);

    private final int    type;

    private final String oldName;

    private final String newName;

    /**
     * 
     */
    private CawCustomerGroupType(int argType, String argOldName,
            String argNewName) {

        this.type = argType;
        this.oldName = argOldName;
        this.newName = argNewName;
    }

    /**
     * @return
     */
    public int getType() {

        return type;
    }

    /**
     * @return
     */
    public String getOldName() {

        return oldName;
    }

    /**
     * @return
     */
    public String getNewName() {

        return newName;
    }

}
