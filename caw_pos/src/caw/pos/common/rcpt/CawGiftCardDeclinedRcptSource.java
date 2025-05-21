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
 * BZ23697          041017    Decline receipt is printed for EMV- Fall back card
 * BZ24019          161017    [Technical issue] - Empty method
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Date;

/**
 *
 */
public class CawGiftCardDeclinedRcptSource {

    private String retailLocationId;

    private String workstationId;

    private Date   transactionDate;

    private Long   beginDateTimestamp;

    private String transactionSequence;

    private String receiptText;

    /**
     * @return the retailLocationId
     */
    public String getRetailLocationId() {

        return retailLocationId;
    }

    /**
     * @param argRetailLocationId the retailLocationId to set
     */
    public void setRetailLocationId(String argRetailLocationId) {

        retailLocationId = argRetailLocationId;
    }

    /**
     * @return the workstationId
     */
    public String getWorkstationId() {

        return workstationId;
    }

    /**
     * @param argWorkstationId the workstationId to set
     */
    public void setWorkstationId(String argWorkstationId) {

        workstationId = argWorkstationId;
    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {

        return transactionDate;
    }

    /**
     * @param argTransactionDate the transactionDate to set
     */
    public void setTransactionDate(Date argTransactionDate) {

        transactionDate = argTransactionDate;
    }

    /**
     * @return the beginDateTimestamp
     */
    public Long getBeginDateTimestamp() {

        return beginDateTimestamp;
    }

    /**
     * @param argBeginDateTimestamp the beginDateTimestamp to set
     */
    public void setBeginDateTimestamp(Long argBeginDateTimestamp) {

        beginDateTimestamp = argBeginDateTimestamp;
    }

    /**
     * @return the transactionSequence
     */
    public String getTransactionSequence() {

        return transactionSequence;
    }

    /**
     * @param argTransactionSequence the transactionSequence to set
     */
    public void setTransactionSequence(String argTransactionSequence) {

        transactionSequence = argTransactionSequence;
    }

    /**
     * @return the receiptText
     */
    public String getReceiptText() {

        return receiptText;
    }

    /**
     * @param argReceiptText the receiptText to set
     */
    public void setReceiptText(String argReceiptText) {

        receiptText = argReceiptText;
    }
}
