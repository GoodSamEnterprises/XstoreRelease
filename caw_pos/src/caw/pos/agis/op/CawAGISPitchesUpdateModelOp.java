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
* BZ69391          060225    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
* BZ69389          060225    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
* BZ69390          060225    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
* BZ69537          110225    [Internal][AGIS Modification]- Last Chance Prompt not displayed when customer voids pre-selected offer and proceeds to completed
*===================================================================
*/
 
package caw.pos.agis.op;
 
import java.lang.reflect.Method;
import java.util.List;
 
import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.util.ICodeInterface;
import dtv.xst.dao.trl.ISaleReturnLineItem;
 
/**
*
*/
public class CawAGISPitchesUpdateModelOp extends Operation {
    
    private static final Logger _logger = LogManager.getLogger(CawAGISPitchesHelper.class);
 
    @Override
    public boolean isOperationApplicable() {    
        List<CawAGISPitchesItemModel> acceptedList = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
        return acceptedList != null && !acceptedList.isEmpty();
    }
 
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {
        ISaleReturnLineItem lineItem = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        if (lineItem == null) {
            return HELPER.completeResponse(); // Early return to avoid unnecessary execution
        }

        CawAGISPitchesModel formModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        List<CawAGISPitchesItemModel> acceptedList = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);

        // Prepare selectOptions once
        CawAGISPitchesItemModel selectOptions = new CawAGISPitchesItemModel();
        selectOptions.setItemCode(CawConstants.CAW_MEMBERSHIP_OPTION_CODE);
        selectOptions.setDescriptions(_formattables.getTranslatable(CawConstants.CAW_MEMBERSHIP_OPTION_DES).toString());

        // Replace matching item in the list
        if (acceptedList != null) {
            acceptedList.replaceAll(item -> item.getItemCode().equals(lineItem.getItemId()) ? selectOptions : item);
            _transactionScope.setValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED, acceptedList);
        }

        // Handle form model updates dynamically
        String itemId = lineItem.getItemId();
        try {
            for (int i = 1; i <= 10; i++) {
                Method getPitchGroupName = formModel.getClass().getMethod("getPitchGroupName" + i);
                Method getComboBoxGroup = formModel.getClass().getMethod("getComboBoxGroup" + i);
                Method setComboBoxGroup = formModel.getClass().getMethod("setComboBoxGroup" + i, ICodeInterface.class);

                String pitchGroupName = (String) getPitchGroupName.invoke(formModel);
                CawAGISPitchesItemModel comboBoxGroup = (CawAGISPitchesItemModel) getComboBoxGroup.invoke(formModel);

                if (pitchGroupName != null && comboBoxGroup != null && comboBoxGroup.getCode().equals(itemId)) {
                    setComboBoxGroup.invoke(formModel, selectOptions);
                    break; // Stop after finding the match
                }
            }
        } catch (Exception e) {
            _logger.error("Error updating formModel via reflection", e);
        }

        return HELPER.completeResponse();
    }

}