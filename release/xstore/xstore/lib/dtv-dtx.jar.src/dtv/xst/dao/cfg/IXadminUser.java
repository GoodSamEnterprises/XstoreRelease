/*    */ package dtv.xst.dao.cfg;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IXadminUser extends IDataModel {
/*  9 */   public static final EventEnum SET_USERNAME = new EventEnum("set userName");
/* 10 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 11 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_FIRSTNAME = new EventEnum("set firstName");
/* 15 */   public static final EventEnum SET_LASTNAME = new EventEnum("set lastName");
/* 16 */   public static final EventEnum SET_ROLEID = new EventEnum("set roleId");
/* 17 */   public static final EventEnum SET_LOCALE = new EventEnum("set locale");
/* 18 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 19 */   public static final EventEnum SET_EMAILADDRESS = new EventEnum("set emailAddress");
/* 20 */   public static final EventEnum SET_DIRECTORYTYPE = new EventEnum("set directoryType");
/* 21 */   public static final EventEnum ADD_ORGSCOPES = new EventEnum("add OrgScopes");
/* 22 */   public static final EventEnum REMOVE_ORGSCOPES = new EventEnum("remove OrgScopes");
/* 23 */   public static final EventEnum SET_ORGSCOPES = new EventEnum("set OrgScopes");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getUserName();
/*    */   
/*    */   void setUserName(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   String getFirstName();
/*    */   
/*    */   void setFirstName(String paramString);
/*    */   
/*    */   String getLastName();
/*    */   
/*    */   void setLastName(String paramString);
/*    */   
/*    */   String getRoleId();
/*    */   
/*    */   void setRoleId(String paramString);
/*    */   
/*    */   String getLocale();
/*    */   
/*    */   void setLocale(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getEmailAddress();
/*    */   
/*    */   void setEmailAddress(String paramString);
/*    */   
/*    */   String getDirectoryType();
/*    */   
/*    */   void setDirectoryType(String paramString);
/*    */   
/*    */   IDataModel getXadminUserExt();
/*    */   
/*    */   void setXadminUserExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IXadminUserNode> getOrgScopes();
/*    */   
/*    */   void setOrgScopes(List<IXadminUserNode> paramList);
/*    */   
/*    */   void addXadminUserNode(IXadminUserNode paramIXadminUserNode);
/*    */   
/*    */   void removeXadminUserNode(IXadminUserNode paramIXadminUserNode);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\IXadminUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */