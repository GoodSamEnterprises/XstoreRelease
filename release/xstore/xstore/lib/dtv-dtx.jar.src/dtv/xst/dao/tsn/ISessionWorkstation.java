/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ISessionWorkstation extends IDataModel, IHasDataProperty<ISessionWorkstationProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_SESSIONID = new EventEnum("set sessionId");
/* 12 */   public static final EventEnum SET_SESSIONWORKSTATIONSEQUENCENBR = new EventEnum("set sessionWorkstationSequenceNbr");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_BEGINDATETIMESTAMP = new EventEnum("set beginDatetimestamp");
/* 18 */   public static final EventEnum SET_CASHDRAWERID = new EventEnum("set cashDrawerId");
/* 19 */   public static final EventEnum SET_ENDDATETIMESTAMP = new EventEnum("set endDatetimestamp");
/* 20 */   public static final EventEnum SET_ATTACHED = new EventEnum("set attached");
/* 21 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
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
/*    */   long getSessionId();
/*    */   
/*    */   void setSessionId(long paramLong);
/*    */   
/*    */   int getSessionWorkstationSequenceNbr();
/*    */   
/*    */   void setSessionWorkstationSequenceNbr(int paramInt);
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
/*    */   Date getBeginDatetimestamp();
/*    */   
/*    */   void setBeginDatetimestamp(Date paramDate);
/*    */   
/*    */   String getCashDrawerId();
/*    */   
/*    */   void setCashDrawerId(String paramString);
/*    */   
/*    */   Date getEndDatetimestamp();
/*    */   
/*    */   void setEndDatetimestamp(Date paramDate);
/*    */   
/*    */   boolean getAttached();
/*    */   
/*    */   void setAttached(boolean paramBoolean);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   IDataModel getSessionWorkstationExt();
/*    */   
/*    */   void setSessionWorkstationExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ISessionWorkstationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ISessionWorkstationProperty> paramList);
/*    */   
/*    */   void addSessionWorkstationProperty(ISessionWorkstationProperty paramISessionWorkstationProperty);
/*    */   
/*    */   void removeSessionWorkstationProperty(ISessionWorkstationProperty paramISessionWorkstationProperty);
/*    */   
/*    */   void setParentSession(ISession paramISession);
/*    */   
/*    */   ISession getParentSession();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ISessionWorkstation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */