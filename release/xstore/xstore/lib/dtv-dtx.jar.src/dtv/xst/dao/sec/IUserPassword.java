/*    */ package dtv.xst.dao.sec;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IUserPassword extends IDataModel, IUserPasswordModel, IHasDataProperty<IUserPasswordProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_USER = new EventEnum("set user");
/* 11 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_HASH = new EventEnum("set hash");
/* 17 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 18 */   public static final EventEnum SET_FAILEDATTEMPTS = new EventEnum("set failedAttempts");
/* 19 */   public static final EventEnum SET_LOCKEDOUTTIMESTAMP = new EventEnum("set lockedOutTimeStamp");
/* 20 */   public static final EventEnum ADD_ROLEOBJECTS = new EventEnum("add RoleObjects");
/* 21 */   public static final EventEnum REMOVE_ROLEOBJECTS = new EventEnum("remove RoleObjects");
/* 22 */   public static final EventEnum SET_ROLEOBJECTS = new EventEnum("set RoleObjects");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getUser();
/*    */   
/*    */   void setUser(String paramString);
/*    */   
/*    */   long getSequence();
/*    */   
/*    */   void setSequence(long paramLong);
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
/*    */   String getHash();
/*    */   
/*    */   void setHash(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   int getFailedAttempts();
/*    */   
/*    */   void setFailedAttempts(int paramInt);
/*    */   
/*    */   Date getLockedOutTimeStamp();
/*    */   
/*    */   void setLockedOutTimeStamp(Date paramDate);
/*    */   
/*    */   IDataModel getUserPasswordExt();
/*    */   
/*    */   void setUserPasswordExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IUserRole> getRoleObjects();
/*    */   
/*    */   void setRoleObjects(List<IUserRole> paramList);
/*    */   
/*    */   void addUserRole(IUserRole paramIUserRole);
/*    */   
/*    */   void removeUserRole(IUserRole paramIUserRole);
/*    */   
/*    */   List<IUserPasswordProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IUserPasswordProperty> paramList);
/*    */   
/*    */   void addUserPasswordProperty(IUserPasswordProperty paramIUserPasswordProperty);
/*    */   
/*    */   void removeUserPasswordProperty(IUserPasswordProperty paramIUserPasswordProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\IUserPassword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */