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
 * BZ46798          151021    [Internal] Performing partial reject back to back will force the user to restart Xstore
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import dtv.data2.access.DataFactory;
import dtv.data2.access.IObjectId;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.order.maint.ValidateStatusHasNotChangedOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.xom.*;

/**
 *
 */
public class CawValidateStatusHasNotChangedOp extends ValidateStatusHasNotChangedOp {

    private static final PromptKey NOTIFY_DIFFERENT_PROMPT = PromptKey.valueOf("ORDER_VIEWED_ORDER_NOT_CURRENT");

    private final IOpState         POST_NOTIFY             = new OpState("POST_NOTIFY");
    
    private static final Logger _logger    = LogManager.getLogger(CawValidateStatusHasNotChangedOp.class);
    @Override
    protected IOpResponse handleComparison(IXstEvent argEvent) {

        IOrder modeledOrder = getScopedValue(ValueKeys.SELECTED_ORDER);
        boolean dbModelDifferent = false;

        OrderId modeledOrderId = (OrderId) modeledOrder.getObjectId();
        IOrder orderFromDb = (IOrder) DataFactory.getObjectById((IObjectId) modeledOrderId);

        if (orderFromDb.getOrderLines().size() != modeledOrder.getOrderLines().size() 
                || !orderFromDb.getStatusCode().equals(modeledOrder.getStatusCode())) {
            dbModelDifferent = true;
        } else {

            int size = modeledOrder.getOrderLines().size();

            CawOrderLineComparator lineComparator = new CawOrderLineComparator();
            List<IOrderLine> modeledLines = new ArrayList<IOrderLine>(modeledOrder.getOrderLines());
            List<IOrderLine> dbLines = new ArrayList<>(orderFromDb.getOrderLines());
            Collections.sort(modeledLines, lineComparator);
            Collections.sort(dbLines, lineComparator);
            for (int index = 0; index < size; index++) {
                IOrderLine modeledLine = modeledLines.get(index);
                IOrderLine dbLine = dbLines.get(index);
                _logger.debug("Order GUi: " + modeledLine.getItemId() + "-" + modeledLine.getSequence());
                _logger.debug("Order DB: " + dbLine.getItemId() + "-" + dbLine.getSequence());
                if (!modeledLine.getStatusCode().equals(dbLine.getStatusCode())) {
                    dbModelDifferent = true;
                    break;
                }
            }
        }
        if (dbModelDifferent) {
            setScopedValue(ValueKeys.SELECTED_ORDER, orderFromDb);
            setOpState(this.POST_NOTIFY);
            return this.HELPER.getPromptResponse(NOTIFY_DIFFERENT_PROMPT, new dtv.i18n.IFormattable[0]);
        }
        return this.HELPER.completeResponse();
    }
}
