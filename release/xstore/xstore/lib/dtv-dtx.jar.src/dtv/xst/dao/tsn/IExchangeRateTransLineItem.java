/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IExchangeRateTransLineItem extends IDataModel, IExchangeRateTransLineItemModel, IHasDataProperty<IExchangeRateTransLineItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_LINEITEMSEQUENCE = new EventEnum("set lineItemSequence");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_BASECURRENCY = new EventEnum("set baseCurrency");
/* 20 */   public static final EventEnum SET_TARGETCURRENCY = new EventEnum("set targetCurrency");
/* 21 */   public static final EventEnum SET_OLDEXCHANGERATE = new EventEnum("set oldExchangeRate");
/* 22 */   public static final EventEnum SET_NEWEXCHANGERATE = new EventEnum("set newExchangeRate");
/* 23 */   public static final EventEnum SET_NOTES = new EventEnum("set notes");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   int getLineItemSequence();
/*    */   
/*    */   void setLineItemSequence(int paramInt);
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
/*    */   String getBaseCurrency();
/*    */   
/*    */   void setBaseCurrency(String paramString);
/*    */   
/*    */   String getTargetCurrency();
/*    */   
/*    */   void setTargetCurrency(String paramString);
/*    */   
/*    */   BigDecimal getOldExchangeRate();
/*    */   
/*    */   void setOldExchangeRate(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getNewExchangeRate();
/*    */   
/*    */   void setNewExchangeRate(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getNotes();
/*    */   
/*    */   void setNotes(String paramString);
/*    */   
/*    */   IDataModel getExchangeRateTransLineItemExt();
/*    */   
/*    */   void setExchangeRateTransLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IExchangeRateTransLineItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IExchangeRateTransLineItemProperty> paramList);
/*    */   
/*    */   void addExchangeRateTransLineItemProperty(IExchangeRateTransLineItemProperty paramIExchangeRateTransLineItemProperty);
/*    */   
/*    */   void removeExchangeRateTransLineItemProperty(IExchangeRateTransLineItemProperty paramIExchangeRateTransLineItemProperty);
/*    */   
/*    */   void setParentTransaction(IExchangeRateTransaction paramIExchangeRateTransaction);
/*    */   
/*    */   IExchangeRateTransaction getParentTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\IExchangeRateTransLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */