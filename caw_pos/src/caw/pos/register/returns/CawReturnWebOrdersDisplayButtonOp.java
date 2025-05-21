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
 * BZ25207          240118    Return Tender Options displays incorrectly tender types when refunding Web Order items.
 *===================================================================
 */

package caw.pos.register.returns;

import org.apache.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawReturnWebOrdersDisplayButtonOp extends Operation {

    private static final Logger _logger = Logger
            .getLogger(CawReturnWebOrdersDisplayButtonOp.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        _transactionScope.setValue(CawValueKeys.IS_SALE_SCREEN, true);
        _logger.info("Start screen");
        return HELPER.completeResponse();
    }

}
