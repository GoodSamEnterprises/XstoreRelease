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
 * Req/Bug ID#          ddMMyy    Description
 * BZ30922              210619    [New Requirement] Price Check and Inventory Lookup
 *===================================================================
 */
package caw.pos.inventory.lookup;

import java.util.List;

import dtv.pos.common.PromptKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.inventory.lookup.DisplayFoundItemOp;
import dtv.pos.inventory.lookup.ItemResultsEditModel;
import dtv.util.CollectionUtils;

public class CawDisplayFoundPriceItemOp extends DisplayFoundItemOp {

    @Override
    protected CawItemResultsPriceModel createModel() {

        ItemResultsEditModel baseModel = super.createModel();
        CawItemResultsPriceModel model = null;
        if (baseModel instanceof CawItemResultsPriceModel) {
            model = (CawItemResultsPriceModel) baseModel;
        }
        return model;
    }

    /* handleInitialState()
     * @see dtv.pos.framework.op.AbstractFormOp#handleInitialState()
     */
    @SuppressWarnings("static-access")
    @Override
    protected IOpResponse handleInitialState() {

        List<CawInventoryStoreInfo> listInventoryStoreInfo = CawInventoryLookupHelper.getInstance()
                .getListInventoryStoreInfo();
        boolean isCommunicationError = CawInventoryLookupHelper.getInstance().isCommunicationError();

        if (CollectionUtils.isEmpty(listInventoryStoreInfo) && !isCommunicationError) {
            return HELPER.getCompletePromptResponse(PromptKey.valueOf("CAW_INVENTORY_NO_RESULTS_FOUND"));
        }
        if (isCommunicationError) {
            return HELPER.getCompletePromptResponse(PromptKey.valueOf("CAW_INVENTORY_ERROR"));
        }
        return super.handleInitialState();
    }
}
