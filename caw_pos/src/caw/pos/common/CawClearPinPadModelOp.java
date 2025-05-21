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
 * BZ48120          170122    Pinpad shows Thank You message on top of line items after assigning customer during a sale transaction 
 *===================================================================
 */

package caw.pos.common;

import org.apache.log4j.Logger;

import caw.tenderauth.impl.eigen.model.CawTransactionListEditModel;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawClearPinPadModelOp extends Operation {

    private static final Logger logger_ = Logger.getLogger(CawClearPinPadModelOp.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {

        try {
            CawTransactionListEditModel._cawCurrentTransAmtModel.clear();
        } catch (Exception ex) {
            logger_.error("can't Clear PinPad Model " + ex);
        }
        return HELPER.completeResponse();
    }

}
