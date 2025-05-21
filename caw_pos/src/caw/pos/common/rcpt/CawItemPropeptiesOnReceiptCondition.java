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
 * BZ28201          141118    [New Requirement] Additional Item Prompts and attributes for 500 item needs to print on transaction receipts.
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ46743          100122    Vehicle Identification Number (VIN) Capture for Xstore
 *===================================================================
 */

package caw.pos.common.rcpt;

import caw.pos.customer.CawCustomerConstants;
import caw.pos.register.rvpayment.CawRvPaymentHelper;
import caw.pos.register.vin.CawVinHelper;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.xom.IOrderLine;
import dtv.xst.dao.xom.impl.OrderLineModel;

/**
 *
 */
public class CawItemPropeptiesOnReceiptCondition extends AbstractInvertableCondition {

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof SaleReturnLineItemModel) {
            ISaleReturnLineItem saleLineItem = (ISaleReturnLineItem) argSource;
            /*BEGIN BZ44917*/
            if(CawRvPaymentHelper.isRvPaymentSaleLineItem(saleLineItem)) {
                return true;
            }
            /*END BZ44917*/
            else {
                String code = ((SaleReturnLineItemModel) argSource).getItemId();
                if(code != null && !code.isEmpty()) {
                    ICodeValue iReasonCode = CodeLocator.getCodeValue(ConfigurationMgr
                            .getOrganizationId(), CawCustomerConstants.CAW_RECEIPT_ITEM_PROPERTIES, code);

                    if (iReasonCode != null) {
                        return true;
                    }
                }
            }
            
        }
        
        /* BEGIN BZ46743 */
        if (argSource instanceof OrderLineModel) {
            
            IOrderLine orderLine = (IOrderLine)argSource;
            
            if (CawVinHelper.isVinItem(orderLine.getShadowedSaleItem().getItem())) {
                return true;
            }
        }
        /* END BZ46743 */

        return false;
    }
}
