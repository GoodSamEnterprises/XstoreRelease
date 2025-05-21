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
 * BZ61330          290124    Update tender options for Verified return, Unverified return, web orders and Tender Exchange
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;

/**
 *
 */
public class CawValidateExchangeConfigurationVisibilityRule extends AbstractVisibilityRule{
    
    private static final String RETURN_TNDR_EXCHANGE_CASH   = "RETURN_TNDR_EXCHANGE_CASH";
    
    private static final String RETURN_TNDR_EXCHANGE_CREDIT = "RETURN_TNDR_EXCHANGE_CREDIT";

    private static final String ENABLE                      = "ENABLE";
    
    private int tenderCode                                  = 0;
    
    private ICodeValue iSKUCode;
    
    @Override
    public void setParameter(String argName, String argValue) {
        this.tenderCode = Integer.parseInt(argValue);
    }

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        switch (this.tenderCode) {
        case 1:
            iSKUCode = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), RETURN_TNDR_EXCHANGE_CASH, ENABLE);
            if (iSKUCode != null) {
                return AccessLevel.GRANTED;
            } else {
                return AccessLevel.DENIED;
            }

        case 2:
            iSKUCode = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), RETURN_TNDR_EXCHANGE_CREDIT, ENABLE);
            if (iSKUCode != null) {
                return AccessLevel.GRANTED;
            } else {
                return AccessLevel.DENIED;
            }

        default:
            return AccessLevel.DENIED;  
        }
    }
}
