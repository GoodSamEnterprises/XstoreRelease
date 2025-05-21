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
 * BZ37884          180920    Disable extra Customer Copy & Store Copy of printed receipt for Brokered Order Transactions
 * BZ37971          210920    [Internal] Order Pickup - There is no place on the Store Copy of receipt to sign if signature is not captured on Pin Pad
 * BZ38025          220920    [Internal] Order Pickup - Needing to print both Order Customer Copy and Store Copy
 * BZ38051          020120    [Task] Need to modify receipt to display both Sale/Returned items and Order items when create an Order transaction into Xstore.
 *===================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;


import javax.inject.Inject;

import caw.pos.order.CawOrderHelper;
import caw.tenderauth.impl.eigen.CawEigenMgr;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;
import dtv.pos.order.OrderReceiptSource;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderStatus;
import dtv.xst.xom.impl.order.OrderType;
public class CawDisableOrderRule extends AbstractRcptCopyRule {
    
    //BEGIN BZ38025
    @Inject
    private CawEigenMgr         _cawEigenMgr;

    public CawDisableOrderRule() {
        super();
        InjectionHammer.forceAtInjectProcessing(this);
    }
    //END BZ38025
    
    @Override
    protected boolean doesRuleApply(Object argSource) {

        boolean isRun = true;
        IRetailTransaction retailTrans = null;
        IOrder currentOrder = null; 
        
        if (argSource instanceof IRetailTransaction) {
            retailTrans = (IRetailTransaction) argSource;
            if (CawOrderHelper.getInstance().isOrderTransaction(retailTrans)) {
                isRun = false;
                //BEGIN BZ38051
                if (CawOrderHelper.getInstance().isOrderCreateMixedTransaction(retailTrans)) {
                    isRun = true;
                }
                //END BZ38051
            }
        } else if (argSource instanceof OrderReceiptSource) {
            //BEGIN BZ37971
            currentOrder = ((OrderReceiptSource) argSource).getOrder();
            
            if (currentOrder != null) {
                if (!(OrderType.STANDARD_PICKUP.matches(currentOrder.getOrderType())
                       && OrderStatus.READY_FOR_PICK_UP.matches(currentOrder.getStatusCode()) )) {
                    isRun = false;
                }
                //BEGIN BZ38025
                else if (_cawEigenMgr.getSigCap() != null) {
                    isRun = false;
                    //Check singed to not print receipt
                }
                //END BZ38025
            }
            //END BZ37971
        }

        return isRun;
    }
}
