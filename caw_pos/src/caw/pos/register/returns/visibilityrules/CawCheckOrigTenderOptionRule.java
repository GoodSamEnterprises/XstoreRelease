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
 * BZ27922          011118    [New Requirement] Make all tender changes configurable
 * BZ33089          251019    [5.0 UAT] Return with receipt a transaction with a Check Tender didn't have mail refund as an option.
 * BZ35659          060420    [PROD] Cash Tendering on Verified Returns and Show Work Orders
 * BZ63225          230424    Issue with refunds from Work Order Completes
 *===================================================================
 */

package caw.pos.register.returns.visibilityrules;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.tender.*;
import caw.pos.workorder.common.CawWorkOrderConstants;
import caw.pos.workorder.common.CawWorkOrderHelper;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.tender.TenderHelper;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawCheckOrigTenderOptionRule extends AbstractVisibilityRule {

    @Inject
    private TenderHelper        _tenderHelper;

    @Inject
    protected TransactionScope  _transactionScope;

    @Inject
    private ReturnManager       _returnMgr;

    private static final String TENDER = "tender";

    private String              _tenderId;
    
    private String localCurrency = null; //BZ35659

    /* (non-Javadoc)
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#setParameter(java.lang.String, java.lang.String)
     */
    @Override
    public void setParameter(String argName, String argValue) {

        if (TENDER.equalsIgnoreCase(argName)) {
            if (argValue
                    .equalsIgnoreCase(CawWorkOrderConstants.LOCAL_CURRENCY)) {
                this._tenderId = _tenderHelper.getLocalCurrencyTenderId();
                this.localCurrency = CawWorkOrderConstants.LOCAL_CURRENCY;
            } else {
                this._tenderId = argValue;
            }
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#checkVisibilityImpl()
     */
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {
        /* BEGIN BZ35659 */
        if (CawWorkOrderOptionsOp.isRefundAction() && CawWorkOrderConstants.LOCAL_CURRENCY.equalsIgnoreCase(this.localCurrency)) {
            CawRefundTenderConfig config = CawRefundTenderConfigHelper.getInstance().getConfig(this._tenderId);
            if (config != null) {
                return AccessLevel.GRANTED;
            } else {
                return AccessLevel.DENIED;
            }
        } else {
        /* END BZ35659 */
            //
            CawRefundTenderConfig config = CawRefundTenderConfigHelper
                    .getInstance().getConfig(this._tenderId);
            //
            IRetailTransaction trans = getCurrentRetailTransaction();
            //
            List<ISaleReturnLineItem> lineItemsWebReturn = _transactionScope
                    .getValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER);
            //
            List<IRetailTransaction> origTransList = _returnMgr
                    .getAllOrigTransaction();

            if (trans != null) {
                if (config == null) {
                    return AccessLevel.GRANTED;
                }

                BigDecimal balanceDue = trans.getAmountDue();
                String returntype = CawRefundTenderConfigHelper.getInstance().returnType(trans, lineItemsWebReturn);

                //Check amount of current transaction with transaction
                boolean isLesserReqAmtWithoutOrig = (balanceDue.abs().compareTo(config.getMinAmountWithoutOriginalTrans()) < 0);

                //Check current tender id's configuration
                ////Based on configuration: RefundTenderConfig.xml--CheckOriginalTransaction
                if (!config.getCheckOriginalTransaction() && !isLesserReqAmtWithoutOrig) {
                    return AccessLevel.GRANTED;
                }

                //Check if current return type should be granted
                //Based on configuration: RefundTenderConfig.xml--NoRequiredOriginalTransaction
                if (config.getNoRequiredOrigTrans().contains(returntype)) {
                    return AccessLevel.GRANTED;
                }

                if (origTransList != null && !origTransList.isEmpty()) {
                    //Check if orig trans contains current tender id
                    boolean isAvailable = CawRefundTenderConfigHelper.getInstance().isAvailable(this._tenderId, config, origTransList, balanceDue.abs()); /*BZ33089*/
                    //BEGIN BZ63225
                    boolean isWOTransOrReturnWOCompleteTrans = CawWorkOrderHelper.getInstance().checkWOTransOrReturnWOCompleteTrans(origTransList);
                    if (isAvailable && CawTenderConstants.CREDIT_CARD.equalsIgnoreCase(this._tenderId) && isWOTransOrReturnWOCompleteTrans) {
                        isAvailable = false;
                    }
                    //END BZ63225
                    if (isAvailable) { // BZ33089
                        return AccessLevel.GRANTED;
                    }
                }
            }
        }
        return AccessLevel.DENIED;
    }

}
