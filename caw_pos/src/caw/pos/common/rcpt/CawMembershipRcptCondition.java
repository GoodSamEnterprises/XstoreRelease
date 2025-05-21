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
 * BZ23949          161017    Receipt Changes Required
 * BZ24076          191017    Redundant membership info on receipt after removing customer
 * BZ24121          201017    Missing information of membership in customer receipt when performing return transaction
 * BZ23958          251017    Xstore needs to prompt for membership # when customer joins
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ24421          101117    Receipt Displays "None" for level if Customer does not have a Level
 * BZ24429          101117    Receipt Change - Please Add Expiration Date to Receipt
 * BZ24651          061217    Membership info under Customer section should be displayed <status> instead of <benefit name>
 * BZ25434          210517    New Requirement - Extend Membership Validation Calls to Include Renewal Items
 * BZ26467          060618    [Internal] Membership info does not print enough info on receipt when attaching the customer just created into transaction incase offline status
 * BZ44053          100621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.*;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatCustLoyalAcctPResults;
import caw.pos.common.*;
import twitter4j.*;

import dtv.data2.access.*;
import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.scope.TransactionScope;
import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
import dtv.xst.dao.cat.ICustomerLoyaltyCard;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawMembershipRcptCondition extends AbstractInvertableCondition {

    private static final Logger            _logger                     = LogManager
            .getLogger(CawMembershipRcptCondition.class);

    private static final String            MEMBERSHIPS                 = "MEMBERSHIPS";

    private static final String            EBS_TEXT                    = "EBS";

    private static final String            JSON_MEMBERSHIPS            = "memberships";

    private static final String            IDENTIFIER                  = "identifier";

    private static final String            EXPIRE_DATE                 = "expireDate";

    @Inject
    private Provider<TransactionScope>     _transactionScope;

    //Begin BZ24651
    private static String                  statusDescription           = "";

    IQueryKey<CawCatCustLoyalAcctPResults> CAW_CAT_CUST_LOYALTY_ACCT_P = new QueryKey<CawCatCustLoyalAcctPResults>(
            "CAW_CAT_CUST_LOYALTY_ACCT_P", CawCatCustLoyalAcctPResults.class);

    private static final String            argCardNbr_FIELD            = "argCardNbr";

    private static final String            argCustAcct_FIELD           = "argCustAcct";

    //End BZ24651
    /**
     * Checking the condition to show/hide the customer's memberships
     *
     * @return true if the condition is met, else return false
     */
    @Override
    protected boolean conditionMetImpl(Object argSoure) {

        if (argSoure instanceof IRetailTransaction) {
            IRetailTransaction trans = (IRetailTransaction) argSoure;
            ICustomerLoyaltyCard loyaltyCard = trans.getLoyaltyCardObject();
            if (loyaltyCard == null) {
                loyaltyCard = DataFactory
                        .createObject(ICustomerLoyaltyCard.class);
                loyaltyCard.setOrganizationId(ConfigurationMgr
                        .getOrganizationId());
            }
            if (trans.getCustomerParty() != null) {
                IParty party = trans.getCustomerParty();
                List<ICustomerLoyaltyAccount> membershipLst = new ArrayList<ICustomerLoyaltyAccount>();
                ICustomerLoyaltyAccount loyAcount = null;
                String membershipJson = null;
                //Begin BZ26467
                String jsonResponseBuf = _transactionScope.get()
                        .getValue(CawValueKeys.API_LOOKUP_RESPONSE);
                String jsonMembers = getJsonMembershipBuf(jsonResponseBuf);
                if (jsonMembers == null || jsonMembers.length() == 0) {
                    try {
                        PartyIdCrossReferencePropertyId partyXRef = new PartyIdCrossReferencePropertyId();
                        partyXRef.setOrganizationId(party.getOrganizationId());
                        partyXRef.setPartyId(party.getPartyId());
                        partyXRef.setAlternateIdOwner(EBS_TEXT);
                        partyXRef.setPropertyCode(MEMBERSHIPS);
                        IPartyIdCrossReferenceProperty referenceProperty = DataFactory
                                .getObjectByIdNoThrow(partyXRef);
                        if (referenceProperty != null
                                && StringUtils.isNotEmpty(referenceProperty
                                        .getStringValue())) {
                            membershipJson = referenceProperty.getStringValue();
                            _logger.info("Membership data get from database."
                                    + membershipJson); //BZ25434
                        }
                    } catch (Exception ex) {
                        _logger.error("Can not get membership from database: "
                                + ex.getMessage());
                    }
                } else {
                    membershipJson = jsonMembers;
                }
                //End BZ26467

                if (membershipJson != null) {
                    try {
                        JSONArray memberShips = new JSONArray(membershipJson);
                        for (int i = 0; i < memberShips.length(); i++) {
                            loyAcount = DataFactory
                                    .createObject(ICustomerLoyaltyAccount.class);
                            loyAcount.setOrganizationId(ConfigurationMgr
                                    .getOrganizationId());
                            loyAcount.setAccountId(memberShips.getJSONObject(i)
                                    .getString(IDENTIFIER));

                            if (memberShips.getJSONObject(i)
                                    .getString(EXPIRE_DATE) != null) {
                                loyAcount.setExpirationDate(CawUtilFunction
                                        .formatDateMMDDYYY(memberShips
                                                .getJSONObject(i)
                                                .getString(EXPIRE_DATE)));
                            }

                            // Start BZ-44053
                            if (memberShips.getJSONObject(i)
                                    .getString(CawEBSConstant.MEMBERSHIPS_TYPE_DESCRIPTION_ATTR) != null) {
                                loyAcount.setLoyaltyProgramName(memberShips
                                        .getJSONObject(i)
                                        .getString(CawEBSConstant.MEMBERSHIPS_TYPE_DESCRIPTION_ATTR));
                            }

                            if (memberShips.getJSONObject(i)
                                    .getString(CawEBSConstant.MEMBERSHIPS_STATUS_DESCRIPTION_ATTR) != null) {
                                //Begin BZ24651
                                loyAcount.setLoyaltyProgramLevelName(memberShips
                                        .getJSONObject(i)
                                        .getString(CawEBSConstant.MEMBERSHIPS_STATUS_DESCRIPTION_ATTR));
                                //End BZ24651
                            }
                            
                            if (memberShips.getJSONObject(i)
                                    .getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR) != null) {
                                loyAcount.setLoyaltyProgramId(memberShips
                                        .getJSONObject(i)
                                        .getString(CawEBSConstant.MEMBERSHIPS_TYPE_ATTR));
                            }
                            
                            if (memberShips.getJSONObject(i)
                                    .getString(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_ATTR) != null) {
                                loyAcount.setLoyaltyProgramLevelId(memberShips
                                        .getJSONObject(i)
                                        .getString(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_ATTR));
                            }
                            // End BZ-44053

                            membershipLst.add(loyAcount);
                        }
                        loyaltyCard.setLoyaltyAccounts(membershipLst);
                        trans.setLoyaltyCardObject(loyaltyCard);

                        return true;
                    } catch (JSONException ex) {
                        _logger.error("Can not get JSON object: "
                                + ex.getMessage());
                    }
                } else {
                    _logger.info("Membership data get from the transaction."
                            + party.getPartyId()); //BZ25434
                    List<ICustomerLoyaltyCard> loyaltyCardsList = party
                            .getLoyaltyCards();
                    for (ICustomerLoyaltyCard custLoyaltyCard : loyaltyCardsList) {
                        loyAcount = DataFactory
                                .createObject(ICustomerLoyaltyAccount.class);
                        loyAcount.setAccountId(custLoyaltyCard.getCardNumber());
                        loyAcount.setOrganizationId(ConfigurationMgr
                                .getOrganizationId());
                        for (ICustomerLoyaltyAccount custLoyaltyAccount : custLoyaltyCard
                                .getLoyaltyAccounts()) {
                            loyAcount.setExpirationDate(custLoyaltyAccount
                                    .getExpirationDate()); // BZ24429
                            loyAcount.setLoyaltyProgramName(custLoyaltyAccount
                                    .getLoyaltyProgramName());
                            //Begin BZ24651
                            statusDescription = "";
                            statusDescription = getCustAccountProperties(custLoyaltyAccount
                                    .getCardNumber(), custLoyaltyAccount
                                            .getAccountId());
                            loyAcount
                                    .setLoyaltyProgramLevelName(statusDescription);

                        }
                        if (!(statusDescription.equalsIgnoreCase(""))) {
                            membershipLst.add(loyAcount);
                        }
                        //End BZ24651
                    }
                    loyaltyCard.setLoyaltyAccounts(membershipLst);
                    trans.setLoyaltyCardObject(loyaltyCard);

                    return true;
                }
            }
        }
        return false;
    }

    //Begin BZ24651
    /**
     * @param argCardNumber
     * @param argAccountId
     * @return
     */
    private String getCustAccountProperties(String argCardNumber,
            String argAccountId) {

        String resluts = "";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(argCardNbr_FIELD, argCardNumber);
        params.put(argCustAcct_FIELD, argAccountId);
        IQueryResultList<CawCatCustLoyalAcctPResults> results = DataFactory
                .getObjectByQueryNoThrow(CAW_CAT_CUST_LOYALTY_ACCT_P, params);
        if (results != null && results.size() > 0) {
            for (CawCatCustLoyalAcctPResults acctPResults : results) {
                return resluts = acctPResults.getProperties();
            }
        }
        return resluts;
    }
    //End BZ24651

    // Begin BZ26467
    /**
     * The function check customer info have contained memberships.
     * @param customerInfo
     * @return
     */
    private String getJsonMembershipBuf(String customerInfo) {

        String buf = null;
        if (!StringUtils.isEmpty(customerInfo)) {
            try {
                JSONObject customerObj = new JSONObject(customerInfo);
                if (!customerObj.isNull(JSON_MEMBERSHIPS)) {
                    buf = customerObj.getString(JSON_MEMBERSHIPS);
                }
            } catch (JSONException ex) {
                _logger.error("getJsonMembershipBuf: " + ex.getMessage());
            }
        }
        return buf;
    }
    // End BZ26467
}
