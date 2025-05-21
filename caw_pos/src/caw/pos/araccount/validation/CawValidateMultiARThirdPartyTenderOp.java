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
 * BZ29124          280119    Port 29051 to Release 3.0 - Update Xstore to allow only one PO tender per transaction
 *===================================================================
 */

package caw.pos.araccount.validation;

import caw.pos.araccount.CawCustomerUtil;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;

public class CawValidateMultiARThirdPartyTenderOp extends AbstractPromptOp {
    

    @Override
    public boolean isOperationApplicable() {
        
        IPosTransaction iPosTransaction = null;
        if(_transactionScope!=null)
        {
            iPosTransaction =  _transactionScope.getTransaction();
        }
        
        return CawCustomerUtil.isExistedARAccountOrThirdparty(iPosTransaction);
    }

    @Override
    public PromptKey getDefaultPromptKey() {
        return PromptKey.valueOf("CAW_PROMPT_NOT_ALOW_MULTI_TENDERS");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {
        return HELPER.getStartChainResponse(OpChainKey.valueOf("PRE_TENDERING"));
    }

}
