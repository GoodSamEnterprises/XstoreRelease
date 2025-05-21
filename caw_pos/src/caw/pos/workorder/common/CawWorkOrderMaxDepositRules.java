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
 * BZ27005          020818    [1.6.2] Should be displayed deposit amount screen instead of WO Options when selecting 'OK' on Overtender screen
 * BZ27208          160818    [Updated Requirement] Update Work Order Deposit Minimum to one cent (0.01) instead of zero (0.00)
 * BZ29311          150219    [3.1][Internal] WO deposit is unable to proceed when WO amount due is $0.00
 *===================================================================
 */

package caw.pos.workorder.common;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.pos.common.CawConfigurationMgr;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.ICustomerItemAccount;

/**
 *
 */
public class CawWorkOrderMaxDepositRules extends PromptOp {

    @Inject
    private CustomerAccountHelper _accountHelper;

    private Boolean               isOver = null;

    /* 
     * Get Validate Prompt
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_WORK_ORDER_VALIDATION_ERROR_MESSAGE");
    }

    /* 
     * Only run if Deposit amount > Total amount or Deposit amount < configure minimum amount.
     */
    @Override
    public boolean isOperationApplicable() {

        ICustomerItemAccount account = _accountHelper
                .getCurrentAccount(getScopedValue(ValueKeys.CURRENT_ACCOUNT_TYPE));
        final BigDecimal deposit = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);
        BigDecimal minDepositAmount = CawConfigurationMgr
                .getMinimumDepositAmount(); //BZ27208
        BigDecimal totalNewItemAmt = account.getActiveAccountTotal();
        /* BEGIN BZ29311 */
        if(totalNewItemAmt.compareTo(BigDecimal.ZERO)==0){
            return Boolean.FALSE;
        }else {
         // Begin BZ27208
            if (deposit.compareTo(minDepositAmount) < 0) {
                isOver = Boolean.FALSE;
                return !isOver;
            }

            if (deposit.compareTo(totalNewItemAmt) > 0) {
                isOver = Boolean.TRUE;
                return isOver;
            }
            // End BZ27208
        }
        /* END BZ29311 */
        return Boolean.FALSE;
    }

    /* 
     * Display prompt's message.
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[1];
        // Begin BZ27208
        if (isOver == Boolean.TRUE) {
            args[0] = _ff
                    .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_MAX_DEPOSIT);
        } else {
            BigDecimal minDepositAmount = CawConfigurationMgr
                    .getMinimumDepositAmount(); //BZ27208
            args[0] = _ff.getSimpleFormattable(String.format(_ff
                    .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_MIN_DEPOSIT)
                    .toString(), minDepositAmount.toString()));
        }
        // End BZ27208
        return args;
    }
}
