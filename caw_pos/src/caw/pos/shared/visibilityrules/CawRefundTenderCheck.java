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
 * BZ25068          220118    New Requirement to Process Web Order Returns
 * BZ27812          191018    [New Requirement] Add cash as a tender option for Web Orders
 * BZ27924          231018    [Internal] Tender type of Return web order displayed incorrect when pressing 'Exit return' to do new return types trans
 * BZ27922          011118    [New Requirement] Make all tender changes configurable
 *===================================================================
 */

package caw.pos.shared.visibilityrules;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.register.CawTransactionUtils;
import caw.pos.tender.CawRefundTenderConfigHelper;
import caw.pos.tender.CawTenderConstants;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.shared.visibilityrules.RefundTenderCheck;
import dtv.pos.tender.TenderConstants;
import dtv.pos.tender.TenderHelper;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawRefundTenderCheck extends RefundTenderCheck {

    @Inject
    protected TransactionScope _transactionScope;

    // Begin BZ27812
    @Inject
    private TenderHelper       _tenderHelper;

    private String             tenderId = null;
    // End BZ27812

    // Begin BZ27812
    @Override
    public void setParameter(String argName, String argValue) {

        //Begin BZ27924, BZ27922
        IRetailTransaction trans = getCurrentRetailTransaction();
        List<ISaleReturnLineItem> lineItemsWebReturn = _transactionScope
                .getValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER);
        //Return web order
        boolean isWebOrder = CawTransactionUtils
                .isReturnWebOrder(trans, lineItemsWebReturn);
        //Blind return
        boolean isBlind = CawRefundTenderConfigHelper.getInstance()
                .isBlindReturn(trans);
        //Unverified return
        boolean isUnverified = CawRefundTenderConfigHelper.getInstance()
                .isUnverifiedReturn(trans);

        if (isWebOrder || (isUnverified && !isBlind)) {
            if ("tender".equals(argName)) {
                tenderId = argValue;
                if (argValue.toString()
                        .equalsIgnoreCase(TenderConstants.LOCAL_CURRENCY)) {
                    tenderId = this._tenderHelper.getLocalCurrencyTenderId();
                }
            }
        } else {
            super.setParameter(argName, argValue);
        }
        //End BZ27924, BZ27922
    }
    // End BZ27812

    @Override
    protected IAccessLevel checkVisibilityImpl() {

        //Begin BZ27812, BZ27924, BZ27922
        IRetailTransaction trans = getCurrentRetailTransaction();
        //Transaction is null. DENY
        if (trans == null) {
            return AccessLevel.DENIED;
        }

        IAccessLevel accessLevel = AccessLevel.DENIED;
        List<ISaleReturnLineItem> lineItemsWebReturn = _transactionScope
                .getValue(CawValueKeys.LIST_ITEM_RETURN_WEB_ORDER);
        //Get all available tenders
        List<ITender> tenders = _tenderHelper.getAllAvailableTenders();
        //Check current return type is return web order or unverified return
        if (CawTransactionUtils.isReturnWebOrder(trans, lineItemsWebReturn)) {
            //Check if current tender option is enable for return web order return
            if (CawRefundTenderConfigHelper.getInstance()
                    .isEnableForReturn(tenderId, CawTenderConstants.RETURN_WEB_ORDER, tenders)) {
                accessLevel = AccessLevel.GRANTED;
            }
        } else if (CawRefundTenderConfigHelper.getInstance()
                .isBlindReturn(trans)) {
            accessLevel = super.checkVisibilityImpl();
        } else if (CawRefundTenderConfigHelper.getInstance()
                .isUnverifiedReturn(trans)) {
            //Check if current tender option is enable for unverified return
            if (CawRefundTenderConfigHelper.getInstance()
                    .isEnableForReturn(tenderId, CawTenderConstants.RETURN_UNVERIFIED, tenders)) {
                accessLevel = AccessLevel.GRANTED;
            }
        } else {
            accessLevel = super.checkVisibilityImpl();
        }
        //End BZ27812, BZ27924, BZ27922

        return accessLevel;
    }
}
