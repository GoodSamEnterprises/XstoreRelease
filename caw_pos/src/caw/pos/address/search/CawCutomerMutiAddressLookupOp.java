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
 * BZ26575          180618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26742          180718    [New Requirement] Update QAS results include the entered or existing customer address as an option
 * BZ30378          120619    [New Requirement] Refine QAS result and break out the street number ranges in Xstore
 *===================================================================
 */

package caw.pos.address.search;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.qas.proweb.*;
import oracle.retail.xstore.avs.IAddressLineAndAddressId;
import oracle.retail.xstore.avs.impl.response.AddressVerificationResponse;

import dtv.pos.address.search.AddressLookupModel;
import dtv.pos.common.OpChainKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyLocaleInformation;

/**
 *
 */
public class CawCutomerMutiAddressLookupOp extends CawPromptAddressLookupOp {

    private static final Logger          _logger        = LogManager.getLogger(CawCutomerMutiAddressLookupOp.class);

    private CawPromptAddressLookupHelper _addressHelper = CawPromptAddressLookupHelper.getInstance();

    @Override
    public boolean isOperationApplicable() {

        if (CawConstants.MULTIPLE_DISPAY.equals(getScopedValue(CawValueKeys.IS_ADDRESS_MULTIPLE_DISPLAY))
                && getScopedValue(CawValueKeys.CAW_QAS_SEARCH_RESULT) != null) {
            return true;
        }

        return false;
    }

    @Override
    protected AddressLookupModel createModel() {

        AddressLookupModel model = this.getModel();
        if (model == null) {
            model = new AddressLookupModel("_addressLookupTitle");
        }

        CawQASearchResult resultLookup = getScopedValue(CawValueKeys.CAW_QAS_SEARCH_RESULT);
        if (resultLookup != null) {
            CawVerifyLevelType verifyLevel = resultLookup.getVerifyLevel();
            //CawQAAddressType address = resultLookup.getQAAddress();
            CawQAPicklistType pickList = resultLookup.getQAPicklist();

            if ((pickList != null) && (pickList.getPotentialMatches().compareTo(BigInteger.ZERO) != 0)) {
                List<CawPicklistEntryType> entries = pickList.getPicklistEntry();
                AddressVerificationResponse res = getAddressVerificationResponse(verifyLevel, entries, pickList
                        .isMoreOtherMatches());
                List<IAddressLineAndAddressId> addressGrouplst = res.getMatches();
                if (addressGrouplst != null && addressGrouplst.size() > 0) {
                    model.setAddressGroupList(addressGrouplst);
                }
            }
        }

        return model;
    }

    @Override
    protected IOpResponse handleInitialState() {

        IOpResponse iOpResponse = super.handleInitialState();
        /* Begin BZ30378 */
        Optional<AddressLookupModel> createModel = Optional.of(createModel());
        if(createModel.isPresent()) {
            List<? extends IAddressLineAndAddressId> listAddress = createModel().getAddressGroupListModel().getAddresses();
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
        return iOpResponse;
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        return super.handleFormResponse(argEvent);
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        try {
            IXstActionKey key = argAction.getActionKey();
            if (ADDRESS_LOOKUP.equals(key) && argAction.getData() != null) {
                String address = "";
                if (argAction.getData() instanceof AddressLookupModel) {
                    AddressLookupModel addressLookupModel = (AddressLookupModel) argAction.getData();
                    address = addressLookupModel.getAddressLine();
                    this.getModel().setAddressLine(address);
                }
                return super.handleAddressDoSearch(argAction);

            } else if (REFINE_WITH_ADDRESS_LIST.equals(key) || REFINE_WITHOUT_ADDRESS_LIST.equals(key)) {
                return super.handleAddressDoRefine(argAction, false);//BZ26742 modified

            } else if (ADDRESS_LOOKUP_CLEAR_HISTORY.equals(key)) {
                cleanup();
                return super.handleInitialState();

            } else if (XstDataActionKey.NO.equals(key)) {
                return redirectToCustomerEditScreen();

            } else if (XstDataActionKey.YES.equals(key)) {
                List<CawAddressLineType> addressLineTypes = getScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_LINES);
                if (addressLineTypes != null && addressLineTypes.size() > 0) {
                    IPartyLocaleInformation localInformationQAS = _addressHelper.adapt(addressLineTypes);
                    if (localInformationQAS != null) {
                        setScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO, localInformationQAS);
                        return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CAW_CUSTOMER_UPDATE_ADDRESS"));
                    }
                }
                return HELPER.completeResponse();

            } else if (XstDataActionKey.ACCEPT.equals(key)) {
                return redirectToCustomerEditScreen();

            } else if (CANCEL.equals(key) || ADDRESS_LOOKUP_CANCEL.equals(key)) {
                return redirectToCustomerEditScreen();

            } else if (XstDataActionKey.valueOf(CawConstants.QAS_OFFLINE).equals(key)) {
                return super.handleQASBypass(argAction, false);//BZ26742 modified
            }

        } catch (Exception ex) {
            _logger.error("handleDataAction-1:" + ex.getMessage());
        }
        return super.handleDataAction(argAction);
    }

    @Override
    protected String getAddressLineLabelTag() {

        if (this.getScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY) == null) {
            IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
            String countryAlpha2 = "";
            String customerInforStr = CawCatalystHelper.getLookupResponseData();
            countryAlpha2 = _addressHelper.getCountryCodeFromJson(customerInforStr);
            if (StringUtils.isEmpty(countryAlpha2) && party.getCountry() != null) {
                countryAlpha2 = party.getCountry();
            }
            this.setScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY, countryAlpha2);
        }

        return super.getAddressLineLabelTag();
    }

    /**
     * @return
     */
    private IOpResponse redirectToCustomerEditScreen() {

        clearScopedValue(CawValueKeys.IS_ADDRESS_MULTIPLE_DISPLAY);
        _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, Boolean.valueOf(true));

        return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION_EDIT"));
    }
}
