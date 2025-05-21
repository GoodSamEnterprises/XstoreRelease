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
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import caw.tenderauth.impl.eigen.CawPinpadItemModelHelper;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * The class clear all element in Queue when the tender with Credit/Gift card. 
 */
public class CawClearPinpadItemModelQueueOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        CawPinpadItemModelHelper.getInstance()
                .clearAllElementToListNeedToSendMiraServ();

        return HELPER.completeResponse();
    }

}
