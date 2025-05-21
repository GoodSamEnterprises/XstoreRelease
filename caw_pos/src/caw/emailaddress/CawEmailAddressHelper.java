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
 * BZ45995          141021    [New requirement] Email capture when good sam membership is sold
 * BZ42019          171121    Replace QAS with EAVS2
 *===================================================================
 */

package caw.emailaddress;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.common.CawConstants;
import caw.pos.common.CawJSONConstant;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.CodeValueId;
import dtv.xst.dao.com.impl.CodeValueModel;

/**
 *
 */
public class CawEmailAddressHelper extends CawJSONConstant {

    private static final Logger                   _logger    = LogManager
            .getLogger(CawEmailAddressHelper.class);

    private CawEBSHelper                          _ebsHelper = CawEBSHelper.getInstance();
    
    public static final int                       SUCCESS_RESPONSE_STATUS = 0;

    public static final int                       ERROR_RESPONSE_STATUS   = 1;
    
    public static final String                    EMAIL_VALIDATION_SAVE   = "EMAIL_VALIDATION_SAVE"; //BZ42019
    

    private static volatile CawEmailAddressHelper instance   = null;

    private CawEmailAddressHelper() {

        super();
    }

    public static CawEmailAddressHelper getInstance() {

        if (instance == null) {
            synchronized (CawEBSHelper.class) {
                if (instance == null) {
                    instance = new CawEmailAddressHelper();
                }
            }
        }
        return instance;
    }

    public ResponseEntity<String> requestValidateEmail(String emailAddress) {

        return _ebsHelper.sendEmailValidationRequestToESB(emailAddress);

    }
    
    @SuppressWarnings("unchecked")
    public static String getErrorString(JSONObject emailResJsonObj) {

        String result = "";

        try {
            JSONObject errorJsonObj = emailResJsonObj.getJSONObject(JSON_ERRORS);

            List<String> errorMsgList = new ArrayList<>();
            Iterator<String> keys = errorJsonObj.keys();

            while (keys.hasNext()) {
                String key = keys.next();

                if (errorJsonObj.get(key) instanceof String) {
                    String value = errorJsonObj.getString(key);

                    errorMsgList.add(key + ": " + value);
                }
            }

            if (errorMsgList.size() > 0) {
                result = String.join("\n", errorMsgList);
            }
        } catch (Exception ex) {
            _logger.error("getErrorString: " + ex.getMessage());
        }

        return result;
    }
    
    public static String getErrorString(ResponseEntity<String> emailAddressValidationReponse) {

        String result = "";

        try {
            JSONObject emailResJsonObj;
            emailResJsonObj = new JSONObject(emailAddressValidationReponse.getBody());
            result = getErrorString(emailResJsonObj);
        } catch (JSONException ex) {
            _logger.error("Can't parse email address validation response: " + ex.getMessage());
        }

        return result;
    }
    
    public static CawEmailValidationStatus getMailingAddressValidationStatus(ResponseEntity<String> emailAddressValidationReponse) {
        CawEmailValidationStatus validationStatus = CawEmailValidationStatus.SUCCESS;
        
        if (emailAddressValidationReponse == null || !emailAddressValidationReponse.getStatusCode().equals(HttpStatus.OK)) {
            validationStatus = CawEmailValidationStatus.UNAVAILABLE;
        } else {
            try {
                JSONObject emailResJsonObj;
                emailResJsonObj = new JSONObject(emailAddressValidationReponse.getBody());
                int emailResStatus = emailResJsonObj.getInt(CawJSONConstant.JSON_STATUS);
                
                if (emailResStatus == ERROR_RESPONSE_STATUS) {
                    validationStatus = CawEmailValidationStatus.ERROR;
                } else if (emailResStatus == SUCCESS_RESPONSE_STATUS) {
                    boolean isEmailValid = emailResJsonObj.getBoolean(CawJSONConstant.JSON_EMAIL_VALIDATION_IS_EMAIL_VALID);
                    if (!isEmailValid) {
                        validationStatus = CawEmailValidationStatus.INVALID;
                    }
                }
            } catch (JSONException ex) {
                _logger.error("Can't parse email address validation response: " + ex.getMessage());
            }
        }
        
        return validationStatus;
    }
    
    /* BEGIN BZ42019 */
    public static String getSpecifiedNoThanksEmail() {
        String result = null;
        
        CodeValueId codeValueId = new CodeValueId();
        
        codeValueId.setOrganizationId(ConfigurationMgr.getOrganizationId());
        codeValueId.setCategory(CawConstants.CAW_NO_THANKS_EMAIL);
        codeValueId.setCode(CawConstants.CAW_NO_THANKS_EMAIL_CODE);
        
        CodeValueModel preDefineEmail = DataFactory.getObjectByIdNoThrow(codeValueId);
        
        if (preDefineEmail != null && StringUtils.isNotEmpty(preDefineEmail.getDescription())) {
            result = preDefineEmail.getDescription();
        }
        
        return result;
    }
    /* END BZ42019 */

}
