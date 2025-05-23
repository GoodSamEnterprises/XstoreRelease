/*    */ package dtv.xst.dao.thr;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.hrs.IWorkCodes;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ITimeclockTransaction extends IDataModel, ITimeclockTransactionModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_TIMECLOCKENTRYCODES = new EventEnum("set timeclockEntryCodes");
/* 14 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 15 */   public static final EventEnum SET_TIMECARDENTRYID = new EventEnum("set timecardEntryId");
/* 16 */   public static final EventEnum SET_TIMECARDENTRYSEQ = new EventEnum("set timecardEntrySeq");
/* 17 */   public static final EventEnum SET_TIMECARDENTRYBUSINESSDATE = new EventEnum("set timecardEntryBusinessDate");
/* 18 */   public static final EventEnum SET_TIMECARDENTRYWORKSTATIONID = new EventEnum("set timecardEntryWorkstationId");
/* 19 */   public static final EventEnum SET_WORKCODESTRING = new EventEnum("set workCodeString");
/* 20 */   public static final EventEnum SET_WORKCODE = new EventEnum("set WorkCode");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getTimeclockEntryCodes();
/*    */   
/*    */   void setTimeclockEntryCodes(String paramString);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   long getTimecardEntryId();
/*    */   
/*    */   void setTimecardEntryId(long paramLong);
/*    */   
/*    */   long getTimecardEntrySeq();
/*    */   
/*    */   void setTimecardEntrySeq(long paramLong);
/*    */   
/*    */   Date getTimecardEntryBusinessDate();
/*    */   
/*    */   void setTimecardEntryBusinessDate(Date paramDate);
/*    */   
/*    */   long getTimecardEntryWorkstationId();
/*    */   
/*    */   void setTimecardEntryWorkstationId(long paramLong);
/*    */   
/*    */   String getWorkCodeString();
/*    */   
/*    */   void setWorkCodeString(String paramString);
/*    */   
/*    */   IDataModel getTimeclockTransactionExt();
/*    */   
/*    */   void setTimeclockTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IWorkCodes getWorkCode();
/*    */   
/*    */   void setWorkCode(IWorkCodes paramIWorkCodes);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\ITimeclockTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */