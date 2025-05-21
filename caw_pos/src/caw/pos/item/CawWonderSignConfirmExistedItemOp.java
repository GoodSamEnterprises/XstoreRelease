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
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.item;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.List;

import caw.pos.common.CawConstants;

import dtv.i18n.IFormattable;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptYesNoOp;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawWonderSignConfirmExistedItemOp extends PromptYesNoOp {

    private String _confirmItemType = null;
    private static final String CONFIRM_SALE_TYPE = "SALE";
    private static final String CONFIRM_ORDER_TYPE = "ORDER";
    @Override
    public boolean isOperationApplicable() {
    
        boolean prompt = Boolean.FALSE;
        IItem currentItem = this.getScopedValue(ValueKeys.CURRENT_ITEM);
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        if (trans != null) {//BZ42307
            List<ISaleReturnLineItem> lineItems = trans.getLineItems(ISaleReturnLineItem.class);
            if (lineItems != null) {
                for (ISaleReturnLineItem saleLineItem : lineItems) {
                    if (!saleLineItem.getVoid()
                            && CONFIRM_SALE_TYPE.equalsIgnoreCase(_confirmItemType)
                            && saleLineItem.getStringProperty(CawConstants.WONDERSIGN_CART_ID) != null
                            && saleLineItem.getItemId().equals(currentItem.getItemId())) {
                        prompt = Boolean.TRUE;
                    } else if (!saleLineItem.getVoid()
                            && CONFIRM_ORDER_TYPE.equalsIgnoreCase(_confirmItemType)
                            && saleLineItem.getItemId().equals(currentItem.getItemId())) {
                        prompt = Boolean.TRUE;
                    }
                }
            }
        }
        return prompt;
    }
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {
        ISaleReturnLineItem lineItem = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        IFormattable itemId = this._ff.getSimpleFormattable(lineItem.getItemId());
        return new IFormattable[] { itemId};
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        if (XstDataActionKey.NO.equals(argAction.getActionKey())) {
            this.clearScopedValue(ValueKeys.CURRENT_ITEM);
        }
        return super.handleDataAction(argAction);
    }

    @Override
    public void setParameter(String argName, String argValue) {

        if ("ConfirmItemType".equalsIgnoreCase(argName)) {
            this._confirmItemType = argValue;
        } else {
            super.setParameter(argName, argValue);
        }
    }
}
