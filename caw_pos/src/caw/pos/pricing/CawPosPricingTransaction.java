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
 * BZ27342          011018    [New Requirement] An approach to apply promo to club members with certain status
 *===================================================================
 */

package caw.pos.pricing;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawConstants;

import dtv.pos.customer.loyalty.LoyaltyMgr;
import dtv.pos.pricing.PosPricingTransaction;
import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
import dtv.xst.dao.cat.ICustomerLoyaltyCard;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.prc.DealId;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * This class is extended from base to create new trigger for sub-group level.
 */
public class CawPosPricingTransaction extends PosPricingTransaction {

    @Inject
    private LoyaltyMgr _loyaltyMgr;
    
    /**
     * 
     */
    public CawPosPricingTransaction(IPosTransaction argTransaction) {

        super(argTransaction);
    }

    /**
     * New trigger format
     * @param argCustomerGroup
     * @param argSubIdGroup
     * @return
     */
    protected String customerSubGroupTrigger(String argCustomerGroup,
            String argSubIdGroup) {

        return CUSTOMER_GROUP_TRIGGER_KEY + ':' + argCustomerGroup + ':'
                + argSubIdGroup;
    }

    /* Add trigger with group and group:sublevel into transaction.
     * @see dtv.pos.pricing.PosPricingTransaction#addCustomer(dtv.xst.dao.crm.IParty)
     */
    @Override
    protected void addCustomer(IParty argCustomer) {

        Collection<String> groups = _loyaltyMgr.getEffectiveCustomerGroups();
        Collection<? extends DealId> deals = argCustomer.getTargetedDeals();
        List<ICustomerLoyaltyCard> loyaltyCards = null;
        List<ICustomerLoyaltyAccount> listLoyalty = null;

        if (groups != null && groups.size() > 0) {
            for (String customerGroup : groups) {
                //Keep base trigger
                addTrigger(customerGroupTrigger(customerGroup));
                loyaltyCards = argCustomer.getLoyaltyCards();

                if ((!customerGroup.equals(CawConstants.DEFAULT_CONSTANT))
                        && (loyaltyCards != null)
                        && (loyaltyCards.size() > 0)) {
                    for (ICustomerLoyaltyCard loyaltyCard : loyaltyCards) {
                        listLoyalty = loyaltyCard.getLoyaltyAccounts();

                        if ((listLoyalty != null) && (listLoyalty.size() > 0)) {
                            for (ICustomerLoyaltyAccount loyalty : listLoyalty) {
                                //New trigger for sub level group
                                addTrigger(customerSubGroupTrigger(customerGroup, loyalty
                                        .getLoyaltyProgramLevelId()));
                            }
                        }
                    }
                }
            }
        }

        if (deals != null && deals.size() > 0) {
            for (DealId targetedDealId : deals) {
                addTarget(targetedDealId.getDealId());
            }
        }
    }
}
