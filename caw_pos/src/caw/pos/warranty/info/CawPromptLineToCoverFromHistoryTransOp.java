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
 * BZ26879          310718    [New Requirement] Add reference to Original item on Order Service
 *===================================================================
 */

package caw.pos.warranty.info;

import static org.apache.commons.lang3.math.NumberUtils.toLong;

import dtv.hardware.types.HardwareType;
import dtv.pos.register.ItemLocator;
import dtv.pos.warranty.info.PromptLineToCoverFromHistoryTransOp;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.SaleItemType;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 * This class is used to adding BusinessDate  (transaction date) 
 * to current line item in case add Item warranty via customer history
 */
public class CawPromptLineToCoverFromHistoryTransOp
        extends PromptLineToCoverFromHistoryTransOp {

    @Override
    protected ISaleReturnLineItem convertToSaleLineItem(
            CustomerTransHistoryResult argCustHistoryItem) {

        IItem item = ItemLocator.getLocator()
                .lookupItem(argCustHistoryItem.getItemId());
        SaleItemType saleItemType = SaleItemType
                .forName(argCustHistoryItem.getSaleItemType());
        String entryMethod = HardwareType.KEYBOARD.getName();

        ISaleReturnLineItem lineItem = ItemLocator.getLocator()
                .getSaleLineItem(item, saleItemType, entryMethod);

        lineItem.setRetailLocationId(toLong(argCustHistoryItem
                .getRetailLocationId()));
        lineItem.setWorkstationId(toLong(argCustHistoryItem
                .getWorkstationId()));
        lineItem.setQuantity(argCustHistoryItem.getQty());
        lineItem.setTransactionSequence(argCustHistoryItem.getTransSeq());
        //Begin BZ26879 added
        lineItem.setBusinessDate(argCustHistoryItem.getTransactionDate());
        //End BZ26879
        Long lineItemSeq = argCustHistoryItem.getLineItemSeq();

        if (lineItemSeq != null) {
            lineItem.setRetailTransactionLineItemSequence(lineItemSeq
                    .intValue());
        }

        return lineItem;
    }
}
