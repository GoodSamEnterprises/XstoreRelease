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
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.LocationFactory;
import dtv.xst.dao.loc.RetailLocationId;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * @author nu.nguyen
 *
 */
public class CawStoreLocationDocBuilderField extends AbstractDocBuilderField {

    private static final String NEW_LINE = "\n";

    /**
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawStoreLocationDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /** {@inheritDoc} */
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        //BEGIN BZ23955
        String str = "";
        if (argSource instanceof SaleReturnLineItemModel) {
            IPosTransaction parentSource = ((SaleReturnLineItemModel) argSource)
                    .getParentTransaction();
            if (parentSource instanceof RetailTransactionModel) {
                RetailLocationId location = ((RetailTransactionModel) parentSource)
                        .getRetailLocationIdObject();

                //BZ23955
                if (LocationFactory.getInstance()
                        .getStoreById(location) != null) {
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getStoreName() != null) {
                        str += LocationFactory.getInstance()
                                .getStoreById(location).getStoreName()
                                + NEW_LINE;
                    }
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getAddress1() != null) {
                        str += LocationFactory.getInstance()
                                .getStoreById(location).getAddress1()
                                + NEW_LINE;
                    }
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getAddress2() != null) {
                        str += LocationFactory.getInstance()
                                .getStoreById(location).getAddress2()
                                + NEW_LINE;
                    }
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getAddress3() != null) {
                        str += LocationFactory.getInstance()
                                .getStoreById(location).getAddress3()
                                + NEW_LINE;
                    }
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getCounty() != null) {
                        str += LocationFactory.getInstance()
                                .getStoreById(location).getCounty() + NEW_LINE;
                    }
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getCity() != null) {
                        str += LocationFactory.getInstance()
                                .getStoreById(location).getCity();
                    }
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getState() != null) {
                        str += ", " + LocationFactory.getInstance()
                                .getStoreById(location).getState();
                    }
                    if (LocationFactory.getInstance().getStoreById(location)
                            .getPostalCode() != null) {
                        str += " "
                                + LocationFactory.getInstance()
                                        .getStoreById(location).getPostalCode()
                                + NEW_LINE;
                    }
                }
            }
        }
        return str;
        //END BZ23955
    }

}
