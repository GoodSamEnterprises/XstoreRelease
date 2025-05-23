/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryLocation extends IDataModel, IInventoryLocationModel, IHasDataProperty<IInventoryLocationProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_LOCATIONID = new EventEnum("set locationId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_NAME = new EventEnum("set name");
/* 17 */   public static final EventEnum SET_SYSTEMLOCATION = new EventEnum("set systemLocation");
/* 18 */   public static final EventEnum SET_ACTIVE = new EventEnum("set active");
/* 19 */   public static final EventEnum ADD_INVENTORYLOCATIONBUCKETS = new EventEnum("add InventoryLocationBuckets");
/* 20 */   public static final EventEnum REMOVE_INVENTORYLOCATIONBUCKETS = new EventEnum("remove InventoryLocationBuckets");
/* 21 */   public static final EventEnum SET_INVENTORYLOCATIONBUCKETS = new EventEnum("set InventoryLocationBuckets");
/* 22 */   public static final EventEnum ADD_AVAILABILITYCODES = new EventEnum("add AvailabilityCodes");
/* 23 */   public static final EventEnum REMOVE_AVAILABILITYCODES = new EventEnum("remove AvailabilityCodes");
/* 24 */   public static final EventEnum SET_AVAILABILITYCODES = new EventEnum("set AvailabilityCodes");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getName();
/*    */   
/*    */   void setName(String paramString);
/*    */   
/*    */   boolean getSystemLocation();
/*    */   
/*    */   void setSystemLocation(boolean paramBoolean);
/*    */   
/*    */   boolean getActive();
/*    */   
/*    */   void setActive(boolean paramBoolean);
/*    */   
/*    */   IDataModel getInventoryLocationExt();
/*    */   
/*    */   void setInventoryLocationExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryLocationBucket> getInventoryLocationBuckets();
/*    */   
/*    */   void setInventoryLocationBuckets(List<IInventoryLocationBucket> paramList);
/*    */   
/*    */   void addInventoryLocationBucket(IInventoryLocationBucket paramIInventoryLocationBucket);
/*    */   
/*    */   void removeInventoryLocationBucket(IInventoryLocationBucket paramIInventoryLocationBucket);
/*    */   
/*    */   List<IInventoryLocationAvailability> getAvailabilityCodes();
/*    */   
/*    */   void setAvailabilityCodes(List<IInventoryLocationAvailability> paramList);
/*    */   
/*    */   void addInventoryLocationAvailability(IInventoryLocationAvailability paramIInventoryLocationAvailability);
/*    */   
/*    */   void removeInventoryLocationAvailability(IInventoryLocationAvailability paramIInventoryLocationAvailability);
/*    */   
/*    */   List<IInventoryLocationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryLocationProperty> paramList);
/*    */   
/*    */   void addInventoryLocationProperty(IInventoryLocationProperty paramIInventoryLocationProperty);
/*    */   
/*    */   void removeInventoryLocationProperty(IInventoryLocationProperty paramIInventoryLocationProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */