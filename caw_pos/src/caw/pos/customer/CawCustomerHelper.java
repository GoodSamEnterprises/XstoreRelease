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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23197              050917    No result when searching customer with Phone Number
 * BZ23168              050917    The information of Home/Work/Mobile field don't replicate on API service when adding new a customer
 * BZ23270              120917    Cannot search successfully customer when combining "Country" criteria
 * BZ23268              120917    Company name displays on result list instead of 'null' when searching customer belongs to company
 * BZ23269              120917    Company name is not retrieved info on Contact Information
 * BZ23294              130917    Customer Search Information
 * BZ23367              160917    Club# doesn't display on Account tab when searching the customer has memberships number
 * BZ23417              180917    [Customer Update] Get Pricing Identifier as Customer Group for Customer Information
 * BZ23477              200917    Need send back customer information to EBS WS when online
 * BZ23541              270917    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4
 * BZ23637              280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ23721              041017    [Prompting Engine] Unexpected character in the customer fields' value in the Catalyst requests
 * BZ23951              171017    Customer Search Screen Needs to Include Membership#, Expiration Date
 * BZ24126              231017    Cust_Acct_ID has membership displays incorrect format in database
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins 
 * BZ24202              261017    Cannot lookup customer info successfully at Xstore although have data response from CW Webservice
 * BZ24297              021117    Club# is not displayed info on Account tab on Dashboard when viewing customer has membership
 * BZ24385              081117    "Join RA membership#" is not displayed under customer section on receipt after validation this membership successfully
 * BZ24498              161117    Club price is not applied to transaction after selling GSC Join in EBS offline
 * BZ24351              201117    Non Good Sam Club members are receiving CLUB pricing incorrectly
 * BZ24607              301117    Membership # Not Appearing on Receipt
 * BZ24651              061217    Membership info under Customer section should be displayed <status> instead of <benefit name>
 * BZ24601              221217    Price of customer is changed from RETL to CLUB unexpectedly when sending catalyst=1 request
 * BZ25118              120118    HDE prompt displays when doing a return item with original receipt in case not retrieved data from EBS status
 * BZ25358              210518    Enhancements to QAS Integration with POS
 * BZ25434              230518    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 * BZ26471              050618    Club pricing doesn't show on top banner when doing Resume transaction has club/wholesale/Crew pricing
 * BZ26453              050618    [Internal] Membership Info of customer does not display at customer search prompt when searching the customer in offline status.
 * BZ26398              070618    Club pricing is displayed on top banner once adding RA join item for transaction in offline case.
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26207              190718    New Requirement - Enable Work Order Functionality
 * BZ26289              110718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27851              121018    [Internal][27339] Membership info is empty at Account tab when select&View customer has membership info.
 * BZ28441              141218    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 3.0
 * BZ28853              271218    [Internal][offline][2.9.7] Cannot found a customer which existed data from XCenter incase offline.
 * BZ28549              271218    [PROD] Club pricing is not reflected when suspended transactions are resumed
 * BZ28985              190219    [Internal] Incorrect customer account number is submitted in the Upsert request to the Neuron API
 * BZ29840              210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 * BZ27535              090519    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ31982              230719    [INTERNAL] Could not tender by AR Account when consuming trans in Xstore
 * BZ31717              240719    [Prod] Cancelled transactions are successfully proceed in Order Service. 
 * BZ34163              191219    [INTERNAL] Xstore does not send customer new address to EBS when old address does not match QAS
 * BZ28036              100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ36405              030620    Issue with Credit Customer placed on credit hold
 * BZ37650              100920    [Internal] ERROR screen displays when email is missing on customer record
 * BZ37753              160920    [Internal] - HDE screen displays when adding 2nd address for customer
 * BZ37970              180920      [Interna] ERROR - Missing Organization Type when attempting to assign WHSL customer to new order
 * BZ38598              301020    [PROD] Membership Activation Issues
 * BZ48622              110222    [Internal]- Customer Maintenance Accounts Tab displays no values when selecting 'Select and View' on Search Customer screen.    
 * BZ48732              210222    [Internal] Duplicate customer info when performing the customer search
 * BZ48733              210222    [Internal] Issues in the customer maintenance accounts tab
 * BZ48564              150422    [Task] - Display Loyalty Information on the Customer Maintenance Accounts Tab
 * BZ48692              240422    [Task] Process New Service is offline/time out when processing customer Search.
 * BZ48564              280422    [Task] - Display Loyalty Information on the Customer Maintenance Accounts Tab
 * BZ50682              220622    [Internal] Item sold with regular price when customer is GSAM Club membership.
 * BZ53048              211022    [Internal] Order Service response with ERROR: 400 Bad Request in case Upsert API Offline..
 * BZ53459              101122    [UAT] Accounts tab display multiple GSAM records with same points balance and redeemable points
 * BZ54290              160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ58973              190923    Resumed loyalty transaction not prompting loyalty offers
 * BZ61159              190224    [New Requirement] - Xstore AGIS Replacement
 * BZ69515              120225    Display Good Sam Visa Cardholder indicator Icon
*===================================================================
 */

package caw.pos.customer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.address.search.CawPromptAddressLookupHelper;
import caw.pos.address.search.CawQASHelper;
import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.advance.prompting.CawCustomerGroupType;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.customer.membership.CawCustomerMembershipView;
import caw.pos.customer.membership.CawMembershipHelper;
import caw.pos.util.CawEBSHelper;
import caw.qas.proweb.*;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;

import dtv.data2.access.*;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.data2.access.query.QueryRequest;
import dtv.pos.address.search.AddressSearchInfo;
import dtv.pos.common.*;
import dtv.pos.customer.CustomerSearchModel;
import dtv.pos.framework.form.IHasAddressFields;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.IPersistablesBag;
import dtv.pos.iframework.security.StationState;
import dtv.util.*;
import dtv.util.common.CommonConstants;
import dtv.util.sequence.SequenceFactory;
import dtv.xst.crm.cust.ICustomerQueryResult;
import dtv.xst.dao.cat.*;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.tax.ITaxExemption;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 * BZ25675 moved constants to CawJSONConstant class
 */
public class CawCustomerHelper extends CawJSONConstant {

    private static final Logger                                 _logger                            = LogManager
            .getLogger(CawCustomerHelper.class);

    private CawPromptAddressLookupHelper                        _addressHelper                     = CawPromptAddressLookupHelper
            .getInstance();

    private static volatile CawCustomerHelper                   INSTANCE                           = null;

    //Begin BZ23052
    private static final String                                 IS_AUTO_RENEW                      = "isAutoRenew";

    private static final String                                 STATUS_DESCRIPTION                 = "statusDescription";

    private static final String                                 STATUS                             = "status";

    private static final String                                 TYPE_DESCRIPTION                   = "typeDescription";

    private static final String                                 TYPE                               = "type";

    private static final String                                 BENEFIT_LEVEL_NAME                 = "benefitLevelName";

    private static final String                                 BENEFIT_LEVEL                      = "benefitLevel";

    private static final String                                 EXPIRE_DATE                        = "expireDate";

    private static final String                                 JOIN_DATE                          = "joinDate";

    private static final String                                 IDENTIFIER                         = "identifier";

    private static final String                                 CUSTOMER                           = "CUSTOMER";

    private static final String                                 OPEN                               = "OPEN";

    private static final String                                 WORK_ORDER                         = "WORK_ORDER";

    private static final String                                 HOUSE_ACCOUNT                      = "HOUSE_ACCOUNT";                          // BZ26289

    private static final String                                 CLOSE                              = "CLOSE";

    private static final String                                 LOYALTY                            = "LOYALTY";

    private static final String                                 GOOD_SAM_CLUB_SEQ                  = "GOOD_SAM_CLUB";

    private static final String                                 DTV_CLASS_NAME                     = "dtv.xst.dao.cat.impl.CustomerAccount";   // BZ24385

    IPersistablesBag                                            bag                                = TransactionHelper
            .getPersistables();
    // End BZ23052

    private static final String                                 PRICING_ATTR                       = "pricing";                                //BZ23417

    private static final String                                 THE_CUSTOMER_ATTR                  = "customer";    // BZ24498, BZ61159

    public ICustomerLoyaltyCard                                 savedCustLoyaltyCard               = null;

    private static final String                                 CAW_CUSTOMER_GROUP_REMOVE          = "CAW_CUSTOMER_GROUP_REMOVE";              // BZ24351

    // Begin BZ24601
    private static final String                                 CAW_CAT_CUST_LOYALTY_ACCT_P_REMOVE = "CAW_CAT_CUST_LOYALTY_ACCT_P_REMOVE";

    private static final String                                 CAW_CAT_CUST_LOYALTY_ACCT_REMOVE   = "CAW_CAT_CUST_LOYALTY_ACCT_REMOVE";

    private static final String                                 CAW_CAT_CUST_CARD_ACCT_REMOVE      = "CAW_CAT_CUST_CARD_ACCT_REMOVE";

    private static final String                                 CAW_CAT_CUST_ACCT_REMOVE           = "CAW_CAT_CUST_ACCT_REMOVE";

    IQueryKey<CawCustomerGroupQueryResult>                      CAW_CUSTOMER_GROUP_PRICE_LOOKUP    = new QueryKey<CawCustomerGroupQueryResult>(
            "CAW_CUSTOMER_GROUP_PRICE_LOOKUP",
            CawCustomerGroupQueryResult.class);
    // End BZ24601

    // Begin BZ26453
    protected static final IQueryKey<CawCustomerQueryResult>    CAW_CRM_CUSTOMER_LOOKUP            = new QueryKey<CawCustomerQueryResult>(
            "CAW_CRM_CUSTOMER_LOOKUP", CawCustomerQueryResult.class);

    protected static final IQueryKey<CawCustomerQueryResult>    CAW_CRM_CUSTOMER_LOOKUP_PRIMARY    = new QueryKey<CawCustomerQueryResult>(
            "CAW_CRM_CUSTOMER_LOOKUP_PRIMARY", CawCustomerQueryResult.class);

    private static final String                                 ACTIVE_FLAG_FIELD                  = "activeFlag";

    private static final String                                 PRIMARY_ADDRESS_FIELD              = "primaryAddress";
    // End BZ26453

    // Begin BZ26398
    protected static final IQueryKey<CawPartyIdXrefQueryResult> CAW_CUSTOMER_PARTY_ID_XREF         = new QueryKey<CawPartyIdXrefQueryResult>(
            "CAW_CUSTOMER_PARTY_ID_XREF", CawPartyIdXrefQueryResult.class);
    // End BZ26398

    /* BEGIN BZ31717 */
    private static final String                                 CAT_CUST_CONSUMER_CHARGE_ACCT_REMOVE = "CAT_CUST_CONSUMER_CHARGE_ACCT_REMOVE";
    /* END BZ31717 */
    /**
     * @return
     */
    private static final int                                    RESPONSE_SUCCESS_CODE = 200;
    
    public static CawCustomerHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawCustomerHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawCustomerHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * BZ27339 applied.
     * 
     * Reset all caches or common variables 
     * which generated from the given customer.
     * Used when customer removed out of the transaction
     */
    public void resetSelectedCustomer() {

        CawMembershipHelper.getInstance().reset();
        CawCatalystHelper.setLookupResponseData(null);
    }

    /**
     * Get list of customers for entered criteria
     * Step1: Build JSON message for Customer Search request
     * Step2: Send the request and get response via Neuron service
     * Step3: Parse the response to list of customers
     * @param argFields
     * @return
     */
    public IQueryResultList<ICustomerQueryResult> searchCustomerFromEBS(
            Collection<IKeyedValue<String, ?>> argFields) {

        IQueryResultList<ICustomerQueryResult> list = null;
        try {
            //Step1: Build JSON message for Customer Search request-------------
            String body = this.buildRequestOfCustomerSearch(argFields);
            //Step2: Send the request and get response via Neuron service-------
            ResponseEntity<String> result = CawEBSHelper.getInstance()
                    .searchRequestToEBS(body);
            //Step3: Parse the response to list of customers --------------
            if (result != null) {
                if (result.getStatusCode() == HttpStatus.OK) {
                    List<CawCustomerQueryResult> customerQueryResults = this
                            .parseResponseOfCustomerSearch(result.getBody());
                    list = QueryResultList
                            .makeList(customerQueryResults, ICustomerQueryResult.class);
                }
            }
            //BEGIN BZ48622, BZ48732: ENABLE TO USE MOCKUP
            if (Files.exists(Paths.get("/opt/xstore/mockupResponse/mockupCustomerSearchResponse.txt"))) {
                String mockupResponse = new String(Files.readAllBytes(Paths.get("/opt/xstore/mockupResponse/mockupCustomerSearchResponse.txt")));
                if(StringUtils.isNotEmpty(mockupResponse)) {
                    List<CawCustomerQueryResult> customerQueryResults = this.parseResponseOfCustomerSearch(mockupResponse);
                    list = QueryResultList.makeList(customerQueryResults, ICustomerQueryResult.class);
                }
            }
            //END BZ48622, BZ48732: ENABLE TO USE MOCKUP
        } catch (Exception ex) {
            _logger.error("searchCustomerFromEBS-0: " + ex.getMessage());
        }
        return list;
    }

    /**
     * Customer template change value default
     * 
     * @param argIParty
     * @param customerTemplate
     */
    public CawCustomerTemplate changeCawCustomerTemplate(IParty argIParty) {

        CawCustomerTemplate customerTemplate = new CawCustomerTemplate();
        // name
        CawCustomerInfo name = new CawCustomerInfo();
        name.setFirst(argIParty.getFirstName());
        name.setLast(argIParty.getLastName());
        name.setPrefix(argIParty.getSalutation());
        name.setMiddle(argIParty.getMiddleName());
        name.setSuffix(argIParty.getSuffix());
        name.setCompany(argIParty.getOrganizationName());
        customerTemplate.setName(name);
        // address
        List<IPartyLocaleInformation> listAddresses = argIParty
                .getLocaleInformation();
        CawCustomerAddress address = new CawCustomerAddress();
        //Begin BZ34163: Due to the new address is set at the first element, so getting it to update into customer info
        IPartyLocaleInformation localeInfo = listAddresses.get(0);
        if (localeInfo != null) {
            address.setAddressType(CawEBSConstant.ADDRESS_TYPE);
            address.setAddressTypeDescription(localeInfo.getAddressType());
            address.setIsDeliverable(localeInfo.getContact());
            address.setLine1(localeInfo.getAddress1());
            address.setLine2(localeInfo.getAddress2());
            address.setLine3(localeInfo.getAddress3());
            address.setLine4(localeInfo.getAddress4());
            address.setCity(localeInfo.getCity());
            address.setStateProvince(localeInfo.getState());
            address.setPostalCode(localeInfo.getPostalCode());
            address.setCountry(localeInfo.getCountry());
            address.setCounty(localeInfo.getCounty());

            customerTemplate.setAddress(address);
        }
        //End BZ34163
        // phones
        List<IPartyTelephone> listPhonses = argIParty.getTelephoneInformation();
        StringBuilder sbPhone = new StringBuilder();
        sbPhone.append("[");
        for (IPartyTelephone phone : listPhonses) {
            if (phone.getTelephoneNumber() != null) {
                if (phone.getTelephoneType().equals(HOME_TYPE)) {
                    sbPhone.append("{\"identifier\":").append(ONE_STRING)
                            .append(",\"type\":").append(ONE_STRING)
                            .append(",\"typeDescription\":")
                            .append("\"" + phone.getTelephoneType() + "\"")
                            .append(",\"number\":")
                            .append("\"" + phone.getTelephoneNumber() + "\"")
                            .append(",\"isActive\":").append(Boolean.TRUE)
                            .append("},");
                }
                if (phone.getTelephoneType().equals(MOBILE_TYPE)) {
                    sbPhone.append("{\"identifier\":").append(ONE_STRING)
                            .append(",\"type\":").append(TWO_STRING)
                            .append(",\"typeDescription\":")
                            .append("\"" + phone.getTelephoneType() + "\"")
                            .append(",\"number\":")
                            .append("\"" + phone.getTelephoneNumber() + "\"")
                            .append(",\"isActive\":").append(Boolean.TRUE)
                            .append("},");
                }

            }
        }
        sbPhone.setLength(sbPhone.length() - 1);
        if (sbPhone.length() > ZERO) {
            sbPhone.append("]");
        }

        customerTemplate.setPhones(sbPhone.toString());
        customerTemplate.setEmailAddress(argIParty.getEmailAddress());
        if (customerTemplate.getName().getCompany() != null) {
            customerTemplate.setCustomerType(TWO);
            customerTemplate.getName().setFirst(null);
            customerTemplate.getName().setLast(null);
        } else {
            customerTemplate.setCustomerType(ONE);
        }

        return customerTemplate;
    }

    /**
     * 
     * @param customerFormatJson
     * @param neuronUser
     * @param neuronKey
     */
    public ResponseEntity<String> upsertCustomterToEBS(
            CawCustomerTemplate custTemplate) {

        CawRestConfig request = CawRestConfigHelper.getInstance()
                .getRestRequest(CawEBSConstant.CUSTOMER_UPSERT);
        String body = request.getBody();

        /*The current webservice have issue so that temporary comment this code*/
        Integer storeId = Integer.parseInt(System
                .getProperty(CommonConstants.RETAIL_LOCATION_ID));
        body = body.replace(SALES_CHANNEL, CawUtilFunction
                .formatParameter(storeId.toString()));

        // body = body.replace(SALES_CHANNEL, "1");//Temporary hard coded waiting Upsert API work, it line will remove

        body = body.replace(NAME_AUDIT, CawUtilFunction
                .formatParameter(custTemplate.getName().getAudit()));
        body = body.replace(NAME_PREFIX, CawUtilFunction
                .formatParameter(custTemplate.getName().getPrefix()));
        body = body.replace(NAME_FIRST, CawUtilFunction
                .formatParameter(custTemplate.getName().getFirst()));
        body = body.replace(NAME_MIDDLE, CawUtilFunction
                .formatParameter(custTemplate.getName().getMiddle()));
        body = body.replace(NAME_LAST, CawUtilFunction
                .formatParameter(custTemplate.getName().getLast()));
        body = body.replace(NAME_SUFFIX, CawUtilFunction
                .formatParameter(custTemplate.getName().getSuffix()));
        body = body.replace(NAME_COMPANY, CawUtilFunction
                .formatParameter(custTemplate.getName().getCompany()));

        body = body.replace(ADDRESS_AUDIT, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getAudit()));
        body = body.replace(ADDRESS_ADDRESS_TYPE, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getAddressType()));
        body = body.replace(ADDRESS_TYPE_DESCRIPTION, CawUtilFunction
                .formatParameter(custTemplate.getAddress()
                        .getAddressTypeDescription()));
        body = body.replace(ADDRESS_IS_DELIVERABLE, custTemplate.getAddress()
                .getIsDeliverable() == true ? Boolean.TRUE.toString()
                        : Boolean.FALSE.toString());
        body = body.replace(ADDRESS_LINE1, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getLine1()));
        body = body.replace(ADDRESS_LINE2, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getLine2()));
        body = body.replace(ADDRESS_LINE3, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getLine3()));
        body = body.replace(ADDRESS_LINE4, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getLine4()));
        body = body.replace(ADDRESS_CITY, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getCity()));
        body = body.replace(ADDRESS_STATE_PROVINCE, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getStateProvince()));
        body = body.replace(ADDRESS_POSTAL_CODE, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getPostalCode()));
        body = body.replace(ADDRESS_COUNTRY, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getCountry()));
        body = body.replace(ADDRESS_COUNTY, CawUtilFunction
                .formatParameter(custTemplate.getAddress().getCounty()));

        body = body.replace(MEMBERSHIPS, NULL);
        /* Begin BZ23197 */
        if (!custTemplate.getPhones().isEmpty()) {
            body = body.replace(PHONES, custTemplate.getPhones());
        } else {
            body = body.replace(PHONES, NULL);
        }
        /* End BZ23197 */
        body = body.replace(PARTNERS, NULL);
        body = body.replace(PRICING, NULL);
        body = body.replace(ACCOUNT_NUMBER, custTemplate.getAccountNumber()
                .toString());
        body = body.replace(ACCOUNT_STATUS, custTemplate.getAccountStatus()
                .toString());
        body = body.replace(ACCOUNT_STATUS_DESCRIPTION, CawUtilFunction
                .formatParameter(custTemplate.getAccountStatusDescription()));
        body = body.replace(CUSTOMER_TYPE, custTemplate.getCustomerType()
                .toString());
        body = body.replace(RV_TYPE, custTemplate.getRvType() != null
                ? custTemplate.getRvType().toString()
                : NULL);
        body = body.replace(ACXIOMIDENTIFIERS, NULL);
        body = body.replace(ALLOWEDIT, Boolean.TRUE.toString());
        body = body.replace(EMAIL_ADDRESS, CawUtilFunction
                .formatParameter(custTemplate.getEmailAddress()));

        body = body.replace(RV_TYPE, custTemplate.getRvType().toString());
        body = body.replace(RV_TYPE_DESCRIPTION, CawUtilFunction
                .formatParameter(custTemplate.getRvTypeDescription()));
        body = body.replace(IS_TAXEXEMPT, Boolean.FALSE.toString());
        body = body.replace(TAX_CERTIFICATE, NULL);
        body = body.replace(AR_INFO, NULL);
        body = body.replace(LAST_UPDATE_USER, CawUtilFunction
                .formatParameter(custTemplate.getLastUpdateUser()));
        body = body.replace(LAST_UPDATE_SYSTEM, CawUtilFunction
                .formatParameter(custTemplate.getLastUpdateSystem()));
        body = body.replace(LAST_UPDATE_DATE, CawUtilFunction
                .formatParameter(custTemplate.getLastUpdateDate()));
        body = body.replace(FEED, CawUtilFunction
                .formatParameter(custTemplate.getFeed()));
        body = body.replace(CRUD, String.valueOf(CawCustomerCrud.NOT_SPECIFIED.getValue())); //BZ54290
        body = body.replace(CRUD_DESCRIPTION, CawUtilFunction
                .formatParameter(custTemplate.getCrudDescription()));
        body = body.replace(ATTRIBUTES, CawUtilFunction
                .formatParameter(custTemplate.getAttributes()));

        String finalBody = CawUtilFunction.sanitizeXmlChars(body)
                .replaceAll(SPECIAL_CHARACTER, SPACE_CHARACTER);

        //BZ25675 Changed
        return CawEBSHelper.getInstance().upsertCustomterToEBS(finalBody);
    }

    /**
     * @return
     */
    public Integer getMaxNumberOfCustomers() {

        return ConfigurationMgr.getHelper()
                .getInt(new String[] { STORE_TAG, SYSTEM_CONFIG_TAG, CUSTOMER_SEARCH, MAXNUMBEROFCUSTOMERS });

    }

    /**
     * @param jsonObject
     * @return
     */
    public IParty createPartyObjFromJson(JSONObject responseData)
            throws JSONException {

        IParty party = DataFactory.createObject(IParty.class);
        JSONObject objIndex = null;
        if (responseData != null) {
            final long partySeq = SequenceFactory
                    .getNextLongValue(CawEBSConstant.PARTY_SEQUENCE_ID);
            party.setOrganizationId(CawEBSConstant.ORGANIZATION_ID);
            party.setPartyId(partySeq);

            String custId = SequenceFactory
                    .getNextStringValue(CawEBSConstant.CUSTOMER_SEQUENCE_ID);
            party.setCustomerId(custId);
            party.setPartyTypeCode(CawEBSConstant.CUSTOMER);

            objIndex = CawJSONUtils.getJSONObject(responseData, JSON_NAME);
            if (objIndex != null) {
                if (objIndex.get(JSON_LAST_NAME) != null) {
                    party.setFirstName(objIndex.get(JSON_FIRST_NAME)
                            .toString());
                }
                if (objIndex.get(JSON_LAST_NAME) != null) {
                    party.setLastName(objIndex.get(JSON_LAST_NAME).toString());
                }
                // Begin BZ23269
                String companyName = objIndex.getString(JSON_COMPANY);
                if (companyName != null) {
                    party.setOrganizationName(companyName);
                    if (companyName.split(" ").length > 1) {
                        String first = companyName
                                .substring(0, companyName.lastIndexOf(" "));
                        String last = companyName
                                .substring(companyName.lastIndexOf(" ") + 1);
                        party.setFirstName(first);
                        party.setLastName(last);
                    } else {
                        party.setFirstName("");
                        party.setLastName(companyName);
                    }
                }
                // End BZ23269
            }

            // BEGIN BZ37970
            String organizationType = CawJSONUtils.getString(responseData, JSON_CUSTOMER_TYPE);
            if(StringUtils.isNotEmpty(organizationType) && organizationType.equals("2")) {
                party.setOrganizationTypeCode("COMPANY");
            }
            // END BZ37970

            // Begin BZ23294
            objIndex = CawJSONUtils.getJSONObject(responseData, JSON_ADDRESS);
            if (objIndex != null) {
                IPartyLocaleInformation addressInfo = DataFactory
                        .createObject(IPartyLocaleInformation.class);

                if (objIndex.getString(JSON_LINE1) != null) {
                    addressInfo.setAddress1(objIndex.getString(JSON_LINE1));
                }

                if (objIndex.getString(JSON_LINE2) != null) {
                    addressInfo.setAddress2(objIndex.getString(JSON_LINE2));
                }

                if (objIndex.getString(JSON_LINE3) != null) {
                    addressInfo.setAddress3(objIndex.getString(JSON_LINE3));
                }

                if (objIndex.getString(JSON_LINE4) != null) {
                    addressInfo.setAddress4(objIndex.getString(JSON_LINE4));
                }

                if (objIndex.getString(JSON_CITY) != null) {
                    addressInfo.setCity(objIndex.getString(JSON_CITY));
                }

                if (objIndex.getString(JSON_STATE) != null) {
                    addressInfo.setState(objIndex.getString(JSON_STATE));
                }

                if (objIndex.getString(JSON_POSTAL_CODE) != null) {
                    addressInfo.setPostalCode(objIndex
                            .getString(JSON_POSTAL_CODE));
                }

                if (objIndex.getString(JSON_COUNTY) != null) {
                    addressInfo.setCounty(objIndex.getString(JSON_COUNTY));
                }
                // End BZ23294
                //Waiting confirm because DB only store 2 character but JSON response 3 character
                String country = objIndex.getString(JSON_COUNTRY);
                if (country != null && country.length() > 2) {
                    country = country.substring(0, 2);
                }
                addressInfo.setCountry(country);

                addressInfo.setPrimary(true);// BZ28853

                party.addPartyLocaleInformation(addressInfo);
            }

            String emailaddress = CawJSONUtils
                    .getString(responseData, JSON_EMAIL_ADDRESS);
            if (StringUtils.isNotEmpty(emailaddress)) { // BZ37650
                party.setEmailAddress(emailaddress);
            }
        }

        return party;
    }

    /* Begin BZ-28441 */
    /**
     * @param jsonObject
     * @return
     */
    public void updatePartyObjFromJson(IParty party , JSONObject responseData)
            throws JSONException {

        JSONObject objIndex = null;
        if (responseData != null) {
            
            objIndex = CawJSONUtils.getJSONObject(responseData, JSON_NAME);
            if (objIndex != null) {
                if (objIndex.get(JSON_LAST_NAME) != null) {
                    party.setFirstName(objIndex.get(JSON_FIRST_NAME)
                            .toString());
                }
                if (objIndex.get(JSON_LAST_NAME) != null) {
                    party.setLastName(objIndex.get(JSON_LAST_NAME).toString());
                }
                String companyName = objIndex.getString(JSON_COMPANY);
                if (companyName != null) {
                    party.setOrganizationName(companyName);
                    if (companyName.split(" ").length > 1) {
                        String first = companyName
                                .substring(0, companyName.lastIndexOf(" "));
                        String last = companyName
                                .substring(companyName.lastIndexOf(" ") + 1);
                        party.setFirstName(first);
                        party.setLastName(last);
                    } else {
                        party.setFirstName("");
                        party.setLastName(companyName);
                    }
                }
            }

            // BEGIN BZ37970
            String organizationType = CawJSONUtils.getString(responseData, JSON_CUSTOMER_TYPE);
            if(StringUtils.isNotEmpty(organizationType) && organizationType.equals("2")) {
                party.setOrganizationTypeCode("COMPANY");
            }
            // END BZ37970

            objIndex = CawJSONUtils.getJSONObject(responseData, JSON_ADDRESS);
            if (objIndex != null) {
                IPartyLocaleInformation addressInfo = party.getPrimaryLocaleInformation();
                if (objIndex.getString(JSON_LINE1) != null) {
                    addressInfo.setAddress1(objIndex.getString(JSON_LINE1));
                }

                if (objIndex.getString(JSON_LINE2) != null) {
                    addressInfo.setAddress2(objIndex.getString(JSON_LINE2));
                }

                if (objIndex.getString(JSON_LINE3) != null) {
                    addressInfo.setAddress3(objIndex.getString(JSON_LINE3));
                }

                if (objIndex.getString(JSON_LINE4) != null) {
                    addressInfo.setAddress4(objIndex.getString(JSON_LINE4));
                }

                if (objIndex.getString(JSON_CITY) != null) {
                    addressInfo.setCity(objIndex.getString(JSON_CITY));
                }

                if (objIndex.getString(JSON_STATE) != null) {
                    addressInfo.setState(objIndex.getString(JSON_STATE));
                }

                if (objIndex.getString(JSON_POSTAL_CODE) != null) {
                    addressInfo.setPostalCode(objIndex
                            .getString(JSON_POSTAL_CODE));
                }

                if (objIndex.getString(JSON_COUNTY) != null) {
                    addressInfo.setCounty(objIndex.getString(JSON_COUNTY));
                }
                String country = objIndex.getString(JSON_COUNTRY);
                if (country != null && country.length() > 2) {
                    country = country.substring(0, 2);
                }
                addressInfo.setCountry(country);

                addressInfo.setPrimary(true);// BZ28853
            }

            String emailaddress = CawJSONUtils
                    .getString(responseData, JSON_EMAIL_ADDRESS);
            
            /* BEGIN BZ37650 -- add !emailaddress.equals("")  */
            if (StringUtils.isNotEmpty(emailaddress)) {
                party.setEmailAddress(emailaddress);
            }
            /* END BZ37650 */
        }
    }
    /* End BZ-28441 */

    /**
     * @param accountNumber
     * @param party
     * @return
     */
    // Begin BZ23367
    public IPartyIdCrossReference createPartyCrossReferenceObjFromJson(
            String accountNumber, IParty party) {

        IPartyIdCrossReference partyXRef = DataFactory
                .createObject(IPartyIdCrossReference.class);
        partyXRef.setOrganizationId(party.getOrganizationId());
        partyXRef.setPartyId(party.getPartyId());
        partyXRef.setAlternateId(accountNumber);
        partyXRef.setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);
        return partyXRef;
    }
    // End BZ23367

    /**
     * 
     * @param iParty
     * @param accountNumber
     */
    public String processUpsertRequestToESB(IParty iParty, Long accountNumber) {

        if (iParty != null) {

            // If cawCustomerTemplate is null, that mean Webservice is offline.
            //CawCustomerTemplate cawCustomerTemplate = getJSONTemplate();
            CawCustomerTemplate cawCustomerTemplate = changeCawCustomerTemplate(iParty);
            cawCustomerTemplate.setAccountNumber(accountNumber);
            try {

                ResponseEntity<String> result = upsertCustomterToEBS(cawCustomerTemplate);
                _logger.info("The customer just created: " + result);
                if (result.getStatusCode() == HttpStatus.OK) {
                    if (result.getBody() != null) {
                        return result.getBody();

                    }
                }
            } catch (Exception httpClientErrorException) {
                _logger.error("The customer can not be sent to EBS: "
                        + httpClientErrorException);

            }

        }
        return null;
    }

    public void saveCustomerJSON(IParty party, JSONObject responseData)
            throws JSONException {

        if (party != null && responseData != null) {
            // NAME
            if (responseData.getString(JSON_NAME) != null 
                    && responseData.getJSONObject(JSON_NAME).has(JSON_AUDIT) //BZ50682
                    && responseData.getJSONObject(JSON_NAME).get(JSON_AUDIT) != null) {
                savePartyXRefP(party, PROPERTIES_NAME_AUDIT, responseData
                        .getJSONObject(JSON_NAME).get(JSON_AUDIT)
                        .toString(), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_NAME_AUDIT, null, STRING);
            }

            // ADDRESS
            if (!responseData.isNull(JSON_ADDRESS)
                    && responseData.getString(JSON_ADDRESS) != null) {
                if (responseData.getJSONObject(JSON_ADDRESS).has(JSON_AUDIT) &&  //BZ50682
                        responseData.getJSONObject(JSON_ADDRESS).get(JSON_AUDIT) != null) {
                    savePartyXRefP(party, PROPERTIES_ADDRESS_AUDIT, responseData
                            .getJSONObject(JSON_ADDRESS).get(JSON_AUDIT)
                            .toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_ADDRESS_AUDIT, null, STRING);
                }
                if (responseData.getJSONObject(JSON_ADDRESS)
                        .get(JSON_ADDRESS_TYPE) != null) {
                    savePartyXRefP(party, PROPERTIES_ADDRESS_TYPE, responseData
                            .getJSONObject(JSON_ADDRESS).get(JSON_ADDRESS_TYPE)
                            .toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_ADDRESS_TYPE, null, STRING);
                }
                if (responseData.getJSONObject(JSON_ADDRESS)
                        .get(JSON_ADDRESS_TYPE_DESCRIPTION) != null) {
                    savePartyXRefP(party, PROPERTIES_ADDRESS_TYPE_DESCRIPTION, responseData
                            .getJSONObject(JSON_ADDRESS)
                            .get(JSON_ADDRESS_TYPE_DESCRIPTION)
                            .toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_ADDRESS_TYPE_DESCRIPTION, null, STRING);
                }
            }

            // MEMBERSHIPS
            if (responseData.getString(JSON_MEMBERSHIPS) != null) {
                savePartyXRefP(party, PROPERTIES_MEMBERSHIPS, responseData
                        .getJSONArray(JSON_MEMBERSHIPS).toString(), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_MEMBERSHIPS, null, STRING);
            }

            // Begin BZ24202
            // PHONES
            if (responseData.getString(JSON_PHONES) != null) {
                savePartyXRefP(party, PROPERTIES_PHONES, responseData
                        .getJSONArray(JSON_PHONES).toString(), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_PHONES, null, STRING);
            }
            // End BZ24202

            // PARTNERS
            if (responseData.getString(JSON_PARTNERS) != null) {
                savePartyXRefP(party, PROPERTIES_PARTNERS, responseData
                        .getJSONArray(JSON_PARTNERS).toString(), STRING);//BZ24202
            } else {
                savePartyXRefP(party, PROPERTIES_PARTNERS, null, STRING);
            }

            // ACCOUNT_STATUS
            savePartyXRefP(party, PROPERTIES_ACCOUNT_STATUS, String
                    .valueOf(responseData.getInt(JSON_ACCOUNT_STATUS)), STRING);

            // ACCOUNT_STATUS_DESCRIPTION
            if (responseData
                    .getString(JSON_ACCOUNT_STATUS_DESCRIPTION) != null) {
                savePartyXRefP(party, PROPERTIES_ACCOUNT_STATUS_DESCRIPTION, responseData
                        .getString(JSON_ACCOUNT_STATUS_DESCRIPTION), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_ACCOUNT_STATUS_DESCRIPTION, null, STRING);
            }

            // CUSTOMER_TYPE
            savePartyXRefP(party, PROPERTIES_CUSTOMER_TYPE, String
                    .valueOf(responseData.getInt(JSON_CUSTOMER_TYPE)), STRING);
            //Begin BZ25916
            // ACXIOM_INDIVIDUAL
            if (!responseData.isNull(JSON_ACXIOM_IDENTIFIERS) && responseData
                    .getString(JSON_ACXIOM_IDENTIFIERS) != null) {
                if (responseData.getJSONObject(JSON_ACXIOM_IDENTIFIERS)
                        .get(JSON_ACXIOM_INDIVIDUAL_ID) != null) {
                    savePartyXRefP(party, PROPERTIES_ACXIOM_INDIVIDUAL, responseData
                            .getJSONObject(JSON_ACXIOM_IDENTIFIERS)
                            .get(JSON_ACXIOM_INDIVIDUAL_ID).toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_ACXIOM_INDIVIDUAL, null, STRING);
                }
                if (responseData.getJSONObject(JSON_ACXIOM_IDENTIFIERS)
                        .get(JSON_ACXIOM_HOUSEHOLD_ID) != null) {
                    savePartyXRefP(party, PROPERTIES_ACXIOM_HOUSEHOLD, responseData
                            .getJSONObject(JSON_ACXIOM_IDENTIFIERS)
                            .get(JSON_ACXIOM_HOUSEHOLD_ID).toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_ACXIOM_HOUSEHOLD, null, STRING);
                }
            }

            // ALLOW_EDIT
            savePartyXRefP(party, PROPERTIES_ALLOW_EDIT, String
                    .valueOf(responseData.getBoolean(JSON_ALLOW_EDIT)), STRING);

            // RV_TYPE
            savePartyXRefP(party, PROPERTIES_ACCOUNT_STATUS, String
                    .valueOf(responseData.getInt(JSON_RV_TYPE)), STRING);

            // RV_TYPE_DESCRIPTION  
            if (responseData.getString(JSON_RV_TYPE_DESCRIPTION) != null) {
                savePartyXRefP(party, PROPERTIES_RV_TYPE_DESCRIPTION, responseData
                        .getString(JSON_RV_TYPE_DESCRIPTION), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_RV_TYPE_DESCRIPTION, null, STRING);
            }

            // IS_TAX_EXEMPT
            savePartyXRefP(party, PROPERTIES_IS_TAX_EXEMPT, String
                    .valueOf(responseData
                            .getBoolean(JSON_IS_TAX_EXEMPT)), STRING);

            // TAX_CERTIFICATE
            if (responseData.getString(JSON_TAX_CERTIFICATE) != null) {
                savePartyXRefP(party, PROPERTIES_TAX_CERTIFICATE, responseData
                        .getString(JSON_TAX_CERTIFICATE), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_TAX_CERTIFICATE, null, STRING);
            }

            // AR_INFO
            if (responseData.getString(JSON_AR_INFO) != null) {
                if (responseData.getJSONObject(JSON_AR_INFO)
                        .get(JSON_AR_CREDIT_HOLD) != null) {
                    savePartyXRefP(party, PROPERTIES_IS_AR_INFO_CREDIT_HOLD, responseData
                            .getJSONObject(JSON_AR_INFO)
                            .get(JSON_AR_CREDIT_HOLD).toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_IS_AR_INFO_CREDIT_HOLD, null, STRING);
                }
                if (responseData.getJSONObject(JSON_AR_INFO)
                        .get(JSON_AR_AVAILABLE_BALANCE) != null) {
                    savePartyXRefP(party, PROPERTIES_AR_INFO_AVAILABLE_BALANCE, responseData
                            .getJSONObject(JSON_AR_INFO)
                            .get(JSON_AR_AVAILABLE_BALANCE).toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_AR_INFO_AVAILABLE_BALANCE, null, STRING);
                }
                if (responseData.getJSONObject(JSON_AR_INFO)
                        .get(JSON_AR_LAST_PAYMENT) != null) {
                    savePartyXRefP(party, PROPERTIES_AR_INFO_LAST_PAYMENT, responseData
                            .getJSONObject(JSON_AR_INFO)
                            .get(JSON_AR_LAST_PAYMENT).toString(), STRING);
                } else {
                    savePartyXRefP(party, PROPERTIES_AR_INFO_LAST_PAYMENT, null, STRING);
                }
            }

            // FEED
            if (responseData.getString(JSON_FEED) != null) {
                savePartyXRefP(party, PROPERTIES_FEED, responseData
                        .getString(JSON_FEED), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_FEED, null, STRING);
            }

            // ATTRIBUTES
            if (responseData.getString(JSON_ATTRIBUTES) != null) {
                savePartyXRefP(party, PROPERTIES_ATTRIBUTES, responseData
                        .getString(JSON_ATTRIBUTES), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_ATTRIBUTES, null, STRING);
            }

            // CRUD
            savePartyXRefP(party, PROPERTIES_CRUD, String
                    .valueOf(responseData.getInt(JSON_CRUD)), STRING);

            // CRUD_DESCRIPTION
            if (responseData.getString(JSON_CRUD_DESCRIPTION) != null) {
                savePartyXRefP(party, PROPERTIES_CRUD_DESCRIPTION, responseData
                        .getString(JSON_CRUD_DESCRIPTION), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_CRUD_DESCRIPTION, null, STRING);
            }
        }
    }

    /**
     * @param party
     * @param responseData
     * @return
     * @throws JSONException
     */
    private void savePartyXRefP(IParty party, String propertyName,
            String propertyValue, String type) {

        IPartyIdCrossReferenceProperty partyXRefP = DataFactory
                .createObject(IPartyIdCrossReferenceProperty.class);
        partyXRefP.setOrganizationId(party.getOrganizationId());
        partyXRefP.setPartyId(party.getPartyId());
        partyXRefP.setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);

        partyXRefP.setPropertyCode(propertyName);
        partyXRefP.setType(type);
        partyXRefP.setStringValue(propertyValue);

        DataFactory.makePersistent(partyXRefP);
    }

    /**
     * @param accountNumber
     * @param party
     */
    public void saveCustomerXRef(String accountNumber, IParty party) {

        // persist customer to CRM_PARTY_ID_XREF
        IPartyIdCrossReference partyXRef = DataFactory
                .createObject(IPartyIdCrossReference.class);
        partyXRef.setOrganizationId(party.getOrganizationId());
        partyXRef.setPartyId(party.getPartyId());
        partyXRef.setAlternateId(accountNumber);
        partyXRef.setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);

        DataFactory.makePersistent(partyXRef);
    }

    // Begin BZ23367
    public void saveCatCustLoyaltyAcc(String lookupResponse, IParty iParty,
            StationState stationState) {

        try {
            if (lookupResponse != null && iParty != null && !lookupResponse.isEmpty()) {
                JSONObject objectJson = new JSONObject(lookupResponse);
                if (!objectJson.isNull(JSON_MEMBERSHIPS) && objectJson
                        .getJSONArray(JSON_MEMBERSHIPS).length() > 0) {
                    JSONArray memberShips = objectJson
                            .getJSONArray(JSON_MEMBERSHIPS);

                    // Begin BZ24601
                    // remove all data
                    removeMembeshipHistoryData(iParty, memberShips);
                    // End BZ24601

                    // Begin BZ25434
                    IPartyIdCrossReferenceProperty referenceProperty = savePartyXRefPropertyMembershipAttr(iParty, memberShips);
                    if (referenceProperty != null) {
                        ((IDataModelImpl) referenceProperty).getDAO()
                                .setObjectState(DaoState.INSERT_OR_UPDATE
                                        .intVal());
                        bag.addObject(referenceProperty);
                    }
                    // End BZ25434

                    ICustomerAccount iCustomerAccount = null;
                    ICustomerLoyaltyCard customerLoyaltyCard = null;
                    ICustomerLoyaltyAccount loyaltyAccount = null;
                    ICustomerLoyaltyAccountProperty iCustomerLoyaltyAccountProperty,
                            iCustomerLoyaltyAccountProperty1,
                            iCustomerLoyaltyAccountProperty2;

                    int len = memberShips.length();
                    for (int i = 0; i < len; i++) {
                        //CAT_CUST_ACCT
                        iCustomerAccount = createCustomerAccount(iParty, stationState, memberShips
                                .getJSONObject(i)); // BZ24601
                        bag.addObject(iCustomerAccount);

                        //CAT_CUST_ACCT_CARD
                        customerLoyaltyCard = createCatCustAcctCard(iParty, stationState, memberShips
                                .getJSONObject(i)); // BZ24601
                        bag.addObject(customerLoyaltyCard);

                        // setSavedCustLoyaltyCard(customerLoyaltyCard); // BZ 24297

                        //CAT_CUST_LOYALTY_ACCT
                        loyaltyAccount = createCatCustLoyaltyAcct(objectJson, memberShips
                                .getJSONObject(i)); // BZ24601
                        loyaltyAccount.setAccountId(iCustomerAccount
                                .getCustAccountId());
                        bag.addObject(loyaltyAccount);

                        //Begin BZ24651
                        //CAT_CUST_LOYALTY_ACCT_P For typeDescription
                        iCustomerLoyaltyAccountProperty = createLoyaltyAccountPropertyTypeDes(memberShips
                                .getJSONObject(i), loyaltyAccount);
                        iCustomerLoyaltyAccountProperty
                                .setAccountId(iCustomerAccount
                                        .getCustAccountId());
                        bag.addObject(iCustomerLoyaltyAccountProperty);

                        //CAT_CUST_LOYALTY_ACCT_P for statusDescription
                        iCustomerLoyaltyAccountProperty1 = createLoyaltyAccountPropertyStatusDes(memberShips
                                .getJSONObject(i), loyaltyAccount); // BZ24601
                        iCustomerLoyaltyAccountProperty1
                                .setAccountId(iCustomerAccount
                                        .getCustAccountId());
                        bag.addObject(iCustomerLoyaltyAccountProperty1);

                        //CAT_CUST_LOYALTY_ACCT_P For isAutoRenew
                        iCustomerLoyaltyAccountProperty2 = createLoyaltyAccountProperty(memberShips
                                .getJSONObject(i), loyaltyAccount);// BZ24601
                        iCustomerLoyaltyAccountProperty2
                                .setAccountId(iCustomerAccount
                                        .getCustAccountId());
                        bag.addObject(iCustomerLoyaltyAccountProperty2);
                        //End BZ24651
                    }

                    // Persist to database
                    bag.persist();
                }
                //Begin BZ26471
                if (!objectJson.isNull(PRICING_ATTR)) {
                    JSONObject pricing = (JSONObject) objectJson
                            .get(PRICING_ATTR);

                    IPartyIdCrossReferenceProperty referenceProperty = savePartyXRefPropertyPricingAttr(iParty, pricing);
                    if (referenceProperty != null) {
                        ((IDataModelImpl) referenceProperty).getDAO()
                                .setObjectState(DaoState.INSERT_OR_UPDATE
                                        .intVal());
                        bag.addObject(referenceProperty);
                    }
                    // Persist to database
                    bag.persist();
                }
                //End BZ26471

                /* BEGIN BZ31982 */
                if (!objectJson.isNull(JSON_AR_INFO)) {
                    if (objectJson.get(JSON_AR_INFO) instanceof JSONObject) {
                        JSONObject arInfo = (JSONObject) objectJson.get(JSON_AR_INFO);
                        IPartyIdCrossReferenceProperty referencePropertyArInfo = savePartyXRefPropertyArInfoAttr(iParty, arInfo);
                        if (referencePropertyArInfo != null) {
                            ((IDataModelImpl) referencePropertyArInfo).getDAO()
                                    .setObjectState(DaoState.INSERT_OR_UPDATE.intVal());
                            bag.addObject(referencePropertyArInfo);
                        }
                        // Persist to database
                        bag.persist();
                    }
                }
                /* END BZ31982 */
            }
        } catch (Exception ex) {
            _logger.error("Can not parse json " + ex.getMessage());
        }
    }

    /**
     * @param iParty
     * @param memberShips
     * @throws JSONException
     */
    public void removeMembeshipHistoryData(IParty iParty, JSONArray memberShips)
            throws JSONException {

        int length = memberShips.length();
        for (int i = 0; i < length; i++) {
            if (!memberShips.getJSONObject(i).isNull(IDENTIFIER)) {
                removeCatCustLoyAcc(iParty, memberShips.getJSONObject(i)
                        .getString(IDENTIFIER));
                removeCatCustLoyAccP(iParty, memberShips.getJSONObject(i)
                        .getString(IDENTIFIER));
            }
        }

        removeCatCustAcctCard(iParty);
        removeCatCustAcctLocal(iParty);
        removeCatCustAcct(iParty);
    }

    //Begin BZ24651
    /**
     * @param memberShips
     * @param i
     * @param loyaltyAccount
     * @throws JSONException
     */
    public ICustomerLoyaltyAccountProperty createLoyaltyAccountPropertyTypeDes(
            JSONObject memberShips, ICustomerLoyaltyAccount loyaltyAccount)
            throws JSONException { // BZ24601

        ICustomerLoyaltyAccountProperty iCustomerLoyaltyAccountProperty = DataFactory
                .createObject(ICustomerLoyaltyAccountProperty.class);

        iCustomerLoyaltyAccountProperty
                .setAccountId(loyaltyAccount.getAccountId());
        iCustomerLoyaltyAccountProperty
                .setCardNumber(loyaltyAccount.getCardNumber());
        iCustomerLoyaltyAccountProperty
                .setOrganizationId(ConfigurationMgr.getOrganizationId());

        iCustomerLoyaltyAccountProperty.setPropertyCode(STATUS);
        iCustomerLoyaltyAccountProperty.setType(STRING);
        iCustomerLoyaltyAccountProperty
                .setStringValue(memberShips.getString(TYPE_DESCRIPTION));

        return iCustomerLoyaltyAccountProperty;
    }

    public ICustomerLoyaltyAccountProperty createLoyaltyAccountPropertyStatusDes(
            JSONObject memberShips, ICustomerLoyaltyAccount loyaltyAccount)
            throws JSONException { // BZ24601

        ICustomerLoyaltyAccountProperty iCustomerLoyaltyAccountProperty1 = DataFactory
                .createObject(ICustomerLoyaltyAccountProperty.class);
        iCustomerLoyaltyAccountProperty1
                .setAccountId(loyaltyAccount.getAccountId());
        iCustomerLoyaltyAccountProperty1
                .setCardNumber(loyaltyAccount.getCardNumber());
        iCustomerLoyaltyAccountProperty1
                .setOrganizationId(ConfigurationMgr.getOrganizationId());

        iCustomerLoyaltyAccountProperty1.setPropertyCode(STATUS_DESCRIPTION);
        iCustomerLoyaltyAccountProperty1.setType(STRING);
        iCustomerLoyaltyAccountProperty1
                .setStringValue(memberShips.getString(STATUS_DESCRIPTION));

        return iCustomerLoyaltyAccountProperty1;
    }

    public ICustomerLoyaltyAccountProperty createLoyaltyAccountProperty(
            JSONObject memberShips, ICustomerLoyaltyAccount loyaltyAccount)
            throws JSONException {// BZ24601

        ICustomerLoyaltyAccountProperty iCustomerLoyaltyAccountProperty2 = DataFactory
                .createObject(ICustomerLoyaltyAccountProperty.class);
        iCustomerLoyaltyAccountProperty2
                .setAccountId(loyaltyAccount.getAccountId());
        iCustomerLoyaltyAccountProperty2
                .setCardNumber(loyaltyAccount.getCardNumber());
        iCustomerLoyaltyAccountProperty2
                .setOrganizationId(ConfigurationMgr.getOrganizationId());

        iCustomerLoyaltyAccountProperty2.setPropertyCode(IS_AUTO_RENEW);
        iCustomerLoyaltyAccountProperty2.setType(STRING);
        iCustomerLoyaltyAccountProperty2
                .setStringValue(memberShips.getString(IS_AUTO_RENEW));

        return iCustomerLoyaltyAccountProperty2;
    }

    //End BZ24651
    /**
     * @param objectJson
     * @param memberShips
     * @param i
     * @return
     * @throws JSONException
     */
    public ICustomerLoyaltyAccount createCatCustLoyaltyAcct(
            JSONObject objectJson, JSONObject memberShips)
            throws JSONException {

        ICustomerLoyaltyAccount iCustomerLoyaltyAccount = DataFactory
                .createObject(ICustomerLoyaltyAccount.class); //BZ24601
        iCustomerLoyaltyAccount
                .setOrganizationId(ConfigurationMgr.getOrganizationId());

        // Begin BZ24607
        if (!objectJson.isNull(JSON_ACCOUNT_NUMBER)) {
            iCustomerLoyaltyAccount
                    .setAccountId(objectJson.getString(JSON_ACCOUNT_NUMBER));
        }

        if (!memberShips.isNull(IDENTIFIER)) {
            iCustomerLoyaltyAccount
                    .setCardNumber(memberShips.getString(IDENTIFIER));
        }

        iCustomerLoyaltyAccount
                .setOrganizationId(ConfigurationMgr.getOrganizationId());
        // End BZ24607

        if (memberShips.getString(JOIN_DATE) != null) {
            iCustomerLoyaltyAccount.setEffectiveDate(CawUtilFunction
                    .formatDateMMDDYYY(memberShips.getString(JOIN_DATE)));
        }

        if (memberShips.getString(EXPIRE_DATE) != null) {
            iCustomerLoyaltyAccount.setExpirationDate(CawUtilFunction
                    .formatDateMMDDYYY(memberShips.getString(EXPIRE_DATE)));
        }

        if (memberShips.getString(BENEFIT_LEVEL) != null) {
            iCustomerLoyaltyAccount.setLoyaltyProgramLevelId(memberShips
                    .getString(BENEFIT_LEVEL));
        }

        if (memberShips.getString(BENEFIT_LEVEL_NAME) != null) {
            iCustomerLoyaltyAccount.setLoyaltyProgramLevelName(memberShips
                    .getString(BENEFIT_LEVEL_NAME));
        }

        if (memberShips.getString(TYPE) != null) {
            iCustomerLoyaltyAccount
                    .setLoyaltyProgramId(memberShips.getString(TYPE));
        }

        if (memberShips.getString(TYPE_DESCRIPTION) != null) {
            iCustomerLoyaltyAccount.setLoyaltyProgramName(memberShips
                    .getString(TYPE_DESCRIPTION));
        }

        return iCustomerLoyaltyAccount;
    }

    /**
     * @param iParty
     * @param stationState
     * @param customerAccountId
     * @param acountId
     */
    // Begin BZ24601
    public ICustomerAccount createCustomerAccount(IParty iParty,
            StationState stationState, JSONObject memberShips)
            throws JSONException {

        ICustomerAccount customerAccount = DataFactory
                .createObject(ICustomerAccount.class);

        String acountId = SequenceFactory.getNextStringValue(GOOD_SAM_CLUB_SEQ);
        customerAccount.setCustAccountId(acountId);
        customerAccount.setCustAccountCode(LOYALTY);
        customerAccount.setOrganizationId(ConfigurationMgr.getOrganizationId());
        customerAccount.setRetailLocationId(stationState.getRetailLocationId());
        customerAccount.setParty(iParty);

        if (memberShips.has(EXPIRE_DATE) && !memberShips.isNull(EXPIRE_DATE)
                && memberShips.getString(EXPIRE_DATE) != null) {
            Date expireDate = CawUtilFunction
                    .formatDateMMDDYYY(memberShips.getString(EXPIRE_DATE));
            Date todayDate = new Date();
            if (expireDate.after(todayDate)) {
                customerAccount.setCustAccountStateCode(CLOSE);
            } else {
                customerAccount.setCustAccountStateCode(OPEN);
            }
        }

        customerAccount.setAccountBalance(new BigDecimal(0));
        customerAccount.setClassName(DTV_CLASS_NAME);
        customerAccount.setCustIdentityTypeCode(CUSTOMER);

        return customerAccount;
    }
    // End BZ24601

    /**
     * 
     * @param loyaltyQueryResult
     * @param iParty
     * @param stationState
     * @param memberShips
     * @return
     * @throws JSONException
     */
    // Begin BZ24601
    public ICustomerLoyaltyCard createCatCustAcctCard(IParty iParty,
            StationState stationState, JSONObject memberShips)
            throws JSONException {

        ICustomerLoyaltyCard customerLoyaltyCard = DataFactory
                .createObject(ICustomerLoyaltyCard.class);
        customerLoyaltyCard
                .setOrganizationId(ConfigurationMgr.getOrganizationId());

        customerLoyaltyCard.setPartyId(iParty.getPartyId());
        // Begin BZ24607
        if (!memberShips.isNull(IDENTIFIER)) {
            customerLoyaltyCard
                    .setCardNumber(memberShips.getString(IDENTIFIER));
        }

        if (!memberShips.isNull(JOIN_DATE)) {
            customerLoyaltyCard.setEffectiveDate(CawUtilFunction
                    .formatDateMMDDYYY(memberShips.getString(JOIN_DATE)));
        }

        if (!memberShips.isNull(EXPIRE_DATE)) {
            customerLoyaltyCard.setExpirationDate(CawUtilFunction
                    .formatDateMMDDYYY(memberShips.getString(EXPIRE_DATE)));
        }
        // End BZ24607

        return customerLoyaltyCard;
    }
    // End BZ23367/BZ24601

    //Begin BZ23417
    /**
     * Insert data to table CRM_CUSTOMER_AFFILIATION(Groups customer).
     * @param iParty
     * @param jsonResponse
     * @return
     */
    public ICustomerAffiliation createCustomerAffiliation(IParty iParty,
            String jsonResponse) {

        // Begin BZ24351
        // Remove group customer
        try {
            if (iParty != null) {
                // Begin BZ24601
                //Remove group customer on Xcenter
                Map<String, Object> params1 = new HashMap<>();
                params1.put(CawQueryConstants.ARG_PARTY_ID, iParty
                        .getPartyId());
                params1.put(CawQueryConstants.ARG_ORGANIZATION_ID, iParty
                        .getOrganizationId());

                CustomerAffiliationId customerAffiliationId = null;
                ICustomerAffiliation affiliation = null;
                IQueryResultList<CawCustomerGroupQueryResult> queryResult = DataFactory
                        .getObjectByQueryNoThrow(CAW_CUSTOMER_GROUP_PRICE_LOOKUP, params1);
                if (queryResult != null) {
                    for (CawCustomerGroupQueryResult customerGroup : queryResult) {
                        customerAffiliationId = new CustomerAffiliationId();
                        customerAffiliationId.setOrganizationId(ConfigurationMgr
                                .getOrganizationId());
                        customerAffiliationId.setPartyId(iParty.getPartyId());
                        if (customerGroup.getCustGroupId() != null) {
                            customerAffiliationId
                                    .setCustomerGroupId(customerGroup
                                            .getCustGroupId());

                            affiliation = DataFactory
                                    .getObjectByIdNoThrow(customerAffiliationId);
                            if (affiliation != null) {
                                ((IDataModelImpl) affiliation).getDAO()
                                        .setObjectState(DaoState.DELETED
                                                .intVal());
                                DataFactory
                                        .makePersistent(customerAffiliationId);
                            }
                        }
                    }
                }
                //End BZ24601

                //Remove group customer on local
                Map<String, Object> params2 = new HashMap<String, Object>();
                params2.put(CawQueryConstants.ARG_PARTY_ID, iParty
                        .getPartyId());
                QueryRequest removeRequest = new QueryRequest();
                removeRequest.setQueryKey(CAW_CUSTOMER_GROUP_REMOVE);
                removeRequest.setParams(params2);
                DataFactory.makePersistent(removeRequest);
            }
        } catch (Exception ex) {
            _logger.error("Can not delete customer group: " + ex.getMessage());
        }
        // End BZ24351
        ICustomerAffiliation iCustomerAffiliation = null;
        try {
            if (iParty != null && jsonResponse != null) {
                JSONObject jsonObject = new JSONObject(jsonResponse);
                if (!jsonObject.isNull(PRICING_ATTR)) {
                    int identifier = jsonObject.getJSONObject(PRICING_ATTR)
                            .getInt(IDENTIFIER);
                    // Begin BZ23637
                    String groupId = null;

                    if (CawCustomerGroupType.CLUB.getType() == identifier) {
                        groupId = CawCustomerGroupType.CLUB.getNewName();
                    } else if (CawCustomerGroupType.RETL
                            .getType() == identifier) {
                        groupId = CawCustomerGroupType.RETL.getNewName();
                    } else if (CawCustomerGroupType.CREW
                            .getType() == identifier) {
                        groupId = CawCustomerGroupType.CREW.getNewName();
                    } else if (CawCustomerGroupType.WHSL
                            .getType() == identifier) {
                        groupId = CawCustomerGroupType.WHSL.getNewName();
                    }
                    // End BZ23637
                    if (groupId != null) {
                        CustomerAffiliationId customerAffiliationId = new CustomerAffiliationId();
                        customerAffiliationId.setOrganizationId(ConfigurationMgr
                                .getOrganizationId());
                        customerAffiliationId.setPartyId(iParty.getPartyId());
                        customerAffiliationId.setCustomerGroupId(groupId); //BZ23637

                        iCustomerAffiliation = DataFactory
                                .getObjectByIdNoThrow(customerAffiliationId);
                        if (iCustomerAffiliation == null) {
                            iCustomerAffiliation = DataFactory
                                    .createObject(ICustomerAffiliation.class);
                            iCustomerAffiliation
                                    .setObjectId(customerAffiliationId);
                            iCustomerAffiliation
                                    .setOrganizationId(ConfigurationMgr
                                            .getOrganizationId());
                        }
                        /* BEGIN BZ28549 */
                        /*Create a clone object then save it to DB*/
                        ICustomerAffiliation iCustomerAffiliationClone = DataFactory
                                .createObject(ICustomerAffiliation.class);
                        iCustomerAffiliationClone.setOrganizationId(iCustomerAffiliation.getOrganizationId());
                        iCustomerAffiliationClone.setPartyId(iCustomerAffiliation.getPartyId());
                        iCustomerAffiliationClone.setCustomerGroupId(iCustomerAffiliation.getCustomerGroupId());
                        DataFactory.makePersistent(iCustomerAffiliationClone);
                        //
                        bag.addObject(iCustomerAffiliationClone);
                        /* END BZ28549 */
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Can not create CustomerAffiliation."
                    + ex.getMessage());
        }

        return iCustomerAffiliation;
    }
    //End BZ23417

    //Begin BZ23477
    /**
     * 
     * @param iParty
     * @param accountNumber
     * @return
     */
    public String buildUpsertRequest(IParty iParty, Long accountNumber) {

        String upsertRequest = null;
        if (iParty != null) {
            CawCustomerTemplate custTemplate = changeCawCustomerTemplate(iParty);
            custTemplate.setAccountNumber(accountNumber);
            try {

                CawRestConfig request = CawRestConfigHelper.getInstance()
                        .getRestRequest(CawEBSConstant.CUSTOMER_UPSERT);
                String body = request.getBody();

                Integer storeId = Integer.parseInt(System
                        .getProperty(CommonConstants.RETAIL_LOCATION_ID));
                body = body.replace(SALES_CHANNEL, CawUtilFunction
                        .formatParameter(storeId.toString()));
                body = body.replace(CHANNEL_TYPE_ATTR, "4"); // BZ23591
                body = body.replace(NAME_AUDIT, CawUtilFunction
                        .formatParameter(custTemplate.getName().getAudit()));
                body = body.replace(NAME_PREFIX, CawUtilFunction
                        .formatParameter(custTemplate.getName().getPrefix()));
                body = body.replace(NAME_FIRST, CawUtilFunction
                        .formatParameter(custTemplate.getName().getFirst()));
                body = body.replace(NAME_MIDDLE, CawUtilFunction
                        .formatParameter(custTemplate.getName().getMiddle()));
                body = body.replace(NAME_LAST, CawUtilFunction
                        .formatParameter(custTemplate.getName().getLast()));
                body = body.replace(NAME_SUFFIX, CawUtilFunction
                        .formatParameter(custTemplate.getName().getSuffix()));
                body = body.replace(NAME_COMPANY, CawUtilFunction
                        .formatParameter(custTemplate.getName().getCompany()));

                body = body.replace(ADDRESS_AUDIT, CawUtilFunction
                        .formatParameter(custTemplate.getAddress().getAudit()));
                /* BEGIN BZ53048 */
                body = body.replace(ADDRESS_ADDRESS_TYPE, custTemplate.getAddress().getAddressType());
                /* END BZ53048 */
                body = body.replace(ADDRESS_TYPE_DESCRIPTION, CawUtilFunction
                        .formatParameter(custTemplate.getAddress()
                                .getAddressTypeDescription()));
                body = body.replace(ADDRESS_IS_DELIVERABLE, custTemplate
                        .getAddress().getIsDeliverable() == true
                                ? Boolean.TRUE.toString()
                                : Boolean.FALSE.toString());
                body = body.replace(ADDRESS_LINE1, CawUtilFunction
                        .formatParameter(custTemplate.getAddress().getLine1()));
                body = body.replace(ADDRESS_LINE2, CawUtilFunction
                        .formatParameter(custTemplate.getAddress().getLine2()));
                body = body.replace(ADDRESS_LINE3, CawUtilFunction
                        .formatParameter(custTemplate.getAddress().getLine3()));
                body = body.replace(ADDRESS_LINE4, CawUtilFunction
                        .formatParameter(custTemplate.getAddress().getLine4()));
                body = body.replace(ADDRESS_CITY, CawUtilFunction
                        .formatParameter(custTemplate.getAddress().getCity()));
                body = body.replace(ADDRESS_STATE_PROVINCE, CawUtilFunction
                        .formatParameter(custTemplate.getAddress()
                                .getStateProvince()));
                body = body.replace(ADDRESS_POSTAL_CODE, CawUtilFunction
                        .formatParameter(custTemplate.getAddress()
                                .getPostalCode()));
                body = body.replace(ADDRESS_COUNTRY, CawUtilFunction
                        .formatParameter(custTemplate.getAddress()
                                .getCountry()));
                body = body.replace(ADDRESS_COUNTY, CawUtilFunction
                        .formatParameter(custTemplate.getAddress()
                                .getCounty()));

                body = body.replace(MEMBERSHIPS, NULL);
                if (!custTemplate.getPhones().isEmpty()) {
                    body = body.replace(PHONES, custTemplate.getPhones());
                } else {
                    body = body.replace(PHONES, NULL);
                }
                body = body.replace(PARTNERS, NULL);
                body = body.replace(PRICING, NULL);
                body = body.replace(ACCOUNT_NUMBER, custTemplate
                        .getAccountNumber().toString());
                body = body.replace(ACCOUNT_STATUS, custTemplate
                        .getAccountStatus().toString());
                body = body.replace(ACCOUNT_STATUS_DESCRIPTION, CawUtilFunction
                        .formatParameter(custTemplate
                                .getAccountStatusDescription()));
                body = body.replace(CUSTOMER_TYPE, custTemplate
                        .getCustomerType().toString());
                body = body.replace(RV_TYPE, custTemplate.getRvType() != null
                        ? custTemplate.getRvType().toString()
                        : NULL);
                body = body.replace(ACXIOMIDENTIFIERS, NULL);
                body = body.replace(ALLOWEDIT, Boolean.TRUE.toString());
                body = body.replace(EMAIL_ADDRESS, CawUtilFunction
                        .formatParameter(custTemplate.getEmailAddress()));

                body = body
                        .replace(RV_TYPE, custTemplate.getRvType().toString());
                body = body.replace(RV_TYPE_DESCRIPTION, CawUtilFunction
                        .formatParameter(custTemplate.getRvTypeDescription()));
                body = body.replace(IS_TAXEXEMPT, Boolean.FALSE.toString());
                body = body.replace(TAX_CERTIFICATE, NULL);
                body = body.replace(AR_INFO, NULL);
                body = body.replace(LAST_UPDATE_USER, CawUtilFunction
                        .formatParameter(custTemplate.getLastUpdateUser()));
                body = body.replace(LAST_UPDATE_SYSTEM, CawUtilFunction
                        .formatParameter(custTemplate.getLastUpdateSystem()));
                body = body.replace(LAST_UPDATE_DATE, CawUtilFunction
                        .formatParameter(custTemplate.getLastUpdateDate()));
                body = body.replace(FEED, CawUtilFunction
                        .formatParameter(custTemplate.getFeed()));
                /* BEGIN BZ28985 */
                if (accountNumber == 0) {
                    body = body.replace(CRUD, String.valueOf(CawCustomerCrud.CREATED.getValue())); //BZ54290
                } else if (accountNumber > 0) {
                    body = body.replace(CRUD, String.valueOf(CawCustomerCrud.UPDATED.getValue())); //BZ54290
                } else {
                    body = body.replace(CRUD, String.valueOf(CawCustomerCrud.NOT_SPECIFIED.getValue())); //BZ54290
                }
                /* END BZ28985 */
                body = body.replace(CRUD_DESCRIPTION, CawUtilFunction
                        .formatParameter(custTemplate.getCrudDescription()));
                body = body.replace(ATTRIBUTES, CawUtilFunction
                        .formatParameter(custTemplate.getAttributes()));

                upsertRequest = body;
            } catch (Exception httpClientErrorException) {
                _logger.debug("The customer can not be sent to EBS: "
                        + httpClientErrorException);
            }

        }
        return upsertRequest;
    }

    /**
     * Store request to database when ESB offline
     * @param iParty
     * @param request
     * @return
     */
    public IPartyProperty processCustomerOffline(IParty iParty,
            String request) {
        //BEGIN BZ48564: HDE WHEN SAVE CHANGES
        IPartyProperty iPartyProperty = null;
        if (iParty != null) {
            PartyPropertyId partyPropertyId = new PartyPropertyId();
            partyPropertyId
                    .setOrganizationId(ConfigurationMgr.getOrganizationId());
            partyPropertyId.setPartyId(iParty.getPartyId());
            partyPropertyId.setPropertyCode(CawConstants.ESB_QUEUE_ONLINE_STATUS);
            iPartyProperty = DataFactory.getObjectByIdNoThrow(partyPropertyId);

            if (iPartyProperty == null) {
                iPartyProperty = DataFactory.createObject(IPartyProperty.class);
            }
            iPartyProperty.setType(CawConstants.PROP_STRING_TYPE);
            if (request.length() < 4000) {
                partyPropertyId.setPropertyCode(CawConstants.ESB_QUEUE_ONLINE_STATUS);
                iPartyProperty.setStringValue(request);
                iPartyProperty.setObjectId(partyPropertyId);
                iPartyProperty = DataFactory.makePersistent(iPartyProperty);
            } else {
                for(int i = 0 ; i <2 ; i++) {
                    if(i==0) {
                        partyPropertyId.setPropertyCode(CawConstants.ESB_QUEUE_ONLINE_STATUS);
                        iPartyProperty.setStringValue(request.substring(0, 3999));
                        iPartyProperty.setObjectId(partyPropertyId);
                        iPartyProperty = DataFactory.makePersistent(iPartyProperty);
                    } else {
                        partyPropertyId.setPropertyCode(CawConstants.ESB_QUEUE_ONLINE_STATUS_2);
                        iPartyProperty.setStringValue(request.substring(4000));
                        iPartyProperty.setObjectId(partyPropertyId);
                        iPartyProperty = DataFactory.makePersistent(iPartyProperty);
                    }
                }
            }
        }
       //END BZ48564: HDE WHEN SAVE CHANGES
        return iPartyProperty;
    }

    //End BZ23477
    // BZ23958
    public List<ICustomerLoyaltyCard> getCustomerCards(IParty iParty) {

        List<ICustomerLoyaltyCard> result = new ArrayList<ICustomerLoyaltyCard>();
        List<ICustomerLoyaltyAccount> acctLoyaltyLst = new ArrayList<ICustomerLoyaltyAccount>();

        Map<String, Object> params = new HashMap<>();
        params.put(CawQueryConstants.ARG_ORGANIZATION_ID, iParty
                .getOrganizationId());
        params.put(CawQueryConstants.ARG_PARTY_ID, iParty.getPartyId());

        List<CawCustomerCardQueryResult> cardLst = DataFactory
                .getObjectByQueryNoThrow(CawQueryConstants.CRM_CUSTOMER_CARD_LOOKUP, params);

        if (cardLst != null && cardLst.size() > 0) {
            Map<String, Object> paramsLoyaltyAccts = new HashMap<>();
            paramsLoyaltyAccts
                    .put(CawQueryConstants.ARG_PARTY_ID, iParty.getPartyId());
            ICustomerLoyaltyCard loyCard = null;
            ICustomerLoyaltyAccount loyAcount = null;
            List<CawCustomerLoyaltyQueryResult> acctLst = null;
            CustomerLoyaltyAccountId customerLoyaltyAccountId = null;
            for (CawCustomerCardQueryResult cawCustomerCardQueryResult : cardLst) {
                paramsLoyaltyAccts
                        .put(CawQueryConstants.ARG_CUST_CARD_NUMBER, cawCustomerCardQueryResult
                                .getCustCardNumber());
                loyCard = DataFactory.createObject(ICustomerLoyaltyCard.class);
                loyCard.setOrganizationId(cawCustomerCardQueryResult
                        .getOrganizationId());
                loyCard.setPartyId(cawCustomerCardQueryResult.getPartyId());
                loyCard.setCardNumber(cawCustomerCardQueryResult
                        .getCustCardNumber());
                loyCard.setExpirationDate(cawCustomerCardQueryResult
                        .getExpireDate());

                acctLst = DataFactory
                        .getObjectByQueryNoThrow(CawQueryConstants.CRM_CUSTOMER_LOYALTY_EBS_LOOKUP, paramsLoyaltyAccts);
                if (acctLst != null && acctLst.size() > 0) {
                    for (CawCustomerLoyaltyQueryResult cawCustomerLoyaltyQueryResult : acctLst) {
                        customerLoyaltyAccountId = new CustomerLoyaltyAccountId();
                        customerLoyaltyAccountId
                                .setAccountId(cawCustomerLoyaltyQueryResult
                                        .getCustAcctId());
                        customerLoyaltyAccountId
                                .setCardNumber(cawCustomerLoyaltyQueryResult
                                        .getCustCardNbr());
                        customerLoyaltyAccountId
                                .setOrganizationId(cawCustomerLoyaltyQueryResult
                                        .getOrganizationId());
                        loyAcount = DataFactory
                                .getObjectByIdNoThrow(customerLoyaltyAccountId);

                        acctLoyaltyLst.add(loyAcount);
                    }
                    loyCard.setLoyaltyAccounts(acctLoyaltyLst);
                }
                result.add(loyCard);
            }
        }
        return result;
    }
    // End BZ23958

    // Begin BZ24498
    /**
     * The function build Customer Json when Webservice offline.
     * @param iParty
     * @return
     */
    public String buildCustomerJsonObjectOffline(IParty iParty) {

        String jsonCustomerBuf = null;
        if (iParty != null) {
            try {
                Long accountNumber = 0L;
                if (iParty.getAlternatePartyIds() != null
                        && iParty.getAlternatePartyIds().size() > 0) {
                    if (iParty.getAlternatePartyIds().get(0)
                            .getAlternateId() != null)
                        accountNumber = Long.valueOf(CawJSONUtils
                                .vLong(iParty.getAlternatePartyIds().get(0)
                                        .getAlternateId()));
                }

                String upsertRequest = buildUpsertRequest(iParty, accountNumber);
                // Begin BZ26398
                JSONObject customerJson = new JSONObject(upsertRequest);
                if (!customerJson.isNull(THE_CUSTOMER_ATTR)) {
                    customerJson = customerJson
                            .getJSONObject(THE_CUSTOMER_ATTR);
                }

                // When ESB offline, The membership and price will get from DB
                Map<String, Object> params = new HashMap<String, Object>();
                params.put(CawQueryConstants.ARG_ORGANIZATION_ID, iParty
                        .getOrganizationId());
                params.put(CawQueryConstants.ARG_PARTY_ID, iParty.getPartyId());
                List<CawPartyIdXrefQueryResult> xrefResults = DataFactory
                        .getObjectByQueryNoThrow(CAW_CUSTOMER_PARTY_ID_XREF, params);

                if (xrefResults != null && xrefResults.size() > 0) {
                    // Get value of CRM_PARTY_ID_XREF_P.PROPERTY_CODE=MEMBERSHIPS
                    String membershipInfo = getValueOfPartyIdXrefByPropertyCode(JSON_MEMBERSHIPS, xrefResults);
                    JSONArray membershipJsonArray = CawJSONUtils
                            .toJSONArray(membershipInfo);
                    if (membershipJsonArray != null) {
                        customerJson.put(JSON_MEMBERSHIPS, membershipJsonArray);
                    }

                    // Get value of CRM_PARTY_ID_XREF_P.PROPERTY_CODE=PRICING
                    String pricingInfo = getValueOfPartyIdXrefByPropertyCode(PRICING_ATTR, xrefResults);
                    JSONObject pricingJSONObject = CawJSONUtils
                            .toJSONObject(pricingInfo);
                    if (pricingJSONObject != null) {
                        customerJson.put(PRICING_ATTR, pricingJSONObject);
                    }
                }
                jsonCustomerBuf = customerJson.toString();
                // End  BZ26398
                //Start BZ58973
                CawCustomerLoyaltyFlag cawCustomerLoyaltyFlag = new CawCustomerLoyaltyFlag();
                cawCustomerLoyaltyFlag.getAndSetCustomerLoyaltyFlagFromDB(iParty);
                //End BZ58973
            } catch (JSONException ex) {
                _logger.error("Can not build Custom JSON in case EBS offline."
                        + ex.getMessage());
            }

        }
        return jsonCustomerBuf;
    }

    // End BZ24498

    /**
     * @return the savedCustLoyaltyCard
     */
    public ICustomerLoyaltyCard getSavedCustLoyaltyCard() {

        return savedCustLoyaltyCard;
    }

    /**
     * @param argSavedCustLoyaltyCard the savedCustLoyaltyCard to set
     */
    public void setSavedCustLoyaltyCard(
            ICustomerLoyaltyCard argSavedCustLoyaltyCard) {

        savedCustLoyaltyCard = argSavedCustLoyaltyCard;
    }

    // Begin BZ24601
    public void removeCatCustLoyAccP(IParty party, String cardNbr) {

        // Remove group customer
        try {
            if (party != null) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put(CawQueryConstants.ARG_ORGANIZATION_ID, party
                        .getOrganizationId());
                params.put(CawQueryConstants.ARG_CARD_NUMBER, cardNbr);
                QueryRequest removeRequest = new QueryRequest();
                removeRequest.setQueryKey(CAW_CAT_CUST_LOYALTY_ACCT_P_REMOVE);
                removeRequest.setParams(params);
                DataFactory.makePersistent(removeRequest);
            }
        } catch (Exception ex) {
            _logger.error("Can not delete Cat Cust Loy Acc Properties: "
                    + ex.getMessage());
        }
    }

    public void removeCatCustLoyAcc(IParty party, String cardNbr) {

        // Remove group customer
        try {
            if (party != null) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put(CawQueryConstants.ARG_ORGANIZATION_ID, party
                        .getOrganizationId());
                params.put(CawQueryConstants.ARG_CARD_NUMBER, cardNbr);
                QueryRequest removeRequest = new QueryRequest();
                removeRequest.setQueryKey(CAW_CAT_CUST_LOYALTY_ACCT_REMOVE);
                removeRequest.setParams(params);
                DataFactory.makePersistent(removeRequest);
            }
        } catch (Exception ex) {
            _logger.error("Can not delete Cat Cust Loy Acct: "
                    + ex.getMessage());
        }
    }

    public void removeCatCustAcctCard(IParty party) {

        // Remove group customer
        try {
            if (party != null) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put(CawQueryConstants.ARG_ORGANIZATION_ID, party
                        .getOrganizationId());
                params.put(CawQueryConstants.ARG_PARTY_ID, party.getPartyId());
                QueryRequest removeRequest = new QueryRequest();
                removeRequest.setQueryKey(CAW_CAT_CUST_CARD_ACCT_REMOVE);
                removeRequest.setParams(params);
                DataFactory.makePersistent(removeRequest);
            }
        } catch (Exception ex) {
            _logger.error("Can not delete Cat Cust Loy Acct: "
                    + ex.getMessage());
        }
    }

    public void removeCatCustAcct(IParty party) {

        // Remove group customer
        try {
            if (party != null) {
                Map<String, Object> params = new HashMap<>();

                params.put(CawQueryConstants.ARG_PARTY_ID, party.getPartyId());
                IQueryResultList<CawCustomerLoyaltyQueryResult> queryResult = DataFactory
                        .getObjectByQueryNoThrow(CawQueryConstants.CRM_CUSTOMER_LOYALTY_LOOKUP, params);
                if (queryResult != null) {
                    CustomerAccountId customerAccountId = null;
                    ICustomerAccount icustomerAccount = null;
                    for (CawCustomerLoyaltyQueryResult cawCustomerLoyaltyQueryResult : queryResult) {
                        customerAccountId = new CustomerAccountId();
                        customerAccountId
                                .setCustAccountCode(cawCustomerLoyaltyQueryResult
                                        .getCustAcctCode());
                        customerAccountId
                                .setCustAccountId(cawCustomerLoyaltyQueryResult
                                        .getCustAcctId());
                        customerAccountId
                                .setOrganizationId(cawCustomerLoyaltyQueryResult
                                        .getOrganizationId());

                        icustomerAccount = DataFactory
                                .getObjectById(customerAccountId);
                        //BZ26207, BZ26289 work order session: add exception to not delete work order and house account payment account
                        if (icustomerAccount != null
                                && icustomerAccount.getCustAccountCode() != null
                                && !icustomerAccount.getCustAccountCode()
                                        .equals(WORK_ORDER)
                                && !icustomerAccount.getCustAccountCode()
                                        .equals(HOUSE_ACCOUNT)) {
                            ((IDataModelImpl) icustomerAccount).getDAO()
                                    .setObjectState(DaoState.DELETED.intVal());
                            DataFactory.makePersistent(icustomerAccount);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Can not delete Cat Cust Loy Acct: "
                    + ex.getMessage());
        }
    }

    public void removeCatCustAcctLocal(IParty party) {

        // Remove group customer
        try {
            if (party != null) {
                Map<String, Object> params = new HashMap<String, Object>();

                params.put(CawQueryConstants.ARG_ORGANIZATION_ID, party
                        .getOrganizationId());
                params.put(CawQueryConstants.ARG_PARTY_ID, party.getPartyId());
                QueryRequest removeRequest = new QueryRequest();
                removeRequest.setQueryKey(CAW_CAT_CUST_ACCT_REMOVE);
                removeRequest.setParams(params);
                DataFactory.makePersistent(removeRequest);
            }
        } catch (Exception ex) {
            _logger.error("Can not delete Cat Cust Loy Acct: "
                    + ex.getMessage());
        }
    }
    // End BZ24601

    /**
     * 
     * @param argFields
     * @return
     */
    private String buildRequestOfCustomerSearch(
            Collection<IKeyedValue<String, ?>> argFields) {

        String body = null;
        try {
            String lastName = null;
            String firstName = null;
            String city = null;
            String state = null;
            String postalCode = null;
            String memberID = null;
            String accountNumber = null;
            String phoneNumber = null;
            String organizationName = null;
            String emailAddress = null;
            String address1 = null;
            String country = null; // BZ23270

            for (IKeyedValue<String, ?> it : argFields) {
                if (CustomerSearchModel.LAST_NAME_FIELD.equals(it.getKey())) {
                    lastName = (String) it.getValue();
                } else if (CustomerSearchModel.FIRST_NAME_FIELD
                        .equals(it.getKey())) {
                    firstName = (String) it.getValue();
                } else if (IHasAddressFields.CITY_FIELD.equals(it.getKey())) {
                    city = (String) it.getValue();
                } else if (IHasAddressFields.STATE_FIELD.equals(it.getKey())) {
                    state = (String) it.getValue();
                } else if (IHasAddressFields.POSTAL_CODE_FIELD
                        .equals(it.getKey())) {
                    postalCode = (String) it.getValue();
                } else if (CustomerSearchModel.PHONE_FIELD
                        .equals(it.getKey())) {
                    phoneNumber = (String) it.getValue();
                } else if (CustomerSearchModel.LOYALTY_NUMBER_FIELD
                        .equals(it.getKey())) {
                    memberID = (String) it.getValue();
                } else if (CustomerSearchModel.CUSTOMER_NUMBER_FIELD
                        .equals(it.getKey())) {
                    accountNumber = (String) it.getValue();
                } else if (CustomerSearchModel.EMAIL_FIELD
                        .equals(it.getKey())) {
                    emailAddress = (String) it.getValue();
                } else if (CawEBSConstant.ORGANIZATION_NAME_FIELD
                        .equals(it.getKey())) {
                    organizationName = (String) it.getValue();
                } else if (IHasAddressFields.ADDRESS1_FIELD
                        .equals(it.getKey())) {
                    address1 = (String) it.getValue();
                } else if (IHasAddressFields.COUNTRY_FIELD
                        .equals(it.getKey())) {
                    country = (String) it.getValue(); // BZ23270
                }
            }

            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawEBSConstant.CUSTOMER_SEARCH);
            body = request.getBody();
            body = body.replace(LAST_NAME, CawUtilFunction
                    .formatParameter(lastName));
            body = body.replace(FIRST_NAME, CawUtilFunction
                    .formatParameter(firstName));
            body = body.replace(CITY, CawUtilFunction.formatParameter(city));
            body = body.replace(STATE, CawUtilFunction.formatParameter(state));
            body = body
                    .replace(COUNTRY, CawUtilFunction.formatParameter(country)); //BZ23270
            body = body.replace(POSTAL_CODE, CawUtilFunction
                    .formatParameter(postalCode));
            body = body.replace(EMAIL_ADDRESS, CawUtilFunction
                    .formatParameter(emailAddress));
            body = body.replace(COMPANY_NAME, CawUtilFunction
                    .formatParameter(organizationName));
            body = body.replace(ADDRESS, CawUtilFunction
                    .formatParameter(address1));
            /* Begin BZ23168 and BZ23197*/
            if (phoneNumber != null) {
                body = body.replace(PHONE_NUMBER, CawUtilFunction
                        .formatParameter(phoneNumber)
                        .replaceAll("-", SPACE_CHARACTER));
            } else {
                body = body.replace(PHONE_NUMBER, NULL);
            }
            /* End BZ23168 and BZ23197 */
            body = body.replace(MEMBER_ID, CawUtilFunction
                    .formatParameter(memberID));
            body = body.replace(ACCOUNT_NUMBER, String
                    .valueOf(CawUtilFunction.vLong(accountNumber)));
            body = body.replace(LIMIT_RESULT, getMaxNumberOfCustomers()
                    .toString());
        } catch (Exception ex) {
            _logger.error("buildRequestOfCustomerSearch: " + ex.getMessage());
        }
        return body;
    }

    /**
     * Review code of BZ25358
     * @param jsonMessage
     * @return
     */
    private List<CawCustomerQueryResult> parseResponseOfCustomerSearch(
            String jsonMessage) {

        List<CawCustomerQueryResult> customerQueryResults = new ArrayList<CawCustomerQueryResult>();
        String tmp = null;
        try {
            JSONObject objects = new JSONObject(jsonMessage);
            JSONArray customerList = CawJSONUtils
                    .getJSONArray(objects, CawEBSConstant.CUSTOMERS);
            if (customerList != null) {
                int nFound = customerList.length();
                
                List<JSONObject> lstMembership = null;
                CawCustomerQueryResult customer = null;
                JSONObject curJsonCustomer = null;
                JSONObject name, address, obj;
                JSONArray memberShips = null;
                String companyName, first, last;
                for (int i = 0; i < nFound; i++) {
                    customer = new CawCustomerQueryResult();
                    curJsonCustomer = customerList.getJSONObject(i);
                    customer.setDataSource(CawEBSConstant.EBS_DATASOURCE);
                    customer.setOrganizationId(CawEBSConstant.ORGANIZATION_ID);
                    tmp = curJsonCustomer.getString(JSON_ACCOUNT_NUMBER);
                    customer.setId(Long.valueOf(CawJSONUtils.vLong(tmp)));
                    customer.setCustomerId(tmp);
                    customer.setAccountNumber(tmp);
                    customer.setLocationCode(CawPropertyUtils.STORE_NUMBER);/*BZ27535*/

                    name = curJsonCustomer.getJSONObject(JSON_NAME);
                    customer.setFirstName(name.getString(JSON_FIRST_NAME));
                    customer.setLastName(name.getString(JSON_LAST_NAME));

                    address = CawJSONUtils
                            .getJSONObject(curJsonCustomer, JSON_ADDRESS);
                    if (address != null) {
                        customer.setAddress(address.getString(JSON_LINE1));
                        customer.setAddress2(address.getString(JSON_LINE2));
                        customer.setCity(address.getString(JSON_CITY));
                        customer.setState(address.getString(JSON_STATE));
                        customer.setPostalCode(address
                                .getString(JSON_POSTAL_CODE));
                        customer.setCounty(address.getString(JSON_COUNTY));
                        if (CawEBSConstant.USA
                                .equals(address.getString(JSON_COUNTRY))) {
                            customer.setCountry(CawEBSConstant.US);
                        } else {
                            customer.setCountry(address
                                    .getString(JSON_COUNTRY));
                        }
                    }

                    // Begin BZ23268
                    companyName = name.getString(JSON_COMPANY);
                    if (StringUtils.isNotEmpty(companyName)) {
                        customer.setOrganizationName(companyName);
                        if (companyName.split(" ").length > 1) {
                            first = companyName
                                    .substring(0, companyName.lastIndexOf(" "));
                            last = companyName
                                    .substring(companyName.lastIndexOf(" ")
                                            + 1);
                            customer.setFirstName(first);
                            customer.setLastName(last);
                        } else {
                            customer.setFirstName("");
                            customer.setLastName(companyName);
                        }
                    }
                    // End BZ23268

                    // Begin BZ23951
                    // set memberships
                    try {
                        memberShips = CawJSONUtils
                                .getJSONArray(curJsonCustomer, JSON_MEMBERSHIPS);
                        if (memberShips != null && memberShips.length() > 0) {
                            lstMembership = new ArrayList<JSONObject>();
                            int len = memberShips.length();
                            for (int j = 0; j < len; j++) {
                                obj = memberShips.getJSONObject(j);
                                lstMembership.add(obj);
                            }
                            customer.setMembershipLst(lstMembership);
                        }
                    } catch (Exception ex) {
                        _logger.error("parseResponseOfCustomerSearch-0: "
                                + ex.getMessage());
                    }
                    // End BZ23951
                    customerQueryResults.add(customer);
                }
            }
        } catch (Exception ex) {
            _logger.error("parseResponseOfCustomerSearch: " + ex.getMessage());
            customerQueryResults = null;
        }
        return customerQueryResults;
    }

    // Begin BZ25434
    
    /*BEGIN BZ28036*/
    /**
     * Search detail customer history.
     * @param purchaseResponse list history of customer.
     * @param accountNumber is account number.
     * @return
     */
    public List<CustomerTransHistoryResult> searchCustomerPurchaseDetailFromEBS(
            Map<String, Date> purchaseResponse, String accountNumber) {

        /*
         * get detail Customer Purchase history
         */
        List<CustomerTransHistoryResult> customerTransHistoryResult = new ArrayList<CustomerTransHistoryResult>();
        List<CustomerTransHistoryResult> customerTransHistoryDetail = new ArrayList<CustomerTransHistoryResult>();
        for (Iterator<Entry<String, Date>> trans = purchaseResponse.entrySet().iterator(); trans
                .hasNext();) {
            Map.Entry<String, Date> tran =  trans.next();
            String body = this
                    .buildRequestOfPurchaseHistoryDetail(accountNumber, tran.getKey());
            ResponseEntity<String> result = CawEBSHelper.getInstance()
                    .searchDetailHistoryToEBS(body);
            if (result != null) {
                if (result.getStatusCode() == HttpStatus.OK) {
                    customerTransHistoryDetail = this
                            .parseResponseOfCustomerPurchaseDetail(result
                                    .getBody(),tran.getValue());
                    customerTransHistoryResult
                            .addAll(customerTransHistoryDetail);
                }
            }
        }
        return customerTransHistoryResult;
    }

    /**
     * Convert Customer Purchase Detail respond to list CustomerTransHistoryResult.
     * @param purchaseResponse
     * @return
     */
    private List<CustomerTransHistoryResult> parseResponseOfCustomerPurchaseDetail(
            String purchaseResponse, Date transactionDate) {

        CustomerTransHistoryResult customerPurchase = null;
        List<CustomerTransHistoryResult> customerTransHistoryResult = new ArrayList<CustomerTransHistoryResult>();
        try {
            JSONObject objects = new JSONObject(purchaseResponse)
                    .getJSONObject(CawEBSConstant.ORDER);
            JSONArray items = CawJSONUtils
                    .getJSONArray(objects, CawEBSConstant.ITEMS);
            String retailLocationId = objects
                    .getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR)
                    .getString(CawEBSConstant.SALES_CHANNEL_ID_ATTR);
            long transSeq = objects
                    .getLong(CawEBSConstant.SALES_CHANNEL_ID_ATTR);
            String workstationId = objects
                    .getJSONObject(CawEBSConstant.SALES_CHANNEL_ATTR)
                    .getString(CawEBSConstant.TERMINAL);
            boolean returnFlag = false;
            BigDecimal itemPrice = null;
            String itemId = null;
            String attrDescription = null;
            if (items != null) {
                for (int i = 0; i < items.length(); i++) {
                    itemId = items.getJSONObject(i)
                            .getString(CawEBSConstant.CODE);
                    attrDescription = items.getJSONObject(i)
                            .getJSONObject(CawEBSConstant.ATTRIBUTES)
                            .getString(CawEBSConstant.DESCRIPTION_ATTR);
                    if (StringUtils.isNotEmpty(itemId)
                            || (StringUtils.isEmpty(itemId)
                                    && attrDescription.matches(".*(TAX).*"))) {
                        customerPurchase = new CustomerTransHistoryResult();
                        itemPrice = new BigDecimal(items.getJSONObject(i)
                                .getString(CawEBSConstant.LINETOTAL));
                        customerPurchase
                                .setDataSource(CawEBSConstant.EBS_DATASOURCE);
                        customerPurchase.setItemDescription(items
                                .getJSONObject(i)
                                .getJSONObject(CawEBSConstant.ATTRIBUTES)
                                .getString(CawEBSConstant.DESCRIPTION_ATTR));
                        customerPurchase.setItemId(items.getJSONObject(i)
                                .getString(CawEBSConstant.CODE));
                        customerPurchase.setPrice(itemPrice);
                        customerPurchase
                                .setQty(new BigDecimal(items.getJSONObject(i)
                                        .getInt(CawEBSConstant.QUANTITY)));
                        customerPurchase.setRetailLocationId(retailLocationId);
                        customerPurchase.setTransSeq(transSeq);
                        customerPurchase.setWorkstationId(workstationId);
                        customerPurchase.setTransactionDate(transactionDate);
                        customerPurchase
                                .setSaleItemType(CawConstants.CAW_ITM_LINE_ITEM_SALE_TYPE_CODE
                                        .toUpperCase());
                        returnFlag = (itemPrice.signum() == -1) ? true : false;
                        customerPurchase.setReturnFlag(returnFlag);

                        customerTransHistoryResult.add(customerPurchase);

                    } else {
                        String description = items.getJSONObject(i)
                                .getJSONObject(CawEBSConstant.ATTRIBUTES)
                                .getString(CawEBSConstant.DESCRIPTION_ATTR);

                        if (description
                                .matches(".*(VISA|TENDER|MASTERCARD).*")) {
                            break;
                        } else {
                            BigDecimal price = new BigDecimal(items
                                    .getJSONObject(i)
                                    .getString(CawEBSConstant.LINETOTAL));
                            if (customerPurchase != null) {
                                customerPurchase.setPrice(customerPurchase.getPrice().add(price));
                            }
                            
                            continue;
                        }
                    }

                }
            }
        } catch (JSONException ex) {
           _logger.error("Method 'parseResponseOfCustomerPurchaseDetail' throw a exception.", ex.getMessage());
        }

        return customerTransHistoryResult;
    }

    /*END BZ28036*/
    /**
     * 
     * @param party
     * @param membershipsArr
     * @return
     */
    public IPartyIdCrossReferenceProperty savePartyXRefPropertyMembershipAttr(
            IParty party, JSONArray membershipsArr) {

        IPartyIdCrossReferenceProperty partyXRefP = null;
        if (party != null && membershipsArr != null
                && membershipsArr.length() > 0) {
            partyXRefP = DataFactory
                    .createObject(IPartyIdCrossReferenceProperty.class);

            partyXRefP.setOrganizationId(party.getOrganizationId());
            partyXRefP.setPartyId(party.getPartyId());
            partyXRefP.setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);

            partyXRefP.setPropertyCode(JSON_MEMBERSHIPS);
            partyXRefP.setType(STRING);
            partyXRefP.setStringValue(membershipsArr.toString());
        }

        return partyXRefP;
    }

    // End BZ25434
    //Begin BZ26471
    /**
     * save pricing into CRM_PARTY_ID_XREF_P table
     * @param party
     * @param pricing
     * @return
     */
    public IPartyIdCrossReferenceProperty savePartyXRefPropertyPricingAttr(
            IParty party, JSONObject pricing) {

        IPartyIdCrossReferenceProperty partyXRefP = null;
        if (party != null && pricing != null && pricing.length() > 0) {
            partyXRefP = DataFactory
                    .createObject(IPartyIdCrossReferenceProperty.class);

            partyXRefP.setOrganizationId(party.getOrganizationId());
            partyXRefP.setPartyId(party.getPartyId());
            partyXRefP.setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);

            partyXRefP.setPropertyCode(PRICING_ATTR);
            partyXRefP.setType(STRING);
            partyXRefP.setStringValue(pricing.toString());
        }

        return partyXRefP;
    }
    //End BZ26471

    // Begin BZ26453
    /**
     * The function search customer in the database.
     * @param argFields
     * @param commonHelper
     * @return
     */
    public IQueryResultList<CawCustomerQueryResult> searchForCustomers(
            Collection<IKeyedValue<String, ?>> argFields,
            CommonHelper commonHelper) {

        Map<String, Object> params = new HashMap<>();
        params.put(CawQueryConstants.ARG_VOID_FLAG, Boolean.valueOf(false));
        params.put(CawQueryConstants.ARG_ACTIVE_FLAG, Boolean.valueOf(true));

        boolean primaryAddressFieldPresent = false;

        for (IKeyedValue<String, ?> field : argFields) {
            if (PRIMARY_ADDRESS_FIELD.equals(field.getKey())) {
                primaryAddressFieldPresent = true;
            }
            if (ACTIVE_FLAG_FIELD.equals(field.getKey())) {
                Boolean activeFlag = ((Boolean) field.getValue())
                        .booleanValue();
                params.put(CawQueryConstants.ARG_ACTIVE_FLAG, activeFlag);
            }
        }

        IQueryKey<CawCustomerQueryResult> queryKey = (primaryAddressFieldPresent)
                ? CAW_CRM_CUSTOMER_LOOKUP_PRIMARY
                : CAW_CRM_CUSTOMER_LOOKUP;

        return searchForCustomers(queryKey, commonHelper
                .makeParamMap(argFields, params));
    }

    /**
     * The function executes query search customer.
     * @param argQueryKey
     * @param argParams
     * @return
     */
    public IQueryResultList<CawCustomerQueryResult> searchForCustomers(
            IQueryKey<CawCustomerQueryResult> argQueryKey,
            Map<String, Object> argParams) {

        Map<String, Object> params = new HashMap<String, Object>();
        if (argParams != null) {
            params = new HashMap<String, Object>(argParams);
        }

        if (!params.containsKey(CawQueryConstants.ARG_ORGANIZATION_ID)) {
            params.put(CawQueryConstants.ARG_ORGANIZATION_ID, ConfigurationMgr
                    .getOrganizationId());
        }

        if (!params.containsKey(CawQueryConstants.ARG_ACTIVE_FLAG)) {
            params.put(CawQueryConstants.ARG_ACTIVE_FLAG, Boolean
                    .valueOf(true));//BZ26453
        }

        return DataFactory.getObjectByQueryNoThrow(argQueryKey, params);
    }

    /**
     * 
     * @param cawCustomer
     * @return
     */
    public List<JSONObject> getMembershipsOfCustomer(
            CawCustomerQueryResult cawCustomer,
            List<JSONObject> lstMembership) {

        try {
            JSONArray memberShips = new JSONArray(
                    cawCustomer.getMembershipStringValue());
            if (memberShips.length() > 0) {
                lstMembership.clear();
                int len = memberShips.length();
                JSONObject obj = null;
                for (int j = 0; j < len; j++) {
                    obj = memberShips.getJSONObject(j);
                    lstMembership.add(obj);
                }
            }
        } catch (Exception ex) {
            _logger.error("Can not parse membership info from database:"
                    + ex.getMessage());
        }

        return lstMembership;
    }

    // End BZ26453

    // Begin BZ26398
    /**
     * The method get value in list data of CRM PARTY_ID_XREF_P table with PROPERTY CODE parameter 
     * @param propertyCode
     * @param xrefResults
     * @return
     */
    public String getValueOfPartyIdXrefByPropertyCode(String propertyCode,
            List<CawPartyIdXrefQueryResult> xrefResults) {

        String propertyValue = null;

        if (propertyCode != null && xrefResults != null
                && xrefResults.size() > 0) {
            for (CawPartyIdXrefQueryResult cawPartyIdXref : xrefResults) {
                if (propertyCode
                        .equalsIgnoreCase(cawPartyIdXref.getPropertyCode())) {
                    propertyValue = cawPartyIdXref.getStringValue();
                    break;
                }
            }
        }

        return propertyValue;
    }
    // End BZ26398

    //Begin BZ26575
    /**
     * -3 - Country not support QAS
     * -2 - Offline
     * -1 - Not found address
     *  0 - The address is matching exactly
     *  1 - Found 1 or n addresses, but not matching
     * @param frmModel
     * @param _busyState
     * @return
     */
    // BZ37753 - Modify parameter to call checkQASMatchingLookupAddress() from Object to 2 parameter addressLine and country
    public int checkQASMatchingLookupAddress(String addressLine, String country,
            IBusyState argBusyState, TransactionScope argTransactionScope) {

        int defaultNotFound = -1;
        String countryAlpha2 = country;
        
        //Added BZ26568
        if (!_addressHelper.isCountryQASEnabled(countryAlpha2)) {
            return -3;
        }

        CawQASearchResult resultLookup = null;
        if (addressLine != null && addressLine.length() > 0) {
            String line = addressLine.trim();
            if (line.length() > 0) {
                argBusyState.start(CawConstants.BUSY_STATE_MSG);
                resultLookup = _addressHelper
                        .doSearchAddress(line, countryAlpha2);
                argBusyState.end();
                if (resultLookup == null) {
                    if (CawQASHelper.getInstance().isOffline()) {
                        return -2;//BZ26575 Offline
                    } else {
                        return -1;//BZ26575 Not found
                    }
                }
            }
        }

        if (resultLookup != null) {
            CawQAAddressType address = resultLookup.getQAAddress();
            CawQAPicklistType pickList = resultLookup.getQAPicklist();
            CawVerifyLevelType verifyLevel = resultLookup.getVerifyLevel();

            IPartyLocaleInformation localeInfo = null;
            AddressSearchInfo addressSearchInfo = _addressHelper
                    .getAddressSearchInfo(verifyLevel, address);
            if (addressSearchInfo != null) {
                localeInfo = addressSearchInfo.getResultAddress();
            }

            if (localeInfo != null) {
                String addressResponseStr = _addressHelper
                        .getMergedAddressOneLine(localeInfo);
                if (addressResponseStr != null
                        && addressResponseStr.length() > 0) {
                    if (addressResponseStr.equalsIgnoreCase(addressLine)) {
                        return 0; //BZ26575 found
                    } else {
                        argTransactionScope
                                .setValue(CawValueKeys.CAW_QAS_SEARCH_RESULT, resultLookup);
                        return 1; //BZ26575 found, but not matching
                    }
                }
            }

            if ((pickList != null) && pickList.getPotentialMatches() != null
                    && (BigInteger.ZERO
                            .compareTo(pickList.getPotentialMatches()) != 0)) {
                List<CawPicklistEntryType> entries = pickList
                        .getPicklistEntry();
                if (entries != null && entries.size() > 0) {
                    argTransactionScope
                            .setValue(CawValueKeys.CAW_QAS_SEARCH_RESULT, resultLookup);
                    return entries.size();
                }
            }
        }
        return defaultNotFound;
    }
    //End 26575

    /**
     * Get amount from AR Available Balance
     * @param jsonCustLookupResponse
     * @return
     */
    public BigDecimal getARAvailableBalanceAmt(String jsonCustLookupResponse) {

        BigDecimal arAccountBalance = BigDecimal.ZERO;
        try {
            if (jsonCustLookupResponse != null && !jsonCustLookupResponse.isEmpty()) {
                JSONObject req = new JSONObject(jsonCustLookupResponse);
                JSONObject locs = req
                        .getJSONObject(CawJSONConstant.JSON_AR_INFO);
                Iterator<?> keys = locs.keys();
                String key, value;
                BigDecimal amt;
                while (keys.hasNext()) {
                    key = (String) keys.next();
                    value = locs.getString(key);
                    if (key != null && key
                            .equalsIgnoreCase(CawJSONConstant.JSON_AR_AVAILABLE_BALANCE)) {
                        amt = CawUtilFunction
                                .vBigDecimal(value, BigDecimal.ZERO);
                        if (BigDecimal.ZERO.compareTo(amt) != 0) {
                            arAccountBalance = amt;
                            break;
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method getARAvailableBalanceAmt: "
                    + ex.getMessage());
        }
        return arAccountBalance;
    }

    /*Begin BZ36405 */
    public BigDecimal getAvailableBalanceAmt(String jsonCustLookupResponse) {

        BigDecimal availableBalance = BigDecimal.ZERO;
        try {
            if (jsonCustLookupResponse != null && !jsonCustLookupResponse.isEmpty()) {
                JSONObject arInfoJsonObj = new JSONObject(jsonCustLookupResponse);
                if (arInfoJsonObj.has(CawJSONConstant.JSON_AR_INFO)) {
                    JSONObject arInfoJsonAttrObj = arInfoJsonObj.getJSONObject(CawJSONConstant.JSON_AR_INFO);
                    if (arInfoJsonAttrObj != null && arInfoJsonAttrObj.has(CawJSONConstant.JSON_AR_CREDIT_HOLD)) {
                        boolean isArCreditHold = arInfoJsonAttrObj.getBoolean(CawJSONConstant.JSON_AR_CREDIT_HOLD);
                        availableBalance = isArCreditHold == true ? availableBalance 
                                : new BigDecimal(arInfoJsonAttrObj.getString(CawJSONConstant.JSON_AR_AVAILABLE_BALANCE));
                    }
                }
              
            }
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method getAvailableBalanceAmt: "
                    + ex.getMessage());
        }
        return availableBalance;
    }
    /*End BZ36405*/

    /* Begin BZ27851 */
    /**
     * @param membershipviews
     * @param iParty
     * @return
     */
    public List<ICustomerLoyaltyCard> getCustomerLoyaltyCardFromEBS(
            List<CawCustomerMembershipView> membershipviews, IParty iParty) {

        List<ICustomerLoyaltyCard> customerLoyaltyCards = new ArrayList<ICustomerLoyaltyCard>();

        ICustomerLoyaltyCard loyaltyCard = null;
        ICustomerLoyaltyCardProperty loyaltyCardProperty = null;
        if (membershipviews != null && membershipviews.size() > 0) {
            for (CawCustomerMembershipView membershipview : membershipviews) {

                loyaltyCard = DataFactory.createObject(ICustomerLoyaltyCard.class);
                loyaltyCard.setOrganizationId(iParty.getOrganizationId());

                loyaltyCard.setPartyId(iParty.getPartyId());

                loyaltyCard.setCardNumber(membershipview.getClub());

                loyaltyCard.setExpirationDate(CawUtilFunction.formatDateMMDDYYY(membershipview.getExpDate()));
                
                /* BEGIN BZ53459*/
                loyaltyCardProperty = addLoyaltyProperty(iParty, membershipview, CawConstants.LOYALTY_MEMBERSHIP
                        , membershipview.getMemberShip());
                if (loyaltyCardProperty != null) {
                    loyaltyCard.addCustomerLoyaltyCardProperty(loyaltyCardProperty);
                }
                
                loyaltyCardProperty = addLoyaltyProperty(iParty, membershipview, CawConstants.LOYALTY_MEMBERSHIP_POINTS_BALANCE
                        , membershipview.getPointsBalance());
                if (loyaltyCardProperty != null) {
                    loyaltyCard.addCustomerLoyaltyCardProperty(loyaltyCardProperty);
                }
                
                loyaltyCardProperty = addLoyaltyProperty(iParty, membershipview, CawConstants.LOYALTY_MEMBERSHIP_REDEEMABLE_VALUE
                        , membershipview.getRedeemableValue());
                if (loyaltyCardProperty != null) {
                    loyaltyCard.addCustomerLoyaltyCardProperty(loyaltyCardProperty);
                }
                /* END BZ53459*/
                
                customerLoyaltyCards.add(loyaltyCard);
            }
        }
        return customerLoyaltyCards;
    }

    /**
     * Step 1: get list of memberships
     * Step 2: get list of LoyaltyCards
     * Step 3: get image of membership of the customer
     * @param argCustomer
     * @param jsonCustomerResponse
     */
    public void loadMembershipInfo(IParty argCustomer,
            String jsonCustomerResponse) {

        List<ICustomerLoyaltyCard> outLoyaltyCards = null;
        String outMembershipImageUrl = "";
        List<CawCustomerMembershipView> outCustomerMembershipViews = null;
        CawMembershipHelper _mbshipHelper = CawMembershipHelper.getInstance();

        //Step 1: get list of memberships-----------------------------
        outCustomerMembershipViews = _mbshipHelper
                .getReloadMemberships(jsonCustomerResponse);
        boolean bMembershipsExisted = _mbshipHelper.isMembershipsExisted();

        //Step 2: get list of LoyaltyCards----------------------------
        long organizationId = ConfigurationMgr.getOrganizationId();
        // Get loyalty card of the Customer from EBS
        if (bMembershipsExisted && argCustomer != null) {
            organizationId = argCustomer.getOrganizationId();
            /*BEGIN BZ48733*/
            outLoyaltyCards = getCustomerLoyaltyCardFromEBS(outCustomerMembershipViews, argCustomer);
            if (outLoyaltyCards == null || outLoyaltyCards.size() == 0) {
                // Get Customer cards from DB
                outLoyaltyCards = getCustomerCards(argCustomer);
            }
            //BEGIN BZ48564
            //Handle customer has membership type other 1 and loyalty attribute is null
            for (int i = 0; i < outLoyaltyCards.size(); i++) {
                if (outLoyaltyCards.size() == 1 && outLoyaltyCards.get(0).getAwardAccounts().isEmpty()
                        && outLoyaltyCards.get(0).getCardNumber().equals(" ")
                        && outLoyaltyCards.get(0).getLoyaltyAccounts().isEmpty()) {
                    outLoyaltyCards.remove(i);
                }
            }
            
            argCustomer.setLoyaltyCards(outLoyaltyCards);
            //END BZ48564 
            /*END BZ48733*/
        }

        //Step 3: Get image of membership of the customer.------------
        outMembershipImageUrl = _mbshipHelper
                .getMembershipImageFromJsonCustomer(jsonCustomerResponse, organizationId, bMembershipsExisted);
        if (argCustomer != null && (outMembershipImageUrl == null
                || outMembershipImageUrl.isEmpty())) {

            outMembershipImageUrl = _mbshipHelper
                    .getMembershipImageFromDatabase(jsonCustomerResponse,argCustomer, bMembershipsExisted); //BEGIN BZ69515

        }
        _mbshipHelper.setMembershipImage(outMembershipImageUrl);
    }
    /* End BZ27851 */
    
    /* BEGIN BZ28853 */
    /**
     *  
     * @param party
     * @param esbResponse
     * @param isNew
     * @return return the list phones
     */
    public List<IPartyTelephone> parseCustomerPhones(IParty party, String esbResponse, boolean isNew) {

        if (isNew) {
            // Create new Phone
            return createCustomerPhones(party, esbResponse);

        } else {
            // Update the Phone
            return updateCustomerPhones(party, esbResponse);

        }
    }

    /**
     * @param party
     * @param esbResponse
     * @return the list phones
     */
    private List<IPartyTelephone> createCustomerPhones(IParty party, String esbResponse) {

        List<IPartyTelephone> listPhones = new ArrayList<>();

        try {

            JSONObject jsonObjects = new JSONObject(esbResponse);

            JSONObject curJsonPhone = null;

            JSONArray phoneArrays = CawJSONUtils.getJSONArray(jsonObjects, CawConstants.PHONE);

            if (phoneArrays != null) {

                int nFound = phoneArrays.length();

                IPartyTelephone partTelephone = null;

                for (int i = 0; i < nFound; i++) {

                    partTelephone = DataFactory.createObject(IPartyTelephone.class);

                    curJsonPhone = phoneArrays.getJSONObject(i);

                    if (curJsonPhone != null) {

                        partTelephone.setOrganizationId(party.getOrganizationId());

                        partTelephone.setPartyId(party.getPartyId());

                        int phoneType = curJsonPhone.getInt(CawEBSConstant.TYPE_ATTR);
                        // Only save HOME and MOBILE
                        if (phoneType == 1) {

                            partTelephone.setTelephoneType(CawConstants.HOME);

                        } else if (phoneType == 2) {

                            partTelephone.setTelephoneType(CawConstants.MOBILE_PHONE);

                        } else {
                            continue;
                        }
                        partTelephone.setTelephoneNumber(curJsonPhone.getString(CawConstants.PHONE_NUMBER));

                        partTelephone.setCreateUserId(party.getCreateUserId());

                        partTelephone.setCreateDate(party.getCreateDate());

                    }

                    listPhones.add(partTelephone);
                }
            }
        } catch (Exception ex) {
            _logger.error("parse Phones: " + ex.getMessage());
            listPhones = null;
        }
        return listPhones;

    }

    /**
     * @param party
     * @param esbResponse
     * @return
     */
    private List<IPartyTelephone> updateCustomerPhones(IParty party, String esbResponse) {

        List<IPartyTelephone> listPhones = new ArrayList<>();

        List<IPartyTelephone> listExistedPhones = null;

        try {

            JSONObject jsonObjects = new JSONObject(esbResponse);

            JSONObject curJsonPhone = null;

            JSONArray phoneArrays = CawJSONUtils.getJSONArray(jsonObjects, CawConstants.PHONE);

            listExistedPhones = party.getTelephoneInformation();

            if (phoneArrays != null && CollectionUtils.isNotEmpty(listExistedPhones)) {

                int curPhoneExisted = listExistedPhones.size();

                int jsonPhoneExisted = phoneArrays.length();

                IPartyTelephone curPartyPhone = null;

                for (int i = 0; i < curPhoneExisted; i++) {

                    curPartyPhone = listExistedPhones.get(i);

                    if (curPartyPhone != null && (CawConstants.HOME.equalsIgnoreCase(curPartyPhone.getTelephoneType())
                            || CawConstants.MOBILE.equalsIgnoreCase(curPartyPhone.getTelephoneType())))

                    {
                        for (int j = 0; j < jsonPhoneExisted; j++) {
                            curJsonPhone = phoneArrays.getJSONObject(j);

                            int jsonPhoneType = curJsonPhone.getInt(CawEBSConstant.TYPE_ATTR);

                            if (jsonPhoneType == 1
                                    && CawConstants.HOME.equalsIgnoreCase(curPartyPhone.getTelephoneType())) {

                                curPartyPhone.setTelephoneNumber(curJsonPhone.getString(CawConstants.PHONE_NUMBER));

                            } else if (jsonPhoneType == 2
                                    && CawConstants.MOBILE.equalsIgnoreCase(curPartyPhone.getTelephoneType())) {

                                curPartyPhone.setTelephoneNumber(curJsonPhone.getString(CawConstants.PHONE_NUMBER));

                            } else {
                                continue;
                            }

                            listPhones.add(curPartyPhone);
                        }
                    }

                }
            }
        } catch (Exception ex) {
            _logger.error("parse Phones: " + ex.getMessage());
            listPhones = null;
        }
        return listPhones;

    }
    /* END BZ28853 */
    
    /* BEGIN BZ31982 */
    /***
     * Save arInfo into CRM_PARTY_ID_XREF_P table.
     * @param party
     * @param arInfo
     * @return
     */
    public IPartyIdCrossReferenceProperty savePartyXRefPropertyArInfoAttr(IParty party, JSONObject arInfo) {

        IPartyIdCrossReferenceProperty partyXRefP = null;

        if (party != null && arInfo != null) {
            partyXRefP = DataFactory.createObject(IPartyIdCrossReferenceProperty.class);
            partyXRefP.setOrganizationId(party.getOrganizationId());
            partyXRefP.setPartyId(party.getPartyId());
            partyXRefP.setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);
            partyXRefP.setPropertyCode(JSON_AR_INFO);
            partyXRefP.setType(STRING);
            partyXRefP.setStringValue(arInfo.toString());
        }
        return partyXRefP;
    }

    /***
     * Get arInfo of CRM_PARTY_ID_XREF_P.PROPERTY_CODE=ARINFO
     * @param iParty
     * @return
     */
    public static String getValueArInfoFromDB(IParty iParty) {

        String arInfo = StringUtils.EMPTY;

        if (iParty != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put(CawQueryConstants.ARG_ORGANIZATION_ID, iParty.getOrganizationId());
            params.put(CawQueryConstants.ARG_PARTY_ID, iParty.getPartyId());
            List<CawPartyIdXrefQueryResult> xrefResults = DataFactory
                    .getObjectByQueryNoThrow(CAW_CUSTOMER_PARTY_ID_XREF, params);

            if (CollectionUtils.isNotEmpty(xrefResults)) {
                arInfo = CawCustomerHelper.getInstance()
                        .getValueOfPartyIdXrefByPropertyCode(CawJSONConstant.JSON_AR_INFO, xrefResults);
            }
        }
        return arInfo;
    }

    /***
     * Get TaxExemptInfo of customer
     * @param customerJson
     * @param taxExemptions
     * @return
     */
    public static JSONObject getTaxExemptInfo(JSONObject customerJson, List<ITaxExemption> taxExemptions) {

        JSONObject jsonCustomerHaveTaxExempt = customerJson;

        if (CollectionUtils.isNotEmpty(taxExemptions)) {
            for (ITaxExemption taxExemption : taxExemptions) {
                try {
                    jsonCustomerHaveTaxExempt
                            .put(CawJSONConstant.JSON_TAX_CERTIFICATE, taxExemption.getCertificateNbr());
                    jsonCustomerHaveTaxExempt.put(CawJSONConstant.JSON_IS_TAX_EXEMPT, Boolean.TRUE.toString());
                } catch (JSONException ex) {
                    _logger.error("Json Tax Exempt Info: " + ex.getMessage());
                }
            }
        }
        return jsonCustomerHaveTaxExempt;
    }

    /***
     * Build JSON object for customer information get data from DB
     * @param jsonMessCustomerInfo
     * @param party
     * @param taxExemptions
     * @return
     */
    public static String buildCustomerInforFromDB(String jsonMessCustomerInfo, IParty party,
            List<ITaxExemption> taxExemptions) {

        String strCustomerInfor = jsonMessCustomerInfo;

        if (party != null && StringUtils.isEmpty(strCustomerInfor)) {
            // 1. Get information of customer with Memberships and Pricing from DB.
            strCustomerInfor = CawCustomerHelper.getInstance().buildCustomerJsonObjectOffline(party);
            String arInfo = StringUtils.EMPTY;

            // 2. Get information of customer with AR account from DB.
            if (CawCustomerUtil.isWhslCustomer(party)) {
                arInfo = getValueArInfoFromDB(party);
            }
            JSONObject customerJson;
            try {
                // Put membership and pricing into JSON customer.
                customerJson = new JSONObject(strCustomerInfor);

                // Put arInfo into JSON customer.
                if (StringUtils.isNotEmpty(arInfo)) {
                    JSONObject jsonArInfo = CawJSONUtils.toJSONObject(arInfo);
                    if (jsonArInfo != null) {
                        customerJson.put(CawJSONConstant.JSON_AR_INFO, jsonArInfo);
                    }
                }
                // 3. Get tax exempt from DB and put taxCertificate and isTaxExempt into JSON customer.
                customerJson = getTaxExemptInfo(customerJson, taxExemptions);
                if (customerJson != null) {
                    strCustomerInfor = customerJson.toString();
                }
            } catch (JSONException ex1) {
                _logger.error("Build Json Custormer Info: " + ex1.getMessage());
            }
        }
        return strCustomerInfor;
    }
    /* END BZ31982 */
    
    /* BEGIN BZ31717 */
    /**
     * Remove a row in table CAT_CUST_CONSUMER_CHARGE_ACCT have cust_account_id equal value 
     * of houseAccountSeq.seq to resolve Primary Key Violation when tendering to AR or Third-party.
     * @param party
     * @param custCardId
     */
    public void removeCatCustConsumerChargeAcctLocal(IParty party, String custCardId) {

        try {
            if (party != null && StringUtils.isNotEmpty(custCardId)) {
                Map<String, Object> params = new HashMap<String, Object>();

                params.put(CawQueryConstants.ARG_ORGANIZATION_ID, party.getOrganizationId());
                params.put(CawQueryConstants.ARG_CUST_ACCT_ID, custCardId);
                QueryRequest removeRequest = new QueryRequest();
                removeRequest.setQueryKey(CAT_CUST_CONSUMER_CHARGE_ACCT_REMOVE);
                removeRequest.setParams(params);
                DataFactory.makePersistent(removeRequest);
            }
        } catch (Exception ex) {
            _logger.error("Can not delete Cat Cust Loy Acct: " + ex.getMessage());
        }
    }
    /* END BZ31717 */
    
    /*BEGIN BZ28036*/
    public Map<String, Date> searchCustomerPurchaseFromEBS(String accountNumber,
            String itemCode) {

        try {
            //Step1: Build JSON message for Customer Purchase History-------------
            String body = this
                    .buildRequestOfPurchaseHistory(accountNumber, itemCode);
            //Step2: Send the request and get response via Neuron service-------
            ResponseEntity<String> result = CawEBSHelper.getInstance()
                    .searchPurchaseHistoryToEBS(body);
            if (result != null && result.getStatusCode() == HttpStatus.OK) {
                Map<String, Date> trans = new HashMap<String, Date>();
                JSONObject objects = new JSONObject(result.getBody());
                JSONArray oders = CawJSONUtils
                        .getJSONArray(objects, CawEBSConstant.ORDERS);
                Date transactionDate = null;
                if (oders != null && oders.length() > 0) {
                    for (int i = 0; i < oders.length(); i++) {
                        transactionDate = DateUtils
                                .parseDate(oders.getJSONObject(i)
                                        .getString(CawEBSConstant.ORDERDATE));
                        /*
                         * filter transaction has order date > 365
                         */
                        if (!getPurchasDateRange(transactionDate))
                            continue;
                        trans.put(oders.getJSONObject(i)
                                .getString(CawEBSConstant.SALES_CHANNEL_ID_ATTR),transactionDate);
                    }
                }
                return trans;

            }
        } catch (Exception ex) {
            _logger.error("searchCustomerFromEBS-0: " + ex.getMessage());
        }
        return null;
    }

    private String buildRequestOfPurchaseHistory(String accountNumber,
            String itemCode) {

        String body = null;
        String item = null;
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawEBSConstant.CUSTOMER_PURCHASE_HISTORY);
            body = request.getBody();
            body = body.replace(ACCOUNT_NUMBER, accountNumber);
            if (itemCode == null) {
                item = CawConstants.NULL_TEXT;
            }  else {
                item = itemCode;
            }
         
            body = body.replace(ITEM_CODES, item);
            
        } catch (Exception ex) {
            _logger.error("getWorkOrderSearchTemplateBuf-1:", ex);
            body = null;
        }
        return body;
    }

    private String buildRequestOfPurchaseHistoryDetail(String accountNumber,
            String transactionId) {

        String body = null;
        try {
            CawRestConfig request = CawRestConfigHelper.getInstance()
                    .getRestRequest(CawEBSConstant.CUSTOMER_PURCHASE_HISTORY_DETAIL);
            body = request.getBody();
            body = body.replace(ACCOUNT_NUMBER, accountNumber);
            body = body.replace(JSON_TRANSACTIONID, transactionId);
        } catch (Exception ex) {
            _logger.error("getWorkOrderSearchTemplateBuf-1:", ex);
            body = null;
        }
        return body;
    }

    /**
     * Check date in 365
     * @param TransactionDate
     * @return
     */
    private boolean getPurchasDateRange(Date TransactionDate) {

        Calendar currentBusinessDate = Calendar.getInstance();
        currentBusinessDate
                .setTime(DateUtils.clearTime(DateUtils.getNewDate()));
        currentBusinessDate
                .add(5, -1 * ConfigurationMgr.customerHistoryAgeLimitDays());
        Date startDate = DateUtils.startOfDay(currentBusinessDate.getTime());
        Date endDate = DateUtils
                .endOfDay(DateUtils.clearTime(DateUtils.getNewDate()));
        DateRange range = new DateRange(startDate, endDate);
        return DateUtils.isBetween(TransactionDate, range);
    }
    /*END BZ28036*/


    /* BEGIN BZ38598 */
    /**
     * Delete party property code EBS_QUEUE if updating customer - ONLINE CASE only
     * @param argIParty
     * @param argBody
     */
    public void deteleCustomerOfflineQueue(IParty argIParty, String upSertResponse) {

        // if response is OK
        if (StringUtils.isNoneEmpty(upSertResponse)) {
            // delete Party Properties by DELTE statement
            try {
                if (argIParty != null) {
                    // build parameter
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put(CawQueryConstants.ARG_ORGANIZATION_ID, argIParty.getOrganizationId());
                    params.put(CawQueryConstants.ARG_PARTY_ID, argIParty.getPartyId());
                    params.put(CawQueryConstants.ARG_PROPERTY_CODE, CawConstants.ESB_QUEUE_ONLINE_STATUS);
                    
                    // build query
                    QueryRequest removeRequest = new QueryRequest();
                    removeRequest.setQueryKey(CawQueryConstants.PARTY_PROPERTY_REMOVE);
                    removeRequest.setParams(params);
                    
                    // delete
                    DataFactory.makePersistent(removeRequest);
                }
            } catch (Exception ex) {
                _logger.error("Can not delete party properties for EBS_QUEUE: " + ex.getMessage());
            }
        }
    }
    /* End BZ38598 */
    

    /* BEGIN BZ53459 */
    private ICustomerLoyaltyCardProperty addLoyaltyProperty(IParty iParty,
            CawCustomerMembershipView membershipview, String typeCode, String typeValue) {
        ICustomerLoyaltyCardProperty loyaltyCardProperty = null;
        try {
            loyaltyCardProperty = DataFactory.createObject(ICustomerLoyaltyCardProperty.class);
            loyaltyCardProperty.setOrganizationId(iParty.getOrganizationId());
            loyaltyCardProperty.setCardNumber(membershipview.getClub());
            loyaltyCardProperty.setPropertyCode(typeCode);
            loyaltyCardProperty.setPropertyValue(typeValue);
            loyaltyCardProperty.setType(CawConstants.PROP_STRING_TYPE);
        } catch (Exception ex) {
            _logger.error("Method addLoyaltyProperty can not create ICustomerLoyaltyCardProperty object:" + ex.getMessage());
        }
        
        return loyaltyCardProperty;
    }
    /* END BZ53459 */
}
