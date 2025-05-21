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
 * BZ63225          230424    Issue with refunds from Work Order Completes
 *===================================================================
 */

package caw.pos.tender;

import java.math.BigDecimal;
import java.util.*;

import dtv.pos.tender.TenderAvailabilityCodeType;
import dtv.pos.tender.TenderHelper;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawTenderHelper extends TenderHelper{
    @Override
    public Collection<? extends ICreditDebitTenderLineItem> getUsableTendersFromOriginalTransactions(
            IRetailTransaction argCurrentTrans,
            List<IRetailTransaction> argOrigTransactions,
            Map<ICreditDebitTenderLineItem, ICreditDebitTenderLineItem> argOriginalRefMap) {

        Collection<? extends ICreditDebitTenderLineItem> origTransTenderLines = searchOriginalTransCreditTenderLineItems(argOrigTransactions);
        if (origTransTenderLines == null || origTransTenderLines.isEmpty())
            return Collections.emptyList();
        if (argOriginalRefMap != null) {
            List<ICreditDebitTenderLineItem> returnTransTenderLines = argCurrentTrans.getLineItems(ICreditDebitTenderLineItem.class);
            for (ICreditDebitTenderLineItem tenderLine : returnTransTenderLines) {
                if (!tenderLine.getVoid()) {
                    ICreditDebitTenderLineItem originalTenderLine = argOriginalRefMap.get(tenderLine);
                    if (originalTenderLine != null)
                        origTransTenderLines.remove(originalTenderLine);
                }
            }
        }
        List<ICreditDebitTenderLineItem> validTenderLines = new ArrayList<>(origTransTenderLines.size());

        for (ICreditDebitTenderLineItem origTransTenderLine : origTransTenderLines) {
            boolean stillValid = (!origTransTenderLine.getVoid()
                    && origTransTenderLine.getTender().containsAvailCode(TenderAvailabilityCodeType.RETURN_WITH_RECEIPT.getName()));

            if (stillValid)
                if (NumberUtils.isNonPositive(origTransTenderLine.getAmount()))
                    stillValid = false;
            if (stillValid) {
                List<ITenderLineItem> previousLines = getPreviousReturnTenderLines(origTransTenderLine);
                BigDecimal tenderedAmount = BigDecimal.ZERO;
                for (ITenderLineItem tndr : previousLines)
                    tenderedAmount = tenderedAmount.add((tndr.getAmount() != null) ? tndr.getAmount().abs() : BigDecimal.ZERO);
                if (origTransTenderLine.getAmount().compareTo(tenderedAmount) <= 0)
                    stillValid = false;
            }
            if (stillValid) {
                stillValid = false;
                long origTransTenderLineSeq = origTransTenderLine.getTransactionSequence();

                for (ISaleReturnLineItem returnedSaleLine : argCurrentTrans
                        .getLineItems(ISaleReturnLineItem.class)) {

                    if (!returnedSaleLine.getVoid()
                            && !returnedSaleLine.getReturnedWithGiftReceipt()
                            //&& returnedSaleLine.getOriginalTransactionSequence() == origTransTenderLineSeq
                            ) {
                        stillValid = true;
                        break;
                    }
                }
            }
            if (stillValid)
                validTenderLines.add(origTransTenderLine);
        }
        return validTenderLines;
    }
}
