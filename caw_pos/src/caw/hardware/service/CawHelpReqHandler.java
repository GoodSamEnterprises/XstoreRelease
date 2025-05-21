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
 * BZ24578          241117    F1 function key still works although Help/F1 button is removed out BO and Xstore
 *===================================================================
 */

package caw.hardware.service;

import javax.inject.Provider;

import dtv.pos.framework.op.req.HelpReqHandler;
import dtv.pos.iframework.IModeController;
import dtv.pos.iframework.event.IXstEventListener;
import dtv.pos.iframework.op.req.IOpRequest;

/**
 *
 */
public class CawHelpReqHandler extends HelpReqHandler {

    private static final String HELP = "HELP";

    public CawHelpReqHandler(Provider<IModeController> argModeProvider) {

        super(argModeProvider);
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.req.HelpReqHandler#handleRequest(dtv.pos.iframework.op.req.IOpRequest, dtv.pos.iframework.event.IXstEventListener, dtv.pos.iframework.IModeController)
     */
    @Override
    public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {

        if (argRequest != null && !HELP.equals(argRequest.getRequestType())) {
            super.handleRequest(argRequest, argListener, argModeController);
        }
    }

}
