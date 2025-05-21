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
 * BZ23563          101017    [Payments] Xstore needs to confirm selected 
 *                            customer before sending command to pin pad for instant credit
 * BZ24039          181017    Customer name displays null instead of company name on "Confirm name & address"
 *                            prompt when registering "GS Visa apply now".
 * BZ24187          261017    HDE is displayed when pressing "GS Visa Apply Now" button
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ28738          201218    [PLCC] PINPAD and Xstore display inconsistency once selecting 'NO' on Customer & Confirmation screen
 * BZ28740          211218    [PLCC] Can't do trans with New GSVisa Card
 * BZ29277          130219    [INTERNAL][PLCC] Sigcap did not clear the content when user select Photo ID not match the detail.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawConstants;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 * Customer verify their information.
 * Step 1, verify on PINPAD: YES go to verify on Xstore, NO go to customer maintenance
 * Step 2, verify on Xstore: YES go to entry information, NO quit process
 */
public class CawConfirmCustomerInfoPromptOp extends AbstractPromptOp {

    private static final OpChainKey OP_CUST_ASSOCIATION = OpChainKey.valueOf("CUST_ASSOCIATION");

    @Inject
    private CustomerHelper          _customerHelper;

    private CawCustomerGSHelper     _gsHelper           = CawCustomerGSHelper.getInstance();

    @Inject
    private CawEigenMgr             _cawEigenMgr;

    @Inject
    private CawEigenHelper          _cawEigenHelper;

    @Override
    public PromptKey getDefaultPromptKey() {

        _cawEigenMgr.verifyGovIssuedId();
        return PromptKey.valueOf("CAW.CONFIRM_CUST_INFO");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        /*Verify on Xstore*/
        if (argEvent instanceof IXstDataAction) {
            IXstDataAction dataAction = (IXstDataAction) argEvent;
            if ((dataAction.getActionKey() != null) && (dataAction.getActionKey().equals(XstDataActionKey.NO))) {
                _cawEigenHelper.refreshPinpadScreen(_transactionScope); /*BZ28738: clear "_cawEigenMgr.verifyGovIssuedId()" screen */
                _gsHelper.clearGSInfo(); /*BZ28740: clear GS info*/
                return HELPER.completeCurrentChainResponse();
            }
        }
        return HELPER.completeResponse();
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArgEvent) {

        /*Verify on PINPAD*/
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        if (trans == null || trans.getCustomerParty() == null) {
            return HELPER.getWaitStackChainResponse(OP_CUST_ASSOCIATION);
        }

        IParty custParty = trans.getCustomerParty();
        /*Verify on PINPAD*/
        if (!_gsHelper.isVerified() && !_cawEigenMgr.verifyCustomer(custParty)) {
            return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_CUSTOMER_MAINTENANCE_EDIT"));
        }
        _gsHelper.isVerified(true);
        return super.handleOpExec(argArgEvent);
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argArgEvent) {

        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        IParty custParty = trans.getCustomerParty();
        IFormattable args[] = new IFormattable[4];
        /* BZ24039 Begin */
        args[0] = _ff.getSimpleFormattable(_customerHelper.getCustomerDisplayName(custParty));
        /* BZ24039 End */
        args[1] = _ff.getSimpleFormattable(CawCustomerUtil.getAddressInfoIParty(custParty, 1));
        //
        StringBuilder value = new StringBuilder();
        value.append(CawCustomerUtil.getAddressInfoIParty(custParty, 2)).append(CawConstants.COMMA_SIGN)
                .append(CawCustomerUtil.getAddressInfoIParty(custParty, 3)).append(CawConstants.SPACE_SIGN)
                .append(CawCustomerUtil.getAddressInfoIParty(custParty, 4));
        args[2] = _ff.getSimpleFormattable(value.toString());

        return args;
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.WAIT_FOR_SIGCAP;
    }
}
