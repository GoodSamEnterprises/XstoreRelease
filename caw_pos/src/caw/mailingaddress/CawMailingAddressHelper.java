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
 * BZ42019          171121    Replace QAS with EAVS2
 * BZ47782          201221    Patch 18 - Question about mailing address rules
 * BZ47747          040122    [Internal] - Xstore should NOT continue calling the Mailing Address Validation API if it had already been validated as an exact address just before and no more update to the customer profile.
 *===================================================================
 */

package caw.mailingaddress;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.common.*;
import caw.pos.customer.CawCustomerMaintenanceModel;
import caw.pos.util.CawEBSHelper;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.customer.CustomerMaintenanceModel;
import dtv.pos.customer.IQualifiedAddress;
import dtv.xst.dao.crm.IParty;

/**
 *
 */
public class CawMailingAddressHelper extends CawJSONConstant {

    private static final Logger                     _logger                         = LogManager
            .getLogger(CawMailingAddressHelper.class);

    private CawEBSHelper                            _ebsHelper                      = CawEBSHelper
            .getInstance();
    
    
    public static final String                      MAILING_VALIDATION_SAVE         = "MAILING_VALIDATION_SAVE";
    
    public static final String                      MAILING_VALIDATION_UPDATE       = "MAILING_VALIDATION_UPDATE";
    
    
    public static final String                      DEFAULT_CHANNEL_TYPE    = "Retail";

    public static final int                         DEFAULT_ADDRESS_TYPE    = 1;
    

    public static final int                         SUCCESS_RESPONSE_STATUS         = 0;

    public static final int                         WARNING_RESPONSE_STATUS         = 1;

    public static final int                         ERROR_RESPONSE_STATUS           = 2;

    public static final int                         EXACT_MATCH                     = 0;

    public static final int                         SINGLE_MATCH                    = 1;

    private static volatile CawMailingAddressHelper instance                        = null;

    private CawMailingAddressHelper() {

        super();
    }
    
    public static CawMailingAddressHelper getInstance() {

        if (instance == null) {
            synchronized (CawEBSHelper.class) {
                if (instance == null) {
                    instance = new CawMailingAddressHelper();
                }
            }
        }
        return instance;
    }
    
    public ResponseEntity<String> requestValidateMailingAddress(CawMailingAddressRequest requestObj) {
        
        String requestBody = buildMailingValidationRequest(requestObj);
        
        ResponseEntity<String> response = _ebsHelper.sendMailingValidationRequestToESB(requestBody);
        
        return response;
        
    }
    
    private String buildMailingValidationRequest(CawMailingAddressRequest requestObj) {
        
        String body = null;
        
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.MAILING_ADDRESS_VALIDATE);
            
            body = request.getBody();
            
            body = body.replace(SALES_CHANNEL_ID, String.valueOf(requestObj.getSalesChannelId()));
            
            body = body.replace(CHANNEL_TYPE_ATTR, CawUtilFunction.formatParameter(requestObj.getChannelType()));
            
            body = body.replace(ADDRESS_ADDRESS_TYPE, String.valueOf(requestObj.getAddressType()));
            
            body = body.replace(ADDRESS_LINE1, CawUtilFunction.formatParameter(requestObj.getLine1()));
            
            body = body.replace(ADDRESS_LINE2, CawUtilFunction.formatParameter(requestObj.getLine2()));
            
            body = body.replace(ADDRESS_LINE3, CawUtilFunction.formatParameter(requestObj.getLine3()));
            
            body = body.replace(ADDRESS_LINE4, CawUtilFunction.formatParameter(requestObj.getLine4()));
            
            body = body.replace(CITY, CawUtilFunction.formatParameter(requestObj.getCity()));
            
            body = body.replace(STATE, CawUtilFunction.formatParameter(requestObj.getState()));
            
            body = body.replace(POSTAL_CODE, CawUtilFunction.formatParameter(requestObj.getPostal()));
            
            body = body.replace(COUNTRY, CawUtilFunction.formatParameter(requestObj.getCountry()));
            
        } catch (Exception ex) {
            _logger.error("Fail to parse Mailing Validation request to request body: " + ex.getMessage());
        }
        
        return body;
    }
    
    public static void setAddressFromCatalystReponse(String catalystResponseStr, CawMailingAddressRequest request) {
        if (StringUtils.isNotEmpty(catalystResponseStr)) {
            try {
                JSONObject customerJsonObj = new JSONObject(catalystResponseStr);

                if (!customerJsonObj.isNull(CawJSONConstant.JSON_ADDRESS)
                        && customerJsonObj.getJSONObject(CawJSONConstant.JSON_ADDRESS) != null) {

                    JSONObject addressJsonObj = customerJsonObj.getJSONObject(CawJSONConstant.JSON_ADDRESS);
                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE1)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE1))) {
                        request.setLine1(addressJsonObj.getString(CawJSONConstant.JSON_LINE1));
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE2)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE2))) {
                        request.setLine2(addressJsonObj.getString(CawJSONConstant.JSON_LINE2));
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE3)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE3))) {
                        request.setLine3(addressJsonObj.getString(CawJSONConstant.JSON_LINE3));
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE4)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE4))) {
                        request.setLine4(addressJsonObj.getString(CawJSONConstant.JSON_LINE4));
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_CITY)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_CITY))) {
                        request.setCity(addressJsonObj.getString(CawJSONConstant.JSON_CITY));
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_STATE)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_STATE))) {
                        request.setState(addressJsonObj.getString(CawJSONConstant.JSON_STATE));

                        if (!addressJsonObj.isNull(CawJSONConstant.JSON_POSTAL_CODE)
                                && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE))) {
                            request.setPostal(addressJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE));
                        }
                    }
                }
            } catch (Exception ex) {
                _logger.error("Can not parse address of the customer");
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public static String getErrorString(ResponseEntity<String> mailingAddressValidationReponse) {

        String result = "";

        try {
            
            JSONObject mailingResJsonObj;
            mailingResJsonObj = new JSONObject(mailingAddressValidationReponse.getBody());
            
            JSONObject errorJsonObj = mailingResJsonObj.getJSONObject(JSON_ERRORS);

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
    
    @SuppressWarnings("unchecked")
    public static String getWarningString(ResponseEntity<String> mailingAddressValidationReponse) {

        String result = "";

        try {
            
            JSONObject mailingResJsonObj;
            mailingResJsonObj = new JSONObject(mailingAddressValidationReponse.getBody());
            
            JSONObject warningJsonObj = mailingResJsonObj.getJSONObject(JSON_WARNINGS);

            List<String> errorMsgList = new ArrayList<>();
            Iterator<String> keys = warningJsonObj.keys();

            while (keys.hasNext()) {
                String key = keys.next();

                if (warningJsonObj.get(key) instanceof String) {
                    String value = warningJsonObj.getString(key);

                    errorMsgList.add(key + ": " + value);
                }
            }

            if (errorMsgList.size() > 0) {
                result = String.join("\n", errorMsgList);
            }
        } catch (Exception ex) {
            _logger.error("getWarningString: " + ex.getMessage());
        }

        return result;
    }
    
    public static String getCleanedAddressString(ResponseEntity<String> mailingAddressValidationReponse) {
        String result = "";
        
        try {
            
            JSONObject mailingResJsonObj;
            mailingResJsonObj = new JSONObject(mailingAddressValidationReponse.getBody());
            
            JSONObject cleanAddrJsonObj = mailingResJsonObj.getJSONObject(CawJSONConstant.JSON_MAILING_VALIDATION_CLEAN_ADDRESS);
            
            String line1 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE1);
            String line2 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE2);
            String line3 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE3);
            String line4 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE4);
            String city = cleanAddrJsonObj.getString(CawJSONConstant.JSON_CITY);
            String state = cleanAddrJsonObj.getString(CawJSONConstant.JSON_STATE);
            String postal = cleanAddrJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE);
            String country = cleanAddrJsonObj.getString(CawJSONConstant.JSON_COUNTRY);
            
            result = result + (StringUtils.isNotEmpty(line1) 
                    ? line1 : CawConstants.CAW_STRING_EMPTY);
            result = result + (StringUtils.isNotEmpty(line2) 
                    ? (CawConstants.SPACE_SIGN + line2) : CawConstants.CAW_STRING_EMPTY);
            result = result + (StringUtils.isNotEmpty(line3) 
                    ? (CawConstants.SPACE_SIGN + line3) : CawConstants.CAW_STRING_EMPTY);
            result = result + (StringUtils.isNotEmpty(line4) 
                    ? (CawConstants.SPACE_SIGN + line4) : CawConstants.CAW_STRING_EMPTY);
            result = result + (StringUtils.isNotEmpty(city) 
                    ? (CawConstants.SPACE_SIGN + city) : CawConstants.CAW_STRING_EMPTY);
            result = result + (StringUtils.isNotEmpty(state) 
                    ? (CawConstants.SPACE_SIGN + state) : CawConstants.CAW_STRING_EMPTY);
            result = result + (StringUtils.isNotEmpty(postal) 
                    ? (CawConstants.SPACE_SIGN + postal) : CawConstants.CAW_STRING_EMPTY);
            result = result + (StringUtils.isNotEmpty(country) 
                    ? (CawConstants.SPACE_SIGN + country) : CawConstants.CAW_STRING_EMPTY);
            
        } catch (Exception ex) {
            _logger.error("getCleanedAddressString: " + ex.getMessage());
        }
        
        return result;
    }
    
    public static void updateCustomerAddressWithCleanedAddress(CustomerMaintenanceModel model, ResponseEntity<String> mailingAddressValidationReponse) {
        try {
            
            JSONObject mailingResJsonObj;
            mailingResJsonObj = new JSONObject(mailingAddressValidationReponse.getBody());
            
            JSONObject cleanAddrJsonObj = mailingResJsonObj.getJSONObject(CawJSONConstant.JSON_MAILING_VALIDATION_CLEAN_ADDRESS);
            
            String line1 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE1);
            String line2 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE2);
            String line3 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE3);
            String line4 = cleanAddrJsonObj.getString(CawJSONConstant.JSON_LINE4);
            String city = cleanAddrJsonObj.getString(CawJSONConstant.JSON_CITY);
            String state = cleanAddrJsonObj.getString(CawJSONConstant.JSON_STATE);
            String postal = cleanAddrJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE);
            String country = cleanAddrJsonObj.getString(CawJSONConstant.JSON_COUNTRY);
            
            model.setAddress1(line1);
            model.setAddress2(line2);
            model.setAddress3(line3);
            model.setAddress4(line4);
            model.setCity(city);
            model.setState(state);
            model.setPostalCode(postal);
            
            if (model instanceof CawCustomerMaintenanceModel) {
                CawCustomerMaintenanceModel cawModel = (CawCustomerMaintenanceModel) model;
                
                cawModel.getMainAddress().setAddress1(line1);
                cawModel.getMainAddress().setAddress2(line2);
                cawModel.getMainAddress().setAddress3(line3);
                cawModel.getMainAddress().setAddress4(line4);
                cawModel.getMainAddress().setCity(city);
                cawModel.getMainAddress().setState(state);
                cawModel.getMainAddress().setPostalCode(postal);
            }
            
            model.setCountry(country);
            if (StringUtils.isNotEmpty(country)) {
                if (country.equals(CawEBSConstant.USA)) {
                    model.setCountry(CawConstants.US);
                }
                
                if (country.equals(CawEBSConstant.CAN)) {
                    model.setCountry(CawConstants.CA);
                }
            }
            
        } catch (Exception ex) {
            _logger.error("updateCustomerAddressWithCleanedAddress: " + ex.getMessage());
        }
    }
    
    public static CawMailingValidationStatus getMailingAddressValidationStatus(ResponseEntity<String> mailingAddressValidationReponse) {
        CawMailingValidationStatus validationStatus = CawMailingValidationStatus.SUCCESS;
        
        if (mailingAddressValidationReponse == null || !mailingAddressValidationReponse.getStatusCode().equals(HttpStatus.OK)) {
            validationStatus = CawMailingValidationStatus.UNAVAILABLE;
        } else {
            try {
                JSONObject mailingResJsonObj;
                mailingResJsonObj = new JSONObject(mailingAddressValidationReponse.getBody());
                int mailingResStatus = mailingResJsonObj.getInt(CawJSONConstant.JSON_STATUS);
                
                if (mailingResStatus == ERROR_RESPONSE_STATUS) {
                    validationStatus = CawMailingValidationStatus.ERROR;
                } else if (mailingResStatus == WARNING_RESPONSE_STATUS) {
                    validationStatus = CawMailingValidationStatus.WARNING;
                }
            } catch (JSONException ex) {
                _logger.error("Can't parse mailing address validation response: " + ex.getMessage());
            }
        }
        
        return validationStatus;
    }
    
    public static boolean isMailingAddressValidatableCountry(String country) {

        if (country != null && (CawEBSConstant.US.equalsIgnoreCase(country)
                || CawEBSConstant.CA.equalsIgnoreCase(country))) {
            return true;
        }
        return false;
    }
    
    /* BEGIN BZ 47747 */
    /**
     * Compare addr1 with cleaned address from response
     * @param addr1
     * @param responseJsonStr
     * @return
     */
    public static boolean isIdenticalMailingAddress(IQualifiedAddress addr1, String responseJsonStr) {
        boolean result = false;
        
        if (StringUtils.isNotEmpty(responseJsonStr)) {
            try {
                JSONObject responseJsonObj = new JSONObject(responseJsonStr);
                JSONObject cleanJsonObj = responseJsonObj.getJSONObject(JSON_MAILING_VALIDATION_CLEAN_ADDRESS);
                
                String cleanPostalCode = cleanJsonObj.getString(JSON_POSTAL_CODE);
                
                if (StringUtils.isNotEmpty(addr1.getPostalCode()) 
                        && StringUtils.isNotEmpty(cleanPostalCode)
                        && addr1.getPostalCode().equalsIgnoreCase(cleanPostalCode)) {
                    
                    String cleanState = cleanJsonObj.getString(JSON_STATE);
                    
                    if (StringUtils.isNotEmpty(addr1.getState())
                            && StringUtils.isNotEmpty(cleanState)
                            && addr1.getState().equalsIgnoreCase(cleanState)) {
                        
                        String cleanCity = cleanJsonObj.getString(JSON_CITY);
                        
                        if (StringUtils.isNotEmpty(addr1.getCity())
                                && StringUtils.isNotEmpty(cleanCity)
                                && addr1.getCity().equalsIgnoreCase(cleanCity)) {
                            
                            
                            String cleanLine4 = cleanJsonObj.getString(JSON_LINE4);
                            
                            if ((StringUtils.isEmpty(addr1.getAddress4()) && StringUtils.isEmpty(cleanLine4))
                                    || addr1.getAddress4().equalsIgnoreCase(cleanLine4)) {
                                
                                String cleanLine3 = cleanJsonObj.getString(JSON_LINE3);
                                
                                if ((StringUtils.isEmpty(addr1.getAddress3()) && StringUtils.isEmpty(cleanLine3))
                                        || addr1.getAddress3().equalsIgnoreCase(cleanLine3)) {
                                    
                                    String cleanLine2 = cleanJsonObj.getString(JSON_LINE2);
                                    
                                    if ((StringUtils.isEmpty(addr1.getAddress2()) && StringUtils.isEmpty(cleanLine2))
                                            || addr1.getAddress2().equalsIgnoreCase(cleanLine2)) {
                                        
                                        String cleanLine1 = cleanJsonObj.getString(JSON_LINE1);
                                        
                                        if ((StringUtils.isEmpty(addr1.getAddress1()) && StringUtils.isEmpty(cleanLine1))
                                                || addr1.getAddress1().equalsIgnoreCase(cleanLine1)) {
                                            result = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
            } catch (Exception e) {
                _logger.error("Can not parse mailing address validation");
            }
        }
        
        return result;
    }
    
    public static boolean isIdenticalMailingAddress(IQualifiedAddress addr1, IParty addr2) {
        boolean result = true;
        
        boolean isAddressLineIdentical = false;
        
        if ((StringUtils.isEmpty(addr1.getAddress4()) && StringUtils.isEmpty(addr2.getLocaleInformation().get(0).getAddress4()))
                || addr1.getAddress4().equalsIgnoreCase(addr2.getLocaleInformation().get(0).getAddress4())) {
            
            if ((StringUtils.isEmpty(addr1.getAddress3()) && StringUtils.isEmpty(addr2.getLocaleInformation().get(0).getAddress3()))
                    || addr1.getAddress3().equalsIgnoreCase(addr2.getLocaleInformation().get(0).getAddress3())) {
                
                if ((StringUtils.isEmpty(addr1.getAddress2()) && StringUtils.isEmpty(addr2.getLocaleInformation().get(0).getAddress2()))
                        || addr1.getAddress2().equalsIgnoreCase(addr2.getLocaleInformation().get(0).getAddress2())) {
                    
                    if ((StringUtils.isEmpty(addr1.getAddress1()) && StringUtils.isEmpty(addr2.getLocaleInformation().get(0).getAddress1()))
                            || addr1.getAddress1().equalsIgnoreCase(addr2.getLocaleInformation().get(0).getAddress1())) {
                        isAddressLineIdentical = true;
                    }
                }
            }
        }
        
        if (!StringUtils.equalsIgnoreCase(addr1.getCity(), addr2.getLocaleInformation().get(0).getCity())
                || !StringUtils.equalsIgnoreCase(addr1.getState(), addr2.getLocaleInformation().get(0).getState())
                || !StringUtils.equalsIgnoreCase(addr1.getPostalCode(), addr2.getLocaleInformation().get(0).getPostalCode())
                || !StringUtils.equalsIgnoreCase(addr1.getCountry(), addr2.getLocaleInformation().get(0).getCountry())) {
            result = false;
        }
        
        return result && isAddressLineIdentical;
    }
    
    public static boolean isIdenticalMailingAddress(IQualifiedAddress addr1, CawMailingAddressRequest addr2) {
        boolean result = true;
        
        boolean isAddressLineIdentical = false;

        
        if ((StringUtils.isEmpty(addr1.getAddress4()) && StringUtils.isEmpty(addr2.getLine4()))
                || addr1.getAddress4().equalsIgnoreCase(addr2.getLine4())) {
            
            if ((StringUtils.isEmpty(addr1.getAddress3()) && StringUtils.isEmpty(addr2.getLine3()))
                    || addr1.getAddress3().equalsIgnoreCase(addr2.getLine3())) {
                
                if ((StringUtils.isEmpty(addr1.getAddress2()) && StringUtils.isEmpty(addr2.getLine2()))
                        || addr1.getAddress2().equalsIgnoreCase(addr2.getLine2())) {
                    
                    if ((StringUtils.isEmpty(addr1.getAddress1()) && StringUtils.isEmpty(addr2.getLine1()))
                            || addr1.getAddress1().equalsIgnoreCase(addr2.getLine1())) {
                        isAddressLineIdentical = true;
                    }
                }
            }
        }
        
        if (!StringUtils.equalsIgnoreCase(addr1.getCity(), addr2.getCity())
                || !StringUtils.equalsIgnoreCase(addr1.getState(), addr2.getState())
                || !StringUtils.equalsIgnoreCase(addr1.getPostalCode(), addr2.getPostal())
                || !StringUtils.equalsIgnoreCase(addr1.getCountry(), addr2.getCountry())) {
            result = false;
        }
        
        return result && isAddressLineIdentical;
    }
    /* END BZ 47747 */
}

