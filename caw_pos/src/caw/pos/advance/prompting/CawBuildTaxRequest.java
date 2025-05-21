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
 * BZ37396          021020    Tax value calculation issue in Order transactions
 * BZ38471          141020    [Internal] Xstore does not call TAX API to calculate again during creating Order Delivery in case mixed order items firstly then Sale items when hit Exit Order button.
 * BZ45871          240821    [Internal] Exception after call Tax API during Electric World order creation with a Wholesale customer
 * BZ46146          080921    POS is not updating Tax correctly for cart items
 * BZ51922          260822    [UAT] Padding issue with the correlation key
 *===================================================================
 */

package caw.pos.advance.prompting;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;

import dtv.pos.iframework.security.StationState;
import dtv.pos.register.tax.TaxStrategyFactory;
import dtv.pos.register.type.LineItemType;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.itm.INonPhysicalItem;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.*;

/**
 *
 */
public class CawBuildTaxRequest {

    private static final String       CAW_ID                             = "!{id}";

    private static final String       CAW_TERMINAL                       = "!{terminal}";

    private static final String       CAW_CHANNELTYPE                    = "!{channelType}";

    private static final String       ORDER_TYPE                         = "!{orderType}";

    private static final String       ORDER_TYPE_DESCRIPTION             = "!{orderTypeDescription}";

    private static final String       CHANNEL_TYPE_DESCRIPTION           = "!{channelTypeDescription}";

    private static final String       PHYSICAL_INFO                      = "!{physicalInfo}";

    private static final String       ORDER_DATE                         = "!{orderDate}";

    public static final String        CUSTOMER                           = "!{customer}";

    public static final String        NAME                               = "!{name}";

    public static final String        NAME_AUDIT                         = "!{audit}";

    public static final String        NAME_PREFIX                        = "!{prefix}";

    public static final String        NAME_FIRST                         = "!{first}";

    public static final String        NAME_MIDDLE                        = "!{middle}";

    public static final String        NAME_LAST                          = "!{last}";

    public static final String        NAME_SUFFIX                        = "!{suffix}";

    public static final String        NAME_COMPANY                       = "!{company}";

    public static final String        ADDRESS                            = "!{address}";

    public static final String        ADDRESS_AUDIT                      = "!{audit}";

    public static final String        ADDRESS_ADDRESS_TYPE               = "!{addressType}";

    public static final String        ADDRESS_TYPE_DESCRIPTION           = "!{addressTypeDescription}";

    public static final String        ADDRESS_IS_DELIVERABLE             = "!{isDeliverable}";

    public static final String        ADDRESS_LINE1                      = "!{line1}";

    public static final String        ADDRESS_LINE2                      = "!{line2}";

    public static final String        ADDRESS_LINE3                      = "!{line3}";

    public static final String        ADDRESS_LINE4                      = "!{line4}";

    public static final String        ADDRESS_CITY                       = "!{city}";

    public static final String        ADDRESS_STATE_PROVINCE             = "!{stateProvince}";

    public static final String        ADDRESS_POSTAL_CODE                = "!{postalCode}";

    public static final String        ADDRESS_COUNTRY                    = "!{country}";

    public static final String        ADDRESS_COUNTY                     = "!{county}";

    public static final String        MEMBERSHIPS                        = "!{memberships}";

    public static final String        PHONES                             = "!{phones}";

    public static final String        PARTNERS                           = "!{partners}";

    public static final String        PRICING                            = "!{pricing}";

    public static final String        ACCOUNT_NUMBER                     = "!{accountNumber}";

    public static final String        ENTER_PRISE_IDS                    = "!{enterpriseIds}";

    public static final String        ORIGIN_COMPANY                     = "!{originCompany}";

    public static final String        ORIGIN_DATE                        = "!{originDate}";

    public static final String        CASHIER                            = "!{cashier}";

    public static final String        ORDER_TOTAL_WITH_TAX               = "!{orderTotalWithTax}";

    public static final String        THIRD_PARTY_PAYER                  = "!{thirdPartyPayer}";

    public static final String        ACCOUNT_STATUS                     = "!{accountStatus}";

    public static final String        ACCOUNT_STATUS_DESCRIPTION         = "!{accountStatusDescription}";

    public static final String        CUSTOMER_TYPE                      = "!{customerType}";

    public static final String        ACXIOMIDENTIFIERS                  = "!{acxiomIdentifiers}";

    public static final String        ALLOWEDIT                          = "!{allowEdit}";

    public static final String        EMAIL_ADDRESS                      = "!{emailAddress}";

    public static final String        RV_TYPE                            = "!{rvType}";

    public static final String        RV_TYPE_DESCRIPTION                = "!{rvTypeDescription}";

    public static final String        IS_TAXEXEMPT                       = "!{isTaxExempt}";

    public static final String        TAX_CERTIFICATE                    = "!{taxCertificate}";

    public static final String        AR_INFO                            = "!{arInfo}";

    public static final String        LAST_UPDATE_USER                   = "!{lastUpdateUser}";

    public static final String        LAST_UPDATE_SYSTEM                 = "!{lastUpdateSystem}";

    public static final String        LAST_UPDATE_DATE                   = "!{lastUpdateDate}";

    public static final String        FEED                               = "!{feed}";

    public static final String        ATTRIBUTES                         = "!{attributes}";

    public static final String        CRUD                               = "!{crud}";

    public static final String        CRUD_DESCRIPTION                   = "!{crudDescription}";

    public static final String        ALERTS                             = "!{alerts}";

    public static final String        SHIP_TO_INFO                       = "!{shipToInfo}";

    public static final String        SHIP_TO_INFO_NAME                  = "!{name}";

    public static final String        SHIP_TO_INFO_COMPANY               = "!{company}";

    public static final String        SHIP_TO_INFO_LINE_1                = "!{line1}";

    public static final String        SHIP_TO_INFO_LINE_2                = "!{line2}";

    public static final String        SHIP_TO_INFO_LINE_3                = "!{line3}";

    public static final String        SHIP_TO_INFO_CITY                  = "!{city}";

    public static final String        SHIP_TO_INFO_STATE                 = "!{stateProvince}";

    public static final String        SHIP_TO_INFO_POSTALCODE            = "!{postalCode}";

    public static final String        SHIP_TO_INFO_SHIP_VIA              = "!{shipVia}";

    public static final String        SHIP_TO_INFO_SERVICE_LEVEL         = "!{serviceLevel}";

    public static final String        SHIP_TO_INFO_COUNTRY               = "!{country}";

    public static final String        ITEMS_UNIT_OF_MEASURE              = "!{unitOfMeasure}";

    public static final String        ITEMS_UNIT_LIST_PRICE              = "!{unitListPrice}";

    public static final String        ITEMS_UNIT_SELLING_PRICE           = "!{unitSellingPrice}";

    public static final String        ITEMS_LINE_TOTAL                   = "!{lineTotal}";

    public static final String        ITEMS_IS_RETURN                    = "!{isReturn}";

    public static final String        ITEMS_TAX_CODE                     = "!{taxCode}";

    public static final String        ITEMS_TAX_AMOUNT                   = "!{taxAmount}";

    public static final String        ITEMS_SHIP_TO_INFO                 = "!{shipToInfo}";

    public static final String        ADJUSTMENTS                        = "!{adjustments}";

    public static final String        ADJUSTMENTS_TYPE                   = "!{type}";

    public static final String        ADJUSTMENTS_AMOUNT                 = "!{amount}";

    public static final String        ADJUSTMENTS_COUPON_CODE            = "!{couponCode}";

    public static final String        ADJUSTMENTS_SERIALIZED_COUPON_CODE = "!{serializedCouponCode}";

    public static final String        ADJUSTMENTS_CORRECLATION_KEY       = "!{correlationKey}";

    public static final String        ADJUSTMENTS_PROPERTIES             = "!{properties}";

    public static final String        ADJUSTMENTS_ATTRIBUTES             = "!{attributes}";

    public static final String        ITEMS_PROPERTIES                   = "!{properties}";

    public static final String        ITEMS_ATTRIBUTES                   = "!{attributes}";

    public static final String        TENDERS                            = "!{tenders}";

    public static final String        RECEIPT_TYPE                       = "!{receiptType}";

    public static final String        RECEIPT_TYPE_DESCRIPTOPN           = "!{receiptTypeDescription}";

    public static final String        E_RECEIPT_EMAIL                    = "!{eReceiptEmail}";

    public static final String        CONTACT_PHONE                      = "!{contactPhone}";

    public static final String        PAID_IN_OUT_DETAIL                 = "!{paidInOutDetail}";

    public static final String        CORRECLATION_KEY                   = "!{correlationKey}";

    public static final String        PROPERTIES                         = "!{properties}";

    public static final String        PROPERTIES_COMMENTS_GENERAL        = "!{commentsGeneral}";

    public static final String        ATTRIBUTTES_ORDER_HOLD_NAME        = "!{orderHoldName}";

    private static final String       DATE_TIME_FORMAT                   = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static final String        CODE                               = "!{code}";

    public static final String        ITEMS                              = "!{items}";

    public static final String        FILE_NUMBER                        = "!{fileNumber}";

    public static final String        ITEMS_QUANTITY                     = "!{quantity}";

