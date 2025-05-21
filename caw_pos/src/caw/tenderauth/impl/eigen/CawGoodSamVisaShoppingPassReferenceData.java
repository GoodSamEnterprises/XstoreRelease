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
 * BZ23265          200917    Implement issue "Create Good Sam Visa" card function
 * BZ23864          101017    CW address should be displayed below CW's logo on Declined receipt for EMV/non-EMV/GC
 * BZ23942          121017    [Payments] Create GS Visa success but still has error in xstore log
 * BZ27108          160818    [PROD]Good Sam Visa Shopping Pass text needs to reflect the approved credit amount
 * BZ28942          300119    [Internal] Credit card name displays inconsistent on shopping Pass receipt and Xstore screen
 * BZ29292          130219    [Internal] Need to fix the text on the PLCC Shopping Pass to match ADS Requirements
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

import java.util.Date;

import dtv.pos.common.LocationFactory;
import dtv.util.IReceiptSource;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.loc.RetailLocationId;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawGoodSamVisaShoppingPassReferenceData implements IReceiptSource {

    /*Begin BZ-23265*/
    private long            organizationId_;

    private int             retailLocationId_;

    private long            currentTime_;

    private int             registerId_;

    private long            ticketId_;

    private Date            businessDate_;

    private IPosTransaction transaction;

    private String          creditLimit;

    private String          apr;

    private String          tempAccount;

    private String          tempAccountExp;

    private String          cawGoodSamNote1;   //BZ27108

    /* BEGIN BZ28942 */
    private String          cawGoodSamCongrats;

    private String          cawGoodSamFooter;
    /* END BZ28942 */

    /* BEGIN BZ29292 */
    private int             cardType;

    private String          firstName = "";

    private String          lastName  = "";

    private String          tempCreditLimit;

    /* END BZ29292 */

    /**
     * 
     */
    public CawGoodSamVisaShoppingPassReferenceData(long argOrganizationId,
            int argRetailLocationId, int argWkstnId, Date argBusinessDate,
            IPosTransaction argTrans) {

        organizationId_ = argOrganizationId;
        retailLocationId_ = argRetailLocationId;
        businessDate_ = argBusinessDate;
        currentTime_ = new Date().getTime();
        transaction = argTrans;
    }

    /**
     * @return the organizationId
     */
    public long getOrganizationId() {

        return organizationId_;
    }

    /**
     * @param argOrganizationId the organizationId to set
     */
    public void setOrganizationId(long argOrganizationId) {

        organizationId_ = argOrganizationId;
    }

    /**
     * @return the retailLocationId
     */
    public int getRetailLocationId() {

        return retailLocationId_;
    }

    /**
     * @param argRetailLocationId the retailLocationId to set
     */
    public void setRetailLocationId(int argRetailLocationId) {

        retailLocationId_ = argRetailLocationId;
    }

    /**
     * @return the currentTime
     */
    public long getCurrentTime() {

        return currentTime_;
    }

    /**
     * @param argCurrentTime the currentTime to set
     */
    public void setCurrentTime(long argCurrentTime) {

        currentTime_ = argCurrentTime;
    }

    /**
     * @return the registerId
     */
    public int getRegisterId() {

        return registerId_;
    }

    /**
     * @param argRegisterId the registerId to set
     */
    public void setRegisterId(int argRegisterId) {

        registerId_ = argRegisterId;
    }

    /**
     * @return the ticketId
     */
    public long getTicketId() {

        return ticketId_;
    }

    /**
     * @param argTicketId the ticketId to set
     */
    public void setTicketId(long argTicketId) {

        ticketId_ = argTicketId;
    }

    /**
     * @return the businessDate
     */
    public Date getBusinessDate() {

        return businessDate_;
    }

    /**
     * @param argBusinessDate the businessDate to set
     */
    public void setBusinessDate(Date argBusinessDate) {

        businessDate_ = argBusinessDate;
    }

    public Date getTransactionDate() {

        return getTransaction().getTransactionDate();
    }

    public IPosTransaction getTransaction() {

        return transaction;
    }

    public long getTransactionSequence() {

        return getTransaction().getTransactionSequence();
    }

    public Date getBeginDateTimestamp() {

        return getTransaction().getBeginDateTimestamp();
    }

    public long getWorkstationId() {

        return getTransaction().getWorkstationId();
    }

    public String getTranCashierId() {

        final IParty party = getTransaction().getOperatorParty();
        return party != null ? party.getEmployeeId() : null;
    }

    public IParty getOperatorParty() {

        final IParty party = getTransaction().getOperatorParty();
        return party;
    }

    public IParty getCustomerParty() {

        IRetailTransaction trans = (IRetailTransaction) getTransaction();
        final IParty party = trans.getCustomerParty();
        return party;
    }

    /**
     * @return the creditLimit
     */
    public String getCreditLimit() {

        return creditLimit;
    }

    /**
     * @param argCreditLimit the creditLimit to set
     */
    public void setCreditLimit(String argCreditLimit) {

        creditLimit = argCreditLimit;
    }

    /**
     * @return the apr
     */
    public String getApr() {

        return apr;
    }

    /**
     * @param argApr the apr to set
     */
    public void setApr(String argApr) {

        apr = argApr;
    }

    /**
     * @return the tempAccount
     */
    public String getTempAccount() {

        return tempAccount;
    }

    /**
     * @param argTempAccount the tempAccount to set
     */
    public void setTempAccount(String argTempAccount) {

        tempAccount = argTempAccount;
    }

    /**
     * @return the tempAccountExp
     */
    public String getTempAccountExp() {

        return tempAccountExp;
    }

    /**
     * @param argTempAccountExp the tempAccountExp to set
     */
    public void setTempAccountExp(String argTempAccountExp) {

        tempAccountExp = argTempAccountExp;
    }
    /*End BZ-23265*/

    // Begin BZ23864
    /**
     * 
     * @return getStoreName
     */
    public String getStoreName() {

        if (transaction != null) {
            return LocationFactory.getInstance()
                    .getStoreById(transaction.getRetailLocationId())
                    .getStoreName();
        }
        return null;
    }

    /**
     * 
     * @return getAddress
     */
    public String getAddress() {

        if (transaction != null) {
            return LocationFactory.getInstance()
                    .getStoreById(transaction.getRetailLocationId())
                    .getAddress1();
        }
        return null;
    }

    /**
     * 
     * @return getLocation
     */
    public String getLocation() {

        if (transaction != null) {
            String city = LocationFactory.getInstance()
                    .getStoreById(transaction.getRetailLocationId()).getCity();
            String state = LocationFactory.getInstance()
                    .getStoreById(transaction.getRetailLocationId()).getState();
            String postalCode = LocationFactory.getInstance()
                    .getStoreById(transaction.getRetailLocationId())
                    .getPostalCode();

            return city + ", " + state + " " + postalCode;
        }
        return null;
    }
    // End BZ23864

    /**
     * BZ 23942: missing method in <section name="transaction_store_location"> of RcptConfig.xml
     */
    public RetailLocationId getRetailLocationIdObject() {

        RetailLocationId id = new RetailLocationId();
        id.setOrganizationId(getOrganizationId());
        id.setRetailLocationId(new Long(getRetailLocationId()));
        return id;
    }

    // Begin BZ27108
    /**
     * @return the cawGoodSamNote1
     */
    public String getCawGoodSamNote1() {

        return cawGoodSamNote1;
    }

    /**
     * @param argCawGoodSamNote1 the cawGoodSamNote1 to set
     */
    public void setCawGoodSamNote1(String argCawGoodSamNote1) {

        cawGoodSamNote1 = argCawGoodSamNote1;
    }
    // End BZ27108

    /* BEGIN BZ28942 */
    public String getCawGoodSamCongrats() {

        return cawGoodSamCongrats;
    }

    public void setCawGoodSamCongrats(String argCawGoodSamCongrats) {

        cawGoodSamCongrats = argCawGoodSamCongrats;
    }

    public String getCawGoodSamFooter() {

        return cawGoodSamFooter;
    }

    public void setCawGoodSamFooter(String argCawGoodSamFooter) {

        cawGoodSamFooter = argCawGoodSamFooter;
    }
    /* END BZ28942 */

    /* BEGIN BZ29292 */

    /**
     * @return the cardType
     */
    public int getCardType() {

        return cardType;
    }

    /**
     * @param argCardType the cardType to set
     */
    public void setCardType(int argCardType) {

        cardType = argCardType;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * @param argFirstName the firstName to set
     */
    public void setFirstName(String argFirstName) {

        firstName = argFirstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * @param argLastName the lastName to set
     */
    public void setLastName(String argLastName) {

        lastName = argLastName;
    }

    /**
     * @return the tempCreditLimit
     */
    public String getTempCreditLimit() {

        return tempCreditLimit;
    }

    /**
     * @param argTempCreditLimit the tempCreditLimit to set
     */
    public void setTempCreditLimit(String argTempCreditLimit) {

        tempCreditLimit = argTempCreditLimit;
    }
    /* END BZ29292*/

}
