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
 * BZ23558              270917    Receipts are missing EMV data
 * BZ33319              260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 *===================================================================
 */

package caw.payment.verifone;

public class CawEmvPaymentCardInfo {

    private boolean hasEmvInfo;

    private String  aidTag;

    private String  appNameTag;

    private String  tvrTag;

    private String  tsiTag;

    private String  acTag;

    private String  seqNumber;

    private String  hostResCode;

    private String  isoResCode;

    private String  currency;

    private String  traceNumber;

    private String  deviceId;

    private String  merchId;

    private String  terminalNumber;

    private String  verification;

    private String  declineReason;
    
    private String  deferFinancial;         /*BZ33319*/

    /**
     * Returns 
     * @return 
     */
    public boolean isHasEmvInfo() {

        return hasEmvInfo;
    }

    /**
     * Specifies
     * @param argHasEmvInfo 
     */
    public void setHasEmvInfo(boolean argHasEmvInfo) {

        hasEmvInfo = argHasEmvInfo;
    }

    /**
     * Returns 
     * @return 
     */
    public String getAidTag() {

        return aidTag;
    }

    /**
     * Specifies
     * @param argAidTag 
     */
    public void setAidTag(String argAidTag) {

        aidTag = argAidTag;
    }

    /**
     * Returns 
     * @return 
     */
    public String getAppNameTag() {

        return appNameTag;
    }

    /**
     * Specifies
     * @param argAppNameTag 
     */
    public void setAppNameTag(String argAppNameTag) {

        appNameTag = argAppNameTag;
    }

    /**
     * Returns 
     * @return 
     */
    public String getTvrTag() {

        return tvrTag;
    }

    /**
     * Specifies
     * @param argTvrTag 
     */
    public void setTvrTag(String argTvrTag) {

        tvrTag = argTvrTag;
    }

    /**
     * Returns 
     * @return 
     */
    public String getTsiTag() {

        return tsiTag;
    }

    /**
     * Specifies
     * @param argTsiTag 
     */
    public void setTsiTag(String argTsiTag) {

        tsiTag = argTsiTag;
    }

    /**
     * Returns 
     * @return 
     */
    public String getAcTag() {

        return acTag;
    }

    /**
     * Specifies
     * @param argAcTag 
     */
    public void setAcTag(String argAcTag) {

        acTag = argAcTag;
    }

    /**
     * @return the seqNumber
     */
    public String getSeqNumber() {

        return seqNumber;
    }

    /**
     * @param argSeqNumber the seqNumber to set
     */
    public void setSeqNumber(String argSeqNumber) {

        seqNumber = argSeqNumber;
    }

    /**
     * @return the hostResCode
     */
    public String getHostResCode() {

        return hostResCode;
    }

    /**
     * @param argHostResCode the hostResCode to set
     */
    public void setHostResCode(String argHostResCode) {

        hostResCode = argHostResCode;
    }

    /**
     * @return the isoResCode
     */
    public String getIsoResCode() {

        return isoResCode;
    }

    /**
     * @param argIsoResCode the isoResCode to set
     */
    public void setIsoResCode(String argIsoResCode) {

        isoResCode = argIsoResCode;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {

        return currency;
    }

    /**
     * @param argCurrency the currency to set
     */
    public void setCurrency(String argCurrency) {

        currency = argCurrency;
    }

    /**
     * @return the traceNumber
     */
    public String getTraceNumber() {

        return traceNumber;
    }

    /**
     * @param argTraceNumber the traceNumber to set
     */
    public void setTraceNumber(String argTraceNumber) {

        traceNumber = argTraceNumber;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {

        return deviceId;
    }

    /**
     * @param argDeviceId the deviceId to set
     */
    public void setDeviceId(String argDeviceId) {

        deviceId = argDeviceId;
    }

    /**
     * @return the terminalNumber
     */
    public String getTerminalNumber() {

        return terminalNumber;
    }

    /**
     * @param argTerminalNumber the terminalNumber to set
     */
    public void setTerminalNumber(String argTerminalNumber) {

        terminalNumber = argTerminalNumber;
    }

    /**
     * @return the merchId
     */
    public String getMerchId() {

        return merchId;
    }

    /**
     * @param argMerchId the merchId to set
     */
    public void setMerchId(String argMerchId) {

        merchId = argMerchId;
    }

    /**
     * @return the verification
     */
    public String getVerification() {

        return verification;
    }

    /**
     * @param argVerification the verification to set
     */
    public void setVerification(String argVerification) {

        verification = argVerification;
    }

    /**
     * @return the verification
     */
    public String getDeclineReason() {

        return declineReason;
    }

    /**
     * @param argVerification the verification to set
     */
    public void setDeclineReason(String argDeclineReason) {

        declineReason = argDeclineReason;
    }

    /*BEGIN BZ33319*/
    /**
     * @return the deferFinancial
     */
    public String getDeferFinancial() {

        return deferFinancial;
    }

    /**
     * @param argDeferFinancial the deferFinancial to set
     */
    public void setDeferFinancial(String argDeferFinancial) {

        deferFinancial = argDeferFinancial;
    }
    /*END BZ33319*/
}
