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
 * BZ24385          081117    "Join RA membership#" is not displayed under customer section on receipt after validation this membership successfully
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ24424          131117    "RA membership validation" prompt does not display for RA JOIN when you select "1-Year join (w/Auto Renew) - $69.95"
 * BZ24498          161117    Club price is not applied to transaction after selling GSC Join in EBS offline
 * BZ24910          201217    <Status description> membership just joined into club does not display under customer section on receipt.
 * BZ24601          221217    Price of customer is changed from RETL to CLUB unexpectedly when sending catalyst=1 request
 * BZ26471          050618    Club pricing doesn't show on top banner when doing Resume transaction has club/wholesale/Crew pricing
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process 
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.customer.*;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.data2.access.*;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.TransactionHelper;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.IPersistablesBag;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.StationState;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.*;
import dtv.xst.dao.crm.*;

/**
 *
 */
public class CawProcessSaveJoinGoodSamOp extends Operation {

    private static final Logger           _logger                         = LogManager
            .getLogger(CawProcessDirectivesAddItemOp.class);

    private CawAdvancePromptingHelper     _cawAdvancePromptingHelper      = CawAdvancePromptingHelper
            .getInstance();

    private static final String           ARG_PARTY_ID                    = "argPartyId";

    private static final String           ARG_CUST_ACCT_CARD_NBR          = "argCustAcctCardNbr";

    private static final String           ARG_ORGANIZATION_ID             = "argOrganizationId";

    private static final String           MEMBERSHIPS_ATTR                = "memberships";

    /* BZ26575 removed   
     * IQueryKey<CawCustomerLoyaltyQueryResult> CRM_CUSTOMER_LOYALTY_EBS_LOOKUP = new QueryKey<CawCustomerLoyaltyQueryResult>(
            "CRM_CUSTOMER_LOYALTY_EBS_LOOKUP",
            CawCustomerLoyaltyQueryResult.class);*/

    IQueryKey<CawCustomerCardQueryResult> CRM_CUSTOMER_CARD_MEMBER_LOOKUP = new QueryKey<CawCustomerCardQueryResult>(
            "CRM_CUSTOMER_CARD_MEMBER_LOOKUP",
            CawCustomerCardQueryResult.class);                                                                       // BZ24498

    private CawCustomerHelper             _customerHelper                 = CawCustomerHelper
            .getInstance();

    IPersistablesBag                      bag                             = TransactionHelper
            .getPersistables();
    private static final String           PRICING_ATTR                    = "pricing";                               //BZ26471

    @Override
    public boolean isOperationApplicable() {

        if (getScopedValue(CawValueKeys.ITEM_NON_PHYSICAL_GROUP) != null
                && getScopedValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP) != null) {//BZ24354
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        handleSaveCompletedValidate();
        return HELPER.completeResponse();
    }

    private void handleSaveCompletedValidate() {

        // Update group for customer if the customer join Good Sam Club
        IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        if (party == null) {
            party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        }

        CawMembershipActivityModel activityModel = getScopedValue(CawValueKeys.ITEM_NON_PHYSICAL_GROUP);//BZ24354
        if (activityModel != null && activityModel.getCustomerGroup() != null
                && activityModel.getCustomerGroup().length() > 0) {// BZ24424
            ICustomerAffiliation iCustomerAffiliation = _cawAdvancePromptingHelper
                    .joinCutomerToGoodSamClub(party, activityModel
                            .getCustomerGroup());//BZ24354

            List<ICustomerAffiliation> iCustomerAffiliaions = new ArrayList<ICustomerAffiliation>();
            iCustomerAffiliaions.add(iCustomerAffiliation);
            party.setCustomerGroups(iCustomerAffiliaions);

            setScopedValue(ValueKeys.SELECTED_CUSTOMER, party);
        }

        // Update loyalty for customer join Good Sam Club
        if (getScopedValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP) != null) {
            saveCatCustLoyaltyAcc(getScopedValue(CawValueKeys.RESPONSE_VALIDATE_MEMBERSHIP), party, _stationState);
        }
    }

    public void saveCatCustLoyaltyAcc(String lookupResponse, IParty iParty,
            StationState stationState) {

        ICustomerLoyaltyAccountProperty iCustomerLoyaltyAccountProperty1;
        try {
            if (lookupResponse != null && iParty != null) {
                JSONObject objectJson = new JSONObject(lookupResponse);
                if (!objectJson.isNull(MEMBERSHIPS_ATTR) && objectJson
                        .getJSONArray(MEMBERSHIPS_ATTR).length() > 0) {
                    JSONArray memberShips = objectJson
                            .getJSONArray(MEMBERSHIPS_ATTR);

                    _customerHelper
                            .removeMembeshipHistoryData(iParty, memberShips); // BZ24601

                    ICustomerAccount iCustomerAccount = null;
                    ICustomerLoyaltyCard customerLoyaltyCard = null;
                    ICustomerLoyaltyAccount loyaltyAccount = null;
                    ICustomerLoyaltyAccountProperty iCustomerLoyaltyAccountProperty = null;

                    IPartyIdCrossReferenceProperty referenceProperty = null;
                    for (int i = 0; i < memberShips.length(); i++) {
                        //CAT_CUST_ACCT
                        iCustomerAccount = _customerHelper
                                .createCustomerAccount(iParty, stationState, memberShips
                                        .getJSONObject(i));
                        bag.addObject(iCustomerAccount);

                        //CAT_CUST_ACCT_CARD
                        customerLoyaltyCard = _customerHelper
                                .createCatCustAcctCard(iParty, stationState, memberShips
                                        .getJSONObject(i));
                        bag.addObject(customerLoyaltyCard);

                        //CAT_CUST_LOYALTY_ACCT
                        loyaltyAccount = _customerHelper
                                .createCatCustLoyaltyAcct(objectJson, memberShips
                                        .getJSONObject(i));
                        loyaltyAccount.setAccountId(iCustomerAccount
                                .getCustAccountId());
                        bag.addObject(loyaltyAccount);

                        //Begin BZ24910
                        //CAT_CUST_LOYALTY_ACCT_P for statusDescription
                        iCustomerLoyaltyAccountProperty1 = _customerHelper
                                .createLoyaltyAccountPropertyStatusDes(memberShips
                                        .getJSONObject(i), loyaltyAccount);
                        iCustomerLoyaltyAccountProperty1
                                .setAccountId(iCustomerAccount
                                        .getCustAccountId());
                        bag.addObject(iCustomerLoyaltyAccountProperty1);
                        //End BZ24910

                        //CAT_CUST_LOYALTY_ACCT_P
                        iCustomerLoyaltyAccountProperty = _customerHelper
                                .createLoyaltyAccountProperty(memberShips
                                        .getJSONObject(i), loyaltyAccount);
                        iCustomerLoyaltyAccountProperty
                                .setAccountId(iCustomerAccount
                                        .getCustAccountId());
                        bag.addObject(iCustomerLoyaltyAccountProperty);

                        customerLoyaltyCard
                                .addCustomerLoyaltyAccount(loyaltyAccount);
                        if (checkExistLoyCard(iParty
                                .getLoyaltyCards(), customerLoyaltyCard)) {
                            iParty.getLoyaltyCards().add(customerLoyaltyCard);
                        }

                        // Begin BZ25434
                        referenceProperty = _customerHelper
                                .savePartyXRefPropertyMembershipAttr(iParty, memberShips);
                        if (referenceProperty != null) {
                            ((IDataModelImpl) referenceProperty).getDAO()
                                    .setObjectState(DaoState.INSERT_OR_UPDATE
                                            .intVal());
                            bag.addObject(referenceProperty);
                        }
                        // End BZ25434

                        _transactionScope
                                .setValue(ValueKeys.SELECTED_CUSTOMER, iParty);
                        setScopedValue(ValueKeys.SELECTED_CUSTOMER, iParty);
                        // Persist to database
                        bag.persist();
                    }
                }
                //Begin BZ26471
                if (!objectJson.isNull(PRICING_ATTR)) {
                    JSONObject pricing = (JSONObject) objectJson
                            .get(PRICING_ATTR);

                    IPartyIdCrossReferenceProperty referenceProperty = _customerHelper
                            .savePartyXRefPropertyPricingAttr(iParty, pricing);
                    if (referenceProperty != null) {
                        ((IDataModelImpl) referenceProperty).getDAO()
                                .setObjectState(DaoState.INSERT_OR_UPDATE
                                        .intVal());
                        bag.addObject(referenceProperty);
                    }
                    // Persist to database
                    bag.persist();
                }
                //End BZ26471
            }
        } catch (Exception ex) {
            _logger.debug("Membership validate have error." + ex.getMessage());
        }
    }

    /**
     * @param argLoyaltyCards
     * @param argCardNumber
     * @return
     */
    private boolean checkExistLoyCard(
            List<ICustomerLoyaltyCard> argLoyaltyCards,
            ICustomerLoyaltyCard argCard) {

        // Begin BZ24498
        IQueryResultList<CawCustomerCardQueryResult> customerLoyaltyCards = null;
        try {
            if (argCard != null) {
                Map<String, Object> params = new HashMap<>();
                params.put(ARG_ORGANIZATION_ID, argCard.getOrganizationId());
                params.put(ARG_CUST_ACCT_CARD_NBR, argCard.getCardNumber());
                params.put(ARG_PARTY_ID, argCard.getPartyId());

                customerLoyaltyCards = DataFactory
                        .getObjectByQueryNoThrow(CRM_CUSTOMER_CARD_MEMBER_LOOKUP, params);
            }
        } catch (Exception ex) {
            _logger.error("Can not get acct card: " + ex.getMessage());
        }

        if (customerLoyaltyCards != null && customerLoyaltyCards.size() > 0) {
            return false;
        }
        return true;
        // End BZ24498
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
}
