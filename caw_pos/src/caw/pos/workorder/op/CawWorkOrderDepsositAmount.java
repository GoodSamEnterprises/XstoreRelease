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
 * BZ27068          080818    [1.6.4] Cannot complete Work Order Refund for the selected Work Order with status: OPEN
 *===================================================================
 */

package caw.pos.workorder.op;

import java.math.BigDecimal;

import dtv.pos.customer.account.type.CustomerItemAccountDetailType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawWorkOrderDepsositAmount extends Operation {

    /* Set deposit amount.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {

        setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, BigDecimal.ZERO);
        setScopedValue(ValueKeys.CURRENT_ACCOUNT_DETAIL_TYPE, CustomerItemAccountDetailType.DEPOSIT);
        return HELPER.completeResponse();
    }

}
