/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventorySummaryCountTransactionDetail extends IDataModel, IHasDataProperty<IInventorySummaryCountTransactionDetailProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_TRANSLINESEQUENCE = new EventEnum("set transLineSequence");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_LOCATIONID = new EventEnum("set locationId");
/* 20 */   public static final EventEnum SET_BUCKETID = new EventEnum("set bucketId");
/* 21 */   public static final EventEnum SET_SYSTEMCOUNT = new EventEnum("set systemCount");
/* 22 */   public static final EventEnum SET_DECLAREDCOUNT = new EventEnum("set declaredCount");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
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
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   int getTransLineSequence();
/*    */   
/*    */   void setTransLineSequence(int paramInt);
/*    */   
/*    */   String getLocationId();
/*    */   
/*    */   void setLocationId(String paramString);
/*    */   
/*    */   String getBucketId();
/*    */   
/*    */   void setBucketId(String paramString);
/*    */   
/*    */   BigDecimal getSystemCount();
/*    */   
/*    */   void setSystemCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getDeclaredCount();
/*    */   
/*    */   void setDeclaredCount(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getInventorySummaryCountTransactionDetailExt();
/*    */   
/*    */   void setInventorySummaryCountTransactionDetailExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventorySummaryCountTransactionDetailProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventorySummaryCountTransactionDetailProperty> paramList);
/*    */   
/*    */   void addInventorySummaryCountTransactionDetailProperty(IInventorySummaryCountTransactionDetailProperty paramIInventorySummaryCountTransactionDetailProperty);
/*    */   
/*    */   void removeInventorySummaryCountTransactionDetailProperty(IInventorySummaryCountTransactionDetailProperty paramIInventorySummaryCountTransactionDetailProperty);
/*    */   
/*    */   void setParentTransaction(IInventorySummaryCountTransaction paramIInventorySummaryCountTransaction);
/*    */   
/*    */   IInventorySummaryCountTransaction getParentTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventorySummaryCountTransactionDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */