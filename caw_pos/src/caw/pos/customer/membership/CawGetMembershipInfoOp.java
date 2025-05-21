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
 * Req/Bug ID#          ddMMyy    Description
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27851              121018     [Internal][27339] Membership info is empty at Account tab when select&View customer has membership info.
 *===================================================================
 */

package caw.pos.customer.membership;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.customer.CawCustomerHelper;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;

/**
 * The CawGetMembershipInfoOp class
 */
public class CawGetMembershipInfoOp extends Operation {

    /** (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {

        // BZ27851 start
        IParty cust = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        String jsonMessage = CawCatalystHelper.getLookupResponseData();
        CawCustomerHelper _custHelper = CawCustomerHelper.getInstance();
        _custHelper.loadMembershipInfo(cust, jsonMessage);
        //BZ27851 end

        return HELPER.completeResponse();
    }

}
