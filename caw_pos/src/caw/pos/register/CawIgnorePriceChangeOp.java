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
 * BZ24257          061117    [UAT] Register allows the price to be changed - Need to configure this to be turned off - Price overrides are not allowed by CW
 *===================================================================
 */

package caw.pos.register;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * This op is used for ignoring CHANGE_ITEM_PRICE opchain. Besides, help to recovery base function easily.
 */
/* Begin BZ24257*/
public class CawIgnorePriceChangeOp extends Operation {

    /* 
     * Nothing to do on this op! 
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        return HELPER.completeResponse();
    }

}
/* End BZ24257*/
