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
 * BZ26431          040618    [25590] Should be displayed indicating item cannot sold due to no price instead of pulling ($0.01) after removing membership customer.
 *===================================================================
 */

package caw.pos.register.sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawRemoveNoRegularPriceItem extends PromptOp {

    private static final BigDecimal   DEFAULT_PRICE    = new BigDecimal(
            "-0.01");

    private List<ISaleReturnLineItem> listNoPriceItems = new ArrayList<>();

    private int                       size             = 0;

    /* Show Prompt if there 1 or more no price item(s)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        IRetailTransaction currentTransaction = _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE);

        if (currentTransaction != null) {
            List<IRetailTransactionLineItem> listLineItems = currentTransaction
                    .getRetailTransactionLineItems();
            size = listLineItems.size();
            ISaleReturnLineItem lineItem = null;
            BigDecimal regularBasePrice = null;

            if (size > 0) {

                for (int i = 0; i < size; i++) {

                    if (listLineItems.get(i) instanceof ISaleReturnLineItem) {
                        lineItem = (ISaleReturnLineItem) listLineItems.get(i);
                        regularBasePrice = lineItem.getRegularBasePrice();

                        if (!lineItem.getVoid()) {

                            if (regularBasePrice == null || regularBasePrice
                                    .compareTo(DEFAULT_PRICE) == 0) {
                                listNoPriceItems.add(lineItem);
                            }
                        }
                    }
                }
            }
        }

        if (!listNoPriceItems.isEmpty()) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    /* Prompt CAW_NO_REGULAR_PRICE_ITEM
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_NO_REGULAR_PRICE_ITEM");
    }

    /* Show which item(s) has no regular price on Prompt
     * @see dtv.pos.framework.op.AbstractPromptOp#getPromptArgs(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        List<String> listItemId = new ArrayList<>();
        String itemId = null;
        size = listNoPriceItems.size();
        IFormattable args[] = new IFormattable[size];

        for (int i = 0; i < size; i++) {
            itemId = listNoPriceItems.get(i).getItemId();
            if (!listItemId.contains(itemId)) {
                listItemId.add(itemId);
            }
        }

        args[0] = _ff.getSimpleFormattable(String.join(", ", listItemId));

        return args;
    }

    /* Press ENTER to close Prompt and remove no price item(s)
     * @see dtv.pos.framework.op.AbstractPromptOp#handleDataAction(dtv.pos.iframework.action.IXstDataAction)
     */
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        IXstActionKey actionKey = argEvent.getActionKey();

        if (XstDataActionKey.ACCEPT.equals(actionKey)) {

            for (ISaleReturnLineItem lineItem : listNoPriceItems) {
                lineItem.setVoid(Boolean.TRUE);
            }
            return HELPER.completeResponse();
        }

        return super.handleDataAction(argEvent);
    }

}
