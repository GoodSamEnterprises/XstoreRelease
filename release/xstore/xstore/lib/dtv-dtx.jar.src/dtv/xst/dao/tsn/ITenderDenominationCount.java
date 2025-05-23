/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.tnd.ITenderDenomination;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ITenderDenominationCount extends IDataModel, IHasDataProperty<ITenderDenominationCountProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDAYDATE = new EventEnum("set businessDayDate");
/* 10 */   public static final EventEnum SET_DENOMINATIONID = new EventEnum("set denominationId");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 13 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 14 */   public static final EventEnum SET_TENDERTYPECODE = new EventEnum("set tenderTypeCode");
/* 15 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 16 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 17 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 18 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 19 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 20 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 21 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 22 */   public static final EventEnum SET_DIFFERENCEAMOUNT = new EventEnum("set differenceAmount");
/* 23 */   public static final EventEnum SET_DIFFERENCEMEDIACOUNT = new EventEnum("set differenceMediaCount");
/* 24 */   public static final EventEnum SET_MEDIACOUNT = new EventEnum("set mediaCount");
/* 25 */   public static final EventEnum SET_TENDERDENOMINATION = new EventEnum("set TenderDenomination");
/* 26 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 27 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 28 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDayDate();
/*    */   
/*    */   void setBusinessDayDate(Date paramDate);
/*    */   
/*    */   String getDenominationId();
/*    */   
/*    */   void setDenominationId(String paramString);
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
/*    */   IDataModel getTenderDenominationCountExt();
/*    */   
/*    */   void setTenderDenominationCountExt(IDataModel paramIDataModel);
/*    */   
/*    */   ITenderDenomination getTenderDenomination();
/*    */   
/*    */   void setTenderDenomination(ITenderDenomination paramITenderDenomination);
/*    */   
/*    */   List<ITenderDenominationCountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderDenominationCountProperty> paramList);
/*    */   
/*    */   void addTenderDenominationCountProperty(ITenderDenominationCountProperty paramITenderDenominationCountProperty);
/*    */   
/*    */   void removeTenderDenominationCountProperty(ITenderDenominationCountProperty paramITenderDenominationCountProperty);
/*    */   
/*    */   void setParentTenderCount(ITenderCount paramITenderCount);
/*    */   
/*    */   ITenderCount getParentTenderCount();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITenderDenominationCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */