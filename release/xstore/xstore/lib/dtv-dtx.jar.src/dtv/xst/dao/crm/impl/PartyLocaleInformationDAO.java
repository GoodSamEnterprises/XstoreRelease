/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyLocaleInformationId;
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
/*     */ public class PartyLocaleInformationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1499026356L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PartyLocaleInformationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Integer _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _country;
/*     */   private String _postalCode;
/*     */   private String _state;
/*  41 */   private Boolean _contact = Boolean.FALSE;
/*  42 */   private Boolean _primary = Boolean.FALSE;
/*     */   private String _addressType;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   
/*     */   public Long getOrganizationId() {
/*  48 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  52 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  53 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  58 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  62 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  63 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  68 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  72 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  73 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  78 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  82 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  83 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  89 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  93 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  94 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  99 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 103 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 104 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 110 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 114 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 115 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress1() {
/* 120 */     return this._address1;
/*     */   }
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 124 */     if (changed(argAddress1, this._address1, "address1")) {
/* 125 */       this._address1 = argAddress1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress2() {
/* 130 */     return this._address2;
/*     */   }
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 134 */     if (changed(argAddress2, this._address2, "address2")) {
/* 135 */       this._address2 = argAddress2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress3() {
/* 140 */     return this._address3;
/*     */   }
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 144 */     if (changed(argAddress3, this._address3, "address3")) {
/* 145 */       this._address3 = argAddress3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress4() {
/* 150 */     return this._address4;
/*     */   }
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 154 */     if (changed(argAddress4, this._address4, "address4")) {
/* 155 */       this._address4 = argAddress4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApartment() {
/* 160 */     return this._apartment;
/*     */   }
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 164 */     if (changed(argApartment, this._apartment, "apartment")) {
/* 165 */       this._apartment = argApartment;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCity() {
/* 170 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/* 174 */     if (changed(argCity, this._city, "city")) {
/* 175 */       this._city = argCity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountry() {
/* 180 */     return this._country;
/*     */   }
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 184 */     if (changed(argCountry, this._country, "country")) {
/* 185 */       this._country = argCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/* 190 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 194 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/* 195 */       this._postalCode = argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getState() {
/* 200 */     return this._state;
/*     */   }
/*     */   
/*     */   public void setState(String argState) {
/* 204 */     if (changed(argState, this._state, "state")) {
/* 205 */       this._state = argState;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getContact() {
/* 210 */     return this._contact;
/*     */   }
/*     */   
/*     */   public void setContact(Boolean argContact) {
/* 214 */     if (changed(argContact, this._contact, "contact")) {
/* 215 */       this._contact = argContact;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPrimary() {
/* 220 */     return this._primary;
/*     */   }
/*     */   
/*     */   public void setPrimary(Boolean argPrimary) {
/* 224 */     if (changed(argPrimary, this._primary, "primary")) {
/* 225 */       this._primary = argPrimary;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddressType() {
/* 230 */     return this._addressType;
/*     */   }
/*     */   
/*     */   public void setAddressType(String argAddressType) {
/* 234 */     if (changed(argAddressType, this._addressType, "addressType")) {
/* 235 */       this._addressType = argAddressType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNeighborhood() {
/* 240 */     return this._neighborhood;
/*     */   }
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 244 */     if (changed(argNeighborhood, this._neighborhood, "neighborhood")) {
/* 245 */       this._neighborhood = argNeighborhood;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCounty() {
/* 250 */     return this._county;
/*     */   }
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 254 */     if (changed(argCounty, this._county, "county")) {
/* 255 */       this._county = argCounty;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 262 */     StringBuilder buf = new StringBuilder(512);
/* 263 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 264 */     if (getOrganizationId() != null) {
/* 265 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 267 */     if (getPartyId() != null) {
/* 268 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 270 */     if (getSequence() != null) {
/* 271 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 273 */     if (getCreateDate() != null) {
/* 274 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 276 */     if (getCreateUserId() != null) {
/* 277 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 279 */     if (getUpdateDate() != null) {
/* 280 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 282 */     if (getUpdateUserId() != null) {
/* 283 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 285 */     if (getAddress1() != null) {
/* 286 */       buf.append("address1").append("=").append(getAddress1()).append(" ");
/*     */     }
/* 288 */     if (getAddress2() != null) {
/* 289 */       buf.append("address2").append("=").append(getAddress2()).append(" ");
/*     */     }
/* 291 */     if (getAddress3() != null) {
/* 292 */       buf.append("address3").append("=").append(getAddress3()).append(" ");
/*     */     }
/* 294 */     if (getAddress4() != null) {
/* 295 */       buf.append("address4").append("=").append(getAddress4()).append(" ");
/*     */     }
/* 297 */     if (getApartment() != null) {
/* 298 */       buf.append("apartment").append("=").append(getApartment()).append(" ");
/*     */     }
/* 300 */     if (getCity() != null) {
/* 301 */       buf.append("city").append("=").append(getCity()).append(" ");
/*     */     }
/* 303 */     if (getCountry() != null) {
/* 304 */       buf.append("country").append("=").append(getCountry()).append(" ");
/*     */     }
/* 306 */     if (getPostalCode() != null) {
/* 307 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 309 */     if (getState() != null) {
/* 310 */       buf.append("state").append("=").append(getState()).append(" ");
/*     */     }
/* 312 */     if (getContact() != null && getContact().booleanValue()) {
/* 313 */       buf.append("contact").append("=").append(getContact()).append(" ");
/*     */     }
/* 315 */     if (getPrimary() != null && getPrimary().booleanValue()) {
/* 316 */       buf.append("primary").append("=").append(getPrimary()).append(" ");
/*     */     }
/* 318 */     if (getAddressType() != null) {
/* 319 */       buf.append("addressType").append("=").append(getAddressType()).append(" ");
/*     */     }
/* 321 */     if (getNeighborhood() != null) {
/* 322 */       buf.append("neighborhood").append("=").append(getNeighborhood()).append(" ");
/*     */     }
/* 324 */     if (getCounty() != null) {
/* 325 */       buf.append("county").append("=").append(getCounty()).append(" ");
/*     */     }
/*     */     
/* 328 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 332 */     PartyLocaleInformationId id = new PartyLocaleInformationId();
/* 333 */     id.setOrganizationId(getOrganizationId());
/* 334 */     id.setPartyId(getPartyId());
/* 335 */     id.setSequence(getSequence());
/* 336 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 340 */     setOrganizationId(((PartyLocaleInformationId)argObjectId).getOrganizationId());
/* 341 */     setPartyId(((PartyLocaleInformationId)argObjectId).getPartyId());
/* 342 */     setSequence(((PartyLocaleInformationId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 346 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 350 */     StringBuilder buf = new StringBuilder(1050);
/* 351 */     buf.append("<").append("dao").append(" name=\"PartyLocaleInformation\" cmd=\"" + getObjectStateString() + "\">");
/* 352 */     getFieldsAsXml(buf);
/* 353 */     buf.append("</").append("dao").append(">");
/*     */     
/* 355 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 359 */     Map<String, String> values = super.getValues();
/* 360 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 361 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 362 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 363 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 364 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 365 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 366 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 367 */     if (this._address1 != null) values.put("Address1", DaoUtils.getXmlSafeFieldValue(12, this._address1)); 
/* 368 */     if (this._address2 != null) values.put("Address2", DaoUtils.getXmlSafeFieldValue(12, this._address2)); 
/* 369 */     if (this._address3 != null) values.put("Address3", DaoUtils.getXmlSafeFieldValue(12, this._address3)); 
/* 370 */     if (this._address4 != null) values.put("Address4", DaoUtils.getXmlSafeFieldValue(12, this._address4)); 
/* 371 */     if (this._apartment != null) values.put("Apartment", DaoUtils.getXmlSafeFieldValue(12, this._apartment)); 
/* 372 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/* 373 */     if (this._country != null) values.put("Country", DaoUtils.getXmlSafeFieldValue(12, this._country)); 
/* 374 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 375 */     if (this._state != null) values.put("State", DaoUtils.getXmlSafeFieldValue(12, this._state)); 
/* 376 */     if (this._contact != null) values.put("Contact", DaoUtils.getXmlSafeFieldValue(-7, this._contact)); 
/* 377 */     if (this._primary != null) values.put("Primary", DaoUtils.getXmlSafeFieldValue(-7, this._primary)); 
/* 378 */     if (this._addressType != null) values.put("AddressType", DaoUtils.getXmlSafeFieldValue(12, this._addressType)); 
/* 379 */     if (this._neighborhood != null) values.put("Neighborhood", DaoUtils.getXmlSafeFieldValue(12, this._neighborhood)); 
/* 380 */     if (this._county != null) values.put("County", DaoUtils.getXmlSafeFieldValue(12, this._county)); 
/* 381 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 386 */     super.setValues(argValues);
/* 387 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 389 */       String fieldName = field.getKey();
/* 390 */       String fieldValue = field.getValue();
/* 391 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 396 */             setOrganizationId((Long)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 405 */             setPartyId((Long)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 414 */             setSequence((Integer)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 423 */             setCreateDate((Date)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 432 */             setCreateUserId((String)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 441 */             setUpdateDate((Date)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 449 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 450 */             setUpdateUserId((String)value);
/* 451 */           } catch (Exception ee) {
/* 452 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address1":
/*     */           try {
/* 458 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 459 */             setAddress1((String)value);
/* 460 */           } catch (Exception ee) {
/* 461 */             throw new DtxException("An exception occurred while calling setAddress1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address2":
/*     */           try {
/* 467 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 468 */             setAddress2((String)value);
/* 469 */           } catch (Exception ee) {
/* 470 */             throw new DtxException("An exception occurred while calling setAddress2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address3":
/*     */           try {
/* 476 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 477 */             setAddress3((String)value);
/* 478 */           } catch (Exception ee) {
/* 479 */             throw new DtxException("An exception occurred while calling setAddress3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address4":
/*     */           try {
/* 485 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 486 */             setAddress4((String)value);
/* 487 */           } catch (Exception ee) {
/* 488 */             throw new DtxException("An exception occurred while calling setAddress4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Apartment":
/*     */           try {
/* 494 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 495 */             setApartment((String)value);
/* 496 */           } catch (Exception ee) {
/* 497 */             throw new DtxException("An exception occurred while calling setApartment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "City":
/*     */           try {
/* 503 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 504 */             setCity((String)value);
/* 505 */           } catch (Exception ee) {
/* 506 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Country":
/*     */           try {
/* 512 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 513 */             setCountry((String)value);
/* 514 */           } catch (Exception ee) {
/* 515 */             throw new DtxException("An exception occurred while calling setCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 521 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 522 */             setPostalCode((String)value);
/* 523 */           } catch (Exception ee) {
/* 524 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "State":
/*     */           try {
/* 530 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 531 */             setState((String)value);
/* 532 */           } catch (Exception ee) {
/* 533 */             throw new DtxException("An exception occurred while calling setState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Contact":
/*     */           try {
/* 539 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 540 */             setContact((Boolean)value);
/* 541 */           } catch (Exception ee) {
/* 542 */             throw new DtxException("An exception occurred while calling setContact() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Primary":
/*     */           try {
/* 548 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 549 */             setPrimary((Boolean)value);
/* 550 */           } catch (Exception ee) {
/* 551 */             throw new DtxException("An exception occurred while calling setPrimary() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressType":
/*     */           try {
/* 557 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 558 */             setAddressType((String)value);
/* 559 */           } catch (Exception ee) {
/* 560 */             throw new DtxException("An exception occurred while calling setAddressType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Neighborhood":
/*     */           try {
/* 566 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 567 */             setNeighborhood((String)value);
/* 568 */           } catch (Exception ee) {
/* 569 */             throw new DtxException("An exception occurred while calling setNeighborhood() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "County":
/*     */           try {
/* 575 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 576 */             setCounty((String)value);
/* 577 */           } catch (Exception ee) {
/* 578 */             throw new DtxException("An exception occurred while calling setCounty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyLocaleInformationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */