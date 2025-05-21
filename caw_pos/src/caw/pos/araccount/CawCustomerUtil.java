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
 * BZ24561          221117    Should be displayed message to indicate EBS is offlined when doing AR/Third-party tender in offline cases
 * BZ25674          040718    New Requirement - Add security override for employee/crew member sales
 * BZ26289          240718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27000          030818    [26289] House Account tab info displays incorrectly the A/R data retrieved from EBS Neuron or localDB.
 * BZ27199          170818    Cannot complete Sale Transaction which used any tender types with special customer Club#:W7705280824
 * BZ26982          290818    [1.6.2] Do NOT submit OLPS request if the customer is a wholesale customer
 * BZ27651          200918    [New Requirement] Add the saleperson to the requests of Card Services API
 * BZ27339          031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ28033          110518    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ28688          171218    [2.9.4] Club Price appears on expired club member return receipts.
 * BZ29124          280119    Port 29051 to Release 3.0 - Update Xstore to allow only one PO tender per transaction
 * BZ29316          120219    [Internal] Zip Code in Xstore does not match the zip code displayed on the Pin Pad Customer Verification Form
 * BZ29387          140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 * BZ29388          150219    [Internal] PLCC - Only 1 receipt prints when making a payment
 * BZ28012          180219    [New Requirement] Reprocess the ApplicationStatus calls if first attempt is unsuccessful
 * BZ29409          220219    [Prod] CW is reporting that a Wholesale customer couldn't be found when attempting a third party tender
 * BZ29515          220219    [ADS Feedback] Duplicate cardholder address in the ‘address’ and ‘address2’ fields for credit application
 * BZ29514          220219    Updated Requirement] ADS Feedback: Instant Credit API – the phone number is not being sent. This is a required field.
 * BZ29600          010319    [Prod] CW is reporting that a Wholesale customer couldn't be found when attempting a third party tender
 * BZ29592          040319    [Port 29564 to 4.0] Wholesale customer couldn't be found when attempting a third party tender
 * BZ27535          090593    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ31523          250619    [Port BZ30263 to 5.0]Display GSC member savings in transaction
 * BZ32272          300719    [New Requirement] Leading Characters are not being dropped when adding GS membership
 * BZ33497          291019    [INTERNAL] EBS responded 400 107:Customer updates not allowedCustomer has Crew membership that prevents updates
 * BZ33615          311019    [Prod] Issue with tax being charged on tax exempt wholesale customer
 * BZ33894          031219    [New Requirement] Capturing email at end of transaction while assigned customer into transaction
 * BZ33598          231219    [Prod] QAS address match issues
 * BZ30259          120220    [New Requirement] Customer Specific Messages on Receipts
 * BZ36405          030620    Issue with Credit Customer placed on credit hold
 * BZ37305          260820    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad.
 * BZ37642          030920    [Internal] Xstore makes a Shipping Rates API request to Neuron API included a few value of attributes/tags into the body request does not match to specification Neuron API.
 * BZ40798          240221    Modification to member savings calculation
 * BZ44053          100621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 * BZ45486          060821    [Prod] Issue With House and 3rd Party Payment
 * BZ53159          251022    [Internal] Appear error in xstore log when creating a Sale with GSAM membership customer.
 *===================================================================
 */

package caw.pos.araccount;

import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.customer.CawCustomerConstants;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.customer.membership.CawCustomerMembershipView;
import caw.pos.customer.membership.CawMembershipHelper;
import caw.pos.util.CawEBSHelper;
import twitter4j.*;

import dtv.data2.access.*;
import dtv.event.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.PromptKey;
import dtv.pos.employee.EmployeeHelper;
import dtv.pos.houseaccount.HouseAccountStateType;
import dtv.pos.houseaccount.model.HouseAcctBuyerModel;
import dtv.pos.i18n.format.TelephoneFormatter;
import dtv.pos.iframework.IPersistablesBag;
import dtv.util.IDateProvider;
import dtv.util.sequence.SequenceFactory;
import dtv.xst.dao.cat.*;
import dtv.xst.dao.com.*;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trl.impl.AccountReceivableSaleLineItemModel;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * The Class CawCustomerUtil
 *
 */
public class CawCustomerUtil {

    /* BEGIN BZ28688 */
    /** The Constant PRICING_TAG. */
    public static final String       PRICING_TAG                             = "pricing";

    /** The Constant MEMBERSHIP_TAG. */
    public static final String       MEMBERSHIP_TAG                          = "membership";

    /** The Constant BAND_TAG. */
    public static final String       BAND_TAG                                = "band";
    /* END BZ28688*/
    /** The Constant MAX_ADVANCE_AMOUNT. */
    public static final String       MAX_ADVANCE_AMOUNT                      = "MAX_ADVANCE_AMOUNT";                    // Max $ amount for associate advances

    /** The Constant ASSOCIATE_ADVANCE. */
    public static final String       ASSOCIATE_ADVANCE                       = "ASSOCIATE_ADVANCE";                     // boolean flag to allow assoc advances.

    /** The Constant PARAM_CUSTOMER_REQUIRED. */
    public static final String       PARAM_CUSTOMER_REQUIRED                 = "CustomerRequired";

    /** The Constant PARAM_CUSTOMER_INFO_REQUIRED. */
    public static final String       PARAM_CUSTOMER_INFO_REQUIRED            = "CustomerInfoRequired";
    /**
     * Event descriptor for posting/receiving events about customer address changes not made directly on the
     * customer maintenance model.
     */
    public static final IEventSource ADDRESS_CHANGED_EVENT_DESCRIPTOR        = new EventDescriptor(
            "CustomerAddressChangedEventDescriptor");

    /** The Constant CUSTOMER_ADDRESS_ADDED. */
    public static final EventEnum    CUSTOMER_ADDRESS_ADDED                  = new EventEnum("add customerAddress");

    /** The Constant CUSTOMER_ADDRESS_REMOVED. */
    public static final EventEnum    CUSTOMER_ADDRESS_REMOVED                = new EventEnum("remove customerAddress");

    /** The Constant CUSTOMER_PRIMARY_ADDRESS_CHANGED. */
    public static final EventEnum    CUSTOMER_PRIMARY_ADDRESS_CHANGED        = new EventEnum("change primaryAddress");

    /** Event descriptor for posting/receiving events about the items on the customer wish list changing. */
    public static final IEventSource WISH_LIST_CHANGED_EVENT_DESCRIPTOR      = new EventDescriptor(
            "CustomerWishListChangedEventDescriptor");

    /** The Constant CUSTOMER_WISH_LIST_UPDATED. */
    public static final EventEnum    CUSTOMER_WISH_LIST_UPDATED              = new EventEnum("update customerWishList");

    /** Event descriptor for posting/receiving events about the items on the customer digital cart changing. */
    public static final IEventSource DIGITAL_CART_CHANGED_EVENT_DESCRIPTOR   = new EventDescriptor(
            "CustomerDigitalCartChangedEventDescriptor");

    /** The Constant DIGITAL_CART_LIST_UPDATED. */
    public static final EventEnum    DIGITAL_CART_LIST_UPDATED               = new EventEnum(
            "update customerDigitalCart");

    /** Event descriptor for posting/receiving events about the tax exemptions on the customer changing. */
    public static final IEventSource TAX_EXEMPT_CHANGED_EVENT_DESCRIPTOR     = new EventDescriptor(
            "CustomerTaxExemptChangedEventDescriptor");

    /** The Constant CUSTOMER_TAX_EXEMPT_UPDATED. */
    public static final EventEnum    CUSTOMER_TAX_EXEMPT_UPDATED             = new EventEnum(
            "update customerTaxExemption");

    /** The Constant DEACTIVATE_CUSTOMER. */
    public static final EventEnum    DEACTIVATE_CUSTOMER                     = new EventEnum("deactivate customer");

    /** The Constant CUSTOMER_HOUSE_ACCOUNT_CREATED. */
    public static final EventEnum    CUSTOMER_HOUSE_ACCOUNT_CREATED          = new EventEnum(
            "create customerHouseAccount");

    /** The Constant HOUSE_ACCOUNT_BUYERS_REFRESH. */
    public static final EventEnum    HOUSE_ACCOUNT_BUYERS_REFRESH            = new EventEnum(
            "refresh customerHouseAccountBuyerList");

    /** The Constant DEACTIVATE_CUSTOMER_EVENT_DESCRIPTOR. */
    public static final IEventSource DEACTIVATE_CUSTOMER_EVENT_DESCRIPTOR    = new EventDescriptor(
            "DeactivateCustomerEventDescriptor");

    /** The Constant HOUSE_ACCOUNT_CREATED_EVENT_DESCRIPTOR. */
    public static final IEventSource HOUSE_ACCOUNT_CREATED_EVENT_DESCRIPTOR  = new EventDescriptor(
            "HouseAccountCreatedEventDescriptor");

    /** The Constant HOUSE_ACCOUNT_BUYERS_REFRESH_DESCRIPTOR. */
    public static final IEventSource HOUSE_ACCOUNT_BUYERS_REFRESH_DESCRIPTOR = new EventDescriptor(
            "HouseAccountBuyersRefreshEventDescriptor");

    private static final Logger      _logger                                 = LogManager
            .getLogger(CawCustomerUtil.class);
    
    

    /**
     * Checks if is employee.
     *
     * @param argCustomer the customer
     * @return true, if is employee
     */
    public static boolean isEmployee(IParty argCustomer) {

        boolean isEmployee = false;

        if (argCustomer != null) {
            /* A customer will be considered an employee if: (1) They have an "EMPLOYEE" party type code OR (2) They
             * are a member of the reserved "EMPLOYEE" group and have no corresponding employee record. Ideally,
             * because this determination will be used to drive employee discount availability, we would first check
             * to see if the customer has an associated employee record with a non- terminated status. The
             * consensus, however, is that the remote round-trip to establish this record isn't worth the potential
             * fraud savings. */
            boolean inEmployeeGroup = false;
            String val = CawPropertyUtils.CUSTOMER_GROUP_TYPE_CREW_NEW_NAME;//BZ25674 added
            List<ICustomerAffiliation> list = argCustomer.getCustomerGroups();
            for (ICustomerAffiliation custGroup : list) {
                if (EmployeeHelper.DEFAULT_EMPLOYEE_GROUP.equalsIgnoreCase(custGroup.getCustomerGroupId())) {
                    inEmployeeGroup = true;
                    break;
                }
                // BZ25674 Start
                // Check if the Customer link to transaction is belonged to Crew group               
                if (val != null && val.equalsIgnoreCase(custGroup.getCustomerGroupId())) {
                    inEmployeeGroup = true;
                    break;
                }
                // BZ25674 End
            }

            /* If a customer is a member of the reserved "EMPLOYEE" group, assume that they can be considered an
             * employee, even if they do not have a corresponding employee record. This is a potentially
             * over-generous interpretation, but apparently there are many organizations that don't want to model
             * non-store personnel in the DB but still want to afford them employee discounts, etc. */
            isEmployee = EmployeeHelper.EMPLOYEE_PARTY_TYPE.equalsIgnoreCase(argCustomer.getPartyTypeCode()) //
                    || inEmployeeGroup;
        }

        return isEmployee;
    }

    /**
     * The Enum NoResultsReason.
     */
    public static enum NoResultsReason {

        /** The no records. */
        NO_RECORDS(PromptKey.valueOf("NO_CUSTOMER_AVAILABLE")),

        NO_RECORDS_THIRD_PARTY(PromptKey.valueOf("CAW_PROMPT_NO_CUSTOMER_AVAILABLE")),

        NO_RECORDS_THIRD_PARTY_AVAILABLE(PromptKey.valueOf("CAW_PROMPT_NO_CUSTOMER_THIRD_PARTY_AVAILABLE")),
        //Begin BZ24561 
        EBS_OFFLINE(PromptKey.valueOf("CAW_PROMPT_EBS_OFFLINE")),
        //End BZ24561
        /** The too many records. */
        TOO_MANY_RECORDS(PromptKey.valueOf("TOO_MANY_CUSTOMER_RECORDS")),

        /** The invalid user. */
        INVALID_USER(PromptKey.valueOf("INVALID_RELATE_USER_CRM"));

        private PromptKey _promptKey;

        private NoResultsReason(PromptKey argPromptKey) {

            _promptKey = argPromptKey;
        }

        /**
         * Gets the prompt key.
         *
         * @return the key for the prompt to display when this no results outcome has occurred.
         */
        public PromptKey getPromptKey() {

            return _promptKey;
        }
    }

    // BZ26289 start
    /**
     * Checks if is wholesale customer.
     *
     * @param argCustomer the customer
     * @return true, if is wholesale customer
     */
    public static boolean isWhslCustomer(IParty argCustomer) {

        /* BEGIN BZ29600 */
        String jsonCustomerLookup = CawCatalystHelper.getLookupResponseData();

        String jsonPricing = "";

        if (StringUtils.isNotEmpty(jsonCustomerLookup)) {

            jsonPricing = getJsonPricing(jsonCustomerLookup);

        }
        // Check customer is wholesale
        if (StringUtils.isNotEmpty(jsonPricing)) {

            return isWhslCustomer(jsonPricing);

        } else {
            /* BEGIN BZ29592 */
            String jsonOffilne = CawCustomerHelper.getInstance().buildCustomerJsonObjectOffline(argCustomer);

            if (StringUtils.isNotEmpty(jsonOffilne)) {
                
                jsonPricing = getJsonPricing(jsonOffilne);
                
            }

            if (StringUtils.isNotEmpty(jsonPricing)) {

                return isWhslCustomer(jsonPricing);

            }
            /* END BZ29592 */
        }
        return false;
        /* END BZ29600 */
    }
    
    /* BEGIN BZ29600 */
    /**
     * @param jsonMessage
     * @return
     */
    public static String getJsonPricing(String jsonMessage) {

        String jsonPricing = "";
        try {
            JSONObject jsonParent = new JSONObject(jsonMessage);

            JSONObject objPricing = null;

            if (jsonParent.has(CawEBSConstant.PRICING_ATTR)
                    && !jsonParent.isNull(CawEBSConstant.PRICING_ATTR))/* BZ29592 */ {
                
                Object pricingAtt = jsonParent.get(CawEBSConstant.PRICING_ATTR);

                if (pricingAtt != null && !pricingAtt.equals("")) {
                    
                    objPricing = jsonParent.getJSONObject(CawEBSConstant.PRICING_ATTR);
                    
                }

                if (objPricing != null) {
                    
                    return objPricing.toString();
                    
                }

            }

        } catch (Exception ex) {
            _logger.error("Could not parse membership: " + ex.getMessage());

        }
        return jsonPricing;
    }
    /* END BZ29600 */

    /**
     * BZ33497: commented out, this method should be not longer used
     * Checks if is crew customer.
     *
     * @param argCustomer the customer
     * @return true, if is crew customer
     */
     /*public static boolean isCrewCustomer(IParty argCustomer) {

        boolean found = false;
        if (argCustomer != null) {
            String val = CawPropertyUtils.CUSTOMER_GROUP_TYPE_CREW_NEW_NAME;
            List<ICustomerAffiliation> list = argCustomer.getCustomerGroups();
            for (ICustomerAffiliation custGroup : list) {
                if (val != null && custGroup.getCustomerGroupId() != null
                        && val.equalsIgnoreCase(custGroup.getCustomerGroupId())) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }*/

