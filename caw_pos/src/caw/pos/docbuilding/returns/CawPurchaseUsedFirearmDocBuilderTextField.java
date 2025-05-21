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
 * BZ23458          210917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 * BZ24018          171017    [Technical issue] - Empty if statement
 *===================================================================
 */

package caw.pos.docbuilding.returns;

import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

/**
 * Break line for return comment code.
 */
public class CawPurchaseUsedFirearmDocBuilderTextField
        extends AbstractDocBuilderField {

    /**
     * 
     */
    public CawPurchaseUsedFirearmDocBuilderTextField(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1,
            Locale argArg2) {

        if (argSource instanceof SaleReturnLineItemModel) {
            SaleReturnLineItemModel lineItem = (SaleReturnLineItemModel) argSource;
            return lineItem.getReturnComment();
        }

        return null;
    }

}
