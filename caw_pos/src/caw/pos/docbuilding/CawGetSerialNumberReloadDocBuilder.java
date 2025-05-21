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
 * BZ26963          310718    Missing Serialize number each line item on receipt after complete sale transaction
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
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.trl.impl.VoucherSaleLineItemModel;

/**
 *
 */
public class CawGetSerialNumberReloadDocBuilder
        extends AbstractDocBuilderField {

    public CawGetSerialNumberReloadDocBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argParamObject,
            IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        if (argParamObject instanceof VoucherSaleLineItemModel) {
            return CawUtilFunction
                    .formatSerialGCWithMask(((VoucherSaleLineItemModel) argParamObject)
                            .getSerialNumber(), CawConstants.STAR_SIGN);
            // Begin BZ26963
        } else if (argParamObject instanceof SaleReturnLineItemModel) {
            return ((SaleReturnLineItemModel) argParamObject).getSerialNumber();
        }
        // End BZ26963
        return null;
    }
}
