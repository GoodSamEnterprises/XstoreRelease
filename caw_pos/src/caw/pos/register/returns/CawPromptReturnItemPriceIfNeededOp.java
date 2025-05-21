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
 * BZ25280          290118    [Xstore] Enter Price prompt is displayed twice for 0600 item for Web Order Returns
 *===================================================================
 */

package caw.pos.register.returns;

import caw.pos.common.CawValueKeys;

import dtv.pos.register.returns.PromptReturnItemPriceIfNeededOp;

/**
 *
 */
public class CawPromptReturnItemPriceIfNeededOp
        extends PromptReturnItemPriceIfNeededOp {

    @Override
    public boolean isOperationApplicable() {

        if (_transactionScope != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER) == Boolean.TRUE) {
            return Boolean.FALSE;
        } else {
            return super.isOperationApplicable();
        }

    }

}
