/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IHasDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCountBucket extends IDataModel, IHasDataProperty<IInventoryCountBucketProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_INVENTORYCOUNTID = new EventEnum("set inventoryCountId");
/* 12 */   public static final EventEnum SET_INVENTORYBUCKETID = new EventEnum("set inventoryBucketId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_COUNTCYCLE = new EventEnum("set countCycle");
/* 18 */   public static final EventEnum SET_BUCKETSTATUS = new EventEnum("set bucketStatus");
/* 19 */   public static final EventEnum SET_INVENTORYBUCKETNAME = new EventEnum("set inventoryBucketName");
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getInventoryCountId();
/*    */   
/*    */   void setInventoryCountId(String paramString);
/*    */   
/*    */   String getInventoryBucketId();
/*    */   
/*    */   void setInventoryBucketId(String paramString);
/*    */   
/*    */   int getCountCycle();
/*    */   
/*    */   void setCountCycle(int paramInt);
/*    */   
/*    */   String getBucketStatus();
/*    */   
/*    */   void setBucketStatus(String paramString);
/*    */   
/*    */   String getInventoryBucketName();
/*    */   
/*    */   void setInventoryBucketName(String paramString);
/*    */   
/*    */   IDataModel getInventoryCountBucketExt();
/*    */   
/*    */   void setInventoryCountBucketExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCountBucketProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCountBucketProperty> paramList);
/*    */   
/*    */   void addInventoryCountBucketProperty(IInventoryCountBucketProperty paramIInventoryCountBucketProperty);
/*    */   
/*    */   void removeInventoryCountBucketProperty(IInventoryCountBucketProperty paramIInventoryCountBucketProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCountBucket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */