/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.DeliveryModifierId;
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
/*     */ 
/*     */ public class DeliveryModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -2114809077L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _deliveryType;
/*     */   private String _firstName;
/*     */   private String _middleName;
/*     */   private String _lastName;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _state;
/*     */   private String _postalCode;
/*     */   private String _country;
/*     */   private String _telephone1;
/*     */   private String _telephone2;
/*     */   private String _telephone3;
/*     */   private String _telephone4;
/*     */   private String _shippingMethod;
/*     */   private String _trackingNumber;
/*     */   private String _instructions;
/*     */   private String _extension;
/*     */   private Date _deliveryDate;
/*     */   private Date _startTime;
/*     */   private Date _endTime;
/*     */   private String _geoCode;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.delivery_enum, t.first_name, t.middle_name, t.last_name, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.state, t.postal_code, t.country, t.telephone1, t.telephone2, t.telephone3, t.telephone4, t.shipping_method, t.tracking_number, t.instructions, t.extension, t.delivery_date, t.delivery_start_time, t.delivery_end_time, t.geo_code, t.neighborhood, t.county FROM cat_delivery_modifier t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  63 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  67 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.delivery_enum, t.first_name, t.middle_name, t.last_name, t.address1, t.address2, t.address3, t.address4, t.apartment, t.city, t.state, t.postal_code, t.country, t.telephone1, t.telephone2, t.telephone3, t.telephone4, t.shipping_method, t.tracking_number, t.instructions, t.extension, t.delivery_date, t.delivery_start_time, t.delivery_end_time, t.geo_code, t.neighborhood, t.county FROM cat_delivery_modifier t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  73 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*  76 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_delivery_modifier(organization_id, cust_acct_id, cust_acct_code, create_date, create_user_id, update_date, update_user_id, delivery_enum, first_name, middle_name, last_name, address1, address2, address3, address4, apartment, city, state, postal_code, country, telephone1, telephone2, telephone3, telephone4, shipping_method, tracking_number, instructions, extension, delivery_date, delivery_start_time, delivery_end_time, geo_code, neighborhood, county) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  79 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  83 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._deliveryType, this._firstName, this._middleName, this._lastName, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._telephone1, this._telephone2, this._telephone3, this._telephone4, this._shippingMethod, this._trackingNumber, this._instructions, this._extension, this._deliveryDate, this._startTime, this._endTime, this._geoCode, this._neighborhood, this._county } };
/*  84 */     return insertParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  90 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_delivery_modifier SET update_date = ?, update_user_id = ?, delivery_enum = ?, first_name = ?, middle_name = ?, last_name = ?, address1 = ?, address2 = ?, address3 = ?, address4 = ?, apartment = ?, city = ?, state = ?, postal_code = ?, country = ?, telephone1 = ?, telephone2 = ?, telephone3 = ?, telephone4 = ?, shipping_method = ?, tracking_number = ?, instructions = ?, extension = ?, delivery_date = ?, delivery_start_time = ?, delivery_end_time = ?, geo_code = ?, neighborhood = ?, county = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  96 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 100 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._deliveryType, this._firstName, this._middleName, this._lastName, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._state, this._postalCode, this._country, this._telephone1, this._telephone2, this._telephone3, this._telephone4, this._shippingMethod, this._trackingNumber, this._instructions, this._extension, this._deliveryDate, this._startTime, this._endTime, this._geoCode, this._neighborhood, this._county } };
/* 101 */     return updateParameterObject;
/*     */   }
/*     */   
/* 104 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 91, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 106 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 109 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_delivery_modifier" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 112 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 118 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 121 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode };
/*     */   }
/*     */   
/* 124 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 127 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 130 */     return "cat_delivery_modifier";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 134 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 138 */     return new DeliveryModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class DeliveryModifierFiller
/*     */     implements IFiller {
/*     */     private DeliveryModifierDBA _parent;
/*     */     
/*     */     public DeliveryModifierFiller(DeliveryModifierDBA argParent) {
/* 146 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 151 */       long primitiveResult = argResultSet.getLong(1);
/* 152 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 153 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 157 */       this._parent._custAccountId = argResultSet.getString(2);
/* 158 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */       
/* 160 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 161 */       if (t4 != null) {
/* 162 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 170 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 171 */       if (t6 != null) {
/* 172 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 175 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 178 */       this._parent._updateUserId = argResultSet.getString(7);
/* 179 */       this._parent._deliveryType = argResultSet.getString(8);
/* 180 */       this._parent._firstName = argResultSet.getString(9);
/* 181 */       this._parent._middleName = argResultSet.getString(10);
/* 182 */       this._parent._lastName = argResultSet.getString(11);
/* 183 */       this._parent._address1 = argResultSet.getString(12);
/* 184 */       this._parent._address2 = argResultSet.getString(13);
/* 185 */       this._parent._address3 = argResultSet.getString(14);
/* 186 */       this._parent._address4 = argResultSet.getString(15);
/* 187 */       this._parent._apartment = argResultSet.getString(16);
/* 188 */       this._parent._city = argResultSet.getString(17);
/* 189 */       this._parent._state = argResultSet.getString(18);
/* 190 */       this._parent._postalCode = argResultSet.getString(19);
/* 191 */       this._parent._country = argResultSet.getString(20);
/* 192 */       this._parent._telephone1 = argResultSet.getString(21);
/* 193 */       this._parent._telephone2 = argResultSet.getString(22);
/* 194 */       this._parent._telephone3 = argResultSet.getString(23);
/* 195 */       this._parent._telephone4 = argResultSet.getString(24);
/* 196 */       this._parent._shippingMethod = argResultSet.getString(25);
/* 197 */       this._parent._trackingNumber = argResultSet.getString(26);
/* 198 */       this._parent._instructions = argResultSet.getString(27);
/* 199 */       this._parent._extension = argResultSet.getString(28);
/*     */       
/* 201 */       Timestamp t29 = argResultSet.getTimestamp(29);
/* 202 */       if (t29 != null) {
/* 203 */         this._parent._deliveryDate = (Date)new DtvDate(t29.getTime());
/*     */       } else {
/*     */         
/* 206 */         this._parent._deliveryDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 210 */       Timestamp t30 = argResultSet.getTimestamp(30);
/* 211 */       if (t30 != null) {
/* 212 */         this._parent._startTime = (Date)new DtvDate(t30.getTime());
/*     */       } else {
/*     */         
/* 215 */         this._parent._startTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 219 */       Timestamp t31 = argResultSet.getTimestamp(31);
/* 220 */       if (t31 != null) {
/* 221 */         this._parent._endTime = (Date)new DtvDate(t31.getTime());
/*     */       } else {
/*     */         
/* 224 */         this._parent._endTime = null;
/*     */       } 
/*     */       
/* 227 */       this._parent._geoCode = argResultSet.getString(32);
/* 228 */       this._parent._neighborhood = argResultSet.getString(33);
/* 229 */       this._parent._county = argResultSet.getString(34);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 234 */     argDAO.suppressStateChanges(true);
/* 235 */     DeliveryModifierDAO dao = (DeliveryModifierDAO)argDAO;
/* 236 */     dao.setOrganizationId(this._organizationId);
/* 237 */     dao.setCustAccountId(this._custAccountId);
/* 238 */     dao.setCustAccountCode(this._custAccountCode);
/* 239 */     dao.setCreateDate(this._createDate);
/* 240 */     dao.setCreateUserId(this._createUserId);
/* 241 */     dao.setUpdateDate(this._updateDate);
/* 242 */     dao.setUpdateUserId(this._updateUserId);
/* 243 */     dao.setDeliveryType(this._deliveryType);
/* 244 */     dao.setFirstName(this._firstName);
/* 245 */     dao.setMiddleName(this._middleName);
/* 246 */     dao.setLastName(this._lastName);
/* 247 */     dao.setAddress1(this._address1);
/* 248 */     dao.setAddress2(this._address2);
/* 249 */     dao.setAddress3(this._address3);
/* 250 */     dao.setAddress4(this._address4);
/* 251 */     dao.setApartment(this._apartment);
/* 252 */     dao.setCity(this._city);
/* 253 */     dao.setState(this._state);
/* 254 */     dao.setPostalCode(this._postalCode);
/* 255 */     dao.setCountry(this._country);
/* 256 */     dao.setTelephone1(this._telephone1);
/* 257 */     dao.setTelephone2(this._telephone2);
/* 258 */     dao.setTelephone3(this._telephone3);
/* 259 */     dao.setTelephone4(this._telephone4);
/* 260 */     dao.setShippingMethod(this._shippingMethod);
/* 261 */     dao.setTrackingNumber(this._trackingNumber);
/* 262 */     dao.setInstructions(this._instructions);
/* 263 */     dao.setExtension(this._extension);
/* 264 */     dao.setDeliveryDate(this._deliveryDate);
/* 265 */     dao.setStartTime(this._startTime);
/* 266 */     dao.setEndTime(this._endTime);
/* 267 */     dao.setGeoCode(this._geoCode);
/* 268 */     dao.setNeighborhood(this._neighborhood);
/* 269 */     dao.setCounty(this._county);
/* 270 */     argDAO.suppressStateChanges(false);
/* 271 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 275 */     return loadDAO((IDataAccessObject)new DeliveryModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 279 */     DeliveryModifierDAO dao = (DeliveryModifierDAO)argDAO;
/* 280 */     this._organizationId = dao.getOrganizationId();
/* 281 */     this._custAccountId = dao.getCustAccountId();
/* 282 */     this._custAccountCode = dao.getCustAccountCode();
/* 283 */     this._createDate = dao.getCreateDate();
/* 284 */     this._createUserId = dao.getCreateUserId();
/* 285 */     this._updateDate = dao.getUpdateDate();
/* 286 */     this._updateUserId = dao.getUpdateUserId();
/* 287 */     this._deliveryType = dao.getDeliveryType();
/* 288 */     this._firstName = dao.getFirstName();
/* 289 */     this._middleName = dao.getMiddleName();
/* 290 */     this._lastName = dao.getLastName();
/* 291 */     this._address1 = dao.getAddress1();
/* 292 */     this._address2 = dao.getAddress2();
/* 293 */     this._address3 = dao.getAddress3();
/* 294 */     this._address4 = dao.getAddress4();
/* 295 */     this._apartment = dao.getApartment();
/* 296 */     this._city = dao.getCity();
/* 297 */     this._state = dao.getState();
/* 298 */     this._postalCode = dao.getPostalCode();
/* 299 */     this._country = dao.getCountry();
/* 300 */     this._telephone1 = dao.getTelephone1();
/* 301 */     this._telephone2 = dao.getTelephone2();
/* 302 */     this._telephone3 = dao.getTelephone3();
/* 303 */     this._telephone4 = dao.getTelephone4();
/* 304 */     this._shippingMethod = dao.getShippingMethod();
/* 305 */     this._trackingNumber = dao.getTrackingNumber();
/* 306 */     this._instructions = dao.getInstructions();
/* 307 */     this._extension = dao.getExtension();
/* 308 */     this._deliveryDate = dao.getDeliveryDate();
/* 309 */     this._startTime = dao.getStartTime();
/* 310 */     this._endTime = dao.getEndTime();
/* 311 */     this._geoCode = dao.getGeoCode();
/* 312 */     this._neighborhood = dao.getNeighborhood();
/* 313 */     this._county = dao.getCounty();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 317 */     DeliveryModifierId id = (DeliveryModifierId)argId;
/* 318 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 319 */     argStatement.setString(2, id.getCustAccountId());
/* 320 */     argStatement.setString(3, id.getCustAccountCode());
/* 321 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 325 */     DeliveryModifierId id = new DeliveryModifierId();
/* 326 */     id.setOrganizationId(this._organizationId);
/* 327 */     id.setCustAccountId(this._custAccountId);
/* 328 */     id.setCustAccountCode(this._custAccountCode);
/* 329 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 337 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 341 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\DeliveryModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */