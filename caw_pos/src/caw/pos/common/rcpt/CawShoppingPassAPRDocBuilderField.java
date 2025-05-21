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
 * BZ29619          040319    [Internal][PLCC] Shopping Pass Changes
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import caw.pos.common.CawConstants;
import caw.tenderauth.impl.eigen.CawGoodSamVisaShoppingPassReferenceData;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;

/**
 *
 */
public class CawShoppingPassAPRDocBuilderField extends AbstractDocBuilderField {

    public CawShoppingPassAPRDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        String strAPR = CawConstants.VALUE_0_PERCENT;
        if (argSource instanceof CawGoodSamVisaShoppingPassReferenceData) {
            CawGoodSamVisaShoppingPassReferenceData shoppingPassReferenceData = (CawGoodSamVisaShoppingPassReferenceData) argSource;
            if (!CawConstants.VALUE_0_PERCENT.equalsIgnoreCase(shoppingPassReferenceData.getApr())) {
                strAPR = shoppingPassReferenceData.getApr() + CawConstants.PERCENT;
            }
        }
        return strAPR;
    }
}
