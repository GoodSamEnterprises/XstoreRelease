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
 * Req/Bug ID#      ddMMyy    Description
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 *===================================================================
 */

package caw.orderservice.model;

/**
 *
 */
//Start BZ50032
public class CawCheetahTokenModel {

    private String  expiresTime;

    private String  tokenAccess;

    private String  tokenType;

    private boolean isUseToken = false;

    /**
     * @return the isUseToken
     */
    public boolean isUseToken() {

        return isUseToken;
    }

    /**
     * @param argIsUseToken the isUseToken to set
     */
    public void setUseToken(boolean argIsUseToken) {

        isUseToken = argIsUseToken;
    }

    /**
     * 
     */
    public CawCheetahTokenModel(String argExpiresTime, String argTokenAccess,
            String argTokenType) {

        super();
        expiresTime = argExpiresTime;
        tokenAccess = argTokenAccess;
        tokenType = argTokenType;
    }

    public CawCheetahTokenModel() {

        super();
    }

    /**
     * @return the expiresTime
     */
    public String getExpiresTime() {

        return expiresTime;
    }

    /**
     * @param argExpiresTime the expiresTime to set
     */
    public void setExpiresTime(String argExpiresTime) {

        expiresTime = argExpiresTime;
    }

    /**
     * @return the tokenAccess
     */
    public String getTokenAccess() {

        return tokenAccess;
    }

    /**
     * @param argTokenAccess the tokenAccess to set
     */
    public void setTokenAccess(String argTokenAccess) {

        tokenAccess = argTokenAccess;
    }

    /**
     * @return the tokenType
     */
    public String getTokenType() {

        return tokenType;
    }

    /**
     * @param argTokenType the tokenType to set
     */
    public void setTokenType(String argTokenType) {

        tokenType = argTokenType;
    }
    //End BZ50032
}