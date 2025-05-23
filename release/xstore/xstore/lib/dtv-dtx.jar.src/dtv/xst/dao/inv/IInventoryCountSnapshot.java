/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCountSnapshot extends IDataModel, IHasDataProperty<IInventoryCountSnapshotProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_INVENTORYCOUNTID = new EventEnum("set inventoryCountId");
/* 12 */   public static final EventEnum SET_INVENTORYLOCATIONID = new EventEnum("set inventoryLocationId");
/* 13 */   public static final EventEnum SET_INVENTORYBUCKETID = new EventEnum("set inventoryBucketId");
/* 14 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_SNAPSHOTDATE = new EventEnum("set snapshotDate");
/* 20 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getInventoryLocationId();
/*    */   
/*    */   void setInventoryLocationId(String paramString);
/*    */   
/*    */   String getInventoryBucketId();
/*    */   
/*    */   void setInventoryBucketId(String paramString);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
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
/*    */   Date getSnapshotDate();
/*    */   
/*    */   void setSnapshotDate(Date paramDate);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getInventoryCountSnapshotExt();
/*    */   
/*    */   void setInventoryCountSnapshotExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCountSnapshotProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCountSnapshotProperty> paramList);
/*    */   
/*    */   void addInventoryCountSnapshotProperty(IInventoryCountSnapshotProperty paramIInventoryCountSnapshotProperty);
/*    */   
/*    */   void removeInventoryCountSnapshotProperty(IInventoryCountSnapshotProperty paramIInventoryCountSnapshotProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCountSnapshot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */