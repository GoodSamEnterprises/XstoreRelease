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
 * BZ26207          240718    New Requirement - Enable Work Order Functionality
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.crm.IPartyLocaleInformation;

/**
 * Work order receipt: retrieve work order customer's info.
 */
public class CawWorkOrderRetrieveCustomerInfoDocBuilder
        extends AbstractDocBuilderField {

    private static final String COUNTY      = "County: ";

    private static final String COUNTRY     = "Country: ";

    private static final String POSTAL_CODE = "Postal Code: ";

    private static final String STATE       = "State: ";

    private static final String CITY        = "City: ";

    private static final String APARTMENT   = "Apartment: ";

    private static final String NEW_LINE    = "\n";

    private static final String ADDRESS     = "Address: ";

    /**
     * 
     */
    public CawWorkOrderRetrieveCustomerInfoDocBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    /* 
     * Retrieve work order customer's info.
     * @see dtv.docbuilding.IDocBuilderField#getContents(java.lang.Object, dtv.docbuilding.IDocElementFactory, java.util.Locale)
     */
    @Override
    public String getContents(Object argVar1, IDocElementFactory argVar2,
            Locale argVar3) {

        String str = "";
        if (argVar1 instanceof IPartyLocaleInformation) {

            IPartyLocaleInformation pli = (IPartyLocaleInformation) argVar1;
            str += ADDRESS;
            if (pli.getAddress1() != null && !pli.getAddress1().isEmpty()) {
                str += pli.getAddress1() + " ";
            }
            if (pli.getAddress2() != null && !pli.getAddress2().isEmpty()) {
                str += pli.getAddress2() + " ";
            }
            if (pli.getAddress3() != null && !pli.getAddress3().isEmpty()) {
                str += pli.getAddress3() + " ";
            }
            if (pli.getAddress4() != null && !pli.getAddress4().isEmpty()) {
                str += pli.getAddress4() + " ";
            }
            if (pli.getApartment() != null && !pli.getApartment().isEmpty()) {
                str += NEW_LINE + APARTMENT + pli.getApartment();
            }
            if (pli.getCity() != null && !pli.getCity().isEmpty()) {
                str += NEW_LINE + CITY + pli.getCity();
            }
            if (pli.getState() != null && !pli.getState().isEmpty()) {
                str += NEW_LINE + STATE + pli.getState();
            }
            if (pli.getPostalCode() != null && !pli.getPostalCode().isEmpty()) {
                str += NEW_LINE + POSTAL_CODE + pli.getPostalCode();
            }
            if (pli.getCountry() != null && !pli.getCountry().isEmpty()) {
                str += NEW_LINE + COUNTRY + pli.getCountry();
            }
            if (pli.getCounty() != null && !pli.getCounty().isEmpty()) {
                str += NEW_LINE + COUNTY + pli.getCounty();
            }
        }
        return str;
    }

}
