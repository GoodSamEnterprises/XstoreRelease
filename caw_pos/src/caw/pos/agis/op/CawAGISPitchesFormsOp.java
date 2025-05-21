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
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 *===================================================================
 */

package caw.pos.agis.op;

import java.util.*;
import java.util.stream.Collectors;

import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.pos.common.FormKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.util.IKeyedValue;

public class CawAGISPitchesFormsOp extends AbstractFormOp<CawAGISPitchesModel>{

    @Override
    public boolean isOperationApplicable() {
        int isEmpty = _transactionScope != null && _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null ? _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) : 0;
    
        return isEmpty > 0;
    }
    
    @Override
    protected CawAGISPitchesModel createModel() {
        return _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
    }

    @Override
    protected FormKey getFormKey() {
        return FormKey.valueOf(CawConstants.CAW_AGIS_PITCHES_FORM);
    }
    //BEGIN BZ69391,BZ69389,BZ69389
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {
        CawAGISPitchesModel model = (CawAGISPitchesModel) this.getModel();
        List<CawAGISPitchesItemModel> itemIds = new ArrayList<>();

        if (model.getPitchGroupName1() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup1());
        }
        if (model.getPitchGroupName2() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup2());
        }
        if (model.getPitchGroupName3() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup3());
        }
        if (model.getPitchGroupName4() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup4());
        }
        if (model.getPitchGroupName5() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup5());
        }
        if (model.getPitchGroupName6() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup6());
        }
        if (model.getPitchGroupName7() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup7());
        }
        if (model.getPitchGroupName8() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup8());
        }
        if (model.getPitchGroupName9() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup9());
        }
        if (model.getPitchGroupName10() != null) {
            itemIds.add((CawAGISPitchesItemModel) model.getComboBoxGroup10());
        }
        
        _transactionScope.setValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED, itemIds);
        return super.handleFormResponse(argEvent);
    }

    //END BZ69391,BZ69389,BZ69389
}
