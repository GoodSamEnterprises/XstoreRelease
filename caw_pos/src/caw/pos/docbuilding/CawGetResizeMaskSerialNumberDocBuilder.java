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
 * BZ23765          101017    Mask should be limited in receipt when performing 
 *                            a transaction by merchandise certificate tender
 * BZ24094          261017    [Technical issue] - Method Invocation in Loop Condition
 * BZ25958          120718    New Requirement - Remove Gift Card transactions from the Pin Pad
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
import dtv.xst.dao.ttr.IVoucherTenderLineItem;

/**
 *
 */
public class CawGetResizeMaskSerialNumberDocBuilder
        extends AbstractDocBuilderField {

    public CawGetResizeMaskSerialNumberDocBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argParamObject,
            IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        if (argParamObject instanceof IVoucherTenderLineItem) {
            return CawUtilFunction.formatSerialGCWithMask(((IVoucherTenderLineItem) argParamObject)
                    .getSerialNumber(), CawConstants.STAR_SIGN);
        }
        return null;
    }
}