    public static final String        ITEMS_SALES_PERSON                 = "!{salesPerson}";

    public static final String        SALES_CHANNEL                      = "!{salesChannel}";

    private static final String       SQUARE_BRACKETS_OPEN               = "[";

    private static final String       SQUARE_BRACKETS_CLOSE              = "]";

    private static final String       CORRELATION_KEY                    = "!{correlationKey}";

    private static final String       IDENTIFIER                         = "!{identifier}";

    private static final String       IS_ACTIVE                          = "!{isActive}";

    private static final String       IS_PRIMARY                         = "!{isPrimary}";

    private static final String       TYPE                               = "!{type}";

    private static final String       DESCRIPTION                        = "!{description}";

    private static final String       NUMBER                             = "!{number}";

    private static final String       NUMBER_DEFAULT                     = "0";

    private static final String       DATE_FORMAT                        = "yyyyMMdd";

    private static final String       YYYY_M_MDD                         = DATE_FORMAT;

    private static final Logger       _logger                            = LogManager
            .getLogger(CawBuildTaxRequest.class);

    private static CawBuildTaxRequest INSTANCE                           = null;

    public static CawBuildTaxRequest getInstance() {

        if (INSTANCE == null) {
            synchronized (CawBuildTaxRequest.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawBuildTaxRequest();
                }
            }
        }
        return INSTANCE;
    }

    public String buildSalesChannel(IPosTransaction posTrans) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.TAX_OBJECT_SALES_CHANNEL_ATTR);
        String body = request.getBody();
        long storeId = 0;
        long terminalId = 0;

        if (posTrans != null) {
            storeId = posTrans.getRetailLocationId();
            terminalId = posTrans.getWorkstationId();
        }

        body = body.replace(CAW_ID, String.format("%s", storeId));
        body = body.replace(CAW_TERMINAL, String.format("%s", terminalId));
        body = body.replace(CAW_CHANNELTYPE, String.format("%s", Integer.valueOf(4)));
        body = body.replace(CHANNEL_TYPE_DESCRIPTION, CawUtilFunction.formatParameter("Xstore"));
        body = body.replace(PHYSICAL_INFO, "null");

        return body;
    }

    public String buildCustomerName(IParty argIParty) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.TAX_OBJECT_CUSTOMER_NAME_ATTR);
        String body = request.getBody();

        body = body.replace(NAME_AUDIT, "null");
        body = body.replace(NAME_PREFIX, argIParty.getSalutation() != null
                ? argIParty.getSalutation(): CawUtilFunction.formatParameter(""));
        body = body.replace(NAME_FIRST, CawUtilFunction
                .formatParameter(argIParty.getFirstName()));
        body = body.replace(NAME_MIDDLE, argIParty.getMiddleName() != null
                ? argIParty.getMiddleName() : "null");
        body = body.replace(NAME_LAST, CawUtilFunction
                .formatParameter(argIParty.getLastName()));
        body = body.replace(NAME_SUFFIX, argIParty.getSuffix() != null
                ? argIParty.getSuffix() : CawUtilFunction.formatParameter(argIParty.getFirstName()));
        // String company = argIParty.getOrganizationName() != null ? CawUtilFunction.formatParameter(argIParty.getOrganizationName()) : "null";
        body = body.replace(NAME_COMPANY, "null");
        
        return body;

    }

    public String buildCustomerAddress(IParty argIParty) {

        List<IPartyLocaleInformation> listAddresses = argIParty.getLocaleInformation();
        IPartyLocaleInformation localeInfo = listAddresses.get(0);

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.TAX_OBJECT_CUSTOMER_ADDRESS_ATTR);

        String body = request.getBody();

        body = body.replace(ADDRESS_AUDIT, "null");
        body = body.replace(ADDRESS_ADDRESS_TYPE, String.format("%s", CawEBSConstant.ADDRESS_TYPE));
        body = body.replace(ADDRESS_TYPE_DESCRIPTION, localeInfo
                .getAddressType() != null ? CawUtilFunction.formatParameter(localeInfo.getAddressType()) : "null");
        Boolean conntact = localeInfo.getContact();
        body = body.replace(ADDRESS_IS_DELIVERABLE, conntact.toString());
        body = body.replace(ADDRESS_LINE1, CawUtilFunction
                .formatParameter(localeInfo.getAddress1() != null ? localeInfo.getAddress1() : "null"));
        body = body.replace(ADDRESS_LINE2, CawUtilFunction.formatParameter(localeInfo.getAddress2() != null
                        ? localeInfo.getAddress2() : ""));
        body = body.replace(ADDRESS_LINE3, localeInfo.getAddress3() != null
                ? localeInfo.getAddress3(): "null");
        body = body.replace(ADDRESS_LINE4, localeInfo.getAddress4() != null
                ? localeInfo.getAddress4() : "null");
        body = body.replace(ADDRESS_CITY, CawUtilFunction
                .formatParameter(localeInfo.getCity()));
        body = body.replace(ADDRESS_STATE_PROVINCE, CawUtilFunction
                .formatParameter(localeInfo.getState()));
        body = body.replace(ADDRESS_POSTAL_CODE, CawUtilFunction
                .formatParameter(localeInfo.getPostalCode()));
        body = body.replace(ADDRESS_COUNTRY, CawUtilFunction
                .formatParameter(localeInfo.getCountry()));
        body = body.replace(ADDRESS_COUNTY, localeInfo.getCounty() != null
                ? localeInfo.getCounty() : "null");

        return body;

    }

    public String buildCustomerPhones(IParty argIParty) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.REQUEST_PHONES_ATTR);

        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        body = body.replace(IDENTIFIER, NUMBER_DEFAULT);
        body = body.replace(TYPE, fmtNull);
        body = body.replace(DESCRIPTION, fmtNull);
        body = body.replace(NUMBER, fmtNull);
        body = body.replace(IS_ACTIVE, Boolean.TRUE.toString());
        body = body.replace(IS_PRIMARY, Boolean.TRUE.toString());

        return body;

    }

    public String buildCustomer(IParty argIParty) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.TAX_OBJECT_CUSTOMER_ATTR);

        String body = request.getBody();

        String name = this.buildCustomerName(argIParty);
        body = body.replace(NAME, name);
        String address = this.buildCustomerAddress(argIParty);
        body = body.replace(ADDRESS, address);
        body = body.replace(MEMBERSHIPS, "null");
        //body = body.replace(PHONES , buildCustomerPhones(argIParty));
        body = body.replace(PHONES, "null");
        body = body.replace(PARTNERS, "null");
        body = body.replace(PRICING, "null");
        body = body.replace(ACCOUNT_NUMBER, argIParty.getAlternatePartyIds().get(0).getAlternateId());
        body = body.replace(ENTER_PRISE_IDS, "null");
        body = body.replace(ACXIOMIDENTIFIERS, "null");
        body = body.replace(ACCOUNT_STATUS, "0");
        body = body.replace(ACCOUNT_STATUS_DESCRIPTION, CawUtilFunction
                .formatParameter(CawEBSConstant.CUSTOMER_TEMPLATE_ACCOUNT_STATUS_DESCRIPTION));
        body = body.replace(CUSTOMER_TYPE, "1");
        body = body.replace(ALLOWEDIT, Boolean.FALSE.toString());
        body = body.replace(EMAIL_ADDRESS, CawUtilFunction.formatParameter(argIParty.getEmailAddress()));
        body = body.replace(RV_TYPE, "0");
        body = body.replace(RV_TYPE_DESCRIPTION, CawUtilFunction.formatParameter(CawEBSConstant.CUSTOMER_TEMPLATE_RVTYPE_DESCRIPTION));
        body = body.replace(IS_TAXEXEMPT, "false");
        body = body.replace(TAX_CERTIFICATE, "null");
        body = body.replace(AR_INFO, "null");
        body = body.replace(LAST_UPDATE_USER, "null");
        body = body.replace(LAST_UPDATE_SYSTEM, "null");
        SimpleDateFormat sd = new SimpleDateFormat(DATE_TIME_FORMAT);
        body = body.replace(LAST_UPDATE_DATE, CawUtilFunction.formatParameter(sd.format(new Date())));
        body = body.replace(ORIGIN_COMPANY, "null");
        body = body.replace(ORIGIN_DATE, CawUtilFunction.formatParameter(sd.format(new Date())));
        body = body.replace(FEED, "null");
        body = body.replace(CRUD, "0");
        body = body.replace(CRUD_DESCRIPTION, CawUtilFunction.formatParameter("NotSpecified"));
        body = body.replace(ALERTS, "null");
        body = body.replace(ATTRIBUTES, "null");

        return body;

    }

    public String buildShipToInfo(IOrderLine orderLine) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.TAX_OBJECT_SHIP_TO_INFO_ATTR);

        String body = request.getBody();
        IFulfillmentModifier fulfillment = orderLine.getFulfillmentModifier();

        if (fulfillment != null) {

            IAddressModifier address = fulfillment.getAddress();

            body = body.replace(NAME, CawUtilFunction
                    .formatParameter(fulfillment.getLocationName1() + " "+ fulfillment.getLocationName2()));
            body = body.replace(SHIP_TO_INFO_COMPANY, "null");
            if (address != null) {
    
                body = body.replace(SHIP_TO_INFO_LINE_1, CawUtilFunction.formatParameter(address.getAddress1()));
                body = body.replace(SHIP_TO_INFO_LINE_2, CawUtilFunction.formatParameter(address.getAddress2()));
                body = body.replace(SHIP_TO_INFO_LINE_3, CawUtilFunction.formatParameter(address.getAddress3()));
                body = body.replace(SHIP_TO_INFO_CITY, CawUtilFunction.formatParameter(address.getCity()));  
                body = body.replace(SHIP_TO_INFO_STATE, CawUtilFunction.formatParameter(address.getState()));
                body = body.replace(SHIP_TO_INFO_POSTALCODE, CawUtilFunction.formatParameter(address.getPostalCode()));
                String shipMethod = orderLine.getSelectedShipMethod() != null ? orderLine.getSelectedShipMethod() : "1";
                body = body.replace(SHIP_TO_INFO_SHIP_VIA, CawUtilFunction.formatParameter(shipMethod));
                body = body.replace(SHIP_TO_INFO_SERVICE_LEVEL, shipMethod);
                body = body.replace(SHIP_TO_INFO_COUNTRY, CawUtilFunction.formatParameter(address.getCountry()));
            }
        }
        return body;
    }

    String buildSalesPersion(IPosTransaction iPosTransaction,ISaleReturnLineItem salesLineItem) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.TAX_SALESPERSON_ATTR);
        String body = request.getBody();
        IParty party = null;

        if (salesLineItem.getCommissionModifiers() != null
                && salesLineItem.getCommissionModifiers().size() > 0) {

            ICommissionModifier commission = salesLineItem.getCommissionModifiers().get(0);
            party = commission.getEmployeeParty();
            
        } else if (salesLineItem.getCommissionModifiers() != null
                && salesLineItem.getCommissionModifiers().size() <= 0) {
            
            party = iPosTransaction.getOperatorParty();
            
        } else {
            return "null";
        }

        body = body.replace(CODE, CawUtilFunction.formatParameter(party.getEmployeeId()));
        body = body.replace(NAME, CawUtilFunction.formatParameter(party.getFirstName() + " " + party.getLastName()));
        body = body.replace(FILE_NUMBER, CawUtilFunction.formatParameter(party.getEmployeeId()));

        return body;

    }

    String buildItemAdjustments(BigDecimal unitListPrice, BigDecimal unitSellingPrice, String correlationKey) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.TAX_OBJECT_ADJUSTMENTS_ATTR);

        String body = request.getBody();

        body = body.replace(ADJUSTMENTS_TYPE, "1");
        BigDecimal amount = unitListPrice.subtract(unitSellingPrice);
        body = body.replace(ADJUSTMENTS_AMOUNT, amount.toString());
        body = body.replace(ADJUSTMENTS_COUPON_CODE, CawUtilFunction.formatParameter("0000"));
        body = body.replace(ADJUSTMENTS_SERIALIZED_COUPON_CODE, "null");
        body = body.replace(ADJUSTMENTS_CORRECLATION_KEY, CawUtilFunction.formatParameter(correlationKey));
        body = body.replace(ADJUSTMENTS_PROPERTIES, "null");
        body = body.replace(ADJUSTMENTS_ATTRIBUTES, "null");

        String result = SQUARE_BRACKETS_OPEN + body + SQUARE_BRACKETS_CLOSE;

        return result;

    }

    String buildItemArray(IOrder order, IPosTransaction iPosTransaction, StationState stationState, TaxStrategyFactory taxStrategyFactory) {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.TAX_OBJECT_ITEMS_ATTR);
        String fmtNull = CawJSONConstant.NULL;
        String body = request.getBody();
        StringBuilder resultBuilder = new StringBuilder();
        String result = "";
        String temp = "null";
        String correlationKey = "null";
        int lineNumber = 0;
        List<ISaleTaxModifier> taxMod = null;
        BigDecimal taxAmount = ZERO;
        
        /* BEGIN BZ46146 */
        try {
            if (iPosTransaction != null) {
                List<ISaleReturnLineItem> transLineItems = iPosTransaction.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
    
                if (transLineItems != null) {
                    for (ISaleReturnLineItem transLineItem1 : transLineItems) {
                        if (transLineItem1.getItem() instanceof INonPhysicalItem && (!transLineItem1.getVoid())
                                && null != transLineItem1.getOrderModifier()) { //BZ46146
                            taxAmount = ZERO;
                            lineNumber++;
                            temp = String.valueOf(body);
                            correlationKey = getCorrelationKey(iPosTransaction, stationState);
                            if (!correlationKey.equals(fmtNull)) {
                                correlationKey = correlationKey + ":"
                                        + String.valueOf(lineNumber);//BZ51922
                            }

                            temp = temp.replace(CODE, CawUtilFunction .formatParameter(transLineItem1.getItemId()));
                            temp = temp.replace(ITEMS_SALES_PERSON, buildSalesPersion(iPosTransaction, transLineItem1));

                            if (transLineItem1.getQuantity() != null) {
                                temp = temp.replace(ITEMS_QUANTITY, transLineItem1.getQuantity().setScale(0).toString());
                            } else {
                                temp = temp.replace(ITEMS_QUANTITY, fmtNull);
                            }                  
                            temp = temp.replace(ITEMS_UNIT_OF_MEASURE, "0");
                            temp = temp.replace(ITEMS_UNIT_LIST_PRICE, transLineItem1.getRegularBasePrice().toString());
                            temp = temp.replace(ITEMS_UNIT_SELLING_PRICE, transLineItem1.getUnitPrice().toString());
                            temp = temp.replace(ITEMS_TAX_CODE, CawUtilFunction.formatParameter(transLineItem1.getItem().getOptions().getTaxGroupId()));

                            taxMod = transLineItem1.getTaxModifiers();
                            
                            if (CollectionUtils.isNotEmpty(taxMod)) {
                                for (ISaleTaxModifier tax : taxMod) {
                                    taxAmount = taxAmount.add(tax.getTaxAmount());
                                }
                            }
                            
                            temp = temp.replace(ITEMS_TAX_AMOUNT, taxAmount.toString());
                            BigDecimal lineTotal = transLineItem1.getUnitPrice().add(taxAmount);
                            temp = temp.replace(ITEMS_LINE_TOTAL, lineTotal.toString());
                            temp = temp.replace(ITEMS_IS_RETURN, Boolean.toString(transLineItem1.getReturn()));
                            temp = temp.replace(ITEMS_SHIP_TO_INFO, "null");
                            temp = temp.replace(ADJUSTMENTS, buildItemAdjustments(transLineItem1.getRegularBasePrice(), transLineItem1
                                                    .getUnitPrice(), correlationKey));
                            temp = temp.replace(CORRELATION_KEY, CawUtilFunction.formatParameter(correlationKey + ":" + lineNumber));
                            temp = temp.replace(ITEMS_PROPERTIES, "null");
                            temp = temp.replace(ITEMS_ATTRIBUTES, "null");
                            resultBuilder.append(temp);
                            resultBuilder.append(",");
                        }
                    }
                }
                
                if (order != null && order.getOrderLines() != null) {
                    for (IOrderLine orderline : order.getOrderLines()) {     
                        if (!orderline.getVoid()) {
                            ISaleReturnLineItem transLineItem = orderline.getShadowedSaleItem();
                            taxAmount = ZERO;
                            lineNumber++;
                            temp = String.valueOf(body);
                            correlationKey = getCorrelationKey(iPosTransaction, stationState);
                            if (!correlationKey.equals(fmtNull)) {
                                correlationKey = correlationKey + ":"
                                        + String.valueOf(lineNumber);//BZ51922
                            }

                            temp = temp.replace(CODE, CawUtilFunction .formatParameter(transLineItem.getItemId()));
                            temp = temp.replace(ITEMS_SALES_PERSON, buildSalesPersion(iPosTransaction, transLineItem));

                            if (transLineItem.getQuantity() != null) {
                                temp = temp.replace(ITEMS_QUANTITY, transLineItem.getQuantity().setScale(0).toString());
                            } else {
                                temp = temp.replace(ITEMS_QUANTITY, fmtNull);
                            }                  
                            temp = temp.replace(ITEMS_UNIT_OF_MEASURE, "0");
                            temp = temp.replace(ITEMS_UNIT_LIST_PRICE, transLineItem.getRegularBasePrice().toString());
                            temp = temp.replace(ITEMS_UNIT_SELLING_PRICE, transLineItem.getUnitPrice().toString());
                            temp = temp.replace(ITEMS_TAX_CODE, CawUtilFunction.formatParameter(transLineItem.getItem().getOptions().getTaxGroupId()));

                            taxMod = transLineItem.getTaxModifiers();
                            
                            if (CollectionUtils.isNotEmpty(taxMod)) {
                                for (ISaleTaxModifier tax : taxMod) {
                                    taxAmount = taxAmount.add(tax.getTaxAmount());
                                }
                            }
                            
                            temp = temp.replace(ITEMS_TAX_AMOUNT, taxAmount.toString());
                            BigDecimal lineTotal = orderline.getExtendedPrice().add(taxAmount);
                            temp = temp.replace(ITEMS_LINE_TOTAL, lineTotal.toString());
                            temp = temp.replace(ITEMS_IS_RETURN, Boolean.toString(transLineItem.getReturn()));
                            temp = temp.replace(ITEMS_SHIP_TO_INFO, "null");
                            temp = temp.replace(ADJUSTMENTS, buildItemAdjustments(transLineItem.getRegularBasePrice(), transLineItem
                                                    .getUnitPrice(), correlationKey));
                            temp = temp.replace(CORRELATION_KEY, CawUtilFunction.formatParameter(correlationKey + ":" + lineNumber));
                            temp = temp.replace(ITEMS_PROPERTIES, "null");
                            temp = temp.replace(ITEMS_ATTRIBUTES, "null");
                            resultBuilder.append(temp);
                            resultBuilder.append(",");
                        }
                        if (resultBuilder.length() > 0) {
                            result = SQUARE_BRACKETS_OPEN
                                    + (resultBuilder.toString()).substring(0, (resultBuilder.toString()).length() - 1)
                                    + SQUARE_BRACKETS_CLOSE;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Exception while build item array while builing tax request: " + ex.getMessage());
        }
        /* END BZ46146 */

        return result;

    }

    public String buildTaxProperties() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.TAX_PROPERTIES_ATTR);

        String body = request.getBody();
        body = body.replace(PROPERTIES_COMMENTS_GENERAL, CawUtilFunction.formatParameter(""));

        return body;

    }

    public String buildTaxAttributes() {

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.TAX_ATTRIBUTES_ATTR);

        String body = request.getBody();
        body = body.replace(ATTRIBUTTES_ORDER_HOLD_NAME, CawUtilFunction.formatParameter(""));

        return body;

    }

    public String buildCashier(IPosTransaction posTrans) {

        List<ISaleReturnLineItem> transLineItems = posTrans.getLineItemsByTypeCode(LineItemType.ITEM
                .getName(), ISaleReturnLineItem.class);

        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.OBJECT_CASHIER_ATTR);
        String body = request.getBody();
        IParty party = null;
        
        if (transLineItems.size() > 0 && transLineItems.get(0).getCommissionModifiers() != null
                && transLineItems.get(0).getCommissionModifiers().size() > 0) {
            
            ICommissionModifier commission = transLineItems.get(0).getCommissionModifiers().get(0);
            party = commission.getEmployeeParty();
            
        } else if (transLineItems.size() > 0 && transLineItems.get(0).getCommissionModifiers().size() <= 0) {
            party = posTrans.getOperatorParty();

        }
        if (party != null) {
            body = body.replace(CODE, CawUtilFunction.formatParameter(party.getEmployeeId()));
            body = body.replace(NAME, CawUtilFunction.formatParameter(party.getFirstName() + " " + party.getLastName()));
            body = body.replace(FILE_NUMBER, CawUtilFunction.formatParameter(party.getEmployeeId()));
        } else {
            return "null";
        }
        

        return body;

    }

    public String buildTaxRequestTemplate(IOrder order,IPosTransaction posTrans, IParty argParty,
            StationState stationState, TaxStrategyFactory taxStrategyFactory, String lookupResponse) {
        
        CawRestConfig request = CawRestConfigHelper.getInstance().getRestRequest(CawEBSConstant.TAX_REQUEST_TEMPLATE);
        String body = "null";
        
        try {
            body = request.getBody();
            body = body.replace(SALES_CHANNEL, buildSalesChannel(posTrans));
            body = body.replace(ORDER_TYPE, "0");
            body = body.replace(ORDER_TYPE_DESCRIPTION, CawUtilFunction.formatParameter("SalesTransaction"));

            body = body.replace(CAW_ID, "" + stationState.getRetailLocationId() + stationState.getWorkstationId()
                    + posTrans.getTransactionSequence());
            body = body.replace(CASHIER, buildCashier(posTrans));
            Date orderDate = order.getCreateDate();
            SimpleDateFormat sd = new SimpleDateFormat(DATE_TIME_FORMAT);
            body = body.replace(ORDER_DATE, CawUtilFunction.formatParameter(sd.format(orderDate)));
            BigDecimal orderTotalWithTax = buildOrderTotalWithtax(order, posTrans);
            body = body.replace(ORDER_TOTAL_WITH_TAX, orderTotalWithTax.toString());
            
            /* BEGIN BZ45871 */
            String customer = CawAdvancePromptingHelper.getInstance().getCustomerJsonForCatalystFour(argParty, lookupResponse); 
            body = body.replace(CUSTOMER, customer);
            /* END BZ45871 */
            
            body = body.replace(THIRD_PARTY_PAYER, "null");
            
            /* BEGIN BZ46146 */
            if (CollectionUtils.isNotEmpty(order.getOrderLines())) {
                body = body.replace(SHIP_TO_INFO, buildShipToInfo(order.getOrderLines().get(0)));
            } else {
                body = body.replace(SHIP_TO_INFO, CawUtilFunction.formatParameter(null));
            }
            /* END BZ46146 */
            
            
            body = body.replace(ITEMS, buildItemArray(order,posTrans, stationState, taxStrategyFactory));
            body = body.replace(TENDERS, "[]");
            body = body.replace(RECEIPT_TYPE, "0");
            body = body.replace(RECEIPT_TYPE_DESCRIPTOPN, CawUtilFunction.formatParameter("NotSpecified"));
            body = body.replace(E_RECEIPT_EMAIL, "null");
            body = body.replace(CONTACT_PHONE, CawUtilFunction.formatParameter("330-507-1885"));
            body = body.replace(PAID_IN_OUT_DETAIL, "null");
            body = body.replace(CORRECLATION_KEY, CawUtilFunction.formatParameter(getCorrelationKey(posTrans, stationState)));
            body = body.replace(PROPERTIES, buildTaxProperties());
            body = body.replace(ATTRIBUTES, buildTaxAttributes());
            
        } catch (Exception ex) {
            _logger.info("Exception when create TAX request: " + ex.getMessage());
        }
        
        return body;
    }
    
    public BigDecimal buildOrderTotalWithtax(IOrder order,IPosTransaction iPosTransaction) {
        BigDecimal result = BigDecimal.ZERO;

        /* BEGIN BZ46146 */
        try {
            List<ISaleTaxModifier> taxMod = null;
            BigDecimal taxAmount = BigDecimal.ZERO;
            BigDecimal shippingTotal = BigDecimal.ZERO;
            BigDecimal orderlinetotal = BigDecimal.ZERO;
            if (iPosTransaction != null) {
                List<ISaleReturnLineItem> transLineItems = iPosTransaction.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
                
                if (transLineItems != null) {
                    for (ISaleReturnLineItem transLineItem1 : transLineItems) {
                        if (transLineItem1.getItem() instanceof INonPhysicalItem && (!transLineItem1.getVoid())) {       
                            taxAmount = BigDecimal.ZERO;
                            taxMod = transLineItem1.getTaxModifiers();
                            
                            if (CollectionUtils.isNotEmpty(taxMod)) {
                                for (ISaleTaxModifier tax : taxMod) {
                                    taxAmount = taxAmount.add(tax.getTaxAmount());
                                }
                            }
                            
                            shippingTotal = shippingTotal.add(transLineItem1.getUnitPrice().add(taxAmount));
                            
                        }
                    }
                }
                
                if (order != null && order.getOrderLines() != null) {
                    for (IOrderLine orderline : order.getOrderLines()) {
                        if (!orderline.getVoid()) {
                            ISaleReturnLineItem transLineItem = orderline.getShadowedSaleItem();
                            taxAmount = BigDecimal.ZERO;
                            taxMod = transLineItem.getTaxModifiers();
                            
                            if (CollectionUtils.isNotEmpty(taxMod)) {
                                for (ISaleTaxModifier tax : taxMod) {
                                    taxAmount = taxAmount.add(tax.getTaxAmount());
                                }
                            }
                            
                            orderlinetotal = orderlinetotal.add(orderline.getExtendedPrice().add(taxAmount));
                        } 
                    }
                }
            }
            
            result = shippingTotal.add(orderlinetotal);
        } catch (Exception ex) {
            _logger.error("Exception while building order total with tax: " + ex.getMessage());
        }
        /* END BZ46146 */
        
        return result;
    }

    public String getCorrelationKey(IPosTransaction iPosTransaction, StationState stationState) {

        String correlationKey = CawJSONConstant.NULL;
        try {
            if (iPosTransaction != null && stationState != null) {
                DateFormat df = new SimpleDateFormat(YYYY_M_MDD);
                Date bsnDate = iPosTransaction.getBusinessDate();
                String storeID = String.format("%4s", stationState.getRetailLocationId()).replace(' ', '0');
                String regID = String.format("%2s", stationState.getWorkstationId()).replace(' ', '0');
                String transSeq = String.format("%4s", iPosTransaction.getTransactionSequence()).replace(' ', '0');
                correlationKey = df.format(bsnDate) + ":" + storeID + ":" + regID + ":" + transSeq;
            }
        } catch (Exception ex) {
            _logger.error("Can not build CorrelationKey: " + ex.getMessage());
        }

        return correlationKey;
    }
}
