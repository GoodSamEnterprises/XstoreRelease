/*    */ package dtv.xst.dao.sec;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ISecurityLog extends IDataModel {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 14 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 17 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 18 */   public static final EventEnum SET_ACTIVITYTYPE = new EventEnum("set activityType");
/* 19 */   public static final EventEnum SET_SUCCESS = new EventEnum("set success");
/* 20 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 21 */   public static final EventEnum SET_OVERRIDINGEMPLOYEEID = new EventEnum("set overridingEmployeeId");
/* 22 */   public static final EventEnum SET_PRIVILEGETYPE = new EventEnum("set privilegeType");
/* 23 */   public static final EventEnum SET_SYSTEMDATETIME = new EventEnum("set systemDateTime");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   String getActivityType();
/*    */   
/*    */   void setActivityType(String paramString);
/*    */   
/*    */   boolean getSuccess();
/*    */   
/*    */   void setSuccess(boolean paramBoolean);
/*    */   
/*    */   String getEmployeeId();
/*    */   
/*    */   void setEmployeeId(String paramString);
/*    */   
/*    */   String getOverridingEmployeeId();
/*    */   
/*    */   void setOverridingEmployeeId(String paramString);
/*    */   
/*    */   String getPrivilegeType();
/*    */   
/*    */   void setPrivilegeType(String paramString);
/*    */   
/*    */   Date getSystemDateTime();
/*    */   
/*    */   void setSystemDateTime(Date paramDate);
/*    */   
/*    */   IDataModel getSecurityLogExt();
/*    */   
/*    */   void setSecurityLogExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\ISecurityLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */