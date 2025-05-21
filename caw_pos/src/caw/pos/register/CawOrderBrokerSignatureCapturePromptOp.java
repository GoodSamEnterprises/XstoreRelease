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
 * BZ37382          270820    [Requirement] Signature capturing for Order Creation/Pickup transaction
 * BZ37661          070920    [Requirement] Add new prompt "Please ask the customer to sign the receipt"
 *===================================================================
 */

package caw.pos.register;

import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderSignature;
import dtv.xst.dao.xom.IOrder;

/**
 *
 */
public class CawOrderBrokerSignatureCapturePromptOp extends AbstractPromptOp {    

    /* BEGIN BZ37382 */
    private static final Logger logger = Logger.getLogger(CawOrderBrokerSignatureCapturePromptOp.class);

    @Inject
    private IBusyState          _busyState;

    @Inject
    private CawEigenMgr         _cawEigenMgr;

    @Inject
    private OrderMgr            _orderMgr;

    @Inject
    private TransactionScope    _transaction;
    
    private static String NOT_APPROVED = "NOT_APPROVED";
    
    private static String SIGNED       = "SIGNED";
    
    private static final String NOT_SIGNED = "NOT_SIGNED";

    @Override
    public PromptKey getDefaultPromptKey() {
        if ((NOT_APPROVED).equals(_transactionScope.getValue(CawValueKeys.IS_ORDER_TRANSACTION))) {
            return PromptKey.valueOf("CAW_ORDER_BROKER_SIGNATURE_CAPTURE_RECEIPT");
        } else {
            return PromptKey.valueOf("CAW_ORDER_BROKER_SIGNATURE_CAPTURE");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * dtv.pos.iframework.op.IPromptOp#handlePromptResponse(dtv.pos.iframework.
     * event.IXstEvent)
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argVar1) {
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        if (currentOrder != null
                && NOT_SIGNED.equals(_transactionScope.getValue(CawValueKeys.IS_ORDER_TRANSACTION))) {
            _busyState.start("Waiting for signature");
            /* Implement here */
            try {
                String captureStr = _cawEigenMgr.signatureCapture(currentOrder);
                if (_cawEigenMgr.getResponseApproved() != null
                        && CawEigenConstants.ADS_RETURN_CODE_APPROVE_000.equals(_cawEigenMgr.getResponseApproved())) {
                    _transactionScope.setValue(CawValueKeys.IS_ORDER_TRANSACTION, SIGNED);
                    // Get information from transaction
                    IPosTransaction iPosTransaction = _transaction.getTransaction();
                    if (iPosTransaction != null && StringUtils.isNotEmpty(captureStr)) {

                        // 1. CreateObject ITenderSignature
                        ITenderSignature tenderSignatureModel = DataFactory.createObject(ITenderSignature.class);

                        // 2. Set information for ITenderSignature. Data will
                        // get from IPosTransaction
                        tenderSignatureModel.setOrganizationId(iPosTransaction.getOrganizationId());
                        tenderSignatureModel.setRetailLocationId(iPosTransaction.getRetailLocationId());
                        tenderSignatureModel.setBusinessDate(iPosTransaction.getBusinessDate());
                        tenderSignatureModel.setWorkstationId(iPosTransaction.getWorkstationId());
                        tenderSignatureModel.setTransactionSequence(iPosTransaction.getTransactionSequence());
                        tenderSignatureModel.setRetailTransactionLineItemSequence(1);
                        tenderSignatureModel.setSignature(captureStr);
                        tenderSignatureModel.setCreateDate(new Date());
                        tenderSignatureModel.setCreateUserId(iPosTransaction.getCreateUserId());

                        // 3. SetObjectState is INSERT_OR_UPDATE
                        ((IDataModelImpl) tenderSignatureModel).getDAO()
                                .setObjectState(DaoState.INSERT_OR_UPDATE.intVal());

                        // 4. Save signature into ttr_sisnature table
                        DataFactory.makePersistent(tenderSignatureModel);
                    }

                    _busyState.end();

                } else {
                    _transactionScope.setValue(CawValueKeys.IS_ORDER_TRANSACTION, NOT_APPROVED);
                    return HELPER
                            .getCompleteStackChainResponse(OpChainKey.valueOf("CAW_ORDER_BROKER_PROMPT_SIGNATURE_CAPTURE"));
                }
            } catch (Exception ex) {
                logger.info("Don't Get Signature Capture for Order Broker transaction", ex);
            }

        }
        return this.HELPER.completeResponse();
    }
    /* END BZ37382 */
}
