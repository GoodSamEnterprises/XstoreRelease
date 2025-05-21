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
 * BZ37179          140820    Remove non-physical items (Deposit, Payment, Shipping Fee) in Order Transactions
 * BZ 37109         240820    [Task] Call QAS integration in Delivery Order to verify customer shipping address
 * BZ37884          180920    Disable extra Customer Copy & Store Copy of printed receipt for Brokered Order Transactions
 * BZ38051          020120    [Task] Need to modify receipt to display both Sale/Returned items and Order items when create an Order transaction into Xstore.
 * BZ37396          021020    Tax value calculation issue in Order transactions
 * BZ38436          131020    [Internal] Xstore makes a call TAX API unexpectedly for Sale Transaction without any Order items into the transaction at "At tender" button
 * BZ38471          141020    [Internal] Xstore does not call TAX API to calculate again during creating Order Delivery in case mixed order items firstly then Sale items when hit Exit Order button.
 * BZ42889          110521    [Prod] Order cancellation with pricing turned on, tries to force a return with a refund. The refund should be happening in Oracle.
 * BZ45973          270821    [Internal] Exception caught during op exec for dtv.pos.customer.EnsureExistingCustInfoPresentOp
 * BZ47440          071221    [Internal patch 7.0.16] Order Complete Receipt - Deposit/Payments and Balance Due printed incorrectly when picking up an BOPIS that contained cancelled item
 * BZ47630          131221    [Internal patch 7.0.16-17] Enable Reject Order button - Incorrect order line item status when do a partial reject
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.address.search.CawPromptAddressLookupHelper;
import caw.pos.address.search.CawQASHelper;
import caw.pos.common.*;
import caw.qas.proweb.*;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.data2x.DataServiceUtils;
import dtv.pos.address.search.AddressSearchInfo;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.IBusyState;
import dtv.pos.order.*;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.type.LineItemType;
import dtv.util.DateUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.crm.IPartyLocaleInformation;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.IOrderServices;
import dtv.xst.xom.impl.order.OrderLineStatus;
import dtv.xst.xom.impl.order.OrderStatus;
import dtv.xst.xom.impl.order.update.OrderUpdateRequest;
import dtv.xst.xom.order.IOrderUpdateRequest;
import dtv.xst.xom.order.IOrderUpdateResponse;

/**
 *
 */
public class CawOrderHelper extends OrderHelper {
    

    private static final Logger            _logger                         = LogManager.getLogger(CawOrderHelper.class);
    
    private CawPromptAddressLookupHelper   _addressHelper                  = CawPromptAddressLookupHelper.getInstance();

    public static final String             DEPOSIT_MOCKUP_ITEM_ID          = "ORDER";

    public static final String             ITEM_DEFAULT_VALUE              = "*";

    public static final String             DEPOSIT_MOCKUP_ITEM_NAME        = "Order Deposit";

    public static final String             MERCH_LEVEL_1                   = "NP";

    public static final String             ENTRY_METHOD_CODE               = "AUTOMATIC";

    private static volatile CawOrderHelper INSTANCE                        = null;
    
    //BEGIN BZ38051
    @Inject
    private OrderMgr                       _orderMgr;
    
    @Inject
    private Provider<IOrderServices> _orderServices;
    
    /* BEGIN BZ37396 */
    private static final String  TAX_LOCATION            = "VITURAL";

    private static final Integer TAX_SEQUENCE            = 1;

    private static final String  TAX_AUTHORITY_ID        = "TAX_API";

    private static final String  TAX_AUTHORITY_NAME      = "Neuron Tax API";

    private static final String  TAX_AUTHORITY_TYPE_CODE = "TAX_API";

    private static final String  TAX_CODE                = "taxCode";

    private static final String  TAX_AMOUNT              = "taxAmount";

    private static final String  ATTRIBUTES              = "attributes";

    private static final String  TAX_RATE                = "taxRate"; 
    
