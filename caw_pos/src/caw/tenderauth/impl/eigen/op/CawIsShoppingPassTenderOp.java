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
 * BZ24105          191017    Should be distinguish Good Sam Visa card and Shopping Pass tender in DB
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawIsShoppingPassTenderOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        setScopedValue(CawValueKeys.IS_SHOPPING_PASS_TENDER, Boolean.TRUE);
        return HELPER.completeResponse();
    }

}
