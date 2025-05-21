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
 * BZ27294          220818    'Issue Store credit' is displayed as refund tender when performing WO complete then remove a line item from WO transaction
 *===================================================================
 */

package caw.pos.workorder.visibilityrules;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawValueKeys;
import caw.pos.tender.CawTenderConstants;
import caw.pos.workorder.common.CawWorkOrderConstants;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.pos.tender.TenderHelper;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;
import dtv.xst.dao.ttr.impl.TenderLineItemModel;

/**
 *
 */
public class CawWorkOrderTenderRule extends AbstractVisibilityRule {

    private String           tenderName_;

    @Inject
    private TenderHelper     _tenderHelper;

    @Inject
    private TransactionScope _transactionScope;

    @Override
    public void setParameter(String argName, String argValue) {

        if (StringUtils.isNotEmpty(argName)
                && StringUtils.isNotEmpty(argValue)) {
            if (argValue
                    .equalsIgnoreCase(CawWorkOrderConstants.LOCAL_CURRENCY)) {
                this.tenderName_ = this._tenderHelper
                        .getLocalCurrencyTenderId();
            } else {
                this.tenderName_ = argValue;
            }
        }
    }

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        AccessLevel accessLevel = AccessLevel.DENIED;
        IPosTransaction iPosTransaction = _transactionScope
                .getValue(CawValueKeys.CAW_LATEST_TRANSACTION);
        if (iPosTransaction != null) {
            List<IRetailTransactionLineItem> lineItems = iPosTransaction
                    .getTenderLineItems();
            ITender tender = null;
            String className = null;
            boolean isVoid = false;
            if (lineItems != null && lineItems.size() > 0) {
                for (IRetailTransactionLineItem transactionLineItem : lineItems) {
                    if (transactionLineItem instanceof TenderLineItemModel) {
                        tender = ((ITenderLineItem) transactionLineItem)
                                .getTender();

                        if (this.tenderName_
                                .equalsIgnoreCase(tender.getTenderId())) {
                            accessLevel = AccessLevel.GRANTED;
                            break;
                        } else if (this.tenderName_
                                .equalsIgnoreCase(CawWorkOrderConstants.HOME_OFFICE_CHECK)) {
                            if (CawTenderConstants.CHECK
                                    .equals(tender.getTenderId())
                                    || CawTenderConstants.USD_TRAVELERS_CHECK
                                            .equals(tender.getTenderId())) {
                                accessLevel = AccessLevel.GRANTED;
                                break;
                            }
                        } else if (this.tenderName_
                                .equalsIgnoreCase(CawTenderConstants.CREDIT_CARD)) {
                            className = ((ITenderLineItem) transactionLineItem)
                                    .getClassName();
                            isVoid = ((ITenderLineItem) transactionLineItem)
                                    .getVoid();
                            if (!isVoid && (className
                                    .equalsIgnoreCase(CawWorkOrderConstants.DTV_CLASS_NAME))) {
                                accessLevel = AccessLevel.GRANTED;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return accessLevel;
    }

}
