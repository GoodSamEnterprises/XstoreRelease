/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.tnd.ITender;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ITenderSerializedCount extends IDataModel, IHasDataProperty<ITenderSerializedCountProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDAYDATE = new EventEnum("set businessDayDate");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_SERIALIZEDCOUNTSEQUENCE = new EventEnum("set serializedCountSequence");
/* 13 */   public static final EventEnum SET_TENDERTYPECODE = new EventEnum("set tenderTypeCode");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 21 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 22 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 23 */   public static final EventEnum SET_TENDER = new EventEnum("set Tender");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   int getSerializedCountSequence();
/*    */   
/*    */   void setSerializedCountSequence(int paramInt);
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
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
/*    */   
/*    */   IDataModel getTenderSerializedCountExt();
/*    */   
/*    */   void setTenderSerializedCountExt(IDataModel paramIDataModel);
/*    */   
/*    */   ITender getTender();
/*    */   
/*    */   void setTender(ITender paramITender);
/*    */   
/*    */   List<ITenderSerializedCountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITenderSerializedCountProperty> paramList);
/*    */   
/*    */   void addTenderSerializedCountProperty(ITenderSerializedCountProperty paramITenderSerializedCountProperty);
/*    */   
/*    */   void removeTenderSerializedCountProperty(ITenderSerializedCountProperty paramITenderSerializedCountProperty);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITenderSerializedCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */