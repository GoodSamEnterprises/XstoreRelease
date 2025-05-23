/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEmployeePassword extends IDataModel, IHasDataProperty<IEmployeePasswordProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 11 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_PASSWORD = new EventEnum("set password");
/* 17 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 18 */   public static final EventEnum SET_TEMPORARY = new EventEnum("set temporary");
/* 19 */   public static final EventEnum SET_CURRENT = new EventEnum("set current");
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
/*    */   String getEmployeeId();
/*    */   
/*    */   void setEmployeeId(String paramString);
/*    */   
/*    */   int getSequence();
/*    */   
/*    */   void setSequence(int paramInt);
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
/*    */   String getPassword();
/*    */   
/*    */   void setPassword(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   boolean getTemporary();
/*    */   
/*    */   void setTemporary(boolean paramBoolean);
/*    */   
/*    */   boolean getCurrent();
/*    */   
/*    */   void setCurrent(boolean paramBoolean);
/*    */   
/*    */   IDataModel getEmployeePasswordExt();
/*    */   
/*    */   void setEmployeePasswordExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IEmployeePasswordProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEmployeePasswordProperty> paramList);
/*    */   
/*    */   void addEmployeePasswordProperty(IEmployeePasswordProperty paramIEmployeePasswordProperty);
/*    */   
/*    */   void removeEmployeePasswordProperty(IEmployeePasswordProperty paramIEmployeePasswordProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeePassword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */