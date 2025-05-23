/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IHasDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCountSection extends IDataModel, IHasDataProperty<IInventoryCountSectionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_INVENTORYBUCKETID = new EventEnum("set inventoryBucketId");
/* 12 */   public static final EventEnum SET_SECTIONID = new EventEnum("set sectionId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 18 */   public static final EventEnum SET_INVENTORYBUCKETNAME = new EventEnum("set inventoryBucketName");
/* 19 */   public static final EventEnum ADD_SECTIONDETAILS = new EventEnum("add SectionDetails");
/* 20 */   public static final EventEnum REMOVE_SECTIONDETAILS = new EventEnum("remove SectionDetails");
/* 21 */   public static final EventEnum SET_SECTIONDETAILS = new EventEnum("set SectionDetails");
/* 22 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 23 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 24 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 25 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 26 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 27 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getInventoryBucketId();
/*    */   
/*    */   void setInventoryBucketId(String paramString);
/*    */   
/*    */   String getSectionId();
/*    */   
/*    */   void setSectionId(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getInventoryBucketName();
/*    */   
/*    */   void setInventoryBucketName(String paramString);
/*    */   
/*    */   IDataModel getInventoryCountSectionExt();
/*    */   
/*    */   void setInventoryCountSectionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCountSectionDetail> getSectionDetails();
/*    */   
/*    */   void setSectionDetails(List<IInventoryCountSectionDetail> paramList);
/*    */   
/*    */   void addInventoryCountSectionDetail(IInventoryCountSectionDetail paramIInventoryCountSectionDetail);
/*    */   
/*    */   void removeInventoryCountSectionDetail(IInventoryCountSectionDetail paramIInventoryCountSectionDetail);
/*    */   
/*    */   List<IInventoryCountSectionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCountSectionProperty> paramList);
/*    */   
/*    */   void addInventoryCountSectionProperty(IInventoryCountSectionProperty paramIInventoryCountSectionProperty);
/*    */   
/*    */   void removeInventoryCountSectionProperty(IInventoryCountSectionProperty paramIInventoryCountSectionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCountSection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */