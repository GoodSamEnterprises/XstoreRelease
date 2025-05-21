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
 * BZ61159          260224    [New Requirement] - Xstore AGIS Replacement
 * BZ62219          060324    [Internal] - Xstore makes a call to Retrieve the Reward API when the customer is not a Loyalty member
 *===================================================================
 */

package caw.pos.agis.op;

import java.util.List;

import caw.pos.advance.prompting.CawAdvancePromptingHelper;
import caw.pos.advance.prompting.CawMembershipActivityModel;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.*;

/**
 *
 */
public class CawAGISProcessMembershipItemValidOp extends Operation{

    private CawAdvancePromptingHelper   _cawAdvancePromptingHelper = CawAdvancePromptingHelper
            .getInstance();

    @Override
    public boolean isOperationApplicable() {
        Boolean isRun = Boolean.FALSE;
        CawMembershipActivityModel cawMembershipActivityModel = getScopedValue(CawValueKeys.ITEM_NON_PHYSICAL_GROUP);
        if (cawMembershipActivityModel.isValidateMembershipID()) {
            isRun = Boolean.TRUE;
        }
        return isRun;
    }
    
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
       
        CawMembershipActivityModel cawMembershipActivityModel = getScopedValue(CawValueKeys.ITEM_NON_PHYSICAL_GROUP);
        if (cawMembershipActivityModel != null) {
            if (cawMembershipActivityModel.getCustomerGroup() != null
                    && cawMembershipActivityModel.getCustomerGroup()
                            .length() > 0) {
                IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
                if (party == null) {
                    party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
                }
                // Get customer group from database
                PartyId partyId = new PartyId();
                partyId.setPartyId(party.getPartyId());
                IParty iParty = DataFactory.getObjectByIdNoThrow(partyId);
                List<ICustomerAffiliation> currentCustomerGroups = iParty.getCustomerGroups();
                // Check and make persist club
                ICustomerAffiliation iCustomerAffiliation = _cawAdvancePromptingHelper
                        .joinCutomerToGoodSamClub(party, cawMembershipActivityModel
                                .getCustomerGroup());
                // Update global variables
                if(!currentCustomerGroups.contains(iCustomerAffiliation)) {
                    currentCustomerGroups.add(iCustomerAffiliation);
                }
                party.setCustomerGroups(currentCustomerGroups);
                setScopedValue(ValueKeys.SELECTED_CUSTOMER, party);
            }
        }
        //_transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true); //BZ62219

        return HELPER.completeResponse();
    } 
    
    
    

}
