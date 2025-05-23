/*    */ package dtv.xst.dao.sch;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.hrs.IWorkCodes;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ISchedule extends IDataModel, IHasDataProperty<IScheduleProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_SCHEDULESEQ = new EventEnum("set scheduleSeq");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_STARTTIME = new EventEnum("set startTime");
/* 18 */   public static final EventEnum SET_ENDTIME = new EventEnum("set endTime");
/* 19 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 20 */   public static final EventEnum SET_WORKCODESTRING = new EventEnum("set workCodeString");
/* 21 */   public static final EventEnum SET_SCHEDULEDURATION = new EventEnum("set scheduleDuration");
/* 22 */   public static final EventEnum SET_BREAKDURATION = new EventEnum("set breakDuration");
/* 23 */   public static final EventEnum SET_WORKCODE = new EventEnum("set WorkCode");
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
/*    */   String getEmployeeId();
/*    */   
/*    */   void setEmployeeId(String paramString);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getScheduleSeq();
/*    */   
/*    */   void setScheduleSeq(long paramLong);
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
/*    */   Date getStartTime();
/*    */   
/*    */   void setStartTime(Date paramDate);
/*    */   
/*    */   Date getEndTime();
/*    */   
/*    */   void setEndTime(Date paramDate);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   String getWorkCodeString();
/*    */   
/*    */   void setWorkCodeString(String paramString);
/*    */   
/*    */   long getScheduleDuration();
/*    */   
/*    */   void setScheduleDuration(long paramLong);
/*    */   
/*    */   long getBreakDuration();
/*    */   
/*    */   void setBreakDuration(long paramLong);
/*    */   
/*    */   IDataModel getScheduleExt();
/*    */   
/*    */   void setScheduleExt(IDataModel paramIDataModel);
/*    */   
/*    */   IWorkCodes getWorkCode();
/*    */   
/*    */   void setWorkCode(IWorkCodes paramIWorkCodes);
/*    */   
/*    */   List<IScheduleProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IScheduleProperty> paramList);
/*    */   
/*    */   void addScheduleProperty(IScheduleProperty paramIScheduleProperty);
/*    */   
/*    */   void removeScheduleProperty(IScheduleProperty paramIScheduleProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\ISchedule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */