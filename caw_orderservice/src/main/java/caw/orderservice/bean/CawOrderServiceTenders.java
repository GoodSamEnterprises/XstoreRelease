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
 * BZ25090              110118    [PROD] Over Tender of Cash Causing Accounting Issues in EBS
 * BZ24869              151217    [Order Service] TaxCode displays null in orderservice log when performing Pay In/PayOut transaction
 * BZ24866              151217    [PROD] Tax Code is "null" in order service for Tender Exchange transaction for $0.01
 * BZ24641              011217    [OrderService]Tender Exchange did not flow to order_service.outug
 * BZ24395              081117    [OrderService]Paid In & Paid Out transactions in order_service.out
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ25739              200318    [BZ25614] Missing tax code of item in order service log when doing tender exchange trans in BO
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ25640              220518    New Requirement - Used Firearm System Process Redesign
 * BZ26735              290618    [PROD] Transaction with UOM as EACH submitted a quantity of 0 in the order service
 * BZ26888              240718    [Internal] Move 2 Paid In (980920) & Paid Out (980919) items to configuration file
 * BZ27117              080818    [OS] Should be handled account credit tender like Item deposit for WO complete transaction.
 * BZ27629              180818    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 * BZ29123              210119    Port 28987 to Release 3.0: Xstore needs to submit the PO Number in the Order Service for A/R and Third Party Tenders
 * BZ30023              020419    [Prod] Cannot send to EBS card holder name has special charater
 * BZ32517              291019    [New Requirement] SKU prompt required prior to swipe gift cards for the refund activation to track inventory
 *===================================================================
 */

package caw.orderservice.bean;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import caw.orderservice.constant.CawCommonConstant;
import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.model.CawItemModel;
import caw.orderservice.model.CawPropertiesModel;
import caw.orderservice.model.CawSalesPersonModel;
import caw.orderservice.model.CawTenderModel;
import caw.orderservice.model.CawTheOrderModel;
import caw.orderservice.model.CawTransactionModel;
import caw.orderservice.model.CawWorkOrderDetail;
import caw.orderservice.utils.CawPropertiesConfig;
import dtv.util.StringUtils;

/**
 *This function is used to handle Tenders for each orders
 */
public class CawOrderServiceTenders {

    private static Logger logger = Logger
            .getLogger(CawOrderServiceTenders.class);

    /**
     * Load tender for transaction
     * @param transSeq
     * @param storeID
     * @param regID
     * @param bsnDate
     * @param conn
     * @param correlationKey
     * @param order
     * @return
     * @throws SQLException
     * @throws JsonProcessingException 
     */
    public static CawTheOrderModel loadTenderTrans(String transSeq,
            String storeID, String regID, Timestamp bsnDate, Connection conn,
            String correlationKey, CawTheOrderModel order,
            CawTransactionModel model)
            throws SQLException, JsonProcessingException {

        String valProperty = CawCommonConstant.EMPTY_STRING;
        // Start BZ 32517
        String itemGiftCardId = CawCommonConstant.EMPTY_STRING;
        String serialNbrGc = CawCommonConstant.EMPTY_STRING;
        // End BZ 32517
        String[] parts = null;
        CawSalesPersonModel salePerson = null;
        PreparedStatement psTenderInfo = conn
                .prepareStatement(CawSQLConstant.QUERY_TENDERS_INFO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rsTenderInfo = null;
        String tndAuthToken = null;
        CawItemModel itmModel = null;
        CawTenderModel tenderModel = null;
        try {
            psTenderInfo.setString(1, transSeq);
            psTenderInfo.setString(2, storeID);
            psTenderInfo.setString(3, regID);
            psTenderInfo.setTimestamp(4, bsnDate);
            rsTenderInfo = psTenderInfo.executeQuery();
            logger.debug("loadTaxGroupIdTenderPaidInOut()-Executed query for Tender\n"
                    + CawSQLConstant.QUERY_TENDERS_INFO + " "
                    + Arrays.asList(transSeq, storeID, regID, bsnDate));
            rsTenderInfo.last();
            logger.debug("Result - size:" + rsTenderInfo.getRow());
            rsTenderInfo.beforeFirst();
            while (rsTenderInfo.next()) {
                //Begin BZ24641
                tndAuthToken = null;
                model.setTndTndrStatCode(rsTenderInfo
                        .getString(CawDBFieldConstant.TNDR_STATCODE_FIELD));
                /*BEGIN BZ32517*/
                itemGiftCardId = rsTenderInfo
                        .getString(CawDBFieldConstant.ORIG_STAN);
                serialNbrGc = rsTenderInfo
                        .getString(CawDBFieldConstant.serial_nbr_gc);
                if (itemGiftCardId != null) {
                    loadInfoGC(correlationKey, model, itemGiftCardId, serialNbrGc);
                }
                /*END BZ32517*/
                if (model.getTransTypCode()
                        .equalsIgnoreCase(CawCommonConstant.TENDER_EXCHANGE)) {
                    if (model.getTndTndrStatCode()
                            .equalsIgnoreCase(CawCommonConstant.REFUND)) {
                        model.setCountTenders(model.getCountTenders() + 1);
                        tenderModel = new CawTenderModel();
                        model.setTndCorRelationKey(correlationKey + ":"
                                + model.getCountTenders());
                        model.setTndType(rsTenderInfo
                                .getString(CawDBFieldConstant.TNDR_ID_FIELD));
                        model.setTndAmt(rsTenderInfo
                                .getBigDecimal(CawDBFieldConstant.AMT_FIELD));
                        model.setTndAuthNumber(rsTenderInfo
                                .getString(CawDBFieldConstant.AUTH_NBR_FIELD));
                        //Begin BZ24230
                        tndAuthToken = CawOrderServiceUtils
                                .decryptField(CawCommonConstant.CCENC, rsTenderInfo
                                        .getString(CawDBFieldConstant.TRANSACTION_REFERENCE_DATA_FIELD));

                        //End BZ24230
                        //Begin BZ24231
                        //Decrpyt tndCardNbrMarked
                        model.setTndCardNbrMarked(CawOrderServiceUtils
                                .decryptField(CawCommonConstant.CCENC, rsTenderInfo
                                        .getString(CawDBFieldConstant.ACCT_NBR_FIELD)));
                        if (model.getTndCardNbrMarked() != null) {
                            model.setTndCardNbrMarked(CawOrderServiceUtils
                                    .maskField(model.getTndCardNbrMarked()));
                        }
                        //End BZ24231
                        //Begin BZ24232
                        model.setTndCardHolder(rsTenderInfo
                                .getString(CawDBFieldConstant.CUSTOMER_NAME_FIELD));
                        //End BZ24232
                        //Begin BZ24271
                        model.setTndExprDate(CawOrderServiceUtils
                                .decryptField(CawCommonConstant.CCENC, rsTenderInfo
                                        .getString(CawDBFieldConstant.EXPR_DATE_FIELD)));
                        //End BZ24271

                        //Begin BZ23830
                        try {

                            if (CawPropertiesConfig
                                    .get(model.getTndType()) != null) {
                                if (model.getTndType() != null) {
                                    valProperty = CawPropertiesConfig
                                            .get(model.getTndType());
                                    parts = valProperty.split("-");
                                    model.setTndType(parts[0]);
                                    model.setTndCode(parts[1]);
                                } else {
                                    model.setTndType("Missing Tender Type for:"
                                            + model.getTndType());
                                    model.setUpdateStatusRes(-2);
                                }
                            } else {
                                model.setTndType("Missing Tender Type for:"
                                        + model.getTndType());
                                model.setUpdateStatusRes(-2);
                            }

                        } catch (Exception e) {
                            model.setTndType("Missing Tender Type for:"
                                    + model.getTndType());
                            model.setUpdateStatusRes(-2);
                            logger.warn("Missing Tender Type for:"
                                    + model.getTndType() + e.getMessage());
                        }
                        //End BZ23830

                        tenderModel.setCorrelationKey(model
                                .getTndCorRelationKey());
                        tenderModel.setType(model.getTndType());
                        tenderModel.setCode(model.getTndCode());
                        tenderModel.setAuthorization(model.getTndAuthNumber());
                        tenderModel.setToken(tndAuthToken);
                        //Begin BZ24231
                        tenderModel.setCardNumberMasked(model
                                .getTndCardNbrMarked());
                        //End BZ24231
                        //Begin BZ24232
                        tenderModel.setCardholder(StringEscapeUtils.escapeJson(model.getTndCardHolder())); //BZ-30023
                        //End BZ24232
                        tenderModel.setExpireDate(model.getTndExprDate());
                        //Begin BZ229123
                        /*tenderModel.setPurchaseOrder(rsTenderInfo
                                .getString(CawDBFieldConstant.PO_NUMBER_FIELD));
                        tenderModel.setOrderHoldName(rsTenderInfo
                                .getString(CawDBFieldConstant.ACCT_USER_NAME_FIELD));
                        if(tenderModel.getOrderHoldName()!= null){
                            tenderModel
                            .setAffiliateId(model.getAccountNumber() + "");                            
                        }else{
                            tenderModel
                            .setAffiliateId(0+"");
                        }*/
                        
                        //End BZ29123
                        tenderModel.setAmount(model.getTndAmt());
                        logger.debug("loadTenderTrans()-Tender's Info\n"
                                + CawOrderServiceUtils
                                        .writeValueAsString(tenderModel));
                        order.getTenders().add(tenderModel);
                    } else {
                        //items
                        logger.debug("loadTenderTrans()-Beginning Print Out Item for Tender Exchange, loading item code (38200) for Item tender exchange");
                        model.setTndAmt(rsTenderInfo
                                .getBigDecimal(CawDBFieldConstant.AMT_FIELD));
                        if (model.getTndAmt().compareTo(BigDecimal.ZERO) > 0) {
                            model.setTndAmt(model.getTndAmt()
                                    .multiply(BigDecimal.valueOf(-1)));
                        }
                        model.setCountItem(model.getCountItem() + 1);
                        itmModel = new CawItemModel();
                        model.setItmCorRelationKey(correlationKey + ":"
                                + model.getCountItem());
                        model.setItmQuantity(BigDecimal.ONE);//BZ26735
                        model.setItmUnitMeasure(CawCommonConstant.EACHES);
                        model.setItmCode(CawPropertiesConfig
                                .getItemCodeTenderExchange());//BZ27629

                        itmModel.setCorrelationKey(model
                                .getItmCorRelationKey());
                        itmModel.setCode(model.getItmCode());
                        itmModel.setQuantity(model.getItmQuantity());
                        itmModel.setUnitOfMeasure(model.getItmUnitMeasure());
                        itmModel.setUnitListPrice(model.getTndAmt());
                        itmModel.setUnitSellingPrice(model.getTndAmt());
                        itmModel.setLineTotal(model.getTndAmt());
                        itmModel.setTaxAmount(BigDecimal.valueOf(0.00));
                        //End BZ24340
                        //Begin BZ25860
                        itmModel.setReturn(false);
                        //End BZ25860
                        //Begin BZ24866
                        model.setItmTaxCodeExch(CawCommonConstant.EMPTY_STRING);
                        //Get tax group id
                        model.setItmTaxCodeExch(loadTaxGroupIdTenderPaidInOut(conn, CawPropertiesConfig
                                .getItemCodeTenderExchange(), model));//BZ27629

                        itmModel.setTaxCode(model.getItmTaxCodeExch());
                        //End BZ24866
                        salePerson = new CawSalesPersonModel();
                        salePerson.setCode(model.getCode());
                        salePerson.setName(model.getName());
                        salePerson.setFileNumber(model.getFileNumber());
                        itmModel.setSalesPerson(salePerson);

                        logger.debug("loadTenderTrans()-Items's Info for Tender Exchange\n"
                                + CawOrderServiceUtils
                                        .writeValueAsString(itmModel));
                        order.getItems().add(itmModel);
                    }
                } else {
                    model.setCountTenders(model.getCountTenders() + 1);
                    tenderModel = new CawTenderModel();
                    model.setTndCorRelationKey(correlationKey + ":"
                            + model.getCountTenders());
                    model.setTndType(rsTenderInfo
                            .getString(CawDBFieldConstant.TNDR_ID_FIELD));
                    model.setTndAmt(rsTenderInfo
                            .getBigDecimal(CawDBFieldConstant.AMT_FIELD));
                    //Begin BZ27117
                    if (model.getTndType()
                            .equalsIgnoreCase(CawCommonConstant.ACCOUNT_CREDIT)) {
                        //Don't need to send Account Credit tender to Oracle Editor
                    } else {
                        //End BZ27117
                        //Begin BZ24395
                        if (model.getTransTypCode()
                                .equalsIgnoreCase(CawCommonConstant.TENDER_CONTROL)) {
                            model.setItmListPrice(BigDecimal.valueOf(0.00));
                            String orderTypPaidInOut = model.getOrderModel()
                                    .getOrderType();
                            if (CawCommonConstant.PAIDOUT
                                    .equalsIgnoreCase(orderTypPaidInOut)) {
                                model.setTndAmt(model.getTndAmt()
                                        .multiply(BigDecimal.valueOf(-1)));
                            }
                            model.setItmListPrice(model.getTndAmt());
                        }
                        //End BZ24395
                        model.setTndAuthNumber(rsTenderInfo
                                .getString(CawDBFieldConstant.AUTH_NBR_FIELD));
                        //Begin BZ24230
                        tndAuthToken = CawOrderServiceUtils
                                .decryptField(CawCommonConstant.CCENC, rsTenderInfo
                                        .getString(CawDBFieldConstant.TRANSACTION_REFERENCE_DATA_FIELD));
                        //End BZ24230
                        //Begin BZ24231
                        //Decrpyt tndCardNbrMarked
                        model.setTndCardNbrMarked(CawOrderServiceUtils
                                .decryptField(CawCommonConstant.CCENC, rsTenderInfo
                                        .getString(CawDBFieldConstant.ACCT_NBR_FIELD)));
                        if (model.getTndCardNbrMarked() != null) {
                            model.setTndCardNbrMarked(CawOrderServiceUtils
                                    .maskField(model.getTndCardNbrMarked()));
                        }
                        //End BZ24231
                        //Begin BZ24232
                        model.setTndCardHolder(rsTenderInfo
                                .getString(CawDBFieldConstant.CUSTOMER_NAME_FIELD));
                        //End BZ24232
                        //Begin BZ24271
                        model.setTndExprDate(CawOrderServiceUtils
                                .decryptField(CawCommonConstant.CCENC, rsTenderInfo
                                        .getString(CawDBFieldConstant.EXPR_DATE_FIELD)));
                        //End BZ24271
                        //Begin BZ29123
                        tenderModel.setPurchaseOrder(rsTenderInfo
                                .getString(CawDBFieldConstant.PO_NUMBER_FIELD));
                        //End BZ29123
                        //Begin BZ23830
                        try {
                            if (CawPropertiesConfig
                                    .get(model.getTndType()) != null) {
                                if (model.getTndType() != null) {
                                    valProperty = CawPropertiesConfig
                                            .get(model.getTndType());
                                    parts = valProperty.split("-");
                                    model.setTndType(parts[0]);
                                    model.setTndCode(parts[1]);
                                } else {
                                    model.setTndType("Missing Tender Type for:"
                                            + model.getTndType());
                                    model.setUpdateStatusRes(-2);
                                }
                            } else {
                                model.setTndType("Missing Tender Type for:"
                                        + model.getTndType());
                                model.setUpdateStatusRes(-2);
                            }

                        } catch (Exception e) {
                            model.setTndType("Missing Tender Type for:"
                                    + model.getTndType());
                            model.setUpdateStatusRes(-2);
                            logger.warn("Missing Tender Type for:"
                                    + model.getTndType() + " "
                                    + e.getMessage());
                        }
                        //End BZ23830
                        //Begin BZ25090
                        int index = order.getTenders().size() - 1;
                        if (model.getTndTndrStatCode()
                                .equalsIgnoreCase(CawCommonConstant.CHANGE_TNDSTATUSCODE)) {
                            if (index >= 0) {
                                order.getTenders().get(index)
                                        .setAmount(order.getTenders().get(index)
                                                .getAmount()
                                                .add(model.getTndAmt()));
                            }
                            break;
                        }
                        //End BZ25090
                        tenderModel.setCorrelationKey(model
                                .getTndCorRelationKey());
                        tenderModel.setType(model.getTndType());
                        tenderModel.setCode(model.getTndCode());
                        tenderModel.setAuthorization(model.getTndAuthNumber());
                        tenderModel.setToken(tndAuthToken);
                        //Begin BZ24231
                        tenderModel.setCardNumberMasked(model
                                .getTndCardNbrMarked());
                        //End BZ24231
                        //Begin BZ24232
                        tenderModel.setCardholder(StringEscapeUtils.escapeJson(model.getTndCardHolder()));//BZ-30023
                        //End BZ24232
                        tenderModel.setExpireDate(model.getTndExprDate());
                        tenderModel.setAmount(model.getTndAmt());

                        logger.debug("loadTenderTrans()-Tender's Info\n"
                                + CawOrderServiceUtils
                                        .writeValueAsString(tenderModel));
                        order.getTenders().add(tenderModel);
                    }
                }
                //End BZ24641
            }
        } finally {
            if (rsTenderInfo != null) {
                rsTenderInfo.close();
            }
            if (psTenderInfo != null) {
                psTenderInfo.close();
            }
        }
        return order;
    }

    /**
     * Load Tender for PaidIn/Out.
     * @param correlationKey
     * @param taxCodePaidInOut
     * @param transTypCode
     * @param code
     * @param name
     * @param fileNumber
     * @return
     * @throws JsonProcessingException 
     */
    public static CawTheOrderModel loadTenderPaidInPaidOut(
            String correlationKey, String taxCodePaidInOut, String transTypCode,
            String code, String name, String fileNumber,
            CawTransactionModel model, Connection conn)
            throws JsonProcessingException {

        if (model.getTransTypCode()
                .equalsIgnoreCase(CawCommonConstant.TENDER_CONTROL)) {
            logger.debug("loadTenderPaidInPaidOut()-Beginning type of TENDER_CONTROL");
            model.setCountItem(model.getCountItem() + 1);
            CawItemModel itmModel = new CawItemModel();
            model.setItmCorRelationKey(correlationKey + ":"
                    + model.getCountItem());
            model.setItmQuantity(BigDecimal.ONE);//BZ26735
            model.setItmUnitMeasure(CawCommonConstant.EACHES);
            String orderTypPaidInOut = model.getOrderModel().getOrderType();

            if (CawCommonConstant.PAIDIN.equalsIgnoreCase(orderTypPaidInOut)) {
                logger.debug("loadTenderPaidInPaidOut()-Beginning Print Out Item for PaidIn, load item code (980920) for Order PaidIn");
                //Begin BZ26888
                model.setItmCode(CawPropertiesConfig.getPaidInItemId());
                //End BZ26888                
                itmModel.setCorrelationKey(model.getItmCorRelationKey());
                itmModel.setCode(model.getItmCode());
                itmModel.setQuantity(model.getItmQuantity());
                itmModel.setUnitOfMeasure(model.getItmUnitMeasure());
                itmModel.setUnitListPrice(model.getItmListPrice());
                itmModel.setUnitSellingPrice(model.getItmListPrice());
                itmModel.setLineTotal(model.getItmListPrice());
                itmModel.setTaxAmount(BigDecimal.valueOf(0.00));
                //End BZ24340
                //Begin BZ25860
                itmModel.setReturn(false);
                //End BZ25860
                //Begin BZ24869
                itmModel.setTaxCode(taxCodePaidInOut);
                //End BZ24869
                CawSalesPersonModel salePerson = new CawSalesPersonModel();
                salePerson.setCode(code);
                salePerson.setName(name);
                salePerson.setFileNumber(fileNumber);
                itmModel.setSalesPerson(salePerson);
                model.getOrderModel().getItems().add(itmModel);

            } else if (CawCommonConstant.PAIDOUT
                    .equalsIgnoreCase(orderTypPaidInOut)) {
                logger.debug("loadTenderPaidInPaidOut()-Beginning Print Out Item for PaidIn, load item code (980919) for Order PaidIn");
                //Begin BZ26888
                model.setItmCode(CawPropertiesConfig.getPaidOutItemId());
                //End BZ26888
                itmModel.setCorrelationKey(model.getItmCorRelationKey());
                itmModel.setCode(model.getItmCode());
                itmModel.setQuantity(model.getItmQuantity());
                itmModel.setUnitOfMeasure(model.getItmUnitMeasure());
                itmModel.setUnitListPrice(model.getItmListPrice());
                itmModel.setUnitSellingPrice(model.getItmListPrice());
                itmModel.setLineTotal(model.getItmListPrice());
                itmModel.setTaxAmount(BigDecimal.valueOf(0.00));
                //Begin BZ25860
                itmModel.setReturn(true);
                //End BZ25860
                //Begin BZ24869
                itmModel.setTaxCode(taxCodePaidInOut);
                //End BZ24869
                CawSalesPersonModel salePerson = new CawSalesPersonModel();
                salePerson.setCode(code);
                salePerson.setName(name);
                salePerson.setFileNumber(fileNumber);
                itmModel.setSalesPerson(salePerson);

                //Begin BZ25640 - load properties
                String propertiesDetail = null;
                if (model.getOrderModel().getPaidInOutDetail() != null
                        && CawCommonConstant.UFA_REASON_CODE
                                .equalsIgnoreCase(model.getOrderModel()
                                        .getPaidInOutDetail().getCode())) {
                    String transSeq = model.getTransSeq();
                    String storeID = model.getStoreID();
                    String regID = model.getRegID();
                    Timestamp bsnDate = model.getBsnDate();
                    propertiesDetail = CawOrderServiceItems
                            .loadUFAProperties(conn, transSeq, storeID, regID, bsnDate);
                }

                if (propertiesDetail != null && propertiesDetail.length() > 0) {
                    CawPropertiesModel properties = new CawPropertiesModel();
                    properties.setProperty4(propertiesDetail);
                    itmModel.setPropertiesModel(properties);
                    logger.debug("Properties's info:" + CawOrderServiceUtils
                            .writeValueAsString(properties));
                }
                //End BZ25640

                model.getOrderModel().getItems().add(itmModel);
            }
            logger.debug("loadTenderPaidInPaidOut()- Item PaidIn/Out's info:"
                    + CawOrderServiceUtils.writeValueAsString(itmModel));
        }
        return model.getOrderModel();

    }

    /**
     * Get Tax Group Id for Tender PaidIn/Out
     * @param conn
     * @param codePaidInOut
     * @return
     * @throws SQLException
     */
    public static String loadTaxGroupIdTenderPaidInOut(Connection conn,
            String codePaidInOut, CawTransactionModel model)
            throws SQLException {

        PreparedStatement psPaidInOutTaxCode = null;
        ResultSet rsPaidInOutTaxCode = null;

        try {
            psPaidInOutTaxCode = conn
                    .prepareStatement(CawSQLConstant.QUERY_PAID_IN_OUT_TAX_CODE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psPaidInOutTaxCode.setString(1, codePaidInOut);
            rsPaidInOutTaxCode = psPaidInOutTaxCode.executeQuery();
            logger.debug("loadTaxGroupIdTenderPaidInOut()-Executed query for getting Tax Group Id\n"
                    + CawSQLConstant.QUERY_PAID_IN_OUT_TAX_CODE + " "
                    + Arrays.asList(codePaidInOut));
            rsPaidInOutTaxCode.last();
            logger.debug("Result set – size:" + rsPaidInOutTaxCode.getRow());
            rsPaidInOutTaxCode.beforeFirst();

            while (rsPaidInOutTaxCode.next()) {
                model.setItmTaxCodeExch(rsPaidInOutTaxCode
                        .getString(CawDBFieldConstant.TAX_GROUP_ID_FIELD));
            }
            if (model.getItmTaxCodeExch().isEmpty()) {
                model.setItmTaxCodeExch(CawCommonConstant.TAXCODE_NT);
            }
            logger.debug("loadTaxGroupIdTenderPaidInOut()- Tax Group Id For Tender Exchange:"
                    + model.getItmTaxCodeExch());
        } finally {
            if (rsPaidInOutTaxCode != null) {
                try {
                    rsPaidInOutTaxCode.close();
                } catch (SQLException e) {
                    logger.error("SQLException: " + e.getMessage());
                }
            }
            if (psPaidInOutTaxCode != null) {
                psPaidInOutTaxCode.close();
            }
        }
        //BZ25739: return to getItmTaxCodeExch instead of getTaxCodePaidInOut
        return model.getItmTaxCodeExch();
    }

    //Begin BZ27117
    /**
     * loadWorkOrderAccountCreditInfo: used to load Item code and Tax Group id for item Work Order Account Credit
     * @param conn
     * @return
     * @throws SQLException
     */
    public static CawWorkOrderDetail loadWorkOrderAccountCreditInfo(
            Connection conn) throws SQLException {

        CawWorkOrderDetail WOAccountCredit = new CawWorkOrderDetail();
        PreparedStatement psWOAccountCredit = null;
        ResultSet rsWOAccountCredit = null;

        try {
            psWOAccountCredit = conn
                    .prepareStatement(CawSQLConstant.QUERY_ITEM_WORK_ORDER_FOR_ACCOUNT_CREDIT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rsWOAccountCredit = psWOAccountCredit.executeQuery();
            logger.debug("loadWorkOrderAccountCreditInfo()-Executed query for loadWorkOrderAccountCreditInfo\n"
                    + CawSQLConstant.QUERY_PAID_IN_OUT_TAX_CODE);
            rsWOAccountCredit.last();
            logger.debug("Result set â€“ size:" + rsWOAccountCredit.getRow());
            rsWOAccountCredit.beforeFirst();

            while (rsWOAccountCredit.next()) {
                WOAccountCredit.setTaxGroupId(rsWOAccountCredit
                        .getString(CawDBFieldConstant.TAX_GROUP_ID_FIELD));
                WOAccountCredit.setItmCode(rsWOAccountCredit
                        .getString(CawDBFieldConstant.ITEM_ID_FIELD));
            }
            if (WOAccountCredit.getTaxGroupId().isEmpty()) {
                WOAccountCredit.setTaxGroupId(CawCommonConstant.TAXCODE_NT);
            }
        } finally {
            if (rsWOAccountCredit != null) {
                try {
                    rsWOAccountCredit.close();
                } catch (SQLException e) {
                    logger.error("SQLException: " + e.getMessage());
                }
            }
            if (psWOAccountCredit != null) {
                psWOAccountCredit.close();
            }
        }
        return WOAccountCredit;
    }
    //End BZ27117
    /*BEGIN BZ32517*/
    public static void loadInfoGC(String correlationKey,
            CawTransactionModel model,  String itemGiftCardId, String serialNbrGc) {

        model.setCountItem(model.getCountItem() + 1);
        model.setItmCorRelationKey(correlationKey + ":" + model.getCountItem());
        CawItemModel itmModel = new CawItemModel();
        CawPropertiesModel proModel = new CawPropertiesModel();
        CawSalesPersonModel salePerson = new CawSalesPersonModel();

        model.setItmCode(CawPropertiesConfig.getItemCodeTenderExchange());
        itmModel.setCorrelationKey(model.getItmCorRelationKey());
        itmModel.setCode(itemGiftCardId);
        itmModel.setQuantity(BigDecimal.ONE);
        itmModel.setUnitOfMeasure(CawCommonConstant.EACHES);
        itmModel.setUnitListPrice(BigDecimal.valueOf(0.00));
        itmModel.setUnitSellingPrice(BigDecimal.valueOf(0.00));
        itmModel.setLineTotal(BigDecimal.valueOf(0.00));
        itmModel.setTaxCode(CawCommonConstant.TAXCODE_NT);
        itmModel.setTaxAmount(BigDecimal.valueOf(0.00));
        
        proModel.setProperty4(StringUtils.format(CawCommonConstant.SERIAL_NUMBER_TEXT, serialNbrGc));
        itmModel.setPropertiesModel(proModel);
        itmModel.setReturn(false);
        salePerson.setCode(model.getCode());
        salePerson.setName(model.getName());
        salePerson.setFileNumber(model.getFileNumber());
        itmModel.setSalesPerson(salePerson);
        model.getOrderModel().getItems().add(itmModel);
    }
    /*END BZ32517*/
}
