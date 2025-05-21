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
 * BZ23301              120917    These fields on Customer Update should be validated before pressing Process
 * BZ23274              120917    Message content from EBS should be enhancement when searching customer
 * BZ23270              120917    Cannot search successfully customer when combining "Country" criteria
 * BZ23306              120917    The information on Customer search should be displayed on Contact Information after selecting F8/New
 * BZ23274              120917    Message content from EBS should be enhancement when searching customer
 * BZ23368              140917    Xstore should be displayed 'Processing...' screen to inform the customer when searching customer
 * BZ23052              140917    Implement Advanced Prompting
 * BZ23367              160917    Club# doesn't display on Account tab when searching the customer has memberships number
 * BZ23417              180917    [Customer Update] Get Pricing Identifier as Customer Group for Customer Information
 * BZ23479              220917    Add new parameter (EBS_ENABLE) to ON/OFF call to EBS Web Service
 * BZ23534              250917    Not show prompt when not entering last name at customer search
 * BZ23541              270917    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4
 * BZ23263              250917    Implement House Account
 * BZ23637              280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ23620              290917    AR info should be added value on Customer Attributes screen
 * BZ23749              041017    Cannot lookup Whole Sale customer successfully when searching any criterias except "Company name" input
 * BZ23982              131017    Registers are constantly frozen and required rebooting
 * BZ24017              151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ24095              191017    Club pricing is not applied for membership when doing a sale transaction at first time
 * BZ24098              191017    Missing club pricing/regular price/return price for item when performing transaction 
 *                                with cash tender which total transaction is over $10000.00
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins
 * BZ24219              011117    Club pricing is not applied for customer when assigning to sale screen from Dashboard
 * BZ24385              081117    "Join RA membership#" is not displayed under customer section on receipt after validation this membership successfully
 * BZ24383              091117    "Auto-Renew" term should be printed on receipt when choosing "Auto-renew membership sold"
 * BZ24414              091117    When Adding New Customer for Warranty Item New 'Logoff' Button Appears
 * BZ24498              161117    Club price is not applied to transaction after selling GSC Join in EBS offline
 * BZ24556              201117    [Payments][Build 1.1.3] Help Desk Error displays when you select Yes for Good Sam Prescreen
 * BZ24601              221217    Price of customer is changed from RETL to CLUB unexpectedly when sending catalyst=1 request
 * BZ24945              281217    AR tender is disable on Return tender option screen when performing return transaction by scanning trans on Sell item screen
 * BZ25316              300118    Cannot go to View Customer dashboard when selecting Select&View on an item from result search list in EBS offline status.
 * BZ26025              200418    [Catalyst 4] No prompting engine request data at catalyst=4 is sent to ESB when assigning a new customer just created during transaction
 * BZ25358              290418    Enhancements to QAS Integration with POS
 * BZ26303              171518    [1.5 QAS] Data still persists when searching for customer by Member # or Email and invalid data is used
 * BZ26313              210518    [QAS] Undo change button should be an Esc button.
 * BZ26379              280518    A new customer gets club pricing info from the previous transaction when assigned the customer to trans
 * BZ26453              050618    [Internal] Membership Info of customer does not display at customer search prompt when searching the customer in offline status.
 * BZ26565              061418    Customer info is displayed although searching first-name field on customer search screen
 * BZ26575              061418    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26671              250618    Missing Customer address confirmation screen when applying for a Good Sam Visa
 * BZ26289              170718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27000              090818    [26289] House Account tab info displays incorrectly the A/R data retrieved from EBS Neuron or localDB.
 * BZ26414              090818    AR tender displays unexpectedly on Sale tender options screen when pressing skip button then add items
 * BZ27129              090818    [1.6.5][26289] AR Account/B tender is disabled on Sale Tender Options screen
 * BZ27199              140818    Cannot complete Sale Transaction which used any tender types with special customer Club#:W7705280824
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27856              111018    [Build 2.9]First & Last Name used in search is not retained when user selects to create a new customer
 * BZ28441              141218    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 3.0
 * BZ28033              110518    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ28853              271218    [Internal][offline][2.9.7] Cannot found a customer which existed data from XCenter incase offline.
 * BZ28857              271218    [Internal][Offline] Membership Info displays inconsistently on Customer Search Result/Info Tab/Top panel when searching then assign the customer in case offline
 * BZ29640              060319    [Internal] Cannot search some wholesale customer with account number
 * BZ30307              260419    [Internal] New customer made while Xcenter offline cannot complete tender when Xcenter is back online
 * BZ27535              090519    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ30318              060619    [New Requirement] Drop leading characters from GS member card barcode scans
 * BZ32272              300719    [New Requirement] Leading Characters are not being dropped when adding GS membership
 * BZ33442              221019    [Prod] Customer updates not allowedCustomer has Crew membership that prevents updates
 * BZ33595              151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ26268              110220    Driver License and State ID scan for customer add/age prompts
 * BZ35054              180220    [Ported the fix from patch 8 to Xstore 6.0][Prod] Roadside Assistance prompt on a crew account
 * BZ28036              100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ35221              240220    [Defect 26268] Customer information is not auto filled in the customer creation screen when searching customer by scanning driver's license
 * BZ36405              030620    Issue with Credit Customer placed on credit hold
 * BZ38283              021020    Port bug 38212: [PROD] - Tender Token Error
 * BZ48848              270422    [Internal] - Loyalty information is NOT displayed on Membership Info tab.
 * BZ49801              040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 * BZ53724              231222    Unable to edit customer details when register is offline
 * BZ54290              160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ61159              260224    [New Requirement] - Xstore AGIS Replacement
 * BZ62146              060324    [Internal] - The membership information should show on the Membership Info Tab.
 *===================================================================
 */

package caw.pos.customer;

