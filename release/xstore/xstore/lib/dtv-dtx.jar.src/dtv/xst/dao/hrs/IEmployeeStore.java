/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEmployeeStore extends IDataModel, IHasDataProperty<IEmployeeStoreProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_EMPLOYEESTORESEQUENCE = new EventEnum("set employeeStoreSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_BEGINDATE = new EventEnum("set beginDate");
/* 18 */   public static final EventEnum SET_ENDDATE = new EventEnum("set endDate");
/* 19 */   public static final EventEnum SET_TEMPORARYASSIGNMENT = new EventEnum("set temporaryAssignment");
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   int getEmployeeStoreSequence();
/*    */   
/*    */   void setEmployeeStoreSequence(int paramInt);
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
/*    */   Date getBeginDate();
/*    */   
/*    */   void setBeginDate(Date paramDate);
/*    */   
/*    */   Date getEndDate();
/*    */   
/*    */   void setEndDate(Date paramDate);
/*    */   
/*    */   boolean getTemporaryAssignment();
/*    */   
/*    */   void setTemporaryAssignment(boolean paramBoolean);
/*    */   
/*    */   IDataModel getEmployeeStoreExt();
/*    */   
/*    */   void setEmployeeStoreExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IEmployeeStoreProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEmployeeStoreProperty> paramList);
/*    */   
/*    */   void addEmployeeStoreProperty(IEmployeeStoreProperty paramIEmployeeStoreProperty);
/*    */   
/*    */   void removeEmployeeStoreProperty(IEmployeeStoreProperty paramIEmployeeStoreProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeeStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */