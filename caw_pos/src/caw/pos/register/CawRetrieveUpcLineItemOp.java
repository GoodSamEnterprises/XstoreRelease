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
 * BZ26270          290618    New Requirement - Display UPC on both Xstore screens and on receipts
 *===================================================================
 */
package caw.pos.register;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IReversibleOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.ISaleReturnLineItem;

public class CawRetrieveUpcLineItemOp
        extends Operation implements IReversibleOp {

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        ISaleReturnLineItem lineItem = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        //IItem item = getScopedValue(ValueKeys.CURRENT_ITEM);
        CawUPCHelper.getInstance().addUpc(lineItem);
        return HELPER.completeResponse();
    }

    @Override
    public IOpResponse handleOpReverse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }

}
