/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEmployeeNote extends IDataModel, IHasDataProperty<IEmployeeNoteProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 11 */   public static final EventEnum SET_NOTESEQUENCE = new EventEnum("set noteSequence");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_NOTE = new EventEnum("set note");
/* 17 */   public static final EventEnum SET_NOTETIMESTAMP = new EventEnum("set noteTimeStamp");
/* 18 */   public static final EventEnum SET_CREATORPARTYID = new EventEnum("set creatorPartyId");
/* 19 */   public static final EventEnum SET_CREATORPARTY = new EventEnum("set CreatorParty");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
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
/*    */   String getEmployeeId();
/*    */   
/*    */   void setEmployeeId(String paramString);
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
/*    */   IDataModel getEmployeeNoteExt();
/*    */   
/*    */   void setEmployeeNoteExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getCreatorParty();
/*    */   
/*    */   void setCreatorParty(IParty paramIParty);
/*    */   
/*    */   List<IEmployeeNoteProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEmployeeNoteProperty> paramList);
/*    */   
/*    */   void addEmployeeNoteProperty(IEmployeeNoteProperty paramIEmployeeNoteProperty);
/*    */   
/*    */   void removeEmployeeNoteProperty(IEmployeeNoteProperty paramIEmployeeNoteProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeeNote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */