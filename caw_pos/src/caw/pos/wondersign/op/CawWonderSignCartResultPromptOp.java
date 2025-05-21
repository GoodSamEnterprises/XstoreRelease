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
 *===================================================================
 */

package caw.pos.wondersign.op;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.*;
import caw.pos.wondersign.model.CawWonderSignCart;
import caw.pos.wondersign.util.CawWonderSignHelper;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractListPromptOp;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawWonderSignCartResultPromptOp extends AbstractListPromptOp {

    private static final IXstDataActionKey SELECT            = XstDataActionKey.valueOf("SELECT");

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_WONDERSIGN_CART_SEARCH_RESULT");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argParamIXstEvent) {

        return HELPER.completeResponse();
    }

    @Override
    protected PromptKey getEmptyListPromptKey() {

        return PromptKey.valueOf("CAW_WONDERSIGN_CART_NOT_FOUND");
    }
    @Override
    protected Object[] getPromptList(IXstEvent argParamIXstEvent) {
        List<CawWonderSignCart> carts = new ArrayList<CawWonderSignCart>();
        
        String searchCartResponseJsonStr = _transactionScope.getValue(CawValueKeys.CAW_CART_SEARCH_RESPONSE);
        
        if (StringUtils.isNotEmpty(searchCartResponseJsonStr)) {
            
            JSONObject reponseJsonObject = CawJSONUtils.toJSONObject(searchCartResponseJsonStr);
        
            JSONArray resultsJsonArray = CawJSONUtils.getJSONArray(reponseJsonObject, CawJSONConstant.JSON_CART_SEARCH_RESULTS);
            
            if (resultsJsonArray != null) {
                for (int i = 0; i < resultsJsonArray.length(); i++) {
                    JSONObject cartJsonObject = CawJSONUtils.getJSONObject(resultsJsonArray, i);
                    
                    CawWonderSignCart cart = null;
                    
                    cart = CawWonderSignHelper.parseToCart(cartJsonObject);
                    
                    if (cart != null) {
                        carts.add(cart);
                    }
                }
            }
        }
        

        return carts.toArray();
    }

    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {
        _transactionScope.clearValue(CawValueKeys.WS_SELECTED_ITEM_LIST);
        return super.handleInitialState(argEvent);
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey actionKey = argEvent.getActionKey();

        if (actionKey == SELECT) {
            
            List<Object> selectedObjects = Arrays.asList(argEvent.getDataSet());
            List<CawWonderSignCart> selectedCarts = new ArrayList<>();
            
            for (Object selectedObj : selectedObjects) {
                if (selectedObj instanceof CawWonderSignCart) {
                    CawWonderSignCart cart = (CawWonderSignCart) selectedObj;
                    selectedCarts.add(cart);
                }
            }
            
            _transactionScope.setValue(CawValueKeys.WS_SELECTED_CART, selectedCarts);

            return HELPER.completeResponse();
        }

        return super.handleDataAction(argEvent);
    }

}
