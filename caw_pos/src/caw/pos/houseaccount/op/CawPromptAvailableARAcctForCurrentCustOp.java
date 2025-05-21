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
 * BZ27177          140818    Account# attached into item#98920 displays sometimes incorrectly into House Account screen after entering valid payment amount.
 *===================================================================
 */

package caw.pos.houseaccount.op;

import javax.inject.Inject;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;

import dtv.pos.houseaccount.HouseAccountHelper;
import dtv.pos.houseaccount.op.PromptAvailableARAcctForCurrentCustOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.cat.ICustomerConsumerChargeAccount;
import dtv.xst.query.results.HouseAccountSearchResult;

/**
 * The CawPromptAvailableARAcctForCurrentCustOp class 
 */
public class CawPromptAvailableARAcctForCurrentCustOp
        extends PromptAvailableARAcctForCurrentCustOp {

    @Inject
    private HouseAccountHelper _houseAccountHelper;

    /** {@inheritDoc} */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        HouseAccountSearchResult result = (HouseAccountSearchResult) argEvent
                .getData();

        ICustomerConsumerChargeAccount account = (ICustomerConsumerChargeAccount) result
                .getPopulatedObject();

        //BZ27177 Begin
        if (account != null) {
            String jsonResponseEbs = CawCatalystHelper.getLookupResponseData();
            String accountNumber = CawCustomerUtil
                    .getAccountNumber(jsonResponseEbs);
            account.setCustAccountId(accountNumber);
        }
        //BZ27177 End

        setScopedValue(ValueKeys.CURRENT_HOUSE_ACCOUNT, account);

        _houseAccountHelper.setCurrentHouseAccount(account);

        return HELPER.completeResponse();
    }
}
