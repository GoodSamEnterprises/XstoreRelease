/*    */ package dtv.xst.dao.ctl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDeviceRegistration extends IDataModel, IHasDataProperty<IDeviceRegistrationProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_IPADDRESS = new EventEnum("set ipAddress");
/* 17 */   public static final EventEnum SET_DATETIMESTAMP = new EventEnum("set dateTimestamp");
/* 18 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 19 */   public static final EventEnum SET_XTOREVERSION = new EventEnum("set xtoreVersion");
/* 20 */   public static final EventEnum SET_ENVVERSION = new EventEnum("set envVersion");
/* 21 */   public static final EventEnum SET_ACTIVEFLAG = new EventEnum("set activeFlag");
/* 22 */   public static final EventEnum SET_CONFIGVERSION = new EventEnum("set configVersion");
/* 23 */   public static final EventEnum SET_PRIMARYREGISTER = new EventEnum("set primaryRegister");
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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
/*    */   String getIpAddress();
/*    */   
/*    */   void setIpAddress(String paramString);
/*    */   
/*    */   Date getDateTimestamp();
/*    */   
/*    */   void setDateTimestamp(Date paramDate);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   String getXtoreVersion();
/*    */   
/*    */   void setXtoreVersion(String paramString);
/*    */   
/*    */   String getEnvVersion();
/*    */   
/*    */   void setEnvVersion(String paramString);
/*    */   
/*    */   boolean getActiveFlag();
/*    */   
/*    */   void setActiveFlag(boolean paramBoolean);
/*    */   
/*    */   String getConfigVersion();
/*    */   
/*    */   void setConfigVersion(String paramString);
/*    */   
/*    */   boolean getPrimaryRegister();
/*    */   
/*    */   void setPrimaryRegister(boolean paramBoolean);
/*    */   
/*    */   IDataModel getDeviceRegistrationExt();
/*    */   
/*    */   void setDeviceRegistrationExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDeviceRegistrationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDeviceRegistrationProperty> paramList);
/*    */   
/*    */   void addDeviceRegistrationProperty(IDeviceRegistrationProperty paramIDeviceRegistrationProperty);
/*    */   
/*    */   void removeDeviceRegistrationProperty(IDeviceRegistrationProperty paramIDeviceRegistrationProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\IDeviceRegistration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */