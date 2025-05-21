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
 * BZ23164              100917    [DEV] Implement EMV Payment Integration
 *== ================================================================
 */

package caw.tender.impl.mira.op;

import javax.inject.Inject;

import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

public class CawCreditCardInfoOp extends Operation {

    /**
     * 
     */
    private static final String CREDIT_CARD           = "CREDIT_CARD";

    protected final IOpState    POST_ACCT_INFO_PROMPT = new OpState(
            "POST_ACCT_INFO_PROMPT");

    @Inject
    private TenderHelper        _tenderHelper;

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        ITenderLineItem tl = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        ICreditDebitTenderLineItem creditCardTender = (ICreditDebitTenderLineItem) tl;
        creditCardTender
                .setEntryMethodCode(CawEigenConstants.MIRA_ENTRY_METHOD_SWIPED);
        setOpState(POST_ACCT_INFO_PROMPT);

        // Use the setting for Credit card for EMV
        String tenderIdName = CREDIT_CARD;
        _tenderHelper.setTenderIdType(creditCardTender, tenderIdName);
        return HELPER.completeResponse();
    }

}
