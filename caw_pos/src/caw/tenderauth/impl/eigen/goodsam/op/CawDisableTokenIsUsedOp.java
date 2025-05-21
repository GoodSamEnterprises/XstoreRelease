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
 * BZ58779          110923    [Internal][Loyalty] Xstore does not follow the existing process to enroll to GS membership when a free GS membership SKU is auto added. 
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;


import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawDisableTokenIsUsedOp extends Operation{
    private CawCustomerGSHelper _gsHelper        = CawCustomerGSHelper.getInstance();

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        Boolean cawDisableTokenIsUsed = _transactionScope.getValue(CawValueKeys.CAW_DISABLE_TOKEN_IS_USED);
        
        if(cawDisableTokenIsUsed != null && cawDisableTokenIsUsed) {
            _gsHelper.isTokenUsed(false);
        }
        return HELPER.completeResponse();
    }

}
