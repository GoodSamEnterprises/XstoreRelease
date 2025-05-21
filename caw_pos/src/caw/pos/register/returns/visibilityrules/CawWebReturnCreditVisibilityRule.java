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
 * BZ61330          290124    Update tender options for Verified return, Unverified return, web orders and Tender Exchange 
 *===================================================================
 */

package caw.pos.register.returns.visibilityrules;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.tender.CawRefundTenderConfigHelper;
import caw.pos.workorder.common.CawWorkOrderHelper;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.register.returns.ReturnManager;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawWebReturnCreditVisibilityRule extends AbstractVisibilityRule {
    

    @Inject
    protected TransactionScope  _transactionScope;
    
    private static final Logger                   _logger    = LogManager
            .getLogger(CawWebReturnCreditVisibilityRule.class);

    private static final String RETURN_TNDR_WEB_ORDER_CREDIT = "RETURN_TNDR_WEB_ORDER_CREDIT";

    private static final String ENABLE                       = "ENABLE";

    IRetailTransaction          trans                        = getCurrentRetailTransaction();

    List<ISaleReturnLineItem>   lineItemsWebReturn           = _transactionScope
            .getValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER);
    
    @Inject
    private ReturnManager       _returnMgr;
    
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        try {
            boolean isWOTransOrReturnWOCompleteTrans = false;
            List<IRetailTransaction> originalTrans = _returnMgr.getAllOrigTransaction();
            isWOTransOrReturnWOCompleteTrans = CawWorkOrderHelper.getInstance().checkWOTransOrReturnWOCompleteTrans(originalTrans);
            if(isWOTransOrReturnWOCompleteTrans) {
                return AccessLevel.GRANTED;
            }

            String returntype = CawRefundTenderConfigHelper.getInstance().returnType(trans, lineItemsWebReturn);
            if (returntype != null && !returntype.isEmpty()) {
                if(returntype.equalsIgnoreCase(CawConstants.RETURN_WEB_ORDER)) {
                    ICodeValue iSKUCode = CodeLocator.getCodeValue(ConfigurationMgr
                            .getOrganizationId(), RETURN_TNDR_WEB_ORDER_CREDIT, ENABLE);
                    if (iSKUCode != null) {
                        return AccessLevel.GRANTED;
                    } else {
                        return AccessLevel.DENIED;
                    } 
                }
            }
        } catch (Exception ex) {
            _logger.error("getErrorString: " + ex.getMessage());
        }
        return AccessLevel.DENIED;
    }
}
