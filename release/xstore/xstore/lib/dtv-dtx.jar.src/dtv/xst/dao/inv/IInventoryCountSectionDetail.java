/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IHasDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCountSectionDetail extends IDataModel, IHasDataProperty<IInventoryCountSectionDetailProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_INVENTORYBUCKETID = new EventEnum("set inventoryBucketId");
/* 12 */   public static final EventEnum SET_SECTIONID = new EventEnum("set sectionId");
/* 13 */   public static final EventEnum SET_SECTIONDETAILNUMBER = new EventEnum("set sectionDetailNumber");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_MERCHANDISEHIERARCHYLEVEL = new EventEnum("set merchandiseHierarchyLevel");
/* 19 */   public static final EventEnum SET_MERCHANDISEHIERARCHYID = new EventEnum("set merchandiseHierarchyId");
/* 20 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
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
/*    */   String getInventoryBucketId();
/*    */   
/*    */   void setInventoryBucketId(String paramString);
/*    */   
/*    */   String getSectionId();
/*    */   
/*    */   void setSectionId(String paramString);
/*    */   
/*    */   int getSectionDetailNumber();
/*    */   
/*    */   void setSectionDetailNumber(int paramInt);
/*    */   
/*    */   String getMerchandiseHierarchyLevel();
/*    */   
/*    */   void setMerchandiseHierarchyLevel(String paramString);
/*    */   
/*    */   String getMerchandiseHierarchyId();
/*    */   
/*    */   void setMerchandiseHierarchyId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   IDataModel getInventoryCountSectionDetailExt();
/*    */   
/*    */   void setInventoryCountSectionDetailExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCountSectionDetailProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCountSectionDetailProperty> paramList);
/*    */   
/*    */   void addInventoryCountSectionDetailProperty(IInventoryCountSectionDetailProperty paramIInventoryCountSectionDetailProperty);
/*    */   
/*    */   void removeInventoryCountSectionDetailProperty(IInventoryCountSectionDetailProperty paramIInventoryCountSectionDetailProperty);
/*    */   
/*    */   void setParentSection(IInventoryCountSection paramIInventoryCountSection);
/*    */   
/*    */   IInventoryCountSection getParentSection();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCountSectionDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */