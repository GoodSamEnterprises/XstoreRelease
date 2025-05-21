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
 * BZ23976          121017    Need to send the ADS result to CareTaker after the credit application completes
 * BZ24017          151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ24125          251017    'HDE' screen is displayed after pressing 'View Customer' button
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26596          150618    [New Requirement] Add Associate detail to the Card Services Caretaker Call
 * BZ27108          160818    [PROD]Good Sam Visa Shopping Pass text needs to reflect the approved credit amount
 * BZ27668          031018    [New Requirement] Add the salesperson to the Made Offer requests for the Card Services API
 * BZ28247          181218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ28012          211218    [New Requirement] Update the Caretaker Calls to include all credit application responses
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 * BZ29382          150219    [Internal] Customer continues to be prompted for prescreen even after the customer has accepted and tendered with their new account.
 * BZ29501          220219    Xstore not filling the adsResponse to the ApplicationStatus calls for the instant credit decline
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSInfo;

import dtv.i18n.FormattableFactory;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * BZ26575 modified by using CawUtilFunction 
 */
public class CawGoodSamVisaHelper {

    private static final Logger                 logger                                = Logger
            .getLogger(CawGoodSamVisaHelper.class);

    /* BEGIN BZ26596 */
    private static final String                 CASHIER                               = "!{cashier}";

    private static final String                 CODE                                  = "!{employeeId}";

    private static final String                 FILENUMBER                            = "!{partyId}";

    private static final String                 NULL                                  = "null";
    /* END BZ26596 */

    private static final String                 LAST                                  = "!{last}";

    private static final String                 FIRST                                 = "!{first}";

    private static final String                 COUNTRY                               = "!{country}";

    private static final String                 POSTAL_CODE                           = "!{postalCode}";

    private static final String                 STATE_PROVINCE                        = "!{stateProvince}";

    private static final String                 CITY                                  = "!{city}";

    private static final String                 LINE1                                 = "!{line1}";

    private static final String                 CUSTOMER                              = "!{customer}";

    private static final String                 ADDRESS                               = "!{address}";

    private static final String                 NAME                                  = "!{name}";

    private static final String                 CUSTOMER_TYPE                         = "!{customerType}";

    private static final String                 ACCOUNT_NUMBER                        = "!{accountNumber}";

    public static volatile CawGoodSamVisaHelper INSTANCE                              = null;

    private static final String                 SALE_CHANEL_ID                        = "!{id}";

    private static final String                 SALE_CHANNEL_TYPE                     = "!{channelType}";

    private static final String                 PRESCREEN_ID                          = "!{preScreenID}";

    private static final String                 YES_BUTTON                            = "YES";

    private static final String                 NO_BUTTON                             = "NO";

    private static final String                 NOTPRI_BUTTON                         = "NOTPRI";

    /* BEGIN BZ27108 */
    private static final String                 XML_VIRTUAL_CARD_CREDIT_LIMIT_PATTERN = "//creditLimit";

    public static final String                  VIRTUAL_CARD_CREDIT_LIMIT_DEFAULT     = " $5,000.00";
    /* END BZ27108 */

    /* BEGIN BZ28247 */
    /**
     * The CUSTOMER_RESPONSE
     */
    public static final String                  CUSTOMER_RESPONSE                     = "!{customerResponse}";

    /**
     * The TYPE
     */
    public static final String                  TYPE                                  = "!{type}";

    /**
     * The STATUS
     */
    public static final String                  STATUS                                = "!{status}";

    /**
     * The CARDTYPE
     */
    public static final String                  CARDTYPE                              = "!{cardtype}";

    /**
     * The CUSTOMER_SOURCE
     */
    public static final String                  CUSTOMER_SOURCE                       = "!{customerSource}";

    /**
     * The ADSRESPONSE
     */
    public static final String                  ADSRESPONSE                           = "!{adsResponse}";

    /**
     * The RETURN_CODE
     */
    private static final String                 RETURN_CODE                           = "!{returnCode}";

    /**
     * The MESSAGE
     */
    private static final String                 MESSAGE                               = "!{message}";

    /**
     * The ACCOUNT_ID
     */
    private static final String                 ACCOUNT_ID                            = "!{accountId}";

    /**
     * The APPLICATION_ID
     */
    private static final String                 APPLICATION_ID                        = "!{applicationId}";

    /**
     * The ADS_PRESCREEN_ID
     */
    private static final String                 ADS_PRESCREEN_ID                      = "!{prescreenId}";

    private static final String                 TERMINAL_ID                           = "!{terminal}";        // BZ29382
    private CawCustomerGSHelper                 _gsHelper                             = CawCustomerGSHelper
            .getInstance();

    /* END BZ28247 */

    public static CawGoodSamVisaHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawGoodSamVisaHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawGoodSamVisaHelper();
                }
            }
        }
        return INSTANCE;
    }

    /* BEGIN BZ28247*/
    /**
     * @param trans
     * @param keyPressed
     * @param preScreenID
     * @param esbResponse
     * @return
     */
    public String getMadeOfferTemplate(IPosTransaction trans, String keyPressed, String preScreenId,
            String esbResponse) {

        IRetailTransaction retailTrans = (IRetailTransaction) trans;

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawRestConfigHelper.GOODSAM_VISA_MADEOFFER_TEMPLATE);

        String body = request.getBody();
        body = body.replace(SALE_CHANEL_ID, Long.toString(trans.getRetailLocationId()));
        body = body.replace(SALE_CHANNEL_TYPE, CawEBSConstant.SALE_CHANNEL_TYPE_RETAIL);
        /* BEGIN BZ29382 */
        if (retailTrans != null) {
            body = body.replace(TERMINAL_ID, CawJSONConstant.SPACE_CHARACTER + retailTrans.getWorkstationId());
        }
        body = body.replace(PRESCREEN_ID, CawUtilFunction.formatParameter(preScreenId));

        if (keyPressed.equalsIgnoreCase(YES_BUTTON)) {
            body = body.replace(CUSTOMER_RESPONSE, CawJSONConstant.SPACE_CHARACTER
                    + Integer.parseInt(CawEBSConstant.PRESCREEN_ID_YES));

        } else if (keyPressed.equalsIgnoreCase(NO_BUTTON)) {
            body = body.replace(CUSTOMER_RESPONSE, CawJSONConstant.SPACE_CHARACTER
                    + Integer.parseInt(CawEBSConstant.PRESCREEN_ID_NO));

        } else if (keyPressed.equalsIgnoreCase(NOTPRI_BUTTON)) {
            body = body.replace(CUSTOMER_RESPONSE, CawJSONConstant.SPACE_CHARACTER
                    + Integer.parseInt(CawEBSConstant.PRESCREEN_ID_NOTPRI));
        } else {
            body = body.replace(CUSTOMER_RESPONSE, CawJSONConstant.SPACE_CHARACTER
                    + Integer.parseInt(CawEBSConstant.PRESCREEN_ID_NOTPRI));
        }
        body = body.replace(CUSTOMER, getCareTakerCustomerTemplate(esbResponse));
        /* END BZ29382 */
        return body;
    }

    /* BEGIN BZ29280 */
    /**
     * @param trans
     * @param xmlResponse
     * @param ebsResponse
     * @param applicationType
     * @return
     */
    public String getCareTakerTemplate(IRetailTransaction trans, String ebsResponse, String applicationType,
            String preScreenId) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.GOODSAM_VISA_CARE_TAKER_TEMPLATE);
        /* BEGIN BZ28012 */
        String body = request.getBody();
        if (trans != null) {
            body = body.replace(SALE_CHANEL_ID, Long.toString(trans.getRetailLocationId()));

            body = body.replace(SALE_CHANNEL_TYPE, CawEBSConstant.SALE_CHANNEL_TYPE_RETAIL);

            body = body.replace(TERMINAL_ID, CawJSONConstant.SPACE_CHARACTER + trans.getWorkstationId());

            body = body.replace(CASHIER, getCashierTemplate(trans));
        }
        /* END BZ28012 */
        if (CawConstants.PRESCREEN_ACCEPT.equalsIgnoreCase(applicationType)) {

            body = body.replace(TYPE, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_1));

        } else if (CawConstants.INSTANT_CREDIT.equalsIgnoreCase(applicationType)) {

            body = body.replace(TYPE, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_2));

        } else {

            body = body.replace(TYPE, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_0));

        }

        int status = _gsHelper.getApplicationStatus();

        if (status == 1) {
            // Approved.
            body = body.replace(STATUS, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_1));
        } else if (status == 2) {
            // Declined.
            body = body.replace(STATUS, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_2));
        } else if (status == 4) {
            // Cancelled.
            body = body.replace(STATUS, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_4));
        }

        CawCustomerGSInfo customerGSInfor = _gsHelper.getGSInfo();

        if (CawConstants.PRESCREEN_ACCEPT.equalsIgnoreCase(applicationType)) {

            body = body.replace(CARDTYPE, CawJSONConstant.SPACE_CHARACTER + _gsHelper.getCardType());

        } else if (CawConstants.INSTANT_CREDIT.equalsIgnoreCase(applicationType) && customerGSInfor != null
                && customerGSInfor.getCardType() > 1) {

            body = body.replace(CARDTYPE, CawJSONConstant.SPACE_CHARACTER + _gsHelper.getCardType());

        } else {

            if (CawConstants.INSTANT_CREDIT.equalsIgnoreCase(applicationType)) {

                body = body.replace(CARDTYPE, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_1));

            } else {

                body = body.replace(CARDTYPE, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_0));

            }
        }

        body = body.replace(CUSTOMER, getCareTakerCustomerTemplate(ebsResponse));

        body = body.replace(CUSTOMER_SOURCE, CawJSONConstant.SPACE_CHARACTER + Integer.parseInt(CawConstants.VALUE_1));

        String adsResponse = getAdsResponse(customerGSInfor, applicationType, preScreenId);

        if (adsResponse != null && StringUtils.isNotEmpty(preScreenId)) {

            body = body.replace(ADSRESPONSE, adsResponse);

        } else {
            body = body.replace(ADSRESPONSE, adsResponse);// BZ29501
        }
        /* END BZ28012 */

        return body;
    }

    /**
     * @param customerGSInfor
     * @param applicationType
     * @param preScreenId
     * @return
     */
    private String getAdsResponse(CawCustomerGSInfo customerGSInfor, String applicationType, String preScreenId) {

        CawRestConfig request = null;

        if (StringUtils.isNotEmpty(applicationType)) {
            if (CawConstants.PRESCREEN_ACCEPT.equalsIgnoreCase(applicationType)) {
                request = CawRestConfigHelper.getInstance()
                        .getRestRequest(CawEBSConstant.ATR_ADSRESPONSE_TEMPLETE_PRESCREEN);
            } else {
                request = CawRestConfigHelper.getInstance()
                        .getRestRequest(CawEBSConstant.ATR_ADSRESPONSE_TEMPLETE_INSTANT);
            }
        }

        String body = "";

        if (request != null) {
            body = request.getBody();
        }

        // CawAdsResponse adsResponse = _cawCardServiceHelper.parseXmlResponse(xmlResponse);

        if (customerGSInfor != null && StringUtils.isNotEmpty(body)) {
            if (StringUtils.isNotEmpty(customerGSInfor.getReturnCode())) {
                body = body.replace(RETURN_CODE, CawUtilFunction.formatParameter(customerGSInfor.getReturnCode()));
            } else {
                body = body.replace(RETURN_CODE, CawJSONConstant.NULL);
            }
            if (StringUtils.isNotEmpty(customerGSInfor.getMessage())) {
                body = body.replace(MESSAGE, CawUtilFunction.formatParameter(customerGSInfor.getMessage()));
            } else {
                body = body.replace(MESSAGE, CawJSONConstant.NULL);
            }
            if (StringUtils.isNotEmpty(customerGSInfor.getAccountId())) {
                body = body.replace(ACCOUNT_ID, CawUtilFunction.formatParameter(customerGSInfor.getAccountId()));
            } else {
                body = body.replace(ACCOUNT_ID, CawJSONConstant.NULL);
            }
            if (StringUtils.isNotEmpty(customerGSInfor.getApplicationId())) {
                body = body
                        .replace(APPLICATION_ID, CawUtilFunction.formatParameter(customerGSInfor.getApplicationId()));
            } else {
                body = body.replace(APPLICATION_ID, CawJSONConstant.NULL);
            }
            if (StringUtils.isNotEmpty(preScreenId)) {
                body = body.replace(ADS_PRESCREEN_ID, CawUtilFunction.formatParameter(preScreenId));
            } else if (CawConstants.PRESCREEN_ACCEPT.equalsIgnoreCase(applicationType)) {
                body = body.replace(ADS_PRESCREEN_ID, CawJSONConstant.NULL);
            }

        } else {
            body = body.replace(RETURN_CODE, CawUtilFunction.formatParameter(CawJSONConstant.SPACE_CHARACTER));

            body = body.replace(MESSAGE, CawUtilFunction.formatParameter(CawJSONConstant.SPACE_CHARACTER));

            body = body.replace(ACCOUNT_ID, CawUtilFunction.formatParameter(CawJSONConstant.SPACE_CHARACTER));

            body = body.replace(APPLICATION_ID, CawUtilFunction.formatParameter(CawJSONConstant.SPACE_CHARACTER));

            body = body.replace(ADS_PRESCREEN_ID, CawUtilFunction.formatParameter(CawJSONConstant.SPACE_CHARACTER));
        }

        return body;
    }
    /* END BZ29280 */

    /* END BZ28247 */

    /**
     * Added for BZ26596, BZ27668 renamed to getCashierTemplate
     * @param trans
     * @return
     */
    public String getCashierTemplate(IRetailTransaction trans) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.GOODSAM_VISA_CARE_TAKER_CASHIER_TEMPLATE);
        String body = request.getBody();

        /* BEGIN BZ27668 */
        IParty cashier = null;
        if (trans != null) {
            cashier = trans.getOperatorParty();
        }
        /* END BZ27668 */

        if (cashier != null) {
            body = body.replace(CODE, CawUtilFunction.formatParameter(cashier.getEmployeeId()));
            body = body.replace(NAME, CawUtilFunction
                    .formatParameter(cashier.getFirstName() + " " + cashier.getLastName()));
            body = body.replace(FILENUMBER, CawUtilFunction.formatParameter(String.valueOf(cashier.getPartyId())));
        } else {
            body = body.replace(CODE, NULL);
            body = body.replace(NAME, NULL);
            body = body.replace(FILENUMBER, NULL);
        }

        return body;
    }

    public String getCareTakerCustomerTemplate(String ebsResponse) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.GOODSAM_VISA_CARE_TAKER_CUSTOMER_TEMPLATE);
        String body = request.getBody();
        /* BEGIN BZ24125 */
        if (ebsResponse != null && !"".equals(ebsResponse)) {
            body = body.replace(ACCOUNT_NUMBER, CawCustomerUtil.getAccountNumber(ebsResponse));
            body = body.replace(CUSTOMER_TYPE, CawCustomerUtil.getCustomerType(ebsResponse));
            body = body.replace(NAME, getCareTakerCustomerName(ebsResponse));
            body = body.replace(ADDRESS, getCareTakerCustomerAddress(ebsResponse));
        } else {
            body = body.replace(ACCOUNT_NUMBER, CawJSONConstant.NULL);
            body = body.replace(CUSTOMER_TYPE, CawJSONConstant.NULL);
            body = body.replace(NAME, CawJSONConstant.NULL);
            body = body.replace(ADDRESS, CawJSONConstant.NULL);
        }
        /* END BZ24125 */
        return body;
    }

    /**
     * @param argEbsResponse
     * @return
     */
    private CharSequence getCareTakerCustomerAddress(String ebsResponse) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.GOODSAM_VISA_CARE_TAKER_CUSTOMER_ADDRESS_TEMPLATE);
        String body = request.getBody();
        body = body
                .replace(LINE1, CawUtilFunction.formatParameter(CawCustomerUtil.getCustomerAddressLine1(ebsResponse)));
        body = body.replace(CITY, CawUtilFunction.formatParameter(CawCustomerUtil.getCustomerCity(ebsResponse)));
        body = body.replace(STATE_PROVINCE, CawUtilFunction
                .formatParameter(CawCustomerUtil.getCustomerState(ebsResponse)));
        body = body.replace(POSTAL_CODE, CawUtilFunction.formatParameter(CawCustomerUtil.getCustomerZip(ebsResponse)));
        body = body.replace(COUNTRY, CawUtilFunction.formatParameter(CawCustomerUtil.getCustomerCountry(ebsResponse)));

        return body;
    }

    /**
     * @param argEbsResponse
     * @return
     */
    private CharSequence getCareTakerCustomerName(String ebsResponse) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.GOODSAM_VISA_CARE_TAKER_CUSTOMER_NAME_TEMPLATE);
        String body = request.getBody();
        body = body.replace(FIRST, CawUtilFunction.formatParameter(CawCustomerUtil.getCustomerFirstName(ebsResponse)));
        body = body.replace(LAST, CawUtilFunction.formatParameter(CawCustomerUtil.getCustomerLastName(ebsResponse)));

        return body;
    }
    /* END BZ23976 */

    /* BEGIN BZ27108 */
    public String decodevVirtualCardCreditLimit(String argSource) {

        String creditLimit = null;
        if (argSource != null && !argSource.isEmpty()) {
            byte[] decoded = Base64.getDecoder().decode(argSource);
            String str = new String(decoded, StandardCharsets.UTF_8);
            StringReader reader = null;
            SAXBuilder saxBuilder = new SAXBuilder();
            try {
                reader = new StringReader(str);
                Document doc = saxBuilder.build(reader);
                XPathFactory xFactory = XPathFactory.instance();
                XPathExpression<Element> expr = xFactory
                        .compile(XML_VIRTUAL_CARD_CREDIT_LIMIT_PATTERN, Filters.element());
                List<Element> links = expr.evaluate(doc);
                for (Element link : links) {
                    creditLimit = link.getValue();
                }
            } catch (JDOMException | IOException ex) {
                logger.error("The function decode creditLimit have error." + ex.getMessage());
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }

        return creditLimit;
    }
    /* END BZ27108 */

    /* BEGIN BZ29280 */

    /**
     * @param argSource
     * @return
     */
    public int decodeCardType(String argSource) {

        int cardType = 0;
        String type = "";
        if (StringUtils.isNotEmpty(argSource)) {
            byte[] decoded = Base64.getDecoder().decode(argSource);
            String str = new String(decoded, StandardCharsets.UTF_8);
            StringReader reader = null;
            SAXBuilder saxBuilder = new SAXBuilder();
            try {
                reader = new StringReader(str);
                Document doc = saxBuilder.build(reader);
                XPathFactory xFactory = XPathFactory.instance();
                XPathExpression<Element> expr = xFactory
                        .compile(CawEigenConstants.XML_CARD_TYPE_PATTERN, Filters.element());
                List<Element> links = expr.evaluate(doc);
                if (links != null && !links.isEmpty()) {
                    type = links.get(0).getValue();
                    if (type.equals(CawConstants.VISA_SHORT)) {
                        cardType = 1;
                    } else if (type.equals(CawConstants.PLCC_SHORT)) {
                        cardType = 2;
                    }
                }
            } catch (JDOMException | IOException ex) {
                logger.error("The function decode expiry date have error." + ex.getMessage());
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
        return cardType;
    }

    /**
     * @param argSource
     * @return
     */
    public String decodeApr(String argSource) {

        String apr = "";
        if (StringUtils.isNotEmpty(argSource)) {
            byte[] decoded = Base64.getDecoder().decode(argSource);
            String str = new String(decoded, StandardCharsets.UTF_8);
            StringReader reader = null;
            SAXBuilder saxBuilder = new SAXBuilder();
            try {
                reader = new StringReader(str);
                Document doc = saxBuilder.build(reader);
                XPathFactory xFactory = XPathFactory.instance();
                XPathExpression<Element> expr = xFactory.compile(CawEigenConstants.XML_APR_PATTERN, Filters.element());
                List<Element> links = expr.evaluate(doc);
                if (links != null && !links.isEmpty()) {
                    apr = links.get(0).getValue();
                }
            } catch (JDOMException | IOException ex) {
                logger.error("The function decode expiry date have error." + ex.getMessage());
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
        return apr;
    }

    /**
     * @param keyTranslation
     * @param parameter
     * @return
     */
    public String makeString(String keyTranslation, String parameter) {
        FormattableFactory _ff = FormattableFactory.getInstance();
        return String.format(_ff.getTranslatable(keyTranslation).toString(), parameter); /*BZ27973*/
    }
    /* END BZ29280 */

}
