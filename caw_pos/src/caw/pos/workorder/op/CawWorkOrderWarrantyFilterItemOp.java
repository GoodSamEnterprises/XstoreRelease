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
 * BZ27248          210818    Warranty Items from S&I are not associated with the items covered
 * BZ29884          270319    [Prod] Work Order Issues- warranty item price was changed after import into xstore
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.*;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.warranty.WarrantyHelper;
import dtv.util.CompositeObject.TwoPiece;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.IWarrantyItem;

/**
 *
 */
public class CawWorkOrderWarrantyFilterItemOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderWarrantyFilterItemOp.class);

    @Inject
    private WarrantyHelper      _warrantyHelper;

    @Override
    public boolean isOperationApplicable() {

        CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);
        if (workOrderResult != null) {
            List<CawWorkOrderItem> itemList = workOrderResult.getWoItems();
            if (itemList != null && itemList.size() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            CawWorkOrderEBSQueryResult workOrderResult = _transactionScope
                    .getValue(CawValueKeys.CAW_WORK_ORDER_SELECTED_ACCOUNT);

            Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> warrantyItems;
            
            List<CawWorkOrderItem> woWarrantyItem = new ArrayList<>(); //  BZ29884
            warrantyItems = CawWorkOrderHelper.getInstance()
                    .moveWarrantyItemsOnly(workOrderResult, _warrantyHelper, woWarrantyItem);

            /* BEGIN BZ29884 */
            /**
             * The variable CawValueKeys.WO_WARRANTY_ITEMS uses store all warranty item of WO.
             * It is using in the class CawWorkOrderAddWarrantyItemOp.java
             */
            if (woWarrantyItem.size() > 0) {
                _transactionScope.setValue(CawValueKeys.WO_WARRANTY_ITEMS, woWarrantyItem);
            } else {
                clearScopedValue(CawValueKeys.WO_WARRANTY_ITEMS);
            }
            /* END BZ29884 */

            if (warrantyItems.size() > 0) {
                _transactionScope
                        .setValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST, warrantyItems);
            }
        } catch (Exception ex) {
            _logger.error("handleOpExec:" + ex.getMessage());
        }

        return HELPER.completeResponse();
    }
}
