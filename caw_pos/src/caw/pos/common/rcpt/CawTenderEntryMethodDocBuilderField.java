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
 * BZ23544              260917    Entry method 'Chip Read' should be displayed in receipt instead of 'keyed' when performing transaction with EMV card
 *== ================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;
import dtv.xst.dao.trl.IAuthorizableLineItem;

public class CawTenderEntryMethodDocBuilderField
        extends TenderEntryMethodDocBuilderField {

    /**
     * Constructs a <code>CawTenderEntryMethodDocBuilderField</code>.
     * 
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawTenderEntryMethodDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource != null && argSource instanceof IAuthorizableLineItem) {
            IAuthorizableLineItem line = (IAuthorizableLineItem) argSource;
            result = line.getEntryMethodCode();
        }
        return result;
    }
}
