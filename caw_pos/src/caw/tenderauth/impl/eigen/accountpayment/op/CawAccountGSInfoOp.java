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
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ29379          140219    [Internal] Xstore should display the actual response provided by Eigen MiraServ once returning an unsuccessful GS Account Payment inquiry response
 * BZ29535          260219    [Internal] Good Sam Account Inquiry Screen/Form does not display amounts and due date.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.op;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawUtilFunction;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.i18n.format.MoneyFormatter;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 * Send Account Inquiry (Account Lookup) request and retrieve card's info.
 */
public class CawAccountGSInfoOp extends PromptOp {

    private CawCustomerGSHelper _gsHelper       = CawCustomerGSHelper.getInstance();

    @Inject
    private CawEigenMgr         _cawEigenMgr;

    @Inject
    private IBusyState          _busyState;

    private MoneyFormatter      _moneyFormatter = new MoneyFormatter();

    /* Send Account Inquiry (Account Lookup) request
     * @see dtv.pos.framework.op.AbstractPromptOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        IParty custParty = null;
        if (trans != null && trans.getCustomerParty() != null) {
            custParty = trans.getCustomerParty();
        }
        _busyState.start(CawConstants.WAIT_FOR_SIGCAP);

        /*BEGIN BZ29379*/
        IOpResponse response = HELPER.completeCurrentChainResponse();
        Boolean isApproved = Boolean.FALSE;
        if (custParty != null) {
            if (StringUtils.isNotEmpty(_gsHelper.getMarkedPAN()) && StringUtils.isNotEmpty(_gsHelper.getExpiryDay())) {
                isApproved = Boolean.TRUE;
            } else {
                isApproved = _cawEigenMgr.requestAccountLookup();
            }
        }

        if (isApproved) {
            _busyState.end();
            _cawEigenMgr.displayAccountInquiry(_gsHelper.getGSInfo());
            response = HELPER.getCompletePromptResponse(getDefaultPromptKey(), getPromptArgs(argArg0));
        } else {
            _busyState.end();
            String resMgs = _gsHelper.getResMgs();
            IFormattable args = _ff.getSimpleFormattable(resMgs);
            response = HELPER.getCompletePromptResponse(getErrorPromptKey(), args);
            _cawEigenMgr.displayResMgs(resMgs);
        }
        /*END BZ29379*/

        return response;
    }

    /* Main prompt.
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_GS_PAYMENT_ACCOUNT_INFO");
    }
    
    
    /*BEGIN BZ29379*/
    /* Error prompt
     * @see dtv.pos.framework.op.AbstractPromptOp#getErrorPromptKey()
     */
    @Override
    protected PromptKey getErrorPromptKey() {

        return PromptKey.valueOf("CAW_GS_ACCOUNT_PAYMENT_ERROR");
    }
    /*END BZ29379*/

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argArgEvent) {

        IFormattable args[] = new IFormattable[4];
        StringBuilder name = new StringBuilder();
        name.append(_gsHelper.getFirstNameADS()).append(CawConstants.SPACE_SIGN).append(_gsHelper.getLastNameADS())
                .toString();
        args[0] = _ff.getSimpleFormattable(name.toString());
        args[1] = _ff.getSimpleFormattable(_gsHelper.getMarkedPAN());
        args[2] = _ff.getSimpleFormattable(_moneyFormatter.format(_gsHelper.getMinAmountDue(), null));
        /* BEGIN BZ29535 */
        Date dueDate = CawUtilFunction.formatDateMMDDYYY(_gsHelper.getDueDate());
        String strDueDate = CawUtilFunction.convertDateFormatMMDDYYY(dueDate);
        args[3] = _ff.getSimpleFormattable(strDueDate);
        /* END BZ29535 */
        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return super.handlePromptResponse(argEvent);
    }
}
