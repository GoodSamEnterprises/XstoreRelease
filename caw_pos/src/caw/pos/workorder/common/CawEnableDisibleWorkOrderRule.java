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
 * BZ33136          191119    [Prod] Issue with GS Visa credit card applications during work orders 
 *===================================================================
 */

package caw.pos.workorder.common;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.spring.ValueKeys;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawEnableDisibleWorkOrderRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Inject
    private WorkOrderHelper    _workOrderHelper;
    
    private CawCustomerGSHelper _gsHelper = CawCustomerGSHelper.getInstance();/*BZ33136*/

    /* When work order button enable or disable.
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#checkVisibilityImpl()
     */
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        IRetailTransaction trans = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);
        IParty iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();
        Boolean isWOTrans = _transactionScope
                .getValue(CawValueKeys.IS_WORK_ORDER_TRANS);//wo352-get

        //This block code handle case: at the beginning, if item(s) is added to transaction then
        //work order button disable. And then if all item(s) voided, work order button enable again.
        if (trans != null && iParty != null && account == null
                && isWOTrans == null) {
            List<IRetailTransactionLineItem> lineItems = trans
                    .getRetailTransactionLineItems();
            ISaleReturnLineItem lineItem = null;

            if (lineItems != null && lineItems.size() > 0) {
                int size = lineItems.size();

                for (int i = 0; i < size; i++) {

                    if (lineItems.get(i) instanceof ISaleReturnLineItem) {
                        lineItem = (ISaleReturnLineItem) lineItems.get(i);

                        if (!lineItem.getVoid()) {
                            return AccessLevel.DENIED;
                        }
                    }
                }
            }
        }

        //Disable button:
        //No customer
        //After remove customer
        //Perform Purchase Used Firearm
        //Work order account exist
        //In a work order transactions
        if (_gsHelper.getApplicationStatus() == 1 /*BZ33136*/
                || (trans == null && iParty == null)
                || (trans != null && iParty == null)
                || (trans == null && iParty != null) || (account != null)
                || (isWOTrans != null && isWOTrans.booleanValue() == true)) {
            return AccessLevel.DENIED;
        }

        return AccessLevel.GRANTED;
    }

}
