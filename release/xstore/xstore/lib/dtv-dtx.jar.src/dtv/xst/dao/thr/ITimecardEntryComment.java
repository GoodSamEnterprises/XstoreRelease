/*    */ package dtv.xst.dao.thr;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITimecardEntryComment extends IDataModel, ITimecardEntryCommentModel, IHasDataProperty<ITimecardEntryCommentProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_WEEKENDINGDATE = new EventEnum("set weekEndingDate");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 14 */   public static final EventEnum SET_COMMENTSEQ = new EventEnum("set commentSeq");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_COMMENTDATETIME = new EventEnum("set commentDateTime");
/* 20 */   public static final EventEnum SET_COMMENTTEXT = new EventEnum("set commentText");
/* 21 */   public static final EventEnum SET_CREATORID = new EventEnum("set creatorId");
/* 22 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 23 */   public static final EventEnum SET_TIMECARDENTRYID = new EventEnum("set timecardEntryId");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   Date getWeekEndingDate();
/*    */   
/*    */   void setWeekEndingDate(Date paramDate);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   long getCommentSeq();
/*    */   
/*    */   void setCommentSeq(long paramLong);
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
/*    */   Date getCommentDateTime();
/*    */   
/*    */   void setCommentDateTime(Date paramDate);
/*    */   
/*    */   String getCommentText();
/*    */   
/*    */   void setCommentText(String paramString);
/*    */   
/*    */   String getCreatorId();
/*    */   
/*    */   void setCreatorId(String paramString);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getTimecardEntryId();
/*    */   
/*    */   void setTimecardEntryId(long paramLong);
/*    */   
/*    */   IDataModel getTimecardEntryCommentExt();
/*    */   
/*    */   void setTimecardEntryCommentExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITimecardEntryCommentProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITimecardEntryCommentProperty> paramList);
/*    */   
/*    */   void addTimecardEntryCommentProperty(ITimecardEntryCommentProperty paramITimecardEntryCommentProperty);
/*    */   
/*    */   void removeTimecardEntryCommentProperty(ITimecardEntryCommentProperty paramITimecardEntryCommentProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\ITimecardEntryComment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */