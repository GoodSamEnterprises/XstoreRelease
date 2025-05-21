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
 * BZ26207          240718    New Requirement - Enable Work Order Functionality
 * BZ27163          100818    WO Email receipt shows the incorrect header for Work Order Deposit or Refund
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.OutputContextType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.customer.account.ICustomerAccountMaintModel;

/**
 * Work order receipt: build title.
 */
public class CawWorkOrderTitleBuilderField extends AbstractDocBuilderField {

    private static final FormattableFactory FF   = FormattableFactory
            .getInstance();

    private static final String             OPEN = "OPEN";

    /**
     * 
     */
    public CawWorkOrderTitleBuilderField(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    /* 
     * Build title.
     */
    @Override
    public String getContents(Object argVar1, IDocElementFactory argVar2,
            Locale argVar3) {

        String title = "";
        if (argVar1 instanceof ICustomerAccountMaintModel) {
            String state = ((ICustomerAccountMaintModel) argVar1).getAccount()
                    .getCustAccountStateCode();
            /* Begin BZ27163 */
            if (state.equals(OPEN) || CawWorkOrderOptionsOp.isDepositAction()) {
                title = FF.getTranslatable("_woDepositTrans")
                        .toString(OutputContextType.RECEIPT);
            } else if (CawWorkOrderOptionsOp.isCompleteAction()) {
                title = FF.getTranslatable("_woCompleteTrans")
                        .toString(OutputContextType.RECEIPT);
            } else if (CawWorkOrderOptionsOp.isRefundAction()) {
                title = FF.getTranslatable("_woRefundTrans")
                        .toString(OutputContextType.RECEIPT);
            }
            /* End BZ27163 */
        }
        return title;
    }

}
