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
 * BZ23052          120917    Implement Advanced Prompting
 * BZ28529          061218    [Internal] Error with Prompt Engine when sending Prompt Engine result
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.DefaultScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 * Disable or enable button previous on form input
 */
public class CawAllowPreviousButtonVisibilityRule extends AbstractVisibilityRule {

    @Inject
    private DefaultScope _defaultScope;

    /** (non-Javadoc)
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#checkVisibilityImpl()
     */
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        /* Begin BZ28529*/
        IAccessLevel accessLevel = AccessLevel.GRANTED;
        Integer active = _defaultScope.getValue(CawValueKeys.ELEMENT_ACTIVE);
        Boolean isPressPreviousButton = _defaultScope.getValue(CawValueKeys.IS_INPUT_BACK_BUTTON);
        if (active != null && active.intValue() == 0 || active == null) {
            return AccessLevel.DENIED;
        } else {
            if (isPressPreviousButton) {
                if ((active.intValue() == 0)) {
                    return AccessLevel.DENIED;
                }
            }
        }
        /* End BZ28529*/
        return accessLevel;
    }

}
