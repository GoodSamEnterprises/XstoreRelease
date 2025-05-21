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
 * BZ23052              120917    Implement Advanced Prompting
 * BZ23481              220917    No response when pressing Yes on "Item not File" prompt with advanced prompting trigger "First name = cat and last name = directives"
 * BZ23541              280817    No request is sent to EBS again when choosing any items associated IsCallbackRequired= true with catalyst =4 
 * BZ23646              021017    [prompting advance]The message 'you cannot sell item' should be displayed after pressing 'Y' on Item not on file screen
 * BZ23982              131017    Registers are constantly frozen and required rebooting
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins
 * BZ24094              261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ24319              011117    Membership validation should not be applied for "Auto-renew" item from GS RS membership.
 * BZ24650              051217    HDE displays when typing item ID for the returned item with original receipt.
 * BZ28556              071218    [Internal[28265]PromptResultResponse from Neuron should return 'null' value in case choosing skip options: No,Thanks which has "isCallbackRequired": true
 * BZ28033              200219    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ33231              241019    [New Requirement] Change to "Will Save" prompting method to use Prompting Engine
 * BZ38980              031120    [TASK] Prompt Engine - Add Item & Price
 * BZ39699              231120    [Task] Porting these fixes of xstore 6.0 patch 10.0/11.0 into Xstore 7.0 patch 1.0
 * BZ59669              301023    [FreeTier short term] Update the membership resend [Catalyst=] call to a membership valdiation call
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import twitter4j.*;

import dtv.hardware.types.HardwareType;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.TransactionHelper;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.IPersistablesBag;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.itm.IItem;

public class CawProcessDirectivesAddItemOp extends Operation {

    private static final String ITEM_QUANTITY   = "quantity";

    private static final String ITEM_CODE       = "itemCode";

    private static final String ITEM_PRICE       = "unitSellingPrice"; // BZ-38980

    private static final Logger _logger         = LogManager
            .getLogger(CawProcessDirectivesAddItemOp.class);

    private final IOpState      NO_ITEMS_FOUND  = new OpState("NO_ITEMS_FOUND");

    private JSONArray           directiveFileds = new JSONArray();

    IPersistablesBag            bag             = TransactionHelper
            .getPersistables();

    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        String itemCode = "";//BZ28556
        try {
            if (CawCatalystHelper.getCatalystDirectiveResponse() != null
                    && CawCatalystHelper.getCatalystDirectiveResponse()
                            .length() > 0) {
                JSONObject directive = null;
                int length = CawCatalystHelper.getCatalystDirectiveResponse()
                        .length();
                for (int i = 0; i < length; i++) {
                    if (CawCatalystHelper.getCatalystDirectiveResponse()
                            .getJSONObject(i) != null) {
                        directive = CawCatalystHelper
                                .getCatalystDirectiveResponse()
                                .getJSONObject(i);
                        /* Begin BZ28556 */
                        if (!directive.isNull(CawEBSConstant.PROPERTIES_ATTR) && directive
                                .getJSONObject(CawEBSConstant.PROPERTIES_ATTR).has(CawEBSConstant.ITEMCODE_ATTR)) { //BZ33231
                            itemCode = directive.getJSONObject(CawEBSConstant.PROPERTIES_ATTR)
                                    .getString(CawEBSConstant.ITEMCODE_ATTR);
                        }

                        if (!directive.isNull(CawEBSConstant.TYPE_ATTR)
                                && (directive
                                        .getInt(CawEBSConstant.TYPE_ATTR) == 3
                                        && itemCode
                                                .compareToIgnoreCase("0") != 0)) {
                            /* End BZ28556 */
                            directiveFileds.put(CawCatalystHelper
                                    .getCatalystDirectiveResponse()
                                    .getJSONObject(i));
                            /* BEGIN BZ28033 */
                            if (_transactionScope != null) {
                                _transactionScope.setValue(CawValueKeys.IS_RESENT_CATALYST_4, Boolean.TRUE);
                            }
                            /* END BZ28033 */
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.debug("Cann not get item." + ex.getMessage());
        }

        if (directiveFileds != null && directiveFileds.length() > 0) { // BZ23958
            isRun = Boolean.TRUE;
        }

        return isRun;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        if (directiveFileds != null && directiveFileds.length() > 0) {
            String itemCode = null;
            Integer quantity = null;
            BigDecimal itemPrice = null; // BZ-38980
            JSONObject tempObj = null;
            JSONObject itemObject = null;

            int length = directiveFileds.length();
            for (int i = 0; i < length; i++) {
                try {
                    tempObj = directiveFileds.getJSONObject(i);
                    if (!tempObj.isNull(CawEBSConstant.TYPE_ATTR)) {
                        if (!tempObj.isNull(CawEBSConstant.PROPERTIES_ATTR)) {
                            itemObject = tempObj
                                    .getJSONObject(CawEBSConstant.PROPERTIES_ATTR);
                            if (itemObject != null) {
                                if (!itemObject.isNull(ITEM_CODE)) {
                                    itemCode = itemObject.getString(ITEM_CODE);
                                }
                                // Start BZ-38980
                                if (!itemObject.isNull(ITEM_PRICE)) {
                                    itemPrice = NumberUtils.toBigDecimal(itemObject.getString(ITEM_PRICE), Locale.getDefault());
                                } // End BZ-38980

                                if (!itemObject.isNull(ITEM_QUANTITY)) {
                                    quantity = itemObject.getInt(ITEM_QUANTITY);
                                }
                                if (itemCode != null) {
                                    try {
                                        CawCatalystHelper
                                                .setCatalystDirectiveResponse(CawCatalystHelper
                                                        .removeItemOfJsonArray(CawCatalystHelper
                                                                .getCatalystDirectiveResponse(), itemCode));
                                        directiveFileds = CawCatalystHelper
                                                .removeItemOfJsonArray(directiveFileds, itemCode);
                                    } catch (JSONException ex) {
                                        _logger.debug("Cann not get item."
                                                + ex.getMessage());
                                    }
                                    //BEGIN BZ59669
                                    List<ICodeValue> iSKUCodes = _transactionScope.getValue(CawValueKeys.CAW_GS_LOYALTY_ITEM_FREE_CODE_VALUE);
                                    for (ICodeValue iSKUCode : iSKUCodes) {
                                        if(iSKUCode.getCode() != null && !iSKUCode.getCode().isEmpty()
                                                && itemCode.equalsIgnoreCase(iSKUCode.getCode())) {
                                            
                                            _transactionScope.setValue(CawValueKeys.CAW_SHOULD_SEND_VALIDATE_MEMBERSHIP_AFTER_ADD_ITEM, true);
                                        } 
                                    }
                                    //END BZ59669
                                }
                                //Remove this element to list
                                return addItemToSaleScreen(itemCode, quantity, itemPrice); // BZ-38980
                            }
                        }
                    }
                } catch (Exception ex) {
                    _logger.error("Can not get item." + ex.getMessage());
                }
            }
        }

        return HELPER.completeResponse();

    }

    private IOpResponse addItemToSaleScreen(String itemId, Integer quantity, BigDecimal argItemPrice) { // BZ-38980

        IOpResponse iOpResponse = HELPER.completeResponse();
        try {
            IItem item = ItemLocator.getLocator().lookupItem(itemId);
            if (item != null) {
                setScopedValue(ValueKeys.CURRENT_ITEM, item);
                setScopedValue(ValueKeys.ENTERED_ITEM_ID, itemId); // BZ 24650
                setScopedValue(ValueKeys.ENTERED_ITEM_QUANTITY, BigDecimal.ONE);
                // Start BZ-38980
                if (argItemPrice != null ) {
                    setScopedValue(ValueKeys.ENTERED_ITEM_PRICE, argItemPrice);
                } // End BZ-38980
                // Start BZ-39699
                else {
                    clearScopedValue(ValueKeys.ENTERED_ITEM_PRICE);
                } // End BZ-39699
                if (quantity != null) {
                    setScopedValue(ValueKeys.ENTERED_ITEM_QUANTITY, new BigDecimal(
                            quantity));
                }

                // If the item was scanned, the entry method will have been set when
                // the scan event was handled. Otherwise, the item must have been entered via keyboard.
                if (getScopedValue(ValueKeys.VALUE_ENTRY_METHOD) == null) {
                    setScopedValue(ValueKeys.VALUE_ENTRY_METHOD, HardwareType.KEYBOARD);
                }
                iOpResponse = HELPER.getWaitStackChainResponse(OpChainKey
                        .valueOf("SALE_ITEM_AFTER_LOOKUP"));
            } else {
                this.setOpState(NO_ITEMS_FOUND);
                iOpResponse = HELPER.getCompleteStackChainResponse(OpChainKey
                        .valueOf("CAW_ITEM_NOT_ON_FILE")); //BZ23646
            }
        } catch (Exception ex) {
            _logger.error("Can not lookup Item." + ex.getMessage());
        }

        return iOpResponse;
    }

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
}
