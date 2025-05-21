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
 * BZ26289          110718    New Requirement - Enable A/R Payment Functionality in Xstore
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import dtv.pos.framework.action.access.AbstractFormVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 * The CawDisableCreateNewHouseAccountVisibilityRule class
 */
public class CawDisableCreateNewHouseAccountVisibilityRule
        extends AbstractFormVisibilityRule {

    /** {@inheritDoc} */
    @Override
    protected IAccessLevel checkVisibilityImpl() {
        return AccessLevel.DENIED;
    }

}
