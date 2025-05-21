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
 * BZ23458          270917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 * BZ25068          220118    New Requirement to Process Web Order Returns
 *===================================================================
 */

package caw.pos.register.returns;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * If return purchase used firearm, override price.
 */
public class CawRouteReturnPriceOverrideOp extends Operation {

    @Override
    public boolean isOperationApplicable() {

        Boolean isPurchaseUsedFirearm = _transactionScope
                .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);

        if ((isPurchaseUsedFirearm != null) && (isPurchaseUsedFirearm)) {
            return true;
            // Begin BZ25068
        } else if (_transactionScope
                .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) == Boolean.TRUE) {
            return true;
            // End BZ25068
        } else {

            return false;
        }
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        return HELPER.getCompleteStackChainResponse(OpChainKey
                .valueOf("OVERRIDE_RETURN_PRICE"));
    }

}
