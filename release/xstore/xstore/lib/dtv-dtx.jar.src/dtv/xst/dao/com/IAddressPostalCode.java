/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IAddressPostalCode extends IDataModel, IHasDataProperty<IAddressPostalCodeProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_COUNTRYID = new EventEnum("set countryId");
/* 11 */   public static final EventEnum SET_POSTALCODEID = new EventEnum("set postalCodeId");
/* 12 */   public static final EventEnum SET_ADDRESSMODE = new EventEnum("set addressMode");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_POSTALCODE = new EventEnum("set postalCode");
/* 18 */   public static final EventEnum SET_STATEID = new EventEnum("set stateId");
/* 19 */   public static final EventEnum SET_CITYNAME = new EventEnum("set cityName");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCountryId();
/*    */   
/*    */   void setCountryId(String paramString);
/*    */   
/*    */   String getPostalCodeId();
/*    */   
/*    */   void setPostalCodeId(String paramString);
/*    */   
/*    */   String getAddressMode();
/*    */   
/*    */   void setAddressMode(String paramString);
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
/*    */   String getPostalCode();
/*    */   
/*    */   void setPostalCode(String paramString);
/*    */   
/*    */   String getStateId();
/*    */   
/*    */   void setStateId(String paramString);
/*    */   
/*    */   String getCityName();
/*    */   
/*    */   void setCityName(String paramString);
/*    */   
/*    */   IDataModel getAddressPostalCodeExt();
/*    */   
/*    */   void setAddressPostalCodeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IAddressPostalCodeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IAddressPostalCodeProperty> paramList);
/*    */   
/*    */   void addAddressPostalCodeProperty(IAddressPostalCodeProperty paramIAddressPostalCodeProperty);
/*    */   
/*    */   void removeAddressPostalCodeProperty(IAddressPostalCodeProperty paramIAddressPostalCodeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IAddressPostalCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */