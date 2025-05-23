/*    */ package dtv.xst.dao.dsc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDiscountTypeEligibility extends IDataModel, IHasConfigElement, IHasDataProperty<IDiscountTypeEligibilityProperty> {
/*  9 */   public static final EventEnum SET_DISCOUNTCODE = new EventEnum("set discountCode");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_SALELINEITEMTYPECODE = new EventEnum("set saleLineItemTypeCode");
/* 12 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 18 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 19 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 20 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 21 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 22 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getDiscountCode();
/*    */   
/*    */   void setDiscountCode(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getSaleLineItemTypeCode();
/*    */   
/*    */   void setSaleLineItemTypeCode(String paramString);
/*    */   
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
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
/*    */   IDataModel getDiscountTypeEligibilityExt();
/*    */   
/*    */   void setDiscountTypeEligibilityExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDiscountTypeEligibilityProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDiscountTypeEligibilityProperty> paramList);
/*    */   
/*    */   void addDiscountTypeEligibilityProperty(IDiscountTypeEligibilityProperty paramIDiscountTypeEligibilityProperty);
/*    */   
/*    */   void removeDiscountTypeEligibilityProperty(IDiscountTypeEligibilityProperty paramIDiscountTypeEligibilityProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\IDiscountTypeEligibility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */