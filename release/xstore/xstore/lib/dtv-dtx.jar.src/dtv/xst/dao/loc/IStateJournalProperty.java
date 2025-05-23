/*    */ package dtv.xst.dao.loc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IStateJournalProperty extends IDataModel, IDataProperty {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_STATUSTYPCODE = new EventEnum("set statusTypcode");
/* 13 */   public static final EventEnum SET_STATEJOURNALID = new EventEnum("set stateJournalId");
/* 14 */   public static final EventEnum SET_PROPERTYCODE = new EventEnum("set propertyCode");
/* 15 */   public static final EventEnum SET_TYPE = new EventEnum("set type");
/* 16 */   public static final EventEnum SET_STRINGVALUE = new EventEnum("set stringValue");
/* 17 */   public static final EventEnum SET_DATEVALUE = new EventEnum("set dateValue");
/* 18 */   public static final EventEnum SET_DECIMALVALUE = new EventEnum("set decimalValue");
/* 19 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 20 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 21 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 22 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getPropertyCode();
/*    */   
/*    */   void setPropertyCode(String paramString);
/*    */   
/*    */   String getType();
/*    */   
/*    */   void setType(String paramString);
/*    */   
/*    */   String getStringValue();
/*    */   
/*    */   void setStringValue(String paramString);
/*    */   
/*    */   Date getDateValue();
/*    */   
/*    */   void setDateValue(Date paramDate);
/*    */   
/*    */   BigDecimal getDecimalValue();
/*    */   
/*    */   void setDecimalValue(BigDecimal paramBigDecimal);
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
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\IStateJournalProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */