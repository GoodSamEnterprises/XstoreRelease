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
 * BZ26971          310718    [26289] House account payment transaction is not eligible to be suspended transaction when backing to Sale screen from Tender Option list
 * BZ27287          210818    [1.6.11] WO Redirect the WO refund to tender option screen to prevent adding the new items
 * BZ27379          120918    [1.6.15] WO Xstore reflects the discount incorrectly for the WO line item
 *===================================================================
 */

package caw.pos.tender;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.PromptRollbackTenderOp;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawPromptRollbackTenderOp class
 */
public class CawPromptRollbackTenderOp extends PromptRollbackTenderOp {

    /**
     * The SALE_ITEM_START
     */
    private static final String SALE_ITEM_START = "SALE_ITEM_START";

    /**
     * Gets the rollback response.
     *
     * @return the rollback response
     */
    @Override
    protected IOpResponse getRollbackResponse() {

        if (_transactionScope != null) {
            IPosTransaction pos = _transactionScope.getTransaction();
            IParty cust = _transactionScope
                    .getValue(ValueKeys.SELECTED_CUSTOMER);
            // BZ27287 start
            if (pos != null && cust != null) {

                if ((CawCustomerUtil.isWhslCustomer(cust)
                        && CawCustomerUtil.isHouseAccountPayment(pos))) {
                    return HELPER.getStartChainResponse(OpChainKey
                            .valueOf(SALE_ITEM_START));
                }

                //BZ27379 added condition for WO refund status
                if (CawWorkOrderHelper.getInstance()
                        .isWorkOrderRedundStatus(pos)) {
                    return HELPER.getStartChainResponse(OpChainKey
                            .valueOf(SALE_ITEM_START));
                }
            }
            // BZ27287 end
        }
        return super.getRollbackResponse();
    }
}
