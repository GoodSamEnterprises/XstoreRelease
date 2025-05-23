/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemRestriction extends IDataModel, IItemRestrictionModel, IHasDataProperty<IItemRestrictionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RESTRICTIONCATEGORY = new EventEnum("set restrictionCategory");
/* 11 */   public static final EventEnum SET_RESTRICTIONCODE = new EventEnum("set restrictionCode");
/* 12 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 13 */   public static final EventEnum SET_SALELINEITEMTYPECODE = new EventEnum("set saleLineItemTypeCode");
/* 14 */   public static final EventEnum SET_PROPERTYNAME = new EventEnum("set propertyName");
/* 15 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 16 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 17 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 18 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 19 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 20 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 21 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 22 */   public static final EventEnum SET_BOOLEANVALUE = new EventEnum("set booleanValue");
/* 23 */   public static final EventEnum SET_STRINGVALUE = new EventEnum("set stringValue");
/* 24 */   public static final EventEnum SET_DATEVALUE = new EventEnum("set dateValue");
/* 25 */   public static final EventEnum SET_DECIMALVALUE = new EventEnum("set decimalValue");
/* 26 */   public static final EventEnum SET_ONCALENDAR = new EventEnum("set onCalendar");
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
/*    */   String getRestrictionCategory();
/*    */   
/*    */   void setRestrictionCategory(String paramString);
/*    */   
/*    */   String getRestrictionCode();
/*    */   
/*    */   void setRestrictionCode(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   String getSaleLineItemTypeCode();
/*    */   
/*    */   void setSaleLineItemTypeCode(String paramString);
/*    */   
/*    */   String getPropertyName();
/*    */   
/*    */   void setPropertyName(String paramString);
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
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   boolean getOnCalendar();
/*    */   
/*    */   void setOnCalendar(boolean paramBoolean);
/*    */   
/*    */   IDataModel getItemRestrictionExt();
/*    */   
/*    */   void setItemRestrictionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IItemRestrictionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemRestrictionProperty> paramList);
/*    */   
/*    */   void addItemRestrictionProperty(IItemRestrictionProperty paramIItemRestrictionProperty);
/*    */   
/*    */   void removeItemRestrictionProperty(IItemRestrictionProperty paramIItemRestrictionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemRestriction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */