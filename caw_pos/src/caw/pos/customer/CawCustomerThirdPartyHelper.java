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
 * BZ23263          250917    Implement House Account
 * BZ23951          171017    Customer Search Screen Needs to Include Membership#, Expiration Date
 * BZ26323          220518    [24561] Should be displayed message to indicate EBS is offlined when doing AR/Third-party tender in offline cases
 * BZ26500          060618    Xstore allows to complete trans with Third-party tender which customer has belong club pricing once EBS is offline
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ29409          220219    [Prod] CW is reporting that a Wholesale customer couldn't be found when attempting a third party tender
 * BZ29600          010319    [Prod] CW is reporting that a Wholesale customer couldn't be found when attempting a third party tender
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 * BZ27535          090519    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 *===================================================================
 */

package caw.pos.customer;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import caw.rest.services.CawRestConfig;
import caw.rest.services.CawRestConfigHelper;
import twitter4j.*;

import dtv.data2.access.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.TransactionHelper;
import dtv.pos.customer.CustomerSearchModel;
import dtv.pos.framework.form.IHasAddressFields;
import dtv.pos.iframework.IPersistablesBag;
import dtv.pos.iframework.security.StationState;
import dtv.util.IKeyedValue;
import dtv.util.common.CommonConstants;
import dtv.util.sequence.SequenceFactory;
import dtv.xst.crm.cust.ICustomerQueryResult;
import dtv.xst.dao.cat.*;
import dtv.xst.dao.crm.*;

/**
 * BZ25675 moved constants to CawJSONConstant class
 */
public class CawCustomerThirdPartyHelper extends CawJSONConstant {

    private static final Logger                         _logger                         = LogManager
            .getLogger(CawCustomerThirdPartyHelper.class);

    private static volatile CawCustomerThirdPartyHelper INSTANCE                        = null;

    @Inject
    protected StationState                              _stationState;

    //Begin BZ23052
    private static final String                         IS_AUTO_RENEW                   = "isAutoRenew";

    private static final String                         STATUS_DESCRIPTION              = "statusDescription";

    private static final String                         STATUS                          = "status";

    private static final String                         TYPE_DESCRIPTION                = "typeDescription";

    private static final String                         TYPE                            = "type";

    private static final String                         BENEFIT_LEVEL_NAME              = "benefitLevelName";

    private static final String                         BENEFIT_LEVEL                   = "benefitLevel";

    private static final String                         EXPIRE_DATE                     = "expireDate";

    private static final String                         JOIN_DATE                       = "joinDate";

    private static final String                         IDENTIFIER                      = "identifier";

    private static final String                         SUFFIX                          = "L";

    private static final String                         CUSTOMER                        = "CUSTOMER";

    private static final String                         OPEN                            = "OPEN";

    private static final String                         CLOSE                           = "CLOSE";

    private static final String                         LOYALTY                         = "LOYALTY";

    private static final String                         CUSTOMER_ACCOUNT                = "CUSTOMER_ACCOUNT";

    private static final String                         DTV_CLASS_NAME                  = "dtv.xst.dao.cat.impl.CustomerLoyaltyAccount";

    private static final String                         ARG_CUST_CARD_NUMBER            = "argCustCardNumber";

    private static final String                         ARG_PARTY_ID                    = "argPartyId";

    private static final String                         PRICING_ATTR                    = "pricing";                                    //BZ23417

    IQueryKey<CawCustomerLoyaltyQueryResult>            CRM_CUSTOMER_LOYALTY_EBS_LOOKUP = new QueryKey<CawCustomerLoyaltyQueryResult>(
            "CRM_CUSTOMER_LOYALTY_EBS_LOOKUP",
            CawCustomerLoyaltyQueryResult.class);

    IPersistablesBag                                    bag                             = TransactionHelper
            .getPersistables();
    // End BZ23052

    private boolean                                     esbOffline                      = false;

    /**
     * @return
     */
    public static CawCustomerThirdPartyHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawCustomerThirdPartyHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawCustomerThirdPartyHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Reviewed code of BZ25358
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
        setEsbOffline(false);
        try {
            //Step1: Build JSON message for Customer Search request--------------------
            String body = this.buildRequestOfCustomerSearch(argFields);

            //Step2: Send the request and get response via Neuron service--------------
            ResponseEntity<String> result = CawEBSHelper.getInstance()
                    .searchRequestToEBS(body);

            //Step3: Parse the response to list of customers--------------------------
            if (result != null) {
                if (result.getStatusCode() == HttpStatus.OK) {
                    List<CawCustomerQueryResult> customerQueryResults = parseResponseOfCustomerSearch(result
                            .getBody());
                    list = QueryResultList
                            .makeList(customerQueryResults, ICustomerQueryResult.class);
                    //Begin BZ26323
                } else if (result
                        .getStatusCode() == HttpStatus.REQUEST_TIMEOUT) {
                    setEsbOffline(true);
                } else if (result.getStatusCode() == HttpStatus.BAD_REQUEST) {
                    setEsbOffline(true);
                } else {
                    setEsbOffline(true);//BZ26500
                }
                //End BZ26323
            }
        } catch (Exception ex) {
            _logger.error("searchCustomerFromEBS-thirdparty: "
                    + ex.getMessage());
        }
        return list;
    }

    /**
     * @param argSelected
     * @return
     */
    public String lookupCustomerFromEBS(ICustomerQueryResult argSelected) {

        String accountNumber = null;
        String locationCode = null;
        if (argSelected instanceof CawCustomerQueryResult) {
            CawCustomerQueryResult customer = (CawCustomerQueryResult) argSelected;
            accountNumber = customer.getAccountNumber();
            locationCode = customer.getLocationCode();
        }

        return CawEBSHelper.getInstance()
                .lookupCustomerInEBS(accountNumber, locationCode);
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
        for (IPartyLocaleInformation localeInfo : listAddresses) {
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
        body = body.replace(SALES_CHANNEL, formatParameter(storeId.toString()));

        // body = body.replace(SALES_CHANNEL, "1");//Temporary hard coded waiting Upsert API work, it line will remove

        body = body.replace(NAME_AUDIT, formatParameter(custTemplate.getName()
                .getAudit()));
        body = body.replace(NAME_PREFIX, formatParameter(custTemplate.getName()
                .getPrefix()));
        body = body.replace(NAME_FIRST, formatParameter(custTemplate.getName()
                .getFirst()));
        body = body.replace(NAME_MIDDLE, formatParameter(custTemplate.getName()
                .getMiddle()));
        body = body.replace(NAME_LAST, formatParameter(custTemplate.getName()
                .getLast()));
        body = body.replace(NAME_SUFFIX, formatParameter(custTemplate.getName()
                .getSuffix()));
        body = body.replace(NAME_COMPANY, formatParameter(custTemplate.getName()
                .getCompany()));

        body = body.replace(ADDRESS_AUDIT, formatParameter(custTemplate
                .getAddress().getAudit()));
        body = body.replace(ADDRESS_ADDRESS_TYPE, formatParameter(custTemplate
                .getAddress().getAddressType()));
        body = body
                .replace(ADDRESS_TYPE_DESCRIPTION, formatParameter(custTemplate
                        .getAddress().getAddressTypeDescription()));
        body = body.replace(ADDRESS_IS_DELIVERABLE, custTemplate.getAddress()
                .getIsDeliverable() == true ? Boolean.TRUE.toString()
                        : Boolean.FALSE.toString());
        body = body.replace(ADDRESS_LINE1, formatParameter(custTemplate
                .getAddress().getLine1()));
        body = body.replace(ADDRESS_LINE2, formatParameter(custTemplate
                .getAddress().getLine2()));
        body = body.replace(ADDRESS_LINE3, formatParameter(custTemplate
                .getAddress().getLine3()));
        body = body.replace(ADDRESS_LINE4, formatParameter(custTemplate
                .getAddress().getLine4()));
        body = body.replace(ADDRESS_CITY, formatParameter(custTemplate
                .getAddress().getCity()));
        body = body.replace(ADDRESS_STATE_PROVINCE, formatParameter(custTemplate
                .getAddress().getStateProvince()));
        body = body.replace(ADDRESS_POSTAL_CODE, formatParameter(custTemplate
                .getAddress().getPostalCode()));
        body = body.replace(ADDRESS_COUNTRY, formatParameter(custTemplate
                .getAddress().getCountry()));
        body = body.replace(ADDRESS_COUNTY, formatParameter(custTemplate
                .getAddress().getCounty()));

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
        body = body
                .replace(ACCOUNT_STATUS_DESCRIPTION, formatParameter(custTemplate
                        .getAccountStatusDescription()));
        body = body.replace(CUSTOMER_TYPE, custTemplate.getCustomerType()
                .toString());
        body = body.replace(RV_TYPE, custTemplate.getRvType() != null
                ? custTemplate.getRvType().toString()
                : NULL);
        body = body.replace(ACXIOMIDENTIFIERS, NULL);
        body = body.replace(ALLOWEDIT, Boolean.TRUE.toString());
        body = body.replace(EMAIL_ADDRESS, formatParameter(custTemplate
                .getEmailAddress()));

        body = body.replace(RV_TYPE, custTemplate.getRvType().toString());
        body = body.replace(RV_TYPE_DESCRIPTION, formatParameter(custTemplate
                .getRvTypeDescription()));
        body = body.replace(IS_TAXEXEMPT, Boolean.FALSE.toString());
        body = body.replace(TAX_CERTIFICATE, NULL);
        body = body.replace(AR_INFO, NULL);
        body = body.replace(LAST_UPDATE_USER, formatParameter(custTemplate
                .getLastUpdateUser()));
        body = body.replace(LAST_UPDATE_SYSTEM, formatParameter(custTemplate
                .getLastUpdateSystem()));
        body = body.replace(LAST_UPDATE_DATE, formatParameter(custTemplate
                .getLastUpdateDate()));
        body = body.replace(FEED, formatParameter(custTemplate.getFeed()));
        body = body.replace(CRUD, formatParameter(String
                .valueOf(CawCustomerCrud.NOT_SPECIFIED.getValue())));
        body = body.replace(CRUD_DESCRIPTION, formatParameter(custTemplate
                .getCrudDescription()));
        body = body.replace(ATTRIBUTES, formatParameter(custTemplate
                .getAttributes()));

        String finalBody = CawUtilFunction.sanitizeXmlChars(body)
                .replaceAll(SPECIAL_CHARACTER, SPACE_CHARACTER);

        //BZ26575 changed by using CawEBSHelper
        ResponseEntity<String> response = CawEBSHelper.getInstance()
                .upsertCustomterToEBS(finalBody);

        return response;
    }

    /**
     * @return
     */
    public Integer getMaxNumberOfCustomers() {

        return ConfigurationMgr.getHelper()
                .getInt(new String[] { STORE_TAG, SYSTEM_CONFIG_TAG, CUSTOMER_SEARCH, MAXNUMBEROFCUSTOMERS });

    }

    /**
     * @param argString
     * @return
     */
    public String formatParameter(String argString) {

        return argString != null ? "\"" + argString + "\"" : "null";
    }

    /**
     * @param jsonObject
     * @return
     */
    public IParty createPartyObjFromJson(JSONObject responseData)
            throws JSONException {

        IParty party = DataFactory.createObject(IParty.class);
        if (responseData != null) {
            final long partySeq = SequenceFactory
                    .getNextLongValue(CawEBSConstant.PARTY_SEQUENCE_ID);
            party.setOrganizationId(CawEBSConstant.ORGANIZATION_ID);
            party.setPartyId(partySeq);

            String custId = SequenceFactory
                    .getNextStringValue(CawEBSConstant.CUSTOMER_SEQUENCE_ID);
            party.setCustomerId(custId);
            party.setPartyTypeCode(CawEBSConstant.CUSTOMER);

            if (responseData.getJSONObject(JSON_NAME) != null) {
                if (responseData.getJSONObject(JSON_NAME)
                        .get(JSON_LAST_NAME) != null) {
                    party.setFirstName(responseData.getJSONObject(JSON_NAME)
                            .get(JSON_FIRST_NAME).toString());
                }
                if (responseData.getJSONObject(JSON_NAME)
                        .get(JSON_LAST_NAME) != null) {
                    party.setLastName(responseData.getJSONObject(JSON_NAME)
                            .get(JSON_LAST_NAME).toString());
                }
                // Begin BZ23269
                if (responseData.getJSONObject(JSON_NAME)
                        .getString(JSON_COMPANY) != null) {
                    party.setOrganizationName(responseData
                            .getJSONObject(JSON_NAME).getString(JSON_COMPANY));
                    String companyName = responseData.getJSONObject(JSON_NAME)
                            .getString(JSON_COMPANY);
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

            // Begin BZ23294
            if (responseData.getJSONObject(JSON_ADDRESS) != null) {
                IPartyLocaleInformation addressInfo = DataFactory
                        .createObject(IPartyLocaleInformation.class);

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_LINE1) != null) {
                    addressInfo.setAddress1(responseData
                            .getJSONObject(JSON_ADDRESS).get(JSON_LINE1)
                            .toString());
                }

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_LINE2) != null) {
                    addressInfo.setAddress2(responseData
                            .getJSONObject(JSON_ADDRESS).get(JSON_LINE2)
                            .toString());
                }

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_LINE3) != null) {
                    addressInfo.setAddress3(responseData
                            .getJSONObject(JSON_ADDRESS).get(JSON_LINE3)
                            .toString());
                }

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_LINE4) != null) {
                    addressInfo.setAddress4(responseData
                            .getJSONObject(JSON_ADDRESS).get(JSON_LINE4)
                            .toString());
                }

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_CITY) != null) {
                    addressInfo.setCity(responseData.getJSONObject(JSON_ADDRESS)
                            .get(JSON_CITY).toString());
                }

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_STATE) != null) {
                    addressInfo
                            .setState(responseData.getJSONObject(JSON_ADDRESS)
                                    .get(JSON_STATE).toString());
                }

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_POSTAL_CODE) != null) {
                    addressInfo.setPostalCode(responseData
                            .getJSONObject(JSON_ADDRESS).get(JSON_POSTAL_CODE)
                            .toString());
                }

                if (responseData.getJSONObject(JSON_ADDRESS)
                        .getString(JSON_COUNTY) != null) {
                    addressInfo
                            .setCounty(responseData.getJSONObject(JSON_ADDRESS)
                                    .get(JSON_COUNTY).toString());
                }
                // End BZ23294
                //Waiting confirm because DB only store 2 character but JSON response 3 character
                if (responseData.getJSONObject(JSON_ADDRESS)
                        .get(JSON_COUNTRY) != null) {
                    String country = responseData.getJSONObject(JSON_ADDRESS)
                            .getString(JSON_COUNTRY);
                    if (country != null) {
                        if (country.length() > 2) {
                            country = country.substring(0, 2);
                        }
                    }
                    addressInfo.setCountry(country);
                }

                party.addPartyLocaleInformation(addressInfo);
            }

            if (responseData.get(JSON_EMAIL_ADDRESS) != null) {
                party.setEmailAddress(responseData.get(JSON_EMAIL_ADDRESS)
                        .toString());
            }
        }

        return party;
    }

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

    public void saveCustomerJSON(IParty party, JSONObject responseData)
            throws JSONException {

        if (party != null && responseData != null) {
            // NAME
            if (responseData.getString(JSON_NAME) != null && responseData
                    .getJSONObject(JSON_NAME).get(JSON_AUDIT) != null) {
                savePartyXRefP(party, PROPERTIES_NAME_AUDIT, responseData
                        .getJSONObject(JSON_NAME).get(JSON_AUDIT)
                        .toString(), STRING);
            } else {
                savePartyXRefP(party, PROPERTIES_NAME_AUDIT, null, STRING);
            }

            // ADDRESS
            if (responseData.getString(JSON_ADDRESS) != null) {
                if (responseData.getJSONObject(JSON_ADDRESS)
                        .get(JSON_AUDIT) != null) {
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

            // PARTNERS
            if (responseData.getString(JSON_PARTNERS) != null) {
                savePartyXRefP(party, PROPERTIES_PARTNERS, responseData
                        .getJSONObject(JSON_PARTNERS).toString(), STRING);
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

            // ACXIOM_INDIVIDUAL
            if (responseData.getString(JSON_ACXIOM_IDENTIFIERS) != null) {
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
    public void savePartyXRefP(IParty party, String propertyName,
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

    // Begin BZ23367
    public void saveCatCustLoyaltyAcc(String lookupResponse, IParty iParty,
            StationState stationState) {

        try {
            if (lookupResponse != null && iParty != null) {
                JSONObject objectJson = new JSONObject(lookupResponse);
                if (!objectJson.isNull(JSON_MEMBERSHIPS) && objectJson
                        .getJSONArray(JSON_MEMBERSHIPS).length() > 0) {
                    JSONArray memberShips = objectJson
                            .getJSONArray(JSON_MEMBERSHIPS);

                    Map<String, Object> params = new HashMap<>();
                    params.put(ARG_PARTY_ID, iParty.getPartyId());

                    IQueryResultList<CawCustomerLoyaltyQueryResult> queryResult = null;
                    CawCustomerLoyaltyQueryResult cawCustomerLoyaltyQueryResult = null;
                    ICustomerAccount iCustomerAccount = null;
                    ICustomerLoyaltyCard customerLoyaltyCard = null;
                    ICustomerLoyaltyAccount loyaltyAccount = null;
                    ICustomerLoyaltyAccountProperty iCustomerLoyaltyAccountProperty = null;

                    int len = memberShips.length();
                    for (int i = 0; i < len; i++) {
                        params.put(ARG_CUST_CARD_NUMBER, memberShips
                                .getJSONObject(i).getString(IDENTIFIER));

                        queryResult = DataFactory
                                .getObjectByQueryNoThrow(CRM_CUSTOMER_LOYALTY_EBS_LOOKUP, params);

                        if (queryResult != null && queryResult.size() > 0) {
                            cawCustomerLoyaltyQueryResult = queryResult.get(0);
                        }

                        //CAT_CUST_ACCT
                        iCustomerAccount = createCustomerAccount(cawCustomerLoyaltyQueryResult, iParty, stationState, memberShips
                                .getJSONObject(i));
                        bag.addObject(iCustomerAccount);

                        //CAT_CUST_ACCT_CARD
                        customerLoyaltyCard = createCatCustAcctCard(cawCustomerLoyaltyQueryResult, iParty, stationState, memberShips
                                .getJSONObject(i));
                        bag.addObject(customerLoyaltyCard);

                        //CAT_CUST_LOYALTY_ACCT
                        loyaltyAccount = createCatCustLoyaltyAcct(cawCustomerLoyaltyQueryResult, objectJson, memberShips
                                .getJSONObject(i));
                        loyaltyAccount.setAccountId(iCustomerAccount
                                .getCustAccountId());
                        bag.addObject(loyaltyAccount);

                        //CAT_CUST_LOYALTY_ACCT_P
                        iCustomerLoyaltyAccountProperty = createLoyaltyAccountProperty(cawCustomerLoyaltyQueryResult, memberShips
                                .getJSONObject(i), loyaltyAccount);
                        iCustomerLoyaltyAccountProperty
                                .setAccountId(iCustomerAccount
                                        .getCustAccountId());
                        bag.addObject(iCustomerLoyaltyAccountProperty);

                        // Persist to database
                        bag.persist();
                    }
                }

            }
        } catch (Exception ex) {
            _logger.debug("Can not parse json" + ex.getMessage());
        }
    }

    /**
     * @param memberShips
     * @param i
     * @param loyaltyAccount
     * @throws JSONException
     */
    private ICustomerLoyaltyAccountProperty createLoyaltyAccountProperty(
            CawCustomerLoyaltyQueryResult cawCustomerLoyaltyQueryResult,
            JSONObject memberShips, ICustomerLoyaltyAccount loyaltyAccount)
            throws JSONException {

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

        iCustomerLoyaltyAccountProperty.setPropertyCode(STATUS_DESCRIPTION);
        iCustomerLoyaltyAccountProperty.setType(STRING);
        iCustomerLoyaltyAccountProperty
                .setStringValue(memberShips.getString(STATUS_DESCRIPTION));

        iCustomerLoyaltyAccountProperty.setPropertyCode(IS_AUTO_RENEW);
        iCustomerLoyaltyAccountProperty.setType(STRING);
        iCustomerLoyaltyAccountProperty
                .setStringValue(memberShips.getString(IS_AUTO_RENEW));

        return iCustomerLoyaltyAccountProperty;
    }

    /**
     * @param objectJson
     * @param memberShips
     * @param i
     * @return
     * @throws JSONException
     */
    private ICustomerLoyaltyAccount createCatCustLoyaltyAcct(
            CawCustomerLoyaltyQueryResult loyaltyQueryResult,
            JSONObject objectJson, JSONObject memberShips)
            throws JSONException {

        ICustomerLoyaltyAccount iCustomerLoyaltyAccount = null;
        if (loyaltyQueryResult != null) {
            CustomerLoyaltyAccountId customerLoyaltyAccountId = new CustomerLoyaltyAccountId();
            customerLoyaltyAccountId
                    .setAccountId(loyaltyQueryResult.getCustAcctId());
            customerLoyaltyAccountId
                    .setCardNumber(loyaltyQueryResult.getCustCardNbr());
            customerLoyaltyAccountId
                    .setOrganizationId(loyaltyQueryResult.getOrganizationId());
            iCustomerLoyaltyAccount = DataFactory
                    .getObjectByIdNoThrow(customerLoyaltyAccountId);
        }

        if (iCustomerLoyaltyAccount == null) {
            iCustomerLoyaltyAccount = DataFactory
                    .createObject(ICustomerLoyaltyAccount.class);
        }

        iCustomerLoyaltyAccount
                .setAccountId(objectJson.getString(JSON_ACCOUNT_NUMBER));
        iCustomerLoyaltyAccount
                .setCardNumber(memberShips.getString(IDENTIFIER));
        iCustomerLoyaltyAccount
                .setOrganizationId(ConfigurationMgr.getOrganizationId());
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
    private ICustomerAccount createCustomerAccount(
            CawCustomerLoyaltyQueryResult cawCustomerLoyaltyQueryResult,
            IParty iParty, StationState stationState, JSONObject memberShips)
            throws JSONException {

        ICustomerAccount customerAccount = null;
        if (cawCustomerLoyaltyQueryResult != null) {
            CustomerAccountId customerAccountId = new CustomerAccountId();
            customerAccountId.setOrganizationId(cawCustomerLoyaltyQueryResult
                    .getOrganizationId());

            customerAccountId.setCustAccountId(cawCustomerLoyaltyQueryResult
                    .getCustAcctId());
            customerAccountId.setCustAccountCode(cawCustomerLoyaltyQueryResult
                    .getCustAcctCode());
            customerAccount = DataFactory
                    .getObjectByIdNoThrow(customerAccountId);
        }

        if (customerAccount == null) {
            customerAccount = DataFactory.createObject(ICustomerAccount.class);

            String acountId = SUFFIX + stationState.getRetailLocationId()
                    + stationState.getWorkstationId()
                    + SequenceFactory.getNextLongValue(CUSTOMER_ACCOUNT);

            customerAccount.setCustAccountId(acountId);
            customerAccount.setCustAccountCode(LOYALTY);
            customerAccount
                    .setOrganizationId(ConfigurationMgr.getOrganizationId());
            customerAccount
                    .setRetailLocationId(stationState.getRetailLocationId());
        }

        customerAccount.setParty(iParty);
        if (memberShips.getString(EXPIRE_DATE) != null) {
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

    /**
     * 
     * @param loyaltyQueryResult
     * @param iParty
     * @param stationState
     * @param memberShips
     * @return
     * @throws JSONException
     */
    public ICustomerLoyaltyCard createCatCustAcctCard(
            CawCustomerLoyaltyQueryResult loyaltyQueryResult, IParty iParty,
            StationState stationState, JSONObject memberShips)
            throws JSONException {

        ICustomerLoyaltyCard customerLoyaltyCard = null;
        if (loyaltyQueryResult != null) {
            CustomerLoyaltyCardId customerLoyaltyCardId = new CustomerLoyaltyCardId();
            customerLoyaltyCardId
                    .setCardNumber(loyaltyQueryResult.getCustCardNbr());
            customerLoyaltyCardId
                    .setOrganizationId(loyaltyQueryResult.getOrganizationId());
            customerLoyaltyCard = DataFactory
                    .getObjectByIdNoThrow(customerLoyaltyCardId);
        }

        if (customerLoyaltyCard == null) {
            customerLoyaltyCard = DataFactory
                    .createObject(ICustomerLoyaltyCard.class);
            customerLoyaltyCard
                    .setOrganizationId(ConfigurationMgr.getOrganizationId());
        }

        customerLoyaltyCard.setCardNumber(memberShips.getString(IDENTIFIER));
        customerLoyaltyCard.setPartyId(iParty.getPartyId());
        customerLoyaltyCard.setEffectiveDate(CawUtilFunction
                .formatDateMMDDYYY(memberShips.getString(JOIN_DATE)));
        customerLoyaltyCard.setExpirationDate(CawUtilFunction
                .formatDateMMDDYYY(memberShips.getString(EXPIRE_DATE)));

        return customerLoyaltyCard;
    }

    // End BZ23367

    //Begin BZ23417
    /**
     * Insert data to table CRM_CUSTOMER_AFFILIATION(Groups customer).
     * @param iParty
     * @param jsonResponse
     * @return
     */
    public ICustomerAffiliation createCustomerAffiliation(IParty iParty,
            String jsonResponse) {

        ICustomerAffiliation iCustomerAffiliation = null;
        try {
            if (iParty != null && jsonResponse != null) {
                JSONObject jsonObject = new JSONObject(jsonResponse);
                if (!jsonObject.isNull(PRICING_ATTR)) {
                    String identifier = jsonObject.getJSONObject(PRICING_ATTR)
                            .getString(IDENTIFIER);
                    CustomerAffiliationId customerAffiliationId = new CustomerAffiliationId();
                    customerAffiliationId.setOrganizationId(ConfigurationMgr
                            .getOrganizationId());
                    customerAffiliationId.setPartyId(iParty.getPartyId());
                    customerAffiliationId.setCustomerGroupId(identifier);

                    iCustomerAffiliation = DataFactory
                            .getObjectByIdNoThrow(customerAffiliationId);
                    if (iCustomerAffiliation == null) {
                        iCustomerAffiliation = DataFactory
                                .createObject(ICustomerAffiliation.class);
                        iCustomerAffiliation.setObjectId(customerAffiliationId);
                        iCustomerAffiliation.setOrganizationId(ConfigurationMgr
                                .getOrganizationId());
                    }
                    iCustomerAffiliation.setCustomerGroupId(identifier);
                    iCustomerAffiliation = DataFactory
                            .makePersistent(iCustomerAffiliation);
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

    //End BZ23477

    /**
     * Reviewed for BZ25358 
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
            body = body.replace(LAST_NAME, formatParameter(lastName));
            body = body.replace(FIRST_NAME, formatParameter(firstName));
            body = body.replace(CITY, formatParameter(city));
            body = body.replace(STATE, formatParameter(state));
            body = body.replace(COUNTRY, formatParameter(country)); //BZ23270
            body = body.replace(POSTAL_CODE, formatParameter(postalCode));
            body = body.replace(EMAIL_ADDRESS, formatParameter(emailAddress));
            body = body
                    .replace(COMPANY_NAME, formatParameter(organizationName));
            body = body.replace(ADDRESS, formatParameter(address1));
            /* Begin BZ23168 and BZ23197*/
            if (phoneNumber != null) {
                body = body.replace(PHONE_NUMBER, formatParameter(phoneNumber)
                        .replaceAll("-", SPACE_CHARACTER));
            } else {
                body = body.replace(PHONE_NUMBER, NULL);
            }
            /* End BZ23168 and BZ23197 */
            body = body.replace(MEMBER_ID, formatParameter(memberID));
            body = body.replace(ACCOUNT_NUMBER, String
                    .valueOf(CawUtilFunction.vLong(accountNumber)));
            body = body.replace(LIMIT_RESULT, getMaxNumberOfCustomers()
                    .toString());
        } catch (Exception ex) {
            _logger.error("buildRequestOfCustomerSearch-pt: "
                    + ex.getMessage());
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
        long accNbr = 0l;
        try {
            JSONObject objects = new JSONObject(jsonMessage);
            JSONArray customerList = objects
                    .getJSONArray(CawEBSConstant.CUSTOMERS);
            JSONObject curJsonCustomer = null;
            CawCustomerQueryResult customer = null;
            JSONObject name, address, obj;
            JSONArray memberShips;
            String companyName, first, last;
            List<JSONObject> lstMembership = null;
            int length = customerList.length();
            for (int i = 0; i < length; i++) {
                curJsonCustomer = customerList.getJSONObject(i);
                /* Begin BZ29409 */
                if (!curJsonCustomer.isNull(CawEBSConstant.PRICING_ATTR)) {
                    if (!curJsonCustomer.getJSONObject(CawEBSConstant.PRICING_ATTR)
                            .isNull(CawEBSConstant.PRICE_MEMBERSHIP)
                            && CawCustomerUtil.isWhslCustomer(curJsonCustomer.getJSONObject(CawEBSConstant.PRICING_ATTR)
                                    .toString()))/* BZ29600 */ {
                /* End BZ29409 */
                        customer = new CawCustomerQueryResult();
                        customer.setOrganizationId(CawEBSConstant.ORGANIZATION_ID);
                        accNbr = CawJSONUtils.vLong(curJsonCustomer
                                .getString(JSON_ACCOUNT_NUMBER));
                        customer.setId(Long.valueOf(accNbr));
                        customer.setCustomerId(curJsonCustomer
                                .getString(JSON_ACCOUNT_NUMBER));
                        customer.setAccountNumber(curJsonCustomer
                                .getString(JSON_ACCOUNT_NUMBER));
                        customer.setLocationCode(CawPropertyUtils.STORE_NUMBER);/*BZ27535*/
                        name = curJsonCustomer.getJSONObject(JSON_NAME);
                        customer.setFirstName(name.getString(JSON_FIRST_NAME));
                        customer.setLastName(name.getString(JSON_LAST_NAME));
                        address = curJsonCustomer.getJSONObject(JSON_ADDRESS);
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
                        customer.setDataSource(CawEBSConstant.EBS_DATASOURCE);
                        // Begin BZ23268
                        if (StringUtils
                                .isNotEmpty(name.getString(JSON_COMPANY))) {
                            customer.setOrganizationName(name
                                    .getString(JSON_COMPANY));
                            companyName = name.getString(JSON_COMPANY);
                            if (companyName.split(" ").length > 1) {
                                first = companyName.substring(0, companyName
                                        .lastIndexOf(" "));
                                last = companyName
                                        .substring(companyName.lastIndexOf(" ")
                                                + 1);
                                customer.setFirstName(first);
                                customer.setLastName(last);
                            } else {
                                customer.setFirstName("");
                                customer.setLastName(companyName);
                            }

                        } else {
                            customer.setFirstName(name
                                    .getString(JSON_FIRST_NAME));
                            customer.setLastName(name
                                    .getString(JSON_LAST_NAME));
                        }
                        // End BZ23268
                        // Begin BZ23951
                        // set memberships
                        try {
                            memberShips = CawJSONUtils
                                    .getJSONArray(curJsonCustomer, JSON_MEMBERSHIPS);
                            if (memberShips != null
                                    && memberShips.length() > 0) {
                                lstMembership = new ArrayList<JSONObject>();
                                int len = memberShips.length();
                                for (int j = 0; j < len; j++) {
                                    obj = memberShips.getJSONObject(j);
                                    lstMembership.add(obj);
                                }
                                customer.setMembershipLst(lstMembership);
                            }
                        } catch (Exception ex) {
                            _logger.error("Cannot get JSON object: "
                                    + ex.getMessage());
                        }
                        // End BZ23951
                        customerQueryResults.add(customer);
                    }
                }
            }

        } catch (Exception ex) {
            _logger.error("parseResponseOfCustomerSearch-thirdparty: "
                    + ex.getMessage());
            customerQueryResults = null;
        }
        return customerQueryResults;
    }

    //Begin BZ26323
    /**
     * @return the esbOffline
     */
    public boolean isEsbOffline() {

        return esbOffline;
    }

    /**
     * @param argEsbOffline the esbOffline to set
     */
    public void setEsbOffline(boolean argEsbOffline) {

        esbOffline = argEsbOffline;
    }

    //End BZ26323
}
