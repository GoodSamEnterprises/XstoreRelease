/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemPrices extends IDataModel, IHasDataProperty<IItemPricesProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 11 */   public static final EventEnum SET_LEVELCODE = new EventEnum("set levelCode");
/* 12 */   public static final EventEnum SET_LEVELVALUE = new EventEnum("set levelValue");
/* 13 */   public static final EventEnum SET_ITEMPRICEPROPERTYCODE = new EventEnum("set itemPricePropertyCode");
/* 14 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 15 */   public static final EventEnum SET_PRICINGQUANTITY = new EventEnum("set pricingQuantity");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 21 */   public static final EventEnum SET_PRICE = new EventEnum("set price");
/* 22 */   public static final EventEnum SET_EXTERNALID = new EventEnum("set externalId");
/* 23 */   public static final EventEnum SET_EXTERNALSYSTEM = new EventEnum("set externalSystem");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getLevelCode();
/*    */   
/*    */   void setLevelCode(String paramString);
/*    */   
/*    */   String getLevelValue();
/*    */   
/*    */   void setLevelValue(String paramString);
/*    */   
/*    */   String getItemPricePropertyCode();
/*    */   
/*    */   void setItemPricePropertyCode(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   BigDecimal getPricingQuantity();
/*    */   
/*    */   void setPricingQuantity(BigDecimal paramBigDecimal);
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
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   BigDecimal getPrice();
/*    */   
/*    */   void setPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getExternalId();
/*    */   
/*    */   void setExternalId(String paramString);
/*    */   
/*    */   String getExternalSystem();
/*    */   
/*    */   void setExternalSystem(String paramString);
/*    */   
/*    */   IDataModel getItemPricesExt();
/*    */   
/*    */   void setItemPricesExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemPricesProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemPricesProperty> paramList);
/*    */   
/*    */   void addItemPricesProperty(IItemPricesProperty paramIItemPricesProperty);
/*    */   
/*    */   void removeItemPricesProperty(IItemPricesProperty paramIItemPricesProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemPrices.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */