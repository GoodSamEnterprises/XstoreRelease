/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IHasDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCountSheet extends IDataModel, IHasDataProperty<IInventoryCountSheetProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_INVENTORYCOUNTID = new EventEnum("set inventoryCountId");
/* 12 */   public static final EventEnum SET_COUNTSHEETNUMBER = new EventEnum("set countSheetNumber");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_INVENTORYBUCKETID = new EventEnum("set inventoryBucketId");
/* 18 */   public static final EventEnum SET_SECTIONNUMBER = new EventEnum("set sectionNumber");
/* 19 */   public static final EventEnum SET_SECTIONID = new EventEnum("set sectionId");
/* 20 */   public static final EventEnum SET_COUNTCYCLE = new EventEnum("set countCycle");
/* 21 */   public static final EventEnum SET_SHEETSTATUS = new EventEnum("set sheetStatus");
/* 22 */   public static final EventEnum SET_CHECKEDOUT = new EventEnum("set checkedOut");
/* 23 */   public static final EventEnum SET_INVENTORYBUCKETNAME = new EventEnum("set inventoryBucketName");
/* 24 */   public static final EventEnum ADD_COUNTSHEETLINEITEMS = new EventEnum("add CountSheetLineItems");
/* 25 */   public static final EventEnum REMOVE_COUNTSHEETLINEITEMS = new EventEnum("remove CountSheetLineItems");
/* 26 */   public static final EventEnum SET_COUNTSHEETLINEITEMS = new EventEnum("set CountSheetLineItems");
/* 27 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 28 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 29 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 30 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 31 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 32 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getInventoryBucketId();
/*    */   
/*    */   void setInventoryBucketId(String paramString);
/*    */   
/*    */   int getSectionNumber();
/*    */   
/*    */   void setSectionNumber(int paramInt);
/*    */   
/*    */   String getSectionId();
/*    */   
/*    */   void setSectionId(String paramString);
/*    */   
/*    */   int getCountCycle();
/*    */   
/*    */   void setCountCycle(int paramInt);
/*    */   
/*    */   String getSheetStatus();
/*    */   
/*    */   void setSheetStatus(String paramString);
/*    */   
/*    */   boolean getCheckedOut();
/*    */   
/*    */   void setCheckedOut(boolean paramBoolean);
/*    */   
/*    */   String getInventoryBucketName();
/*    */   
/*    */   void setInventoryBucketName(String paramString);
/*    */   
/*    */   IDataModel getInventoryCountSheetExt();
/*    */   
/*    */   void setInventoryCountSheetExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCountSheetLineItem> getCountSheetLineItems();
/*    */   
/*    */   void setCountSheetLineItems(List<IInventoryCountSheetLineItem> paramList);
/*    */   
/*    */   void addInventoryCountSheetLineItem(IInventoryCountSheetLineItem paramIInventoryCountSheetLineItem);
/*    */   
/*    */   void removeInventoryCountSheetLineItem(IInventoryCountSheetLineItem paramIInventoryCountSheetLineItem);
/*    */   
/*    */   List<IInventoryCountSheetProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCountSheetProperty> paramList);
/*    */   
/*    */   void addInventoryCountSheetProperty(IInventoryCountSheetProperty paramIInventoryCountSheetProperty);
/*    */   
/*    */   void removeInventoryCountSheetProperty(IInventoryCountSheetProperty paramIInventoryCountSheetProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCountSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */