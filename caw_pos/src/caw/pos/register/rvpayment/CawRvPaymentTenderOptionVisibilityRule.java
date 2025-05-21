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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 *===================================================================
 */

package caw.pos.register.rvpayment;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.register.type.LineItemType;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * 
 */
public class CawRvPaymentTenderOptionVisibilityRule extends AbstractVisibilityRule {
    

    private static final Logger                          _logger                   = LogManager
            .getLogger(CawRvPaymentTenderOptionVisibilityRule.class);
    
    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        AccessLevel accessLevel = AccessLevel.GRANTED;
        
        try {
            if (_transactionScope != null && _transactionScope.getTransaction() != null) {
                List<ISaleReturnLineItem> transLineItems = _transactionScope.getTransaction().getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
                
                if (CawRvPaymentHelper.isRvTransaction(transLineItems)) {
                    if (CawRvPaymentHelper.isRvItemTransactionOnly(transLineItems)) {
                        accessLevel = AccessLevel.DENIED;
                    } else if (CawRvPaymentHelper.isOnlyRvPaymentAmountRemain(_transactionScope.getTransaction())) {
                        accessLevel = AccessLevel.DENIED;
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Exception from checkVisibilityImpl:" + ex.getMessage());
        }
        
        return accessLevel;
    }

}
