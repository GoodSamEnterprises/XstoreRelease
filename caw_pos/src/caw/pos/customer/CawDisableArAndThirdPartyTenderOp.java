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
 * BZ26289          120718    New Requirement - Enable A/R Payment Functionality in Xstore
 *===================================================================
 */

package caw.pos.customer;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * The CawDisableArAndThirdPartyTenderOp class
 */
public class CawDisableArAndThirdPartyTenderOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        _transactionScope
                .setValue(CawValueKeys.IS_ALLOW_DISPLAY_AR_ACCOUNT, Boolean.FALSE); // BZ26289
        _transactionScope
        .setValue(CawValueKeys.IS_ALLOW_DISPLAY_THIRD_PARTY, Boolean.FALSE); // BZ26289
        return HELPER.completeResponse();
    }
}
