/*    */ package dtv.xst.dao.crm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerNote extends IDataModel, IHasDataProperty<ICustomerNoteProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 11 */   public static final EventEnum SET_NOTESEQUENCE = new EventEnum("set noteSequence");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_CREATORID = new EventEnum("set creatorId");
/* 17 */   public static final EventEnum SET_NOTE = new EventEnum("set note");
/* 18 */   public static final EventEnum SET_NOTETIMESTAMP = new EventEnum("set noteTimeStamp");
/* 19 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 20 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 21 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
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
/*    */   String getCreatorId();
/*    */   
/*    */   void setCreatorId(String paramString);
/*    */   
/*    */   String getNote();
/*    */   
/*    */   void setNote(String paramString);
/*    */   
/*    */   Date getNoteTimeStamp();
/*    */   
/*    */   void setNoteTimeStamp(Date paramDate);
/*    */   
/*    */   IDataModel getCustomerNoteExt();
/*    */   
/*    */   void setCustomerNoteExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerNoteProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerNoteProperty> paramList);
/*    */   
/*    */   void addCustomerNoteProperty(ICustomerNoteProperty paramICustomerNoteProperty);
/*    */   
/*    */   void removeCustomerNoteProperty(ICustomerNoteProperty paramICustomerNoteProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\ICustomerNote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */