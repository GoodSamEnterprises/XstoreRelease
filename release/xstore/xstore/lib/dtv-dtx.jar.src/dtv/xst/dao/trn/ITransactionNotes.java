/*    */ package dtv.xst.dao.trn;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITransactionNotes extends IDataModel, ITransactionNotesModel, IHasDataProperty<ITransactionNotesProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 10 */   public static final EventEnum SET_NOTESEQUENCE = new EventEnum("set noteSequence");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_NOTE = new EventEnum("set note");
/* 20 */   public static final EventEnum SET_NOTEDATETIMESTAMP = new EventEnum("set noteDatetimestamp");
/* 21 */   public static final EventEnum SET_POSTED = new EventEnum("set posted");
/* 22 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 23 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 24 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 25 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 26 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 27 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   int getNoteSequence();
/*    */   
/*    */   void setNoteSequence(int paramInt);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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
/*    */   Date getNoteDatetimestamp();
/*    */   
/*    */   void setNoteDatetimestamp(Date paramDate);
/*    */   
/*    */   boolean getPosted();
/*    */   
/*    */   void setPosted(boolean paramBoolean);
/*    */   
/*    */   IDataModel getTransactionNotesExt();
/*    */   
/*    */   void setTransactionNotesExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITransactionNotesProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITransactionNotesProperty> paramList);
/*    */   
/*    */   void addTransactionNotesProperty(ITransactionNotesProperty paramITransactionNotesProperty);
/*    */   
/*    */   void removeTransactionNotesProperty(ITransactionNotesProperty paramITransactionNotesProperty);
/*    */   
/*    */   void setParentTransaction(IPosTransaction paramIPosTransaction);
/*    */   
/*    */   IPosTransaction getParentTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\ITransactionNotes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */