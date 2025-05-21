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

import java.util.ArrayList;
import java.util.List;

import caw.pos.common.*;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.action.IXstDataActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.voucher.VoucherBalanceInfo;
import dtv.util.IReceiptSource;

public class CawSaleDisplayBalanceOp extends CawDisplayBalanceOp {

    private IXstDataActionKey RELOAD                            = XstDataActionKey
            .valueOf("RELOAD");

    private OpChainKey        RELOAD_BALANCE_RECEIPTS           = OpChainKey
            .valueOf("CAW_PRINT_GIFT_CARD_RELOAD_BALANCE_RECEIPTS");

    private OpChainKey        CAW_BALANCE_TO_SALE_VOUCHER_START = OpChainKey
            .valueOf("CAW_BALANCE_TO_SALE_VOUCHER_START");

    private PromptKey         GIFT_CARD_BALANCE_RELOAD_PROMPT   = PromptKey
            .valueOf("GIFT_CARD_BALANCE_RECEIPT_WITH_RELOAD");

    @Override
    public boolean isOperationApplicable() {

        clearScopedValue(ValueKeys.CURRENT_AUTH_REQUEST);
        if (CawConstants.CARD_IN_ACTIVE
                .equalsIgnoreCase(getScopedValue(CawValueKeys.CARD_ACTIVE_STATUS))) {
            return false;
        }

        return true;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        if (_stationState.getSystemUser().getOperatorId() != 0) {
            return GIFT_CARD_BALANCE_RELOAD_PROMPT;
        }
        return super.getDefaultPromptKey();
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        clearScopedValue(ValueKeys.CURRENT_AUTH_REQUEST);
        VoucherBalanceInfo balanceInfo = this
                .getScopedValue(ValueKeys.VOUCHER_BALANCE_INFO);
        if (balanceInfo != null && argEvent instanceof IXstDataAction) {
            IXstDataAction iXstEvent = (IXstDataAction) argEvent;
            if (XstDataActionKey.YES == iXstEvent.getActionKey()) {
                /* When the user clicks the button print receipt. 
                 * The system will print the receipt 
                 * and keep the user at current screen.
                 */
                final List<IReceiptSource> rcptSrcList = new ArrayList<>();
                rcptSrcList.add(balanceInfo);
                setScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE, rcptSrcList);
                balanceInfo.setReceiptRequired(true);

                return HELPER
                        .getCompleteStackChainResponse(RELOAD_BALANCE_RECEIPTS);

            } else if (RELOAD == iXstEvent.getActionKey()) {
                if (CawVoucherValue.FROM_REG_OPTION
                        .equals(getScopedValue(CawValueKeys.BALANCE_INQUIRY_COME_FROM))) {
                    return HELPER
                            .getStartChainResponse(CAW_BALANCE_TO_SALE_VOUCHER_START);

                } else {
                    return HELPER.completeResponse();
                }
            }
        }

        return super.handlePromptResponse(argEvent);

    }

}
