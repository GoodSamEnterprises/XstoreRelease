/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ISession extends IDataModel, IHasDataProperty<ISessionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_SESSIONID = new EventEnum("set sessionId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_BEGINDATETIMESTAMP = new EventEnum("set beginDatetimestamp");
/* 17 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 18 */   public static final EventEnum SET_ENDDATETIMESTAMP = new EventEnum("set endDatetimestamp");
/* 19 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 20 */   public static final EventEnum SET_EMPLOYEEPARTYID = new EventEnum("set employeePartyId");
/* 21 */   public static final EventEnum SET_TENDERREPOSITORYID = new EventEnum("set tenderRepositoryId");
/* 22 */   public static final EventEnum SET_CASHDRAWERID = new EventEnum("set cashDrawerId");
/* 23 */   public static final EventEnum SET_PARTY = new EventEnum("set Party");
/* 24 */   public static final EventEnum SET_TENDERREPOSITORY = new EventEnum("set TenderRepository");
/* 25 */   public static final EventEnum ADD_SESSIONTENDERS = new EventEnum("add SessionTenders");
/* 26 */   public static final EventEnum REMOVE_SESSIONTENDERS = new EventEnum("remove SessionTenders");
/* 27 */   public static final EventEnum SET_SESSIONTENDERS = new EventEnum("set SessionTenders");
/* 28 */   public static final EventEnum ADD_SESSIONWORKSTATIONS = new EventEnum("add SessionWorkstations");
/* 29 */   public static final EventEnum REMOVE_SESSIONWORKSTATIONS = new EventEnum("remove SessionWorkstations");
/* 30 */   public static final EventEnum SET_SESSIONWORKSTATIONS = new EventEnum("set SessionWorkstations");
/* 31 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 32 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 33 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 34 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 35 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 36 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   Date getEndDatetimestamp();
/*    */   
/*    */   void setEndDatetimestamp(Date paramDate);
/*    */   
/*    */   String getStatusCode();
/*    */   
/*    */   void setStatusCode(String paramString);
/*    */   
/*    */   long getEmployeePartyId();
/*    */   
/*    */   void setEmployeePartyId(long paramLong);
/*    */   
/*    */   String getTenderRepositoryId();
/*    */   
/*    */   void setTenderRepositoryId(String paramString);
/*    */   
/*    */   String getCashDrawerId();
/*    */   
/*    */   void setCashDrawerId(String paramString);
/*    */   
/*    */   IDataModel getSessionExt();
/*    */   
/*    */   void setSessionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getParty();
/*    */   
/*    */   void setParty(IParty paramIParty);
/*    */   
/*    */   ITenderRepository getTenderRepository();
/*    */   
/*    */   void setTenderRepository(ITenderRepository paramITenderRepository);
/*    */   
/*    */   List<ISessionTender> getSessionTenders();
/*    */   
/*    */   void setSessionTenders(List<ISessionTender> paramList);
/*    */   
/*    */   void addSessionTender(ISessionTender paramISessionTender);
/*    */   
/*    */   void removeSessionTender(ISessionTender paramISessionTender);
/*    */   
/*    */   List<ISessionWorkstation> getSessionWorkstations();
/*    */   
/*    */   void setSessionWorkstations(List<ISessionWorkstation> paramList);
/*    */   
/*    */   void addSessionWorkstation(ISessionWorkstation paramISessionWorkstation);
/*    */   
/*    */   void removeSessionWorkstation(ISessionWorkstation paramISessionWorkstation);
/*    */   
/*    */   List<ISessionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ISessionProperty> paramList);
/*    */   
/*    */   void addSessionProperty(ISessionProperty paramISessionProperty);
/*    */   
/*    */   void removeSessionProperty(ISessionProperty paramISessionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ISession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */