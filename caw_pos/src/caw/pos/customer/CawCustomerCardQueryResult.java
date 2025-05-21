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
 * INT-92               260817    Customer Integration
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins 
 *== ================================================================
 */

package caw.pos.customer;

import java.util.Date;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;
import dtv.xst.dao.cat.CustomerLoyaltyCardId;

/**
 *
 */
public class CawCustomerCardQueryResult extends AbstractQueryResult {

    private static final long serialVersionUID = 1L;

    private long              _organizationId;

    private Long              _partyId         = null;

    private String            _custCardNumber  = null;

    private Date              _expireDate      = null;

    @Override
    protected IObjectId getObjectIdImpl() {

        CustomerLoyaltyCardId modelId = new CustomerLoyaltyCardId();
        modelId.setOrganizationId(Long.valueOf(this.getOrganizationId()));
        modelId.setCardNumber(this.getCustCardNumber());
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
     * @return the custCardNumber
     */
    public String getCustCardNumber() {

        return _custCardNumber;
    }

    /**
     * @param argCustCardNumber the custCardNumber to set
     */
    public void setCustCardNumber(String argCustCardNumber) {

        _custCardNumber = argCustCardNumber;
    }

    /**
     * @return the expireDate
     */
    public Date getExpireDate() {

        return _expireDate;
    }

    /**
     * @param argExpireDate the expireDate to set
     */
    public void setExpireDate(Date argExpireDate) {

        _expireDate = argExpireDate;
    }

}
