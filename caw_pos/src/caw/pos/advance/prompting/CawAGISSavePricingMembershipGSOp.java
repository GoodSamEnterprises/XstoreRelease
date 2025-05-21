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
 *===================================================================
 */

package caw.pos.advance.prompting;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawJSONUtils;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.trn.IPosTransactionProperty;

/**
 *
 */
public class CawAGISSavePricingMembershipGSOp extends Operation {
    // BEGIN BZ62036
    private String STRING_TYPE = "STRING";
    
    private String MEMBERSHIP_KEY = "memberships";
    
    private String PRICING_KEY = "pricing";
    
    @Inject
    protected TransactionScope _transactionScope;
    
    private static final Logger logger_                = Logger
            .getLogger(CawAGISSavePricingMembershipGSOp.class);


    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        handleSaveCompletedValidate();
        return HELPER.completeResponse();
    }

    private void handleSaveCompletedValidate() {        
        String customerInfo = CawCatalystHelper.getLookupResponseData();
        
        JSONObject info = CawJSONUtils.toJSONObject(customerInfo);
        try {
            String pricingInfo = info.getString(PRICING_KEY);
            String membershipInfo = info.getString(MEMBERSHIP_KEY);
            IPosTransaction trans = _transactionScope.getTransaction();
            IPosTransactionProperty transactionProperty = DataFactory.createObject(IPosTransactionProperty.class);
            transactionProperty.setOrganizationId(trans.getOrganizationId());
            transactionProperty.setRetailLocationId(trans.getRetailLocationId());
            transactionProperty.setTransactionSequence(trans.getTransactionSequence());
            transactionProperty.setBusinessDate(trans.getBusinessDate());
            transactionProperty.setWorkstationId(trans.getWorkstationId());
            transactionProperty.setPropertyCode(CawConstants.CAW_PRICING_INFO);
            transactionProperty.setType(STRING_TYPE);
            transactionProperty.setStringValue(pricingInfo);
            
            DataFactory.makePersistent(transactionProperty);  
            IPosTransactionProperty transactionProperty2 = DataFactory.createObject(IPosTransactionProperty.class);
            transactionProperty2.setOrganizationId(trans.getOrganizationId());
            transactionProperty2.setRetailLocationId(trans.getRetailLocationId());
            transactionProperty2.setTransactionSequence(trans.getTransactionSequence());
            transactionProperty2.setBusinessDate(trans.getBusinessDate());
            transactionProperty2.setWorkstationId(trans.getWorkstationId());
            transactionProperty2.setPropertyCode(CawConstants.CAW_MEMBERSHIP_INFO);
            transactionProperty2.setType(STRING_TYPE);
            transactionProperty2.setStringValue(membershipInfo);
            DataFactory.makePersistent(transactionProperty2);
        } catch (Exception ex) {
            logger_.error("getPricingInformation: There is no membership from EBS response."
                    + ex.getMessage());
        }
    }
    // END BZ62036
}