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
 * BZ29388          150219    [Internal] PLCC - Only 1 receipt prints when making a payment
 *===================================================================
 */

package caw.pos.register.ap.rcpt;

import java.util.Locale;

import caw.pos.araccount.CawCustomerUtil;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 * The CawRcptHANumberBuilderField
 */
public class CawRcptAPNumberBuilderField extends AbstractDocBuilderField {

    /**
     * The CawRcptHANumberBuilderField constructor
     */
    public CawRcptAPNumberBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        IRetailTransaction retailTrans = null;
        if (argSource instanceof IRetailTransaction) {
            retailTrans = (IRetailTransaction) argSource;
        }
        return CawCustomerUtil.getAccountPaymentNumber(retailTrans);
    }

}
