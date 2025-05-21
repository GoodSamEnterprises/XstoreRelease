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
 * BZ26289          110718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27414          300818    [Internal]House account payment receipt printed unexpectedly when doing sale transaction.
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import java.util.List;

import dtv.pos.hardware.rcptbuilding.copyrules.TransactionTypeRule;
import dtv.pos.houseaccount.model.CustomerConsumerChargeAcctModel;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawRcptHouseAccountPaymentRule
 */
public class CawRcptHouseAccountPaymentRule extends TransactionTypeRule {

    private String transactionTypeCode_;

    public CawRcptHouseAccountPaymentRule() {

        super();
        transactionTypeCode_ = "HOUSE_ACCOUNT";
    }

    /**
     * Validate that the rule is applied when 
     * 1. Tender Control Transaction
     * 2. Paid out Type (Declared type="PAID_OUT" at ReceiptCopyRule tab in rcptConfig.xml
     * 3. Reason Code is determined for Purchase of Used Firearm
     */
    @Override
    protected boolean doesRuleApply(Object argSource) {

        // Begin BZ27414
        ISaleReturnLineItem returnLineItem = null;
        // End BZ27414

        if (argSource instanceof CustomerConsumerChargeAcctModel) {
            IPosTransaction pos = ((CustomerConsumerChargeAcctModel) argSource)
                    .getCurrentTransaction();
            List<IRetailTransactionLineItem> tranLineItems = pos
                    .getRetailTransactionLineItems();

            for (IRetailTransactionLineItem lineItem : tranLineItems) {

                if (lineItem instanceof ISaleReturnLineItem
                        && !lineItem.getVoid()) {// BZ27414: Add more condition ->!lineItem.getVoid()
                    // Begin BZ27414
                    returnLineItem = (ISaleReturnLineItem) lineItem;
                    if (returnLineItem.getCustomerAccountModifier() != null
                            && transactionTypeCode_.equals(returnLineItem
                                    .getCustomerAccountModifier()
                                    .getCustAccountCode())) {
                        return true;
                    }
                    // End BZ27414
                }
            }
        }

        if (argSource instanceof IRetailTransaction) {
            List<IRetailTransactionLineItem> tranLineItems = ((IRetailTransaction) argSource)
                    .getRetailTransactionLineItems();

            for (IRetailTransactionLineItem lineItem : tranLineItems) {
                if (lineItem instanceof ISaleReturnLineItem
                        && !lineItem.getVoid()) {// BZ27414: Add more condition ->!lineItem.getVoid()
                    // Begin BZ27414
                    returnLineItem = (ISaleReturnLineItem) lineItem;
                    if (returnLineItem.getCustomerAccountModifier() != null
                            && transactionTypeCode_.equals(returnLineItem
                                    .getCustomerAccountModifier()
                                    .getCustAccountCode())) {
                        return true;
                    }
                    // End BZ27414
                }
            }
        }
        return false;
    }

    /**
     * @return the transactionTypeCode
     */
    public String getTransactionTypeCode() {

        return transactionTypeCode_;
    }

    /**
     * @param argTransactionTypeCode the transactionTypeCode to set
     */
    public void setTransactionTypeCode(String argTransactionTypeCode) {

        transactionTypeCode_ = argTransactionTypeCode;
    }

}
