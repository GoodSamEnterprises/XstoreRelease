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
 * BZ30259          120220    [New Requirement] Customer Specific Messages on Receipts 
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;

/**
 *
 */
public class CawCustomerMessageDocBuilderField  extends AbstractDocBuilderField {

    @Inject
    protected TransactionScope _transactionScope;

    public CawCustomerMessageDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = _transactionScope.getValue(CawValueKeys.CAW_CUSTOMER_MESSAGE);
        return result;
    }
}

