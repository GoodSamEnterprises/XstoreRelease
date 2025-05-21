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
 * BZ62036          040324    [Task] - Suspend and Resume transaction.
 * BZ69536          100225    [AGIS Modification] - HDE occurs when resume transaction 
 *===================================================================
 */

package caw.pos.register.suspendresume;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import caw.pos.advance.prompting.CawAGISSavePricingMembershipGSOp;
import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.agis.op.CawAGISPitchesHelper;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import twitter4j.Logger;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.util.ICodeInterface;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
/**
 *
 */
public class CawAGISLoadPitchesFromSuspendOp extends Operation{
    // BEGIN BZ62036
    private CawAGISPitchesHelper    _gsmPitchesHelper   = CawAGISPitchesHelper.getInstance();
    private static final Logger logger_ = Logger.getLogger(CawAGISLoadPitchesFromSuspendOp.class);
    
    @Override
    public boolean isOperationApplicable() {    
        return !_gsmPitchesHelper.isLoadDataPitchesForm(_transactionScope);
    }
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) { 
        IPosTransaction suspended = getScopedValue(ValueKeys.SELECTED_SUSPENDED_TRANSACTION);
        List<ICustomerAffiliation> suspendedCusGroups = new ArrayList<ICustomerAffiliation>();
        List<IRetailTransactionLineItem> lineItems = suspended.getRetailTransactionLineItems();
        CawAGISPitchesModel cawPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        
        IParty iParty = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        if(iParty == null) {
            iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        }
        if (iParty != null) {
            suspendedCusGroups = iParty.getCustomerGroups();
            PartyId partyId = new PartyId();
            partyId.setPartyId(iParty.getPartyId());
            IParty party = DataFactory.getObjectByIdNoThrow(partyId);
            List<ICustomerAffiliation> currentGroups = party.getCustomerGroups();
            for(ICustomerAffiliation i : suspendedCusGroups) {
                if(!currentGroups.contains(i)) {
                    currentGroups.add(i);
                }
            }
            iParty.setCustomerGroups(currentGroups);
            setScopedValue(ValueKeys.SELECTED_CUSTOMER, iParty);
            _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, iParty);
        }
        //BEGIN BZ69536
        if (lineItems != null && lineItems.size() > 0) {
            for (IRetailTransactionLineItem lineItem : lineItems) {
                if (!(lineItem instanceof ISaleReturnLineItem)) {
                    continue;
                }

                ISaleReturnLineItem saleReturnLineItem = (ISaleReturnLineItem) lineItem;
                if (saleReturnLineItem.getItem() == null || saleReturnLineItem.getVoid()) {
                    continue;
                }

                String itemId = saleReturnLineItem.getItemId();
                updatePitchComboBox(itemId, cawPitchesModel);
            }
            _transactionScope.setValue(CawValueKeys.CAW_AGIS_PICHES_MODEL, cawPitchesModel);
        }
        return HELPER.completeResponse();
    }
    // END BZ62036
    private void updatePitchComboBox(String itemId, CawAGISPitchesModel cawPitchesModel) {
        for (int i = 1; i <= 10; i++) {
            try {
                // Get the pitch items group dynamically
                Method getPitchItemsMethod = CawAGISPitchesModel.class.getMethod("getPitchItemsGroup" + i);
                List<CawAGISPitchesItemModel> pitchItems = (List<CawAGISPitchesItemModel>) getPitchItemsMethod.invoke(cawPitchesModel);

                // Find and set the matching item
                for (CawAGISPitchesItemModel pitchItem : pitchItems) {
                    if (pitchItem.getItemCode().equals(itemId)) {
                        Method setComboBoxMethod = CawAGISPitchesModel.class.getMethod("setComboBoxGroup" + i, ICodeInterface.class);
                        setComboBoxMethod.invoke(cawPitchesModel, pitchItem);
                        break; // Stop after finding the first match
                    }
                }
            } catch (Exception e) {
                logger_.error(e.getStackTrace().toString()); // Handle or log the exception as needed
            }
        }
    }
    //END BZ69536
}
