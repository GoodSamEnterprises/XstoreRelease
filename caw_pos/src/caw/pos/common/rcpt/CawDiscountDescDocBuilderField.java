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
 * BZ24255          271017    [UAT]'Trans Discount:$Off' should be displayed in receipt instead of 'Trans Discount:$Of' when doing a trans level discount $ amount or % amount
 * BZ52129          011222    BTM-153: Receipt is not showing entire text for point redemptions line
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.List;
import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.*;
import dtv.xst.dao.trl.impl.RetailPriceModifierModel;

/**
 *
 */
public class CawDiscountDescDocBuilderField extends AbstractDocBuilderField {

    private static String GROUP = "Group";
    
    //BEGIN BZ52129
    private static String LOYALTY_ITEM_AMT_PROMPT = "LOYALTY_ITEM_AMT_PROMPT"; 
    private static String CAW_LOYALTY_DES_LENGTH = "CAW_LOYALTY_DES_LENGTH"; 
    //END BZ52129

    /**
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawDiscountDescDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        //BEGIN BZ24255
        String str = "";
        if (argSource instanceof RetailPriceModifierModel) {
            RetailPriceModifierModel model = (RetailPriceModifierModel) argSource;
            if (model.getDiscount().getDescription() != null
                    && !model.getDiscount().getDescription().isEmpty()) {
                String des = model.getDiscount().getDescription();
                if (des.contains(GROUP)) {
                    if (des.length() > 25) {
                        str = des.substring(0, 25);
                    } else {
                        str = des;
                    }
                    //BEGIN BZ52129
                } else if (LOYALTY_ITEM_AMT_PROMPT.equalsIgnoreCase(model.getDiscountCode())) {
                    List<String> listCodes = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), CAW_LOYALTY_DES_LENGTH);
                    
                    if (listCodes != null && listCodes.get(0)!= null && str.length() > Integer.parseInt(listCodes.get(0))) {
                        str = des.substring(0, Integer.parseInt(listCodes.get(0)));
                    } else {
                        str = des;
                    }
                    //END BZ52129
                    
                } else {
                    if (des.length() > 23) {
                        str = des.substring(0, 23);
                    } else {
                        str = des;
                    }
                }
            }
        }
        return str.trim();
        //END BZ24255
    }

}
