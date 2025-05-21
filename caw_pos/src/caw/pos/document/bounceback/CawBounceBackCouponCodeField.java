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

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.document.DocumentHelper;
import dtv.pos.document.DocumentHelper.DocumentDefinitionPropertyCode;
import dtv.pos.document.bounceback.BounceBackCouponCodeField;
import dtv.xst.dao.doc.*;
import dtv.xst.dao.dsc.IDiscount;
import javax.inject.Inject;
import dtv.pos.pricing.discount.DiscountHelper;

/**
 * This class build the bounce back coupon discount description and discount series code string for the
 * receipt.
 *
 */
public class CawBounceBackCouponCodeField extends BounceBackCouponCodeField {

    @Inject
    private DiscountHelper _discountHelper;

    /**
     * Instantiates a new bounce back coupon code field.
     *
     * @param argContents the contents
     * @param argStyle the style
     * @param argLocation the location
     * @param argAlignment the alignment
     * @param argPriority the priority
     * @param argFormatter the formatter
     */
    public CawBounceBackCouponCodeField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        IDocumentLineItem lineItem = (IDocumentLineItem) argSource;
        if (lineItem != null && lineItem.getDocument() != null) {
            IDocumentDefinition dd = DocumentHelper.get()
                    .getDocumentDefinition(lineItem.getDocumentType(), lineItem.getSeriesId());
            if (dd != null && dd.getDocDefProperties() != null) {
                List<IDocumentDefinitionProperties> properties = DocumentHelper.get()
                        .getDocumentDefinitionProperties(dd, DocumentDefinitionPropertyCode.DISCOUNT_CODE);
                if (properties != null && !properties.isEmpty()) {
                    IDiscount discount = this._discountHelper.getDiscount(properties.get(0).getStringValue());
                    if (discount == null) {
                        return "";
                    } else {
                        StringBuffer sb = new StringBuffer();
                        sb.append(discount.getDescription());
                        //sb.append(" Code "); //BZ34116
                        //sb.append(lineItem.getSeriesId()); // BZ34116
                        return sb.toString();
                    }
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
