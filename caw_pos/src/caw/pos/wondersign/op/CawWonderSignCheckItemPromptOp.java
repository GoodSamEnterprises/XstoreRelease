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
 * BZ45865          230821    [Internal] Not-on-file item is duplicated in prompting when attempting to add each cart that had the same not-on-file item in turn.
 *===================================================================
 */

package caw.pos.wondersign.op;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import caw.pos.wondersign.model.CawWonderSignCart;
import caw.pos.wondersign.model.CawWonderSignCartItem;
import caw.pos.wondersign.util.CawWonderSignHelper;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.itm.IItem;

/**
 *
 */
public class CawWonderSignCheckItemPromptOp extends AbstractPromptOp {

    private static final Logger _logger           = LogManager
            .getLogger(CawWonderSignCheckItemPromptOp.class);

    private CawWonderSignHelper _wonderSignHelper = CawWonderSignHelper
            .getInstance();
    
    private List<String>        _listNotOnFileItem = new ArrayList<>();

    /* If WonderSign selected cart contain no item or item(s) not on file then run this Op.
     */
    @Override
    public boolean isOperationApplicable() {
        _listNotOnFileItem = new ArrayList<>(); //BZ45865

        //Step 1: Handle WonderSign selected cart items
        boolean check = handleWonderSignItems();
        if (!check) {
            return Boolean.TRUE;
        }
        
        //Step2: Check if WS items not on file
        if (!_listNotOnFileItem.isEmpty()) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @SuppressWarnings("null")
    boolean handleWonderSignItems() {

        boolean success = false;

        try {
            IItem item = null;
            String itemId = null;
            
            List<CawWonderSignCartItem> removeItems = new ArrayList<CawWonderSignCartItem>();
            
            List<CawWonderSignCartItem> items = new ArrayList<>();
            
            String searchCartResponseJsonStr = _transactionScope.getValue(CawValueKeys.CAW_CART_SEARCH_RESPONSE);
            
            List<CawWonderSignCart> selectedCarts = _transactionScope.getValue(CawValueKeys.WS_SELECTED_CART);
            
            if (searchCartResponseJsonStr != null && selectedCarts != null && selectedCarts.size() > 0) {
                JSONObject reponseJsonObject = CawJSONUtils.toJSONObject(searchCartResponseJsonStr);
                JSONArray resultsJsonArray = CawJSONUtils.getJSONArray(reponseJsonObject, CawJSONConstant.JSON_CART_SEARCH_RESULTS);
                
                for (CawWonderSignCart cawWonderSignCart : selectedCarts) {
                    List<CawWonderSignCartItem> singleCartItems = CawWonderSignHelper.getCartItems(cawWonderSignCart.getCorrelationKey(), resultsJsonArray);
                    
                    if (singleCartItems != null) {
                        
                        items.addAll(singleCartItems);
                        
                        for (CawWonderSignCartItem cawWonderSignCartItem : singleCartItems) {
                            itemId = cawWonderSignCartItem.getCode();
                            item = _wonderSignHelper.getWonderSignItemOnFile(itemId);
            
                            if (item == null) {
                                removeItems.add(cawWonderSignCartItem);
                                _listNotOnFileItem.add(itemId);
                            }
                        }
                    }
                }
                
            }
            
            
            
            for (CawWonderSignCartItem cawWonderSignCartItem : removeItems) {
                items.remove(cawWonderSignCartItem);
            }
            
            _transactionScope.setValue(CawValueKeys.WS_VALID_CART_ITEM, items);
            
            success = true;
        } catch (Exception ex) {
            _logger.error("handleWonderSignItems", ex);
            success = false;
        }
        
        return success;

    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_WONDERSIGN_ITEMS_NOT_ON_FILE");
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
    
        IFormattable[] args = new IFormattable[1];
        
        args[0] = FormattableFactory.getInstance().getSimpleFormattable(String.join(", ", _listNotOnFileItem));
        
        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }
}
