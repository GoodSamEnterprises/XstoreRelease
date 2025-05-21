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
 * BZ37202          180820    [TASK] Modify Order receipts to matches Camping World's current templates and rules
 * BZ37887          170920    [INTERNAL]Order Pickup printed receipt as ORDER CANCEL incorrectly
 * BZ46879          221021    Xstore Patch 16 Receipt Issues
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Collections;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawConstants;
import caw.pos.order.maint.CawOrderComparator;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.OutputContextType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.order.OrderReceiptSource;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;
import dtv.xst.xom.impl.order.OrderStatus;

/**
 *
 */
public class CawOrderHeaderBuilderField extends AbstractDocBuilderField {
    /**
     * 
     */
    private static final FormattableFactory FF                    = FormattableFactory.getInstance();


    /**
     * @param argContents
     * @param argStyle
     * @param argLocation
     * @param argAlignment
     * @param argPriority
     * @param argFormatter
     */
    public CawOrderHeaderBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argArg0, IDocElementFactory argArg1, Locale argArg2) {

        String result = FF.getTranslatable("_orderCreated")
                .toString(OutputContextType.RECEIPT);
        if (argArg0 instanceof OrderReceiptSource) {
            IOrder order = ((OrderReceiptSource) argArg0).getOrder();
            IPosTransaction iPosTransaction = ((OrderReceiptSource) argArg0).getTransaction();/*BZ46879*/
            if (order != null) {
                if (StringUtils.isNotEmpty(order.getStatusCode())
                        && order.isNew()
                        && OrderStatus.NEW.matches(order.getStatusCode())) {
                    result = FF.getTranslatable("_orderCreated").toString(OutputContextType.RECEIPT);
                } else {
                    /*BEGIN BZ46879*/
                    if (iPosTransaction != null) {
                        String orderType = iPosTransaction.getStringProperty(CawConstants.CAW_ORDER_TYPE);
                        if (OrderStatus.COMPLETE.matches(orderType)) {
                            result = FF.getTranslatable("_orderCompleted").toString(OutputContextType.RECEIPT);
                        } else {
                            // order cancelled
                            result = FF.getTranslatable("_orderCancel").toString(OutputContextType.RECEIPT);
                        }
                    }
                    //sort order line 
                    CawOrderComparator lineComparator = new CawOrderComparator();
                    Collections.sort(order.getOrderLines(), lineComparator);
                    /*END BZ46879*/
                }
            }
        }

        return result;
    }
}
