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
 * BZ25958          100718    New Requirement - Remove Gift Card transactions from the Pin Pad
 *===================================================================
 */

package caw.pos.register.nonphysical;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;

import dtv.data2.access.ObjectNotFoundException;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.nonphysical.PromptSelectVoucherItemOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.INonPhysicalItem;

/**
 *
 */
public class CawPromptSelectVoucherItemOp extends PromptSelectVoucherItemOp {

    private static final Logger logger_ = LogManager
            .getLogger(CawPromptSelectVoucherItemOp.class);

    /* Only GC Reload, no need to display prompt.
     * @see dtv.pos.register.nonphysical.PromptSelectVoucherItemOp#showListIfOne()
     */
    @Override
    protected boolean showListIfOne() {

        return Boolean.FALSE;
    }

    /* Get only GC Reload
     * @see dtv.pos.register.nonphysical.PromptSelectVoucherItemOp#getPromptList(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected Object[] getPromptList(IXstEvent argArgEvent) {

        try {
            INonPhysicalItem[] voucherItem = new INonPhysicalItem[] {};

            List<INonPhysicalItem> voucherList = ItemLocator.getLocator()
                    .lookupNonPhysicalItems(new String[] { CawConstants.ITM_GC_RELOAD_ID });

            if (voucherList != null && voucherList.size() > 0) {
                voucherItem = new INonPhysicalItem[] { voucherList.get(0) };
            }

            return voucherItem;

        } catch (ObjectNotFoundException ex) {
            logger_.warn("No items found for voucher "
                    + getScopedValue(ValueKeys.SELECTED_VOUCHER_CATEGORY));

            return null;
        }

    }

}
