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
 * BZ27378          280818    [1.6.15] WO Complete the deposited WO doesn't look up the work order from S&I
 * BZ46429          281021    [PROD] Work Order Prepay and Complete Issue
 *===================================================================
 */

package caw.pos.workorder.pickup;

import java.math.BigDecimal;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderEBSQueryResult;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.data2.access.DataFactory;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.pos.workorder.pickup.AddWorkOrderPickupTenderOp;
import dtv.xst.dao.cat.ICustomerItemAccount;
import dtv.xst.dao.cwo.IWorkOrderAccount;

/**
 *
 */
public class CawAddWorkOrderPickupTenderOp extends AddWorkOrderPickupTenderOp {

    @Inject
    protected WorkOrderHelper _workOrderHelper;

    /* Retrieve last deposit amount for this work order account.
     * @see dtv.pos.workorder.pickup.AddWorkOrderPickupTenderOp#getTenderAmount(dtv.xst.dao.cat.ICustomerItemAccount)
     */
    @Override
    protected BigDecimal getTenderAmount(ICustomerItemAccount argArgAccount) {

        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);

        IWorkOrderAccount currentAccount = _workOrderHelper
                .getCurrentWorkOrderAccount();
        IWorkOrderAccount accountOnDB = (IWorkOrderAccount) CawWorkOrderHelper
                .getInstance().retrieveAccount(workOrderResult);
        BigDecimal depositAmount = BigDecimal.ZERO;
        //Retrieve last deposit amount for work order account.
        
        if (accountOnDB != null) {
            if (currentAccount != null) {
                depositAmount = accountOnDB.getActiveAccountPayments();
            }
            
            /* BEGIN BZ46429 */
            if (depositAmount == null || depositAmount.equals(BigDecimal.ZERO)) {
                 accountOnDB.setActiveAccountPayments(workOrderResult.getWoDepositAmt());
                 accountOnDB.setAccountPayments(workOrderResult.getWoDepositAmt());
                 
                 accountOnDB.setActiveAccountTotal(workOrderResult.getWoTotalWithTax());
                 accountOnDB.setAccountTotal(workOrderResult.getWoTotalWithTax());
                 
                 DataFactory.makePersistent(accountOnDB);
                
                depositAmount = accountOnDB.getActiveAccountPayments();
            }
            /* END BZ46429 */
        }
        
        return depositAmount;
    }
}
