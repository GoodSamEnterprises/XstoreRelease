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
 * BZ29387          140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 *===================================================================
 */

package caw.pos.register.returns.visibilityrules;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.tender.CawTenderConstants;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.shared.visibilityrules.TenderEnabledCheck;
import dtv.pos.tender.TenderConstants;
import dtv.pos.tender.TenderHelper;
import dtv.xst.dao.tnd.ITender;

/**
 *
 */
public class CawSaleTenderEnabledCheckVisibilityRule
        extends TenderEnabledCheck {

    @Inject
    private TenderHelper       _tenderHelper;

    @Inject
    protected TransactionScope _transactionScope;

    private String             tenderId = null;

    @Override
    public void setParameter(String argName, String argValue) {

        Boolean isAccountPayment = _transactionScope
                .getValue(CawValueKeys.IS_ACCOUNT_PAYMENT);
        if (isAccountPayment != null && isAccountPayment) {
            tenderId = argValue;
            if (argValue.toString()
                    .equalsIgnoreCase(TenderConstants.LOCAL_CURRENCY)) {
                tenderId = this._tenderHelper.getLocalCurrencyTenderId();
            }
        } else {
            super.setParameter(argName, argValue);
        }
    }

    @Override
    public IAccessLevel checkVisibility() throws Exception {

        IAccessLevel accessLevel = AccessLevel.DENIED;
        Boolean isAccountPayment = _transactionScope
                .getValue(CawValueKeys.IS_ACCOUNT_PAYMENT);
        //Get all available tenders
        List<ITender> tenders = _tenderHelper.getAllAvailableTenders();
        if (isAccountPayment != null && isAccountPayment) {
            if (isEnableForSale(CawTenderConstants.ACCOUNT_PAYMENT, tenders)) {
                accessLevel = AccessLevel.GRANTED;
            }
        } else {
            accessLevel = super.checkVisibility();
        }
        return accessLevel;
    }

    /**
     * 
     * @param availableCode
     * @param tenders
     * @return
     */
    private boolean isEnableForSale(String availableCode,
            List<ITender> tenders) {

        boolean isEnable = false;

        if (tenderId != null && tenders != null && tenders.size() > 0) {
            ITender iTender = null;

            for (ITender iTenderTemp : tenders) {
                if (tenderId.equalsIgnoreCase(iTenderTemp.getTenderId())) {
                    iTender = iTenderTemp;
                    break;
                }
            }

            if (iTender != null && iTender.containsAvailCode(availableCode)) {
                isEnable = true;
            }
        }

        return isEnable;
    }
}
