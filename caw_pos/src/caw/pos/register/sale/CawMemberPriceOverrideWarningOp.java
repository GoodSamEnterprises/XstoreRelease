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
 * BZ25115          180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 *===================================================================
 */

package caw.pos.register.sale;

import caw.pos.common.CawValueKeys;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawMemberPriceOverrideWarningOp extends AbstractPromptOp {

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_MEMBER_PRICE_OVERRIDE_WARNING");
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg) {

        if (_transactionScope
                .getValue(CawValueKeys.IS_APPLY_CLUB_PRICE) == null) {
            // Set flag marked that system will convert price from regular price to club price.
            _transactionScope
                    .setValue(CawValueKeys.IS_APPLY_CLUB_PRICE, Boolean.TRUE);
        } else {
            if (Boolean.TRUE == _transactionScope
                    .getValue(CawValueKeys.IS_APPLY_CLUB_PRICE)) {
                // Set flag marked that system will convert price from club price to regular price.
                _transactionScope
                        .setValue(CawValueKeys.IS_APPLY_CLUB_PRICE, Boolean.FALSE);
            } else {
                // Set flag marked that system will convert price from regular price to club price.
                _transactionScope
                        .setValue(CawValueKeys.IS_APPLY_CLUB_PRICE, Boolean.TRUE);
            }
        }

        return HELPER.completeResponse();
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractPromptOp#getPromptArgs(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];
        args[0] = _ff.getTranslatable("_cawMemberPriceOverrideTitleNotify");

        if (_transactionScope
                .getValue(CawValueKeys.IS_APPLY_CLUB_PRICE) == null) {
            args[1] = _ff.getTranslatable("_cawMemberClubPriceOverrideMsg");
        } else {
            if (Boolean.TRUE == _transactionScope
                    .getValue(CawValueKeys.IS_APPLY_CLUB_PRICE)) {
                args[1] = _ff
                        .getTranslatable("_cawMemberRegularPriceOverrideMsg");
            } else {
                args[1] = _ff.getTranslatable("_cawMemberClubPriceOverrideMsg");
            }
        }

        return args;
    }

}
