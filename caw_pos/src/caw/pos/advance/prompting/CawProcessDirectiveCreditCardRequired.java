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
 * BZ23052          160917    Implement Advanced Prompting
 * BZ23982          131017    Registers are constantly frozen and required rebooting
 * BZ24173          241017    "Credit card is required" prompt is looping unexpectedly when backing from "Tender option" list
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ24326          021117    "Credit Card tender is required" prompt should be trigger after fee selected "Auto-renew" joining in GS RA added into sale screen
 * BZ24381          071117    "Credit card tender is required" prompt is trigger unexpectedly although completing tender by Manual Credit incase choosing "Auto-renew"
 * BZ24382          081117    No "Credit card is required" prompt displays when tendering these types: Third-party/check in case choosing "Auto-renew membership sold"
 * BZ45160          040821    [Internal] Can complete the transaction paid other tender types not credit card even though the transaction receives directive: 10 for credit card required
 * BZ45156          030821    [PROD] Update Miraserv auth request to include recurring payment indicator
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import twitter4j.*;

import dtv.data2.access.*;
import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * If CATALYST required Credit Card, xstore must be required tender by Credit Card.
 */
public class CawProcessDirectiveCreditCardRequired extends AbstractPromptOp {

    private static final String                    TEXT                              = "text";

    private static final Logger                    _logger                           = LogManager
            .getLogger(CawProcessDirectiveCreditCardRequired.class);

    private static final String                    ACCEPT                            = "ACCEPT";

    private static final String                    SALE_TENDER                       = "SALE_TENDER";

    private static final PromptKey                 CAW_CATALYST_CREDIT_CARD_REQUIRED = PromptKey
            .valueOf("CAW_CATALYST_CREDIT_CARD_REQUIRED");

    @Inject
    private TransactionScope                       _transaction;

    private Boolean                                isCallBack                        = Boolean.FALSE;

    //Begin BZ24381
    IQueryKey<CawCreditDebitCardTenderTypeResults> CAW_CREDIT_DEBIT_TENDER_TYPE      = new QueryKey<CawCreditDebitCardTenderTypeResults>(
            "CAW_CREDIT_DEBIT_TENDER_TYPE",
            CawCreditDebitCardTenderTypeResults.class);

    private static final String                    CAW_CREDIT_DEBIT_FIELD            = "argCredit";

    //End BZ24381
    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        _transactionScope.setValue(CawValueKeys.IS_DIRECTIVE_TEN, Boolean.FALSE);/*BZ45156*/
        try {
            if (CawCatalystHelper.getCatalystDirectiveResponse() != null
                    && CawCatalystHelper.getCatalystDirectiveResponse()
                            .length() > 0) {
                JSONObject directive = null;
                int length = CawCatalystHelper.getCatalystDirectiveResponse().length();
                for (int i = 0; i < length; i++) {
                    directive = CawCatalystHelper.getCatalystDirectiveResponse().getJSONObject(i);
                    if (directive != null) {
                        if (!directive.isNull(CawEBSConstant.TYPE_ATTR)
                                && directive.getInt(CawEBSConstant.TYPE_ATTR) == CawDirectiveType.CREDIT_CARD_REQUIRED
                                                .getType()) {
                            _transactionScope.setValue(CawValueKeys.IS_DIRECTIVE_TEN, Boolean.TRUE);/*BZ45156*/
                            isRun = Boolean.TRUE;
                            break;
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.debug("Cann not get item." + ex.getMessage());
        }

        return isRun;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        Boolean isExitsTenderCredit = Boolean.FALSE;

        if (argEvent instanceof IXstDataAction) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            if (ACCEPT.equals(key.toString())) {
                return HELPER
                        .getStartChainResponse(OpChainKey.valueOf(SALE_TENDER));
            }
        } else if (isCallBack) {
            return HELPER
                    .getStartChainResponse(OpChainKey.valueOf(SALE_TENDER));
        } else {
            IPosTransaction iPosTransaction = _transaction.getTransaction();
            if (iPosTransaction != null) {
                List<ITenderLineItem> tenderList = iPosTransaction
                        .getLineItems(ITenderLineItem.class);
                BigDecimal amount = new BigDecimal(0);
                if (tenderList != null && tenderList.size() > 0) {
                    for (ITenderLineItem iTenderLineItem : tenderList) {
                        //Begin BZ24382
                        //amount = amount.add(iTenderLineItem.getAmount());
                        boolean chkTenderTyp = false;/*BZ45160*/
                        if (iTenderLineItem.getVoid() != true) {
                            amount = amount.add(iTenderLineItem.getAmount());
                            /*BEGIN BZ45160*/
                            //just check tender type when the Tender Line Item not void
                            chkTenderTyp = getCreditCardTenderType(iTenderLineItem.getTenderId());
                            /*END BZ45160*/
                        }
                        //End BZ24382
                        //Begin BZ24381: chkTenderTyp is used to check whether the tender type exists in/belong credit card or not.
                        if (chkTenderTyp == true
                                && isExitsTenderCredit == Boolean.FALSE) {
                            /*if (iTenderLineItem.getTenderId().contains(CREDIT_CARD)
                                && isExitsTenderCredit == Boolean.FALSE) {*/
                            //End BZ24381
                            isExitsTenderCredit = Boolean.TRUE;
                        }
                    }
                    /*BEGIN BZ45160*/
                    //Set this variable is true if Transaction has existing a tender by Credit Card else is false.
                    _transactionScope.setValue(CawValueKeys.IS_REQUIRED_CREDIT_CARD, isExitsTenderCredit);
                    /*END BZ45160*/
                    if ((amount.equals(iPosTransaction.getTotal()) // for step lastest amount due when tender
                            && isExitsTenderCredit == Boolean.FALSE)
                            || (amount.compareTo(iPosTransaction.getTotal()) < 0 // for step tender doesn't existing Credit Card and remain amount.
                                    && isExitsTenderCredit == Boolean.FALSE)
                            || (amount.compareTo(iPosTransaction.getTotal()) > 0 // for step lastest amount due when tender
                                    && isExitsTenderCredit == Boolean.FALSE)) {/*BZ45160*/
                        amount = new BigDecimal(0);
                        isCallBack = Boolean.TRUE;
                        setScopedValue(CawValueKeys.IS_CALL_BACK, Boolean.TRUE);
                        return HELPER.getPromptResponse(CAW_CATALYST_CREDIT_CARD_REQUIRED, getPromptArgs(argEvent)); // BZ24326
                    }
                } else {
                    return HELPER.completeResponse();
                }

            }
        }
        return HELPER.completeResponse();
    }

    public CawProcessDirectiveCreditCardRequired() {

        super(true);
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
 
    @Override
    public PromptKey getDefaultPromptKey() {

        return CAW_CATALYST_CREDIT_CARD_REQUIRED; // BZ24326
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return null;
    }

    // Begin BZ24326
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getTranslatable("_catalystCreditCardRequiredTitle");
        String message = null;
        try {
            if (CawCatalystHelper.getCatalystMessageResponse() != null
                    && CawCatalystHelper.getCatalystMessageResponse()
                            .length() > 0) {
                JSONArray messageResponse = CawCatalystHelper
                        .getCatalystMessageResponse();
                JSONObject messageJson = null;
                for (int i = 0; i < messageResponse.length(); i++) {
                    messageJson = messageResponse.getJSONObject(i);
                    if (!messageJson.isNull(CawEBSConstant.TYPE_ATTR)
                            && messageJson
                                    .getInt(CawEBSConstant.TYPE_ATTR) == 0) {
                        message = messageJson.getString(TEXT);
                        if (message != null) {
                            args[1] = _ff
                                    .getSimpleFormattable(message, FormatterType.SIMPLE);
                        } else {
                            args[1] = _ff
                                    .getTranslatable("_catalystCreditCardRequiredMessage");
                        }
                    }
                }
            } else {
                args[1] = _ff
                        .getTranslatable("_catalystCreditCardRequiredMessage");
            }
        } catch (Exception ex) {
            _logger.error("Cannot get JSON object: " + ex.getMessage());
        }

        return args;
    }

    // End BZ24326
    //Begin BZ24381
    private boolean getCreditCardTenderType(String tenderTyp) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put(CAW_CREDIT_DEBIT_FIELD, "CREDIT_CARD");
        IQueryResultList<CawCreditDebitCardTenderTypeResults> results = DataFactory
                .getObjectByQueryNoThrow(CAW_CREDIT_DEBIT_TENDER_TYPE, params);
        if (results != null && results.size() > 0) {
            for (CawCreditDebitCardTenderTypeResults cardTenderTypeResults : results) {
                if (cardTenderTypeResults != null) {
                    if (tenderTyp.equalsIgnoreCase(cardTenderTypeResults
                            .getTnd_type())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //End BZ24381
}
