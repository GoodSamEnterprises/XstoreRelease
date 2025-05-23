/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerItemAccountActivity extends IDataModel, ICustomerItemAccountActivityModel, IHasDataProperty<ICustomerItemAccountActivityProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_CUSTACCOUNTDETAILNUM = new EventEnum("set custAccountDetailNum");
/* 13 */   public static final EventEnum SET_SEQUENCENUMBER = new EventEnum("set sequenceNumber");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_EXTENDEDAMOUNT = new EventEnum("set extendedAmount");
/* 19 */   public static final EventEnum SET_ACTIVITYDATETIME = new EventEnum("set activityDateTime");
/* 20 */   public static final EventEnum SET_ACTIVITYCODE = new EventEnum("set activityCode");
/* 21 */   public static final EventEnum SET_ACCOUNTLINEITEMSTATECODE = new EventEnum("set accountLineItemStateCode");
/* 22 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 23 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 24 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 25 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 26 */   public static final EventEnum SET_TRANSSEQUENCE = new EventEnum("set transSequence");
/* 27 */   public static final EventEnum SET_TRANSLINEITEMSEQ = new EventEnum("set transLineItemSeq");
/* 28 */   public static final EventEnum SET_NETAMOUNT = new EventEnum("set netAmount");
/* 29 */   public static final EventEnum SET_UNITPRICE = new EventEnum("set unitPrice");
/* 30 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 31 */   public static final EventEnum SET_SCHEDULEDPICKUPDATE = new EventEnum("set scheduledPickupDate");
/* 32 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 33 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 34 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 35 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 36 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 37 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getSequenceNumber();
/*    */   
/*    */   void setSequenceNumber(long paramLong);
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
/*    */   Date getActivityDateTime();
/*    */   
/*    */   void setActivityDateTime(Date paramDate);
/*    */   
/*    */   String getActivityCode();
/*    */   
/*    */   void setActivityCode(String paramString);
/*    */   
/*    */   String getAccountLineItemStateCode();
/*    */   
/*    */   void setAccountLineItemStateCode(String paramString);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransSequence();
/*    */   
/*    */   void setTransSequence(long paramLong);
/*    */   
/*    */   long getTransLineItemSeq();
/*    */   
/*    */   void setTransLineItemSeq(long paramLong);
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
/*    */   Date getScheduledPickupDate();
/*    */   
/*    */   void setScheduledPickupDate(Date paramDate);
/*    */   
/*    */   IDataModel getCustomerItemAccountActivityExt();
/*    */   
/*    */   void setCustomerItemAccountActivityExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerItemAccountActivityProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerItemAccountActivityProperty> paramList);
/*    */   
/*    */   void addCustomerItemAccountActivityProperty(ICustomerItemAccountActivityProperty paramICustomerItemAccountActivityProperty);
/*    */   
/*    */   void removeCustomerItemAccountActivityProperty(ICustomerItemAccountActivityProperty paramICustomerItemAccountActivityProperty);
/*    */   
/*    */   void setParentCustItemAccountDetail(ICustomerItemAccountDetail paramICustomerItemAccountDetail);
/*    */   
/*    */   ICustomerItemAccountDetail getParentCustItemAccountDetail();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerItemAccountActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */