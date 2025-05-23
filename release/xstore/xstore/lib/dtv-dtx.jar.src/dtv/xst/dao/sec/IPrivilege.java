/*    */ package dtv.xst.dao.sec;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPrivilege extends IDataModel, IPrivilegeModel, IHasDataProperty<IPrivilegeProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PRIVILEGETYPE = new EventEnum("set privilegeType");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 16 */   public static final EventEnum SET_AUTHENTICATIONREQUIRED = new EventEnum("set authenticationRequired");
/* 17 */   public static final EventEnum SET_GROUPMEMBERSHIPRAW = new EventEnum("set groupMembershipRaw");
/* 18 */   public static final EventEnum SET_OVERRIDABLE = new EventEnum("set overridable");
/* 19 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 20 */   public static final EventEnum SET_SECONDPROMPTSETTINGS = new EventEnum("set secondPromptSettings");
/* 21 */   public static final EventEnum SET_SECONDPROMPTREQRDIFFEMP = new EventEnum("set secondPromptReqrDiffEmp");
/* 22 */   public static final EventEnum SET_SECONDPROMPTGROUPMEMBERSHIPRAW = new EventEnum("set secondPromptGroupMembershipRaw");
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
/*    */   String getPrivilegeType();
/*    */   
/*    */   void setPrivilegeType(String paramString);
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
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
/*    */   
/*    */   boolean getAuthenticationRequired();
/*    */   
/*    */   void setAuthenticationRequired(boolean paramBoolean);
/*    */   
/*    */   String getGroupMembershipRaw();
/*    */   
/*    */   void setGroupMembershipRaw(String paramString);
/*    */   
/*    */   boolean getOverridable();
/*    */   
/*    */   void setOverridable(boolean paramBoolean);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getSecondPromptSettings();
/*    */   
/*    */   void setSecondPromptSettings(String paramString);
/*    */   
/*    */   boolean getSecondPromptReqrDiffEmp();
/*    */   
/*    */   void setSecondPromptReqrDiffEmp(boolean paramBoolean);
/*    */   
/*    */   String getSecondPromptGroupMembershipRaw();
/*    */   
/*    */   void setSecondPromptGroupMembershipRaw(String paramString);
/*    */   
/*    */   IDataModel getPrivilegeExt();
/*    */   
/*    */   void setPrivilegeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPrivilegeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPrivilegeProperty> paramList);
/*    */   
/*    */   void addPrivilegeProperty(IPrivilegeProperty paramIPrivilegeProperty);
/*    */   
/*    */   void removePrivilegeProperty(IPrivilegeProperty paramIPrivilegeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\IPrivilege.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */