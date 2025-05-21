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
 * BZ27248          210818     Warranty Items from S&I are not associated with the items covered
 *===================================================================
 */

package caw.pos.workorder.op;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.spring.ValueKeys;
import dtv.util.CompositeObject.TwoPiece;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.IWarrantyItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawWorkOrderAttachedWarrantyConditionOp
        extends AbstractRunCondition {

    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected boolean shouldRunImpl() {

        boolean isRun = false;
        @SuppressWarnings("unchecked")
        Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> warrantyItems = _transactionScope
                .getValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST);

        if (warrantyItems != null && warrantyItems.size() > 0) {
            ISaleReturnLineItem newLineItem = this
                    .getScopedValue(ValueKeys.CURRENT_SALE_LINE);
            if (newLineItem != null
                    && StringUtils.isNotEmpty(newLineItem.getItemId())) {
                for (Map.Entry<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> entry : warrantyItems
                        .entrySet()) {
                    if (entry.getValue() != null
                            && entry.getValue().getItemId() != null
                            && entry.getValue().getItemId()
                                    .equalsIgnoreCase(newLineItem
                                            .getItemId())) {
                        isRun = true;
                        break;
                    }
                }
            }
        }

        return isRun;
    }

}
