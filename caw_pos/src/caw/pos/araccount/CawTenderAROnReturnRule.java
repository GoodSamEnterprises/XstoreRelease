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
 * BZ24945          281217    AR tender is disable on Return tender option screen when performing return transaction by scanning trans on Sell item screen
 *===================================================================
 */

package caw.pos.araccount;

import static dtv.pos.iframework.visibilityrules.AccessLevel.DENIED;
import static dtv.pos.iframework.visibilityrules.AccessLevel.GRANTED;
import static dtv.util.NumberUtils.isZero;

import javax.inject.Inject;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.register.returns.ReturnManager;
import dtv.xst.dao.tnd.TenderCategory;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * This function is used to check AR/Third party is allow visible or not
 */
public class CawTenderAROnReturnRule extends AbstractVisibilityRule {

    private TenderCategory      category_      = TenderCategory.ACCOUNT;

    private static final String tenderCategory = "TenderCategory";

    private static final String AR_ACCOUNT     = "AR_ACCOUNT";

    @Inject
    private ReturnManager       _returnMgr;

    /** {@inheritDoc} */
    @Override
    public void setParameter(String argName, String argValue) {

        if (tenderCategory.equalsIgnoreCase(argName)) {
            category_ = TenderCategory.forName(argValue);
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /** {@inheritDoc} */
    @Inject
    protected TransactionScope _transactionScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        IRetailTransaction trans = getCurrentRetailTransaction();

        if ((trans == null) || isZero(trans.getAmountDue())) {
            return DENIED;
        }
        for (IRetailTransaction origTrans : _returnMgr
                .getAllOrigTransaction()) {
            for (ITenderLineItem tenderLine : origTrans
                    .getLineItems(ITenderLineItem.class)) {
                if (category_.matches(tenderLine.getTender()) && tenderLine
                        .getTenderId().equalsIgnoreCase(AR_ACCOUNT)) {
                    return GRANTED;
                }
            }
        }
        return DENIED;
    }
}
