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
 * BZ24905              211217    [OrderService] Pull 0600 item attributes to order service
 * BZ24801              131217    [OrderService] Cashier is submitted as Sales Person in order service
 * BZ24703              051217    [Order service] Correlation key displays incorrect when doing transaction has discount.
 * BZ24658              011217    [OrderService]Serialized items are not passed to Order Service
 * BZ24642              301117    [OrderService] Remove "OVT" prefix in the Correlation Key for "adjustments"
 * BZ24613              291117    [Payment] Gift card reloads are causing an error in Oracle editor
 * BZ24600              241117    [Order service] Should be rounded line total tax amount in log when doing sale/return transaction
 * BZ24573              211117    [OrderService] Line Total Variance on order message but correct amounts are in Xstore
 * BZ24516              211117    [UAT][Order Service] Selling Price Variance - incorrect sign on the coupon (should be positive to offset the credit)
 * BZ24527              161117    The value of adjustment price displayed ''null'' when performing return transaction that add discount
 * BZ24480              151117    [Order Service] When there is No tax set on an item were sending a Null.
 * BZ24418              081117    [Order service] Error "Message":"Discount adjustments must have a couponCode." is displayed table CAW_TRN_ORD_SER when CAW order
 * BZ24390              061117    [OrderService] "adjustments" data needs to account for qty of items
 * BZ24369              031117    [OrderService] "taxAmount" value on order service message does not match Xstore
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ25441              010318    [CW PROD] Order Service allows voided item discounts to be sent to Neuron
 * BZ25740              032118    [Order Service] Adjustment of item line displayed incorrect in Order service log when performing return web order
 * BZ25558              100418    New Requirement - Return Reason Codes Not Flowing to EBS
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ26308              210518    Item properties displays incorrect in order service log when item has different prompt property.
 * BZ25640              220518    New Requirement - Used Firearm System Process Redesign
 * BZ26735              290618    [PROD] Transaction with UOM as EACH submitted a quantity of 0 in the order service
 * BZ26289              240718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ26207              250718    New Requirement - Enable Work Order Functionality
 * BZ26879              300718    [New Requirement] Add reference to Original item on Order Service
 * BZ27078              060818    [Order Service] Items is submitted in the order service incorrectly for House Account payment transaction.
 * BZ27584              190918    [PROD] Xstore return does not reference the original transaction in Order Service
 * BZ27712              121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ28203              141118    [27712] Missing item properties for item 500 in Order Service
 * BZ29156              210119    [Bundle the enhancement 2.1_29109] 0500 Property Names in the Order Service
 * BZ29205              250119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29391              140219    [Internal] PLCC payment generates a 400 error.
 * BZ29324              060319    [3.1] Returns for Item 500 that was in a WO is causing a 400 error
 * BZ29205              130319    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29912              280319    [INTERNAL] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Refund
 * BZ30009              010419    [Prod] Cannot send to EBS 500 item has special charater
 * BZ30261              190419    [Prod] Work Order Issues: Order Service send Work Order Deposit as Sale Transaction
 * BZ30666              140519    [Prod] Issue with returns - correlation key
 * BZ30153              150519    [New Requirement] Xstore allow to add the sale associate to line items and submit the certain sale associate for each line items to Order Service
 * BZ31944              170719    [Port BZ31258 to 5.0]The OS did not pull the discount for prompt price item
 * BZ31793              250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 * BZ32434              120819    [Prod] Oracle Return Issue: showing a positive listing price
 * BZ33984              261119    [Port 33954 to 5.2]Bounce Back Coupon reporting not showing all data
 * BZ33985              261119    [Port 33972 to 5.2][PROD] Order Service should wait for items before sending to EBS
 * BZ35016              060320    [New Requirement] WO complete should not override WO deposit data in CAT_CUST_ITEM_ACCT_DETAIL
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ44528              130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ45903              250821    [Internal] Order Service - brokerItemDetail is incorrect if transaction included two same items but one is a sale item and one from EW order
 * BZ45949              250821    [Internal] cartIDs is duplicated in the request to Order Service if more than one item in the Kiosk Order transaction
 * BZ44917              110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ47542              071221    RV Service Payments - Property Names
 * BZ48749              052422    [PROD] Issues in xStore vs DW sales report
 * BZ53670              161122    BTM-241: Numeric Property Values
 *===================================================================
 */

package caw.orderservice.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Strings;

import caw.orderservice.constant.CawCommonConstant;
import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawPKeyConstant;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.constant.CawWSTemplateConstant;
import caw.orderservice.helper.CawWorkOrderHelper;
import caw.orderservice.model.CawAdjustmentsModel;
import caw.orderservice.model.CawAttributesModel;
import caw.orderservice.model.CawItemModel;
import caw.orderservice.model.CawOriginalItemAndWarrantyModel;
import caw.orderservice.model.CawPaidInOutDetail;
import caw.orderservice.model.CawPropertiesModel;
import caw.orderservice.model.CawSalesPersonModel;
import caw.orderservice.model.CawTransactionModel;
import caw.orderservice.model.CawWorkOrderDetail;
import caw.orderservice.utils.CawPropertiesConfig;
import caw.orderservice.utils.CawUtils;
import twitter4j.JSONException;
import twitter4j.JSONObject;

/**
 *This function is used to handle items for each order
 */
public class CawOrderServiceItems {

    private static Logger logger = Logger.getLogger(CawOrderServiceItems.class);

