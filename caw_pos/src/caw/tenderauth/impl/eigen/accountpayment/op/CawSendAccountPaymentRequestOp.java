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
 * BZ29406          180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 * BZ29444          190219    [Internal][Account Payment]Xstore Good Sam Account Payment Account Inquiry Responses incorrectly the content prompt incase unsuccessfully retrieved from ADS/Eigen.
 * BZ46300          060121    [New Requirement] Settlement Request for New Payment Type
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.op;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.tender.CawTenderConstants;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.i18n.FormattableFactory;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * Send Account Payment Request and handle failed response.
 */
public class CawSendAccountPaymentRequestOp extends Operation {

    @Inject
    private CawEigenMgr          _cawEigenMgr;

    @Inject
    protected FormattableFactory _ff;

    @Inject
    private IBusyState           _busyState;

    /* Send Account Payment Request.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IPosTransaction trans = _transactionScope.getTransaction();
        _busyState.start(CawConstants.WAIT_FOR_SIGCAP);
        
        //BEGIN BZ46300
        String tenderType = StringUtils.EMPTY;
        BigDecimal tenderAmount = new BigDecimal(CawEigenConstants.DEFAUTL_AMOUNT);
        
        if (trans != null) {
            List<IRetailTransactionLineItem> listTenders = trans.getTenderLineItems();
            for (IRetailTransactionLineItem tender : listTenders) {
                if (tender instanceof ITenderLineItem && !tender.getVoid()) {
                    ITenderLineItem tenderLine = (ITenderLineItem) tender;
                    
                    if (CawTenderConstants.USD_CURRENCY.equalsIgnoreCase(tenderLine.getTenderId())) {
                        tenderType = CawConstants.VALUE_1;
                    }
                    else if (CawTenderConstants.CHECK.equalsIgnoreCase(tenderLine.getTenderId())) {
                        tenderType = CawConstants.VALUE_2;
                    }
                    else {
                        tenderType = CawConstants.VALUE_4;
                    }
                    
                    tenderAmount = tenderLine.getAmount();
                    
                    if (!_cawEigenMgr.accountPaymentRequest(trans, tenderType, tenderAmount)) {
                        _busyState.end();
                        return HELPER.getCompletePromptResponse(getErrorPromptKey());
                    }
                }
            }
            
        } else {
            _busyState.end();
            return HELPER.getCompletePromptResponse(getErrorPromptKey());  
        }        
        //END BZ46300
        _busyState.end();
        return HELPER.completeResponse();
    }

    /* Failed Response Prompt.
     * @see dtv.pos.framework.op.AbstractPromptOp#getErrorPromptKey()
     */
    private PromptKey getErrorPromptKey() {
        /*BZ29444: changed prompt name to CAW_GS_ACCOUNT_PAYMENT_DECLINED*/
        return PromptKey.valueOf("CAW_GS_ACCOUNT_PAYMENT_DECLINED");
    }
}
