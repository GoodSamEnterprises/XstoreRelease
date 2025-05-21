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
 * BZ51234          231222    WO Deposit and Refund Tender Discrepancy 
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

public class CawDisableBackToSaleVisibilityRule extends AbstractVisibilityRule{

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        if (CawWorkOrderOptionsOp.isDepositAction()) {
            return AccessLevel.DENIED;
        }
        
        return AccessLevel.GRANTED;
    }

}
