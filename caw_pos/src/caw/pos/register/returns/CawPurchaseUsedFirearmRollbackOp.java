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
 * BZ23672          021017    No action when pressing 'Cancel' button on Purchases Used Firearm screen.
 *===================================================================
 */

package caw.pos.register.returns;

import org.apache.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Route to Sale Item Screen when press Cancel.
 */
public class CawPurchaseUsedFirearmRollbackOp extends Operation {

    private static final Logger _logger = Logger
            .getLogger(CawPurchaseUsedFirearmRollbackOp.class);

    @Override
    public boolean isOperationApplicable() {

        Boolean isPurchaseUsedFirearm = _transactionScope
                .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);

        if ((isPurchaseUsedFirearm != null) && (isPurchaseUsedFirearm)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        _logger.info("Purchase Used Firearm - Route to Sale Item Start srceen");
        return HELPER
                .getStartChainResponse(OpChainKey.valueOf("SALE_ITEM_START"));
    }

}
