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
 * BZ25958          100718    New Requirement - Remove Gift Card transactions from the Pin Pad
 *===================================================================
 */

package caw.pos.docbuilding;

import java.util.Locale;

import caw.pos.common.CawConstants;
import caw.pos.common.CawUtilFunction;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.tender.voucher.VoucherBalanceInfo;
import dtv.xst.dao.trl.impl.VoucherSaleLineItemModel;

/**
 *
 */
public class CawGetSerialNumberDocBuilder extends AbstractDocBuilderField {

    public CawGetSerialNumberDocBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argParamObject,
            IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        if (argParamObject instanceof VoucherBalanceInfo) {
            return CawUtilFunction
                    .formatSerialGCWithMask(((VoucherBalanceInfo) argParamObject)
                            .getSerialNumber(), CawConstants.STAR_SIGN);
        }
        if (argParamObject instanceof VoucherSaleLineItemModel) {
            return CawUtilFunction
                    .formatSerialGCWithMask(((VoucherSaleLineItemModel) argParamObject)
                            .getSerialNumber(), CawConstants.STAR_SIGN);
        }
        return null;
    }
}
