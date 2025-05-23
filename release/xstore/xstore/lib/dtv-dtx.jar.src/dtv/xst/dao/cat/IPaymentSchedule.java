/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPaymentSchedule extends IDataModel, IHasDataProperty<IPaymentScheduleProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_BEGINDATE = new EventEnum("set beginDate");
/* 17 */   public static final EventEnum SET_INTERVALTYPEENUM = new EventEnum("set intervalTypeEnum");
/* 18 */   public static final EventEnum SET_INTERVALCOUNT = new EventEnum("set intervalCount");
/* 19 */   public static final EventEnum SET_TOTALPAYMENTAMOUNT = new EventEnum("set totalPaymentAmount");
/* 20 */   public static final EventEnum SET_PAYMENTCOUNT = new EventEnum("set paymentCount");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getBeginDate();
/*    */   
/*    */   void setBeginDate(Date paramDate);
/*    */   
/*    */   String getIntervalTypeEnum();
/*    */   
/*    */   void setIntervalTypeEnum(String paramString);
/*    */   
/*    */   int getIntervalCount();
/*    */   
/*    */   void setIntervalCount(int paramInt);
/*    */   
/*    */   BigDecimal getTotalPaymentAmount();
/*    */   
/*    */   void setTotalPaymentAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   int getPaymentCount();
/*    */   
/*    */   void setPaymentCount(int paramInt);
/*    */   
/*    */   IDataModel getPaymentScheduleExt();
/*    */   
/*    */   void setPaymentScheduleExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPaymentScheduleProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPaymentScheduleProperty> paramList);
/*    */   
/*    */   void addPaymentScheduleProperty(IPaymentScheduleProperty paramIPaymentScheduleProperty);
/*    */   
/*    */   void removePaymentScheduleProperty(IPaymentScheduleProperty paramIPaymentScheduleProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IPaymentSchedule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */