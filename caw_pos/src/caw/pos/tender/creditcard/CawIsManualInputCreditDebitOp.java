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
 * BZ27629          210918    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 *===================================================================
 */

package caw.pos.tender.creditcard;

import caw.pos.common.CawVoucherValue;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawIsManualInputCreditDebitOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        CawVoucherValue.setIS_MANUAL_INPUT_CREDIT(true);
        return HELPER.completeResponse();
    }
}