    /**
     * Check House Account Payment
     * @param pos
     * @return
     */
    public static boolean isHouseAccountPayment(IPosTransaction pos) {

        boolean valid = false;
        if (pos != null) {
            List<IRetailTransactionLineItem> tranLineItems = pos.getRetailTransactionLineItems();
            AccountReceivableSaleLineItemModel itemPayment;
            ICustomerItemAccountModifier houseAcc;
            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof AccountReceivableSaleLineItemModel) {
                    itemPayment = (AccountReceivableSaleLineItemModel) lineItem;
                    houseAcc = itemPayment.getCustomerAccountModifier();
                    if (houseAcc != null && CawConstants.HOUSE_ACCOUNT_TYPE.equals(houseAcc.getCustAccountCode())) {
                        valid = true;
                        break;
                    }
                }
            }
        }
        return valid;
    }

    /**
     * @param iParty
     * @param value
     */
    public static void saveCustomerTaxExemptStatus(IParty iParty, String value) {

        IPartyProperty iPartyProperty = null;
        if (iParty != null) {
            PartyPropertyId partyPropertyId = new PartyPropertyId();
            partyPropertyId.setOrganizationId(ConfigurationMgr.getOrganizationId());
            partyPropertyId.setPartyId(iParty.getPartyId());
            partyPropertyId.setPropertyCode(CawConstants.HOUSE_ACCOUNT_TYPE);
            iPartyProperty = DataFactory.getObjectByIdNoThrow(partyPropertyId);

            if (iPartyProperty == null) {
                iPartyProperty = DataFactory.createObject(IPartyProperty.class);
                iPartyProperty.setObjectId(partyPropertyId);
            }

            iPartyProperty.setStringValue(value);
            iPartyProperty.setType(CawConstants.PROP_STRING_TYPE);
            DataFactory.makePersistent(iPartyProperty);
        }
    }

    /**
     * Get Tax exempt status from EBS Response
     * @param lookupResponseEbs
     * @return
     */
    public static String getCustomerTaxExempt(String lookupResponseEbs) {

        String custTaxExempt = CawConstants.CUST_TAX_EXEMPT_NO;

        try {
            if (StringUtils.isNotEmpty(lookupResponseEbs) && lookupResponseEbs.length() > 0) {
                JSONObject req = new JSONObject(lookupResponseEbs);

                boolean isTaxExempt = req.getBoolean(CawJSONConstant.JSON_CUSTOMER_TAX_EXEMPT);
                /*BEGIN BZ27535*/
                /*String taxCertificate = req.getString(CawJSONConstant.JSON_TAX_CERTIFICATE);*/ /*BZ33615*/ 
                if (isTaxExempt) {/*BZ33615*/
                    custTaxExempt = CawConstants.CUST_TAX_EXEMPT_YES;
                }
                /*END BZ27535*/
            }
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method checkArAccountValid: " + ex.getMessage());
        }

        return custTaxExempt;
    }
    
    // BZ26289 end
    /*Begin BZ36405*/
    public static boolean isArCreditHold(String lookupResponseEbs) {

        boolean isArCreditHold = false;
        try {
            if (StringUtils.isNotEmpty(lookupResponseEbs)) {
                JSONObject arInfo = new JSONObject(lookupResponseEbs).getJSONObject(CawJSONConstant.JSON_AR_INFO);
                isArCreditHold = arInfo.getBoolean(CawJSONConstant.JSON_AR_CREDIT_HOLD);
               
            }
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method checkArAccountValid: " + ex.getMessage());
        }

        return isArCreditHold;
    }
    /*End BZ36405*/
    // BZ27000 start
    /**
     * Get Available credit
     * @param lookupResponseEbs
     * @return
     */
    public static BigDecimal getAvailableCredit(String lookupResponseEbs) {

        BigDecimal arAccountBalance = null;

        try {
            if (lookupResponseEbs != null && lookupResponseEbs.length() > 0) {
                JSONObject req = new JSONObject(lookupResponseEbs);
                JSONObject locs = req.getJSONObject(CawJSONConstant.JSON_AR_INFO);
                HashMap<String, String> map = new HashMap<String, String>();
                Iterator<?> keys = locs.keys();
                String key, value;
                BigDecimal amt;
                while (keys.hasNext()) {
                    key = (String) keys.next();
                    value = locs.getString(key);
                    map.put(key, value);
                    if (key.equalsIgnoreCase(CawJSONConstant.JSON_AR_AVAILABLE_BALANCE)) {
                        amt = CawUtilFunction.vBigDecimal(value);
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
            _logger.error("Error happened in method getAvailableCredit: " + ex.getMessage());
        }
        return arAccountBalance;
    }

    /**
     * Get Setup Date
     * @param lookupResponseEbs
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getWhslSetupDate(String lookupResponseEbs) {

        Date lastPayment = null;
        /* BEGIN BZ29592 */
        if (StringUtils.isNotEmpty(lookupResponseEbs)) {

            try {
                JSONObject req = new JSONObject(lookupResponseEbs);
                JSONObject whls = req.getJSONObject(CawJSONConstant.JSON_AVAILABLE_PRICING);
                String val = CawJSONUtils
                        .getString(whls, CawJSONConstant.JSON_MEMBERSHIP, CawJSONConstant.JSON_JOIN_DATE);
                if (val != null && val.length() > 0) {
                    lastPayment = new Date(val);
                }
            } catch (JSONException ex) {
                _logger.error("getWhslSetupDate-1: " + ex.getMessage());
            } catch (Exception ex) {
                _logger.error("getWhslSetupDate-2: " + ex.getMessage());
            }
        }
        /* END BZ29592 */
        return lastPayment;
    }

    /**
     * Get last payment date
     * @param lookupResponseEbs
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getWhslLastPayment(String lookupResponseEbs) {

        Date lastPayment = null;
        /* BEGIN BZ29592 */
        if (StringUtils.isNotEmpty(lookupResponseEbs)) {
            try {
                JSONObject req = new JSONObject(lookupResponseEbs);
                String val = CawJSONUtils
                        .getString(req, CawJSONConstant.JSON_AR_INFO, CawJSONConstant.JSON_AR_LAST_PAYMENT);
                if (val != null && val.length() > 0) {
                    lastPayment = new Date(val);
                }
            } catch (JSONException ex) {
                _logger.error("getWhslLastPayment-1: " + ex.getMessage());
            } catch (Exception ex) {
                _logger.error("getWhslLastPayment-2: " + ex.getMessage());
            }
        }
        /* END BZ29592 */
        return lastPayment;
    }

    public static String getAccountNumber(String lookupResponseEbs) {

        String val = null;
        try {
            JSONObject req = new JSONObject(lookupResponseEbs);
            val = CawJSONUtils.getString(req, CawJSONConstant.JSON_ACCOUNT_NUMBER);
        } catch (JSONException ex) {
            _logger.error("getAccountNumber-1: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("getAccountNumber-2: " + ex.getMessage());
        }
        return val;
    }

    /**
     * @param argDateProvider
     * @param argRetailLocationId
     * @param argParty
     * @param argCreditLimit
     * @return
     */
    public static ICustomerConsumerChargeAccount createNewHouseAccount(IDateProvider argDateProvider,
            long argRetailLocationId, IParty argParty, BigDecimal argCreditLimit, String argTendId,
            IPersistablesBag argBag) {

        //Begin BZ23724: additional condition for house account existed in cat_cust_acct or not
        String houseAccountIdKey = "";

        CustomerAccountId temp = new CustomerAccountId();

        IDataModel result = null;
        do {
            houseAccountIdKey = SequenceFactory.getNextStringValue(CawConstants.HOUSE_ACCOUNT_TYPE);

            temp.setCustAccountId(houseAccountIdKey);

            temp.setCustAccountCode(CawConstants.HOUSE_ACCOUNT_TYPE);

            result = DataFactory.getObjectByIdNoThrow(temp);
        } while (result != null);
        //End BZ23724
        // Create cat_cust_acct
        CustomerAccountId id = new CustomerAccountId();

        id.setCustAccountId(houseAccountIdKey);

        id.setCustAccountCode(argTendId);//BZ24405

        ICustomerAccount custAcct = DataFactory.createObject(id, ICustomerAccount.class);

        custAcct.setAccountBalance(new BigDecimal(0));

        custAcct.setRetailLocationId(argRetailLocationId);

        custAcct.setCustIdentityTypeCode(argParty.getPartyTypeCode());

        custAcct.setPartyId(argParty.getPartyId());

        custAcct.setParty(argParty);

        custAcct.setCustAccountStateCode(HouseAccountStateType.OPEN_ACCOUNT.toString());

        final Date today = argDateProvider.getDate();

        custAcct.setLastActivityDate(today);

        custAcct.setAccountSetupDate(today);

        ICustomerConsumerChargeAccount custConsumerChargeAcct = DataFactory
                .createObject(id, ICustomerConsumerChargeAccount.class);

        custConsumerChargeAcct.setRetailLocationId(argRetailLocationId);

        custConsumerChargeAcct.setCustAccountStateCode(HouseAccountStateType.OPEN_ACCOUNT.toString());

        custConsumerChargeAcct.setCustIdentityTypeCode(argParty.getPartyTypeCode());

        custConsumerChargeAcct.setPartyId(argParty.getPartyId());

        custConsumerChargeAcct.setParty(argParty);

        custConsumerChargeAcct.setLastActivityDate(today);

        custConsumerChargeAcct.setAccountSetupDate(today);

        custConsumerChargeAcct.setCreditLimit(argCreditLimit);

        custConsumerChargeAcct.setAvailableCredit(argCreditLimit);

        custConsumerChargeAcct.setAccountBalance(BigDecimal.ZERO);//BZ27199

        HouseAcctBuyerModel buyerModel = new HouseAcctBuyerModel();

        IChargeAccountUser userToBeAdded = buyerModel.getHouseAccountBuyer();

        userToBeAdded.setCustAccountId(houseAccountIdKey);

        userToBeAdded.setCustAccountCode(argTendId);

        userToBeAdded.setAccountUserFirstName(argParty.getFirstName());

        userToBeAdded.setAccountUserLastName(argParty.getLastName());

        userToBeAdded.setAccountUserName(argParty.getFirstName() + " " + argParty.getLastName());

        userToBeAdded.setPrimaryContact(true);

        custConsumerChargeAcct.addChargeAccountUser(userToBeAdded);

        argBag.addAllObjects(new IDataModel[] { custAcct, custConsumerChargeAcct, argParty });
        try {
            argBag.persist();
        } catch (dtv.data2.access.exception.PersistenceException ex) {
            _logger.error(ex);
        }
        return custConsumerChargeAcct;
    }
    // BZ27000 end

    // Begin BZ26982
    public static boolean isNullName(JSONObject lookupResponseEbs) {

        Boolean val = Boolean.FALSE;
        try {
            JSONObject objName = lookupResponseEbs.getJSONObject(CawJSONConstant.JSON_NAME);
            if ((objName == null) || (objName.isNull(CawJSONConstant.JSON_FIRST_NAME))
                    || (objName.isNull(CawJSONConstant.JSON_LAST_NAME))) {
                val = Boolean.TRUE;
            }
        } catch (JSONException ex) {
            _logger.error("getName-1: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("getName-2: " + ex.getMessage());
        }
        return val;
    }
    // End BZ26982

    /* BEGIN BZ27535 */

    public static String getTaxCertificate(String lookupResponseEbs) {
        String taxCertificate = "";

        try {
            if (lookupResponseEbs != null && lookupResponseEbs.length() > 0) {
                JSONObject req = new JSONObject(lookupResponseEbs);

                taxCertificate = req.getString(CawJSONConstant.JSON_TAX_CERTIFICATE);
                /*BEGIN BZ33615*/
                if(StringUtils.isEmpty(taxCertificate)) {
                    taxCertificate = CawJSONConstant.NO_CERTIFICATE;
                }
                /*END BZ33615*/  
            }
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method getTaxCertificate: " + ex.getMessage());
        }
        return taxCertificate;
    }
    /* END BZ27535 */

    /* Begin BZ27651: To reuse and void duplication*/
    public static String getCustomerType(String argJsonSource) {

        String response = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                response = res.getString(CawJSONConstant.JSON_CUSTOMER_TYPE);
            } catch (JSONException ex) {
                _logger.error("Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public static String getCustomerFirstName(String argJsonSource) {

        String response = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                response = res.getJSONObject(CawJSONConstant.JSON_NAME).getString(CawJSONConstant.JSON_FIRST_NAME);
            } catch (JSONException ex) {
                _logger.error("Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public static String getCustomerLastName(String argJsonSource) {

        String response = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                response = res.getJSONObject(CawJSONConstant.JSON_NAME).getString(CawJSONConstant.JSON_LAST_NAME);
            } catch (JSONException ex) {
                _logger.error("Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public static String getCustomerCountry(String argJsonSource) {

        String response = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                response = res.getJSONObject(CawJSONConstant.JSON_ADDRESS).getString(CawJSONConstant.JSON_COUNTRY);
            } catch (JSONException ex) {
                _logger.error("Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public static String getCustomerCity(String argJsonSource) {

        String response = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                response = res.getJSONObject(CawJSONConstant.JSON_ADDRESS).getString(CawJSONConstant.JSON_CITY);
            } catch (JSONException ex) {
                _logger.error("Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public static String getCustomerState(String argJsonSource) {

        String response = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                response = res.getJSONObject(CawJSONConstant.JSON_ADDRESS).getString(CawJSONConstant.JSON_STATE);
            } catch (JSONException ex) {
                _logger.error("Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public static String getCustomerZip(String argJsonSource) {

        String postalCode = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                if (!res.isNull(CawJSONConstant.JSON_ADDRESS)) {
                    if (!res.getJSONObject(CawJSONConstant.JSON_ADDRESS).isNull(CawJSONConstant.JSON_POSTAL_CODE)) {
                        postalCode = res.getJSONObject(CawJSONConstant.JSON_ADDRESS)
                                .getString(CawJSONConstant.JSON_POSTAL_CODE);

                        if (postalCode != null && postalCode.length() > 5) {
                            postalCode = postalCode
                                    .substring(CawJSONConstant.POSTAL_CODE_FIRST_INDEX, CawJSONConstant.POSTAL_CODE_LAST_INDEX);
                        }
                    }
                }
            } catch (JSONException ex) {
                _logger.error("Can not get postalCode from response at ESB: " + ex.getMessage());
            }
        }

        return postalCode;

    }

    public static String getCustomerAddressLine1(String argJsonSource) {

        String response = null;
        if (argJsonSource != null && !argJsonSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argJsonSource);
                response = res.getJSONObject(CawJSONConstant.JSON_ADDRESS).getString(CawJSONConstant.JSON_LINE1);
            } catch (JSONException ex) {
                _logger.error("JSON Exception: " + ex.getMessage());
            }
        }
        return response;
    }

    public static String getCompanyName(String argSource) {

        String response = null;
        if (argSource != null && !argSource.isEmpty()) {
            try {
                JSONObject res = new JSONObject(argSource);
                response = res.getJSONObject(CawJSONConstant.JSON_NAME).getString(CawJSONConstant.JSON_COMPANY);
            } catch (JSONException ex) {
                _logger.error("Json Object Exception: " + ex.getMessage());
            }
        }
        return response;
    }
    /* Begin BZ27651 End */

    // Begin BZ27651
    /**
     * The method build cashier information with format JSON
     * @param iParty
     * @return
     */
    public static JSONObject buildCashierInfoJSONObject(IParty iParty) {

        JSONObject cashierInfo = null;
        if (iParty != null) {
            try {
                cashierInfo = new JSONObject();
                cashierInfo.put(CawJSONConstant.CASHIER_CODE, CawJSONConstant.SPACE_CHARACTER);
                if (StringUtils.isNotEmpty(iParty.getEmployeeId())) {
                    cashierInfo.put(CawJSONConstant.CASHIER_CODE, iParty.getEmployeeId());
                }

                cashierInfo.put(CawJSONConstant.CASHIER_NAME, CawJSONConstant.SPACE_CHARACTER);
                if (StringUtils.isNotEmpty(iParty.getFirstName()) && StringUtils.isNotEmpty(iParty.getLastName())) {
                    cashierInfo.put(CawJSONConstant.CASHIER_NAME, iParty.getFirstName() + " " + iParty.getLastName());
                }

                cashierInfo.put(CawJSONConstant.CASHIER_FILE_NUMBER, CawJSONConstant.SPACE_CHARACTER);
                if (iParty.getPartyId() > 0) {
                    cashierInfo.put(CawJSONConstant.CASHIER_FILE_NUMBER, String.valueOf(iParty.getPartyId()));
                }

            } catch (Exception ex) {
                _logger.error("The method buildCashierInfoJsonObject() can not build object." + ex.getMessage());
            }

        }

        return cashierInfo;

    }

    // End BZ27651
    // BZ27339 start
    /**
     * @param lookupResponseEbs
     * @return
     */
    public static String getArCreditHold(String lookupResponseEbs) {

        String arCreditHold = "";
        try {
            if (lookupResponseEbs != null && lookupResponseEbs.length() > 0) {
                JSONObject result = CawJSONUtils.toJSONObject(lookupResponseEbs);
                JSONObject locs = result.getJSONObject(CawJSONConstant.JSON_AR_INFO);
                if (locs != null && locs.getBoolean(CawJSONConstant.JSON_AR_CREDIT_HOLD)) {
                    arCreditHold = CawConstants.CUST_TAX_EXEMPT_YES;
                } else {
                    arCreditHold = CawConstants.CUST_TAX_EXEMPT_NO;
                }
            }
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method getArCreditHold: " + ex.getMessage());
        }
        return arCreditHold;
    }

    /**
     * Get account# from IParty customer object
     * @param party
     * @return
     */
    public static String getAccountNumber(IParty party) {

        String val = null;
        try {
            if (party != null) {
                List<IPartyIdCrossReference> idRefs = party.getAlternatePartyIds();
                if (idRefs != null && idRefs.size() > 0) {
                    IPartyIdCrossReference id = idRefs.get(0);
                    val = id.getAlternateId();
                }
            }
        } catch (Exception ex) {
            _logger.error("getAccountNumber-2: " + ex.getMessage());
        }
        return val;
    }
    // BZ27339 end

    /**
     * BZ25761
     * Get phone numbers from iParty
     * @param iParty
     * @return
     */
    public static Map<String, String> getPhoneNumberIParty(IParty iParty) {

        Map<String, String> phoneNumbers = new HashMap<String, String>();
        List<IPartyTelephone> listPhone = iParty.getTelephoneInformation();
        IPartyLocaleInformation pli = iParty.getPrimaryLocaleInformation();
        TelephoneFormatter formatter = new TelephoneFormatter();

        if (CollectionUtils.isNotEmpty(listPhone) && pli != null) {
            String number = "";
            String type = "";
            Locale locale = Locale.forLanguageTag(pli.getCountry());

            for (IPartyTelephone phone : listPhone) {
                number = formatter.format(phone.getTelephoneNumber(), locale);
                type = phone.getTelephoneType();

                if (StringUtils.isNotEmpty(number) && StringUtils.isNotEmpty(type)) {
                    if (!phoneNumbers.containsKey(type)) {
                        phoneNumbers.put(type, number);
                    }
                }
            }
        }
        return phoneNumbers;
    }

    /**
     * BZ25761
     * (Type = 1: Address line 1)
     * (Type = 2: City)
     * (Type = 3: State)
     * (Type = 4: full Zipcode)
     * @param iParty
     * @return
     */
    public static String getAddressInfoIParty(IParty iParty, int type) {

        String value = "";
        IPartyLocaleInformation pli = iParty.getPrimaryLocaleInformation();
        if (pli != null) {
            switch (type) {
            case 1:
                value = pli.getAddress1();
                break;
            case 2:
                value = pli.getCity();
                break;
            case 3:
                value = pli.getState();
                break;
            case 4:
                value = pli.getPostalCode();
                /* BEGIN BZ29316: get full Zipcode
                if (value != null && value.length() > 5) {
                    value = value
                            .substring(CawJSONConstant.POSTAL_CODE_FIRST_INDEX, CawJSONConstant.POSTAL_CODE_LAST_INDEX);
                }
                END BZ29316*/
                break;
            }
        }
        return value;
    }

    /*BEGIN BZ29316*/
    /**
     * Get first 5 chars of the full zipcode
     * @param full ZipCode
     * @return partial Zipcode
     */
    public static String getPartialZipcode(IParty iParty) {

        String zipcode = CawCustomerUtil.getAddressInfoIParty(iParty, CawCustomerAddressFieldType.POSTAL_CODE); //BZ-29515
        if (zipcode != null && zipcode.length() > 5) {
            zipcode = zipcode
                    .substring(CawJSONConstant.POSTAL_CODE_FIRST_INDEX, CawJSONConstant.POSTAL_CODE_LAST_INDEX);
        }
        return zipcode;
    }
    /*END BZ29316*/

    /**
     * BZ-23563, BZ25761
     * @param argParty
     * @return
     */
    public static String getEBSAccountNumber(IParty argParty) {

        String accountNo = null;
        IParty tmpParty = argParty;
        if (argParty != null) {
            /*Force reload Party Model due to Xstore Caching*/
            if (argParty.getAlternatePartyIds().isEmpty()) {
                PartyId partyId = new PartyId();
                partyId.setPartyId(argParty.getPartyId());
                IParty iParty = DataFactory.getObjectByIdNoThrow(partyId);
                if (iParty != null) {
                    tmpParty = iParty;
                }
            }
            List<IPartyIdCrossReference> altIds = tmpParty.getAlternatePartyIds();
            if (altIds != null) {
                for (IPartyIdCrossReference altId : altIds) {
                    if (CawEBSConstant.ALTERNATE_ID_OWNER.equals(altId.getAlternateIdOwner())) {
                        accountNo = altId.getAlternateId();
                    }
                }
            }
        }
        return accountNo;
    }

    /**
     * BZ-23563, BZ25761
     * @param argAccountNumber
     * @return
     */
    public static String getCustomerDetailResponse(String argAccountNumber) {
        /* BEGIN BZ28033 */
        //BZ26575 changed by using CawEBSHelper

        String esbResponse = CawCatalystHelper.getLookupResponseData();
        if (StringUtils.isEmpty(esbResponse)) {
            esbResponse = CawEBSHelper.getInstance()
                    .lookupCustomerInEBS(argAccountNumber, CawPropertyUtils.STORE_NUMBER);/*BZ27535*/
            CawCatalystHelper.setLookupResponseData(esbResponse);
        }
        /*Begin BZ25858*/
        if (StringUtils.isNotEmpty(esbResponse)) {
            return esbResponse;
        }
        return null;
        /*End BZ25858*/
        /* END BZ28033 */
    }

    /**
     * Check case Club Price or Your Price  <br>
     * Case 1: If happen exception, this is non member using Your Price <br>
     * Case 2: If condition below equal null or empty, this is customer have not joined membership using Your Price <br>
     * Case 3: If customer is membership: <br>
     *         3.1: If Retail Pricing (Expired,...) using Your Price <br>
     *         3.2: Extant (Club, Crew,..) using Club Price <br>
     * @param argSource <br>
     * @return
     */

    /* BEGIN BZ28688 */
    public static boolean isClubOfSpecialReceipt(IParty argSource) {
        long org = 1L;
        String customerGroupId = "";
        String response = CawCatalystHelper.getLookupResponseData();
        List<CawCustomerMembershipView> outCustomerMembershipViews = null;
        outCustomerMembershipViews = CawMembershipHelper.getInstance().getReloadMemberships(response);
        /*No customer*/
        if (argSource != null) {
            org = argSource.getOrganizationId();
        } else {
            return false;
        }

        /*EBS response is null*/
        if (response != null) {
            customerGroupId = getCustomerGroupIdFromEBS(response, org, outCustomerMembershipViews);
            /*Check customer group, map with COM_CODE_VALUE*/
            if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME.equals(customerGroupId)) {
                return false;
            }
        } else {
            return isClubCustomerGroupID(argSource);//BZ28688
        }

        return true;
    }

    /**
     * Get customer group id from EBS to Print Receipt
     * @param
     * @return
     */

    public static String getCustomerGroupIdFromEBS(String jsonCustomerResponse, long orgId,
            List<CawCustomerMembershipView> customerMembershipViews) {

        JSONObject result = null;
        JSONObject obPricing = null;
        JSONObject obMembership = null;
        String customerGroupId = "";
        String description = "";
        String band = "";
        String benefitLevelName = "";

        if (jsonCustomerResponse == null || jsonCustomerResponse.length() == 0) {
            return customerGroupId;
        }

        try {
            result = CawJSONUtils.toJSONObject(jsonCustomerResponse);
            obPricing = CawJSONUtils.getJSONObject(result, PRICING_TAG);
            if (obPricing != null) {
                obMembership = CawJSONUtils.getJSONObject(obPricing, MEMBERSHIP_TAG);
                if (obMembership != null) {

                    if (!obPricing.isNull(BAND_TAG)) {

                        benefitLevelName = obMembership.getString(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_NAME_ATTR);

                        if (!StringUtils.isEmpty(benefitLevelName)
                                && CawCustomerConstants.CAW_CUSTOMER_ELITE_LEVEL.equals(benefitLevelName)) {
                            ICodeValue value = null;
                            CodeValueId id = new CodeValueId();
                            id.setOrganizationId(orgId);
                            id.setCategory(CawCustomerConstants.CAW_CUSTOMER_GROUPS_LEVEL);
                            id.setCode(StringUtils.upperCase(benefitLevelName));
                            try {
                                value = (ICodeValue) DataFactory.getObjectById(id);
                                if (value != null) {
                                    description = value.getCode();
                                }
                            } catch (ObjectNotFoundException e) {
                                _logger.warn("Could not find Customer Group level [" + id.getCode() + "]"
                                        + e.getMessage());
                            }

                        } else {
                            band = obPricing.getString(BAND_TAG);
                            if (band != null) {
                                ICodeValue value = null;
                                CodeValueId id = new CodeValueId();
                                id.setOrganizationId(orgId);
                                id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                                if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME.equalsIgnoreCase(band)) {
                                    id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                                } else {
                                    id.setCode(band);
                                }
                                try {
                                    value = (ICodeValue) DataFactory.getObjectById(id);
                                    if (value != null) {
                                        description = value.getCode();
                                    }
                                } catch (ObjectNotFoundException e) {
                                    _logger.warn("Could not find Customer Group [" + id.getCode() + "]"
                                            + e.getMessage());
                                }
                            }
                        }
                    }
                    customerGroupId = description;
                } else {

                    if (customerMembershipViews != null && customerMembershipViews.size() > 0) {
                        band = obPricing.getString(BAND_TAG);
                        if (band != null) {
                            ICodeValue value = null;
                            CodeValueId id = new CodeValueId();
                            id.setOrganizationId(orgId);
                            id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                            if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME.equalsIgnoreCase(band)) {
                                id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                            } else {
                                id.setCode(band);
                            }
                            try {
                                value = (ICodeValue) DataFactory.getObjectById(id);
                                if (value != null) {
                                    description = value.getCode();
                                }
                            } catch (ObjectNotFoundException e) {
                                _logger.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
                            }
                        }
                        customerGroupId = description;
                    } else {
                        ICodeValue value = null;
                        CodeValueId id = new CodeValueId();
                        id.setOrganizationId(orgId);
                        id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                        id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                        try {
                            value = (ICodeValue) DataFactory.getObjectById(id);
                            if (value != null) {
                                description = value.getCode();
                            }
                        } catch (ObjectNotFoundException e) {
                            _logger.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
                        }

                        customerGroupId = description;
                    }

                }
            }
        } catch (Exception ex) {
            _logger.error("getPricingInformation: There is no membership from EBS response." + ex.getMessage());
        }
        return customerGroupId;
    }

    /**
     * Get customer group id from  ICustomerAffiliation to Print Receipt
     * @param argSource as IParty
     * @return  true if CustomerGroupId In (CUSTOMER_GROUP_TYPE_CLUB_NEW_NAME, CUSTOMER_GROUP_TYPE_CLUB_OLD_NAME, 
     * CUSTOMER_GROUP_TYPE_CREW_NEW_NAME, CUSTOMER_GROUP_TYPE_CREW_OLD_NAME, CUSTOMER_GROUP_TYPE_WHSL_NEW_NAME, CUSTOMER_GROUP_TYPE_WHSL_OLD_NAME) 
     */
    public static boolean isClubCustomerGroupID(IParty argSource) {

        List<ICustomerAffiliation> customerAffiliation = null;
        String priceHeader = "";
        if (CollectionUtils.isNotEmpty(argSource.getCustomerGroups())) {
            customerAffiliation = argSource.getCustomerGroups();
            for (ICustomerAffiliation icustomerAffiliation : customerAffiliation) {

                priceHeader = icustomerAffiliation.getCustomerGroupId();
                if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_NEW_NAME.equals(priceHeader)
                        || CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_OLD_NAME.equals(priceHeader)
                        || CawPropertyUtils.CUSTOMER_GROUP_TYPE_CREW_NEW_NAME.equals(priceHeader)
                        || CawPropertyUtils.CUSTOMER_GROUP_TYPE_CREW_OLD_NAME.equals(priceHeader)
                        || CawPropertyUtils.CUSTOMER_GROUP_TYPE_WHSL_NEW_NAME.equals(priceHeader)
                        || CawPropertyUtils.CUSTOMER_GROUP_TYPE_WHSL_OLD_NAME.equals(priceHeader)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* END BZ28688 */
    /* BEGIN BZ29124 */
    /**
     * Check the existed the AR or ThirdParty in transaction
     * @param iPosTransaction
     * @return
     */
    public static boolean isExistedARAccountOrThirdparty(IPosTransaction iPosTransaction) {

        if (iPosTransaction != null) {

            List<ITenderLineItem> tenderLists = iPosTransaction.getLineItems(ITenderLineItem.class);

            if (CollectionUtils.isNotEmpty(tenderLists)) {

                for (ITenderLineItem tenderLineItem : tenderLists) {

                    if (!tenderLineItem.getVoid()) {

                        if (CawConstants.AR_ACCOUNT.equalsIgnoreCase(tenderLineItem.getTenderId())
                                || (CawConstants.THIRD_PARTY.equalsIgnoreCase(tenderLineItem.getTenderId()))) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    /* END BZ29124 */
    /* BEGIN BZ29387 */
    /**
     * Check House Account Payment
     * @param pos
     * @param isAccountPayment
     * @return
     */
    public static boolean isAccountPayment(IPosTransaction pos, boolean isAccountPayment) {

        boolean valid = false;
        if (pos != null) {
            List<IRetailTransactionLineItem> tranLineItems = pos.getRetailTransactionLineItems();
            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof AccountReceivableSaleLineItemModel) {
                    if (isAccountPayment /* "Need to remove out of TRUNK BRANCH" && itemPayment.getScannedItemId() != null
                                         && itemPayment.getScannedItemId().length() >= 28
                                         && itemPayment.getScannedItemId().contains(CawConstants.CAW_MARKED_PAN)*/) {

                        valid = true;
                        break;

                    }
                }
            }
        }
        return valid;
    }

    /* END BZ29387 */
    /* BEGIN BZ29388 */
    public static String getAccountPaymentNumber(IRetailTransaction transaction) {
        String accountPaymentNumber = "";
        List<IRetailTransactionLineItem> tranLineItems = null;
        if (transaction != null) {
            tranLineItems = transaction.getRetailTransactionLineItems();
        }
        if (tranLineItems != null && tranLineItems.size() > 0) {
            ISaleReturnLineItem returnLineItem = null; //BZ27414
            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof ISaleReturnLineItem && !lineItem.getVoid()) {
                    returnLineItem = (ISaleReturnLineItem) lineItem;
                    if (returnLineItem.getScannedItemId() != null
                            && returnLineItem.getScannedItemId().contains(CawConstants.ACCOUNT_ID_LABEL)
                            && CawConstants.GS_ACCOUNT_PAYMENT.equalsIgnoreCase(returnLineItem.getItemDescription())
                            && returnLineItem.getScannedItemId().length() >= 28) {
                        accountPaymentNumber = returnLineItem.getScannedItemId().substring(12);
                    }

                }
            }
        }
        return accountPaymentNumber;
    }

    /* END BZ29388 */
    /* BEGIN BZ28012 */
    /**
     * Get application status retry times
     * @return
     */
    public static int getApplicationStatusRetriesTime() {

        int retryTimes = 0;

        List<String> retryLists = CodeLocator
                .getCodes(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_APP_STATUS_RETRY_TIMES);

        if (CollectionUtils.isNotEmpty(retryLists) && StringUtils.isNumeric(retryLists.get(0))) {
            retryTimes = Integer.parseInt(retryLists.get(0));
        }

        return retryTimes;
    }
    /* END BZ28012 */

    /* BEGIN BZ29600 */
    /* BEGIN BZ29592 */
    /**
     * @param jsonPricing
     * @return
     */
    public static boolean isWhslCustomer(String jsonPricing) {

        JSONObject jsonPricingObj = null;

        JSONObject jsonMemberShipObj = null;

        String memberShipType = null;

        try {
            /* BEGIN BZ29592 */
            jsonPricingObj = new JSONObject(jsonPricing);

            if (jsonPricingObj.has(CawEBSConstant.PRICE_MEMBERSHIP)
                    && !jsonPricingObj.isNull(CawEBSConstant.PRICE_MEMBERSHIP))

            {
                Object memberShip = jsonPricingObj.get(CawEBSConstant.PRICE_MEMBERSHIP);

                if (memberShip != null && !memberShip.equals("")) {

                    jsonMemberShipObj = jsonPricingObj.getJSONObject(CawEBSConstant.PRICE_MEMBERSHIP);

                }

                if (jsonMemberShipObj != null && jsonMemberShipObj.has(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                        && !jsonMemberShipObj.isNull(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)) { // BZ-44053

                    Object memberShipTypeObj = jsonMemberShipObj.get(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR); // BZ-44053

                    if (memberShipTypeObj != null && !memberShipTypeObj.equals("")) {

                        memberShipType = jsonMemberShipObj.getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR); // BZ-44053

                    }

                    if (StringUtils.isNotEmpty(memberShipType)) {
                        /*BEGIN BZ45486*/
                        //split wholesale identify to string array
                        String[] whslTypes = CawCustomerConstants.CAW_WHOLESALE_IDENTIFY.trim().split(CawCustomerConstants.CAW_SPLIT_STRING_COMMA);
                        return Arrays.asList(whslTypes).contains(memberShipType);
                        /*END BZ45486*/
                    }
                }

            }
            /* END BZ29592 */
        } catch (JSONException ex) {
            _logger.error("Could not check wholesale from json pricing: " + ex.getMessage());
            return false;
        }
        /* BEGIN BZ33598: catch null exception */
        catch (NullPointerException ex) {
            _logger.error("Error in isWhslCustomer: " + ex.getMessage());
        return false;
        }
        /* END BZ33598 */
        return false;
    }
    /* END BZ29592 */
    /* END BZ29600 */

    /* BEGIN BZ29515 */
    /**
     * 
     * @param iParty
     * @param addressFieldType
     * @return
     */
    public static String getAddressInfoIParty(IParty iParty, CawCustomerAddressFieldType addressFieldType) {

        String value = "";
        IPartyLocaleInformation pli = iParty.getPrimaryLocaleInformation();
        if (pli != null && addressFieldType != null) {
            switch (addressFieldType) {
            case ADDRESS1: {
                if (StringUtils.isNotEmpty(pli.getAddress1())) {
                    value = pli.getAddress1();
                }
                break;
            }
            case ADDRESS2: {

                if (StringUtils.isNotEmpty(pli.getAddress2())) {
                    value = pli.getAddress2();
                }
                break;
            }
            case ADDRESS3: {

                if (StringUtils.isNotEmpty(pli.getAddress3())) {
                    value = pli.getAddress3();
                }
                break;
            }
            case ADDRESS4: {
                if (StringUtils.isNotEmpty(pli.getAddress4())) {
                    value = pli.getAddress4();
                }
                break;
            }
            case ADDRESS_TYPE: {
                if (StringUtils.isNotEmpty(pli.getAddressType())) {
                    value = pli.getAddressType();
                }
                break;
            }
            case APARTMENT: {
                if (StringUtils.isNotEmpty(pli.getApartment())) {
                    value = pli.getApartment();
                }
                break;
            }
            case CITY: {
                if (StringUtils.isNotEmpty(pli.getCity())) {
                    value = pli.getCity();
                }
                break;
            }
            case POSTAL_CODE: {
                if (StringUtils.isNotEmpty(pli.getPostalCode())) {
                    value = pli.getPostalCode();
                }
                break;
            }
            case STATE: {
                if (StringUtils.isNotEmpty(pli.getState())) {
                    value = pli.getState();
                }
                break;
            }
            case COUNTRY: {
                if (StringUtils.isNotEmpty(pli.getCountry())) {
                    value = pli.getCountry();
                }
                break;
            }
            }
        }
        return value;
    }
    /* END BZ29515 */

    /*BEGIN BZ29514*/
    /**
     * Type: 1-Home, 2-Mobile
     * @param iParty
     * @param type
     * @return phone number without format
     */
    public static String getPhoneNumberByType(IParty iParty, int type) {

        String phoneNumber = null;
        Map<String, String> phoneNumbers = CawCustomerUtil.getPhoneNumberIParty(iParty);
        if (!CollectionUtils.sizeIsEmpty(phoneNumbers)) {
            switch (type) {
            case 1:
                phoneNumber = phoneNumbers.get(CawConstants.HOME);
                break;
            case 2:
                phoneNumber = phoneNumbers.get(CawConstants.MOBILE);
                break;
            }
        }
        if (phoneNumber == null) {
            phoneNumber = "";
        }
        return phoneNumber;
    }
    /*END BZ29514*/

    /*BEGIN BZ31523, BZ33497: re-factor the way we checking Crew customer*/
    /**
     * Check crew customer from EBS
     * @param argCustomer
     * @return
     */
    public static boolean isCrewCustomerFromEBS(IParty argCustomer) {

        String jsonCustomerLookup = CawCatalystHelper.getLookupResponseData();

        if (StringUtils.isNotEmpty(jsonCustomerLookup)) {
            return isCrewCustomerFromEBS(jsonCustomerLookup);
        } else {
            String jsonOffilne = CawCustomerHelper.getInstance().buildCustomerJsonObjectOffline(argCustomer);
            if (StringUtils.isNotEmpty(jsonOffilne)) {
                return isCrewCustomerFromEBS(jsonOffilne);
            }
        }
        return false;
    }

    /**
     * 
     * @param jsonPricing
     * @return
     */
    public static boolean isCrewCustomerFromEBS(String jsonCustomerLookup) {

        JSONObject jsonObjectCustomerLookup = null;
        JSONArray memberShips = null;
        JSONObject memberShip = null;
        String memberShipType = null;
        try {
            jsonObjectCustomerLookup = new JSONObject(jsonCustomerLookup);

            if (jsonObjectCustomerLookup.has(CawJSONConstant.JSON_MEMBERSHIPS)
                    && !jsonObjectCustomerLookup.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                memberShips = jsonObjectCustomerLookup.getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);

                if (memberShips != null && memberShips.length() > 0) {
                    int length = memberShips.length();

                    for (int i = 0; i < length; i++) {
                        memberShip = memberShips.getJSONObject(i);
                        memberShipType = CawUtilFunction
                                .vString(memberShip.getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)); // BZ-44053

                        if (StringUtils.isNotEmpty(memberShipType)) {
                            /*BEGIN BZ45486*/
                            //split CREW identify to string array
                            String[] whslTypes = CawCustomerConstants.CAW_CREW_IDENTIFY.trim().split(CawCustomerConstants.CAW_SPLIT_STRING_COMMA);
                            return Arrays.asList(whslTypes).contains(memberShipType);
                            /*END BZ45486*/
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.error("Could not check crew from json pricing: " + ex.getMessage());
            return false;
        }
        /* BEGIN BZ33598: catch null exception */
        catch (NullPointerException ex) {
            _logger.error("Error in isWhslCustomer: " + ex.getMessage());
        return false;
        }
        /* END BZ33598 */
        return false;
    }
    /* END BZ33497: re-factor the way we checking Crew customer*/

    /**
     * 
     * @param argSource
     * @return
     */
    public static boolean isClubCustomerXstore(IParty argSource) {

        List<ICustomerAffiliation> customerAffiliation = null;
        String priceHeader = "";
        if (argSource != null && CollectionUtils.isNotEmpty(argSource.getCustomerGroups())) { /*BZ33497: check null*/
            customerAffiliation = argSource.getCustomerGroups();
            for (ICustomerAffiliation icustomerAffiliation : customerAffiliation) {

                priceHeader = icustomerAffiliation.getCustomerGroupId();
                if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_NEW_NAME.equals(priceHeader)
                        || CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_OLD_NAME.equals(priceHeader)) {
                    return true;
                }
            }
        }
        return false;
    }
    /*END BZ31523*/

    /* BEGIN BZ32272 */
    /**
     * Check if clubNumber start with 73 and cut correct club number
     * Ex: 73000121100143 -> 121100143
     * @param clubNumber: club number - 73000121100143
     * @return result - 121100143
     */
    public static String trimGSMNumber(String clubNumber) {

        String tmpStr = clubNumber;
        if (CawCustomerConstants.LOYALTY_NUMBER_TRIM.equals(clubNumber.substring(0, 2))) {
            tmpStr = clubNumber.substring(2);
            tmpStr = StringUtils.stripStart(tmpStr, "0");
        }
        return tmpStr;
    }
    /* END BZ32272 */

    /*Begin BZ33894*/
    /**
     * 
     * @return
     */
    public static boolean isAllowEdit() {

        return isAllowEdit(CawCatalystHelper.getLookupResponseData());
    }

    /**
     * 
     * @param jsonCustLookupResponse
     * @return
     */
    public static boolean isAllowEdit(String jsonCustLookupResponse) {

        boolean allowEdit = false;
        try {
            if (StringUtils.isNotEmpty(jsonCustLookupResponse)) {// BZ44053
                JSONObject req = new JSONObject(jsonCustLookupResponse);
                if (req.has(CawJSONConstant.JSON_ALLOW_EDIT)) {
                    allowEdit = req.getBoolean(CawJSONConstant.JSON_ALLOW_EDIT);
                }
            }
        } catch (JSONException ex) {
            _logger.error("Error in isAllowEdit-0: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error in isAllowEdit-1: " + ex.getMessage());
        }
        return allowEdit;
    }
    /*End BZ33894*/
    
    /*BEGIN BZ33598*/
    /**
     * 
     * @param jsonCustLookupResponse
     * @return
     */
    public static boolean isLoadingCrewWhslModel() {

        boolean result = false;
        String jsonResponseEbs = CawCatalystHelper.getLookupResponseData();
        String pricingAtt = getJsonPricing(jsonResponseEbs);

        if (isWhslCustomer(pricingAtt) || isCrewCustomerFromEBS(jsonResponseEbs)) {
            result = true;
        }
        return result;
    }
    /*END BZ33598*/

    /* BEGIN BZ30259 */
    /***
     * Get list messages of customer.
     * @param argSource
     * @return
     */
    public static String getCustomerMessages(IParty argSource) {
        String strValue = StringUtils.EMPTY;
        long org = 1L;
        List<String> listMembershipType = null;
        String newLine = dtv.util.StringUtils.NEW_LINE;
        String strResponCustomer = CawCatalystHelper.getLookupResponseData();
        ;
        //Transaction have customer
        if (argSource != null) {

            //Read customer info from DB when EBS offline
            if (dtv.util.StringUtils.isEmpty(strResponCustomer)) {

                strResponCustomer = CawCustomerHelper.getInstance().buildCustomerJsonObjectOffline(argSource);
            }
            org = argSource.getOrganizationId();
            listMembershipType = getListCustomerMembershipsTypeFromEBS(strResponCustomer, org);
            //Check customer memberships, map with COM_CODE_VALUE
            if (CollectionUtils.isNotEmpty(listMembershipType)) {

                for (int i = 0; i < listMembershipType.size(); i++) {

                    IReceiptText  iReceiptText = getReceiptText(ConfigurationMgr
                            .getOrganizationId(), CawCustomerConstants.CAW_MEMBERSHIP_MESS, listMembershipType.get(i));
                    if (iReceiptText != null) {
                        strValue += iReceiptText.getReceiptText() + newLine;
                    }
                }
            }
        }
        return strValue;
    }

    /***
     * Get list membership type of customer from EBS
     * @param jsonCustomerResponse
     * @param orgId
     * @return
     */
    public static List<String> getListCustomerMembershipsTypeFromEBS(
            String jsonCustomerResponse, long orgId) {

        JSONObject result = null;
        JSONObject jobMembership = null;
        JSONArray obMembership = null;
        List<String> listMembershipType = new ArrayList<>();
        String strStatus = StringUtils.EMPTY;
        String strMembershipTypeFromEBS = StringUtils.EMPTY;
        if (jsonCustomerResponse == null
                || jsonCustomerResponse.length() == 0) {
            return listMembershipType;
        }

        try {
            result = CawJSONUtils.toJSONObject(jsonCustomerResponse);
            if (result.has(CawJSONConstant.JSON_MEMBERSHIPS)
                    && StringUtils.isNotEmpty(result
                            .getString(CawJSONConstant.JSON_MEMBERSHIPS))) {
                obMembership = result
                        .getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                if (obMembership != null) {
                    for (int i = 0; i < obMembership.length(); i++) {

                        jobMembership = obMembership.getJSONObject(i);
                        if (jobMembership
                                .has(CawEBSConstant.MEMBERSHIPS_STATUS_ATTR)) {
                            strStatus = jobMembership
                                    .getString(CawEBSConstant.MEMBERSHIPS_STATUS_ATTR);
                        }
                        if (!CawCustomerConstants.MEMBERSHIPS_STATUS_EXPIRED
                                .equals(strStatus)) {
                            if (jobMembership
                                    .has(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)) {
                                strMembershipTypeFromEBS = jobMembership
                                        .getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR);
                                listMembershipType
                                        .add(strMembershipTypeFromEBS);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.debug("getMembershipTypeInformation: There is no membership from EBS response."
                    + ex.getMessage());
        }
        return listMembershipType;
    }

    public static IReceiptText getReceiptText(long argOrgId, String argTextCode, String argTextSubcode) {

        ReceiptTextId id = new ReceiptTextId();
        id.setOrganizationId(argOrgId);
        id.setTextCode(argTextCode);
        id.setTextSubcode(argTextSubcode);
        id.setTextSequence(0);
        id.setConfigElement("*");
        /* BEGIN BZ53159 */
        IReceiptText iReceiptText = DataFactory.getObjectByIdNoThrow(id);
        return iReceiptText;
        /* END BZ53159 */
    }
    /* END BZ30259 */
    
    /*BEGIN BZ37305*/
    public static String getEmailAddress(String jsonCustLookupResponse ) {
        String emailAddress = StringUtils.EMPTY;
        try {
            if (jsonCustLookupResponse != null) {
                JSONObject req = new JSONObject(jsonCustLookupResponse);
                if (req.has(CawJSONConstant.JSON_EMAIL_ADDRESS)) {
                    emailAddress = req.getString(CawJSONConstant.JSON_EMAIL_ADDRESS);
                }
            }
        } catch (JSONException ex) {
            _logger.error("Error in getEmailAddress-0: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error in getEmailAddress-1: " + ex.getMessage());
        }
        return emailAddress;
    }
    /*END BZ37305*/
    /* BEGIN BZ37642 */
    public static boolean isUseMemberPricing(IParty party) {

        List<ICustomerAffiliation> customerAffiliation = null;
        String customerGroup = "";
        if (party != null
                && CollectionUtils.isNotEmpty(party.getCustomerGroups())) {
            customerAffiliation = party.getCustomerGroups();
            for (ICustomerAffiliation icustomerAffiliation : customerAffiliation) {

                customerGroup = icustomerAffiliation.getCustomerGroupId();
                if (!(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME.equals(customerGroup)
                        || CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME.equals(customerGroup))) {
                    return true;
                }
            }
        }
        return false;
    }
    /* END BZ37642 */
    
    /**
     * BZ40798
     * Checking if customer is club member or not
     * @param argSource
     * @return
     */
    /* BEGIN BZ40798 */
    public static boolean isClubOnlyCustomer(IParty party) {
        if (party != null) {
        List<ICustomerAffiliation> customerAffiliation = null;
        String priceHeader = "";
      
            if (CollectionUtils.isNotEmpty(party.getCustomerGroups())) {
                customerAffiliation = party.getCustomerGroups();
                for (ICustomerAffiliation icustomerAffiliation : customerAffiliation) {

                    priceHeader = icustomerAffiliation.getCustomerGroupId();
                    if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_NEW_NAME
                            .equals(priceHeader)
                            || CawPropertyUtils.CUSTOMER_GROUP_TYPE_CLUB_OLD_NAME
                                    .equals(priceHeader)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /* END BZ40798 */
}
