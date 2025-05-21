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
 * BZ26270          060718    New Requirement - Display UPC on both Xstore screens and on receipts
 *===================================================================
 */
package caw.pos.register.returns.verification;

import caw.pos.register.CawUPCHelper;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.verification.UpdateVerifiedReturnLineOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * An operation responsible for transferring relevant data from the original line item being returned to the
 * new line item representing it in the current transaction.<br>
 */
public class CawUpdateVerifiedReturnLineOp extends UpdateVerifiedReturnLineOp {

    /**
     * Copies properties from the original line item 
     * to the return line item and modifies them as necessary.
     *
     * @param argEvent unused.
     * @return Complete, always.
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        //BEGIN BZ26270
        ISaleReturnLineItem origLine = getScopedValue(ValueKeys.ORIGINAL_SALE_LINE);
        ISaleReturnLineItem returnLine = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        if (returnLine != null && origLine != null) {
            if (returnLine.getScannedItemId() == null) {
                returnLine.setScannedItemId(origLine.getScannedItemId());
            }
            CawUPCHelper.getInstance().addUpc(returnLine);
        }
        //END BZ26270

        return super.handleOpExec(argEvent);
    }
}
