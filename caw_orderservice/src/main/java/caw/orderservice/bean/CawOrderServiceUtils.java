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
 * BZ23591              270917    Add channelType in Customer Update and Order Service
 * BZ24352              031117    [OrderService] Customers sent with the orders are incomplete...customer data returned from a lookup service call is not what’s being supplied when the order is submitted
 * BZ24395              081117    [OrderService]Paid In & Paid Out transactions in order_service.out
 * BZ24658              011217    [OrderService]Serialized items are not passed to Order Service
 * BZ24905              211217    [OrderService] Pull 0600 item attributes to order service
 * BZ24886              250118    [PROD] Memberships Sold with No Customer in EBS
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ25558              100418    New Requirement - Return Reason Codes Not Flowing to EBS
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ26308              210518    Item properties displays incorrect in order service log when item has different prompt property.
 * BZ26602              100718    Order Service Error with resulted in 400 (The request does not contain a valid OrderPutRequest object.)
 * BZ26207              250718    New Requirement - Enable Work Order Functionality
 * BZ26955              300718    [Interim 1.6.1] - Work Order transaction failed to post via Order Service
 * BZ27067              060818    [1.6.3] WO transactions do not flow to Order Service
 * BZ27584              190918    [PROD] Xstore return does not reference the original transaction in Order Service
 * BZ27712              121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ29123              210119    Port 28987 to Release 3.0: Xstore needs to submit the PO Number in the Order Service for A/R and Third Party Tenders
 * BZ29049              210119    [Internal] Incorrect PO information in Order Service for A/R and Third Party Tenders during even exchanges
 * BZ29204              250119    [Port 29171 to release 3.0] PurchaseOrder attribute is set value incorrectly in case no data inputted PO information when using Third Party/A/R tender
 * BZ29391              140219    [Internal] PLCC payment generates a 400 error.
 * BZ27535              250619    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ29668              200619    [Internal] OS Logging the transaction output to database table journal
 * BZ32434              120819    [Prod] Oracle Return Issue: showing a positive listing price
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ38176              300920    [Internal] - The request of information Pickup storeâ€™s address (shipToInfo) is sent Incorrectly when create Order transaction in case the customer selects multiple pick-up stores
 * BZ38841              221020    [Internal] - The request of Order is sent Incorrectly when executing Mixed Sale transaction and Order transaction
 * BZ40798              240221    Modification to member savings calculation 
 * BZ42198              260321    Error Converting Value-OS Error 
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ45907              250821    [Internal] Order Service issue - ERROR CawOrderServiceApp:708 - Error in sendRequestToESB-1
 * BZ45903              250821    [Internal] Order Service - brokerItemDetail is incorrect if transaction included two same items but one is a sale item and one from EW order
 * BZ44917              110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ48359              250122    [PROD] Multiple transactions getting rejected by neuron
 * BZ48320              220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 * BZ50835              300622    [Order Service] Loyalty - OS request has error when making a Sales transaction with a customer has loyalty
 * BZ51771              191022    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service.
 * BZ52349              201022    [Internal][Order Service] Loyalty - OS request include the error detail in customer tag when making Sale with customers belonging to GSAM Club without Loyalty.
 * BZ53108              021122    [UAT] Pricing/Membership Issue      
 * BZ53798              241122    [UAT] Offline POS transactions are not reaching to CD
 * BZ61159              160124    [New Requirement] - Xstore AGIS Replacement
 * BZ63054              080424    [API Change] - Format of the Submit Order API response is changed.
 *== ================================================================
 */

package caw.orderservice.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

import caw.orderservice.common.CawJSONUtils;
import caw.orderservice.constant.CawCommonConstant;
import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawPKeyConstant;
import caw.orderservice.constant.CawPValueConstant;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.constant.CawWSTemplateConstant;
import caw.orderservice.cron.bean.CawOrderServiceTasks;
import caw.orderservice.helper.CawBrokeredOrderHelper;
import caw.orderservice.helper.CawOrderTypeEnum;
import caw.orderservice.model.CawAddressModel;
import caw.orderservice.model.CawAdjustmentsModel;
import caw.orderservice.model.CawAttributesModel;
import caw.orderservice.model.CawBrokeredOrderLineModel;
import caw.orderservice.model.CawCashierModel;
import caw.orderservice.model.CawCheetahTokenModel;
import caw.orderservice.model.CawCustomerModel;
import caw.orderservice.model.CawItemModel;
import caw.orderservice.model.CawNameModel;
import caw.orderservice.model.CawPaidInOutDetail;
import caw.orderservice.model.CawPropertiesModel;
import caw.orderservice.model.CawSalesPersonModel;
import caw.orderservice.model.CawShipToInfoModel;
import caw.orderservice.model.CawTenderModel;
import caw.orderservice.model.CawTheOrderModel;
import caw.orderservice.model.CawTransactionModel;
import caw.orderservice.model.CawWorkOrderDetail;
import caw.orderservice.rest.CawOrderServiceRestUtils;
import caw.orderservice.utils.CawPropertiesConfig;
import caw.orderservice.utils.CawUtils;
import dtv.i18n.IFormattable;
import dtv.util.NumberUtils;
import dtv.util.StringUtils;
import dtv.util.ThreadSafeFormat;
import dtv.util.crypto.DtvDecrypter;
import oracle.sql.CLOB;
import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

public class CawOrderServiceUtils {
    private static final Logger logger             = Logger.getLogger(CawOrderServiceUtils.class);

    private static final Format REP_DATE_FORMATTER = ThreadSafeFormat.getDateInstance("yyyyMMddHHmmssSSS"); /*BZ29668*/
    
    /**
     * @param fileName
     * @return
     */
    /* BEGIN BZ37463 */
    public static String readRequestTemplate(String fileName) {

        InputStream stream = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            stream = CawOrderServiceUtils.class.getClassLoader()
                    .getResourceAsStream(fileName);
            logger.debug(stream);
            br = new BufferedReader(new InputStreamReader(stream));
            while ((line = br.readLine()) != null) {
                sb.append(line).append(CawCommonConstant.NEW_LINE);
            }
            return sb.toString();
        } catch (Exception e) {
            logger.error("Could not get request template" + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error("Can not close buffered reader-1! "
                            + e.getMessage());
                }
            }
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    logger.error("Can not close buffered reader-2! "
                            + e.getMessage());
                }
            }
        }
        return null;
    }
    /* END BZ37463 */

    //Begin BZ24395
    /**
     * Generate JSON buffer of Order Request
     * @param template
     * @param fileName
     * @param accountNumber
     * @param customerOffline
     * @param conn
     * @return
     */
    public static String getOrderServiceRequest(Connection conn,
            CawTransactionModel model, String customerOffline) {

        CawTheOrderModel theOrdModel = model.getOrderModel();
        String jsonCustomerApplyNow = null;
        String result = null;
        try {
            /* BEGIN BZ37463 */
            if (CawOrderTypeEnum.BROKERED_ORDER_STATUS.equals(CawBrokeredOrderHelper.getInstance().isTransactionOrderTyle(model))) {
                /*BEGIN BZ48320*/
                if(model.getBrokeredOrderModel().isVinTrans() == true && CawBrokeredOrderHelper.getInstance().isVinOrderLine(model)) {
                    // BUILD Request for the order VIN trans
                    result = CawBrokeredOrderHelper.getInstance().sendOrderCapture(theOrdModel, model);
                }
                /*END BZ48320*/
                else {
                    // BUILD MESSAGE FOR THE ORDER STATUS
                    // accept/reject, pick/reserve
                    result = CawBrokeredOrderHelper.getInstance().sendNotifyOrderStatus(theOrdModel, model);
                }
            } else if (model.getBrokeredOrderModel() != null) {

                if (CawOrderTypeEnum.BROKERED_ORDER_STATUS.equals(CawBrokeredOrderHelper.getInstance().isTransactionOrderTyle(model))) {
                    result = CawBrokeredOrderHelper.getInstance().sendNotifyOrderStatus(theOrdModel, model);
                } else {
                    // create, cancel, complete order
                    result = CawBrokeredOrderHelper.getInstance().buildOrderBrokerServiceRequest(conn, model, customerOffline);
                }
                /* END BZ37463 */
            } else {
                String originalTempBuff = readRequestTemplate(CawWSTemplateConstant.ORDER_SERVICE_TEMPLATE);
                if (originalTempBuff != null && originalTempBuff.length() > 0) {
                    result = String.valueOf(originalTempBuff);
                    result = result
                            .replace(CawWSTemplateConstant.ID_SALE_CHANEL_ATTR, theOrdModel
                                    .getSalesChannel().getId().toString());
                    result = result
                            .replace(CawWSTemplateConstant.TERMINAL_ATTR, theOrdModel
                                    .getSalesChannel().getTerminal().toString());
                    result = result
                            .replace(CawWSTemplateConstant.CHANNEL_TYPE_ATTR, theOrdModel
                                    .getSalesChannel().getChannelType().toString()); // BZ23591
                    //BEGIN BZ63054
                    result = result
                            .replace(CawWSTemplateConstant.CHANNEL_TYPE_DES, theOrdModel
                                    .getSalesChannel().getChannelTypeDescription()); 
                    
                    result = result
                            .replace(CawWSTemplateConstant.PHYSICAL_INFO, CawCommonConstant.NULL_STRING); 
                    
                    result = result
                            .replace(CawWSTemplateConstant.SALES_CHANNEL_CONFIG_ATTR, CawCommonConstant.NULL_STRING); 
                    //END BZ63054
                    result = result
                            .replace(CawWSTemplateConstant.ORDER_TYPE_ATTR, CawPropertiesConfig
                            .get(theOrdModel.getOrderType()));//BZ23591, BZ48630
                    
                    //Begin BZ26207
                    if (theOrdModel.getWorkOrderDetail() != null) {
                        result = result
                                .replace(CawWSTemplateConstant.WORK_ORDER_DETAIL_ATTR, getWorkOrderRequest(theOrdModel
                                        .getWorkOrderDetail(), CawWSTemplateConstant.WORK_ORDER_DETAIL_TEMPLATE));
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.WORK_ORDER_DETAIL_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    //End BZ26207
                    if (theOrdModel.getPaidInOutDetail() != null) {
                        result = result
                                .replace(CawWSTemplateConstant.PAID_IN_OUT_DETAIL_ATTR, getPaidInOutRequest(theOrdModel
                                        .getPaidInOutDetail(), CawWSTemplateConstant.PAID_IN_OUT_DETAIL_TEMPLATE));
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.PAID_IN_OUT_DETAIL_ATTR, CawCommonConstant.NULL_STRING);
                    }
    
                    result = result
                            .replace(CawWSTemplateConstant.ID_ORDER_ATTR, theOrdModel
                                    .getId().toString());
                    result = result
                            .replace(CawWSTemplateConstant.CORRELATION_KEY_ATTR, formatParameter(theOrdModel
                                    .getCorrelationKey()));
    
                    //CASHIER INFO
                    if (theOrdModel.getCashier() != null) {
                        result = result
                                .replace(CawWSTemplateConstant.CASHIER_ATTR, getCashierRequest(theOrdModel
                                        .getCashier(), CawWSTemplateConstant.CASHIER_TEMPLATE));
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.CASHIER_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    
                    //Start BZ48630, BZ53798 - check length of begin date from query, in case < 23, it mean format is hh:mm:ss instead of hh:mm:ss.sss
                    if(theOrdModel.getOrderDate().length() < 23) {
                        theOrdModel.setOrderDate(theOrdModel.getOrderDate().concat(".000"));
                    }
                    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    Date d = sdf.parse(theOrdModel.getOrderDate());
                    result = result
                            .replace(CawWSTemplateConstant.ORDER_DATE_ATTR, formatParameter(output.format(d)));
                    //End BZ48630, BZ53798
                    
                    result = result
                            .replace(CawWSTemplateConstant.ORDER_TOTAL_WITH_TAX_ATTR, String
                                    .valueOf(theOrdModel.getOrderTotalWithTax()));
                    //CUSTOMER
                    if (theOrdModel.getCustomer() != null
                            && theOrdModel.getCustomer().getPartyId() != null) {
                        //Begin BZ24352
                        if (customerOffline != null
                                && customerOffline.length() > 0) {
                            //Step1: OFFLINE Forced from parent method
                            //BEGIN BZ53108
                            customerOffline = getMembershipFromDB(conn, model.getPartyId())!="" ? customerOffline.replace("\"memberships\":null", "\"memberships\":" + getMembershipFromDB(conn, model.getPartyId())) : customerOffline ;
                            customerOffline = getPricingFromDB(conn, model.getPartyId())!="" ? customerOffline.replace("\"pricing\":null", "\"pricing\":" + getPricingFromDB(conn, model.getPartyId())) : customerOffline ;
                            jsonCustomerApplyNow = customerOffline;
                            //END BZ53108
                        } else {
                            //Step2: ONLINE Forced
                            if (model.getAccountNumber() > 0) {
                                try {
                                    String accountNumber = String
                                            .valueOf(model.getAccountNumber());
                                    jsonCustomerApplyNow = lookUpCustomer(accountNumber, model.getStoreID()); /*BZ27535: add parameters*/
                                    //Start BZ50835
                                    if(!jsonCustomerApplyNow.isEmpty()) {
                                        JSONObject jsonCustomerFormEbs = new JSONObject(jsonCustomerApplyNow);
                                        if(jsonCustomerFormEbs.has(CawCommonConstant.JSON_CUSTOMER)) {
                                            jsonCustomerApplyNow = jsonCustomerFormEbs.getString(CawCommonConstant.JSON_CUSTOMER);
                                        }
                                    }
                                    //End BZ50835
                                } catch (Exception e) {
                                    logger.error("getOrderServiceRequest-1: "
                                            + e.getMessage());
                                    /*if any err when hand shake with ESB order 
                                    * to lookup account, then Template customer is used.
                                    * Go to step3
                                    * */
                                }
                            }
    
                            //Step3: CHECK IF IT IS NOT FOUND OR OFFLINE AGAIN
                            if (jsonCustomerApplyNow == null
                                    || jsonCustomerApplyNow.length() == 0) {
                                //Begin 26602
                                try {
                                    JSONObject template = CawOrderServiceCustomerTemplate
                                            .buildCustomerTemp(conn, model
                                                    .getCustModel(), model
                                                            .getPartyId(), model
                                                                    .getAccountNumber(), model
                                                                            .getCustomerType(), model
                                                                                    .getEmailAddress(), model
                                                                                            .getStoreID());
                                    if (template != null) {
                                        model.setCustomerTemplate(template);
                                        jsonCustomerApplyNow = template.toString();
                                    }
                                } catch (Exception e) {
                                    logger.error("getOrderServiceRequest-2: "
                                            + e.getMessage());
                                }
                                //End 26602
                            }
                        }
                        //End BZ24352
                    }
                    if (jsonCustomerApplyNow != null
                            && jsonCustomerApplyNow.length() > 0) {
                        result = result
                                .replace(CawWSTemplateConstant.CUSTOMER_ATTR, jsonCustomerApplyNow);
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.CUSTOMER_ATTR, CawCommonConstant.NULL_STRING);
                    }
    
                    //SHIPTO ADDRESS
                    if (theOrdModel.getShipToInfo() != null) {
                        String shipToInfo = getShipToInfoRequest(theOrdModel
                                .getShipToInfo(), CawWSTemplateConstant.SHIP_TO_INFO_TEMPLATE);
                        if (shipToInfo != null && shipToInfo.length() > 0) {
                            result = result
                                    .replace(CawWSTemplateConstant.SHIP_TO_INFO_ATTR, shipToInfo);
                        } else {
                            result = result
                                    .replace(CawWSTemplateConstant.SHIP_TO_INFO_ATTR, CawCommonConstant.NULL_STRING);
                        }
    
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.SHIP_TO_INFO_ATTR, CawCommonConstant.NULL_STRING);
                    }
    
                    //ITEMS
                    String itemRequest = getItemsRequest(theOrdModel, CawWSTemplateConstant.ITEMS_TEMPLATE, model);
                    if (itemRequest != null) {
                        result = result
                                .replace(CawWSTemplateConstant.ITEMS_ATTR, itemRequest);
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.ITEMS_ATTR, CawCommonConstant.NULL_STRING);
                    }
    
                    //TENDERS
                    String tenderRequest = getTendersRequest(theOrdModel, CawWSTemplateConstant.TENDERS_TEMPLATE);
                    if (tenderRequest != null) {
                        result = result
                                .replace(CawWSTemplateConstant.TENDERS_ATTR, tenderRequest);
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.TENDERS_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    //Begin BZ29049
                    //Begin BZ29123
                    result = result
                            .replace(CawWSTemplateConstant.PURCHASE_ORDER_ATTR, formatParameter(purchaseOrderTemplate(theOrdModel)));
                    //End BZ29123
                    //End BZ29049
                    //RECEIPT TYPE
                    
                    result = result
                            .replace(CawWSTemplateConstant.RECEIPT_TYPE_ATTR, CawPropertiesConfig
                            .get(theOrdModel.getReceiptType())); //BZ48630
                    /*BEGIN BZ63054*/
                    result = result
                            .replace(CawWSTemplateConstant.RECEIPT_TYPE_ATTR_DESCRIPTION_ATTR, theOrdModel.getReceiptType()); // BZ63054
                    result = result
                            .replace(CawWSTemplateConstant.E_RECEIPT_EMAIL_ATTR, formatParameter(theOrdModel
                                    .getEReceiptEmail()));
                    /*END BZ63054*/
                    result = result
                            .replace(CawWSTemplateConstant.E_RECEIPT_EMAIL_ATTR, formatParameter(theOrdModel
                                    .getEReceiptEmail()));
    
                    //ATTRUBUTE FIELDS
                    /* BEGIN BZ40798 */
                    CawAttributesModel theAttrModel = theOrdModel.getAttributes();
                    String attRequest = getGoodSamSavingAttribute(theAttrModel);
                    if (attRequest != null) {
                        String attributes = CawWSTemplateConstant.ATTRIBUTES_TEMPLATE;
                        attributes = attributes.replace(CawWSTemplateConstant.ATTRIBUTES_GOOD_SAM_SAVINGS, CawOrderServiceUtils.formatNullString(theAttrModel.getGoodSamSavings())); // Null = "0.00"
                        attributes = attributes.replace(CawWSTemplateConstant.ATTRIBUTES_COULD_SAVE, CawOrderServiceUtils.formatNullString(theAttrModel.getCouldSave())); // Null = "0.00"
                        /*BEGIN BZ44528*/
                        if(!StringUtils.isEmpty(theAttrModel.getCartIDs())) {
                            JSONObject jsonAttributes = new JSONObject(attributes);
                            jsonAttributes.put(CawCommonConstant.ATTRIBUTES_CARTIDS, theAttrModel.getCartIDs());
                            result = result.replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, jsonAttributes.toString());
                        }
                        /*BEGIN BZ44917*/
                        if (theAttrModel.getRvPaymentAmount() != null && theAttrModel.getRvPaymentAmount().compareTo(BigDecimal.ZERO) != 0) {/*BZ48359*/
                            JSONObject jsonAttributes = new JSONObject(attributes);
                            jsonAttributes.put(CawCommonConstant.ATTRIBUTES_RV_PAYMENT_AMOUNT, String.valueOf(theAttrModel.getRvPaymentAmount()));
                            result = result.replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, jsonAttributes.toString());
                        }
                        /*END BZ44917*/
                        else {
                            result = result.replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, attributes);
                        }
                        /*END BZ44528*/
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    /* END BZ40798 */
                    
                    //BEGIN BZ51771
                    try {
                        String loyatyDetailTemplate = model.getOrderModel().getLoyatyDetail();
                        logger.debug("[loyatyDetailTemplate from DB]: " + loyatyDetailTemplate);
                        
                        if(loyatyDetailTemplate != null && !loyatyDetailTemplate.isEmpty()) {
                            JSONObject jsonObject = new JSONObject(loyatyDetailTemplate);
                            if(jsonObject.has(CawWSTemplateConstant.LOYALTY_DETAILS_FIELD_NAME) && !jsonObject.isNull(CawWSTemplateConstant.LOYALTY_DETAILS_FIELD_NAME)) {
                                result = result.replace(CawWSTemplateConstant.LOYALTY_DETAILS, jsonObject.getString(CawWSTemplateConstant.LOYALTY_DETAILS_FIELD_NAME));
                                logger.debug("[result loyatyDetailTemplate replace from DB]: " + result);
                            } else {
                                result = result.replace(CawWSTemplateConstant.LOYALTY_DETAILS, CawCommonConstant.NULL_STRING);
                            }
                        } else {
                            result = result.replace(CawWSTemplateConstant.LOYALTY_DETAILS, CawCommonConstant.NULL_STRING);
                        }
                        
                    } catch (Exception e) {
                        logger.error("[Error when replace loyatyDetailTemplate to request]: "+ e.getMessage());
                    }
                    
                    //END BZ51771
                    
                    //BEGIN BZ63054
                    result = result.replace(CawWSTemplateConstant.THIRD_PARTY_PAYER_ATTR, CawCommonConstant.NULL_STRING); 
                    result = result.replace(CawWSTemplateConstant.CONTACT_PHONE, CawCommonConstant.NULL_STRING);
                    //END BZ63054
                }
          }
        } catch (Exception e) {
            logger.error("Error in getOrderServiceRequest-1: " + e.getMessage());
        }
        
        //BEGIN BZ61159
        try {
            String pitchesInfoTemplate = model.getOrderModel().getPitchesInfo();
            logger.debug("[pitchesInfoTemplate from DB]: " + pitchesInfoTemplate);
            if (pitchesInfoTemplate != null && !pitchesInfoTemplate.isEmpty()) { //Update Pitches in customer template
                JSONObject resultJson = new JSONObject(result);
                if(resultJson.has(CawWSTemplateConstant.THE_ORDER_ATTR_NAME) && !resultJson.isNull(CawWSTemplateConstant.THE_ORDER_ATTR_NAME)) {
                    JSONObject orderJson = resultJson.getJSONObject(CawWSTemplateConstant.THE_ORDER_ATTR_NAME);
                    if(orderJson.has(CawCommonConstant.JSON_CUSTOMER) && !orderJson.isNull(CawCommonConstant.JSON_CUSTOMER)) {
                        JSONObject customerJson = orderJson.getJSONObject(CawCommonConstant.JSON_CUSTOMER);
                        if(customerJson.has(CawWSTemplateConstant.PITCHES_INFO_FIELD_NAME) && !customerJson.isNull(CawWSTemplateConstant.PITCHES_INFO_FIELD_NAME)) {
                            JSONArray pitchesInfoTemplateJsonArray = new JSONArray(pitchesInfoTemplate);
                            customerJson.put(CawWSTemplateConstant.PITCHES_INFO_FIELD_NAME, pitchesInfoTemplateJsonArray);
                            logger.debug("[result pitchesInfoTemplate replace from DB]: " + customerJson.toString());
                        }
                    }
                }
                result = resultJson.toString();
            }
        } catch (Exception e) {
            logger.error("[Error when replace pitchesInfoTemplate to request]: "+ e.getMessage());
        }
        //END BZ61159
        logger.debug("[result pitchesInfoTemplate replace from DB - final]: " + result);
        return result;
    }

    //End BZ24395
    /**
     * @param paidInOutDetail
     * @param fileName
     * @return
     */
    public static String getPaidInOutRequest(CawPaidInOutDetail paidInOutDetail,
            String fileName) {

        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            //24418 required, example 'PO12' => '12'
            String code = CawUtils.getInstance()
                    .substring(paidInOutDetail.getCode(), 2);
            result = String.valueOf(originalTempBuff);
            result = result
                    .replace(CawWSTemplateConstant.CODE_PAIDINOUT_ATTR, formatParameter(code));
            result = result
                    .replace(CawWSTemplateConstant.DESCRIPTION_PAIDINOUT_ATTR, formatParameter(paidInOutDetail
                            .getDescription()));
        }
        return result;
    }

    //Begin BZ26207
    /**
     * @param cawWorkOrderDetail
     * @param fileName
     * @return
     */
    public static String getWorkOrderRequest(
            CawWorkOrderDetail cawWorkOrderDetail, String fileName) {

        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            result = String.valueOf(originalTempBuff);
            result = result
                    .replace(CawWSTemplateConstant.WORK_ORDER_ID, formatParameter(cawWorkOrderDetail
                            .getId()));
            result = result
                    .replace(CawWSTemplateConstant.WORK_ORDER_STATUS, cawWorkOrderDetail
                            .getPosStatus());
        }
        return result;
    }

    //End Begin BZ26207
    /**
     * @param itm
     * @param fileName
     * @return
     */
    public static String getAdjustmentsRequest(CawItemModel itm,
            String fileName) {

        StringBuilder sbAdjustment = new StringBuilder();
        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            String templateRequest = null;
            if (itm.getAdjustments() != null
                    && itm.getAdjustments().size() > 0) {
                sbAdjustment.append("[");
                for (CawAdjustmentsModel adj : itm.getAdjustments()) {
                    templateRequest = String.valueOf(originalTempBuff);
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.CORRELATION_KEY_ATTR, formatParameter(adj
                                    .getCorrelationKey()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.TYPE_ATTR, CawPropertiesConfig
                                    .get(adj.getType()));   //BZ48630
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.AMOUNT_ATTR, String
                                    .valueOf(adj.getAmount()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.COUPON_CODE_ATTR, formatParameter(adj
                                    .getCouponCode()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.SERIALIZED_COUPON_ATTR, formatParameter(adj
                                    .getSerializedCoupon()));

                    sbAdjustment.append(templateRequest);
                    sbAdjustment.append(",");
                }
                result = sbAdjustment.substring(0, sbAdjustment.length() - 1);
                if (result != null) {
                    result = result + "]";
                }
            }
        }
        return result;
    }
    /* BEGIN BZ37463 */
    /**
     * @param model
     * @param shipModel
     * @param itemModel
     * @return
     */
    public static boolean isShippingItem(CawTransactionModel model,
            CawShipToInfoModel shipModel, CawItemModel itemModel) {

        boolean isShippingItem = true;

        if (model != null && model.getBrokeredOrderModel() != null
                && model.getBrokeredOrderModel().getCawBrokeredOrderLineModel() != null
                && model.getBrokeredOrderModel().getCawBrokeredOrderLineModel().size() > 0
                && shipModel != null) {
            List<CawBrokeredOrderLineModel> orderLineModels = model
                    .getBrokeredOrderModel().getCawBrokeredOrderLineModel();
            for (CawBrokeredOrderLineModel orderLineModel : orderLineModels) {
                if (orderLineModel != null && itemModel != null
                        && itemModel.getCode() != null 
                        && itemModel.getCode().equals(orderLineModel.getItemId())) {
                    shipModel.setShipVia(orderLineModel.getShippingMethodDes());
                    shipModel.setServiceLevel(orderLineModel.getShippingMethod());
                    isShippingItem = false;
                    break;
                }
            }
        } else {
            isShippingItem = false;
        }
        
        return isShippingItem;

    }

    /* END BZ37463 */
    /**
     * @param template
     * @param fileName
     * @return
     */
    public static String getItemsRequest(CawTheOrderModel theOrdModel,
            String fileName, CawTransactionModel model) {

        StringBuilder sbItem = new StringBuilder();
        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            String templateRequest = null;
            List<CawItemModel> itmLst = theOrdModel.getItems();
            if (itmLst != null && itmLst.size() > 0) {
                String adjRequest = null;
                String proRequest = null;
                String salePersonRequeset = null;
                String attrRequest = null;
                
                sbItem.append("[");
                for (CawItemModel itm : itmLst) {
                    templateRequest = String.valueOf(originalTempBuff);
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.CORRELATION_KEY_ATTR, formatParameter(itm
                                    .getCorrelationKey()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.CODE_ATTR, formatParameter(itm
                                    .getCode()));
                    salePersonRequeset = getSalePersonRequest(itm
                            .getSalesPerson());
                    if (salePersonRequeset != null) {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.SALES_PERSON_ATTR, salePersonRequeset);
                    } else {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.SALES_PERSON_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.QUANTITY_ATTR, String
                                    .valueOf(itm.getQuantity()));

                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.UNIT_OF_MEASURE_ATTR, CawPropertiesConfig
                                    .get(itm.getUnitOfMeasure())); //BZ48630
                    
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.UNIT_LIST_PRICE_ATTR, String
                                    .valueOf(itm.getUnitListPrice()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.UNIT_SELLING_PRICE_ATTR, String
                                    .valueOf(itm.getUnitSellingPrice()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.TAX_CODE_ATTR, formatParameter(itm
                                    .getTaxCode()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.TAX_AMOUNT_ATTR, String
                                    .valueOf(itm.getTaxAmount()));
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.LINE_TOTAL_ATTR, String
                                    .valueOf(itm.getLineTotal()));
                    //Begin BZ25860
                    templateRequest = templateRequest
                            .replace(CawWSTemplateConstant.IS_RETURN_ATTR, String
                                    .valueOf(itm.isReturn()));
                    //End BZ25860
                    adjRequest = getAdjustmentsRequest(itm, CawWSTemplateConstant.ADJUSTMENTS_TEMPLATE);
                    if (adjRequest != null) {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.ADJUSTMENTS_ATTR, adjRequest);
                    } else {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.ADJUSTMENTS_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    
                    /* BEGIN BZ37463 */
                    // BUILD SHIPPING INFO
                    //SHIPTO ADDRESS                   
                    if (model.getBrokeredOrderModel() != null) {
                        /* BEGIN BZ38176 */
                        CawShipToInfoModel shipToInfoModel = CawBrokeredOrderHelper
                                .getInstance()
                                .getShippingInfo(itm, model
                                        .getBrokeredOrderModel()
                                        .getCawBrokeredOrderLineModel(), model
                                                .getBrokeredOrderModel()
                                                .getShipToInfoModels());
                        /* END BZ38176 */
                        boolean isShippingItem = false;
                        
                        if (shipToInfoModel != null) {
                            isShippingItem = isShippingItem(model, shipToInfoModel, itm);
                        }

                        String shipToInfo = getShipToInfoRequest(shipToInfoModel, CawWSTemplateConstant.SHIP_TO_INFO_TEMPLATE);
                        // IF SHIPPING ITEM, SET SHIPPING INFO IS NULL
                        if (isShippingItem) {
                            shipToInfo = null;
                        }

                        if (shipToInfo != null && shipToInfo.length() > 0) {
                            templateRequest = templateRequest.replace(CawWSTemplateConstant.SHIP_TO_INFO_ATTR, shipToInfo);
                        } else {
                            templateRequest = templateRequest.replace(CawWSTemplateConstant.SHIP_TO_INFO_ATTR, CawCommonConstant.NULL_STRING);
                        }

                        // BUILD BROKER DETAIL
                        String brokerItemDetail = getBrokerItemDetail(itm, shipToInfoModel, model, CawWSTemplateConstant.BROKER_DETAIL_TEMPLATE);// BZ38176
                        
                        if (!StringUtils.isEmpty(brokerItemDetail)) {
                            templateRequest = templateRequest.replace(CawWSTemplateConstant.BROKER_ITEM_DETAIL, brokerItemDetail);
                        } else {
                            templateRequest = templateRequest.replace(CawWSTemplateConstant.BROKER_ITEM_DETAIL, CawCommonConstant.NULL_STRING);
                        }
                        // END BUILD BROKER DETAIL 

                    } else {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.SHIP_TO_INFO_ATTR, CawCommonConstant.NULL_STRING);
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.BROKER_ITEM_DETAIL, CawCommonConstant.NULL_STRING);
                    }                
                    /* END BZ37463 */     
                    proRequest = getPropertiesRequest(itm.getPropertiesModel());
                    if (proRequest != null) {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.PROPERTIES_ATTR, proRequest);
                    } else {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.PROPERTIES_ATTR, CawCommonConstant.NULL_STRING);
                    }

                    //BZ25558 Added
                    attrRequest = getItemAttributesRequest(itm.getAttributesModel());
                    
                    if (attrRequest != null) {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, attrRequest);
                    } else {
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, CawCommonConstant.NULL_STRING);
                    }

                    if (sbItem.length() > 1) {
                        sbItem.append(",");
                    }
                    sbItem.append(templateRequest);
                }
                if (sbItem.length() > 0) {
                    sbItem.append("]");
                }

                result = sbItem.toString();
            }
        }

        return result;
    }

    /**
     * @param template
     * @param fileName
     * @return
     */
    /* BEGIN BZ37463 */
    public static String getTendersRequest(CawTheOrderModel theOrdModel,
            String fileName) {

        String result = null;
        try {
            String originalTempBuff = readRequestTemplate(fileName);
            if (originalTempBuff != null && originalTempBuff.length() > 0) {
                String templateRequest = null;
                List<CawTenderModel> tndLst = theOrdModel.getTenders();
                if (tndLst != null && tndLst.size() > 0) {
                    StringBuilder sbTender = new StringBuilder();
                    for (CawTenderModel tnd : tndLst) {
                        templateRequest = String.valueOf(originalTempBuff);
                        logger.debug("Tender template buffer: "
                                + templateRequest);
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.CORRELATION_KEY_ATTR, formatParameter(tnd
                                        .getCorrelationKey()));

                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.TYPE_ATTR, CawPropertiesConfig
                                        .get(tnd.getType())); //BZ48630
                        
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.CODE_ATTR, formatParameter(tnd
                                        .getCode()));
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.AMOUNT_ATTR, String
                                        .valueOf(tnd.getAmount()));
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.AUTHORIZATION_ATTR, formatParameter(tnd
                                        .getAuthorization()));
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.TOKEN_ATTR, formatParameter(tnd
                                        .getToken()));
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.CARD_NUMBER_MASKED_ATTR, formatParameter(tnd
                                        .getCardNumberMasked()));
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.CARDHOLDER_ATTR, formatParameter(tnd
                                        .getCardholder()));
                        templateRequest = templateRequest
                                .replace(CawWSTemplateConstant.EXPIRE_DATE_ATTR, formatParameter(tnd
                                        .getExpireDate()));

                        if (sbTender.length() > 0) {
                            sbTender.append(",");
                        }
                        sbTender.append(templateRequest);
                    }

                    if (sbTender.length() > 0) {
                        result = "[" + sbTender.toString() + "]";
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error in getTenders-1: " + e.getMessage());
            result = null;
        }

        return result;
    }
    /* END BZ37463 */

    /**
     * @param cawAddressModel
     * @param fileName
     * @return
     */
    public static String getAddressCustomerRequest(
            CawAddressModel cawAddressModel, String fileName) {

        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            result = String.valueOf(originalTempBuff);
            result = result
                    .replace(CawWSTemplateConstant.AUDIT_ATTR, formatParameter(cawAddressModel
                            .getAudit()));
            result = result
                    .replace(CawWSTemplateConstant.ADDRESS_TYPE_ATTR, formatParameter(cawAddressModel
                            .getAddressType()));
            result = result
                    .replace(CawWSTemplateConstant.IS_DELIVERABLE_ATTR, String
                            .valueOf(cawAddressModel.getIsDeliverable()));
            result = result
                    .replace(CawWSTemplateConstant.LINE1_ATTR, formatParameter(cawAddressModel
                            .getLine1()));
            result = result
                    .replace(CawWSTemplateConstant.LINE2_ATTR, formatParameter(cawAddressModel
                            .getLine2()));
            result = result
                    .replace(CawWSTemplateConstant.LINE3_ATTR, formatParameter(cawAddressModel
                            .getLine3()));
            result = result
                    .replace(CawWSTemplateConstant.LINE4_ATTR, formatParameter(cawAddressModel
                            .getLine4()));
            result = result
                    .replace(CawWSTemplateConstant.CITY_ATTR, formatParameter(cawAddressModel
                            .getCity()));
            result = result
                    .replace(CawWSTemplateConstant.STATE_PROVINCE_ATTR, formatParameter(cawAddressModel
                            .getStateProvince()));
            result = result
                    .replace(CawWSTemplateConstant.POSTAL_CODE_ATTR, formatParameter(cawAddressModel
                            .getPostalCode()));
            result = result
                    .replace(CawWSTemplateConstant.COUNTRY_ATTR, formatParameter(cawAddressModel
                            .getCountry()));
            result = result
                    .replace(CawWSTemplateConstant.COUNTY_ATTR, formatParameter(cawAddressModel
                            .getCounty()));
        }
        return result;
    }

    /**
     * @param name
     * @param fileName
     * @return
     */
    public static String getNameCustomerRequest(CawNameModel name,
            String fileName) {

        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            result = String.valueOf(originalTempBuff);
            result = result
                    .replace(CawWSTemplateConstant.PREFIX_ATTR, formatParameter(name
                            .getPrefix()));
            result = result
                    .replace(CawWSTemplateConstant.FIRST_ATTR, formatParameter(name
                            .getFirst()));
            result = result
                    .replace(CawWSTemplateConstant.MIDDLE_ATTR, formatParameter(name
                            .getMiddle()));
            result = result
                    .replace(CawWSTemplateConstant.LAST_ATTR, formatParameter(name
                            .getLast()));
            result = result
                    .replace(CawWSTemplateConstant.SUFFIX_ATTR, formatParameter(name
                            .getSuffix()));
            result = result
                    .replace(CawWSTemplateConstant.COMPANY_ATTR, formatParameter(name
                            .getCompany()));
        }
        return result;
    }

    /**
     * @param cust
     * @param fileName
     * @return
     */
    public static String getCustomerRequest(CawCustomerModel cust,
            String fileName) {

        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            result = String.valueOf(originalTempBuff);
            result = result
                    .replace(CawWSTemplateConstant.CUSTOMER_TYPE_ATTR, String
                            .valueOf(cust.getCustomerType()));
            result = result
                    .replace(CawWSTemplateConstant.ACCOUNT_NUMBER_ATTR, String
                            .valueOf(cust.getAccountNumber()));
            if (cust.getName() != null) {
                result = result
                        .replace(CawWSTemplateConstant.NAME_CUSTOMER_ATTR, getNameCustomerRequest(cust
                                .getName(), CawWSTemplateConstant.NAME_CUSTOMER_TEMPLATE));
            } else {
                result = result
                        .replace(CawWSTemplateConstant.NAME_CUSTOMER_ATTR, CawCommonConstant.NULL_STRING);
            }
            if (cust.getAddress() != null) {
                result = result
                        .replace(CawWSTemplateConstant.ADDRESS_CUSTOMER_ATTR, getAddressCustomerRequest(cust
                                .getAddress(), CawWSTemplateConstant.ADDRESS_CUSTOMER_TEMPLATE));
            } else {
                result = result
                        .replace(CawWSTemplateConstant.ADDRESS_CUSTOMER_ATTR, CawCommonConstant.NULL_STRING);
            }

        }
        return result;
    }

    /**
     * @param cashier
     * @param fileName
     * @return
     */
    public static String getCashierRequest(CawCashierModel cashier,
            String fileName) {

        String result = null;
        String originalTempBuff = readRequestTemplate(fileName);
        if (originalTempBuff != null && originalTempBuff.length() > 0) {
            result = String.valueOf(originalTempBuff);
            result = result
                    .replace(CawWSTemplateConstant.CODE_CASHIER_ATTR, formatParameter(cashier
                            .getCode()));
            result = result
                    .replace(CawWSTemplateConstant.NAME_CASHIER_ATTR, formatParameter(cashier
                            .getName()));
            result = result
                    .replace(CawWSTemplateConstant.FILE_NUMBER_ATTR, formatParameter(cashier
                            .getFileNumber()));
        }
        return result;
    }
    /* BEGIN BZ37463 */
    /**
     * @param sti
     * @param fileName
     * @return
     */
    public static String getShipToInfoRequest(CawShipToInfoModel sti,
            String fileName) {

        String result = null;
        if (sti != null) {
            String originalTempBuff = readRequestTemplate(fileName);
            if (originalTempBuff != null && originalTempBuff.length() > 0) {
                result = String.valueOf(originalTempBuff);
                result = result
                        .replace(CawWSTemplateConstant.NAME_SHIP_ATTR, formatParameter(sti
                                .getName()));
                result = result
                        .replace(CawWSTemplateConstant.LINE1_SHIP_ATTR, formatParameter(sti
                                .getLine1()));
                result = result
                        .replace(CawWSTemplateConstant.LINE2_SHIP_ATTR, formatParameter(sti
                                .getLine2()));
                result = result
                        .replace(CawWSTemplateConstant.CITY_SHIP_ATTR, formatParameter(sti
                                .getCity()));
                result = result
                        .replace(CawWSTemplateConstant.STATE_PROVINCE_SHIP_ATTR, formatParameter(sti
                                .getStateProvince()));
                result = result
                        .replace(CawWSTemplateConstant.POSTAL_CODE_SHIP_ATTR, formatParameter(sti
                                .getPostalCode()));
                result = result
                        .replace(CawWSTemplateConstant.COUNTRY_SHIP_ATTR, formatParameter(sti
                                .getCountry()));

                result = result
                        .replace(CawWSTemplateConstant.SHIP_VIA, formatParameter(sti
                                .getShipVia()));

                result = addServiceLevel(sti, result);
            }
        }
        return result;
    }
    
    
    private static String addServiceLevel(CawShipToInfoModel sti, String result) {

        if (!StringUtils.isEmpty(sti.getServiceLevel())
                && StringUtils.isNumber(sti.getServiceLevel())) {
            result = addValueIntoRequest(result, CawWSTemplateConstant.SERVICE_LEVEL, sti.getServiceLevel(), false);
        } else {
            result = addValueIntoRequest(result, CawWSTemplateConstant.SERVICE_LEVEL, CawUtils.STRING_0, false);
        }

        return result;
    }
    /* END BZ37463 */

    /* BEGIN BZ37463 */

    /**
     * @param item
     * @param model
     * @param fileName
     * @return
     */
    public static String getBrokerItemDetail(CawItemModel item,CawShipToInfoModel shipToInfoModel,
            CawTransactionModel model, String fileName)/* BEGIN BZ38176 */ {

        String result = null;

        String orderType = "";

        CawBrokeredOrderLineModel orderLineModel = null;

        List<CawBrokeredOrderLineModel> brokeredOrderLineModels = null;

        if (item != null && model != null
                && model.getBrokeredOrderModel() != null) {
            orderType = model.getBrokeredOrderModel().getOrderType();

            brokeredOrderLineModels = model.getBrokeredOrderModel()
                    .getCawBrokeredOrderLineModel();

            String brokerDetailTemplate = readRequestTemplate(fileName);

            if (brokeredOrderLineModels != null) { // BZ-38841
                for (CawBrokeredOrderLineModel cawBrokeredOrderLineModel : brokeredOrderLineModels) {

                    if (item.getCode() != null 
                            && item.getCode().equals(cawBrokeredOrderLineModel.getItemId())
                                && item.getRtransLineitmSeq() == cawBrokeredOrderLineModel.getRtransLineitmSeq()) {/*BZ45903*/
                        orderLineModel = cawBrokeredOrderLineModel;

                        if (brokerDetailTemplate != null
                                && brokerDetailTemplate.length() > 0) {

                            result = String.valueOf(brokerDetailTemplate);
                            /*BEGIN NOTE: if change this block please also change request of catalist 4 on xstore*/
                            // BUILD SHIP TO CUSTOMER
                            if (CawCommonConstant.BROKERED_ORDER_STANDARD_DELIVERY
                                    .equalsIgnoreCase(orderType)) {
                                result = result
                                        .replace(CawWSTemplateConstant.BROKER_ACTION, CawUtils.STRING_1);
                                result = result
                                        .replace(CawWSTemplateConstant.FULL_FILL_SYSTEM, CawCommonConstant.NULL_STRING);
                                result = result
                                        .replace(CawWSTemplateConstant.FULL_FILL_LOCATION, CawCommonConstant.NULL_STRING);
                                /* BEGIN BZ45907 */
                                String obRequestId = orderLineModel.getRequestId() != null ? orderLineModel.getRequestId() : CawUtils.STRING_0;
                                result = result.replace(CawWSTemplateConstant.OB_REQUEST_ID, obRequestId);
                                /* END BZ45907 */
                                result = result
                                        .replace(CawWSTemplateConstant.OB_ORDER_ID, formatParameter(orderLineModel
                                                .getOrderId()));
                                result = result.replace(CawWSTemplateConstant.OB_ACTION_DESCRIPTION, formatParameter(CawCommonConstant.OB_SHIP_TO_CUSTOMER));/*BZ44528*/
                            } else {
                                // BUILD SHIP TO OTHER STORE
                                result = result
                                        .replace(CawWSTemplateConstant.BROKER_ACTION, CawUtils.STRING_2);
                                result = result
                                        .replace(CawWSTemplateConstant.FULL_FILL_SYSTEM, formatParameter(CawWSTemplateConstant.FULL_FILL_SYSTEM_DES));

                                result = addFulfillingLocation(shipToInfoModel, result); //BZ38176

                                result = result
                                        .replace(CawWSTemplateConstant.OB_REQUEST_ID, orderLineModel
                                                .getRequestId());
                                result = result
                                        .replace(CawWSTemplateConstant.OB_ORDER_ID, formatParameter(orderLineModel
                                                .getOrderId()));
                                
                                result = result.replace(CawWSTemplateConstant.OB_ACTION_DESCRIPTION, formatParameter(CawCommonConstant.OB_PICKUP_IN_STORE));/*BZ44528*/

                            }
                            /*END NOTE: if change this block please also change request of catalist 4 on xstore*/
                            break;
                        }
                    }
                }
            } // BZ-38841
        } // End first IF
            

        return result;
    }

    /**
     * @param model
     * @param result
     * @return
     */
    private static String addFulfillingLocation(CawShipToInfoModel shipToInfoModel, String result) {

        /* BEGIN BZ38176 */
        if (shipToInfoModel != null) {
            result = addValueIntoRequest(result, CawWSTemplateConstant.FULL_FILL_LOCATION, shipToInfoModel
                    .getFullfillLocation());
        } else {
            result = addValueIntoRequest(result, CawWSTemplateConstant.FULL_FILL_LOCATION, CawCommonConstant.NULL_STRING);
        }
        /* END BZ38176 */

        return result;
    }
    
    /**
     * 
     * @param request
     * @param field
     * @param value
     * @return
     */
    private static String addValueIntoRequest(String request, String field, String value) {
        request = addValueIntoRequest(request, field, value, true);
        return request;
    }

    /**
     * 
     * @param request
     * @param value
     * @param field
     * @return
     */
    private static String addValueIntoRequest(String request, String field, String value, boolean isFormat) {

        if (value != null) {
            if (isFormat) {
                value =  formatParameter(value);
            } 
            request = request.replace(field, value);
        } else {
            request = request.replace(field, CawCommonConstant.NULL_STRING);
        }
        
        return request;
    }
    /* END BZ37463 */
    //Begin BZ26308
    //Begin BZ24905
    //Begin BZ24658
    /**
     * @param propModel
     * @return
     */
    public static String getPropertiesRequest(CawPropertiesModel propModel) {

        if (propModel != null && propModel.getProperty4() != null
                && propModel.getProperty4().length() > 0) {
            return propModel.getProperty4();
        } else {
            return null;
        }
    }

    //End BZ24658
    //End BZ24905
    //End BZ26308
    /**
     * @param salePersonModel
     * @return
     */
    public static String getSalePersonRequest(
            CawSalesPersonModel salePersonModel) {

        StringBuilder sbPro = new StringBuilder();
        if (salePersonModel != null) {
            sbPro.append("{").append("\"code\":")
                    .append(formatParameter(salePersonModel.getCode()))
                    .append(",").append("\"name\":")
                    .append(formatParameter(salePersonModel.getName()))
                    .append(",").append("\"fileNumber\":")
                    .append(formatParameter(salePersonModel.getFileNumber()))
                    .append("}");
            return sbPro.toString();
        } else {
            return null;
        }
    }

    /**
     * @param attrOrdModel
     * @return
     */
    /* BEGIN BZ37463 */
    public static String getOrderAttributesRequest(
            CawAttributesModel attrOrdModel) {

        StringBuilder sbPro = new StringBuilder();
        if (attrOrdModel != null) {
            sbPro.append("{").append("\"orderHoldName\":")
                    .append(formatParameter(attrOrdModel.getOrderHoldName()))
                    .append(",").append("\"affiliateId\":")
                    .append(formatParameter(attrOrdModel.getAffiliateId()))
                    .append("}");
            return sbPro.toString();
        } else {
            return null;
        }
    }
    /* END BZ37463 */

    /**
     * @param argString
     * @return
     */
    public static String formatParameter(String argString) {

        return argString != null ? "\"" + argString + "\""
                : CawCommonConstant.NULL_STRING;
    }
    
    /**
     * @param argString
     * @return
     */
    public static String formatNullString(String argString) {

        return argString != null ? "\"" + argString + "\""
                : "\"" + CawCommonConstant.VALUE_00 + "\"";
    }

    //Begin BZ24352
    /**
     * this method is used to Lookup Customer via account number.
     * @param accountNumber
     * @return
     */
    public static String lookUpCustomer(String accountNumber, String locationCode) { /*BZ27535: add parameters*/

        String urlAPI = CawPropertiesConfig
                .get(CawPKeyConstant.UPSERT_SERVICE_API);
        //BEGIN BZ48630
        boolean isUseToken = false;
        
        if (CawPropertiesConfig.get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN) != null 
                && !CawPropertiesConfig.get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN).isEmpty()) {
            urlAPI = CawPropertiesConfig.get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);
            isUseToken = true;
        } 
        //END BZ48630
        String neuronUser = CawPropertiesConfig
                .get(CawPKeyConstant.NEURON_USER);
        String neuronKey = CawPropertiesConfig.get(CawPKeyConstant.NEURON_KEY);
        String customerLookupUrl= null;
        if (urlAPI != null && urlAPI.length() > 0) {
            try {
                String[] splitUrl = urlAPI.trim().split("\\|");
                if(splitUrl != null && splitUrl.length == 3) {
                    urlAPI = splitUrl[0];
                    neuronUser = splitUrl[1];
                    neuronKey = splitUrl[2];
                    customerLookupUrl = urlAPI;
                }
                else {
                    customerLookupUrl = urlAPI + "?accountNumber=" + accountNumber
                            + "&locationCode=" + locationCode;
                }
            } catch (Exception ex_ebs) {
                logger.error("sendRequestToEBS-0: " + ex_ebs.getMessage());
            }
        } else {
            logger.info("sendRequestToEBS: URL is null or empty");
        }
        try {
            urlAPI = urlAPI.replace(CawCommonConstant.ACCOUNT_NUMBER, accountNumber);
            urlAPI = urlAPI.replace(CawCommonConstant.LOCATION_CODE, locationCode);
            customerLookupUrl = urlAPI;
            logger.info("Created GET request for: " + urlAPI);//BZ48630
        } catch (Exception ex) {
            logger.error("sendRequestToEBS-0: " + ex.getMessage());
        }
        
        
        HttpHeaders httpHeaders = CawOrderServiceRestUtils
                .createHttpHeader(MediaType.APPLICATION_JSON, neuronUser, neuronKey);
        
        /* BEGIN BZ48630: Handle to use TOKEN */
        if (isUseToken) {
            String authorization = StringUtils.EMPTY;
            
            HashMap<String, CawCheetahTokenModel> listTokenModel = CawOrderServiceTasks.getListTokenModel();
            
            if (listTokenModel != null){
                if (!listTokenModel.containsKey(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN)) {
                    CawOrderServiceUtils.getTokenFromApi(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);                       
                }
                else if (CawOrderServiceApp.isExpiredToken(listTokenModel.get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN).getExpiresTime())) {
                    CawOrderServiceUtils.getTokenFromApi(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);
                }
            }
            else {
                CawOrderServiceUtils.getTokenFromApi(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);
            }
            
            if (CawOrderServiceTasks.getListTokenModel() != null) {
                if (CawOrderServiceTasks.getListTokenModel().get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN) != null) {
                    String tokenType = CawOrderServiceTasks.getListTokenModel().get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN).getTokenType();
                    String tokenAccess = CawOrderServiceTasks.getListTokenModel().get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN).getTokenAccess();
                    authorization = tokenType + " " + tokenAccess;
                    httpHeaders.set(CawCommonConstant.CAW_AUTHORIZATION, authorization);
                }
            }
        }
        /* END BZ48630: Handle to use TOKEN */
        
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

        ResponseEntity<String> customerTemplate = CawOrderServiceRestUtils
                .callServiceAPIResponseEntity(customerLookupUrl, HttpMethod.GET, entity);
        
        logger.debug("[lookUpCustomer API - customerTemplate ]: " + customerTemplate.toString());
        //BEGIN BZ52349
        //If customerTemplate have status code is different 200 series, return empty
        //If body of customerTemplate have result, work follow flow pos URL. If no, work with NEURON URL
        try {
            if(customerTemplate.getStatusCode().is2xxSuccessful() && customerTemplate.getBody() != null && !customerTemplate.getBody().isEmpty()) {
                JSONObject jsonBody = new JSONObject(customerTemplate.getBody());
                if(jsonBody.has(CawCommonConstant.JSON_RESULT)) {
                    return getCustomerFromLookUpCustomer(customerTemplate, accountNumber, locationCode);
                } else {
                    return customerTemplate.getBody();
                }
            }
        } catch (JSONException e) {
            logger.error("[lookUpCustomer API - customerTemplate.getBody() error]: " + e);
        }
        logger.debug("[lookUpCustomer API - customerTemplate.getBody() return]: " + customerTemplate.getBody().toString());
        return StringUtils.EMPTY;
        //END BZ52349
    }

    //End BZ24352
    
    //BEGIN BZ52349
    public static String getCustomerFromLookUpCustomer(ResponseEntity<String> customerTemplate, String accountNumber, String locationCode) {
        //Start BZ48630
        //If getResultCodeFromEBS return != 200, continue to search with loyaltySearch=false in URL
        try {
            JSONObject result = new JSONObject(customerTemplate.getBody());
            if(CawBrokeredOrderHelper.getInstance().getResultCodeFromEBS(customerTemplate) != HttpStatus.OK.value()) {
                logger.debug("[lookUpCustomer API - error code]: " + CawBrokeredOrderHelper.getInstance().getResultCodeFromEBS(customerTemplate));
                logger.debug("[lookUpCustomer API - error detail]: " + CawBrokeredOrderHelper.getInstance().getErrorDetailFromEBS(customerTemplate));
                try {
                    //search with loyaltySearch=false in URL, return empty if getResultCodeFromEBS != 200
                    ResponseEntity<String> lookupCusWithoutLoyalty = lookUpCustomerWithLoyaltyIsFalse(accountNumber, locationCode);
                    
                    JSONObject resultCusLookupWithoutLoyaltyJson = new JSONObject(lookupCusWithoutLoyalty.getBody());
                    if(CawBrokeredOrderHelper.getInstance().getResultCodeFromEBS(lookupCusWithoutLoyalty) != HttpStatus.OK.value()) {
                        logger.debug("[lookUpCustomer without loyalty API - error code]: " + CawBrokeredOrderHelper.getInstance().getResultCodeFromEBS(lookupCusWithoutLoyalty));
                        logger.debug("[lookUpCustomer without loyalty API - error detail]: " + CawBrokeredOrderHelper.getInstance().getErrorDetailFromEBS(lookupCusWithoutLoyalty));
                        return StringUtils.EMPTY;
                    }
                    else if(!resultCusLookupWithoutLoyaltyJson.isNull(CawCommonConstant.JSON_RESULT) && !resultCusLookupWithoutLoyaltyJson.getString(CawCommonConstant.JSON_RESULT).isEmpty()) {
                        String resultChild = resultCusLookupWithoutLoyaltyJson.getString(CawCommonConstant.JSON_RESULT);
                        logger.debug("[lookUpCustomer without loyalty API - result Child]: " + resultChild);
                        return resultChild;
                    }
                } catch (Exception ex){
                    logger.error("[lookUpCustomer without API - error detail]: " + CawBrokeredOrderHelper.getInstance().getErrorDetailFromEBS(customerTemplate));
                }
            }
            else if(!result.isNull(CawCommonConstant.JSON_RESULT) && !result.getString(CawCommonConstant.JSON_RESULT).isEmpty()) {
                String resultChild = result.getString(CawCommonConstant.JSON_RESULT);
                logger.debug("[lookUpCustomer kong API - result]: " + resultChild);
                return resultChild;
            }
            //END BZ48630
        } catch (JSONException ex) {
            logger.error("[lookUpCustomer API - JSONException]: " + ex.toString());
        }
        return StringUtils.EMPTY;
    }
    //END BZ52349
    
    //BEGIN BZ52349
    public static ResponseEntity<String> lookUpCustomerWithLoyaltyIsFalse(String accountNumber, String locationCode) {
        String urlAPI = CawPropertiesConfig.get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);
        boolean isUseToken = true;
        
        String neuronUser = CawPropertiesConfig
                .get(CawPKeyConstant.NEURON_USER);
        String neuronKey = CawPropertiesConfig.get(CawPKeyConstant.NEURON_KEY);
        String customerLookupUrl= null;
        
        try {
            urlAPI = urlAPI.replace(CawCommonConstant.ACCOUNT_NUMBER, accountNumber);
            urlAPI = urlAPI.replace(CawCommonConstant.LOCATION_CODE, locationCode);
            urlAPI = urlAPI.replace(CawCommonConstant.LOYALTY_SEARCH_IS_TRUE, CawCommonConstant.LOYALTY_SEARCH_IS_FALSE);
            customerLookupUrl = urlAPI;
            logger.info("Created GET request for: " + urlAPI);//BZ48630
        } catch (Exception ex) {
            logger.error("sendRequestToEBS-0: " + ex.getMessage());
        }
        
        HttpHeaders httpHeaders = CawOrderServiceRestUtils
                .createHttpHeader(MediaType.APPLICATION_JSON, neuronUser, neuronKey);
        
        /* BEGIN BZ48630: Handle to use TOKEN */
        if (isUseToken) {
            String authorization = StringUtils.EMPTY;
            
            HashMap<String, CawCheetahTokenModel> listTokenModel = CawOrderServiceTasks.getListTokenModel();
            
            if (listTokenModel != null){
                if (!listTokenModel.containsKey(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN)) {
                    CawOrderServiceUtils.getTokenFromApi(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);                       
                }
                else if (CawOrderServiceApp.isExpiredToken(listTokenModel.get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN).getExpiresTime())) {
                    CawOrderServiceUtils.getTokenFromApi(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);
                }
            }
            else {
                CawOrderServiceUtils.getTokenFromApi(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN);
            }
            
            if (CawOrderServiceTasks.getListTokenModel() != null) {
                if (CawOrderServiceTasks.getListTokenModel().get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN) != null) {
                    String tokenType = CawOrderServiceTasks.getListTokenModel().get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN).getTokenType();
                    String tokenAccess = CawOrderServiceTasks.getListTokenModel().get(CawPKeyConstant.UPSERT_SERVICE_API_TOKEN).getTokenAccess();
                    authorization = tokenType + " " + tokenAccess;
                    httpHeaders.set(CawCommonConstant.CAW_AUTHORIZATION, authorization);
                }
            }
        }
        /* END BZ48630: Handle to use TOKEN */
        
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

        ResponseEntity<String> customerTemplate = CawOrderServiceRestUtils
                .callServiceAPIResponseEntity(customerLookupUrl, HttpMethod.GET, entity);
        
        logger.debug("[lookUpCustomer without loyalty API - result]: " + customerTemplate);
        return customerTemplate;   
        
    }
    //END BZ52349
    /**
     * @param fileName
     * @return
     */
    public static JSONObject getJsonContentByTemplate(String fileName) {

        JSONObject customerJson = null;
        try {
            String originalTempBuff = readRequestTemplate(fileName);
            if (originalTempBuff != null && originalTempBuff.length() > 0) {
                customerJson = new JSONObject(originalTempBuff);
            }
        } catch (Exception e) {
            logger.error("getJsonContentByTemplate-1: Can not read content from file '"
                    + fileName + "." + e.getMessage());
        }

        return customerJson;

    }
    //End BZ24886

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(Session session, String toEmail,
            String subject, String body) {

        String senderEmail = CawPropertiesConfig
                .get(CawPKeyConstant.SENDER_EMAIL);

        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader(CawCommonConstant.CONTENT_TYPE, CawCommonConstant.TEXT_HTML_CHARSET_UTF_8);
            msg.addHeader(CawCommonConstant.FORMAT, CawCommonConstant.FLOWED);
            msg.addHeader(CawCommonConstant.CONTENT_TRANSFER_ENCODING, CawCommonConstant.ENC_8BIT);

            msg.setFrom(new InternetAddress(senderEmail,
                    CawCommonConstant.ORDER_SERVICE));

            msg.setReplyTo(InternetAddress.parse(senderEmail, false));

            msg.setSubject(subject, CawCommonConstant.UTF_8);

            msg.setText(body, CawCommonConstant.UTF_8, CawCommonConstant.HTML);

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress
                    .parse(toEmail, false));
            logger.info("Message is ready");
            Transport.send(msg);

            logger.info("Email Sent Successfully!!");
        } catch (Exception e) {
            logger.error("Could not send email: " + e.getMessage());
        }
    }

    //Begin BZ24230
    /**
     * @param accountNumber
     * @return
     */
    protected static String maskField(String accountNumber) {

        if ((accountNumber == null) || (accountNumber.isEmpty())
                || (accountNumber.length() < 4)) {
            return null;
        }
        return mask(accountNumber.substring(0, accountNumber.length() - 4))
                .concat(accountNumber.substring(accountNumber.length() - 4));
    }

    /**
     * @param o
     * @return
     */
    protected static String mask(Object o) {

        String result;
        if ((o instanceof IFormattable)) {
            result = ((IFormattable) o)
                    .toString(dtv.i18n.OutputContextType.LOG);
        } else {
            if (o == null) {
                return CawCommonConstant.NULL_STRING;
            }

            result = String.valueOf(o);
        }
        return StringUtils.fill("*", result.length());
    }
    //End BZ24230

    //Begin BZ24271
    /**
     * Desrypt field from Xoffice database
     * @param argEncryptionService
     * @param value
     * @return
     */
    protected static String decryptField(String argEncryptionService,
            String value) {

        if (value == null) {
            return null;
        }
        return DtvDecrypter.getInstance(argEncryptionService)
                .decryptIfEncrypted(value);
    }

    //End BZ24271
    /**
     * method is used to send email
     * @param correlationKey
     */
    public static void sendNotifyEmail(String correlationKey) {

        String allowSend = CawPropertiesConfig
                .get(CawPKeyConstant.ALLOW_SEND_EMAIL);
        String recipientEmail = CawPropertiesConfig
                .get(CawPKeyConstant.RECIPIENT_EMAIL);
        String smtpConfig = CawPropertiesConfig
                .get(CawPKeyConstant.SMTP_CONFIG);

        String subject = "Order #: " + correlationKey + " is failed";
        String body = "There is error when processing transaction: "
                + correlationKey
                + "<br/>Please review error message in CAW_TRN_ORD_SER table. "
                + "<br/>If you want to process again, update status to 0.";

        if (allowSend != null
                && allowSend.equalsIgnoreCase(Boolean.TRUE.toString())) {
            try {
                logger.info("SENDING NOTIFY EMAIL TO " + recipientEmail + ": "
                        + subject);
                Properties props = System.getProperties();
                props.put(CawPValueConstant.MAIL_SMTP_HOST, smtpConfig);
                Session session = Session.getInstance(props, null);
                CawOrderServiceUtils
                        .sendEmail(session, recipientEmail, subject, body);
            } catch (Exception e) {
                logger.warn("PROBLEM WHEN SENDING EMAIL TO SUPPORT TEAM");
                logger.error("Error when sending email: " + e.getMessage());
            }
        }
    }

    /**
     * method is used to get Email's info
     * @param transSeq
     * @param storeID
     * @param regID
     * @param bsnDate
     * @param conn
     * @return
     * @throws SQLException
     */
    public static CawTheOrderModel orderEmail(String transSeq, String storeID,
            String regID, Timestamp bsnDate, Connection conn,
            CawTransactionModel model) throws SQLException {

        PreparedStatement psEmailReceipt = null;
        ResultSet rsEmailReceipt = null;

        try {
            //GETS RECEIPTING METHOD AND EMAIL ADDRESS
            //PREPARE EMAIL ADDRESS AND RECEIPTING METHODS
            psEmailReceipt = conn
                    .prepareStatement(CawSQLConstant.QUERY_EMAIL_RECEIPT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psEmailReceipt.setString(1, model.getTransSeq());
            psEmailReceipt.setString(2, model.getStoreID());
            psEmailReceipt.setString(3, model.getRegID());
            psEmailReceipt.setTimestamp(4, model.getBsnDate());
            rsEmailReceipt = psEmailReceipt.executeQuery();
            if (rsEmailReceipt != null) {
                logger.debug("orderEmail()-Executed query for Email Receipt\n"
                        + CawSQLConstant.QUERY_EMAIL_RECEIPT + " "
                        + Arrays.asList(model.getTransSeq(), model
                                .getStoreID(), model
                                        .getRegID(), model.getBsnDate()));
                rsEmailReceipt.last();
                logger.debug("Email - size:" + rsEmailReceipt.getRow());
                rsEmailReceipt.beforeFirst();
            }

            while (rsEmailReceipt.next()) {
                if (rsEmailReceipt
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD)
                        .equals(CawCommonConstant.RECEIPT_DELIVERY_METHOD_STRING)) {
                    model.setMethodEMail(rsEmailReceipt
                            .getString(CawCommonConstant.STRING_VALUE));
                } else if (rsEmailReceipt
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD)
                        .equals(CawCommonConstant.RECEIPT_EMAIL_ADDRESS_STRING)
                        && !model.getMethodEMail()
                                .equals(CawCommonConstant.PAPER_STRING)
                        && !rsEmailReceipt
                                .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD)
                                .equals(CawCommonConstant.CUSTOMER_EMAIL_UPDATED_STRING)) {
                    model.setEmailAddress(rsEmailReceipt
                            .getString(CawCommonConstant.STRING_VALUE));
                } else if (model.getMethodEMail()
                        .equals(CawCommonConstant.PAPER_STRING)) {
                    model.setEmailAddress(null);
                }
                //Begin BZ29391
                if(rsEmailReceipt
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD)
                        .equalsIgnoreCase(CawCommonConstant.CAW_TRANSACTION_TYPE) && rsEmailReceipt
                        .getString(CawCommonConstant.STRING_VALUE).equalsIgnoreCase(CawCommonConstant.ACCOUNT_PAYMENT) ) {
                    model.setCheckAcPayment(true); 
                }
                //End BZ29391
            }

            //@TODO - need to review
            switch (model.getMethodEMail()) {
            case CawCommonConstant.PAPER_STRING:
                model.setMethodEMail(CawCommonConstant.PRINT_METHOD);
                break;
            case CawCommonConstant.EMAIL_PAPER_STRING:
                model.setMethodEMail(CawCommonConstant.PRINT_AND_EMAIL_METHOD);
                break;
            //Begin BZ24292
            case CawCommonConstant.EMAIL_ONLY_STRING:
                model.setMethodEMail(CawCommonConstant.EMAIL_METHOD);
                break;
            //End BZ24292
            default:
                model.setMethodEMail(CawCommonConstant.NONE_METHOD);
                break;
            }

            model.getOrderModel().setReceiptType(model.getMethodEMail());
            model.getOrderModel().setEReceiptEmail(model.getEmailAddress());
            logger.debug("orderEmail()-Email Receipt info\n"
                    + model.getMethodEMail() + "/" + model.getEmailAddress());
        } catch (RuntimeException e) {
            logger.error("Error in orderEmail-1: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
        } finally {
            if (rsEmailReceipt != null) {
                rsEmailReceipt.close();
            }
            if (psEmailReceipt != null) {
                psEmailReceipt.close();
            }
        }
        return model.getOrderModel();
    }

    /**
     * method is used to update data err/success to table caw_order_service
     * @param conn
     * @param updateCodeError
     * @param responseMessage
     * @param responseCode
     * @param responseDesc
     * @param updateDate
     * @param transSeq
     * @param storeID
     * @param regID
     * @param bsnDate
     */
    public static int updateStatusCawOrderServiceTable(Connection conn,
            long updateCodeError, String responseMessage, int responseCode,
            String responseDesc, String updateDate, String transSeq,
            String storeID, String regID, Timestamp bsnDate) {

        int success = 0;
        //PREPARE UPDATE/INSERT STATEMENTS
        PreparedStatement psUpdateOrderStatus = null;
        try {
            psUpdateOrderStatus = conn
                    .prepareStatement(CawSQLConstant.QUERY_UPDATE_STATUS);
            logger.debug("updateStatusCawOrderServiceTable()-Executed query for updateStatusCawOrderServiceTable\n"
                    + CawSQLConstant.QUERY_UPDATE_STATUS + " "
                    + Arrays.asList(updateCodeError, responseMessage, responseCode, responseDesc, updateDate, transSeq, storeID, bsnDate));

            psUpdateOrderStatus.setLong(1, updateCodeError);
            psUpdateOrderStatus.setString(2, responseMessage);
            psUpdateOrderStatus.setInt(3, responseCode);
            psUpdateOrderStatus.setString(4, responseDesc);
            psUpdateOrderStatus.setString(5, updateDate);
            psUpdateOrderStatus.setString(6, transSeq);
            psUpdateOrderStatus.setString(7, storeID);
            psUpdateOrderStatus.setString(8, regID);
            psUpdateOrderStatus.setTimestamp(9, bsnDate);
            psUpdateOrderStatus.executeUpdate();
        } catch (Exception e) {
            success = -1;
            logger.error("Error in updateStatusCawOrderServiceTable-1"
                    + e.getMessage());
        } finally {
            if (psUpdateOrderStatus != null) {
                try {
                    psUpdateOrderStatus.close();
                } catch (SQLException e) {
                    logger.error("Error in updateStatusCawOrderServiceTable-2"
                            + e.getMessage());
                }
            }
        }
        return success;
    }

    /**
     * this method is used to notify info of transaction when success
     * @param result
     * @param correlationKey
     * @param partyId
     * @param countItem
     * @param countTenders
     * @param orderTotalWithTax
     */
    public static void notifyInfoTransaction(ResponseEntity<String> result,
            String correlationKey, String partyId, int countItem,
            int countTenders, BigDecimal orderTotalWithTax) {

        logger.info("RESPONSE: " + result.getBody());
        logger.info("TRANSACTION: " + correlationKey
                + " HAS BEEN SENT SUCCESSFUL WITH DETAIL");
        logger.info("\tCustomer ID: " + partyId);
        logger.info("\tNumber of Items: " + countItem);
        logger.info("\tNumber of Tenders: " + countTenders);
        logger.info("\tTransaction Total: " + orderTotalWithTax);
    }

    /**
     * this method is used to update number of retry to send mail
     * @param retry_count
     * @param transSeq
     * @param storeID
     * @param regID
     * @param bsnDate
     */
    public static int updateOrderRetryCount(int retry_count, String transSeq,
            String storeID, String regID, Timestamp bsnDate, Connection conn,
            CawTransactionModel model) {

        int success = 0;
        //PREPARE UPDATE RETRY_COUNT STATEMENT
        PreparedStatement psUpdateOrderRetryCount = null;
        try {
            psUpdateOrderRetryCount = conn
                    .prepareStatement(CawSQLConstant.QUERY_UPDATE_RETRY_COUNT);
            psUpdateOrderRetryCount.setInt(1, model.getRetry_count() + 1);
            psUpdateOrderRetryCount.setString(2, model.getTransSeq());
            psUpdateOrderRetryCount.setString(3, model.getStoreID());
            psUpdateOrderRetryCount.setString(4, model.getRegID());
            psUpdateOrderRetryCount.setTimestamp(5, model.getBsnDate());
            psUpdateOrderRetryCount.executeUpdate();
        } catch (Exception e) {
            success = -1;
            logger.error("Error in updateOrderRetryCount-1" + e.getMessage());
        } finally {
            if (psUpdateOrderRetryCount != null) {
                try {
                    psUpdateOrderRetryCount.close();
                } catch (SQLException e) {
                    logger.error("Error in updateOrderRetryCount-2"
                            + e.getMessage());
                }
            }
        }
        return success;
    }

    /**
     * Convert object to json and print out
     * @param value
     * @return
     */
    public static String writeValueAsString(Object value) {

        ObjectMapper mapper = null;
        String res = null;
        try {
            mapper = new ObjectMapper();
            res = mapper.writeValueAsString(value);
        } catch (Exception e) {
            logger.error("Error in writeValueAsString-1" + e.getMessage());
        }
        return CawUtils.getInstance().vString(res);
    }

    //Begin BZ25558
    /**
     * @param itemAttr
     * @return
     */
    public static String getItemAttributesRequest(CawAttributesModel itemAttr) {

        if (itemAttr != null) {
            StringBuilder sbPro = new StringBuilder();
            if (itemAttr.getReturnReason() != null) {
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append("\"returnReason\":")
                        .append(formatParameter(itemAttr.getReturnReason()));
            }
            //Begin BZ27584
            if (itemAttr.getOrignalCorrelationKey() != null) {
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append("\"originalCorrelationKey\":")
                        .append(formatParameter(itemAttr
                                .getOrignalCorrelationKey()));
            }
            //End BZ27584
            //Begin BZ27712: adding work order item's attributes
            if (itemAttr.getWoAttributes() != null) {
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append(itemAttr.getWoAttributes());
            }
            //End BZ27712
            
            /* BEGIN BZ37463 */
            if (itemAttr.getoRequestId() != null && itemAttr.getoRequestId().length() > 0) {
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append("\"o.requestId\":")
                        .append(formatParameter(itemAttr.getoRequestId()));
            }
             /* END BZ37463*/
            
            //Finally
            if (sbPro.length() > 0) {
                return "{" + sbPro.toString() + "}";
            }
        }
        return null;
    }

    //End BZ25558
    //Begin BZ26207
    /**
     * BZ27067: Read value from mapping file following :
     * Deposit: Set to Deposit or 4   ===> posStatus": "4"
     * Complete: Set to Complete or 8 ===> posStatus": "8"
     * Cancel: Set to Cancel or 16    ===> posStatus": "16"
     * @param workOrderDetail
     */
    public static CawWorkOrderDetail formatWorkOrderDetail(
            CawWorkOrderDetail woDetail) {

        CawWorkOrderDetail cawWorkOrderDetail = new CawWorkOrderDetail();
        //Begin BZ26955
        String woId = "";
        if (woDetail != null && woDetail.getId() != null) {
            String[] breakWoDetail = woDetail.getId().split(":");
            if (breakWoDetail != null && breakWoDetail.length > 1) {
                woId = breakWoDetail[1];
            }
        }
        //End BZ26955

        if (woDetail.getPosStatus()
                .equalsIgnoreCase(CawCommonConstant.WO_CANCEL_CODE)) {
            cawWorkOrderDetail.setId(woId);
            cawWorkOrderDetail.setPosStatus(CawPropertiesConfig
                    .get(CawCommonConstant.WO_CANCEL_CODE));
        } else if (woDetail.getPosStatus()
                .equalsIgnoreCase(CawCommonConstant.WO_COMPLETE_CODE)) {
            cawWorkOrderDetail.setId(woId);
            cawWorkOrderDetail.setPosStatus(CawPropertiesConfig
                    .get(CawCommonConstant.WO_COMPLETE_CODE));
        } else if (woDetail.getPosStatus()
                .equalsIgnoreCase(CawCommonConstant.WO_DEPOSIT_CODE)) {
            cawWorkOrderDetail.setId(woId);
            cawWorkOrderDetail.setPosStatus(CawPropertiesConfig
                    .get(CawCommonConstant.WO_DEPOSIT_CODE));//BZ27067:get value from mapping file
        }
        return cawWorkOrderDetail;
    }
    //End BZ26207
    //Begin BZ29049, BZ37463
    public static String purchaseOrderTemplate(CawTheOrderModel theOrdModel) {

        String PO = StringUtils.EMPTY; //BZ29204
        for (CawTenderModel purchaseOrder : theOrdModel.getTenders()) {
            if (purchaseOrder.getPurchaseOrder() != null) {
                return purchaseOrder.getPurchaseOrder();
            }

        }
        return PO;
    }
    //End BZ29049, BZ37463
    /* BEGIN BZ29668 */
    /**
     * String to clob.
     *
     * @param conn the conn
     * @param argData the arg data
     * @return the clob
     */
    public static CLOB stringToClob(Connection conn, String argData) {

        CLOB clob = null;
        try {
            clob = CLOB.createTemporary(conn, false, CLOB.DURATION_SESSION);
            clob.setString(1, argData);
        } catch (SQLException e) {
            logger.error("Error in stringToClob()" + e.getMessage());
        }

        return clob;
    }
    
    /**
     * Gets the format time stampt.
     *
     * @return the format time stampt
     */
    public static String getFormatTimeStampt() {
        return REP_DATE_FORMATTER.format(new Date(System.currentTimeMillis()));
    }
    
    /**
     * Insert log caw order service table.
     *
     * @param conn the conn
     * @param timeStamp the time stamp
     * @param transSeq the trans seq
     * @param storeID the store ID
     * @param regID the reg ID
     * @param bsnDate the bsn date
     * @param requestMessage the request message
     * @param responseMessage the response message
     * @param responseCode the response code
     * @return the int
     */
    public static int insertLogCawOrderServiceTable(Connection conn, String timeStamp, String transSeq, String storeID,
            String regID, Timestamp bsnDate, String requestMessage, String responseMessage, int responseCode) {

        int success = 0;
        // PREPARE INSERT STATEMENTS
        PreparedStatement psInsertCawOrdSerLog = null;
        try {
            psInsertCawOrdSerLog = conn.prepareStatement(CawSQLConstant.QUERY_INSERT_ORD_SER_LOG);
            logger.debug("insertLogCawOrderServiceTable()-Executed query for insertLogCawOrderServiceTable\n"
                    + CawSQLConstant.QUERY_INSERT_ORD_SER_LOG + " "
                    + Arrays.asList(timeStamp, transSeq, storeID, regID, bsnDate, requestMessage, responseMessage, responseCode));

            psInsertCawOrdSerLog.setString(1, timeStamp);
            psInsertCawOrdSerLog.setInt(2, Integer.parseInt(transSeq));
            psInsertCawOrdSerLog.setInt(3, Integer.parseInt(storeID));
            psInsertCawOrdSerLog.setInt(4, Integer.parseInt(regID));
            psInsertCawOrdSerLog.setTimestamp(5, bsnDate);
            psInsertCawOrdSerLog.setClob(6, stringToClob(conn, requestMessage));
            psInsertCawOrdSerLog.setClob(7, stringToClob(conn, responseMessage));
            psInsertCawOrdSerLog.setString(8, Integer.toString(responseCode));
            psInsertCawOrdSerLog.executeUpdate();
        } catch (Exception e) {
            success = -1;
            logger.error("Error in insertLogCawOrderServiceTable-1" + e.getMessage());
        } finally {
            if (psInsertCawOrdSerLog != null) {
                try {
                    psInsertCawOrdSerLog.close();
                } catch (SQLException e) {
                    logger.error("Error in insertLogCawOrderServiceTable-2" + e.getMessage());
                }
            }
        }
        return success;
    }

    /**
     * Update log caw order service table.
     *
     * @param conn the conn
     * @param responseMessage the response message
     * @param responseCode the response code
     * @param timeStamp the time stamp
     * @param transSeq the trans seq
     * @param storeID the store ID
     * @param regID the reg ID
     * @return the int
     */
    public static int updateLogCawOrderServiceTable(Connection conn, String responseMessage, int responseCode,
            String timeStamp, String transSeq, String storeID, String regID) {

        int success = 0;
        // PREPARE UPDATE STATEMENTS
        PreparedStatement psUpdateCawOrdSerLog = null;
        try {
            psUpdateCawOrdSerLog = conn.prepareStatement(CawSQLConstant.QUERY_UPDATE_ORD_SER_LOG);
            logger.debug("updateLogCawOrderServiceTable()-Executed query for updateLogCawOrderServiceTable\n"
                    + CawSQLConstant.QUERY_UPDATE_ORD_SER_LOG + " "
                    + Arrays.asList(transSeq, storeID, regID, responseMessage, responseCode));

            psUpdateCawOrdSerLog.setClob(1, stringToClob(conn, responseMessage));
            psUpdateCawOrdSerLog.setString(2, Integer.toString(responseCode));
            psUpdateCawOrdSerLog.setString(3, timeStamp);
            psUpdateCawOrdSerLog.setInt(4, Integer.parseInt(transSeq));
            psUpdateCawOrdSerLog.setInt(5, Integer.parseInt(storeID));
            psUpdateCawOrdSerLog.setInt(6, Integer.parseInt(regID));
            psUpdateCawOrdSerLog.executeUpdate();
        } catch (Exception e) {
            success = -1;
            logger.error("Error in updateLogCawOrderServiceTable-1" + e.getMessage());
        } finally {
            if (psUpdateCawOrdSerLog != null) {
                try {
                    psUpdateCawOrdSerLog.close();
                } catch (SQLException e) {
                    logger.error("Error in updateLogCawOrderServiceTable-2" + e.getMessage());
                }
            }
        }
        return success;
    }
    /* END BZ29668 */

    /* BEGIN BZ32434 */
    /**
     * 1. UnitListPrice: unitListPrice positive for Sale and Negative for return
     * 2. Adj Amount: adjustment amount negative for Sale and positive for Return
     * @param discountAmt
     * @param isReturn
     * @return
     */
    public static BigDecimal getSignValue(BigDecimal amount, int caseNum, boolean isReturn) {

        BigDecimal tmpValue = BigDecimal.ZERO;
        logger.debug("getSignValue: " + amount + ", case: " + caseNum + ", isReturn: " + isReturn);
        if (NumberUtils.isZeroOrNull(amount)) {
            tmpValue = BigDecimal.ZERO;
        } else {
            if (caseNum == 1) {
                tmpValue = isReturn ? amount.abs().negate() : amount.abs();
            } else if (caseNum == 2) {
                tmpValue = isReturn ? amount.abs() : amount.abs().negate();
            }
        }
        return tmpValue;
    }
    /* END BZ32434 */
    
    /* BEGIN BZ40798 */
    public static CawAttributesModel orderSavingsAmount(Connection conn,
            CawTransactionModel model) {

        PreparedStatement psSavingAmount = null;
        ResultSet rspsSavingAmount = null;
        CawAttributesModel cawAttributesModel = null;
        try {
            psSavingAmount = conn
                    .prepareStatement(CawSQLConstant.QUERY_SAVINGS_AMOUNT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            psSavingAmount.setString(1, model.getTransSeq());
            psSavingAmount.setString(2, model.getStoreID());
            psSavingAmount.setString(3, model.getRegID());
            psSavingAmount.setTimestamp(4, model.getBsnDate());
            rspsSavingAmount = psSavingAmount.executeQuery();
            cawAttributesModel = new CawAttributesModel();
            while (rspsSavingAmount.next()) { //BZ40798
                if (rspsSavingAmount
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD)
                        .equals(CawCommonConstant.GOOD_SAM_SAVINGS_STRING)) {
                    cawAttributesModel.setGoodSamSavings(rspsSavingAmount
                            .getString(CawCommonConstant.STRING_VALUE));
                } else if (rspsSavingAmount
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD)
                        .equals(CawCommonConstant.COULD_SAVE_STRING)) {
                    cawAttributesModel.setCouldSave(rspsSavingAmount
                            .getString(CawCommonConstant.STRING_VALUE));
                }
            }
        } catch (Exception e) {
            logger.error("Could not read good sam saving amount." + e);
        }
        // Start BZ-42198
        finally {
            try {
                if (rspsSavingAmount != null) {
                    rspsSavingAmount.close();
                }
                if (psSavingAmount != null) {
                    psSavingAmount.close();
                }
            } catch (SQLException e) {
                logger.error("Error in closing connection: " + e.getMessage());
            }
        } // End BZ-42198
        return cawAttributesModel;
    }
    
    /**
     * @param attrOrdModel
     * @return
     */
    public static String getGoodSamSavingAttribute(
            CawAttributesModel attrOrdModel) {

        StringBuilder sbPro = new StringBuilder();
        if (attrOrdModel != null) {
            sbPro.append(CawWSTemplateConstant.ATTRIBUTES_TEMPLATE);
            return sbPro.toString();
        } else {
            return null;
        }
    }
    /* END BZ40798 */

    /* BEGIN BZ48630: Handle to use Token */
    public static String getTokenFromApi(String urlAPIPropName) {
        String tokenUrl;
        
        if(CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.TOKEN) != null) {
            tokenUrl = CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.TOKEN);
        } else {
            //default use OS URL
            tokenUrl = CawPropertiesConfig.get(CawPKeyConstant.ORDER_SERVICE_STATUS_API_TOKEN);
        }
        String tokenRequest = readRequestTemplate(CawWSTemplateConstant.TOKEN_TEMPLATE);
        
        if (!StringUtils.isEmpty(tokenUrl) && !StringUtils.isEmpty(tokenRequest)) {
            logger.info("[Call Token url]: " + tokenUrl);
            
            String clientIdPropName;
            String clientSecretPropName;
            String grantTypePropNam;
            //client id property name
            if(CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.CLIENT_ID) != null 
                    && !CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.CLIENT_ID).isEmpty()) {
                clientIdPropName = urlAPIPropName + CawPKeyConstant.CLIENT_ID;
            } else {
                clientIdPropName = CawPKeyConstant.ORDER_SERVICE_API_TOKEN + CawPKeyConstant.CLIENT_ID;
            }
            //client secret property name
            if(CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.CLIENT_SECRET) != null
                    && !CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.CLIENT_SECRET).isEmpty()) {
                clientSecretPropName = urlAPIPropName + CawPKeyConstant.CLIENT_SECRET;
            } else {
                clientSecretPropName = CawPKeyConstant.ORDER_SERVICE_API_TOKEN + CawPKeyConstant.CLIENT_SECRET;
            }
            //grant type property name
            if(CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.GRANT_TYPE) != null
                    && !CawPropertiesConfig.get(urlAPIPropName + CawPKeyConstant.GRANT_TYPE).isEmpty()) {
                grantTypePropNam = urlAPIPropName+CawPKeyConstant.GRANT_TYPE;
            } else {
                grantTypePropNam = CawPKeyConstant.ORDER_SERVICE_API_TOKEN + CawPKeyConstant.GRANT_TYPE;
            }
            
            if (!StringUtils.isEmpty(CawPropertiesConfig.get(clientIdPropName))
                    && !StringUtils.isEmpty(CawPropertiesConfig.get(clientSecretPropName))
                    && !StringUtils.isEmpty(CawPropertiesConfig.get(grantTypePropNam))) {
                
                tokenRequest = tokenRequest.replace(CawWSTemplateConstant.TOKEN_CLIENT_ID, CawPropertiesConfig.get(clientIdPropName));
                tokenRequest = tokenRequest.replace(CawWSTemplateConstant.TOKEN_CLIENT_SECRET, CawPropertiesConfig.get(clientSecretPropName));
                tokenRequest = tokenRequest.replace(CawWSTemplateConstant.TOKEN_GRANT_TYPE, CawPropertiesConfig.get(grantTypePropNam));
                
                String neuronUser = CawPropertiesConfig.get(CawPKeyConstant.NEURON_USER);
                String neuronKey = CawPropertiesConfig.get(CawPKeyConstant.NEURON_KEY);
                HttpHeaders httpHeaders = CawOrderServiceRestUtils.createHttpHeader(MediaType.APPLICATION_JSON, neuronUser, neuronKey);
                
                HttpEntity<String> entity = new HttpEntity<String>(tokenRequest, httpHeaders);
                
                ResponseEntity<String> response = CawOrderServiceRestUtils.callServiceAPIResponseEntity(tokenUrl, HttpMethod.POST, entity);
                
                if (response != null) {
                    if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null && !response.getBody().isEmpty()) {
                        CawCheetahTokenModel tokenModel = new CawCheetahTokenModel();
                        
                        JSONObject tokenJson = CawJSONUtils.toJSONObject(response.getBody());
                        tokenModel.setTokenType(CawJSONUtils.getString(tokenJson, CawCommonConstant.CAW_TOKEN_TYPE));
                        tokenModel.setTokenAccess(CawJSONUtils.getString(tokenJson, CawCommonConstant.CAW_ACCESS_TOKEN));
                        
                        if(CawJSONUtils.getString(tokenJson, CawCommonConstant.CAW_TOKEN_EXPIRES_IN) != null 
                                && CawJSONUtils.getString(tokenJson, CawCommonConstant.CAW_TOKEN_EXPIRES_IN) != StringUtils.EMPTY) {
                            Date now = new Date();
                            long seconds = now.getTime();
                            seconds = seconds + (Long.parseLong(CawJSONUtils.getString(tokenJson, CawCommonConstant.CAW_TOKEN_EXPIRES_IN)) * 1000) 
                                    - (Long.parseLong(CawPropertiesConfig.get(CawPKeyConstant.ORDER_SERVICE_API_TOKEN + CawPKeyConstant.CONTINGENCY_TIME)) * 1000); 
                            Date expired = new Date(seconds);
                            DateFormat dateFormat = new SimpleDateFormat(CawCommonConstant.CAW_TOKEN_EXPIRED_TIME_FORMAT);  
                            tokenModel.setExpiresTime(dateFormat.format(expired));
                            
                            CawOrderServiceTasks.getListTokenModel().put(urlAPIPropName, tokenModel);
                            return response.getBody();
                        }
                    }
                }
            }
            else {
                logger.info("[Missing information for Token attribute. Please check 3 propeties for token in config.properties file]");
            }            
        }
        else {
            logger.info("[Missing information for Token URL and Token Request Template. Please check the token URL in config.properties file and TokenTemplate.txt.]");
        }

        return StringUtils.EMPTY;
    }
    /* END BZ48630: Handle to use Token */
    
    //BEGIN BZ53108
    public static String getMembershipFromDB(Connection conn, String party) 
            throws SQLException {
        JSONArray jsonMemberships = null;

        PreparedStatement psmemberships = null;
        ResultSet rsmemberships = null;
        
        String result = "";
        try {
            try {
                psmemberships = conn
                        .prepareStatement(CawSQLConstant.QUERY_MEMBERSHIPS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
                psmemberships.setString(1, party);
                rsmemberships = psmemberships.executeQuery();
                logger.debug("buildCustomerTemp-get membership from DB-Executed query for membership\n"
                        + CawSQLConstant.QUERY_MEMBERSHIPS + " "
                        + Arrays.asList(party));
                rsmemberships.last();
                logger.debug("Result set â€“ size:" + rsmemberships.getRow());
                rsmemberships.beforeFirst();
        
                while (rsmemberships.next()) {
                    if (rsmemberships
                            .getString(CawDBFieldConstant.STRING_VALUE_FIELD) != null) {
                        jsonMemberships = new JSONArray(rsmemberships
                                .getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                        result =  jsonMemberships.toString();
                    }
                }
            } catch (Exception e) {
                logger.debug("Cannot buildCustomerTemp-get membership from DB-Executed query for membership: " + e.getMessage());
            }
            
        } catch(Exception e) {
        
        }
        finally {
            if (rsmemberships != null) {
                rsmemberships.close();
            }
            if (psmemberships != null) {
                psmemberships.close();
            }
    
        }
        return result;
    }
    
    public static String getPricingFromDB(Connection conn, String party) 
            throws SQLException {
        JSONObject jsonPricingMembership = null; 
        
        PreparedStatement pspricingmembership = null;
        ResultSet rspricingmembership = null; 
        String result = "";
        
        try {
            pspricingmembership = conn.prepareStatement(CawSQLConstant.QUERY_PRICING_MEMBERSHIP
                    , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pspricingmembership.setString(1, party);
            rspricingmembership = pspricingmembership.executeQuery();
            logger.debug("buildCustomerTemp-get pricing from DB-Executed query for pricing\n"
                    + CawSQLConstant.QUERY_PRICING_MEMBERSHIP + " "
                    + Arrays.asList(party));
            rspricingmembership.last();
            logger.debug("Result set - size:" + rspricingmembership.getRow());
            rspricingmembership.beforeFirst();

            while (rspricingmembership.next()) {
                if (rspricingmembership.getString(CawDBFieldConstant.STRING_VALUE_FIELD) != null) {
                   
                    jsonPricingMembership = new JSONObject(rspricingmembership.getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                    result = jsonPricingMembership.toString();
                } 
            }
        } catch (Exception e) {
            logger.debug("Cannot buildCustomerTemp-get pricing from DB-Executed query for pricing: " + e.getMessage());
        }
        finally {
            if (rspricingmembership != null) {
                rspricingmembership.close();
            }
            if (pspricingmembership != null) {
                pspricingmembership.close();
            }
        }
        return result;
    }
    //END BZ53108
}
