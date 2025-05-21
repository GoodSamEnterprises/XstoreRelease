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
 * BZ43207          221121    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import caw.pos.common.CawConstants;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.order.IOrderReceiptSource;
import dtv.xst.dao.xom.IOrderPayment;

public class CawOrderPaymentBuilderField extends AbstractDocBuilderField {

    public CawOrderPaymentBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
        BigDecimal summaryRefundAmount = BigDecimal.ZERO;
        
        if (argSource instanceof IOrderReceiptSource) {            
            List<IOrderPayment> listOrderPayments = ((IOrderReceiptSource) argSource).getOrder().getPayments();
                       
            for (IOrderPayment orderPayment : listOrderPayments) {
                if (!orderPayment.getVoid()) {
                    if (CawConstants.CAW_REFUND_CONSTANT.equalsIgnoreCase(orderPayment.getTypeCode())) {
                        summaryRefundAmount = summaryRefundAmount.add(orderPayment.getAmount());
                    }
                }
            }            
        }
        return this.getFormatter().format(summaryRefundAmount, argLocale);
    }
}
