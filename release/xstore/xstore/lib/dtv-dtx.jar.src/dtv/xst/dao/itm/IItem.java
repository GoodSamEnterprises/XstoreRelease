/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItem extends IDataModel, IItemModel, IHasDataProperty<IItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 11 */   public static final EventEnum SET_CLASSNAME = new EventEnum("set className");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 17 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_ITEMLEVELCODE = new EventEnum("set itemLevelCode");
/* 20 */   public static final EventEnum SET_ITEMTYPECODE = new EventEnum("set itemTypeCode");
/* 21 */   public static final EventEnum SET_MERCHLEVEL1ID = new EventEnum("set merchLevel1Id");
/* 22 */   public static final EventEnum SET_MERCHLEVEL2ID = new EventEnum("set merchLevel2Id");
/* 23 */   public static final EventEnum SET_MERCHLEVEL3ID = new EventEnum("set merchLevel3Id");
/* 24 */   public static final EventEnum SET_MERCHLEVEL4ID = new EventEnum("set merchLevel4Id");
/* 25 */   public static final EventEnum SET_SERIALIZEDITEM = new EventEnum("set serializedItem");
/* 26 */   public static final EventEnum SET_PARENTITEMID = new EventEnum("set parentItemId");
/* 27 */   public static final EventEnum SET_NAME = new EventEnum("set name");
/* 28 */   public static final EventEnum SET_DISALLOWITEMMATRIXDISPLAY = new EventEnum("set disallowItemMatrixDisplay");
/* 29 */   public static final EventEnum SET_ITEMMATRIXCOLOR = new EventEnum("set itemMatrixColor");
/* 30 */   public static final EventEnum SET_DIMENSIONSYSTEM = new EventEnum("set dimensionSystem");
/* 31 */   public static final EventEnum SET_DIMENSION1 = new EventEnum("set dimension1");
/* 32 */   public static final EventEnum SET_DIMENSION2 = new EventEnum("set dimension2");
/* 33 */   public static final EventEnum SET_DIMENSION3 = new EventEnum("set dimension3");
/* 34 */   public static final EventEnum SET_LISTPRICE = new EventEnum("set listPrice");
/* 35 */   public static final EventEnum SET_MEASUREMENTREQUIRED = new EventEnum("set measurementRequired");
/* 36 */   public static final EventEnum SET_NOTINVENTORIED = new EventEnum("set notInventoried");
/* 37 */   public static final EventEnum SET_EXTERNALSYSTEM = new EventEnum("set externalSystem");
/* 38 */   public static final EventEnum ADD_ITEMOPTIONS = new EventEnum("add ItemOptions");
/* 39 */   public static final EventEnum REMOVE_ITEMOPTIONS = new EventEnum("remove ItemOptions");
/* 40 */   public static final EventEnum SET_ITEMOPTIONS = new EventEnum("set ItemOptions");
/* 41 */   public static final EventEnum SET_PARENTITEM = new EventEnum("set ParentItem");
/* 42 */   public static final EventEnum ADD_ITEMDEALPROPERTIES = new EventEnum("add ItemDealProperties");
/* 43 */   public static final EventEnum REMOVE_ITEMDEALPROPERTIES = new EventEnum("remove ItemDealProperties");
/* 44 */   public static final EventEnum SET_ITEMDEALPROPERTIES = new EventEnum("set ItemDealProperties");
/* 45 */   public static final EventEnum ADD_ITEMPROMPTPROPERTIES = new EventEnum("add ItemPromptProperties");
/* 46 */   public static final EventEnum REMOVE_ITEMPROMPTPROPERTIES = new EventEnum("remove ItemPromptProperties");
/* 47 */   public static final EventEnum SET_ITEMPROMPTPROPERTIES = new EventEnum("set ItemPromptProperties");
/* 48 */   public static final EventEnum SET_ITEMLABELPROPERTIES = new EventEnum("set ItemLabelProperties");
/* 49 */   public static final EventEnum ADD_ITEMIMAGES = new EventEnum("add ItemImages");
/* 50 */   public static final EventEnum REMOVE_ITEMIMAGES = new EventEnum("remove ItemImages");
/* 51 */   public static final EventEnum SET_ITEMIMAGES = new EventEnum("set ItemImages");
/* 52 */   public static final EventEnum ADD_ITEMDIMENSIONTYPES = new EventEnum("add ItemDimensionTypes");
/* 53 */   public static final EventEnum REMOVE_ITEMDIMENSIONTYPES = new EventEnum("remove ItemDimensionTypes");
/* 54 */   public static final EventEnum SET_ITEMDIMENSIONTYPES = new EventEnum("set ItemDimensionTypes");
/* 55 */   public static final EventEnum ADD_ITEMDIMENSIONVALUES = new EventEnum("add ItemDimensionValues");
/* 56 */   public static final EventEnum REMOVE_ITEMDIMENSIONVALUES = new EventEnum("remove ItemDimensionValues");
/* 57 */   public static final EventEnum SET_ITEMDIMENSIONVALUES = new EventEnum("set ItemDimensionValues");
/* 58 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 59 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 60 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 61 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 62 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 63 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getClassName();
/*    */   
/*    */   void setClassName(String paramString);
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
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getItemLevelCode();
/*    */   
/*    */   void setItemLevelCode(String paramString);
/*    */   
/*    */   String getItemTypeCode();
/*    */   
/*    */   void setItemTypeCode(String paramString);
/*    */   
/*    */   String getMerchLevel1Id();
/*    */   
/*    */   void setMerchLevel1Id(String paramString);
/*    */   
/*    */   String getMerchLevel2Id();
/*    */   
/*    */   void setMerchLevel2Id(String paramString);
/*    */   
/*    */   String getMerchLevel3Id();
/*    */   
/*    */   void setMerchLevel3Id(String paramString);
/*    */   
/*    */   String getMerchLevel4Id();
/*    */   
/*    */   void setMerchLevel4Id(String paramString);
/*    */   
/*    */   boolean getSerializedItem();
/*    */   
/*    */   void setSerializedItem(boolean paramBoolean);
/*    */   
/*    */   String getParentItemId();
/*    */   
/*    */   void setParentItemId(String paramString);
/*    */   
/*    */   String getName();
/*    */   
/*    */   void setName(String paramString);
/*    */   
/*    */   boolean getDisallowItemMatrixDisplay();
/*    */   
/*    */   void setDisallowItemMatrixDisplay(boolean paramBoolean);
/*    */   
/*    */   String getItemMatrixColor();
/*    */   
/*    */   void setItemMatrixColor(String paramString);
/*    */   
/*    */   String getDimensionSystem();
/*    */   
/*    */   void setDimensionSystem(String paramString);
/*    */   
/*    */   String getDimension1();
/*    */   
/*    */   void setDimension1(String paramString);
/*    */   
/*    */   String getDimension2();
/*    */   
/*    */   void setDimension2(String paramString);
/*    */   
/*    */   String getDimension3();
/*    */   
/*    */   void setDimension3(String paramString);
/*    */   
/*    */   BigDecimal getListPrice();
/*    */   
/*    */   void setListPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getMeasurementRequired();
/*    */   
/*    */   void setMeasurementRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getNotInventoried();
/*    */   
/*    */   void setNotInventoried(boolean paramBoolean);
/*    */   
/*    */   String getExternalSystem();
/*    */   
/*    */   void setExternalSystem(String paramString);
/*    */   
/*    */   IDataModel getItemExt();
/*    */   
/*    */   void setItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemOptions> getItemOptions();
/*    */   
/*    */   void setItemOptions(List<IItemOptions> paramList);
/*    */   
/*    */   void addItemOptions(IItemOptions paramIItemOptions);
/*    */   
/*    */   void removeItemOptions(IItemOptions paramIItemOptions);
/*    */   
/*    */   IItem getParentItem();
/*    */   
/*    */   void setParentItem(IItem paramIItem);
/*    */   
/*    */   List<IItemDealProperty> getItemDealProperties();
/*    */   
/*    */   void setItemDealProperties(List<IItemDealProperty> paramList);
/*    */   
/*    */   void addItemDealProperty(IItemDealProperty paramIItemDealProperty);
/*    */   
/*    */   void removeItemDealProperty(IItemDealProperty paramIItemDealProperty);
/*    */   
/*    */   List<IItemPromptProperty> getItemPromptProperties();
/*    */   
/*    */   void setItemPromptProperties(List<IItemPromptProperty> paramList);
/*    */   
/*    */   void addItemPromptProperty(IItemPromptProperty paramIItemPromptProperty);
/*    */   
/*    */   void removeItemPromptProperty(IItemPromptProperty paramIItemPromptProperty);
/*    */   
/*    */   IItemLabelProperties getItemLabelProperties();
/*    */   
/*    */   void setItemLabelProperties(IItemLabelProperties paramIItemLabelProperties);
/*    */   
/*    */   List<IItemImage> getItemImages();
/*    */   
/*    */   void setItemImages(List<IItemImage> paramList);
/*    */   
/*    */   void addItemImage(IItemImage paramIItemImage);
/*    */   
/*    */   void removeItemImage(IItemImage paramIItemImage);
/*    */   
/*    */   List<IItemDimensionType> getItemDimensionTypes();
/*    */   
/*    */   void setItemDimensionTypes(List<IItemDimensionType> paramList);
/*    */   
/*    */   void addItemDimensionType(IItemDimensionType paramIItemDimensionType);
/*    */   
/*    */   void removeItemDimensionType(IItemDimensionType paramIItemDimensionType);
/*    */   
/*    */   List<IItemDimensionValue> getItemDimensionValues();
/*    */   
/*    */   void setItemDimensionValues(List<IItemDimensionValue> paramList);
/*    */   
/*    */   void addItemDimensionValue(IItemDimensionValue paramIItemDimensionValue);
/*    */   
/*    */   void removeItemDimensionValue(IItemDimensionValue paramIItemDimensionValue);
/*    */   
/*    */   List<IItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemProperty> paramList);
/*    */   
/*    */   void addItemProperty(IItemProperty paramIItemProperty);
/*    */   
/*    */   void removeItemProperty(IItemProperty paramIItemProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */