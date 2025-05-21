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
 * BZ24381          071117    "Credit card tender is required" prompt is trigger unexpectedly although completing tender by Manual Credit incase choosing "Auto-renew"
 *===================================================================
 */

package caw.pos.advance.prompting;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;
import dtv.xst.dao.tnd.TenderId;

/**
 * This class is used to declare variable when doing query for get tender type is in credit card
 */
public class CawCreditDebitCardTenderTypeResults extends AbstractQueryResult {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1205892969385445511L;

    private String            Tnd_type         = null;

    /**
     * @return the tnd_type
     */
    public String getTnd_type() {

        return Tnd_type;
    }

    /**
     * @param argTnd_type the tnd_type to set
     */
    public void setTnd_type(String argTnd_type) {

        Tnd_type = argTnd_type;
    }

    @Override
    protected IObjectId getObjectIdImpl() {

        TenderId tenderId = new TenderId();
        tenderId.setTenderId(Tnd_type);
        return tenderId;
    }

}
