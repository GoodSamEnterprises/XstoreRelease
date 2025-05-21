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
 * BZ29683          080319     [INTERNAL] [4.0.1] Review/Evaluate $20 GSVS on the current build
 * BZ31568          250619     [Port BZ31110 to 5.0] [Prod] Xstore charged full WO total amount to the new approved PLCC
 *===================================================================
 */

package caw.pos.tender;

import java.math.BigDecimal;
import java.util.Currency;

import caw.pos.common.CawConstants;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.ui.config.DataFieldConfig;
import dtv.pos.framework.ui.config.PromptConfig;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.PromptTenderAmtOp;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * Void GS Deal after pressing BACK on AMOUNT BOX.
 */
public class CawCreditCardPromptTenderAmtOp extends PromptTenderAmtOp {

    private final IOpState PRESSING_BACK_STATE = new OpState("PRESSING_BACK_STATE");

    /* Reuse super class condition
     * @see dtv.pos.tender.PromptTenderAmtOp#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        return super.isOperationApplicable();
    }

    /* Default Prompt
     * @see dtv.pos.tender.PromptTenderAmtOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("TOKEN_ENTER_TENDER_AMOUNT");
    }

    /* BEGIN BZ31568*/
    /* Correct the cash suggestion
     * @see dtv.pos.tender.PromptTenderAmtOp#getPromptResponse(dtv.pos.iframework.event.IXstEvent, dtv.pos.common.PromptKey, dtv.i18n.IFormattable[])
     */
    @Override
    public IOpResponse getPromptResponse(IXstEvent argEvent, PromptKey argPromptKey, IFormattable[] argPromptArgs) {

        if (CawWorkOrderOptionsOp.isDepositAction()) {
            BigDecimal depositAmount = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);
            if (depositAmount == null) {
                depositAmount = BigDecimal.ZERO;
            }
            IPosTransaction iPosTransaction = _transactionScope.getTransaction();

            if (depositAmount.compareTo(iPosTransaction.getAmountDue()) < 0) {
                ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
                ITender tender = tenderLine.getTender();
                Currency currency = Currency.getInstance(tender.getCurrencyId());
                PromptConfig config = createPromptConfig();

                depositAmount = depositAmount
                        .setScale(currency.getDefaultFractionDigits(), ConfigurationMgr.getLocalCurrencyRoundingMode());
                config.setDataFieldConfig(new DataFieldConfig());
                config.getDataFieldConfig().setDefaultValue(depositAmount);
                return HELPER.getPromptResponse(argPromptKey, config, argPromptArgs);
            }
        }
        return super.getPromptResponse(argEvent, argPromptKey, argPromptArgs);
    }
    /* END BZ31568*/

    /* Handle pressing BACK
     * @see dtv.pos.framework.op.AbstractPromptOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        if (argArg0 != null) {
            IXstActionKey key = ((IXstAction) argArg0).getActionKey();
            if (CawConstants.PRESSING_BACK.equals(key)) {
                setOpState(PRESSING_BACK_STATE);
                return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CAW_VOID_GS_DEAL"), argArg0);
            }
        }
        if (getOpState() == PRESSING_BACK_STATE) {
            return HELPER.getBackupResponse();
        }
        return super.handleOpExec(argArg0);
    }
}
