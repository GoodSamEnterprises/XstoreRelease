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
 * BZ28201          121118    [New Requirement] Additional Item Prompts and attributes for 500 item needs to print on transaction receipts.
 * BZ28356          161118    [Internal] Remove the Vendor Cost Attribute from Transaction Receipts for 0500/500 item
 * BZ28483          031218    [Internal] Missing Vendor instructions from receipt
 * BZ29212          280119    [Internal] VC attributes is printed on receipt when exchanging item 500.
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ47542          061221    RV Service Payments - Property Names
 * BZ46743          100122    Vehicle Identification Number (VIN) Capture for Xstore
 * BZ48083          100122    Patch 19 - VIN Item - Order Cancel receipt should NOT print the VIN Number
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawJSONConstant;
import caw.pos.register.rvpayment.CawRvPaymentHelper;
import caw.pos.register.vin.CawVinHelper;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.register.ItemLocator;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.IRetailTransactionLineItemProperty;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;
import dtv.xst.dao.xom.impl.OrderLineModel;

public class CawItemPropertiesBuilderField extends AbstractDocBuilderField {

    private static final String NEW_LINE          = "\n";
    private static final String NOT_PRINT_RECEIPT = "NOT_PRINT_RECEIPT";

    @Inject
    protected FormattableFactory FF;
    public CawItemPropertiesBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);

    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String strItemProperties = "";
        List<IItemPromptProperty> iItemPromptProperty = null;
        List<IRetailTransactionLineItemProperty> iRetailTransLineItemProperties = null;
        
        if (argSource instanceof SaleReturnLineItemModel) {
            iRetailTransLineItemProperties = ((SaleReturnLineItemModel) argSource).getProperties();
            ISaleReturnLineItem saleLineItem = (ISaleReturnLineItem) argSource;/*BZ44917*/
           /* iItemPromptProperty = ((SaleReturnLineItemModel) argSource)
                    .getItem().getItemPromptProperties();*/
            IItem item = ((SaleReturnLineItemModel) argSource).getItem();
            /*BEGIN BZ29212*/
            if (((SaleReturnLineItemModel) argSource).getReturn())
                item = ItemLocator.getLocator().lookupItem(item.getItemId());
            /*END BZ29212*/
            /*BEGIN BZ44917*/
            if (CawRvPaymentHelper.isRvPaymentSaleLineItem(saleLineItem)) {
                strItemProperties = strItemProperties + getRvPaymentItemProperties(saleLineItem);
            }else {
            /*END BZ44917*/
                iItemPromptProperty = item.getItemPromptProperties();
                /*Sort list _iItemPromptProperty with getSortOrder() ascending.*/
                if (CollectionUtils.isNotEmpty(iItemPromptProperty)) {
                    Collections
                            .sort(iItemPromptProperty, new Comparator<IItemPromptProperty>() {
                                @Override
                                public int compare(
                                        IItemPromptProperty itemPromptPropertyBefore,
                                        IItemPromptProperty itemPromptPropertyAfter) {
                                    return itemPromptPropertyBefore.getSortOrder()
                                            - itemPromptPropertyAfter
                                                    .getSortOrder();
                                }
                            });
                    strItemProperties = getAllPropertiesOfItem(iItemPromptProperty, iRetailTransLineItemProperties);
                }
            }
        }else if (argSource instanceof OrderLineModel) {
            /* BEGIN BZ46743, BZ48083 */            
            OrderLineModel orderLine = (OrderLineModel) argSource;
            
            if (CawVinHelper.isVinItem(orderLine.getShadowedSaleItem().getItem())) {
                
                String vinLabel = FF.getTranslatable("_cawVinOrderRcptLabel").toString();
                String vinNum = orderLine.getStringProperty(CawConstants.CAW_VEHICLE_IDENTIFICATION_NUMBER);
                if (!StringUtils.isEmpty(vinNum)) {
                    strItemProperties =  vinLabel + CawConstants.CAW_COLON_SIGN + CawConstants.SPACE_SIGN + orderLine.getStringProperty(CawConstants.CAW_VEHICLE_IDENTIFICATION_NUMBER);
        }
            }
            /* END BZ46743 BZ48083*/
        }
        
        return strItemProperties;
    }

    private String getPropertiesValue(
            List<IRetailTransactionLineItemProperty> _iRetailTransLineItemProperty,
            String _promptTitleKey, String _protPropertyCode) {

        String itemValuePropertyTrans = "";
        String strLineItemPropertyResulft = "";

        if (CollectionUtils.isNotEmpty(_iRetailTransLineItemProperty)) {
            String itemPropertyCodeTrans = "";
            /*Get value in table TransactionLineItemProperty*/
            for (IRetailTransactionLineItemProperty iRetailTransaction : _iRetailTransLineItemProperty) {
                itemPropertyCodeTrans = iRetailTransaction.getPropertyCode();
                if (StringUtils.isNotEmpty(_protPropertyCode)
                        && _protPropertyCode
                                .equalsIgnoreCase(itemPropertyCodeTrans)) {
                    /*Check value of property equal null of empty then*/
                    /*Begin BZ28483*/
                    if (iRetailTransaction.getPropertyValue() != null
                            && StringUtils.isNotEmpty(iRetailTransaction
                                    .getPropertyValue().toString())) {
                        itemValuePropertyTrans = iRetailTransaction
                                .getPropertyValue().toString();
                        strLineItemPropertyResulft = _promptTitleKey
                                + itemValuePropertyTrans + NEW_LINE;
                        break;
                    } else {
                        break;
                    }
                    /*End BZ28483*/
                }
            }
        }

        return strLineItemPropertyResulft;
    }

    private String getAllPropertiesOfItem(
            List<IItemPromptProperty> _iItemPromptProperty,
            List<IRetailTransactionLineItemProperty> _iRetailTransLineItemProperty) {
        String strItemProperties = "";
        List<IItemPromptPropertyProperty> iItemPromptPropertyProperty = null;
        String protPropertyCode = "";
        String promptTitleKey = "";
        String strLineItemProperty = "";
        boolean checkNotPrintReceipt = true;

        for (IItemPromptProperty ItemPrompt : _iItemPromptProperty) {
            protPropertyCode = ItemPrompt.getPromptPropertyCode();
            

            promptTitleKey = ItemPrompt.getPromptTitleKey() + ": ";
            /*Get from P based on the id from normal table.*/
            iItemPromptPropertyProperty = ItemPrompt.getProperties();
            /*Get line item property to print receipt with value of item property not null and empty*/
            strLineItemProperty = getPropertiesValue(_iRetailTransLineItemProperty, promptTitleKey, protPropertyCode);

            if (CollectionUtils.isNotEmpty(iItemPromptPropertyProperty)) {
                /*Check value from P based  have in List property with condition is NOT_PRINT_RECEIPT 
                  and Decimal value = 1 (1 is not print and 0 is print)*/
                for (IItemPromptPropertyProperty property : iItemPromptPropertyProperty) {
                    if (NOT_PRINT_RECEIPT
                            .equalsIgnoreCase(property.getPropertyCode())) {
                        checkNotPrintReceipt = true;
                        if (BigDecimal.ONE
                                .compareTo(property.getDecimalValue()) == 0) {
                            protPropertyCode = "";
                            promptTitleKey = "";
                            break;
                        } else {
                            /*With case is Decimal value = 0. It print receipt.*/
                            /*Begin BZ28483*/
                            if (!strLineItemProperty.equals("")) {
                                strItemProperties += strLineItemProperty;
                            }
                            /*End BZ28483*/
                            break;
                        }
                    } else {
                        checkNotPrintReceipt = false;
                    }
                }
                if (checkNotPrintReceipt == false) {
                    /*Begin BZ28483*/
                    if (!strLineItemProperty.equals("")) {
                        strItemProperties += strLineItemProperty;
                    }
                    /*End BZ28483*/
                }
            }
            // When get from P non data
            else {
                strItemProperties += strLineItemProperty;
            }
        }
        return strItemProperties;

    }
    /*BEGIN BZ44917, BZ47542*/
    private String getRvPaymentItemProperties(ISaleReturnLineItem argSaleLineItem) {

        BigDecimal balanceDue = argSaleLineItem.getExtendedAmount();
        String rvWorkOrder = StringUtils.EMPTY;
        String rvDescription = StringUtils.EMPTY;
        
        if (StringUtils.isNotEmpty(argSaleLineItem.getStringProperty(CawConstants.RV_SERVICE_PAYMENT_PROPERTIES))) {
            String properties = argSaleLineItem.getStringProperty(CawConstants.RV_SERVICE_PAYMENT_PROPERTIES);
            
            rvWorkOrder = CawRvPaymentHelper.getRvProperty(properties,CawJSONConstant.JSON_WORK_ORDER);
            rvDescription = CawRvPaymentHelper.getRvProperty(properties, CawJSONConstant.JSON_DESCRIPTION);
        }
        
        IFormattable strItemProperties = FF.getTranslatable("_rvPaymentPropertiesReceipt", new IFormattable[] { FF
                        .getLiteral(rvWorkOrder), FF.getLiteral(balanceDue), FF.getLiteral(rvDescription) });
        
        return strItemProperties.toString();
    }
    /*END BZ44917, BZ47542*/
}
