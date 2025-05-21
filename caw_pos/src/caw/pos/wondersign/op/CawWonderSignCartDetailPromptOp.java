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
 * BZ44528          130821    Electric World & Mobile POS Implementation(Phase 1)
 * BZ45863          230821    [Internal] Xstore should notify the user if no items in cart can be added to the Electric World order
 *===================================================================
 */

package caw.pos.wondersign.op;

import java.util.List;

import caw.pos.common.CawValueKeys;
import caw.pos.wondersign.model.CawWonderSignCartItem;
import caw.pos.wondersign.util.CawWonderSignHelper;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractListPromptOp;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.util.StringUtils;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.ItemId;

/**
 *
 */
public class CawWonderSignCartDetailPromptOp extends AbstractListPromptOp {

    private CawWonderSignHelper            _wonderSignHelper = CawWonderSignHelper.getInstance();

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_WONDERSIGN_CART_ITEMS_RESULT");
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey actionKey = argEvent.getActionKey();

        if (actionKey == XstDataActionKey.CANCEL) {

            return HELPER.getOpChainRollBackRequest();

        } else {
            List<CawWonderSignCartItem> selectedItems = _transactionScope.getValue(CawValueKeys.WS_VALID_CART_ITEM);

            _wonderSignHelper.setCartSelectedItem(selectedItems);
            
            _transactionScope.setValue(CawValueKeys.WS_SELECTED_ITEM_LIST, selectedItems);
        }

        return super.handleDataAction(argEvent);
    }

    @Override
    protected Object[] getPromptList(IXstEvent argParamIXstEvent) {
        
        List<CawWonderSignCartItem> items = _transactionScope.getValue(CawValueKeys.WS_VALID_CART_ITEM);
        
        if (items != null) {

            for (CawWonderSignCartItem item : items) {
                ItemId id = new ItemId();
                id.setOrganizationId(ConfigurationMgr.getOrganizationId());
                id.setItemId(item.getCode());

                IItem queryItem = DataFactory.getObjectByIdNoThrow(id);

                if (queryItem != null
                        && !StringUtils.isEmpty(queryItem.getItemId())) {
                    item.setName(queryItem.getDescription());
                }
            }
            
            return items.toArray();
        }

        return null;
    }

    @Override
    protected PromptKey getEmptyListPromptKey() {
        
        return PromptKey.valueOf("CAW_NO_VALID_ITEM_IN_CART"); //BZ45863
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }

}
