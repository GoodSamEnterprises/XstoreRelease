/*    */ package dtv.xst.dao.dsc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDiscountGroupMapping extends IDataModel, IHasDataProperty<IDiscountGroupMappingProperty> {
/*  9 */   public static final EventEnum SET_CUSTOMERGROUPID = new EventEnum("set customerGroupId");
/* 10 */   public static final EventEnum SET_DISCOUNTCODE = new EventEnum("set discountCode");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_CONFIGELEMENT = new EventEnum("set configElement");
/* 17 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 18 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 19 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 20 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 21 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 22 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getCustomerGroupId();
/*    */   
/*    */   void setCustomerGroupId(String paramString);
/*    */   
/*    */   String getDiscountCode();
/*    */   
/*    */   void setDiscountCode(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
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
/*    */   String getConfigElement();
/*    */   
/*    */   void setConfigElement(String paramString);
/*    */   
/*    */   IDataModel getDiscountGroupMappingExt();
/*    */   
/*    */   void setDiscountGroupMappingExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDiscountGroupMappingProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDiscountGroupMappingProperty> paramList);
/*    */   
/*    */   void addDiscountGroupMappingProperty(IDiscountGroupMappingProperty paramIDiscountGroupMappingProperty);
/*    */   
/*    */   void removeDiscountGroupMappingProperty(IDiscountGroupMappingProperty paramIDiscountGroupMappingProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\IDiscountGroupMapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */