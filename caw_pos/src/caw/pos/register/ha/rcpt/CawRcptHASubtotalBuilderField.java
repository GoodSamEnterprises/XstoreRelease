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
 * BZ26289          110718    New Requirement - Enable A/R Payment Functionality in Xstore
 *===================================================================
 */

package caw.pos.register.ha.rcpt;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawRcptHASubtotalBuilderField
 */
public class CawRcptHASubtotalBuilderField extends AbstractDocBuilderField {

    private static final Logger _logger = LogManager
            .getLogger(CawRcptHASubtotalBuilderField.class);

    /**
     * The CawRcptHASubtotalBuilderField constructor
     */
    public CawRcptHASubtotalBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /**
     * The method get value of 'Account Payment' field on House Account receipt
     */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String paymentAmount = "";
        if (argSource != null && argSource instanceof IPosTransaction) {
            IPosTransaction pos = (IPosTransaction) argSource;
            if (pos.getSubtotal() != null) {
                _logger.info("House account payment amount."
                        + pos.getSubtotal());
                paymentAmount = pos.getSubtotal().toString();
            }
        }

        return paymentAmount;
    }
}
