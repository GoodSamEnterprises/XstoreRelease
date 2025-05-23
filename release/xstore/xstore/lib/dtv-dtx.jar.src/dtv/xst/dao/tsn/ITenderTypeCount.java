/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderTypeCount extends IDataModel, ITenderTypeCountModel, IHasDataProperty<ITenderTypeCountProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDAYDATE = new EventEnum("set businessDayDate");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_TENDERTYPECODE = new EventEnum("set tenderTypeCode");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 20 */   public static final EventEnum SET_DIFFERENCEAMOUNT = new EventEnum("set differenceAmount");
/* 21 */   public static final EventEnum SET_DIFFERENCEMEDIACOUNT = new EventEnum("set differenceMediaCount");
/* 22 */   public static final EventEnum SET_MEDIACOUNT = new EventEnum("set mediaCount");
/* 23 */   public static final EventEnum ADD_TENDERCOUNTS = new EventEnum("add TenderCounts");
/* 24 */   public static final EventEnum REMOVE_TENDERCOUNTS = new EventEnum("remove TenderCounts");
/* 25 */   public static final EventEnum SET_TENDERCOUNTS = new EventEnum("set TenderCounts");
/* 26 */   public static final EventEnum ADD_TENDERSERIALIZEDCOUNTS = new EventEnum("add TenderSerializedCounts");
/* 27 */   public static final EventEnum REMOVE_TENDERSERIALIZEDCOUNTS = new EventEnum("remove TenderSerializedCounts");
/* 28 */   public static final EventEnum SET_TENDERSERIALIZEDCOUNTS = new EventEnum("set TenderSerializedCounts");
/* 29 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 30 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 31 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 32 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 33 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 34 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDayDate();
/*    */   
/*    */   void setBusinessDayDate(Date paramDate);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getTenderTypeCode();
/*    */   
/*    */   void setTenderTypeCode(String paramString);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getDifferenceAmount();
/*    */   
/*    */   void setDifferenceAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   int getDifferenceMediaCount();
/*    */   
/*    */   void setDifferenceMediaCount(int paramInt);
/*    */   
/*    */   int getMediaCount();
/*    */   
/*    */   void setMediaCount(int paramInt);
/*    */   
/*    */   IDataModel getTenderTypeCountExt();
/*    */   
/*    */   void setTenderTypeCountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderCount> getTenderCounts();
/*    */   
/*    */   void setTenderCounts(List<ITenderCount> paramList);
/*    */   
/*    */   void addTenderCount(ITenderCount paramITenderCount);
/*    */   
/*    */   void removeTenderCount(ITenderCount paramITenderCount);
/*    */   
/*    */   List<ITenderSerializedCount> getTenderSerializedCounts();
/*    */   
/*    */   void setTenderSerializedCounts(List<ITenderSerializedCount> paramList);
/*    */   
/*    */   void addTenderSerializedCount(ITenderSerializedCount paramITenderSerializedCount);
/*    */   
/*    */   void removeTenderSerializedCount(ITenderSerializedCount paramITenderSerializedCount);
/*    */   
/*    */   List<ITenderTypeCountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderTypeCountProperty> paramList);
/*    */   
/*    */   void addTenderTypeCountProperty(ITenderTypeCountProperty paramITenderTypeCountProperty);
/*    */   
/*    */   void removeTenderTypeCountProperty(ITenderTypeCountProperty paramITenderTypeCountProperty);
/*    */   
/*    */   void setParentTenderControlTransaction(ITenderControlTransaction paramITenderControlTransaction);
/*    */   
/*    */   ITenderControlTransaction getParentTenderControlTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITenderTypeCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */