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
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import caw.pos.customer.CawCustomerSearchOp;
import dtv.pos.framework.tax.ITaxHelper;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.register.tax.PromptTransTaxExemptionOp;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.tax.ITaxExemption;

/**
 * Prompts the user to select a tax exemption to be applied to the current transaction as a whole.<br>
 * <br>
 *
 * @author mshields
 * @created Feb 12, 2007
 * @version $Revision: 320971 $
 */
public class CawPromptTransTaxExemptionOp extends PromptTransTaxExemptionOp {

    /* (non-Javadoc)
     * @see dtv.pos.register.tax.PromptTaxExemptionOp#getPromptList(dtv.pos.iframework.event.IXstEvent)
     */
    @Inject
    private ITaxHelper _taxHelper;

    @Override
    protected Object[] getPromptList(IXstEvent argEvent) {

        IParty customer = this.getCustomer();
        Date busDate = this._transDateProvider.getDate();
        List<ITaxExemption> exemptions = this._taxHelper
                .getTaxExemptions(customer, busDate);
        if (!CawCustomerSearchOp.isEsbTaxExempt)
            exemptions.clear();
        return exemptions.toArray(new ITaxExemption[exemptions.size()]);
    }
}
