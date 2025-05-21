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
 * Req/Bug ID#          ddMMyy    Description
 * INT-020              120417    EMV
 * INT-92               260817    Customer Integration
 *== ================================================================
 */

package caw.pos.customer;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;
import dtv.xst.dao.crm.PartyIdCrossReferenceId;

public class CawCustomerEBSQueryResult extends AbstractQueryResult {

    private static final long serialVersionUID  = 1L;

    private long              _organizationId;

    private Long              _partyId          = null;

    private String            _alternateIdOwner = null;

    /** {@inheritDoc} */
    @Override
    protected IObjectId getObjectIdImpl() {

        PartyIdCrossReferenceId modelId = new PartyIdCrossReferenceId();
        modelId.setOrganizationId(Long.valueOf(this.getOrganizationId()));
        modelId.setPartyId(this.getPartyId());
        modelId.setAlternateIdOwner(this.getAlternateIdOwner());
        return modelId;
    }

    /**
     * Returns 
     * @return 
     */
    public long getOrganizationId() {

        return _organizationId;
    }

    /**
     * Specifies
     * @param argOrganizationId 
     */
    public void setOrganizationId(long argOrganizationId) {

        _organizationId = argOrganizationId;
    }

    /**
     * Returns 
     * @return 
     */
    public Long getPartyId() {

        return _partyId;
    }

    /**
     * Specifies
     * @param argPartyId 
     */
    public void setPartyId(Long argPartyId) {

        _partyId = argPartyId;
    }

    /**
     * @return the alternateIdOwner
     */
    public String getAlternateIdOwner() {

        return _alternateIdOwner;
    }

    /**
     * @param argAlternateIdOwner the alternateIdOwner to set
     */
    public void setAlternateIdOwner(String argAlternateIdOwner) {

        _alternateIdOwner = argAlternateIdOwner;
    }
}
