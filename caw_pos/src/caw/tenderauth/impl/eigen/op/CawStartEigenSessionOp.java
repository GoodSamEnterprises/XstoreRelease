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
 * BZ24937          120118    [Prod Support] Disable line item displaying on pinpad
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import javax.inject.Inject;

import caw.tenderauth.impl.eigen.CawEigenMgr;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawStartEigenSessionOp extends Operation {

    @Inject
    private CawEigenMgr _cawEigenMgr;

    /**
     * Start Eigen session whenever transaction begins
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        _cawEigenMgr.startSession();
        return HELPER.completeResponse();
    }

}
