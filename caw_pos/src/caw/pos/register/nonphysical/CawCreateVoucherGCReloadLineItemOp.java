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
 * BZ27757          100918    [UAT] Selling a gift card from the Non-Merch menu is significantly slow
 *===================================================================
 */

package caw.pos.register.nonphysical;

import caw.pos.common.CawConstants;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.type.NonPhysicalItemType;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.INonPhysicalItem;

/**
 * The class converts the current item to GC RELOAD data when reloading gift card.
 */
public class CawCreateVoucherGCReloadLineItemOp
        extends CawCreateVoucherSaleLineItemOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IItem item = this.getScopedValue(ValueKeys.CURRENT_ITEM);

        if (item instanceof INonPhysicalItem) {
            INonPhysicalItem nonPhysItem = (INonPhysicalItem) item;

            NonPhysicalItemType nonPhysicalItemType = NonPhysicalItemType
                    .forName(CawConstants.NON_PHYSICAL_ITEM_TYPE_VOUCHER);
            if (nonPhysicalItemType != null && nonPhysicalItemType
                    .matches(nonPhysItem.getNonPhysicalItemTypeCode())) {
                item = ItemLocator.getLocator()
                        .lookupItem(CawConstants.ITEM_GC_RELOAD);
                if (item != null) {
                    this.setScopedValue(ValueKeys.CURRENT_ITEM, item);
                }
            }
        }

        IOpResponse response = super.handleOpExec(argEvent);

        getScopedValue(ValueKeys.CURRENT_VOUCHER_LINE_ITEM)
                .setVoucherTypeCode(CawEigenConstants.XPAY_GIFT_CARD);

        return response;
    }

}
