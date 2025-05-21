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
 * BZ24187          261017    HDE is displayed when pressing "GS Visa Apply Now" button
 * BZ25858          030418    [Internal] Help Desk Error when you select GS Visa Apply when EBS is Offline
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ27535          090519    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.List;

import caw.pos.common.CawEBSConstant;
import caw.pos.common.CawPropertyUtils;
import caw.pos.util.CawEBSHelper;

import dtv.data2.access.DataFactory;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawConfirmCustomerInfoErrorPromptOp extends AbstractPromptOp {

    private static final OpChainKey OP_CUST_ASSOCIATION = OpChainKey
            .valueOf("CUST_ASSOCIATION");

    private static final String     SALE_ITEM_START     = "SALE_ITEM_START";

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW.CONFIRM_CUST_INFO_ERROR");
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        String ebsResponse = null;
        IRetailTransaction trans = _transactionScope
                .getTransaction(RETAIL_SALE);
        if (getEBSAccountNumber(trans.getCustomerParty()) != null) {
            //BEGIN BZ24187
            String accountNo = getEBSAccountNumber(trans.getCustomerParty());
            if (accountNo != null) {
                ebsResponse = getCustomerDetailResponse(accountNo);
                if (ebsResponse == null || ebsResponse.length() == 0) { //BZ25858
                    return true;
                }
            }
            //END BZ24187
        }
        return false;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return HELPER
                .getStartChainResponse(OpChainKey.valueOf(SALE_ITEM_START));
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArgEvent) {

        IRetailTransaction trans = _transactionScope
                .getTransaction(RETAIL_SALE);
        if (trans == null || trans.getCustomerParty() == null) {
            return HELPER.getWaitStackChainResponse(OP_CUST_ASSOCIATION);
        }
        return super.handleOpExec(argArgEvent);
    }

    private String getEBSAccountNumber(IParty argParty) {

        String accountNo = null;
        IParty tmpParty = argParty;
        if (argParty != null) {
            /*Force reload Party Model due to Xstore Caching*/
            if (argParty.getAlternatePartyIds().isEmpty()) {
                PartyId partyId = new PartyId();
                partyId.setPartyId(argParty.getPartyId());
                IParty iParty = DataFactory.getObjectByIdNoThrow(partyId);
                if (iParty != null) {
                    tmpParty = iParty;
                }
            }
            List<IPartyIdCrossReference> altIds = tmpParty
                    .getAlternatePartyIds();
            if (altIds != null) {
                for (IPartyIdCrossReference altId : altIds) {
                    if (CawEBSConstant.ALTERNATE_ID_OWNER
                            .equals(altId.getAlternateIdOwner())) {
                        accountNo = altId.getAlternateId();
                    }
                }
            }
        }
        return accountNo;
    }

    private String getCustomerDetailResponse(String argAccountNumber) {
        //BZ26575 Changed by using CawEBSHelper
        String response = CawEBSHelper.getInstance()
                .lookupCustomerInEBS(argAccountNumber, CawPropertyUtils.STORE_NUMBER);/*BZ27535*/
        if (response != null && response.length() > 0) {
            return response;
        }
        return null;
    }

}
