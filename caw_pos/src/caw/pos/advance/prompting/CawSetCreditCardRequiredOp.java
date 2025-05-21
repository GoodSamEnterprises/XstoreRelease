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
 * BZ24173          241017    "Credit card is required" prompt is looping unexpectedly when backing from "Tender option" list
 *===================================================================
 */

package caw.pos.advance.prompting;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 * If POS transaction have CreditDebit Tender Line Item, mark is existing. 
 */
public class CawSetCreditCardRequiredOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IPosTransaction tran = _transactionScope.getTransaction();
        for (IRetailTransactionLineItem retailLineItem : tran
                .getRetailTransactionLineItems()) {
            if (retailLineItem instanceof ICreditDebitTenderLineItem) {
                _transactionScope
                        .setValue(CawValueKeys.IS_REQUIRED_CREDIT_CARD, Boolean.TRUE);
                break;
            }
        }
        return HELPER.completeResponse();
    }

}
