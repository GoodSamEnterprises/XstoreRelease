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
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.Iterator;
import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.op.AbstractPromptReasonCodeOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.dao.xom.IOrderLine;
import dtv.xst.xom.impl.order.OrderLineStatus;

/**
 *
 */
public class CawPromptRejectOrderReasonOp extends AbstractPromptReasonCodeOp {
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        IOpResponse resp = super.handlePromptResponse(argEvent);
        if (resp != null && resp.getOpStatus().isComplete()) {
            IOrder currentOrder = getScopedValue(ValueKeys.SELECTED_ORDER);
            IReasonCode reasonCode = getScopedValue(ValueKeys.SELECTED_REASON_CODE);
            List<IOrderLine> orderLines = this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
            if (reasonCode != null) {
                Iterator<IOrderLine> it = null;
                if(orderLines != null && orderLines.size() > 0) {
                    it = orderLines.iterator();
                }else {
                    it = currentOrder.getOrderLines().iterator();
                }
                while (it.hasNext()) {
                    IOrderLine orderLine = it.next();
                    if (!OrderLineStatus.CANCELLED.matches(orderLine.getStatusCode())) {
                        orderLine.setStatusCodeReason(reasonCode.getReasonCode());
                        orderLine.setStatusCodeReasonNote(reasonCode.getDescription());
                    }
                }
                currentOrder.setStatusCodeReason(reasonCode.getReasonCode());
                currentOrder.setStatusCodeReasonNote(reasonCode.getDescription());
            }
            DataFactory.makePersistent(currentOrder);
            return this.HELPER.completeResponse();
        }else {
            return resp;
        }
    }

    @Override
    public boolean isOperationApplicable() {
        return ConfigurationMgr.showPromptRejectOrderReasonCode();
    }
}
