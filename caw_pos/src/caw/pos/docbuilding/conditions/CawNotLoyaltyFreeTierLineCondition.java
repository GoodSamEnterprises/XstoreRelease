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
 * BZ59418          171023    Free Tier Opt In Loyalty SKU customization
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

public class CawNotLoyaltyFreeTierLineCondition extends AbstractInvertableCondition {
    /* Begin BZ59418 */
    private String cawComCodeCategory_ = null;

    @Override
    public void setParameter(String argName, Object argValue) {
        if ("VALUE".equalsIgnoreCase(argName)) {
            this.cawComCodeCategory_ = argValue.toString();
        } else {
            super.setParameter(argName, argValue);
        }

    }
    
    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof SaleReturnLineItemModel) {
            ISaleReturnLineItem saleLineItem = (ISaleReturnLineItem) argSource;
           
            String code = saleLineItem.getItemId();
            if(code != null && !code.isEmpty()) {
                ICodeValue iSKUCode = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), cawComCodeCategory_, code);

                if (iSKUCode != null) {
                    return false;
                }
            }
        }
        return true;
    }
    /* End BZ59418 */
}
