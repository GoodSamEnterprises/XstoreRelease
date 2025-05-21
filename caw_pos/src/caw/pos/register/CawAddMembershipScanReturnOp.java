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
 * BZ24945          020118    AR tender is disable on Return tender option screen when performing return transaction by scanning trans on Sell item screen
 * BZ25320          300118    AR tender is disable when return original transaction with new customer.
 * BZ26324          240518    'AR' tender is disable on Tender options screen when exchanging transaction with customer has wholesale group
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ28033          110518    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ27535          090519    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ36405          030620    Issue with Credit Customer placed on credit hold 
*===================================================================
 */

package caw.pos.register;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.ICustomerAffiliation;
import dtv.xst.dao.crm.IParty;

/**
 *
 */
public class CawAddMembershipScanReturnOp extends Operation {
    private static final Logger        _logger       = LogManager
            .getLogger(CawAddMembershipScanReturnOp.class);

    @Inject
    private Provider<TransactionScope> _transProviderScope;

    /**
     * Add missing membership info into transaction when scan transaction barcode
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        //Begin BZ25320
        if (getScopedValue(ValueKeys.SELECTED_CUSTOMER) == null) {
            //End BZ25320
            if (getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION) != null
                    && getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION)
                            .getCustomerParty() != null
                    && !getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION)
                            .getCustomerParty().getAlternatePartyIds()
                            .isEmpty()) {
                String accountNumber = getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION)
                        .getCustomerParty().getAlternatePartyIds().get(0)
                        .getAlternateId();

                //BZ26575 changed by using CawEBSHelper
                /* BEGIN BZ28033 */
                // Get JSON Customer from the Cached
                String lookupResponse = CawCatalystHelper.getLookupResponseData();
                if (StringUtils.isEmpty(lookupResponse)) {
                    lookupResponse = CawEBSHelper.getInstance()
                            .lookupCustomerInEBS(accountNumber, CawPropertyUtils.STORE_NUMBER);/* BZ27535 */
                    CawCatalystHelper.setLookupResponseData(lookupResponse);
                }
                /* END BZ28033 */

                if (StringUtils.isNotEmpty(lookupResponse)) {
                    _logger.info("The customer response from EBS data."
                            + lookupResponse);
                    try {
                        JSONObject lookupJSONResponse = new JSONObject(
                                lookupResponse);

                        IParty iParty = getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION)
                                .getCustomerParty();
                        if (!lookupJSONResponse
                                .isNull(CawEBSConstant.PRICING_ATTR)
                                && !lookupJSONResponse
                                        .getJSONObject(CawEBSConstant.PRICING_ATTR)
                                        .isNull(CawEBSConstant.PRICE_BAND)) {
                            ICustomerAffiliation affiliation = DataFactory
                                    .createObject(ICustomerAffiliation.class);

                            affiliation.setPartyId(iParty.getPartyId());
                            affiliation.setOrganizationId(iParty
                                    .getOrganizationId());
                            affiliation.setCustomerGroupId(lookupJSONResponse
                                    .getJSONObject(CawEBSConstant.PRICING_ATTR)
                                    .getString(CawEBSConstant.PRICE_BAND));

                            ArrayList<ICustomerAffiliation> customerAffiliations = new ArrayList<ICustomerAffiliation>();
                            customerAffiliations.add(affiliation);
                            iParty.setCustomerGroups(customerAffiliations);
                        }

                        _transProviderScope.get()
                                .setValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponse);
                        CawCatalystHelper.setLookupResponseData(lookupResponse);

                        setScopedValue(ValueKeys.SELECTED_CUSTOMER, iParty);
                        //Begin BZ26324
                        setScopedValue(CawValueKeys.API_LOOKUP_RESPONSE, lookupResponse);
                        checkArAccountValid(lookupResponse);
                        //End BZ26324
                        _transactionScope
                                .setValue(ValueKeys.SELECTED_CUSTOMER, iParty);

                        _transactionScope.getTransaction(RETAIL_SALE)
                                .setCustomerParty(iParty);

                    } catch (JSONException ex) {
                        _logger.info("Can not proccess JSon data response from EBS.");
                    }
                }
            }
        } //BZ25320

        return HELPER.completeResponse();
    }

    //Begin BZ26324
    /**
     * this method is used to check AR account info in case this is Return transaction.
     */
    private boolean checkArAccountValid(String lookupResponse) {

        boolean isAllowDisplayMsg = false;

        BigDecimal arAccountBalance = CawCustomerHelper.getInstance()
                .getAvailableBalanceAmt(lookupResponse);/*BZ36405*/
        if (BigDecimal.ZERO.compareTo(arAccountBalance) != 0) { //BZ23749
            isAllowDisplayMsg = true;
        }
        //adjust code
        _transactionScope
                .setValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT, Boolean
                        .valueOf(isAllowDisplayMsg));
        _transactionScope
                .setValue(CawValueKeys.AR_ACCOUNT_BALANCE, arAccountBalance);
        return isAllowDisplayMsg;
    }
    //End BZ26324
}
