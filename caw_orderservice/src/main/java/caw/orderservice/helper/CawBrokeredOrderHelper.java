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
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ38176              300920    [Internal] - The request of information Pickup store address (shipToInfo) is sent Incorrectly when create Order transaction in case the customer selects multiple pick-up stores
 * BZ40561              140121    OB Reject Reasons and Order Status
 * BZ40776              280121    [UAT] Duplicate and Missed Order service Messages on order status change in Xstore
 * BZ41065              030221    [UAT] Order Service send accept status with the reason code/desc for the subsequent reject/cancel
 * BZ40798              240221    Modification to member savings calculation
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ45903              250821    [Internal] Order Service - brokerItemDetail is incorrect if transaction included two same items but one is a sale item and one from EW order
 * BZ48320              220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 * BZ50194              221222    BOPIS orders with VIN Capture
 *===================================================================
 */

package caw.orderservice.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.orderservice.bean.CawOrderServiceCustomerTemplate;
import caw.orderservice.bean.CawOrderServiceUtils;
import caw.orderservice.constant.CawCommonConstant;
import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.constant.CawWSTemplateConstant;
import caw.orderservice.model.CawAttributesModel;
import caw.orderservice.model.CawBrokeredOrderLineModel;
import caw.orderservice.model.CawBrokeredOrderModel;
import caw.orderservice.model.CawItemModel;
import caw.orderservice.model.CawShipToInfoModel;
import caw.orderservice.model.CawTheOrderModel;
import caw.orderservice.model.CawTransactionModel;
import twitter4j.JSONObject;

/**
 *
 */
public class CawBrokeredOrderHelper {

    private static Logger    logger   = Logger.getLogger(CawBrokeredOrderHelper.class);

    private static volatile CawBrokeredOrderHelper INSTANCE = null;

    public static CawBrokeredOrderHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawBrokeredOrderHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawBrokeredOrderHelper();
                }
            }
        }

        return INSTANCE;
    }

    /* BEGIN BZ37463 */
    /**
     * The method returns an object type is CawBrokeredOrderModel if this is a BrokeredOrder transaction.
     * @param conn
     * @param model
     * @return
     */
    public CawBrokeredOrderModel loadBrokeredOrderTran(Connection conn,
            CawTransactionModel model) {

        CawBrokeredOrderModel brokeredOrderModel = null;
        /**
         *  If transaction have filed TRANS_TYPCODE = ORDER, the transaction will have status "Accepted 
         *  or Picked/Reserved or Un-reserved or Rejected
         */
        if (CawCommonConstant.TRANS_TYPE_ORDER_CODE.equalsIgnoreCase(model.getTransTypCode())) {
            brokeredOrderModel = loadBrokeredOrderFromPosTransaction(conn, model);
            if (brokeredOrderModel != null) {
                List<CawBrokeredOrderLineModel> cawBrokeredOrderLineModels = getBrokeredOrderLineById(conn, brokeredOrderModel.getOrderId());
                if (cawBrokeredOrderLineModels != null && cawBrokeredOrderLineModels.size() > 0) {
                    brokeredOrderModel.setCawBrokeredOrderLineModel(cawBrokeredOrderLineModels);
                    // Begin BZ-40776
                    if (StringUtils.isEmpty(brokeredOrderModel.getPosStatus())) {
                        brokeredOrderModel.setPosStatus(cawBrokeredOrderLineModels.get(0).getStatusCode());
                    } // End BZ-40776
                }
            }
        } else {
            /**
             * This is BrokeredOrder transaction (Delivery or Pickup  or Completed/Picked
             * or Cancelled) If the SQL CawSQLConstant.QUERY_BROKERED_ORDER_TRANS have data.
             */

            brokeredOrderModel = loadBrokeredOrderByRetailTransaction(conn, model, brokeredOrderModel);
            if (brokeredOrderModel != null) {
                brokeredOrderModel
                        .setTransType(CawCommonConstant.TRANS_TYPE_ORDER_RETAIL_TRANSACTION);
                loadBrokeredOrderLine(conn, brokeredOrderModel, model);
                loadOrderShippingInfo(conn, brokeredOrderModel);
            }
        }

        return brokeredOrderModel;
    }

    /**
     * @param conn
     * @param model
     * @param brokeredOrderModel
     * @return
     */
    public CawBrokeredOrderModel loadBrokeredOrderFromPosTransaction(
            Connection conn, CawTransactionModel model) {

        CawBrokeredOrderModel brokeredOrderModel = createBrokeredOrderByPosTransaction(conn, model);
        if (brokeredOrderModel != null) {
            loadBrokeredOrderById(conn, brokeredOrderModel);
        }

        return brokeredOrderModel;
    }

    /**
     * @param conn
     * @param model
     * @param brokeredOrderModel
     * @return
     */
    protected CawBrokeredOrderModel createBrokeredOrderByPosTransaction(
            Connection conn, CawTransactionModel model) {

        CawBrokeredOrderModel brokeredOrderModel = null;
        String sqlBrokeredOrder = null;
        PreparedStatement psBrokeredOrder = null;
        ResultSet rsBrokeredOrder = null;
        try {
            sqlBrokeredOrder = CawSQLConstant.QUERY_BROKERED_ORDER_FROM_TRANS_P;
            psBrokeredOrder = conn
                    .prepareStatement(sqlBrokeredOrder, ResultSet.TYPE_SCROLL_INSENSITIVE);
            psBrokeredOrder.setString(1, model.getTransSeq());
            psBrokeredOrder.setString(2, model.getStoreID());
            psBrokeredOrder.setString(3, model.getRegID());
            psBrokeredOrder.setTimestamp(4, model.getBsnDate());
            rsBrokeredOrder = psBrokeredOrder.executeQuery();

            logger.debug("Executed query to load Brokered Order from table transaction property: \n"
                    + sqlBrokeredOrder + " "
                    + Arrays.asList(model.getStoreID(), model
                            .getBsnDate(), model
                                    .getRegID(), model.getTransSeq()));

            String orderId = null;
            String orderStatus = null;
            while (rsBrokeredOrder.next()) {
                if (CawDBFieldConstant.BROKERED_ORDER_ID
                        .equalsIgnoreCase(rsBrokeredOrder
                                .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD))) {
                    orderId = rsBrokeredOrder
                            .getString(CawDBFieldConstant.STRING_VALUE_FIELD);
                }

                // Begin BZ-40776
                if (CawDBFieldConstant.BROKERED_ORDER_ORDER_STATUS_LINES
                        .equalsIgnoreCase(rsBrokeredOrder
                                .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD))) {
                    orderStatus = rsBrokeredOrder
                            .getString(CawDBFieldConstant.STRING_VALUE_FIELD);
                }
            }

            if (orderId != null) {
                // End BZ-40776
                brokeredOrderModel = new CawBrokeredOrderModel();
                brokeredOrderModel.setOrderId(orderId);
                brokeredOrderModel.setPosStatus(orderStatus);
                brokeredOrderModel.setTransType(CawCommonConstant.TRANS_TYPE_ORDER_CODE);
            }

        } catch (Exception e) {
            logger.error("The exception happened in method loadBrokeredOrderTransaction(): "
                    + e.getMessage());
        } finally {
            if (rsBrokeredOrder != null) {
                try {
                    rsBrokeredOrder.close();
                } catch (SQLException e) {
                    logger.error("Method loadBrokeredOrderTransaction() close the ResultSet: "
                            + e.getMessage());
                }
            }
            if (psBrokeredOrder != null) {
                try {
                    psBrokeredOrder.close();
                } catch (SQLException e) {
                    logger.error("Method loadBrokeredOrderTransaction() close the PreparedStatement: "
                            + e.getMessage());
                }
            }
        }

        return brokeredOrderModel;
    }

    /**
     * @param conn
     * @param model
     * @param brokeredOrderModel
     * @return
     */
    protected CawBrokeredOrderModel loadBrokeredOrderByRetailTransaction(
            Connection conn, CawTransactionModel model,
            CawBrokeredOrderModel brokeredOrderModel) {

        String sqlBrokeredOrder = null;
        PreparedStatement psBrokeredOrder = null;
        ResultSet rsBrokeredOrder = null;
        try {
            sqlBrokeredOrder = CawSQLConstant.QUERY_BROKERED_ORDER_TRANS;
            psBrokeredOrder = conn
                    .prepareStatement(sqlBrokeredOrder, ResultSet.TYPE_SCROLL_INSENSITIVE);
            psBrokeredOrder.setString(1, model.getStoreID());
            psBrokeredOrder.setTimestamp(2, model.getBsnDate());
            psBrokeredOrder.setString(3, model.getRegID());
            psBrokeredOrder.setString(4, model.getTransSeq());
            rsBrokeredOrder = psBrokeredOrder.executeQuery();

            logger.debug("Executed query to load Brokered Order transaction: \n"
                    + sqlBrokeredOrder + " "
                    + Arrays.asList(model.getStoreID(), model
                            .getBsnDate(), model
                                    .getRegID(), model.getTransSeq()));

            if (rsBrokeredOrder.next()) {
                brokeredOrderModel = new CawBrokeredOrderModel();
                String transSeq = rsBrokeredOrder
                        .getString(CawDBFieldConstant.TRANS_SEQ_FIELD);
                String orderId = rsBrokeredOrder
                        .getString(CawDBFieldConstant.BROKERED_ORDER_ID);
                String orderType = rsBrokeredOrder
                        .getString(CawDBFieldConstant.BROKERED_ORDER_TYPE);
                String statusCode = rsBrokeredOrder
                        .getString(CawDBFieldConstant.BROKERED_ORDER_STATUS_CODE);

                brokeredOrderModel
                        .setChannelType(CawCommonConstant.BROKERED_ORDER_CHANNEL_TYPE);
                brokeredOrderModel.setTransSeq(transSeq);
                brokeredOrderModel.setOrderType(orderType);
                brokeredOrderModel.setOrderId(orderId);
                brokeredOrderModel.setPosStatus(statusCode);
            }
        } catch (Exception e) {
            logger.error("The exception happened in method loadBrokeredOrderTransaction(): "
                    + e.getMessage());
        } finally {
            if (rsBrokeredOrder != null) {
                try {
                    rsBrokeredOrder.close();
                } catch (SQLException e) {
                    logger.error("Method loadBrokeredOrderTransaction() close the ResultSet: "
                            + e.getMessage());
                }
            }
            if (psBrokeredOrder != null) {
                try {
                    psBrokeredOrder.close();
                } catch (SQLException e) {
                    logger.error("Method loadBrokeredOrderTransaction() close the PreparedStatement: "
                            + e.getMessage());
                }
            }
        }
        return brokeredOrderModel;
    }

    /**
     * The method load Brokered Order lines
     * @param conn
     * @param brokeredOrderModel
     * @param model
     * @return
     */
    protected void loadBrokeredOrderById(Connection conn,
            CawBrokeredOrderModel brokeredOrderModel) {

        if (brokeredOrderModel != null) {
            String sqlBrokeredOrder = null;
            PreparedStatement psBrokeredOrder = null;
            ResultSet rsBrokeredOrder = null;
            try {
                sqlBrokeredOrder = CawSQLConstant.QUERY_BROKERED_ORDER_BY_ID;
                psBrokeredOrder = conn
                        .prepareStatement(sqlBrokeredOrder, ResultSet.TYPE_SCROLL_INSENSITIVE);
                psBrokeredOrder.setString(1, brokeredOrderModel.getOrderId());
                rsBrokeredOrder = psBrokeredOrder.executeQuery();

                logger.debug("Executed query to load Brokered Order transaction: \n"
                        + sqlBrokeredOrder + " "
                        + Arrays.asList(brokeredOrderModel.getOrderId()));

                if (rsBrokeredOrder.next()) {
                    String orderId = rsBrokeredOrder.getString(CawDBFieldConstant.BROKERED_ORDER_ID);
                    String orderType = rsBrokeredOrder.getString(CawDBFieldConstant.BROKERED_ORDER_TYPE);

                    brokeredOrderModel.setChannelType(CawCommonConstant.BROKERED_ORDER_CHANNEL_TYPE);
                    brokeredOrderModel.setOrderType(orderType);
                    brokeredOrderModel.setOrderId(orderId);
                }
            } catch (Exception e) {
                logger.error("The exception happened in method loadBrokeredOrderTransaction(): "
                        + e.getMessage());
            } finally {
                if (rsBrokeredOrder != null) {
                    try {
                        rsBrokeredOrder.close();
                    } catch (SQLException e) {
                        logger.error("Method loadBrokeredOrderTransaction() close the ResultSet: "
                                + e.getMessage());
                    }
                }
                if (psBrokeredOrder != null) {
                    try {
                        psBrokeredOrder.close();
                    } catch (SQLException e) {
                        logger.error("Method loadBrokeredOrderTransaction() close the PreparedStatement: "
                                + e.getMessage());
                    }
                }
            }
        }

    }

    /**
     * @param model
     * @param theOrdModel
     * @param result
     * @return
     */
    protected String loadOrderType(CawTransactionModel model,
            CawTheOrderModel theOrdModel, String result) {
        // Set order orderType
        String originalTempBuff = null;
        String orderType = theOrdModel.getOrderType();
        if (model.getBrokeredOrderModel() != null
                && model.getBrokeredOrderModel().getOrderType() != null) {
            String brokeredOrderType = model.getBrokeredOrderModel().getOrderType();
            if (CawCommonConstant.BROKERED_ORDER_STANDARD_DELIVERY.equalsIgnoreCase(brokeredOrderType)) {
                orderType = CawCommonConstant.BROKERED_ORDER_TYPE_DELIVERY;
            } else if (CawCommonConstant.BROKERED_ORDER_STANDARD_PICKUP.equalsIgnoreCase(brokeredOrderType)) {
                orderType = CawCommonConstant.BROKERED_ORDER_TYPE_PICKUP;
            }
        }

        result = result.replace(CawWSTemplateConstant.ORDER_TYPE_ATTR, null);
        result = result.replace(CawCommonConstant.ATTR_ORDER_DETAIL, originalTempBuff);

        return result;
    }
    
    /**
     * 
     * @param model
     * @return
     */
    public String buildOrderBrokerServiceRequest(Connection conn,
            CawTransactionModel model, String customerOffline) {

        CawTheOrderModel theOrdModel = model.getOrderModel();

        String jsonCustomerApplyNow = null;

        String result = null;

        if (CawCommonConstant.TRANS_TYPE_ORDER_RETAIL_TRANSACTION
                .equalsIgnoreCase(model.getBrokeredOrderModel()
                        .getTransType())) {
            // BUILD MESSAGE FOR THE CREATE ORDER

            try {

                String orderServiceTemplate = CawOrderServiceUtils
                        .readRequestTemplate(CawWSTemplateConstant.ORDER_SERVICE_TEMPLATE);

                if (orderServiceTemplate != null
                        && orderServiceTemplate.length() > 0) {
                    // BUILD SALE CHANNEL
                    result = String.valueOf(orderServiceTemplate);

                    result = result
                            .replace(CawWSTemplateConstant.ID_SALE_CHANEL_ATTR, theOrdModel
                                    .getSalesChannel().getId().toString());
                    result = result
                            .replace(CawWSTemplateConstant.TERMINAL_ATTR, theOrdModel
                                    .getSalesChannel().getTerminal()
                                    .toString());
                    result = result
                            .replace(CawWSTemplateConstant.CHANNEL_TYPE_ATTR, theOrdModel
                                    .getSalesChannel().getChannelType()
                                    .toString());
                    // END BUILD SALE CHANNEL

                    result = result
                            .replace(CawWSTemplateConstant.ORDER_TYPE_ATTR, CawOrderServiceUtils
                                    .formatParameter(theOrdModel
                                            .getOrderType()));

                    // BUILD ORDER DETAIL
                    if (theOrdModel.getWorkOrderDetail() != null) {
                        result = result
                                .replace(CawWSTemplateConstant.WORK_ORDER_DETAIL_ATTR, CawOrderServiceUtils
                                        .getWorkOrderRequest(theOrdModel
                                                .getWorkOrderDetail(), CawWSTemplateConstant.WORK_ORDER_DETAIL_TEMPLATE));
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.WORK_ORDER_DETAIL_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    // END BUILD ORDER DETAIL

                    // BUILD PAID_IN_OUT_DETAIL DETAIL
                    if (theOrdModel.getPaidInOutDetail() != null) {
                        result = result
                                .replace(CawWSTemplateConstant.PAID_IN_OUT_DETAIL_ATTR, CawOrderServiceUtils
                                        .getPaidInOutRequest(theOrdModel
                                                .getPaidInOutDetail(), CawWSTemplateConstant.PAID_IN_OUT_DETAIL_TEMPLATE));
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.PAID_IN_OUT_DETAIL_ATTR, CawCommonConstant.NULL_STRING);
                    }

                    // END BUILD PAID_IN_OUT_DETAIL DETAIL

                    // BUILD ORDER ID AND CORRELATIONKEY
                    result = result
                            .replace(CawWSTemplateConstant.ID_ORDER_ATTR, theOrdModel
                                    .getId().toString());
                    result = result
                            .replace(CawWSTemplateConstant.CORRELATION_KEY_ATTR, CawOrderServiceUtils
                                    .formatParameter(theOrdModel
                                            .getCorrelationKey()));
                    // END BUILD ORDER ID AND CORRELATIONKEY

                    //CASHIER INFO
                    if (theOrdModel.getCashier() != null) {
                        result = result
                                .replace(CawWSTemplateConstant.CASHIER_ATTR, CawOrderServiceUtils
                                        .getCashierRequest(theOrdModel
                                                .getCashier(), CawWSTemplateConstant.CASHIER_TEMPLATE));
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.CASHIER_ATTR, CawCommonConstant.NULL_STRING);
                    }

                    result = result
                            .replace(CawWSTemplateConstant.ORDER_DATE_ATTR, CawOrderServiceUtils
                                    .formatParameter(theOrdModel
                                            .getOrderDate()));
                    result = result
                            .replace(CawWSTemplateConstant.ORDER_TOTAL_WITH_TAX_ATTR, String
                                    .valueOf(theOrdModel
                                            .getOrderTotalWithTax()));
                    //CUSTOMER
                    if (theOrdModel.getCustomer() != null
                            && theOrdModel.getCustomer().getPartyId() != null) {
                        if (customerOffline != null
                                && customerOffline.length() > 0) {
                            //Step1: OFFLINE Forced from parent method
                            jsonCustomerApplyNow = customerOffline;
                        } else {
                            //Step2: ONLINE Forced
                            if (model.getAccountNumber() > 0) {
                                try {
                                    String accountNumber = String
                                            .valueOf(model.getAccountNumber());
                                    jsonCustomerApplyNow = CawOrderServiceUtils
                                            .lookUpCustomer(accountNumber, model
                                                    .getStoreID());
                                } catch (Exception e) {
                                    logger.error("Could not lookup Account Customer : "
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
                                        jsonCustomerApplyNow = template
                                                .toString();
                                    }
                                } catch (Exception e) {
                                    logger.error("Could not create Temp Customer: "
                                            + e.getMessage());
                                }

                            }
                        }

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
                        String shipToInfo = CawOrderServiceUtils
                                .getShipToInfoRequest(theOrdModel
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

                    String itemRequest = CawOrderServiceUtils
                            .getItemsRequest(theOrdModel, CawWSTemplateConstant.ITEMS_TEMPLATE, model);

                    if (itemRequest != null) {
                        result = result
                                .replace(CawWSTemplateConstant.ITEMS_ATTR, itemRequest);
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.ITEMS_ATTR, CawCommonConstant.NULL_STRING);
                    }

                    //TENDERS
                    String tenderRequest = CawOrderServiceUtils
                            .getTendersRequest(theOrdModel, CawWSTemplateConstant.TENDERS_TEMPLATE);
                    if (tenderRequest != null) {
                        result = result
                                .replace(CawWSTemplateConstant.TENDERS_ATTR, tenderRequest);
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.TENDERS_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    result = result
                            .replace(CawWSTemplateConstant.PURCHASE_ORDER_ATTR, CawOrderServiceUtils
                                    .formatParameter(CawOrderServiceUtils
                                            .purchaseOrderTemplate(theOrdModel)));

                    //RECEIPT TYPE
                    result = result
                            .replace(CawWSTemplateConstant.RECEIPT_TYPE_ATTR, CawOrderServiceUtils
                                    .formatParameter(theOrdModel
                                            .getReceiptType()));
                    result = result
                            .replace(CawWSTemplateConstant.E_RECEIPT_EMAIL_ATTR, CawOrderServiceUtils
                                    .formatParameter(theOrdModel
                                            .getEReceiptEmail()));

                    /* BEGIN BZ40798 */
                    //ATTRUBUTE FIELDS
                    CawAttributesModel attrModel = theOrdModel.getAttributes();
                    String attRequest = CawOrderServiceUtils
                            .getGoodSamSavingAttribute(attrModel);
                    if (attRequest != null) {
                        String attributes = CawWSTemplateConstant.ATTRIBUTES_TEMPLATE;
                        attributes = attributes.replace(CawWSTemplateConstant.ATTRIBUTES_GOOD_SAM_SAVINGS, CawOrderServiceUtils.formatNullString(attrModel.getGoodSamSavings())); // Null = "0.00"
                        attributes = attributes.replace(CawWSTemplateConstant.ATTRIBUTES_COULD_SAVE, CawOrderServiceUtils.formatNullString(attrModel.getCouldSave())); // Null = "0.00"
                        /*BEGIN BZ44528*/
                        if(!StringUtils.isEmpty(attrModel.getCartIDs())) {
                            JSONObject jsonAttributes = new JSONObject(attributes);
                            jsonAttributes.put(CawCommonConstant.ATTRIBUTES_CARTIDS, attrModel.getCartIDs());
                            result = result.replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, jsonAttributes.toString());
                        }else {
                            result = result.replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, attributes);
                        }
                        /*END BZ44528*/
                    } else {
                        result = result
                                .replace(CawWSTemplateConstant.ATTRIBUTES_ATTR, CawCommonConstant.NULL_STRING);
                    }
                    /* END BZ40798 */
                }
            } catch (Exception e) {
                logger.error("Could not build Order Broker Message: "
                        + e.getMessage());
            }
        }
        return result;

    }

    /**
     * @param conn
     * @param orderId
     * @return
     */
    public List<CawBrokeredOrderLineModel> getBrokeredOrderLineById(Connection conn, String orderId) {

        if (orderId != null) {
            List<CawBrokeredOrderLineModel> cawBrokeredOrderLines = new ArrayList<CawBrokeredOrderLineModel>();
            String sqlBrokeredOrderLine = null;
            PreparedStatement psBrokeredOrderLine = null;
            ResultSet rsBrokeredOrderLines = null;
            try {
                sqlBrokeredOrderLine = CawSQLConstant.QUERY_BROKERED_ORDER_LINES_BY_ID;
                psBrokeredOrderLine = conn.prepareStatement(sqlBrokeredOrderLine, ResultSet.TYPE_SCROLL_INSENSITIVE);
                psBrokeredOrderLine.setString(1, orderId);
                rsBrokeredOrderLines = psBrokeredOrderLine.executeQuery();

                logger.debug("Executed query to load loadBrokeredOrderLineById transaction: \n"
                        + sqlBrokeredOrderLine + " " + Arrays.asList(orderId));

                CawBrokeredOrderLineModel brokeredOrderLineModel = null;
                while (rsBrokeredOrderLines.next()) {
                    brokeredOrderLineModel = new CawBrokeredOrderLineModel();

                    brokeredOrderLineModel = new CawBrokeredOrderLineModel();
                    brokeredOrderLineModel.setOrderId(orderId);
                    brokeredOrderLineModel.setDetailSeq(rsBrokeredOrderLines.getInt("DETAIL_SEQ"));
                    brokeredOrderLineModel.setRequestId(rsBrokeredOrderLines.getString("EXTERNAL_ORDER_ID"));
                    brokeredOrderLineModel.setItemId(rsBrokeredOrderLines.getString("ITEM_ID"));
                    brokeredOrderLineModel.setQuantity(rsBrokeredOrderLines.getInt("QUANTITY"));
                    brokeredOrderLineModel.setFulfillmentType(rsBrokeredOrderLines.getString("FULFILLMENT_TYPE"));
                    brokeredOrderLineModel.setStatusCode(rsBrokeredOrderLines.getString("STATUS_CODE"));
                    // Begin BZ-40561
                    brokeredOrderLineModel.setStatusCodeReason(rsBrokeredOrderLines.getString(CawDBFieldConstant.BROKERED_ORDER_STATUS_CODE_REASON));
                    brokeredOrderLineModel.setStatusCodeReasonNote(rsBrokeredOrderLines.getString(CawDBFieldConstant.BROKERED_ORDER_STATUS_CODE_REASON_NOTE));
                    // End BZ-40561

                    cawBrokeredOrderLines.add(brokeredOrderLineModel);
                }
            } catch (Exception e) {
                logger.error("The exception happened in method loadBrokeredOrderLineById(): "
                        + e.getMessage());
            } finally {
                if (rsBrokeredOrderLines != null) {
                    try {
                        rsBrokeredOrderLines.close();
                    } catch (SQLException e) {
                        logger.error("Method loadBrokeredOrderLineById() close the ResultSet: "
                                + e.getMessage());
                    }
                }
                if (psBrokeredOrderLine != null) {
                    try {
                        psBrokeredOrderLine.close();
                    } catch (SQLException e) {
                        logger.error("Method loadBrokeredOrderLine() close the PreparedStatement: "
                                + e.getMessage());
                    }
                }
            }

            if (cawBrokeredOrderLines.size() > 0) {
                return cawBrokeredOrderLines;
            }
        }
        
        return null;

    }

    /**
     * The method load Brokered Order lines
     * @param conn
     * @param brokeredOrderModel
     * @param model
     * @return
     */
    public void loadBrokeredOrderLine(Connection conn,
            CawBrokeredOrderModel brokeredOrderModel,
            CawTransactionModel model) {

        List<CawBrokeredOrderLineModel> brokeredOrderModels = new ArrayList<CawBrokeredOrderLineModel>();
        String sqlBrokeredOrderLine = null;
        PreparedStatement psBrokeredOrderLine = null;
        ResultSet rsBrokeredOrderLines = null;
        try {
            sqlBrokeredOrderLine = CawSQLConstant.QUERY_BROKERED_ORDER_LINES;
            psBrokeredOrderLine = conn
                    .prepareStatement(sqlBrokeredOrderLine, ResultSet.TYPE_SCROLL_INSENSITIVE);
            psBrokeredOrderLine.setTimestamp(1, model.getBsnDate());
            psBrokeredOrderLine.setString(2, model.getStoreID());
            psBrokeredOrderLine.setString(3, model.getRegID());
            psBrokeredOrderLine.setString(4, model.getTransSeq());
            rsBrokeredOrderLines = psBrokeredOrderLine.executeQuery();

            logger.debug("Executed query to load loadBrokeredOrderLine transaction: \n"
                    + sqlBrokeredOrderLine + " "
                    + Arrays.asList(model.getStoreID(), model
                            .getBsnDate(), model
                                    .getRegID(), model.getTransSeq()));

            while (rsBrokeredOrderLines.next()) {

                String itemId = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.ITEM_ID_FIELD);

                String shippingMethod = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.SELECTED_SHIP_METHOD);

                String shippingMethodDes = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.SHIPPER_METHOD_DESC);

                String requestId = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.EXTERNAL_ORDER_ID);

                String fullfillType = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.FULFILLMENT_TYPE);

                String orderId = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.BROKERED_ORDER_ID);
                
                String statusCode = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.BROKERED_ORDER_STATUS_CODE);
                /* BEGIN BZ38716 */
                int detailSeq = rsBrokeredOrderLines
                        .getInt(CawDBFieldConstant.DETAIL_SEQ);               
                /* END BZ38716 */
                // Begin BZ-40561
                String statusCodeReason = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.BROKERED_ORDER_STATUS_CODE_REASON);
                
                String statusCodeReasonNote = rsBrokeredOrderLines
                        .getString(CawDBFieldConstant.BROKERED_ORDER_STATUS_CODE_REASON_NOTE);
                // End BZ-40561
                int transLineItemSeq = rsBrokeredOrderLines.getInt(CawDBFieldConstant.RTRANS_LINEITM_SEQ_FIELD);/*BZ45903*/
                String vinNumber = rsBrokeredOrderLines.getString(CawDBFieldConstant.STRING_VALUE_FIELD);/*BZ48320*/
                CawBrokeredOrderLineModel brokeredOrderModelLine = new CawBrokeredOrderLineModel();
                brokeredOrderModelLine.setItemId(itemId);
                brokeredOrderModelLine.setShippingMethod(shippingMethod);
                brokeredOrderModelLine.setShippingMethodDes(shippingMethodDes);
                brokeredOrderModelLine.setRequestId(requestId);
                brokeredOrderModelLine.setFulfillmentType(fullfillType);
                brokeredOrderModelLine.setOrderId(orderId);
                brokeredOrderModelLine.setStatusCode(statusCode);
                brokeredOrderModelLine.setDetailSeq(detailSeq); // BZ38716
                // Begin BZ-40561
                brokeredOrderModelLine.setStatusCodeReason(statusCodeReason);
                brokeredOrderModelLine.setStatusCodeReasonNote(statusCodeReasonNote);
                // End BZ-40561
                brokeredOrderModelLine.setRtransLineitmSeq(transLineItemSeq);/*BZ45903*/
                brokeredOrderModelLine.setVinNumber(vinNumber);/*BZ48320*/
                brokeredOrderModels.add(brokeredOrderModelLine);
            }
        } catch (Exception e) {
            logger.error("The exception happened in method loadBrokeredOrderLine(): "
                    + e.getMessage());
        } finally {
            if (rsBrokeredOrderLines != null) {
                try {
                    rsBrokeredOrderLines.close();
                } catch (SQLException e) {
                    logger.error("Method loadBrokeredOrderLine() close the ResultSet: "
                            + e.getMessage());
                }
            }
            if (psBrokeredOrderLine != null) {
                try {
                    psBrokeredOrderLine.close();
                } catch (SQLException e) {
                    logger.error("Method loadBrokeredOrderLine() close the PreparedStatement: "
                            + e.getMessage());
                }
            }
        }

        if (brokeredOrderModels.size() > 0) {

            brokeredOrderModel
                    .setCawBrokeredOrderLineModel(brokeredOrderModels);

        }

    }

    /**
     * @param conn
     * @param brokeredOrderModel
     */
    public void loadOrderShippingInfo(Connection conn,
            CawBrokeredOrderModel brokeredOrderModel) {

        if (conn != null && brokeredOrderModel != null) {

            String sqlShippingInfo = null;
            CawShipToInfoModel orderShippingInfoModel = null;
            PreparedStatement psShippingInfo = null;
            ResultSet rsShippingInfo = null;
            
            List<CawShipToInfoModel> shipToInfoModels = new ArrayList<CawShipToInfoModel>();// BZ38716

            sqlShippingInfo = CawSQLConstant.QUERY_SHIPPING_INFO;
            try {

                psShippingInfo = conn
                        .prepareStatement(sqlShippingInfo, ResultSet.TYPE_SCROLL_INSENSITIVE);
                psShippingInfo.setString(1, brokeredOrderModel.getOrderId());
                rsShippingInfo = psShippingInfo.executeQuery();

                while (rsShippingInfo.next()) {

                    orderShippingInfoModel = new CawShipToInfoModel();

                    String firstName = rsShippingInfo
                            .getString(CawDBFieldConstant.BROKERED_LOC_NAME1);

                    String lastName = rsShippingInfo
                            .getString(CawDBFieldConstant.BROKERED_LOC_NAME2);

                    String name = "";

                    if (StringUtils.isNotEmpty(firstName)) {
                        name = firstName;
                    }
                    if (StringUtils.isNotEmpty(lastName)) {
                        name = name + " " + lastName;
                    }

                    orderShippingInfoModel.setName(name);
                    orderShippingInfoModel.setLine1(rsShippingInfo
                            .getString(CawDBFieldConstant.BROKERED_ADDRESS1));
                    orderShippingInfoModel.setCity(rsShippingInfo
                            .getString(CawDBFieldConstant.BROKERED_CITY));
                    orderShippingInfoModel.setStateProvince(rsShippingInfo
                            .getString(CawDBFieldConstant.BROKERED_STATE));

                    orderShippingInfoModel.setPostalCode(rsShippingInfo
                            .getString(CawDBFieldConstant.BROKERED_POSTAL_CODE));
                    orderShippingInfoModel.setCountry(rsShippingInfo
                            .getString(CawDBFieldConstant.BROKERED_COUNTRY));
                    /* BEGIN BZ38716 */
                    int detailSeq = rsShippingInfo
                            .getInt(CawDBFieldConstant.DETAIL_SEQ);

                    orderShippingInfoModel.setFullfillLocation(rsShippingInfo
                            .getString(CawDBFieldConstant.FULLFILLLOCATION_ID));

                    orderShippingInfoModel.setDetailSeq(detailSeq);

                    brokeredOrderModel
                            .setShipToInfoModel(orderShippingInfoModel);
                    shipToInfoModels.add(orderShippingInfoModel);
                    /* END BZ38716 */
                    
                }
                /* BEGIN BZ38716 */
                if (shipToInfoModels.size() > 0) {
                    brokeredOrderModel.setShipToInfoModels(shipToInfoModels);
                }
                /* END BZ38716 */
            } catch (Exception e) {
                logger.error("The exception happened in loading Order Shipping Info: "
                        + e.getMessage());
            } finally {
                if (rsShippingInfo != null) {
                    try {
                        rsShippingInfo.close();
                    } catch (SQLException e) {
                        logger.error("Method loadOrderShippingInfo close the ResultSet: "
                                + e.getMessage());
                    }
                }
                if (psShippingInfo != null) {
                    try {
                        psShippingInfo.close();
                    } catch (SQLException e) {
                        logger.error("Method loadOrderShippingInfo close the PreparedStatement: "
                                + e.getMessage());
                    }
                }
            }

        }
    }

    public CawBrokeredOrderLineModel getBrokeredOrderLineModel(
            List<CawBrokeredOrderLineModel> brokeredOrderLineModel,
            CawItemModel item) {

        if (brokeredOrderLineModel != null && brokeredOrderLineModel.size() > 0
                && item != null && StringUtils.isNotEmpty(item.getCode())) {
            for (CawBrokeredOrderLineModel orderLineModel : brokeredOrderLineModel) {
                if (StringUtils.isNotEmpty(orderLineModel.getItemId())
                        && item.getCode().equals(orderLineModel.getItemId())) {
                    return orderLineModel;
                }
            }
        }

        return null;
    }

    /**
     * @param theOrdModel
     * @param model
     */
    public String sendNotifyOrderStatus(CawTheOrderModel theOrdModel, CawTransactionModel model) {

        // BUILD MESSAGE FOR THE ORDER STATUS
        String result = null;
        if (theOrdModel != null && model != null) {
            try {
                String orderStatusTemplate = CawOrderServiceUtils
                        .readRequestTemplate(CawWSTemplateConstant.ORDER_STATUS_TEMPLATE);
                if (orderStatusTemplate != null
                        && orderStatusTemplate.length() > 0) {
                    result = String.valueOf(orderStatusTemplate);
                    // BUILD SALE CHANNEL                   
                    result = result
                            .replace(CawWSTemplateConstant.ID_SALE_CHANEL_ATTR, theOrdModel
                                    .getSalesChannel().getId().toString());
                    result = result
                            .replace(CawWSTemplateConstant.TERMINAL_ATTR, theOrdModel
                                    .getSalesChannel().getTerminal()
                                    .toString());
                    result = result
                            .replace(CawWSTemplateConstant.CHANNEL_TYPE_ATTR, theOrdModel
                                    .getSalesChannel().getChannelType().toString());
                    // END BUILD SALE CHANNEL 

                    // BUILD OB ORDER_ID
                    String obOrderReasonProperties; // BZ-40561
                    if (model != null
                            && model.getBrokeredOrderModel() != null) {
                        // Begin BZ-40561
                        result = fillDataForField(model.getBrokeredOrderModel().getOrderId(), CawWSTemplateConstant.OB_ORDER_ID, result);
                        result = fillDataForField(model.getBrokeredOrderModel().getPosStatus(), CawWSTemplateConstant.OB_ORDER_STAUS_CODE, result, true);
                        
                        obOrderReasonProperties = getOrderStatusProperties(model.getBrokeredOrderModel());
                        result = result.replace(CawWSTemplateConstant.OB_ORDER_REASON_PROPERTIES, obOrderReasonProperties);
                        // End BZ-40561
                    }
                }

            } catch (Exception e) {
                logger.error("Could not create Order Status: "
                        + e.getMessage());
            }
        }
        return result;
    }

    // Begin BZ-40561
    /**
     * 
     * @param data
     * @param field
     * @param result
     * @param isLowerOrUpperCase: if true, lower. if false, upper
     * @return
     */
    private String fillDataForField(String data, String field, String result, boolean isLowerOrUpperCase) {
        if (isLowerOrUpperCase) {
            data = StringUtils.lowerCase(data);
        } else {
            data = StringUtils.upperCase(data);
        }
        result = fillDataForField(data, field, result);
        return result;
    }
    
    /**
     * @param model
     * @param result
     * @return
     */
    private String fillDataForField(String data, String field, String result) {

        if (StringUtils.isNotEmpty(data)) {
            result = result.replace(field, CawOrderServiceUtils.formatParameter(data));
        } else {
            result = result.replace(field, CawCommonConstant.NULL_STRING);
        }
        return result;
    }
    
    /**
     * @param cawBrokeredOrderModel 
     * @return
     */
    private String getOrderStatusProperties(CawBrokeredOrderModel cawBrokeredOrderModel) {

        String result = StringUtils.EMPTY;
        String reason, sttCode; // BZ41065

        List<CawBrokeredOrderLineModel> cawBrokeredOrderLinesModel = cawBrokeredOrderModel
                .getCawBrokeredOrderLineModel();

        for (CawBrokeredOrderLineModel cawBrokeredOrderLineModel : cawBrokeredOrderLinesModel) {
            reason = cawBrokeredOrderLineModel.getStatusCodeReason();
            /* BEGIN BZ41065 */
            sttCode = cawBrokeredOrderModel.getPosStatus();
            if (StringUtils.isNotEmpty(reason)) {
                if (CawCommonConstant.BROKERED_ORDER_STT_CODE_CANCELLED.equalsIgnoreCase(sttCode)
                        || CawCommonConstant.BROKERED_ORDER_STT_CODE_REJECTED.equalsIgnoreCase(sttCode)) {
                    result = CawWSTemplateConstant.ORDER_REASON_PROPERTIES_TEMPLATE;

                    result = fillDataForField(reason, CawWSTemplateConstant.OB_ORDER_REASON_CODE, result);
                    result = fillDataForField(cawBrokeredOrderLineModel
                            .getStatusCodeReasonNote(), CawWSTemplateConstant.OB_ORDER_REASON_DESC, result);
                    // Xstore will reject all lines in order, therefore, need to get first line
                    break;
                }
            }
            /* END BZ41065 */
        }

        return result;
    }
    // End BZ-40561
    
    /**
     * 
     * @param model
     * @return
     */
    public CawOrderTypeEnum isTransactionOrderTyle(CawTransactionModel model) {

        CawOrderTypeEnum result = null;
        if (CawCommonConstant.TRANS_TYPE_ORDER_CODE.equalsIgnoreCase(model.getTransTypCode())) {
            // MESSAGE FOR THE ORDER STATUS
            // accept/reject, pick/reserve
            result = CawOrderTypeEnum.BROKERED_ORDER_STATUS;

        } else if (model.getBrokeredOrderModel() != null) {
            List<CawBrokeredOrderLineModel> orderLines = model.getBrokeredOrderModel().getCawBrokeredOrderLineModel();
            // get first order line == pickup(PICKUP and FULFILLED) or CANCELLED
            if (orderLines != null && orderLines.size() > 0) {
                CawBrokeredOrderLineModel orderLine = orderLines.get(0);
                if ("CANCELLED".equalsIgnoreCase(orderLine.getStatusCode())
                        || ("PICKUP".equalsIgnoreCase(orderLine.getFulfillmentType())
                                && "FULFILLED".equalsIgnoreCase(orderLine.getStatusCode()))) {
                    result = CawOrderTypeEnum.BROKERED_ORDER_STATUS;
                } else {
                    // create, cancel, complete order
                    result = CawOrderTypeEnum.BROKERED_ORDER;
                }
            }
        } else {
            result = CawOrderTypeEnum.RETAIL_SALE;
        }
        return result;
    }
    /* BEGIN BZ38716 */
    /**
     * @param itm
     * @param cawBrokeredOrderLineModel
     * @param shipToInfoModels
     * @return
     */
    public CawShipToInfoModel getShippingInfo(CawItemModel itm,
            List<CawBrokeredOrderLineModel> cawBrokeredOrderLineModel,
            List<CawShipToInfoModel> shipToInfoModels) {

        int detailSeq = -1;

        CawShipToInfoModel cawShipToInfoModel = null;

        if (cawBrokeredOrderLineModel != null
                && cawBrokeredOrderLineModel.size() > 0) {
            for (CawBrokeredOrderLineModel orderLineModel : cawBrokeredOrderLineModel) {

                if (orderLineModel.getItemId() != null
                        && orderLineModel.getItemId().equals(itm.getCode())) {
                    detailSeq = orderLineModel.getDetailSeq();
                    break;
                }

            }
        }
        if (detailSeq != -1 && shipToInfoModels != null
                && shipToInfoModels.size() > 0) {
            for (CawShipToInfoModel shipToInfoModel : shipToInfoModels) {

                if (shipToInfoModel.getDetailSeq() == detailSeq) {
                    cawShipToInfoModel = shipToInfoModel;
                    break;
                }

            }
        }
        return cawShipToInfoModel;
    }
    /* END BZ38716 */
    
    /*BEGIN BZ48320*/
    /**
     * @param theOrdModel
     * @param model
     */
    public String sendOrderCapture(CawTheOrderModel theOrdModel, CawTransactionModel model) {

        // BUILD request for the order VIN trans
        String result = null;
        if (theOrdModel != null && model != null) {
            try {
                String orderStatusTemplate = CawOrderServiceUtils.readRequestTemplate(CawWSTemplateConstant.ORDER_CAPTURE_TEMPLATE);
                if (orderStatusTemplate != null && orderStatusTemplate.length() > 0) {
                    result = String.valueOf(orderStatusTemplate);
                    // BUILD SALE CHANNEL
                    result = result.replace(CawWSTemplateConstant.ID_SALE_CHANEL_ATTR
                            , theOrdModel.getSalesChannel().getId().toString());
                    result = result.replace(CawWSTemplateConstant.TERMINAL_ATTR
                            , theOrdModel.getSalesChannel().getTerminal().toString());
                    result = result.replace(CawWSTemplateConstant.CHANNEL_TYPE_ATTR
                            , theOrdModel.getSalesChannel().getChannelType().toString());
                    // END BUILD SALE CHANNEL 

                    // BUILD body order Capture
                    if (model != null && model.getBrokeredOrderModel() != null) {
                        //get first line to build request
                        CawBrokeredOrderLineModel orderLineModel = model.getBrokeredOrderModel().getCawBrokeredOrderLineModel().get(0);
                        String itemCorrelationKey = String.format("%s:%s", orderLineModel.getOrderId(), orderLineModel.getDetailSeq()); //BZ50194
                        result = fillDataForField(orderLineModel.getOrderId(), CawWSTemplateConstant.OB_ORDER_CORRELATION_KEY, result);
                        result = fillDataForField(itemCorrelationKey, CawWSTemplateConstant.OB_ORDER_ITEM_CORRELATION_KEY, result);
                        result = fillDataForField(orderLineModel.getVinNumber(), CawWSTemplateConstant.OB_ORDER_VIN_ID, result);
                    }
                }

            } catch (Exception e) {
                logger.error("Could not create Order Capture: " + e.getMessage());
            }
        }
        return result;
    }
    public boolean isVinTransaction(CawTransactionModel model) {
        if(model.getBrokeredOrderModel() != null 
                && model.getBrokeredOrderModel().getCawBrokeredOrderLineModel().size() > 0) {
            Iterator<CawBrokeredOrderLineModel> iter = model.getBrokeredOrderModel().getCawBrokeredOrderLineModel().iterator();
            while (iter.hasNext()) {
                CawBrokeredOrderLineModel orderLine = iter.next();
                if(!StringUtils.isEmpty(orderLine.getVinNumber())) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isVinOrderLine(CawTransactionModel model) {
        if(model.getBrokeredOrderModel() != null 
                && model.getBrokeredOrderModel().getCawBrokeredOrderLineModel().size() > 0) {
            CawBrokeredOrderLineModel orderLine = model.getBrokeredOrderModel().getCawBrokeredOrderLineModel().get(0);
            return !StringUtils.isEmpty(orderLine.getVinNumber());
        }
        return false;
    }
    /*END BZ48320*/
    
    //BEGIN BZ48630
    public int getResultCodeFromEBS(ResponseEntity<String> response) {
        int resultCode = 1;
        String responseBody = response.getBody();
        try {
            JSONObject jsonObj = new JSONObject(responseBody);
            if (jsonObj.has(CawCommonConstant.JSON_RESULT_CODE)) {
                resultCode = jsonObj.getInt(CawCommonConstant.JSON_RESULT_CODE);
            }
        } catch (Exception ex) {
            String errorDetail = getErrorDetailFromEBS(response);
            logger.error("[Error detail] : " + errorDetail);
        }

        return resultCode;

    }  
    public String getErrorDetailFromEBS(ResponseEntity<String> response) {
        String errorDetail = "";
        String responseBody = response.getBody();
        try {
            JSONObject jsonObj = new JSONObject(responseBody);
            if (jsonObj.has(CawCommonConstant.JSON_ERROR_DETAIL)) {
                errorDetail = jsonObj.getString(CawCommonConstant.JSON_ERROR_DETAIL);
            }
        } catch (Exception ex) {
            logger.error("[Can't read response] : " + ex.getMessage());
        }
        return errorDetail;
    }
   //END BZ48630
}
