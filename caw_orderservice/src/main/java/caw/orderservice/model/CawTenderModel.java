/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * CAW_OrderService     210817    Initial development framework
 * BZ29123              100119    Port 28987 to Release 3.0: Xstore needs to submit the PO Number in the Order Service for A/R and Third Party Tenders
 *== ================================================================
 */

package caw.orderservice.model;

import java.math.BigDecimal;

public class CawTenderModel {

    private String     correlationKey;

    private String     type;

    private String     code;

    private BigDecimal amount;

    private String     authorization;

    private String     token;

    private String     cardNumberMasked;

    private String     cardholder;

    //Begin BZ29123
    private String     expireDate;

    private String     purchaseOrder;

    private String     orderHoldName;

    private String     affiliateId;

    //End BZ29123
    public String getCorrelationKey() {

        return correlationKey;
    }

    public void setCorrelationKey(String correlationKey) {

        this.correlationKey = correlationKey;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public BigDecimal getAmount() {

        return amount;
    }

    public void setAmount(BigDecimal amount) {

        this.amount = amount;
    }

    public String getAuthorization() {

        return authorization;
    }

    public void setAuthorization(String authorization) {

        this.authorization = authorization;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {

        this.token = token;
    }

    public String getCardNumberMasked() {

        return cardNumberMasked;
    }

    public void setCardNumberMasked(String cardNumberMasked) {

        this.cardNumberMasked = cardNumberMasked;
    }

    public String getCardholder() {

        return cardholder;
    }

    public void setCardholder(String cardholder) {

        this.cardholder = cardholder;
    }

    public String getExpireDate() {

        return expireDate;
    }

    public void setExpireDate(String expireDate) {

        this.expireDate = expireDate;
    }
    //Begin BZ29123

    /**
     * @return the purchaseOrder
     */
    public String getPurchaseOrder() {

        return purchaseOrder;
    }

    /**
     * @param purchaseOrder the purchaseOrder to set
     */
    public void setPurchaseOrder(String purchaseOrder) {

        this.purchaseOrder = purchaseOrder;
    }

    /**
     * @return the orderHoldName
     */
    public String getOrderHoldName() {

        return orderHoldName;
    }

    /**
     * @param orderHoldName the orderHoldName to set
     */
    public void setOrderHoldName(String orderHoldName) {

        this.orderHoldName = orderHoldName;
    }

    /**
     * @return the affiliateId
     */
    public String getAffiliateId() {

        return affiliateId;
    }

    /**
     * @param affiliateId the affiliateId to set
     */
    public void setAffiliateId(String affiliateId) {

        this.affiliateId = affiliateId;
    }

    //End BZ29123
}
