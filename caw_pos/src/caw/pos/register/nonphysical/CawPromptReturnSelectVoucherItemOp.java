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
 * BZ32517          251019   [New Requirement] SKU prompt required prior to swipe gift cards for the refund activation to track inventory.
 * BZ35053          170220    [Porting the fix from patch 8 to Xstore 6.0] [PROD] Difficulty determining which gift card option to pick without associated item number
 *===================================================================
 */

package caw.pos.register.nonphysical;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.ObjectNotFoundException;
import dtv.i18n.IFormattable;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.nonphysical.PromptSelectVoucherItemOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.itm.INonPhysicalItem;

/**
 *
 */
public class CawPromptReturnSelectVoucherItemOp extends PromptSelectVoucherItemOp {
    private static final Logger logger_ = LogManager.getLogger(PromptSelectVoucherItemOp.class);
    
    @Override
   public boolean isOperationApplicable() {
      
      return true;
   }

   /* (non-Javadoc)
     * @see dtv.pos.register.nonphysical.PromptSelectVoucherItemOp#handleOpReverse(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpReverse(IXstEvent argEvent) {
        clearScopedValue(CawValueKeys.CAW_SKU_TYPE);
        return super.handleOpReverse(argEvent);
    }

    /* (non-Javadoc)
     * @see dtv.pos.register.nonphysical.PromptSelectVoucherItemOp#handlePromptResponse(dtv.pos.iframework.event.IXstEvent)
     */
    @SuppressWarnings("deprecation")
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {
        Object o = argEvent.getData();
        if (!(o instanceof INonPhysicalItem)) {
            logger_.error("Object selected from list is improper type.  " + INonPhysicalItem.class.getName()
                    + " expected, found [" + o.getClass().getName() + "]");
            return this.HELPER.silentErrorResponse();
        } else {
            INonPhysicalItem item = (INonPhysicalItem) o;
            setScopedValue(ValueKeys.CURRENT_ITEM, item);
            setScopedValue(ValueKeys.SELECTED_VOUCHER_TYPE, item.getNonPhysicalItemSubtype());
            setScopedValue(CawValueKeys.CAW_SKU_TYPE,(item.getItemId()));
            return HELPER.completeResponse();
        }
        
    }

    /* BEGIN BZ35053 */
    /* (non-Javadoc)
     * @see dtv.pos.register.nonphysical.PromptSelectVoucherItemOp#getPromptArgs(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable voucherDescription = null;
        String voucherCategory = getScopedValue(ValueKeys.SELECTED_VOUCHER_CATEGORY);
        if (CawConstants.CAW_GIFT_CARD.equalsIgnoreCase(voucherCategory)) {
            voucherDescription = _ff.getTranslatable("_menutextIssueGiftCard");
        } else {
            voucherDescription = _ff.getTranslatable("_voucher");
        }
        return new IFormattable[] { voucherDescription };

    }

    /* (non-Javadoc)
     * @see dtv.pos.register.nonphysical.PromptSelectVoucherItemOp#getPromptList(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected Object[] getPromptList(IXstEvent argEvent) {

        try {
            String category = getScopedValue(ValueKeys.SELECTED_VOUCHER_CATEGORY);
            if (CawConstants.CAW_GIFT_CARD.equalsIgnoreCase(category)) {

                List<String> listGCItemID = CodeLocator
                        .getCodes(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_ISSUE_XPAY_GIFT_CARD);
                String[] itemIds = null;

                if (!listGCItemID.isEmpty()) {

                    itemIds = listGCItemID.stream().toArray(String[]::new);
                    List<INonPhysicalItem> voucherList = ItemLocator.getLocator().lookupNonPhysicalItems(itemIds);
                    Iterator<INonPhysicalItem> it = voucherList.iterator();
                    while (it.hasNext()) {
                        INonPhysicalItem item = it.next();
                        if (!isValidItem(item)) {
                            it.remove();
                        }
                    }
                    return voucherList.toArray();
                } else {
                    return super.getPromptList(argEvent);
                }
            }

        } catch (ObjectNotFoundException var8) {
            logger_.warn("No items found for voucher " + this.getScopedValue(ValueKeys.SELECTED_VOUCHER_CATEGORY));
            return null;
        }
        return super.getPromptList(argEvent);
    }
    /* END BZ35053 */
}
