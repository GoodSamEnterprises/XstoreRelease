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
 * PAYMENT          070917    Payment-Item Display
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import caw.tenderauth.impl.eigen.constants.CawModelKeys;

import dtv.pos.iframework.IModeController;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IStationModel;
import dtv.pos.register.InitializeFactoriesOp;

/**
 *
 */
public class CawInitializeFactoriesOp extends InitializeFactoriesOp {

    /* (non-Javadoc)
     * @see dtv.pos.register.InitializeFactoriesOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IModeController mode = _modeProvider.get();
        IStationModel stationModel = mode.getStationModel();
        // Initialize the CAW transaction model so that the event handler
        stationModel.getModel(CawModelKeys.CAW_CURRENT_TRANSACTION);
        return super.handleOpExec(argEvent);
    }

}
