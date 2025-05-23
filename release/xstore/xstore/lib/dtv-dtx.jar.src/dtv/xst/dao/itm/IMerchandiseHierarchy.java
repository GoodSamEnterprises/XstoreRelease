/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IMerchandiseHierarchy extends IDataModel, IMerchandiseHierarchyModel, IHasDataProperty<IMerchandiseHierarchyProperty> {
/*  9 */   public static final EventEnum SET_HIERARCHYID = new EventEnum("set hierarchyId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_PARENTID = new EventEnum("set parentId");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 20 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 21 */   public static final EventEnum SET_HIDDEN = new EventEnum("set hidden");
/* 22 */   public static final EventEnum SET_DISALLOWITEMMATRIXDISPLAY = new EventEnum("set disallowItemMatrixDisplay");
/* 23 */   public static final EventEnum SET_ITEMMATRIXCOLOR = new EventEnum("set itemMatrixColor");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getHierarchyId();
/*    */   
/*    */   void setHierarchyId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
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
/*    */   String getParentId();
/*    */   
/*    */   void setParentId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getLevelCode();
/*    */   
/*    */   void setLevelCode(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   boolean getHidden();
/*    */   
/*    */   void setHidden(boolean paramBoolean);
/*    */   
/*    */   boolean getDisallowItemMatrixDisplay();
/*    */   
/*    */   void setDisallowItemMatrixDisplay(boolean paramBoolean);
/*    */   
/*    */   String getItemMatrixColor();
/*    */   
/*    */   void setItemMatrixColor(String paramString);
/*    */   
/*    */   IDataModel getMerchandiseHierarchyExt();
/*    */   
/*    */   void setMerchandiseHierarchyExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IMerchandiseHierarchyProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IMerchandiseHierarchyProperty> paramList);
/*    */   
/*    */   void addMerchandiseHierarchyProperty(IMerchandiseHierarchyProperty paramIMerchandiseHierarchyProperty);
/*    */   
/*    */   void removeMerchandiseHierarchyProperty(IMerchandiseHierarchyProperty paramIMerchandiseHierarchyProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IMerchandiseHierarchy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */