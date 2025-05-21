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
 * BZ27257          200818    'HDE' screen is displayed when pressing 'ESC' on Work Order Options screen
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.trl.IRetailTransactionLineItem;

/**
 * The CawRemoveWorkOrderLineItemsOp class
 */
public class CawRemoveWorkOrderLineItemsOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawRemoveWorkOrderLineItemsOp.class);

    /** Get work order line items and void
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        List<ICustomerItemAccountDetail> listItemLine = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_LINE_ITEMS);

        if (listItemLine != null && !listItemLine.isEmpty()) {

            IRetailTransactionLineItem item = null;

            for (ICustomerItemAccountDetail lineItem : listItemLine) {

                if (lineItem != null) {

                    item = lineItem.getRetailLineItem();
                    // BZ27257 start
                    if (item != null) {
                        item.setVoid(Boolean.TRUE);
                    }
                    // BZ27257 end
                }
            }

        } else {
            _logger.error("WO list item line is null or empty.");
        }
        return HELPER.completeResponse();
    }
}
