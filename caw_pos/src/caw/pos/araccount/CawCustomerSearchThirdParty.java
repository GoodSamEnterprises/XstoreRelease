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
 * BZ23263              250917    Implement House Account
 * BZ23675              021017    AR tender is enable unexpectedly when customer is associated not 
 *                                belong to AR account (remove method checkArAccountValid(), this method causing this err above)
 * BZ23982              131017    Registers are constantly frozen and required rebooting
 * BZ24404              091117    'Picked up by' of Third- party tender displayed incorrect in receipt when doing transaction between AR and Third- party
 * BZ24561              221117    Should be displayed message to indicate EBS is offlined when doing AR/Third-party tender in offline cases
 * BZ26323              220518    [24561] Should be displayed message to indicate EBS is offlined when doing AR/Third-party tender in offline cases
 * BZ26313              210518    [QAS] Undo change button should be an Esc button.
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27813              181018    [New Requirement] Credit Limit VALIDATION is displaying for AR and Third Party if tender amount is greater than $1000
 * BZ28033              170119    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ29640              060319    [Internal] Cannot search some wholesale customer with account number
 * BZ36405              030620    Issue with Credit Customer placed on credit hold
 * BZ45486              090821    [Prod] Issue With House and 3rd Party Payment
 * BZ46016              310820    [Internal] Xstore makes a call to Card status and catalyst 4 unexpectedly when back from Validation Third party account is zero.
 * BZ53547              161122    [Internal] Loyalty information is not printed on the receipt when tender with Third-Party option.
 *===================================================================
 */

package caw.pos.araccount;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.customer.*;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.data2.access.IQueryResultList;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.customer.CustomerSearchModel;
import dtv.pos.framework.form.FormConstants;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.iframework.ILocationFactory;
import dtv.pos.iframework.IPersistablesBag;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.util.IKeyedValue;
import dtv.util.KeyValuePair;
import dtv.xst.crm.cust.ICustomerQueryResult;
import dtv.xst.dao.crm.*;

public class CawCustomerSearchThirdParty extends CawCustomerSearchThirdPartyOp {

    private static final Logger         _logger                  = LogManager
            .getLogger(CawCustomerSearchThirdParty.class);

    private CawCustomerThirdPartyHelper _cawCustomerUpdateHelper = CawCustomerThirdPartyHelper
            .getInstance();

    @Inject
    private CustomerHelper              _customerHelper;

    private OpChainKey                  _addCustomerChain        = null;

    IPersistablesBag                    bag                      = TransactionHelper
            .getPersistables();                                                               //BZ23367

    //Begin BZ24561
    private static boolean              EBS_TIMEOUT              = false;
    //End BZ24561

    @Inject
    private ILocationFactory            _locationFactory;                                     // BZ27339

    @Override
    protected IOpResponse handleSetSelection(ICustomerQueryResult argSelected) {

        try {
            String accountNumber = null;
            String locationCode = null;
            if (argSelected instanceof CawCustomerQueryResult) {
                CawCustomerQueryResult customer = (CawCustomerQueryResult) argSelected;
                accountNumber = customer.getAccountNumber();
                locationCode = customer.getLocationCode();
            }
            _transactionScope
                    .setValue(CawCustomerConstants.LOCATION_CODE, locationCode);
            // Begin BZ23052
            
            //BEGIN BZ53547
            CawCatalystHelper.setLookupResponseDataUseThirdPartyTender(CawCatalystHelper.getLookupResponseData());
            CawCatalystHelper.setLookupResponseLoyaltyDataUseThirdPartyTender(CawCatalystHelper.getLookupLoyaltyResponseData());
            CawCatalystHelper.setSelectedCustomerUseThirdPartyTender(_transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER));
            //END BZ53547
            
            CawCatalystHelper.setLookupResponseData(null);// BZ28033
            String lookupResponse = _cawCustomerUpdateHelper
                    .lookupCustomerFromEBS(argSelected);
            setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponse);
            //Begin BZ24404
            String name = CawCustomerUtil.getCompanyName(lookupResponse);
            setScopedValue(CawValueKeys.COMPANYNAME, name);
            //End BZ24404

            // BZ27813 start
            BigDecimal tpAccountBalance = CawCustomerHelper.getInstance().getARAvailableBalanceAmt(lookupResponse);
            _transactionScope.setValue(CawValueKeys.TP_ACCOUNT_BALANCE, tpAccountBalance);
            /*BEGIN BZ45486*/
            if (tpAccountBalance.compareTo(BigDecimal.ZERO) != 0) {
                _transactionScope.setValue(CawCustomerConstants.ACCOUNT_NUMBER, accountNumber);
            }
            /*END BZ45486*/
            
            // BZ27813 end
            /*BEGIN BZ36405*/
            boolean isArCreditHold = CawCustomerUtil.isArCreditHold(lookupResponse);
            _transactionScope.setValue(CawValueKeys.IS_AR_CREDIT_HOLD, isArCreditHold);
            /*END BZ36405*/
            // End BZ23052
            // Check customer exists in database
            Map<String, Object> params = new HashMap<>();
            params.put(CawQueryConstants.ARG_ACCOUNT_NUMBER, accountNumber);
            IQueryResultList<CawCustomerEBSQueryResult> cawCustomerEBSQueryResult = DataFactory
                    .getObjectByQueryNoThrow(CawQueryConstants.CRM_CUSTOMER_EBS_LOOKUP, params);
            if (cawCustomerEBSQueryResult == null
                    || cawCustomerEBSQueryResult.size() == 0) {
                if (StringUtils.isNotEmpty(lookupResponse)) {
                    JSONObject responseData = new JSONObject(lookupResponse);
                    // Begin BZ23367
                    IParty party = _cawCustomerUpdateHelper
                            .createPartyObjFromJson(responseData);
                    bag.addObject(party);

                    // persist customer to CRM_PARTY_ID_XREF
                    IPartyIdCrossReference partyXRef = _cawCustomerUpdateHelper
                            .createPartyCrossReferenceObjFromJson(accountNumber, party);
                    bag.addObject(partyXRef);
                    bag.persist();

                    // Insert data from response of LookuAPI to table IPartyIdCrossReferenceProperty
                    _cawCustomerUpdateHelper
                            .saveCustomerJSON(party, responseData);

                    //Insert to table CAT_CUST_ACCT/CAT_CUST_LOYALTY_ACCT/CAT_CUST_LOYALTY_ACCT_P/CAT_CUST_ACCT_CARD
                    _cawCustomerUpdateHelper
                            .saveCatCustLoyaltyAcc(lookupResponse, party, _stationState);
                    // End BZ23367

                    //Begin BZ23417
                    _cawCustomerUpdateHelper
                            .createCustomerAffiliation(party, lookupResponse);
                    // End BZ23417
                    argSelected.setId(party.getPartyId());
                }

            } else {
                argSelected
                        .setId(cawCustomerEBSQueryResult.get(0).getPartyId());
                // Begin BZ23367
                //Insert to table CAT_CUST_ACCT/CAT_CUST_LOYALTY_ACCT/CAT_CUST_LOYALTY_ACCT_P/CAT_CUST_ACCT_CARD
                PartyId partyId = new PartyId();
                partyId.setPartyId(cawCustomerEBSQueryResult.get(0)
                        .getPartyId());
                partyId.setOrganizationId(ConfigurationMgr.getOrganizationId());

            }
        } catch (Exception ex) {
            _logger.error("Can not lookup customer from EBS:"
                    + ex.getMessage());
        }

        IOpResponse response = super.handleSetSelection(argSelected);
        return response;
    }

    /** {@inheritDoc} */
    @Override
    protected IQueryResultList<ICustomerQueryResult> runQueryWrapResults(
            Collection<IKeyedValue<String, ?>> argFields) {

        //Begin BZ24561
        EBS_TIMEOUT = false;
        //End BZ24561
        IQueryResultList<ICustomerQueryResult> customerQueryResults = null;
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
            argFields.add(new KeyValuePair<String, String>(
                    CawCustomerConstants.COUNTRY_FIELD,
                    this.getModel().getCountry()));
        }
        // End BZ23270
        try {
            customerQueryResults = _cawCustomerUpdateHelper
                    .searchCustomerFromEBS(argFields);
            EBS_TIMEOUT = _cawCustomerUpdateHelper.isEsbOffline();//BZ26323
            _logger.info("Result customer from EBS: " + customerQueryResults);
        } catch (Exception ex) {
            _logger.error("Can not find customer:" + ex.getMessage());
        }

        if (customerQueryResults != null) {
            return customerQueryResults;
        } else {
            //Begin BZ24561: in case, EBS is offline, the result will get response with value 408
            //BZ26323
            if (!CawUtilFunction.allowEBSConnection() || EBS_TIMEOUT) {
                EBS_TIMEOUT = true;
                _transactionScope
                        .setValue(CawValueKeys.EBS_TIMEOUT, EBS_TIMEOUT);
            }
            //End BZ24561
            return super.runQueryWrapResults(argFields);
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
        if (argModel
                .getValue(CawCustomerConstants.ORGANIZATION_NAME_FIELD) != null) {
            argModel.setCompanyName(argModel
                    .getValue(CawCustomerConstants.ORGANIZATION_NAME_FIELD)
                    .toString());
        }
        // End BZ23306
        IFormattable msg = null;
        // Begin BZ23274
        // validate account number field
        if (StringUtils.isNotEmpty(argModel.getCustomerId())) {
            if (StringUtils.isNumeric(argModel.getCustomerId())) {
                try {
                    Long.parseLong(argModel.getCustomerId()); //BZ29640
                } catch (Exception ex) {
                    _logger.debug("Account number is not valid"
                            + ex.getMessage());
                    msg = _formattables
                            .getTranslatable("_accountNumberValidationError");
                    list.add(SimpleValidationResult.getFailed(msg));
                }
            } else {
                msg = _formattables
                        .getTranslatable("_accountNumberValidationError");
                list.add(SimpleValidationResult.getFailed(msg));
            }
        }
        // End BZ23274
        // validate address field
        if (StringUtils.isNotEmpty(argModel.getEmailAddress())) {
            if (!validateEmailAddress(argModel.getEmailAddress())) {
                msg = _formattables
                        .getTranslatable("_emailAddressValidationError");
                list.add(SimpleValidationResult.getFailed(msg));
            }
        }
        // BZ23274
        // validate last name field
        if (argModel.getTelephone() == null
                && argModel.getLoyaltyNumber() == null
                && argModel.getCustomerId() == null
                && argModel.getEmailAddress() == null
                && argModel.getCompanyName() == null) {
            if ((argModel.getLastName() != null
                    && argModel.getFirstName() == null
                    && argModel.getAddress1() == null
                    && argModel.getCity() == null && argModel.getState() == null
                    && argModel.getPostalCode() == null)
                    || (argModel.getLastName() == null
                            && (argModel.getFirstName() != null
                                    || argModel.getAddress1() != null
                                    || argModel.getCity() != null
                                    || argModel.getState() != null
                                    || argModel.getPostalCode() != null))) {
                msg = _formattables
                        .getTranslatable("_customerSearchValidationError");
                list.add(SimpleValidationResult.getFailed(msg));
            }
        }
        // End BZ23274
        return argModel.validate(list);
    }

    /**
     * 
     * @param emailStr
     * @return
     */
    public boolean validateEmailAddress(String emailStr) {

        Matcher matcher = CawCustomerConstants.VALID_EMAIL_ADDRESS_REGEX
                .matcher(emailStr);
        return matcher.find();
    }
    // End Begin BZ23301

    // BZ27339 start    
    /**     
     * this method is used to clear all text after "Back/ESC" is clicked     
     * */
    private void clearSearchFieldInput() {

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
        this.getModel()
                .setValue(CawCustomerConstants.ORGANIZATION_NAME_FIELD, null);
        this.getModel()
                .changeCountry(_locationFactory
                        .getStoreById(_stationState.getRetailLocationId())
                        .getCountry(), true);
    }
    // BZ27339 end

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        IXstActionKey key = argAction.getActionKey();
        // BZ27339 start.
        if (CawCustomerConstants.BUTTON_CLEAR.equals(key.toString())) {
            clearSearchFieldInput();
            return this.HELPER.getChangeFormResponse(this.getFormKey(), this
                    .getModel(), this.getActionGroupKey(), this.isEditable());
        }
        // BZ27339 end.
        //Begin BZ26313
        _transactionScope.clearValue(CawValueKeys.IS_SEARCH_CUSTOMER);
        if (CawCustomerConstants.BUTTON_CANCEL_QAS
                .equalsIgnoreCase(key.toString())) {
            getOpState();
            return HELPER.getStartChainResponse(OpChainKey.valueOf("CHECK_SALE_COMPLETE"));/*BZ46016*/
        }
        //End BZ26313
        if (key == FormConstants.NEW) {
            IParty customer = this._customerHelper.createParty(this.getModel()
                    .getChanges(), this._stationState.getRetailLocationId());

            this.setScopedValue(ValueKeys.SELECTED_CUSTOMER, customer);
            // Begin BZ23306
            if (customer.getPrimaryLocaleInformation() != null) {
                if (!StringUtils.isEmpty(this.getModel().getCountry())) {
                    customer.getPrimaryLocaleInformation()
                            .setCountry(this.getModel().getCountry());
                }
                if (!StringUtils.isEmpty(this.getModel().getAddress1())) {
                    customer.getPrimaryLocaleInformation()
                            .setAddress1(this.getModel().getAddress1());
                }
            }
            // End BZ23306
            if (!StringUtils.isEmpty(this.getModel().getCompanyName())) {
                customer.setOrganizationName(this.getModel().getCompanyName());
            }

            return this.HELPER
                    .getCompleteStackChainResponse(this._addCustomerChain, argAction);

        } else {
            return super.handleDataAction(argAction);
        }
    }

    @Override
    public void setParameter(String argName, String argValue) {

        if (CawCustomerConstants.ADD_CUSTOMER_CHAIN.equalsIgnoreCase(argName)) {
            this._addCustomerChain = OpChainKey.valueOf(argValue);
        } else {
            super.setParameter(argName, argValue);
        }
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
}