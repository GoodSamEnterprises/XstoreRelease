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
 * BZ23052          140917    Club# doesn't display on Account tab when searching the customer has memberships number
 * BZ23958          251017    Xstore needs to prompt for membership # when customer joins 
 *===================================================================
 */

package caw.pos.customer;

import java.util.Date;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;
import dtv.xst.dao.cat.CustomerAccountId;

/**
 *
 */
public class CawCustomerLoyaltyQueryResult extends AbstractQueryResult {

    private static final long serialVersionUID  = 1L;

    private long              _organizationId;

    private Long              _partyId          = null;

    private String            _custAcctCode     = null;

    private String            _custAcctId       = null;

    private String            _custCardNbr      = null;

    private Date              _expireDate       = null;

    private String            _programName      = null;

    private String            _programLevelName = null;

    /* (non-Javadoc)
     * @see dtv.data2.access.AbstractQueryResult#getObjectIdImpl()
     */
    @Override
    protected IObjectId getObjectIdImpl() {

        CustomerAccountId modelId = new CustomerAccountId();
        modelId.setOrganizationId(Long.valueOf(this.getOrganizationId()));
        modelId.setCustAccountCode(this.getCustAcctCode());
        modelId.setCustAccountId(this.getCustAcctId());
        return modelId;
    }

    public long getOrganizationId() {

        return _organizationId;
    }

    public void setOrganizationId(long argOrganizationId) {

        _organizationId = argOrganizationId;
    }

    public Long getPartyId() {

        return _partyId;
    }

    public void setPartyId(Long argPartyId) {

        _partyId = argPartyId;
    }

    public String getCustAcctCode() {

        return _custAcctCode;
    }

    public void setCustAcctCode(String argCustAcctCode) {

        _custAcctCode = argCustAcctCode;
    }

    public String getCustCardNbr() {

        return _custCardNbr;
    }

    public void setCustCardNbr(String argCustCardNbr) {

        _custCardNbr = argCustCardNbr;
    }

    /**
     * @return the custAcctId
     */
    public String getCustAcctId() {

        return _custAcctId;
    }

    /**
     * @param argCustAcctId the custAcctId to set
     */
    public void setCustAcctId(String argCustAcctId) {

        _custAcctId = argCustAcctId;
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

    /**
     * @return the programName
     */
    public String getProgramName() {

        return _programName;
    }

    /**
     * @param argProgramName the programName to set
     */
    public void setProgramName(String argProgramName) {

        _programName = argProgramName;
    }

    /**
     * @return the programLevelName
     */
    public String getProgramLevelName() {

        return _programLevelName;
    }

    /**
     * @param argProgramLevelName the programLevelName to set
     */
    public void setProgramLevelName(String argProgramLevelName) {

        _programLevelName = argProgramLevelName;
    }
}
