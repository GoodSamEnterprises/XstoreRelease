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
 * BZ27712          261018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ29205          250119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ29210          250119    [Internal] Order Service cannot send WO to EBS
 * BZ29245          300119    [Internal][OS] Attributes item#500 is sent to OS incorrectly info when doing WO REFUND after bundling these fixed related to WO into 2.1
 * BZ48749          060122    [PROD] Issues in xStore vs DW sales report
 *===================================================================
 */

package caw.pos.workorder.item;

import java.util.List;
import java.util.ListIterator;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.*;
import caw.pos.workorder.common.CawWorkOrderHelper;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataPropertyUtils;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trl.impl.RetailTransactionLineItemPropertyModel;

/**
 *
 */
public class CawSaveWOItemAttributesOp extends Operation {
    
    private static final Logger _logger = LogManager.getLogger(CawSaveWOItemAttributesOp.class);

    /* BZ27712: add work order item attributes as retail line item property
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        String attributes = getScopedValue(CawValueKeys.CAW_WO_ITEM_ATTRIBUTES);
        JSONObject properties = getScopedValue(CawValueKeys.CAW_WO_ITEM_PROPERTIES); /*BZ29205*/
        ISaleReturnLineItem saleLine = getScopedValue(ValueKeys.CURRENT_SALE_LINE);

        /*Add attributes*/
        if (attributes != null && saleLine != null && !CawWorkOrderOptionsOp.isRefundAction()) {

            IRetailTransactionLineItemProperty saleLineProperty = CawWorkOrderHelper.getInstance()
                    .createLineItemPropertyObject(CawConstants.WO_CODE, saleLine, attributes
                            .substring(1, attributes.length() - 1)); /*BZ29245*/
                saleLine.addRetailTransactionLineItemProperty(saleLineProperty);
        }
        
        /*BEGIN BZ29205: Add properties*/
        if (properties != null && !CawWorkOrderOptionsOp.isRefundAction()) {
            try {
                if (saleLine != null && saleLine.getItem() != null) {
                    IItem item = saleLine.getItem();
                    List<IItemPromptProperty> promptProperties = item.getItemPromptProperties();
                    List<IItemPromptPropertyProperty> promptPropertiesP = null;
                    String stringValue = null;

                    if (CollectionUtils.isNotEmpty(promptProperties)) {
                        for (IItemPromptProperty promptProperty : promptProperties) {
                            promptPropertiesP = promptProperty.getProperties();

                            if (CollectionUtils.isNotEmpty(promptPropertiesP)) {
                                for (IItemPromptPropertyProperty promptPropertyP : promptPropertiesP) {
                                    stringValue = promptPropertyP.getStringValue();

                                    if (properties.has(stringValue)) {
                                        DataPropertyUtils.setPropertyValue(saleLine, promptPropertyP
                                                .getPromptPropertyCode(), properties.getString(stringValue));
                                        properties.remove(stringValue);
                                    }
                                }
                            }
                        }
                    }
                    String propertyCodeValue = CawUtilFunction
                            .queryKeyFormat(CawConstants.WOP_PREFIX, saleLine.getRetailLocationId(), saleLine
                                    .getBusinessDate(), saleLine.getWorkstationId(), saleLine
                                            .getTransactionSequence(), saleLine
                                                    .getRetailTransactionLineItemSequence());
                    DataPropertyUtils.setPropertyValue(saleLine, propertyCodeValue, properties.toString()
                            .substring(1, properties.toString().length() - 1));
                    /*Clear scope CawValueKeys.CAW_WO_ITEM_PROPERTIES before going to next item*/
                    clearScopedValue(CawValueKeys.CAW_WO_ITEM_PROPERTIES);
                }
            } catch (JSONException ex) {
                _logger.error("CawSaveWOItemAttributesOp: " + ex.getMessage());
            }
        }
        /*END BZ29205*/
        
