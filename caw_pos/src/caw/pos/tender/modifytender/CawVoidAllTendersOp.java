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
 * BZ29406          180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 *===================================================================
 */

package caw.pos.tender.modifytender;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import dtv.pos.common.OpChainKey;
import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.util.StringUtils;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.IAuthorizableLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;
import dtv.xst.dao.ttr.IVoucherTenderLineItem;

/**
 * Support to void all tenders.
 */
public class CawVoidAllTendersOp extends Operation {

    @Inject
    private CustomerAccountHelper _accountHelper;

    private boolean               disallowAuthorizedTenders_;

    private boolean               disallowVoidedTenders_;

    private boolean               disallowNonVoidableTenders_;

    private boolean               disallowChangeTenders_;

    private boolean               disallowRoundingTenders_;

    private boolean               disallowVoucherTenders_;

    private boolean               disallowLayawayPaymentTenders_;

    /**
     * @return the disallowAuthorizedTenders
     */
    public boolean isDisallowAuthorizedTenders() {

        return disallowAuthorizedTenders_;
    }

    /**
     * @param argDisallowAuthorizedTenders the disallowAuthorizedTenders to set
     */
    public void setDisallowAuthorizedTenders(boolean argDisallowAuthorizedTenders) {

        disallowAuthorizedTenders_ = argDisallowAuthorizedTenders;
    }

    /**
     * @return the disallowVoidedTenders
     */
    public boolean isDisallowVoidedTenders() {

        return disallowVoidedTenders_;
    }

    /**
     * @param argDisallowVoidedTenders the disallowVoidedTenders to set
     */
    public void setDisallowVoidedTenders(boolean argDisallowVoidedTenders) {

        disallowVoidedTenders_ = argDisallowVoidedTenders;
    }

    /**
     * @return the disallowNonVoidableTenders
     */
    public boolean isDisallowNonVoidableTenders() {

        return disallowNonVoidableTenders_;
    }

    /**
     * @param argDisallowNonVoidableTenders the disallowNonVoidableTenders to set
     */
    public void setDisallowNonVoidableTenders(boolean argDisallowNonVoidableTenders) {

        disallowNonVoidableTenders_ = argDisallowNonVoidableTenders;
    }

    /**
     * @return the disallowChangeTenders
     */
    public boolean isDisallowChangeTenders() {

        return disallowChangeTenders_;
    }

    /**
     * @param argDisallowChangeTenders the disallowChangeTenders to set
     */
    public void setDisallowChangeTenders(boolean argDisallowChangeTenders) {

        disallowChangeTenders_ = argDisallowChangeTenders;
    }

    /**
     * @return the disallowRoundingTenders
     */
    public boolean isDisallowRoundingTenders() {

        return disallowRoundingTenders_;
    }

    /**
     * @param argDisallowRoundingTenders the disallowRoundingTenders to set
     */
    public void setDisallowRoundingTenders(boolean argDisallowRoundingTenders) {

        disallowRoundingTenders_ = argDisallowRoundingTenders;
    }

    /**
     * @return the disallowVoucherTenders
     */
    public boolean isDisallowVoucherTenders() {

        return disallowVoucherTenders_;
    }

    /**
     * @param argDisallowVoucherTenders the disallowVoucherTenders to set
     */
    public void setDisallowVoucherTenders(boolean argDisallowVoucherTenders) {

        disallowVoucherTenders_ = argDisallowVoucherTenders;
    }

    /**
     * @return the disallowLayawayPaymentTenders
     */
    public boolean isDisallowLayawayPaymentTenders() {

        return disallowLayawayPaymentTenders_;
    }

    /**
     * @param argDisallowLayawayPaymentTenders the disallowLayawayPaymentTenders to set
     */
    public void setDisallowLayawayPaymentTenders(boolean argDisallowLayawayPaymentTenders) {

        disallowLayawayPaymentTenders_ = argDisallowLayawayPaymentTenders;
    }

    /**
     *  Default constructor.
     */
    public CawVoidAllTendersOp() {

        // default the values to typical settings
        setDisallowVoidedTenders(true);
        setDisallowChangeTenders(true);
        setDisallowLayawayPaymentTenders(true);
        setDisallowAuthorizedTenders(false);
        setDisallowRoundingTenders(true);
        setDisallowNonVoidableTenders(true);
        setDisallowVoucherTenders(false);
    }

    /**
     * Checks whether the given tender line item has been authorized.
     *
     * @param tenderLine A tender line item
     * @return If the tender line item has been authorized
     */
    protected boolean checkTenderAuth(ITenderLineItem tenderLine) {

        if (!isDisallowAuthorizedTenders()) {
            return false;
        }
        if (!(tenderLine instanceof IAuthorizableLineItem)) {
            // not authorizable, so no way to be auth'ed
            return false;
        }
        IAuthorizableLineItem authTender = (IAuthorizableLineItem) tenderLine;

        /* Check flag being used to help determine whether or not a tender has been authorized. (i.e. credit
         * reversals from some payment processors do not include an authorization code) */
        if (!StringUtils.isEmpty(authTender.getAuthorizationCode())
                || tenderLine.getBooleanProperty("ApprovalFlag", false)) {
            return true;
        }
        // doesn't have an adjudication code or an authorization code, so not auth'ed
        return false;
    }

    /**
     * Checks whether the given tender line item has a status of null or CHANGE.
     *
     * @param tenderLine the tender line
     * @return If the tender line item status is null or CHANGE
     */
    protected boolean checkTenderChange(ITenderLineItem tenderLine) {

        if (!disallowChangeTenders_) {
            return false;
        }
        return (tenderLine.getTenderStatusCode() == null)
                || (TenderStatus.forName(tenderLine.getTenderStatusCode()) == TenderStatus.CHANGE);
    }

    /**
     * Checks whether the given tender line item is a layaway ACCOUNT_CREDIT.
     *
     * @param tenderLine A tender line item
     * @return If the tender line item is a layaway ACCOUNT_CREDIT
     */
    protected boolean checkTenderLayaway(ITenderLineItem tenderLine) {

        return isDisallowLayawayPaymentTenders() && _accountHelper.isAccountCreditTenderLine(tenderLine);
    }

    /**
     * Check tender non voidable.
     *
     * @param it the it
     * @return true, if successful
     */
    protected boolean checkTenderNonVoidable(ITenderLineItem it) {

        return isDisallowNonVoidableTenders() && it.getTender().getOptions().getNonVoidable();
    }

    /**
     * Checks whether the given tender line item has been voided.
     *
     * @param tenderLine A tender line item
     * @return If the tender line item has been voided
     */
    protected boolean checkTenderVoid(ITenderLineItem tenderLine) {

        return isDisallowVoidedTenders() && tenderLine.getVoid();
    }

    /**
     * Checks whether the given tender line item is a voucher.
     *
     * @param tenderLine A tender line item
     * @return If the tender line item is a voucher
     */
    protected boolean checkTenderVoucher(ITenderLineItem tenderLine) {

        return isDisallowVoucherTenders() && (tenderLine instanceof IVoucherTenderLineItem);
    }

    /**
     * Performs additional checks on a tender line. Customer operations can override this method to modify the
     * behavior of <tt>{@link #getPromptList(IXstCommand, IXstEvent)}</tt> without needing override the entire
     * method or to change another tender check.
     *
     * @param argTenderLine the tender line item to test
     * @return <code>true</code> to exclude the line item, <code>false</code> to include it
     */
    protected boolean doAdditionalChecks(ITenderLineItem argTenderLine) {

        return false;
    }

    /* Process void all tender lines
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IPosTransaction trans = _transactionScope.getTransaction();
        List<ITenderLineItem> tenders = trans.getLineItems(ITenderLineItem.class);
        
        if (CollectionUtils.isNotEmpty(tenders)) {
            for (ITenderLineItem line : tenders) {
                // check to make sure this is a non-voided, non-change, non-authorized, non-layaway,
                // non-voucher tender line item
                if (checkTenderVoid(line)) {
                    continue;
                }
                if (checkTenderChange(line)) {
                    continue;
                }
                if (checkTenderAuth(line)) {
                    continue;
                }
                if (checkTenderLayaway(line)) {
                    continue;
                }
                if (checkTenderVoucher(line)) {
                    continue;
                }
                if (checkTenderNonVoidable(line)) {
                    continue;
                }
                if (doAdditionalChecks(line)) {
                    continue;
                }
                setScopedValue(ValueKeys.CURRENT_TENDER_LINE, line);
                return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CAW_VOID_TENDER"));
            }
        }
        return HELPER.completeResponse();
    }
}
