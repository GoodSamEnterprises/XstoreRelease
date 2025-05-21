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
 * BZ24414          091117    When Adding New Customer for Warranty Item New 'Logoff' Button Appears
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 *===================================================================
 */

package caw.pos.customer;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Add flag to identify Customer Search using Back button or Log off button
 */
public class CawIsBackCustSearchFormOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {
        clearScopedValue(CawValueKeys.CARD_ACTIVE_STATUS);//BZ25958
        _transactionScope
                .setValue(CawValueKeys.FN_BACK_CUST_SEARCH, Boolean.TRUE); // BZ 24414
        return HELPER.completeResponse();
    }

}
