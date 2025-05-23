/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITenderCount extends IDataModel, IHasDataProperty<ITenderCountProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDAYDATE = new EventEnum("set businessDayDate");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 13 */   public static final EventEnum SET_TENDERTYPECODE = new EventEnum("set tenderTypeCode");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 21 */   public static final EventEnum SET_DIFFERENCEAMOUNT = new EventEnum("set differenceAmount");
/* 22 */   public static final EventEnum SET_DIFFERENCEMEDIACOUNT = new EventEnum("set differenceMediaCount");
/* 23 */   public static final EventEnum SET_MEDIACOUNT = new EventEnum("set mediaCount");
/* 24 */   public static final EventEnum SET_DEPOSITAMOUNT = new EventEnum("set depositAmount");
/* 25 */   public static final EventEnum SET_LOCALCURRENCYAMOUNT = new EventEnum("set localCurrencyAmount");
/* 26 */   public static final EventEnum ADD_TENDERDENOMINATIONCOUNTS = new EventEnum("add TenderDenominationCounts");
/* 27 */   public static final EventEnum REMOVE_TENDERDENOMINATIONCOUNTS = new EventEnum("remove TenderDenominationCounts");
/* 28 */   public static final EventEnum SET_TENDERDENOMINATIONCOUNTS = new EventEnum("set TenderDenominationCounts");
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
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
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
/*    */   BigDecimal getDepositAmount();
/*    */   
/*    */   void setDepositAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getLocalCurrencyAmount();
/*    */   
/*    */   void setLocalCurrencyAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getTenderCountExt();
/*    */   
/*    */   void setTenderCountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITenderDenominationCount> getTenderDenominationCounts();
/*    */   
/*    */   void setTenderDenominationCounts(List<ITenderDenominationCount> paramList);
/*    */   
/*    */   void addTenderDenominationCount(ITenderDenominationCount paramITenderDenominationCount);
/*    */   
/*    */   void removeTenderDenominationCount(ITenderDenominationCount paramITenderDenominationCount);
/*    */   
/*    */   List<ITenderCountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderCountProperty> paramList);
/*    */   
/*    */   void addTenderCountProperty(ITenderCountProperty paramITenderCountProperty);
/*    */   
/*    */   void removeTenderCountProperty(ITenderCountProperty paramITenderCountProperty);
/*    */   
/*    */   void setParentTenderTypeCount(ITenderTypeCount paramITenderTypeCount);
/*    */   
/*    */   ITenderTypeCount getParentTenderTypeCount();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITenderCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */