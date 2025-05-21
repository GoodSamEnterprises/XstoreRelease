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
 * BZ26207          190718    New Requirement - Enable Work Order Functionality
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.customer.account.ICustomerAccountType;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.pos.hardware.rcptbuilding.copyrules.CustomerAccountTypeRule;
import dtv.xst.dao.trl.*;

/**
 * Turn off normal sale receipt (customer, store) while doing work order.
 */
public class CawDisableRcptForAccountRule extends CustomerAccountTypeRule {

    private static final Logger  logger_          = LogManager
            .getLogger(CawDisableRcptForAccountRule.class);

    private static final String  TYPE_PARAMETER   = "TYPE";

    private ICustomerAccountType custAccountType_ = null;

    /*
     * Input kind of account.
     * @see dtv.pos.hardware.rcptbuilding.copyrules.CustomerAccountTypeRule#setParameter(java.lang.String, java.lang.Object)
     */
    @Override
    public void setParameter(String argName, Object argValue) {

        if (TYPE_PARAMETER.equalsIgnoreCase(argName)) {
            this.custAccountType_ = CustomerAccountType
                    .forName(argValue.toString());
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /* 
     * Turn off normal sale receipt (customer, store) while doing 'Input kind of account'.
     * @see dtv.pos.hardware.rcptbuilding.copyrules.CustomerAccountTypeRule#doesRuleApply(java.lang.Object)
     */
    @Override
    protected boolean doesRuleApply(Object argSource) {

        if (this.custAccountType_ == null) {
            logger_.warn("Customer account type is null");
        } else if (argSource instanceof IRetailTransactionModel) {
            List<ISaleReturnLineItem> lineItems = ((IRetailTransactionModel) argSource)
                    .getLineItems(ISaleReturnLineItem.class);

            for (ISaleReturnLineItem item : lineItems) {

                if (!item.getVoid()) {
                    ICustomerItemAccountModifier account = item
                            .getCustomerAccountModifier();

                    if (account != null && account.getCustAccountCode()
                            .equals(custAccountType_.getName())) {
                        return Boolean.FALSE;
                    }
                }
            }
        }
        return Boolean.TRUE;
    }
}
