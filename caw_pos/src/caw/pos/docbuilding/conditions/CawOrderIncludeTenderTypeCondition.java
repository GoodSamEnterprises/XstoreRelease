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
 * BZ37709          080920    [Internal] Removing the customer's signature line on Store Copy receipt of Create Order transaction
 * BZ37621          070920    [Internal] Receipt messages on the "Order Copy" of Emailed receipt does not match Camping World 
 *===================================================================
 */
package caw.pos.docbuilding.conditions;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.List;

import javax.inject.Inject;

import dtv.pos.docbuilding.conditions.IncludeTenderTypeCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.order.OrderReceiptSource;
import dtv.pos.register.type.LineItemType;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.tnd.TenderCategory;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.ttr.ITenderLineItem;

public class CawOrderIncludeTenderTypeCondition extends IncludeTenderTypeCondition {
    
    @Inject
    protected TransactionScope _transactionScope;
    private TenderCategory     tndrCategory_;

    public CawOrderIncludeTenderTypeCondition() {
        super();
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof OrderReceiptSource
                && _transactionScope.getTransaction(RETAIL_SALE) != null) {
            RetailTransactionModel trans = (RetailTransactionModel) _transactionScope.getTransaction(RETAIL_SALE);
            List<IRetailTransactionLineItem> lineItems = trans.getLineItemsByTypeCode(LineItemType.TENDER.getName());

            if (lineItems != null) {
                for (IRetailTransactionLineItem lineItem : lineItems) {
                    ITenderLineItem tenderLine = (ITenderLineItem) lineItem;
                    if (tenderLine.getTender().getTenderTypecode()
                            .equalsIgnoreCase(this.tndrCategory_.getName())
                            && !tenderLine.getVoid()) {

                        return true;
                    }
                }
            }
        } else if (argSource instanceof ITenderLineItem) {
            ITenderLineItem model = (ITenderLineItem) argSource;
            if (model.getTender().getTenderTypecode().equalsIgnoreCase(this.tndrCategory_.getName())) {
                return true;
            }
        }

        return false;
    }
}
