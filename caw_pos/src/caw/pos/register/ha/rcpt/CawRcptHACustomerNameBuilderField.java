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

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.impl.RetailTransactionModel;

/**
 * The CawRcptHACustomerNameBuilderField
 */
public class CawRcptHACustomerNameBuilderField extends AbstractDocBuilderField {

    /**
     * The CawRcptHANumberBuilderField constructor
     */
    public CawRcptHACustomerNameBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        if (argSource != null && argSource instanceof RetailTransactionModel) {
            RetailTransactionModel pos = (RetailTransactionModel) argSource;
            if (pos.getCustomerParty() != null) {
                return pos.getCustomerParty().getOrganizationName();
            }
        }
        return "";
    }

}
