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
 * BZ36863          280720    [PROD] Duplicate receipts for all returns/exchanges 
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import java.util.List;

import dtv.pos.hardware.rcptbuilding.copyrules.RefundRule;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawRefundRule extends RefundRule{

    @Override
    protected boolean doesRuleApply(Object argSource) {
        if (argSource instanceof IPosTransaction) {
            IPosTransaction tran = (IPosTransaction) argSource;
            // BEGIN BZ36863
            List<ISaleReturnLineItem> lineItems = tran.getLineItems(ISaleReturnLineItem.class);
            for (ISaleReturnLineItem item : lineItems) {
                if (item.getReturn()) {
                   return true;
                }
            }
            // END BZ36863
        }
        
        return super.doesRuleApply(argSource);
    }

}
