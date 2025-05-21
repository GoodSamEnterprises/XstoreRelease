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
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 * BZ27629          210918    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import caw.pos.common.CawValueKeys;
import caw.pos.common.CawVoucherValue;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawBalanceInquiryInitialStateOp extends Operation {

    private OpChainKey CAW_SALE_XPAY_BALANCE_INQUIRY_MCR = OpChainKey
            .valueOf("CAW_SALE_XPAY_BALANCE_INQUIRY_MCR");

    private OpChainKey XPAY_BALANCE_INQUIRY_MCR          = OpChainKey
            .valueOf("XPAY_BALANCE_INQUIRY_MCR");

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        if (_stationState.getSystemUser().getOperatorId() != 0) {// Check user is login
            setScopedValue(CawValueKeys.BALANCE_INQUIRY_COME_FROM, CawVoucherValue.FROM_REG_OPTION);
            return HELPER
                    .getStartChainResponse(CAW_SALE_XPAY_BALANCE_INQUIRY_MCR);
        } else {
            // Begin BZ27629
            CawVoucherValue.setVOUCHER_CARD_NUMBER("");
            CawVoucherValue.setVOUCHER_TRACE_NUMBER("");
            // Begin BZ27629
            return HELPER.getStartChainResponse(XPAY_BALANCE_INQUIRY_MCR);
        }
    }

}
