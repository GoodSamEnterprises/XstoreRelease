/*    */ package dtv.xst.dao.prc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDealWeek extends IDataModel, IHasDataProperty<IDealWeekProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DEALID = new EventEnum("set dealId");
/* 11 */   public static final EventEnum SET_DAYCODE = new EventEnum("set dayCode");
/* 12 */   public static final EventEnum SET_STARTTIME = new EventEnum("set startTime");
/* 13 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 14 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_ENDTIME = new EventEnum("set endTime");
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
/*    */   String getDealId();
/*    */   
/*    */   void setDealId(String paramString);
/*    */   
/*    */   String getDayCode();
/*    */   
/*    */   void setDayCode(String paramString);
/*    */   
/*    */   Date getStartTime();
/*    */   
/*    */   void setStartTime(Date paramDate);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
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
/*    */   Date getEndTime();
/*    */   
/*    */   void setEndTime(Date paramDate);
/*    */   
/*    */   IDataModel getDealWeekExt();
/*    */   
/*    */   void setDealWeekExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDealWeekProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDealWeekProperty> paramList);
/*    */   
/*    */   void addDealWeekProperty(IDealWeekProperty paramIDealWeekProperty);
/*    */   
/*    */   void removeDealWeekProperty(IDealWeekProperty paramIDealWeekProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\IDealWeek.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */