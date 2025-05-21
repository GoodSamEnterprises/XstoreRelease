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
 * BZ26503          070618    [Internal]Credit/Debit tender displays unexpectedly from Refund Tender list 
 *                            when returning original receipt is not used this tender into sale transaction.
 * BZ26558          130618    Credit/Debit tender disable on return tender options screen when pressing 'Back' on Tender original credit card screen.
 * BZ26650          210618    [1.5.0] Missing Credit/Debit refund tender type for Web Order Returns
 * BZ27023          060818    [1.6.2] WO - Xstore doesn't retrieve existing tokens for credit tenders when doing WO Cancel transaction
 * BZ27035          060818    Work Order Refund Tender Option Issue
 * BZ27036          060818    Work Order Complete tender options isssue
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27812          191018    [New Requirement] Add cash as a tender option for Web Orders
 * BZ27921          231018    [Internal] Incorrect return tender options for when you combine Verified Return with Web Order Return in the same transaction
 *===================================================================
 */

package caw.pos.register.returns.visibilityrules;

import java.util.List;

import javax.inject.Inject;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.register.returns.ReturnType;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * Check CREDIT/DEBIT/SHOPPING PASS/GS VISA NOW.
 * If these tender is voided, do not show it in Tender Option screen
 * BZ26503/BZ26558/BZ26650/BZ27921
 */
public class CawCheckCreditDebitVoidFlagVisibilityRule
        extends AbstractVisibilityRule {

    /**
     * 
     */
    private static final String DTV_CLASS_NAME = "dtv.xst.dao.ttr.impl.CreditDebitTenderLineItem";

    @Inject
    private ReturnManager       _returnMgr;

    @Inject
    protected TransactionScope  _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        boolean hasBlind = false;
        boolean hasUnverified = false;
        boolean hasVerified = false;

        //Transaction is null. DENY
        IRetailTransaction currentTrans = getCurrentRetailTransaction();
        if (currentTrans == null) {
            return AccessLevel.DENIED;
        }

        //Check current transaction if it contains multiple return type.
        for (ISaleReturnLineItem saleLine : currentTrans
                .getLineItems(ISaleReturnLineItem.class)) {
            if ((saleLine.getReturn()) && (!saleLine.getVoid())) {

                if (ReturnType.BLIND.matches(saleLine.getReturnTypeCode())) {
                    hasBlind = true;
                } else if (ReturnType.UNVERIFIED
                        .matches(saleLine.getReturnTypeCode())) {
                    hasUnverified = true;
                } else if (ReturnType.VERIFIED
                        .matches(saleLine.getReturnTypeCode())) {
                    hasVerified = true;
                }
            }
        }

        //In the priority: Xstore will return the result configured in TND_TNDR_AVAILABILITY table.
        if (hasBlind) {
            return AccessLevel.GRANTED;
        } else if (hasUnverified) {
            return AccessLevel.GRANTED;
        } else if (hasVerified) {
            boolean isVoid = false;
            String className = null;
            ITenderLineItem tender = null;
            List<IRetailTransactionLineItem> tenderList = null;
            List<IRetailTransaction> origTrans = _returnMgr
                    .getAllOrigTransaction();
            if (null != origTrans && !(origTrans.isEmpty())) {
                for (IRetailTransaction retailTrans : origTrans) {
                    tenderList = retailTrans.getTenderLineItems();
                    for (IRetailTransactionLineItem retailTransLineItem : tenderList) {
                        if (retailTransLineItem instanceof ITenderLineItem) {
                            tender = (ITenderLineItem) retailTransLineItem;
                            className = tender.getClassName();
                            isVoid = tender.getVoid();
                            if (!isVoid && (className
                                    .equalsIgnoreCase(DTV_CLASS_NAME))) {
                                return AccessLevel.GRANTED;
                            }
                        }
                    }
                }
            }
        }
        return AccessLevel.DENIED;
    }
}
