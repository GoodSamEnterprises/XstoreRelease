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
 * BZ24171          231017    'Picked up By' displayed 'GLOBAL SATELLITE SOLUTI' instead of 'GLOBAL SATELLITE SOLUTIONS' in receipt when performing transaction by Thirty-party tender
 * BZ29673          170419    [Internal]Company name text is broken out many lines on receipt when using WHLS has long company name to tender
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import org.apache.commons.lang3.text.WordUtils;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.util.StringUtils;
import dtv.xst.dao.ttr.IAccountReceivableTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawAccountUsernameDocBuilderField extends AbstractDocBuilderField {

    private static final String NEW_LINE         = "\n";

    private static final String SPACE_LINE       = " ";
    private static final int    LENGTH_OF_STRING = 36;

    /**
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawAccountUsernameDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        /* BEGIN BZ24171,BZ29673 */
        String contents = "";
        String accUsername = "";
        int lengthPreFixStr = 0;
        String preFixStr = "";

        if (argSource instanceof ITenderLineItem) {
            if (argSource instanceof IAccountReceivableTenderLineItem) {

                FormattableFactory fmFact = FormattableFactory.getInstance();
                IFormattable text = fmFact.getTranslatable("_houseAccountRcptUserName");
                IAccountReceivableTenderLineItem arLine = (IAccountReceivableTenderLineItem) argSource;
                preFixStr = text.toString() + SPACE_LINE;
                lengthPreFixStr = preFixStr.length();
                accUsername = arLine.getAccountUserName();

                if (!StringUtils.isEmpty(accUsername)) {
                    String formatedName = WordUtils.wrap(accUsername, LENGTH_OF_STRING - lengthPreFixStr, NEW_LINE
                            + String.format("%1$" + lengthPreFixStr + "s", SPACE_LINE), true);
                    contents = preFixStr + formatedName.toString();
                }
            }

        }
        return contents;
        /* END BZ24171,BZ29673 */
    }

}
