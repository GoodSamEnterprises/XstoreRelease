/*    */ package dtv.xst.dao.sec;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IAclAccessType extends IDataModel, IAclAccessTypeModel, IHasDataProperty<IAclAccessTypeProperty> {
/*  9 */   public static final EventEnum SET_ACCESSTYPECODE = new EventEnum("set accessTypeCode");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_SECUREDOBJECTID = new EventEnum("set securedObjectId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_GROUPMEMBERSHIPRAW = new EventEnum("set groupMembershipRaw");
/* 17 */   public static final EventEnum SET_NOACCESSSETTINGS = new EventEnum("set noAccessSettings");
/* 18 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 19 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 20 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getAccessTypeCode();
/*    */   
/*    */   void setAccessTypeCode(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getSecuredObjectId();
/*    */   
/*    */   void setSecuredObjectId(String paramString);
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
/*    */   String getGroupMembershipRaw();
/*    */   
/*    */   void setGroupMembershipRaw(String paramString);
/*    */   
/*    */   String getNoAccessSettings();
/*    */   
/*    */   void setNoAccessSettings(String paramString);
/*    */   
/*    */   IDataModel getAclAccessTypeExt();
/*    */   
/*    */   void setAclAccessTypeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IAclAccessTypeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IAclAccessTypeProperty> paramList);
/*    */   
/*    */   void addAclAccessTypeProperty(IAclAccessTypeProperty paramIAclAccessTypeProperty);
/*    */   
/*    */   void removeAclAccessTypeProperty(IAclAccessTypeProperty paramIAclAccessTypeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\IAclAccessType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */