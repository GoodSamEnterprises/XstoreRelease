/*      */ package dtv.xst.dao.loc.impl;
/*      */ 
/*      */ import dtv.data2.access.DaoUtils;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.AbstractDAOImpl;
/*      */ import dtv.util.DtvDate;
/*      */ import dtv.xst.dao.loc.RetailLocationId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RetailLocationDAO
/*      */   extends AbstractDAOImpl
/*      */ {
/*      */   private static final long serialVersionUID = -1911878152L;
/*   23 */   private static final Logger _logger = Logger.getLogger(RetailLocationDAO.class);
/*      */   
/*      */   private Long _organizationId;
/*      */   private Long _retailLocationId;
/*      */   private DtvDate _createDate;
/*      */   private String _createUserId;
/*      */   private DtvDate _updateDate;
/*      */   private String _updateUserId;
/*      */   private String _address1;
/*      */   private String _address2;
/*      */   private String _address3;
/*      */   private String _address4;
/*      */   private String _apartment;
/*      */   private String _city;
/*      */   private String _country;
/*      */   private String _locale;
/*      */   private String _currencyId;
/*      */   private String _description;
/*      */   private String _postalCode;
/*      */   private String _state;
/*      */   private String _storeName;
/*      */   private String _storeNbr;
/*      */   private String _alternateStoreNbr;
/*      */   private String _telephone1;
/*      */   private String _telephone2;
/*      */   private String _telephone3;
/*      */   private String _telephone4;
/*      */   private BigDecimal _latitude;
/*      */   private BigDecimal _longitude;
/*      */   private BigDecimal _defaultTaxPercentage;
/*      */   private String _storeManager;
/*      */   private String _locationType;
/*   55 */   private Boolean _deliveryAvailable = Boolean.FALSE;
/*   56 */   private Boolean _pickupAvailable = Boolean.FALSE;
/*   57 */   private Boolean _transferAvailable = Boolean.FALSE;
/*      */   private String _emailAddress;
/*      */   private String _geoCode;
/*   60 */   private Boolean _uezIndicator = Boolean.FALSE;
/*      */   private String _district;
/*      */   private String _area;
/*   63 */   private Boolean _useTillAccountability = Boolean.FALSE;
/*      */   private String _depositBankName;
/*      */   private String _depositBankAcctNbr;
/*      */   private String _neighborhood;
/*      */   private String _county;
/*      */   private String _airportCode;
/*      */   
/*      */   public Long getOrganizationId() {
/*   71 */     return this._organizationId;
/*      */   }
/*      */   
/*      */   public void setOrganizationId(Long argOrganizationId) {
/*   75 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*   76 */       this._organizationId = argOrganizationId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Long getRetailLocationId() {
/*   81 */     return this._retailLocationId;
/*      */   }
/*      */   
/*      */   public void setRetailLocationId(Long argRetailLocationId) {
/*   85 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*   86 */       this._retailLocationId = argRetailLocationId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getCreateDate() {
/*   91 */     return (Date)this._createDate;
/*      */   }
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*   95 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*   96 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  102 */     return this._createUserId;
/*      */   }
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  106 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  107 */       this._createUserId = argCreateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getUpdateDate() {
/*  112 */     return (Date)this._updateDate;
/*      */   }
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  116 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  117 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  123 */     return this._updateUserId;
/*      */   }
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  127 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  128 */       this._updateUserId = argUpdateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getAddress1() {
/*  133 */     return this._address1;
/*      */   }
/*      */   
/*      */   public void setAddress1(String argAddress1) {
/*  137 */     if (changed(argAddress1, this._address1, "address1")) {
/*  138 */       this._address1 = argAddress1;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getAddress2() {
/*  143 */     return this._address2;
/*      */   }
/*      */   
/*      */   public void setAddress2(String argAddress2) {
/*  147 */     if (changed(argAddress2, this._address2, "address2")) {
/*  148 */       this._address2 = argAddress2;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getAddress3() {
/*  153 */     return this._address3;
/*      */   }
/*      */   
/*      */   public void setAddress3(String argAddress3) {
/*  157 */     if (changed(argAddress3, this._address3, "address3")) {
/*  158 */       this._address3 = argAddress3;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getAddress4() {
/*  163 */     return this._address4;
/*      */   }
/*      */   
/*      */   public void setAddress4(String argAddress4) {
/*  167 */     if (changed(argAddress4, this._address4, "address4")) {
/*  168 */       this._address4 = argAddress4;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getApartment() {
/*  173 */     return this._apartment;
/*      */   }
/*      */   
/*      */   public void setApartment(String argApartment) {
/*  177 */     if (changed(argApartment, this._apartment, "apartment")) {
/*  178 */       this._apartment = argApartment;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getCity() {
/*  183 */     return this._city;
/*      */   }
/*      */   
/*      */   public void setCity(String argCity) {
/*  187 */     if (changed(argCity, this._city, "city")) {
/*  188 */       this._city = argCity;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getCountry() {
/*  193 */     return this._country;
/*      */   }
/*      */   
/*      */   public void setCountry(String argCountry) {
/*  197 */     if (changed(argCountry, this._country, "country")) {
/*  198 */       this._country = argCountry;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getLocale() {
/*  203 */     return this._locale;
/*      */   }
/*      */   
/*      */   public void setLocale(String argLocale) {
/*  207 */     if (changed(argLocale, this._locale, "locale")) {
/*  208 */       this._locale = argLocale;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getCurrencyId() {
/*  213 */     return this._currencyId;
/*      */   }
/*      */   
/*      */   public void setCurrencyId(String argCurrencyId) {
/*  217 */     if (changed(argCurrencyId, this._currencyId, "currencyId")) {
/*  218 */       this._currencyId = argCurrencyId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDescription() {
/*  223 */     return this._description;
/*      */   }
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  227 */     if (changed(argDescription, this._description, "description")) {
/*  228 */       this._description = argDescription;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getPostalCode() {
/*  233 */     return this._postalCode;
/*      */   }
/*      */   
/*      */   public void setPostalCode(String argPostalCode) {
/*  237 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/*  238 */       this._postalCode = argPostalCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getState() {
/*  243 */     return this._state;
/*      */   }
/*      */   
/*      */   public void setState(String argState) {
/*  247 */     if (changed(argState, this._state, "state")) {
/*  248 */       this._state = argState;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getStoreName() {
/*  253 */     return this._storeName;
/*      */   }
/*      */   
/*      */   public void setStoreName(String argStoreName) {
/*  257 */     if (changed(argStoreName, this._storeName, "storeName")) {
/*  258 */       this._storeName = argStoreName;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getStoreNbr() {
/*  263 */     return this._storeNbr;
/*      */   }
/*      */   
/*      */   public void setStoreNbr(String argStoreNbr) {
/*  267 */     if (changed(argStoreNbr, this._storeNbr, "storeNbr")) {
/*  268 */       this._storeNbr = argStoreNbr;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getAlternateStoreNbr() {
/*  273 */     return this._alternateStoreNbr;
/*      */   }
/*      */   
/*      */   public void setAlternateStoreNbr(String argAlternateStoreNbr) {
/*  277 */     if (changed(argAlternateStoreNbr, this._alternateStoreNbr, "alternateStoreNbr")) {
/*  278 */       this._alternateStoreNbr = argAlternateStoreNbr;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTelephone1() {
/*  283 */     return this._telephone1;
/*      */   }
/*      */   
/*      */   public void setTelephone1(String argTelephone1) {
/*  287 */     if (changed(argTelephone1, this._telephone1, "telephone1")) {
/*  288 */       this._telephone1 = argTelephone1;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTelephone2() {
/*  293 */     return this._telephone2;
/*      */   }
/*      */   
/*      */   public void setTelephone2(String argTelephone2) {
/*  297 */     if (changed(argTelephone2, this._telephone2, "telephone2")) {
/*  298 */       this._telephone2 = argTelephone2;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTelephone3() {
/*  303 */     return this._telephone3;
/*      */   }
/*      */   
/*      */   public void setTelephone3(String argTelephone3) {
/*  307 */     if (changed(argTelephone3, this._telephone3, "telephone3")) {
/*  308 */       this._telephone3 = argTelephone3;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTelephone4() {
/*  313 */     return this._telephone4;
/*      */   }
/*      */   
/*      */   public void setTelephone4(String argTelephone4) {
/*  317 */     if (changed(argTelephone4, this._telephone4, "telephone4")) {
/*  318 */       this._telephone4 = argTelephone4;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getLatitude() {
/*  323 */     return this._latitude;
/*      */   }
/*      */   
/*      */   public void setLatitude(BigDecimal argLatitude) {
/*  327 */     if (changed(argLatitude, this._latitude, "latitude")) {
/*  328 */       this._latitude = argLatitude;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getLongitude() {
/*  333 */     return this._longitude;
/*      */   }
/*      */   
/*      */   public void setLongitude(BigDecimal argLongitude) {
/*  337 */     if (changed(argLongitude, this._longitude, "longitude")) {
/*  338 */       this._longitude = argLongitude;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getDefaultTaxPercentage() {
/*  343 */     return this._defaultTaxPercentage;
/*      */   }
/*      */   
/*      */   public void setDefaultTaxPercentage(BigDecimal argDefaultTaxPercentage) {
/*  347 */     if (changed(argDefaultTaxPercentage, this._defaultTaxPercentage, "defaultTaxPercentage")) {
/*  348 */       this._defaultTaxPercentage = argDefaultTaxPercentage;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getStoreManager() {
/*  353 */     return this._storeManager;
/*      */   }
/*      */   
/*      */   public void setStoreManager(String argStoreManager) {
/*  357 */     if (changed(argStoreManager, this._storeManager, "storeManager")) {
/*  358 */       this._storeManager = argStoreManager;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getLocationType() {
/*  363 */     return this._locationType;
/*      */   }
/*      */   
/*      */   public void setLocationType(String argLocationType) {
/*  367 */     if (changed(argLocationType, this._locationType, "locationType")) {
/*  368 */       this._locationType = argLocationType;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDeliveryAvailable() {
/*  373 */     return this._deliveryAvailable;
/*      */   }
/*      */   
/*      */   public void setDeliveryAvailable(Boolean argDeliveryAvailable) {
/*  377 */     if (changed(argDeliveryAvailable, this._deliveryAvailable, "deliveryAvailable")) {
/*  378 */       this._deliveryAvailable = argDeliveryAvailable;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPickupAvailable() {
/*  383 */     return this._pickupAvailable;
/*      */   }
/*      */   
/*      */   public void setPickupAvailable(Boolean argPickupAvailable) {
/*  387 */     if (changed(argPickupAvailable, this._pickupAvailable, "pickupAvailable")) {
/*  388 */       this._pickupAvailable = argPickupAvailable;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getTransferAvailable() {
/*  393 */     return this._transferAvailable;
/*      */   }
/*      */   
/*      */   public void setTransferAvailable(Boolean argTransferAvailable) {
/*  397 */     if (changed(argTransferAvailable, this._transferAvailable, "transferAvailable")) {
/*  398 */       this._transferAvailable = argTransferAvailable;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmailAddress() {
/*  403 */     return this._emailAddress;
/*      */   }
/*      */   
/*      */   public void setEmailAddress(String argEmailAddress) {
/*  407 */     if (changed(argEmailAddress, this._emailAddress, "emailAddress")) {
/*  408 */       this._emailAddress = argEmailAddress;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getGeoCode() {
/*  413 */     return this._geoCode;
/*      */   }
/*      */   
/*      */   public void setGeoCode(String argGeoCode) {
/*  417 */     if (changed(argGeoCode, this._geoCode, "geoCode")) {
/*  418 */       this._geoCode = argGeoCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getUezIndicator() {
/*  423 */     return this._uezIndicator;
/*      */   }
/*      */   
/*      */   public void setUezIndicator(Boolean argUezIndicator) {
/*  427 */     if (changed(argUezIndicator, this._uezIndicator, "uezIndicator")) {
/*  428 */       this._uezIndicator = argUezIndicator;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDistrict() {
/*  433 */     return this._district;
/*      */   }
/*      */   
/*      */   public void setDistrict(String argDistrict) {
/*  437 */     if (changed(argDistrict, this._district, "district")) {
/*  438 */       this._district = argDistrict;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getArea() {
/*  443 */     return this._area;
/*      */   }
/*      */   
/*      */   public void setArea(String argArea) {
/*  447 */     if (changed(argArea, this._area, "area")) {
/*  448 */       this._area = argArea;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getUseTillAccountability() {
/*  453 */     return this._useTillAccountability;
/*      */   }
/*      */   
/*      */   public void setUseTillAccountability(Boolean argUseTillAccountability) {
/*  457 */     if (changed(argUseTillAccountability, this._useTillAccountability, "useTillAccountability")) {
/*  458 */       this._useTillAccountability = argUseTillAccountability;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDepositBankName() {
/*  463 */     return this._depositBankName;
/*      */   }
/*      */   
/*      */   public void setDepositBankName(String argDepositBankName) {
/*  467 */     if (changed(argDepositBankName, this._depositBankName, "depositBankName")) {
/*  468 */       this._depositBankName = argDepositBankName;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDepositBankAcctNbr() {
/*  473 */     return this._depositBankAcctNbr;
/*      */   }
/*      */   
/*      */   public void setDepositBankAcctNbr(String argDepositBankAcctNbr) {
/*  477 */     if (changed(argDepositBankAcctNbr, this._depositBankAcctNbr, "depositBankAcctNbr")) {
/*  478 */       this._depositBankAcctNbr = argDepositBankAcctNbr;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getNeighborhood() {
/*  483 */     return this._neighborhood;
/*      */   }
/*      */   
/*      */   public void setNeighborhood(String argNeighborhood) {
/*  487 */     if (changed(argNeighborhood, this._neighborhood, "neighborhood")) {
/*  488 */       this._neighborhood = argNeighborhood;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getCounty() {
/*  493 */     return this._county;
/*      */   }
/*      */   
/*      */   public void setCounty(String argCounty) {
/*  497 */     if (changed(argCounty, this._county, "county")) {
/*  498 */       this._county = argCounty;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getAirportCode() {
/*  503 */     return this._airportCode;
/*      */   }
/*      */   
/*      */   public void setAirportCode(String argAirportCode) {
/*  507 */     if (changed(argAirportCode, this._airportCode, "airportCode")) {
/*  508 */       this._airportCode = argAirportCode;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  515 */     StringBuilder buf = new StringBuilder(512);
/*  516 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/*  517 */     if (getOrganizationId() != null) {
/*  518 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*      */     }
/*  520 */     if (getRetailLocationId() != null) {
/*  521 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*      */     }
/*  523 */     if (getCreateDate() != null) {
/*  524 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*      */     }
/*  526 */     if (getCreateUserId() != null) {
/*  527 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*      */     }
/*  529 */     if (getUpdateDate() != null) {
/*  530 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*      */     }
/*  532 */     if (getUpdateUserId() != null) {
/*  533 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*      */     }
/*  535 */     if (getAddress1() != null) {
/*  536 */       buf.append("address1").append("=").append(getAddress1()).append(" ");
/*      */     }
/*  538 */     if (getAddress2() != null) {
/*  539 */       buf.append("address2").append("=").append(getAddress2()).append(" ");
/*      */     }
/*  541 */     if (getAddress3() != null) {
/*  542 */       buf.append("address3").append("=").append(getAddress3()).append(" ");
/*      */     }
/*  544 */     if (getAddress4() != null) {
/*  545 */       buf.append("address4").append("=").append(getAddress4()).append(" ");
/*      */     }
/*  547 */     if (getApartment() != null) {
/*  548 */       buf.append("apartment").append("=").append(getApartment()).append(" ");
/*      */     }
/*  550 */     if (getCity() != null) {
/*  551 */       buf.append("city").append("=").append(getCity()).append(" ");
/*      */     }
/*  553 */     if (getCountry() != null) {
/*  554 */       buf.append("country").append("=").append(getCountry()).append(" ");
/*      */     }
/*  556 */     if (getLocale() != null) {
/*  557 */       buf.append("locale").append("=").append(getLocale()).append(" ");
/*      */     }
/*  559 */     if (getCurrencyId() != null) {
/*  560 */       buf.append("currencyId").append("=").append(getCurrencyId()).append(" ");
/*      */     }
/*  562 */     if (getDescription() != null) {
/*  563 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*      */     }
/*  565 */     if (getPostalCode() != null) {
/*  566 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*      */     }
/*  568 */     if (getState() != null) {
/*  569 */       buf.append("state").append("=").append(getState()).append(" ");
/*      */     }
/*  571 */     if (getStoreName() != null) {
/*  572 */       buf.append("storeName").append("=").append(getStoreName()).append(" ");
/*      */     }
/*  574 */     if (getStoreNbr() != null) {
/*  575 */       buf.append("storeNbr").append("=").append(getStoreNbr()).append(" ");
/*      */     }
/*  577 */     if (getAlternateStoreNbr() != null) {
/*  578 */       buf.append("alternateStoreNbr").append("=").append(getAlternateStoreNbr()).append(" ");
/*      */     }
/*  580 */     if (getTelephone1() != null) {
/*  581 */       buf.append("telephone1").append("=").append(getTelephone1()).append(" ");
/*      */     }
/*  583 */     if (getTelephone2() != null) {
/*  584 */       buf.append("telephone2").append("=").append(getTelephone2()).append(" ");
/*      */     }
/*  586 */     if (getTelephone3() != null) {
/*  587 */       buf.append("telephone3").append("=").append(getTelephone3()).append(" ");
/*      */     }
/*  589 */     if (getTelephone4() != null) {
/*  590 */       buf.append("telephone4").append("=").append(getTelephone4()).append(" ");
/*      */     }
/*  592 */     if (getLatitude() != null) {
/*  593 */       buf.append("latitude").append("=").append(getLatitude()).append(" ");
/*      */     }
/*  595 */     if (getLongitude() != null) {
/*  596 */       buf.append("longitude").append("=").append(getLongitude()).append(" ");
/*      */     }
/*  598 */     if (getDefaultTaxPercentage() != null) {
/*  599 */       buf.append("defaultTaxPercentage").append("=").append(getDefaultTaxPercentage()).append(" ");
/*      */     }
/*  601 */     if (getStoreManager() != null) {
/*  602 */       buf.append("storeManager").append("=").append(getStoreManager()).append(" ");
/*      */     }
/*  604 */     if (getLocationType() != null) {
/*  605 */       buf.append("locationType").append("=").append(getLocationType()).append(" ");
/*      */     }
/*  607 */     if (getDeliveryAvailable() != null && getDeliveryAvailable().booleanValue()) {
/*  608 */       buf.append("deliveryAvailable").append("=").append(getDeliveryAvailable()).append(" ");
/*      */     }
/*  610 */     if (getPickupAvailable() != null && getPickupAvailable().booleanValue()) {
/*  611 */       buf.append("pickupAvailable").append("=").append(getPickupAvailable()).append(" ");
/*      */     }
/*  613 */     if (getTransferAvailable() != null && getTransferAvailable().booleanValue()) {
/*  614 */       buf.append("transferAvailable").append("=").append(getTransferAvailable()).append(" ");
/*      */     }
/*  616 */     if (getEmailAddress() != null) {
/*  617 */       buf.append("emailAddress").append("=").append(getEmailAddress()).append(" ");
/*      */     }
/*  619 */     if (getGeoCode() != null) {
/*  620 */       buf.append("geoCode").append("=").append(getGeoCode()).append(" ");
/*      */     }
/*  622 */     if (getUezIndicator() != null && getUezIndicator().booleanValue()) {
/*  623 */       buf.append("uezIndicator").append("=").append(getUezIndicator()).append(" ");
/*      */     }
/*  625 */     if (getDistrict() != null) {
/*  626 */       buf.append("district").append("=").append(getDistrict()).append(" ");
/*      */     }
/*  628 */     if (getArea() != null) {
/*  629 */       buf.append("area").append("=").append(getArea()).append(" ");
/*      */     }
/*  631 */     if (getUseTillAccountability() != null && getUseTillAccountability().booleanValue()) {
/*  632 */       buf.append("useTillAccountability").append("=").append(getUseTillAccountability()).append(" ");
/*      */     }
/*  634 */     if (getDepositBankName() != null) {
/*  635 */       buf.append("depositBankName").append("=").append(getDepositBankName()).append(" ");
/*      */     }
/*  637 */     if (getDepositBankAcctNbr() != null) {
/*  638 */       buf.append("depositBankAcctNbr").append("=").append(getDepositBankAcctNbr()).append(" ");
/*      */     }
/*  640 */     if (getNeighborhood() != null) {
/*  641 */       buf.append("neighborhood").append("=").append(getNeighborhood()).append(" ");
/*      */     }
/*  643 */     if (getCounty() != null) {
/*  644 */       buf.append("county").append("=").append(getCounty()).append(" ");
/*      */     }
/*  646 */     if (getAirportCode() != null) {
/*  647 */       buf.append("airportCode").append("=").append(getAirportCode()).append(" ");
/*      */     }
/*      */     
/*  650 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public IObjectId getObjectId() {
/*  654 */     RetailLocationId id = new RetailLocationId();
/*  655 */     id.setOrganizationId(getOrganizationId());
/*  656 */     id.setRetailLocationId(getRetailLocationId());
/*  657 */     return (IObjectId)id;
/*      */   }
/*      */   
/*      */   public void setObjectId(IObjectId argObjectId) {
/*  661 */     setOrganizationId(((RetailLocationId)argObjectId).getOrganizationId());
/*  662 */     setRetailLocationId(((RetailLocationId)argObjectId).getRetailLocationId());
/*      */   }
/*      */   
/*      */   public String getImplementingClass() {
/*  666 */     return null;
/*      */   }
/*      */   
/*      */   public String toXmlString() {
/*  670 */     StringBuilder buf = new StringBuilder(2200);
/*  671 */     buf.append("<").append("dao").append(" name=\"RetailLocation\" cmd=\"" + getObjectStateString() + "\">");
/*  672 */     getFieldsAsXml(buf);
/*  673 */     buf.append("</").append("dao").append(">");
/*      */     
/*  675 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public Map<String, String> getValues() {
/*  679 */     Map<String, String> values = super.getValues();
/*  680 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/*  681 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/*  682 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/*  683 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/*  684 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/*  685 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/*  686 */     if (this._address1 != null) values.put("Address1", DaoUtils.getXmlSafeFieldValue(12, this._address1)); 
/*  687 */     if (this._address2 != null) values.put("Address2", DaoUtils.getXmlSafeFieldValue(12, this._address2)); 
/*  688 */     if (this._address3 != null) values.put("Address3", DaoUtils.getXmlSafeFieldValue(12, this._address3)); 
/*  689 */     if (this._address4 != null) values.put("Address4", DaoUtils.getXmlSafeFieldValue(12, this._address4)); 
/*  690 */     if (this._apartment != null) values.put("Apartment", DaoUtils.getXmlSafeFieldValue(12, this._apartment)); 
/*  691 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/*  692 */     if (this._country != null) values.put("Country", DaoUtils.getXmlSafeFieldValue(12, this._country)); 
/*  693 */     if (this._locale != null) values.put("Locale", DaoUtils.getXmlSafeFieldValue(12, this._locale)); 
/*  694 */     if (this._currencyId != null) values.put("CurrencyId", DaoUtils.getXmlSafeFieldValue(12, this._currencyId)); 
/*  695 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/*  696 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/*  697 */     if (this._state != null) values.put("State", DaoUtils.getXmlSafeFieldValue(12, this._state)); 
/*  698 */     if (this._storeName != null) values.put("StoreName", DaoUtils.getXmlSafeFieldValue(12, this._storeName)); 
/*  699 */     if (this._storeNbr != null) values.put("StoreNbr", DaoUtils.getXmlSafeFieldValue(12, this._storeNbr)); 
/*  700 */     if (this._alternateStoreNbr != null) values.put("AlternateStoreNbr", DaoUtils.getXmlSafeFieldValue(12, this._alternateStoreNbr)); 
/*  701 */     if (this._telephone1 != null) values.put("Telephone1", DaoUtils.getXmlSafeFieldValue(12, this._telephone1)); 
/*  702 */     if (this._telephone2 != null) values.put("Telephone2", DaoUtils.getXmlSafeFieldValue(12, this._telephone2)); 
/*  703 */     if (this._telephone3 != null) values.put("Telephone3", DaoUtils.getXmlSafeFieldValue(12, this._telephone3)); 
/*  704 */     if (this._telephone4 != null) values.put("Telephone4", DaoUtils.getXmlSafeFieldValue(12, this._telephone4)); 
/*  705 */     if (this._latitude != null) values.put("Latitude", DaoUtils.getXmlSafeFieldValue(3, this._latitude)); 
/*  706 */     if (this._longitude != null) values.put("Longitude", DaoUtils.getXmlSafeFieldValue(3, this._longitude)); 
/*  707 */     if (this._defaultTaxPercentage != null) values.put("DefaultTaxPercentage", DaoUtils.getXmlSafeFieldValue(3, this._defaultTaxPercentage)); 
/*  708 */     if (this._storeManager != null) values.put("StoreManager", DaoUtils.getXmlSafeFieldValue(12, this._storeManager)); 
/*  709 */     if (this._locationType != null) values.put("LocationType", DaoUtils.getXmlSafeFieldValue(12, this._locationType)); 
/*  710 */     if (this._deliveryAvailable != null) values.put("DeliveryAvailable", DaoUtils.getXmlSafeFieldValue(-7, this._deliveryAvailable)); 
/*  711 */     if (this._pickupAvailable != null) values.put("PickupAvailable", DaoUtils.getXmlSafeFieldValue(-7, this._pickupAvailable)); 
/*  712 */     if (this._transferAvailable != null) values.put("TransferAvailable", DaoUtils.getXmlSafeFieldValue(-7, this._transferAvailable)); 
/*  713 */     if (this._emailAddress != null) values.put("EmailAddress", DaoUtils.getXmlSafeFieldValue(12, this._emailAddress)); 
/*  714 */     if (this._geoCode != null) values.put("GeoCode", DaoUtils.getXmlSafeFieldValue(12, this._geoCode)); 
/*  715 */     if (this._uezIndicator != null) values.put("UezIndicator", DaoUtils.getXmlSafeFieldValue(-7, this._uezIndicator)); 
/*  716 */     if (this._district != null) values.put("District", DaoUtils.getXmlSafeFieldValue(12, this._district)); 
/*  717 */     if (this._area != null) values.put("Area", DaoUtils.getXmlSafeFieldValue(12, this._area)); 
/*  718 */     if (this._useTillAccountability != null) values.put("UseTillAccountability", DaoUtils.getXmlSafeFieldValue(-7, this._useTillAccountability)); 
/*  719 */     if (this._depositBankName != null) values.put("DepositBankName", DaoUtils.getXmlSafeFieldValue(12, this._depositBankName)); 
/*  720 */     if (this._depositBankAcctNbr != null) values.put("DepositBankAcctNbr", DaoUtils.getXmlSafeFieldValue(12, this._depositBankAcctNbr)); 
/*  721 */     if (this._neighborhood != null) values.put("Neighborhood", DaoUtils.getXmlSafeFieldValue(12, this._neighborhood)); 
/*  722 */     if (this._county != null) values.put("County", DaoUtils.getXmlSafeFieldValue(12, this._county)); 
/*  723 */     if (this._airportCode != null) values.put("AirportCode", DaoUtils.getXmlSafeFieldValue(12, this._airportCode)); 
/*  724 */     return values;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setValues(Map<String, String> argValues) {
/*  729 */     super.setValues(argValues);
/*  730 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*      */       
/*  732 */       String fieldName = field.getKey();
/*  733 */       String fieldValue = field.getValue();
/*  734 */       switch (fieldName) {
/*      */         
/*      */         case "OrganizationId":
/*      */           try {
/*  738 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/*  739 */             setOrganizationId((Long)value);
/*  740 */           } catch (Exception ee) {
/*  741 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "RetailLocationId":
/*      */           try {
/*  747 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/*  748 */             setRetailLocationId((Long)value);
/*  749 */           } catch (Exception ee) {
/*  750 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateDate":
/*      */           try {
/*  756 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  757 */             setCreateDate((Date)value);
/*  758 */           } catch (Exception ee) {
/*  759 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateUserId":
/*      */           try {
/*  765 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  766 */             setCreateUserId((String)value);
/*  767 */           } catch (Exception ee) {
/*  768 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateDate":
/*      */           try {
/*  774 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  775 */             setUpdateDate((Date)value);
/*  776 */           } catch (Exception ee) {
/*  777 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateUserId":
/*      */           try {
/*  783 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  784 */             setUpdateUserId((String)value);
/*  785 */           } catch (Exception ee) {
/*  786 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Address1":
/*      */           try {
/*  792 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  793 */             setAddress1((String)value);
/*  794 */           } catch (Exception ee) {
/*  795 */             throw new DtxException("An exception occurred while calling setAddress1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Address2":
/*      */           try {
/*  801 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  802 */             setAddress2((String)value);
/*  803 */           } catch (Exception ee) {
/*  804 */             throw new DtxException("An exception occurred while calling setAddress2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Address3":
/*      */           try {
/*  810 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  811 */             setAddress3((String)value);
/*  812 */           } catch (Exception ee) {
/*  813 */             throw new DtxException("An exception occurred while calling setAddress3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Address4":
/*      */           try {
/*  819 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  820 */             setAddress4((String)value);
/*  821 */           } catch (Exception ee) {
/*  822 */             throw new DtxException("An exception occurred while calling setAddress4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Apartment":
/*      */           try {
/*  828 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  829 */             setApartment((String)value);
/*  830 */           } catch (Exception ee) {
/*  831 */             throw new DtxException("An exception occurred while calling setApartment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "City":
/*      */           try {
/*  837 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  838 */             setCity((String)value);
/*  839 */           } catch (Exception ee) {
/*  840 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Country":
/*      */           try {
/*  846 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  847 */             setCountry((String)value);
/*  848 */           } catch (Exception ee) {
/*  849 */             throw new DtxException("An exception occurred while calling setCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Locale":
/*      */           try {
/*  855 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  856 */             setLocale((String)value);
/*  857 */           } catch (Exception ee) {
/*  858 */             throw new DtxException("An exception occurred while calling setLocale() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CurrencyId":
/*      */           try {
/*  864 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  865 */             setCurrencyId((String)value);
/*  866 */           } catch (Exception ee) {
/*  867 */             throw new DtxException("An exception occurred while calling setCurrencyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Description":
/*      */           try {
/*  873 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  874 */             setDescription((String)value);
/*  875 */           } catch (Exception ee) {
/*  876 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PostalCode":
/*      */           try {
/*  882 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  883 */             setPostalCode((String)value);
/*  884 */           } catch (Exception ee) {
/*  885 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "State":
/*      */           try {
/*  891 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  892 */             setState((String)value);
/*  893 */           } catch (Exception ee) {
/*  894 */             throw new DtxException("An exception occurred while calling setState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "StoreName":
/*      */           try {
/*  900 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  901 */             setStoreName((String)value);
/*  902 */           } catch (Exception ee) {
/*  903 */             throw new DtxException("An exception occurred while calling setStoreName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "StoreNbr":
/*      */           try {
/*  909 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  910 */             setStoreNbr((String)value);
/*  911 */           } catch (Exception ee) {
/*  912 */             throw new DtxException("An exception occurred while calling setStoreNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AlternateStoreNbr":
/*      */           try {
/*  918 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  919 */             setAlternateStoreNbr((String)value);
/*  920 */           } catch (Exception ee) {
/*  921 */             throw new DtxException("An exception occurred while calling setAlternateStoreNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Telephone1":
/*      */           try {
/*  927 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  928 */             setTelephone1((String)value);
/*  929 */           } catch (Exception ee) {
/*  930 */             throw new DtxException("An exception occurred while calling setTelephone1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Telephone2":
/*      */           try {
/*  936 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  937 */             setTelephone2((String)value);
/*  938 */           } catch (Exception ee) {
/*  939 */             throw new DtxException("An exception occurred while calling setTelephone2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Telephone3":
/*      */           try {
/*  945 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  946 */             setTelephone3((String)value);
/*  947 */           } catch (Exception ee) {
/*  948 */             throw new DtxException("An exception occurred while calling setTelephone3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Telephone4":
/*      */           try {
/*  954 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  955 */             setTelephone4((String)value);
/*  956 */           } catch (Exception ee) {
/*  957 */             throw new DtxException("An exception occurred while calling setTelephone4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Latitude":
/*      */           try {
/*  963 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  964 */             setLatitude((BigDecimal)value);
/*  965 */           } catch (Exception ee) {
/*  966 */             throw new DtxException("An exception occurred while calling setLatitude() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Longitude":
/*      */           try {
/*  972 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  973 */             setLongitude((BigDecimal)value);
/*  974 */           } catch (Exception ee) {
/*  975 */             throw new DtxException("An exception occurred while calling setLongitude() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DefaultTaxPercentage":
/*      */           try {
/*  981 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  982 */             setDefaultTaxPercentage((BigDecimal)value);
/*  983 */           } catch (Exception ee) {
/*  984 */             throw new DtxException("An exception occurred while calling setDefaultTaxPercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "StoreManager":
/*      */           try {
/*  990 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  991 */             setStoreManager((String)value);
/*  992 */           } catch (Exception ee) {
/*  993 */             throw new DtxException("An exception occurred while calling setStoreManager() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "LocationType":
/*      */           try {
/*  999 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1000 */             setLocationType((String)value);
/* 1001 */           } catch (Exception ee) {
/* 1002 */             throw new DtxException("An exception occurred while calling setLocationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DeliveryAvailable":
/*      */           try {
/* 1008 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1009 */             setDeliveryAvailable((Boolean)value);
/* 1010 */           } catch (Exception ee) {
/* 1011 */             throw new DtxException("An exception occurred while calling setDeliveryAvailable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PickupAvailable":
/*      */           try {
/* 1017 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1018 */             setPickupAvailable((Boolean)value);
/* 1019 */           } catch (Exception ee) {
/* 1020 */             throw new DtxException("An exception occurred while calling setPickupAvailable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TransferAvailable":
/*      */           try {
/* 1026 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1027 */             setTransferAvailable((Boolean)value);
/* 1028 */           } catch (Exception ee) {
/* 1029 */             throw new DtxException("An exception occurred while calling setTransferAvailable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmailAddress":
/*      */           try {
/* 1035 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1036 */             setEmailAddress((String)value);
/* 1037 */           } catch (Exception ee) {
/* 1038 */             throw new DtxException("An exception occurred while calling setEmailAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "GeoCode":
/*      */           try {
/* 1044 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1045 */             setGeoCode((String)value);
/* 1046 */           } catch (Exception ee) {
/* 1047 */             throw new DtxException("An exception occurred while calling setGeoCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UezIndicator":
/*      */           try {
/* 1053 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1054 */             setUezIndicator((Boolean)value);
/* 1055 */           } catch (Exception ee) {
/* 1056 */             throw new DtxException("An exception occurred while calling setUezIndicator() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "District":
/*      */           try {
/* 1062 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1063 */             setDistrict((String)value);
/* 1064 */           } catch (Exception ee) {
/* 1065 */             throw new DtxException("An exception occurred while calling setDistrict() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Area":
/*      */           try {
/* 1071 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1072 */             setArea((String)value);
/* 1073 */           } catch (Exception ee) {
/* 1074 */             throw new DtxException("An exception occurred while calling setArea() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UseTillAccountability":
/*      */           try {
/* 1080 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1081 */             setUseTillAccountability((Boolean)value);
/* 1082 */           } catch (Exception ee) {
/* 1083 */             throw new DtxException("An exception occurred while calling setUseTillAccountability() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DepositBankName":
/*      */           try {
/* 1089 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1090 */             setDepositBankName((String)value);
/* 1091 */           } catch (Exception ee) {
/* 1092 */             throw new DtxException("An exception occurred while calling setDepositBankName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DepositBankAcctNbr":
/*      */           try {
/* 1098 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1099 */             setDepositBankAcctNbr((String)value);
/* 1100 */           } catch (Exception ee) {
/* 1101 */             throw new DtxException("An exception occurred while calling setDepositBankAcctNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "Neighborhood":
/*      */           try {
/* 1107 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1108 */             setNeighborhood((String)value);
/* 1109 */           } catch (Exception ee) {
/* 1110 */             throw new DtxException("An exception occurred while calling setNeighborhood() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "County":
/*      */           try {
/* 1116 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1117 */             setCounty((String)value);
/* 1118 */           } catch (Exception ee) {
/* 1119 */             throw new DtxException("An exception occurred while calling setCounty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AirportCode":
/*      */           try {
/* 1125 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1126 */             setAirportCode((String)value);
/* 1127 */           } catch (Exception ee) {
/* 1128 */             throw new DtxException("An exception occurred while calling setAirportCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\RetailLocationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */