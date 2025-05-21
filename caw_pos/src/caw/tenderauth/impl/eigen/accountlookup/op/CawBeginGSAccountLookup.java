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
 * BZ25762          121418      New Requirement - Credit Account Look up integration in Xstore
 * BZ29468          210219      [Internal] Invalid search data provided response received after swiping PLCC for Account Payment
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawBeginGSAccountLookup extends Operation {

    private CawCustomerGSHelper _gsHelper = CawCustomerGSHelper.getInstance();

    /* Check for customer is attached in transaction or not.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        /*BZ29468: Clear object before starting Account lookup or Account Payment*/
        _gsHelper.clearGSInfo();
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        if (trans == null || trans.getCustomerParty() == null) {
            return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION"));
        }

        return HELPER.completeResponse();
    }
}
