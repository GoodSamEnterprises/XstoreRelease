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

package caw.pos.tender.validation;

import caw.pos.common.CawVoucherValue;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Add flag to identify whether it is a tender exchange
 */
public class CawIsTenderExchangeAuthorize extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        CawVoucherValue.setIsTenderExchange(true);
        return HELPER.completeResponse();
    }

}
