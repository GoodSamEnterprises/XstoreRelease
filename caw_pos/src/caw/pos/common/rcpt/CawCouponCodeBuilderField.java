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
 * BZ24564          281117    Need to Print Coupon Code on Receipt
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.IRetailPriceModifier;

public class CawCouponCodeBuilderField extends AbstractDocBuilderField {

    public CawCouponCodeBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /* (non-Javadoc)
     * @see dtv.docbuilding.IDocBuilderField#getContents(java.lang.Object, dtv.docbuilding.IDocElementFactory, java.util.Locale)
     */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof IRetailPriceModifier) {
            IRetailPriceModifier priceModifier = (IRetailPriceModifier) argSource;
            if (priceModifier.getDealId() != null) {
                result = priceModifier.getDealId();
            }
        }
        return result;
    }

}
