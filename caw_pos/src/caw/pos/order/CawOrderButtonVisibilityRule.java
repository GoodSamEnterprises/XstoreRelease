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
 * BZ62616          032624    Disable BOPIS in Xstore
 *===================================================================
 */

package caw.pos.order;

import caw.pos.common.CawConstants;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 *
 */
public class CawOrderButtonVisibilityRule  extends AbstractVisibilityRule {

    public static final String CAW_ORDER_ENABLE = System.getProperty("caw.pos.order.enable");

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        IAccessLevel accessLevel = AccessLevel.DENIED;
        if(CAW_ORDER_ENABLE != null && CAW_ORDER_ENABLE.equalsIgnoreCase(CawConstants.TRUE_STRING)) {
            accessLevel = AccessLevel.GRANTED;
        }
        return accessLevel;
    }
}
