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
 * BZ23951              171017    Customer Search Screen Needs to Include Membership#, Expiration Date
 * BZ26453              050618    [Internal] Membership Info of customer does not display at customer search prompt when searching the customer in offline status.
 * BZ28033              110518    [New Requirement]Clean up the redundant calls to Neuron from xstore
 *== ================================================================
 */

package caw.pos.customer;

import java.util.List;

import twitter4j.JSONObject;

import dtv.xst.crm.impl.cust.lookup.resp.CustomerQueryResult;

/**
 *
 */
public class CawCustomerQueryResult extends CustomerQueryResult {

    private static final long serialVersionUID      = 1L;

    private String            accountNumber         = null;

    private String            locationCode          = null;

    private List<JSONObject>  membershipLst         = null; // BZ23951

    private String            membershipStringValue = null; // BZ26453
    /* BEGIN BZ28033 */
    private String            jsonSearchCustomerResponse = null;

    /**
     * Get the Json Search Customer Response
     * @return
     */
    public String getJsonSearchCustomerResponse() {
        return jsonSearchCustomerResponse;
    }

    public void setJsonSearchCustomerResponse(String argJsonSearchResponse) {
        jsonSearchCustomerResponse = argJsonSearchResponse;
    }
    /* END BZ28033 */

    /**
     * Returns
     * 
     * @return
     */
    public String getAccountNumber() {

        return accountNumber;
    }

    /**
     * Specifies
     * 
     * @param argAccountNumber
     */
    public void setAccountNumber(String argAccountNumber) {

        accountNumber = argAccountNumber;
    }

    /**
     * Returns
     * 
     * @return
     */
    public String getLocationCode() {

        return locationCode;
    }

    /**
     * Specifies
     * 
     * @param argLocationCode
     */
    public void setLocationCode(String argLocationCode) {

        locationCode = argLocationCode;
    }

    /**
     * @return the membershipLst
     */
    public List<JSONObject> getMembershipLst() {

        return membershipLst;
    }

    /**
     * @param argMembershipLst the membershipLst to set
     */
    public void setMembershipLst(List<JSONObject> argMembershipLst) {

        membershipLst = argMembershipLst;
    }

    // Begin BZ26453
    /**
     * @return the membershipStringValue
     */
    public String getMembershipStringValue() {

        return membershipStringValue;
    }

    /**
     * @param argMembershipStringValue the membershipStringValue to set
     */
    public void setMembershipStringValue(String argMembershipStringValue) {

        membershipStringValue = argMembershipStringValue;
    }
    // End BZ26453

}
