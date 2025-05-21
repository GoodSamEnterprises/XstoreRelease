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
 * BZ46798          151021    [Internal] Performing partial reject back to back will force the user to restart Xstore * 
 *===================================================================
 */

package caw.pos.order.maint;

import java.util.Comparator;

import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawOrderLineComparator implements Comparator<IOrderLine> {

    @Override
    public int compare(IOrderLine argLine1, IOrderLine argLine2) {

        return argLine1.getSequence() - argLine2.getSequence();
    }

}
