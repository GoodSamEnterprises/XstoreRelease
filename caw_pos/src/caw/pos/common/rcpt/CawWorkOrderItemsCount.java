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
 * BZ28108          071118    [Internal] Sold Item Count does not print on WORK ORDER COMPLETE Receipts for work order only items 
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.util.NumberUtils;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.itm.INonPhysicalItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

public class CawWorkOrderItemsCount extends AbstractDocBuilderField {

    public CawWorkOrderItemsCount(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {
        BigDecimal itemCount = NumberUtils.ZERO;
        List<ISaleReturnLineItem> iSaleReturnLineItem = null;
        if (argSource instanceof RetailTransactionModel) {
            iSaleReturnLineItem = ((RetailTransactionModel) argSource)
                    .getLineItems(ISaleReturnLineItem.class);
            if (iSaleReturnLineItem != null) {
                for (ISaleReturnLineItem lineItem : iSaleReturnLineItem) {

                    if (lineItem instanceof SaleReturnLineItemModel && !lineItem.getVoid()) {
                        final IItem item = lineItem.getItem();
                        if (item instanceof INonPhysicalItem) {
                            final INonPhysicalItem nonPhysItem = (INonPhysicalItem) item;
                            /* If this is a Non-Physical item, then check SystemConfig.xml to determine if it should be
                             * included in the count. */
                            boolean matchFound = false;
                            final String[] includeNonMerchTypes = ConfigurationMgr.getNonMerchIncludeItemCounts();

                            for (final String includeNonMerchType : includeNonMerchTypes) {
                                if (includeNonMerchType != null
                                        && includeNonMerchType.equals(nonPhysItem.getNonPhysicalItemTypeCode())) {
                                    matchFound = true;
                                    break;
                                }
                            }

                            if (!matchFound) {
                                continue;
                            }
                        }
                        // If we get this far, include the item in the count.
                        itemCount = itemCount.add(item.getMeasurementRequired() ? BigDecimal.ONE : lineItem.getQuantity());
                    }

                }

            }

        }
        return getFormatter().format(itemCount, argLocale);
    }
}