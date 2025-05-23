/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IStockLedger extends IDataModel, IHasDataProperty<IStockLedgerProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUCKETID = new EventEnum("set bucketId");
/* 12 */   public static final EventEnum SET_INVLOCATIONID = new EventEnum("set invLocationId");
/* 13 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_UNITCOUNT = new EventEnum("set unitcount");
/* 19 */   public static final EventEnum SET_INVENTORYVALUE = new EventEnum("set inventoryValue");
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
/*    */   String getBucketId();
/*    */   
/*    */   void setBucketId(String paramString);
/*    */   
/*    */   String getInvLocationId();
/*    */   
/*    */   void setInvLocationId(String paramString);
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
/*    */   BigDecimal getUnitcount();
/*    */   
/*    */   void setUnitcount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getInventoryValue();
/*    */   
/*    */   void setInventoryValue(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getStockLedgerExt();
/*    */   
/*    */   void setStockLedgerExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IStockLedgerProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IStockLedgerProperty> paramList);
/*    */   
/*    */   void addStockLedgerProperty(IStockLedgerProperty paramIStockLedgerProperty);
/*    */   
/*    */   void removeStockLedgerProperty(IStockLedgerProperty paramIStockLedgerProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IStockLedger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */