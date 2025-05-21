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
 * BZ25318          300118    Missing Club information on top banner when sale/return transaction in offlined case.
 *===================================================================
 */

package caw.pos.customer;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;

/**
 * BZ 25318: get StringValue from CRM_PARTY_ID_XREF_P table 
 */
public class CawCustomerPartyIdXrefQueryResult extends AbstractQueryResult {

    private static final long serialVersionUID = 1L;

    private String            _stringValue     = null;

    /**
     * @return the stringValue
     */
    public String getStringValue() {

        return _stringValue;
    }

    /**
     * @param argStringValue the stringValue to set
     */
    public void setStringValue(String argStringValue) {

        _stringValue = argStringValue;
    }

    @Override
    protected IObjectId getObjectIdImpl() {

        return null;
    }
}
