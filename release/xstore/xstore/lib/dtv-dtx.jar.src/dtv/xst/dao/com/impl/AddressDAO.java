/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AddressId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AddressDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 516961236L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AddressDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _addressId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _state;
/*     */   private String _postalCode;
/*     */   private String _country;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   
/*     */   public Long getOrganizationId() {
/*  46 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  50 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  51 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddressId() {
/*  56 */     return this._addressId;
/*     */   }
/*     */   
/*     */   public void setAddressId(String argAddressId) {
/*  60 */     if (changed(argAddressId, this._addressId, "addressId")) {
/*  61 */       this._addressId = (argAddressId != null && MANAGE_CASE) ? argAddressId.toUpperCase() : argAddressId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  66 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  70 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  71 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  77 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  81 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  82 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  87 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  91 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  92 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  98 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 102 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 103 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 108 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 112 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 113 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 118 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 122 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 123 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress1() {
/* 128 */     return this._address1;
/*     */   }
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 132 */     if (changed(argAddress1, this._address1, "address1")) {
/* 133 */       this._address1 = argAddress1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress2() {
/* 138 */     return this._address2;
/*     */   }
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 142 */     if (changed(argAddress2, this._address2, "address2")) {
/* 143 */       this._address2 = argAddress2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress3() {
/* 148 */     return this._address3;
/*     */   }
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 152 */     if (changed(argAddress3, this._address3, "address3")) {
/* 153 */       this._address3 = argAddress3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress4() {
/* 158 */     return this._address4;
/*     */   }
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 162 */     if (changed(argAddress4, this._address4, "address4")) {
/* 163 */       this._address4 = argAddress4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApartment() {
/* 168 */     return this._apartment;
/*     */   }
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 172 */     if (changed(argApartment, this._apartment, "apartment")) {
/* 173 */       this._apartment = argApartment;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCity() {
/* 178 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/* 182 */     if (changed(argCity, this._city, "city")) {
/* 183 */       this._city = argCity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getState() {
/* 188 */     return this._state;
/*     */   }
/*     */   
/*     */   public void setState(String argState) {
/* 192 */     if (changed(argState, this._state, "state")) {
/* 193 */       this._state = argState;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/* 198 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 202 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/* 203 */       this._postalCode = argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountry() {
/* 208 */     return this._country;
/*     */   }
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 212 */     if (changed(argCountry, this._country, "country")) {
/* 213 */       this._country = argCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNeighborhood() {
/* 218 */     return this._neighborhood;
/*     */   }
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 222 */     if (changed(argNeighborhood, this._neighborhood, "neighborhood")) {
/* 223 */       this._neighborhood = argNeighborhood;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCounty() {
/* 228 */     return this._county;
/*     */   }
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 232 */     if (changed(argCounty, this._county, "county")) {
/* 233 */       this._county = argCounty;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 240 */     StringBuilder buf = new StringBuilder(512);
/* 241 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 242 */     if (getOrganizationId() != null) {
/* 243 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 245 */     if (getAddressId() != null) {
/* 246 */       buf.append("addressId").append("=").append(getAddressId()).append(" ");
/*     */     }
/* 248 */     if (getCreateDate() != null) {
/* 249 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 251 */     if (getCreateUserId() != null) {
/* 252 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 254 */     if (getUpdateDate() != null) {
/* 255 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 257 */     if (getUpdateUserId() != null) {
/* 258 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 260 */     if (getOrgCode() != null) {
/* 261 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 263 */     if (getOrgValue() != null) {
/* 264 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 266 */     if (getAddress1() != null) {
/* 267 */       buf.append("address1").append("=").append(getAddress1()).append(" ");
/*     */     }
/* 269 */     if (getAddress2() != null) {
/* 270 */       buf.append("address2").append("=").append(getAddress2()).append(" ");
/*     */     }
/* 272 */     if (getAddress3() != null) {
/* 273 */       buf.append("address3").append("=").append(getAddress3()).append(" ");
/*     */     }
/* 275 */     if (getAddress4() != null) {
/* 276 */       buf.append("address4").append("=").append(getAddress4()).append(" ");
/*     */     }
/* 278 */     if (getApartment() != null) {
/* 279 */       buf.append("apartment").append("=").append(getApartment()).append(" ");
/*     */     }
/* 281 */     if (getCity() != null) {
/* 282 */       buf.append("city").append("=").append(getCity()).append(" ");
/*     */     }
/* 284 */     if (getState() != null) {
/* 285 */       buf.append("state").append("=").append(getState()).append(" ");
/*     */     }
/* 287 */     if (getPostalCode() != null) {
/* 288 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 290 */     if (getCountry() != null) {
/* 291 */       buf.append("country").append("=").append(getCountry()).append(" ");
/*     */     }
/* 293 */     if (getNeighborhood() != null) {
/* 294 */       buf.append("neighborhood").append("=").append(getNeighborhood()).append(" ");
/*     */     }
/* 296 */     if (getCounty() != null) {
/* 297 */       buf.append("county").append("=").append(getCounty()).append(" ");
/*     */     }
/*     */     
/* 300 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 304 */     AddressId id = new AddressId();
/* 305 */     id.setOrganizationId(getOrganizationId());
/* 306 */     id.setAddressId(getAddressId());
/* 307 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 311 */     setOrganizationId(((AddressId)argObjectId).getOrganizationId());
/* 312 */     setAddressId(((AddressId)argObjectId).getAddressId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 316 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 320 */     StringBuilder buf = new StringBuilder(950);
/* 321 */     buf.append("<").append("dao").append(" name=\"Address\" cmd=\"" + getObjectStateString() + "\">");
/* 322 */     getFieldsAsXml(buf);
/* 323 */     buf.append("</").append("dao").append(">");
/*     */     
/* 325 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 329 */     Map<String, String> values = super.getValues();
/* 330 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 331 */     if (this._addressId != null) values.put("AddressId", DaoUtils.getXmlSafeFieldValue(12, this._addressId)); 
/* 332 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 333 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 334 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 335 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 336 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 337 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 338 */     if (this._address1 != null) values.put("Address1", DaoUtils.getXmlSafeFieldValue(12, this._address1)); 
/* 339 */     if (this._address2 != null) values.put("Address2", DaoUtils.getXmlSafeFieldValue(12, this._address2)); 
/* 340 */     if (this._address3 != null) values.put("Address3", DaoUtils.getXmlSafeFieldValue(12, this._address3)); 
/* 341 */     if (this._address4 != null) values.put("Address4", DaoUtils.getXmlSafeFieldValue(12, this._address4)); 
/* 342 */     if (this._apartment != null) values.put("Apartment", DaoUtils.getXmlSafeFieldValue(12, this._apartment)); 
/* 343 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/* 344 */     if (this._state != null) values.put("State", DaoUtils.getXmlSafeFieldValue(12, this._state)); 
/* 345 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 346 */     if (this._country != null) values.put("Country", DaoUtils.getXmlSafeFieldValue(12, this._country)); 
/* 347 */     if (this._neighborhood != null) values.put("Neighborhood", DaoUtils.getXmlSafeFieldValue(12, this._neighborhood)); 
/* 348 */     if (this._county != null) values.put("County", DaoUtils.getXmlSafeFieldValue(12, this._county)); 
/* 349 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 354 */     super.setValues(argValues);
/* 355 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 357 */       String fieldName = field.getKey();
/* 358 */       String fieldValue = field.getValue();
/* 359 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 364 */             setOrganizationId((Long)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressId":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 373 */             setAddressId((String)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setAddressId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 382 */             setCreateDate((Date)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 391 */             setCreateUserId((String)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 400 */             setUpdateDate((Date)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 409 */             setUpdateUserId((String)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setOrgCode((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 427 */             setOrgValue((String)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address1":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 436 */             setAddress1((String)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setAddress1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address2":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 445 */             setAddress2((String)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setAddress2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address3":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 454 */             setAddress3((String)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setAddress3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address4":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 463 */             setAddress4((String)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setAddress4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Apartment":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 472 */             setApartment((String)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setApartment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "City":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 481 */             setCity((String)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "State":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 490 */             setState((String)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 498 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 499 */             setPostalCode((String)value);
/* 500 */           } catch (Exception ee) {
/* 501 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Country":
/*     */           try {
/* 507 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 508 */             setCountry((String)value);
/* 509 */           } catch (Exception ee) {
/* 510 */             throw new DtxException("An exception occurred while calling setCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Neighborhood":
/*     */           try {
/* 516 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 517 */             setNeighborhood((String)value);
/* 518 */           } catch (Exception ee) {
/* 519 */             throw new DtxException("An exception occurred while calling setNeighborhood() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "County":
/*     */           try {
/* 525 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 526 */             setCounty((String)value);
/* 527 */           } catch (Exception ee) {
/* 528 */             throw new DtxException("An exception occurred while calling setCounty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */