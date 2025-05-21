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

import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.op.AbstractIteratingOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.xom.IOrderLine;

public class CawPartialUpdateOrderItemIteratingOp extends AbstractIteratingOp<IOrderLine> {

    @Override
    protected List<IOrderLine> getObjects(IXstEvent argEvent) {
        return this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
    }

    @Override
    protected IOpResponse handleObject(IXstEvent argEvent, IOrderLine argOrderLine) {
        this.setScopedValue(CawValueKeys.CURRENT_ORDER_LINE_DETAIL, argOrderLine);
        return super.handleObject(argEvent, argOrderLine);
    }
}
