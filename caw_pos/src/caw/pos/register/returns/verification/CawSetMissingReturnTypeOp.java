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
 * BZ24605          301117    'HDE' is displayed when doing return unverified transaction.
 *===================================================================
 */

package caw.pos.register.returns.verification;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnItemType;
import dtv.pos.spring.ValueKeys;

/**
 * Fix BZ24605: Add missing Return Item Type
 */
public class CawSetMissingReturnTypeOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        if (getScopedValue(ValueKeys.RETURN_ITEM_TYPE) == null) {
            setScopedValue(ValueKeys.RETURN_ITEM_TYPE, ReturnItemType.REGULAR_ITEM); // BZ24605
        }
        return HELPER.completeResponse();
    }

}
