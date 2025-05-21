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
 * BZ24945          281217    AR tender is disable on Return tender option screen when performing return transaction by scanning trans on Sell item screen
 * BZ26500          060618    Xstore allows to complete trans with Third-party tender which customer has belong club pricing once EBS is offline
 * BZ29201          120919    [Internal] PO# displays abnormal value on receipt when PO information does not capture on Xstore for A/R or Third party tender
 * BZ35326          120320    [PROD] [NEW REQ] Non-credited Wholesale using Credit / AR and 3rd Party Credit mapped to same Tender Type/Trans Code
 *===================================================================
 */

package caw.pos.araccount;

import static dtv.hardware.types.InputType.*;
import static dtv.pos.framework.form.FormConstants.NEW;
import static dtv.pos.framework.form.FormConstants.SELECT;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.araccount.CawCustomerUtil.NoResultsReason;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.IObjectId;
import dtv.data2.access.IQueryResultList;
import dtv.data2x.impl.req.TooManyRecordsFoundException;
import dtv.hardware.dl.IDriversLicenseEvent;
import dtv.hardware.events.*;
import dtv.pos.common.*;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.customer.CustomerSearchModel;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.form.IHasAddressFields;
import dtv.pos.framework.op.AbstractSearchFormOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IMenuModel;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.spring.ValueKeys;
import dtv.util.*;
import dtv.util.config.ConfigUtils;
import dtv.util.config.ParameterConfig;
import dtv.util.crypto.EncString;
import dtv.xst.crm.cust.ICustomerQueryResult;
import dtv.xst.crm.exceptions.InvalidUserException;
import dtv.xst.crm.impl.cust.SecurityPrivilegeType;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.PartyId;

/**
 *
 */
