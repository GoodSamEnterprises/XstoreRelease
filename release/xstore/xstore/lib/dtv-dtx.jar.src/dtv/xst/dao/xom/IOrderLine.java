/*    */ package dtv.xst.dao.xom;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IOrderLine extends IDataModel, IOrderLineModel, IHasDataProperty<IOrderLineProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ORDERID = new EventEnum("set orderId");
/* 11 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_EXTERNALORDERID = new EventEnum("set externalOrderId");
/* 17 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 18 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 19 */   public static final EventEnum SET_FULFILLMENTTYPE = new EventEnum("set fulfillmentType");
/* 20 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 21 */   public static final EventEnum SET_UNITPRICE = new EventEnum("set unitPrice");
/* 22 */   public static final EventEnum SET_EXTENDEDPRICE = new EventEnum("set extendedPrice");
/* 23 */   public static final EventEnum SET_TAXAMOUNT = new EventEnum("set taxAmount");
/* 24 */   public static final EventEnum SET_NOTES = new EventEnum("set notes");
/* 25 */   public static final EventEnum SET_SELECTEDSHIPMETHOD = new EventEnum("set selectedShipMethod");
/* 26 */   public static final EventEnum SET_ACTUALSHIPMETHOD = new EventEnum("set actualShipMethod");
/* 27 */   public static final EventEnum SET_TRACKINGNUMBER = new EventEnum("set trackingNumber");
/* 28 */   public static final EventEnum SET_DROPSHIP = new EventEnum("set dropShip");
/* 29 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 30 */   public static final EventEnum SET_STATUSCODEREASON = new EventEnum("set statusCodeReason");
/* 31 */   public static final EventEnum SET_LINENUMBER = new EventEnum("set lineNumber");
/* 32 */   public static final EventEnum SET_STATUSCODEREASONNOTE = new EventEnum("set statusCodeReasonNote");
/* 33 */   public static final EventEnum SET_ITEMUPCCODE = new EventEnum("set itemUpcCode");
/* 34 */   public static final EventEnum SET_ITEMEANCODE = new EventEnum("set itemEanCode");
/* 35 */   public static final EventEnum SET_EXTENDEDFREIGHT = new EventEnum("set extendedFreight");
/* 36 */   public static final EventEnum SET_CUSTOMIZATIONCHARGE = new EventEnum("set customizationCharge");
/* 37 */   public static final EventEnum SET_GIFTWRAP = new EventEnum("set giftWrap");
/* 38 */   public static final EventEnum SET_SHIPALONE = new EventEnum("set shipAlone");
/* 39 */   public static final EventEnum SET_SHIPWEIGHT = new EventEnum("set shipWeight");
/* 40 */   public static final EventEnum SET_LINEMESSAGE = new EventEnum("set lineMessage");
/* 41 */   public static final EventEnum SET_SOURCEMODIFIER = new EventEnum("set SourceModifier");
/* 42 */   public static final EventEnum SET_FULFILLMENTMODIFIER = new EventEnum("set FulfillmentModifier");
/* 43 */   public static final EventEnum ADD_BALANCEMODIFIERS = new EventEnum("add BalanceModifiers");
/* 44 */   public static final EventEnum REMOVE_BALANCEMODIFIERS = new EventEnum("remove BalanceModifiers");
/* 45 */   public static final EventEnum SET_BALANCEMODIFIERS = new EventEnum("set BalanceModifiers");
/* 46 */   public static final EventEnum ADD_CUSTOMIZATIONMODIFIERS = new EventEnum("add CustomizationModifiers");
/* 47 */   public static final EventEnum REMOVE_CUSTOMIZATIONMODIFIERS = new EventEnum("remove CustomizationModifiers");
/* 48 */   public static final EventEnum SET_CUSTOMIZATIONMODIFIERS = new EventEnum("set CustomizationModifiers");
/* 49 */   public static final EventEnum ADD_FEES = new EventEnum("add Fees");
/* 50 */   public static final EventEnum REMOVE_FEES = new EventEnum("remove Fees");
/* 51 */   public static final EventEnum SET_FEES = new EventEnum("set Fees");
/* 52 */   public static final EventEnum SET_ITEM = new EventEnum("set Item");
/* 53 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 54 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 55 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 56 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 57 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 58 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getOrderId();
/*    */   
/*    */   void setOrderId(String paramString);
/*    */   
/*    */   int getSequence();
/*    */   
/*    */   void setSequence(int paramInt);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   String getExternalOrderId();
/*    */   
/*    */   void setExternalOrderId(String paramString);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getFulfillmentType();
/*    */   
/*    */   void setFulfillmentType(String paramString);
/*    */   
/*    */   String getStatusCode();
/*    */   
/*    */   void setStatusCode(String paramString);
/*    */   
/*    */   BigDecimal getUnitPrice();
/*    */   
/*    */   void setUnitPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getExtendedPrice();
/*    */   
/*    */   void setExtendedPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxAmount();
/*    */   
/*    */   void setTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getNotes();
/*    */   
/*    */   void setNotes(String paramString);
/*    */   
/*    */   String getSelectedShipMethod();
/*    */   
/*    */   void setSelectedShipMethod(String paramString);
/*    */   
/*    */   String getActualShipMethod();
/*    */   
/*    */   void setActualShipMethod(String paramString);
/*    */   
/*    */   String getTrackingNumber();
/*    */   
/*    */   void setTrackingNumber(String paramString);
/*    */   
/*    */   boolean getDropShip();
/*    */   
/*    */   void setDropShip(boolean paramBoolean);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   String getStatusCodeReason();
/*    */   
/*    */   void setStatusCodeReason(String paramString);
/*    */   
/*    */   int getLineNumber();
/*    */   
/*    */   void setLineNumber(int paramInt);
/*    */   
/*    */   String getStatusCodeReasonNote();
/*    */   
/*    */   void setStatusCodeReasonNote(String paramString);
/*    */   
/*    */   String getItemUpcCode();
/*    */   
/*    */   void setItemUpcCode(String paramString);
/*    */   
/*    */   String getItemEanCode();
/*    */   
/*    */   void setItemEanCode(String paramString);
/*    */   
/*    */   BigDecimal getExtendedFreight();
/*    */   
/*    */   void setExtendedFreight(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getCustomizationCharge();
/*    */   
/*    */   void setCustomizationCharge(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getGiftWrap();
/*    */   
/*    */   void setGiftWrap(boolean paramBoolean);
/*    */   
/*    */   boolean getShipAlone();
/*    */   
/*    */   void setShipAlone(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getShipWeight();
/*    */   
/*    */   void setShipWeight(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getLineMessage();
/*    */   
/*    */   void setLineMessage(String paramString);
/*    */   
/*    */   IDataModel getOrderLineExt();
/*    */   
/*    */   void setOrderLineExt(IDataModel paramIDataModel);
/*    */   
/*    */   ISourceModifier getSourceModifier();
/*    */   
/*    */   void setSourceModifier(ISourceModifier paramISourceModifier);
/*    */   
/*    */   IFulfillmentModifier getFulfillmentModifier();
/*    */   
/*    */   void setFulfillmentModifier(IFulfillmentModifier paramIFulfillmentModifier);
/*    */   
/*    */   List<IBalanceModifier> getBalanceModifiers();
/*    */   
/*    */   void setBalanceModifiers(List<IBalanceModifier> paramList);
/*    */   
/*    */   void addBalanceModifier(IBalanceModifier paramIBalanceModifier);
/*    */   
/*    */   void removeBalanceModifier(IBalanceModifier paramIBalanceModifier);
/*    */   
/*    */   List<ICustomizationModifier> getCustomizationModifiers();
/*    */   
/*    */   void setCustomizationModifiers(List<ICustomizationModifier> paramList);
/*    */   
/*    */   void addCustomizationModifier(ICustomizationModifier paramICustomizationModifier);
/*    */   
/*    */   void removeCustomizationModifier(ICustomizationModifier paramICustomizationModifier);
/*    */   
/*    */   List<IFeeModifier> getFees();
/*    */   
/*    */   void setFees(List<IFeeModifier> paramList);
/*    */   
/*    */   void addFeeModifier(IFeeModifier paramIFeeModifier);
/*    */   
/*    */   void removeFeeModifier(IFeeModifier paramIFeeModifier);
/*    */   
/*    */   IItemModifier getItem();
/*    */   
/*    */   void setItem(IItemModifier paramIItemModifier);
/*    */   
/*    */   List<IOrderLineProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IOrderLineProperty> paramList);
/*    */   
/*    */   void addOrderLineProperty(IOrderLineProperty paramIOrderLineProperty);
/*    */   
/*    */   void removeOrderLineProperty(IOrderLineProperty paramIOrderLineProperty);
/*    */   
/*    */   void setParentOrder(IOrder paramIOrder);
/*    */   
/*    */   IOrder getParentOrder();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IOrderLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */