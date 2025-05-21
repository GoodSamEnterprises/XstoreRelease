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
 * BZ23447          270917    [Return] Blind returns should only allow for Gift Cards as the tender type
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
import dtv.pos.register.returns.ReturnType;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

/**
 * Set rule for Blind Return and Purchase Used Firearm return.
 */
public class CawBlindReturnVisibilityRule extends AbstractVisibilityRule {

    private static final String RETURN_CODE_BR  = "BR";

    private static final String RETURN_CODE_PUF = "PUF";

    @Inject
    protected TransactionScope  _transactionScope;

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
            String returnTypeCode = StringUtils.EMPTY;

            IRetailTransaction trans = getCurrentRetailTransaction();

            if (trans == null) {
                return AccessLevel.DENIED;
            }

            for (ISaleReturnLineItem saleLine : trans
                    .getLineItems(ISaleReturnLineItem.class)) {
                if ((saleLine.getReturn()) && (!saleLine.getVoid())) {
                    if (ReturnType.BLIND
                            .matches(saleLine.getReturnTypeCode())) {
                        if ((!((SaleReturnLineItemModel) saleLine).getVoid())
                                && (((SaleReturnLineItemModel) saleLine)
                                        .getReasonCodeObject() != null)
                                && (CawPurchaseUsedFirearmConstant.REASON_TYPE_CODE
                                        .equals(((SaleReturnLineItemModel) saleLine)
                                                .getReasonCodeObject()
                                                .getReasonTypeCode()))
                                && (CawPurchaseUsedFirearmConstant.TYPE_CODE
                                        .equals(((SaleReturnLineItemModel) saleLine)
                                                .getReasonCodeObject()
                                                .getReasonCode()))) {
                            returnTypeCode = RETURN_CODE_PUF;
                            break;
                        }

                        returnTypeCode = RETURN_CODE_BR;
                    }
                }
            }

            if (RETURN_CODE_PUF.equals(returnTypeCode)) {
                return AccessLevel.GRANTED;
            } else if (RETURN_CODE_BR.equals(returnTypeCode)) {
                return AccessLevel.DENIED;
            } else {
                return AccessLevel.GRANTED;
            }
        }
    }

}
