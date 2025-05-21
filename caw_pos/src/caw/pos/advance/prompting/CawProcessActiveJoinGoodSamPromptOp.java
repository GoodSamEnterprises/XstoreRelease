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
 * BZ23958          251017    Xstore needs to prompt for membership # when customer joins 
 * BZ24219          011117    Club pricing is not applied for customer when assigning to sale screen from Dashboard
 * BZ24319          021117    Membership validation should not be applied for "Auto-renew" item from GS RS membership.
 * BZ24324          021117    Membership validation prompt should be distinguish when joining in GS club and GS RS (Roadside assistance)
 * BZ24349          021117    Should be removed out the trigger only inputting number for membership# when joining new club
 * BZ24326          021117    "Credit Card tender is required" prompt should be trigger after fee selected "Auto-renew" joining in GS RA added into sale screen
 * BZ24356          031117    [Advance Prompting] Xstore needs to return to Membership Info prompt after a failed membership validation response
 * BZ24295          071117    "Membership Validation" prompt displays again when pressing BACK to cancel validation GS RA at catalyst =4
 * BZ24385          081117    "Join RA membership#" is not displayed under customer section on receipt after validation this membership successfully
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ28855          271218    [Internal][Offline] Xstore is still made a call to CardService API also PE at Catalyst =4 although turning off Neuron connectivity via configuration
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.common.*;
import caw.pos.util.CawEBSHelper;
import twitter4j.*;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.scope.ValueKey;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawProcessActiveJoinGoodSamPromptOp extends AbstractPromptOp {

    private static final String          ITEM_CODE_ATTR             = "itemCode";

    private static final String          CUSTOMER_ATTR              = "customer";

    private static final String          CAN_PURCHASE_ATTR          = "canPurchase";

    private static final String          PROPERTIES_ATTR            = "properties";

    private static final String          ITEM_CODE                  = ITEM_CODE_ATTR;

    private static final Logger          _logger                    = LogManager
            .getLogger(CawProcessActiveJoinGoodSamPromptOp.class);

    private JSONArray                    directiveFileds            = new JSONArray();

    private CawAdvancePromptingHelper    _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    protected final IOpState             MEMBERSHIP_ACTIVE_DECLINED = new OpState(
            "MEMBERSHIP_ACTIVE_DECLINED");

    protected final IOpState             MEMBERSHIP_ACTIVE_APPROVED = new OpState(
            "MEMBERSHIP_ACTIVE_APPROVED");

    @Inject
    private IBusyState                   _busyState;

    private String                       validateResponse           = null;

    public static final ValueKey<String> ACCOUNT_NUMBER             = new ValueKey<String>(
            String.class, "ACCOUNT_NUMBER");

    private Integer                      active                     = 0;

    private static final String          MESSAGE_ATTR               = "message";               //BZ24317

    @Inject
    private CawMembershipActivityHelper  _cawMembershipActivityHelper;

    /* (non-Javadoc)
    * @see dtv.pos.framework.op.AbstractPromptOp#handleInitialState(dtv.pos.iframework.event.IXstEvent)
    */
    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {

        return super.handleInitialState(argEvent);
    }

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        try {
            if (CawCatalystHelper.getCatalystDirectiveResponse() != null
                    && CawCatalystHelper.getCatalystDirectiveResponse()
                            .length() > 0) {
                JSONObject directive = null;
                JSONArray directiveResponse = CawCatalystHelper
                        .getCatalystDirectiveResponse();
                for (int i = 0; i < directiveResponse.length(); i++) {
                    if (directiveResponse.getJSONObject(i) != null) {
                        directive = directiveResponse.getJSONObject(i);
                        if (!directive.isNull(CawEBSConstant.TYPE_ATTR)
                                && directive
                                        .getInt(CawEBSConstant.TYPE_ATTR) == CawDirectiveType.ADD_ITEM
                                                .getType()) {
                            directiveFileds
                                    .put(directiveResponse.getJSONObject(i));
                        }
                    }
                }

                if (directiveFileds != null && directiveFileds.length() > 0) {
                    int temp = 0;
                    // Begin BZ24356
                    if (getScopedValue(CawValueKeys.IS_RETRY_VALIDATE) != null
                            && getScopedValue(CawValueKeys.IS_RETRY_VALIDATE)
                            && getScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED) != null) {
                        temp = getScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED);
                    } else {
                        if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT) != null) {
                            if (directiveFileds.length()
                                    - getScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT) > 0) {
                                temp = directiveFileds.length()
                                        - getScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT);
                            }
                        }
                    }
                    // End BZ24356

                    JSONObject itemJson = directiveFileds.getJSONObject(temp)
                            .getJSONObject(PROPERTIES_ATTR);
                    String itmCode = itemJson.getString(ITEM_CODE_ATTR);
                    CawMembershipActivityModel model = _cawMembershipActivityHelper
                            .getMembershipActivity(itmCode);
                    if (model != null && model.isValidateMembershipID()) {
                        setScopedValue(CawValueKeys.MEMBERSHIP_ACTIVITY_MODEL, model);//BZ24324
                        isRun = Boolean.TRUE;
                    }
                    // Begin BZ24319
                    else {
                        clearScopedValue(CawValueKeys.MEMBERSHIP_ACTIVITY_MODEL);//BZ24324
                        clearScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED); //BZ24324
                        clearScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN);
                    }
                    // End BZ24319
                    // Begin BZ24326
                    if (model != null && model.isAutoRenew()) {//BZ24354
                        setScopedValue(CawValueKeys.IS_AUTO_RENEW, Boolean.TRUE);
                    }
                    // End BZ24326
                }
            }

        } catch (JSONException ex) {
            _logger.debug("Cann not get item." + ex.getMessage());
        }

        //Clear message
        clearScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG);//BZ24317

        return isRun;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg) {

        // Begin BZ24356
        if (getScopedValue(CawValueKeys.IS_RETRY_VALIDATE) != null
                && getScopedValue(CawValueKeys.IS_RETRY_VALIDATE)
                && getScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED) != null) {
            active = getScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED);
        } else {
            if (getScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT) == null) {
                active = 0;
            } else {
                if (directiveFileds.length()
                        - getScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT) > 0) {
                    active = directiveFileds.length()
                            - getScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT);
                } else {
                    active = 0;
                }
            }
        }
        // End BZ24356

        if (argArg != null && argArg.getData() != null) {
            String dataEntered = (String) argArg.getData();

            try {
                if (active <= directiveFileds.length()) {
                    JSONObject itemJson = directiveFileds.getJSONObject(active)
                            .getJSONObject(PROPERTIES_ATTR);

                    // handle send request to EBS
                    IPosTransaction trans = _transactionScope.getTransaction();
                    String custLookupData = getScopedValue(CawValueKeys.API_LOOKUP_RESPONSE);
                    if (custLookupData == null) {
                        custLookupData = _transactionScope
                                .getValue(CawValueKeys.API_LOOKUP_RESPONSE);
                    }
                    try {
                        itemJson = directiveFileds.getJSONObject(active)
                                .getJSONObject(PROPERTIES_ATTR);

                        String codeItem = itemJson.getString(ITEM_CODE);

                        String requestMembershipValidate = _cawAdvancePromptingHelper
                                .getMembershipValidateTemplate(trans, custLookupData, itemJson, dataEntered);
                        if (requestMembershipValidate != null) {
                            _busyState.start(CawConstants.BUSY_STATE_MSG);
                            //BZ BZ26398 changed and BZ26757
                            /* BEGIN BZ28855 */
                            ResponseEntity<String> membershipValidateResponse = null;

                            if (CawUtilFunction.allowEBSConnection()) {
                                membershipValidateResponse = CawEBSHelper.getInstance()
                                        .sendMembershipValidateToEBS(requestMembershipValidate);
                            }
                            /* END BZ28855 */

                            if (membershipValidateResponse != null) {
                                if (membershipValidateResponse
                                        .getStatusCodeValue() == CawEBSHelper.RESPONSE_SUCCESS_CODE) {
                                    //Begin BZ24317
                                    JSONObject bodyResponse = new JSONObject(
                                            membershipValidateResponse
                                                    .getBody());
                                    if (!bodyResponse
                                            .isNull(CAN_PURCHASE_ATTR)) {
                                        boolean canPurchase = bodyResponse
                                                .getBoolean(CAN_PURCHASE_ATTR);
                                        if (canPurchase == Boolean.TRUE) {
                                            validateResponse = bodyResponse
                                                    .getString(CUSTOMER_ATTR);
                                            setScopedValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP, validateResponse);
                                            setScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED, 1);
                                            // Begin BZ24356
                                            clearScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED);
                                            clearScopedValue(CawValueKeys.IS_RETRY_VALIDATE);
                                            checkItemValidateFailed(codeItem);
                                            // End BZ24356
                                            setScopedValue(CawValueKeys.IS_COMPLETED_VALIDATION, Boolean.TRUE); // BZ24385
                                        } else {
                                            if (!bodyResponse
                                                    .isNull(MESSAGE_ATTR)) {
                                                setScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG, bodyResponse
                                                        .getString(MESSAGE_ATTR));
                                            }
                                            setScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED, 0);
                                            // Begin BZ24356
                                            setScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED, active);
                                            addItemValidateFaild(codeItem);
                                            // End BZ24356
                                        }
                                    }
                                    //End BZ24317
                                } else {
                                    setScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED, 0);
                                    // Begin BZ24356
                                    setScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED, active);
                                    addItemValidateFaild(codeItem);
                                    // End BZ24356

                                }
                            } else {
                                setScopedValue(CawValueKeys.IS_MEMBERSHIP_ACTIVATED, 0);
                                // Begin BZ24356
                                setScopedValue(CawValueKeys.ACTIVE_CODE_ACTIVATED_FAILED, active);
                                addItemValidateFaild(codeItem);
                                // End BZ24356
                            }
                        }
                    } catch (JSONException ex) {
                        _logger.error("Cannot get JSON Object:"
                                + ex.getMessage());
                    }

                }

            } catch (Exception ex) {
                _logger.error("Cannot get JSON Object:" + ex.getMessage());
            }
        }

        active = active + 1;
        setScopedValue(CawValueKeys.IS_MEMBERSHIP_COUNT, active);

        if (active >= directiveFileds.length()) {
            setScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN, Boolean.FALSE);
        } else {
            setScopedValue(CawValueKeys.IS_MEMBERSHIP_RUN, Boolean.TRUE);
        }

        return HELPER.completeResponse();

    }

    // Begin BZ24356
    /**
     * @param itemId
     */
    private void addItemValidateFaild(String itemId) {

        if (itemId != null) {
            Set<String> itmValidateFaileSet = getScopedValue(CawValueKeys.MEMBERSHIP_ITEM_ID_FAILED);
            if (itmValidateFaileSet == null
                    || itmValidateFaileSet.size() == 0) {
                itmValidateFaileSet = new HashSet<String>();
            }
            itmValidateFaileSet.add(itemId);
            setScopedValue(CawValueKeys.MEMBERSHIP_ITEM_ID_FAILED, itmValidateFaileSet);
        }
    }

    /**
     * @param argCodeItem
     */
    private void checkItemValidateFailed(String codeItem) {

        if (codeItem != null) {
            Set<String> itmValidateFaileSet = getScopedValue(CawValueKeys.MEMBERSHIP_ITEM_ID_FAILED);
            if (itmValidateFaileSet != null && itmValidateFaileSet.size() > 0) {
                for (String itmCode : itmValidateFaileSet) {
                    if (codeItem.equals(itmCode)) {
                        itmValidateFaileSet.remove(codeItem);
                    }
                }
            }
            setScopedValue(CawValueKeys.MEMBERSHIP_ITEM_ID_FAILED, itmValidateFaileSet);
        }
    }
    // End BZ24356

    @Override
    public IOpResponse runValidationCheck(IXstEvent argEvent,
            PromptKey argFailedPrompt) {

        String dataEntered = (String) argEvent.getData();
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

    @Override
    protected PromptKey getErrorPromptKey() {

        return PromptKey.valueOf("VALIDATION_ERROR_MESSAGE");
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("ENTER_MEMBERSHIP_NUMBER");
    }

    // Begin BZ24324
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getTranslatable("_membershipInfo");
        args[1] = _ff.getTranslatable("_prompEnterMembershipId");

        if (getScopedValue(CawValueKeys.MEMBERSHIP_ACTIVITY_MODEL) != null) {
            CawMembershipActivityModel activityModel = getScopedValue(CawValueKeys.MEMBERSHIP_ACTIVITY_MODEL);
            if (activityModel.getPromptTitle() != null) {
                args[0] = _ff.getSimpleFormattable(activityModel
                        .getPromptTitle(), FormatterType.SIMPLE);
            }
            if (activityModel.getPromptMessage() != null) {
                args[1] = _ff.getSimpleFormattable(activityModel
                        .getPromptMessage(), FormatterType.SIMPLE);
            }
        }

        return args;
    }
    // End BZ24324

    public String formatParameter(String argString) {

        return argString != null ? '"' + argString + '"' : "null"; //BZ23721
    }

    // Begin BZ24295
    @Override
    public boolean canceling() {

        CawCatalystHelper.setCatalystDirectiveResponse(null);
        return super.canceling();
    }
    // End BZ24295

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
}
