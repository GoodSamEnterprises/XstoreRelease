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
 * BZ29292          140219   [Internal] Need to fix the text on the PLCC Shopping Pass to match ADS Requirements
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.log4j.Logger;

import caw.tenderauth.impl.eigen.CawGoodSamVisaShoppingPassReferenceData;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.rcpt.TenderEntryMethodDocBuilderField;

/**
 *
 */
public class CawShoppingPassDocBuilderField extends TenderEntryMethodDocBuilderField {

    private static final Logger logger_          = Logger.getLogger(CawShoppingPassDocBuilderField.class);

    private static final String MM_DD_YYYY_HH_MM = "MM/dd/yyyy hh mm aa";

    public CawShoppingPassDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        String currentDate = "";
        if (argSource instanceof CawGoodSamVisaShoppingPassReferenceData) {
            try {
                CawGoodSamVisaShoppingPassReferenceData passReferenceData = (CawGoodSamVisaShoppingPassReferenceData) argSource;
                SimpleDateFormat formatDate = new SimpleDateFormat(MM_DD_YYYY_HH_MM);
                StringBuilder temp = new StringBuilder("******");
                temp.append(formatDate.format(passReferenceData.getBeginDateTimestamp()));
                temp.append("******");
                currentDate = temp.toString();
            } catch (Exception ex) {
                logger_.info("Can not format the current date." + ex.getMessage());
            }
        }

        return currentDate;
    }

}
