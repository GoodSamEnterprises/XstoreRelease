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
 * BZ26432              010618    Should go to Customer Maintenance and accounts screen instead of display error message when pressing 'Back' on Customer search screen in BO
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ30318              200619    [New Requirement] Drop leading characters from GS member card barcode scans
 * BZ31486              250619    [Internal] Can not found customer when using Customer Search in BO
 * BZ33595              151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ26268              110220    Driver License and State ID scan for customer add/age prompts
 * BZ36405              030620    Issue with Credit Customer placed on credit hold
 *===================================================================
 */
package caw.pos.customer;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONObject;

import dtv.data2.access.*;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.data2x.impl.req.TooManyRecordsFoundException;
import dtv.hardware.dl.IDriversLicenseEvent;
import dtv.hardware.events.ItemScanEvent;
import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.customer.CustomerSearchModel;
import dtv.pos.customer.CustomerSearchOp;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.tax.ITaxHelper;
import dtv.pos.iframework.*;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.event.IXstEventType;
import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.hardware.IInput;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.spring.ValueKeys;
import dtv.util.IKeyedValue;
import dtv.util.KeyValuePair;
import dtv.util.crypto.EncString;
import dtv.xst.crm.cust.ICustomerQueryResult;
import dtv.xst.crm.impl.cust.lookup.resp.CustomerQueryResult;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.tax.ITaxExemption;

/**
 * this class is used to handle case.
 */
public class CawBOCustomerSearchOp extends CustomerSearchOp {

    boolean isResultCustomerSearhScreen = false; //BZ26268

    /* BEGIN BZ33595 */
    private static final IXstEventType[] EVENTS = { InputType.INPUT_ITEM, InputType.INPUT_DRIVERS_LICENSE }; // BZ26268

    @Override
    public IXstEventType[] getObservedEvents() {
        return EVENTS;
    }
    /* END BZ33595 */
    
    /** The location factory. */
    @Inject
    private ILocationFactory _locationFactory;// BZ27339

    /** The Constant _logger. */
    /* Begin BZ31486 */
    private static final Logger _logger             = LogManager.getLogger(CawCustomerSearchOp.class);

    /** The busy state. */
    @Inject
    private IBusyState          _busyState;

    /** The primary address only. */
    private boolean             _primaryAddressOnly = false;

    /** The common helper. */
    @Inject
    private CommonHelper        _commonHelper;

    /** The bag. */
    IPersistablesBag            bag                 = TransactionHelper.getPersistables();

    /** The tax helper. */
    @Inject
    private ITaxHelper          _taxHelper;
    /* End BZ31486 */

