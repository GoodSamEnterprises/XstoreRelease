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
 * BZ30267          180419    [New_Requirement] CW wants to limit perform Manual Credit entry from Lead to higher roles up.
 * BZ30269          280519    [New-Requirement] For returns of warranty merchandise, add in the warranty override to this change - prompt for manager override
 *===================================================================
 */

package caw.pos.security.op;

import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.security.op.PromptIdPasswordFormOp;

/**
 * Override method handleDataAction()
 */
public class CawPromptIdPasswordFormOp extends PromptIdPasswordFormOp {

    /* BZ30267: Return Tender Option after pressing Back on Override Security Form
     * @see dtv.pos.framework.op.AbstractFormOp#handleDataAction(dtv.pos.iframework.action.IXstDataAction)
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        final IXstDataActionKey CANCEL_PROCESS = XstDataActionKey.valueOf("CANCEL_PROCESS");
        IXstActionKey key = argAction.getActionKey();
        if (CANCEL_PROCESS.equals(key)) {
            /*BEGIN BZ30269: handle for WO Refund*/
            if (CawWorkOrderOptionsOp.isRefundAction()) {
                return HELPER.getStartChainResponse(OpChainKey.valueOf("SALE_ITEM_START"));
            }
            /*END BZ30269: handle for WO Refund*/
            return handleExit();
        }
        return super.handleDataAction(argAction);
    }
}
