/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryBucket extends IDataModel, IHasDataProperty<IInventoryBucketProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUCKETID = new EventEnum("set bucketId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_NAME = new EventEnum("set name");
/* 17 */   public static final EventEnum SET_FUNCTIONCODE = new EventEnum("set functionCode");
/* 18 */   public static final EventEnum SET_ADJUSTMENTACTION = new EventEnum("set adjustmentAction");
/* 19 */   public static final EventEnum SET_DEFAULTLOCATIONID = new EventEnum("set defaultLocationId");
/* 20 */   public static final EventEnum SET_SYSTEMBUCKET = new EventEnum("set systemBucket");
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
/*    */   String getBucketId();
/*    */   
/*    */   void setBucketId(String paramString);
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
/*    */   String getFunctionCode();
/*    */   
/*    */   void setFunctionCode(String paramString);
/*    */   
/*    */   String getAdjustmentAction();
/*    */   
/*    */   void setAdjustmentAction(String paramString);
/*    */   
/*    */   String getDefaultLocationId();
/*    */   
/*    */   void setDefaultLocationId(String paramString);
/*    */   
/*    */   boolean getSystemBucket();
/*    */   
/*    */   void setSystemBucket(boolean paramBoolean);
/*    */   
/*    */   IDataModel getInventoryBucketExt();
/*    */   
/*    */   void setInventoryBucketExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryBucketProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryBucketProperty> paramList);
/*    */   
/*    */   void addInventoryBucketProperty(IInventoryBucketProperty paramIInventoryBucketProperty);
/*    */   
/*    */   void removeInventoryBucketProperty(IInventoryBucketProperty paramIInventoryBucketProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryBucket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */