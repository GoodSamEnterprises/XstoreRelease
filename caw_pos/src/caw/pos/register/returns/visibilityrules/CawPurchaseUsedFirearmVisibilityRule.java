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
 * BZ23458          210917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 * BZ25068          220118    New Requirement to Process Web Order Returns
 *===================================================================
 */

package caw.pos.register.returns.visibilityrules;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.register.returns.common.CawPurchaseUsedFirearmConstant;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

/**
 * About Purchase Used Firearm, tender only Cash or Gift Card.
 */
public class CawPurchaseUsedFirearmVisibilityRule
        extends AbstractVisibilityRule {

    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        // Begin BZ25068
        if (_transactionScope != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) == Boolean.TRUE) {
            return AccessLevel.GRANTED;
            // End BZ25068
        } else {
            IRetailTransaction trans = getCurrentRetailTransaction();
            for (ISaleReturnLineItem saleLine : trans
                    .getLineItems(ISaleReturnLineItem.class)) {
                if ((saleLine.getReturn()) && (!saleLine.getVoid())) {
                    if ((((SaleReturnLineItemModel) saleLine)
                            .getReasonCodeObject() != null)
                            && (CawPurchaseUsedFirearmConstant.REASON_TYPE_CODE
                                    .equals(((SaleReturnLineItemModel) saleLine)
                                            .getReasonCodeObject()
                                            .getReasonTypeCode()))
                            && (CawPurchaseUsedFirearmConstant.TYPE_CODE
                                    .equals(((SaleReturnLineItemModel) saleLine)
                                            .getReasonCodeObject()
                                            .getReasonCode()))) {
                        return AccessLevel.DENIED;
                    }
                }
            }
            return AccessLevel.GRANTED;
        }

    }

}
