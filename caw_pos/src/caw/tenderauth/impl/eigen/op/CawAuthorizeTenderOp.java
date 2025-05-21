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
 * BZ23356          011017    CWS Will Require a Printed Decline Receipt for EMV Tenders
 * BZ49199          300322    Patch 19 - WO - Unable to Complete Full Refund Amount
 * BZ49313          170422    [Internal] Return receipt is NOT printed when refund the sale amount to original Credit/Debit Card declined.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import java.util.ArrayList;
import java.util.List;

import caw.pos.common.CawValueKeys;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.CawDeclinedReferenceData;

import dtv.pos.common.FormKey;
import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.spring.TransactionScopeKeys;
import dtv.pos.spring.ValueKeys;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.form.TenderAuthEditModel;
import dtv.tenderauth.impl.op.AuthorizeTenderOp;
import dtv.util.IReceiptSource;
import dtv.util.StringUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawAuthorizeTenderOp extends AuthorizeTenderOp {

    /**
     * 
     */
    private static final String DECLIN   = "DECLIN";

    private static final String DECLINED = "DECLINED";

    private DataActionGroupKey  actionGroup;

    private TenderAuthEditModel editModel;

    /**
     * 
     */
    public CawAuthorizeTenderOp() {

        InjectionHammer.forceAtInjectProcessing(this);
    }

    List<IReceiptSource>   rcptSrclistOrg          = new ArrayList<IReceiptSource>();

    private final IOpState COMPLETE_PRINT_DECLINED = new OpState("COMPLETE_PRINT_DECLINED");

    private final String   ASKING_TO_CANCEL_STATE_NAME        = "ASKING_TO_CANCEL";/*BZ49199*/

    @Override
    protected IOpResponse handleBasedOnState(IXstEvent argEvent) {
        IOpState state = this.getOpState();
        if (state == COMPLETE_PRINT_DECLINED) {
            this.setOpState(this.SHOWING_FAILED);
            clearScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE);/*BZ49313*/
            return this.showAuthFailed();
        } else {
            /*BEGIN BZ49199*/
            if(state != null && StringUtils.equivalentIgnoreCase(ASKING_TO_CANCEL_STATE_NAME, state.getName()) 
                    && argEvent == null) {
                this.setOpState(null);
            }
            /*END BZ49199*/
            return super.handleBasedOnState(argEvent);
        }
    }

    @Override
    protected IOpResponse handleFailed(IAuthResponse argResponse) {

        this._transactionScope
                .clearValue(TransactionScopeKeys.SAVED_TENDER_INPUT);
        if (!COMPLETE_PRINT_DECLINED.equals(this.getOpState())) {
            if (argResponse instanceof CawMiraResponse) {
                CawMiraResponse response = (CawMiraResponse) argResponse;
                ITenderLineItem tenderLineItem = (ITenderLineItem) response
                        .getRequest().getLineItem();
                if (tenderLineItem != null
                        && tenderLineItem instanceof ICreditDebitTenderLineItem) {
                    ICreditDebitTenderLineItem creditDebitLineItem = (ICreditDebitTenderLineItem) tenderLineItem;
                    if (DECLINED
                            .equals(creditDebitLineItem.getAdjudicationCode())
                            || DECLIN.equals(creditDebitLineItem
                                    .getAuthorizationCode())) {
                        setRcptSrclistOrg(getScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE));
                        CawDeclinedReferenceData declineBean = _transactionScope
                                .getValue(CawValueKeys.DECLINED_DATA);
                        List<IReceiptSource> rcptSrclistOveride = new ArrayList<IReceiptSource>();
                        rcptSrclistOveride.add(declineBean);
                        this.setOpState(COMPLETE_PRINT_DECLINED);
                        setScopedValue(ValueKeys.CURRENT_RECEIPT_SOURCE, rcptSrclistOveride);

                        this.actionGroup = DataActionGroupKey.DEFAULT;
                        this.editModel = makeEditModel(argResponse);

                        return HELPER.getWaitStackChainResponse(OpChainKey
                                .valueOf("CAW_PRINT_DECLINED_RECEIPTS"));
                    }
                }
            }

        }
        return super.handleFailed(argResponse);
    }

    private IOpResponse showAuthFailed() {

        return this.HELPER.getShowFormResponse(FormKey
                .valueOf("AUTH_FAILED"), this.editModel, this.actionGroup);
    }

    /* (non-Javadoc)
     * @see dtv.tenderauth.impl.op.AbstractAuthorizeOp#handleInitialState()
     */
    @Override
    protected IOpResponse handleInitialState() {

        return super.handleInitialState();
    }

    /**
     * @return the rcptSrclistOrg
     */
    public List<IReceiptSource> getRcptSrclistOrg() {

        return rcptSrclistOrg;
    }

    /**
     * @param argRcptSrclistOrg the rcptSrclistOrg to set
     */
    public void setRcptSrclistOrg(List<IReceiptSource> argRcptSrclistOrg) {

        rcptSrclistOrg = argRcptSrclistOrg;
    }
}
