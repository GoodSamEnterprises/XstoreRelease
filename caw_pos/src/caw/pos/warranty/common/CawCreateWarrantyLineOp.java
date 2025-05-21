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
 * BZ28271          210319    [3.0] Work Orders with Warranty items show on Flash Sales report after a deposit is made.
 *===================================================================
 */

package caw.pos.warranty.common;

import javax.inject.Inject;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.WarrantyManager;
import dtv.pos.warranty.common.CreateWarrantyLineOp;
import dtv.xst.dao.itm.IWarrantyItem;
import dtv.xst.dao.trl.IWarrantyLineItem;

/**
 *
 */
public class CawCreateWarrantyLineOp extends CreateWarrantyLineOp {
    private static final String PARAM_SALE_LINE_ITEM_TYPE_CODE = "SALE_LINE_ITEM_TYPE_CODE";
    private String              _saleReturnLineItemTypeCode;
    /* (non-Javadoc)
     * @see dtv.pos.warranty.common.CreateWarrantyLineOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */

    @Inject
    private WarrantyManager     _warrantyMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argArgEvent) {
        IWarrantyLineItem warrantyLineItem = getScopedValue(ValueKeys.CURRENT_WARRANTY_LINE_ITEM);
        IWarrantyItem warrantyItem = _warrantyMgr.getWarrantyItem(warrantyLineItem);
        if (warrantyItem == null && getScopedValue(ValueKeys.SELECTED_WARRANTY_PLAN) != null) {
            warrantyItem = getScopedValue(ValueKeys.SELECTED_WARRANTY_PLAN);
        }
        if (warrantyItem != null) {
            IWarrantyLineItem warrantyLine = createWarrantyLineItem(warrantyItem, getSaleItemType(), isReturnMode(), isZeroExtendedPriceForced());
            warrantyLine.setSaleReturnLineItemTypeCode(_saleReturnLineItemTypeCode);
            // Set the new warranty line item to the scope
            setScopedValue(ValueKeys.CURRENT_WARRANTY_LINE_ITEM, warrantyLine);
        }
        return HELPER.completeResponse();
    }

    /* (non-Javadoc)
     * @see dtv.pos.warranty.common.CreateWarrantyLineOp#setParameter(java.lang.String, java.lang.String)
     */
    @Override
    public void setParameter(String argArgName, String argArgValue) {
        if (PARAM_SALE_LINE_ITEM_TYPE_CODE.equalsIgnoreCase(argArgName)) {
            _saleReturnLineItemTypeCode = argArgValue;
        }
        super.setParameter(argArgName, argArgValue);
    }
}
