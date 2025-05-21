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
 * BZ29134          290119    [Internal] The Account Lookup flow should be aborted after three failed attempts look up a customer hasn't found in system.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.CawEigenHelper;

import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

public class CawGSAccountThreeFailedAttemptsSSNOp extends PromptOp {

    @Inject
    private CawEigenHelper _cawEigenHelper;

    @Override
    public PromptKey getDefaultPromptKey() {

        clearScopedValue(CawValueKeys.CAW_THREE_FAILED_ATTEMPTS_SSN);
        return PromptKey.valueOf("CAW_GS_ACCOUNT_THREE_FAILED_ATTEMPTS_SSN");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        if (argEvent != null) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();

            if (key.equals(XstDataActionKey.ACCEPT)) {
                _cawEigenHelper.refreshPinpadScreen(_transactionScope);
                return HELPER.getStartChainResponse(OpChainKey.valueOf("SALE_ITEM_START"));
            }
        }
        return HELPER.completeResponse();
    }

}