    private static final String  CODE                     = "code";

    /* BEGIN BZ42889*/
    private static final String  OMNI_REFUND_YES          = "OMNI_REFUND:YES";

    private static final String  CAW_POS_OMNI_REFUND      = "CAW_POS_OMNI_REFUND";
    /* END BZ42889*/
    /* END BZ37396 */

    public CawOrderHelper() {
        super();
        InjectionHammer.forceAtInjectProcessing(this);
    }

    //END BZ38051
    public static CawOrderHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawOrderHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawOrderHelper();
                }
            }
        }
        return INSTANCE;
    }

    IItem mockupItemDeposit() {

        IItem item = ItemLocator.getLocator()
                .getEmptyItem(DEPOSIT_MOCKUP_ITEM_ID);
        item.setOrganizationId(ConfigurationMgr.getOrganizationId());
        item.setOrgCode(ITEM_DEFAULT_VALUE);
        item.setOrgValue(ITEM_DEFAULT_VALUE);
        item.setMerchLevel1Id(MERCH_LEVEL_1);
        item.setName(DEPOSIT_MOCKUP_ITEM_NAME);
        item.setDescription(DEPOSIT_MOCKUP_ITEM_NAME);

        IItemOptions iItemOption = DataFactory.createObject(IItemOptions.class);
        iItemOption.setOrganizationId(ConfigurationMgr.getOrganizationId());
        iItemOption.setItem(item);
        iItemOption.setVendorId(CawConstants.EMPTY_SIGN);
        iItemOption.setLevelCode(ITEM_DEFAULT_VALUE);
        iItemOption.setLevelValue(ITEM_DEFAULT_VALUE);
        iItemOption.setNotReturnable(false);
        iItemOption.setExcludeFromNetSales(false);

        ((IDataModelImpl) iItemOption).getDAO()
                .setObjectState(DaoState.CLEAN.intVal());

        List<IItemOptions> iItemOptions = new ArrayList<IItemOptions>();
        iItemOptions.add(iItemOption);
        item.setItemOptions(iItemOptions);

        // The IItem object dose not insert to database.
        ((IDataModelImpl) item).getDAO().setObjectState(DaoState.CLEAN.intVal());

        return item;
    }

    public ISaleReturnLineItem createDepositAmountLine(BigDecimal depositAmount) {

        RetailTransactionLineItemId id = new RetailTransactionLineItemId();
        ISaleReturnLineItem result = DataFactory.createObject(ISaleReturnLineItem.class);

        IItem item = mockupItemDeposit();

        result.setItem(item);
        result.setScannedItemId(item.getItemId());
        result.setMerchLevel1Id(item.getMerchLevel1Id());
        result.setVendorId(item.getOptions().getVendorId());
        result.setUnitCost(item.getOptions().getUnitCost());
        result.setNotReturnable(item.getOptions().getNotReturnable());
        result.setExcludeFromNetSales(item.getOptions()
                .getExcludeFromNetSales());
        if (depositAmount != null) {
            result.setBaseUnitPrice(depositAmount);
            result.setUnitPrice(depositAmount);
        } else {
            result.setBaseUnitPrice(BigDecimal.ZERO);
            result.setUnitPrice(BigDecimal.ZERO);
        }
        result.setRegularBasePrice(BigDecimal.ZERO);

        result.setBeginDateTimestamp(DateUtils.getNewDate());
        result.setQuantity(BigDecimal.ONE);
        result.setInitialQuantity(BigDecimal.ONE);

        result.setQuantityToAllocate(BigDecimal.ONE);
        result.setSaleReturnLineItemTypeCode(SaleItemType.ORDER.getName());
        result.setLineItemTypeCode(LineItemType.ITEM.getName());
        result.setItemIdEntryMethodCode(ENTRY_METHOD_CODE);

        // The Item object dose not insert to database.
        ((IDataModelImpl) result).getDAO().setObjectState(DaoState.CLEAN.intVal());

        return result;
    }
    
    /* BEGIN BZ37109 */
    public int checkQASMatchingLookupAddress(Object frmModel,
            IBusyState argBusyState, TransactionScope argTransactionScope) {

        int defaultNotFound = -1;
        if (frmModel != null && frmModel instanceof DeliveryInfoModel) {

            DeliveryInfoModel infoModel = (DeliveryInfoModel) frmModel;

            String addressLine = getMergedAddressOneLine(infoModel);
            String countryAlpha2 = infoModel.getCountry();

            //Added BZ26568
            if (!_addressHelper.isCountryQASEnabled(countryAlpha2)) {
                return -3;
            }

            CawQASearchResult resultLookup = null;
            if (addressLine != null && addressLine.length() > 0) {
                String line = addressLine.trim();
                if (line.length() > 0) {
                    argBusyState.start(CawConstants.BUSY_STATE_MSG);
                    resultLookup = _addressHelper
                            .doSearchAddress(line, countryAlpha2);
                    argBusyState.end();
                    if (resultLookup == null) {
                        if (CawQASHelper.getInstance().isOffline()) {
                            return -2;//BZ26575 Offline
                        } else {
                            return -1;//BZ26575 Not found
                        }
                    }
                }
            }

            if (resultLookup != null) {
                CawQAAddressType address = resultLookup.getQAAddress();
                CawQAPicklistType pickList = resultLookup.getQAPicklist();
                CawVerifyLevelType verifyLevel = resultLookup.getVerifyLevel();

                IPartyLocaleInformation localeInfo = null;
                AddressSearchInfo addressSearchInfo = _addressHelper
                        .getAddressSearchInfo(verifyLevel, address);
                if (addressSearchInfo != null) {
                    localeInfo = addressSearchInfo.getResultAddress();
                }

                if (localeInfo != null) {
                    String addressResponseStr = _addressHelper
                            .getMergedAddressOneLine(localeInfo);
                    if (addressResponseStr != null
                            && addressResponseStr.length() > 0) {
                        if (addressResponseStr.equalsIgnoreCase(addressLine)) {
                            return 0; //BZ26575 found
                        } else {
                            argTransactionScope
                                    .setValue(CawValueKeys.CAW_QAS_SEARCH_RESULT, resultLookup);
                            return 1; //BZ26575 found, but not matching
                        }
                    }
                }

                if ((pickList != null) && pickList.getPotentialMatches() != null
                        && (BigInteger.ZERO.compareTo(pickList
                                .getPotentialMatches()) != 0)) {
                    List<CawPicklistEntryType> entries = pickList
                            .getPicklistEntry();
                    if (entries != null && entries.size() > 0) {
                        argTransactionScope
                                .setValue(CawValueKeys.CAW_QAS_SEARCH_RESULT, resultLookup);
                        return entries.size();
                    }
                }

            }
        }
        return defaultNotFound;
    }

    public String getMergedAddressOneLine(DeliveryInfoModel infoModel) {

        StringBuilder address = new StringBuilder();
        DeliveryInfoModel _infoModel = infoModel;
        try {
            if (_infoModel != null) {
                if (_infoModel.getAddress1() != null) {
                    address.append(_infoModel.getAddress1());
                }
                if (_infoModel.getAddress2() != null) {
                    if (_infoModel.getAddress1() == null) {
                        address.append(_infoModel.getAddress2());
                    } else {
                        address.append(", ").append(_infoModel.getAddress2());
                    }
                }
                if (_infoModel.getAddress3() != null) {
                    if (_infoModel.getAddress1() == null
                            && _infoModel.getAddress2() == null) {
                        address.append(_infoModel.getAddress3());
                    } else {
                        address.append(", ").append(_infoModel.getAddress3());
                    }
                }
                if (_infoModel.getAddress4() != null) {
                    if (_infoModel.getAddress1() == null
                            && _infoModel.getAddress2() == null
                            && _infoModel.getAddress3() == null) {
                        address.append(_infoModel.getAddress4());
                    } else {
                        address.append(", ").append(_infoModel.getAddress4());
                    }
                }
                address.append(", ");
                if (_infoModel.getCity() != null) {
                    address.append(_infoModel.getCity());
                }
                address.append(", ");
                if (_infoModel.getState() != null) {
                    address.append(_infoModel.getState());
                }
                if (_infoModel.getPostalCode() != null) {
                    address.append(" ").append(_infoModel.getPostalCode());
                }
            }
        } catch (Exception ex) {
            _logger.error("getMergedAddressLine-1: " + ex.getMessage());
        }
        return address.toString();
    }
    /* END BZ37109 */
    
    /*BEGIN BZ37884*/
    /**
    * 
    * @param retailTrans
    * @return
    */
    public boolean isOrderTransaction(IRetailTransaction retailTrans) {

        boolean isOrder = false;
        List<ISaleReturnLineItem> items = retailTrans.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
        for (ISaleReturnLineItem lineItem : items) {
            if (!lineItem.getVoid()) {
                if (SaleItemType.ORDER.matches(lineItem.getSaleReturnLineItemTypeCode())) {
                    isOrder = true;
                    break;
                } else if (lineItem.getOrderModifier() != null) {
                    isOrder = true;
                    break;
                }
            }
        }
        return isOrder;
    }
    /*END BZ37884*/
    //BEGIN BZ38051
    public boolean isOrderCreateMixedTransaction(IRetailTransaction retailTrans) {

        boolean isOrderCreateMixed = false;
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        List<ISaleReturnLineItem> items = retailTrans.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
        if (currentOrder != null
                && OrderStatus.NEW.matches(currentOrder.getStatusCode())) {
            //Create new Order
            for (ISaleReturnLineItem lineItem : items) {
                if (!lineItem.getVoid()) {
                    //Mixed sale or return
                    if (SaleItemType.SALE.matches(lineItem.getSaleReturnLineItemTypeCode())
                            || SaleItemType.RETURN.matches(lineItem.getSaleReturnLineItemTypeCode())) {
                        isOrderCreateMixed = true;
                        break;
                    }
                }
            }
        }
        return isOrderCreateMixed;
    }
    //END BZ38051
    
    /* BEGIN BZ37396, BZ38471 */
    public void updateTaxModifier(JSONArray items, IOrder order, IPosTransaction trans) {

        JSONObject item = null;
        String taxCode = null;
        BigDecimal taxAmount = BigDecimal.ZERO;
        BigDecimal taxRate = BigDecimal.ZERO;
        JSONObject attributes = null;
        List<ISaleTaxModifier> lstSaleTaxMod = null;
        String shippingID = null;
        int temp = -1;
        try {
        
            List<ISaleReturnLineItem> transLineItems = trans
                    .getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
            
            List<IOrderLine> orderlines = order.getOrderLines();
            
            for (ISaleReturnLineItem transLineItem : transLineItems) {
                if (transLineItem.getItem() instanceof INonPhysicalItem  && !transLineItem.getVoid()) {
                    item = items.getJSONObject(0);
                    shippingID = item.getString(CODE);
                    if (transLineItem.getItemId().equals(shippingID)) {
                        temp++;
    
                        lstSaleTaxMod = transLineItem.getTaxModifiers();
                        item = items.getJSONObject(temp);
                        
                        taxCode = item.getString(TAX_CODE);
                        taxAmount = new BigDecimal(item.getString(TAX_AMOUNT));
                        attributes = item.getJSONObject(ATTRIBUTES);
                        taxRate = new BigDecimal(attributes.getString(TAX_RATE));
    
                        lstSaleTaxMod = transLineItem.getTaxModifiers();
                        for (ISaleTaxModifier saleTaxMod : lstSaleTaxMod) {                        
                            transLineItem.removeSaleTaxModifier(saleTaxMod);
                            
                            saleTaxMod.setTaxGroupId(taxCode);
                            saleTaxMod.setTaxAmount(taxAmount);
                            saleTaxMod.setTaxPercentage(taxRate);
                            saleTaxMod.setRawTaxPercentage(taxRate);
                            saleTaxMod.setRawTaxAmount(taxAmount);
                            saleTaxMod.setSaleTaxModifierSequence(1);
                            //BZ45973 comment out: saleTaxMod.setTaxLocationId(TAX_LOCATION);
                            saleTaxMod.setAuthorityId(TAX_AUTHORITY_ID);
                            saleTaxMod.setAuthorityName(TAX_AUTHORITY_NAME);
                            saleTaxMod.setAuthorityTypeCode(TAX_AUTHORITY_TYPE_CODE);
                            saleTaxMod.setTaxOverrideAmount(taxAmount);
                            saleTaxMod.setTaxRuleSequence(TAX_SEQUENCE);
                            saleTaxMod.setTaxOverride(true);
                            transLineItem.addSaleTaxModifier(saleTaxMod);
                        }
                    }
                }
            }

            for (IOrderLine orderline : orderlines) {
                // Update tax of items except deposit item
                if (orderline != null && !orderline.getVoid()) {
                    
                    ISaleReturnLineItem transLineItem = orderline.getShadowedSaleItem();
                    temp++;
                    lstSaleTaxMod = transLineItem.getTaxModifiers();
                    item = items.getJSONObject(temp);
                    
                    taxCode = item.getString(TAX_CODE);
                    taxAmount = new BigDecimal(item.getString(TAX_AMOUNT));
                    attributes = item.getJSONObject(ATTRIBUTES);
                    taxRate = new BigDecimal(attributes.getString(TAX_RATE));

                    lstSaleTaxMod = transLineItem.getTaxModifiers();
                    for (ISaleTaxModifier saleTaxMod : lstSaleTaxMod) {
                        transLineItem.removeSaleTaxModifier(saleTaxMod);
                        
                        saleTaxMod.setTaxGroupId(taxCode);
                        saleTaxMod.setTaxAmount(taxAmount);
                        saleTaxMod.setTaxPercentage(taxRate);
                        saleTaxMod.setRawTaxPercentage(taxRate);
                        saleTaxMod.setRawTaxAmount(taxAmount);
                        saleTaxMod.setSaleTaxModifierSequence(1);
                        //BZ45973 comment out: saleTaxMod.setTaxLocationId(TAX_LOCATION);
                        saleTaxMod.setAuthorityId(TAX_AUTHORITY_ID);
                         saleTaxMod.setAuthorityName(TAX_AUTHORITY_NAME);
                        saleTaxMod.setAuthorityTypeCode(TAX_AUTHORITY_TYPE_CODE);
                        saleTaxMod.setTaxOverrideAmount(taxAmount);
                        saleTaxMod.setTaxRuleSequence(TAX_SEQUENCE);
                        saleTaxMod.setTaxOverride(true);
                        transLineItem.addSaleTaxModifier(saleTaxMod);
                    }
                }
            }

        } catch (JSONException ex) {
          _logger.info("[Exception happen when mapping Tax response]: " + ex.getMessage());
        }
    }
    /* END BZ37396, BZ38471 */
    
    /* BEGIN BZ38436 */
    public boolean isOrderLinesNotVoid(IOrder order) {

        boolean result = false;
        int count = 0;

        if (order != null) {
            for (IOrderLine orderLine : order.getOrderLines()) {
                if (!orderLine.getVoid()) {
                    count++;
                    break;
                }
            }
            if (count != 0) {
                result = true;
            }
        }
        return result;
    }
    /* END BZ38436 */
    
    /* BEGIN BZ42889 */
    public boolean isOmniRefundYes(OrderMgr orderMgr) {

        IOrder order = _orderMgr.getCurrentOrder();

        if (order != null) {
            String notes = order.getNotes();

            if (StringUtils.isNotEmpty(notes)) {

                notes = notes.replaceAll("\\s", "");
                
                String omniRefundYes = CawPropertyUtils.getSystemProperty(CAW_POS_OMNI_REFUND, OMNI_REFUND_YES);
                
                if (StringUtils.isNotEmpty(omniRefundYes)
                        && notes.contains(omniRefundYes)) {
                    return true;
                }
            }
        }
        return false;
    }
    /* END BZ42889 */
    
    // BEGIN BZ47440
    @Override
    public IOrder updateOrderLinesStatus(IOrder argOrder, List<IOrderLine> argOrderLines, OrderLineStatus argNewStatus,
            long argRetailLocationId, String argUserId) {
        //BEGIN BZ47630
        IOrder updatedOrder = argOrder;
        
        for (int i = 0; i < argOrderLines.size(); i++) {            
            List<IOrderLine> reqOrderLine = new ArrayList<IOrderLine>();
            reqOrderLine.add(argOrderLines.get(i));
            IOrderUpdateRequest updateLinesRequest = new OrderUpdateRequest(argOrder, reqOrderLine, argNewStatus);
            updateLinesRequest.setEmployeeId(DataServiceUtils.toSafeString(argUserId));
            updateLinesRequest.setStoreId(argRetailLocationId);
            IOrderUpdateResponse updateLinesResponse = this._orderServices.get().updateOrderLines(updateLinesRequest);
        }
        //END BZ47630
        
        if (OrderLineStatus.REJECTED.equals(argNewStatus) || OrderLineStatus.CANCELLED.equals(argNewStatus)) {
            List<IOrderLineProperty> existingOrderLinesProp = new ArrayList<IOrderLineProperty>();
            argOrder.getOrderLines().forEach(li -> existingOrderLinesProp.addAll(li.getProperties()));
            
            this.lookupOrder(argOrder, argRetailLocationId);
            List<IOrderLineProperty> newAddedOrderLinesProp = new ArrayList<IOrderLineProperty>();
            argOrder.getOrderLines().forEach(li -> newAddedOrderLinesProp.addAll(
                    li.getProperties().stream().filter(dtl -> !existingOrderLinesProp.contains(dtl))
                    .collect(Collectors.toList())));
        }

        return updatedOrder;
    }
    
    protected void refreshUpdateResponse(List<IOrderLineProperty> argOrigOrderLines, List<IOrderLineProperty> argNewlyAddedOrderLines, OrderLineStatus argNewStatus, IOrderUpdateResponse argUpdateResponse) {
         
        List<IOrderLineProperty> sortedNewOrderLines = argNewlyAddedOrderLines.stream().sorted(new Comparator<IOrderLineProperty>(){
            @Override
            public int compare( IOrderLineProperty line1, IOrderLineProperty line2) {
                int result = 0;
                if (line1.getSequence() > line2.getSequence()) {
                    result = -1;
                }
                else if (line1.getSequence() < line2.getSequence()) {
                    result = 1;
                }
                return result;
            }
        }).collect(Collectors.toList());
        
        List<IOrderLine> respLines = argUpdateResponse.getOrderLines();

        for(int i = respLines.size() - 1; i >= 0; --i) {
            IOrderLineProperty origLine = argOrigOrderLines.get(i);
            IOrderLineProperty respLine = (IOrderLineProperty)respLines.get(i);
           if (origLine != respLine) {
              if (OrderLineStatus.REJECTED.equals(argNewStatus)) {
              } else {
                  IOrderLineProperty orderLine = sortedNewOrderLines.stream().filter((dtl) -> {
                    return dtl.getSequence() == respLine.getSequence();
                 }).findFirst().orElse((IOrderLineProperty)null);
                 if (orderLine != null) {                    
                    sortedNewOrderLines.remove(orderLine);
                 }
              }
           }
        }

     }
    // END BZ47440
}
