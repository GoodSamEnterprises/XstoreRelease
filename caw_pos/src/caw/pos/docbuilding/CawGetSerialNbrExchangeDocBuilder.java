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
 * BZ26847          100718    [1.6.0][25958] Reload/Issue Gift card info prints on receipt incorrectly
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
import dtv.xst.dao.ttr.impl.VoucherModel;
import dtv.xst.dao.ttr.impl.VoucherTenderLineItemModel;

/**
 *This class is used to format content in case Gift card is Tender Exchanges
 */
public class CawGetSerialNbrExchangeDocBuilder extends AbstractDocBuilderField {

    public CawGetSerialNbrExchangeDocBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argParamObject,
            IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        if (argParamObject instanceof VoucherTenderLineItemModel) {
            Object verchermodel = ((VoucherTenderLineItemModel) argParamObject)
                    .getVoucher();
            if (verchermodel != null) {
                return CawUtilFunction
                        .formatSerialGCWithMask(((VoucherModel) verchermodel)
                                .getSerialNumber(), CawConstants.STAR_SIGN);
            } else {
                return CawUtilFunction
                        .formatSerialGCWithMask(((VoucherTenderLineItemModel) argParamObject)
                                .getSerialNumber(), CawConstants.STAR_SIGN);
            }
        }
        return null;
    }
}
