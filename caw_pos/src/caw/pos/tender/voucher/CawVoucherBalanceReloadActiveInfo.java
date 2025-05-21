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
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ27182          140818    Gift Card Receipt Title Not Appearing 
 * BZ33085          241019    [5.0 UAT] Void the gift card Tender line for a Sales transaction
 *===================================================================
 */

package caw.pos.tender.voucher;

import java.math.BigDecimal;
import java.util.Date;

import dtv.pos.framework.systemcycle.TransDateProvider;
import dtv.util.IReceiptSource;
import dtv.util.crypto.EncString;

/**
 *
 */
public class CawVoucherBalanceReloadActiveInfo implements IReceiptSource {

    private final TransDateProvider _transDateProvider;

    private String                  _authorizationCode;

    private BigDecimal              _balance;

    private EncString               _serialNumber;

    private String                  _traceNumber;

    private boolean                 _isReceiptRequired;

    private String                  storeName;

    private String                  storeAddress;

    private String                  storeLocation;

    private String                  storeNbr;

    private int                     registerNumber;

    private String                  salePersonNumber;

    private String                  tranCashierId;

    private Date                    beginDateTimestamp;

    private Long                    tranId;

    private BigDecimal              amount;

    private String                  transactionType;

    private String                  _cardNumber;

    private String                  valueAddText;      // BZ27182
    
    private int                     lineSequence; //BZ33085

    public CawVoucherBalanceReloadActiveInfo(
            TransDateProvider argTransDateProvider) {
        this._transDateProvider = argTransDateProvider;
    }

    /**
     * @return the authorizationCode
     */
    public String getAuthorizationCode() {

        return _authorizationCode;
    }

    /**
     * @param argAuthorizationCode the authorizationCode to set
     */
    public void setAuthorizationCode(String argAuthorizationCode) {

        _authorizationCode = argAuthorizationCode;
    }

    /**
     * @return the balance
     */
    public BigDecimal getBalance() {

        return _balance;
    }

    /**
     * @return the storeNbr
     */
    public String getStoreNbr() {

        return storeNbr;
    }

    /**
     * @param argStoreNbr the storeNbr to set
     */
    public void setStoreNbr(String argStoreNbr) {

        storeNbr = argStoreNbr;
    }

    /**
     * @return the registerNumber
     */
    public int getRegisterNumber() {

        return registerNumber;
    }

    /**
     * @param argRegisterNumber the registerNumber to set
     */
    public void setRegisterNumber(int argRegisterNumber) {

        registerNumber = argRegisterNumber;
    }

    /**
     * @return the salePersonNumber
     */
    public String getSalePersonNumber() {

        return salePersonNumber;
    }

    /**
     * @param argSalePersonNumber the salePersonNumber to set
     */
    public void setSalePersonNumber(String argSalePersonNumber) {

        salePersonNumber = argSalePersonNumber;
    }

    /**
     * @return the tranCashierId
     */
    public String getTranCashierId() {

        return tranCashierId;
    }

    /**
     * @param argTranCashierId the tranCashierId to set
     */
    public void setTranCashierId(String argTranCashierId) {

        tranCashierId = argTranCashierId;
    }

    /**
     * @return the beginDateTimestamp
     */
    public Date getBeginDateTimestamp() {

        return beginDateTimestamp;
    }

    /**
     * @param argBeginDateTimestamp the beginDateTimestamp to set
     */
    public void setBeginDateTimestamp(Date argBeginDateTimestamp) {

        beginDateTimestamp = argBeginDateTimestamp;
    }

    /**
     * @param argBalance the balance to set
     */
    public void setBalance(BigDecimal argBalance) {

        _balance = argBalance;
    }

    /**
     * @return the serialNumber
     */
    public EncString getSerialNumber() {

        return _serialNumber;
    }

    /**
     * @param argSerialNumber the serialNumber to set
     */
    public void setSerialNumber(EncString argSerialNumber) {

        _serialNumber = argSerialNumber;
    }

    /**
     * @return the traceNumber
     */
    public String getTraceNumber() {

        return _traceNumber;
    }

    /**
     * @param argTraceNumber the traceNumber to set
     */
    public void setTraceNumber(String argTraceNumber) {

        _traceNumber = argTraceNumber;
    }

    /**
     * @return the isReceiptRequired
     */
    public boolean isReceiptRequired() {

        return _isReceiptRequired;
    }

    /**
     * @param argIsReceiptRequired the isReceiptRequired to set
     */
    public void setReceiptRequired(boolean argIsReceiptRequired) {

        _isReceiptRequired = argIsReceiptRequired;
    }

    /**
     * @return the transDateProvider
     */
    public TransDateProvider getTransDateProvider() {

        return _transDateProvider;
    }

    /**
     * @return the storeName
     */
    public String getStoreName() {

        return storeName;
    }

    /**
     * @param argStoreName the storeName to set
     */
    public void setStoreName(String argStoreName) {

        storeName = argStoreName;
    }

    /**
     * @return the storeAddress
     */
    public String getStoreAddress() {

        return storeAddress;
    }

    /**
     * @param argStoreAddress the storeAddress to set
     */
    public void setStoreAddress(String argStoreAddress) {

        storeAddress = argStoreAddress;
    }

    /**
     * @return the storeLocation
     */
    public String getStoreLocation() {

        return storeLocation;
    }

    /**
     * @param argStoreLocation the storeLocation to set
     */
    public void setStoreLocation(String argStoreLocation) {

        storeLocation = argStoreLocation;
    }

    /**
     * @return the tranId
     */
    public Long getTranId() {

        return tranId;
    }

    /**
     * @param argTranId the tranId to set
     */
    public void setTranId(Long argTranId) {

        tranId = argTranId;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {

        return amount;
    }

    /**
     * @param argAmount the amount to set
     */
    public void setAmount(BigDecimal argAmount) {

        amount = argAmount;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {

        return transactionType;
    }

    /**
     * @param argTransactionType the transactionType to set
     */
    public void setTransactionType(String argTransactionType) {

        transactionType = argTransactionType;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {

        return _cardNumber;
    }

    /**
     * @param argCardNumber the cardNumber to set
     */
    public void setCardNumber(String argCardNumber) {

        _cardNumber = argCardNumber;
    }

    // Begin BZ27182
    /**
     * @return the valueAddText
     */
    public String getValueAddText() {

        return valueAddText;
    }

    /**
     * @param argValueAddText the valueAddText to set
     */
    public void setValueAddText(String argValueAddText) {

        valueAddText = argValueAddText;
    }
    // End BZ27182

    /*BEGIN BZ33085*/
    /**
     * @return the lineSequence
     */
    public int getLineSequence() {
        return lineSequence;
    }

    /**
     * @param lineSequence the lineSequence to set
     */
    public void setLineSequence(int lineSequenceParam) {
        this.lineSequence = lineSequenceParam;
    }
    /*END BZ33085*/
}
