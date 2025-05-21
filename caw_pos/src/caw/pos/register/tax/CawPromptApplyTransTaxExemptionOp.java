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
 * BZ27535          090719    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 *===================================================================
 */

package caw.pos.register.tax;

import dtv.pos.framework.tax.ITaxHelper;
import dtv.pos.register.tax.PromptApplyTransTaxExemptionOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import caw.pos.customer.CawCustomerSearchOp;

public class CawPromptApplyTransTaxExemptionOp
        extends PromptApplyTransTaxExemptionOp {

    @Inject
    private ITaxHelper _taxHelper;

    /* (non-Javadoc)
     * @see dtv.pos.register.tax.PromptApplyTransTaxExemptionOp#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Date busDate = this._transDateProvider.getDate();
        IParty customer = this.getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        if (customer != null && !this._taxHelper
                .getTaxExemptions(customer, busDate).isEmpty()
                && CawCustomerSearchOp.isEsbTaxExempt) {
            IPosTransaction trans = this._transactionScope.getTransaction();
            List<IRetailTransactionLineItem> tenderLines = trans
                    .getTenderLineItems();
            Iterator<IRetailTransactionLineItem> var5 = tenderLines.iterator();
            IRetailTransactionLineItem tenderLine;
            do {
                if (!var5.hasNext()) {
                    return true;
                }
                tenderLine = var5.next();
            } while (tenderLine.getVoid());
            return false;
        } else {
            return false;
        }
    }
}