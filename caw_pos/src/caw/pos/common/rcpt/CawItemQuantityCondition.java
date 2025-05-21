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
 * BZ26893          261118    [Xstore] Transaction Receipt Changes
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.i18n.format.QuantityFormatter;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

public class CawItemQuantityCondition extends AbstractInvertableCondition {

    @Override
    protected boolean conditionMetImpl(Object argSource) {
        
        BigDecimal quantity = NumberUtils.ZERO;
        String squantity = "";
        QuantityFormatter formatter = new QuantityFormatter();
        if (argSource instanceof SaleReturnLineItemModel) {
            quantity = ((SaleReturnLineItemModel) argSource).getQuantity();
            squantity = formatter.format(quantity, null);
            if ("1".equals(squantity)) {
                return true;
            }
        }
        return false;
    }
}
