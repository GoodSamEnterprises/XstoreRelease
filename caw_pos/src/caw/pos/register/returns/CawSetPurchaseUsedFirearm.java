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
 * BZ23458          210917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 *===================================================================
 */

package caw.pos.register.returns;

import org.apache.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Set Purchase Used Firearm flag  is true so that mark this function is start.
 */
public class CawSetPurchaseUsedFirearm extends Operation {

    private static final Logger _logger = Logger
            .getLogger(CawSetPurchaseUsedFirearm.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        _transactionScope.setValue(CawValueKeys.IS_PURCHASE_USED_FIREARM, true);
        _logger.info("Start Purchase Used Firearm");
        return HELPER.completeResponse();
    }

}