public class CawCustomerSearchThirdPartyOp extends
        AbstractSearchFormOp<ICustomerQueryResult, IParty, CustomerSearchModel> implements IXstEventObserver {

    private static final IXstEventType[] EVENTS                                       = new IXstEventType[] { INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE };

    private static final String          PARAM_RESULTS_PROMPT                         = "RESULTS_PROMPT";

    private static final String          PARAM_IGNORE_CURRENT_PARTY                   = "IGNORE_CURRENT_PARTY";

    private static final String          PARAM_PRIMARY_ADDRESS_ONLY                   = "PrimaryOnly";

    private static final String          PARAM_ADD_CUSTOMER_CHAIN                     = "AddCustomerChain";

    private static final String          PARAM_EDIT_CUSTOMER_CHAIN                    = "EditCustomerChain";

    private static final String          PARAM_ALWAYS_VIEW_CUSTOMER                   = "AlwaysViewCustomer";

    private static final Logger          _logger                                      = LogManager
            .getLogger(CawCustomerSearchThirdPartyOp.class);

    private PromptKey                    resultsPromptKey_                            = null;

    private boolean                      ignoreCurrentParty_                          = false;

    private boolean                      _customerRequired                            = true;

    private OpChainKey                   _addCustomerChain                            = null;

    private OpChainKey                   _editCustomerChain                           = null;

    private NoResultsReason              _noResultsReason                             = NoResultsReason.NO_RECORDS_THIRD_PARTY_AVAILABLE;

    private boolean                      _viewCustomerSelected                        = false;

    private boolean                      _viewCustomerAlways                          = false;

    @Inject
    private CustomerHelper               _customerHelper;

    //Begin BZ24561
    private static final String          CAW_PROMPT_EBS_OFFLINE                       = "CAW_PROMPT_EBS_OFFLINE";

    private static final String          CAW_PROMPT_NO_CUSTOMER_THIRD_PARTY_AVAILABLE = "CAW_PROMPT_NO_CUSTOMER_THIRD_PARTY_AVAILABLE";

    private static final String          PRE_TENDERING                                = "PRE_TENDERING";

    private static final String          BACK_TO_TENDER                               = "BACKTOTENDER";

    //End BZ24561
    /** {@inheritDoc} */
    @Override
    public IXstEventType[] getObservedEvents() {

        return EVENTS;
    }

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpReverse(IXstEvent argEvent) {

        /* Need when we escape from future Operations (such as Customer Maintenance). We must put the Command
         * object back in it's initial state in order for the reprompt to work correctly. Activity 169264. - C
         * Dusseau 3/14/06 */
        if (!ignoreCurrentParty_) {
            clearScopedValue(ValueKeys.SELECTED_CUSTOMER);
        }

        _viewCustomerSelected = false;
        return HELPER.completeResponse();
    }

    /** {@inheritDoc} */
    @Override
    public void setParameter(String argName, String argValue) {

        if (PARAM_RESULTS_PROMPT.equalsIgnoreCase(argName)) {
            resultsPromptKey_ = PromptKey.valueOf(argValue);
        } else if (PARAM_IGNORE_CURRENT_PARTY.equalsIgnoreCase(argName)) {
            ignoreCurrentParty_ = ConfigUtils.toBoolean(argValue);
        } else if (PARAM_PRIMARY_ADDRESS_ONLY.equalsIgnoreCase(argName)) {
            ConfigUtils.toBoolean(argValue);
        } else if (PARAM_ADD_CUSTOMER_CHAIN.equalsIgnoreCase(argName)) {
            _addCustomerChain = OpChainKey.valueOf(argValue);
        } else if (PARAM_EDIT_CUSTOMER_CHAIN.equalsIgnoreCase(argName)) {
            _editCustomerChain = OpChainKey.valueOf(argValue);
        } else if (PARAM_ALWAYS_VIEW_CUSTOMER.equalsIgnoreCase(argName)) {
            _viewCustomerAlways = ConfigUtils.toBoolean(argValue);
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected CustomerSearchModel createModel() {

        CustomerSearchModel model = new CustomerSearchModel();
        return model;
    }

    /** {@inheritDoc} */
    @Override
    protected DataActionGroupKey getActionGroupKey() {

        return _customerRequired ? DataActionGroupKey.NO_SKIP
                : DataActionGroupKey.DEFAULT;
    }

    /** {@inheritDoc} */
    @Override
    protected FormKey getBaseFormKey() {

        return FormKey.valueOf("CUSTOMER_SEARCH");
    }

    /** {@inheritDoc} */
    @Override
    protected PromptKey getNoCriteriaPrompt() {

        return PromptKey.valueOf("NO_CUST_SEARCH_CRITERIA");
    }

    /** {@inheritDoc} */
    @Override
    protected PromptKey getNoResultsPromptKey() {

        //Begin BZ24945
        //Begin BZ24561
        if (_noResultsReason.getPromptKey() != null) {
            if (_noResultsReason.getPromptKey().compareTo(PromptKey
                    .valueOf(CAW_PROMPT_EBS_OFFLINE)) == 0) {
                return PromptKey.valueOf(CAW_PROMPT_EBS_OFFLINE);
            } else {
                return PromptKey
                        .valueOf(CAW_PROMPT_NO_CUSTOMER_THIRD_PARTY_AVAILABLE);
            }
            //End BZ24561
            //End BZ24945
        } else {
            return _noResultsReason.getPromptKey();
        }
    }

    /** {@inheritDoc} */
    @Override
    protected PromptKey getSearchResultsPromptKey() {

        return resultsPromptKey_;
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleBeforeDataAction(IXstEvent argEvent) {

        // Check any parameters that may be on the event.
        if (argEvent instanceof IXstAction) {
            IXstAction action = (IXstAction) argEvent;

            if (action.getParameters() != null) {
                for (ParameterConfig parameter : action.getParameters()) {
                    if (CawCustomerUtil.PARAM_CUSTOMER_REQUIRED
                            .equals(parameter.getName())) {
                        _customerRequired = ConfigUtils
                                .toBoolean(parameter.getValue());
                    }
                }
            }
        }

        // The concrete CustomerCardEvent represents a customer id search
        if (argEvent instanceof CustomerCardEvent) {
            CustomerCardEvent event = (CustomerCardEvent) argEvent;
            String idField = CustomerSearchModel.CUSTOMER_NUMBER_FIELD;
            String id = EncString.getSensitiveData(event.getAccountNumber());

            return handleIdSearch(id, idField);
        }
        // Any other event implementing ICustomerCardEvent represent loyalty number search
        else if (argEvent instanceof ICustomerCardEvent) {
            ICustomerCardEvent event = (ICustomerCardEvent) argEvent;
            String idField = CustomerSearchModel.LOYALTY_NUMBER_FIELD;
            String id = EncString.getSensitiveData(event.getAccountNumber());

            return handleIdSearch(id, idField);
        } else if (argEvent instanceof IDriversLicenseEvent) {
            IDriversLicenseEvent event = (IDriversLicenseEvent) argEvent;
            return handleDriversLicenseSearch(event);
        }

        if (argEvent instanceof IHardwareInputEvent) {
            String id = argEvent.getStringData();
            final String idField;

            if (argEvent instanceof EmployeeCardEvent) {
                idField = CustomerSearchModel.EMPLOYEE_NUMBER_FIELD;
            } else {
                idField = CustomerSearchModel.LOYALTY_NUMBER_FIELD;
            }

            return handleIdSearch(id, idField);
        }

        return super.handleBeforeDataAction(argEvent);
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        IXstActionKey key = argAction.getActionKey();

        if (key == NEW) {
            IParty customer = _customerHelper.createParty(getModel()
                    .getChanges(), _stationState.getRetailLocationId());
            setScopedValue(ValueKeys.SELECTED_CUSTOMER, customer);
            if (customer.getPrimaryLocaleInformation() != null
                    && !StringUtils.isEmpty(getModel().getCountry())) {
                customer.getPrimaryLocaleInformation()
                        .setCountry(getModel().getCountry());
            }

            return HELPER
                    .getCompleteStackChainResponse(_addCustomerChain, argAction);
        } else if (SHOWING_LIST.equals(getOpState()) && (key == SELECT)) {
            _viewCustomerSelected = true;
            return handleListSelection(argAction);
        } //Begin BZ24561
        else if (key.toString().equalsIgnoreCase(BACK_TO_TENDER)) {
            return HELPER
                    .getStartChainResponse(OpChainKey.valueOf(PRE_TENDERING));
        }
        //End BZ24561

        /*BEGIN BZ29201*/
        if (key == XstDataActionKey.ACCEPT) {
            IPromptActionModel promptActionModel = _modeProvider.get().getStationModel().getPromptActionModel();
            disableActions(promptActionModel.getActions());
            IMenuModel menuModel = _modeProvider.get().getStationModel().getMenuModel();
            disableActions(menuModel.getActions());
        }
        /*END BZ29201*/
        return super.handleDataAction(argAction);
    }

    /*BEGIN BZ29201*/
    /**
     * this function is used to disable action.
     * @param IXstAction
     * 
     */
    protected void disableActions(Collection<IXstAction> argActions) {
        Iterator<IXstAction> actions = argActions.iterator();
        while (actions.hasNext()) {
            IXstAction action = actions.next();
            _logger.debug("Disabling action: " + action);
            action.setEnabled(false);
        }
    }
    /*BEGIN BZ29201*/

    /**
    * Invokes a search query for a customer identified by the drivers's license scan.
    *
    * @param argEvent the barcode event continaing the customer data.
    * @return the opertaional reponse from the search.
    */
    protected IOpResponse handleDriversLicenseSearch(
            IDriversLicenseEvent argEvent) {

        IEditModel editModel = getModel();
        editModel.setValue(IHasAddressFields.CITY_FIELD, argEvent.getCity());
        editModel.setValue(CustomerSearchModel.FIRST_NAME_FIELD, argEvent
                .getFirstName());
        editModel.setValue(CustomerSearchModel.LAST_NAME_FIELD, argEvent
                .getLastName());
        editModel.setValue(IHasAddressFields.POSTAL_CODE_FIELD, argEvent
                .getPostalCode());
        editModel.setValue(IHasAddressFields.STATE_FIELD, argEvent.getState());

        return handleSearch(editModel.getChanges());
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        Collection<IKeyedValue<String, ?>> fields = getModel().getChanges();

        if (!fields.isEmpty()) {
            Iterator<IKeyedValue<String, ?>> it = fields.iterator();
            String key, currentCountry;
            while (it.hasNext()) {
                key = it.next().getKey();

                // Add country field to search parameter ONLY when state field is supplied.
                if (key != null && key.equals(IHasAddressFields.STATE_FIELD)
                        && getModel().getState() != null) {
                    currentCountry = getModel().getCountry();
                    fields.add(new KeyValuePair<String, Object>(
                            IHasAddressFields.COUNTRY_FIELD, currentCountry));
                    break;
                }
            }
        }

        // search and display search results
        return handleSearch(fields);
    }

    /**
    * Invokes a search query for the customer uniquely identified by the specified key.
    *
    * @param argId the unique value by which the searched-for customer is identifiable
    * @param argFieldName the name of the model field to which is assigned <code>argId</code>
    * @return the operational response derived as a result of the search
    */
    protected IOpResponse handleIdSearch(String argId, String argFieldName) {

        IEditModel editModel = getModel();
        editModel.setValue(argFieldName, argId);

        return handleSearch(editModel.getChanges());
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleListSelection(IXstEvent argEvent) {

        Object selectedResult = argEvent.getData();

        if (selectedResult instanceof ICustomerQueryResult) {
            String secPrivilege = ((ICustomerQueryResult) selectedResult)
                    .getSecurityPrivilege();

            if (secPrivilege != null) {
                if (SecurityPrivilegeType.LIMITED_READ.matches(secPrivilege)) {
                    return HELPER.getPromptResponse(getNoSecurityAccess());
                }
            }
        }

        return super.handleListSelection(argEvent);
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleSetSelection(ICustomerQueryResult argSelected) {

        IOpResponse response = super.handleSetSelection(argSelected);

        if (response.getOpStatus().isComplete()
                && (_viewCustomerSelected || _viewCustomerAlways)) {
            response = HELPER.getCompleteStackChainResponse(_editCustomerChain);
        }

        return response;
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handleSkip() {

        // Skipping customer search means that you can also skip anything that you can also skip anything else
        // later in the chain that would have relied on a customer being selected, so just complete the chain.
        return HELPER.completeCurrentChainResponse();
    }

    /** {@inheritDoc} */
    @Override
    protected IParty retrieveResult(IObjectId argObjectId) {

        String userId = _stationState.getSystemUser().getOperatorParty()
                .getEmployeeId();
        /* We have to call the (new) version of this method that takes the party ID (and not its component
         * primitive value(s)). The ID objects derived from the query results may contain properties that we have
         * to query for at least a little longer, and atomizing the ID at this point makes those properties
         * unrecoverable. */
        return _customerHelper
                .searchPartyById((PartyId) argObjectId, _stationState
                        .getRetailLocationId(), userId);
    }

    /** {@inheritDoc} */
    @Override
    protected IQueryResultList<ICustomerQueryResult> runQueryWrapResults(
            Collection<IKeyedValue<String, ?>> argFields) {
        //Begin BZ26500
        try {
            if (_transactionScope
                    .getValue(CawValueKeys.IS_ALLOW_DISPLAY_THIRD_PARTY) != null
                    && _transactionScope
                            .getValue(CawValueKeys.IS_ALLOW_DISPLAY_THIRD_PARTY) == true) {
                _noResultsReason = NoResultsReason.NO_RECORDS_THIRD_PARTY;
            } else {
                //Begin BZ24561
                if (_transactionScope.getValue(CawValueKeys.EBS_TIMEOUT) != null
                        && _transactionScope
                                .getValue(CawValueKeys.EBS_TIMEOUT) == true) {
                    _noResultsReason = NoResultsReason.EBS_OFFLINE;
                } else {
                    _noResultsReason = NoResultsReason.NO_RECORDS;
                }
                //End BZ24561
            }
            //End BZ26500
        } catch (TooManyRecordsFoundException ex) {
            _noResultsReason = NoResultsReason.TOO_MANY_RECORDS;
            _logger.info("Too many records found." + ex.getMessage());
        } catch (InvalidUserException ex) {
            _noResultsReason = NoResultsReason.INVALID_USER;
            _logger.info("Invalid User." + ex.getMessage());
        }

        return null;
    }

    /** {@inheritDoc} */
    @Override
    protected void setSelectedResult(IParty argDataModel) {

        /* BEGIN BZ35326 */
        //Only set scope SELECTED_CUSTOMER when available Balance of customer Third party > 0.
        //To fix auto assign customer third party to transaction
        if (_transactionScope.getValue(CawValueKeys.TP_ACCOUNT_BALANCE) != null
                && _transactionScope.getValue(CawValueKeys.TP_ACCOUNT_BALANCE)
                        .compareTo(BigDecimal.ZERO) == 1) {
            setScopedValue(ValueKeys.SELECTED_CUSTOMER, argDataModel);
        }
        /* END BZ35326 */
    }

    /** {@inheritDoc} */
    @Override
    protected boolean showListIfOne() {

        return ConfigurationMgr.showCustomerListIfOne();
    }
}
