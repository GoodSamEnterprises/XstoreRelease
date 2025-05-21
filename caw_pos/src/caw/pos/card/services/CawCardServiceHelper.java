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
 * BZ28247          111218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 *===================================================================
 */

package caw.pos.card.services;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.w3c.dom.CharacterData;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.goodsam.op.CawAdsResponse;
import caw.tenderauth.impl.eigen.op.CawGoodSamVisaHelper;

import dtv.pos.i18n.format.MoneyFormatter;

public class CawCardServiceHelper {

    /**
     * The logger
     */
    private static final Logger                  logger                = Logger.getLogger(CawCardServiceHelper.class);

    /**
     * The INSTANCE
     */
    private static volatile CawCardServiceHelper INSTANCE              = null;

    /**
     * The PRESCREEN_ACCEPTANCE
     */
    private static final String                  PRESCREEN_ACCEPTANCE  = "prescreenAcceptance44Response";

    /**
     * The INSTANT_CREDIT
     */
    private static final String                  INSTANT_CREDIT        = "instantCredit42Response";

    /**
     * The RETURN_CODE
     */
    private static final String                  RETURN_CODE           = "returnCode";

    /**
     * The ERROR_MESSAGE
     */
    private static final String                  ERROR_MESSAGE         = "errorMessage";

    /**
     * The ACCOUNT_ID
     */
    private static final String                  ACCOUNT_ID            = "accountId";

    /**
     * The APPLICATION_ID
     */
    private static final String                  APPLICATION_ID        = "applicationId";

    /**
     * The RESPONSE
     */
    private static final String                  RESPONSE              = "response";

    /**
     * The INSTANCE_CREDIT_TAG
     */
    private static final String                  INSTANCE_CREDIT_TAG   = "instantCredit";
    /* BEGIN BZ29280 */

    private CawGoodSamVisaHelper                 _cawGoodSamVisaHelper = CawGoodSamVisaHelper.getInstance();

    private CawCustomerGSHelper                  _gsHelper             = CawCustomerGSHelper.getInstance();

    private MoneyFormatter                       _moneyFormatter       = new MoneyFormatter();
    /* END BZ29280 */

    /**
     * @return
     */
    public static CawCardServiceHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawCardServiceHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawCardServiceHelper();
                }
            }
        }
        return INSTANCE;
    }

    /* BEGIN BZ28247 */
    /**
     * @param xmlResponse
     * @return
     */
    public CawAdsResponse parseXmlResponse(String xmlResponse, String originalResponse) {
        String argReturnCode = "";

        String argErrorMessage = "";

        String argAccountId = "";

        String argApplicationId = "";
        /* BEGIN BZ29280 */
        int cardType = 0;

        String creditLimit = "";

        String apr = "";

        String virtualCreditLimit = "";
        /* END BZ29280 */
        if (StringUtils.isNotEmpty(xmlResponse)) {
            DocumentBuilder documentBulder = null;
            try {
                documentBulder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException ex) {

                logger.error("Could not create document builder. " + ex.getMessage());
            }
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlResponse));

            Document doc = null;
            try {
                if (documentBulder != null) {
                    doc = documentBulder.parse(is);
                }
            } catch (SAXException ex) {

                logger.error("Could not parse xml data stream. " + ex.getMessage());
            } catch (IOException ex) {

                logger.error("Could not parse xml data input stream. " + ex.getMessage());
            }
            /* BEGIN BZ29280 */
            if (xmlResponse.contains(PRESCREEN_ACCEPTANCE)) {
                if (doc != null) {
                    return processParsePrescreenData(doc, originalResponse);
                }
            } else if (xmlResponse.contains(INSTANT_CREDIT)) {
                if (doc != null) {
                    return processInstanceCreditData(doc, originalResponse);
                }
            }
            /* END BZ29280 */
        }

        return new CawAdsResponse(argReturnCode, argErrorMessage, argAccountId, argApplicationId, cardType, creditLimit,
                apr, virtualCreditLimit);// BZ29280

    }

    /**
     * @param argDoc
     * @return
     */
    private CawAdsResponse processInstanceCreditData(Document argDoc, String originalResponse) {

        String argReturnCode = "";

        String argErrorMessage = "";

        String argAccountId = "";

        String argApplicationId = "";

        int cardType = 0;

        String creditLimit = "";

        String apr = "";

        String virtualCreditLimit = "";

        NodeList nodes = argDoc.getElementsByTagName(RESPONSE);

        if (nodes != null && nodes.getLength() > 0)

        {
            Element element = (Element) nodes.item(0);
            if (element != null) {
                // Start to get the Return Code
                NodeList returnCodeNode = element.getElementsByTagName(RETURN_CODE);
                if (returnCodeNode != null && returnCodeNode.getLength() > 0) {
                    Element returnCodeValue = (Element) returnCodeNode.item(0);
                    if (returnCodeValue != null) {
                        argReturnCode = getCharacterDataFromElement(returnCodeValue);
                    }
                }
                // End to get the Return Code

                // Start to get the errorMessage
                NodeList errorMessageNode = element.getElementsByTagName(ERROR_MESSAGE);
                if (errorMessageNode != null && errorMessageNode.getLength() > 0) {
                    Element errorMessageValue = (Element) errorMessageNode.item(0);
                    if (errorMessageValue != null) {
                        argErrorMessage = getCharacterDataFromElement(errorMessageValue);
                    }
                }
                // End to get the errorMessage

                // Start to get data in the Instance Credit tag
                NodeList instanceCreditNodes = argDoc.getElementsByTagName(INSTANCE_CREDIT_TAG);
                if (instanceCreditNodes != null && instanceCreditNodes.getLength() > 0) {
                    Element elementInstanceCredit = (Element) instanceCreditNodes.item(0);
                    if (elementInstanceCredit != null) {
                        // Get accountNumber in the Instance Credit tag
                        NodeList insCreditAccountIdNode = element.getElementsByTagName(ACCOUNT_ID);

                        if (insCreditAccountIdNode != null && insCreditAccountIdNode.getLength() > 0) {
                            Element insCreditAccountIdValue = (Element) insCreditAccountIdNode.item(0);
                            if (insCreditAccountIdValue != null) {
                                argAccountId = getCharacterDataFromElement(insCreditAccountIdValue);
                            }
                        }
                        // End to get the accountNumber
                        // Get the accountId in the Instance Credit tag

                        NodeList insCreditApplicationIdNode = element.getElementsByTagName(APPLICATION_ID);

                        if (insCreditApplicationIdNode != null && insCreditApplicationIdNode.getLength() > 0) {
                            Element insCreditApplicationIdValue = (Element) insCreditApplicationIdNode.item(0);
                            if (insCreditApplicationIdValue != null) {
                                argApplicationId = getCharacterDataFromElement(insCreditApplicationIdValue);
                            }
                        }

                        // End to get the accountId in the Instance Credit tag

                    }
                }
                // End to get Instance Credit

            }
        }
        /* BEGIN BZ29280 */
        if (StringUtils.isNotEmpty(originalResponse)) {
            cardType = _cawGoodSamVisaHelper.decodeCardType(originalResponse);

            virtualCreditLimit = CawGoodSamVisaHelper.VIRTUAL_CARD_CREDIT_LIMIT_DEFAULT;
            try {
                creditLimit = _cawGoodSamVisaHelper.decodevVirtualCardCreditLimit(originalResponse);
                if (creditLimit != null) {

                    virtualCreditLimit = _cawGoodSamVisaHelper
                            .makeString("_cawGoodSamNote1", _moneyFormatter.format(creditLimit, null));
                }
            } catch (Exception ex) {
                logger.error("Parse virtualCard -> creditLimit Exception: " + ex.getMessage());
            }

            apr = _cawGoodSamVisaHelper.decodeApr(originalResponse);

        }

        return new CawAdsResponse(argReturnCode, argErrorMessage, argAccountId, argApplicationId, cardType, creditLimit,
                apr, virtualCreditLimit);
        /* END BZ29280 */

    }

    /**
     * @param argDoc
     * @return
     */
    private CawAdsResponse processParsePrescreenData(Document argDoc, String originalResponse) {

        String argReturnCode = "";

        String argErrorMessage = "";

        String argAccountId = "";

        String argApplicationId = "";
        /* BEGIN BZ29280 */
        int cardType = 0;

        String creditLimit = "";

        String apr = "";

        String virtualCreditLimit = "";
        /* END BZ29280 */
        NodeList nodes = argDoc.getElementsByTagName(RESPONSE);

        if (nodes != null && nodes.getLength() > 0)

        {
            Element element = (Element) nodes.item(0);
            if (element != null) {
                // Start to get the Return Code
                NodeList returnCodeNode = element.getElementsByTagName(RETURN_CODE);
                if (returnCodeNode != null && returnCodeNode.getLength() > 0) {
                    Element returnCodeValue = (Element) returnCodeNode.item(0);
                    if (returnCodeValue != null) {
                        argReturnCode = getCharacterDataFromElement(returnCodeValue);
                    }
                }
                // End to get the Return Code

                // Start to get the errorMessage
                NodeList errorMessageNode = element.getElementsByTagName(ERROR_MESSAGE);
                if (errorMessageNode != null && errorMessageNode.getLength() > 0) {
                    Element errorMessageValue = (Element) errorMessageNode.item(0);
                    if (errorMessageValue != null) {
                        argErrorMessage = getCharacterDataFromElement(errorMessageValue);
                    }
                }
                // End to get the errorMessage

                // Start to get the accountId
                NodeList accountIdNode = element.getElementsByTagName(ACCOUNT_ID);
                if (accountIdNode != null && accountIdNode.getLength() > 0) {
                    Element accountIdValue = (Element) accountIdNode.item(0);
                    if (accountIdValue != null) {
                        argAccountId = getCharacterDataFromElement(accountIdValue);
                    }
                }
                // End to get the accountNumber

                // Start to get the applicationId
                NodeList applicationIdNode = element.getElementsByTagName(APPLICATION_ID);
                if (applicationIdNode != null && applicationIdNode.getLength() > 0) {
                    Element applicationIdValue = (Element) applicationIdNode.item(0);
                    if (applicationIdValue != null) {
                        argApplicationId = getCharacterDataFromElement(applicationIdValue);
                    }
                }
                // End to get the applicationId
            }
        }
        /* BEGIN BZ29280 */
        if (StringUtils.isNotEmpty(originalResponse)) {

            cardType = _gsHelper.getCardType();

            virtualCreditLimit = CawGoodSamVisaHelper.VIRTUAL_CARD_CREDIT_LIMIT_DEFAULT;
            try {
                creditLimit = _cawGoodSamVisaHelper.decodevVirtualCardCreditLimit(originalResponse);
                if (creditLimit != null) {

                    virtualCreditLimit = _cawGoodSamVisaHelper
                            .makeString("_cawGoodSamNote1", _moneyFormatter.format(creditLimit, null));
                }
            } catch (Exception ex) {
                logger.error("Parse virtualCard -> creditLimit Exception: " + ex.getMessage());
            }

            apr = _cawGoodSamVisaHelper.decodeApr(originalResponse);

        }

        return new CawAdsResponse(argReturnCode, argErrorMessage, argAccountId, argApplicationId, cardType, creditLimit,
                apr, virtualCreditLimit);
        /* END BZ29280 */

    }

    /**
     * @param e
     * @return
     */
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
    /* END BZ28247 */

}