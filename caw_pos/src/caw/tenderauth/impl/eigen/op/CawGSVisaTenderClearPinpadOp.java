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
 * BZ26395          211118    Items and buttons are overload on PIN PAD when doing void line New Good Sam Visa tender.
 * BZ28561          131218    [PINPAD] Items is overwriting on Gander Outdoor idle screen
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.CawPinpadItemModelHelper;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawGSVisaTenderClearPinpadOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawGSVisaTenderClearPinpadOp.class);

    @Inject
    private CawEigenMgr         _cawEigenMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            // Clear element in Queue
            CawPinpadItemModelHelper.getInstance()
                    .clearAllElementToListNeedToSendMiraServ();
            // Start session to clear Pinpad screen
            _cawEigenMgr.startSessionToClearPinpadScreen(); /*BZ28561*/
        } catch (Exception ex) {
            _logger.debug("The error happened when The Pinpad clear screen."
                    + ex.getMessage());
        }

        return HELPER.completeResponse();
    }

}
