/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemDimensionValue extends IDataModel, IDimensionSummary, IHasDataProperty<IItemDimensionValueProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DIMENSIONSYSTEM = new EventEnum("set dimensionSystem");
/* 11 */   public static final EventEnum SET_DIMENSION = new EventEnum("set dimension");
/* 12 */   public static final EventEnum SET_DIMENSIONVALUE = new EventEnum("set dimensionValue");
/* 13 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 14 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
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
/*    */   String getDimensionSystem();
/*    */   
/*    */   void setDimensionSystem(String paramString);
/*    */   
/*    */   String getDimension();
/*    */   
/*    */   void setDimension(String paramString);
/*    */   
/*    */   String getDimensionValue();
/*    */   
/*    */   void setDimensionValue(String paramString);
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
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   IDataModel getItemDimensionValueExt();
/*    */   
/*    */   void setItemDimensionValueExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemDimensionValueProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemDimensionValueProperty> paramList);
/*    */   
/*    */   void addItemDimensionValueProperty(IItemDimensionValueProperty paramIItemDimensionValueProperty);
/*    */   
/*    */   void removeItemDimensionValueProperty(IItemDimensionValueProperty paramIItemDimensionValueProperty);
/*    */   
/*    */   void setParentDimensionType(IItemDimensionType paramIItemDimensionType);
/*    */   
/*    */   IItemDimensionType getParentDimensionType();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemDimensionValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */