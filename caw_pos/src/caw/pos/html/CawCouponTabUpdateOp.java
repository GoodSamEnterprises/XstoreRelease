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
 * BZ53626          181122    [UAT] After voiding loyalty offer, offers tab still shows offer as applied. 
 *===================================================================
 */

package caw.pos.html;

import java.util.Optional;

import javax.inject.Inject;

import dtv.pos.framework.op.Operation;
import dtv.pos.framework.ui.model.InfoTabHelper;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawCouponTabUpdateOp extends Operation {

    @Inject
    private Optional<InfoTabHelper> _tabHelper;

    private static final String     TRANSACTION_COUPONS = "TRANSACTION_COUPONS";

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent arg0) {

        _tabHelper.get().setTabUpdated(TRANSACTION_COUPONS); 
        return this.HELPER.completeResponse();
    }
}
