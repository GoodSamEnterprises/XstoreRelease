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
 * BZ62710          210324    [Internal] - Last Chance Prompt should NOT display in WO Deposit and WO Refund transaction.
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 * BZ69537          021025    [Internal][AGIS Modification]- Last Chance Prompt not displayed when customer voids pre-selected offer and proceeds to completed.
 *===================================================================
 */

package caw.pos.agis.op;

import java.util.List;

import javax.inject.Inject;

import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;

public class CawAGISPitchesLastChanceConditions extends AbstractRunCondition{

    @Inject
    private TransactionScope _transactionScope;
    
    @Override
    protected boolean shouldRunImpl() {
        // BEGIN BZ62710,BZ69391,BZ69389,BZ69389
        if(CawWorkOrderOptionsOp.isDepositAction() || CawWorkOrderOptionsOp.isRefundAction()) {
            return false;
        }
        // END BZ62710
        List<CawAGISPitchesItemModel> itemIds = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
        
        if (itemIds != null && _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) !=null 
                && _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null) {
            for(CawAGISPitchesItemModel item : itemIds) {
                if(item.getItemCode().equals(CawConstants.CAW_MEMBERSHIP_OPTION_CODE) ) {
                    return true;
                }
            }
        }
        //BEGIN BZ69537
        if (itemIds != null && itemIds.isEmpty()) {
            return true;
        }
        
        //END BZ69391,BZ69389,BZ69389, BZ69537
        return false;
    }
}