        /* BEGIN BZ29245: Refund WO*/
        if (CawWorkOrderOptionsOp.isRefundAction()) {
            IRetailTransaction trans = _transactionScope
                    .getTransaction(TransactionType.RETAIL_SALE);

            if (trans != null) {
                List<IRetailTransactionLineItem> items = trans
                        .getSaleLineItems();
                List<IRetailTransactionLineItemProperty> itemProperties = null;
                IRetailTransactionLineItemProperty newSaleLineProperty = null;
                ISaleReturnLineItem lineItem = null;

                if (items != null && items.size() > 0) {
                    for (IRetailTransactionLineItem item : items) {
                        lineItem = (ISaleReturnLineItem) item;
                        itemProperties = item.getProperties();
                        /*Remove all properties on void items*/
                        if (item.getVoid()) {
                            itemProperties.clear();
                        }
                        /*No void and return items: get old property value and add again with new property code*/
                        if (CollectionUtils.isNotEmpty(itemProperties) && !item.getVoid() && lineItem.getReturn()) {
                            /*BEGIN BZ29205*/
                            ListIterator<IRetailTransactionLineItemProperty> listIterator = itemProperties
                                    .listIterator();
                            String propertyCode = "";
                            String stringAttbValue = "";
                            String stringValue = "";
                            IRetailTransactionLineItemProperty property = new RetailTransactionLineItemPropertyModel();
                            /*Iterate through property list*/
                            while (listIterator.hasNext()) {
                                property = listIterator.next();
                                propertyCode = property.getPropertyCode();
                                long rtlId = property.getRetailLocationId();
                                if (propertyCode.contains(CawConstants.WO_CODE)
                                        && propertyCode.contains(String.valueOf(rtlId))) {
                                    stringAttbValue = property.getStringValue();
                                    listIterator.remove();
                                } else if (propertyCode.contains(CawConstants.WOP_PREFIX)
                                        && propertyCode.contains(String.valueOf(rtlId))) {
                                    stringValue = property.getStringValue();
                                    listIterator.remove();
                                }
                            }
                            /*END BZ29205*/
                            //Only add line item property for item no void and return.
                            if (!item.getVoid() && lineItem.getReturn()) {
                                if (StringUtils.isNotEmpty(stringAttbValue)) {
                                    newSaleLineProperty = CawWorkOrderHelper.getInstance()
                                            .createLineItemPropertyObject(CawConstants.WO_CODE, lineItem, stringAttbValue);//BZ29210
                                    item.addRetailTransactionLineItemProperty(newSaleLineProperty);
                                }
                                if (StringUtils.isNotEmpty(stringValue)) {
                                    newSaleLineProperty = CawWorkOrderHelper.getInstance()
                                            .createLineItemPropertyObject(CawConstants.WOP_PREFIX, lineItem, stringValue);
                                    item.addRetailTransactionLineItemProperty(newSaleLineProperty);
                                }
                            }
                        }
                    }
                }
            }
        }
        /* END BZ29245: Refund WO*/
        
        /*BEGIN BZ48749*/
        if (saleLine != null) {
            IRetailTransactionLineItemProperty saleLineProperty = CawWorkOrderHelper.getInstance().createLineItemPropertyObject(saleLine, CawConstants.IS_WO_ITEM, Boolean.TRUE.toString());
            if(!CawWorkOrderOptionsOp.isRefundAction()) {
                saleLine.addRetailTransactionLineItemProperty(saleLineProperty);
            }else if(CawWorkOrderOptionsOp.isRefundAction()){
                //WO Refund => remove Property IS_WO_ITEM for all item
                IRetailTransaction trans = _transactionScope.getTransaction(TransactionType.RETAIL_SALE);
                if (trans != null) {
                    List<IRetailTransactionLineItem> items = trans.getSaleLineItems();
                    ISaleReturnLineItem lineItem = null;
                    if (items != null && items.size() > 0) {
                        for (IRetailTransactionLineItem item : items) {
                            lineItem = (ISaleReturnLineItem) item;
                            if(StringUtils.isNotEmpty(lineItem.getStringProperty(CawConstants.IS_WO_ITEM))) {
                                lineItem.deleteProperty(CawConstants.IS_WO_ITEM);
                            }
                        }
                    }
                }
            }
        }
        /*END BZ48749*/
        return HELPER.completeResponse();
    }
}
