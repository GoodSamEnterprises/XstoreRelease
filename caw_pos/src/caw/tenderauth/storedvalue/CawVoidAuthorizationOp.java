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
 * 
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.tenderauth.storedvalue.VoidAuthorizationOp;

/**
 *
 */
public class CawVoidAuthorizationOp extends VoidAuthorizationOp {

    @Override
    protected IOpResponse handleManualAuthInfoResponse(IXstEvent argArgEvent) {

        clearScopedValue(ValueKeys.CURRENT_AUTH_REQUEST);
        return HELPER.completeResponse();
    }
}
