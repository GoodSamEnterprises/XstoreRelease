/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEmployeeTask extends IDataModel, IHasDataProperty<IEmployeeTaskProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_TASKID = new EventEnum("set taskId");
/* 12 */   public static final EventEnum SET_STARTDATE = new EventEnum("set startDate");
/* 13 */   public static final EventEnum SET_ENDDATE = new EventEnum("set endDate");
/* 14 */   public static final EventEnum SET_COMPLETEDATE = new EventEnum("set completeDate");
/* 15 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 16 */   public static final EventEnum SET_VISIBILITY = new EventEnum("set visibility");
/* 17 */   public static final EventEnum SET_ASSIGNMENTID = new EventEnum("set assignmentId");
/* 18 */   public static final EventEnum SET_STORECREATED = new EventEnum("set storeCreated");
/* 19 */   public static final EventEnum SET_TITLE = new EventEnum("set title");
/* 20 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 21 */   public static final EventEnum SET_PRIORITY = new EventEnum("set priority");
/* 22 */   public static final EventEnum SET_STATUSCODE = new EventEnum("set statusCode");
/* 23 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 24 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 25 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 26 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 27 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 28 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 29 */   public static final EventEnum SET_CUSTOMERPARTY = new EventEnum("set CustomerParty");
/* 30 */   public static final EventEnum ADD_EMPLOYEETASKNOTES = new EventEnum("add EmployeeTaskNotes");
/* 31 */   public static final EventEnum REMOVE_EMPLOYEETASKNOTES = new EventEnum("remove EmployeeTaskNotes");
/* 32 */   public static final EventEnum SET_EMPLOYEETASKNOTES = new EventEnum("set EmployeeTaskNotes");
/* 33 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 34 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 35 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 36 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 37 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 38 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getTaskId();
/*    */   
/*    */   void setTaskId(long paramLong);
/*    */   
/*    */   Date getStartDate();
/*    */   
/*    */   void setStartDate(Date paramDate);
/*    */   
/*    */   Date getEndDate();
/*    */   
/*    */   void setEndDate(Date paramDate);
/*    */   
/*    */   Date getCompleteDate();
/*    */   
/*    */   void setCompleteDate(Date paramDate);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   String getVisibility();
/*    */   
/*    */   void setVisibility(String paramString);
/*    */   
/*    */   String getAssignmentId();
/*    */   
/*    */   void setAssignmentId(String paramString);
/*    */   
/*    */   boolean getStoreCreated();
/*    */   
/*    */   void setStoreCreated(boolean paramBoolean);
/*    */   
/*    */   String getTitle();
/*    */   
/*    */   void setTitle(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getPriority();
/*    */   
/*    */   void setPriority(String paramString);
/*    */   
/*    */   String getStatusCode();
/*    */   
/*    */   void setStatusCode(String paramString);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
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
/*    */   IDataModel getEmployeeTaskExt();
/*    */   
/*    */   void setEmployeeTaskExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getCustomerParty();
/*    */   
/*    */   void setCustomerParty(IParty paramIParty);
/*    */   
/*    */   List<IEmployeeTaskNote> getEmployeeTaskNotes();
/*    */   
/*    */   void setEmployeeTaskNotes(List<IEmployeeTaskNote> paramList);
/*    */   
/*    */   void addEmployeeTaskNote(IEmployeeTaskNote paramIEmployeeTaskNote);
/*    */   
/*    */   void removeEmployeeTaskNote(IEmployeeTaskNote paramIEmployeeTaskNote);
/*    */   
/*    */   List<IEmployeeTaskProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEmployeeTaskProperty> paramList);
/*    */   
/*    */   void addEmployeeTaskProperty(IEmployeeTaskProperty paramIEmployeeTaskProperty);
/*    */   
/*    */   void removeEmployeeTaskProperty(IEmployeeTaskProperty paramIEmployeeTaskProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeeTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */