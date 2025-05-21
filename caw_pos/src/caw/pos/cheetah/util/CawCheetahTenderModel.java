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
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *===================================================================
 */

package caw.pos.cheetah.util;

import java.math.BigDecimal;

public class CawCheetahTenderModel {

    private String     correlationKey;

    private String     type;

    private String     code;

    private BigDecimal amount;

    private String     authorization;

    private String     token;

    private String     cardNumberMasked;

    private String     cardholder;

    private String     expireDate;

    /**
     * @return the correlationKey
     */
    public String getCorrelationKey() {

        return correlationKey;
    }

    /**
     * @param argCorrelationKey the correlationKey to set
     */
    public void setCorrelationKey(String argCorrelationKey) {

        correlationKey = argCorrelationKey;
    }

    /**
     * @return the type
     */
    public String getType() {

        return type;
    }

    /**
     * @param argType the type to set
     */
    public void setType(String argType) {

        type = argType;
    }

    /**
     * @return the code
     */
    public String getCode() {

        return code;
    }

    /**
     * @param argCode the code to set
     */
    public void setCode(String argCode) {

        code = argCode;
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
     * @return the authorization
     */
    public String getAuthorization() {

        return authorization;
    }

    /**
     * @param argAuthorization the authorization to set
     */
    public void setAuthorization(String argAuthorization) {

        authorization = argAuthorization;
    }

    /**
     * @return the token
     */
    public String getToken() {

        return token;
    }

    /**
     * @param argToken the token to set
     */
    public void setToken(String argToken) {

        token = argToken;
    }

    /**
     * @return the cardNumberMasked
     */
    public String getCardNumberMasked() {

        return cardNumberMasked;
    }

    /**
     * @param argCardNumberMasked the cardNumberMasked to set
     */
    public void setCardNumberMasked(String argCardNumberMasked) {

        cardNumberMasked = argCardNumberMasked;
    }

    /**
     * @return the cardholder
     */
    public String getCardholder() {

        return cardholder;
    }

    /**
     * @param argCardholder the cardholder to set
     */
    public void setCardholder(String argCardholder) {

        cardholder = argCardholder;
    }

    /**
     * @return the expireDate
     */
    public String getExpireDate() {

        return expireDate;
    }

    /**
     * @param argExpireDate the expireDate to set
     */
    public void setExpireDate(String argExpireDate) {

        expireDate = argExpireDate;
    }

}
