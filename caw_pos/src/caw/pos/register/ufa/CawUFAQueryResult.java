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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa;

import dtv.data2.access.*;

/**
 * Get StringValue from CRM_PARTY_ID_XREF_P table 
 */
public class CawUFAQueryResult extends AbstractQueryResult {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1784007472582320631L;

    private String            desc_            = null;

    @Override
    protected IObjectId getObjectIdImpl() {

        /*CustomerAccountId id = new CustomerAccountId();
        id.setOrganizationId(Long.valueOf(getOrganizationId()));
        id.setCustAccountCode(getCustAcctCode());
        id.setCustAccountId(getCustAcctId());
        return id;*/
        return null;
    }

    public IDataModel getPopulatedObject() {
        /* CustomerAccountId id = (CustomerAccountId)getObjectId();
        Object obj = DataFactory.getObjectById(id);
        return obj == null ? null : (IDataModel)obj;*/

        return null;
    }

    /**
     * @return the desc
     */
    public String getDesc() {

        return desc_;
    }

    /**
     * @param argDesc the desc to set
     */
    public void setDesc(String argDesc) {

        desc_ = argDesc;
    }

}
