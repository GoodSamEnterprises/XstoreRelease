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

import caw.pos.agis.model.CawAGISPitchesLoadDataCustomerResponse;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawAGISPitchesLoadDataOp extends Operation {
    
    private CawAGISPitchesHelper    _gsmPitchesHelper   = CawAGISPitchesHelper.getInstance();
    
    @Override
    public boolean isOperationApplicable() {
        return _gsmPitchesHelper.isLoadDataPitchesForm(_transactionScope);
    }
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {
        CawAGISPitchesLoadDataCustomerResponse pitchesResponse = new CawAGISPitchesLoadDataCustomerResponse();
        
        if (_transactionScope != null) {
            CawAGISPitchesModel cawPitchesModel = pitchesResponse.loadDataFromCustomerLookupResponse(_transactionScope);   
            if (cawPitchesModel != null) {
                _transactionScope.setValue(CawValueKeys.CAW_AGIS_PICHES_MODEL, cawPitchesModel);
            }
        }

        return HELPER.completeResponse();
    }
}
