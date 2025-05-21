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
 * BZ27248          230818     Warranty Items from S&I are not associated with the items covered
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.util.CompositeObject.TwoPiece;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.IWarrantyItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawWorkOrderReAddItemOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderReAddItemOp.class);

    @Override
    public boolean isOperationApplicable() {

        List<String> removeItems = _transactionScope
                .getValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY);

        if (removeItems != null && removeItems.size() > 0) {
            return true;
        }

        return false;
    }

    @Inject
    private WorkOrderHelper _workOrderHelper;

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            IWorkOrderAccount account = _workOrderHelper
                    .getCurrentWorkOrderAccount();
            List<String> removeItems = _transactionScope
                    .getValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY);

            if (account != null) {
                ISaleReturnLineItem lineItem = null;
                List<ICustomerItemAccountDetail> listDetails = account
                        .getCustItemAccountDetails();
                // Void old item
                for (ICustomerItemAccountDetail detailLine : listDetails) {
                    if (detailLine
                            .getRetailLineItem() instanceof ISaleReturnLineItem) {
                        lineItem = (ISaleReturnLineItem) detailLine
                                .getRetailLineItem();

                        if (lineItem != null
                                && removeItems.contains(lineItem.getItemId())) {
                            lineItem.setVoid(true);
                        }
                    }
                }
            }

            // Add new item
            @SuppressWarnings("unchecked")
            Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> warrantyItems = _transactionScope
                    .getValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST);

            List<String> newItems = new ArrayList<String>();
            if (warrantyItems != null && warrantyItems.size() > 0) {

                for (Map.Entry<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> entry : warrantyItems
                        .entrySet()) {
                    if (entry.getValue() != null
                            && entry.getValue().getItemId() != null)
                        ;
                    newItems.add(entry.getValue().getItemId());
                }
            }

            if (newItems.size() > 0) {
                _transactionScope
                        .setValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY, newItems);
            }

        } catch (Exception ex) {
            _logger.error("Can not void work order line." + ex.getMessage());
        }

        return HELPER.completeResponse();
    }

}
