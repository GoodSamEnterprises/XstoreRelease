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
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ24433          101117    Club price and Club Info is not applied into transaction properly after renew GSC membership successfully
 * BZ24424          131117    "RA membership validation" prompt does not display for RA JOIN when you select "1-Year join (w/Auto Renew) - $69.95"
 * BZ24443          131117    Should have a trigger for membership validation when passing 'GC Join membership number'
 * BZ24556          201117    [Payments][Build 1.1.3] Help Desk Error displays when you select Yes for Good Sam Prescreen
 * BZ24944          271217    Club Pricing information doesn't display on top banner when attached GS join for transaction in offline case
 * BZ25318          300118    Missing Club information on top banner when sale/return transaction in offlined case.
 * BZ25594          010318    HDE prompt displays when joining RA_JOIN after joining successfully GSC_JOIN
 * BZ25115          180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 * BZ25434          110518    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 * BZ25677          190318    [BZ25115] 'Member Price Override' is enable on Customer Option menu when assigned customer has Club pricing.
 * BZ26255          150518    [Internal] Xstore still stays on Notify prompt when pressing RETRY on re-new membership validation.
 * BZ26398          310518    Club pricing is displayed on top banner once adding RA join item for transaction in offline case.
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ27889          181018    [Internal]Can't join GSC membership in offline case when assigned a new customer into trans
 * BZ27967          011118    [Internal] GSC join membership screen is displayed without prompt text when entering item renew for trans
 * BZ28033          110518    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ32272          300719    [New Requirement] Leading Characters are not being dropped when adding GS membership
 * BZ33595          151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ34226          140220    [New Requirement] Add Warning beeps for any prompt requiring action
 * BZ44053          100621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 * BZ58779          070923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added.
 * BZ59283          091023    [PROD] - points not printing on receipts with new patch(7.0.30-0.120) deployed to prod
 *===================================================================
 */

package caw.pos.advance.prompting;

import static dtv.hardware.types.InputType.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.hardware.events.ItemScanEvent;
import dtv.hardware.events.TransactionScanEvent;
import dtv.hardware.types.InputType;
import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.util.crypto.EncString;
import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
import dtv.xst.dao.cat.ICustomerLoyaltyCard;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * Using this class to validate JOIN and RENEWAL membership item
 */
public class CawProcessMembershipItemValidOp extends AbstractPromptOp implements IXstEventObserver { // BZ33595

    /* BEGIN BZ33595 */
    private static final IXstEventType[] EVENTS = { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION , INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE }; //BZ34226

    @Override
    public IXstEventType[] getObservedEvents() {
        return EVENTS;
    }
    /* END BZ33595 */

    private static boolean               IS_BEEP_FLAG   = false;         //BZ34226

    private static final String         MEMBERSHIPS_TAG            = "memberships";

    private static final String         QUANTITY                   = "quantity";

    private static final String         ITEM_CODE                  = "itemCode";

    private static final int            ONE_ITEM                   = 1;

    // Begin BZ25434
    private static final String         CAN_PURCHASE_ATTR          = "canPurchase";

    private static final String         MESSAGE_ATTR               = "message";

    private static final String         CUSTOMER_ATTR              = "customer";

    private static final String         LOCATION_CODE              = "0001";

    /** The Constant PRICING_TAG. */
    public static final String          PRICING_TAG                = "pricing";

    /** The Constant MEMBERSHIP_TAG. */
    public static final String          MEMBERSHIP_TAG             = "membership";

    /** The Constant IDENTIFIER_TAG. */
    public static final String          IDENTIFIER_TAG             = "identifier";

    private static final String         ACCOUNT_NUMBER             = "accountNumber";

    @Inject
    private CawMembershipActivityHelper _cawMembershipActivityHelper;

    // End BZ25434 

    private CawAdvancePromptingHelper   _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    private static final Logger         _logger                    = LogManager
            .getLogger(CawProcessMembershipItemValidOp.class);

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        CawMembershipActivityModel cawMembershipActivityModel = getScopedValue(CawValueKeys.ITEM_NON_PHYSICAL_GROUP);
        if (cawMembershipActivityModel != null) {
            if (cawMembershipActivityModel.isValidateMembershipID()) {
                isRun = Boolean.TRUE;
            } else {
                // Begin BZ24433
                if (cawMembershipActivityModel.getCustomerGroup() != null
                        && cawMembershipActivityModel.getCustomerGroup()
                                .length() > 0) {
                    IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
                    if (party == null) {
                        party = _transactionScope
                                .getValue(ValueKeys.SELECTED_CUSTOMER);
                    }

                    ICustomerAffiliation iCustomerAffiliation = _cawAdvancePromptingHelper
                            .joinCutomerToGoodSamClub(party, cawMembershipActivityModel
                                    .getCustomerGroup());

                    List<ICustomerAffiliation> iCustomerAffiliaions = new ArrayList<ICustomerAffiliation>();
                    iCustomerAffiliaions.add(iCustomerAffiliation);
                    party.setCustomerGroups(iCustomerAffiliaions);

                    setScopedValue(ValueKeys.SELECTED_CUSTOMER, party);
                }
                //End BZ24433
            }
        }

