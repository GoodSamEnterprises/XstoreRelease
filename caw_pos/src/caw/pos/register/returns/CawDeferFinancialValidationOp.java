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
 * BZ33319          260221    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 * BZ41674          050321    ADS Settlement - ORIG_INVOICE_NO on the return needs to match the INVOICE_NO of the purchase.
 * BZ41781          100321    Xstore allowed mixed verified return incorrectly when one sale was purchased on a deferred plan but the other sale was not
 * BZ41784          100321    Xstore allowed Exchange transaction for Verified Return for PLCC & Good Sam Visa Promo + Sale in the same transaction incorrectly
 * BZ41811          110321    Do a Verified Return for items purchased on a deferred financing plan but don't select items to return then Xstore does not allow to make another Verified Return
 * BZ41810          110321    Xstore allowed mixed a Verified Return for items purchased on a deferred financing plan with a Blind Return.
 * BZ43454          140521    [PROD] Only one item allowed for return when original Sale with multiple items has deferred financing
 *===================================================================
 */

package caw.pos.register.returns;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.tender.impl.mira.CawMiraFormatter;

import dtv.pos.common.PromptKey;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnManager;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 *
 */
public class CawDeferFinancialValidationOp extends AbstractPromptOp {

    private static final String   IS_DEFER_FINANCIAL = "IS_DEFER_FINANCIAL";

    private static final String   PROMOTE_FINANCIAL  = "PROMOTE_FINANCIAL";

    @Inject
    private ReturnManager         _returnMgr;

    private String                _transType; /*BZ41811*/
    private static final Logger   logger             = Logger.getLogger(CawMiraFormatter.class);

    protected static final String EMPTY_STR          = "";

    protected static final String DASH_STR           = "-"; 

    @Override
    public PromptKey getDefaultPromptKey() {
        return PromptKey.valueOf("CAW_DEFER_FINANCIAL_MIXED_NOT_ALLOWED");
    }
    
    @Override
    public void setParameter(String argName, String argValue) {

        if ("TransType".equalsIgnoreCase(argName)) {
            this._transType = argValue;
        } else {
            super.setParameter(argName, argValue);
        }
    }
    
    @Override
    public boolean isOperationApplicable() {
        // Start BZ41674
        boolean result = false;
        try {
            return isReturnDeferFinancialTransaction();
        } catch (Exception ex) {
            logger.error("Can not build transNumber for return transaction: " + ex.getMessage());
        }
        return result;
        // End BZ41674
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argVar1) {

        return null;
    }

    /*BEGIN BZ41674*/
    private boolean isReturnDeferFinancialTransaction() {

        boolean result = false;
        try {
            IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
            if (trans != null) {
                List<IRetailTransactionLineItem> lineItems = trans.getRetailTransactionLineItems();
                ISaleReturnLineItem lineItem = null;
                PosTransactionId orgTransID = null;
                if (!isEmptyTrans(trans)) {
                    int size = lineItems.size();
                    for (int i = 0; i < size; i++) {
                        if (lineItems.get(i) instanceof ISaleReturnLineItem) {
                            lineItem = (ISaleReturnLineItem) lineItems.get(i);
                            orgTransID = new PosTransactionId();
                            /* BEGIN BZ43454 get original transaction information*/
                            orgTransID.setTransactionSequence(lineItem.getOriginalTransactionSequence());
                            orgTransID.setBusinessDate(lineItem.getOriginalBusinessDate());
                            orgTransID.setOrganizationId(lineItem.getOrganizationId());
                            orgTransID.setRetailLocationId(lineItem.getOriginalRetailLocationId());
                            orgTransID.setWorkstationId(lineItem.getOriginalWorkstationId());
                            /* END BZ43454 */
                            if (!lineItem.getVoid()
                                    && validateReturndeferFinancialTrans(orgTransID)) {
                                result = true;
                            }
                        }
                    }
                } else if (_returnMgr.getCurrentOrigTransactionId() != null) {
                    orgTransID = new PosTransactionId();
                    orgTransID.setTransactionSequence(_returnMgr
                            .getCurrentOrigTransactionId()
                            .getTransactionSequence());
                    orgTransID.setBusinessDate(_returnMgr
                            .getCurrentOrigTransactionId().getBusinessDate());
                    orgTransID.setOrganizationId(_returnMgr
                            .getCurrentOrigTransactionId().getOrganizationId());
                    orgTransID.setRetailLocationId(_returnMgr
                            .getCurrentOrigTransactionId()
                            .getRetailLocationId());
                    orgTransID.setWorkstationId(_returnMgr
                            .getCurrentOrigTransactionId().getWorkstationId());
                    result = validateReturndeferFinancialTrans(orgTransID);
                }
            }
        } catch (Exception ex) {
            logger.error(" Can not check Exist Sale Item: " + ex.getMessage());
        }
        return result;
    }

    private boolean validateReturndeferFinancialTrans(PosTransactionId orgTransID) {
        IRetailTransactionLineItemProperty isDeferFinancial = null;
        try {
            if (_returnMgr != null && CollectionUtils
                    .isNotEmpty(_returnMgr.getAllOrigTransaction())) {
                PosTransactionId posOrigTranId = null;
                for (IRetailTransaction origTrans : _returnMgr.getAllOrigTransaction()) {
                    List<IRetailTransactionLineItem> lineReturnItems = origTrans.getRetailTransactionLineItems();
                    ICreditDebitTenderLineItem lineReturnItem = null;
                    if (CollectionUtils.isNotEmpty(lineReturnItems)) {
                        for (int i = 0; i < lineReturnItems.size(); i++) {
                            /*check item return has DEFER FINANCIA*/
                            if (lineReturnItems.get(i) instanceof ICreditDebitTenderLineItem) {
                                lineReturnItem = (ICreditDebitTenderLineItem) lineReturnItems.get(i);
                                isDeferFinancial = lineReturnItem.getProperty(IS_DEFER_FINANCIAL);
                                if (isDeferFinancial != null) {
                                    posOrigTranId  = new PosTransactionId();
                                    posOrigTranId.setTransactionSequence(origTrans.getTransactionSequence());
                                    posOrigTranId.setBusinessDate(origTrans.getBusinessDate());
                                    posOrigTranId.setOrganizationId(origTrans.getOrganizationId());
                                    posOrigTranId.setRetailLocationId(origTrans.getRetailLocationId());
                                    posOrigTranId.setWorkstationId(origTrans.getWorkstationId());
                                    /*Check mix return defer financia trans*/
                                    boolean isMix = checkMixDeferFinanciaTrans(posOrigTranId, orgTransID);
                                    if(isMix) {
                                        return isMix;
                                    }
                                    /*save value of VN,OG fields in scope*/
                                    if(posOrigTranId.equals(orgTransID)) {
                                        _transactionScope
                                                .setValue(CawValueKeys.RETURN_OG_FIELD, getTransNumber(origTrans));
                                        if ((lineReturnItem.getProperty(PROMOTE_FINANCIAL) != null)) {
                                            _transactionScope
                                                    .setValue(CawValueKeys.RETURN_VN_FIELD, lineReturnItem
                                                            .getProperty(PROMOTE_FINANCIAL)
                                                            .getStringValue());
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(" Can not validate transaction: " + ex.getMessage());
        }
        return false;
    }

    /*BEGIN BZ41811*/
    /**
     * @param argOrigTrans
     * @param argOrigLineTrans
     * @return
     */
    private boolean checkMixDeferFinanciaTrans(PosTransactionId argPosOrigTranId,
            PosTransactionId argPostTransLineItem) {
        boolean isValid = false;
        /*return transaction */
        if("RETURN".equals(_transType) && _returnMgr.getCurrentOrigTransactionId() != null) {
            PosTransactionId posCurrentOrigTranId = new PosTransactionId();
            posCurrentOrigTranId.setTransactionSequence(_returnMgr.getCurrentOrigTransactionId().getTransactionSequence());
            posCurrentOrigTranId.setBusinessDate(_returnMgr.getCurrentOrigTransactionId().getBusinessDate());
            posCurrentOrigTranId.setOrganizationId(_returnMgr.getCurrentOrigTransactionId().getOrganizationId());
            posCurrentOrigTranId.setRetailLocationId(_returnMgr.getCurrentOrigTransactionId().getRetailLocationId());
            posCurrentOrigTranId.setWorkstationId(_returnMgr.getCurrentOrigTransactionId().getWorkstationId());
            if(argPosOrigTranId.equals(argPostTransLineItem) && !argPostTransLineItem.equals(posCurrentOrigTranId)) {
                isValid = true;
            }else if(!argPostTransLineItem.equals(argPosOrigTranId) && argPosOrigTranId.equals(posCurrentOrigTranId)) {
                isValid = true;
            }
            else if(argPostTransLineItem.getTransactionSequence() == 0 && argPosOrigTranId.equals(posCurrentOrigTranId)) {
                isValid = true;
            }
        }
        /*BEGIN BZ41810*/
        /*Blind Return*/
        else if ("RETURN".equals(_transType)
                && _returnMgr.getCurrentOrigTransactionId() == null
                && argPosOrigTranId.equals(argPostTransLineItem)) {
            isValid = true;
        }
        /*END BZ41810*/
        /*sale trans*/
        else if("SALE".equals(_transType)){
            if(argPostTransLineItem.equals(argPosOrigTranId)) {
                isValid = true;
            }
        }
        return isValid;
    }
    /*END BZ41811*/
    private boolean isEmptyTrans(IRetailTransaction trans) {

        boolean result = true;
        try {
            if (trans != null) {
                List<IRetailTransactionLineItem> lineItems = trans.getRetailTransactionLineItems();
                ISaleReturnLineItem lineItem = null;
                if (CollectionUtils.isNotEmpty(lineItems)) {
                    int size = lineItems.size();
                    for (int i = 0; i < size; i++) {
                        if (lineItems.get(i) instanceof ISaleReturnLineItem) {
                            lineItem = (ISaleReturnLineItem) lineItems.get(i);
                            if (!lineItem.getVoid()) {
                                result = false;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(" Can not check Exist Sale Item: " + ex.getMessage());
        }
        return result;
    }
    /*END BZ41784*/
    
    /*BEGIN BZ41784*/
    private String getTransNumber(IRetailTransaction trans) {
        try {
            if (trans != null) {
                String businessDate = String.format("%tF", trans.getBusinessDate()).replaceAll(DASH_STR, "");
                String transNumber = String.format("%s0%d0%d%d", businessDate, trans.getRetailLocationId(), trans.getWorkstationId(), trans
                                                .getTransactionSequence());
                return transNumber;
            }

        } catch (Exception ex) {
            logger.error(" Can not build transNumber: " + ex.getMessage());
        }
        return EMPTY_STR;
    }
    /*END BZ41674*/
}
