/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICustomerAccountNote extends IDataModel, IHasDataProperty<ICustomerAccountNoteProperty> {
/*  9 */   public static final EventEnum SET_NOTESEQUENCE = new EventEnum("set noteSequence");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 12 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ENTRYTIMESTAMP = new EventEnum("set entryTimestamp");
/* 18 */   public static final EventEnum SET_ENTRYPARTYID = new EventEnum("set entryPartyId");
/* 19 */   public static final EventEnum SET_NOTE = new EventEnum("set note");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getNoteSequence();
/*    */   
/*    */   void setNoteSequence(long paramLong);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
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
/*    */   Date getEntryTimestamp();
/*    */   
/*    */   void setEntryTimestamp(Date paramDate);
/*    */   
/*    */   long getEntryPartyId();
/*    */   
/*    */   void setEntryPartyId(long paramLong);
/*    */   
/*    */   String getNote();
/*    */   
/*    */   void setNote(String paramString);
/*    */   
/*    */   IDataModel getCustomerAccountNoteExt();
/*    */   
/*    */   void setCustomerAccountNoteExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ICustomerAccountNoteProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICustomerAccountNoteProperty> paramList);
/*    */   
/*    */   void addCustomerAccountNoteProperty(ICustomerAccountNoteProperty paramICustomerAccountNoteProperty);
/*    */   
/*    */   void removeCustomerAccountNoteProperty(ICustomerAccountNoteProperty paramICustomerAccountNoteProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerAccountNote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */