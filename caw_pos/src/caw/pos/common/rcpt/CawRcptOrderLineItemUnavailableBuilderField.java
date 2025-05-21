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
 * BZ46879          221021    Xstore Patch 16 Receipt Issues
 * BZ43207          221121    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;

import caw.pos.common.CawConstants;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.util.StringUtils;
import dtv.xst.dao.xom.IOrderLine;
import dtv.xst.xom.impl.order.OrderLineStatus;

/**
 *
 */
public class CawRcptOrderLineItemUnavailableBuilderField extends AbstractDocBuilderField{
    public CawRcptOrderLineItemUnavailableBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1
            , Locale argArg2) {
        String result = StringUtils.EMPTY;
        if (argSource instanceof IOrderLine) {
            IOrderLine lineItem = (IOrderLine) argSource;
            if (OrderLineStatus.CANCELLED.getCode().equals(lineItem.getStatusCode()) 
                    || OrderLineStatus.UNFULFILLABLE.getCode().equals(lineItem.getStatusCode())) {
                result = CawConstants.CAW_ORDER_LINE_CANCELLED; //BZ42307 - Replace "UNAVAILABLE" to "CANCELLED"
            }
        }
        return result;
    }

}
