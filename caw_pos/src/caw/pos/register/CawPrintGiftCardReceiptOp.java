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
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ33085          241019    [5.0 UAT] Void the gift card Tender line for a Sales transaction
 *===================================================================
 */

package caw.pos.register;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import caw.pos.common.CawValueKeys;
import caw.pos.tender.voucher.CawVoucherBalanceReloadActiveInfo;

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
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The class print the gift card receipt when transaction is complete.
 */
public class CawPrintGiftCardReceiptOp extends Operation {

    @Inject
    private IRcptBuilder   _rcptBuilder;

    private final IOpState PRINTING_END_RCPTS = new OpState(
            "PRINTING_END_RCPTS");

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /*BEGIN BZ33085*/
        List<CawVoucherBalanceReloadActiveInfo> balanceReloadActiveInfos = _transactionScope
                .getValue(CawValueKeys.VOUCHER_BALANCE_RELOAD_ACTIVE_INFO);
        IPosTransaction trans = _transactionScope.getTransaction();

        if (trans != null) {
            List<IRetailTransactionLineItem> listLineItems = trans.getLineItems(IRetailTransactionLineItem.class);
            if (CollectionUtils.isNotEmpty(listLineItems) && CollectionUtils.isNotEmpty(balanceReloadActiveInfos)) {

                for (IRetailTransactionLineItem listLineItem : listLineItems) {
                    if (!listLineItem.getVoid()) {

                        // Loop each gift card to get data, compare with line items which the data belong to and print receipt
                        for (CawVoucherBalanceReloadActiveInfo cawVoucherBalanceInfo : balanceReloadActiveInfos) {
                            IRcpt[] rcpts = this._rcptBuilder.getRcpts(cawVoucherBalanceInfo);

                            if (rcpts != null && rcpts.length > 0 && cawVoucherBalanceInfo
                                    .getLineSequence() == listLineItem.getRetailTransactionLineItemSequence()) {
                                this.setOpState(this.PRINTING_END_RCPTS);
                                this.setScopedValue(ValueKeys.CURRENT_RECEIPTS_STACK, new RcptStack(rcpts));
                                _transactionScope.getValue(CawValueKeys.VOUCHER_BALANCE_RELOAD_ACTIVE_INFO)
                                        .remove(cawVoucherBalanceInfo);
                                return this.HELPER.getWaitStackChainResponse(OpChainKey.valueOf("PRINT_ITEMS"));
                            }
                        }
                    }
                }
            }
        }
        /*END BZ33085*/

        return HELPER.completeResponse();
    }
}
