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
* BZ61159          050324    [New Requirement] - Xstore AGIS Replacement
* BZ62263          050324    [Internal] The verbiage on the Banner Save Story, Banner Customer and LOGO does NOT change when changing the offer from GS Customer Club to NOT GS Customer
* BZ62036          190324    [Task] - Suspend and Resume transaction.
* BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
* BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
* BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
*===================================================================
*/
 
package caw.pos.agis.op;
 
import java.util.List;
 
import javax.inject.Inject;
 
import caw.pos.advance.prompting.CawCustomerGroupType;
import caw.pos.advance.prompting.CawMembershipActivityHelper;
import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trn.IPosTransaction;
 
/**
*
*/
public class CawAGISVoidItemUpdateRunCondition extends AbstractRunCondition {
    private String RETAIL_ID = "3";
    @Inject
    protected TransactionScope _transactionScope;
    @Inject
    private CawMembershipActivityHelper _membershipHelper;
    @Override
    protected boolean shouldRunImpl() {
        if(_transactionScope.getValue(CawValueKeys.CAW_AGIS_PRICING_ID) != null && !_transactionScope.getValue(CawValueKeys.CAW_AGIS_PRICING_ID).equals(RETAIL_ID)) {
            return false;
        }
        boolean isAlow = true;
        if (_transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) !=null
                    && _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null) {
            List<CawAGISPitchesItemModel> cawAGISPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
 
            if(cawAGISPitchesModel != null && !cawAGISPitchesModel.isEmpty()) {
                for (CawAGISPitchesItemModel cawAGISPitchesItemModel : cawAGISPitchesModel) {
                    if(cawAGISPitchesItemModel.getItemCode().equals(CawConstants.CAW_MEMBERSHIP_OPTION_CODE)||
                            cawAGISPitchesItemModel.getItemCode().equals(CawConstants.CAW_NOTHANKS_OPTION_CODE) ) {
                        continue;
                    }
                    if(isGoodSamItem(cawAGISPitchesItemModel.getItemCode())) {
                        isAlow = false;
                        break;
                    }
                }
            }
        }
        // BEGIN BZ62036
        IPosTransaction suspended = getScopedValue(ValueKeys.SELECTED_SUSPENDED_TRANSACTION);
        if(suspended != null) {
            if (!isAlow) {
                return false;
            }
        }
        // END BZ62036
        return isAlow;
    }
    private boolean isGoodSamItem(String itemId) {
 
        if (_membershipHelper.getMembershipActivity(itemId) != null && CawCustomerGroupType.CLUB.getNewName().equals(_membershipHelper.getMembershipActivity(itemId).getCustomerGroup())) {
            return true;
        } else {
            return false;
        }
    }
}