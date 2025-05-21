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
 * BZ23359          270917    Gift cards can't be swiped at screen
 *===================================================================
 */

package caw.pos.register.nonphysical;

import java.math.BigDecimal;

import dtv.pos.register.nonphysical.PromptVoucherAmtOp;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawPromptVoucherAmtOp extends PromptVoucherAmtOp {

    @Override
    public boolean isOperationApplicable() {

        BigDecimal amt = getScopedValue(ValueKeys.ENTERED_ITEM_PRICE);
        return amt == null && super.isOperationApplicable();
    }
}
