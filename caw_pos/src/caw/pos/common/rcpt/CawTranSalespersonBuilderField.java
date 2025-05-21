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
 * BZ23949          161017    Receipt Changes Required
 * BZ24107          191017    Cashier info is not removed out of decline receipt when performing the sale transaction and tender by GC
 * BZ24127          201017    [Receipt] Salesperson is displayed incorrectly in receipt when performing sale transaction
 * BZ24129          201017    Missing Saleperson number in Return product receipt
 * BZ28037          011118    [Internal] Missing Sales Person on Tender Exchange Transaction Receipts
 * BZ31357          170619    [INTERNAL] The sale association of trans is missing in receipt
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Arrays;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.lang3.text.WordUtils;

import caw.tender.impl.mira.response.CawMiraResponse;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.TransactionHelper;
import dtv.pos.employee.IEmployeeHelper;
import dtv.util.StringUtils;
import dtv.xst.dao.hrs.IEmployee;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.tsn.impl.TenderControlTransactionModel;

/**
 *
 */
public class CawTranSalespersonBuilderField extends AbstractDocBuilderField {

    @Inject
    private IEmployeeHelper     _employeeHelper;
    /* Begin BZ31357*/
    private static final String NEW_LINE    = "\n             ";
    
    private static final String SPACE_LINE  = " ";
    
    private static final int MAX_LINE = 29;
    /* End BZ31357*/

    public CawTranSalespersonBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        dtv.util.temp.InjectionHammer.forceAtInjectProcessing(this);
    }

    /* (non-Javadoc)
     * @see dtv.docbuilding.IDocBuilderField#getContents(java.lang.Object, dtv.docbuilding.IDocElementFactory, java.util.Locale)
     */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        String result = "";

        if (argSource instanceof IRetailTransaction) {
            result = TransactionHelper
                    .getCommissionedAssociatesList((IRetailTransaction) argSource, false, false, false); //BZ24127

            /* Begin BZ31357*/
            FormattableFactory fmFact = FormattableFactory.getInstance();
            IFormattable text = fmFact.getTranslatable("_salesperson");
            String preFixStr = text.toString() + SPACE_LINE;
            result = String.join(SPACE_LINE, Arrays.asList(result.split(SPACE_LINE)));
            if (!StringUtils.isEmpty(result)) {
                String formatedLineId = WordUtils.wrap(result, MAX_LINE, NEW_LINE, true);
                result = preFixStr + formatedLineId.toString();
            }
            /* End BZ31357*/

            // Begin BZ24107
        } else if (argSource instanceof CawMiraResponse) {
            CawMiraResponse response = (CawMiraResponse) argSource;
            if (response.getEmployeeId() != null) {
                result = response.getEmployeeId();
            }
        } else if (argSource instanceof SaleReturnLineItemModel) {//BZ24129
            IPosTransaction parentSource = ((SaleReturnLineItemModel) argSource).getParentTransaction();
            if (parentSource instanceof RetailTransactionModel) {
                result = TransactionHelper.getCommissionedAssociatesList(parentSource, false, false, false);
            }
        }
        // End BZ24107
        // Begin BZ28037 
        else if (argSource instanceof TenderControlTransactionModel) {
            long _partyID;
            _partyID = ((TenderControlTransactionModel) argSource).getOperatorParty().getPartyId();

            IEmployee _loginID = _employeeHelper.getEmployeeByPartyId(_partyID);
            result = _loginID.getLoginId();
        }

        // End BZ28037
        return result;
    }

}