import static dtv.pos.customer.CustomerUtil.CUSTOMER_HOUSE_ACCOUNT_CREATED;
import static dtv.pos.customer.CustomerUtil.HOUSE_ACCOUNT_CREATED_EVENT_DESCRIPTOR;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.data2.access.*;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.data2x.impl.req.TooManyRecordsFoundException;
import dtv.event.Eventor;
import dtv.event.eventor.DefaultEventor;
import dtv.hardware.dl.IDriversLicenseEvent;
import dtv.hardware.events.ItemScanEvent;
import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.customer.*;
import dtv.pos.framework.form.FormConstants;
import dtv.pos.framework.tax.ITaxHelper;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.houseaccount.HouseAccountHelper;
import dtv.pos.iframework.*;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.event.IXstEventType;
import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.hardware.IInput;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IMenuModel;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.util.IKeyedValue;
import dtv.util.KeyValuePair;
import dtv.util.config.ConfigUtils;
import dtv.util.crypto.EncString;
import dtv.xst.crm.cust.ICustomerQueryResult;
import dtv.xst.crm.impl.cust.lookup.resp.CustomerQueryResult;
import dtv.xst.dao.cat.*;
import dtv.xst.dao.com.*;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.crm.impl.PartyPropertyModel;
import dtv.xst.dao.tax.ITaxExemption;
import dtv.xst.query.results.HouseAccountSearchResult;

public class CawCustomerSearchOp extends CustomerSearchOp {

    boolean isResultCustomerSearhScreen = false; //BZ26268

    /* BEGIN BZ33595 */
    private static final IXstEventType[] EVENTS = { InputType.INPUT_ITEM, InputType.INPUT_DRIVERS_LICENSE }; // BZ26268

    @Override
    public IXstEventType[] getObservedEvents() {
        return EVENTS;
    }
    /* END BZ33595 */

    private static final Logger _logger             = LogManager.getLogger(CawCustomerSearchOp.class);

    @Inject
    private CustomerHelper      _customerHelper;

    @Inject
    private IBusyState          _busyState;

    @Inject
    private CommonHelper        _commonHelper;

    @Inject
    private HouseAccountHelper  _houseAccountHelper;

    IPersistablesBag            bag                 = TransactionHelper.getPersistables();

    private OpChainKey          _addCustomerChain   = null;

    // Begin BZ26453
    private boolean             _primaryAddressOnly = false;
    
    private boolean             isEbsOffline        = false;                                          /* BZ27535 */

    public static boolean       isEsbTaxExempt      = true;                                           /* BZ27535 */

    @Inject
    private ILocationFactory    _locationFactory;                                                     // BZ27339

    @Inject
    private ITaxHelper          _taxHelper;                                                           /*BZ27535*/

    // Begin BZ26379 
    @Override
    protected IOpResponse handleInitialState() {
        _transactionScope.clearValue(CawValueKeys.EDIT_ACCOUNT_NUMBER); //BZ33442
        // Clear customer info of the previous customer.
        CawCatalystHelper.setLookupResponseData(null);
        //BEGIN BZ26414, BZ27129
        _transactionScope.clearValue(CawValueKeys.AR_ACCOUNT_BALANCE);
        _transactionScope.clearValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT);
        //END BZ26414, BZ27129

        //BEGIN BZ27339
        clearScopedValue(ValueKeys.SELECTED_CUSTOMER);
        _transactionScope.clearValue(ValueKeys.SELECTED_CUSTOMER);
        CawCustomerHelper.getInstance().resetSelectedCustomer();
        //END BZ27339

        return super.handleInitialState();
    }
    // End BZ26379

    /**
     * Called by handleListSelection
     */
    @Override
    protected IOpResponse handleSetSelection(ICustomerQueryResult argSelected) {

        IOpResponse response = null;//HELPER.completeResponse();
        _transactionScope.setValue(CawValueKeys.IS_RETURN_AR_ACCOUNT, true);//BZ24945
        _transactionScope.setValue(CawValueKeys.IS_SEARCH_CUSTOMER, true);//BZ26313
        /*Begin Bz-23479; BZ27339 removed out*/
        /*if (!CawUtilFunction.allowEBSConnection()) {
            return super.handleSetSelection(argSelected);
        }*/
        /*End Bz-23479*/
        /** BEGIN BZ24219 */
        clearScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN);
        CawCatalystHelper.setCatalystMessageResponse(null);
        /** END BZ24219 */
        clearScopedValue(CawValueKeys.IS_COMPLETED_VALIDATION); // BZ24385
        _transactionScope.clearValue(CawValueKeys.IS_AUTO_RENEW); // BZ24383
        _transactionScope.clearValue(CawValueKeys.AR_ACCOUNT_BALANCE);
        _transactionScope.clearValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT);

        try {
            String accountNumber = null;
            Long exsitedCustomerId = null;
            String lookupResponseEBS = null;
            IParty selectedCustomer = null;
            if (argSelected instanceof CawCustomerQueryResult) {

                CawCustomerQueryResult customer = (CawCustomerQueryResult) argSelected;
                lookupResponseEBS = lookAccCustomerInEBS(customer);//BZ28033
                //Added 26671
                accountNumber = customer.getAccountNumber();

                // Check customer exists in database
                exsitedCustomerId = getCustomerIdInDB(accountNumber);

                //Begin BZ23263 - just check in case of Online
                checkArAccountValid(lookupResponseEBS);
                //End BZ23263

            } else if (argSelected instanceof CustomerQueryResult) {

                CustomerQueryResult cust = (CustomerQueryResult) argSelected;
                PartyId partyId = new PartyId();
                partyId.setPartyId(cust.getId());
                selectedCustomer = DataFactory.getObjectByIdNoThrow(partyId);
            }

            // End BZ24498
            ICustomerAffiliation customerAffiliation = null;
            List<ICustomerAffiliation> customerAffiliations = new ArrayList<ICustomerAffiliation>();

            if (exsitedCustomerId == null || exsitedCustomerId.longValue() == 0) {
                if (StringUtils.isNotEmpty(lookupResponseEBS)) {

                    /* Case 1: Customer is found in EBS, but not existed in Local DB */

                    JSONObject responseData = new JSONObject(lookupResponseEBS);
                    // Begin BZ23367
                    selectedCustomer = CawCustomerHelper.getInstance().createPartyObjFromJson(responseData);
                    bag.addObject(selectedCustomer);

                    // persist customer to CRM_PARTY_ID_XREF
                    IPartyIdCrossReference partyXRef = CawCustomerHelper.getInstance()
                            .createPartyCrossReferenceObjFromJson(accountNumber, selectedCustomer);
                    bag.addObject(partyXRef);
                    bag.persist();
                    /* BEGIN BZ28853 */
                    // CRM_PARTY_TELEPHONE
                    List<IPartyTelephone> listPhones = CawCustomerHelper.getInstance()
                            .parseCustomerPhones(selectedCustomer, lookupResponseEBS, true);

                    for (IPartyTelephone partyTelephone : listPhones) {
                        if (partyTelephone != null) {
                            bag.addObject(partyTelephone);
                            bag.persist();
                        }
                    }
                    /* END BZ28853 */

                    // Begin BZ24601
                    argSelected.setId(selectedCustomer.getPartyId());
                    response = super.handleSetSelection(argSelected);
                    // End BZ24601

                    // Insert data from response of LookuAPI to table IPartyIdCrossReferenceProperty
                    CawCustomerHelper.getInstance().saveCustomerJSON(selectedCustomer, responseData);

                    //Insert to table CAT_CUST_ACCT/CAT_CUST_LOYALTY_ACCT/CAT_CUST_LOYALTY_ACCT_P/CAT_CUST_ACCT_CARD
                    CawCustomerHelper.getInstance()
                            .saveCatCustLoyaltyAcc(lookupResponseEBS, selectedCustomer, _stationState);
                    // End BZ23367

                    //Begin BZ23417
                    customerAffiliation = CawCustomerHelper.getInstance()
                            .createCustomerAffiliation(selectedCustomer, lookupResponseEBS);
                    // End BZ23417

                    // Begin BZ24095 & BZ24098
                    // Begin BZ30307
                    ((IDataModelImpl) customerAffiliation).getDAO().setObjectState(DaoState.UPDATED.intVal());
                    // End BZ30307
                    customerAffiliations.add(customerAffiliation);
                    selectedCustomer.setCustomerGroups(customerAffiliations);
                    // Begin BZ24095 & BZ24098

                } else {

                    /* Case 2: Customer is not found in EBS, and not existed in Local DB */
                    response = super.handleSetSelection(argSelected); // BZ 25316
                }

            } else {

                /* Case 3: Customer is found in EBS and already existed in Local DB */

                argSelected.setId(exsitedCustomerId);
                // Begin BZ23367
                PartyId partyId = new PartyId();
                partyId.setPartyId(exsitedCustomerId);
                partyId.setOrganizationId(ConfigurationMgr.getOrganizationId());
                selectedCustomer = DataFactory.getObjectByIdNoThrow(partyId);
                if (selectedCustomer != null) {
                    // Begin BZ24601
                    argSelected.setId(selectedCustomer.getPartyId());
                    response = super.handleSetSelection(argSelected);
                    // End BZ24601

                    /* BEGIN BZ28441, BZ28857 */
                    if (StringUtils.isNotEmpty(lookupResponseEBS)) {
                        JSONObject responseData = new JSONObject(lookupResponseEBS);
                        CawCustomerHelper.getInstance().updatePartyObjFromJson(selectedCustomer, responseData);
                        bag.addObject(selectedCustomer);
                        bag.persist();

                        /* End BZ-28441 */
                        /* BEGIN BZ28853 */
                        // Update the CRM_PARTY_TELEPHONE

                        List<IPartyTelephone> listExitedPhones = selectedCustomer.getTelephoneInformation();

                        if (CollectionUtils.isEmpty(listExitedPhones)) {
                            List<IPartyTelephone> jsonListPhones = CawCustomerHelper.getInstance()
                                    .parseCustomerPhones(selectedCustomer, lookupResponseEBS, true);

                            for (IPartyTelephone partyTelephone : jsonListPhones) {
                                if (partyTelephone != null) {
                                    bag.addObject(partyTelephone);
                                    bag.persist();
                                }
                            }
                        } else {
                            List<IPartyTelephone> jsonListPhones = CawCustomerHelper.getInstance()
                                    .parseCustomerPhones(selectedCustomer, lookupResponseEBS, false);
                            for (IPartyTelephone partyTelephone : jsonListPhones) {
                                if (partyTelephone != null) {
                                    bag.addObject(partyTelephone);
                                    bag.persist();
                                }
                            }
                        }
                    }
                    /* END BZ28853, BZ28857 */
                    //Insert to table CAT_CUST_ACCT/CAT_CUST_LOYALTY_ACCT/CAT_CUST_LOYALTY_ACCT_P/CAT_CUST_ACCT_CARD
                    CawCustomerHelper.getInstance()
                            .saveCatCustLoyaltyAcc(lookupResponseEBS, selectedCustomer, _stationState);

                    if (StringUtils.isNotEmpty(lookupResponseEBS)) {//BZ26453
                        customerAffiliation = CawCustomerHelper.getInstance()
                                .createCustomerAffiliation(selectedCustomer, lookupResponseEBS); //BZ23417
                        // Begin BZ30307
                        ((IDataModelImpl) customerAffiliation).getDAO().setObjectState(DaoState.UPDATED.intVal());
                        // End BZ30307

                        // Begin BZ24095 & BZ24098
                        customerAffiliations.add(customerAffiliation);
                        selectedCustomer.setCustomerGroups(customerAffiliations);
                        // End BZ24095 & BZ24098
                    }
                }
                // End BZ23367
            }

            // Begin BZ26453
            if (selectedCustomer != null) {
                setScopedValue(ValueKeys.SELECTED_CUSTOMER, selectedCustomer);//BZ24601
                _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, selectedCustomer); // BZ24095 & BZ24098
                _transactionScope
                        .setValue(CawValueKeys.ACCOUNT_API, accountNumber);/*BZ28036*/
            }
            // End BZ26453

            // Begin BZ24095 & BZ24098
            // Begin BZ24498
            if (StringUtils.isEmpty(lookupResponseEBS)) {
                lookupResponseEBS = CawCustomerHelper.getInstance()
                        .buildCustomerJsonObjectOffline(getScopedValue(ValueKeys.SELECTED_CUSTOMER));//BZ26453
                _logger.info("Build customer json object when Webservice offline." + lookupResponseEBS);
                /* BEGIN BZ27535, BZ53724 */
                try {
                    isEbsOffline = true;
                    List<ITaxExemption> taxExemptions = _taxHelper.getTaxExemptions(selectedCustomer);
                    if (taxExemptions != null && taxExemptions.size() > 0) {
                        JSONObject customerJson = new JSONObject(lookupResponseEBS);
                        for (ITaxExemption taxExemption : taxExemptions) {
                            customerJson.put(CawJSONConstant.JSON_TAX_CERTIFICATE, taxExemption.getCertificateNbr());
                            customerJson.put(CawJSONConstant.JSON_IS_TAX_EXEMPT, Boolean.TRUE.toString());
                            lookupResponseEBS = customerJson.toString();
                        }
                    }
                } catch (Exception ex) {
                    _logger.error("[Error when get tax exemption]: " + ex);
                }
                /* END BZ27535, BZ53724 */
                _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponseEBS);
                setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponseEBS);
                CawCatalystHelper.setLookupResponseData(lookupResponseEBS);
            }
            // End BZ24498

            // BZ26289 Start
            handleHouseAccountCustomer(selectedCustomer, lookupResponseEBS);
            // BZ26289 End

            //BEGIN BZ54290
            IPartyProperty isLoyaltyCustomerObj = null;
            if (StringUtils.isNotEmpty(CawCatalystHelper.getLookupLoyaltyResponseData())) {
                boolean isLoyaltyCustomer = CawCheetahHelper.getInstance().checkIsLoyaltyCustomer(CawCatalystHelper.getLookupLoyaltyResponseData());
                if(isLoyaltyCustomer) {
                    _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
                    IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
                    isLoyaltyCustomerObj = CawCheetahHelper.getInstance().addCustomerLoyaltyProperty(new JSONObject(lookupResponseEBS), party);
                    bag.addObject(isLoyaltyCustomerObj);
                    bag.persist();
                }
            } else {
                PartyPropertyId partyPropId = new PartyPropertyId();
                
                partyPropId.setOrganizationId(ConfigurationMgr.getOrganizationId());
                partyPropId.setPartyId(getScopedValue(ValueKeys.SELECTED_CUSTOMER).getPartyId());
                partyPropId.setPropertyCode("IS_LOYALTY_CUSTOMER");
                PartyPropertyModel partyPropModel = DataFactory.getObjectByIdNoThrow(partyPropId);
                if(partyPropModel != null && Boolean.parseBoolean(partyPropModel.getStringValue())) {
                    _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
                }
            }
            //END BZ54290
            
        } catch (Exception ex) {
            _logger.error("Can not lookup customer from EBS:" + ex.getMessage());
        }
        //Begin BZ23541
        CawCatalystHelper.setCustomerPartyId(0L);//This is flag for mark sent request to catalyst =1.
        CawCatalystHelper.clearDirectiveExceptType8();//BZ35054
        CawCatalystHelper.setCatalystInputsResponse(null);
        CawCatalystHelper.setCatalystMessageResponse(null);
        CawCatalystHelper.getInputdatals().clear();
        //End BZ23541

        if (response == null) {
            response = HELPER.completeResponse();
        }

        return response;
    }

    /** {@inheritDoc} */
    @Override
    protected IQueryResultList<ICustomerQueryResult> runQueryWrapResults(Collection<IKeyedValue<String, ?>> argFields) {

        IQueryResultList<ICustomerQueryResult> customerQueryResults = null;

        if (!CawUtilFunction.allowEBSConnection()) {
            //BEGIN BZ28857
            return cawSearchCustomers(argFields);
            //END BZ28857
        }

        // Begin BZ23270
        Iterator<IKeyedValue<String, ?>> res = argFields.iterator();
        IKeyedValue<?, ?> para = null;
        boolean hasCountry = false;
        while (res.hasNext()) {
            para = res.next();
            if (para.getKey().equals(CawCustomerConstants.COUNTRY_FIELD)) {
                hasCountry = true;
                break;
            }
        }
        if (!hasCountry) {
            argFields.add(new KeyValuePair<String, String>(CawCustomerConstants.COUNTRY_FIELD,
                    this.getModel().getCountry()));
        }
        // End BZ23270

        try {
            _busyState.start(CawConstants.BUSY_STATE_MSG);
            customerQueryResults = CawCustomerHelper.getInstance().searchCustomerFromEBS(argFields);
            _busyState.end();
        } catch (Exception ex) {
            _busyState.end();
            _logger.error("Can not find customer:" + ex.getMessage());
        }

        if (customerQueryResults != null && customerQueryResults.size() > 0) {
            return customerQueryResults;
        } else {

            /* BEGIN BZ26453, BZ28857 */
            return cawSearchCustomers(argFields);
            /* END BZ26453, BZ28857 */

        }
    }

    // Begin BZ23301
    /**
     * argModel
     */
    @Override
    protected IValidationResultList validateForm(CustomerSearchModel argModel) {

        IValidationResultList list = new ValidationResultList();
        // Begin BZ23306
        if (argModel.getValue(CawCustomerConstants.ORGANIZATION_NAME_FIELD) != null) {
            argModel.setCompanyName(argModel.getValue(CawCustomerConstants.ORGANIZATION_NAME_FIELD).toString());
        }
        //Begin BZ23534
        else {
            argModel.setCompanyName(null);
        }
        //End BZ23534
        // End BZ23306
        IFormattable msg = null;
        // Begin BZ23274
        // validate account number field
        if (StringUtils.isNotEmpty(argModel.getCustomerId())) {
            if (StringUtils.isNumeric(argModel.getCustomerId())) {
                try {
                    Long.parseLong(argModel.getCustomerId()); //BZ29640
                } catch (Exception ex) {
                    msg = _formattables.getTranslatable("_accountNumberValidationError");
                    list.add(SimpleValidationResult.getFailed(msg));
                }
            } else {
                msg = _formattables.getTranslatable("_accountNumberValidationError");
                list.add(SimpleValidationResult.getFailed(msg));
            }
        }
        // End BZ23274
        /*BEGIN BZ30318*/
        /*validate Club field*/
        if (StringUtils.isNotEmpty(argModel.getLoyaltyNumber())) {
            /* BEGIN BZ32272 */
            String loyaltyNumber = CawCustomerUtil.trimGSMNumber(argModel.getLoyaltyNumber());
            argModel.setLoyaltyNumber(loyaltyNumber);
            /* END BZ32272 */
        }
        /*END BZ30318*/
        // validate address field
        if (StringUtils.isNotEmpty(argModel.getEmailAddress())) {
            if (!validateEmailAddress(argModel.getEmailAddress())) {
                msg = _formattables.getTranslatable("_emailAddressValidationError");
                list.add(SimpleValidationResult.getFailed(msg));
            }
        }
        // BZ23274
        // validate last name field
        boolean valid = validateFields(argModel);
        if (!valid) {
            msg = _formattables.getTranslatable("_customerSearchValidationError");
            list.add(SimpleValidationResult.getFailed(msg));
        }
        // End BZ23274
        return argModel.validate(list);
    }

    /**
     * Added BZ26565
     * Require a last name 
     * and one or more of firstName, address, 
     * city, stateProvince, postalCode or country
     * @param argModel
     * @return
     */
    private boolean validateFields(CustomerSearchModel argModel) {

        boolean valid = true;
        //Group 1- require one of fields
        if ((argModel.getTelephone() == null || argModel.getTelephone().length() == 0)
                && (argModel.getLoyaltyNumber() == null || argModel.getLoyaltyNumber().length() == 0)
                && (argModel.getCustomerId() == null || argModel.getCustomerId().length() == 0)
                && (argModel.getEmailAddress() == null || argModel.getEmailAddress().length() == 0)
                && (argModel.getCompanyName() == null || argModel.getCompanyName().length() == 0)) {

            //Group 2- require two of fields
            if (argModel.getLastName() == null || argModel.getLastName().length() == 0) {
                valid = false;
            } else if ((argModel.getFirstName() == null || argModel.getFirstName().length() == 0)
                    && (argModel.getAddress1() == null || argModel.getAddress1().length() == 0)
                    && (argModel.getCity() == null || argModel.getCity().length() == 0)
                    && (argModel.getState() == null || argModel.getState().length() == 0)
                    && (argModel.getPostalCode() == null || argModel.getPostalCode().length() == 0)) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * 
     * @param emailStr
     * @return
     */
    public boolean validateEmailAddress(String emailStr) {

        Matcher matcher = CawCustomerConstants.VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    // End Begin BZ23301

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        //Begin BZ25358, BZ27856 start
        _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, false);
        _transactionScope.setValue(CawValueKeys.IS_BACK, false);
        // BZ27856 end

        IXstActionKey key = argAction.getActionKey();
        /*BEGIN BZ38283*/
        // disable prompt actions
        IPromptActionModel promptActionModel = _modeProvider.get().getStationModel().getPromptActionModel();
        disableActions(promptActionModel.getActions());

        // disable menu actions
        IMenuModel menuModel = _modeProvider.get().getStationModel().getMenuModel();
        disableActions(menuModel.getActions());
        /*END BZ38283*/
        // BZ27339 start.
        if (CawCustomerConstants.BUTTON_CLEAR.equals(key.toString())) {
            clearSearchFieldInput();
            return this.HELPER.getChangeFormResponse(this.getFormKey(), this.getModel(), this.getActionGroupKey(), this
                    .isEditable());
        }
        // BZ27339 end.
        //Begin BZ26303
        /*Begin BZ26313:condition removeCust is used 
         * to removed customer for any customer 
         * is save but not assign this customer to trans*/
        Boolean fnBack = _transactionScope.getValue(CawValueKeys.FN_BACK_CUST_SEARCH);
        Boolean removeCust = _transactionScope.getValue(CawValueKeys.IS_REMOVE_CUSTOMER);
        if (fnBack != null && fnBack.booleanValue()) {
            if (removeCust != null && removeCust.booleanValue()) {
                if (!CawCustomerConstants.BUTTON_ACCEPT.equalsIgnoreCase(key.toString())
                        && !CawCustomerConstants.BUTTON_CHANGE_COUNTRY.equalsIgnoreCase(key.toString())) {
                    _transactionScope.clearValue(CawValueKeys.IS_REMOVE_CUSTOMER);
                    return HELPER.getStartChainResponse(OpChainKey.valueOf("REMOVE_CUST_ASSOC_QAS"));
                }
            } else {
                if (CawCustomerConstants.BUTTON_CANCEL_QAS.equalsIgnoreCase(key.toString())) {
                    return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("BACKTO_SALE_ITEM"));
                }
            }
        }
        _transactionScope.clearValue(CawValueKeys.IS_SEARCH_CUSTOMER);

        //End BZ26313
        if (key == FormConstants.BACK || key == FormConstants.EXIT || getOpState() == VALIDATION_ERROR) {
            _transactionScope.setValue(CawValueKeys.IS_BACK, true);
        }
        //End BZ26303
        //End BZ25358
        if (key == FormConstants.NEW) {
            _transactionScope.setValue(CawValueKeys.IS_SEARCH_CUSTOMER, true);//BZ26313
            IParty customer = this._customerHelper
                    .createParty(this.getModel().getChanges(), this._stationState.getRetailLocationId());

            this.setScopedValue(ValueKeys.SELECTED_CUSTOMER, customer);
            // Begin BZ23306
            if (customer.getPrimaryLocaleInformation() != null) {
                if (!StringUtils.isEmpty(this.getModel().getCountry())) {
                    customer.getPrimaryLocaleInformation().setCountry(this.getModel().getCountry());
                }
                if (!StringUtils.isEmpty(this.getModel().getAddress1())) {
                    customer.getPrimaryLocaleInformation().setAddress1(this.getModel().getAddress1());
                }
            }
            // End BZ23306
            if (!StringUtils.isEmpty(this.getModel().getCompanyName())) {
                customer.setOrganizationName(this.getModel().getCompanyName());
            }

            return this.HELPER.getCompleteStackChainResponse(this._addCustomerChain, argAction);

        } else {
            //Begin BZ25358
            if (key == FormConstants.SELECT) {
                _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
                _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, false);
                handleOpExecDisableAction(argAction);
            }
            //End BZ25358
            CawCatalystHelper.clearDirectiveExceptType8();//BZ35054
            return super.handleDataAction(argAction);
        }

    }

    @Override
    public void setParameter(String argName, String argValue) {

        if (CawCustomerConstants.ADD_CUSTOMER_CHAIN.equalsIgnoreCase(argName)) {
            this._addCustomerChain = OpChainKey.valueOf(argValue);
            // Begin BZ26453
        } else if (CawCustomerConstants.PRIMARY_ONLY.equalsIgnoreCase(argName)) {
            this._primaryAddressOnly = ConfigUtils.toBoolean(argValue).booleanValue();
            // End BZ26453
        } else {
            super.setParameter(argName, argValue);
        }
    }

    //Begin BZ23263
    private boolean checkArAccountValid(String lookupResponse) {

        boolean isAllowDisplayMsg = false;

        BigDecimal arAccountBalance = CawCustomerHelper.getInstance()
                .getAvailableBalanceAmt(lookupResponse);/*BZ36405*/
        if (BigDecimal.ZERO.compareTo(arAccountBalance) != 0) { //BZ23749
            isAllowDisplayMsg = true;
        }
        //adjust code
        _transactionScope.setValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT, Boolean.valueOf(isAllowDisplayMsg));
        _transactionScope.setValue(CawValueKeys.AR_ACCOUNT_BALANCE, arAccountBalance);
        return isAllowDisplayMsg;
    }
    //END BZ23263

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }

    /**
     * BZ 24414: Check flag to identify Customer Search using Back button or Log off button
     */
    @Override
    protected FormKey getBaseFormKey() {

        /* START BZ 24414 */
        Boolean isBackSearchForm = _transactionScope.getValue(CawValueKeys.FN_BACK_CUST_SEARCH);
        //Begin BZ25358
        if (Boolean.TRUE.equals(_transactionScope.getValue(CawValueKeys.IS_BACK))) {
            //adding method to clear here
            clearFieldInput();
        }
        //End BZ25358
        if (isBackSearchForm == null) {
            return FormKey.valueOf(CawCustomerConstants.CUSTOMER_SEARCH_V2);
        }
        /* END BZ 24414 */
        return super.getBaseFormKey();
    }

    // Begin BZ24601
    @Override
    protected void setSelectedResult(IParty argDataModel) {

        ICustomerLoyaltyCard iCustomerLoyaltyCard;
        List<ICustomerLoyaltyAccount> customerLoyaltyAccounts;
        if (argDataModel != null) {
            List<ICustomerLoyaltyCard> customerLoyaltyCards = argDataModel.getLoyaltyCards();
            for (Iterator<ICustomerLoyaltyCard> iterator = customerLoyaltyCards.iterator(); iterator.hasNext();) {
                iCustomerLoyaltyCard = iterator.next();

                if (iCustomerLoyaltyCard.getLoyaltyAccounts() != null) {
                    customerLoyaltyAccounts = iCustomerLoyaltyCard.getLoyaltyAccounts();
                    for (int i = 0; i < customerLoyaltyAccounts.size(); i++) {
                        ((IDataModelImpl) customerLoyaltyAccounts.get(i)).getDAO()
                                .setObjectState(DaoState.DELETED.intVal());
                        DataFactory.makePersistent(customerLoyaltyAccounts.get(i));
                    }
                }
            }
        }

        super.setSelectedResult(argDataModel);
    }

    // End BZ24601
    //Begin BZ25358
    /**
     * this method is used to clear all text after "Back/ESC" is clicked
     */
    private void clearFieldInput() {

        this.getModel().setFirstName(CawConstants.EMPTY_SIGN);
        this.getModel().setLastName(CawConstants.EMPTY_SIGN);
        this.getModel().setTelephone(CawConstants.EMPTY_SIGN);
        this.getModel().setCustomerId(CawConstants.EMPTY_SIGN);
        this.getModel().setAddress1(CawConstants.EMPTY_SIGN);
        this.getModel().setCity(CawConstants.EMPTY_SIGN);
        this.getModel().setState(CawConstants.EMPTY_SIGN);
        this.getModel().setPostalCode(CawConstants.EMPTY_SIGN);
        this.getModel().setEmailAddress(CawConstants.EMPTY_SIGN);
        this.getModel().setLoyaltyNumber(CawConstants.EMPTY_SIGN);
        this.getModel().setCustomerId(null); //BZ26453
        this.getModel().setValue(CawCustomerConstants.ORGANIZATION_NAME_FIELD, null);
    }

    /**
     * BZ27339 Added
     * this method is used to clear all text after "Back/ESC" is clicked     
     * */
    private void clearSearchFieldInput() {

        clearFieldInput();
        this.getModel()
                .changeCountry(_locationFactory.getStoreById(_stationState.getRetailLocationId()).getCountry(), true);
    }

    public IOpResponse handleOpExecDisableAction(IXstEvent argEvent) {

        // disable prompt actions
        IPromptActionModel promptActionModel = _modeProvider.get().getStationModel().getPromptActionModel();
        disableActions(promptActionModel.getActions());

        // disable menu actions
        IMenuModel menuModel = _modeProvider.get().getStationModel().getMenuModel();
        disableActions(menuModel.getActions());

        return HELPER.completeResponse();
    }

    protected void disableActions(Collection<IXstAction> argActions) {

        // iterate and disable each action
        for (IXstAction action : argActions) {
            _logger.debug("Disabling action: " + action);

            action.setEnabled(false);
        }
    }

    private String lookAccCustomerInEBS(CawCustomerQueryResult customer) {

        String accountNumber = null;
        String locationCode = null;
        String lookupResponse = null;

        // Begin BZ26453
        if (StringUtils.isNotEmpty(customer.getAccountNumber())) {
            accountNumber = customer.getAccountNumber();
            _transactionScope.setValue(CawCustomerConstants.ACCOUNT_NUMBER, accountNumber);
            _transactionScope.setValue(CawValueKeys.EDIT_ACCOUNT_NUMBER, Long.valueOf(accountNumber));//BZ26025
        }
        locationCode = customer.getLocationCode();
        // End BZ26453

        // Begin BZ24498
        _transactionScope.setValue(CawCustomerConstants.LOCATION_CODE, locationCode);

        //BZ27339 added to check EBS connection
        if (accountNumber != null && CawUtilFunction.allowEBSConnection()) {
            // Begin BZ23052 and BZ25675 changed by using CawEBSHelper
            /* BEGIN BZ28033 */
            lookupResponse = CawCatalystHelper.getLookupResponseData();
            if (StringUtils.isEmpty(lookupResponse)) {
                _busyState.start(CawConstants.BUSY_STATE_MSG);
                lookupResponse = CawEBSHelper.getInstance().lookupCustomerInEBS(accountNumber, locationCode);
                _transactionScope.setValue(CawValueKeys.EDIT_ACCOUNT_NUMBER, Long.valueOf(accountNumber));//BZ26025, BZ61159
                CawCatalystHelper.setLookupResponseData(lookupResponse);
                _busyState.end();
            }
            /* END BZ28033 */
        }

        /** BEGIN BZ24219 */
        if (StringUtils.isNotEmpty(lookupResponse)) {//BZ24556
            setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponse);
            _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponse);
            //BEGIN BZ61159, BZ62146
            storePricingFromMiddleLayer(); 
            storeMembershipFromMiddleLayer();
            //END BZ61159, BZ62146
        }
        /** END BZ24219 */

        return lookupResponse;

    }

    /* BEGIN BZ61159, BZ62146*/
    private void storePricingFromMiddleLayer() {
        String custLookupResp = _transactionScope.getValue(CawValueKeys.API_LOOKUP_RESPONSE);
        try {
            if(custLookupResp != null && !custLookupResp.isEmpty()) {
                JSONObject custLookupRespJson = new JSONObject(custLookupResp.toString());
                if(custLookupRespJson.has(CawJSONConstant.JSON_AVAILABLE_PRICING) && !custLookupRespJson.isNull(CawJSONConstant.JSON_AVAILABLE_PRICING)) {
                    JSONObject pricingJson = custLookupRespJson.getJSONObject(CawJSONConstant.JSON_AVAILABLE_PRICING);
                    _transactionScope.setValue(CawValueKeys.CAW_PRICING_LOOKUP_FROM_MIDDLE_LAYER, pricingJson.toString());//BZ61159
                }
            }
        } catch (Exception ex) {
            _logger.debug("[Error at storePricingFromMiddleLayer]: " + ex.getMessage());
        }
    }
    
    private void storeMembershipFromMiddleLayer() {
        String custLookupResp = _transactionScope.getValue(CawValueKeys.API_LOOKUP_RESPONSE);
        try {
            if(custLookupResp != null && !custLookupResp.isEmpty()) {
                JSONObject custLookupRespJson = new JSONObject(custLookupResp.toString());
                if(custLookupRespJson.has(CawJSONConstant.JSON_MEMBERSHIPS) && !custLookupRespJson.isNull(CawJSONConstant.JSON_MEMBERSHIPS)) {
                    JSONArray membershipJson = custLookupRespJson.getJSONArray(CawJSONConstant.JSON_MEMBERSHIPS);
                    _transactionScope.setValue(CawValueKeys.CAW_MEMBERSHIP_LOOKUP_FROM_MIDDLE_LAYER, membershipJson.toString());//BZ61159
                }
            }
        } catch (Exception ex) {
            _logger.debug("[Error at storeMembershipFromMiddleLayer]: " + ex.getMessage());
        }
    }
    /* END BZ61159, BZ62146 */
    
    private Long getCustomerIdInDB(String accountNumber) {

        Long partId = null;
        IQueryResultList<CawCustomerEBSQueryResult> cawCustomerEBSQueryResult = null;
        Map<String, Object> params = new HashMap<>();
        params.put(CawQueryConstants.ARG_ACCOUNT_NUMBER, accountNumber);
        cawCustomerEBSQueryResult = DataFactory
                .getObjectByQueryNoThrow(CawQueryConstants.CRM_CUSTOMER_EBS_LOOKUP, params);
        if (cawCustomerEBSQueryResult != null && cawCustomerEBSQueryResult.size() > 0) {
            partId = cawCustomerEBSQueryResult.get(0).getPartyId();
        }
        return partId;
    }

    //End BZ25358
    //BZ26289 Start
    protected void handleHouseAccountCustomer(IParty argParty, String lookupResponseEbs) {

        if (CawCustomerUtil.isWhslCustomer(argParty)) {

            BigDecimal accBalanceOnlineOnly = _transactionScope.getValue(CawValueKeys.AR_ACCOUNT_BALANCE);
            if (accBalanceOnlineOnly != null && accBalanceOnlineOnly.compareTo(BigDecimal.ZERO) != 0) {
                /*House Account Payment when
                 * A whole sale customer 
                 * and AR Account Balance amount is found.*/
                _transactionScope.setValue(CawValueKeys.HAS_WHLS_HOUSE_ACCOUNT, Boolean.valueOf(true));
            }

            ICustomerConsumerChargeAccount houseAccount = null;
            houseAccount = checkHouseAccountExisted(argParty);
            if (houseAccount == null) {
                //create house account - BZ27199 used accBalanceOnlineOnly
                houseAccount = CawCustomerUtil.createNewHouseAccount(_transDateProvider, _stationState
                        .getRetailLocationId(), argParty, accBalanceOnlineOnly, CawCustomerConstants.CUST_ACCT_CODE, bag);
                if (houseAccount != null && lookupResponseEbs != null) {
                    // Save customer tax exempt status to DB
                    CawCustomerUtil.saveCustomerTaxExemptStatus(argParty, CawCustomerUtil
                            .getCustomerTaxExempt(lookupResponseEbs));

                    // Save Available Balance  Amount
                }
            }

            // BZ27000 start get account number from EBS
            if (houseAccount != null) {
                //BZ27199 used accBalanceOnlineOnly
                houseAccount.setCreditLimit(accBalanceOnlineOnly);
                String accountNumber = CawCustomerUtil.getAccountNumber(lookupResponseEbs);
                houseAccount.setCustAccountId(accountNumber);

                if (houseAccount.getChargeAccountUsers() != null && houseAccount.getChargeAccountUsers().size() > 0) {
                    IChargeAccountUser user = houseAccount.getChargeAccountUsers().get(0);
                    setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT_USER, user);
                }
            }
            setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT_TO_MAINTAIN, houseAccount);
            setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT, houseAccount);
            Eventor eventor = new DefaultEventor(HOUSE_ACCOUNT_CREATED_EVENT_DESCRIPTOR);
            eventor.post(CUSTOMER_HOUSE_ACCOUNT_CREATED, houseAccount);
            _houseAccountHelper.setCurrentHouseAccount(houseAccount);
            // BZ27000 end
        }
        setCustomerTaxExempt(argParty, lookupResponseEbs); /* BZ27535 */
    }

    /**
     * @param argParty
     * @return
     */
    protected ICustomerConsumerChargeAccount checkHouseAccountExisted(IParty argParty) {

        final List<HouseAccountSearchResult> searchResults = _houseAccountHelper
                .searchHouseAccountByParty(argParty, false);
        ICustomerConsumerChargeAccount houseAccount = null;

        if (!searchResults.isEmpty()) {
            houseAccount = (ICustomerConsumerChargeAccount) searchResults.get(0).getPopulatedObject();
        }
        return houseAccount;
    }
    // BZ26289 end

    /* BEGIN BZ28857 */
    /**
     * @return
     */
    public IQueryResultList<ICustomerQueryResult> cawSearchCustomers(Collection<IKeyedValue<String, ?>> argFields) {
        IQueryResultList<ICustomerQueryResult> customerQueryResults = null;
        try {
            if (this._primaryAddressOnly) {
                argFields.add(new KeyValuePair<String, Boolean>(CawCustomerConstants.PRIMARY_ADDRESS,
                        Boolean.valueOf(true)));
            }

            IQueryResultList<CawCustomerQueryResult> cawCustomerQueryResult = CawCustomerHelper.getInstance()
                    .searchForCustomers(argFields, _commonHelper);
            List<CawCustomerQueryResult> cawCustomerQuerys = new ArrayList<CawCustomerQueryResult>();

            if (cawCustomerQueryResult != null && cawCustomerQueryResult.size() > 0) {
                List<JSONObject> lstMembership = new ArrayList<JSONObject>();

                for (CawCustomerQueryResult cawCustomer : cawCustomerQueryResult) {
                    // Set location 
                    cawCustomer.setLocationCode(CawPropertyUtils.STORE_NUMBER); /*BZ27535*/
                    if (cawCustomer.getAccountNumber() == null) {
                        cawCustomer.setAccountNumber(""); // If account is null, The error happened when selecting the customer after search complete.
                    }
                    if (cawCustomer.getMembershipStringValue() != null) {
                        //Convert membership from String to List JSONObject
                        lstMembership = CawCustomerHelper.getInstance()
                                .getMembershipsOfCustomer(cawCustomer, lstMembership);
                        if (lstMembership.size() > 0) {
                            cawCustomer.setMembershipLst(lstMembership);
                        }
                    }

                    cawCustomerQuerys.add(cawCustomer);
                }
            }

            customerQueryResults = QueryResultList.makeList(cawCustomerQuerys, ICustomerQueryResult.class);

        } catch (TooManyRecordsFoundException arg2) {
            _logger.info("Too many records found.");
        } catch (Exception exception) {
            _logger.info("Can not search customer:" + exception.getMessage());
        }
        return customerQueryResults;
    }

    /* END BZ28857 */
    /* BEGIN BZ27535 */
    private void setCustomerTaxExempt(IParty argParty, String lookupResponseEbs) {
        String taxExempt = CawCustomerUtil.getCustomerTaxExempt(lookupResponseEbs);
        List<ITaxExemption> taxExemptions = _taxHelper.getTaxExemptions(argParty);
        boolean isTaxExempt = false;
        if (!isEbsOffline) {
            if (CawConstants.CUST_TAX_EXEMPT_NO.endsWith(taxExempt)) {
                if (taxExemptions != null && taxExemptions.size() > 0) {
                    for (ITaxExemption taxExemption : taxExemptions) {
                        ((IDataModelImpl) taxExemption).getDAO()
                                .setObjectState(DaoState.DELETED.intVal());
                        DataFactory.makePersistent(taxExemption);
                    }
                    
                }
                isEsbTaxExempt = false;
            }
            else {
                isEsbTaxExempt = true;
                if (taxExemptions != null && taxExemptions.size() > 0) {
                    for (ITaxExemption taxExemption : taxExemptions) {
                        if(StringUtils.equals(taxExemption.getCertificateNbr(), CawCustomerUtil.getTaxCertificate(lookupResponseEbs))) {
                            isTaxExempt = true;
                        }
                    }
                    
                }
                if(!isTaxExempt) {
                    String reason = null;
                    IReasonCodeProperty reasonCodeProperty = null;
                    String stateLocation = LocationFactory.getInstance().getStoreById(_stationState.getRetailLocationId()).getState();
                    List<? extends IReasonCode> reasonCodes = CodeLocator
                            .getReasonCodes(ConfigurationMgr.getOrganizationId(), CawConstants.REASON_TYPCODE);
                    for (IReasonCode reasonCode : reasonCodes) {
                        reasonCodeProperty = reasonCode.getProperty(CawConstants.PROPERTY_CODE);
                        if (reasonCodeProperty != null) {
                            reason = reasonCodeProperty.getReasonCode();
                        }
                    }
                    ITaxExemption exemption = _taxHelper.createTaxExemption(argParty);
                    exemption.setCertificateNbr(CawCustomerUtil.getTaxCertificate(lookupResponseEbs));
                    exemption.setTaxExemptionId(exemption.getTaxExemptionId());
                    exemption.setReasonCode(reason);
                    exemption.setCertificateHolderName(argParty.getFirstName() + " " + argParty.getLastName());
                    exemption.setCertificateState(stateLocation);
                    DataFactory.makePersistent(exemption);
                }
            }
        }
        CawCustomerUtil.saveCustomerTaxExemptStatus(argParty, taxExempt);
       
    }
    /* END BZ27535 */

    /* BEGIN BZ33595 */
    @Override
    protected IOpResponse handleBeforeDataAction(IXstEvent argEvent) {

        /* BEGIN BZ26268 */
        if (!(argEvent instanceof IXstAction) && isResultCustomerSearhScreen) {
            return HELPER.waitResponse();
        }
        /* END BZ26268 */

        if (argEvent instanceof ItemScanEvent) {
            ItemScanEvent event = (ItemScanEvent) argEvent;
            IEditModel editModel = getModel();
            IInput inputData = event.getInputData();
            if (inputData != null) {
                editModel.setValue(CawConstants.CAW_FIELD_LOYALTY_NUMBER, EncString
                        .getSensitiveData(inputData.getData()));
                validateForm((CustomerSearchModel) editModel);
            }
            isResultCustomerSearhScreen = false; //BZ26268
            return handleSearch(editModel.getChanges());
        }
        isResultCustomerSearhScreen = false; //BZ26268
        return super.handleBeforeDataAction(argEvent);
    }
    /* END BZ33595 */

    /* BEGIN BZ26268 */
    @Override
    protected IOpResponse handleDriversLicenseSearch(
            IDriversLicenseEvent argEvent) {

        _transactionScope.setValue(CawValueKeys.IS_BACK, false); //BZ35221
        IEditModel editModel = getModel();
        editModel.setValue("city", argEvent.getCity());
        editModel.setValue("firstName", argEvent.getFirstName());
        editModel.setValue("lastName", argEvent.getLastName());
        editModel.setValue("postalCode", argEvent.getPostalCode());
        editModel.setValue("address1", argEvent.getAddress1());
        editModel.setValue("state", argEvent.getState());
        return this.handleSearch(editModel.getChanges());
    }

    @Override
    protected IOpResponse getSearchResultsPrompt(
            List<ICustomerQueryResult> argResults, IFormattable argMessage) {

        isResultCustomerSearhScreen = true;
        // @todo Auto-generated method stub
        return super.getSearchResultsPrompt(argResults, argMessage);
    }
    /* END BZ26268 */
}