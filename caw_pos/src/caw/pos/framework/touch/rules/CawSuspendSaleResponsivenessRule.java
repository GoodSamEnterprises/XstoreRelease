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
 * BZ49884          060522    [PROD] Store 28 reg 3 tran 5990 Payment / Transaction completion issue
 *===================================================================
 */

package caw.pos.framework.touch.rules;

import dtv.pos.common.TransactionStatus;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.framework.touch.rules.AbstractTouchResponsivenessRule;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.ui.config.ITouchConfig;
import java.awt.event.MouseEvent;
import javax.inject.Inject;

public class CawSuspendSaleResponsivenessRule extends AbstractTouchResponsivenessRule {

    @Inject
    private TransactionScope _transactionScope;

    protected IXstAction getAction(MouseEvent argEvent) {

        IXstAction action = null;
        ITouchConfig config = getParentConfigObject();
        if (config != null) {
            action = config.getAction();
        }
        
        if (action == null && argEvent.getSource() instanceof IXstAction) {
            action = (IXstAction) argEvent.getSource();
        }
           
        return action;
    }

    @Override
    protected boolean isResponsiveImpl(MouseEvent argEvent) {

        IXstAction action = getAction(argEvent);
        String transaction = this._transactionScope.getTransaction().getTransactionStatusCode();
        if ((action.getActionKey().equals(XstDataActionKey.valueOf("SUSPEND_TRANSACTION"))
                && transaction != null) || TransactionStatus.SUSPEND.matches(transaction)) {
            return false;
        }
        
        return true;
    }
}
