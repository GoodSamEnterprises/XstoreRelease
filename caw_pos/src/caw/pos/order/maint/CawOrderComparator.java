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
 * BZ46879          221021    Xstore Patch 16 Receipt Issues
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.Comparator;

import dtv.xst.dao.xom.IOrderLine;
import dtv.xst.xom.impl.order.OrderStatus;

/**
 *
 */
public class CawOrderComparator implements Comparator<IOrderLine> {

    @Override
    public int compare(IOrderLine argLine1, IOrderLine argLine2) {
        if(OrderStatus.UNFULFILLABLE.matches(argLine1.getStatusCode()) 
                || OrderStatus.CANCELLED.matches(argLine1.getStatusCode()) ){
            return 1;
        }
        return -1;
    }
}
