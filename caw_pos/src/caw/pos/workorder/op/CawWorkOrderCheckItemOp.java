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
 * BZ26945          300718    Work Order Item Not On File screen title is incorrect
 * BZ27107          080818    [1.6.5][Internal] Item Quantity in S&I did not flow to Xstore for Work Order Transaction
 * BZ27084          080818    Work Order - No Line Items Help Desk Error
 * BZ27120          090818    [WorkOrder] Cross store prompt should be displayed when lookup any cross store workorder
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27253          150818    [WO] Some warranty items has been changed to non-warranty items
 * BZ31520          250619    [Port BZ31207 to 5.0][Work Order] clicking back after selecting a WO throws error message
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.*;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.register.ItemLocator;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.INonPhysicalItem;

/**
 *
 */
public class CawWorkOrderCheckItemOp extends PromptOp {

    private List<String>        _listNotOnFileItem = new ArrayList<>();

    private boolean             _woUnavailable     = false;

    private static final Logger _logger            = LogManager
            .getLogger(CawWorkOrderCheckItemOp.class);

    @Inject
    private WorkOrderHelper     _workOrderHelper;

    @Inject
    private IBusyState                     _busyState;//BZ31520

    /* If work order contain no item or item(s) not on file then run this Op.
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        _woUnavailable = false;

        //Step1: WO if work order contains no item(s) then show message.
        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);

        if (workOrderResult == null) {
            _woUnavailable = true;
            return Boolean.TRUE;
        }

        List<CawWorkOrderItem> itemList = workOrderResult.getWoItems();
        if (itemList == null || itemList.size() == 0) {
            return Boolean.TRUE;
        }

        //Step2: Handle WO Items
        boolean check = handleWoItems(itemList);
        if (!check) {
            _woUnavailable = true;
            return Boolean.TRUE;
        }

        //Step3 : check if WO items not on file
        if (!_listNotOnFileItem.isEmpty()) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /* Get prompt.
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        _busyState.endPermanent(); /*BZ31520*/
        return PromptKey.valueOf(CawWorkOrderConstants.CAW_WORK_ORDER_ERROR);
    }

    /* Show which message follow which reason make this Op run.
     * @see dtv.pos.framework.op.AbstractPromptOp#getPromptArgs(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[2];

        if (_woUnavailable) {
            args[0] = _ff.getTranslatable("_woUnavailable");
            args[1] = _ff.getTranslatable("_woUnavailableMsg");
            return args;
        }

        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
        if (workOrderResult != null) {
            // Begin BZ26945, BZ27084       
            List<CawWorkOrderItem> itemList = workOrderResult.getWoItems();
            if (itemList == null || itemList.size() == 0) {
                String woNumber = "";
                IWorkOrderAccount account = _workOrderHelper
                        .getCurrentWorkOrderAccount();
                if (account != null) {
                    woNumber = account.getCustAccountId();
                }
                //WO if work order contain no item(s) then show 'Missing Item' message.
                args[0] = _ff
                        .getSimpleFormattable(CawWorkOrderConstants.CAW_WORK_ORDER_MISSING_ITEM);
                args[1] = _ff.getSimpleFormattable(String.format(_ff
                        .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_MISSING_ITEM_MESSAGE)
                        .toString(), woNumber));
                return args;
            }

            //WO if work order contain item(s) not on file then show 'Item not on file' message.
            if (!_listNotOnFileItem.isEmpty()) {
                args[0] = _ff
                        .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_ITEM_NOT_ON_FILE);
                args[1] = _ff.getSimpleFormattable(String.format(_ff
                        .getTranslatable(CawWorkOrderConstants.CAW_WORK_ORDER_ITEM_NOT_ON_FILE_MESSAGE)
                        .toString(), String.join(", ", _listNotOnFileItem)));
                return args;
            }
            // End BZ26945
        }

        args[0] = _ff.getTranslatable("_woUnavailable");
        args[1] = _ff.getTranslatable("_woUnavailableMsg");
        return args;
    }

    /**
     * Split list of WO Items to Parts and Tasks
     * @param itemList
     * @return
     */
    boolean handleWoItems(List<CawWorkOrderItem> itemList) {

        boolean sucess = false;
        try {
            IWorkOrderAccount account = _workOrderHelper
                    .getCurrentWorkOrderAccount();
            // Begin BZ27192
            List<Map<IItem, CawWorkOrderItem>> taskItems2 = new ArrayList<>();
            List<Map<IItem, CawWorkOrderItem>> partItems2 = new ArrayList<>();
            // End BZ27192
            if (account != null) {
                //WO if work order contain item(s) not on file then show message.
                IItem item = null;
                INonPhysicalItem itemNonPhysical = null;
                String itemId = null;
                for (CawWorkOrderItem woItm : itemList) {
                    Map<IItem, CawWorkOrderItem> map = new HashMap<>();//BZ27192
                    itemId = woItm.getItemId();
                    item = CawWorkOrderHelper.getInstance()
                            .getWoItemOnFile(itemId);
                    if (item != null) {
                        if (CawWorkOrderConstants.NON_PHYSICAL
                                .equalsIgnoreCase(item.getItemTypeCode())) {
                            itemNonPhysical = (INonPhysicalItem) ItemLocator
                                    .getLocator().lookupItem(itemId);
                            // BEGIN BZ27253
                            if (itemNonPhysical
                                    .getNonPhysicalItemTypeCode() != null
                                    && !(itemNonPhysical
                                            .getNonPhysicalItemTypeCode()
                                            .equalsIgnoreCase(CawWorkOrderConstants.WARRANTY_TYPCODE))) {
                                itemNonPhysical
                                        .setNonPhysicalItemTypeCode(CawWorkOrderConstants.TASK);
                            }
                            //END BZ27253
                            itemNonPhysical.setListPrice(woItm.getQuantity());// BZ27107 added
                            map.put(itemNonPhysical, woItm);//BZ27192
                            taskItems2.add(map);
                        } else {
                            item.setListPrice(woItm.getQuantity());//BZ27107 added
                            map.put(item, woItm);//BZ27192
                            partItems2.add(map);
                        }

                    } else {
                        _listNotOnFileItem.add(itemId);
                    }
                }
                sucess = true;
            } else {
                _logger.info("handleWoItems-1: Current WO Account not found");
            }
            _transactionScope.setValue(CawValueKeys.TASK_ITEM_LIST, taskItems2);
            _transactionScope.setValue(CawValueKeys.PART_ITEM_LIST, partItems2);
        } catch (Exception ex) {
            _logger.error("handleWoItems-2", ex);
            sucess = false;
        }
        return sucess;
    }

}
