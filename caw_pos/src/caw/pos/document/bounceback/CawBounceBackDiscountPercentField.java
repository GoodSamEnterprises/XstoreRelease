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
 * BZ34116          111219    [PROD] Bounce Back coupon verbiage changes (continuation of 33981 and 34030)
 *===================================================================
 */

package caw.pos.document.bounceback;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.*;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.document.DocumentHelper;
import dtv.pos.document.DocumentHelper.DocumentDefinitionPropertyCode;
import dtv.pos.document.bounceback.BounceBackDiscountPercentField;
import dtv.pos.pricing.discount.DiscountHelper;
import dtv.pos.pricing.discount.type.DiscountCalculationMethod;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.doc.*;
import dtv.xst.dao.dsc.IDiscount;
import org.apache.commons.lang3.StringUtils;

/**
 *
 */
@SuppressWarnings("deprecation")
public class CawBounceBackDiscountPercentField extends BounceBackDiscountPercentField {

    @Inject
    private DiscountHelper     _discountHelper;

    @Inject
    private FormattableFactory _formatter;

    @SuppressWarnings("deprecation")
    public CawBounceBackDiscountPercentField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @SuppressWarnings("null")
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        IDocumentLineItem lineItem = (IDocumentLineItem) argSource;
        String percentage = "";
        if (lineItem == null || lineItem.getDocument() == null) {
            percentage = "";
        }

        IDocumentDefinition dd = DocumentHelper.get()
                .getDocumentDefinition(lineItem.getDocumentType(), lineItem.getSeriesId());
        if (dd == null || dd.getDocDefProperties() == null) {
            percentage = "";
        }

        List<IDocumentDefinitionProperties> properties = DocumentHelper.get()
                .getDocumentDefinitionProperties(dd, DocumentDefinitionPropertyCode.DISCOUNT_CODE);
        if (properties == null || properties.isEmpty()) {
            percentage = "";
        }

        IDiscount discount = this._discountHelper.getDiscount(properties.get(0).getStringValue());
        if (discount != null) {
            DiscountCalculationMethod calcMethod = DiscountCalculationMethod
                    .forName(discount.getCalculationMethodCode());
            if (calcMethod != null && calcMethod.isPercentageBased()) {
                percentage = this.getFormatter().format(discount.getPercent(), argLocale);
            }
        }

        if (!StringUtils.isEmpty(percentage)) {
            return this._formatter
                    .getTranslatable("_rcptBounceBackSaveTextPercent", new IFormattable[] { this._formatter
                            .getSimpleFormattable(percentage) })
                    .toString(OutputContextType.RECEIPT, argLocale);
        }

        return this._formatter.getTranslatable("_rcptBounceBackSaveText", new IFormattable[] { this._formatter
                .getSimpleFormattable(percentage) }).toString(OutputContextType.RECEIPT, argLocale);
    }
}
