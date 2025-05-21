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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ47542          061221    RV Service Payments - Property Names
 *===================================================================
 */

package caw.pos.register;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawAddSaleLineItemPropertyOp extends Operation{
    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {
        ISaleReturnLineItem line = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        if(line != null) {
            if(this.getScopedValue(CawValueKeys.WONDERSIGN_CART_ID) != null) {
                String cartId = this.getScopedValue(CawValueKeys.WONDERSIGN_CART_ID);
                line.setStringProperty(CawConstants.WONDERSIGN_CART_ID, cartId);
                this.clearScopedValue(CawValueKeys.WONDERSIGN_CART_ID);
                /*BEGIN BZ44917*/
            }else if(this.getScopedValue(CawValueKeys.CAW_RV_PROPERTIES) != null) {
                String properties = this.getScopedValue(CawValueKeys.CAW_RV_PROPERTIES);
                line.setStringProperty(CawConstants.RV_SERVICE_PAYMENT_PROPERTIES, properties);/*BZ47542*/
            }
            /*END BZ44917*/
        }
        return this.HELPER.completeResponse();
    }

}
