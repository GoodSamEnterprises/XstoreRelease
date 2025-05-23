/*    */ package dtv.xst.dao.loc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IRetailLocation extends IDataModel, IRetailLocationModel, IHasDataProperty<IRetailLocationProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ADDRESS1 = new EventEnum("set address1");
/* 16 */   public static final EventEnum SET_ADDRESS2 = new EventEnum("set address2");
/* 17 */   public static final EventEnum SET_ADDRESS3 = new EventEnum("set address3");
/* 18 */   public static final EventEnum SET_ADDRESS4 = new EventEnum("set address4");
/* 19 */   public static final EventEnum SET_APARTMENT = new EventEnum("set apartment");
/* 20 */   public static final EventEnum SET_CITY = new EventEnum("set city");
/* 21 */   public static final EventEnum SET_COUNTRY = new EventEnum("set country");
/* 22 */   public static final EventEnum SET_LOCALE = new EventEnum("set locale");
/* 23 */   public static final EventEnum SET_CURRENCYID = new EventEnum("set currencyId");
/* 24 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 25 */   public static final EventEnum SET_POSTALCODE = new EventEnum("set postalCode");
/* 26 */   public static final EventEnum SET_STATE = new EventEnum("set state");
/* 27 */   public static final EventEnum SET_STORENAME = new EventEnum("set storeName");
/* 28 */   public static final EventEnum SET_STORENBR = new EventEnum("set storeNbr");
/* 29 */   public static final EventEnum SET_ALTERNATESTORENBR = new EventEnum("set alternateStoreNbr");
/* 30 */   public static final EventEnum SET_TELEPHONE1 = new EventEnum("set telephone1");
/* 31 */   public static final EventEnum SET_TELEPHONE2 = new EventEnum("set telephone2");
/* 32 */   public static final EventEnum SET_TELEPHONE3 = new EventEnum("set telephone3");
/* 33 */   public static final EventEnum SET_TELEPHONE4 = new EventEnum("set telephone4");
/* 34 */   public static final EventEnum SET_LATITUDE = new EventEnum("set latitude");
/* 35 */   public static final EventEnum SET_LONGITUDE = new EventEnum("set longitude");
/* 36 */   public static final EventEnum SET_DEFAULTTAXPERCENTAGE = new EventEnum("set defaultTaxPercentage");
/* 37 */   public static final EventEnum SET_STOREMANAGER = new EventEnum("set storeManager");
/* 38 */   public static final EventEnum SET_LOCATIONTYPE = new EventEnum("set locationType");
/* 39 */   public static final EventEnum SET_DELIVERYAVAILABLE = new EventEnum("set deliveryAvailable");
/* 40 */   public static final EventEnum SET_PICKUPAVAILABLE = new EventEnum("set pickupAvailable");
/* 41 */   public static final EventEnum SET_TRANSFERAVAILABLE = new EventEnum("set transferAvailable");
/* 42 */   public static final EventEnum SET_EMAILADDRESS = new EventEnum("set emailAddress");
/* 43 */   public static final EventEnum SET_GEOCODE = new EventEnum("set geoCode");
/* 44 */   public static final EventEnum SET_UEZINDICATOR = new EventEnum("set uezIndicator");
/* 45 */   public static final EventEnum SET_DISTRICT = new EventEnum("set district");
/* 46 */   public static final EventEnum SET_AREA = new EventEnum("set area");
/* 47 */   public static final EventEnum SET_USETILLACCOUNTABILITY = new EventEnum("set useTillAccountability");
/* 48 */   public static final EventEnum SET_DEPOSITBANKNAME = new EventEnum("set depositBankName");
/* 49 */   public static final EventEnum SET_DEPOSITBANKACCTNBR = new EventEnum("set depositBankAcctNbr");
/* 50 */   public static final EventEnum SET_NEIGHBORHOOD = new EventEnum("set neighborhood");
/* 51 */   public static final EventEnum SET_COUNTY = new EventEnum("set county");
/* 52 */   public static final EventEnum SET_AIRPORTCODE = new EventEnum("set airportCode");
/* 53 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 54 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 55 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 56 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 57 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 58 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
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
/*    */   String getCountry();
/*    */   
/*    */   void setCountry(String paramString);
/*    */   
/*    */   String getLocale();
/*    */   
/*    */   void setLocale(String paramString);
/*    */   
/*    */   String getCurrencyId();
/*    */   
/*    */   void setCurrencyId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getPostalCode();
/*    */   
/*    */   void setPostalCode(String paramString);
/*    */   
/*    */   String getState();
/*    */   
/*    */   void setState(String paramString);
/*    */   
/*    */   String getStoreName();
/*    */   
/*    */   void setStoreName(String paramString);
/*    */   
/*    */   String getStoreNbr();
/*    */   
/*    */   void setStoreNbr(String paramString);
/*    */   
/*    */   String getAlternateStoreNbr();
/*    */   
/*    */   void setAlternateStoreNbr(String paramString);
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
/*    */   BigDecimal getLatitude();
/*    */   
/*    */   void setLatitude(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getLongitude();
/*    */   
/*    */   void setLongitude(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getDefaultTaxPercentage();
/*    */   
/*    */   void setDefaultTaxPercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getStoreManager();
/*    */   
/*    */   void setStoreManager(String paramString);
/*    */   
/*    */   String getLocationType();
/*    */   
/*    */   void setLocationType(String paramString);
/*    */   
/*    */   boolean getDeliveryAvailable();
/*    */   
/*    */   void setDeliveryAvailable(boolean paramBoolean);
/*    */   
/*    */   boolean getPickupAvailable();
/*    */   
/*    */   void setPickupAvailable(boolean paramBoolean);
/*    */   
/*    */   boolean getTransferAvailable();
/*    */   
/*    */   void setTransferAvailable(boolean paramBoolean);
/*    */   
/*    */   String getEmailAddress();
/*    */   
/*    */   void setEmailAddress(String paramString);
/*    */   
/*    */   String getGeoCode();
/*    */   
/*    */   void setGeoCode(String paramString);
/*    */   
/*    */   boolean getUezIndicator();
/*    */   
/*    */   void setUezIndicator(boolean paramBoolean);
/*    */   
/*    */   String getDistrict();
/*    */   
/*    */   void setDistrict(String paramString);
/*    */   
/*    */   String getArea();
/*    */   
/*    */   void setArea(String paramString);
/*    */   
/*    */   boolean getUseTillAccountability();
/*    */   
/*    */   void setUseTillAccountability(boolean paramBoolean);
/*    */   
/*    */   String getDepositBankName();
/*    */   
/*    */   void setDepositBankName(String paramString);
/*    */   
/*    */   String getDepositBankAcctNbr();
/*    */   
/*    */   void setDepositBankAcctNbr(String paramString);
/*    */   
/*    */   String getNeighborhood();
/*    */   
/*    */   void setNeighborhood(String paramString);
/*    */   
/*    */   String getCounty();
/*    */   
/*    */   void setCounty(String paramString);
/*    */   
/*    */   String getAirportCode();
/*    */   
/*    */   void setAirportCode(String paramString);
/*    */   
/*    */   IDataModel getRetailLocationExt();
/*    */   
/*    */   void setRetailLocationExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IRetailLocationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IRetailLocationProperty> paramList);
/*    */   
/*    */   void addRetailLocationProperty(IRetailLocationProperty paramIRetailLocationProperty);
/*    */   
/*    */   void removeRetailLocationProperty(IRetailLocationProperty paramIRetailLocationProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\IRetailLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */