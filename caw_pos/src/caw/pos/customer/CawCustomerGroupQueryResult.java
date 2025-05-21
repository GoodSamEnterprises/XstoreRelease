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
 * BZ24601          261217    Price of customer is changed from RETL to CLUB unexpectedly when sending catalyst=1 request
 *===================================================================
 */

package caw.pos.customer;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;
import dtv.xst.dao.crm.CustomerAffiliationId;

/**
 *
 */
public class CawCustomerGroupQueryResult extends AbstractQueryResult {

    private static final long serialVersionUID = 1L;

    private long              _organizationId;

    private Long              _partyId         = null;

    private String            _custGroupId     = null;

    /* (non-Javadoc)
     * @see dtv.data2.access.AbstractQueryResult#getObjectIdImpl()
     */
    @Override
    protected IObjectId getObjectIdImpl() {

        CustomerAffiliationId modelId = new CustomerAffiliationId();
        modelId.setOrganizationId(Long.valueOf(this.getOrganizationId()));
        modelId.setPartyId(this.getPartyId());
        modelId.setCustomerGroupId(this.getCustGroupId());
        return modelId;
    }

    /**
     * @return the organizationId
     */
    public long getOrganizationId() {

        return _organizationId;
    }

    /**
     * @param argOrganizationId the organizationId to set
     */
    public void setOrganizationId(long argOrganizationId) {

        _organizationId = argOrganizationId;
    }

    /**
     * @return the partyId
     */
    public Long getPartyId() {

        return _partyId;
    }

    /**
     * @param argPartyId the partyId to set
     */
    public void setPartyId(Long argPartyId) {

        _partyId = argPartyId;
    }

    /**
     * @return the custGroupId
     */
    public String getCustGroupId() {

        return _custGroupId;
    }

    /**
     * @param argCustGroupId the custGroupId to set
     */
    public void setCustGroupId(String argCustGroupId) {

        _custGroupId = argCustGroupId;
    }

}
