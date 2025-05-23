/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ISessionControlTransaction extends IDataModel, ISessionControlTransactionModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 14 */   public static final EventEnum SET_SESSIONWORKSTATIONSEQUENCE = new EventEnum("set sessionWorkstationSequence");
/* 15 */   public static final EventEnum SET_SESSION = new EventEnum("set Session");
/* 16 */   public static final EventEnum SET_SESSIONWORKSTATION = new EventEnum("set SessionWorkstation");
/* 17 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 18 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 19 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   int getSessionWorkstationSequence();
/*    */   
/*    */   void setSessionWorkstationSequence(int paramInt);
/*    */   
/*    */   IDataModel getSessionControlTransactionExt();
/*    */   
/*    */   void setSessionControlTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   ISession getSession();
/*    */   
/*    */   void setSession(ISession paramISession);
/*    */   
/*    */   ISessionWorkstation getSessionWorkstation();
/*    */   
/*    */   void setSessionWorkstation(ISessionWorkstation paramISessionWorkstation);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ISessionControlTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */