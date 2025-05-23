/*    */ package dtv.xst.dao.tax;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPostalCodeMapping extends IDataModel, IHasDataProperty<IPostalCodeMappingProperty> {
/*  9 */   public static final EventEnum SET_CITY = new EventEnum("set city");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_POSTALCODE = new EventEnum("set postalCode");
/* 12 */   public static final EventEnum SET_TAXLOCATIONID = new EventEnum("set taxLocationId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_POSTALTAXLOCATION = new EventEnum("set PostalTaxLocation");
/* 18 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 19 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 20 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 21 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 22 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 23 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getCity();
/*    */   
/*    */   void setCity(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getPostalCode();
/*    */   
/*    */   void setPostalCode(String paramString);
/*    */   
/*    */   String getTaxLocationId();
/*    */   
/*    */   void setTaxLocationId(String paramString);
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
/*    */   IDataModel getPostalCodeMappingExt();
/*    */   
/*    */   void setPostalCodeMappingExt(IDataModel paramIDataModel);
/*    */   
/*    */   ITaxLocation getPostalTaxLocation();
/*    */   
/*    */   void setPostalTaxLocation(ITaxLocation paramITaxLocation);
/*    */   
/*    */   List<IPostalCodeMappingProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPostalCodeMappingProperty> paramList);
/*    */   
/*    */   void addPostalCodeMappingProperty(IPostalCodeMappingProperty paramIPostalCodeMappingProperty);
/*    */   
/*    */   void removePostalCodeMappingProperty(IPostalCodeMappingProperty paramIPostalCodeMappingProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\IPostalCodeMapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */