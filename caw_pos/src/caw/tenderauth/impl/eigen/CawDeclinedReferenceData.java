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
 * BZ23356          011017    CWS Will Require a Printed Decline Receipt for EMV Tenders
 * BZ23800          051017    Missing EMV tag in declined receipt when performing transaction with EMV is declined
 * BZ23864          101017    CW address should be displayed below CW's logo on Declined receipt for EMV/non-EMV/GC
 * BZ24050          171017    Duplicate Cashier info on declined Credit/Debit receipt in Sale/Return transaction
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawValueKeys;

import dtv.pos.common.LocationFactory;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.IReceiptSource;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawDeclinedReferenceData implements IReceiptSource {

    /**
     * 
     */
    private static final String SALE = "Sale";

    @Inject
    protected TransactionScope  _transactionScope;

    private long                organizationId_;

    private int                 retailLocationId_;

    private long                currentTime_;

    private int                 registerId_;

    private long                ticketId_;

    private int                 lineItmSeq;

    private Date                businessDate_;

    private String              applicationId_;

    private IPosTransaction     transaction;

    private String              tenderDescription;

    private String              numberCard;

    private String              authCode;

    private String              entryMethod;

    private String              authTime;

    private BigDecimal          authAmout;

    private String              emvTag;           // BZ23800

    /**
     * 
     */
    public CawDeclinedReferenceData(long argOrganizationId,
            int argRetailLocationId, int argWkstnId, Date argBusinessDate,
            Integer argLineItmSeq, IPosTransaction argTrans) {

        InjectionHammer.forceAtInjectProcessing(this);
        organizationId_ = argOrganizationId;
        retailLocationId_ = argRetailLocationId;
        businessDate_ = argBusinessDate;
        currentTime_ = new Date().getTime();
        lineItmSeq = argLineItmSeq;
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

    /**
     * @return the applicationId
     */
    public String getApplicationId() {

        return applicationId_;
    }

    /**
     * @param argApplicationId the applicationId to set
     */
    public void setApplicationId(String argApplicationId) {

        applicationId_ = argApplicationId;
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
     * @return the tenderDescription
     */
    public String getTenderDescription() {

        return tenderDescription;
    }

    /**
     * @param argTenderDescription the tenderDescription to set
     */
    public void setTenderDescription(String argTenderDescription) {

        tenderDescription = argTenderDescription;
    }

    /**
     * @return the numberCard
     */
    public String getNumberCard() {

        return numberCard;
    }

    /**
     * @param argNumberCard the numberCard to set
     */
    public void setNumberCard(String argNumberCard) {

        numberCard = argNumberCard;
    }

    /**
     * @return the entryMethod
     */
    public String getEntryMethod() {

        return entryMethod;
    }

    /**
     * @param argEntryMethod the entryMethod to set
     */
    public void setEntryMethod(String argEntryMethod) {

        entryMethod = argEntryMethod;
    }

    /**
     * @return the authTime
     */
    public String getAuthTime() {

        return authTime;
    }

    /**
     * @param argAuthTime the authTime to set
     */
    public void setAuthTime(String argAuthTime) {

        authTime = argAuthTime;
    }

    /**
     * @return the authCode
     */
    public String getAuthCode() {

        return authCode;
    }

    /**
     * @param argAuthCode the authCode to set
     */
    public void setAuthCode(String argAuthCode) {

        authCode = argAuthCode;
    }

    /**
     * @return the verification
     */
    public String getVerification() {

        return "NONE";
    }

    /**
     * @return the seqNumber
     */
    public String getSeqNumber() {

        if (StringUtils.isNotEmpty(getEmvInfo().getSeqNumber())) {
            return getEmvInfo().getSeqNumber();
        }
        return null;
    }

    /**
     * @return the hostResCode
     */
    public String getHostResCode() {

        if (StringUtils.isNotEmpty(getEmvInfo().getHostResCode())) {
            return getEmvInfo().getHostResCode();
        }
        return null;
    }

    /**
     * @return the isoResCode
     */
    public String getIsoResCode() {

        if (StringUtils.isNotEmpty(getEmvInfo().getIsoResCode())) {
            return getEmvInfo().getIsoResCode();
        }
        return null;
    }

    /**
     * @return the emvAID
     */
    public String getEmvAID() {

        if (StringUtils.isNotEmpty(getEmvInfo().getAidTag())) {
            return getEmvInfo().getAidTag();
        }
        return null;
    }

    /**
     * @return the emvAppName
     */
    public String getEmvAppName() {

        if (StringUtils.isNotEmpty(getEmvInfo().getAppNameTag())) {
            return getEmvInfo().getAppNameTag();
        }
        return null;
    }

    /**
     * @return the emvTVR
     */
    public String getEmvTVR() {

        if (StringUtils.isNotEmpty(getEmvInfo().getTvrTag())) {
            return getEmvInfo().getTvrTag();
        }
        return null;
    }

    /**
     * @return the emvTSI
     */
    public String getEmvTSI() {

        if (StringUtils.isNotEmpty(getEmvInfo().getTsiTag())) {
            return getEmvInfo().getTsiTag();
        }
        return null;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {

        if (StringUtils.isNotEmpty(getEmvInfo().getCurrency())) {
            return getEmvInfo().getCurrency();
        }
        return null;
    }

    /**
     * @return the traceNumber
     */
    public String getTraceNumber() {

        if (StringUtils.isNotEmpty(getEmvInfo().getTraceNumber())) {
            return getEmvInfo().getTraceNumber();
        }
        return null;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {

        if (StringUtils.isNotEmpty(getEmvInfo().getDeviceId())) {
            return getEmvInfo().getDeviceId();
        }
        return null;
    }

    /**
     * @return the merchId
     */
    public String getMerchId() {

        if (StringUtils.isNotEmpty(getEmvInfo().getMerchId())) {
            return getEmvInfo().getMerchId();
        }
        return null;
    }

    /**
     * @return the terminalNumber
     */
    public String getTerminalNumber() {

        if (StringUtils.isNotEmpty(getEmvInfo().getTerminalNumber())) {
            return getEmvInfo().getTerminalNumber();
        }
        return null;
    }

    /**
     * @return the emvInfo
     */
    public CawEmvPaymentCardInfo getEmvInfo() {

        Map<Integer, CawEmvPaymentCardInfo> mapEMVInfo = _transactionScope
                .getValue(CawValueKeys.EMV_DATA);
        return mapEMVInfo.get(lineItmSeq);
    }

    /**
     * @return the salePerson
     */
    public String getSalePerson() {

        // Begin BZ24050
        String result = "";
        if (transaction != null) {
            IParty party = transaction.getOperatorParty();
            if (party != null && party.getEmployeeId() != null) {
                result = party.getEmployeeId();
            }
        }
        return result;
        // End BZ24050
    }

    /**
     * @return the transType
     */
    public String getTransType() {

        return SALE;
    }

    /**
     * @return the authAmout
     */
    public BigDecimal getAuthAmout() {

        return authAmout;
    }

    /**
     * @return the authAmout
     */
    public String getAuthAmount() {

        if (authAmout.compareTo(BigDecimal.ZERO) > 0) {
            return authAmout.toString();
        } else {
            return "(" + authAmout.abs().toString() + ")";
        }
    }

    /**
     * @param argAuthAmout the authAmout to set
     */
    public void setAuthAmout(BigDecimal argAuthAmout) {

        authAmout = argAuthAmout;
    }

    /**
     * @return the decline reason
     */
    public String getDeclineReason() {

        if (StringUtils.isNotEmpty(getEmvInfo().getDeclineReason())) {
            return getEmvInfo().getDeclineReason();
        }
        return null;
    }

    /**
     * @return the emvTag
     */
    public String getEmvTag() {

        return emvTag;
    }

    /**
     * @param argEmvTag the emvTag to set
     */
    public void setEmvTag(String argEmvTag) {

        emvTag = argEmvTag;
    }

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
}