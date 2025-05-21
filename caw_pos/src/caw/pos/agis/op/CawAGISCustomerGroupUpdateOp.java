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
 * BZ62219          060324    [Internal] - Xstore makes a call to Retrieve the Reward API when the customer is not a Loyalty member
 *===================================================================
 */

package caw.pos.agis.op;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.advance.prompting.CawCustomerGroupType;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.CawValueKeys;
import caw.pos.register.sale.CawRevertMemberPriceOverrideOp;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.*;

/**
 *
 */
public class CawAGISCustomerGroupUpdateOp extends Operation{
     
    private static final Logger _logger = LogManager
            .getLogger(CawRevertMemberPriceOverrideOp.class);
    
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {
        IParty iParty = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        
        if(iParty == null) {
            iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        }
        
        if (iParty != null) {
            List<ICustomerAffiliation> customerGroups = iParty.getCustomerGroups();
            if (customerGroups != null) {
                try {
                    CustomerAffiliationId customerAffiliationId = new CustomerAffiliationId();
                    ICustomerAffiliation iNewCustomerAffiliation = DataFactory.createObject(customerAffiliationId, ICustomerAffiliation.class);
                    for (ICustomerAffiliation iCustomerAffiliation : customerGroups) {
                        if (CawCustomerGroupType.CLUB.getNewName().equals(iCustomerAffiliation.getCustomerGroupId())) {
                            iNewCustomerAffiliation = iCustomerAffiliation;
                            ((IDataModelImpl) iCustomerAffiliation).getDAO().setObjectState(DaoState.DELETED.intVal());
                            iCustomerAffiliation = DataFactory.makePersistent(iCustomerAffiliation);                           
                        }
                    }
                    // Refresh list group price of the customer in memory                  
                    if (customerGroups.size() > 0) {
                        ICustomerAffiliation customerGroup = null;
                        for (Iterator<ICustomerAffiliation> iterator = customerGroups.iterator(); iterator.hasNext();) {
                            customerGroup = iterator.next();
                            if (customerGroup.getCustomerGroupId() != null
                                    && iNewCustomerAffiliation.getCustomerGroupId() != null
                                    && customerGroup.getCustomerGroupId().equals(iNewCustomerAffiliation.getCustomerGroupId())) {
                                iterator.remove();
                            }
                        }
                        iParty.setCustomerGroups(customerGroups);
                        
                        boolean isClub = false;
                        for (ICustomerAffiliation iCustomerAffiliation : customerGroups) {
                            if (CawCustomerGroupType.CLUB.getNewName().equals(iCustomerAffiliation.getCustomerGroupId())) {
                                isClub = true;
                                break;
                            }
                        }
                        
                        //BEGIN BZ58770
                        boolean isLoyaltyCustomer = CawCheetahHelper.getInstance().checkIsLoyaltyCustomer(CawCatalystHelper.getLookupLoyaltyResponseData());
                        if(!isClub && !isLoyaltyCustomer) {
                            _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, false);
                        }
                        //END BZ58770
                    }
                    setScopedValue(ValueKeys.SELECTED_CUSTOMER, iParty);
                    _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, iParty);
                } catch (Exception ex) {
                    _logger.error("Can not the revert customer group after using function Member Price Override: "
                            + ex.getMessage());
                }

            }
        }
        //_transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true); //BZ62219
        
        return this.HELPER.completeResponse();
    }
}
