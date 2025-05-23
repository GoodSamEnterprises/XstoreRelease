/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyId;
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
/*     */ public class PartyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 76884678L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _allegianceRetailLocationId;
/*     */   private Date _birthDate;
/*     */   private String _customerId;
/*     */   private String _employeeId;
/*     */   private String _nationalTaxId;
/*     */   private String _firstName;
/*     */   private String _firstName2;
/*     */   private String _gender;
/*     */   private String _lastName;
/*     */   private String _lastName2;
/*     */   private String _middleName;
/*     */   private String _preferredLocale;
/*     */   private String _organizationName;
/*     */   private String _organizationTypeCode;
/*     */   private String _partyTypeCode;
/*     */   private String _pictureUri;
/*     */   private String _salutation;
/*     */   private Long _signUpRetailLocationId;
/*     */   private String _socialSecurityNbr;
/*     */   private String _personalTaxId;
/*     */   private String _suffix;
/*     */   private Boolean _void;
/*     */   private Boolean _active;
/*     */   private Boolean _emailRcpts;
/*     */   private Date _anniversaryDate;
/*     */   private Boolean _prospect;
/*     */   private Boolean _rent;
/*     */   private Boolean _privacyCard;
/*     */   private Boolean _commercialCustomer;
/*     */   private String _contactPref;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.allegiance_rtl_loc_id, t.birth_date, t.cust_id, t.employee_id, t.national_tax_id, t.first_name, t.first_name2, t.gender, t.last_name, t.last_name2, t.middle_name, t.preferred_locale, t.organization_name, t.organization_typcode, t.party_typcode, t.picture_uri, t.salutation, t.sign_up_rtl_loc_id, t.social_security_nbr, t.personal_tax_id, t.suffix, t.void_flag, t.active_flag, t.email_rcpts_flag, t.anniversary_date, t.prospect_flag, t.rent_flag, t.privacy_card_flag, t.commercial_customer_flag, t.contact_pref FROM crm_party t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  65 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  69 */     return "SELECT t.organization_id, t.party_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.allegiance_rtl_loc_id, t.birth_date, t.cust_id, t.employee_id, t.national_tax_id, t.first_name, t.first_name2, t.gender, t.last_name, t.last_name2, t.middle_name, t.preferred_locale, t.organization_name, t.organization_typcode, t.party_typcode, t.picture_uri, t.salutation, t.sign_up_rtl_loc_id, t.social_security_nbr, t.personal_tax_id, t.suffix, t.void_flag, t.active_flag, t.email_rcpts_flag, t.anniversary_date, t.prospect_flag, t.rent_flag, t.privacy_card_flag, t.commercial_customer_flag, t.contact_pref FROM crm_party t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  75 */     return " WHERE organization_id = ?  AND party_id = ?  ";
/*     */   }
/*     */   
/*  78 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_party(organization_id, party_id, create_date, create_user_id, update_date, update_user_id, allegiance_rtl_loc_id, birth_date, cust_id, employee_id, national_tax_id, first_name, first_name2, gender, last_name, last_name2, middle_name, preferred_locale, organization_name, organization_typcode, party_typcode, picture_uri, salutation, sign_up_rtl_loc_id, social_security_nbr, personal_tax_id, suffix, void_flag, active_flag, email_rcpts_flag, anniversary_date, prospect_flag, rent_flag, privacy_card_flag, commercial_customer_flag, contact_pref) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  81 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  85 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._allegianceRetailLocationId, this._birthDate, this._customerId, this._employeeId, this._nationalTaxId, this._firstName, this._firstName2, this._gender, this._lastName, this._lastName2, this._middleName, this._preferredLocale, this._organizationName, this._organizationTypeCode, this._partyTypeCode, this._pictureUri, this._salutation, this._signUpRetailLocationId, this._socialSecurityNbr, this._personalTaxId, this._suffix, this._void, this._active, this._emailRcpts, this._anniversaryDate, this._prospect, this._rent, this._privacyCard, this._commercialCustomer, this._contactPref } };
/*  86 */     return insertParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, 12, 91, 12, -5, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -5, 12, 12, 12, -7, -7, -7, 91, -7, -7, -7, -7, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  92 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_party SET update_date = ?, update_user_id = ?, allegiance_rtl_loc_id = ?, birth_date = ?, cust_id = ?, employee_id = ?, national_tax_id = ?, first_name = ?, first_name2 = ?, gender = ?, last_name = ?, last_name2 = ?, middle_name = ?, preferred_locale = ?, organization_name = ?, organization_typcode = ?, party_typcode = ?, picture_uri = ?, salutation = ?, sign_up_rtl_loc_id = ?, social_security_nbr = ?, personal_tax_id = ?, suffix = ?, void_flag = ?, active_flag = ?, email_rcpts_flag = ?, anniversary_date = ?, prospect_flag = ?, rent_flag = ?, privacy_card_flag = ?, commercial_customer_flag = ?, contact_pref = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  98 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 102 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._allegianceRetailLocationId, this._birthDate, this._customerId, this._employeeId, this._nationalTaxId, this._firstName, this._firstName2, this._gender, this._lastName, this._lastName2, this._middleName, this._preferredLocale, this._organizationName, this._organizationTypeCode, this._partyTypeCode, this._pictureUri, this._salutation, this._signUpRetailLocationId, this._socialSecurityNbr, this._personalTaxId, this._suffix, this._void, this._active, this._emailRcpts, this._anniversaryDate, this._prospect, this._rent, this._privacyCard, this._commercialCustomer, this._contactPref } };
/* 103 */     return updateParameterObject;
/*     */   }
/*     */   
/* 106 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -5, 12, 12, 12, -7, -7, -7, 91, -7, -7, -7, -7, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 108 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 111 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_party" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 114 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 120 */     return " WHERE organization_id = ?  AND party_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 123 */     return new Object[] { this._organizationId, this._partyId };
/*     */   }
/*     */   
/* 126 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 129 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 132 */     return "crm_party";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 136 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 140 */     return new PartyFiller(this);
/*     */   }
/*     */   
/*     */   private static class PartyFiller
/*     */     implements IFiller {
/*     */     private PartyDBA _parent;
/*     */     
/*     */     public PartyFiller(PartyDBA argParent) {
/* 148 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 153 */       long primitiveResult = argResultSet.getLong(1);
/* 154 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 155 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 161 */       primitiveResult = argResultSet.getLong(2);
/* 162 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 163 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 168 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 169 */       if (t3 != null) {
/* 170 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 178 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 179 */       if (t5 != null) {
/* 180 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._updateUserId = argResultSet.getString(6);
/*     */ 
/*     */       
/* 189 */       long l1 = argResultSet.getLong(7);
/* 190 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 191 */         this._parent._allegianceRetailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 196 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 197 */       if (t8 != null) {
/* 198 */         this._parent._birthDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 201 */         this._parent._birthDate = null;
/*     */       } 
/*     */       
/* 204 */       this._parent._customerId = argResultSet.getString(9);
/* 205 */       this._parent._employeeId = argResultSet.getString(10);
/* 206 */       this._parent._nationalTaxId = argResultSet.getString(11);
/* 207 */       this._parent._firstName = argResultSet.getString(12);
/* 208 */       this._parent._firstName2 = argResultSet.getString(13);
/* 209 */       this._parent._gender = argResultSet.getString(14);
/* 210 */       this._parent._lastName = argResultSet.getString(15);
/* 211 */       this._parent._lastName2 = argResultSet.getString(16);
/* 212 */       this._parent._middleName = argResultSet.getString(17);
/* 213 */       this._parent._preferredLocale = argResultSet.getString(18);
/* 214 */       this._parent._organizationName = argResultSet.getString(19);
/* 215 */       this._parent._organizationTypeCode = argResultSet.getString(20);
/* 216 */       this._parent._partyTypeCode = argResultSet.getString(21);
/* 217 */       this._parent._pictureUri = argResultSet.getString(22);
/* 218 */       this._parent._salutation = argResultSet.getString(23);
/*     */ 
/*     */       
/* 221 */       long l2 = argResultSet.getLong(24);
/* 222 */       if (l2 != 0L || argResultSet.getObject(24) != null) {
/* 223 */         this._parent._signUpRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 227 */       this._parent._socialSecurityNbr = argResultSet.getString(25);
/* 228 */       this._parent._personalTaxId = argResultSet.getString(26);
/* 229 */       this._parent._suffix = argResultSet.getString(27);
/* 230 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(28));
/* 231 */       this._parent._active = Boolean.valueOf(argResultSet.getBoolean(29));
/* 232 */       this._parent._emailRcpts = Boolean.valueOf(argResultSet.getBoolean(30));
/*     */       
/* 234 */       Timestamp t31 = argResultSet.getTimestamp(31);
/* 235 */       if (t31 != null) {
/* 236 */         this._parent._anniversaryDate = (Date)new DtvDate(t31.getTime());
/*     */       } else {
/*     */         
/* 239 */         this._parent._anniversaryDate = null;
/*     */       } 
/*     */       
/* 242 */       this._parent._prospect = Boolean.valueOf(argResultSet.getBoolean(32));
/* 243 */       this._parent._rent = Boolean.valueOf(argResultSet.getBoolean(33));
/* 244 */       this._parent._privacyCard = Boolean.valueOf(argResultSet.getBoolean(34));
/* 245 */       this._parent._commercialCustomer = Boolean.valueOf(argResultSet.getBoolean(35));
/* 246 */       this._parent._contactPref = argResultSet.getString(36);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 251 */     argDAO.suppressStateChanges(true);
/* 252 */     PartyDAO dao = (PartyDAO)argDAO;
/* 253 */     dao.setOrganizationId(this._organizationId);
/* 254 */     dao.setPartyId(this._partyId);
/* 255 */     dao.setCreateDate(this._createDate);
/* 256 */     dao.setCreateUserId(this._createUserId);
/* 257 */     dao.setUpdateDate(this._updateDate);
/* 258 */     dao.setUpdateUserId(this._updateUserId);
/* 259 */     dao.setAllegianceRetailLocationId(this._allegianceRetailLocationId);
/* 260 */     dao.setBirthDate(this._birthDate);
/* 261 */     dao.setCustomerId(this._customerId);
/* 262 */     dao.setEmployeeId(this._employeeId);
/* 263 */     dao.setNationalTaxId(this._nationalTaxId);
/* 264 */     dao.setFirstName(this._firstName);
/* 265 */     dao.setFirstName2(this._firstName2);
/* 266 */     dao.setGender(this._gender);
/* 267 */     dao.setLastName(this._lastName);
/* 268 */     dao.setLastName2(this._lastName2);
/* 269 */     dao.setMiddleName(this._middleName);
/* 270 */     dao.setPreferredLocale(this._preferredLocale);
/* 271 */     dao.setOrganizationName(this._organizationName);
/* 272 */     dao.setOrganizationTypeCode(this._organizationTypeCode);
/* 273 */     dao.setPartyTypeCode(this._partyTypeCode);
/* 274 */     dao.setPictureUri(this._pictureUri);
/* 275 */     dao.setSalutation(this._salutation);
/* 276 */     dao.setSignUpRetailLocationId(this._signUpRetailLocationId);
/* 277 */     dao.setSocialSecurityNbr(this._socialSecurityNbr);
/* 278 */     dao.setPersonalTaxId(this._personalTaxId);
/* 279 */     dao.setSuffix(this._suffix);
/* 280 */     dao.setVoid(this._void);
/* 281 */     dao.setActive(this._active);
/* 282 */     dao.setEmailRcpts(this._emailRcpts);
/* 283 */     dao.setAnniversaryDate(this._anniversaryDate);
/* 284 */     dao.setProspect(this._prospect);
/* 285 */     dao.setRent(this._rent);
/* 286 */     dao.setPrivacyCard(this._privacyCard);
/* 287 */     dao.setCommercialCustomer(this._commercialCustomer);
/* 288 */     dao.setContactPref(this._contactPref);
/* 289 */     argDAO.suppressStateChanges(false);
/* 290 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 294 */     return loadDAO((IDataAccessObject)new PartyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 298 */     PartyDAO dao = (PartyDAO)argDAO;
/* 299 */     this._organizationId = dao.getOrganizationId();
/* 300 */     this._partyId = dao.getPartyId();
/* 301 */     this._createDate = dao.getCreateDate();
/* 302 */     this._createUserId = dao.getCreateUserId();
/* 303 */     this._updateDate = dao.getUpdateDate();
/* 304 */     this._updateUserId = dao.getUpdateUserId();
/* 305 */     this._allegianceRetailLocationId = dao.getAllegianceRetailLocationId();
/* 306 */     this._birthDate = dao.getBirthDate();
/* 307 */     this._customerId = dao.getCustomerId();
/* 308 */     this._employeeId = dao.getEmployeeId();
/* 309 */     this._nationalTaxId = dao.getNationalTaxId();
/* 310 */     this._firstName = dao.getFirstName();
/* 311 */     this._firstName2 = dao.getFirstName2();
/* 312 */     this._gender = dao.getGender();
/* 313 */     this._lastName = dao.getLastName();
/* 314 */     this._lastName2 = dao.getLastName2();
/* 315 */     this._middleName = dao.getMiddleName();
/* 316 */     this._preferredLocale = dao.getPreferredLocale();
/* 317 */     this._organizationName = dao.getOrganizationName();
/* 318 */     this._organizationTypeCode = dao.getOrganizationTypeCode();
/* 319 */     this._partyTypeCode = dao.getPartyTypeCode();
/* 320 */     this._pictureUri = dao.getPictureUri();
/* 321 */     this._salutation = dao.getSalutation();
/* 322 */     this._signUpRetailLocationId = dao.getSignUpRetailLocationId();
/* 323 */     this._socialSecurityNbr = dao.getSocialSecurityNbr();
/* 324 */     this._personalTaxId = dao.getPersonalTaxId();
/* 325 */     this._suffix = dao.getSuffix();
/* 326 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 327 */     this._active = (dao.getActive() != null) ? dao.getActive() : Boolean.valueOf(false);
/* 328 */     this._emailRcpts = (dao.getEmailRcpts() != null) ? dao.getEmailRcpts() : Boolean.valueOf(false);
/* 329 */     this._anniversaryDate = dao.getAnniversaryDate();
/* 330 */     this._prospect = (dao.getProspect() != null) ? dao.getProspect() : Boolean.valueOf(false);
/* 331 */     this._rent = (dao.getRent() != null) ? dao.getRent() : Boolean.valueOf(false);
/* 332 */     this._privacyCard = (dao.getPrivacyCard() != null) ? dao.getPrivacyCard() : Boolean.valueOf(false);
/* 333 */     this._commercialCustomer = (dao.getCommercialCustomer() != null) ? dao.getCommercialCustomer() : Boolean.valueOf(false);
/* 334 */     this._contactPref = dao.getContactPref();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 338 */     PartyId id = (PartyId)argId;
/* 339 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 340 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 341 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 345 */     PartyId id = new PartyId();
/* 346 */     id.setOrganizationId(this._organizationId);
/* 347 */     id.setPartyId(this._partyId);
/* 348 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 356 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 360 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */