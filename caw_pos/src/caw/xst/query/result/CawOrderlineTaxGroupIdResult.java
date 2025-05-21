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
 * BZ38355          121020    [Internal] Pickup Order - The receipts are printed incorrectly when executing Pickup partial Order
 *===================================================================
 */

package caw.xst.query.result;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;

/**
 *
 */
public class CawOrderlineTaxGroupIdResult extends AbstractQueryResult {

    private static final long serialVersionUID = 1L;

    String                    taxGroupId;

    @Override
    protected IObjectId getObjectIdImpl() {

        return null;
    }

    public String getTaxGroupId() {

        return taxGroupId;
    }

    public void setTaxGroupId(String argTaxGroupId) {

        taxGroupId = argTaxGroupId;
    }
}
