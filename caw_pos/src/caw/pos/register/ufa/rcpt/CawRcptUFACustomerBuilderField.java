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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa.rcpt;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.tsn.ITenderControlTransaction;

/**
 *
 */
public class CawRcptUFACustomerBuilderField extends AbstractDocBuilderField {

    private static final Logger _logger = LogManager
            .getLogger(CawRcptUFACustomerBuilderField.class);

    public CawRcptUFACustomerBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        StringBuilder result = new StringBuilder();
        if (argSource instanceof ITenderControlTransaction) {
            ITenderControlTransaction tndControlTrans = (ITenderControlTransaction) argSource;
            IParty party = tndControlTrans.getFundsReceiptParty();
            try {
                if (party != null) {
                    result.append(party.getFirstName()).append(" ")
                            .append(party.getLastName());
                }
            } catch (Exception ex) {
                _logger.debug("getContents()", ex);
            }

        }
        return result.toString();
    }
}
