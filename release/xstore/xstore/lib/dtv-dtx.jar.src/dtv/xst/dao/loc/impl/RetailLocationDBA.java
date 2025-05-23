/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.RetailLocationId;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RetailLocationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1911878152L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _country;
/*     */   private String _locale;
/*     */   private String _currencyId;
/*     */   private String _description;
/*     */   private String _postalCode;
/*     */   private String _state;
/*     */   private String _storeName;
/*     */   private String _storeNbr;
/*     */   private String _alternateStoreNbr;
/*     */   private String _telephone1;
/*     */   private String _telephone2;
/*     */   private String _telephone3;
/*     */   private String _telephone4;
/*     */   private BigDecimal _latitude;
/*     */   private BigDecimal _longitude;
/*     */   private BigDecimal _defaultTaxPercentage;
/*     */   private String _storeManager;
/*     */   private String _locationType;
/*     */   private Boolean _deliveryAvailable;
/*     */   private Boolean _pickupAvailable;
/*     */   private Boolean _transferAvailable;
/*     */   private String _emailAddress;
/*     */   private String _geoCode;
/*     */   private Boolean _uezIndicator;
/*     */   private String _district;
/*     */   private String _area;
/*     */   private Boolean _useTillAccountability;
/*     */   private String _depositBankName;
/*     */   private String _depositBankAcctNbr;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   private String _airportCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.country, t.locale, t.currency_id, t.description, t.postal_code, t.state, t.store_name, t.store_nbr, t.alternate_store_nbr, t.telephone1, t.telephone2, t.telephone3, t.telephone4, t.latitude, t.longitude, t.default_tax_percentage, t.store_manager, t.location_type, t.delivery_available_flag, t.pickup_available_flag, t.transfer_available_flag, t.email_addr, t.geo_code, t.uez_flag, t.district, t.area, t.use_till_accountability_flag, t.deposit_bank_name, t.deposit_bank_account_number, t.neighborhood, t.county, t.airport_code FROM loc_rtl_loc t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  73 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  77 */     return "SELECT t.organization_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.country, t.locale, t.currency_id, t.description, t.postal_code, t.state, t.store_name, t.store_nbr, t.alternate_store_nbr, t.telephone1, t.telephone2, t.telephone3, t.telephone4, t.latitude, t.longitude, t.default_tax_percentage, t.store_manager, t.location_type, t.delivery_available_flag, t.pickup_available_flag, t.transfer_available_flag, t.email_addr, t.geo_code, t.uez_flag, t.district, t.area, t.use_till_accountability_flag, t.deposit_bank_name, t.deposit_bank_account_number, t.neighborhood, t.county, t.airport_code FROM loc_rtl_loc t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  83 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  86 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_rtl_loc(organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, address1, address2, address3, address4, apartment, city, country, locale, currency_id, description, postal_code, state, store_name, store_nbr, alternate_store_nbr, telephone1, telephone2, telephone3, telephone4, latitude, longitude, default_tax_percentage, store_manager, location_type, delivery_available_flag, pickup_available_flag, transfer_available_flag, email_addr, geo_code, uez_flag, district, area, use_till_accountability_flag, deposit_bank_name, deposit_bank_account_number, neighborhood, county, airport_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  89 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  93 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._country, this._locale, this._currencyId, this._description, this._postalCode, this._state, this._storeName, this._storeNbr, this._alternateStoreNbr, this._telephone1, this._telephone2, this._telephone3, this._telephone4, this._latitude, this._longitude, this._defaultTaxPercentage, this._storeManager, this._locationType, this._deliveryAvailable, this._pickupAvailable, this._transferAvailable, this._emailAddress, this._geoCode, this._uezIndicator, this._district, this._area, this._useTillAccountability, this._depositBankName, this._depositBankAcctNbr, this._neighborhood, this._county, this._airportCode } };
/*  94 */     return insertParameterObject;
/*     */   }
/*     */   
/*  97 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 3, 3, 12, 12, -7, -7, -7, 12, 12, -7, 12, 12, -7, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/* 100 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/* 103 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_rtl_loc SET update_date = ?, update_user_id = ?, address1 = ?, address2 = ?, address3 = ?, address4 = ?, apartment = ?, city = ?, country = ?, locale = ?, currency_id = ?, description = ?, postal_code = ?, state = ?, store_name = ?, store_nbr = ?, alternate_store_nbr = ?, telephone1 = ?, telephone2 = ?, telephone3 = ?, telephone4 = ?, latitude = ?, longitude = ?, default_tax_percentage = ?, store_manager = ?, location_type = ?, delivery_available_flag = ?, pickup_available_flag = ?, transfer_available_flag = ?, email_addr = ?, geo_code = ?, uez_flag = ?, district = ?, area = ?, use_till_accountability_flag = ?, deposit_bank_name = ?, deposit_bank_account_number = ?, neighborhood = ?, county = ?, airport_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/* 106 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 110 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._country, this._locale, this._currencyId, this._description, this._postalCode, this._state, this._storeName, this._storeNbr, this._alternateStoreNbr, this._telephone1, this._telephone2, this._telephone3, this._telephone4, this._latitude, this._longitude, this._defaultTaxPercentage, this._storeManager, this._locationType, this._deliveryAvailable, this._pickupAvailable, this._transferAvailable, this._emailAddress, this._geoCode, this._uezIndicator, this._district, this._area, this._useTillAccountability, this._depositBankName, this._depositBankAcctNbr, this._neighborhood, this._county, this._airportCode } };
/* 111 */     return updateParameterObject;
/*     */   }
/*     */   
/* 114 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 3, 3, 12, 12, -7, -7, -7, 12, 12, -7, 12, 12, -7, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 116 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 119 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_rtl_loc" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 122 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 128 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 131 */     return new Object[] { this._organizationId, this._retailLocationId };
/*     */   }
/*     */   
/* 134 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 137 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 140 */     return "loc_rtl_loc";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 144 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 148 */     return new RetailLocationFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailLocationFiller
/*     */     implements IFiller {
/*     */     private RetailLocationDBA _parent;
/*     */     
/*     */     public RetailLocationFiller(RetailLocationDBA argParent) {
/* 156 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 161 */       long primitiveResult = argResultSet.getLong(1);
/* 162 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 163 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       primitiveResult = argResultSet.getLong(2);
/* 170 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 171 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 176 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 177 */       if (t3 != null) {
/* 178 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 186 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 187 */       if (t5 != null) {
/* 188 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._updateUserId = argResultSet.getString(6);
/* 195 */       this._parent._address1 = argResultSet.getString(7);
/* 196 */       this._parent._address2 = argResultSet.getString(8);
/* 197 */       this._parent._address3 = argResultSet.getString(9);
/* 198 */       this._parent._address4 = argResultSet.getString(10);
/* 199 */       this._parent._apartment = argResultSet.getString(11);
/* 200 */       this._parent._city = argResultSet.getString(12);
/* 201 */       this._parent._country = argResultSet.getString(13);
/* 202 */       this._parent._locale = argResultSet.getString(14);
/* 203 */       this._parent._currencyId = argResultSet.getString(15);
/* 204 */       this._parent._description = argResultSet.getString(16);
/* 205 */       this._parent._postalCode = argResultSet.getString(17);
/* 206 */       this._parent._state = argResultSet.getString(18);
/* 207 */       this._parent._storeName = argResultSet.getString(19);
/* 208 */       this._parent._storeNbr = argResultSet.getString(20);
/* 209 */       this._parent._alternateStoreNbr = argResultSet.getString(21);
/* 210 */       this._parent._telephone1 = argResultSet.getString(22);
/* 211 */       this._parent._telephone2 = argResultSet.getString(23);
/* 212 */       this._parent._telephone3 = argResultSet.getString(24);
/* 213 */       this._parent._telephone4 = argResultSet.getString(25);
/* 214 */       this._parent._latitude = argResultSet.getBigDecimal(26);
/* 215 */       this._parent._longitude = argResultSet.getBigDecimal(27);
/* 216 */       this._parent._defaultTaxPercentage = argResultSet.getBigDecimal(28);
/* 217 */       this._parent._storeManager = argResultSet.getString(29);
/* 218 */       this._parent._locationType = argResultSet.getString(30);
/* 219 */       this._parent._deliveryAvailable = Boolean.valueOf(argResultSet.getBoolean(31));
/* 220 */       this._parent._pickupAvailable = Boolean.valueOf(argResultSet.getBoolean(32));
/* 221 */       this._parent._transferAvailable = Boolean.valueOf(argResultSet.getBoolean(33));
/* 222 */       this._parent._emailAddress = argResultSet.getString(34);
/* 223 */       this._parent._geoCode = argResultSet.getString(35);
/* 224 */       this._parent._uezIndicator = Boolean.valueOf(argResultSet.getBoolean(36));
/* 225 */       this._parent._district = argResultSet.getString(37);
/* 226 */       this._parent._area = argResultSet.getString(38);
/* 227 */       this._parent._useTillAccountability = Boolean.valueOf(argResultSet.getBoolean(39));
/* 228 */       this._parent._depositBankName = argResultSet.getString(40);
/* 229 */       this._parent._depositBankAcctNbr = argResultSet.getString(41);
/* 230 */       this._parent._neighborhood = argResultSet.getString(42);
/* 231 */       this._parent._county = argResultSet.getString(43);
/* 232 */       this._parent._airportCode = argResultSet.getString(44);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 237 */     argDAO.suppressStateChanges(true);
/* 238 */     RetailLocationDAO dao = (RetailLocationDAO)argDAO;
/* 239 */     dao.setOrganizationId(this._organizationId);
/* 240 */     dao.setRetailLocationId(this._retailLocationId);
/* 241 */     dao.setCreateDate(this._createDate);
/* 242 */     dao.setCreateUserId(this._createUserId);
/* 243 */     dao.setUpdateDate(this._updateDate);
/* 244 */     dao.setUpdateUserId(this._updateUserId);
/* 245 */     dao.setAddress1(this._address1);
/* 246 */     dao.setAddress2(this._address2);
/* 247 */     dao.setAddress3(this._address3);
/* 248 */     dao.setAddress4(this._address4);
/* 249 */     dao.setApartment(this._apartment);
/* 250 */     dao.setCity(this._city);
/* 251 */     dao.setCountry(this._country);
/* 252 */     dao.setLocale(this._locale);
/* 253 */     dao.setCurrencyId(this._currencyId);
/* 254 */     dao.setDescription(this._description);
/* 255 */     dao.setPostalCode(this._postalCode);
/* 256 */     dao.setState(this._state);
/* 257 */     dao.setStoreName(this._storeName);
/* 258 */     dao.setStoreNbr(this._storeNbr);
/* 259 */     dao.setAlternateStoreNbr(this._alternateStoreNbr);
/* 260 */     dao.setTelephone1(this._telephone1);
/* 261 */     dao.setTelephone2(this._telephone2);
/* 262 */     dao.setTelephone3(this._telephone3);
/* 263 */     dao.setTelephone4(this._telephone4);
/* 264 */     dao.setLatitude(this._latitude);
/* 265 */     dao.setLongitude(this._longitude);
/* 266 */     dao.setDefaultTaxPercentage(this._defaultTaxPercentage);
/* 267 */     dao.setStoreManager(this._storeManager);
/* 268 */     dao.setLocationType(this._locationType);
/* 269 */     dao.setDeliveryAvailable(this._deliveryAvailable);
/* 270 */     dao.setPickupAvailable(this._pickupAvailable);
/* 271 */     dao.setTransferAvailable(this._transferAvailable);
/* 272 */     dao.setEmailAddress(this._emailAddress);
/* 273 */     dao.setGeoCode(this._geoCode);
/* 274 */     dao.setUezIndicator(this._uezIndicator);
/* 275 */     dao.setDistrict(this._district);
/* 276 */     dao.setArea(this._area);
/* 277 */     dao.setUseTillAccountability(this._useTillAccountability);
/* 278 */     dao.setDepositBankName(this._depositBankName);
/* 279 */     dao.setDepositBankAcctNbr(this._depositBankAcctNbr);
/* 280 */     dao.setNeighborhood(this._neighborhood);
/* 281 */     dao.setCounty(this._county);
/* 282 */     dao.setAirportCode(this._airportCode);
/* 283 */     argDAO.suppressStateChanges(false);
/* 284 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 288 */     return loadDAO((IDataAccessObject)new RetailLocationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 292 */     RetailLocationDAO dao = (RetailLocationDAO)argDAO;
/* 293 */     this._organizationId = dao.getOrganizationId();
/* 294 */     this._retailLocationId = dao.getRetailLocationId();
/* 295 */     this._createDate = dao.getCreateDate();
/* 296 */     this._createUserId = dao.getCreateUserId();
/* 297 */     this._updateDate = dao.getUpdateDate();
/* 298 */     this._updateUserId = dao.getUpdateUserId();
/* 299 */     this._address1 = dao.getAddress1();
/* 300 */     this._address2 = dao.getAddress2();
/* 301 */     this._address3 = dao.getAddress3();
/* 302 */     this._address4 = dao.getAddress4();
/* 303 */     this._apartment = dao.getApartment();
/* 304 */     this._city = dao.getCity();
/* 305 */     this._country = dao.getCountry();
/* 306 */     this._locale = dao.getLocale();
/* 307 */     this._currencyId = dao.getCurrencyId();
/* 308 */     this._description = dao.getDescription();
/* 309 */     this._postalCode = dao.getPostalCode();
/* 310 */     this._state = dao.getState();
/* 311 */     this._storeName = dao.getStoreName();
/* 312 */     this._storeNbr = dao.getStoreNbr();
/* 313 */     this._alternateStoreNbr = dao.getAlternateStoreNbr();
/* 314 */     this._telephone1 = dao.getTelephone1();
/* 315 */     this._telephone2 = dao.getTelephone2();
/* 316 */     this._telephone3 = dao.getTelephone3();
/* 317 */     this._telephone4 = dao.getTelephone4();
/* 318 */     this._latitude = dao.getLatitude();
/* 319 */     this._longitude = dao.getLongitude();
/* 320 */     this._defaultTaxPercentage = dao.getDefaultTaxPercentage();
/* 321 */     this._storeManager = dao.getStoreManager();
/* 322 */     this._locationType = dao.getLocationType();
/* 323 */     this._deliveryAvailable = (dao.getDeliveryAvailable() != null) ? dao.getDeliveryAvailable() : Boolean.valueOf(false);
/* 324 */     this._pickupAvailable = (dao.getPickupAvailable() != null) ? dao.getPickupAvailable() : Boolean.valueOf(false);
/* 325 */     this._transferAvailable = (dao.getTransferAvailable() != null) ? dao.getTransferAvailable() : Boolean.valueOf(false);
/* 326 */     this._emailAddress = dao.getEmailAddress();
/* 327 */     this._geoCode = dao.getGeoCode();
/* 328 */     this._uezIndicator = (dao.getUezIndicator() != null) ? dao.getUezIndicator() : Boolean.valueOf(false);
/* 329 */     this._district = dao.getDistrict();
/* 330 */     this._area = dao.getArea();
/* 331 */     this._useTillAccountability = (dao.getUseTillAccountability() != null) ? dao.getUseTillAccountability() : Boolean.valueOf(false);
/* 332 */     this._depositBankName = dao.getDepositBankName();
/* 333 */     this._depositBankAcctNbr = dao.getDepositBankAcctNbr();
/* 334 */     this._neighborhood = dao.getNeighborhood();
/* 335 */     this._county = dao.getCounty();
/* 336 */     this._airportCode = dao.getAirportCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 340 */     RetailLocationId id = (RetailLocationId)argId;
/* 341 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 342 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 343 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 347 */     RetailLocationId id = new RetailLocationId();
/* 348 */     id.setOrganizationId(this._organizationId);
/* 349 */     id.setRetailLocationId(this._retailLocationId);
/* 350 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 358 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 362 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\RetailLocationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */