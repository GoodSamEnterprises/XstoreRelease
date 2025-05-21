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
 * BZ23477              200917    Need send back customer information to EBS WS when online
 * BZ23515              260917    Cannot go to Sale screen when pressing Assign & Continue from Dashboard through using "GS Visa apply now" for new customer
 * BZ23620              290917    AR info should be added value on Customer Attributes screen
 * BZ23666              021017    HDE prompt display when pressing "Item Details" button at Purchase History of customer maintenance
 * BZ23745              061017    Club info is not displayed on Account tab when viewing a customer as activate GSAM
 * BZ24054              181017    Need send back customer information to CW Service in cases EBS is false
 * BZ24095              191017    Club pricing is not applied for membership when doing a sale transaction at first time
 * BZ24098              191017    Missing club pricing/regular price/return price for item when performing transaction 
 *                                with cash tender which total transaction is over $10000.00
 * BZ24149              201017    HDE is displayed when pressing "View Customer" button in cases EBS is false
 * BZ24297              021117    Club# is not displayed info on Account tab on Dashboard when viewing customer has membership
 * BZ25898              120418    Customer Info is still kept old on top panel at Sale screen although the info is updated successfully at Dashboard.
 * BZ25916              120418    New customer is attached account# of previous customer info unexpectedly at Dashboard also prompting request with catalyst 1 or 4
 * BZ25898              200418    Customer Info is still kept old on top panel at Sale screen although the info is updated successfully at Dashboard.
 * BZ25358              290418    Enhancements to QAS Integration with POS
 * BZ26302              170518    [1.5 QAS] Existing Customer lookup is requiring an email
 * BZ26313              210518    [QAS] Undo change button should be an Esc button.
 * BZ26568              061418    [Internal] Can assign a customer without QAS validation address lookup to sale screen after changing another country
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26289              170718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27000              030818    [26289] House Account tab info displays incorrectly the A/R data retrieved from EBS Neuron or localDB.
 * BZ28501              041218    [Internal][2.9.5] Assign&Continue is not enable also changed address is not updated after QAS validation successfully
 * BZ25761              121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ28985              190219    [Internal] Incorrect customer account number is submitted in the Upsert request to the Neuron API
 * BZ29421              180219    [Port 29355 to 4.0] Transaction errors in OS because of invalid customer data(incomplete telephone #)
 * BZ33497              291019    [INTERNAL] EBS responded 400 107:Customer updates not allowedCustomer has Crew membership that prevents updates
 * BZ33598              231219    [Prod] QAS address match issues
 * BZ28036              100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ36405              030620    Issue with Credit Customer placed on credit hold
 * BZ37753              080920    [Internal] - HDE screen displays when adding 2nd address for customer
 * BZ37834              140920    When a customer is added, pinpad verification is skipped and a receipt is printed
 * BZ37753              160920    [Internal] - HDE screen displays when adding 2nd address for customer
 * BZ38283              021020    Port bug 38212: [PROD] - Tender Token Error
 * BZ38598              301020    [PROD] Membership Activation Issues
 * BZ42019              171121    Replace QAS with EAVS2
 * BZ47818              211221    [Internal patch 7.0.18] Xstore sent incorrect address in the Upsert request to Neuron if editing address right after the customer was created
 * BZ47888              271221    Patch 18 [Internal] Changing name or phone number only does not update customer record
 * BZ47905              281221    [Internal patch 7.0.18] Xstore should send to the Order Service with the customers CRUD attribute = 4 when an existing customer is updated an address into offline mode.
 * BZ48120              180122    Pinpad shows Thank You message on top of line items after assigning customer during a sale transaction
 * BZ49356              080422    [PROD] Orders Completing With Credit Decline
 * BZ48564              100222    [Loyalty] - Need to add new Rewards column on the existing Customer Maintenance Accounts Tab
 * BZ48622              150222    [Internal]- Customer Maintenance Accounts Tab displays no values when selecting 'Select and View' on Search Customer screen.
 * BZ48848              010322    [Internal] - Loyalty information is NOT displayed on Membership Info tab.
 * BZ49730              290422    [Internal] Pinpad does not show the customer verification when assigning a customer from the Customer Maintenance screen
 * BZ55700              240323    [Loyalty Issue] Order NOT passing the pseudo membership.
 * BZ61159              190224    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.pos.customer;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.customer.membership.CawCustomerMembershipView;
import caw.pos.customer.membership.CawMembershipHelper;
import caw.pos.util.CawEBSHelper;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.customer.CustomerMaintenanceModel;
import dtv.pos.customer.EditCustomerOp;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.form.FormConstants;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.houseaccount.model.AccountUserListModel;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IMenuModel;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.IAwardAccountCoupon;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 * CawEditCustomerOp class
 */
public class CawEditCustomerOp extends EditCustomerOp {

    private static final String    CREATED                  = "Created";

    private static final String    UPDATED                  = "Updated";

    private static final String    CRUD_DESCRIPTION         = "crudDescription";

    private static final String    CRUD                     = "crud";

    private static final String    ACCOUNT_BLANCE           = "Account Blance";

    private static final Logger    _logger                  = LogManager.getLogger(CawEditCustomerOp.class);

    private CawCustomerHelper      _custHelper              = CawCustomerHelper.getInstance();

    //Begin BZ23620
    private static String          AR_ACCOUNT               = "A/R Account";

    private static String          AR_ACCOUNT_YES           = "Yes";

    private static String          AR_ACCOUNT_NO            = "No";

    //End BZ23620
    private static final String    THE_CUSTOMER             = "customer";   //BZ61159

    private static final String    CURRENT_TAB              = "CUSTCONTACTINFORMATION";
    
    //End BZ25358
    
    /*BEGIN BZ28036*/
    private static final String    HISTORY_TAB              = "CUSTOMERHISTORY";

    private static final String    RETURN_ITEM              = "RETURNITEM";

    private static final String    SELL_ITEM                = "SELLITEM";

    private static final String    CONTINUTE_RETURN         = "CONTINUTE_RETURN";
    /*END BZ28036*/

    //Begin BZ26313
    private static final String    PRE_SALE_TRANSACTION     = "PRE_SALE_TRANSACTION";

    private static final String    LOSE_CHANGES_PROMPT1     = "LOSE_CHANGES_PROMPT";

    private static final String    PRE_RETURN_CHAIN         = "PRE_RETURN_CHAIN";

    private static final String    BUTTON_YES               = "YES";

    /*BEGIN BZ28036*/
    private static final PromptKey CAW_ITEM_SELL_NOT_FILE   = PromptKey
            .valueOf("CAW_SELL_ITEM_NOT_FILE");

    private static final PromptKey CAW_ITEM_NO_SLECTED      = PromptKey
            .valueOf("CAW_ITEM_NO_SLECTED");

    private static final PromptKey CAW_ITEM_RETURN_NOT_ALOW = PromptKey
            .valueOf("CAW_ITEM_RETURN_NOT_ALOW");

    private static final PromptKey CAW_RETURN_ITEM_NOT_FILE = PromptKey
            .valueOf("CAW_RETURN_ITEM_NOT_FILE");

    //End BZ26313
    private static String          FORM_KEY                 = "";                                           //BZ25761
    
    @Inject
    private CawEigenHelper         _cawEigenHelper;/*BZ48120*/

    public CawEditCustomerOp() {

        super();
        FORM_KEY = ""; //BZ25761: this revert from this class always get GS_CUSTOMER_EDIT form.
        _transactionScope.setValue(CawValueKeys.IS_ADD_NEW_CUST_ASSOC, Boolean.FALSE);
        /*BEGIN BZ33598: isAllowEdit = true, loading customer maintenance with edit mode*/
        if (CawCustomerUtil.isAllowEdit() && Boolean.TRUE.equals(_transactionScope.getValue(CawValueKeys.IS_SELECT_VIEW))) {
            setEditable(true);//BZ25358
        }
        /*END BZ33598*/
    }

    /*
     * BZ25761
     * @see dtv.pos.customer.EditCustomerOp#setParameter(java.lang.String, java.lang.String)
     */
    @Override
    public void setParameter(String argName, String argValue) {

        if (CawConstants.FORM_STATE.equalsIgnoreCase(argName)) {
            FORM_KEY = argValue;
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /* BZ25761
     * @see dtv.pos.customer.AbstractEditCustomerOp#getBaseFormKey()
     */
    @Override
    protected FormKey getBaseFormKey() {

        if (StringUtils.isNotBlank(FORM_KEY)) {
            return FormKey.valueOf(FORM_KEY);
        }
        return super.getBaseFormKey();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * dtv.pos.customer.EditCustomerOp#handleSaveComplete(dtv.pos.iframework.
     * event.IXstEvent)
     */
    @SuppressWarnings("static-access")
    @Override
    protected IOpResponse handleSaveComplete(IXstEvent argEvent) {
        _transactionScope.setValue(CawValueKeys.IS_REMOVE_CUSTOMER, false);//BZ26313
        
        IOpResponse iOpResponse = super.handleSaveComplete(argEvent);
        
        IParty iParty = this.getModel().getCustomer();//BZ47818
        
        Long accountNumber = _transactionScope.getValue(CawValueKeys.EDIT_ACCOUNT_NUMBER);//BZ25916
        if (accountNumber == null) {
            accountNumber = Long.valueOf(0L);
        }
        
        if (iParty != null) {
            // Begin BZ23477 - BZ24054
            String upSertRequest = _custHelper.buildUpsertRequest(iParty, accountNumber);//BZ47818
            if (upSertRequest != null) {
                if (CawUtilFunction.allowEBSConnection()) {
                    //BZ26575 changed by using CawEBSHelper
                    ResponseEntity<String> upSertResponse = CawEBSHelper.getInstance()
                            .upsertCustomterToEBS(upSertRequest);
                    if (upSertResponse != null && !StringUtils.isEmpty(upSertResponse.getBody())) {//Online 
                        //BZ55700 remove code relate to BZ-23515, BZ-38598, BZ-23477
                        CawCatalystHelper.setLookupResponseData(upSertResponse.getBody()); /*BZ37834*/
                    }else {
                        handleEBSOffline(upSertRequest, accountNumber, iParty);/*BZ47905*/
                    }
                    //BZ49730  DELETE mockup in UpsertAPI
                } else {
                    handleEBSOffline(upSertRequest, accountNumber, iParty);/*BZ47905*/
                }
            }
            // End BZ23477 - BZ24054
        }
        //Begin BZ25898
        IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        if (trans != null) {
            IParty partyUpdated = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
            if (partyUpdated == null) {
                partyUpdated = this.getScopedValue(ValueKeys.SELECTED_CUSTOMER);
            }
            if (partyUpdated != null) {
                trans.setCustomerParty(partyUpdated);
            }
            /*BEGIN BZ28036*/
            /*
             * click the "sell item" or "return item" Button router to "SALE_ITEM_START" opchain
             */
            if (_transactionScope
                    .getValue(CawValueKeys.IS_SELECT_SALE_TRANSACTION) != null
                    || _transactionScope
                            .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null) {
                iOpResponse =  HELPER.getStartChainResponse(OpChainKey
                        .valueOf("SALE_ITEM_START"));
            }
        } else {
            /*
             * click the "sell item" or "return item" Button will complete opchain.
             */
            if (_transactionScope
                    .getValue(CawValueKeys.IS_SELECT_SALE_TRANSACTION) != null
                    || _transactionScope
                            .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null) {
                iOpResponse = HELPER.completeResponse();
            }
        }
        /*END BZ28036*/

        //End BZ25898
        //Begin BZ25358
        _transactionScope.clearValue(CawValueKeys.IS_ADDRESS_FOUND);
        _transactionScope.clearValue(CawValueKeys.IS_SELECT_VIEW);
        //End BZ25358
        
        return iOpResponse;
    }

    /**
     * (non-Javadoc)
     * @see dtv.pos.customer.EditCustomerOp#createModel()
     */
    @SuppressWarnings("cast")
    @Override
    protected CustomerMaintenanceModel createModel() {

        CustomerMaintenanceModel model = null;
        //Begin BZ23620
        //Begin BZ24149
        IParty partyUpdated = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        if (partyUpdated == null) {
            partyUpdated = this.getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        }
        //End BZ24149
        //Begin BZ25358
        if (partyUpdated != null) {
            //Begin BZ26302
            if (partyUpdated.getEmailAddress() != null && partyUpdated.getEmailAddress().equalsIgnoreCase("")) {
                partyUpdated.setEmailAddress(null);
            }
            //End BZ26302
            /* BEGIN BZ33497: changed checking method for Crew */
            partyUpdated.setProperties(null);
            IPartyProperty partypropertiesArAccount = null;
            partypropertiesArAccount = createPartyPropertiesArAccount(partyUpdated);
            IPartyProperty partypropertiesAccountBalance = null;
            partypropertiesAccountBalance = createPropertiesAccountBalance(partyUpdated);

            List<IPartyProperty> partyPropArAccount = new ArrayList<>();
            partyPropArAccount.add(partypropertiesArAccount);
            partyPropArAccount.add(partypropertiesAccountBalance);
            if (partyPropArAccount.size() > 0) {
                partyUpdated.setProperties(partyPropArAccount);
            }
            //END BZ23620
        }
        /*BEGIN BZ48622*/
        String jsonMessage = CawCatalystHelper.getLookupResponseData();
        _custHelper.loadMembershipInfo(partyUpdated, jsonMessage);
        /*END BZ48622*/
        this.setScopedValue(ValueKeys.SELECTED_CUSTOMER, partyUpdated);
        model = super.createModel();
        Long accountNumber = _transactionScope.getValue(CawValueKeys.EDIT_ACCOUNT_NUMBER);//BZ25916

        // BZ26289 start
        if (model instanceof CawCustomerMaintenanceModel) {

            CawCustomerMaintenanceModel cawModel = (CawCustomerMaintenanceModel) model;

            String jsonResponseEbs = CawCatalystHelper.getLookupResponseData();// BZ27000

            String custTaxExempt = CawCustomerUtil.getCustomerTaxExempt(jsonResponseEbs);
            cawModel.setCustTaxExemptStatus(custTaxExempt);
            cawModel.setCustomerHouseAccountOnHoldFlag(CawCustomerUtil
                    .isArCreditHold(jsonResponseEbs));/*BZ36405*/
            // BZ27000 start. Get available credit from EBS
            BigDecimal availableCredit = CawCustomerUtil.getAvailableCredit(jsonResponseEbs);
            cawModel.setCustomerHouseAccountAvailableCredit(availableCredit);

            // Get Joined Date of the Customer from EBS
            Date setupDate = CawCustomerUtil.getWhslSetupDate(jsonResponseEbs);
            cawModel.setCawCustomerHouseAccountSetupDate(setupDate);

            cawModel.setCawCustomerHouseAccountLastPaymentDate(CawCustomerUtil.getWhslLastPayment(jsonResponseEbs));

            // Set Customer Account Number that get from EBS
            AccountUserListModel accountList = ((CawCustomerMaintenanceModel) model).getAccountUserModel();

            if (accountNumber != null && accountList != null && accountList.getBuyers() != null) {
                int len = accountList.getBuyers().size();
                String buyerAccNum = String.valueOf(accountNumber);
                for (int i = 0; i < len; i++) {
                    accountList.getBuyers().get(i).setCustAccountId(buyerAccNum);
                }
                /*                ((CawCustomerMaintenanceModel) model)
                        .setAccountUserModel(accountList);*/
            }
            // BZ27000 end
        }
        // BZ26289 end

        if (accountNumber != null && partyUpdated != null) {
            partyUpdated.setCustomerId(String.valueOf(accountNumber));
            model.getCustAccountListModel().showForm(partyUpdated);
        }
        
        setScopedValue(CawValueKeys.CAW_CUSTOMER_SAVED_EMAIL, model.getCustomer().getEmailAddress());

        return model;
    }

    //Begin BZ23620
    /**
     * this function is used to create Party properties in case without in party.
     * @param iParty
     * @return
     */
    public IPartyProperty createPartyPropertiesArAccount(IParty iParty) {

        IPartyProperty iPartyProperty = null;
        if (iParty != null) {
            PartyPropertyId partyPropertyId = new PartyPropertyId();
            partyPropertyId.setOrganizationId(ConfigurationMgr.getOrganizationId());
            partyPropertyId.setPartyId(iParty.getPartyId());
            partyPropertyId.setPropertyCode(AR_ACCOUNT);

            iPartyProperty = DataFactory.createObject(IPartyProperty.class);
            iPartyProperty.setObjectId(partyPropertyId);

            if (checkVisibilityArAccount()) {
                iPartyProperty.setStringValue(AR_ACCOUNT_YES);
            } else {
                iPartyProperty.setStringValue(AR_ACCOUNT_NO);
            }

            iPartyProperty.setType(CawConstants.PROP_STRING_TYPE);
        }

        return iPartyProperty;
    }

    public IPartyProperty createPropertiesAccountBalance(IParty iParty) {

        IPartyProperty iPartyProperty = null;
        if (iParty != null) {
            PartyPropertyId partyPropertyId = new PartyPropertyId();
            partyPropertyId.setOrganizationId(ConfigurationMgr.getOrganizationId());
            partyPropertyId.setPartyId(iParty.getPartyId());
            partyPropertyId.setPropertyCode(ACCOUNT_BLANCE);

            iPartyProperty = DataFactory.createObject(IPartyProperty.class);
            iPartyProperty.setObjectId(partyPropertyId);

            String value = "";
            if (_transactionScope.getValue(CawValueKeys.AR_ACCOUNT_BALANCE) != null) {
                value = _transactionScope.getValue(CawValueKeys.AR_ACCOUNT_BALANCE).toString();
            } else {
                value = "0";
            }

            iPartyProperty.setStringValue(value);

            iPartyProperty.setType(CawConstants.PROP_STRING_TYPE);
        }

        return iPartyProperty;
    }

    /**
     * this function is used to check A/R account or not. based on 2 condition ( attribute 'arinfo' and balance need to greater than zero)
     */
    protected boolean checkVisibilityArAccount() {

        if ((_transactionScope.getValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT) != null)
                && _transactionScope.getValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT) == true) {
            if ((_transactionScope.getValue(CawValueKeys.AR_ACCOUNT_BALANCE) != null)
                    && _transactionScope.getValue(CawValueKeys.AR_ACCOUNT_BALANCE).compareTo(BigDecimal.ZERO) > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //End BZ23620
    //Begin BZ25358
    @SuppressWarnings("null")
    /* Start BZ 24297 */
    @Override
    protected IOpResponse handleInitialState() {

        /* Begin BZ28501 */
        String jsonMessage = CawCatalystHelper.getLookupResponseData();
        //BEGIN BZ48564
        Object model = getModel();
        if (model != null && model instanceof CustomerMaintenanceModel) {
            CustomerMaintenanceModel cm = (CustomerMaintenanceModel) model;
            
            if (CawMembershipHelper.getInstance().getMemberships() != null) {
                CawCustomerMembershipView custSelect = CawMembershipHelper.getInstance().getMemberships().get(0);
                List<IAwardAccountCoupon> listAward = custSelect.getCoupon();                
                List<Object> listCoupon = new ArrayList<>();
                
                if (listAward != null) {
                    for(IAwardAccountCoupon coupon : listAward) {
                        listCoupon.add(coupon);
                    }
                }
                                       
                cm.getCustLoyaltyAwardListModel().getModel().setElements(listCoupon);
            }            
        }        
        //END BZ48564
        /* End BZ28501 */
        /* BEGIN BZ28985 */
        if (StringUtils.isNotEmpty(jsonMessage)) {
            String accountNumber = CawCustomerUtil.getAccountNumber(jsonMessage);

            if (StringUtils.isNotEmpty(accountNumber) && StringUtils.isNumeric(accountNumber)
                    && Long.parseLong(accountNumber) > 0) {

                _transactionScope.setValue(CawValueKeys.EDIT_ACCOUNT_NUMBER, Long.parseLong(accountNumber));
            }
        }
        /* END BZ28985 */
        if (getModel() != null) {
            if (CawCustomerUtil.isAllowEdit()) { /* BZ33598: if allowEdit = true, loading FORMM in edit mode */
                if (Boolean.TRUE.equals(_transactionScope.getValue(CawValueKeys.IS_SELECT_VIEW))) {
                    getModel().addLoyaltyCard(_custHelper.getSavedCustLoyaltyCard());
                    _custHelper.setSavedCustLoyaltyCard(null);
                    _transactionScope.clearValue(CawValueKeys.IS_SELECT_VIEW);
                    FormTabKey requestedTabKey = FormTabKey.forName(CURRENT_TAB);
                    setEditable(true);
                    setOpState(AFTER_REQUEST);
                    return HELPER
                            .getChangeFormResponse(getFormKey(), getModel(), getActionGroupKey(), true, requestedTabKey);
                }
            } else {
                FormTabKey requestedTabKey = (CURRENT_TAB != null) ? FormTabKey.forName(CURRENT_TAB) : null;
                setEditable(false);
                return HELPER
                        .getChangeFormResponse(getFormKey(), getModel(), getActionGroupKey(), false, requestedTabKey);
            }
        }
        return super.handleInitialState();
    }

    /* End BZ 24297 */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        IXstActionKey actionKey = argAction.getActionKey();
        if (FormConstants.EDIT == actionKey) {
            setEditable(true);
            return HELPER.getChangeFormResponse(getFormKey(), getModel(), getActionGroupKey(), true);
        }

        if (FormConstants.EXIT == actionKey) {
            _transactionScope.setValue(CawValueKeys.IS_REMOVE_CUSTOMER, true);//BZ26313
            cleanPartyModel();
            _cawEigenHelper.refreshPinpadScreen(_transactionScope);/*BZ48120*/
            return HELPER.getBackupResponse();
        }

        /*BEGIN BZ28036*/
        /*
         * Handle when click sell item button:
         * 1. check the selected item exiting.
         * 2. check the item exit in xstore.
         * 3. updated the OpState to AFTER_REQUEST
         */
        if (SELL_ITEM.equalsIgnoreCase(actionKey.toString())) {
            if (_transactionScope
                    .getValue(CawValueKeys.ITEM_SELECTED) != null) {
                CustomerTransHistoryResult itemSelected = _transactionScope
                        .getValue(CawValueKeys.ITEM_SELECTED);
                IItem item = ItemLocator.getLocator()
                        .lookupItem(itemSelected.getItemId());
                if (item == null) {
                    IFormattable args[] = new IFormattable[1];
                    args[0] = _formattables
                            .getSimpleFormattable("", FormatterType.SIMPLE);
                    return HELPER
                            .getPromptResponse(CAW_ITEM_SELL_NOT_FILE, args);
                } else {
                    _transactionScope
                            .setValue(CawValueKeys.IS_SELECT_SALE_TRANSACTION, true);
                    setOpState(AFTER_REQUEST);/*set this to can call handleSaveComplete function*/
                    actionKey = XstDataActionKey.ACCEPT;
                    argAction.setActionKey(actionKey);
                }
            } else {
                IFormattable args[] = new IFormattable[1];
                args[0] = _formattables
                        .getSimpleFormattable("", FormatterType.SIMPLE);
                return HELPER.getPromptResponse(CAW_ITEM_NO_SLECTED, args);
            }
        }
        /*
         * Handle when click return item button:
         * 1. check the selected item exiting.
         * 2. check the item exit in xstore.
         * 3. check the return item.
         * 3. updated the OpState to AFTER_REQUEST
         */
        if (RETURN_ITEM.equalsIgnoreCase(actionKey.toString())) {
            if (_transactionScope
                    .getValue(CawValueKeys.ITEM_SELECTED) != null) {
                CustomerTransHistoryResult itemSelected = _transactionScope
                        .getValue(CawValueKeys.ITEM_SELECTED);
                IItem item = ItemLocator.getLocator()
                        .lookupItem(itemSelected.getItemId());

                if (itemSelected.getReturnFlag()) {
                    IFormattable args[] = new IFormattable[1];
                    args[0] = _formattables
                            .getSimpleFormattable("", FormatterType.SIMPLE);
                    return HELPER
                            .getPromptResponse(CAW_ITEM_RETURN_NOT_ALOW, args);
                }
                else if (item == null) {
                    IFormattable args[] = new IFormattable[1];
                    args[0] = _formattables
                            .getSimpleFormattable("", FormatterType.SIMPLE);
                    return HELPER
                            .getPromptResponse(CAW_RETURN_ITEM_NOT_FILE, args);
                }

                else {
                    _transactionScope
                            .setValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION, true);
                    setOpState(AFTER_REQUEST);
                    actionKey = XstDataActionKey.ACCEPT;
                    argAction.setActionKey(actionKey);
                }
            } else {
                IFormattable args[] = new IFormattable[1];
                args[0] = _formattables
                        .getSimpleFormattable("", FormatterType.SIMPLE);
                return HELPER.getPromptResponse(CAW_ITEM_NO_SLECTED, args);
            }
        }
        /*handle user click "Yes" Button when "return an item not on file" message is displayed*/
        if (CONTINUTE_RETURN.equalsIgnoreCase(actionKey.toString())) {
            _transactionScope
                    .setValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION, true);
            _transactionScope.setValue(CawValueKeys.IS_RETURN_CONTINUTE, true);
            setOpState(AFTER_REQUEST);
            actionKey = XstDataActionKey.ACCEPT;
            argAction.setActionKey(actionKey);
        }
        /*END BZ28036*/

        //Begin BZ26575
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
        
        if (CawConstants.HISTORY_PURCHASE.equalsIgnoreCase(actionKey.toString())) {
            setOpState(VALIDATION_ERROR);
            return HELPER.getChangeFormResponse(getFormKey(), getModel(), getActionGroupKey(), false, FormTabKey.forName(HISTORY_TAB));
        }

        if ("ACCEPT".equalsIgnoreCase(actionKey.toString())) {
            //BZ26568 added with CHANGE_COUNTRY
            if (getOpState() != null) {
                if (!getOpState().getName().equalsIgnoreCase("VALIDATION_ERROR")
                        && !getOpState().getName().equalsIgnoreCase("CHANGE_COUNTRY")) {
//                    setOpState(AFTER_REQUEST);
//                    saveChangePressed = true;
                }
            }
            _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
        }
        //End BZ26575
        if ("ABORT_CHANGES".equalsIgnoreCase(actionKey.toString())) {
            _transactionScope.clearValue(CawValueKeys.IS_ADDRESS_FOUND);
        }
        //Begin BZ26313
        if ("CONTINUE".equalsIgnoreCase(actionKey.toString())) {

            _transactionScope.setValue(CawValueKeys.IS_NOT_RUN_ADDRESS_VALIDATION_OP, Boolean.TRUE); //BZ26575
            _transactionScope.clearValue(CawValueKeys.IS_SEARCH_CUSTOMER);
        }

        if (BUTTON_YES.equalsIgnoreCase(actionKey.toString())) {

            if (Boolean.TRUE.equals(_transactionScope.getValue(CawValueKeys.IS_SEARCH_CUSTOMER))) {

                if (getOpState() != null && LOSE_CHANGES_PROMPT1.equalsIgnoreCase(getOpState().getName())) {

                    Boolean fnBack = _transactionScope.getValue(CawValueKeys.FN_BACK_CUST_SEARCH);
                    if (fnBack != null && Boolean.TRUE.equals(fnBack)) {
                        setOpState(null);
                        _cawEigenHelper.refreshPinpadScreen(_transactionScope);/*BZ48120*/
                        return HELPER.getStartChainResponse(OpChainKey.valueOf(PRE_RETURN_CHAIN));
                    } else {
                        clearCustomerValue();
                        setOpState(null);
                        return HELPER.getStartChainResponse(OpChainKey.valueOf(PRE_SALE_TRANSACTION));
                    }
                }
            }
        }
        
        return super.handleDataAction(argAction);
    }

    private void clearCustomerValue() {

        clearScopedValue(ValueKeys.SELECTED_CUSTOMER);
        _transactionScope.clearValue(ValueKeys.SELECTED_CUSTOMER);
        CawCustomerHelper.getInstance().resetSelectedCustomer();
    }

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

    //End BZ26575
  //Begin BZ29421
    /**
     * method validate() is used to check valid phone (home/work/mobile)
     * with regex: pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
     * \d{10} matches 1234567890
     * (?:\d{3}-){2}\d{4} matches 123-456-7890
     * if it is not valid then show message
     */
    @Override
    protected IValidationResultList validateForm(
            CustomerMaintenanceModel argModel) {

        IFormattable msg = null;
        String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        String patternWorkPhone = "\\d{15}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        IValidationResultList valid = new ValidationResultList();

        if (getModel() != null && getModel().getCountry()
                .equalsIgnoreCase(CawEBSConstant.US)) {
            if (argModel.getCustomer().getTelephone1() != null) {
                if (!(argModel.getCustomer().getTelephone1()
                        .matches(pattern))) {
                    msg = _formattables
                            .getTranslatable("_phoneHomeNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                }
            }
            //in case phone work is 10 digits or have extends phone (14 digits)
            if (argModel.getCustomer().getTelephone2() != null) {
                if (argModel.getCustomer().getTelephone2().length() == 10
                        && !(argModel.getCustomer().getTelephone2()
                                .matches(pattern))) {
                    msg = _formattables
                            .getTranslatable("_phoneWorkNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                } else if (!(argModel.getCustomer().getTelephone2()
                        .matches(patternWorkPhone))) {
                    msg = _formattables
                            .getTranslatable("_phoneWorkNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                }
            }
            if (argModel.getCustomer().getTelephone3() != null) {
                if (!(argModel.getCustomer().getTelephone3()
                        .matches(pattern))) {
                    msg = _formattables
                            .getTranslatable("_phoneMobileNumberFormat");
                    valid.add(SimpleValidationResult.getFailed(msg));
                    return argModel.validate(valid);
                }
            }
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
                
                    CustomerMaintenanceModel model = getModel();
                    
                    if (model instanceof CawCustomerMaintenanceModel) {
                        CawCustomerMaintenanceModel cawModel = (CawCustomerMaintenanceModel) model;
                        setScopedValue(CawValueKeys.CURRENT_EDIT_CUSTOMER_MAINTENANCE_MODLE, cawModel);
                    }
                    
                    setScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED, Boolean.FALSE);
                    
                    return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CAW_ADDRESS_VALIDATION_NEURON_EAVS2"));
                }
            }
            
        } else if (BooleanUtils.isNotTrue(getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED))) {
            /* BEGIN BZ47888 */
        	//if no revalidation needed then save
            
            setScopedValue(CawValueKeys.CAW_CUSTOMER_SAVED_EMAIL, getModel().getCustomer().getEmailAddress());

            clearScopse();
            
            response = super.handleFormResponse(argEvent);
            /* END BZ47888 */
        } else if (BooleanUtils.isTrue(getScopedValue(CawValueKeys.CAW_ADDRESS_REVALIDATION_NEEDED))) {
            //if revalidation needed then input again
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
    /*BEGIN BZ47905*/
    private void handleEBSOffline(String upSertRequest, Long accountNumber, IParty iParty) {
        try {
            JSONObject crudupdate = new JSONObject(upSertRequest);
            long acctNumber = accountNumber.longValue();
            if (acctNumber != 0) {
                crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD, CawCustomerCrud.UPDATED.getValue());
                crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD_DESCRIPTION, UPDATED);

            } else {
                crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD, CawCustomerCrud.CREATED.getValue());
                crudupdate.getJSONObject(THE_CUSTOMER).put(CRUD_DESCRIPTION, CREATED);
            }
            upSertRequest = crudupdate.toString();
            _custHelper.processCustomerOffline(iParty, upSertRequest);
            //update email address for LookupResponseData
            String lookupResponse = CawCatalystHelper.getLookupResponseData();
            if(!StringUtils.isEmpty(lookupResponse) && !StringUtils.isEmpty(iParty.getEmailAddress())) {
                String emailAddress = iParty.getEmailAddress();
                JSONObject customerJson = new JSONObject(lookupResponse);
                if(customerJson.has(CawJSONConstant.JSON_EMAIL_ADDRESS)) {
                    customerJson.put(CawJSONConstant.JSON_EMAIL_ADDRESS, emailAddress);
                    CawCatalystHelper.setLookupResponseData(customerJson.toString());
                }
            }
        } catch (JSONException ex) {
            _logger.info("Edit account number=" + accountNumber.toString());
        }
    }
    /*END BZ47905*/
    
}
