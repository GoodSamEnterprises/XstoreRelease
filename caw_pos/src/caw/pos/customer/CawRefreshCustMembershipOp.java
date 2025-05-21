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
 * BZ24410          091117    [Advance Prompting] POS Sale screen does not 
 *                            display membership number, exp date and pricing 
 *                            for new member joins
 * BZ26715          110918   [PROD] Tax Codes not flowing to Oracle
 *===================================================================
 */

package caw.pos.customer;

import caw.pos.common.CawConstants;

import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;

/**
 * Re-add customer party in order to refresh membership information.
 */
public class CawRefreshCustMembershipOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        if (party != null && _transactionScope
                .getTransaction(TransactionType.RETAIL_SALE) != null) {
            _transactionScope.getTransaction(TransactionType.RETAIL_SALE)
                    .setCustomerParty(party); // BZ 24410
        }

        return HELPER.completeResponse();
    }

    //Begin BZ26715
    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
    //End BZ26715
}
