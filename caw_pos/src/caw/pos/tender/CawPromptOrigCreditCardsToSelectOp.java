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
 * BZ63225          230424    Issue with refunds from Work Order Completes
 *===================================================================
 */

package caw.pos.tender;

import java.util.Map;

import javax.inject.Inject;

import dtv.pos.common.TransactionType;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.tender.PromptOrigCreditCardsToSelectOp;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 *
 */
public class CawPromptOrigCreditCardsToSelectOp extends PromptOrigCreditCardsToSelectOp {

    @Inject
    private ReturnManager _returnMgr;
    @Inject
    private CawTenderHelper _cawTenderHelper;

    @Override
    protected Object[] getPromptList(IXstEvent argEvent) {
        Map<ICreditDebitTenderLineItem, ICreditDebitTenderLineItem> refMap = (Map)this._transactionScope.getValue(TransactionScopeKeys.ORIGINAL_CREDITCARD_MAPPING);
        return this._cawTenderHelper.getUsableTendersFromOriginalTransactions((IRetailTransaction)this._transactionScope.getTransaction(TransactionType.RETAIL_SALE), this._returnMgr.getAllOrigTransaction(), refMap).toArray();
    }
}
