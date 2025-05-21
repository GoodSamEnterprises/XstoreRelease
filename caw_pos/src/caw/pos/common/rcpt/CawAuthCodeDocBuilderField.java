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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23701              021017    Void Receipt is required for Credit, Debit Tender line Void
 *== ================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.util.StringUtils;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawAuthCodeDocBuilderField extends AbstractDocBuilderField {

    /**
     * 
     */
    private static final String VOIDED = "(VOIDED)";

    /**
     * Constructs a <code>CawAuthCodeDocBuilderField</code>.
     * 
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawAuthCodeDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argSource;
            result = result
                    + StringUtils.nonNull(lineItem.getAuthorizationCode());
            if (lineItem.getVoid()) {
                result = result + VOIDED;
            }
        }
        return result;
    }

}
