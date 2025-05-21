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
 * BZ23458          270917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 * BZ25068          220118    New Requirement to Process Web Order Returns
 * BZ34650          200220    [Prod] Issue returning 500 items without receipts
 *===================================================================
 */

package caw.pos.register.returns;

import caw.pos.common.CawValueKeys;

import dtv.pos.register.returns.PromptLowestReturnPriceInfoOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItemOptions;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Skip the prompt lowest return if return purchase used firearm.
 */
public class CawSkipPromptLowestReturnPriceInfoOp
        extends PromptLowestReturnPriceInfoOp {

    @Override
    public boolean isOperationApplicable() {

        Boolean isPurchaseUsedFirearm = _transactionScope
                .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);

        if ((isPurchaseUsedFirearm != null) && (isPurchaseUsedFirearm)) {
            return false;
            // Begin BZ25068
        } else if (_transactionScope
                .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) == Boolean.TRUE) {
            return false;
            // End BZ25068
        }
        /*BEGIN BZ34650*/
        ISaleReturnLineItem lineItem = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        if (lineItem != null && lineItem.getItem() != null) {

            IItemOptions itemOptions = lineItem.getItem().getOptions();
            if (itemOptions != null && itemOptions.getPromptForPrice()) {
                return false;
            }
        }
        /*END BZ34650*/
        return super.isOperationApplicable();
    }
}
