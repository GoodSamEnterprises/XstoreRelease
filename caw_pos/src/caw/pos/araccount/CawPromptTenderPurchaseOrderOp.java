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
 * BZ23263          250917    Implement House Account
 * BZ23724          041017    Edit Credit Limit button should be disabled
 * BZ24046          171017    The customer is not associated to sale transaction also do "Third-party" tender when selecting "Yes" on House Account prompt
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ24404          091117    'Picked up by' of Third- party tender displayed incorrect in receipt when doing transaction between AR and Third- party
 * BZ24405          151117    AR account payment should be displayed on Customer Account Activity Summary Report instead of 'House Account Payment'
 * BZ24497          161117    'HDE' screen is displayed when doing transaction with AR account - third-party and AR account tender
 * BZ24945          281217    AR tender is disable on Return tender option screen when performing return transaction by scanning trans on Sell item screen
 * BZ27813          181018    [New Requirement] Credit Limit VALIDATION is displaying for AR and Third Party if tender amount is greater than $1000
 * BZ31717          240719    [Prod] Cancelled transactions are successfully proceed in Order Service.
 *===================================================================
 */

package caw.pos.araccount;

import static dtv.pos.customer.CustomerUtil.CUSTOMER_HOUSE_ACCOUNT_CREATED;
import static dtv.pos.customer.CustomerUtil.HOUSE_ACCOUNT_CREATED_EVENT_DESCRIPTOR;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.customer.CawCustomerHelper;

import dtv.data2.access.DataFactory;
import dtv.data2.access.IDataModel;
import dtv.event.Eventor;
import dtv.event.eventor.DefaultEventor;
import dtv.pos.common.PersistablesBag;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.scope.ValueKey;
import dtv.pos.houseaccount.HouseAccountHelper;
import dtv.pos.houseaccount.HouseAccountStateType;
import dtv.pos.houseaccount.model.HouseAcctBuyerModel;
import dtv.pos.houseaccount.model.HouseAcctEditCreditLimitModel;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;
import dtv.util.IDateProvider;
import dtv.util.sequence.SequenceFactory;
import dtv.xst.dao.cat.*;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.ttr.IAccountReceivableTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * this function is used to show prompt PO and handle PO
 */

public class CawPromptTenderPurchaseOrderOp extends AbstractPromptOp {

    private static final Logger          _logger        = LogManager
            .getLogger(CawPromptTenderPurchaseOrderOp.class);

    /** The tender helper. */
    @Inject
    protected TenderHelper               _tenderHelper;

    @Inject
    private HouseAccountHelper           _houseAccountHelper;

    public static final ValueKey<String> ACCOUNT_NUMBER = new ValueKey<String>(
            String.class, "ACCOUNT_NUMBER");

    private String                       tendId         = "";                  //BZ24405

    /** {@inheritDoc} */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("ENTER_PO_NUMBER");
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        try {
            tendId = "";
            // BZ24405
            // Begin BZ24497
            IParty customer = _transactionScope
                    .getValue(ValueKeys.SELECTED_CUSTOMER);
            if (customer == null) {
                customer = this.getScopedValue(ValueKeys.SELECTED_CUSTOMER);
            }

            //End BZ24497
            IAccountReceivableTenderLineItem lineItem = (IAccountReceivableTenderLineItem) getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
            //Begin BZ24404
            if (getScopedValue(CawValueKeys.COMPANYNAME) != null) {
                lineItem.setAccountUserName(getScopedValue(CawValueKeys.COMPANYNAME));
            }
            //End BZ24404
            tendId = lineItem.getTenderId();//BZ24405
            lineItem.setPoNumber(argArg0.getData().toString());
            lineItem.setPartyId(customer.getPartyId());
            lineItem.setAccountNumber(_transactionScope
                    .getValue(ACCOUNT_NUMBER));

        } catch (Exception ex) {
            _logger.error("Null exception: " + ex.getMessage());
        }

        ICustomerConsumerChargeAccount houseAccount = null;
        createHouseAccount();
        arAvailable(houseAccount);
        //End BZ24405
        return HELPER.completeResponse();
    }

    @Override
    public boolean isOperationApplicable() {

        ITenderLineItem tenderLineItem = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        return (tenderLineItem.getAmount() == null);
    }

    private void arAvailable(ICustomerConsumerChargeAccount arhouseaccount) {

        IChargeAccountUser user = null;
        if (arhouseaccount != null
                && arhouseaccount.getChargeAccountUsers() != null
                && arhouseaccount.getChargeAccountUsers().size() > 0) {
            user = arhouseaccount.getChargeAccountUsers().get(0);
            setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT_USER, user);
        } else {
            user = getScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT_USER);
        }

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);

        if (tenderLine instanceof IAccountReceivableTenderLineItem) {
            IAccountReceivableTenderLineItem arLine = (IAccountReceivableTenderLineItem) tenderLine;
            //Begin BZ24404
            if (user != null) {
                if (!arLine.getTenderId().equalsIgnoreCase("THIRD_PARTY")) {
                    arLine.setAccountUserName(user.getAccountUserName());
                    arLine.setAccountUserId(user.getAccountUserId());
                } else {
                    arLine.setAccountUserId(user.getAccountUserId());
                }
                //End BZ24404
            }

        }
    }

    /**
     * this method is used to create a new House account in case without House account in these table cat_cust_acct
     */
    private void createHouseAccount() {

        HouseAcctEditCreditLimitModel model = new HouseAcctEditCreditLimitModel();
        //model.setCustomerHouseAccountCreditLimit(getDefaultAccountCreditLimit());//BZ27813 removed

        // BZ27813 start
        BigDecimal accBalanceOnlineOnly = _transactionScope
                .getValue(CawValueKeys.AR_ACCOUNT_BALANCE);
        model.setCustomerHouseAccountCreditLimit(accBalanceOnlineOnly);

        ITenderLineItem itm = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        if (itm != null && itm instanceof IAccountReceivableTenderLineItem) {
            IAccountReceivableTenderLineItem lineItem = (IAccountReceivableTenderLineItem) itm;
            if (CawConstants.THIRD_PARTY.equals(lineItem.getTenderId())) {
                BigDecimal accBalanceThirdparty = _transactionScope
                        .getValue(CawValueKeys.TP_ACCOUNT_BALANCE);
                model.setCustomerHouseAccountCreditLimit(accBalanceThirdparty);
            }
        }
        // BZ27813 end

        //Begin BZ24497
        IParty customer = _transactionScope
                .getValue(ValueKeys.SELECTED_CUSTOMER);
        if (customer == null) {
            customer = this.getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        }
        //Begin BZ24945: case for Return AR/Third Party
        if (customer == null) {
            customer = getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION)
                    .getCustomerParty();
        }
        //End BZ24945
        //End BZ24497
        ICustomerConsumerChargeAccount houseAccount = createNewHouseAccount(_transDateProvider, _stationState
                .getRetailLocationId(), customer, model
                        .getCustomerHouseAccountCreditLimit());
        IChargeAccountUser user = null;
        if (houseAccount != null && houseAccount.getChargeAccountUsers() != null
                && houseAccount.getChargeAccountUsers().size() > 0) {
            user = houseAccount.getChargeAccountUsers().get(0);
            setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT_USER, user);
        }
        setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT_TO_MAINTAIN, houseAccount);

        setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT, houseAccount);
        Eventor eventor = new DefaultEventor(
                HOUSE_ACCOUNT_CREATED_EVENT_DESCRIPTOR);
        eventor.post(CUSTOMER_HOUSE_ACCOUNT_CREATED, houseAccount);
        _houseAccountHelper.setCurrentHouseAccount(houseAccount);
    }

    /**
     * Implement code for create new house account
     */
    public ICustomerConsumerChargeAccount createNewHouseAccount(
            IDateProvider argDateProvider, long argRetailLocationId,
            IParty argParty, BigDecimal argCreditLimit) {

        final String strHouseAccount = "HOUSE_ACCOUNT";
        //Begin BZ23724: additional condition for house account existed in cat_cust_acct or not
        String houseAccountIdKey = "";
        CustomerAccountId temp = new CustomerAccountId();
        IDataModel result = null;
        do {
            houseAccountIdKey = SequenceFactory
                    .getNextStringValue(strHouseAccount);
            temp.setCustAccountId(houseAccountIdKey);
            temp.setCustAccountCode(strHouseAccount);
            result = DataFactory.getObjectByIdNoThrow(temp);
        } while (result != null);
        //End BZ23724
        // Create cat_cust_acct
        CustomerAccountId id = new CustomerAccountId();
        id.setCustAccountId(houseAccountIdKey);
        id.setCustAccountCode(tendId);//BZ24405
        ICustomerAccount custAcct = DataFactory
                .createObject(id, ICustomerAccount.class);
        custAcct.setAccountBalance(new BigDecimal(0));
        custAcct.setRetailLocationId(argRetailLocationId);
        custAcct.setCustIdentityTypeCode(argParty.getPartyTypeCode());
        custAcct.setPartyId(argParty.getPartyId());
        custAcct.setParty(argParty);
        custAcct.setCustAccountStateCode(HouseAccountStateType.OPEN_ACCOUNT
                .toString());
        final Date today = argDateProvider.getDate();
        custAcct.setLastActivityDate(today);
        custAcct.setAccountSetupDate(today);
        /* BEGIN BZ31717*/
        CawCustomerHelper.getInstance().removeCatCustConsumerChargeAcctLocal(argParty, houseAccountIdKey);
        /* END BZ31717 */
        ICustomerConsumerChargeAccount custConsumerChargeAcct = DataFactory
                .createObject(id, ICustomerConsumerChargeAccount.class);

        custConsumerChargeAcct.setRetailLocationId(argRetailLocationId);
        custConsumerChargeAcct
                .setCustAccountStateCode(HouseAccountStateType.OPEN_ACCOUNT
                        .toString());
        custConsumerChargeAcct
                .setCustIdentityTypeCode(argParty.getPartyTypeCode());
        custConsumerChargeAcct.setPartyId(argParty.getPartyId());
        custConsumerChargeAcct.setParty(argParty);
        custConsumerChargeAcct.setLastActivityDate(today);
        custConsumerChargeAcct.setAccountSetupDate(today);
        custConsumerChargeAcct.setCreditLimit(argCreditLimit);
        custConsumerChargeAcct.setAvailableCredit(argCreditLimit);
        custConsumerChargeAcct.setAccountBalance(new BigDecimal(0));

        HouseAcctBuyerModel buyerModel = new HouseAcctBuyerModel();
        IChargeAccountUser userToBeAdded = buyerModel.getHouseAccountBuyer();
        userToBeAdded.setCustAccountId(houseAccountIdKey);
        userToBeAdded.setCustAccountCode(tendId);
        userToBeAdded.setAccountUserFirstName(argParty.getFirstName());
        userToBeAdded.setAccountUserLastName(argParty.getLastName());
        userToBeAdded.setAccountUserName(argParty.getFirstName() + " "
                + argParty.getLastName());
        userToBeAdded.setPrimaryContact(true);

        custConsumerChargeAcct.addChargeAccountUser(userToBeAdded);

        PersistablesBag bag = new PersistablesBag();
        bag.addAllObjects(new IDataModel[] { custAcct, custConsumerChargeAcct, argParty });

        return custConsumerChargeAcct;
    }

}
