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
 * BZ29625          080419    [New Requirement] - Auto-Renewal Item Specific Receipts
 * BZ32283          300719    [INTERNAL] Xstore log show warning
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.*;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.item.CawItemMessage;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.customer.account.ICustomerAccountMaintModel;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.StringUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.cwo.impl.WorkOrderLineItemModel;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawItemMessageCondition extends AbstractInvertableCondition {
    private static final Logger _logger = LogManager.getLogger(CawItemMessageCondition.class); //BZ32283

    @Inject
    private TransactionScope _transactionScope;

    public CawItemMessageCondition() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    protected boolean conditionMetImpl(Object argSource) {
        @SuppressWarnings("unchecked")
        Map<String, List<CawItemMessage>> mapItemMess = _transactionScope.getValue(CawValueKeys.CAW_MAP_ITM_MSG);

        if (CawWorkOrderOptionsOp.isRefundAction()) {
            return (mapItemMess != null);
        }
        boolean isHasMessage = false;
        List<IRetailTransactionLineItem> iRetailTransactionLineItems = new ArrayList<>();
        int lineItemSeq;
        String itemId = StringUtils.EMPTY;

        /*Sale, return, house account payment*/
        if (argSource instanceof IRetailTransaction) {
            iRetailTransactionLineItems = ((IRetailTransaction) argSource).getRetailTransactionLineItems();
        }
        /*Work order*/
        else if (argSource instanceof ICustomerAccountMaintModel) {
            iRetailTransactionLineItems = ((ICustomerAccountMaintModel) argSource).getCurrentTransaction()
                    .getRetailTransactionLineItems();
        }

        if (CollectionUtils.isNotEmpty(iRetailTransactionLineItems)) {

            for (IRetailTransactionLineItem iRetailTransactionLineItem : iRetailTransactionLineItems) {
                if ((iRetailTransactionLineItem instanceof ISaleReturnLineItem
                        || iRetailTransactionLineItem instanceof WorkOrderLineItemModel)
                        && (iRetailTransactionLineItem.getVoid())) {

                    itemId = ((ISaleReturnLineItem) iRetailTransactionLineItem).getItem().getItemId();
                    lineItemSeq = iRetailTransactionLineItem.getRetailTransactionLineItemSequence();
                    /* BEGIN BZ32283 */
                    if (!StringUtils.isEmpty(itemId) && lineItemSeq >= 0 
                        && mapItemMess!= null && mapItemMess.size() > 0) {
                        try {
                            mapItemMess.remove(itemId + CawConstants.CAW_COLON_SIGN + lineItemSeq);
                        } catch (Exception ex) {
                            _logger.debug("The method conditionMetImpl cannot remove line Item Seq." + ex.getMessage());
                        }
                    }
                    /* END BZ32283 */
                }
            }

            if (mapItemMess != null) {
                _transactionScope.setValue(CawValueKeys.CAW_MAP_ITM_MSG, mapItemMess);
                isHasMessage = true;
            }
        }
        return isHasMessage;
    }
}