    /**
     * Get Item's info for Transaction
     * @param model
     * @param conn
     * @param correlationKey
     * @return 
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JSONException 
     */
    /*BEGIN BZ33985*/
    public static void loadItemsTransaction(CawTransactionModel model,
            Connection conn, String correlationKey, ResultSet rsItemInfo)
            throws SQLException, JsonProcessingException, JSONException {

        CawSalesPersonModel salePerson = null;
        String couponCodecConfig = null;
        String discountType = CawPropertiesConfig
                .get(CawPKeyConstant.DISCOUNT_TYPE);
        boolean isReturnWebOrdLineItem = false;
        CawItemModel itmModel = null;
        CawAttributesModel attributesModel = null;
        String orgCorrelationKey = null;
        // Begin BZ27712: adding work order item's attributes
        String woAttributes = null;
        String proCodeWOAttrKey = null;
        String queryKeyOrig = "";
        // End BZ27712
        //Begin BZ29205
        String woProperties = null;
        String proCodeWOPropKey = "";//PROPERTY_CODE for work order properties
        //End BZ29205
        String queryKeyPropOrig = "";/*BZ29324*/
        /* BEGIN BZ32434 */
        BigDecimal unitListPrice = BigDecimal.ZERO;
        BigDecimal adjAmount = BigDecimal.ZERO;
        /* END BZ32434 */
        String transSeq = model.getTransSeq();
        String storeID = model.getStoreID();
        String regID = model.getRegID();
        Timestamp bsnDate = model.getBsnDate();
        BigDecimal rvPaymentAmount = BigDecimal.ZERO;/*BZ44917*/
        String wondersignCartId = CawCommonConstant.EMPTY_STRING;/*BZ44528*/
            while (rsItemInfo.next()) {
                itmModel = new CawItemModel();
                attributesModel = new CawAttributesModel(); /*BZ30666*/

                salePerson = new CawSalesPersonModel();/*BZ30153*/
                //Begin BZ24801
                salePerson.setCode(rsItemInfo
                        .getString(CawDBFieldConstant.LOGIN_ID_FIELD));
                salePerson.setName(rsItemInfo
                        .getString(CawCommonConstant.FULL_NAME_FIELD));
                salePerson.setFileNumber(rsItemInfo
                        .getString(CawDBFieldConstant.EMP_PARTY_ID_FIELD));
                //End BZ24801

                model.setCountItem(model.getCountItem() + 1);
                model.setCountDisItem(1); //BZ24642
                model.setItmLineAmtTotal(BigDecimal.valueOf(0.00));
                model.setItmTaxAmt(BigDecimal.valueOf(0.00));//Begin BZ24480

                model.setItmCorRelationKey(correlationKey + ":"
                        + model.getCountItem());
                model.setItmCode(rsItemInfo
                        .getString(CawDBFieldConstant.ITEM_ID_FIELD));
                model.setItmQuantity(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.QUANTITY_FIELD));//BZ26735
                model.setItmUnitMeasure(rsItemInfo
                        .getString(CawDBFieldConstant.UNIT_OF_MEASURE_CODE_FIELD));
                //Begin BZ24227
                model.setItmListPrice(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.REGURLAR_BASE_PRICE_FIELD));
                model.setItmRegBasePrice(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.REGURLAR_BASE_PRICE_FIELD));
                //End BZ24227
                model.setItmSellPrice(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.UNIT_PRICE_FIELD));
                model.setItmBaseUnitPrice(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.BASE_UNIT_PRICE_FIELD));
                model.setItmGrossAmt(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.GROSS_AMT_FIELD));
                model.setItmExtendedAmt(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.EXTENDED_AMT_FIELD));
                model.setItmTaxAmt(rsItemInfo
                        .getBigDecimal(CawDBFieldConstant.TAX_AMT_FIELD));//BZ24369
                //Begin BZ24613
                //Begin BZ24658
                model.setSerialNbr(rsItemInfo
                        .getString(CawDBFieldConstant.SERIAL_NBR_FIELD));

                model.setPromptForPriceFlag(rsItemInfo
                        .getInt(CawDBFieldConstant.PROMPT_FOR_PRICE_FLAG));
                //End BZ24658
                // BZ25441
                model.setRtransLineitmSeq(rsItemInfo
                        .getString(CawDBFieldConstant.RTRANS_LINEITM_SEQ_FIELD));
                //Begin BZ25860
                model.setItmIsReturn(CawUtils.getInstance().vBoolean(rsItemInfo
                        .getString(CawDBFieldConstant.RETURN_FLAG_FIELD)));
                //End BZ25860
                isReturnWebOrdLineItem = isReturnWebOrderLineItm(conn, model
                        .getTransSeq(), model.getStoreID(), model
                                .getRegID(), model.getBsnDate(), model
                                        .getRtransLineitmSeq());
                /*BEGIN BZ48749*/
                //Begin BZ27712: getting then adding work order item's attributes
                proCodeWOAttrKey = CawUtils.getInstance().queryKeyFormat(CawCommonConstant.WA_CODE, storeID, bsnDate, regID, transSeq, model.getRtransLineitmSeq());
                woAttributes = getRTransLineItemProperty(conn, proCodeWOAttrKey);

                if (woAttributes != null && woAttributes.length() > 0) {
                    attributesModel.setWoAttributes(woAttributes);
                }
                //End BZ27712
                //check line item is WO and ItmListPrice < BaseUnitPrice(price response from S&I) 
                //=> set ItmListPrice = ItmListPrice
                if(model.getOrderModel().getWorkOrderDetail() != null
                        && StringUtils.isNotEmpty(CawWorkOrderHelper.getInstance().getRTransLineItemProperty(conn, model, CawCommonConstant.IS_WO_ITEM))
                        && model.getItmListPrice() != null 
                        && model.getItmBaseUnitPrice() != null 
                        && model.getItmListPrice().compareTo(model.getItmBaseUnitPrice()) == -1) {
                    model.setItmListPrice(model.getItmBaseUnitPrice());
                    
                }else {
                    /* BEGIN BZ31944 */
                    if (model.getItmRegBasePrice() == null 
                            || model.getItmRegBasePrice().compareTo(BigDecimal.ZERO) == 0
                            || model.getPromptForPriceFlag() == 1 
                            || isReturnWebOrdLineItem) {
                        
                        if (model.getPromptForPriceFlag() == 1)
                            model.setItmListPrice(model.getItmBaseUnitPrice());
                        else
                            model.setItmListPrice(model.getItmSellPrice());
                    }
                    /* END BZ31944 */
                }
                /*END BZ48749*/
                //End BZ24613
                //Begin BZ24480
                if (model.getItmTaxAmt() == null) {
                    model.setItmTaxAmt(BigDecimal.valueOf(0.00));
                }
                model.setItmTaxCode(rsItemInfo
                        .getString(CawDBFieldConstant.TAX_GROUP_ID_FIELD));
                //Begin BZ24270
                //Begin BZ23565
                //Begin BZ24390
                //GETS PRICE ADJUSTMENT
                //Currently, we don't need value for adjustment, so then comment out code handle for Adjustment
                model.setPricePropCode(rsItemInfo
                        .getString(CawDBFieldConstant.PRICE_PROPERTY_CODE_FIELD));
                if (model.getPricePropCode() == null) {
                    couponCodecConfig = CawWSTemplateConstant.COUPONCODEDEFAULT;
                } else {

                    String pricePropCode = model.getPricePropCode();
                    if (pricePropCode
                            .equalsIgnoreCase(CawWSTemplateConstant.CLUB_CODE)) {
                        couponCodecConfig = CawPropertiesConfig
                                .get(CawPKeyConstant.ADJUSTMENT_CLUB_CODE);
                    } else if (pricePropCode
                            .equalsIgnoreCase(CawWSTemplateConstant.WHOLESALE_CODE)) {
                        couponCodecConfig = CawPropertiesConfig
                                .get(CawPKeyConstant.ADJUSTMENT_WHOLESALE_CODE);
                    } else if (pricePropCode
                            .equalsIgnoreCase(CawWSTemplateConstant.CREW_CODE)) {
                        couponCodecConfig = CawPropertiesConfig
                                .get(CawPKeyConstant.ADJUSTMENT_CREW_CODE);
                    } else {
                        couponCodecConfig = CawWSTemplateConstant.COUPONCODEDEFAULT;
                    }
                }
                //Begin BZ26289
                //check Item code here. if Item is 980920 then set item
                boolean checkHouseAccountPayment = false;
                checkHouseAccountPayment = checkArPaymentExisted(conn, transSeq, storeID, regID, bsnDate, model
                        .getRtransLineitmSeq());
                if (checkHouseAccountPayment) {
                    //Begin BZ27078: unitListPrice will be unitSellingPrice in case transaction is House Account Payment
                    model.setItmListPrice(model.getItmSellPrice());
                    //End BZ27078
                    //Begin BZ29391
                    String arReasonCode = CawPropertiesConfig.getArReasonCode();
                    CawPaidInOutDetail paidIODetail = getPaymentDetail(conn, model
                            .getItmCode(), arReasonCode);
                    if (paidIODetail != null) {
                        model.getOrderModel()
                                .setOrderType(CawCommonConstant.PAIDIN);
                        model.getOrderModel().setPaidInOutDetail(paidIODetail);
                    }
                } //End BZ29391
                else if (model.isCheckAcPayment()) {
                    String acReasonCode = CawPropertiesConfig.getAcReasonCode();
                    CawPaidInOutDetail paidIODetail = getPaymentDetail(conn, model
                            .getItmCode(), acReasonCode);
                    if (paidIODetail != null) {
                        model.getOrderModel()
                                .setOrderType(CawCommonConstant.PAIDIN);
                        model.getOrderModel().setPaidInOutDetail(paidIODetail);
                    }
                }
                //End BZ26289
                /*Prepare for List of Adjustments, A correlationKey is required 
                 * if type is Discount, then amount must be zero or less and a couponeCode is required
                 * if type is Credit, then amount must be zero or greater (do not apply by CAW)*/
                model.setAdjustments(new ArrayList<CawAdjustmentsModel>());
                model.setItmDiscountAmt(BigDecimal.valueOf(0.00));
                //Begin BZ24418
                // BZ25441
                if (model.getItmBaseUnitPrice()
                        .compareTo(model.getItmListPrice()) != 0
                        && !(model.getItmRegBasePrice()
                                .compareTo(BigDecimal.ZERO) == 0
                                || model.getPromptForPriceFlag() == 1
                                || isReturnWebOrdLineItem)) {

                    //Begin BZ24642
                    /* Begin BZ24703 */
                    model.setAdjCorRelationKey(correlationKey + ":"
                            + model.getCountItem() + ":"
                            + model.getCountDisItem());
                    //End BZ24642
                    model.setCountDisItem(model.getCountDisItem() + 1);
                    /* End BZ24703 */

                    //Step1: Fields required
                    CawAdjustmentsModel adjModel = new CawAdjustmentsModel();
                    adjModel.setCorrelationKey(model.getAdjCorRelationKey());//correlationKey
                    adjModel.setType(discountType);
                    adjModel.setCouponCode(couponCodecConfig); //couponCode
                    adjModel.setSerializedCoupon(null); //serializedCoupon

                    //Step2: Prepare for amount field
                    model.setItmDiscountAmt(model.getItmListPrice()
                            .subtract(model.getItmBaseUnitPrice()));
                    //Begin BZ24516
                    //BZ26735
                    model.setItmDiscountAmt((model.getItmDiscountAmt()
                            .multiply(model.getItmQuantity()))
                                    .multiply(BigDecimal.valueOf(-1)));
                    /* BEGIN BZ32434: make sure adjustment amount negative for Sale and positive for Return */
                    adjAmount = CawOrderServiceUtils.getSignValue(model.getItmDiscountAmt(), 2, model.isItmIsReturn());
                    adjModel.setAmount(adjAmount);
                    /* END BZ32434 */
                    //End BZ24516

                    //Step2: Add the Adjustment to list
                    model.getAdjustments().add(adjModel);
                }
                //adj: for each node item discount
                //handle for case discount
                //Begin BZ24418
                //Begin BZ27078
                if (!checkHouseAccountPayment) {
                    loadAdjustmentModelsWithDiscountType(conn, model, correlationKey, discountType, isReturnWebOrdLineItem);
                }
                //End BZ27078
                //Begin BZ24527

                itmModel.setAdjustments(model.getAdjustments());
                //End BZ24527
                //End BZ24418

                //End BZ23565
                //End BZ24270
                //End BZ24390
                if (model.getItmUnitMeasure() != null) {
                    model.setItmUnitMeasure(CawPropertiesConfig
                            .get(model.getItmUnitMeasure()));
                } else {
                    model.setItmUnitMeasure(CawCommonConstant.EACHES);
                }

                itmModel.setCorrelationKey(model.getItmCorRelationKey());
                itmModel.setCode(model.getItmCode());
                itmModel.setQuantity(model.getItmQuantity());
                itmModel.setUnitOfMeasure(model.getItmUnitMeasure());
                /* BEGIN BZ32434: make sure unitListPrice positive for Sale and Negative for return */
                unitListPrice = CawOrderServiceUtils.getSignValue(model.getItmListPrice(), 1, model.isItmIsReturn());
                itmModel.setUnitListPrice(unitListPrice);
                /* END BZ32434 */
                itmModel.setUnitSellingPrice(model.getItmSellPrice());
                itmModel.setTaxCode(model.getItmTaxCode());
                //Begin BZ24369
                itmModel.setTaxAmount(model.getItmTaxAmt());
                //End BZ24369
                //Begin BZ24573
                model.setItmLineAmtTotal(model.getItmSellPrice()
                        .multiply(model.getItmQuantity())
                        .add(model.getItmTaxAmt()));//BZ26735
                //Begin BZ24600
                itmModel.setLineTotal(model.getItmLineAmtTotal()
                        .setScale(2, RoundingMode.HALF_UP));
                //End BZ24600
                //End BZ24573
                //Begin BZ25860
                itmModel.setReturn(model.isItmIsReturn());
                //End BZ25860
                //Begin BZ24801
                /*If Name/code of sale person doesn't exist 
                 *then sale person will get name-code from employee login of Transaction*/
                if (salePerson.getCode() == null
                        || salePerson.getCode().isEmpty()) {
                    salePerson.setCode(model.getCode());
                }
                if (salePerson.getName() == null
                        || salePerson.getName().isEmpty()) {
                    salePerson.setName(model.getName());
                }
                //End BZ24801
                itmModel.setSalesPerson(salePerson);
                itmModel.setRtransLineitmSeq(CawUtils.getInstance().vInt(model.getRtransLineitmSeq()));/*BZ45903*/
                //Begin BZ26879
                CawOriginalItemAndWarrantyModel cawOriginalItemAndWarrantyModel = null;
                cawOriginalItemAndWarrantyModel = checkItemWarranty(model
                        .getItmCode(), transSeq, model.getStoreID(), model
                                .getRegID(), model
                                        .getRtransLineitmSeq(), conn, correlationKey);
                String correlationItmWarranty = "";
                if (!CawOriginalItemAndWarrantyModel
                        .isEmpty(cawOriginalItemAndWarrantyModel
                                .getTranNbr())) {
                    correlationItmWarranty = getLineItmSeqItemWarrantyAndOriginal(cawOriginalItemAndWarrantyModel, conn);
                }

                //BZ25558 Added a node of attributes into item model as well as ItemsTemplate.txt 
                if (CawUtils.getInstance().vBoolean(rsItemInfo
                        .getString(CawDBFieldConstant.RETURN_FLAG_FIELD))) {
                    Timestamp orgbusinessDate = rsItemInfo
                            .getTimestamp(CawDBFieldConstant.ORIGINAL_BUSINESS_DATE_FIELD);
                    String orgStoreId = rsItemInfo
                            .getString(CawDBFieldConstant.ORIGINAL_RTL_LOC_ID_FIELD);
                    String orgRegId = rsItemInfo
                            .getString(CawDBFieldConstant.ORIGINAL_WKSTN_ID_FIELD);
                    String orgTranseq = rsItemInfo
                            .getString(CawDBFieldConstant.ORIGINAL_TRANS_SEQ_FIELD);
                    String orgTranLineSeq = rsItemInfo
                            .getString(CawDBFieldConstant.ORIGINAL_RTRANS_LINEITM_SEQ_FIELD);
                    if (orgTranseq != null && orgStoreId != null
                            && orgRegId != null) {
                        cawOriginalItemAndWarrantyModel = new CawOriginalItemAndWarrantyModel();
                        cawOriginalItemAndWarrantyModel
                                .setBsnDate(orgbusinessDate);
                        cawOriginalItemAndWarrantyModel.setRegId(orgRegId);
                        cawOriginalItemAndWarrantyModel.setStoreId(orgStoreId);
                        cawOriginalItemAndWarrantyModel.setTranNbr(orgTranseq);
                        cawOriginalItemAndWarrantyModel
                                .setTransLienItmSeq(orgTranLineSeq);

                        orgCorrelationKey = getLineItmSeqItemWarrantyAndOriginal(cawOriginalItemAndWarrantyModel, conn);
                        if (orgCorrelationKey != null
                                && orgCorrelationKey.length() > 0) {
                            attributesModel
                                    .setOrignalCorrelationKey(orgCorrelationKey);
                        }
                        //Build queryKey with original information
                        queryKeyOrig = CawUtils.getInstance()
                                .queryKeyFormat(CawCommonConstant.WA_CODE, orgStoreId, orgbusinessDate, orgRegId, orgTranseq, orgTranLineSeq);
                        queryKeyPropOrig = CawUtils.getInstance()
                                .queryKeyFormat(CawCommonConstant.WO_PROPERTIES_CODE, orgStoreId, orgbusinessDate, orgRegId, orgTranseq, orgTranLineSeq); /*BZ29324*/
                    }
                }
                //End BZ27584
                //Begin BZ29205
                /*queryKeyWoPropertiesFormat: define string key to query in sql*/
                proCodeWOPropKey = CawUtils.getInstance()
                        .queryKeyFormat(CawCommonConstant.WO_PROPERTIES_CODE, storeID, model
                                .getBsnDate(), regID, transSeq, model
                                        .getRtransLineitmSeq());
                /*BEGIN BZ29324/BZ29912: in case Return Transaction, the key should be replace with original key*/
                if (CawUtils.getInstance().vBoolean(rsItemInfo
                        .getString(CawDBFieldConstant.RETURN_FLAG_FIELD))
                        && !(CawCommonConstant.WORK_ORDER_CANCEL.equals(model
                                .getOrderModel().getOrderType()))) {
                    proCodeWOPropKey = queryKeyPropOrig;
                }
                /*END BZ29324//BZ29912*/

                /*woProperties: string value from sql query*/
                woProperties = getRTransLineItemProperty(conn, proCodeWOPropKey);

                String propertiesDetail = loadPropAttributeModelDetails(model, conn, transSeq, storeID, regID, bsnDate, model
                        .getRtransLineitmSeq(), queryKeyOrig, correlationItmWarranty, proCodeWOPropKey, woProperties, queryKeyPropOrig);//BZ29324
                //End BZ29205
                //Begin BZ27712: getting then adding work order item's attributes
                if (propertiesDetail != null && propertiesDetail.length() > 0) {
                    /*BEGIN BZ44528*/
                    try {
                        JSONObject jsonProperties = new JSONObject(propertiesDetail);
                        if(jsonProperties != null && jsonProperties.has(CawCommonConstant.WONDERSIGN_CART_ID)) {
                            String cartId = (String) jsonProperties.remove(CawCommonConstant.WONDERSIGN_CART_ID);
                            propertiesDetail = jsonProperties.toString();
                            /*BEGIN BZ45949*/
                            if(!wondersignCartId.contains(cartId)) {
                                StringBuilder sbPro = new StringBuilder(wondersignCartId);
                                wondersignCartId = sbPro.length() > 0 ? sbPro.append(",").append(cartId).toString():cartId;
                            }
                            /*END BZ45949*/
                        /*BEGIN BZ44917, BZ47542*/
                        } else if (jsonProperties != null && jsonProperties.has(CawCommonConstant.RV_SERVICE_PAYMENT_PROPERTIES)) {
                            String rvProperties = (String) jsonProperties.remove(CawCommonConstant.RV_SERVICE_PAYMENT_PROPERTIES);
                            JSONObject jsonRvProperties = new JSONObject(rvProperties);
                            Iterator<String> keys = jsonRvProperties.keys();
                            //add rv properties to json properties
                            while(keys.hasNext()) {
                                String key = keys.next();
                                jsonProperties.put(key, jsonRvProperties.get(key));
                            }
                            propertiesDetail = jsonProperties.toString();
                            rvPaymentAmount = rvPaymentAmount.add(unitListPrice);
                        }
                        /*END BZ44917, BZ47542*/
                    } catch (JSONException e) {
                        logger.error("Error in get wondersign cart id: " + e.getMessage());
                    }
                    /*END BZ44528*/
                    CawPropertiesModel properties = new CawPropertiesModel();
                    properties.setProperty4(propertiesDetail);
                    itmModel.setPropertiesModel(properties);
                    logger.debug("Properties's info:" + CawOrderServiceUtils
                            .writeValueAsString(properties));
                }

                //BZ25558 Added a node of attributes into item model as well as ItemsTemplate.txt 
                String retCode = rsItemInfo
                        .getString(CawDBFieldConstant.RETURN_REASCODE_FIELD);

                if (retCode != null && retCode.length() > 0) {
                    retCode = getComReasonDesc(conn, CawCommonConstant.VAL_RETURN_REASON_TYPCODE, retCode);
                    if (retCode != null && retCode.length() > 0) {
                        attributesModel.setReturnReason(retCode);
                    }
                }

                if (attributesModel != null) {
                    itmModel.setAttributesModel(attributesModel);
                }

                model.getOrderModel().getItems().add(itmModel);
            }
            /*BEGIN BZ44528*/
            attributesModel = model.getOrderModel().getAttributes();
            if(attributesModel == null) {
                attributesModel = new CawAttributesModel();
            }
            logger.info("cartIDs:" + wondersignCartId);
            attributesModel.setCartIDs(wondersignCartId);
            attributesModel.setRvPaymentAmount(rvPaymentAmount);/*BZ44917*/
            model.getOrderModel().setAttributes(attributesModel);;
            /*END BZ44528*/
        }


    /**
     * 
     * @param model
     * @param conn
     * @param correlationKey
     * @return
     * @throws SQLException
     */
    public static ResultSet readItemInfo(CawTransactionModel model, Connection conn, PreparedStatement psItemInfo,
            String correlationKey) throws SQLException {

        String transSeq = model.getTransSeq();
        String storeID = model.getStoreID();
        String regID = model.getRegID();
        Timestamp bsnDate = model.getBsnDate();
        ResultSet rsItemInfo = null;
        //PREPARE ITEM QUERY STATEMENT

        psItemInfo.setString(1, transSeq);
        psItemInfo.setString(2, storeID);
        psItemInfo.setString(3, regID);
        psItemInfo.setTimestamp(4, bsnDate);
        rsItemInfo = psItemInfo.executeQuery();
        logger.debug("loadItemsTransaction()-Executed query for ItemInfo\n" + CawSQLConstant.QUERY_ITEMS_INFO + " "
                + Arrays.asList(transSeq, storeID, regID, bsnDate));
        return rsItemInfo;
    }
    /*END BZ33985*/

    /**
     * this method is used to get Items Adjustment for Item
     * @param conn
     * @param model
     * @param correlationKey
     * @param discountType
     * @param isReturnWebOrdLineItem
     * @throws SQLException
     * @throws JsonProcessingException
     */
    private static void loadAdjustmentModelsWithDiscountType(Connection conn,
            CawTransactionModel model, String correlationKey,
            String discountType, boolean isReturnWebOrdLineItem)
            throws SQLException, JsonProcessingException {

        PreparedStatement psItemDiscount = null;
        ResultSet rsItemDiscount = null;
        CawAdjustmentsModel adjModel = null;
        BigDecimal adjAmount = BigDecimal.ZERO; /* BZ32434 */
        try {
            //Begin BZ24270
            //PREPARE ITEM QUERY STATEMENT
            psItemDiscount = conn
                    .prepareStatement(CawSQLConstant.QUERY_ITEM_DISCOUNT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //End BZ24270
            psItemDiscount.setString(1, model.getTransSeq());
            psItemDiscount.setString(2, model.getStoreID());
            psItemDiscount.setString(3, model.getRegID());
            psItemDiscount.setTimestamp(4, model.getBsnDate());
            psItemDiscount.setString(5, model.getItmCode());
            psItemDiscount.setString(6, model.getRtransLineitmSeq());
            rsItemDiscount = psItemDiscount.executeQuery();
            logger.debug("loadListOfAdjustmentModels()-Executed query Item Discount\n"
                    + CawSQLConstant.QUERY_ITEM_DISCOUNT + " "
                    + Arrays.asList(model.getTransSeq(), model
                            .getStoreID(), model.getRegID(), model
                                    .getBsnDate(), model
                                            .getRtransLineitmSeq()));
            rsItemDiscount.last();
            logger.debug("Result set – size:" + rsItemDiscount.getRow());
            rsItemDiscount.beforeFirst();

            while (rsItemDiscount.next()) {
                model.setItmExtendedAmt(null);
                model.setRtlPriceModReason(CawCommonConstant.EMPTY_STRING);
                model.setItmDisCode(null);
                model.setAdjSerialCoupon(null);
                model.setItmDisDealId(null);
                //Begin BZ24390: extendedAmt will be included discount * quantity
                model.setItmExtendedAmt(rsItemDiscount
                        .getBigDecimal(CawDBFieldConstant.EXTENDED_AMT_FIELD));
                /*compare extendedAmt with zero. if extendedAmt != 0 , 
                 *discount appears here, 
                 *else if then extendedAmt is zero => no need display for discount is zero*/
                //BZ25441 - BZ25740 Fixed 
                //BZ31944 update the conditional to export adjustment for prompt price item 
                if ((model.getItmExtendedAmt().compareTo(BigDecimal.ZERO) != 0)
                        && !((model.getItmRegBasePrice().compareTo(BigDecimal.ZERO) == 0
                                && model.getPromptForPriceFlag() != 1) || isReturnWebOrdLineItem)) {
                    adjModel = new CawAdjustmentsModel();
                    //Begin BZ24527
                    //Begin BZ24642
                    model.setAdjCorRelationKey(correlationKey + ":"
                            + model.getCountItem() + ":"
                            + model.getCountDisItem());
                    model.setCountDisItem(model.getCountDisItem() + 1);
                    //End BZ24642
                    //End BZ24527
                    adjModel.setCorrelationKey(model.getAdjCorRelationKey());//correlationKey
                    adjModel.setType(discountType);//type
                    model.setItmDiscountAmt(model.getItmDiscountAmt()
                            .add(model.getItmExtendedAmt()));
                    //Begin BZ24516
                    model.setItmExtendedAmt(model.getItmExtendedAmt()
                            .multiply(BigDecimal.valueOf(-1)));
                    //End BZ24516
                    /* BEGIN BZ32434: make sure adjustment amount negative for Sale and positive for Return */
                    adjAmount = CawOrderServiceUtils.getSignValue(model.getItmExtendedAmt(), 2, model.isItmIsReturn());
                    adjModel.setAmount(adjAmount);
                    /* END BZ32434 */
                    //End BZ24390
                    model.setItmDisCode(rsItemDiscount
                            .getString(CawDBFieldConstant.DISCOUNT_CODE_FIELD));
                    if (model.getItmDisCode() != null) {
                        adjModel.setCouponCode(model.getItmDisCode()); //couponCode
                        adjModel.setSerializedCoupon(null); //serializedCoupon
                    } else {
                        model.setAdjSerialCoupon(rsItemDiscount
                                .getString(CawDBFieldConstant.SERIAL_NUMBER_FIELD));
                        model.setItmDisDealId(rsItemDiscount
                                .getString(CawDBFieldConstant.DEAL_ID_FIELD));
                        //discountCode = null, dealId = null
                        if (model.getItmDisDealId() == null) {
                            /* BZ33984: change field RTL_PRICE_MOD_REASON_FIELD to field BOUNCE_BACK_COUPON,
                             * change value setSerializedCoupon from null to field SERIAL_NUMBER_FIELD */
                            adjModel.setCouponCode(rsItemDiscount.getString(CawDBFieldConstant.BOUNCE_BACK_COUPON)); //couponCode
                            adjModel.setSerializedCoupon(model.getAdjSerialCoupon()); //serializedCoupon
                        } else {//discountCode = null, dealId != null
                            if ((model.getItmDisDealId() != null
                                    && model.getAdjSerialCoupon() != null)
                                    && model.getItmDisDealId().compareTo(model
                                            .getAdjSerialCoupon()) != 0) {
                                adjModel.setCouponCode(model.getItmDisDealId()); //couponCode
                                /* BEGIN BZ31793: the actual amt used by a serial number */
                                adjModel.setSerializedCoupon(rsItemDiscount
                                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD));
                                adjModel.setAmount(rsItemDiscount
                                        .getBigDecimal(CawDBFieldConstant.DECIMAL_VALUE_FIELD));
                                /* END BZ31793 */
                            } else {
                                adjModel.setCouponCode(model.getItmDisDealId()); //couponCode
                                adjModel.setSerializedCoupon(null); //serializedCoupon
                            }
                        }

                    }

                    model.getAdjustments().add(adjModel);
                    logger.debug("loadListOfAdjustmentModels()-Item Adjustment's info:"
                            + CawOrderServiceUtils
                                    .writeValueAsString(adjModel));
                }
            }
        } finally {
            if (rsItemDiscount != null) {
                rsItemDiscount.close();
            }
            if (psItemDiscount != null) {
                psItemDiscount.close();
            }
        }
    }

    /**
     * this method is used to get Properties for Item
     * @param model
     * @param conn
     * @param transSeq
     * @param storeID
     * @param regID
     * @param bsnDate
     * @param rtransLineitmSeq
     * @param wOPropertieskey 
     * @return
     */
    private static String loadPropAttributeModelDetails(
            CawTransactionModel model, Connection conn, String transSeq,
            String storeID, String regID, Timestamp bsnDate,
            String rtransLineitmSeq, String queryKeyOrig,
            String correlationItmWarranty, String proCodeWOPropKey,
            String woPropValue, String queryKeyPropOrig) {//BZ26879,29205, BZ29324: added param queryKeyPropOrig

        PreparedStatement psItemProRTL = null;
        ResultSet rsItemProRTL = null;
        StringBuilder sbPro = new StringBuilder();
        StringBuilder finalProperty4 = new StringBuilder();
        String queryKey = null; //BZ27712
        try {
            //Begin BZ24905
            psItemProRTL = conn
                    .prepareStatement(CawSQLConstant.QUERY_ITEM_PRO_RTL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //End BZ24905
            //Begin BZ24905
            psItemProRTL.setString(1, transSeq);
            psItemProRTL.setString(2, storeID);
            psItemProRTL.setString(3, regID);
            psItemProRTL.setTimestamp(4, bsnDate);
            psItemProRTL.setString(5, rtransLineitmSeq);
            //Begin BZ27712: Except property line with this property code.
            queryKey = CawUtils.getInstance()
                    .queryKeyFormat(CawCommonConstant.WA_CODE, storeID, bsnDate, regID, transSeq, rtransLineitmSeq);
            //Begin BZ28203
            if (queryKeyOrig.isEmpty()) {
                queryKeyOrig = queryKey;
            }
            //End BZ28203
            /*BEGIN BZ29324*/
            if (queryKeyPropOrig.isEmpty()) {
                queryKeyPropOrig = proCodeWOPropKey;
            }
            /*END BZ29324*/
            psItemProRTL.setString(6, queryKey);
            psItemProRTL.setString(7, queryKeyOrig);
            psItemProRTL.setString(8, proCodeWOPropKey);//BZ29205
            psItemProRTL.setString(9, queryKeyPropOrig); /*BZ29324*/
            //End BZ27712
            rsItemProRTL = psItemProRTL.executeQuery();
            logger.debug("loadPropAttributeModelDetails()-Executed query for loading Properties Attribute\n"
                    + CawSQLConstant.QUERY_ITEM_PRO_RTL + " "
                    + Arrays.asList(transSeq, storeID, regID, bsnDate, model
                            .getRtransLineitmSeq(), queryKey, queryKeyOrig, queryKeyPropOrig));
            rsItemProRTL.last();
            logger.debug("Result set – size:" + rsItemProRTL.getRow());
            rsItemProRTL.beforeFirst();

            while (rsItemProRTL.next()) {
                model.setItmPropStrVal(CawCommonConstant.EMPTY_STRING);
                model.setItmProDateVal(CawCommonConstant.EMPTY_STRING);
                model.setItmPropDecimalVal(BigDecimal.valueOf(0));
                model.setItmPropcode(CawCommonConstant.EMPTY_STRING);

                model.setItmPropStrVal(rsItemProRTL
                        .getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                model.setItmProDateVal(rsItemProRTL
                        .getString(CawDBFieldConstant.DATE_VALUE_FIELD));
                model.setItmPropDecimalVal(rsItemProRTL
                        .getBigDecimal(CawDBFieldConstant.DECIMAL_VALUE_FIELD));
                model.setItmPropcode(rsItemProRTL
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD));
                model.setPropertyMapping(rsItemProRTL
                        .getString(CawDBFieldConstant.PROPERTY_MAPPING));//BZ29156
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append("\"");
                if (model.getItmPropcode()
                        .startsWith(CawCommonConstant.COUPON_CODE_FIELD)) {
                    sbPro.append(CawWSTemplateConstant.COUPON_CODE_LABEL);
                } else {
                    //BEGIN BZ29156
                    if (StringUtils.isBlank(model.getPropertyMapping())) {
                        sbPro.append(model.getItmPropcode().toLowerCase());
                    } else {
                        sbPro.append(model.getPropertyMapping());
                    }
                    //END BZ29156
                }
                sbPro.append("\":");
                if (model.getItmProDateVal() != null) {
                    sbPro.append(CawOrderServiceUtils
                            .formatParameter(model.getItmProDateVal()));
                } else if (model.getItmPropDecimalVal() != null) {
                    sbPro.append(CawOrderServiceUtils
                            .formatParameter(model.getItmPropDecimalVal().toString())); //BZ53670 
                } else {
                    /* BEGIN BZ30009 */
                    String itemDescription = StringEscapeUtils
                            .escapeJson(model.getItmPropStrVal());
                    sbPro.append(CawOrderServiceUtils
                            .formatParameter(itemDescription));
                    /* END BZ30009 */
                }
            }
            //Begin BZ26308
            if (!Strings.isNullOrEmpty(model.getSerialNbr())) {
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append("\"serialNumber\":");
                sbPro.append(CawOrderServiceUtils
                        .formatParameter(model.getSerialNbr()));
            }
            //End BZ26308
            //Begin BZ26879
            if (!Strings.isNullOrEmpty(correlationItmWarranty)) {
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append("\"warrantedItem\":");
                sbPro.append(CawOrderServiceUtils
                        .formatParameter(correlationItmWarranty));
            }
            //End BZ26879
            //Begin BZ29205
            if (!Strings.isNullOrEmpty(woPropValue)) {
                if (sbPro.length() > 0) {
                    sbPro.append(",");
                }
                sbPro.append(woPropValue);
            }
            //End BZ29205
            if (sbPro.length() > 0) {
                finalProperty4.append("{").append(sbPro).append("}");
            }
        } catch (Exception e) {
            logger.error("loadPropAttributeModelDetails-0:", e);
        } finally {
            if (rsItemProRTL != null) {
                try {
                    rsItemProRTL.close();
                } catch (SQLException ex) {
                    logger.error("Error in loadPropAttributeModelDetails-1: "
                            + ex.getMessage());
                }
            }
            if (psItemProRTL != null) {
                try {
                    psItemProRTL.close();
                } catch (SQLException ex) {
                    logger.error("Error in loadPropAttributeModelDetails-2: "
                            + ex.getMessage());
                }
            }
        }
        return finalProperty4.toString();
    }

    //Begin BZ25640
    /**
     * Get value for UFA property codes:
     * : UFA_DETAIL; ETRACK_ID; EBS_ITEM_CODE
     * @param conn
     * @param transSeq
     * @param storeID
     * @param regID
     * @param bsnDate
     * @param rtransLineitmSeq
     * @return
     */
    public static String loadUFAProperties(Connection conn, String transSeq,
            String storeID, String regID, Timestamp bsnDate) {

        PreparedStatement psItemUFAProRTL = null;
        ResultSet rsItemUFAProRTL = null;
        StringBuilder finalUFAPro = new StringBuilder();
        StringBuilder sbProUFADetail = new StringBuilder();
        String etrackId = null;
        String ebsItemCode = null;
        String firearmDetail = null;
        try {
            psItemUFAProRTL = conn
                    .prepareStatement(CawSQLConstant.QUERY_UFA_PROPERTIES, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psItemUFAProRTL.setString(1, transSeq);
            psItemUFAProRTL.setString(2, storeID);
            psItemUFAProRTL.setString(3, regID);
            psItemUFAProRTL.setTimestamp(4, bsnDate);
            rsItemUFAProRTL = psItemUFAProRTL.executeQuery();
            String strValue, strCode;
            while (rsItemUFAProRTL.next()) {
                strValue = rsItemUFAProRTL
                        .getString(CawDBFieldConstant.STRING_VALUE_FIELD);
                strCode = rsItemUFAProRTL
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD);
                if (CawCommonConstant.UFA_PROPERTY_ETRACK_ID.equals(strCode)) {
                    etrackId = strValue;
                } else if (CawCommonConstant.UFA_PROPERTY_EBS_ITEM_CODE
                        .equals(strCode)) {
                    ebsItemCode = strValue;
                } else if (CawCommonConstant.UFA_PROPERTY_UFA_DETAIL
                        .equals(strCode)) {
                    firearmDetail = strValue;
                }
            }

            if (firearmDetail != null) {
                sbProUFADetail.append(firearmDetail);
                if (sbProUFADetail.toString().startsWith("{")) {
                    sbProUFADetail.deleteCharAt(0);
                }
                if (sbProUFADetail.toString().endsWith("}")) {
                    sbProUFADetail.deleteCharAt(sbProUFADetail.length() - 1);
                }
            }

            //One of three not null, then able to add UFA properties 
            if (ebsItemCode != null || etrackId != null) {
                if (sbProUFADetail.length() > 0) {
                    sbProUFADetail.append(",");
                }
                sbProUFADetail.append("\"etrackId\":");
                sbProUFADetail
                        .append(CawOrderServiceUtils.formatParameter(etrackId));

                if (sbProUFADetail.length() > 0) {
                    sbProUFADetail.append(",");
                }
                sbProUFADetail.append("\"ebsItemCode\":");
                sbProUFADetail.append(CawOrderServiceUtils
                        .formatParameter(ebsItemCode));
            }

            if (sbProUFADetail.length() > 0) {
                finalUFAPro.append("{").append(sbProUFADetail).append("}");
            }
        } catch (Exception e) {
            logger.error("loadUFAProperty-0:", e);
        } finally {
            if (rsItemUFAProRTL != null) {
                try {
                    rsItemUFAProRTL.close();
                } catch (SQLException ex) {
                    logger.error("Error in loadUFAProperty-1: "
                            + ex.getMessage());
                }
            }
            if (psItemUFAProRTL != null) {
                try {
                    psItemUFAProRTL.close();
                } catch (SQLException ex) {
                    logger.error("Error in loadUFAProperty-2: "
                            + ex.getMessage());
                }
            }
        }

        return finalUFAPro.toString();
    }
    //End BZ25640

    /**
     * this method is used to get Tax Group Id for PaidIn/Out
     * @param conn
     * @param codePaidInOut
     * @return
     * @throws SQLException
     */
    public static String loadTaxGroupIdPaidInOut(CawTransactionModel model,
            Connection conn, String codePaidInOut) throws SQLException {

        PreparedStatement psPaidInOutTaxCode = null;
        ResultSet rsPaidInOutTaxCode = null;

        try {
            String sqlPaidInOutTaxCode = CawSQLConstant.QUERY_PAID_IN_OUT_TAX_CODE;
            psPaidInOutTaxCode = conn
                    .prepareStatement(sqlPaidInOutTaxCode, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psPaidInOutTaxCode.setString(1, codePaidInOut);
            rsPaidInOutTaxCode = psPaidInOutTaxCode.executeQuery();
            logger.debug("loadTaxGroupIdPaidInOut()-Executed query for loading Group Id PaidIn/Out\n"
                    + sqlPaidInOutTaxCode + " " + Arrays.asList(codePaidInOut));
            rsPaidInOutTaxCode.last();
            logger.debug("Result set – size:" + rsPaidInOutTaxCode.getRow());
            rsPaidInOutTaxCode.beforeFirst();

            //@TODO - why used while
            while (rsPaidInOutTaxCode.next()) {
                model.setTaxCodePaidInOut(rsPaidInOutTaxCode
                        .getString(CawDBFieldConstant.TAX_GROUP_ID_FIELD));
            }
            if (model.getTaxCodePaidInOut().isEmpty()) {
                model.setTaxCodePaidInOut(CawCommonConstant.ITM_TAX_CODE_PAID_IN_OUT);
            }
            logger.debug("loadTaxGroupIdPaidInOut()-Group Id PaidIn/Out infor:"
                    + model.getTaxCodePaidInOut());
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

        return model.getTaxCodePaidInOut();
    }

    /**
     * this method is used to get description for PaidIn/Out
     * @param conn
     * @param reasonCode
     * @return
     */
    public static String getDescPaidOut(Connection conn, String reasonCode) {

        PreparedStatement psPaidInPaidOutDetail = null;
        ResultSet rsPaidInPaidOutDetail = null;
        String descPaidInOut = null;

        try {
            String sqlPaidInPaidOutDetail = CawSQLConstant.QUERY_PAID_IN_OUT_DETAIL_OUT;
            psPaidInPaidOutDetail = conn
                    .prepareStatement(sqlPaidInPaidOutDetail, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psPaidInPaidOutDetail.setString(1, reasonCode);
            rsPaidInPaidOutDetail = psPaidInPaidOutDetail.executeQuery();
            logger.debug("getDescPaidOut()-Executed query for getting Description PaidIn/Out\n"
                    + sqlPaidInPaidOutDetail + " " + Arrays.asList(reasonCode));
            rsPaidInPaidOutDetail.last();
            logger.debug("Result set – size:" + rsPaidInPaidOutDetail.getRow());
            rsPaidInPaidOutDetail.beforeFirst();

            if (rsPaidInPaidOutDetail.next()) {
                descPaidInOut = rsPaidInPaidOutDetail
                        .getString(CawDBFieldConstant.DESCRIPTION_FIELD);
                logger.debug("getDescPaidOut()-Description PaidIn/Out infor:"
                        + descPaidInOut);
            }
        } catch (Exception e) {
            logger.error("getDescPaidOut-1: " + e.getMessage());
        } finally {
            if (rsPaidInPaidOutDetail != null) {
                try {
                    rsPaidInPaidOutDetail.close();
                } catch (SQLException e) {
                    logger.error("getDescPaidOut-2: " + e.getMessage());
                }
            }
            if (psPaidInPaidOutDetail != null) {
                try {
                    psPaidInPaidOutDetail.close();
                } catch (SQLException e) {
                    logger.error("getDescPaidOut-3: " + e.getMessage());
                }
            }
        }

        return descPaidInOut;
    }

    /**
     * BZ 25441 & BZ25740: fix for case web order return
     * @param conn
     * @param transSeq
     * @param storeId
     * @param regId
     * @param bsnDate
     * @param rTransLineItmSeq
     * @return
     */
    private static boolean isReturnWebOrderLineItm(Connection conn,
            String transSeq, String storeId, String regId,
            java.sql.Timestamp bsnDate, String rTransLineItmSeq) {

        boolean check = false;
        ResultSet rsItemProRTL = null;
        String _propertyCode = null;
        PreparedStatement psItemProRTL = null;
        try {
            psItemProRTL = conn
                    .prepareStatement(CawSQLConstant.QUERY_CHK_WEB_ORD_LINE_ITM_RETURN);
            psItemProRTL.setString(1, transSeq);
            psItemProRTL.setString(2, storeId);
            psItemProRTL.setString(3, regId);
            psItemProRTL.setTimestamp(4, bsnDate);
            psItemProRTL.setString(5, rTransLineItmSeq);
            rsItemProRTL = psItemProRTL.executeQuery();

            while (rsItemProRTL.next()) {
                _propertyCode = rsItemProRTL
                        .getString(CawDBFieldConstant.PROPERTY_CODE_FIELD);
                if (CawCommonConstant.P_CODE_SALES_ORD_INF
                        .equalsIgnoreCase(_propertyCode)) {
                    check = true;
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("isReturnWebOrderLineItm-0: " + e.getMessage());
        } finally {
            if (rsItemProRTL != null) {
                try {
                    rsItemProRTL.close();
                } catch (SQLException e) {
                    logger.error("isReturnWebOrderLineItm-1: "
                            + e.getMessage());
                }
            }
            if (psItemProRTL != null) {
                try {
                    psItemProRTL.close();
                } catch (SQLException e) {
                    logger.error("isReturnWebOrderLineItm-2: "
                            + e.getMessage());
                }
            }
        }
        return check;
    }

    /**
     * Added b/c BZ25558
     * Get reason description for the given type and code 
     * @param conn
     * @param reasonTypCode
     * @param reasonCode
     * @return
     */
    private static String getComReasonDesc(Connection conn,
            String reasonTypCode, String reasonCode) {

        String reasonDesc = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(CawSQLConstant.QUERY_COM_REASON_CODE);
            ps.setString(1, reasonTypCode);
            ps.setString(2, reasonCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                reasonDesc = rs.getString(CawDBFieldConstant.DESCRIPTION_FIELD);
            }
        } catch (Exception e) {
            logger.error("getComReasonDesc-0: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.error("getComReasonDesc-1: " + e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    logger.error("getComReasonDesc-2: " + e.getMessage());
                }
            }
        }
        return reasonDesc;
    }

    //Begin BZ29391
    //Begin BZ26289
    private static CawPaidInOutDetail getPaymentDetail(Connection conn,
            String itemCode, String reasonCode) {

        String[] parts = null;
        CawPaidInOutDetail paidIODetail = null;
        String itmPaidIn = CawPropertiesConfig.getPaidInItemId();
        try {
            if (itmPaidIn != null && itmPaidIn.length() > 0
                    && itmPaidIn.equalsIgnoreCase(itemCode)) {
                paidIODetail = new CawPaidInOutDetail();
                parts = reasonCode.split("-");
                paidIODetail.setCode(parts[0]);
                paidIODetail.setDescription(parts[1]);
            }
        } catch (Exception e) {
            logger.error("getArPaymentDetail-0:", e);
        }
        return paidIODetail;
    }

    //End BZ29391
    //End BZ26289
    //Begin BZ26289
    public static boolean checkArPaymentExisted(Connection conn,
            String transSeq, String storeID, String regID, Timestamp bsnDate,
            String rtransLineitmSeq) {

        PreparedStatement psArPayment = null;
        ResultSet rsArPayment = null;
        try {
            psArPayment = conn
                    .prepareStatement(CawSQLConstant.QUERY_AR_PAYMENT);

            psArPayment.setString(1, transSeq);
            psArPayment.setString(2, storeID);
            psArPayment.setString(3, regID);
            psArPayment.setTimestamp(4, bsnDate);
            psArPayment.setString(5, rtransLineitmSeq);
            rsArPayment = psArPayment.executeQuery();
            if (rsArPayment.next()) {
                return true;
            }

        } catch (Exception e) {
            logger.error("checkArPaymentExisted-0:", e);
        } finally {
            if (rsArPayment != null) {
                try {
                    rsArPayment.close();
                } catch (SQLException ex) {
                    logger.error("Error in checkArPaymentExisted-1: "
                            + ex.getMessage());
                }
            }
            if (psArPayment != null) {
                try {
                    psArPayment.close();
                } catch (SQLException ex) {
                    logger.error("Error in checkArPaymentExisted-2: "
                            + ex.getMessage());
                }
            }
        }

        return false;
    }

    //End BZ26289
    //Begin BZ26207
    /**
     * @param conn
     * @param transSeq
     * @param bsdate 
     * @param reg 
     * @param location 
     * @param bsdate 
     * @param reg 
     * @param location 
     * @return
     */
    public static CawWorkOrderDetail getWorkOrderInfo(Connection conn,
            String transSeq, String location, String reg, Timestamp bsdate) {

        PreparedStatement psWorkOrder = null;
        ResultSet rsWorkOrder = null;
        CawWorkOrderDetail workOrderDetail = null; // BZ30261
        try {
            String sqlWorkOrder = CawSQLConstant.QUERY_WORK_ORDER;
            psWorkOrder = conn
                    .prepareStatement(sqlWorkOrder, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psWorkOrder.setString(1, transSeq);
            psWorkOrder.setString(2, location);
            psWorkOrder.setString(3, reg);
            psWorkOrder.setTimestamp(4, bsdate);

            rsWorkOrder = psWorkOrder.executeQuery();
            logger.debug("getWorkOrderInfo()-Executed query for getting Description getWorkOrderInfo\n"
                    + sqlWorkOrder + " "
                    + Arrays.asList(transSeq, location, reg, bsdate));
            rsWorkOrder.last();
            logger.debug("Result set – size:" + rsWorkOrder.getRow());
            rsWorkOrder.beforeFirst();

            if (rsWorkOrder.next()) {
                workOrderDetail = new CawWorkOrderDetail();// BZ30261
                workOrderDetail.setId(rsWorkOrder
                        .getString(CawDBFieldConstant.CUST_ACCT_ID_FIELD));
                workOrderDetail.setPosStatus(rsWorkOrder
                        .getString(CawDBFieldConstant.LINE_TYPCODE_FIELD));
            }
        } catch (Exception e) {
            logger.error("getDescPaidOut-1: " + e.getMessage());
        } finally {
            if (rsWorkOrder != null) {
                try {
                    rsWorkOrder.close();
                } catch (SQLException e) {
                    logger.error("getDescPaidOut-2: " + e.getMessage());
                }
            }
            if (psWorkOrder != null) {
                try {
                    psWorkOrder.close();
                } catch (SQLException e) {
                    logger.error("getDescPaidOut-3: " + e.getMessage());
                }
            }
        }
        return workOrderDetail;
    }

    // End BZ26207
    //Begin BZ26879
    /**
     * @param itmCode
     * @param bsdate, Connection conn 
     * @param reg 
     * @param location 
     * @param transSeq 
     */
    public static CawOriginalItemAndWarrantyModel checkItemWarranty(
            String itmCode, String transSeq, String location, String reg,
            String tranLineSeq, Connection conn, String correlationKey) {

        CawOriginalItemAndWarrantyModel cawOriginalItemAndWarrantyModel = new CawOriginalItemAndWarrantyModel();
        PreparedStatement psItmWarranty = null;
        ResultSet rsItmWarranty = null;
        try {
            String sqlItmWarranty = CawSQLConstant.QUERY_ITEM_WARRANTY;
            psItmWarranty = conn
                    .prepareStatement(sqlItmWarranty, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            psItmWarranty.setString(1, itmCode);
            psItmWarranty.setString(2, transSeq);
            psItmWarranty.setString(3, location);
            psItmWarranty.setString(4, reg);
            psItmWarranty.setString(5, tranLineSeq);
            rsItmWarranty = psItmWarranty.executeQuery();
            logger.debug("checkItemWarranty()-Executed query for getting Description checkItemWarranty()\n"
                    + sqlItmWarranty + " "
                    + Arrays.asList(itmCode, transSeq, location, reg, tranLineSeq));
            rsItmWarranty.last();
            logger.debug("Result size:" + rsItmWarranty.getRow());
            rsItmWarranty.beforeFirst();
            if (rsItmWarranty.next()) {
                cawOriginalItemAndWarrantyModel.setTranNbr(rsItmWarranty
                        .getString(CawDBFieldConstant.COVERED_LINE_TRANS_SEQ_FIELD));
                cawOriginalItemAndWarrantyModel.setStoreId(rsItmWarranty
                        .getString(CawDBFieldConstant.COVERED_LINE_RTL_LOC_ID_FIELD));
                cawOriginalItemAndWarrantyModel.setRegId(rsItmWarranty
                        .getString(CawDBFieldConstant.COVERED_LINE_WKSTN_ID_FIELD));
                cawOriginalItemAndWarrantyModel.setTransLienItmSeq(rsItmWarranty
                        .getString(CawDBFieldConstant.COVERED_RTRANS_LINEITM_SEQ_FIELD));
                cawOriginalItemAndWarrantyModel.setBsnDate(rsItmWarranty
                        .getTimestamp(CawDBFieldConstant.COVERED_LINE_BUSINESS_DATE_FIELD));
            }
        } catch (Exception e) {
            logger.error("checkItemWarranty-1: " + e.getMessage());
        } finally {
            if (rsItmWarranty != null) {
                try {
                    rsItmWarranty.close();
                } catch (SQLException e) {
                    logger.error("checkItemWarranty-2: " + e.getMessage());
                }
            }
            if (rsItmWarranty != null) {
                try {
                    psItmWarranty.close();
                } catch (SQLException e) {
                    logger.error("checkItemWarranty-3: " + e.getMessage());
                }
            }
        }
        return cawOriginalItemAndWarrantyModel;
    }

    private static String getLineItmSeqItemWarrantyAndOriginal(
            CawOriginalItemAndWarrantyModel cawOriginalItemAndWarrantyModel,
            Connection conn) {

        String correlaitonKey = "";
        String transLineItmSeq = "";
        DateFormat formatDtYMD = new SimpleDateFormat(
                CawCommonConstant.YYYY_M_MDD);
        PreparedStatement psLineItmWarrantyAndOriginal = null;
        ResultSet rsLineItmWarrantyAndOriginal = null;
        try {
            String transSeq = cawOriginalItemAndWarrantyModel.getTranNbr();
            String storeID = cawOriginalItemAndWarrantyModel.getStoreId();
            String regID = cawOriginalItemAndWarrantyModel.getRegId();
            Timestamp bsnDate = cawOriginalItemAndWarrantyModel.getBsnDate();
            psLineItmWarrantyAndOriginal = conn
                    .prepareStatement(CawSQLConstant.QUERY_ITEM_WARRANTY_AND_RETURN_SEQUENCE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            psLineItmWarrantyAndOriginal.setString(1, transSeq);
            psLineItmWarrantyAndOriginal.setString(2, storeID);
            psLineItmWarrantyAndOriginal.setString(3, regID);
            psLineItmWarrantyAndOriginal.setTimestamp(4, bsnDate);
            rsLineItmWarrantyAndOriginal = psLineItmWarrantyAndOriginal
                    .executeQuery();
            logger.debug("getLineItmSeqItemWarrantyAndOriginal()-Executed query for getting Description checkItemWarranty()\n"
                    + CawSQLConstant.QUERY_ITEM_WARRANTY_AND_RETURN_SEQUENCE
                    + " " + Arrays.asList(transSeq, storeID, regID, bsnDate));
            rsLineItmWarrantyAndOriginal.last();
            logger.debug("Result size:"
                    + rsLineItmWarrantyAndOriginal.getRow());
            rsLineItmWarrantyAndOriginal.beforeFirst();
            int countLineItmSeq = 0;
            while (rsLineItmWarrantyAndOriginal.next()) {
                countLineItmSeq = countLineItmSeq + 1;
                transLineItmSeq = rsLineItmWarrantyAndOriginal
                        .getString(CawDBFieldConstant.RTRANS_LINEITM_SEQ_FIELD);
                if (transLineItmSeq != null) {
                    if (transLineItmSeq
                            .equalsIgnoreCase(cawOriginalItemAndWarrantyModel
                                    .getTransLienItmSeq())) {
                        correlaitonKey = formatDtYMD
                                .format(cawOriginalItemAndWarrantyModel
                                        .getBsnDate())
                                + ":"
                                + String.format("%4s", cawOriginalItemAndWarrantyModel
                                        .getStoreId())
                                        .replace(' ', CawCommonConstant.ZERO_CHAR)
                                + ":"
                                + String.format("%2s", cawOriginalItemAndWarrantyModel
                                        .getRegId())
                                        .replace(' ', CawCommonConstant.ZERO_CHAR)
                                + ":"
                                + String.format("%4s", cawOriginalItemAndWarrantyModel
                                        .getTranNbr())
                                        .replace(' ', CawCommonConstant.ZERO_CHAR)
                                + ":" + countLineItmSeq;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("getLineItmSeqItemWarrantyAndOriginal-1: "
                    + e.getMessage());
        } finally {
            if (rsLineItmWarrantyAndOriginal != null) {
                try {
                    rsLineItmWarrantyAndOriginal.close();
                } catch (SQLException e) {
                    logger.error("getLineItmSeqItemWarrantyAndOriginal-2: "
                            + e.getMessage());
                }
            }
            if (rsLineItmWarrantyAndOriginal != null) {
                try {
                    psLineItmWarrantyAndOriginal.close();
                } catch (SQLException e) {
                    logger.error("getLineItmSeqItemWarrantyAndOriginal-3: "
                            + e.getMessage());
                }
            }
        }
        return correlaitonKey;
    }

    //End BZ26879

    /**
     * BZ27712 : query retail trans line item's property
     * @param conn
     * @param querryKey
     * @return
     */
    private static String getRTransLineItemProperty(Connection conn,
            String querryKey) {

        String property = null;
        PreparedStatement psRTLItemProperty = null;
        ResultSet rsRTLItemProperty = null;

        try {
            psRTLItemProperty = conn
                    .prepareStatement(CawSQLConstant.QUERY_RETAIL_TRANS_LINE_ITEM_PROPERTY);

            psRTLItemProperty.setString(1, querryKey);

            rsRTLItemProperty = psRTLItemProperty.executeQuery();
            logger.debug("getRTransLineItemProperty()-Executed query for getting retail trans line item property\n"
                    + CawSQLConstant.QUERY_RETAIL_TRANS_LINE_ITEM_PROPERTY + " "
                    + Arrays.asList(querryKey));

            while (rsRTLItemProperty.next()) {
                property = rsRTLItemProperty
                        .getString(CawDBFieldConstant.STRING_VALUE_FIELD);
            }
        } catch (Exception ex) {
            logger.error("getRTransLineItemProperty-0: " + ex.getMessage());
        } finally {
            if (rsRTLItemProperty != null) {
                try {
                    rsRTLItemProperty.close();
                } catch (SQLException e) {
                    logger.error("getRTransLineItemProperty-1: "
                            + e.getMessage());
                }
            }
            if (psRTLItemProperty != null) {
                try {
                    psRTLItemProperty.close();
                } catch (SQLException e) {
                    logger.error("getRTransLineItemProperty-2: "
                            + e.getMessage());
                }
            }
        }

        return property;
    }
    
    /* BEGIN BZ30261*/
    public static boolean isWorkOrderTransaction(Connection conn, CawTransactionModel model) {
        boolean isWorkOrder = false;
        PreparedStatement psTransWOLineItem = null;
        ResultSet rsTransWOLineItem = null;
        try {
            String sqlTransWOLineItem = CawSQLConstant.QUERY_TRANS_LINE_ITEM_WORK_ORDER;
            psTransWOLineItem = conn
                    .prepareStatement(sqlTransWOLineItem, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            psTransWOLineItem.setString(1, model.getTransSeq());
            psTransWOLineItem.setString(2, model.getStoreID());
            psTransWOLineItem.setString(3, model.getRegID());
            psTransWOLineItem.setTimestamp(4, model.getBsnDate());
            
            String storeIdFormated = model.getStoreID()
                    .replaceFirst(CawCommonConstant.PREFIX_ZERO, CawCommonConstant.EMPTY_STRING);
            
            String woPattern = CawCommonConstant.WA_CODE + storeIdFormated;
            psTransWOLineItem.setString(5, woPattern + "%");

            rsTransWOLineItem = psTransWOLineItem.executeQuery();
            logger.debug("isWorkOrderTransaction()-Executed query to check transaction Work Order \n"
                    + sqlTransWOLineItem + " "
                    + Arrays.asList(model.getTransSeq(), model.getStoreID(), model.getRegID(), model.getBsnDate(), woPattern));
            rsTransWOLineItem.last();
            logger.debug("Result set of size:" + rsTransWOLineItem.getRow());
            rsTransWOLineItem.beforeFirst();

            if (rsTransWOLineItem.next()) {
                Long tranSeq = rsTransWOLineItem.getLong(CawDBFieldConstant.TRANS_SEQ_FIELD);
                
                int returnFlag = rsTransWOLineItem.getInt(CawDBFieldConstant.RETURN_FLAG_FIELD);
                
                String saleLineitmTypcode = rsTransWOLineItem.getString(CawDBFieldConstant.SALE_LINEITM_TYPCODE_FIELD);
                
                String propertyCode = rsTransWOLineItem.getString(CawDBFieldConstant.PROPERTY_CODE_FIELD);

                if (tranSeq != null && tranSeq > 0) {
                    /**
                     * The transaction is WO deposit or WO refund 
                     * when TRL_SALE_LINEITM.SALE_LINEITM_TYPCODE =WORK_ORDER
                     */
                    if (CawCommonConstant.LINEITM_TYPCODE_WORK_ORDER.equalsIgnoreCase(saleLineitmTypcode)) {
                        isWorkOrder = true;
                    /**
                     * The transaction is WO complete when 
                     * TRL_SALE_LINEITM.RETURN_FLAG = 0
                     * and TRL_SALE_LINEITM.SALE_LINEITM_TYPCODE =SALE
                     * and TRL_RTRANS_LINEITM_P.PROPERTY_CODE start with "WA" + Store ID
                     */
                    } else if (CawCommonConstant.LINEITM_TYPCODE_SALE.equalsIgnoreCase(saleLineitmTypcode)) {
                        if (returnFlag == 0 && StringUtils.isNotEmpty(propertyCode)) {
                            if (propertyCode.startsWith(woPattern)) {
                                isWorkOrder = true;
                            }
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            logger.error("The exception happened in method isWorkOrderTransaction(): " + e.getMessage());
        } finally {
            if (rsTransWOLineItem != null) {
                try {
                    rsTransWOLineItem.close();
                } catch (SQLException e) {
                    logger.error("isWorkOrderTransaction() close the ResultSet: " + e.getMessage());
                }
            }
            if (psTransWOLineItem != null) {
                try {
                    psTransWOLineItem.close();
                } catch (SQLException e) {
                    logger.error("isWorkOrderTransaction() close the PreparedStatement: " + e.getMessage());
                }
            }
        }
      
        return isWorkOrder;
    }
    /* END BZ30261*/

    /* BEGIN BZ35016 */
    public static CawWorkOrderDetail retrieveWorkOrderTransaction(Connection conn, CawTransactionModel model) {

        CawWorkOrderDetail workOrderDetail = null;
        String sqlTransWOLineItem = null;
        PreparedStatement psTransWOLineItem = null;
        ResultSet rsTransWOLineItem = null;
        try {
            sqlTransWOLineItem = CawSQLConstant.QUERY_WORK_ORDER_TRANS;
            psTransWOLineItem = conn.prepareStatement(sqlTransWOLineItem, ResultSet.TYPE_SCROLL_INSENSITIVE);
            psTransWOLineItem.setString(1, model.getTransSeq());
            psTransWOLineItem.setString(2, model.getStoreID());
            psTransWOLineItem.setString(3, model.getRegID());
            psTransWOLineItem.setTimestamp(4, model.getBsnDate());
            rsTransWOLineItem = psTransWOLineItem.executeQuery();
            logger.debug("isWorkOrderTransaction()-Executed query to check transaction Work Order type \n"
                    + sqlTransWOLineItem + " "
                    + Arrays.asList(model.getTransSeq(), model.getStoreID(), model.getRegID(), model.getBsnDate()));
            if (rsTransWOLineItem.next()) {
                workOrderDetail = new CawWorkOrderDetail();
                String workOrderId = rsTransWOLineItem.getString(CawDBFieldConstant.PROPERTY_CODE_FIELD);
                String workOrderType = rsTransWOLineItem.getString(CawDBFieldConstant.STRING_VALUE_FIELD);
                workOrderDetail.setId(workOrderId);
                workOrderDetail.setPosStatus(workOrderType);
            }
        } catch (Exception e) {
            logger.error("The exception happened in method isWorkOrderTransaction(): " + e.getMessage());
        } finally {
            if (rsTransWOLineItem != null) {
                try {
                    rsTransWOLineItem.close();
                } catch (SQLException e) {
                    logger.error("isWorkOrderTransaction() close the ResultSet: " + e.getMessage());
                }
            }
            if (psTransWOLineItem != null) {
                try {
                    psTransWOLineItem.close();
                } catch (SQLException e) {
                    logger.error("isWorkOrderTransaction() close the PreparedStatement: " + e.getMessage());
                }
            }
        }
        return workOrderDetail;
    }
    /* END BZ35016 */
}
