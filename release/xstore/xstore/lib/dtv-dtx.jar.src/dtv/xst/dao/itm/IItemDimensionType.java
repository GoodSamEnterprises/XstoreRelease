/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemDimensionType extends IDataModel, ISortable, IHasDataProperty<IItemDimensionTypeProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DIMENSIONSYSTEM = new EventEnum("set dimensionSystem");
/* 11 */   public static final EventEnum SET_DIMENSION = new EventEnum("set dimension");
/* 12 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 13 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 19 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 20 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 21 */   public static final EventEnum SET_PROMPTMESSAGE = new EventEnum("set promptMessage");
/* 22 */   public static final EventEnum ADD_DIMENSIONVALUES = new EventEnum("add DimensionValues");
/* 23 */   public static final EventEnum REMOVE_DIMENSIONVALUES = new EventEnum("remove DimensionValues");
/* 24 */   public static final EventEnum SET_DIMENSIONVALUES = new EventEnum("set DimensionValues");
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
/*    */   String getDimensionSystem();
/*    */   
/*    */   void setDimensionSystem(String paramString);
/*    */   
/*    */   String getDimension();
/*    */   
/*    */   void setDimension(String paramString);
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
/*    */   int getSequence();
/*    */   
/*    */   void setSequence(int paramInt);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getPromptMessage();
/*    */   
/*    */   void setPromptMessage(String paramString);
/*    */   
/*    */   IDataModel getItemDimensionTypeExt();
/*    */   
/*    */   void setItemDimensionTypeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemDimensionValue> getDimensionValues();
/*    */   
/*    */   void setDimensionValues(List<IItemDimensionValue> paramList);
/*    */   
/*    */   void addDimensionValue(IItemDimensionValue paramIItemDimensionValue);
/*    */   
/*    */   void removeDimensionValue(IItemDimensionValue paramIItemDimensionValue);
/*    */   
/*    */   List<IItemDimensionTypeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemDimensionTypeProperty> paramList);
/*    */   
/*    */   void addItemDimensionTypeProperty(IItemDimensionTypeProperty paramIItemDimensionTypeProperty);
/*    */   
/*    */   void removeItemDimensionTypeProperty(IItemDimensionTypeProperty paramIItemDimensionTypeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemDimensionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */