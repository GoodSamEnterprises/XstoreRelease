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
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.pos.agis.op;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.IUIController;

public class CawAGISPitchesReloadForms extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        IUIController con = _modeProvider.get().getUiController();
        con.removeNamedComponent(CawConstants.CAW_AGIS_PITCHES_FORM);
        _transactionScope.clearValue(CawValueKeys.CAW_AGIS_PICHES_COUNT);
        return HELPER.completeResponse();
    }

}
