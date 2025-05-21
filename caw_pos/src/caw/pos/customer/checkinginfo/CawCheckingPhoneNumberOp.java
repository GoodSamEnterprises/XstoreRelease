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
 * BZ29514          220219    Updated Requirement] ADS Feedback: Instant Credit API – the phone number is not being sent. This is a required field.
 *===================================================================
 */

package caw.pos.customer.checkinginfo;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.CawEigenMgr;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 * Checking customer's phone number if it is existed or not.
 * If not existed: jump to customer edit screen.
 */
public class CawCheckingPhoneNumberOp extends Operation {
    
    @Inject
    private CawEigenMgr _cawEigenMgr;

    /* Default prompt key.
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    public PromptKey getPromptKey() {

        return PromptKey.valueOf("CAW_CHECKING_PHONE_NUMBER");
    }

    /**
     * Checking phone number.
     * @return true if empty, false if not empty.
     */
    private boolean isPhoneNumberEmpty(IParty custParty) {

        Map<String, String> phoneNumbers = CawCustomerUtil.getPhoneNumberIParty(custParty);
        if (CollectionUtils.sizeIsEmpty(phoneNumbers)) {
            return true;
        }
        return false;
    }

    /* Handle input event.
     * @see dtv.pos.framework.op.AbstractPromptOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /*if transaction or customer do not exist, go to search customer*/
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        if (trans == null || trans.getCustomerParty() == null) {
            return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION"));
        }
        /*Handle action*/
        if (argArg0 != null) {
            IXstActionKey key = ((IXstAction) argArg0).getActionKey();
            if (key.equals(XstDataActionKey.ACCEPT)) {
                _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, Boolean.TRUE);
                return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION_EDIT"));
            }
        }
        /*Checking phone number.*/
        if (isPhoneNumberEmpty(trans.getCustomerParty())) {
            _cawEigenMgr.askingPhoneNumber();
            return HELPER.getPromptResponse(getPromptKey());
        }
        return HELPER.completeResponse();
    }
}
