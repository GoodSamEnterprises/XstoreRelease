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
 * BZ23405          160118    [QAS] There are problem when integrate Xstore with QAS service of Camping World
 * BZ25358          290418    Enhancements to QAS Integration with POS
 * BZ26568          140618    [Internal] Can assign a customer without QAS validation address lookup to sale screen after changing another country
 * BZ26564          140618    [Internal] QAS search sent tag country incorrectly the address of customer which country is CAN
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26742          180718    [New Requirement] Update QAS results include the entered or existing customer address as an option
 * BZ30378          120619    [New Requirement] Refine QAS result and break out the street number ranges in Xstore
 * BZ37109          240820    [Task] Call QAS integration in Delivery Order to verify customer shipping address
 * BZ37753          160920    [Internal] - HDE screen displays when adding 2nd address for customer
 * BZ41382          310321    [Production] Order Service Tender Token Errors
 *===================================================================
 */

package caw.pos.address.search;

import java.math.BigInteger;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Strings;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerMaintenanceModel;
import caw.qas.proweb.*;
import oracle.retail.xstore.avs.IAddressLineAndAddressId;
import oracle.retail.xstore.avs.impl.*;
import oracle.retail.xstore.avs.impl.response.AddressVerificationResponse;

import dtv.i18n.*;
import dtv.pos.address.search.*;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.IQualifiedAddress;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyLocaleInformation;

public class CawPromptAddressLookupOp extends PromptAddressLookupOp {

    private static final PromptKey       ADDRESS_FOUND_PROMPT     = PromptKey.valueOf("ADDRESS_FOUND");

    private static final PromptKey       CAW_QAS_CHECK_CONNECTION = PromptKey.valueOf("CAW_QAS_CHECK_CONNECTION");

    private static final PromptKey       CAW_QAS_TOO_MANY_RESULTS = PromptKey.valueOf("CAW_QAS_TOO_MANY_RESULTS");
    
    public static final String          CAW_QAS_ADDRESS_LINE_MATCH = " ... ";  //BZ30378

    private CawPromptAddressLookupHelper _addressHelper           = CawPromptAddressLookupHelper.getInstance();

    @Inject
    protected FormattableFactory         _ff;

    private static final Logger          _logger                  = LogManager
            .getLogger(CawPromptAddressLookupOp.class);

    @Inject
    private IBusyState                   _busyState;

    @SuppressWarnings("null")
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        // Start BZ-41382
        // disable prompt actions
        IPromptActionModel promptActionModel = _modeProvider.get().getStationModel().getPromptActionModel();
        disableActions(promptActionModel.getActions());
        // End BZ-41382

