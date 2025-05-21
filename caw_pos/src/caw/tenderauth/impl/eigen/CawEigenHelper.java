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
 * BZ23265          200917    Implement issue "Create Good Sam Visa" card function
 * BZ23612          270917    Missing expiry date on the shopping pass slip
 * BZ24582          221117    Need to specify the unique terminal Station ID in the MiraServ requests
 * BZ25884          100417    [PROD] New Requirement- Display Good Sam credit application/error message on Pin Pad
 * BZ27127          220818    [PROD] Xstore throws a blank error and application will not start if pin pad certificates are missing
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ28375          231118    [2.9.4] The number of items displayed incorrect on PIN PAD when changing qty number then void line item
 * BZ28407          291118    [Internal] PINPAD doesn't show full items when item has quantity >1
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ25762          121418    New Requirement - Credit Account Look up integration in Xstore
 * BZ28741          211218    [PLCC] The selection of customer on Pin Pad Credit Approval Form doesn't persist in TRN_TRANS_P
 * BZ29419          180219    [Internal] Xstore needs to change response screen for instant credit when offline.
 * BZ29383          190219    [Internal] GS Account Inquiry form on the PinPad does not go away after selecting Back/Esc. 
 * BZ29472          210219    [Internal] Xstore handles the PLCC prescreen application status improperly. 
 * BZ29476          210219    [Internal] GS Account Payment is prompting signature on PinPad.
 * BZ29422          220219    [Internal] Existing Account Response screen is not prompted when customer has already an existing account.
 * BZ29704          120319    [PLCC Cert] Xstore displays the incorrect message for instant credit timeout
 * BZ32046          230719    [New Requirement] Ability to change text Welcome screen on Pin Pad
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import MiraServJava.MiraServJava;
import MiraServJava.MiraServJavaException;
import caw.pos.common.*;
import caw.pos.transaction.model.CawCurrentTransactionAmtModel;
import caw.pos.transaction.model.CawCurrentTransactionModel;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSInfo;

import dtv.i18n.TranslationHelper;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.i18n.DatabaseTranslationService;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

public class CawEigenHelper {

    private String gsPreScreenId;

    private String gsCreditTermNumber;

    private String gsCreditTermType;

    private String gsAPR;

    private String gsAccountId;

    private String gsAccountNumber;

    private String gsCreditLimit;

    private String ebsResponse;

    private String gsXMLEncode;         /*BZ-23612*/

    private String gsOD;                //BZ25884

    /*Begin BZ23406*/
    private String gsShoppingPassNumber;

    private String gsShoppingPassExp;
    /*End BZ-23406*/
    
    @Inject
    private DatabaseTranslationService _databaseTranslationService; /*BZ32046*/
    
    /* BEGIN BZ29476 */
    private String acPaymentSignature;

    /**
     * @return the acPaymentSignature
     */
    public String getAcPaymentSignature() {
        return acPaymentSignature;
    }

    /**
     * @param argAcPaymentSignature the acPaymentSignature to set
     */
    public void setAcPaymentSignature(String argAcPaymentSignature) {
        acPaymentSignature = argAcPaymentSignature;
    }
    /* END BZ29476 */

    private static final Logger logger                           = Logger.getLogger(CawEigenHelper.class);

    private static final String STATION_ID                       = "StationID";

    private static final String STATION_1                        = "Station_1";

    public static final String  MIRASERV_CONFIG                  = System.getProperty("caw.pos.miraserv.config") != null
            ? System.getProperty("caw.pos.miraserv.config")
            : "";                                                                                                       // BZ24582

    /*Begin BZ25884*/
    private static final String END_TAB_RETURN_CODE_FROM_EIGEN   = "</returnCode>";

    private static final String BEGIN_TAB_RETURN_CODE_FROM_EIGEN = "<returnCode>";

    private static final String EIGEN_TIME_OUT_CODE              = "03, 04, 703, 704, 707, 711, 712, 728, 810, 811";    // BZ29419

    private static final String ISO_RESPONSE_CODES               = "00, 01";                                            //BZ29472

    private static final String ISO_TIME_OUT_CODE                = "03, 04";                                            //BZ29704

    /*End BZ25884*/

    /**
     * @return the gsPreScreenId
     */
    public String getGsPreScreenId() {

        return gsPreScreenId;
    }

    /**
     * @param argGsPreScreenId the gsPreScreenId to set
     */
    public void setGsPreScreenId(String argGsPreScreenId) {

        gsPreScreenId = argGsPreScreenId;
    }

    /**
     * @return the gsCreditTermNumber
     */
    public String getGsCreditTermNumber() {

        return gsCreditTermNumber;
    }

    /**
     * @param argGsCreditTermNumber the gsCreditTermNumber to set
     */
    public void setGsCreditTermNumber(String argGsCreditTermNumber) {

        gsCreditTermNumber = argGsCreditTermNumber;
    }

    /**
     * @return the gsCreditTermType
     */
    public String getGsCreditTermType() {

        return gsCreditTermType;
    }

    /**
     * @param argGsCreditTermType the gsCreditTermType to set
     */
    public void setGsCreditTermType(String argGsCreditTermType) {

        gsCreditTermType = argGsCreditTermType;
    }

    /**
     * @return the gsAPR
     */
    public String getGsAPR() {

        return gsAPR;
    }

    /**
     * @param argGsAPR the gsAPR to set
     */
    public void setGsAPR(String argGsAPR) {

        gsAPR = argGsAPR;
    }

    /**
     * @return the gsAccountId
     */
    public String getGsAccountId() {

        return gsAccountId;
    }

    /**
     * @param argGsAccountId the gsAccountId to set
     */
    public void setGsAccountId(String argGsAccountId) {

        gsAccountId = argGsAccountId;
    }

    /**
     * @return the gsAccountNumber
     */
    public String getGsAccountNumber() {

        return gsAccountNumber;
    }

    /**
     * @param argGsAccountNumber the gsAccountNumber to set
     */
    public void setGsAccountNumber(String argGsAccountNumber) {

        gsAccountNumber = argGsAccountNumber;
    }

    /**
     * @return the gsCreditLimit
     */
    public String getGsCreditLimit() {

        return gsCreditLimit;
    }

    /**
     * @param argGsCreditLimit the gsCreditLimit to set
     */
    public void setGsCreditLimit(String argGsCreditLimit) {

        gsCreditLimit = argGsCreditLimit;
    }

    /**
     * @return the ebsResponse
     */
    public String getEbsResponse() {

        return ebsResponse;
    }

    /**
     * @param argEbsResponse the ebsResponse to set
     */
    public void setEbsResponse(String argEbsResponse) {

        ebsResponse = argEbsResponse;
    }

    /*Begin BZ25884*/
    /**
     * @return the gsOD
     */
    public String getGsOD() {

        return gsOD;
    }

    /**
     * @param argGsOD the gsOD to set
     */
    public void setGsOD(String argGsOD) {

        gsOD = argGsOD;
    }
    /*End BZ25884*/

    /*Begin BZ-23612*/
    /**
     * @return the gsXMLEncode
     */
    public String getGsXMLEncode() {

        return gsXMLEncode;
    }

    /**
     * @param argGsXMLEncode the gsXMLEncode to set
     */
    public void setGsXMLEncode(String argGsXMLEncode) {

        gsXMLEncode = argGsXMLEncode;
    }
    /*End BZ-23612*/

    /*Begin BZ-23406*/
    /**
     * @return the gsShoppingPassNumber
     */
    public String getGsShoppingPassNumber() {

        return gsShoppingPassNumber;
    }

    /**
     * @param argGsShoppingPassNumber the gsShoppingPassNumber to set
     */
    public void setGsShoppingPassNumber(String argGsShoppingPassNumber) {

        gsShoppingPassNumber = argGsShoppingPassNumber;
    }

    /**
     * @return the gsShoppingPassExp
     */
    public String getGsShoppingPassExp() {

        return gsShoppingPassExp;
    }

    /**
     * @param argGsShoppingPassExp the gsShoppingPassExp to set
     */
    public void setGsShoppingPassExp(String argGsShoppingPassExp) {

        gsShoppingPassExp = argGsShoppingPassExp;
    }
    /*End BZ-23406*/

    // Begin BZ24582
    public String getStationId() {

        String stationId = CawVoucherValue.getMiraStationID();

        if (stationId != null && !stationId.isEmpty()) {
            return stationId;
        } else {
            try {
                Ini miraservConfig = new Ini(new File(MIRASERV_CONFIG));
                stationId = miraservConfig.get(STATION_1, STATION_ID);
                if (stationId != null) {
                    stationId = stationId.substring(1, stationId.length() - 1);
                    CawVoucherValue.setMiraStationID(stationId);
                }
            } catch (InvalidFileFormatException ex) {
                logger.error("Invalid File Format Exception: " + ex.getMessage());
            } catch (IOException ex) {
                logger.error("Cannot get Station Id from configuration file: " + ex.getMessage());
            } catch (Exception ex) {
                logger.error("Cannot get Station Id from configuration file-1: " + ex.getMessage());
            }
        }
        // End BZ24582

        //Begin BZ27127
        if (stationId == null) {
            stationId = "";
        }
        //End BZ27127

        return stationId;
    }

    /*Begin BZ-BZ25884*/
    /**
     * 
     * @param genericResponseXML
     * @return
     */
    public String getReturnCodeFromMiraSevResponseXML(String genericResponseXML) {

        String returnCode = null;
        try {
            if (genericResponseXML != null && genericResponseXML.length() > 0) {
                int beginIndex = genericResponseXML.lastIndexOf(BEGIN_TAB_RETURN_CODE_FROM_EIGEN)
                        + BEGIN_TAB_RETURN_CODE_FROM_EIGEN.length();

                int endIndex = genericResponseXML.indexOf(END_TAB_RETURN_CODE_FROM_EIGEN);

                if (beginIndex < endIndex) {
                    returnCode = genericResponseXML.substring(beginIndex, endIndex);
                }
            }
        } catch (Exception ex) {
            logger.error("Can not get return code from MiraSev." + ex.getMessage());
        }

        return returnCode;

    }

    /**
     * 
     * @param returnCode
     * @return
     */
    public Boolean isProcessingOrTimeOutError(String eigenReturnCode, String adsReturnCode, String adsAuxResponseCode) { //BZ29704

        Boolean isError = Boolean.FALSE;
        if ((eigenReturnCode != null && EIGEN_TIME_OUT_CODE.contains(eigenReturnCode))
                || (CawEigenConstants.AUX_RESPONSE_CODE_200.equalsIgnoreCase(adsAuxResponseCode) //BZ29704
                        && adsReturnCode != null && ISO_TIME_OUT_CODE.contains(adsReturnCode))) {
            isError = Boolean.TRUE;
        }

        return isError;

    }
    /*End BZ-BZ25884*/

    /*Begin BZ27344*/
    /**
     * 
     * @param saleLineItem
     * @param sAmountDue
     * @param sTaxAmount
     * @param currentElement
     * @return
     */
    public CawPinpadItemModel createPinpadItemModel(CawCurrentTransactionModel currentElement, String sAmountDue,
            String sTaxAmount, CawPinpadItemModelCommand pinpadScreenCommand) {

        CawPinpadItemModel cawPinpadItemModel = new CawPinpadItemModel();
        if (currentElement != null) {

            if (StringUtils.isNotEmpty(currentElement.getItemID())) {
                cawPinpadItemModel.setItemID(currentElement.getItemID());
            }

            if (StringUtils.isNotEmpty(currentElement.getDescription())) {
                cawPinpadItemModel.setDescription(currentElement.getDescription());
            }

            if (StringUtils.isNotEmpty(currentElement.getIsVoid())) {
                cawPinpadItemModel.setIsVoid(currentElement.getIsVoid());
            }

            if (StringUtils.isNotEmpty(currentElement.getUnitPrice())) {
                cawPinpadItemModel.setUnitPrice(currentElement.getUnitPrice());
            }

            if (StringUtils.isNotEmpty(currentElement.getExtPrice())) {
                cawPinpadItemModel.setExtPrice(currentElement.getExtPrice());
            }

            if (StringUtils.isNotEmpty(currentElement.getQty())) {
                cawPinpadItemModel.setQty(currentElement.getQty());
            }

            if (StringUtils.isNotEmpty(sAmountDue)) {
                cawPinpadItemModel.setsAmountDue(sAmountDue);
            }

            if (StringUtils.isNotEmpty(sTaxAmount)) {
                cawPinpadItemModel.setsTaxAmount(sTaxAmount);
            }

            if (pinpadScreenCommand != null) {
                cawPinpadItemModel.setPinpadItemModelCommand(pinpadScreenCommand);
            }
        }

        return cawPinpadItemModel;
    }

    /**
     * 
     * @param tranLineItems
     * @return
     */
    public List<ISaleReturnLineItem> getSaleLineItemByTranLineItems(List<IRetailTransactionLineItem> tranLineItems) {

        List<ISaleReturnLineItem> saleReturnLineItems = new ArrayList<ISaleReturnLineItem>();
        if (tranLineItems != null && tranLineItems.size() > 0) {
            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof ISaleReturnLineItem) {
                    saleReturnLineItems.add((ISaleReturnLineItem) lineItem);
                }
            }
        }

        return saleReturnLineItems;
    }

    /**
     * Default the Pinpad screen can display  13 item.
     * The function gets 13 last item update price to add to Queue. 
     * @param lineItems
     * @param sAmountDue
     * @param sTaxAmount
     */
    public void addItemChangePriceToQueueSendToPinpad(List<ISaleReturnLineItem> lineItems, String sAmountDue,
            String sTaxAmount) {

        if (lineItems != null && lineItems.size() > 0) {
            /*Begin BZ28407*/
            /*Convert from list  List<ISaleReturnLineItem> lineItems to CawCurrentTransactionAmtModel _cawCurrentTransAmtModel*/
            CawCurrentTransactionAmtModel _cawCurrentTransAmtModel = new CawCurrentTransactionAmtModel();
            for (ISaleReturnLineItem iSaleReturnLineItem : lineItems) {
                CawCurrentTransactionModel model = CawCurrentTransactionModel.getNewInstance(iSaleReturnLineItem);
                _cawCurrentTransAmtModel.add(model);
            }

            ArrayList<CawCurrentTransactionModel> listItem = new ArrayList<CawCurrentTransactionModel>();
            listItem = processGroupItem(_cawCurrentTransAmtModel);

            /**
             * The Pinpad has only displayed 13 item on the screen. 
             * Therefore, the code will be got 13 last items.
             * Example formula: The transaction has 20 items need to refresh price on Pinpad screen. 
             * We only display 13 last items on the Pinpad. 
             * Number item update: 7 = 20 (total item in transaction) - 13(number of item display on Pinpad).
             * That means: We need to list item need to update in the transaction from index= 7 to index 20.
             */

            // Clear all element in Queue
            CawPinpadItemModelHelper.getInstance().clearAllElementToListNeedToSendMiraServ();
            // Add command clear Pinpad screen. 
            addElementClearToQueue();

            /**
             * The add the item to Queue.
             */

            int j = 0;
            int totalElement = listItem.size();
            if (totalElement > CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD) {
                j = totalElement - CawEigenConstants.NUMBER_OF_ITEMS_DISPLAY_PINPAD;
            }
            CawCurrentTransactionModel currentModel = null;
            CawPinpadItemModel cawPinpadItemModelTemp = null;

            /*Add 13 last items to queue*/
            for (int i = j; i < totalElement; i++) {
                currentModel = listItem.get(i);
                cawPinpadItemModelTemp = new CawPinpadItemModel();
                addCawPinpadItemModelToQueue(sAmountDue, sTaxAmount, currentModel, cawPinpadItemModelTemp);
            }
            listItem.clear();
            /*End BZ28407*/
        }
    }

    /**
     * The method add the CawPinpadItemModel to Queue before sent to MiraServ.
     */
    public void addElementClearToQueue() {

        CawPinpadItemModel cawPinpadItemModel = new CawPinpadItemModel();
        cawPinpadItemModel.setPinpadItemModelCommand(CawPinpadItemModelCommand.CLEAR_PINPAD_CURRENT_MODEL);
        CawPinpadItemModelHelper.getInstance().addElementToListNeedToSendMiraServ(cawPinpadItemModel);
    }

    /**
     * The method add the item have change price to MiraServ.
     * @param transactionScope
     */
    public void refreshPinpadScreen(TransactionScope transactionScope) {

        if (transactionScope.getTransaction(RETAIL_SALE) != null) {
            List<IRetailTransactionLineItem> tranLineItems = transactionScope.getTransaction(RETAIL_SALE)
                    .getRetailTransactionLineItems();

            IPosTransaction tranx = transactionScope.getTransaction();
            String sAmountDue = CawUtilFunction.vString(tranx.getAmountDue());
            String sTaxAmount = CawUtilFunction.vString(tranx.getTaxAmount());

            // Get all sale line item in transaction.
            List<ISaleReturnLineItem> saleReturnLineItems = null;
            if (tranLineItems != null && tranLineItems.size() > 0) {
                saleReturnLineItems = getSaleLineItemByTranLineItems(tranLineItems);
            }

            // Add sale lines item to Queue before send to the Pinpad 
            if (saleReturnLineItems != null && saleReturnLineItems.size() > 0) {
                addItemChangePriceToQueueSendToPinpad(saleReturnLineItems, sAmountDue, sTaxAmount);
            } else {
                addElementClearToQueue(); // BZ29383
            }
        }
    }

    //End BZ27344

    /* Begin BZ28407*/
    public ArrayList<CawCurrentTransactionModel> processGroupItem(CawCurrentTransactionAmtModel _cawCurrentTransModel) {

        ArrayList<CawCurrentTransactionModel> listItem = new ArrayList<CawCurrentTransactionModel>();
        BigDecimal qty = BigDecimal.ZERO;
        boolean flagDuplicateItems = false;
        if (!_cawCurrentTransModel.isEmpty()) {
            int transcurrentSize = _cawCurrentTransModel.size();
            for (int k = 0; k < transcurrentSize; k++) {
                if (!StringUtils.isEmpty(_cawCurrentTransModel.get(k).getIsVoid())) {
                    if (!Boolean.valueOf(_cawCurrentTransModel.get(k).getIsVoid())) {
                        qty = BigDecimal.ZERO;
                        flagDuplicateItems = findDuplicateItems(_cawCurrentTransModel, k);
                        if (flagDuplicateItems == false) {
                            qty = sumQtyDuplicateItems(_cawCurrentTransModel, k);
                            listItem.add(getCurrentTransactionModel(_cawCurrentTransModel.get(k).getItemID(), qty
                                    .toString(), _cawCurrentTransModel.get(k).getUnitPrice(), _cawCurrentTransModel
                                            .get(k).getExtPrice(), _cawCurrentTransModel.get(k)
                                                    .getIsVoid(), _cawCurrentTransModel.get(k).getDescription()));
                        }
                    }
                }
            }
        }
        return listItem;
    }

    /***
     * Find items duplicate in list current model
     * @param _cawCurrentTransAmtmodel model current
     * @param k is index of item in model
     * @return
     */
    public boolean findDuplicateItems(CawCurrentTransactionAmtModel _cawCurrentTransAmtmodel, int k) {

        boolean flagMutipleItems = false;
        for (int h = 0; h < k; h++) {
            if (!StringUtils.isEmpty(_cawCurrentTransAmtmodel.get(h).getIsVoid())
                    && (!Boolean.valueOf(_cawCurrentTransAmtmodel.get(h).getIsVoid()))
                    && _cawCurrentTransAmtmodel.get(h).getItemID().equals(_cawCurrentTransAmtmodel.get(k).getItemID())
                    && _cawCurrentTransAmtmodel.get(h).getUnitPrice()
                            .equals(_cawCurrentTransAmtmodel.get(k).getUnitPrice())) {

                flagMutipleItems = true;
                break;
            }
        }
        return flagMutipleItems;
    }

    /***
     * Sum quantity items duplicate in list current model
     * @param _cawCurrentTransAmtmodel model current
     * @param k is index of item in model
     * @return
     */
    public BigDecimal sumQtyDuplicateItems(CawCurrentTransactionAmtModel _cawCurrentTransAmtmodel, int k) {

        BigDecimal qtyTotal = new BigDecimal(_cawCurrentTransAmtmodel.get(k).getQty());
        for (int j = k + 1; j < _cawCurrentTransAmtmodel.size(); j++) {
            if (!StringUtils.isEmpty(_cawCurrentTransAmtmodel.get(j).getIsVoid())
                    && !Boolean.valueOf(_cawCurrentTransAmtmodel.get(j).getIsVoid())
                    && _cawCurrentTransAmtmodel.get(k).getItemID().equals(_cawCurrentTransAmtmodel.get(j).getItemID())
                    && _cawCurrentTransAmtmodel.get(k).getUnitPrice()
                            .equals(_cawCurrentTransAmtmodel.get(j).getUnitPrice())) {//this case for discount

                qtyTotal = qtyTotal.add(new BigDecimal(_cawCurrentTransAmtmodel.get(j).getQty()));
            }
        }

        return qtyTotal;
    }

    /***
     * Create new model from _cawCurrentTransAmtmodel
     * @param _cawCurrentTransAmtmodel model current
     * @param k is index of item in model
     * @param qtyTotal is sum quantity items duplicate
     * @return
     */
    public CawCurrentTransactionModel getCurrentTransactionModel(String itemId, String qty, String unitPrice,
            String extPrice, String isVoid, String description) {

        CawCurrentTransactionModel model = new CawCurrentTransactionModel();
        model.setItemID(itemId);
        model.setQty(qty);
        model.setUnitPrice(unitPrice);
        model.setExtPrice(extPrice);
        model.setIsVoid(isVoid);
        model.setDescription(description);
        return model;
    }

    /**
     * @param sAmountDue
     * @param sTaxAmount
     * @param currentModel
     * @param cawPinpadItemModelTemp
     */
    public void addCawPinpadItemModelToQueue(String sAmountDue, String sTaxAmount,
            CawCurrentTransactionModel currentModel, CawPinpadItemModel cawPinpadItemModelTemp) {

        /*Begin BZ28375*/
        try {
            if (currentModel != null) {
                if (!StringUtils.isEmpty(currentModel.getIsVoid())) {
                    boolean isVoid = Boolean.valueOf(currentModel.getIsVoid());
                    if (!isVoid) {
                        cawPinpadItemModelTemp.setItemID(currentModel.getItemID());
                        cawPinpadItemModelTemp.setIsVoid(currentModel.getIsVoid());
                        cawPinpadItemModelTemp.setExtPrice(currentModel.getExtPrice());
                        cawPinpadItemModelTemp.setUnitPrice(currentModel.getUnitPrice());
                        cawPinpadItemModelTemp.setDescription(currentModel.getDescription());
                        cawPinpadItemModelTemp.setQty(currentModel.getQty());
                        cawPinpadItemModelTemp.setsAmountDue(sAmountDue);
                        cawPinpadItemModelTemp.setsTaxAmount(sTaxAmount);

                        cawPinpadItemModelTemp
                                .setPinpadItemModelCommand(CawPinpadItemModelCommand.ADD_PINPAD_CURRENT_MODEL);

                        CawPinpadItemModelHelper.getInstance()
                                .addElementToListNeedToSendMiraServ(cawPinpadItemModelTemp);
                    }
                }
            }

        } catch (Exception ex) {
            logger.debug("Can not add the CawPinpadItemModel to Queue." + ex.getMessage());
        }
        /*End BZ28375*/
    }
    /*End BZ28407*/

    /**
     * BZ25761
     * @param argSource
     * @return
     */
    public boolean checkDuplicate(String argSource) {

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
                        .compile(CawEigenConstants.XML_ACCOUNT_SUMMARY_PATTERN, Filters.element());
                List<Element> links = expr.evaluate(doc);
                if (links != null && !links.isEmpty()) {
                    return true;
                }

            } catch (JDOMException | IOException ex) {
                logger.error("The function decode expiry date have error." + ex.getMessage());
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
        return false;
    }

    /**
     * BZ-23612, BZ25761
     * @param argSource
     * @return
     */
    public String decodeExpiryDate(String argSource) {

        String expDate = "";
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
                        .compile(CawEigenConstants.XML_EXP_DATE_PATTERN, Filters.element());
                List<Element> links = expr.evaluate(doc);
                if (links != null && !links.isEmpty()) {
                    expDate = links.get(0).getValue();
                }
            } catch (JDOMException | IOException ex) {
                logger.error("The function decode expiry date have error." + ex.getMessage());
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
        return expDate;
    }

    /* BEGIN BZ25761, BZ25762 */
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
                    if (type.equals(CawConstants.VISA_SHORT)) { /*BZ28741: changed VISA to VISA_SHORT*/
                        cardType = 1;
                    } else if (type.equals(CawConstants.PLCC_SHORT)) { /*BZ28741: changed VISA to VISA_SHORT*/
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
    /* END BZ25761, BZ25762 */

    /* BEGIN BZ29472 */
    /**
     * The method check status of response of Prescreen or Instant Credit.
     * @param msj
     * @return
     */
    public boolean isADSApproved(MiraServJava msj) {

        Boolean isApproved = Boolean.FALSE;
        if (msj != null) {
            try {
                if (CawEigenConstants.EIGEN_APPROVE.equals(msj.GetTField(CawEigenConstants.FN_ACTION_CODE))) {
                    String isoResponseCode = msj.GetTField(CawEigenConstants.FN_ISO_RESPONSE_CODE);

                    if (isoResponseCode != null && ISO_RESPONSE_CODES.contains(isoResponseCode)) {
                        isApproved = Boolean.TRUE;
                    }
                }
            } catch (MiraServJavaException ex) {
                logger.info("Can not get Field from Eigen response." + ex.getMessage());
            }
        }

        return isApproved;
    }
    /* END BZ29472 */

    /* BEGIN BZ29422 */
    /**
     * The function check account have exists on ADS.
     *  
     * @param argMiraServResponse
     * @return
     */
    public boolean isAccountDuplicate(CawCustomerGSInfo cawCustomerGSInfo) {

        Boolean isExists = Boolean.FALSE;
        try {
            if (cawCustomerGSInfo != null) {
                if (CawConstants.CAW_ACCOUNT_SUMMARY.equalsIgnoreCase(cawCustomerGSInfo.getAccountResponseType())) {
                    isExists = Boolean.TRUE;
                }

            }
        } catch (Exception ex) {
            logger.info("Can not get field 'accountSummary'from ADS." + ex.getMessage());
        }

        return isExists;
    }
    /* END BZ29422 */
    
    /*BEGIN BZ32046*/
    public String getWelcomeMessage() {
        ICodeValue translationKey = CodeLocator.getCodeValue(ConfigurationMgr
                .getOrganizationId(), CawEigenConstants.PIN_PAD, CawEigenConstants.WELCOME_MESSAGE);

        String welcomeMessage = " ";
        if(translationKey != null) {
            welcomeMessage = translationKey.getDescription();
            if(TranslationHelper.getInstance().isDatabaseTranslationKey(translationKey.getDescription())) {
                welcomeMessage = _databaseTranslationService
                        .getTranslation(Locale.US, translationKey.getDescription(), ConfigurationMgr
                                .getOrganizationId());
            }
        }
        return welcomeMessage;
    }
    /*END BZ32046*/

}
