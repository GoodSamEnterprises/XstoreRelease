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
 * BZ46387          290921    IDS Payment item restriction question
 *===================================================================
 */

package caw.pos.item.restriction;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.scope.DefaultScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.item.restriction.ItemOffLimitsRestrictionValidationRule;
import dtv.xst.dao.itm.IItemRestriction;

/**
 *
 */
public class CawItemOffLimitsRestrictionValidationRule extends ItemOffLimitsRestrictionValidationRule {
    
    @Inject
    private DefaultScope _defaultScope;

    @Override
    protected IValidationResult validate(
            Map<String, IItemRestriction> argProperties) {
        
        if (_defaultScope != null) {
            String rvProp = _defaultScope.getValue(CawValueKeys.CAW_RV_PROPERTIES);
            if (StringUtils.isNotEmpty(rvProp)) {
                return IValidationResult.SUCCESS;
            }
        }        
    
        return super.validate(argProperties);
    }
    
}
