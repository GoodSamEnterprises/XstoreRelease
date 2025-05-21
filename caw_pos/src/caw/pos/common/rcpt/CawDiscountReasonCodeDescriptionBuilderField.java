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
 * BZ26629          300718    [New Requirement] Add a prompt to capture discount code when the Retail Coupon discount reason is selected
 * BZ27025          030818    [26629][Internal] Update receipts to print Retail Coupon code with a colon instead of parenthesis
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Configurable;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.trl.impl.RetailPriceModifierModel;

/**
 * The CawDiscountReasonCodeBuilderField class
 */
@Configurable
public class CawDiscountReasonCodeDescriptionBuilderField
        extends AbstractDocBuilderField {

    private static final String REASON_TYPE_CODE = "DISCOUNT";

    /**
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawDiscountReasonCodeDescriptionBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String reasonCodeDescription = "";

        if (argSource instanceof RetailPriceModifierModel) {

            RetailPriceModifierModel model = (RetailPriceModifierModel) argSource;

            IReasonCode iReasonCode = CodeLocator.getReasonCode(ConfigurationMgr
                    .getOrganizationId(), REASON_TYPE_CODE, model
                            .getDiscountReasonCode());

            if (iReasonCode != null) {
                reasonCodeDescription = iReasonCode.getDescription() + ": ";//BZ27025
            }
        }

        return reasonCodeDescription;
    }

}
