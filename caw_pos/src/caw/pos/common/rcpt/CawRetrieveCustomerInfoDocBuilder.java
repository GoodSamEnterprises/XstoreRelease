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
 * BZ23372          101017    [DEV] Printing a special receipt to attach to 
 *                            returned items to aid disposition/restocking
 * BZ23955          131017    Should be removed return information on return product receipt
 * BZ26893          110818    [Xstore] Transaction Receipt Changes
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.i18n.format.TelephoneFormatter;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.crm.*;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawRetrieveCustomerInfoDocBuilder extends AbstractDocBuilderField {

    private static final String COUNTY        = "County: ";

    private static final String COUNTRY       = "Country: ";

    private static final String POSTAL_CODE   = "Postal Code: ";

    private static final String STATE         = "State: ";

    private static final String CITY          = "City: ";

    private static final String APARTMENT     = "Apartment: ";

    private static final String NEW_LINE      = "\n";

    private static final String CUSTOMER_NAME = "Customer Name: ";

    private static final String ADDRESS       = "Address: ";
    //BEGIN BZ26893
    private static final String PHONE         = "Phone: "; 
    private static final String HOME          = "HOME";
    private static final String MOBILE        = "MOBILE";
    //END BZ26893
    //BZ23955
    @Inject
    protected TransactionScope  _transactionScope;

    /**
     * Constructor for the CurrentTimeDocBuilderField object.
     *
     * @param argContents the configured contents of the field -- not used by this field builder.
     * @param argStyle the configured formatting style for the field
     * @param argLocation the configured column location for the field
     * @param argAlignment the alignment for the field
     * @param argPriority the configured priority for the field
     * @param argFormatter the configured type of formatter to use when building the field
     */
    public CawRetrieveCustomerInfoDocBuilder(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String str = "";
        String sphone = "";

        if (argSource instanceof SaleReturnLineItemModel) {
            IPosTransaction parentSource = ((SaleReturnLineItemModel) argSource)
                    .getParentTransaction();
            if (parentSource instanceof RetailTransactionModel) {
                IParty custParty = ((RetailTransactionModel) parentSource)
                        .getCustomerParty();

                //BEGIN BZ23955
                if (_transactionScope
                        .getValue(CawValueKeys.ACC_USER_NAME) != null) {
                    str += CUSTOMER_NAME
                            + _transactionScope
                                    .getValue(CawValueKeys.ACC_USER_NAME)
                            + NEW_LINE;
                    _transactionScope.clearValue(CawValueKeys.ACC_USER_NAME);
                }
                //END BZ23955

                if (str.isEmpty()) {
                    str += CUSTOMER_NAME + custParty.getFirstName() + " "
                            + custParty.getLastName() + NEW_LINE;

                }

                //BEGIN BZ26893
                if (custParty.getTelephoneInformation() != null
                        && !custParty.getTelephoneInformation().isEmpty()) {
                    List<IPartyTelephone> listPhonses = custParty
                            .getTelephoneInformation();
                    String number = "";
                    String type = "";
                    for (IPartyTelephone phone : listPhonses) {
                        number = phone.getTelephoneNumber();
                        type = phone.getTelephoneType();
                        if (number != null && !number.isEmpty()
                                && type != null && !type.isEmpty()) {
                            if (type.equalsIgnoreCase(HOME)) {
                                sphone = number;
                                break;
                            }
                            if (type.equalsIgnoreCase(MOBILE)) {
                                sphone = number;
                            }
                        }
                    }
                }
                //END BZ26893
                IPartyLocaleInformation pli = custParty
                        .getPrimaryLocaleInformation();
                if (pli != null) {
                    //BEGIN BZ26893
                    if (!sphone.isEmpty()) {
                        
                        TelephoneFormatter telephone = new TelephoneFormatter();
                        Locale locale = argLocale;
                        if (locale == null) {
                          locale = Locale.getDefault();
                        }

                        String formatphone = telephone.format(sphone, locale);
                        str += PHONE + formatphone + NEW_LINE;
                    }
                    //END BZ26893

                    str += ADDRESS;//BZ23955
                    if (pli.getAddress1() != null
                            && !pli.getAddress1().isEmpty()) {
                        str += pli.getAddress1() + " ";
                    }
                    if (pli.getAddress2() != null
                            && !pli.getAddress2().isEmpty()) {
                        str += pli.getAddress2() + " ";
                    }
                    if (pli.getAddress3() != null
                            && !pli.getAddress3().isEmpty()) {
                        str += pli.getAddress3() + " ";
                    }
                    if (pli.getAddress4() != null
                            && !pli.getAddress4().isEmpty()) {
                        str += pli.getAddress4() + " ";
                    }
                    if (pli.getApartment() != null
                            && !pli.getApartment().isEmpty()) {
                        str += NEW_LINE + APARTMENT + pli.getApartment();
                    }
                    if (pli.getCity() != null && !pli.getCity().isEmpty()) {
                        str += NEW_LINE + CITY + pli.getCity();
                    }
                    if (pli.getState() != null && !pli.getState().isEmpty()) {
                        str += NEW_LINE + STATE + pli.getState();
                    }
                    if (pli.getPostalCode() != null
                            && !pli.getPostalCode().isEmpty()) {
                        str += NEW_LINE + POSTAL_CODE + pli.getPostalCode();
                    }
                    if (pli.getCountry() != null
                            && !pli.getCountry().isEmpty()) {
                        str += NEW_LINE + COUNTRY + pli.getCountry();
                    }
                    if (pli.getCounty() != null && !pli.getCounty().isEmpty()) {
                        str += NEW_LINE + COUNTY + pli.getCounty();
                    }
                }
            }
        }
        return str;
    }
    

}
