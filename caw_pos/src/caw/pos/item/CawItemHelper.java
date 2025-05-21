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
 * BZ29625          080419    [New Requirement] - Auto-Renewal Item Specific Receipts
 *===================================================================
 */

package caw.pos.item;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import caw.pos.common.CawConstants;
import caw.pos.common.CawQueryConstants;
import dtv.data2.access.DataFactory;
import dtv.data2.access.IQueryResultList;
import dtv.util.StringUtils;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.ISaleReturnLineItem;


public class CawItemHelper {

    private static final Logger           _logger  = LogManager.getLogger(CawItemHelper.class);

    private static volatile CawItemHelper instance = null;

    private CawItemHelper() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawItemHelper
     */
    public static CawItemHelper getInstance() {

        if (instance == null) {
            synchronized (CawItemHelper.class) {
                if (instance == null) {
                    instance = new CawItemHelper();
                }
            }
        }
        return instance;
    }

    /***
     * Get list message of item from ITM_ITEM_MSG by query to DB from sale return line item.
     * @param argLine
     * @return
     */
    public List<IItemMessage> getItmMsgByQuery(ISaleReturnLineItem argLine) {

        if (argLine == null) {
            return null;
        }
        boolean showItemMessage = argLine.getItem().getOptions().getMessages();
        if (!showItemMessage) {
            return null;
        }
        try {
            Date getTransactionDate = argLine.getTransactionDate();
            if (getTransactionDate == null) {
                return null;
            }
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("argMessageKey", CawConstants.CAW_ITM_MESS);
            params.put("argItemId", argLine.getItem().getItemId());
            params.put("argDate", argLine.getTransactionDate());
            IQueryResultList<IItemMessage> c = DataFactory
                    .getObjectByQuery(CawQueryConstants.CAW_ITEM_MESSAGES, params);
            if (c.isEmpty()) {
                return null;
            }
            return c;

        } catch (Exception ie) {
            _logger.info(ie);
            return null;
        }
    }

    /***
     * Get message of item from messageId
     * @param itemMessage
     * @param crossReferenceProperty
     * @return
     */
    public String getMessageInfor(IItemMessage itemMessage,
            IItemMessageCrossReferenceProperty crossReferenceProperty) {
        String strItemsMessage = StringUtils.EMPTY;
        if (itemMessage != null && crossReferenceProperty != null) {
            List<IItemMessageProperty> iItemMessageProperties = itemMessage.getProperties();
            for (IItemMessageProperty iItemMessageProperty : iItemMessageProperties) {
                if (crossReferenceProperty.getMessageId().equalsIgnoreCase(iItemMessageProperty.getMessageId())
                        && CawConstants.CAW_ITM_MESS.equals(iItemMessageProperty.getPropertyCode())) {
                    strItemsMessage = iItemMessageProperty.getStringValue();
                }
            }
        }
        return strItemsMessage;
    }

    /**
     * @param listCawItemMessages
     * @param cawItemMessage
     */
    public boolean checkDuplicateItemMSGId(List<CawItemMessage> cawItemMessages, CawItemMessage cawItemMessage) {
        boolean isExist = false;
        if (CollectionUtils.isNotEmpty(cawItemMessages)) {
            for (CawItemMessage cawItemMsgTemp : cawItemMessages) {
                if (cawItemMsgTemp.getMessageId().equalsIgnoreCase(cawItemMessage.getMessageId())) {
                    isExist = true;
                    break;
                }
            }
        }
         return isExist;
    }

}
