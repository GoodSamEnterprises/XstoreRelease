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
 * BZ27242          170818    [1.6.9] House Account payment receipts display the wrong account number
 *===================================================================
 */

package caw.pos.register.ha.rcpt;

import java.util.Locale;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;

/**
 * The CawRcptHANumberBuilderField
 */
public class CawRcptHANumberBuilderField extends AbstractDocBuilderField {

    /**
     * The CawRcptHANumberBuilderField constructor
     */
    public CawRcptHANumberBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        // BZ27242 start
        String accountNumber = CawCustomerUtil
                .getAccountNumber(CawCatalystHelper.getLookupResponseData());
        // BZ27242 end
        return accountNumber;
    }

}
