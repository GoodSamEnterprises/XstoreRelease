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
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ48806              010322    [PROD] Order Service (Internal Server Error)
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 * BZ53307              021122    [Internal] Membership tag in Pricing attitude is null when Customer Lookup on OS offline.
 *===================================================================
 */

package caw.orderservice.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.web.client.HttpClientErrorException;

import caw.orderservice.constant.CawCommonConstant;
import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.constant.CawWSTemplateConstant;
import caw.orderservice.model.CawCustomerModel;
import caw.orderservice.model.CawTransactionModel;
import caw.orderservice.utils.CawPropertiesConfig;
import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

/**
 * This functions is used to handle Customer for each order
 */
public class CawOrderServiceCustomerTemplate {

    private static Logger logger = Logger
            .getLogger(CawOrderServiceCustomerTemplate.class);

    /**
     * this method is used in case Customer can't lookup from ESB service.
     * in case, it should be get from customer template pseudo
     * @param conn
     * @param cust
     * @param party
     * @return
     * @throws SQLException
     */
    public static JSONObject buildCustomerTemp(Connection conn,
            CawCustomerModel cust, String party, long accountNumber,
            int custType, String custEmailAddress, String storeId
            ) throws SQLException {

        JSONArray jsonMemberships = null;
        JSONObject jsonPricingMembership = null; // BZ48806
        boolean checkdata = false;

        PreparedStatement psmemberships = null;
        ResultSet rsmemberships = null;
        
        PreparedStatement pspricingmembership = null; // BZ48806
        ResultSet rspricingmembership = null; // BZ48806

        PreparedStatement psGroupPricing = null;
        ResultSet rsGroupPricing = null;
        
        JSONObject template = CawOrderServiceUtils
                .getJsonContentByTemplate(CawWSTemplateConstant.CUSTOMER_TEMPLATE);
        if (template == null) {
            return template;
        }

        //Begin BZ24886: Build Template Customer
        logger.debug("buildCustomerTemp-1 - Template customer Original:"
                + template.toString());
        try {
            if (!template.isNull(CawWSTemplateConstant.NAME)) {
                template.getJSONObject(CawWSTemplateConstant.NAME)
                        .put(CawWSTemplateConstant.PREFIX, cust.getName()
                                .getPrefix() != null
                                        ? cust.getName().getPrefix()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.NAME)
                        .put(CawWSTemplateConstant.FIRST, cust.getName()
                                .getFirst() != null ? cust.getName().getFirst()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.NAME)
                        .put(CawWSTemplateConstant.MIDDLE, cust.getName()
                                .getMiddle() != null
                                        ? cust.getName().getMiddle()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.NAME)
                        .put(CawWSTemplateConstant.LAST, cust.getName()
                                .getLast() != null ? cust.getName().getLast()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.NAME)
                        .put(CawWSTemplateConstant.SUFFIX, cust.getName()
                                .getSuffix() != null
                                        ? cust.getName().getSuffix()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.NAME)
                        .put(CawWSTemplateConstant.COMPANY, cust.getName()
                                .getCompany() != null
                                        ? cust.getName().getCompany()
                                        : null);
            }
            //address
            if (!template.isNull(CawWSTemplateConstant.ADDRESS)) {
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.AUDIT, cust.getAddress()
                                .getAudit() != null
                                        ? cust.getAddress().getAudit()
                                        : null);
              //START BZ48630
              
              template.getJSONObject(CawWSTemplateConstant.ADDRESS).put(CawWSTemplateConstant.ADDRESS_TYPE, CawPropertiesConfig
                          .getInt(cust.getAddress().getAddressType() != null ? cust.getAddress().getAddressType() : null));

          
              //END BZ48630
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.LINE1, cust.getAddress()
                                .getLine1() != null
                                        ? cust.getAddress().getLine1()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.LINE2, cust.getAddress()
                                .getLine2() != null
                                        ? cust.getAddress().getLine2()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.LINE3, cust.getAddress()
                                .getLine3() != null
                                        ? cust.getAddress().getLine3()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.LINE4, cust.getAddress()
                                .getLine4() != null
                                        ? cust.getAddress().getLine4()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.CITY, cust.getAddress()
                                .getCity() != null ? cust.getAddress().getCity()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.STATE_PROVINCE, cust
                                .getAddress().getStateProvince() != null
                                        ? cust.getAddress().getStateProvince()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.POSTAL_CODE, cust
                                .getAddress().getPostalCode() != null
                                        ? cust.getAddress().getPostalCode()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.COUNTRY, cust.getAddress()
                                .getCountry() != null
                                        ? cust.getAddress().getCountry()
                                        : null);
                template.getJSONObject(CawWSTemplateConstant.ADDRESS)
                        .put(CawWSTemplateConstant.COUNTY, cust.getAddress()
                                .getCounty() != null
                                        ? cust.getAddress().getCounty()
                                        : null);
            }

            try {

                psmemberships = conn
                        .prepareStatement(CawSQLConstant.QUERY_MEMBERSHIPS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                psmemberships.setString(1, party);
                rsmemberships = psmemberships.executeQuery();
                logger.debug("buildCustomerTemp-2-Executed query for membership\n"
                        + CawSQLConstant.QUERY_MEMBERSHIPS + " "
                        + Arrays.asList(party));
                rsmemberships.last();
                logger.debug("Result set – size:" + rsmemberships.getRow());
                rsmemberships.beforeFirst();

                while (rsmemberships.next()) {
                    if (rsmemberships
                            .getString(CawDBFieldConstant.STRING_VALUE_FIELD) != null) {
                        jsonMemberships = new JSONArray(rsmemberships
                                .getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                        template.put(CawWSTemplateConstant.MEMBERSHIPS, jsonMemberships);
                    }
                }

                // BEGIN BZ48806
                try {
                    pspricingmembership = conn.prepareStatement(CawSQLConstant.QUERY_PRICING_MEMBERSHIP
                            , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
                    pspricingmembership.setString(1, party);
                    rspricingmembership = pspricingmembership.executeQuery();
                    logger.debug("buildCustomerTemp-3-Executed query for pricing membership\n"
                            + CawSQLConstant.QUERY_PRICING_MEMBERSHIP + " "
                            + Arrays.asList(party));
                    rspricingmembership.last();
                    logger.debug("Result set - size:" + rspricingmembership.getRow());
                    rspricingmembership.beforeFirst();
    
                    while (rspricingmembership.next()) {
                        if (rspricingmembership.getString(CawDBFieldConstant.STRING_VALUE_FIELD) != null) {
                           
                            jsonPricingMembership = new JSONObject(rspricingmembership.getString(CawDBFieldConstant.STRING_VALUE_FIELD));
                        } 
                    }
                } catch (Exception e) {
                    logger.debug("Cannot parse membership of price attribute to JSONObject:" + e.getMessage());
                }
                // END BZ48806
                
            } finally {
                if (rsmemberships != null) {
                    rsmemberships.close();
                }
                if (psmemberships != null) {
                    psmemberships.close();
                }

                // BEGIN BZ48806
                if (rspricingmembership != null) {
                    rspricingmembership.close();
                }
                if (pspricingmembership != null) {
                    pspricingmembership.close();
                }
                // END BZ48806
            }

            try {

                psGroupPricing = conn
                        .prepareStatement(CawSQLConstant.QUERY_GROUP_PRICING, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                psGroupPricing.setString(1, party);
                rsGroupPricing = psGroupPricing.executeQuery();
                logger.debug("buildCustomerTemp-4 - Executed query for Price\n"
                        + CawSQLConstant.QUERY_GROUP_PRICING + " "
                        + Arrays.asList(party));
                rsGroupPricing.last();
                logger.debug("Result set – size:" + rsGroupPricing.getRow());
                rsGroupPricing.beforeFirst();

                String custGroupId = null;
                while (rsGroupPricing.next()) {
                    checkdata = true;
                    custGroupId = rsGroupPricing
                            .getString(CawDBFieldConstant.CUST_GROUP_ID);
                    if (custGroupId != null) {
                        if (custGroupId
                                .compareTo(CawWSTemplateConstant.WHOLESALE_CODE) == 0) {
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.IDENTIFIER, CawWSTemplateConstant.VALUE_26);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.BAND, CawWSTemplateConstant.WHOLESALE_CODE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.DESCRIPTION, CawWSTemplateConstant.WHSL_PRICE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.PRICE_COMPARE_BAND_ID, CawWSTemplateConstant.STR_VAL_0);
                            /* BEGIN BZ48806 */
                            if (jsonPricingMembership != null && jsonPricingMembership.has(CawWSTemplateConstant.MEMBERSHIP)) {
                                template.getJSONObject(CawWSTemplateConstant.PRICING).put(CawWSTemplateConstant.MEMBERSHIP
                                        , jsonPricingMembership.get(CawWSTemplateConstant.MEMBERSHIP));
                            }
                            /* END BZ48806*/
                            break;
                        } else if (custGroupId
                                .compareTo(CawWSTemplateConstant.CLUB_CODE) == 0) {
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.IDENTIFIER, CawWSTemplateConstant.VALUE_24);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.BAND, CawWSTemplateConstant.CLUB_CODE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.DESCRIPTION, CawWSTemplateConstant.CLUB_PRICE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.PRICE_COMPARE_BAND_ID, CawWSTemplateConstant.STR_VAL_0);
                            /* BEGIN BZ53307 */
                            if (jsonPricingMembership != null && jsonPricingMembership.has(CawWSTemplateConstant.MEMBERSHIP)) {
                                template.getJSONObject(CawWSTemplateConstant.PRICING).put(CawWSTemplateConstant.MEMBERSHIP
                                        , jsonPricingMembership.get(CawWSTemplateConstant.MEMBERSHIP));
                            }
                            /* END BZ53307*/
                            break;
                        } else if (custGroupId
                                .compareTo(CawWSTemplateConstant.CREW_CODE) == 0) {
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.IDENTIFIER, CawWSTemplateConstant.VALUE_25);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.BAND, CawWSTemplateConstant.CREW_CODE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.DESCRIPTION, CawWSTemplateConstant.CREW_PRICE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.PRICE_COMPARE_BAND_ID, CawWSTemplateConstant.STR_VAL_0);
                            /* BEGIN BZ53307 */
                            if (jsonPricingMembership != null && jsonPricingMembership.has(CawWSTemplateConstant.MEMBERSHIP)) {
                                template.getJSONObject(CawWSTemplateConstant.PRICING).put(CawWSTemplateConstant.MEMBERSHIP
                                        , jsonPricingMembership.get(CawWSTemplateConstant.MEMBERSHIP));
                            }
                            /* END BZ53307*/
                            break;
                        } else {
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.IDENTIFIER, CawWSTemplateConstant.VALUE_3);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.BAND, CawWSTemplateConstant.RETAIL);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.DESCRIPTION, CawWSTemplateConstant.REG_PRICE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.PRICE_COMPARE_BAND, CawWSTemplateConstant.CLUB_CODE);
                            template.getJSONObject(CawWSTemplateConstant.PRICING)
                                    .put(CawWSTemplateConstant.PRICE_COMPARE_BAND_ID, CawWSTemplateConstant.VALUE_24);
                            /* BEGIN BZ53307 */
                            if (jsonPricingMembership != null && jsonPricingMembership.has(CawWSTemplateConstant.MEMBERSHIP)) {
                                template.getJSONObject(CawWSTemplateConstant.PRICING).put(CawWSTemplateConstant.MEMBERSHIP
                                        , jsonPricingMembership.get(CawWSTemplateConstant.MEMBERSHIP));
                            }
                            /* END BZ53307*/
                            break;
                        }
                    } else {
                        template.getJSONObject(CawWSTemplateConstant.PRICING)
                                .put(CawWSTemplateConstant.IDENTIFIER, CawWSTemplateConstant.VALUE_3);
                        template.getJSONObject(CawWSTemplateConstant.PRICING)
                                .put(CawWSTemplateConstant.BAND, CawWSTemplateConstant.RETAIL);
                        template.getJSONObject(CawWSTemplateConstant.PRICING)
                                .put(CawWSTemplateConstant.DESCRIPTION, CawWSTemplateConstant.REG_PRICE);
                        template.getJSONObject(CawWSTemplateConstant.PRICING)
                                .put(CawWSTemplateConstant.PRICE_COMPARE_BAND, CawWSTemplateConstant.CLUB_CODE);
                        template.getJSONObject(CawWSTemplateConstant.PRICING)
                                .put(CawWSTemplateConstant.PRICE_COMPARE_BAND_ID, CawWSTemplateConstant.VALUE_24);
                        /* BEGIN BZ53307 */
                        if (jsonPricingMembership != null && jsonPricingMembership.has(CawWSTemplateConstant.MEMBERSHIP)) {
                            template.getJSONObject(CawWSTemplateConstant.PRICING).put(CawWSTemplateConstant.MEMBERSHIP
                                    , jsonPricingMembership.get(CawWSTemplateConstant.MEMBERSHIP));
                        }
                        /* END BZ53307*/
                        break;
                    }
                }
            } finally {
                if (rsGroupPricing != null) {
                    rsGroupPricing.close();
                }
                if (psGroupPricing != null) {
                    psGroupPricing.close();
                }
            }

            if (!checkdata) {
                template.getJSONObject(CawWSTemplateConstant.PRICING)
                        .put(CawWSTemplateConstant.IDENTIFIER, CawWSTemplateConstant.VALUE_3);
                template.getJSONObject(CawWSTemplateConstant.PRICING)
                        .put(CawWSTemplateConstant.BAND, CawWSTemplateConstant.RETAIL);
                template.getJSONObject(CawWSTemplateConstant.PRICING)
                        .put(CawWSTemplateConstant.DESCRIPTION, CawWSTemplateConstant.REG_PRICE);
                template.getJSONObject(CawWSTemplateConstant.PRICING)
                        .put(CawWSTemplateConstant.PRICE_COMPARE_BAND, CawWSTemplateConstant.CLUB_CODE);
                template.getJSONObject(CawWSTemplateConstant.PRICING)
                        .put(CawWSTemplateConstant.PRICE_COMPARE_BAND_ID, CawWSTemplateConstant.VALUE_24);
            }
            template.put(CawWSTemplateConstant.JSON_ACCOUNT_NUMBER, accountNumber);
            template.put(CawWSTemplateConstant.CUSTOMER_TYPE, custType);
            template.put(CawWSTemplateConstant.EMAIL_ADDRESS, custEmailAddress);
            template.put(CawWSTemplateConstant.LAST_UPDATE_SYSTEM, CawWSTemplateConstant.CW
                    + storeId);
            updateCRUD(template, accountNumber);
            logger.debug("buildCustomerTemp-5:\n" + template.toString());
        } catch (JSONException e) {
            logger.error("Can not parse for customer template"
                    + e.getMessage());
        }
        //End BZ24886
        return template;
    }

    /**
     * Account number will be updated via this operation for case Customer can't lookup from ESB
     * Account number will be updated via this operation.
     * @param template
     * @param acctNumber
     */
    public static JSONObject updateCRUD(JSONObject template, long acctNumber) {
        try {
            if (acctNumber == 0) {
                template.put(CawWSTemplateConstant.CRUD, 1);
                template.put(CawWSTemplateConstant.CRUD_DESCRIPTION, CawCommonConstant.CRUD_CREATED);
                logger.debug("updateCRUD() - Account will have status Crud-1 and will update account to Database");
            } else {
                template.put(CawWSTemplateConstant.CRUD, 0);
                template.put(CawWSTemplateConstant.CRUD_DESCRIPTION, CawCommonConstant.CRUD_NOT_SPECIFIED);
                logger.debug("updateCRUD() - Account will have status Crud-0. it is NotSpecified");
            }
        } catch (Exception e) {
            logger.error("Cannot update CRUD for customer request");
        }
        return template;
    }

    //Begin BZ24886
    /**
     * this method is used to Update account after having account number from ESB and delete recode out of CRM_PARTY_P if this case is offline
     * @param conn
     * @param cust
     * @param body
     * @throws SQLException
     */
    public static void updateAccountNumberAndDeleteQueue(Connection conn,
            CawCustomerModel cust, String body, CawTransactionModel model)
            throws SQLException {

        //Begin BZ24238
        ResultSet rsCrmParty = null;
        PreparedStatement psInsertCRMPartyIdXXEF = null;
        //End BZ24238
        if (cust.getPartyId() != null) {
            PreparedStatement psDeleteCust = null;
            PreparedStatement isCrmPartyIdXref = null;
            try {
                if (model.getJsonCustomer() != null) {
                    try {
                        //Begin BZ24238
                        JSONObject responseData;
                        isCrmPartyIdXref = conn
                                .prepareStatement(CawSQLConstant.QUERY_CRM_PARTY_ID_XREF_BY_ACCOUNT_NUMBER, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        isCrmPartyIdXref.setString(1, cust.getPartyId());
                        rsCrmParty = isCrmPartyIdXref.executeQuery();
                        logger.debug("updateAccountNumberAndDeleteQueue() - Executed query for CRM_PARTY\n"
                                + CawSQLConstant.QUERY_CRM_PARTY_ID_XREF_BY_ACCOUNT_NUMBER
                                + " " + Arrays.asList(cust.getPartyId()));
                        rsCrmParty.last();
                        logger.debug("Result set - size:"
                                + rsCrmParty.getRow());
                        rsCrmParty.beforeFirst();
                        if (!rsCrmParty.next()) {
                            responseData = new JSONObject(body);
                            if (responseData
                                    .get(CawWSTemplateConstant.JSON_ACCOUNT_NUMBER) != null) {
                                psInsertCRMPartyIdXXEF = conn
                                        .prepareStatement(CawSQLConstant.QUERY_INSERT_CRM_PARTY_ID_XREF_STATUS);
                                model.setAccountNumber(responseData
                                        .getLong(CawWSTemplateConstant.JSON_ACCOUNT_NUMBER));
                                cust.setAccountNumber(model.getAccountNumber());
                                psInsertCRMPartyIdXXEF.setLong(1, 1000);
                                psInsertCRMPartyIdXXEF.setLong(2, Long
                                        .parseLong(cust.getPartyId()));
                                psInsertCRMPartyIdXXEF
                                        .setString(3, CawWSTemplateConstant.ALTERNATE_ID_OWNER);
                                psInsertCRMPartyIdXXEF.setString(4, model
                                        .getAccountNumber()
                                        + CawCommonConstant.EMPTY_STRING);
                                psInsertCRMPartyIdXXEF
                                        .setDate(5, new java.sql.Date(
                                                Calendar.getInstance()
                                                        .getTimeInMillis()));
                                psInsertCRMPartyIdXXEF
                                        .setString(6, CawWSTemplateConstant.VALUE_100);
                                psInsertCRMPartyIdXXEF.setTimestamp(7, null);
                                psInsertCRMPartyIdXXEF.setString(8, null);
                                psInsertCRMPartyIdXXEF.setTimestamp(9, null);
                                logger.debug("updateAccountNumberAndDeleteQueue()-Executed update for CRM_PARTY\n"
                                        + psInsertCRMPartyIdXXEF.toString());
                                psInsertCRMPartyIdXXEF.executeUpdate();
                            }
                        }
                        //End BZ24238
                        //UPDATE RECORD_STATUS = COMPLETED WHEN GETTING SUCCESSFUL RESPONSE
                        psDeleteCust = conn
                                .prepareStatement(CawSQLConstant.QUERY_DELETE_CUSTOMER_OFFLINE);
                        psDeleteCust.setString(1, cust.getPartyId());
                        psDeleteCust
                                .setString(2, CawCommonConstant.ESB_QUEUE_VALUE);
                        psDeleteCust.executeUpdate();
                        logger.info("********** STATUS HAS BEEN UPDATED SUCCESSFUL! **********");
                        logger.info("********** ALL RESPONSES HAS BEEN UPDATED SUCCESSFUL! **********");
                    } catch (JSONException e1) {
                        logger.error("JSONException: " + e1.getMessage());
                    } catch (SQLException e) {
                        logger.error("SQL ERROR: " + e.getMessage());
                    }
                }
            } catch (HttpClientErrorException e) {
                logger.error("Error message from EBS: " + e.getMessage());
            } finally {
                if (rsCrmParty != null) {
                    try {
                        rsCrmParty.close();
                    } catch (SQLException e) {
                        logger.error("Error: " + e.getMessage());
                    }
                }
                if (psDeleteCust != null) {
                    psDeleteCust.close();
                }
                if (psInsertCRMPartyIdXXEF != null) {
                    psInsertCRMPartyIdXXEF.close();
                }
                if (isCrmPartyIdXref != null) {
                    isCrmPartyIdXref.close();
                }
            }

        }
    }
}
