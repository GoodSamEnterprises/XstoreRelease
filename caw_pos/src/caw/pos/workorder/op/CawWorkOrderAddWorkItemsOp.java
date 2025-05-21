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
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ29125          280119    Port 29014 to Release 3.0 - Work Order quantity does not import to Xstore if only 0500 item exists on the order
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.CollectionUtils;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderItem;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cwo.IWorkItem;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.itm.IItem;

/**
 *
 */
public class CawWorkOrderAddWorkItemsOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderAddWorkItemsOp.class);

    @Inject
    private WorkOrderHelper     _workOrderHelper;

    /* Add work item to current work order account
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();
        List<Map<IItem, CawWorkOrderItem>> partList2 = _transactionScope
                .getValue(CawValueKeys.PART_ITEM_LIST);//wo388429-get //BZ27192
        /*BEGIN BZ29125*/
        List<Map<IItem, CawWorkOrderItem>> taskItems2 = _transactionScope.getValue(CawValueKeys.TASK_ITEM_LIST);
        List<Map<IItem, CawWorkOrderItem>> workItems = partList2;
        if (CollectionUtils.isEmpty(workItems)) {
            workItems = taskItems2;
        }
        /*END BZ29125*/
        IItem itemLookedUp = null;
        IWorkItem workItem = null;

        if (account != null) {
            for (Map<IItem, CawWorkOrderItem> itemMap : workItems) {
                for (IItem item : itemMap.keySet()) {
                    itemLookedUp = ItemLocator.getLocator()
                            .lookupItem(item.getItemId());
                    if (itemLookedUp != null) {
                        workItem = _workOrderHelper
                                .createWorkItemFromItem(itemLookedUp, account);
                        account.addWorkItem(workItem);
                        break;
                    }
                }
                break;
            }
            _logger.debug("WO add work items to current work order.");
        } else {
            _logger.error("WO current work order is null.");
        }
        return HELPER.completeResponse();
    }
}
