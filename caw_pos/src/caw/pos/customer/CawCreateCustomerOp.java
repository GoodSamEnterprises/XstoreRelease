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
 * INT-92               260817    Customer Integration
 * BZ23367              160917    Club# doesn't display on Account tab when searching the customer has memberships number
 * BZ23477              200917    Need send back customer information to EBS WS when online
 * BZ23515              260917    Cannot go to Sale screen when pressing Assign & Continue from Dashboard through using "GS Visa apply now" for new customer
 * BZ23340              280917    Customer ID should be displayed instead of Account# on Contact information screen when adding a new Customer
 * BZ23683              021017    Need to initiate a Catalyst 1 Customer Lookup call to the prompting engine when a new customer is created
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins
 * BZ24219              011117    Club pricing is not applied for customer when assigning to sale screen from Dashboard 
 * BZ24385              081117    "Join RA membership#" is not displayed under customer section on receipt after validation this membership successfully
 * BZ24354              081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ24383              091117    "Auto-Renew" term should be printed on receipt when choosing "Auto-renew membership sold"
 * BZ24424              151117    "RA membership validation" prompt does not display for RA JOIN when you select "1-Year join (w/Auto Renew) - $69.95"
 * BZ24498              161117    Club price is not applied to transaction after selling GSC Join in EBS offline
 * BZ25916              120418    New customer is attached account# of previous customer info unexpectedly at Dashboard also prompting request with catalyst 1 or 4
 * BZ25358              290418    Enhancements to QAS Integration with POS
 * BZ26313              210518    [QAS] Undo change button should be an Esc button.
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ25435              160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ27280              220718    [Production] Account#/Membership# of new customer just created into previous transaction is attached unexpectedly to new another customer into next transaction
 * BZ28985              170119    [Internal] Incorrect customer account number is submitted in the Upsert request to the Neuron API if the Xstore Customer record is saved without actual edits
 * BZ29421              180219    [Port 29355 to 4.0] Transaction errors in OS because of invalid customer data(incomplete telephone #)
 * BZ33518              130220    [PROD] - Wholesale account set up is requiring First Name and Last Name to be included
 * BZ37753              160920    [Internal] - HDE screen displays when adding 2nd address for customer
 * BZ38283              021020    Port bug 38212: [PROD] - Tender Token Error
 * BZ42019              171121    Replace QAS with EAVS2
 * BZ47803              211221    [Internal patch 7.0.18] Xstore did not call to validate mailing address when creating a new customer with the address was entered from the Customer Search form
 * BZ47818              211221    [Internal patch 7.0.18] Xstore sent incorrect address in the Upsert request to Neuron if editing address right after the customer was created
 * BZ47888              271221    Patch 18 [Internal] Changing name or phone number only does not update customer record
 * BZ53724              231222    Unable to edit customer details when register is offline
 * BZ61159              190224    [New Requirement] - Xstore AGIS Replacement
 * BZ62987              040424    [Internal] The Banner customer and LOGO are displayed incorrectly when assigning a customer has GS Expired
 * BZ65612              260724    AGMOD Update to Membership SKU New Requirements
 *===================================================================
 */

package caw.pos.customer;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import caw.pos.util.CawRestClientUtil;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.customer.CreateCustomerOp;
import dtv.pos.customer.CustomerMaintenanceModel;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IMenuModel;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyLocaleInformation;

/**
 *
 */
public class CawCreateCustomerOp extends CreateCustomerOp {

    private static final String    UPDATED                  = "Updated";

    private static final String    CREATED                  = "Created";

    private static final String    CRUD_DESCRIPTION         = "crudDescription";

    private static final String    CRUD                     = "crud";

    private static final String    THE_CUSTOMER             = "customer";   //BZ61159

    private static final Logger    _logger                  = LogManager.getLogger(CawRestClientUtil.class);

    private CawCustomerHelper      _custHelper              = CawCustomerHelper.getInstance();

    //Begin BZ26313
    private static final String    PRE_SALE_TRANSACTION     = "PRE_SALE_TRANSACTION";

    private static final String    LOSE_CHANGES_PROMPT1     = "LOSE_CHANGES_PROMPT";

    private static final String    PRE_RETURN_CHAIN         = "PRE_RETURN_CHAIN";

    private static final String    BUTTON_YES               = "YES";

    public CawCreateCustomerOp() {

        super();
        _transactionScope.setValue(CawValueKeys.IS_ADD_NEW_CUST_ASSOC, Boolean.TRUE);
        _transactionScope.setValue(CawValueKeys.CAW_IS_NEW_CUST_ADDR_INIT_VALIDATION, Boolean.TRUE); //BZ47803
        
    }

    //End BZ26313
    /*
     * (non-Javadoc)
     * 
     * @see
     * dtv.pos.customer.CreateCustomerOp#handleSaveComplete(dtv.pos.iframework.
     * event.IXstEvent)
     */
    @Override
    protected IOpResponse handleSaveComplete(IXstEvent argEvent) {
        IOpResponse response = super.handleSaveComplete(argEvent);
        IParty iParty = this.getModel().getCustomer();//BZ47818
        
        long accountNumber = 0l;
        /* BEGIN BZ27280, BZ28985 */
        Long editAccountNumber = _transactionScope.getValue(CawValueKeys.EDIT_ACCOUNT_NUMBER);
        if (editAccountNumber != null && editAccountNumber > 0) {
            accountNumber = editAccountNumber;
        }
        /* END BZ27280, BZ28985 */
        clearScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN);
        CawCatalystHelper.setCatalystMessageResponse(null);
        /* Begin BZ24354*/
        CawCatalystHelper.setCatalystInputsResponse(null);
        CawCatalystHelper.setCatalystDirectiveResponse(null);
        /* End BZ24354*/

        clearScopedValue(CawValueKeys.IS_COMPLETED_VALIDATION); // BZ24385
        _transactionScope.clearValue(CawValueKeys.IS_AUTO_RENEW); // BZ24383
        // Begin BZ23477 - BZ24054
        try {
            String upSertRequest = _custHelper.buildUpsertRequest(iParty, Long.valueOf(accountNumber));//BZ47818

            if (upSertRequest != null) {
                if (CawUtilFunction.allowEBSConnection()) {
                    //BZ25675 changed by using CawEBSHelper
                    ResponseEntity<String> upSertResponse = CawEBSHelper.getInstance()
                            .upsertCustomterToEBS(upSertRequest);
                    if (StringUtils.isEmpty(upSertResponse.getBody())) {// BZ24424 
                        JSONObject crudupdate = new JSONObject(upSertRequest);

                        if (accountNumber != 0) {
                            crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD, CawCustomerCrud.UPDATED.getValue());
                            crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD_DESCRIPTION, UPDATED);

                        } else {
                            crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD, CawCustomerCrud.CREATED.getValue());
                            crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD_DESCRIPTION, CREATED);
                        }
                        upSertRequest = crudupdate.toString();
                        _custHelper.processCustomerOffline(iParty, upSertRequest);
                        // Begin BZ24424
                        JSONObject customerJson = new JSONObject(upSertRequest);
                        if (!customerJson.isNull(THE_CUSTOMER)) {
                            _transactionScope
                                    .setValue(CawValueKeys.API_LOOKUP_RESPONSE, customerJson.getString(THE_CUSTOMER));
                            setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, customerJson.getString(THE_CUSTOMER)); // BZ24498
                            CawCatalystHelper.setLookupResponseData(customerJson.getString(THE_CUSTOMER)); //BZ53724
                            _logger.info("Customer Offline:" + customerJson.getString(THE_CUSTOMER));
                        }
                        _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, iParty);

                        // End BZ24424
                    } else { //Online 
                        JSONObject responseData = new JSONObject(upSertResponse.getBody()); /*BZ-23515*/
                        if (responseData.get(CawJSONConstant.JSON_ACCOUNT_NUMBER) != null) {
                            accountNumber = responseData.getLong(CawJSONConstant.JSON_ACCOUNT_NUMBER);
                            _transactionScope.setValue(CawValueKeys.EDIT_ACCOUNT_NUMBER, accountNumber);//BZ25916
                            setScopedValue(CawValueKeys.ESB_ACCOUNT_NUMBER, accountNumber);
                            // Save customer to CRM_PARTY_ID_XREF
                            _custHelper.saveCustomerXRef(String.valueOf(accountNumber), iParty);
                            // Save customer to CRM_PARTY_ID_XREF_P
                            _custHelper.saveCustomerJSON(iParty, responseData);//BZ23367
                        }
                        setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, upSertResponse.getBody());//BZ23683
                        _transactionScope.setValue(CawValueKeys.API_LOOKUP_RESPONSE, upSertResponse.getBody());
                        CawCatalystHelper.setLookupResponseData(upSertResponse.getBody()); //BZ25435
                        _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, iParty);
                    }
                } else {
                    //CRUD
                    JSONObject crudupdate = new JSONObject(upSertRequest);

                    if (accountNumber != 0) {
                        crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD, CawCustomerCrud.UPDATED.getValue());
                        crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD_DESCRIPTION, UPDATED);

                    } else {
                        crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD, CawCustomerCrud.CREATED.getValue());
                        crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD_DESCRIPTION, CREATED);
                    }
                    upSertRequest = crudupdate.toString();
                    _custHelper.processCustomerOffline(iParty, upSertRequest);
                    // Begin BZ24424
                    JSONObject customerJson = new JSONObject(upSertRequest);
                    if (!customerJson.isNull(THE_CUSTOMER)) {
                        _transactionScope
                                .setValue(CawValueKeys.API_LOOKUP_RESPONSE, customerJson.getString(THE_CUSTOMER));
                        setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, customerJson.getString(THE_CUSTOMER)); // BZ24498
                        CawCatalystHelper.setLookupResponseData(customerJson.toString()); //BZ25435
                    }
                    // End BZ24424
                }
            }
            //BEGIN BZ62987
            storePricingFromMiddleLayer();
            storeMembershipFromMiddleLayer();
            //END BZ62987
        } catch (Exception exception) {
            _logger.error("[ESB]Can not sent Upsert request to ESB " + exception.getMessage());
        }
        // End BZ23477 - BZ24054
        //Begin BZ25358
        _transactionScope.clearValue(CawValueKeys.IS_ADDRESS_FOUND);
        //End BZ25358
        return response;
    }

    /** {@inheritDoc} */
    @Override
    protected CawCustomerMaintenanceModel createModel() {

        /* Begin BZ23340 & BZ23745 */
        CawCustomerMaintenanceModel model = null;
        CustomerMaintenanceModel baseModel = super.createModel();
        if (baseModel instanceof CawCustomerMaintenanceModel) {
            model = (CawCustomerMaintenanceModel) baseModel;
            model.setCustAccountLabel("_custNumberHeader");
            model.updateCustAccountLabel();
        }
        
        //BEGIN BZ65612 - update default from home to mobile 
        model.getCustomer().setTelephone3(model.getCustomer().getTelephone1());
        model.getCustomer().setTelephone1(null);
        //END BZ65612
        
        return model;
        /* End BZ23340 & BZ23745 */
    }

    //Begin BZ25358
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        //Begin BZ26575
        IXstActionKey actionKey = argAction.getActionKey();
        String strKey = actionKey.toString();

        if (CawConstants.QAS_APPLIED.equalsIgnoreCase(actionKey.toString())) {
            refreshModel();
            setOpState(AFTER_REQUEST);
            actionKey = XstDataActionKey.ACCEPT;
            argAction.setActionKey(actionKey);
        }

        if (CawConstants.QAS_OFFLINE.equalsIgnoreCase(actionKey.toString())) {
            refreshModelOffline();
            setOpState(AFTER_REQUEST);
            actionKey = XstDataActionKey.ACCEPT;
            argAction.setActionKey(actionKey);
        }

        if (CawConstants.QAS_NOTFOUND.equalsIgnoreCase(actionKey.toString())) {
            refreshModelOffline();
            setOpState(VALIDATION_ERROR);
        }

        if ("ACCEPT".equalsIgnoreCase(actionKey.toString())) {
            if (getOpState() != null) {
                if (!getOpState().getName().equalsIgnoreCase("VALIDATION_ERROR")
                        && !getOpState().getName().equalsIgnoreCase("CHANGE_COUNTRY")) {
                    setOpState(AFTER_REQUEST);
                }
            }
            _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
        }

        if ("CONTINUE".equalsIgnoreCase(actionKey.toString())) {
            _transactionScope.setValue(CawValueKeys.IS_NOT_RUN_ADDRESS_VALIDATION_OP, Boolean.TRUE); //BZ26575
            _transactionScope.clearValue(CawValueKeys.IS_SEARCH_CUSTOMER);
        }

        //Begin BZ26313
        if (BUTTON_YES.equalsIgnoreCase(strKey)) {
            if (Boolean.TRUE.equals(_transactionScope.getValue(CawValueKeys.IS_SEARCH_CUSTOMER))) {
                if (getOpState() != null && LOSE_CHANGES_PROMPT1.equalsIgnoreCase(getOpState().getName())) {

                    setOpState(null);
                    Boolean fnBack = _transactionScope.getValue(CawValueKeys.FN_BACK_CUST_SEARCH);
                    if (fnBack == null || Boolean.FALSE.equals(fnBack)) {
                        return HELPER.getStartChainResponse(OpChainKey.valueOf(PRE_SALE_TRANSACTION));
                    } else {
                        return HELPER.getStartChainResponse(OpChainKey.valueOf(PRE_RETURN_CHAIN));
                    }
                }
            }
        }

        return super.handleDataAction(argAction);
    }

    //Begin BZ26575

    /**
     * To apply the found address to model
     */
    private void refreshModel() {

        Object model = getModel();
        if (model != null && model instanceof CustomerMaintenanceModel) {
            CustomerMaintenanceModel cm = (CustomerMaintenanceModel) model;
            Object ob = getScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
            if (ob != null && ob instanceof IPartyLocaleInformation) {
                IPartyLocaleInformation addressInformation = (IPartyLocaleInformation) ob;
                //setEditable(true);
                cm.setAddress1(addressInformation.getAddress1());
                cm.setAddress2(addressInformation.getAddress2());
                cm.setAddress3(addressInformation.getAddress3());
                cm.setAddress4(addressInformation.getAddress4());
                cm.setApartment("");
                cm.setCity(addressInformation.getCity());
                cm.setPostalCode(addressInformation.getPostalCode());
                cm.setState(addressInformation.getState());
                cm.setCounty(addressInformation.getCounty());
                cm.setNeighborhood(addressInformation.getNeighborhood());
                cm.setCountry(addressInformation.getCountry());
                clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
            }
        }
    }

    private void refreshModelOffline() {

        Object model = getModel();
        if (model != null && model instanceof CustomerMaintenanceModel) {
            CustomerMaintenanceModel cm = (CustomerMaintenanceModel) model;
            Object ob = getScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO_OFF);
            if (ob != null && ob instanceof IPartyLocaleInformation) {
                IPartyLocaleInformation addressInformation = (IPartyLocaleInformation) ob;
                cm.setAddress1(addressInformation.getAddress1());
                cm.setAddress2(addressInformation.getAddress2());
                cm.setAddress3(addressInformation.getAddress3());
                cm.setAddress4(addressInformation.getAddress4());
                cm.setApartment("");
                cm.setCity(addressInformation.getCity());
                cm.setPostalCode(addressInformation.getPostalCode());
                cm.setState(addressInformation.getState());
                cm.setCounty(addressInformation.getCounty());
                cm.setNeighborhood(addressInformation.getNeighborhood());
                cm.setCountry(addressInformation.getCountry());
                clearScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO_OFF);
            }
        }
    }

    //Begin BZ29421
    /**
     * method validate() is used to check valid phone (home/work/mobile)
     * with regex: pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
     * \d{10} matches 1234567890
     * (?:\d{3}-){2}\d{4} matches 123-456-7890
     * if it is not valid then show message
     */
    @Override
    protected IValidationResultList validateForm(CustomerMaintenanceModel argModel) {

        IFormattable msg = null;
        String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        String patternWorkPhone = "\\d{15}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        IValidationResultList valid = new ValidationResultList();

        if (getModel() != null && getModel().getCountry().equalsIgnoreCase(CawEBSConstant.US)) {
            if (argModel.getCustomer().getTelephone1() != null) {
                if (!(argModel.getCustomer().getTelephone1().matches(pattern))) {
                    msg = _formattables.getTranslatable("_phoneHomeNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                }
            }
            if (argModel.getCustomer().getTelephone2() != null) {
                if (argModel.getCustomer().getTelephone2().length() == 10
                        && !(argModel.getCustomer().getTelephone2().matches(pattern))) {
                    msg = _formattables.getTranslatable("_phoneWorkNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                } else if (!(argModel.getCustomer().getTelephone2().matches(patternWorkPhone))) {
                    msg = _formattables.getTranslatable("_phoneWorkNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                }
            }
            if (argModel.getCustomer().getTelephone3() != null) {
                if (!(argModel.getCustomer().getTelephone3().matches(pattern))) {
                    msg = _formattables.getTranslatable("_phoneMobileNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                }
            }
            /*BEGIN BZ33518*/
            if (StringUtils.isNotEmpty(dtv.util.StringUtils
                    .nonNull(argModel.getCustomer().getOrganizationName()))) {
                String[] word = argModel.getCustomer().getOrganizationName()
                        .split("\\W+");
                argModel.getCustomer().setLastName(word[word.length - 1]);
                if (word.length > 1) {
                    word = Arrays.copyOf(word, word.length - 1);
                    String firsName = Arrays.toString(word)
                            .replaceAll("\\[|\\]|,", "").trim();
                    argModel.getCustomer().setFirstName(firsName);
                }

            }
            /*END BZ33518*/

        }
        return super.validateForm(argModel);
    }
    //End BZ29421

    /*BEGIN BZ38283*/
    private void disableActions(Collection<IXstAction> argActions) {

        // iterate and disable each action
        for (IXstAction action : argActions) {
            _logger.debug("Disabling action: " + action);
            action.setEnabled(false);
        }
    }
    /*END BZ38283*/
    
    /* BEGIN BZ42019 */
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {
        
        IOpResponse response = null;
        
        if (argEvent instanceof IXstDataAction && isSaveChangePressed(((IXstDataAction) argEvent).getActionKey())) {
            // click save
            
            response = getFormValidityResponse(getModel());
            
            if (response == null) {
                if (getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED) == null) {
                    // if hadn't validate then validate
                    CustomerMaintenanceModel model = getModel();
                    
                    if (model instanceof CawCustomerMaintenanceModel) {
                        CawCustomerMaintenanceModel cawModel = (CawCustomerMaintenanceModel) model;
                        setScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE, cawModel);
                    }
                    
                    setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.FALSE);
                    
                    return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CAW_ADDRESS_VALIDATION_NEURON_EAVS2"));
                }
            }
            
        } else if (BooleanUtils.isNotTrue(getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED))) { //BZ47888
            //if no revalidation needed then save
            
            setScopedValue(CawValueKeys.CAW_CUSTOMER_SAVED_EMAIL, getModel().getCustomer().getEmailAddress());

            clearScopse();
            
            response = super.handleFormResponse(argEvent);
        } else if (BooleanUtils.isTrue(getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED))) {
            // if revalidation needed then display again
            response = handleDisplayAgain();
        }
        
        clearScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED);
        
        if (response == null) {
            response = super.handleFormResponse(argEvent);
        }
        
        return response;
    }

    @Override
    protected IOpResponse handleBeforeDataAction(IXstEvent argEvent) {
        
        /*BEGIN BZ49356*/
        if(argEvent instanceof IXstDataAction) {
            // disable prompt actions
            IPromptActionModel promptActionModel = _modeProvider.get().getStationModel().getPromptActionModel();
            disableActions(promptActionModel.getActions());
            // disable menu actions
            IMenuModel menuModel = _modeProvider.get().getStationModel().getMenuModel();
            disableActions(menuModel.getActions());
        }
        /*END BZ49356*/
        if (getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED) != null) {
            // back from address validation chain
            return handleFormResponse(argEvent);
        } else if (argEvent instanceof IXstDataAction && isSaveChangePressed(((IXstDataAction) argEvent).getActionKey())) {
            // click save
            return handleFormResponse(argEvent);
        }
        
        return super.handleBeforeDataAction(argEvent);
    }
    
    private void clearScopse() {
        clearScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE);
        clearScopedValue(CawValueKeys.CAW_LATEST_VALIDATE_MAILING_REQUEST);
        clearScopedValue(CawValueKeys.CAW_LATEST_VALIDATE_EMAIL);
        clearScopedValue(CawValueKeys.CAW_MAILING_VALIDATION_LATEST_RESPONSE);
        clearScopedValue(CawValueKeys.CAW_EMAIL_VALIDATION_LATEST_RESPONSE);
        clearScopedValue(CawValueKeys.CAW_MAILING_ADDRESS_VALIDATION_RUN);
        clearScopedValue(CawValueKeys.CAW_EMAIL_ADDRESS_VALIDATION_RUN);
        clearScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED);
    }
    
    private boolean isSaveChangePressed(IXstActionKey actionKey) {
        boolean result = false;
        
        if ("ACCEPT".equalsIgnoreCase(actionKey.toString())) {
            if (getOpState() != null) {
                if (!getOpState().getName().equalsIgnoreCase("VALIDATION_ERROR")
                        && !getOpState().getName().equalsIgnoreCase("CHANGE_COUNTRY")) {
                    result = true;
                }
            }
        }
        
        return result;
    }
    /* END BZ42019 */
    /* BEGIN BZ61159, BZ62987*/
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
            _logger.debug("[Error at storePricingFromMiddleLayer] - UPSERT: " + ex.getMessage());
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
            _logger.debug("[Error at storeMembershipFromMiddleLayer] - UPSERT: " + ex.getMessage());
        }
    }
    /* END BZ61159, BZ62987 */
}
