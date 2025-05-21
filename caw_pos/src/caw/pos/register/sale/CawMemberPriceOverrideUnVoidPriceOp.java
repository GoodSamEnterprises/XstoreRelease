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
 * BZ25115          020518    New Requirement - Add a Member Price Override Function to the POS Sale screen
 *===================================================================
 */

package caw.pos.register.sale;

import java.util.ArrayList;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.IRetailTransactionLineItem;

/**
 *
 */
public class CawMemberPriceOverrideUnVoidPriceOp extends Operation {

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        ArrayList<IRetailTransactionLineItem> listVoidLineItems = getScopedValue(CawValueKeys.LIST_VOID_LINEITMS);

        if (listVoidLineItems == null || listVoidLineItems.isEmpty()) {
            setScopedValue(CawValueKeys.LIST_VOID_LINEITMS, new ArrayList<IRetailTransactionLineItem>());
            return HELPER.completeResponse();
        }
        int size = listVoidLineItems.size();

        for (int i = 0; i < size; i++) {
            listVoidLineItems.get(i).setVoid(false);
        }
        setScopedValue(CawValueKeys.LIST_VOID_LINEITMS, new ArrayList<IRetailTransactionLineItem>());
        return HELPER.completeResponse();
    }

}
