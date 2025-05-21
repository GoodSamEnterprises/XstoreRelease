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
 * Req/Bug ID#          ddMMyy    Description
 * BZ25358              290418    Enhancements to QAS Integration with POS
 * BZ33598              231219    [Prod] QAS address match issues
 *===================================================================
 */

package caw.pos.address.search;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;

/**
 * this class is used to disable "Edit Customer" button in case allowEdit = false
 */
public class CawQASEditVisibilityRule extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        /*BEGIN BZ33598*/
        if (CawCustomerUtil.isAllowEdit()) {
            return AccessLevel.GRANTED;
        }
        /*END BZ33598*/
        return AccessLevel.DENIED;
    }

}
