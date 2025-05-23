/*    */ package dtv.xst.dao.loc;public interface IOrgHierarchy extends IDataModel, IHierarchyElement, IHasDataProperty<IOrgHierarchyProperty> { void setDAO(IDataAccessObject paramIDataAccessObject); long getOrganizationId(); void setOrganizationId(long paramLong); String getLevelCode(); void setLevelCode(String paramString); String getLevelValue(); void setLevelValue(String paramString); Date getCreateDate(); void setCreateDate(Date paramDate); String getCreateUserId(); void setCreateUserId(String paramString); Date getUpdateDate(); void setUpdateDate(Date paramDate);
/*    */   String getUpdateUserId();
/*    */   void setUpdateUserId(String paramString);
/*    */   String getParentCode();
/*    */   void setParentCode(String paramString);
/*    */   String getParentValue();
/*    */   void setParentValue(String paramString);
/*    */   String getDescription();
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId"); void setDescription(String paramString); String getLevelManager(); void setLevelManager(String paramString); int getLevelOrder(); void setLevelOrder(int paramInt); int getSortOrder(); void setSortOrder(int paramInt); boolean getInactive(); void setInactive(boolean paramBoolean); IDataModel getOrgHierarchyExt(); void setOrgHierarchyExt(IDataModel paramIDataModel); IOrgHierarchy getParentElement(); void setParentElement(IOrgHierarchy paramIOrgHierarchy); List<IOrgHierarchyProperty> getProperties(); void setProperties(List<IOrgHierarchyProperty> paramList); void addOrgHierarchyProperty(IOrgHierarchyProperty paramIOrgHierarchyProperty); void removeOrgHierarchyProperty(IOrgHierarchyProperty paramIOrgHierarchyProperty); void startTransaction(); void rollbackChanges(); void commitTransaction();
/* 10 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 11 */   public static final EventEnum SET_LEVELVALUE = new EventEnum("set levelValue");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_PARENTCODE = new EventEnum("set parentCode");
/* 17 */   public static final EventEnum SET_PARENTVALUE = new EventEnum("set parentValue");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_LEVELMANAGER = new EventEnum("set levelManager");
/* 20 */   public static final EventEnum SET_LEVELORDER = new EventEnum("set levelOrder");
/* 21 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 22 */   public static final EventEnum SET_INACTIVE = new EventEnum("set inactive");
/* 23 */   public static final EventEnum SET_PARENTELEMENT = new EventEnum("set ParentElement");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction"); }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\IOrgHierarchy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */