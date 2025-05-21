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
 * BZ29625          180419    [New Requirement] - Auto-Renewal Item Specific Receipts
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.item.CawItemHelper;
import caw.pos.item.CawItemMessage;

import dtv.data2.access.DataFactory;
import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.util.StringUtils;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.ISaleReturnLineItem;

public class CawItemMessagePromptOp extends AbstractPromptOp {

    private static final Logger _logger               = LogManager.getLogger(CawItemHelper.class);
    String                      strItemsMessagePrompt = "";

    @Override
    public PromptKey getDefaultPromptKey() {
        return PromptKey.valueOf("CAW_ITEM_MESSAGE");
    }

    @Override
    public boolean isOperationApplicable() {
        StringBuilder strItemsMessage = new StringBuilder();
        ISaleReturnLineItem lineItem = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        String strEnterItem = getScopedValue(ValueKeys.ENTERED_ITEM_ID);
        String lineItemTypeCode = lineItem.getCompositeSaleReturnLineItemTypeCode();
        ItemMessageCrossReferencePropertyId crossReferencePropertyId = new ItemMessageCrossReferencePropertyId();
        IItemMessageCrossReferenceProperty crossReferenceProperty = null;

        @SuppressWarnings("unchecked")
        Map<String, List<CawItemMessage>> mapListCawItemMess = _transactionScope.getValue(CawValueKeys.CAW_MAP_ITM_MSG);
        if (mapListCawItemMess == null) {
            mapListCawItemMess = new HashMap<>();
        }
        List<CawItemMessage> listCawItemMessages = new ArrayList<>();

        List<IItemMessage> listItemMessage = CawItemHelper.getInstance().getItmMsgByQuery(lineItem);
        String messageId = StringUtils.EMPTY;
        String strMessage = StringUtils.EMPTY;
        if (CollectionUtils.isNotEmpty(listItemMessage)) {

            String itemId = lineItem.getItemId();
            for (IItemMessage itemMessage : listItemMessage) {
                messageId = itemMessage.getMessageId();
                crossReferencePropertyId.setItemId(itemId);
                crossReferencePropertyId.setMessageId(messageId);
                crossReferencePropertyId.setOrganizationId(ConfigurationMgr.getOrganizationId());
                crossReferencePropertyId.setPropertyCode(CawConstants.CAW_ITM_MSG_REF);
                try {
                    crossReferenceProperty = DataFactory.getObjectById(crossReferencePropertyId);
                    String strcrossRePValue = crossReferenceProperty.getStringValue();
                    if (CawConstants.CAW_ITM_MSG_FOR_BOTH.equalsIgnoreCase(strcrossRePValue)
                            || CawConstants.CAW_ITM_MSG_FOR_CASHIER.equalsIgnoreCase(strcrossRePValue)) {
                        strMessage = CawItemHelper.getInstance().getMessageInfor(itemMessage, crossReferenceProperty);
                        strItemsMessage.append(strMessage + StringUtils.NEW_LINE);
                    }
                    if (CawConstants.CAW_ITM_MSG_FOR_BOTH.equalsIgnoreCase(strcrossRePValue)
                            || CawConstants.CAW_ITM_MSG_FOR_RECEIPT.equalsIgnoreCase(strcrossRePValue)) {

                        strMessage = CawItemHelper.getInstance().getMessageInfor(itemMessage, crossReferenceProperty);
                        CawItemMessage cawItemMessage = new CawItemMessage(messageId, strcrossRePValue, strMessage);
                        listCawItemMessages.add(cawItemMessage);

                    }
                } catch (Exception e) {
                    _logger.warn("Do not have item Specific Message of item in  itm_item_msg_cross_reference_p");
                }
            }

            if (CollectionUtils.isNotEmpty(listCawItemMessages)) {
                mapListCawItemMess.put(itemId + CawConstants.CAW_COLON_SIGN
                        + lineItem.getLineItemSequence(), listCawItemMessages);
                _transactionScope.setValue(CawValueKeys.CAW_MAP_ITM_MSG, mapListCawItemMess);
            }
            if (strItemsMessage.length() > 0 && CawConstants.CAW_ITM_LINE_ITEM_SALE_TYPE_CODE.equals(lineItemTypeCode)
                    && !StringUtils.isEmpty(strEnterItem)) {
                strItemsMessagePrompt = strItemsMessage.toString();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
        IFormattable args[] = new IFormattable[1];
        args[0] = _ff.getSimpleFormattable(strItemsMessagePrompt, FormatterType.SIMPLE);
        return args;
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {
        return HELPER.completeResponse();
    }

}
