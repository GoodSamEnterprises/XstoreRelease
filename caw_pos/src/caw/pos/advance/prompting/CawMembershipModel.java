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

import java.util.List;

import javax.xml.bind.annotation.*;

/**
 *
 */
@XmlRootElement(name = "Memberships")
@XmlAccessorType(XmlAccessType.FIELD)
public class CawMembershipModel {

    @XmlElementWrapper(name = "Membership")
    @XmlElement(name = "Activity")
    private List<CawMembershipActivityModel> activities;

    public List<CawMembershipActivityModel> getActivities() {

        return activities;
    }

    public void setActivities(List<CawMembershipActivityModel> argActivities) {

        activities = argActivities;
    }

}