        return isRun;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("ENTER_MEMBERSHIP_NUMBER");
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getTranslatable("_membershipInfo");
        args[1] = _ff.getTranslatable("_prompEnterMembershipId");

        CawMembershipActivityModel cawMembershipActivityModel = getScopedValue(CawValueKeys.ITEM_NON_PHYSICAL_GROUP);
        if (cawMembershipActivityModel != null) {
            if (cawMembershipActivityModel.getPromptTitle() != null) {
                args[0] = _ff.getSimpleFormattable(cawMembershipActivityModel
                        .getPromptTitle(), FormatterType.SIMPLE);
            }
            if (cawMembershipActivityModel.getPromptMessage() != null) {
                args[1] = _ff.getSimpleFormattable(cawMembershipActivityModel
                        .getPromptMessage(), FormatterType.SIMPLE);
            }
        }

        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg) {

        if (argArg != null && argArg.getData() != null) {
            /* BEGIN BZ33595 */
            String dataEntered = StringUtils.EMPTY;
            if (argArg instanceof ItemScanEvent) {
                ItemScanEvent event = (ItemScanEvent) argArg;
                dataEntered = CawCustomerUtil.trimGSMNumber(EncString.getSensitiveData(event.getInputData().getData()));
            } else {
                dataEntered = CawCustomerUtil.trimGSMNumber((String) argArg.getData());/* BZ32272 */
            }
            /* END BZ33595 */
            IPosTransaction trans = _transactionScope.getTransaction();
            String custLookupData = getLookupResponseData();//BZ26255

            if (StringUtils.isNotEmpty(custLookupData) //BZ24556
                    && getScopedValue(ValueKeys.CURRENT_ITEM) != null) {
                IItem item = getScopedValue(ValueKeys.CURRENT_ITEM);
                String itemId = item.getItemId();
                JSONObject itemJson = createItemJson(itemId);
                
                /* BEGIN BZ58779 */
                try {
                    JSONObject custLookup = new JSONObject(custLookupData);
                    Boolean isNewalGSMembershipSKU = _transactionScope.getValue(CawValueKeys.CAW_IS_NEWAL_GS_MEMBERSHIP_SKU);
                    if(isNewalGSMembershipSKU != null && isNewalGSMembershipSKU && custLookup.has(CawJSONConstant.JSON_MEMBERSHIPS)) {
                        custLookup.remove(CawJSONConstant.JSON_MEMBERSHIPS);
                        custLookup.put(CawJSONConstant.JSON_MEMBERSHIPS, JSONObject.NULL);
                        custLookupData = custLookup.toString();
                    }
                } catch (JSONException ex) {
                    _logger.error("Cannot get JSON Object:"
                            + ex.getMessage());
                }                 
                /* END BZ58779 */
                String requestMembershipValidate = _cawAdvancePromptingHelper
                        .getMembershipValidateTemplate(trans, custLookupData, itemJson, dataEntered);

                getResponseValidate(requestMembershipValidate, dataEntered);//BZ25434
            }
        }

        return this.HELPER.completeResponse();

    }

    /**
     * Send validate request and receive response
     */
    private void getResponseValidate(String requestMembershipValidate,
            String dataEntered) {

        if (requestMembershipValidate != null) {
            //BZ BZ26398 changed and BZ26575 changed
            // Begin BZ27889 check EBS online or offline
            ResponseEntity<String> membershipValidateResponse = null;
            if (CawUtilFunction.allowEBSConnection()) {
                membershipValidateResponse = CawEBSHelper.getInstance()
                        .sendMembershipValidateToEBS(requestMembershipValidate);
            }
            //End BZ27889
            if (membershipValidateResponse != null) {
                if (membershipValidateResponse
                        .getStatusCodeValue() == CawEBSHelper.RESPONSE_SUCCESS_CODE) {
                    try {
                        JSONObject bodyResponse = new JSONObject(
                                membershipValidateResponse.getBody());
                        if (!bodyResponse.isNull(CAN_PURCHASE_ATTR)) {
                            boolean canPurchase = bodyResponse
                                    .getBoolean(CAN_PURCHASE_ATTR);
                            if (canPurchase == Boolean.TRUE) {
                                clearScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG);
                                setScopedValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP, bodyResponse
                                        .getString(CUSTOMER_ATTR));
                                CawCatalystHelper
                                        .setLookupResponseData(bodyResponse
                                                .getString(CUSTOMER_ATTR));//BZ25434
                                _transactionScope
                                        .setValue(CawValueKeys.API_LOOKUP_RESPONSE, bodyResponse
                                                .getString(CUSTOMER_ATTR));//BZ25434
                                // BZ 25318
                                savePricingData(CawCatalystHelper
                                        .getLookupResponseData());
                                _transactionScope
                                        .clearValue(CawValueKeys.IS_APPLY_CLUB_PRICE); //BZ25677
                                // Begin BZ59283 - update flag to true when validate GSAM membership item
                                String memberId = CawCheetahHelper.getInstance().getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
                                if(memberId != null && !memberId.isEmpty()) {
                                    _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
                                }
                                // End BZ59283
                            } else {
                                //400 Error
                                if (!bodyResponse.isNull(MESSAGE_ATTR)) {
                                    setScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG, bodyResponse
                                            .getString(MESSAGE_ATTR));
                                }
                            }
                        }
                    } catch (Exception ex) {
                        _logger.error("Validate Membership Exception:"
                                + ex.getMessage());
                    }
                } else {
                    setScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG, getErrorMsg());
                }
            } else {
                // Begin BZ24424
                //Handle offline mode
                handleOfflineMode(dataEntered);
                // End BZ24424
            }
        } else {
            setScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG, getErrorMsg());
        }

    }

    /**
     * BZ 25318: save an PRICING record into CRM_PARTY_ID_XREF_P table
     * BZ 25594: update logic to overwrite existing Pricing data
     * @param argLookupResponseData
     */
    private void savePricingData(String argLookupResponseData) {

        IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);

        if (party != null && argLookupResponseData != null
                && argLookupResponseData.length() > 0) {
            insertOrUpdatePricingData(party, argLookupResponseData);
        }

    }

    /**
     * BZ 25594: update logic to overwrite existing Pricing data
     */
    private void insertOrUpdatePricingData(IParty party,
            String argLookupResponseData) {

        IPartyIdCrossReferenceProperty partyXRefP = DataFactory
                .createObject(IPartyIdCrossReferenceProperty.class);
        partyXRefP.setOrganizationId(party.getOrganizationId());
        partyXRefP.setPartyId(party.getPartyId());
        partyXRefP.setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);

        partyXRefP.setPropertyCode(CawEBSConstant.PRICING);
        partyXRefP.setType(CawEBSConstant.TRANSACTION_PROPERTIES_TYPE_STRING);
        partyXRefP.setStringValue(argLookupResponseData);

        try {
            DataFactory.makePersistent(partyXRefP);
        } catch (Exception ex) {
            _logger.error(ex.getMessage());
        }
    }

    /**
     * @param dataEntered
     */
    private void handleOfflineMode(String dataEntered) {
        _logger.info("When ESB offline, The customer join memberships will alway approve.");//BZ26398

        IParty iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);//BZ25434
        if (iParty != null) {//BZ25434
            CawMembershipActivityModel cawMembershipActivityModel = getScopedValue(CawValueKeys.ITEM_NON_PHYSICAL_GROUP);
            String customerInfo = getLookupResponseData();

            customerInfo = _cawAdvancePromptingHelper
                    .changeMembershipsAttrOffline(customerInfo, dataEntered, cawMembershipActivityModel);//BZ26398

            clearScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG);
            setScopedValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP, customerInfo);

            CawCatalystHelper.setLookupResponseData(customerInfo);
            _transactionScope
                    .setValue(CawValueKeys.API_LOOKUP_RESPONSE, customerInfo);//BZ25434
            savePricingData(customerInfo);
            _transactionScope.clearValue(CawValueKeys.IS_APPLY_CLUB_PRICE); //BZ25115
            // Begin BZ59283 - update flag to true when validate GSAM membership item
            String memberId = CawCheetahHelper.getInstance().getMembershipId(CawCatalystHelper.getLookupResponseData(), 1);
            if(memberId != null && !memberId.isEmpty()) {
                _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
            }
            // End BZ59283
        }
    }

    private String getErrorMsg() {

        return String.valueOf(_ff.getTranslatable("_activeMembershipDeclined"));

    }

    // Begin BZ24443
    @Override
    public IOpResponse runValidationCheck(IXstEvent argEvent,
            PromptKey argFailedPrompt) {
        /* BEGIN BZ33595 */
        String dataEntered = StringUtils.EMPTY;
        if (argEvent instanceof ItemScanEvent) {
            ItemScanEvent event = (ItemScanEvent) argEvent;
            dataEntered = EncString.getSensitiveData(event.getInputData().getData());
        } else if (argEvent instanceof TransactionScanEvent) {
            return HELPER.waitResponse();
        } else {
            dataEntered = (String) argEvent.getData();
        }
        /* END BZ33595 */
        IFormattable problemsMessage = null;
        if (dataEntered == null) {
            this.setOpState(this.ERROR_MESSAGE_PROMPT);
            problemsMessage = _formattables.getTranslatable("_entryIsRequired");
            return this.HELPER
                    .getPromptResponse(argFailedPrompt, new IFormattable[] { problemsMessage });
        } else {
            return super.runValidationCheck(argEvent, argFailedPrompt);
        }
    }

    // End BZ24443
    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }

    /**
     * Get customer info in transaction
     * @return
     */
    private String getLookupResponseData() {

        String lookupResponseDataResponse = CawCatalystHelper
                .getLookupResponseData();//BZ26255
        //Begin BZ24944
        if (lookupResponseDataResponse == null) {
            lookupResponseDataResponse = _transactionScope
                    .getValue(CawValueKeys.API_LOOKUP_RESPONSE);
        }

        if (lookupResponseDataResponse == null) {
            lookupResponseDataResponse = getScopedValue(CawValueKeys.API_LOOKUP_RESPONSE);//BZ26255
        }
        //End BZ24944

        return lookupResponseDataResponse;
    }

    private JSONObject createItemJson(String itemId) {

        JSONObject itemJson = new JSONObject();
        try {
            itemJson.put(ITEM_CODE, itemId);
            itemJson.put(QUANTITY, ONE_ITEM);
        } catch (JSONException ex) {
            _logger.error("Can not create Item json object" + ex.getMessage());
        }

        return itemJson;
    }

    // Begin BZ25434
    @Override
    protected IOpResponse handleInitialState(IXstEvent argArgEvent) {

        IItem item = getScopedValue(ValueKeys.CURRENT_ITEM);
        CawMembershipActivityModel memberActivityModel = _cawMembershipActivityHelper
                .getMembershipActivity(item.getItemId());
        /* BEGIN BZ34226 */
        if (argArgEvent != null && argArgEvent instanceof IXstAction) {
            IXstActionKey key = ((IXstAction) argArgEvent).getActionKey();
            if ("ACCEPT".equalsIgnoreCase(key.toString()) && IS_BEEP_FLAG) {
                IS_BEEP_FLAG = false;
                return HELPER.completeResponse();
            }
        }
        if (!(argArgEvent instanceof IXstAction) && IS_BEEP_FLAG) {
            CawHardwareHelper.getInstance().sendBeepScanner(CawHardwareHelper
                    .getInstance().getScanner(), CawHardwareHelper.getInstance()
                            .getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
            IS_BEEP_FLAG = true;
            return HELPER.waitResponse();
        }
        /* END BZ34226 */
        // BZ27967 Check renewal membership item
        else if (memberActivityModel != null) {
            if (memberActivityModel.isValidateMembershipID()
                    && !memberActivityModel.isPromptingMemberShipID()) {
                String customerResponse = getCustomerInfoLatest();
                String membershipId = getRenewalMembershipId(customerResponse, memberActivityModel);//BZ26255, BZ44053

                if (StringUtils.isNotEmpty(membershipId)) {
                    validateRenewalMembership(item
                            .getItemId(), membershipId, customerResponse);
                    return HELPER.completeResponse();
                } else {
                    /* BEGIN BZ34226 */
                    IS_BEEP_FLAG = true;
                    IFormattable msg = _ff
                            .getTranslatable("_cawMembershipIsEmptyMsg");
                    setScopedValue(CawValueKeys.MEMBERSHIP_IS_EMPTY, Boolean.TRUE);
                    setScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG, msg
                            .toString());
                    return HELPER.getPromptResponse(PromptKey
                            .valueOf("CAW_MEMBERSHIP_IS_EMPTY"), msg);
                    /* END BZ34226 */
                }
            }
        }
        return super.handleInitialState(argArgEvent);
    }

    private String getCustomerInfoLatest() {

        String customerResponse = getLookupResponseData();
        if (StringUtils.isNotEmpty(customerResponse)) {
            try {
                JSONObject customerObjJson = new JSONObject(customerResponse);
                if (!customerObjJson.isNull(ACCOUNT_NUMBER)) {
                    //BZ26575 changed with CawEBSHelper
                    /* BEGIN BZ28033 */
                    String lookupResponse = CawCatalystHelper.getLookupResponseData();
                    if (StringUtils.isEmpty(lookupResponse)) {
                        lookupResponse = CawEBSHelper.getInstance()
                                .lookupCustomerInEBS(customerObjJson.getString(ACCOUNT_NUMBER), LOCATION_CODE);
                        CawCatalystHelper.setLookupResponseData(lookupResponse);
                    }
                    /* END BZ28033 */
                    if (StringUtils.isNotEmpty(lookupResponse)) {//BZ26255
                        customerResponse = lookupResponse;
                    }
                }
            } catch (Exception ex) {
                _logger.error("Can not get membership ID from customer object."
                        + ex.getMessage());
            }
        }

        if (StringUtils.isNotEmpty(customerResponse)) {
            CawCatalystHelper.setLookupResponseData(customerResponse);
            _transactionScope
                    .setValue(CawValueKeys.API_LOOKUP_RESPONSE, customerResponse);
        }
        return customerResponse;
    }

    /**
     * Get membership Id of the current customer
     * @param customerResponse
     * @param membershipTypeDesc
     * @return
     */
    private String getRenewalMembershipId(String customerResponse,
            CawMembershipActivityModel membershipGroup) { // BZ44053

        String membershipId = null;
        if (StringUtils.isNotEmpty(customerResponse)) {
            try {
                JSONObject customerLookupJson = new JSONObject(
                        customerResponse);

                if (!customerLookupJson.isNull(MEMBERSHIPS_TAG)) {
                    JSONArray memberShips = customerLookupJson
                            .getJSONArray(MEMBERSHIPS_TAG);
                    if (memberShips != null && memberShips.length() > 0) {
                        int len = memberShips.length();
                        JSONObject membershipObj = null;
                        for (int j = 0; j < len; j++) {
                            membershipObj = memberShips.getJSONObject(j);

                            if (!membershipObj.isNull(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR)
                                    && !membershipObj.isNull(IDENTIFIER_TAG)) {//BZ26255, BZ44053
                                if (String
                                        .valueOf(membershipObj
                                                .get(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR))
                                        .equalsIgnoreCase(membershipGroup.getMembershipType())) {//BZ26255, BZ44053
                                    membershipId = membershipObj
                                            .getString(IDENTIFIER_TAG);
                                    break;
                                }
                            }
                        }
                    }
                }

                //Begin BZ26255
                // If membership is null, membership Id will got from database.
                IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
                if (membershipId == null && party != null) {
                    if (party.getLoyaltyCards() != null
                            && party.getLoyaltyCards().size() > 0) {
                        List<ICustomerLoyaltyCard> loyatyCards = party
                                .getLoyaltyCards();
                        for (ICustomerLoyaltyCard iCustomerLoyaltyCard : loyatyCards) {
                            // Get list card number in table CAT_CUST_LOYALTY_ACCT
                            if (iCustomerLoyaltyCard
                                    .getLoyaltyAccounts() != null
                                    && iCustomerLoyaltyCard.getLoyaltyAccounts()
                                            .size() > 0) {
                                for (ICustomerLoyaltyAccount loyaltyAccount : iCustomerLoyaltyCard
                                        .getLoyaltyAccounts()) {
                                    if (loyaltyAccount
                                            .getLoyaltyProgramId() != null
                                            && loyaltyAccount
                                                    .getLoyaltyProgramId()
                                                    .equalsIgnoreCase(membershipGroup.getMembershipType())) {// BZ44053
                                        membershipId = loyaltyAccount
                                                .getCardNumber();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                //End BZ26255
            } catch (Exception ex) {
                _logger.error("Can not get membership ID from customer object."
                        + ex.getMessage());
            }

        }

        return membershipId;
    }

    private void validateRenewalMembership(String itemId, String membershipId,
            String customerInfo) {

        String requestMembershipValidate = _cawAdvancePromptingHelper
                .getMembershipValidateTemplate(_transactionScope
                        .getTransaction(), customerInfo, createItemJson(itemId), membershipId);
        getResponseValidate(requestMembershipValidate, membershipId);
    }

}