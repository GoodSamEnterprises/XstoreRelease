/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCountSheetLineItem extends IDataModel, IHasDataProperty<IInventoryCountSheetLineItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_INVENTORYCOUNTID = new EventEnum("set inventoryCountId");
/* 12 */   public static final EventEnum SET_COUNTSHEETNUMBER = new EventEnum("set countSheetNumber");
/* 13 */   public static final EventEnum SET_LINEITEMNUMBER = new EventEnum("set lineItemNumber");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_INVENTORYBUCKETID = new EventEnum("set inventoryBucketId");
/* 19 */   public static final EventEnum SET_COUNTCYCLE = new EventEnum("set countCycle");
/* 20 */   public static final EventEnum SET_PAGENUMBER = new EventEnum("set pageNumber");
/* 21 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 22 */   public static final EventEnum SET_ALTERNATEID = new EventEnum("set alternateId");
/* 23 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 24 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
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
/*    */   String getInventoryCountId();
/*    */   
/*    */   void setInventoryCountId(String paramString);
/*    */   
/*    */   int getCountSheetNumber();
/*    */   
/*    */   void setCountSheetNumber(int paramInt);
/*    */   
/*    */   int getLineItemNumber();
/*    */   
/*    */   void setLineItemNumber(int paramInt);
/*    */   
/*    */   String getInventoryBucketId();
/*    */   
/*    */   void setInventoryBucketId(String paramString);
/*    */   
/*    */   int getCountCycle();
/*    */   
/*    */   void setCountCycle(int paramInt);
/*    */   
/*    */   int getPageNumber();
/*    */   
/*    */   void setPageNumber(int paramInt);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getAlternateId();
/*    */   
/*    */   void setAlternateId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getInventoryCountSheetLineItemExt();
/*    */   
/*    */   void setInventoryCountSheetLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCountSheetLineItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCountSheetLineItemProperty> paramList);
/*    */   
/*    */   void addInventoryCountSheetLineItemProperty(IInventoryCountSheetLineItemProperty paramIInventoryCountSheetLineItemProperty);
/*    */   
/*    */   void removeInventoryCountSheetLineItemProperty(IInventoryCountSheetLineItemProperty paramIInventoryCountSheetLineItemProperty);
/*    */   
/*    */   void setParentCountSheet(IInventoryCountSheet paramIInventoryCountSheet);
/*    */   
/*    */   IInventoryCountSheet getParentCountSheet();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCountSheetLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */