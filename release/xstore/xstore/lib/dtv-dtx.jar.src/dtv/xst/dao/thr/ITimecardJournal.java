/*    */ package dtv.xst.dao.thr;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.hrs.IWorkCodes;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITimecardJournal extends IDataModel, ITimecardJournalModel, IHasDataProperty<ITimecardJournalProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 13 */   public static final EventEnum SET_TIMECARDENTRYID = new EventEnum("set timecardEntryId");
/* 14 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 15 */   public static final EventEnum SET_TIMECARDENTRYSEQ = new EventEnum("set timecardEntrySeq");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_CLOCKINDATETIME = new EventEnum("set clockInDateTime");
/* 21 */   public static final EventEnum SET_CLOCKOUTDATETIME = new EventEnum("set clockOutDateTime");
/* 22 */   public static final EventEnum SET_ENTRYTYPE = new EventEnum("set entryType");
/* 23 */   public static final EventEnum SET_DELETE = new EventEnum("set delete");
/* 24 */   public static final EventEnum SET_WORKCODESTRING = new EventEnum("set workCodeString");
/* 25 */   public static final EventEnum SET_WORKCODE = new EventEnum("set WorkCode");
/* 26 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 27 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 28 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   long getTimecardEntryId();
/*    */   
/*    */   void setTimecardEntryId(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   long getTimecardEntrySeq();
/*    */   
/*    */   void setTimecardEntrySeq(long paramLong);
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
/*    */   Date getClockInDateTime();
/*    */   
/*    */   void setClockInDateTime(Date paramDate);
/*    */   
/*    */   Date getClockOutDateTime();
/*    */   
/*    */   void setClockOutDateTime(Date paramDate);
/*    */   
/*    */   String getEntryType();
/*    */   
/*    */   void setEntryType(String paramString);
/*    */   
/*    */   boolean getDelete();
/*    */   
/*    */   void setDelete(boolean paramBoolean);
/*    */   
/*    */   IDataModel getTimecardJournalExt();
/*    */   
/*    */   void setTimecardJournalExt(IDataModel paramIDataModel);
/*    */   
/*    */   IWorkCodes getWorkCode();
/*    */   
/*    */   void setWorkCode(IWorkCodes paramIWorkCodes);
/*    */   
/*    */   List<ITimecardJournalProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITimecardJournalProperty> paramList);
/*    */   
/*    */   void addTimecardJournalProperty(ITimecardJournalProperty paramITimecardJournalProperty);
/*    */   
/*    */   void removeTimecardJournalProperty(ITimecardJournalProperty paramITimecardJournalProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\ITimecardJournal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */