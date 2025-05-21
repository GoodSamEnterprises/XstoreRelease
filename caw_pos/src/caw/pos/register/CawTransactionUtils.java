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
 * BZ27924          231018    [Internal] Tender type of Return web order displayed incorrect when pressing 'Exit return' to do new return types trans
 *===================================================================
 */
package caw.pos.register;

import java.util.List;

import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * The class is used to define static methods
 * relating to common utilities for Retail transaction
 * or Functions relating to xStore packages.
 *
 */
public class CawTransactionUtils {

    //private static final Logger _logger = LogManager
    //        .getLogger(CawTransactionUtils.class);

    //Begin BZ27924
    /**
     * This method is used to check List Item Web Order with List current item transaction.
     * @param retailTrans
     * @param lineItmWebOrder
     * @return: true - in List item contains Item web order. False - list item doesn't contain any item web order
     */
    public static boolean isReturnWebOrder(IRetailTransaction retailTrans,
            List<ISaleReturnLineItem> lineItmWebOrder) {

        if (retailTrans != null
                && (lineItmWebOrder != null && !lineItmWebOrder.isEmpty())) {
            List<ISaleReturnLineItem> listItems = retailTrans
                    .getLineItems(ISaleReturnLineItem.class);
            for (ISaleReturnLineItem saleLine : listItems) {
                if ((saleLine.getReturn()) && (!saleLine.getVoid())) {
                    if (lineItmWebOrder.contains(saleLine)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //End BZ27924
}
