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
 * BZ23479          220917    Add new parameter (EBS_ENABLE) to ON/OFF call to EBS Web Service
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import caw.pos.common.CawUtilFunction;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawMerCertSerTndRule extends AbstractVisibilityRule {

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        AccessLevel accessLevel = AccessLevel.GRANTED;
        /*Begin Bz-23479*/
        if (!CawUtilFunction.allowEBSConnection()) {
            accessLevel = AccessLevel.DENIED;
        }
        return accessLevel;
    }
    /*End Bz-23479*/

}
