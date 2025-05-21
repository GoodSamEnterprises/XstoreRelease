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
 * BZ58973          190923    Resumed loyalty transaction not prompting loyalty offers
 *===================================================================
 */

package caw.pos.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.customer.CawCustomerHelper;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.TransactionHelper;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.IPersistablesBag;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.crm.impl.PartyPropertyModel;

public class CawCustomerLoyaltyFlag extends Operation{  
    /* Start BZ58973 */
    private static final Logger _logger = LogManager.getLogger(CawCustomerHelper.class);
    IPersistablesBag bag = TransactionHelper.getPersistables();
    
    public void persistCustomerLoyaltyFlagFromDB(String lookupResponseEBS, IParty party) {
        try {
            if (StringUtils.isNotEmpty(CawCatalystHelper.getLookupLoyaltyResponseData())) {
                IPartyProperty isLoyaltyCustomerObj = null;
                boolean isLoyaltyCustomer = CawCheetahHelper.getInstance().checkIsLoyaltyCustomer(CawCatalystHelper.getLookupLoyaltyResponseData());
                if (isLoyaltyCustomer) {
                    _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
                    isLoyaltyCustomerObj = CawCheetahHelper.getInstance().addCustomerLoyaltyProperty(new JSONObject(lookupResponseEBS), party);
                    bag.addObject(isLoyaltyCustomerObj);
                    bag.persist();
                }
            }
        } catch (Exception ex) {
            _logger.error("Can not persist Customer Loyalty Flag to DB: " + ex.getMessage());
        }
    }
    
    public void getAndSetCustomerLoyaltyFlagFromDB(IParty iParty) {
        PartyPropertyId partyPropId = new PartyPropertyId();
        partyPropId.setOrganizationId(ConfigurationMgr.getOrganizationId());
        partyPropId.setPartyId(iParty.getPartyId());
        partyPropId.setPropertyCode("IS_LOYALTY_CUSTOMER");
        PartyPropertyModel partyPropModel = DataFactory.getObjectByIdNoThrow(partyPropId);
        if(partyPropModel != null && Boolean.parseBoolean(partyPropModel.getStringValue())) {
            _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
        } 
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        // @todo Auto-generated method stub
        return HELPER.completeResponse();
    }
    /* End BZ58973 */
}
