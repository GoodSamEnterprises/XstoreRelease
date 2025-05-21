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
 * BZ29351          150219    [Requirement] PLCC Acquisition - Pin Pad Photo ID Form Placement
 * BZ29506          050319    [Internal] After prescreen application, Xstore prints a transaction receipt and not the temporary shopping pass.
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
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawPreScreenConfirmCustomerInfoPromptOp extends AbstractPromptOp {

    private static final OpChainKey OP_CUST_ASSOCIATION = OpChainKey.valueOf("CUST_ASSOCIATION");

    @Inject
    private CustomerHelper          _customerHelper;

    private CawCustomerGSHelper     _gsHelper           = CawCustomerGSHelper.getInstance();

    @Inject
    private CawEigenMgr             _cawEigenMgr;

    @Inject
    private CawEigenHelper          _cawEigenHelper;

    @Inject
    private IBusyState              _busyState;                                                  //BZ29506

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
                _cawEigenHelper.refreshPinpadScreen(_transactionScope);
                _gsHelper.clearGSInfo();
                return HELPER.completeCurrentChainResponse();
            } else {
                _busyState.start(CawConstants.WAIT_FOR_SIGCAP); //BZ29506
                IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
                IParty custParty = trans.getCustomerParty();
                /*Verify on PINPAD*/
                if (!_cawEigenMgr.verifyCustomer(custParty)) {
                    _busyState.end(); //BZ29506
                    return HELPER
                            .getWaitStackChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_CUSTOMER_MAINTENANCE_EDIT"));
                }
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
        return super.handleOpExec(argArgEvent);
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argArgEvent) {

        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        IParty custParty = trans.getCustomerParty();
        IFormattable args[] = new IFormattable[4];
        args[0] = _ff.getSimpleFormattable(_customerHelper.getCustomerDisplayName(custParty));
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
