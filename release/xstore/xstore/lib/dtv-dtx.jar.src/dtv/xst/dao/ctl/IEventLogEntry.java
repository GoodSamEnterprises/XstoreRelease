/*    */ package dtv.xst.dao.ctl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IEventLogEntry extends IDataModel {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 14 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 17 */   public static final EventEnum SET_OPERATORPARTYID = new EventEnum("set operatorPartyId");
/* 18 */   public static final EventEnum SET_LOGLEVEL = new EventEnum("set logLevel");
/* 19 */   public static final EventEnum SET_LOGTIMESTAMP = new EventEnum("set logTimestamp");
/* 20 */   public static final EventEnum SET_SOURCE = new EventEnum("set source");
/* 21 */   public static final EventEnum SET_THREADNAME = new EventEnum("set threadName");
/* 22 */   public static final EventEnum SET_CRITICALTODELIVER = new EventEnum("set criticalToDeliver");
/* 23 */   public static final EventEnum SET_LOGGERCATEGORY = new EventEnum("set loggerCategory");
/* 24 */   public static final EventEnum SET_LOGMESSAGE = new EventEnum("set logMessage");
/* 25 */   public static final EventEnum SET_ARRIVALTIMESTAMP = new EventEnum("set arrivalTimestamp");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   long getOperatorPartyId();
/*    */   
/*    */   void setOperatorPartyId(long paramLong);
/*    */   
/*    */   String getLogLevel();
/*    */   
/*    */   void setLogLevel(String paramString);
/*    */   
/*    */   Date getLogTimestamp();
/*    */   
/*    */   void setLogTimestamp(Date paramDate);
/*    */   
/*    */   String getSource();
/*    */   
/*    */   void setSource(String paramString);
/*    */   
/*    */   String getThreadName();
/*    */   
/*    */   void setThreadName(String paramString);
/*    */   
/*    */   boolean getCriticalToDeliver();
/*    */   
/*    */   void setCriticalToDeliver(boolean paramBoolean);
/*    */   
/*    */   String getLoggerCategory();
/*    */   
/*    */   void setLoggerCategory(String paramString);
/*    */   
/*    */   String getLogMessage();
/*    */   
/*    */   void setLogMessage(String paramString);
/*    */   
/*    */   Date getArrivalTimestamp();
/*    */   
/*    */   void setArrivalTimestamp(Date paramDate);
/*    */   
/*    */   IDataModel getEventLogEntryExt();
/*    */   
/*    */   void setEventLogEntryExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\IEventLogEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */