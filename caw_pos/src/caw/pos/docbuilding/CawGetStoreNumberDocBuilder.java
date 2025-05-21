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
 * BZ24096          191017    Store#/Register/Cashier/Trans date/Time doesn't appear 
 *                            in one line horizontally in Balance Inquiry receipt
 *===================================================================
 */

package caw.pos.docbuilding;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;

public class CawGetStoreNumberDocBuilder extends AbstractDocBuilderField {

    private static final String STORE_NUMBER = System
            .getProperty("dtv.location.storeNumber") != null
                    ? System.getProperty("dtv.location.storeNumber")
                    : "";

    public CawGetStoreNumberDocBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argParamObject,
            IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        return STORE_NUMBER;
    }
}