        //Begin BZ25358
        _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, false);
        //End BZ25358

        try {
            IXstActionKey key = argAction.getActionKey();
            if (ADDRESS_LOOKUP.equals(key)) {
                IOpResponse response = handleScopedAddressSearch();
                if (response == null) {
                    return handleAddressDoSearch(argAction);
                } else {
                    return response;
                }
            } else if (REFINE_WITH_ADDRESS_LIST.equals(key) || REFINE_WITHOUT_ADDRESS_LIST.equals(key)) {
                return handleAddressDoRefine(argAction, true);
            } else if (ADDRESS_LOOKUP_CLEAR_HISTORY.equals(key)) {
                _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
                cleanup();
                return super.handleInitialState();
            } else if (XstDataActionKey.YES.equals(key)) {
                _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
                _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, true);
                //Begin BZ26575
                return getCustomerFormBack(argAction, XstDataActionKey.valueOf(CawConstants.QAS_APPLIED));
                //End BZ26575

            } else if (XstDataActionKey.NO.equals(key)) {
                // NO button is clicked on Address Found dialog
                _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
                cleanup();
                clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
                //Begin BZ26575
                return getCustomerFormBack(argAction, XstDataActionKey.valueOf(CawConstants.QAS_NOTFOUND));
                //End BZ26575
            } else if (CANCEL.equals(key) || ADDRESS_LOOKUP_CANCEL.equals(key)) {
                _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
                cleanup();
                clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
                //Begin BZ26575
                return getCustomerFormBack(argAction, XstDataActionKey.valueOf(CawConstants.QAS_NOTFOUND));
                //End BZ26575
            } else if (XstDataActionKey.ACCEPT.equals(key)) {
                _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
                if (getOpState() != null && getOpState().getName().equalsIgnoreCase("VALIDATION_ERROR")) {

                    // OK button is clicked on Address Not Found dialog, recover from previous data
                    AddressSearchInfo addressSearchInfo = getScopedValue(ValueKeys.ADDRESS_SEARCH_INFO);
                    if (addressSearchInfo != null) {
                        addressSearchInfo.setAddressLine("");

                        getModel().setAddressLine(addressSearchInfo.getAddressLine());
                        getModel().setAddressGroupList(addressSearchInfo.getAddressIds());
                        getModel().setAddressLineLabel(_formattables.getSimpleFormattable(getAddressLineLabelTag())
                                .toString(OutputContextType.VIEW));
                        if (addressSearchInfo.isMoreMatchesThanRequested()) {
                            getModel().setAddressGroupLabel(_formattables
                                    .getSimpleFormattable(ADDRESS_GROUP_LABEL_MORE_THAN_MAX)
                                    .toString(OutputContextType.VIEW));
                        } else {
                            getModel().setAddressGroupLabel(_formattables.getSimpleFormattable(ADDRESS_GROUP_LABEL)
                                    .toString(OutputContextType.VIEW));
                        }
                    } else {
                        getModel().setAddressGroupLabel(_formattables.getSimpleFormattable(ADDRESS_GROUP_LABEL)
                                .toString(OutputContextType.VIEW));
                    }
                    return handleDisplayAgain();
                }
                cleanup();
                //Begin BZ26575
                clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
                return getCustomerFormBack(argAction, XstDataActionKey.valueOf(CawConstants.QAS_NOTFOUND));
                //End BZ26575
            } else if (XstDataActionKey.valueOf(CawConstants.QAS_OFFLINE).equals(key)) {
                return handleQASBypass(argAction, true);
            }
        } catch (Exception ex) {
            _logger.error("handleDataAction-1:" + ex.getMessage());
        } finally {
            _busyState.end();
        }
        //End BZ25358
        return super.handleDataAction(argAction);
    }

    /**
     * Added BZ26575
     * To handle Scoped Address Lookup if exists
     * @return
     */
    private IOpResponse handleScopedAddressSearch() {

        IOpResponse response = null;
        try {
            CawQASearchResult resultLookup = null;
            Object transferredObj = _transactionScope.getValue(CawValueKeys.CAW_QAS_SEARCH_RESULT);
            if (transferredObj != null) {
                if (transferredObj instanceof CawQASearchResult) {
                    resultLookup = (CawQASearchResult) transferredObj;
                }
                _transactionScope.clearValue(CawValueKeys.CAW_QAS_SEARCH_RESULT);
            }

            if (resultLookup != null) {
                CawVerifyLevelType verifyLevel = resultLookup.getVerifyLevel();
                CawQAAddressType address = resultLookup.getQAAddress();
                CawQAPicklistType pickList = resultLookup.getQAPicklist();
                response = subProcessAddressSearch(verifyLevel, address, pickList);
            }

        } catch (Exception ex) {
            _logger.error("handleScopedAddressRearch-1:" + ex.getMessage());
        }
        return response;
    }

    /**
     * Handle Address Lookup button clicked
     * @return
     */
    protected IOpResponse handleAddressDoSearch(IXstDataAction argAction) {

        String addressLine = getModel().getAddressLine();
        String countryAlpha2 = getScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY); //Added BZ26564
        if (Strings.isNullOrEmpty(addressLine)) {
            try {
                Object frmModel = argAction.getData();
                if (frmModel != null && frmModel instanceof CawCustomerMaintenanceModel) {
                    CawCustomerMaintenanceModel cawModel = (CawCustomerMaintenanceModel) frmModel;
                    IQualifiedAddress mainAddress = cawModel.getMainAddress();
                    addressLine = _addressHelper.getMergedAddressOneLine(mainAddress);
                    countryAlpha2 = mainAddress.getCountry();
                }

                if (addressLine != null) {
                    //Added BZ26568
                    if (!_addressHelper.isCountryQASEnabled(countryAlpha2)) {
                        IFormattable args[] = new IFormattable[1];
                        args[0] = _ff.getSimpleFormattable(countryAlpha2, FormatterType.SIMPLE);
                        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_QAS_VALIDATE_COUNTRY"), args);
                    }
                    getModel().setAddressLine(addressLine);
                }
            } catch (Exception ex) {
                _logger.error("Can't combine text from Customer Edit Screen:" + ex.getMessage());
            }
        }

        CawQASearchResult resultLookup = null;
        if (addressLine != null && addressLine.length() > 0) {
            String line = addressLine.trim();
            if (line.length() > 0) {
                try {
                    _busyState.start(CawConstants.BUSY_STATE_MSG);
                    resultLookup = _addressHelper.doSearchAddress(line, countryAlpha2);
                    _busyState.end();
                    if (resultLookup == null) {
                        if (CawQASHelper.getInstance().isOffline()) {
                            return getPromptOffline();
                        } else {
                            return displayAddressNotFoundPrompt(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
                        }
                    }
                } catch (Exception ex) {
                    _busyState.end();
                }
            }
        }

        //validation response in case the data hasn't entered.
        IOpResponse validationResponse = getFormValidityResponse(getModel());
        if (validationResponse != null) {
            return validationResponse;
        }

        if (resultLookup != null) {
            CawVerifyLevelType verifyLevel = resultLookup.getVerifyLevel();
            CawQAAddressType address = resultLookup.getQAAddress();
            CawQAPicklistType pickList = resultLookup.getQAPicklist();
            return subProcessAddressSearch(verifyLevel, address, pickList);
        } else {
            return displayAddressNotFoundPrompt(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
        }
    }

    /**
     * @param argAction
     * @param argCallBackForm
     * @return
     */
    protected IOpResponse handleAddressDoRefine(IXstDataAction argAction, boolean argCallBackForm) {

        // refine address search from entering detail or select an address group from the list
        IAddressLineAndAddressId addressId = null;
        String countryAlpha2 = getScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY); //Added BZ26564
        CawPicklist resultRefine = null;
        try {

            AddressLookupModel model = getModel();
            if (model != null) {
                if (model.getAddressGroupListModel() != null
                        && model.getAddressGroupListModel().getSelectedElements() != null
                        && model.getAddressGroupListModel().getSelectedElements().size() > 0) {
                    Object element = getModel().getAddressGroupListModel().getSelectedElements().get(0);
                    if (element != null && element instanceof IAddressLineAndAddressId) {
                        addressId = (IAddressLineAndAddressId) element;
                    }
                }
            }

            if (addressId != null) {
                if (addressId.isRangeOfAddresses()) {
                    IOpResponse validationResponse = getFormValidityResponse(getModel());
                    if (validationResponse != null) {
                        return validationResponse;
                    }
                }
                String moniker = addressId.getAddressId();
                String refinement = getModel().getAddressLine();
                if (moniker == null || moniker.length() == 0) {
                    return displayAddressNotFoundPrompt(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
                } else if (CawResultTypeCellDataHandler.ENTERED_ADDRESS_MONIKER.compareToIgnoreCase(moniker) == 0) {
                    //BZ26742 checked not to refine the address
                    return handleQASBypass(argAction, argCallBackForm);
                } else {
                    _busyState.start(CawConstants.BUSY_STATE_MSG);
                    resultRefine = _addressHelper.doRefineAddress(moniker, refinement, countryAlpha2);
                    _busyState.end();
                    if (resultRefine == null) {
                        if (CawQASHelper.getInstance().isOffline()) {
                            return getPromptOffline();
                        } else {
                            return displayAddressNotFoundPrompt(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("handleAddressDoRefine-1" + ex.getMessage());
        }

        if (resultRefine != null) {
            return subProcessAddressRefine(resultRefine, countryAlpha2);
        } else {
            return displayAddressNotFoundPrompt(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
        }
    }

    /**
     * Used when QAS Offline
     * @return
     */
    private IOpResponse getPromptOffline() {
        _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, false);
        IFormattable args[] = new IFormattable[1];
        args[0] = _ff.getSimpleFormattable("", FormatterType.SIMPLE);
        return HELPER.getPromptResponse(CAW_QAS_CHECK_CONNECTION, args);
    }

    /**
     * 
     * @param resultRefine
     * @return
     */
    private IOpResponse subProcessAddressRefine(CawPicklist resultRefine, String language) {

        try {
            CawQASearchResult resultReSearch = null;//new CawQASearchResult();
            if (resultRefine != null && resultRefine.getQAPicklist() != null
                    && resultRefine.getQAPicklist().getPotentialMatches().compareTo(BigInteger.ZERO) != 0) {

                CawQAPicklistType pickList = resultRefine.getQAPicklist();
                List<CawPicklistEntryType> entries = pickList.getPicklistEntry();
                if (entries != null && entries.size() > 0) {
                    CawPicklistEntryType firstEntry = entries.get(0);
                    try {
                        resultReSearch = _addressHelper.doSearchAddress(firstEntry.getPartialAddress(), language);
                        if (resultReSearch == null && CawQASHelper.getInstance().isOffline()) {
                            return getPromptOffline();
                        }
                    } catch (Exception ex) {
                        return getPromptOffline();
                    }

                    if (resultReSearch != null) {
                        if (firstEntry.isUnresolvableRange()) {
                            return subProcessUnresolvableRange(resultReSearch.getVerifyLevel(), entries, pickList
                                    .isMoreOtherMatches());
                        }
                        if (resultReSearch.getQAAddress() != null
                                && resultReSearch.getQAAddress().getAddressLine() != null) {
                            List<CawAddressLineType> addressLines = resultReSearch.getQAAddress().getAddressLine();
                            return subProcessAddressLinesFound(addressLines, resultReSearch.getVerifyLevel());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("subProcessAddressRefine-1:" + ex.getMessage());
        }
        return displayAddressNotFoundPrompt(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
    }

    /**
     * 
     * @param entries
     * @param verifyLevel
     * @return
     */
    private IOpResponse subProcessUnresolvableRange(CawVerifyLevelType verifyLevel, List<CawPicklistEntryType> entries,
            boolean isMoreOtherMatches) {

        AddressVerificationResponse addressResponse = getAddressVerificationResponse(verifyLevel, entries, isMoreOtherMatches);
        /* Begin BZ30378 */
        Optional<AddressVerificationResponse> addressResponseOp = Optional.of(addressResponse);
        if(addressResponseOp.isPresent()) {
            List<IAddressLineAndAddressId> listAddress = addressResponse.getMatches();
            if(org.apache.commons.collections.CollectionUtils.isNotEmpty(listAddress)) {
                int listSize = listAddress.size();
                for (int i = 0; i < listSize; i++) {
                    if(dtv.util.StringUtils.nonNull(addressItem(listAddress, i)).contains(CAW_QAS_ADDRESS_LINE_MATCH)) {
                        return displayAddressManyResultPrompt(CawAddressSearchResultStatus.CAW_QAS_TOO_MANY_RESULTS);
                    }
                }
            }
        }
        /* End BZ30378 */
        setScopedValue(CawValueKeys.ADDRESS_RESPONSE, addressResponse);
        AddressSearchInfo addressSearchInfo = _addressHelper.addressLookup(addressResponse);
        setScopedValue(ValueKeys.ADDRESS_SEARCH_INFO, addressSearchInfo);
        setScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT, addressSearchInfo.getResultAddress());
        addressSearchInfo.setAddressLine("");
        getModel().setAddressLine(addressSearchInfo.getAddressLine());
        getModel().setAddressGroupList(addressResponse.getMatches());

        getModel().setAddressLineLabel(_formattables
                .getSimpleFormattable(_formattables.getTranslatable("_qasAddressLineLabel").toString())
                .toString(OutputContextType.VIEW));
        getModel().setAddressGroupLabel(_formattables
                .getSimpleFormattable(_formattables.getTranslatable("_qasGroupLabel").toString())
                .toString(OutputContextType.VIEW));
        return this.HELPER
                .getChangeFormResponse(this.getFormKey(), this.getModel(), this.getActionGroupKey(), this.isEditable());
    }

    /**
     * 
     * @param addressLines
     * @param verifyLevel
     * @return
     */
    private IOpResponse subProcessAddressLinesFound(List<CawAddressLineType> addressLines,
            CawVerifyLevelType verifyLevel) {

        StringBuilder addressResult = new StringBuilder();
        for (CawAddressLineType line : addressLines) {
            if (!StringUtils.isEmpty(line.getLine())) {
                addressResult.append(line.getLine()).append(" ");
            }
        }

        AddressVerificationResponse addressResponse = new AddressVerificationResponse();
        addressResponse.setRetrievedAddress(_addressHelper.adapt(addressLines));
        addressResponse.setRetrievedAddressNotComplete(_addressHelper
                .adaptRetrievedAddressIncomplete(addressResponse.getRetrievedAddress(), verifyLevel));
        addressResponse.setSearchResult(SearchResultEnum.FORMATTED_ADDRESS_AVAILABLE);

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getSimpleFormattable(addressResult.toString(), FormatterType.SIMPLE);
        if (verifyLevel.equals(CawVerifyLevelType.INTERACTION_REQUIRED)) {
            String warningStr = _ff.getSimpleFormattable("_incompleteAddressWarningMessage")
                    .toString(OutputContextType.VIEW);
            args[1] = _ff.getSimpleFormattable(warningStr, FormatterType.SIMPLE);
        } else if (verifyLevel.equals(CawVerifyLevelType.VERIFIED)) {
            args[1] = _ff.getSimpleFormattable("", FormatterType.SIMPLE);
        }
        AddressSearchInfo addressSearchInfo = _addressHelper.addressLookup(addressResponse);
        setScopedValue(ValueKeys.ADDRESS_SEARCH_INFO, addressSearchInfo);
        setScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_LINES, addressLines);
        setScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT, addressSearchInfo.getResultAddress());
        return HELPER.getPromptResponse(ADDRESS_FOUND_PROMPT, args);
    }

    /**
     * Process for Address Search
     * @param verifyLevel
     * @param address
     * @param pickList
     * @return
     */
    private IOpResponse subProcessAddressSearch(CawVerifyLevelType verifyLevel, CawQAAddressType address,
            CawQAPicklistType pickList) {

        try {
            //Response is QAAddress, it means it belongs to VERIFIED or INTERACTION_REQUIRED
            if ((address != null) && (address.getAddressLine() != null)) {
                AddressSearchInfo addressSearchInfo = _addressHelper.getAddressSearchInfo(verifyLevel, address);
                IPartyLocaleInformation localeAddressInfo = addressSearchInfo.getResultAddress();
                setScopedValue(ValueKeys.ADDRESS_SEARCH_INFO, addressSearchInfo);
                setScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT, localeAddressInfo);
                return getPromptAddressFoundResponse(verifyLevel, address.getAddressLine());
            }

            //handle for List: PREMISES_PARTIAL and MULTIPLE
            if ((pickList != null) && (pickList.getPotentialMatches().compareTo(BigInteger.ZERO) != 0)) {
                List<CawPicklistEntryType> entries = pickList.getPicklistEntry();
                /*Begin BZ25358: compare with LimitResultsQAS configuration 
                from system.properties to limit results return*/
                if (entries.size() > _addressHelper.getPicklistEntryLimit()) {
                    IFormattable args[] = new IFormattable[1];
                    args[0] = _ff.getSimpleFormattable("", FormatterType.SIMPLE);
                    return HELPER.getPromptResponse(CAW_QAS_TOO_MANY_RESULTS, args);
                }
                //End BZ25358
                boolean isMoreOtherMatches = pickList.isMoreOtherMatches();

                return subProcessUnresolvableRange(verifyLevel, entries, isMoreOtherMatches);

            }

        } catch (Exception ex) {
            _logger.error("subProcessAddressRearch-1:" + ex.getMessage());
        }
        return displayAddressNotFoundPrompt(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
    }

    /**
     * Go back to Customer View
     * @param argAction
     * @param argActionkey
     * @return
     */
    protected IOpResponse getCustomerFormBack(IXstDataAction argAction, IXstActionKey argActionkey) {
        /* BEGIN BZ37109 */
        Boolean isDeliveryInfo = _transactionScope.getValue(CawValueKeys.IS_DELIVERY_INFO);
        if (isDeliveryInfo != null && isDeliveryInfo.booleanValue() == true) {
            argAction.setActionKey(argActionkey);
            _transactionScope.setValue(CawValueKeys.IS_DELIVERY_INFO, false);
            return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("ORDER_EDIT_DELIVERY_INFO"), argAction);          
         /* END BZ37109 */    
        } /* BEGIN BZ37753 */

        String isMultiAddressForm = _transactionScope.getValue(CawValueKeys.MULTI_ADDRESS_FORM_ADD_OR_EDIT);
        if (isMultiAddressForm != null) {
            if (isMultiAddressForm.equals("ADD")) {
                argAction.setActionKey(argActionkey);
                _transactionScope.setValue(CawValueKeys.MULTI_ADDRESS_FORM_ADD_OR_EDIT, "");
                return HELPER.getCompleteStackChainResponse(OpChainKey
                        .valueOf("ADD_CUSTOMER_ADDRESS"), argAction);
            } else if(isMultiAddressForm.equals("EDIT")) {
                argAction.setActionKey(argActionkey);
                _transactionScope.setValue(CawValueKeys.MULTI_ADDRESS_FORM_ADD_OR_EDIT, "");
                return HELPER.getCompleteStackChainResponse(OpChainKey
                        .valueOf("EDIT_CUSTOMER_ADDRESS"), argAction);
            }
        }
        
        
        Boolean isAddNewCust = _transactionScope
                .getValue(CawValueKeys.IS_ADD_NEW_CUST_ASSOC);
        if (isAddNewCust != null && isAddNewCust.booleanValue() == true) {
            argAction.setActionKey(argActionkey);
            return HELPER.getCompleteStackChainResponse(OpChainKey
                    .valueOf("ADD_NEW_CUST_ASSOC"), argAction);
        } else {
            argAction.setActionKey(argActionkey);
            return HELPER.getCompleteStackChainResponse(OpChainKey
                    .valueOf("CUST_ASSOCIATION_EDIT"), argAction);
        }
        /* END BZ37753 */   
    }

    private IOpResponse getPromptAddressFoundResponse(CawVerifyLevelType verifyLevel,
            List<CawAddressLineType> addressLines) {

        // Format response and assign it to formattable to show
        StringBuilder addressResult = new StringBuilder();
        for (CawAddressLineType line : addressLines) {
            if (!StringUtils.isEmpty(line.getLine())) {
                addressResult.append(line.getLine()).append(" ");
            }
        }
        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getSimpleFormattable(addressResult.toString(), FormatterType.SIMPLE);
        //For case: INTERACTION_REQUIRED
        if (verifyLevel.equals(CawVerifyLevelType.INTERACTION_REQUIRED)) {
            String warningStr = _ff.getSimpleFormattable("_incompleteAddressWarningMessage")
                    .toString(OutputContextType.VIEW);
            args[1] = _ff.getSimpleFormattable(warningStr, FormatterType.SIMPLE);
        }
        //For case: VERIFIED
        else if (verifyLevel.equals(CawVerifyLevelType.VERIFIED)) {
            args[1] = _ff.getSimpleFormattable("", FormatterType.SIMPLE);
        }
        return HELPER.getPromptResponse(ADDRESS_FOUND_PROMPT, args);
    }
    //End BZ25358

    /**
     * Added 26742
     * @param argAction
     * @param argCallBackForm
     * @return
     */
    protected IOpResponse handleQASBypass(IXstDataAction argAction, boolean argCallBackForm) {

        if (argCallBackForm) {
            _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, false);
            _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, true);
            //cleanup();
            //Begin BZ26575
            clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
            return getCustomerFormBack(argAction, XstDataActionKey.valueOf(CawConstants.QAS_OFFLINE));
            //End BZ26575
        } else {
            return HELPER.completeResponse();
        }
    }

    /**
     * Added 26742 to get the entered address or existing address 
     * @return
     */
    protected AddressLineAndAddressIdImpl getEnteredAddressOption() {

        AddressLineAndAddressIdImpl theLastLineAndId = null;
        //Get the entered address from the form
        IPartyLocaleInformation localeToUpdate = getScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO_OFF);
        
        /* BEGIN BZ37109 */
        Boolean isDeliveryInfo = _transactionScope.getValue(CawValueKeys.IS_DELIVERY_INFO);
        if (isDeliveryInfo != null && isDeliveryInfo.booleanValue() == true) {
            localeToUpdate = getScopedValue(CawValueKeys.CAW_DELIVERY_ADDRESS_INFO_OFF);
        }
        /* END BZ37109 */
        
        /* BEGIN BZ37753 */
        String isMultiAddressForm = _transactionScope.getValue(CawValueKeys.MULTI_ADDRESS_FORM_ADD_OR_EDIT);
        if (StringUtils.isNotEmpty(isMultiAddressForm)) {
            localeToUpdate = getScopedValue(CawValueKeys.CAW_MULTI_ADDRESS_FORM_OFF);
        }
        /* END BZ37753 */
        
        if (localeToUpdate == null) {
            //Or Get the existing address
            IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
            if (party != null) {
                List<IPartyLocaleInformation> addresses = party.getLocaleInformation();
                if (addresses != null && addresses.size() > 0) {
                    localeToUpdate = addresses.get(0);
                }
            }
        }

        if (localeToUpdate != null) {
            theLastLineAndId = new AddressLineAndAddressIdImpl();
            String currentAddressLine = _addressHelper.getMergedAddressOneLine(localeToUpdate);
            theLastLineAndId.setAddressline(currentAddressLine);
            theLastLineAndId.setRangeOfAddresses(false);
            theLastLineAndId.setAddressId(CawResultTypeCellDataHandler.ENTERED_ADDRESS_MONIKER);
        }
        return theLastLineAndId;
    }

    /**
     * Added 26742
     * @param entries
     * @param verifyLevel
     * @return
     */
    private ArrayList<IAddressLineAndAddressId> getAddressGroupList(CawVerifyLevelType verifyLevel,
            List<CawPicklistEntryType> entries) {

        ArrayList<IAddressLineAndAddressId> addressGroupList = new ArrayList<IAddressLineAndAddressId>();
        AddressLineAndAddressIdImpl lineAndId = null;
        /* Begin BZ30378 */
        if(org.apache.commons.collections.CollectionUtils.isNotEmpty(entries)) {
            int entriesSize = entries.size();
            for (int i = 0; i < entriesSize; i++) {
                lineAndId = new AddressLineAndAddressIdImpl();
                lineAndId.setAddressline(entries.get(i).getPicklist());
                lineAndId.setAddressId(entries.get(i).getMoniker());
                lineAndId.setRangeOfAddresses(_addressHelper.getUnresolvableRange(entries.get(i)));
                if (lineAndId.isRangeOfAddresses()) {
                    //For case: PREMISES_PARTIAL
                    if (verifyLevel.equals(CawVerifyLevelType.PREMISES_PARTIAL)) {
                        lineAndId.setAdditionalDataType(AdditionalDataTypeEnum.PREMISE_NUMBER_NEEDED);
                    }
                    //For case: STREET_PARTIAL
                    else if (verifyLevel.equals(CawVerifyLevelType.STREET_PARTIAL)) {
                        lineAndId.setAdditionalDataType(AdditionalDataTypeEnum.STREET_NUMBER_NEEDED);
                    } else {
                        lineAndId.setAdditionalDataType(AdditionalDataTypeEnum.UNSPECIFIED_VALUE_NEEDED);
                    }
                } else {
                    lineAndId.setAdditionalDataType(AdditionalDataTypeEnum.ADDRESS_VERIFIED);
                }
                lineAndId.setAddressLineNotComplete(entries.get(i).isIncompleteAddr());
                lineAndId.setPostalCode(entries.get(i).getPostcode());
                addressGroupList.add(lineAndId);
                if(addressLineCheck(lineAndId.getAddressLine())) {
                    return addressGroupList;
                }
                
            }
        }
        /* End BZ30378 */
        return addressGroupList;
    }

    protected AddressVerificationResponse getAddressVerificationResponse(CawVerifyLevelType verifyLevel,
            List<CawPicklistEntryType> entries, boolean isMoreOtherMatches) {

        AddressVerificationResponse addressResponse = new AddressVerificationResponse();
        addressResponse.setMoreMatchesThanRequested(isMoreOtherMatches);
        ArrayList<IAddressLineAndAddressId> addressGroupList = getAddressGroupList(verifyLevel, entries);
        int size = addressGroupList.size();
        if (size > 1) {
            //For case: MULTIPLE
            addressResponse.setSearchResult(SearchResultEnum.MULTIPLE_MATCHES);
        } else if ((size == 1) && (addressResponse.getSearchResult() == null)) {
            addressResponse.setSearchResult(SearchResultEnum.ONE_UNVERIFIED_ADDRESS_IN_LIST);
            addressResponse.setRetrievedAddressNotComplete(true);
        }
        if (addressGroupList.size() > 0) {
            //Begin BZ26742 add current address as the last option
            AddressLineAndAddressIdImpl theLastLineAndId = getEnteredAddressOption();
            if (theLastLineAndId != null) {
                addressGroupList.add(theLastLineAndId);
            }
            //End BZ26742
        }
        addressResponse.setMatches(addressGroupList);
        return addressResponse;
    }
    
    // Start BZ-41382
    /**
     * Disable actions
     * @param argActions - list of action
     */
    private void disableActions(Collection<IXstAction> argActions) {

        // iterate and disable each action
        for (IXstAction action : argActions) {
            _logger.debug("Disabling action: " + action);
            action.setEnabled(false);
        }
    } // End BZ-41382

    /* Begin BZ30378 */
    /**
     * Display address many result prompt.
     *
     * @param argCawQasTooManyResults the arg caw qas too many results
     * @return the i op response
     */
    protected IOpResponse displayAddressManyResultPrompt(AddressSearchResultStatus argCawQasTooManyResults) {
        this.cleanup();
        return this.HELPER.getPromptResponse(CAW_QAS_TOO_MANY_RESULTS,
                this.getAddressTooManyFounPromptArgs(argCawQasTooManyResults));
    }
    
    /**
     * Gets the address too many foun prompt args.
     *
     * @param status the status
     * @return the address too many foun prompt args
     */
    protected IFormattable[] getAddressTooManyFounPromptArgs(AddressSearchResultStatus status) {
        return new IFormattable[]{this._formattables.getSimpleFormattable(status.getMessage()), this._formattables.getSimpleFormattable(status.getStatus())};
    }
    
    /**
     * Address line check.
     *
     * @param addressLine the address line
     * @return true, if successful
     */
    protected boolean addressLineCheck(String addressLine) {
        if(dtv.util.StringUtils.nonEmpty(addressLine).contains(CAW_QAS_ADDRESS_LINE_MATCH)) {
                return true;
        }
        return false;
    }
    
    /**
     * Address item.
     *
     * @param list the list
     * @param index the index
     * @return the string
     */
    protected String addressItem(List<? extends IAddressLineAndAddressId> list, int index) {
        return list.get(index).getAddressLine();
    }
    /* End BZ30378 */
}
