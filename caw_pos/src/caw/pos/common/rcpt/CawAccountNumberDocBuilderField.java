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
 * BZ30383          260419    [NEW REQUIREMENT] Add the 3rd party payer’s account number to the receipts
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import javax.inject.Inject;

import caw.pos.customer.CawCustomerConstants;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;

public class CawAccountNumberDocBuilderField extends AbstractDocBuilderField {

    public CawAccountNumberDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
        // @todo Auto-generated constructor stub
    }

    @Inject
    protected TransactionScope _transactionScope;

    /* (non-Javadoc)
     * @see dtv.docbuilding.IDocBuilderField#getContents(java.lang.Object, dtv.docbuilding.IDocElementFactory, java.util.Locale)
     */
    @Override
    public String getContents(Object argArg0, IDocElementFactory argArg1, Locale argArg2) {
        String accNumber = "";
        accNumber = _transactionScope.getValue(CawCustomerConstants.ACCOUNT_NUMBER);
        return accNumber;

    }
}
