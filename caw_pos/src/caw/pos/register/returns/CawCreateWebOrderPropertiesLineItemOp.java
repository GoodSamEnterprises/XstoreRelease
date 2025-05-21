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
 * BZ25068          220118    New Requirement to Process Web Order Returns
 * BZ27924          231018    [Internal] Tender type of Return web order displayed incorrect when pressing 'Exit return' to do new return types trans
 *===================================================================
 */

package caw.pos.register.returns;

import java.util.ArrayList;
import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.IRetailTransactionLineItemProperty;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

/**
 *
 */
public class CawCreateWebOrderPropertiesLineItemOp extends Operation {

    private static final String STRING                  = "STRING";

    private static final String SALES_ORDER_INFORMATION = "salesOrderInformation";

    @Override
    public boolean isOperationApplicable() {

        if (_transactionScope.getValue(CawValueKeys.IS_RETURN_WEB_ORDER) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_RETURN_WEB_ORDER)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @SuppressWarnings("null")
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        //Begin BZ27924
        List<ISaleReturnLineItem> lineItems = _transactionScope
                .getValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER);
        if (lineItems == null) {
            lineItems = new ArrayList<ISaleReturnLineItem>();
        }
        //End BZ27924
        ISaleReturnLineItem iSaleLineItm = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        if (iSaleLineItm instanceof SaleReturnLineItemModel) {
            SaleReturnLineItemModel saleLineItm = (SaleReturnLineItemModel) iSaleLineItm;

            IRetailTransactionLineItemProperty id = DataFactory
                    .createObject(IRetailTransactionLineItemProperty.class);
            id.setOrganizationId(Long.valueOf(saleLineItm.getOrganizationId()));
            id.setRetailLocationId(Long
                    .valueOf(saleLineItm.getRetailLocationId()));
            id.setWorkstationId(Long.valueOf(saleLineItm.getWorkstationId()));
            id.setBusinessDate(saleLineItm.getBusinessDate());
            id.setTransactionSequence(Long
                    .valueOf(saleLineItm.getTransactionSequence()));
            id.setRetailTransactionLineItemSequence(Integer.valueOf(saleLineItm
                    .getRetailTransactionLineItemSequence()));
            id.setPropertyCode(SALES_ORDER_INFORMATION);
            id.setStringValue(STRING);
            id.setPropertyValue(saleLineItm.getReturnComment());

            saleLineItm.addRetailTransactionLineItemProperty(id);
            lineItems.add(saleLineItm);//BZ27924
        }
        _transactionScope
                .setValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER, lineItems);//BZ27924
        return HELPER.completeResponse();
    }

}
