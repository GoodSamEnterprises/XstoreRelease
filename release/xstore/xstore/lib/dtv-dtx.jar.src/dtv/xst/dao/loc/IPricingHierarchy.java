/*    */ package dtv.xst.dao.loc;public interface IPricingHierarchy extends IDataModel, IHierarchyElement, IHasDataProperty<IPricingHierarchyProperty> { void setDAO(IDataAccessObject paramIDataAccessObject); long getOrganizationId(); void setOrganizationId(long paramLong); String getLevelCode(); void setLevelCode(String paramString); String getLevelValue(); void setLevelValue(String paramString); Date getCreateDate(); void setCreateDate(Date paramDate); String getCreateUserId(); void setCreateUserId(String paramString);
/*    */   Date getUpdateDate();
/*    */   void setUpdateDate(Date paramDate);
/*    */   String getUpdateUserId();
/*    */   void setUpdateUserId(String paramString);
/*    */   String getParentCode();
/*    */   void setParentCode(String paramString);
/*    */   String getParentValue();
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId"); void setParentValue(String paramString); String getDescription(); void setDescription(String paramString); int getLevelOrder(); void setLevelOrder(int paramInt); int getSortOrder(); void setSortOrder(int paramInt); IDataModel getPricingHierarchyExt(); void setPricingHierarchyExt(IDataModel paramIDataModel); IPricingHierarchy getParentElement(); void setParentElement(IPricingHierarchy paramIPricingHierarchy); List<IPricingHierarchyProperty> getProperties(); void setProperties(List<IPricingHierarchyProperty> paramList); void addPricingHierarchyProperty(IPricingHierarchyProperty paramIPricingHierarchyProperty); void removePricingHierarchyProperty(IPricingHierarchyProperty paramIPricingHierarchyProperty); void startTransaction(); void rollbackChanges(); void commitTransaction();
/* 10 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 11 */   public static final EventEnum SET_LEVELVALUE = new EventEnum("set levelValue");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_PARENTCODE = new EventEnum("set parentCode");
/* 17 */   public static final EventEnum SET_PARENTVALUE = new EventEnum("set parentValue");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_LEVELORDER = new EventEnum("set levelOrder");
/* 20 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 21 */   public static final EventEnum SET_PARENTELEMENT = new EventEnum("set ParentElement");
/* 22 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 23 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 24 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 25 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 26 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 27 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction"); }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\IPricingHierarchy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */