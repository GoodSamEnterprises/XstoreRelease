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
 * BZ23565              051017    Order Service is not processing all the records
 * BZ23830              061017    [Order Service] Unexpected error occurred in scheduled task
 * BZ23922              101017    [Order Service] Update order service
 * BZ23986              121017    [Order Service] Message was stuck due to Address.country is null
 * BZ23327              231017    Error about customer not having both company name and first/last names is generated in Xoffice db when CAW Order Converter tool runs
 * BZ23922              251017    [Order Service] Update order service
 * BZ24226              271017    [OrderService] "orderDate" needs to be mapped to pull the Xstore Transaction Date/Time
 * BZ24231              271017    [OrderService]Xstore needs to send the masked card# in the order_service.out message
 * BZ24232              271017    [OrderService] Xstore needs to send the card holder in the order_service.out message
 * BZ24271              301017    [OrderService] Exp Date of credit/debit card is unrecognizable in the order_service.out
 * BZ24227              301017    [OrderService] Missing List Price on order_service.out message
 * BZ24230              301017    [OrderService] Xstore must send the unencrypted credit card token in order_service.out message
 * BZ24238              301017    [OrderService] "null" is submitted for customer in order_service.out message if created in offline mode
 * BZ24292              311017    [OrderService] "receiptType" submits as "None" when email is selected for receipt in POS
 * BZ24270              021117    [OrderService] "adjustments" data is missing on order_service.out message for items and transactions with discounts
 * BZ24340              021117    [OrderService] Missing value for "lineTotal" in order_service.out messages
 * BZ24352              031117    [OrderService] Customers sent with the orders are incomplete...customer data returned from a lookup service call is not what’s being supplied when the order is submitted
 * BZ24395              081117    [OrderService]Paid In & Paid Out transactions in order_service.out
 * BZ24632              291117    [Order Service] Order Total Amount – Should be a negative number in order log when performing Paid out transaction
 * BZ24866              151217    [PROD] Tax Code is "null" in order service for Tender Exchange transaction for $0.01
 * BZ24869              151217    [Order Service] TaxCode displays null in orderservice log when performing Pay In/PayOut transaction
 * BZ25068              250118    New Requirement to Process Web Order Returns
 * BZ24886              250118    [PROD] Memberships Sold with No Customer in EBS
 * BZ25254              260118    [OrderService] Error message from EBS: 400 ORA-00001: unique constraint (XXCWONT.CWIONT_ORDER_HEADERS_IFACE_U1) violated
 * BZ25306              070218    [PROD] Orders Have No Line Items
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ25640              220518    New Requirement - Used Firearm System Process Redesign
 * BZ26888              240718    [Internal] Move 2 Paid In (980920) & Paid Out (980919) items to configuration file
 * BZ26207              250718    New Requirement - Enable Work Order Functionality
 * BZ29391              140219    [Internal] PLCC payment generates a 400 error.
 * BZ30248              190419    [Prod] OS transaction failed due to customer information error - cause is xCenter DB offline
 * BZ30261              190419    [Prod] Work Order Issues: Order Service send Work Order Deposit as Sale Transaction
 * BZ29668              200619    [Internal] OS Logging the transaction output to database table journal
 * BZ32298              310719    [Internal] Update log file more clearly for investigate issue in the future
 * BZ33985              261119    [Port 33972 to 5.2][PROD] Order Service should wait for items before sending to EBS
 * BZ34609              090119    [Prod] Order Service not processing "paid-out" transactions.
 * BZ35016              060320    [New Requirement] WO complete should not override WO deposit data in CAT_CUST_ITEM_ACCT_DETAIL
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ40798              240221    Modification to member savings calculation
 * BZ48320              220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 * BZ51771              191022    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service. 
 * BZ52877              251022    [UAT] response_message populated as null for status of -1 in OS table
 * BZ53763              211122    [Internal] Duplicate data in the CAW_TRN_ORD_SER_LOG table.
 * BZ55978              290323    Loyalty Issue: Java Null Pointer
 * BZ61159              160124    [New Requirement] - Xstore AGIS Replacement
 * BZ63054              080424    [API Change] - Format of the Submit Order API response is changed.
 *===================================================================
 */

package caw.orderservice.bean;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.fasterxml.jackson.core.JsonProcessingException;

import caw.orderservice.constant.CawCommonConstant;
import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawPKeyConstant;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.constant.CawWSTemplateConstant;
import caw.orderservice.cron.bean.CawOrderServiceTasks;
import caw.orderservice.helper.CawBrokeredOrderHelper;
import caw.orderservice.helper.CawOrderTypeEnum;
import caw.orderservice.model.CawBrokeredOrderLineModel;
import caw.orderservice.model.CawBrokeredOrderModel;
import caw.orderservice.model.CawCashierModel;
import caw.orderservice.model.CawCheetahTokenModel;
import caw.orderservice.model.CawItemModel;
import caw.orderservice.model.CawPaidInOutDetail;
import caw.orderservice.model.CawSalesChannelModel;
import caw.orderservice.model.CawTenderModel;
import caw.orderservice.model.CawTheOrderModel;
import caw.orderservice.model.CawTransactionModel;
import caw.orderservice.model.CawWorkOrderDetail;
import caw.orderservice.rest.CawOrderServiceRestUtils;
import caw.orderservice.utils.CawPropertiesConfig;
import caw.orderservice.utils.CawUtils;
import twitter4j.JSONObject;

/*
 *  The <code>CawOrderServiceApp</code> class. 
 *  This class is used to handle orders. 
 *  run() method is invoked from schedule 
 *  and will run follow configuration time
 */
public class CawOrderServiceApp {

    private static Logger logger = Logger.getLogger(CawOrderServiceApp.class);

    /**
     * Start Order Service process
     * @param conn
     */
    public void run(Connection conn) {

        try {
            consumeDB(conn);
        } catch (RuntimeException e) {
            logger.error("Error in run-1: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
        }
    }

    /**
     * this class is modified based on BZ25614
     * Consume data form Xoffice database, convert to JSON message
     * @param conn
     */
    protected void consumeDB(Connection conn) {

        int maxTrans = CawPropertiesConfig.getInt(CawPKeyConstant.MAX_TRANS);

        PreparedStatement psTransations = null;
        ResultSet rsTransations = null;
        PreparedStatement psItemInfo = null;
        ResultSet rsItemInfo = null;
        int itemsNbr = 0;
        try {
            psTransations = conn
                    .prepareStatement(CawSQLConstant.QUERY_TRANSACTIONS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            psTransations.setInt(1, maxTrans);
            rsTransations = psTransations.executeQuery();
            CawTransactionModel model = null;
            int currentRowNbr = 0;
            String correlationKey = StringUtils.EMPTY; /* BZ32298 */
            

            while (rsTransations.next()) {
                /**
                 * as need to process all records, 
                 * if error to log out
                 */
                try {
                    currentRowNbr = rsTransations.getRow();
                    model = new CawTransactionModel();
                    model.loadTransacitonInfo(rsTransations);
                    correlationKey = model.getCorrelationKey(); /* BZ32298 */
                    /* BEGIN BZ30248*/
                    if (StringUtils.isNotEmpty(model.getPartyId())
                            && StringUtils.isEmpty(model.getCompany())
                            && StringUtils.isEmpty(model.getFirstName()) 
                            && StringUtils.isEmpty(model.getLastName())) {
                        /* BEGIN BZ32298 */
                        logger.info("There is no customer information for this transaction " + "(" + correlationKey
                                + ")" + " now, keep for the next time.");
                        /* END BZ32298 */
                        continue;
                    }
                    /* END BZ30248*/
                    
                    /* BEGIN BZ37463 */
                    CawBrokeredOrderModel brokeredOrderModel = CawBrokeredOrderHelper.getInstance().loadBrokeredOrderTran(conn, model);
                    // If this is a Brokered Order transaction, then the object brokeredOrderModel will be not null.
                    if (brokeredOrderModel != null) {
                        model.setBrokeredOrderModel(brokeredOrderModel);
                    }
                    /* END BZ37463 */
                    
                    /*BEGIN BZ34609: due to no items in TENDER_CONTROL, TENDER_EXCHANGE, no need to execute items query*/
                    String typecode = model.getTransTypCode();
                    if (!CawCommonConstant.TENDER_CONTROL.equalsIgnoreCase(typecode)
                            && !CawCommonConstant.TENDER_EXCHANGE.equalsIgnoreCase(typecode)) { 
                        /*BEGIN BZ33985*/
                        psItemInfo = conn
                                .prepareStatement(CawSQLConstant.QUERY_ITEMS_INFO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rsItemInfo = CawOrderServiceItems.readItemInfo(model, conn, psItemInfo, correlationKey);
                        rsItemInfo.last();
                        itemsNbr = rsItemInfo.getRow();
                        logger.debug("Result set size:" + itemsNbr);
                        rsItemInfo.beforeFirst();
                        if (itemsNbr <= 0 && brokeredOrderModel == null) { /* BZ37463 */
                            logger.info("There is no line item for this transaction " + "(" + correlationKey + ")"
                                    + " now, keep for the next time.");
                            continue;
                        }
                        /*END BZ33985*/
                    }
                    /*END BZ34609*/
                    /* BEGIN BZ30261, BEGIN BZ35016 */
                    CawWorkOrderDetail workOrderDetail = CawOrderServiceItems.retrieveWorkOrderTransaction(conn, model);
                    if (workOrderDetail != null) {
                        logger.info("This transaction " + "(" + correlationKey + ")" + " is Work Order");
                    }
                    /* END BZ35016 */
                    else if (CawOrderServiceItems.isWorkOrderTransaction(conn, model)) {
                        /* BEGIN BZ32298 */
                        logger.info("This transaction " + "(" + correlationKey + ")" + " is Work Order");
                        /* END BZ32298 */
                        workOrderDetail = CawOrderServiceItems
                                .getWorkOrderInfo(conn, model.getTransSeq(), model
                                        .getStoreID(), model
                                                .getRegID(), model.getBsnDate());
                        if (workOrderDetail == null) {
                            logger.info("There is no Work Order information now, keep for the next time.");
                            continue;
                        }
                    }
                    /* END BZ30261*/
                    
                    
                    consumeTransactionModel(conn, currentRowNbr, model, workOrderDetail, rsItemInfo); //BZ30261: Add workOrderDetail parameter, BZ33985

                }  catch (RuntimeException e) {
                    logger.error("Error in consumeDB-1: " + e.getMessage());
                } catch (Exception e) {
                    logger.debug("Current row = " + currentRowNbr);
                    logger.error("Error in consumeDB-4: " + e.getMessage());
                } finally {
                    /*BEGIN BZ33985*/
                    if (rsItemInfo != null) {
                        rsItemInfo.close();
                    }
                    if (psItemInfo != null) {
                        psItemInfo.close();
                    }
                    /*END BZ33985*/
                }
            }

        } catch (RuntimeException e) {
            logger.error("Error in consumeDB-1: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error in consumeDB-2: " + e.getMessage());
        } finally {
            //CLOSE ALL RESULTSETS
            if (rsTransations != null) {
                try {
                    rsTransations.close();
                } catch (SQLException ex) {
                    logger.error("Error in consumeDB-3: " + ex.getMessage());
                }
            }

            //CLOSE ALL PREPARESTATEMENTS
            if (psTransations != null) {
                try {
                    psTransations.close();
                } catch (SQLException ex) {
                    logger.error("Error in consumeDB-4: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * 
     * @param conn
     * @param currentRowNbr
     * @param model
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ParseException
     * @throws JsonProcessingException
     */
    /*BEGIN BZ33985*/
    protected void consumeTransactionModel(Connection conn, int currentRowNbr,
            CawTransactionModel model, CawWorkOrderDetail workOrderDetail, ResultSet rsItemInfo) throws SQLException,
            ClassNotFoundException, ParseException, JsonProcessingException {//BZ30261: Add workOrderDetail parameter

        String correlationKey = null;
        //String maxRetryConfig = CawCommonConstant.EMPTY_STRING;
        CawCashierModel cashier = null;
        String orderTypPaidInOut = CawCommonConstant.EMPTY_STRING;

        //CONVERTING TO JSON FORMAT
        String jsonString = null;
        try {
            model.setOrderModel(new CawTheOrderModel());
            model.getOrderModel().setItems(new ArrayList<CawItemModel>());
            model.getOrderModel().setTenders(new ArrayList<CawTenderModel>());
            /* BEGIN BZ37463 */
            loadSalesChannel(model);
            /* END BZ37463 */

            correlationKey = model.getCorrelationKey();
            logger.info("********** BEGIN TRANSACTION:" + correlationKey
                    + "(REQUEST #" + currentRowNbr + ") **********");

            //Begin BZ24395: Handle for case PaidIn/PaidOut, determine 
            //this trans is paid in or paid out via transTypCode
            String tpecode = model.getTransTypCode();
            if (tpecode != null && tpecode
                    .equalsIgnoreCase(CawCommonConstant.TENDER_CONTROL)) {
                orderTypPaidInOut = checkAndIntialPaidInOut(conn, model);
                model.getOrderModel().setOrderType(orderTypPaidInOut);
            } else {
                //check work order here
                // Begin BZ26207
                if (workOrderDetail != null && workOrderDetail.getId() != null
                        && workOrderDetail.getPosStatus() != null) {
                    if (workOrderDetail.getPosStatus()
                            .equalsIgnoreCase(CawCommonConstant.WO_DEPOSIT_CODE)) {
                        workOrderDetail = CawOrderServiceUtils
                                .formatWorkOrderDetail(workOrderDetail);
                        model.getOrderModel()
                                .setOrderType(CawCommonConstant.WORK_ORDER_DEPOSIT);
                        model.getOrderModel()
                                .setWorkOrderDetail(workOrderDetail);
                    } else if (workOrderDetail.getPosStatus()
                            .equalsIgnoreCase(CawCommonConstant.WO_CANCEL_CODE)) {
                        workOrderDetail = CawOrderServiceUtils
                                .formatWorkOrderDetail(workOrderDetail);
                        model.getOrderModel()
                                .setOrderType(CawCommonConstant.WORK_ORDER_CANCEL);
                        model.getOrderModel()
                                .setWorkOrderDetail(workOrderDetail);
                    } else if (workOrderDetail.getPosStatus()
                            .equalsIgnoreCase(CawCommonConstant.WO_COMPLETE_CODE)) {
                        workOrderDetail = CawOrderServiceUtils
                                .formatWorkOrderDetail(workOrderDetail);
                        model.getOrderModel()
                                .setOrderType(CawCommonConstant.WORK_ORDER_COMPLETE);
                        model.getOrderModel()
                                .setWorkOrderDetail(workOrderDetail);
                    } else {
                        model.getOrderModel()
                                .setOrderType(CawCommonConstant.SALES_TRANSACTION);
                    }

                } else {
                    model.getOrderModel()
                            .setOrderType(CawCommonConstant.SALES_TRANSACTION);
                }
                //End BZ26207
            }
            //End BZ24395

            model.getOrderModel()
                    .setId(CawUtils.getInstance().vLong(model.getTransID()));
            model.getOrderModel().setCorrelationKey(correlationKey);
            model.getOrderModel().setOrderDate(model.getBeginDate());
            model.getOrderModel().setAttributes(CawOrderServiceUtils.orderSavingsAmount(conn, model));//BZ40798

            //Begin BZ24632
            if (orderTypPaidInOut.equalsIgnoreCase(CawCommonConstant.PAIDOUT)
                    || tpecode
                            .equalsIgnoreCase(CawCommonConstant.TENDER_EXCHANGE)) {
                BigDecimal total = model.getOrderTotalWithTax()
                        .multiply(BigDecimal.valueOf(-1));
                model.getOrderModel().setOrderTotalWithTax(total);
            } else {
                model.getOrderModel()
                        .setOrderTotalWithTax(model.getOrderTotalWithTax());
            }
            //End BZ24632

            cashier = new CawCashierModel();
            cashier.setCode(model.getCode());
            cashier.setName(model.getName());
            cashier.setFileNumber(model.getFileNumber());
            logger.debug("consumeTransactionModel()- Cashier's Info:"
                    + CawOrderServiceUtils.writeValueAsString(cashier));
            model.getOrderModel().setCashier(cashier);

            //Begin BZ23565
            model.getOrderModel().setShipToInfo(null);
            //End BZ23565

            //GETS CUSTOMER INFORMATION
            logger.debug("consumeTransactionModel()- Party's info:"
                    + model.getPartyId());
            if (model.getPartyId() != null) {
                getCustomerInfo(conn, model);
            }

            //Begin BZ25306
            logger.debug("consumeTransactionModel()- Customer's Info: "
                    + CawOrderServiceUtils
                            .writeValueAsString(model.getOrderModel()));
            //Begin BZ29391
            //GETS RECEIPTING METHOD AND EMAIL ADDRESS- code has been move here to check acPayment
            model.setOrderModel(CawOrderServiceUtils
                    .orderEmail(model.getTransSeq(), model.getStoreID(), model
                            .getRegID(), model.getBsnDate(), conn, model));
            //End BZ29391
            //GETS TRANSACTION LINE ITEMS
            /*BEGIN BZ34609: due to no items in TENDER_CONTROL, TENDER_EXCHANGE, no need to process items info*/
            if (rsItemInfo != null && !rsItemInfo.isClosed()) {
                CawOrderServiceItems.loadItemsTransaction(model, conn, correlationKey, rsItemInfo); /*BZ33985*/
            }
            /*END BZ34609*/
            logger.debug("consumeTransactionModel()- Items's Info:"
                    + CawOrderServiceUtils.writeValueAsString(model
                            .getOrderModel().getItems()));
            //GETS TENDER INFORMATION
            model.setOrderModel(CawOrderServiceTenders
                    .loadTenderTrans(model.getTransSeq(), model
                            .getStoreID(), model.getRegID(), model
                                    .getBsnDate(), conn, correlationKey, model
                                            .getOrderModel(), model));

            logger.debug("consumeTransactionModel()- Tenders's Info:"
                    + CawOrderServiceUtils.writeValueAsString(model
                            .getOrderModel().getTenders()));
            //End BZ25306
            //BEGIN BZ51771
            //GET LOYALTY DETAIL
            logger.debug("Start get loyaltyDetail from DB");
            String loyaltyDetail = getLoyaltyDetailFromDB(conn, model);
            if(loyaltyDetail != null && !loyaltyDetail.isEmpty()) {
                model.getOrderModel().setLoyatyDetail(loyaltyDetail);
            } else {
                model.getOrderModel().setLoyatyDetail(CawCommonConstant.EMPTY_STRING);
            }
            //END BZ51771
            
            //BEGIN BZ61159
            //GET Pitches Info
            logger.debug("Start get Pitches Info from DB");
            String pitchesInfo = getPitchesInfoFromDB(conn, model);
            if(pitchesInfo != null && !pitchesInfo.isEmpty()) {
                model.getOrderModel().setPitchesInfo(pitchesInfo);
            } else {
                model.getOrderModel().setPitchesInfo(CawCommonConstant.EMPTY_STRING);
            }
            //END BZ61159
            
            //Begin BZ24395: in case of PAID_IN/PAID_OUT TRANSACTION
            model.setOrderModel(CawOrderServiceTenders
                    .loadTenderPaidInPaidOut(correlationKey, model
                            .getTaxCodePaidInOut(), model
                                    .getTransTypCode(), model.getCode(), model
                                            .getName(), model
                                                    .getFileNumber(), model, conn));//BZ25640
            //End BZ24395
            //Create message before convert to JSON format

            //CONVERTING TO JSON FORMAT
            jsonString = buildRequestESB(conn, model);
            //SEND REQUEST TO EBS SERVER
            if (jsonString == null || jsonString.length() == 0) {
                logger.warn("JSON REQUEST MESSAGE IS NULL");
            } else {
                sendRequestToESB(conn, model, correlationKey, jsonString);
            }
            /*BEGIN BZ48320*/
            if (CawBrokeredOrderHelper.getInstance().isVinTransaction(model)) {
                //1. loop order lines
                //2. build request of the order line
                //3. send request to api
                //4. remove the order line from the order list
                Iterator<CawBrokeredOrderLineModel> iter = model.getBrokeredOrderModel().getCawBrokeredOrderLineModel().iterator();
                model.getBrokeredOrderModel().setVinTrans(true);
                while (iter.hasNext()) {
                    CawBrokeredOrderLineModel orderLine = iter.next();
                    if (!StringUtils.isEmpty(orderLine.getVinNumber())) {
                        jsonString = buildRequestESB(conn, model);
                        //SEND REQUEST TO EBS SERVER
                        if (jsonString == null || jsonString.length() == 0) {
                            logger.warn("JSON REQUEST MESSAGE IS NULL");
                        } else {
                            sendRequestToESB(conn, model, correlationKey, jsonString);
                        }
                    }
                    //remove current line
                    iter.remove();
                }
            }
           /*END BZ48320*/

        } catch (RuntimeException e) {
            logger.error("Error in consumeTranx-1: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error in consumeTranx-2: " + e.getMessage());
        }
    }
    /*END BZ33985*/
    /**
     * this method is used to get Customer's info and assign them to variables
     * @param conn
     * @param model
     * @throws SQLException 
     */
    private void getCustomerInfo(Connection conn, CawTransactionModel model)
            throws SQLException {

        checkCustomerInQueue(conn, model);//BZ24886
        model.getOrderModel().setCustomer(model.getCustModel());
    }

    //Begin BZ24886
    /**
     * check customer has existed in queue or not, if it existed then this case is offline, else if it is online
     * @param conn
     * @param cust
     * @throws SQLException
     */
    private void checkCustomerInQueue(Connection conn,
            CawTransactionModel model) throws SQLException {

        JSONObject custTemp = null;//new JSONObject();
        model.setJsonCustomer(CawCommonConstant.EMPTY_STRING);
        model.setFlagCheckQueue(false);
        String sPartyId = model.getCustModel().getPartyId();
        if (sPartyId != null) {
            PreparedStatement psCust = null;
            ResultSet rsCust = null;
            try {
                psCust = conn
                        .prepareStatement(CawSQLConstant.QUERY_STATUS_CUSTOMER_OFFLINE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                psCust.setString(1, sPartyId);
                psCust.setString(2, CawCommonConstant.ESB_QUEUE_VALUE);
                rsCust = psCust.executeQuery();
                logger.debug("checkCustomerInQueue()-Executed query for checkCustomerInQueue \n"
                        + CawSQLConstant.QUERY_STATUS_CUSTOMER_OFFLINE + " "
                        + Arrays.asList(sPartyId, CawCommonConstant.ESB_QUEUE_VALUE));
                rsCust.last();
                logger.debug("Result set – size:" + rsCust.getRow());
                rsCust.beforeFirst();

                String statusCust = null;
                String valCust = null;
                while (rsCust.next()) {
                    statusCust = rsCust
                            .getString(CawDBFieldConstant.RECORD_STATE_FIELD);
                    valCust = rsCust
                            .getString(CawDBFieldConstant.STRING_VALUE_FIELD);
                    if (statusCust == null && valCust != null) {
                        try {
                            custTemp = new JSONObject(valCust);
                            //BEGIN BZ61159
                            if (custTemp.has(CawWSTemplateConstant.THE_CUSTOMER) 
                                    && !custTemp.isNull(CawWSTemplateConstant.THE_CUSTOMER)) {
                                custTemp = new JSONObject(custTemp.getString(CawWSTemplateConstant.THE_CUSTOMER));
                            } else if (custTemp.has(CawWSTemplateConstant.JSON_CUSTOMER) 
                                    && !custTemp.isNull(CawWSTemplateConstant.JSON_CUSTOMER)) {
                                custTemp = new JSONObject(custTemp.getString(CawWSTemplateConstant.JSON_CUSTOMER));
                            }
                            model.setCustomerTemplate(CawOrderServiceCustomerTemplate
                                    .updateCRUD(model
                                            .getCustomerTemplate(), model
                                                    .getAccountNumber()));
                            //END BZ61159
                            model.setJsonCustomer(custTemp.toString());
                            if (!model.getJsonCustomer()
                                    .equalsIgnoreCase("{}")) {
                                model.setFlagCheckQueue(true);
                            }
                        } catch (Exception e) {
                            logger.error("Error in checkCustomerInQueue-1: "
                                    + e.getMessage());
                        }
                    }
                }
            } catch (RuntimeException e) {
                logger.error("Error message from EBS: " + e.getMessage());
                logger.info("********** CAN NOT SENT CUSTOMER TO EBS **********");
            } catch (Exception e) {
                logger.error("Error message from EBS: " + e.getMessage());
                logger.info("********** CAN NOT SENT CUSTOMER TO EBS **********");
            } finally {
                if (rsCust != null) {
                    rsCust.close();
                }
                //Close Prepare statement
                if (psCust != null) {
                    psCust.close();
                }
            }
        }
    }

    //End BZ24886

    //End BZ23327

    /**
     * Check this trans is paid in or paid out 
     * via query sqlPaidInPaidOut. 
     * if it is true then get info needed.
     * @param conn
     * @param model
     * @throws SQLException
     */
    private String checkAndIntialPaidInOut(Connection conn,
            CawTransactionModel model) throws SQLException {

        //Prepare query TSN_TNDR_CONTROL_TRANS to get Reason Code, Type Code
        PreparedStatement psPaidInPaidOut = null;
        ResultSet rsPaidInPaidOut = null;
        String orderTypPaidInOut = CawCommonConstant.EMPTY_STRING;
        try {
            psPaidInPaidOut = conn
                    .prepareStatement(CawSQLConstant.QUERY_PAID_IN_PAID_OUT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psPaidInPaidOut.setString(1, model.getTransSeq());
            psPaidInPaidOut.setString(2, model.getStoreID());
            psPaidInPaidOut.setString(3, model.getRegID());
            psPaidInPaidOut.setTimestamp(4, model.getBsnDate());
            rsPaidInPaidOut = psPaidInPaidOut.executeQuery();
            logger.debug("checkAndIntialPaidInOut()-Executed query to get TYPCODE/REASCODE for PaidIn/PaidOut.\n");
            logger.debug(CawSQLConstant.QUERY_PAID_IN_PAID_OUT + " " + Arrays
                    .asList(model.getTransSeq(), model.getStoreID(), model
                            .getRegID(), model.getBsnDate()));
            rsPaidInPaidOut.last();
            logger.debug("Result set – size:" + rsPaidInPaidOut.getRow());
            rsPaidInPaidOut.beforeFirst();
            //Get order type and reason code
            String tmpInOut = null;
            while (rsPaidInPaidOut.next()) {
                tmpInOut = rsPaidInPaidOut
                        .getString(CawDBFieldConstant.TYPCODE_FIELD);
                model.setReasonCode(rsPaidInPaidOut
                        .getString(CawDBFieldConstant.REASCODE_FIELD));
                if (tmpInOut.equalsIgnoreCase(CawCommonConstant.PAID_OUT)) {
                    //Begin BZ26888
                    String itmPaidOut = CawPropertiesConfig.getPaidOutItemId();
                    //End BZ26888
                    orderTypPaidInOut = CawCommonConstant.PAIDOUT;
                    //Begin BZ24869: get Tax Group Id of Paid Out
                    model.setTaxCodePaidInOut(CawOrderServiceItems
                            .loadTaxGroupIdPaidInOut(model, conn, itmPaidOut));
                    //End BZ2489
                } else if (tmpInOut
                        .equalsIgnoreCase(CawCommonConstant.PAID_IN)) {
                    orderTypPaidInOut = CawCommonConstant.PAIDIN;
                    //Begin BZ26888
                    String itmPaidIn = CawPropertiesConfig.getPaidInItemId();
                    //End BZ26888
                    //Begin BZ24869: get Tax Group Id of Paid In
                    model.setTaxCodePaidInOut(CawOrderServiceItems
                            .loadTaxGroupIdPaidInOut(model, conn, itmPaidIn));
                    //End BZ2489
                }
            }
        } finally {
            if (rsPaidInPaidOut != null) {
                try {
                    rsPaidInPaidOut.close();
                } catch (SQLException e) {
                    logger.error("SQLException: " + e.getMessage());
                }
            }
            if (psPaidInPaidOut != null) {
                psPaidInPaidOut.close();
            }
        }
        model.getOrderModel().setOrderType(orderTypPaidInOut);

        //get descPaidInOut
        String descPaidInOut = CawOrderServiceItems
                .getDescPaidOut(conn, model.getReasonCode());
        CawPaidInOutDetail paidIODetail = new CawPaidInOutDetail();
        paidIODetail.setCode(model.getReasonCode());
        paidIODetail.setDescription(descPaidInOut);
        model.getOrderModel().setPaidInOutDetail(paidIODetail);

        return orderTypPaidInOut;
    }

    /**
     * Send Request to ESB, and update status to DB
     * @param conn
     * @param model
     * @param correlationKey
     * @param jsonString
     * @return
     */
    private int sendRequestToESB(Connection conn, CawTransactionModel model,
            String correlationKey, String jsonString) {

        RestClientResponseException ex = null; //BZ52877
        Exception exOffline = null;
        String urlAPI = this.getServiceUrl(model);//BZ37463
        
        //Start BZ48630
        String urlAPIPropName = this.getServiceUrlPropName(model);
        
        boolean isUseToken = this.isUseToken(model); //BZ48630
        
        if(isUseToken) {
            urlAPI = CawPropertiesConfig.get(urlAPIPropName);
        }
        //End BZ48630
        
        String neuronUser = CawPropertiesConfig
                .get(CawPKeyConstant.NEURON_USER);
        String neuronKey = CawPropertiesConfig.get(CawPKeyConstant.NEURON_KEY);
        
        //Start BZ48630
        if (urlAPI != null && urlAPI.length() > 0) {
            try {
                String[] splitUrl = urlAPI.trim().split("\\|");
                if(splitUrl != null && splitUrl.length == 3) {
                    urlAPI = splitUrl[0];
                    neuronUser = splitUrl[1];
                    neuronKey = splitUrl[2];
                }
            } catch (Exception ex_ebs) {
                logger.error("sendRequestToEBS-0: " + ex_ebs.getMessage());
            }
        } else {
            logger.info("sendRequestToEBS: URL is null or empty");
        }
        
        //End BZ48630

        //PREPARE HTTP SERVER VARIABLE
        HttpHeaders httpHeaders = null;
        HttpEntity<String> entity = null;
        ResponseEntity<String> result = null;
        boolean resultNotFound = false;
        int status = 0;
        String timeStamp = CawOrderServiceUtils.getFormatTimeStampt();
        try {

            httpHeaders = CawOrderServiceRestUtils.createHttpHeader(MediaType.APPLICATION_JSON
                    , neuronUser, neuronKey);
            
            /* BEGIN BZ48630: Handle to use TOKEN */
            if (isUseToken) {
                String authorization = StringUtils.EMPTY;
                HashMap<String, CawCheetahTokenModel> listTokenModel = CawOrderServiceTasks.getListTokenModel();
                //check list don't have key, have key but don't have object, have object but attribute of it is null, check expired token
                //then get new token from api
                if (listTokenModel != null){
                    if (!listTokenModel.containsKey(urlAPIPropName)) {
                    	CawOrderServiceUtils.getTokenFromApi(urlAPIPropName);
                    }
                    else if (isExpiredToken(listTokenModel.get(urlAPIPropName).getExpiresTime())) {
                    	CawOrderServiceUtils.getTokenFromApi(urlAPIPropName);
                    }
                }
                else {
                	CawOrderServiceUtils.getTokenFromApi(urlAPIPropName);
                }
                if (CawOrderServiceTasks.getListTokenModel() != null) {
                    if (CawOrderServiceTasks.getListTokenModel().get(urlAPIPropName) != null) {
                        authorization = listTokenModel.get(urlAPIPropName).getTokenType() + StringUtils.SPACE + listTokenModel.get(urlAPIPropName).getTokenAccess();
                        httpHeaders.set(CawCommonConstant.CAW_AUTHORIZATION, authorization);
                    }
                }

            }
            /* END BZ48630: Handle to use TOKEN */
            
            entity = new HttpEntity<String>(jsonString, httpHeaders);
            HttpMethod httpMethod = this.getHttpMethod(model); //BZ37463
            logger.info("REQUEST MESSAGE:\n" + jsonString);
            model.setRequestOrderService(jsonString);
            result = CawOrderServiceRestUtils.callServiceAPIResponseEntity(urlAPI, httpMethod, entity);
            
            //Start BZ52877
            logger.debug("callServiceAPIResponseEntity - result: " + result.toString());
            ResponseEntity<String> cloneResult = new ResponseEntity<String>(result.getBody(), result.getStatusCode());
            //End BZ52877
            
            /* BEGIN BZ48630, BZ61159 */
            try {
                JSONObject responseBody = new JSONObject(result.getBody());
                if(responseBody.has(CawCommonConstant.JSON_DATA) && !responseBody.isNull(CawCommonConstant.JSON_DATA)) {
                    JSONObject jsonData = responseBody.getJSONObject(CawCommonConstant.JSON_DATA);
                    if(jsonData.has(CawCommonConstant.JSON_ATTRIBUTES) && !jsonData.isNull(CawCommonConstant.JSON_ATTRIBUTES)){
                        JSONObject jsonAttributes = jsonData.getJSONObject(CawCommonConstant.JSON_ATTRIBUTES);
                        if (jsonAttributes.has(CawCommonConstant.JSON_ORDER_RESPONSE) && !jsonAttributes.isNull(CawCommonConstant.JSON_ORDER_RESPONSE)) {
                            //Start BZ52877
                            JSONObject responseBodyResult = jsonAttributes.getJSONObject(CawCommonConstant.JSON_ORDER_RESPONSE);
                            //End BZ52877
                            result = new ResponseEntity<String>(responseBodyResult.toString(),HttpStatus.OK);
                        }
                    }
                }
            }
            catch (Exception exc) {
                logger.error(exc);
            }
            /* END BZ48630, BZ61159 */
            
            /* BEGIN BZ29668 */
            CawOrderServiceUtils
                    .insertLogCawOrderServiceTable(conn, timeStamp, model.getTransSeq(), model.getStoreID(), model
                            .getRegID(), model.getBsnDate(), model
                                    .getRequestOrderService(), model.getResponseMessage(), model.getResponseCode());
            /* END BZ29668 */
            
            //BEGIN BZ52877, BZ61159
            //check status code = 200 and have result field and getResultCodeFromEBS() != 200 
            //call saveToDBWithErrorResponse method to handle error and save to DB
            try {
                 JSONObject responseOriginBody = new JSONObject(cloneResult.getBody());
                 if(result.getStatusCodeValue() == HttpStatus.OK.value()
                         && !responseOriginBody.has(CawCommonConstant.JSON_DATA)
                         && !responseOriginBody.has(CawCommonConstant.JSON_META)) {
                     return saveToDBWithErrorResponse(conn, model, correlationKey, status, cloneResult, timeStamp); //BZ53763
                 }
             } catch (Exception e) {
                 logger.warn("[Error when insert OS information to DB]: " + e);
             }
            //END BZ52877, BZ61159
            
            if (result.getStatusCodeValue() == HttpStatus.OK.value()) {
                CawOrderServiceUtils
                        .notifyInfoTransaction(result, correlationKey, model
                                .getPartyId(), model.getCountItem(), model
                                        .getCountTenders(), model
                                                .getOrderTotalWithTax());
                //this.setResponseOrderService(result.getBody());
                model.setResponseOrderService(result.getBody());
                //Begin BZ25254
                if (model.getPartyId() != null) {
                    CawOrderServiceCustomerTemplate
                            .updateAccountNumberAndDeleteQueue(conn, model
                                    .getCustModel(), result.getBody(), model);
                }
                //End BZ25254
                //UPDATE ALL RESPONSE INTO DATABASE
                model.setResponseCode(result.getStatusCodeValue());
                model.setResponseMessage(result.getBody());
                model.setResponseDesc(result.getBody());
                //Begin BZ23922
                CawOrderServiceUtils
                        .updateStatusCawOrderServiceTable(conn, 1, result.getBody(), model
                                        .getResponseCode(), result.getBody(), model
                                                        .getUpdDate(), model
                                                                .getTransSeq(), model
                                                                        .getStoreID(), model
                                                                                .getRegID(), model
                                                                                        .getBsnDate());
                //End BZ23922
                /* BEGIN BZ29668 */
                CawOrderServiceUtils.updateLogCawOrderServiceTable(conn, result.getBody(), model
                        .getResponseCode(), timeStamp, model.getTransSeq(), model.getStoreID(), model.getRegID());
                /* END BZ29668 */
                logger.debug("********** ALL RESPONSES HAS BEEN UPDATED SUCCESSFUL! **********");
                status = 1;         
            }
        } catch (Exception e) {
            logger.error("Error in sendRequestToESB-1: RESPONSE WITH ERROR: "
                    + e.getMessage());
            resultNotFound = true;

            /*Begin BZ23922: if result != null , 
            it means the results got response from EBS. 
            the value from response could be 400, 500...*/
            logger.info("TRANSACTION: " + correlationKey
                    + " HAS BEEN UPDATED INTO DATABASE WITH ERROR MESSAGE");
            logger.warn("Exeption occurs : " + e + "\n");
            if (e instanceof HttpClientErrorException) {
                ex = (HttpClientErrorException) e;
            } else if (e instanceof HttpServerErrorException) {
                ex = (HttpServerErrorException) e;
            } 
            else if(e instanceof UnknownHttpStatusCodeException) { 
                ex = (UnknownHttpStatusCodeException) e;//BZ52877
            }
            else if(e instanceof ResourceAccessException || e instanceof TimeoutException) {
                exOffline = e;//BZ52877
            }
            
        }

        if (resultNotFound) {
            if (ex == null && exOffline == null) {
                // UPDATE CODE ERROR = -1
                CawOrderServiceUtils
                        .updateStatusCawOrderServiceTable(conn, model
                                .getUpdateStatusRes(), model
                                        .getResponseMessage(), model
                                                .getResponseCode(), model
                                                        .getResponseDesc(), model
                                                                .getUpdDate(), model
                                                                        .getTransSeq(), model
                                                                                .getStoreID(), model
                                                                                        .getRegID(), model
                                                                                                .getBsnDate());
                /* BEGIN BZ29668 */
                CawOrderServiceUtils
                        .insertLogCawOrderServiceTable(conn, CawOrderServiceUtils.getFormatTimeStampt(), model
                                .getTransSeq(), model.getStoreID(), model.getRegID(), model.getBsnDate(), model
                                        .getRequestOrderService(), model.getResponseMessage(), model.getResponseCode());
                /* END BZ29668 */
                logger.warn("********** ALL RESPONSES HAS BEEN UPDATED WITH ERROR MESSAGE, IN CASE OF NETWORK ERROR.");
                //continue;
                status = -1;
            } else if(ex != null){
                //this.setResponseOrderService(ex.getResponseBodyAsString());
                model.setResponseOrderService(ex.getResponseBodyAsString());
                model.setResponseCode(ex.getRawStatusCode());
                model.setResponseMessage(ex.getResponseBodyAsString());
                //Start BZ52877
                if(model.getResponseMessage() == null || model.getResponseMessage().isEmpty()) {
                    model.setResponseMessage(ex.getMessage());
                } 
                //End BZ52877
                model.setResponseDesc(ex.getStatusText());
               //Start BZ52877
                if(model.getResponseDesc() == null || model.getResponseDesc().isEmpty()) {
                    model.setResponseDesc(ex.getMessage());
                }
                //End BZ52877
                if (model.getResponseCode() != HttpStatus.BAD_REQUEST.value()
                        && model.getResponseCode() != HttpStatus.INTERNAL_SERVER_ERROR
                                .value()) {
                    CawOrderServiceUtils
                            .updateOrderRetryCount(model.getRetry_count(), model
                                    .getTransSeq(), model.getStoreID(), model
                                            .getRegID(), model
                                                    .getBsnDate(), conn, model);

                    int maxRetryCount = CawPropertiesConfig
                            .getInt(CawPKeyConstant.MAX_RETRY_COUNT);
                    if (maxRetryCount > 0) {
                        if (model.getRetry_count() + 1 < maxRetryCount) {
                            //continue;
                            status = 0;//@TODO
                        } else {
                            model.setUpdateStatusRes(-2);
                            status = -2;
                        }
                    }
                }

                //UPDATE ALL RESPONSE INTO DATABASE
                CawOrderServiceUtils
                        .updateStatusCawOrderServiceTable(conn, model
                                .getUpdateStatusRes(), model
                                        .getResponseMessage(), model
                                                .getResponseCode(), model
                                                        .getResponseDesc(), model
                                                                .getUpdDate(), model
                                                                        .getTransSeq(), model
                                                                                .getStoreID(), model
                                                                                        .getRegID(), model
                                                                                                .getBsnDate());               
                CawOrderServiceUtils.sendNotifyEmail(correlationKey);
                /* BEGIN BZ29668 */
                CawOrderServiceUtils
                        .insertLogCawOrderServiceTable(conn, CawOrderServiceUtils.getFormatTimeStampt(), model
                                .getTransSeq(), model.getStoreID(), model.getRegID(), model.getBsnDate(), model
                                        .getRequestOrderService(), model.getResponseMessage(), model.getResponseCode());
                /* END BZ29668 */
                logger.warn("********** ALL RESPONSES HAS BEEN UPDATED WITH ERROR MESSAGE, IN CASE OF INVALID REQUEST");

            } 
            else {
                model.setResponseOrderService(exOffline.getMessage());
                if (exOffline instanceof ResourceAccessException) {
                	model.setResponseCode(0);
                }
                else {
                    model.setResponseCode(HttpStatus.REQUEST_TIMEOUT.value());
                }
                model.setResponseMessage(exOffline.getMessage());
                model.setResponseDesc(exOffline.getCause().toString());
                //UPDATE ALL RESPONSE INTO DATABASE
                CawOrderServiceUtils
                        .updateStatusCawOrderServiceTable(conn, model
                                .getUpdateStatusRes(), model
                                        .getResponseMessage(), model
                                                .getResponseCode(), model
                                                        .getResponseDesc(), model
                                                                .getUpdDate(), model
                                                                        .getTransSeq(), model
                                                                                .getStoreID(), model
                                                                                        .getRegID(), model
                                                                                                .getBsnDate());               
                CawOrderServiceUtils.sendNotifyEmail(correlationKey);
                CawOrderServiceUtils
                        .insertLogCawOrderServiceTable(conn, CawOrderServiceUtils.getFormatTimeStampt(), model
                                .getTransSeq(), model.getStoreID(), model.getRegID(), model.getBsnDate(), model
                                        .getRequestOrderService(), model.getResponseMessage(), model.getResponseCode());
                logger.warn("********** ALL RESPONSES HAS BEEN UPDATED WITH ERROR MESSAGE, IN CASE I/O ERROR OCCURS OR TIMEOUT");

            }
        }
        return status;
    }
   
    //BEGIN BZ52877, BZ61159
    private int saveToDBWithErrorResponse(Connection conn, CawTransactionModel model,
            String correlationKey, int status, ResponseEntity<String> cloneResult, String timeStamp) {
        logger.debug("insert DB - 8");
        
        model.setResponseOrderService(cloneResult.toString());
        logger.debug("setResponseOrderService: " + model.getResponseOrderService());
        try {
            JSONObject responseBody = new JSONObject(cloneResult.getBody());
            if(responseBody.has(CawCommonConstant.JSON_STATUS) && !responseBody.isNull(CawCommonConstant.JSON_STATUS)
                    && responseBody.has(CawCommonConstant.JSON_DETAIL) && !responseBody.isNull(CawCommonConstant.JSON_DETAIL)) {
                model.setResponseCode(responseBody.getInt(CawCommonConstant.JSON_STATUS));
                model.setResponseDesc(responseBody.getString(CawCommonConstant.JSON_DETAIL));
                model.setResponseMessage(responseBody.toString());
            } else if (responseBody.has(CawCommonConstant.JSON_ERROR_DESCRIPTION) && !responseBody.isNull(CawCommonConstant.JSON_ERROR_DESCRIPTION)
                    && responseBody.has(CawCommonConstant.JSON_ERROR) && !responseBody.isNull(CawCommonConstant.JSON_ERROR)) {
                model.setResponseCode(HttpStatus.NOT_FOUND.value());
                model.setResponseDesc(responseBody.getString(CawCommonConstant.JSON_ERROR_DESCRIPTION));
                model.setResponseMessage(responseBody.toString());
            } else {
                model.setResponseCode(HttpStatus.NOT_FOUND.value());
                model.setResponseDesc(responseBody.toString());
                model.setResponseMessage(responseBody.toString());
            }
        } catch (Exception e) {
            model.setResponseCode(HttpStatus.NOT_FOUND.value());
            model.setResponseDesc(e.getMessage());
            model.setResponseMessage(cloneResult.getBody());
            logger.debug("setResponseCode exception: " + model.getResponseCode());
            logger.debug("setResponseDesc exception: " + model.getResponseDesc());
            logger.debug("setResponseMessage: " + model.getResponseMessage());
        }
        logger.debug("setResponseCode: " + model.getResponseCode());
        logger.debug("setResponseDesc: " + model.getResponseDesc());
        logger.debug("setResponseMessage: " + model.getResponseMessage());
        //END BZ61159
        logger.debug("insert DB - 9");
        //UPDATE ALL RESPONSE INTO DATABASE
        CawOrderServiceUtils
                .updateStatusCawOrderServiceTable(conn, model
                        .getUpdateStatusRes(), model
                                .getResponseMessage(), model
                                        .getResponseCode(), model
                                                .getResponseDesc(), model
                                                        .getUpdDate(), model
                                                                .getTransSeq(), model
                                                                        .getStoreID(), model
                                                                                .getRegID(), model
                                                                                        .getBsnDate());
        CawOrderServiceUtils.sendNotifyEmail(correlationKey);

        /* BEGIN BZ53763 */
        CawOrderServiceUtils.updateLogCawOrderServiceTable(conn, model.getResponseMessage(), model.getResponseCode(), 
                timeStamp, model.getTransSeq(), model.getStoreID(), model.getRegID()); 
        /* END BZ53763 */
        
        logger.warn("********** ALL RESPONSES HAS BEEN UPDATED WITH ERROR MESSAGE");   
        return status;
        
    }
    //END BZ52877
    
    /**
     * Build a full request for ESB
     * @param conn
     * @param model
     * @return
     */
    private static String buildRequestESB(Connection conn,
            CawTransactionModel model) {

        String jsonString = null;
        try {
            if (model.isFlagCheckQueue()) {
                logger.info("********** TRANS'S IN QUEUE: "
                        + model.getTransSeq() + "**********");
                /*In case here's Offline, 
                 * then JsonCustomer will be sent. 
                 * the CawCustomerModel and party just only 
                 * use in case the URL link send to ESB 
                 * to get account's info have problem
                 */
                jsonString = CawOrderServiceUtils
                        .getOrderServiceRequest(conn, model, model
                                .getJsonCustomer());
                logger.debug("Customer's Json:" + model.getJsonCustomer());
            } else {
                logger.info("********** TRANS'S IN ONLINE: "
                        + model.getTransSeq() + "**********");
                jsonString = CawOrderServiceUtils
                        .getOrderServiceRequest(conn, model, null);
                if (model.getCustomerTemplate() != null) {
                    logger.debug("Customer's Json:"
                            + model.getCustomerTemplate().toString());
                } else {
                    logger.debug("Customer's Json is not found.");
                }

            }
        } catch (Exception e) {
            logger.error("Error in buildRequestESB-1: " + e.getMessage());
        }
        return jsonString;
    }
    
    /* BEGIN BZ37463 */
    /**
     * @param model
     */
    protected void loadSalesChannel(CawTransactionModel model) {

        CawSalesChannelModel salesChannel = new CawSalesChannelModel();
        salesChannel.setId(Integer.valueOf(CawUtils.getInstance().vInt(model.getStoreID())));
        salesChannel.setTerminal(Integer.valueOf(CawUtils.getInstance().vInt(model.getRegID())));

        if (model.getBrokeredOrderModel() != null
                && model.getBrokeredOrderModel().getChannelType() != null) {
            salesChannel.setChannelType(Integer.valueOf(model.getBrokeredOrderModel().getChannelType()));
        } else {
            salesChannel.setChannelType(Integer.valueOf(4));
        }
        salesChannel.setChannelTypeDescription(CawCommonConstant.RETAIL); //BZ63054
        model.getOrderModel().setSalesChannel(salesChannel);
    }

    /* BEGIN BZ37463 */
    /**
     * @return
     */
    protected String getServiceUrl(CawTransactionModel theOrderModel) {

        String urlAPI = CawPropertiesConfig.get(CawPKeyConstant.ORDER_SERVICE_API);

        if (CawOrderTypeEnum.BROKERED_ORDER_STATUS.equals(CawBrokeredOrderHelper
                .getInstance().isTransactionOrderTyle(theOrderModel))) {
            urlAPI = CawPropertiesConfig.get(CawPKeyConstant.ORDER_SERVICE_STATUS_API);
            /*BEGIN BZ48320*/
            if(theOrderModel.getBrokeredOrderModel().isVinTrans() == true && CawBrokeredOrderHelper.getInstance().isVinOrderLine(theOrderModel)) {
                urlAPI = CawPropertiesConfig.get(CawPKeyConstant.ORDER_SERVICE_CAPTURE_API);
            }
            /*END BZ48320*/
        }

        return urlAPI;
    }
    // Begin BZ48630 
    // Get URL property name
    protected String getServiceUrlPropName(CawTransactionModel theOrderModel) {
        String urlAPIPropName = CawPKeyConstant.ORDER_SERVICE_API + CawPKeyConstant.TOKEN;
        if (CawOrderTypeEnum.BROKERED_ORDER_STATUS.equals(CawBrokeredOrderHelper
                .getInstance().isTransactionOrderTyle(theOrderModel))) {
            urlAPIPropName = CawPKeyConstant.ORDER_SERVICE_STATUS_API + CawPKeyConstant.TOKEN;
            if(theOrderModel.getBrokeredOrderModel().isVinTrans() == true && CawBrokeredOrderHelper.getInstance().isVinOrderLine(theOrderModel)) {
                urlAPIPropName = CawPKeyConstant.ORDER_SERVICE_CAPTURE_API + CawPKeyConstant.TOKEN;
            }
        }
        return urlAPIPropName;
    }
    // End BZ48630
    /**
     * 
     * @param theOrderModel
     * @return
     */
    protected HttpMethod getHttpMethod(CawTransactionModel theOrderModel) {

        HttpMethod httpMethod =  HttpMethod.POST;//BZ61159
        
        return httpMethod;
    }
    /* END BZ37463 */
    
    /* BEGIN BZ48630: Handle to use TOKEN */
    protected boolean isUseToken(CawTransactionModel theOrderModel) {

        boolean isUseToken = false;
        //check url use token is exist then return true
        String UrlPropName = getServiceUrlPropName(theOrderModel);
        if(CawPropertiesConfig.get(UrlPropName + CawPKeyConstant.TOKEN) != null 
                && !CawPropertiesConfig.get(UrlPropName + CawPKeyConstant.TOKEN).isEmpty()) {
            isUseToken = true;
        }
        return isUseToken;
    }
    
    public static boolean isExpiredToken(String argExpiresTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CawCommonConstant.CAW_TOKEN_EXPIRED_TIME_FORMAT);
        Date expiredDate;
        try {
            expiredDate = dateFormat.parse(argExpiresTime);
            Date now = new Date();
            if(now.after(expiredDate)) {
                return true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    /* END BZ48630: Handle to use TOKEN */

    //BEGIN BZ51771
    public String getLoyaltyDetailFromDB(Connection conn, CawTransactionModel model) throws SQLException {

        String transSeq = model.getTransSeq();
        String reqID = model.getRegID();
        String locID = model.getStoreID();
        Timestamp bsnDate = model.getBsnDate();
        
        PreparedStatement psLoyaltyDetail = null;
        ResultSet rsLoyaltyDetail = null;
        String result = CawCommonConstant.EMPTY_STRING;
        StringBuilder builder = new StringBuilder();
        
        try {
            psLoyaltyDetail = conn
                    .prepareStatement(CawSQLConstant.QUERY_GET_ALL_PART_LOYALTY_DETAIL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //BZ55978  
            psLoyaltyDetail.setString(1, locID);
            psLoyaltyDetail.setString(2, reqID);
            psLoyaltyDetail.setString(3, transSeq);
            psLoyaltyDetail.setTimestamp(4, bsnDate);
            rsLoyaltyDetail = psLoyaltyDetail.executeQuery();
            logger.debug("getLoyaltyDetailFromDB()-Executed query for getLoyaltyDetailFromDB: \n"
                    + CawSQLConstant.QUERY_GET_ALL_PART_LOYALTY_DETAIL + " "
                    + Arrays.asList(locID, reqID, transSeq, bsnDate)); //BZ55978
            
            rsLoyaltyDetail.last();
            logger.debug("Result set loyalty detail size:" + rsLoyaltyDetail.getRow());
            rsLoyaltyDetail.beforeFirst();
            /* BEGIN BZ55978 */
            int countPart = 0;
            while(rsLoyaltyDetail.next()){
                countPart = countPart + 1;
                if(rsLoyaltyDetail.getString(CawDBFieldConstant.STRING_VALUE_FIELD) != null) {
                    builder.append(rsLoyaltyDetail.getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                    logger.debug("[ getLoyaltyDetailFromDB rsLoyaltyDetail] - Part " + countPart + ": " + result);
                }
            }
            logger.debug("[ getLoyaltyDetailFromDB rsLoyaltyDetail]: - Final: " + result);
            /* END BZ55978 */
        } catch (Exception e) {
            logger.error("Error when get Loyalty Detail: " + e.getMessage());
        } finally {
            if (rsLoyaltyDetail != null) {
                rsLoyaltyDetail.close();
            }
            //Close Prepare statement
            if (psLoyaltyDetail != null) {
                psLoyaltyDetail.close();
            }
        }
        /* BEGIN BZ55978 */
        if (builder.length() > 0) {
            return builder.toString();
        }
        /* END BZ55978 */
        return result;
    }
    // END BZ51771
    
    //BEGIN BZ61159
    public String getPitchesInfoFromDB(Connection conn,CawTransactionModel model) throws SQLException {
        String transSeq = model.getTransSeq();
        String reqID = model.getRegID();
        String locID = model.getStoreID();
        Timestamp bsnDate = model.getBsnDate();
        PreparedStatement psPitchesInfo = null;
        ResultSet rsPitchesInfo = null;
        String result = CawCommonConstant.EMPTY_STRING;
        StringBuilder builder = new StringBuilder();
        
        try {
            psPitchesInfo = conn
                    .prepareStatement(CawSQLConstant.QUERY_GET_ALL_PART_PITCHES_INFO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            psPitchesInfo.setString(1, locID);
            psPitchesInfo.setString(2, reqID);
            psPitchesInfo.setString(3, transSeq);
            psPitchesInfo.setTimestamp(4, bsnDate);
            rsPitchesInfo = psPitchesInfo.executeQuery();
            logger.debug("getPitchesInfoFromDB()-Executed query: \n"
                    + CawSQLConstant.QUERY_GET_ALL_PART_PITCHES_INFO + " "
                    + Arrays.asList(locID, reqID, transSeq, bsnDate));
            rsPitchesInfo.last();
            logger.debug("Result set Pitches Info size:" + rsPitchesInfo.getRow());
            rsPitchesInfo.beforeFirst();
            int countPart = 0;
            while(rsPitchesInfo.next()){
                countPart = countPart + 1;
                if(rsPitchesInfo.getString(CawDBFieldConstant.STRING_VALUE_FIELD) != null) {
                    builder.append(rsPitchesInfo.getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                    logger.debug("[getPitchesInfoFromDB rsPitchesInfo] - Part " + countPart + ": " + rsPitchesInfo.getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                }
            }
            logger.debug("[getPitchesInfoFromDB rsPitchesInfo]: - Final: " + builder.toString());
        } catch (Exception e) {
            logger.error("Error when get Pitches Info: " + e.getMessage());
        } finally {
            if (rsPitchesInfo != null) {
                rsPitchesInfo.close();
            }
            //Close Prepare statement
            if (psPitchesInfo != null) {
                psPitchesInfo.close();
            }
        }
        if (builder.length() > 0) {
            return builder.toString();
        }
        return result;
    }
    //END BZ61159
}
