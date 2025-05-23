/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.loc.IRetailLocation;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerItemAccountDetail extends IDataModel, ICustomerItemAccountDetailModel, IHasDataProperty<ICustomerItemAccountDetailProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_CUSTACCOUNTDETAILNUM = new EventEnum("set custAccountDetailNum");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_EXTENDEDAMOUNT = new EventEnum("set extendedAmount");
/* 18 */   public static final EventEnum SET_STATECODE = new EventEnum("set stateCode");
/* 19 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 20 */   public static final EventEnum SET_ORIGITEMADDDATE = new EventEnum("set origItemAddDate");
/* 21 */   public static final EventEnum SET_SCHEDULEDPICKUPDATE = new EventEnum("set scheduledPickupDate");
/* 22 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 23 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 24 */   public static final EventEnum SET_SOURCELOCATIONID = new EventEnum("set sourceLocationId");
/* 25 */   public static final EventEnum SET_DELIVERYTYPE = new EventEnum("set deliveryType");
/* 26 */   public static final EventEnum SET_FULLFILLMENTLOCATIONID = new EventEnum("set fullfillmentLocationId");
/* 27 */   public static final EventEnum SET_RECEIVEDBYCUSTDATE = new EventEnum("set receivedByCustDate");
/* 28 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 29 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 30 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 31 */   public static final EventEnum SET_NETAMOUNT = new EventEnum("set netAmount");
/* 32 */   public static final EventEnum SET_UNITPRICE = new EventEnum("set unitPrice");
/* 33 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 34 */   public static final EventEnum SET_RETAILLINEITEM = new EventEnum("set RetailLineItem");
/* 35 */   public static final EventEnum ADD_CUSTITEMACCOUNTACTIVITIES = new EventEnum("add CustItemAccountActivities");
/* 36 */   public static final EventEnum REMOVE_CUSTITEMACCOUNTACTIVITIES = new EventEnum("remove CustItemAccountActivities");
/* 37 */   public static final EventEnum SET_CUSTITEMACCOUNTACTIVITIES = new EventEnum("set CustItemAccountActivities");
/* 38 */   public static final EventEnum SET_SOURCELOCATION = new EventEnum("set SourceLocation");
/* 39 */   public static final EventEnum SET_FULLFILLMENTLOCATION = new EventEnum("set FullfillmentLocation");
/* 40 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 41 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 42 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 43 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 44 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 45 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
/*    */   
/*    */   long getCustAccountDetailNum();
/*    */   
/*    */   void setCustAccountDetailNum(long paramLong);
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
/*    */   BigDecimal getExtendedAmount();
/*    */   
/*    */   void setExtendedAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getStateCode();
/*    */   
/*    */   void setStateCode(String paramString);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   Date getOrigItemAddDate();
/*    */   
/*    */   void setOrigItemAddDate(Date paramDate);
/*    */   
/*    */   Date getScheduledPickupDate();
/*    */   
/*    */   void setScheduledPickupDate(Date paramDate);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getSourceLocationId();
/*    */   
/*    */   void setSourceLocationId(long paramLong);
/*    */   
/*    */   String getDeliveryType();
/*    */   
/*    */   void setDeliveryType(String paramString);
/*    */   
/*    */   long getFullfillmentLocationId();
/*    */   
/*    */   void setFullfillmentLocationId(long paramLong);
/*    */   
/*    */   Date getReceivedByCustDate();
/*    */   
/*    */   void setReceivedByCustDate(Date paramDate);
/*    */   
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   BigDecimal getNetAmount();
/*    */   
/*    */   void setNetAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getUnitPrice();
/*    */   
/*    */   void setUnitPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getCustomerItemAccountDetailExt();
/*    */   
/*    */   void setCustomerItemAccountDetailExt(IDataModel paramIDataModel);
/*    */   
/*    */   IRetailTransactionLineItem getRetailLineItem();
/*    */   
/*    */   void setRetailLineItem(IRetailTransactionLineItem paramIRetailTransactionLineItem);
/*    */   
/*    */   List<ICustomerItemAccountActivity> getCustItemAccountActivities();
/*    */   
/*    */   void setCustItemAccountActivities(List<ICustomerItemAccountActivity> paramList);
/*    */   
/*    */   void addCustomerItemAccountActivity(ICustomerItemAccountActivity paramICustomerItemAccountActivity);
/*    */   
/*    */   void removeCustomerItemAccountActivity(ICustomerItemAccountActivity paramICustomerItemAccountActivity);
/*    */   
/*    */   IRetailLocation getSourceLocation();
/*    */   
/*    */   void setSourceLocation(IRetailLocation paramIRetailLocation);
/*    */   
/*    */   IRetailLocation getFullfillmentLocation();
/*    */   
/*    */   void setFullfillmentLocation(IRetailLocation paramIRetailLocation);
/*    */   
/*    */   List<ICustomerItemAccountDetailProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerItemAccountDetailProperty> paramList);
/*    */   
/*    */   void addCustomerItemAccountDetailProperty(ICustomerItemAccountDetailProperty paramICustomerItemAccountDetailProperty);
/*    */   
/*    */   void removeCustomerItemAccountDetailProperty(ICustomerItemAccountDetailProperty paramICustomerItemAccountDetailProperty);
/*    */   
/*    */   void setParentCustItemAccount(ICustomerItemAccount paramICustomerItemAccount);
/*    */   
/*    */   ICustomerItemAccount getParentCustItemAccount();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerItemAccountDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */