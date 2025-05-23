/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCount extends IDataModel, IInventoryCountModel, IHasDataProperty<IInventoryCountProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_INVENTORYCOUNTID = new EventEnum("set inventoryCountId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 17 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 18 */   public static final EventEnum SET_BEGINDATE = new EventEnum("set beginDate");
/* 19 */   public static final EventEnum SET_ENDDATE = new EventEnum("set endDate");
/* 20 */   public static final EventEnum SET_COUNTSTATUS = new EventEnum("set countStatus");
/* 21 */   public static final EventEnum SET_STORECREATED = new EventEnum("set storeCreated");
/* 22 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 23 */   public static final EventEnum ADD_INVENTORYCOUNTBUCKETS = new EventEnum("add InventoryCountBuckets");
/* 24 */   public static final EventEnum REMOVE_INVENTORYCOUNTBUCKETS = new EventEnum("remove InventoryCountBuckets");
/* 25 */   public static final EventEnum SET_INVENTORYCOUNTBUCKETS = new EventEnum("set InventoryCountBuckets");
/* 26 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 27 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 28 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   Date getBeginDate();
/*    */   
/*    */   void setBeginDate(Date paramDate);
/*    */   
/*    */   Date getEndDate();
/*    */   
/*    */   void setEndDate(Date paramDate);
/*    */   
/*    */   String getCountStatus();
/*    */   
/*    */   void setCountStatus(String paramString);
/*    */   
/*    */   boolean getStoreCreated();
/*    */   
/*    */   void setStoreCreated(boolean paramBoolean);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   IDataModel getInventoryCountExt();
/*    */   
/*    */   void setInventoryCountExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCountBucket> getInventoryCountBuckets();
/*    */   
/*    */   void setInventoryCountBuckets(List<IInventoryCountBucket> paramList);
/*    */   
/*    */   void addInventoryCountBucket(IInventoryCountBucket paramIInventoryCountBucket);
/*    */   
/*    */   void removeInventoryCountBucket(IInventoryCountBucket paramIInventoryCountBucket);
/*    */   
/*    */   List<IInventoryCountProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCountProperty> paramList);
/*    */   
/*    */   void addInventoryCountProperty(IInventoryCountProperty paramIInventoryCountProperty);
/*    */   
/*    */   void removeInventoryCountProperty(IInventoryCountProperty paramIInventoryCountProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */