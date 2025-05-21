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
 * Req/Bug ID#          ddMMyy    Description
 * BZ26313              210518    [QAS] Undo change button should be an Esc button.
 *===================================================================
 */

package caw.pos.customer;

import dtv.pos.customer.wishlist.op.RemoveWishListItemsOfCustomerOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * This class is used to check null on transaction
 */
public class CawRemoveWishListItemsOfCustomerOp
        extends RemoveWishListItemsOfCustomerOp {

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        IPosTransaction trans = _transactionScope.getTransaction();
        if (trans != null) {
            super.handleOpExec(argEvent);
        }

        return HELPER.completeResponse();
    }
}
