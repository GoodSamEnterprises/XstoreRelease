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
 * BZ23021              250817    Store copy is only required for: Refunds, Work Order cancel and all employee transactions
 *== ================================================================
 */

package caw.pos.hardware.rcptbuilding.copyrules;

import javax.inject.Inject;

import dtv.hardware.rcptbuilding.copyrules.AbstractRcptCopyRule;
import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.customer.account.ICustomerAccountMaintModel;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.cat.ICustomerAccount;

/**
 *
 */
public class CawWorkOrderCancelRule extends AbstractRcptCopyRule {

    @Inject
    private CustomerAccountHelper _accountHelper;

    @SuppressWarnings("deprecation")
    public CawWorkOrderCancelRule() {

        super();
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    protected boolean doesRuleApply(Object argSource) {

        if ((argSource instanceof ICustomerAccountMaintModel)) {
            ICustomerAccountMaintModel model = (ICustomerAccountMaintModel) argSource;
            ICustomerAccount account = model.getAccount();
            return _accountHelper.isAccountCancelled(account);
        }
        return false;
    }

}