    /* (non-Javadoc)
     * @see dtv.pos.customer.CustomerSearchOp#handleDataAction(dtv.pos.iframework.action.IXstDataAction)
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {
        IXstActionKey key = argAction.getActionKey();
        /* Begin BZ27339 */
        if (CawCustomerConstants.BUTTON_CLEAR.equals(key.toString())) {
            clearFieldInput();
            return this.HELPER.getChangeFormResponse(this.getFormKey(), this
                    .getModel(), this.getActionGroupKey(), this.isEditable());
        }
        // End BZ27339 */.
        if (Boolean.TRUE.equals(_modeProvider.get().getModeData().getKey()
                .equals(CawCustomerConstants.BACK_OFFICE))) {
            if (CawCustomerConstants.BUTTON_CANCEL_QAS
                    .equalsIgnoreCase(key.toString())) {
                argAction.setActionKey(XstDataActionKey.CANCEL);
                return HELPER.getBackupResponse();
            }

        }
        return super.handleDataAction(argAction);
    }

    /*BEGIN BZ30318*/
    /* (non-Javadoc)
     * @see caw.pos.customer.CawCustomerSearchOp#validateForm(dtv.pos.customer.CustomerSearchModel)
     */
    @Override
    protected IValidationResultList validateForm(CustomerSearchModel argModel) {

        /*validate Club field*/
        if (StringUtils.isNotEmpty(argModel.getLoyaltyNumber())) {
            if (argModel.getLoyaltyNumber().substring(0, 2).equals(CawCustomerConstants.LOYALTY_NUMBER_TRIM)) {
                String loyaltyNumber = argModel.getLoyaltyNumber().substring(2);
                loyaltyNumber = StringUtils.stripStart(loyaltyNumber, "0");
                argModel.setLoyaltyNumber(loyaltyNumber);
            }
        }
        return super.validateForm(argModel);       
    }
    /*END BZ30318*/

    /* Begin BZ27339 */
    /**
     * BZ27339 Added
     * this method is used to clear all text after "Back/ESC" is clicked.
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
        this.getModel().setCustomerId(null);
        this.getModel()
                .setValue(CawCustomerConstants.ORGANIZATION_NAME_FIELD, null);
        this.getModel()
                .changeCountry(_locationFactory
                        .getStoreById(_stationState.getRetailLocationId())
                        .getCountry(), true);
    }
    /* End BZ27339 */

    /*
     * (non-Javadoc)
     * @see dtv.pos.customer.CustomerSearchOp#runQueryWrapResults(java.util.Collection)
     */
    /* Begin BZ31486: Apply customer search from ESB in BO*/
    @Override
    protected IQueryResultList<ICustomerQueryResult> runQueryWrapResults(Collection<IKeyedValue<String, ?>> argFields) {

        IQueryResultList<ICustomerQueryResult> customerQueryResults = null;

        if (!CawUtilFunction.allowEBSConnection()) {
            return cawSearchCustomers(argFields);
        }

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

            return cawSearchCustomers(argFields);

        }
    }

    /**
     * Caw search customers.
     *
     * @param argFields
     *            the arg fields
     * @return the i query result list
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
                    cawCustomer.setLocationCode(CawPropertyUtils.STORE_NUMBER);
                    if (cawCustomer.getAccountNumber() == null) {
                        cawCustomer.setAccountNumber(""); // If account is null, The error happened when selecting the
                                                          // customer after search complete.
                    }
                    if (cawCustomer.getMembershipStringValue() != null) {
                        // Convert membership from String to List JSONObject
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

    /*
     * (non-Javadoc)
     * @see dtv.pos.customer.CustomerSearchOp#handleSetSelection(dtv.xst.crm.cust.ICustomerQueryResult)
     */
    @Override
    protected IOpResponse handleSetSelection(ICustomerQueryResult argSelected) {

        IOpResponse response = null;
        _transactionScope.setValue(CawValueKeys.IS_RETURN_AR_ACCOUNT, true);
        _transactionScope.setValue(CawValueKeys.IS_SEARCH_CUSTOMER, true);
        clearScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN);
        CawCatalystHelper.setCatalystMessageResponse(null);
        clearScopedValue(CawValueKeys.IS_COMPLETED_VALIDATION);
        _transactionScope.clearValue(CawValueKeys.IS_AUTO_RENEW);
        _transactionScope.clearValue(CawValueKeys.AR_ACCOUNT_BALANCE);
        _transactionScope.clearValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT);

        try {
            String accountNumber = null;
            Long exsitedCustomerId = null;
            String lookupResponseEBS = null;
            IParty selectedCustomer = null;
            if (argSelected instanceof CawCustomerQueryResult) {

                CawCustomerQueryResult customer = (CawCustomerQueryResult) argSelected;
                lookupResponseEBS = lookAccCustomerInEBS(customer);
                accountNumber = customer.getAccountNumber();

                // Check customer exists in database
                exsitedCustomerId = getCustomerIdInDB(accountNumber);

                checkArAccountValid(lookupResponseEBS);

            } else if (argSelected instanceof CustomerQueryResult) {

                CustomerQueryResult cust = (CustomerQueryResult) argSelected;
                PartyId partyId = new PartyId();
                partyId.setPartyId(cust.getId());
                selectedCustomer = DataFactory.getObjectByIdNoThrow(partyId);
            }

            ICustomerAffiliation customerAffiliation = null;
            List<ICustomerAffiliation> customerAffiliations = new ArrayList<ICustomerAffiliation>();

            if (exsitedCustomerId == null || exsitedCustomerId.longValue() == 0) {
                if (StringUtils.isNotEmpty(lookupResponseEBS)) {

                    // Case 1: Customer is found in EBS, but not existed in Local DB

                    JSONObject responseData = new JSONObject(lookupResponseEBS);
                    selectedCustomer = CawCustomerHelper.getInstance().createPartyObjFromJson(responseData);
                    bag.addObject(selectedCustomer);

                    // persist customer to CRM_PARTY_ID_XREF
                    IPartyIdCrossReference partyXRef = CawCustomerHelper.getInstance()
                            .createPartyCrossReferenceObjFromJson(accountNumber, selectedCustomer);
                    bag.addObject(partyXRef);
                    bag.persist();
                    // CRM_PARTY_TELEPHONE
                    List<IPartyTelephone> listPhones = CawCustomerHelper.getInstance()
                            .parseCustomerPhones(selectedCustomer, lookupResponseEBS, true);

                    for (IPartyTelephone partyTelephone : listPhones) {
                        if (partyTelephone != null) {
                            bag.addObject(partyTelephone);
                            bag.persist();
                        }
                    }

                    argSelected.setId(selectedCustomer.getPartyId());
                    response = super.handleSetSelection(argSelected);

                    // Insert data from response of LookuAPI to table IPartyIdCrossReferenceProperty
                    CawCustomerHelper.getInstance().saveCustomerJSON(selectedCustomer, responseData);

                    // Insert to table CAT_CUST_ACCT/CAT_CUST_LOYALTY_ACCT/CAT_CUST_LOYALTY_ACCT_P/CAT_CUST_ACCT_CARD
                    CawCustomerHelper.getInstance()
                            .saveCatCustLoyaltyAcc(lookupResponseEBS, selectedCustomer, _stationState);

                    customerAffiliation = CawCustomerHelper.getInstance()
                            .createCustomerAffiliation(selectedCustomer, lookupResponseEBS);

                    ((IDataModelImpl) customerAffiliation).getDAO().setObjectState(DaoState.UPDATED.intVal());
                    customerAffiliations.add(customerAffiliation);
                    selectedCustomer.setCustomerGroups(customerAffiliations);

                } else {

                    // Case 2: Customer is not found in EBS, and not existed in Local DB
                    response = super.handleSetSelection(argSelected); // BZ 25316
                }

            } else {

                // Case 3: Customer is found in EBS and already existed in Local DB

                argSelected.setId(exsitedCustomerId);
                PartyId partyId = new PartyId();
                partyId.setPartyId(exsitedCustomerId);
                partyId.setOrganizationId(ConfigurationMgr.getOrganizationId());
                selectedCustomer = DataFactory.getObjectByIdNoThrow(partyId);
                if (selectedCustomer != null) {
                    argSelected.setId(selectedCustomer.getPartyId());
                    response = super.handleSetSelection(argSelected);

                    if (StringUtils.isNotEmpty(lookupResponseEBS)) {
                        JSONObject responseData = new JSONObject(lookupResponseEBS);
                        CawCustomerHelper.getInstance().updatePartyObjFromJson(selectedCustomer, responseData);
                        bag.addObject(selectedCustomer);
                        bag.persist();

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
                    // Insert to table CAT_CUST_ACCT/CAT_CUST_LOYALTY_ACCT/CAT_CUST_LOYALTY_ACCT_P/CAT_CUST_ACCT_CARD
                    CawCustomerHelper.getInstance()
                            .saveCatCustLoyaltyAcc(lookupResponseEBS, selectedCustomer, _stationState);

                    if (StringUtils.isNotEmpty(lookupResponseEBS)) {
                        customerAffiliation = CawCustomerHelper.getInstance()
                                .createCustomerAffiliation(selectedCustomer, lookupResponseEBS);
                        ((IDataModelImpl) customerAffiliation).getDAO().setObjectState(DaoState.UPDATED.intVal());

                        customerAffiliations.add(customerAffiliation);
                        selectedCustomer.setCustomerGroups(customerAffiliations);
                    }
                }
            }

            if (selectedCustomer != null) {
                setScopedValue(ValueKeys.SELECTED_CUSTOMER, selectedCustomer);
                _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, selectedCustomer);
            }

            if (StringUtils.isEmpty(lookupResponseEBS)) {
                lookupResponseEBS = CawCustomerHelper.getInstance()
                        .buildCustomerJsonObjectOffline(getScopedValue(ValueKeys.SELECTED_CUSTOMER));
                _logger.info("Build customer json object when Webservice offline." + lookupResponseEBS);
                List<ITaxExemption> taxExemptions = _taxHelper.getTaxExemptions(selectedCustomer);
                if (taxExemptions != null && taxExemptions.size() > 0) {
                    JSONObject customerJson = new JSONObject(lookupResponseEBS);
                    for (ITaxExemption taxExemption : taxExemptions) {
                        customerJson.put(CawJSONConstant.JSON_TAX_CERTIFICATE, taxExemption.getCertificateNbr());
                        customerJson.put(CawJSONConstant.JSON_IS_TAX_EXEMPT, Boolean.TRUE.toString());
                        lookupResponseEBS = customerJson.toString();
                    }
                }
                _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponseEBS);
                setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponseEBS);
                CawCatalystHelper.setLookupResponseData(lookupResponseEBS);
            }

        } catch (Exception ex) {
            _logger.error("Can not lookup customer from EBS:" + ex.getMessage());
        }
        CawCatalystHelper.setCustomerPartyId(0L);// This is flag for mark sent request to catalyst =1.
        CawCatalystHelper.setCatalystDirectiveResponse(null);
        CawCatalystHelper.setCatalystInputsResponse(null);
        CawCatalystHelper.setCatalystMessageResponse(null);
        CawCatalystHelper.getInputdatals().clear();

        if (response == null) {
            response = HELPER.completeResponse();
        }

        return response;
    }

    /**
     * Look acc customer in EBS.
     *
     * @param customer
     *            the customer
     * @return the string
     */
    private String lookAccCustomerInEBS(CawCustomerQueryResult customer) {

        String accountNumber = null;
        String locationCode = null;
        String lookupResponse = null;

        if (StringUtils.isNotEmpty(customer.getAccountNumber())) {
            accountNumber = customer.getAccountNumber();
            _transactionScope.setValue(CawCustomerConstants.ACCOUNT_NUMBER, accountNumber);
            _transactionScope.setValue(CawValueKeys.EDIT_ACCOUNT_NUMBER, Long.valueOf(accountNumber));
        }
        locationCode = customer.getLocationCode();

        _transactionScope.setValue(CawCustomerConstants.LOCATION_CODE, locationCode);

        if (accountNumber != null && CawUtilFunction.allowEBSConnection()) {
            lookupResponse = CawCatalystHelper.getLookupResponseData();
            if (StringUtils.isEmpty(lookupResponse)) {
                _busyState.start(CawConstants.BUSY_STATE_MSG);
                lookupResponse = CawEBSHelper.getInstance().lookupCustomerInEBS(accountNumber, locationCode);
                CawCatalystHelper.setLookupResponseData(lookupResponse);
                _busyState.end();
            }
        }

        if (StringUtils.isNotEmpty(lookupResponse)) {
            setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponse);
            _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponse);
        }

        return lookupResponse;

    }

    /**
     * Gets the customer id in DB.
     *
     * @param accountNumber
     *            the account number
     * @return the customer id in DB
     */
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

    /**
     * Check ar account valid.
     *
     * @param lookupResponse
     *            the lookup response
     * @return true, if successful
     */
    private boolean checkArAccountValid(String lookupResponse) {

        boolean isAllowDisplayMsg = false;

        BigDecimal arAccountBalance = CawCustomerHelper.getInstance()
                .getAvailableBalanceAmt(lookupResponse);/*BZ36405*/
        if (BigDecimal.ZERO.compareTo(arAccountBalance) != 0) {
            isAllowDisplayMsg = true;
        }

        _transactionScope.setValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT, Boolean.valueOf(isAllowDisplayMsg));
        _transactionScope.setValue(CawValueKeys.AR_ACCOUNT_BALANCE, arAccountBalance);
        return isAllowDisplayMsg;
    }

    /*
     * (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractChangeCountryOp#handleInitialState()
     */
    @Override
    protected IOpResponse handleInitialState() {

        // Clear customer info of the previous customer.
        CawCatalystHelper.setLookupResponseData(null);
        _transactionScope.clearValue(CawValueKeys.AR_ACCOUNT_BALANCE);
        _transactionScope.clearValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT);
        clearScopedValue(ValueKeys.SELECTED_CUSTOMER);
        _transactionScope.clearValue(ValueKeys.SELECTED_CUSTOMER);
        CawCustomerHelper.getInstance().resetSelectedCustomer();
        return super.handleInitialState();
    }
    /* End BZ31486 */

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