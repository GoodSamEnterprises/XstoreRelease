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
 * BZ46879          221021    Xstore Patch 16 Receipt Issues
 *===================================================================
 */

package caw.pos.order;


import caw.pos.common.CawConstants;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.ProcessItemsToPickupOp;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.xom.impl.order.OrderStatus;

/**
 *
 */
public class CawProcessItemsToPickupOp extends ProcessItemsToPickupOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        IPosTransaction transaction = this.getTransaction();
        if(transaction != null) {
            transaction.setStringProperty(CawConstants.CAW_ORDER_TYPE, OrderStatus.COMPLETE.getCode());
        }
        return super.handleOpExec(argEvent);
    }
}
