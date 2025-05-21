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
 * BZ46111          111021    [UAT] Electric World Phase 1 Mixed Transaction Return Error
 *===================================================================
 */

package caw.pos.register.returns.verification;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.data2.access.IDataModel;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.returns.verification.PromptVerifiedReturnItemScanOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawWonderSignPromptVerifiedReturnItemScanOp extends PromptVerifiedReturnItemScanOp{
    
    private static final Logger _logger  = LogManager.getLogger(CawWonderSignPromptVerifiedReturnItemScanOp.class);
    
    @Override
    protected IOpResponse initialize() {
        List<? extends IDataModel> result = null;
        IRetailTransaction trans = this.getScopedValue(ValueKeys.CURRENT_ORIGINAL_TRANSACTION);
        if (trans != null) {
            List<? extends IDataModel> verifyReturnItems = getScopedValue(ValueKeys.CURRENT_VERIFIED_RETURN_ITEMS);
            if (CollectionUtils.isEmpty(verifyReturnItems)) {
                verifyReturnItems = trans.getLineItems(ISaleReturnLineItem.class);
            }
            try {
                result = ItemLocator.getLocator().getAvailableForReturnList(verifyReturnItems);
            } catch (Exception ex) {
                _logger.error("No matching orders were found." + ex.getMessage());
                return null;
            }
        }

        if (result != null && !result.isEmpty()) {
            return null;
        } else {
            this.setOpState(this.NO_RETURNABLE_ITEMS);
            return this.HELPER.getPromptResponse(PromptKey.valueOf("NO_ITEM_AVAILABLE_FOR_RETURN"), new IFormattable[0]);
        }
    }
    
}
