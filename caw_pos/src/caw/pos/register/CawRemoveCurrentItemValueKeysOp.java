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
 * BZ24463          131117    'HDE' screen is displayed when pressing Sell Gift Card button on Sell-Non Merch screen
 *===================================================================
 */

package caw.pos.register;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;

/**
 * Fix BZ 24463
 */
public class CawRemoveCurrentItemValueKeysOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        clearScopedValue(ValueKeys.CURRENT_ITEM); // BZ24463
        return HELPER.completeResponse();
    }

}
