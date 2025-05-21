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
 * BZ29383          190219    [Internal] GS Account Inquiry form on the PinPad does not go away after selecting Back/Esc.
 *===================================================================
 */

package caw.pos.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.tenderauth.impl.eigen.CawPinpadItemModelHelper;
import caw.tenderauth.impl.eigen.op.CawGSVisaTenderClearPinpadOp;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawRefreshPinpadScreenOp extends Operation {

    private static final Logger _logger = LogManager.getLogger(CawGSVisaTenderClearPinpadOp.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            CawPinpadItemModelHelper.handleRefreshPinPadScreen(true);
        } catch (Exception ex) {
            _logger.debug("The error happened when The Pinpad clear screen." + ex.getMessage());
        }

        return HELPER.completeResponse();
    }

}
