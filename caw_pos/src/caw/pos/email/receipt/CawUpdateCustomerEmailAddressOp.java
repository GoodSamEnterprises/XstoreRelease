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
 * BZ33894          031219    [New Requirement] Capturing email at end of transaction while assigned customer into transaction
 * BZ38598          301020    [PROD] Membership Activation Issues
 * BZ61159          190224    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.pos.email.receipt;

import static dtv.pos.common.TransactionType.RETAIL_SALE;
import static dtv.pos.email.Configurations.getSaveUpdatedEmailAddressToCustomer;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawJSONUtils;
import caw.pos.common.CawUtilFunction;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.util.CawEBSHelper;

import dtv.pos.common.TransactionType;
import dtv.pos.email.receipt.EmailRcptHelper;
import dtv.pos.email.receipt.UpdateCustomerEmailAddressOp;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyIdCrossReference;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawUpdateCustomerEmailAddressOp extends UpdateCustomerEmailAddressOp {
    private static final Logger _logger     = LogManager.getLogger(CawUpdateCustomerEmailAddressOp.class);
    private CawCustomerHelper   _custHelper = CawCustomerHelper.getInstance();

    /*Begin BZ33894*/
    /*
     * (non-Javadoc)
     * @see dtv.pos.email.receipt.UpdateCustomerEmailAddressOp#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        IParty customer = trans.getCustomerParty();
        String enteredEmail = getScopedValue(ValueKeys.RECEIPT_EMAIL_ADDRESS);

        if (getSaveUpdatedEmailAddressToCustomer() && customer != null && !isSameAsCustomerEmail(customer, enteredEmail)
                && CawCustomerUtil.isAllowEdit()) {
            return true;
        }
        return false;
    }
    /*End BZ33894*/

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        IXstActionKey key = ((IXstDataAction) argEvent).getActionKey();
        if (key == XstDataActionKey.YES) {
            IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);

            if (trans != null) {
                if (trans.getCustomerParty() != null) {
                    IParty customer = trans.getCustomerParty();
                    customer.setEmailAddress(getScopedValue(ValueKeys.RECEIPT_EMAIL_ADDRESS));
                    EmailRcptHelper.setCustomerEmailUpdated(trans, true);

                    //Begin BZ33894
                    Long accountNumber = 0L;
                    String accNumber = "";
                    List<IPartyIdCrossReference> listPartyIdCrossRef = customer.getAlternatePartyIds();
                    if (CollectionUtils.isNotEmpty(listPartyIdCrossRef)) {
                        accNumber = listPartyIdCrossRef.get(0).getAlternateId();
                        if (accNumber != null) {
                            accountNumber = Long.valueOf(CawJSONUtils.vLong(accNumber));
                        }
                    }

                    String upsertRequest = CawCustomerHelper.getInstance().buildUpsertRequest(customer, accountNumber);
                    if (CawUtilFunction.allowEBSConnection()) {
                        if (StringUtils.isNotEmpty(upsertRequest)) {
                            ResponseEntity<String> upSertResponse = CawEBSHelper.getInstance()
                                    .upsertCustomterToEBS(upsertRequest);
                            if (upSertResponse != null && upSertResponse.getBody() != null && upSertResponse.getBody().length() > 0) { //BZ61159
                                _logger.info("Update email address of customer success.");
                                CawCatalystHelper.setLookupResponseData(upSertResponse.getBody());
                                // BZ-38598: clean up PartyProperties by DELETE statement
                                _custHelper.deteleCustomerOfflineQueue(customer, upSertResponse.getBody()); // BZ-38598
                            } else {
                                _logger.info("Cannot update the email address of the customer.");
                            }
                        }
                    } else {
                        _custHelper.processCustomerOffline(customer, upsertRequest);
                    }
                    //End BZ33894
                }
            }
        }
        return this.HELPER.completeResponse();
    }

}
