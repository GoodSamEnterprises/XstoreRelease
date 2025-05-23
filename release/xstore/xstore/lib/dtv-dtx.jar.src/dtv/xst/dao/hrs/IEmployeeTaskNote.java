/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEmployeeTaskNote extends IDataModel, IHasDataProperty<IEmployeeTaskNoteProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_TASKID = new EventEnum("set taskId");
/* 12 */   public static final EventEnum SET_NOTESEQUENCE = new EventEnum("set noteSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_NOTE = new EventEnum("set note");
/* 18 */   public static final EventEnum SET_NOTETIMESTAMP = new EventEnum("set noteTimeStamp");
/* 19 */   public static final EventEnum SET_CREATORPARTYID = new EventEnum("set creatorPartyId");
/* 20 */   public static final EventEnum SET_CREATORPARTY = new EventEnum("set CreatorParty");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getNoteSequence();
/*    */   
/*    */   void setNoteSequence(long paramLong);
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
/*    */   String getNote();
/*    */   
/*    */   void setNote(String paramString);
/*    */   
/*    */   Date getNoteTimeStamp();
/*    */   
/*    */   void setNoteTimeStamp(Date paramDate);
/*    */   
/*    */   long getCreatorPartyId();
/*    */   
/*    */   void setCreatorPartyId(long paramLong);
/*    */   
/*    */   IDataModel getEmployeeTaskNoteExt();
/*    */   
/*    */   void setEmployeeTaskNoteExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getCreatorParty();
/*    */   
/*    */   void setCreatorParty(IParty paramIParty);
/*    */   
/*    */   List<IEmployeeTaskNoteProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEmployeeTaskNoteProperty> paramList);
/*    */   
/*    */   void addEmployeeTaskNoteProperty(IEmployeeTaskNoteProperty paramIEmployeeTaskNoteProperty);
/*    */   
/*    */   void removeEmployeeTaskNoteProperty(IEmployeeTaskNoteProperty paramIEmployeeTaskNoteProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeeTaskNote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */