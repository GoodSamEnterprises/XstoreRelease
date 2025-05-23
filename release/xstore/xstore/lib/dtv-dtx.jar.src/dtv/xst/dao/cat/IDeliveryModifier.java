/*    */ package dtv.xst.dao.cat;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDeliveryModifier extends IDataModel, IDeliveryModifierModel, IHasDataProperty<IDeliveryModifierProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_DELIVERYTYPE = new EventEnum("set deliveryType");
/* 17 */   public static final EventEnum SET_FIRSTNAME = new EventEnum("set firstName");
/* 18 */   public static final EventEnum SET_MIDDLENAME = new EventEnum("set middleName");
/* 19 */   public static final EventEnum SET_LASTNAME = new EventEnum("set lastName");
/* 20 */   public static final EventEnum SET_ADDRESS1 = new EventEnum("set address1");
/* 21 */   public static final EventEnum SET_ADDRESS2 = new EventEnum("set address2");
/* 22 */   public static final EventEnum SET_ADDRESS3 = new EventEnum("set address3");
/* 23 */   public static final EventEnum SET_ADDRESS4 = new EventEnum("set address4");
/* 24 */   public static final EventEnum SET_APARTMENT = new EventEnum("set apartment");
/* 25 */   public static final EventEnum SET_CITY = new EventEnum("set city");
/* 26 */   public static final EventEnum SET_STATE = new EventEnum("set state");
/* 27 */   public static final EventEnum SET_POSTALCODE = new EventEnum("set postalCode");
/* 28 */   public static final EventEnum SET_COUNTRY = new EventEnum("set country");
/* 29 */   public static final EventEnum SET_TELEPHONE1 = new EventEnum("set telephone1");
/* 30 */   public static final EventEnum SET_TELEPHONE2 = new EventEnum("set telephone2");
/* 31 */   public static final EventEnum SET_TELEPHONE3 = new EventEnum("set telephone3");
/* 32 */   public static final EventEnum SET_TELEPHONE4 = new EventEnum("set telephone4");
/* 33 */   public static final EventEnum SET_SHIPPINGMETHOD = new EventEnum("set shippingMethod");
/* 34 */   public static final EventEnum SET_TRACKINGNUMBER = new EventEnum("set trackingNumber");
/* 35 */   public static final EventEnum SET_INSTRUCTIONS = new EventEnum("set instructions");
/* 36 */   public static final EventEnum SET_EXTENSION = new EventEnum("set extension");
/* 37 */   public static final EventEnum SET_DELIVERYDATE = new EventEnum("set deliveryDate");
/* 38 */   public static final EventEnum SET_STARTTIME = new EventEnum("set startTime");
/* 39 */   public static final EventEnum SET_ENDTIME = new EventEnum("set endTime");
/* 40 */   public static final EventEnum SET_GEOCODE = new EventEnum("set geoCode");
/* 41 */   public static final EventEnum SET_NEIGHBORHOOD = new EventEnum("set neighborhood");
/* 42 */   public static final EventEnum SET_COUNTY = new EventEnum("set county");
/* 43 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 44 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 45 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 46 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 47 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 48 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
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
/*    */   String getDeliveryType();
/*    */   
/*    */   void setDeliveryType(String paramString);
/*    */   
/*    */   String getFirstName();
/*    */   
/*    */   void setFirstName(String paramString);
/*    */   
/*    */   String getMiddleName();
/*    */   
/*    */   void setMiddleName(String paramString);
/*    */   
/*    */   String getLastName();
/*    */   
/*    */   void setLastName(String paramString);
/*    */   
/*    */   String getAddress1();
/*    */   
/*    */   void setAddress1(String paramString);
/*    */   
/*    */   String getAddress2();
/*    */   
/*    */   void setAddress2(String paramString);
/*    */   
/*    */   String getAddress3();
/*    */   
/*    */   void setAddress3(String paramString);
/*    */   
/*    */   String getAddress4();
/*    */   
/*    */   void setAddress4(String paramString);
/*    */   
/*    */   String getApartment();
/*    */   
/*    */   void setApartment(String paramString);
/*    */   
/*    */   String getCity();
/*    */   
/*    */   void setCity(String paramString);
/*    */   
/*    */   String getState();
/*    */   
/*    */   void setState(String paramString);
/*    */   
/*    */   String getPostalCode();
/*    */   
/*    */   void setPostalCode(String paramString);
/*    */   
/*    */   String getCountry();
/*    */   
/*    */   void setCountry(String paramString);
/*    */   
/*    */   String getTelephone1();
/*    */   
/*    */   void setTelephone1(String paramString);
/*    */   
/*    */   String getTelephone2();
/*    */   
/*    */   void setTelephone2(String paramString);
/*    */   
/*    */   String getTelephone3();
/*    */   
/*    */   void setTelephone3(String paramString);
/*    */   
/*    */   String getTelephone4();
/*    */   
/*    */   void setTelephone4(String paramString);
/*    */   
/*    */   String getShippingMethod();
/*    */   
/*    */   void setShippingMethod(String paramString);
/*    */   
/*    */   String getTrackingNumber();
/*    */   
/*    */   void setTrackingNumber(String paramString);
/*    */   
/*    */   String getInstructions();
/*    */   
/*    */   void setInstructions(String paramString);
/*    */   
/*    */   String getExtension();
/*    */   
/*    */   void setExtension(String paramString);
/*    */   
/*    */   Date getDeliveryDate();
/*    */   
/*    */   void setDeliveryDate(Date paramDate);
/*    */   
/*    */   Date getStartTime();
/*    */   
/*    */   void setStartTime(Date paramDate);
/*    */   
/*    */   Date getEndTime();
/*    */   
/*    */   void setEndTime(Date paramDate);
/*    */   
/*    */   String getGeoCode();
/*    */   
/*    */   void setGeoCode(String paramString);
/*    */   
/*    */   String getNeighborhood();
/*    */   
/*    */   void setNeighborhood(String paramString);
/*    */   
/*    */   String getCounty();
/*    */   
/*    */   void setCounty(String paramString);
/*    */   
/*    */   IDataModel getDeliveryModifierExt();
/*    */   
/*    */   void setDeliveryModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDeliveryModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDeliveryModifierProperty> paramList);
/*    */   
/*    */   void addDeliveryModifierProperty(IDeliveryModifierProperty paramIDeliveryModifierProperty);
/*    */   
/*    */   void removeDeliveryModifierProperty(IDeliveryModifierProperty paramIDeliveryModifierProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IDeliveryModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */