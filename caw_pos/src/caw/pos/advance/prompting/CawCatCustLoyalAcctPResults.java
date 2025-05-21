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
 * BZ24651          061217    Membership info under Customer section should be displayed <status> instead of <benefit name>
 *===================================================================
 */

package caw.pos.advance.prompting;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;
import dtv.xst.dao.cat.CustomerLoyaltyAccountPropertyId;

/**
 * This class is used to declare variable when doing query for get tender type is in credit card
 */
public class CawCatCustLoyalAcctPResults extends AbstractQueryResult {

    /**
     * 
     */
    private static final long serialVersionUID  = 1L;

    /**
     * 
     */

    private String            statusDescription = "statusDescription";

    private String            _properties;

    /**
     * @return the properties
     */
    public String getProperties() {

        if (_properties == null) {
            return (String) super.get(statusDescription);
        }
        return _properties;
    }

    /**
     * @param argProperties the properties to set
     */
    public void setProperties(String argProperties) {

        _properties = argProperties;
    }

    @Override
    protected IObjectId getObjectIdImpl() {

        CustomerLoyaltyAccountPropertyId accountPropertyId = new CustomerLoyaltyAccountPropertyId();
        accountPropertyId.setValue(this.getProperties());
        return accountPropertyId;
    }

}
