/*    */ package dtv.xst.dao.loc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IStateJournal extends IDataModel, IHasDataProperty<IStateJournalProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_STATUSTYPCODE = new EventEnum("set statusTypcode");
/* 13 */   public static final EventEnum SET_STATEJOURNALID = new EventEnum("set stateJournalId");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_DATEVALUE = new EventEnum("set dateValue");
/* 19 */   public static final EventEnum SET_STRINGVALUE = new EventEnum("set stringValue");
/* 20 */   public static final EventEnum SET_DECIMALVALUE = new EventEnum("set decimalValue");
/* 21 */   public static final EventEnum SET_TIMESTAMP = new EventEnum("set timeStamp");
/* 22 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 23 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 24 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 25 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 26 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 27 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getStatusTypcode();
/*    */   
/*    */   void setStatusTypcode(String paramString);
/*    */   
/*    */   String getStateJournalId();
/*    */   
/*    */   void setStateJournalId(String paramString);
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
/*    */   Date getDateValue();
/*    */   
/*    */   void setDateValue(Date paramDate);
/*    */   
/*    */   String getStringValue();
/*    */   
/*    */   void setStringValue(String paramString);
/*    */   
/*    */   BigDecimal getDecimalValue();
/*    */   
/*    */   void setDecimalValue(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getTimeStamp();
/*    */   
/*    */   void setTimeStamp(Date paramDate);
/*    */   
/*    */   IDataModel getStateJournalExt();
/*    */   
/*    */   void setStateJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IStateJournalProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IStateJournalProperty> paramList);
/*    */   
/*    */   void addStateJournalProperty(IStateJournalProperty paramIStateJournalProperty);
/*    */   
/*    */   void removeStateJournalProperty(IStateJournalProperty paramIStateJournalProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\IStateJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */