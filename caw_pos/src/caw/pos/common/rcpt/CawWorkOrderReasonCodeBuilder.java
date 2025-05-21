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
 * BZ27334          020818    Work Order Refund Receipts Lost Reason Codes
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.List;
import java.util.Locale;

import caw.pos.common.CawConstants;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.customer.account.ICustomerAccountMaintModel;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Work order receipt: Add reason code, comment to work order refund receipt.
 */
@SuppressWarnings("deprecation")
public class CawWorkOrderReasonCodeBuilder extends AbstractDocBuilderField {

    /**
     * 
     */
    public CawWorkOrderReasonCodeBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    /* Build reason code and comment on work order refund receipt.
     * @see dtv.docbuilding.IDocBuilderField#getContents(java.lang.Object, dtv.docbuilding.IDocElementFactory, java.util.Locale)
     */
    @Override
    public String getContents(Object argVar1, IDocElementFactory argVar2,
            Locale argVar3) {

        String reason = "";
        if (argVar1 instanceof ICustomerAccountMaintModel) {
            List<ISaleReturnLineItem> items = ((ICustomerAccountMaintModel) argVar1)
                    .getCurrentTransaction()
                    .getLineItems(ISaleReturnLineItem.class);
            //Begin BZ27334
            IReasonCode iReasonCode = null;
            for (ISaleReturnLineItem item : items) {

                if (item.getReturnReasonCode() != null) {

                    iReasonCode = CodeLocator.getReasonCode(ConfigurationMgr
                            .getOrganizationId(), CawConstants.RETURN_REASON_TYPE_CODE, item
                                    .getReturnReasonCode());

                    if (iReasonCode != null) {
                        reason = iReasonCode.getDescription();
                        break;
                    }
                }
            }
        } else if (argVar1 instanceof ISaleReturnLineItem) {
            ISaleReturnLineItem item = (ISaleReturnLineItem) argVar1;
            //BZ27334-No print comment if comment is null.
            if (item.getReturn() && item.getReturnComment() != null) {
                reason = "Comment: " + item.getReturnComment();
            }
        }
        //End BZ27006
        return reason;
    }
}
