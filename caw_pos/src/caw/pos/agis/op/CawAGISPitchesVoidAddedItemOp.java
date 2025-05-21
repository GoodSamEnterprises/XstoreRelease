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
 * BZ62148          020324    Appear strikethrough on the membership item when voiding.
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
import caw.pos.common.CawValueKeys;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

public class CawAGISPitchesVoidAddedItemOp extends Operation{

    @Override
    public boolean isOperationApplicable() {    
        //BEGIN BZ62148
        CawAGISPitchesModel cawPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        List<CawAGISPitchesItemModel> itemModels = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
        if(cawPitchesModel != null && itemModels.size() > 0 ) {
            return Boolean.TRUE;
        }         
        //END BZ62148
        return Boolean.FALSE;
    }
    
    //BEGIN BZ69391,BZ69389,BZ69389
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {
       //BEGIN BZ62148
        IPosTransaction trans = _transactionScope.getTransaction();
        
        CawAGISPitchesModel cawPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        
        List<CawAGISPitchesItemModel> itemModels = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
        
        List<ISaleReturnLineItem> lineItems = trans.getLineItems(ISaleReturnLineItem.class);
        
        
        List<CawAGISPitchesItemModel> pitchesItems =  new ArrayList<CawAGISPitchesItemModel>();
        
        if (cawPitchesModel.getPitchGroupName1() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup1());
        }
        if (cawPitchesModel.getPitchGroupName2() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup2());
        }
        if (cawPitchesModel.getPitchGroupName3() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup3());
        }
        if (cawPitchesModel.getPitchGroupName4() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup4());
        }
        if (cawPitchesModel.getPitchGroupName5() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup5());
        }
        if (cawPitchesModel.getPitchGroupName6() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup6());
        }
        if (cawPitchesModel.getPitchGroupName7() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup7());
        }
        if (cawPitchesModel.getPitchGroupName8() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup8());
        }
        if (cawPitchesModel.getPitchGroupName9() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup9());
        }
        if (cawPitchesModel.getPitchGroupName10() != null) {
            pitchesItems.addAll(cawPitchesModel.getPitchItemsGroup10());
        }

        
        Set<String> pitchesItemIds = pitchesItems.stream()
                .map(CawAGISPitchesItemModel::getItemCode) 
                .collect(Collectors.toSet());
        
        Set<String> acceptedItemIds = itemModels.stream()
                .map(CawAGISPitchesItemModel::getItemCode) 
                .collect(Collectors.toSet());
        
        List<ISaleReturnLineItem> filteredLineItems = lineItems.stream()
                .filter(lineItem -> pitchesItemIds.contains(lineItem.getItemId()) // Exists in cawPitchesModel
                        && !acceptedItemIds.contains(lineItem.getItemId())) // Not in itemModels
                .collect(Collectors.toList());
        
        filteredLineItems.forEach(item -> item.setVoid(true));
        
        //END BZ62148
        return HELPER.completeResponse();
    }
    //END BZ69391,BZ69389,BZ69389
}