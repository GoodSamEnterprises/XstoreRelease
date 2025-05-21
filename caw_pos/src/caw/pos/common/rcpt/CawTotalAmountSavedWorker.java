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
 * BZ23607          031017    CWS Receipts Requires Printing of Regular and Club Pricing for Items
 * BZ24346          031117    Missing 'You saved ...' line in receipt when doing trans with item has change quantity
 * BZ24657          011217    "You could have saved..." receipts changes
 * BZ31522          250619    [Port BZ31010 to 5.0][Xstore] Deals are being calculated into "You have saved..." for Club Members
 * BZ40798          240221    Modification to member savings calculation
 * BZ48145          130121    IDS Service Payment and member savings total
 * BZ62222          060324    [Internal] - The Banner Save Story displays a negative number.
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyRoundingMode;
import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyScale;
import static dtv.xst.dao.trl.RetailPriceModifierReasonCode.values;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;

import caw.pos.advance.prompting.CawMembershipActivityHelper;
import caw.pos.register.rvpayment.CawRvPaymentHelper;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
import dtv.xst.dao.cat.ICustomerLoyaltyCard;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.prc.DealTriggerId;
import dtv.xst.dao.prc.IDealTrigger;
import dtv.xst.dao.trl.*;

/**
 * Calculates the total amount saved on a transaction.
 *
 */
public class CawTotalAmountSavedWorker implements Callable<BigDecimal> {
    
    private static final String             CUSTOMER_CLUB_GROUP_TRIGGER = "CUSTGROUP:CLUB";     /*BZ40798*/
    
    private static final Collection<String> _disqualifiedReasons = new HashSet<String>();

    static {
        /* Disqualify for consideration any line item's whose prices change for any reason other than the
         * application of a deal or discount of some kind. */
        for (RetailPriceModifierReasonCode reasonCode : values()) {
            if (!reasonCode.isDiscount()) {
                _disqualifiedReasons.add(reasonCode.getName());
            }
        }
    }

    private final IRetailTransaction _transaction;

    private BigDecimal               _youSavedAmount;

    /**
     * Instantiates a new total amount saved worker.
     *
     * @param argTransaction the transaction
     */
    public CawTotalAmountSavedWorker(IRetailTransaction argTransaction) {

        _transaction = argTransaction;
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal call() {

        if (_youSavedAmount == null) {
            BigDecimal totalDiscount = BigDecimal.ZERO;

            List<ISaleReturnLineItem> lineItems = _transaction
                    .getLineItems(ISaleReturnLineItem.class);

            if (lineItems != null) {
            	
                CawMembershipActivityHelper _membershipHelper = new CawMembershipActivityHelper(); //BZ62222
                for (ISaleReturnLineItem saleLineItem : lineItems) {
                    boolean isMembershipItem = _membershipHelper.getMembershipActivity(saleLineItem.getItemId()) != null; //BZ62222
                    if (saleLineItem.getReturn() || saleLineItem.getVoid()
                            || (saleLineItem.getRegularBasePrice()
                                    .compareTo(BigDecimal.ZERO) == 0)
                            || CawRvPaymentHelper.isRvPaymentSaleLineItem(saleLineItem)
                            || isMembershipItem) { // BZ24657, BZ48145, BZ62222
                        continue;
                    }
                    /*BEGIN BZ40798*/
                    // Check modify price
                    if (saleLineItem.getRetailPriceModifiers().size() > 0) {
                        for (IRetailPriceModifier modifier : saleLineItem
                                .getRetailPriceModifiers()) {
                            if (modifier.getVoid()
                                    || modifier.getDealId() == null
                                    || !isClubGroupDeal(modifier.getDealId())) {
                                continue;
                            }
                            BigDecimal addAmount = BigDecimal.ZERO;
                            if (modifier.getExtendedAmount() != null) {
                                /*Check if item have deal trigger is CUSTGROUP:CLUB*/
                                if (isClubGroupDeal(modifier.getDealId())) { //BZ40798
                                    addAmount = modifier.getExtendedAmount();
                                }
                            } else if (modifier.getAmount() != null) {
                                addAmount = modifier.getAmount();
                            }
                            totalDiscount = totalDiscount.add(addAmount
                                    .setScale(getLocalCurrencyScale(), getLocalCurrencyRoundingMode()));
                        }
                    }
                    /*END BZ40798*/
                    if (saleLineItem.getExtendedAmount() != null) {
                        BigDecimal addAmount = saleLineItem
                                .getRegularBasePrice()
                                .subtract(saleLineItem.getBaseUnitPrice())
                                .multiply(saleLineItem.getQuantity()); // BZ24346
                        totalDiscount = totalDiscount.add(addAmount
                                .setScale(getLocalCurrencyScale(), getLocalCurrencyRoundingMode()));
                    }
                }
            }
            totalDiscount = totalDiscount.setScale(getLocalCurrencyScale(), getLocalCurrencyRoundingMode()); //BZ40798
            _youSavedAmount = totalDiscount;
        }
        return _youSavedAmount;
    }
    /*BEGIN BZ40798*/
    /*
     * Check if item have deal trigger is CUSTGROUP:CLUB
     */
    public boolean isClubGroupDeal(String dealId) {
        
        DealTriggerId dealTriggerId = new DealTriggerId();
        dealTriggerId.setOrganizationId(ConfigurationMgr.getOrganizationId());
        dealTriggerId.setDealId(dealId);
        if (_transaction.getCustomerParty() != null) {
            IParty customer = _transaction.getCustomerParty();
            dealTriggerId.setTrigger(CUSTOMER_CLUB_GROUP_TRIGGER);
            IDealTrigger dealTrigger = DataFactory
                    .getObjectByIdNoThrow(dealTriggerId);
            if (dealTrigger != null) {
                return true;
            } 
            /*check has any level club group*/
            else if (customer.getLoyaltyCards() != null
                    && customer.getLoyaltyCards().size() > 0) {
                List<ICustomerLoyaltyCard> loyaltyCards = customer.getLoyaltyCards();
                List<ICustomerLoyaltyAccount> listLoyalty = null;
                for (ICustomerLoyaltyCard loyaltyCard : loyaltyCards) {
                    listLoyalty = loyaltyCard.getLoyaltyAccounts();
                    if ((listLoyalty != null) && (listLoyalty.size() > 0)) {
                        for (ICustomerLoyaltyAccount loyalty : listLoyalty) {
                            dealTriggerId
                                    .setTrigger(customerSubClubGroupTrigger(loyalty.getLoyaltyProgramLevelId()));
                            dealTrigger = DataFactory.getObjectByIdNoThrow(dealTriggerId);
                            if (dealTrigger != null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private String customerSubClubGroupTrigger(String argSubIdGroup) {
        return CUSTOMER_CLUB_GROUP_TRIGGER + ':' + argSubIdGroup;
    }
    /*END BZ40798*/
}
