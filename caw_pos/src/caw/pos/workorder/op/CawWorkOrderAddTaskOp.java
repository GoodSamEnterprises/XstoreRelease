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
 * BZ27107          080818    [1.6.5][Internal] Item Quantity in S&I did not flow to Xstore for Work Order Transaction
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27286          210818    Work Order Deposit - Discount for Elite Customer not coming from S&I
 * BZ27712          121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ29205          280119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ30154          190619    [New Requirement] Xstore capture the Work Order line items' sale associate from S&I and forward it to Order Service as part of item attribute
 *===================================================================
 */

package caw.pos.workorder.op;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.*;
import twitter4j.JSONObject;

import dtv.hardware.types.HardwareType;
import dtv.pos.common.OpChainKey;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.customer.account.type.CustomerItemAccountDetailType;
import dtv.pos.employee.IEmployeeHelper;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.PartyId;
import dtv.xst.dao.cwo.IWorkOrderLineItem;
import dtv.xst.dao.hrs.IEmployee;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.SaleItemType;

/**
 *
 */
public class CawWorkOrderAddTaskOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderAddTaskOp.class);
    
    /*BEGIN BZ30154*/
    @Inject
    private IEmployeeHelper _employeeHelper; 
    @Inject
    private CustomerHelper      _customerHelper;
    /*END BZ30154*/

    /* Add task item to current work order
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        List<Map<IItem, CawWorkOrderItem>> taskItems2 = _transactionScope
                .getValue(CawValueKeys.TASK_ITEM_LIST);//BZ27192

        if (taskItems2 != null && !taskItems2.isEmpty()) {
            IWorkOrderLineItem woli = null;

            BigDecimal qty = null;
            CawWorkOrderItem valEbsItm = null;
            String attributes = null;
            JSONObject property = null; //BZ29205
            String salesperson = null;/*BZ30154*/
            for (Map<IItem, CawWorkOrderItem> itemMap : taskItems2) {
                for (IItem item : itemMap.keySet()) {
                    woli = (IWorkOrderLineItem) ItemLocator.getLocator()
                            .getSaleLineItem(item, SaleItemType.WORK_ORDER, false, true, HardwareType.KEYBOARD);
                    valEbsItm = itemMap.get(item);
                    //Begin 27107
                    qty = valEbsItm.getQuantity();
                    woli.setQuantity(qty != null ? qty : BigDecimal.ONE);
                    //End 27107
                    //Begin BZ27192
                    woli.setForceZeroExtendedAmt(false);
                    setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, valEbsItm
                            .getUnitSellingPrice());
                    //End BZ27192
                    // BZ27286
                    setScopedValue(CawValueKeys.WO_LIST_DISCOUNT, valEbsItm
                            .getAdjAmount());
                    // BZ27286
                    woli.setInstructions(CawWorkOrderConstants.TASK);
                    woli.setPriceStatus(CawWorkOrderConstants.ACTUAL);
                    //Begin BZ27712: create line item property then add into line item.
                    attributes = valEbsItm.getAttributes();
                    if (attributes != null) {
                        setScopedValue(CawValueKeys.CAW_WO_ITEM_ATTRIBUTES, attributes);
                    }
                    //End BZ27712
                    /*BEGIN BZ29205*/
                    property = valEbsItm.getProperties();
                    if (property != null) {
                        setScopedValue(CawValueKeys.CAW_WO_ITEM_PROPERTIES, property);
                    }
                    /*END BZ29205*/
                    /*BEGIN BZ30154*/
                    salesperson = valEbsItm.getSalesPerson();
                    if (salesperson != null) {
                        final IEmployee cashier = (IEmployee) _stationState
                                .getSystemUser();

                        PartyId partyId = new PartyId();
                        String userId = _stationState.getSystemUser()
                                .getOperatorParty().getEmployeeId();
                        partyId.setPartyId(Long.parseLong(salesperson));
                        IParty party = _customerHelper
                                .searchPartyById(partyId, _stationState
                                        .getRetailLocationId(), userId) ;
                        List<IEmployee> commAssocs = new ArrayList<IEmployee>();
                        if (party != null) {
                            IEmployee employee = _employeeHelper
                                    .getEmployeeById(party.getEmployeeId());
                            commAssocs.add(employee);
                            setScopedValue(ValueKeys.SELECTED_COMMISSIONED_ASSOCS, commAssocs);
                        } else {

                            List<String> items = CawWorkOrderHelper
                                    .getInstance().getNotExist();
                            if (!items.contains(item.getItemId())) {
                                CawWorkOrderHelper.getInstance()
                                        .putToNotExist(item.getItemId());
                            }
                            commAssocs.add(cashier);
                            setScopedValue(ValueKeys.SELECTED_COMMISSIONED_ASSOCS, commAssocs);
                        }
                    }
                    /*END BZ30154*/
                    setScopedValue(ValueKeys.CURRENT_SALE_LINE, woli);
                    setScopedValue(ValueKeys.CURRENT_ACCOUNT_DETAIL_TYPE, CustomerItemAccountDetailType.TASK);
                    taskItems2.remove(itemMap);
                    _logger.debug("WO add task item to current work order.");
                    return HELPER.getWaitStackChainResponse(OpChainKey
                            .valueOf("ADD_WORK_ORDER_ITEM"));
                }
            }
        } else {
            _logger.info("WO task item(s) is empty.");
        }
        return HELPER.completeResponse();
    }
}
