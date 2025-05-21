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
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawValueKeys;
import caw.pos.common.CawVoucherValue;
import caw.tender.impl.mira.response.CawMiraResponse;

import dtv.hardware.posprinting.RcptStack;
import dtv.hardware.rcptbuilding.IRcpt;
import dtv.hardware.rcptbuilding.IRcptBuilder;
import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.ValueKeys;
import dtv.tenderauth.event.IAuthResponse;

/**
 *
 */
public class CawGiftCardInActiveOp extends Operation {

    private static final String ACTIVATION         = "Activation";

    private static final String ISSUE              = "Issue";

    private OpChainKey          SALE_ITEM_START    = OpChainKey
            .valueOf("SALE_ITEM_START");

    private final IOpState      PRINTING_END_RCPTS = new OpState(
            "PRINTING_END_RCPTS");

    @Inject
    private IRcptBuilder        _rcptBuilder;

    @Override
    public boolean isOperationApplicable() {

        String inquiryComeFlag = getScopedValue(CawValueKeys.BALANCE_INQUIRY_COME_FROM);
        if (CawVoucherValue.FROM_REG_OPTION.equals(inquiryComeFlag)) {
            return true;
        }

        return false;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IAuthResponse iAuthResponse = getScopedValue(CawValueKeys.MIRASERV_AUTH_RESPONSE);

        if (this.getOpState() == null
                || this.PRINTING_END_RCPTS != this.getOpState()) {
            if (iAuthResponse instanceof CawMiraResponse) {
                CawMiraResponse cawMiraResponse = (CawMiraResponse) iAuthResponse;
                String reciptContent = cawMiraResponse.getReceiptText();
                if (StringUtils.isNotEmpty(reciptContent)) {
                    reciptContent = reciptContent.replace(ISSUE, ACTIVATION);
                    cawMiraResponse.setReceiptText(reciptContent);
                }

                IRcpt[] rcpts = this._rcptBuilder.getRcpts(cawMiraResponse);
                if (rcpts != null && rcpts.length > 0) {
                    this.setOpState(this.PRINTING_END_RCPTS);
                    this.setScopedValue(ValueKeys.CURRENT_RECEIPTS_STACK, new RcptStack(
                            rcpts));
                    return this.HELPER.getWaitStackChainResponse(OpChainKey
                            .valueOf("PRINT_ITEMS"));
                }
            }
        }

        return HELPER.getStartChainResponse(SALE_ITEM_START);
    }

}
