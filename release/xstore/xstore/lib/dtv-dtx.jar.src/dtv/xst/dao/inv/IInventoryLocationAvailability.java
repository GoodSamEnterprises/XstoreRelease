/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.sec.IPrivilege;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryLocationAvailability extends IDataModel, IHasDataProperty<IInventoryLocationAvailabilityProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_LOCATIONID = new EventEnum("set locationId");
/* 12 */   public static final EventEnum SET_AVAILABILITYCODE = new EventEnum("set availabilityCode");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_PRIVILEGETYPE = new EventEnum("set privilegeType");
/* 18 */   public static final EventEnum SET_PRIVILEGE = new EventEnum("set Privilege");
/* 19 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 20 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 21 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getLocationId();
/*    */   
/*    */   void setLocationId(String paramString);
/*    */   
/*    */   String getAvailabilityCode();
/*    */   
/*    */   void setAvailabilityCode(String paramString);
/*    */   
/*    */   String getPrivilegeType();
/*    */   
/*    */   void setPrivilegeType(String paramString);
/*    */   
/*    */   IDataModel getInventoryLocationAvailabilityExt();
/*    */   
/*    */   void setInventoryLocationAvailabilityExt(IDataModel paramIDataModel);
/*    */   
/*    */   IPrivilege getPrivilege();
/*    */   
/*    */   void setPrivilege(IPrivilege paramIPrivilege);
/*    */   
/*    */   List<IInventoryLocationAvailabilityProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryLocationAvailabilityProperty> paramList);
/*    */   
/*    */   void addInventoryLocationAvailabilityProperty(IInventoryLocationAvailabilityProperty paramIInventoryLocationAvailabilityProperty);
/*    */   
/*    */   void removeInventoryLocationAvailabilityProperty(IInventoryLocationAvailabilityProperty paramIInventoryLocationAvailabilityProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryLocationAvailability.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */