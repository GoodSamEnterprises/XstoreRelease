/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyId;
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
/*     */ public class PartyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 76884678L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PartyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _allegianceRetailLocationId;
/*     */   private DtvDate _birthDate;
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
/*  52 */   private Boolean _void = Boolean.FALSE;
/*  53 */   private Boolean _active = Boolean.FALSE;
/*  54 */   private Boolean _emailRcpts = Boolean.FALSE;
/*     */   private DtvDate _anniversaryDate;
/*  56 */   private Boolean _prospect = Boolean.FALSE;
/*  57 */   private Boolean _rent = Boolean.FALSE;
/*  58 */   private Boolean _privacyCard = Boolean.FALSE;
/*  59 */   private Boolean _commercialCustomer = Boolean.FALSE;
/*     */   private String _contactPref;
/*     */   
/*     */   public Long getOrganizationId() {
/*  63 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  67 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  68 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  73 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  77 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  78 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  83 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  87 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  88 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  94 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  98 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  99 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 104 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 108 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 109 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 115 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 119 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 120 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getAllegianceRetailLocationId() {
/* 125 */     return this._allegianceRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setAllegianceRetailLocationId(Long argAllegianceRetailLocationId) {
/* 129 */     if (changed(argAllegianceRetailLocationId, this._allegianceRetailLocationId, "allegianceRetailLocationId")) {
/* 130 */       this._allegianceRetailLocationId = argAllegianceRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBirthDate() {
/* 135 */     return (Date)this._birthDate;
/*     */   }
/*     */   
/*     */   public void setBirthDate(Date argBirthDate) {
/* 139 */     if (changed(argBirthDate, this._birthDate, "birthDate")) {
/* 140 */       this._birthDate = (argBirthDate == null || argBirthDate instanceof DtvDate) ? (DtvDate)argBirthDate : new DtvDate(argBirthDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCustomerId() {
/* 146 */     return this._customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(String argCustomerId) {
/* 150 */     if (changed(argCustomerId, this._customerId, "customerId")) {
/* 151 */       this._customerId = argCustomerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmployeeId() {
/* 156 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 160 */     if (changed(argEmployeeId, this._employeeId, "employeeId")) {
/* 161 */       this._employeeId = argEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNationalTaxId() {
/* 166 */     return this._nationalTaxId;
/*     */   }
/*     */   
/*     */   public void setNationalTaxId(String argNationalTaxId) {
/* 170 */     if (changed(argNationalTaxId, this._nationalTaxId, "nationalTaxId")) {
/* 171 */       this._nationalTaxId = argNationalTaxId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/* 176 */     return this._firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/* 180 */     if (changed(argFirstName, this._firstName, "firstName")) {
/* 181 */       this._firstName = argFirstName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstName2() {
/* 186 */     return this._firstName2;
/*     */   }
/*     */   
/*     */   public void setFirstName2(String argFirstName2) {
/* 190 */     if (changed(argFirstName2, this._firstName2, "firstName2")) {
/* 191 */       this._firstName2 = argFirstName2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGender() {
/* 196 */     return this._gender;
/*     */   }
/*     */   
/*     */   public void setGender(String argGender) {
/* 200 */     if (changed(argGender, this._gender, "gender")) {
/* 201 */       this._gender = argGender;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLastName() {
/* 206 */     return this._lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 210 */     if (changed(argLastName, this._lastName, "lastName")) {
/* 211 */       this._lastName = argLastName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLastName2() {
/* 216 */     return this._lastName2;
/*     */   }
/*     */   
/*     */   public void setLastName2(String argLastName2) {
/* 220 */     if (changed(argLastName2, this._lastName2, "lastName2")) {
/* 221 */       this._lastName2 = argLastName2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMiddleName() {
/* 226 */     return this._middleName;
/*     */   }
/*     */   
/*     */   public void setMiddleName(String argMiddleName) {
/* 230 */     if (changed(argMiddleName, this._middleName, "middleName")) {
/* 231 */       this._middleName = argMiddleName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPreferredLocale() {
/* 236 */     return this._preferredLocale;
/*     */   }
/*     */   
/*     */   public void setPreferredLocale(String argPreferredLocale) {
/* 240 */     if (changed(argPreferredLocale, this._preferredLocale, "preferredLocale")) {
/* 241 */       this._preferredLocale = argPreferredLocale;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrganizationName() {
/* 246 */     return this._organizationName;
/*     */   }
/*     */   
/*     */   public void setOrganizationName(String argOrganizationName) {
/* 250 */     if (changed(argOrganizationName, this._organizationName, "organizationName")) {
/* 251 */       this._organizationName = argOrganizationName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrganizationTypeCode() {
/* 256 */     return this._organizationTypeCode;
/*     */   }
/*     */   
/*     */   public void setOrganizationTypeCode(String argOrganizationTypeCode) {
/* 260 */     if (changed(argOrganizationTypeCode, this._organizationTypeCode, "organizationTypeCode")) {
/* 261 */       this._organizationTypeCode = argOrganizationTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPartyTypeCode() {
/* 266 */     return this._partyTypeCode;
/*     */   }
/*     */   
/*     */   public void setPartyTypeCode(String argPartyTypeCode) {
/* 270 */     if (changed(argPartyTypeCode, this._partyTypeCode, "partyTypeCode")) {
/* 271 */       this._partyTypeCode = argPartyTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPictureUri() {
/* 276 */     return this._pictureUri;
/*     */   }
/*     */   
/*     */   public void setPictureUri(String argPictureUri) {
/* 280 */     if (changed(argPictureUri, this._pictureUri, "pictureUri")) {
/* 281 */       this._pictureUri = argPictureUri;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSalutation() {
/* 286 */     return this._salutation;
/*     */   }
/*     */   
/*     */   public void setSalutation(String argSalutation) {
/* 290 */     if (changed(argSalutation, this._salutation, "salutation")) {
/* 291 */       this._salutation = argSalutation;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSignUpRetailLocationId() {
/* 296 */     return this._signUpRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setSignUpRetailLocationId(Long argSignUpRetailLocationId) {
/* 300 */     if (changed(argSignUpRetailLocationId, this._signUpRetailLocationId, "signUpRetailLocationId")) {
/* 301 */       this._signUpRetailLocationId = argSignUpRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSocialSecurityNbr() {
/* 306 */     return this._socialSecurityNbr;
/*     */   }
/*     */   
/*     */   public void setSocialSecurityNbr(String argSocialSecurityNbr) {
/* 310 */     if (changed(argSocialSecurityNbr, this._socialSecurityNbr, "socialSecurityNbr")) {
/* 311 */       this._socialSecurityNbr = argSocialSecurityNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPersonalTaxId() {
/* 316 */     return this._personalTaxId;
/*     */   }
/*     */   
/*     */   public void setPersonalTaxId(String argPersonalTaxId) {
/* 320 */     if (changed(argPersonalTaxId, this._personalTaxId, "personalTaxId")) {
/* 321 */       this._personalTaxId = argPersonalTaxId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSuffix() {
/* 326 */     return this._suffix;
/*     */   }
/*     */   
/*     */   public void setSuffix(String argSuffix) {
/* 330 */     if (changed(argSuffix, this._suffix, "suffix")) {
/* 331 */       this._suffix = argSuffix;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 336 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 340 */     if (changed(argVoid, this._void, "void")) {
/* 341 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getActive() {
/* 346 */     return this._active;
/*     */   }
/*     */   
/*     */   public void setActive(Boolean argActive) {
/* 350 */     if (changed(argActive, this._active, "active")) {
/* 351 */       this._active = argActive;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getEmailRcpts() {
/* 356 */     return this._emailRcpts;
/*     */   }
/*     */   
/*     */   public void setEmailRcpts(Boolean argEmailRcpts) {
/* 360 */     if (changed(argEmailRcpts, this._emailRcpts, "emailRcpts")) {
/* 361 */       this._emailRcpts = argEmailRcpts;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getAnniversaryDate() {
/* 366 */     return (Date)this._anniversaryDate;
/*     */   }
/*     */   
/*     */   public void setAnniversaryDate(Date argAnniversaryDate) {
/* 370 */     if (changed(argAnniversaryDate, this._anniversaryDate, "anniversaryDate")) {
/* 371 */       this._anniversaryDate = (argAnniversaryDate == null || argAnniversaryDate instanceof DtvDate) ? (DtvDate)argAnniversaryDate : new DtvDate(argAnniversaryDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getProspect() {
/* 377 */     return this._prospect;
/*     */   }
/*     */   
/*     */   public void setProspect(Boolean argProspect) {
/* 381 */     if (changed(argProspect, this._prospect, "prospect")) {
/* 382 */       this._prospect = argProspect;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getRent() {
/* 387 */     return this._rent;
/*     */   }
/*     */   
/*     */   public void setRent(Boolean argRent) {
/* 391 */     if (changed(argRent, this._rent, "rent")) {
/* 392 */       this._rent = argRent;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPrivacyCard() {
/* 397 */     return this._privacyCard;
/*     */   }
/*     */   
/*     */   public void setPrivacyCard(Boolean argPrivacyCard) {
/* 401 */     if (changed(argPrivacyCard, this._privacyCard, "privacyCard")) {
/* 402 */       this._privacyCard = argPrivacyCard;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCommercialCustomer() {
/* 407 */     return this._commercialCustomer;
/*     */   }
/*     */   
/*     */   public void setCommercialCustomer(Boolean argCommercialCustomer) {
/* 411 */     if (changed(argCommercialCustomer, this._commercialCustomer, "commercialCustomer")) {
/* 412 */       this._commercialCustomer = argCommercialCustomer;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getContactPref() {
/* 417 */     return this._contactPref;
/*     */   }
/*     */   
/*     */   public void setContactPref(String argContactPref) {
/* 421 */     if (changed(argContactPref, this._contactPref, "contactPref")) {
/* 422 */       this._contactPref = argContactPref;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 429 */     StringBuilder buf = new StringBuilder(512);
/* 430 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 431 */     if (getOrganizationId() != null) {
/* 432 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 434 */     if (getPartyId() != null) {
/* 435 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 437 */     if (getCreateDate() != null) {
/* 438 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 440 */     if (getCreateUserId() != null) {
/* 441 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 443 */     if (getUpdateDate() != null) {
/* 444 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 446 */     if (getUpdateUserId() != null) {
/* 447 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 449 */     if (getAllegianceRetailLocationId() != null) {
/* 450 */       buf.append("allegianceRetailLocationId").append("=").append(getAllegianceRetailLocationId()).append(" ");
/*     */     }
/* 452 */     if (getBirthDate() != null) {
/* 453 */       buf.append("birthDate").append("=").append(getBirthDate()).append(" ");
/*     */     }
/* 455 */     if (getCustomerId() != null) {
/* 456 */       buf.append("customerId").append("=").append(getCustomerId()).append(" ");
/*     */     }
/* 458 */     if (getEmployeeId() != null) {
/* 459 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*     */     }
/* 461 */     if (getNationalTaxId() != null) {
/* 462 */       buf.append("nationalTaxId").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 464 */     if (getFirstName() != null) {
/* 465 */       buf.append("firstName").append("=").append(getFirstName()).append(" ");
/*     */     }
/* 467 */     if (getFirstName2() != null) {
/* 468 */       buf.append("firstName2").append("=").append(getFirstName2()).append(" ");
/*     */     }
/* 470 */     if (getGender() != null) {
/* 471 */       buf.append("gender").append("=").append(getGender()).append(" ");
/*     */     }
/* 473 */     if (getLastName() != null) {
/* 474 */       buf.append("lastName").append("=").append(getLastName()).append(" ");
/*     */     }
/* 476 */     if (getLastName2() != null) {
/* 477 */       buf.append("lastName2").append("=").append(getLastName2()).append(" ");
/*     */     }
/* 479 */     if (getMiddleName() != null) {
/* 480 */       buf.append("middleName").append("=").append(getMiddleName()).append(" ");
/*     */     }
/* 482 */     if (getPreferredLocale() != null) {
/* 483 */       buf.append("preferredLocale").append("=").append(getPreferredLocale()).append(" ");
/*     */     }
/* 485 */     if (getOrganizationName() != null) {
/* 486 */       buf.append("organizationName").append("=").append(getOrganizationName()).append(" ");
/*     */     }
/* 488 */     if (getOrganizationTypeCode() != null) {
/* 489 */       buf.append("organizationTypeCode").append("=").append(getOrganizationTypeCode()).append(" ");
/*     */     }
/* 491 */     if (getPartyTypeCode() != null) {
/* 492 */       buf.append("partyTypeCode").append("=").append(getPartyTypeCode()).append(" ");
/*     */     }
/* 494 */     if (getPictureUri() != null) {
/* 495 */       buf.append("pictureUri").append("=").append(getPictureUri()).append(" ");
/*     */     }
/* 497 */     if (getSalutation() != null) {
/* 498 */       buf.append("salutation").append("=").append(getSalutation()).append(" ");
/*     */     }
/* 500 */     if (getSignUpRetailLocationId() != null) {
/* 501 */       buf.append("signUpRetailLocationId").append("=").append(getSignUpRetailLocationId()).append(" ");
/*     */     }
/* 503 */     if (getSocialSecurityNbr() != null) {
/* 504 */       buf.append("socialSecurityNbr").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 506 */     if (getPersonalTaxId() != null) {
/* 507 */       buf.append("personalTaxId").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 509 */     if (getSuffix() != null) {
/* 510 */       buf.append("suffix").append("=").append(getSuffix()).append(" ");
/*     */     }
/* 512 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 513 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 515 */     if (getActive() != null && getActive().booleanValue()) {
/* 516 */       buf.append("active").append("=").append(getActive()).append(" ");
/*     */     }
/* 518 */     if (getEmailRcpts() != null && getEmailRcpts().booleanValue()) {
/* 519 */       buf.append("emailRcpts").append("=").append(getEmailRcpts()).append(" ");
/*     */     }
/* 521 */     if (getAnniversaryDate() != null) {
/* 522 */       buf.append("anniversaryDate").append("=").append(getAnniversaryDate()).append(" ");
/*     */     }
/* 524 */     if (getProspect() != null && getProspect().booleanValue()) {
/* 525 */       buf.append("prospect").append("=").append(getProspect()).append(" ");
/*     */     }
/* 527 */     if (getRent() != null && getRent().booleanValue()) {
/* 528 */       buf.append("rent").append("=").append(getRent()).append(" ");
/*     */     }
/* 530 */     if (getPrivacyCard() != null && getPrivacyCard().booleanValue()) {
/* 531 */       buf.append("privacyCard").append("=").append(getPrivacyCard()).append(" ");
/*     */     }
/* 533 */     if (getCommercialCustomer() != null && getCommercialCustomer().booleanValue()) {
/* 534 */       buf.append("commercialCustomer").append("=").append(getCommercialCustomer()).append(" ");
/*     */     }
/* 536 */     if (getContactPref() != null) {
/* 537 */       buf.append("contactPref").append("=").append(getContactPref()).append(" ");
/*     */     }
/*     */     
/* 540 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 544 */     PartyId id = new PartyId();
/* 545 */     id.setOrganizationId(getOrganizationId());
/* 546 */     id.setPartyId(getPartyId());
/* 547 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 551 */     setOrganizationId(((PartyId)argObjectId).getOrganizationId());
/* 552 */     setPartyId(((PartyId)argObjectId).getPartyId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 556 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 560 */     StringBuilder buf = new StringBuilder(1800);
/* 561 */     buf.append("<").append("dao").append(" name=\"Party\" cmd=\"" + getObjectStateString() + "\">");
/* 562 */     getFieldsAsXml(buf);
/* 563 */     buf.append("</").append("dao").append(">");
/*     */     
/* 565 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 569 */     Map<String, String> values = super.getValues();
/* 570 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 571 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 572 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 573 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 574 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 575 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 576 */     if (this._allegianceRetailLocationId != null) values.put("AllegianceRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._allegianceRetailLocationId)); 
/* 577 */     if (this._birthDate != null) values.put("BirthDate", DaoUtils.getXmlSafeFieldValue(91, this._birthDate)); 
/* 578 */     if (this._customerId != null) values.put("CustomerId", DaoUtils.getXmlSafeFieldValue(12, this._customerId)); 
/* 579 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/* 580 */     if (this._nationalTaxId != null) values.put("NationalTaxId", DaoUtils.getXmlSafeFieldValue(12, this._nationalTaxId)); 
/* 581 */     if (this._firstName != null) values.put("FirstName", DaoUtils.getXmlSafeFieldValue(12, this._firstName)); 
/* 582 */     if (this._firstName2 != null) values.put("FirstName2", DaoUtils.getXmlSafeFieldValue(12, this._firstName2)); 
/* 583 */     if (this._gender != null) values.put("Gender", DaoUtils.getXmlSafeFieldValue(12, this._gender)); 
/* 584 */     if (this._lastName != null) values.put("LastName", DaoUtils.getXmlSafeFieldValue(12, this._lastName)); 
/* 585 */     if (this._lastName2 != null) values.put("LastName2", DaoUtils.getXmlSafeFieldValue(12, this._lastName2)); 
/* 586 */     if (this._middleName != null) values.put("MiddleName", DaoUtils.getXmlSafeFieldValue(12, this._middleName)); 
/* 587 */     if (this._preferredLocale != null) values.put("PreferredLocale", DaoUtils.getXmlSafeFieldValue(12, this._preferredLocale)); 
/* 588 */     if (this._organizationName != null) values.put("OrganizationName", DaoUtils.getXmlSafeFieldValue(12, this._organizationName)); 
/* 589 */     if (this._organizationTypeCode != null) values.put("OrganizationTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._organizationTypeCode)); 
/* 590 */     if (this._partyTypeCode != null) values.put("PartyTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._partyTypeCode)); 
/* 591 */     if (this._pictureUri != null) values.put("PictureUri", DaoUtils.getXmlSafeFieldValue(12, this._pictureUri)); 
/* 592 */     if (this._salutation != null) values.put("Salutation", DaoUtils.getXmlSafeFieldValue(12, this._salutation)); 
/* 593 */     if (this._signUpRetailLocationId != null) values.put("SignUpRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._signUpRetailLocationId)); 
/* 594 */     if (this._socialSecurityNbr != null) values.put("SocialSecurityNbr", DaoUtils.getXmlSafeFieldValue(12, this._socialSecurityNbr)); 
/* 595 */     if (this._personalTaxId != null) values.put("PersonalTaxId", DaoUtils.getXmlSafeFieldValue(12, this._personalTaxId)); 
/* 596 */     if (this._suffix != null) values.put("Suffix", DaoUtils.getXmlSafeFieldValue(12, this._suffix)); 
/* 597 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 598 */     if (this._active != null) values.put("Active", DaoUtils.getXmlSafeFieldValue(-7, this._active)); 
/* 599 */     if (this._emailRcpts != null) values.put("EmailRcpts", DaoUtils.getXmlSafeFieldValue(-7, this._emailRcpts)); 
/* 600 */     if (this._anniversaryDate != null) values.put("AnniversaryDate", DaoUtils.getXmlSafeFieldValue(91, this._anniversaryDate)); 
/* 601 */     if (this._prospect != null) values.put("Prospect", DaoUtils.getXmlSafeFieldValue(-7, this._prospect)); 
/* 602 */     if (this._rent != null) values.put("Rent", DaoUtils.getXmlSafeFieldValue(-7, this._rent)); 
/* 603 */     if (this._privacyCard != null) values.put("PrivacyCard", DaoUtils.getXmlSafeFieldValue(-7, this._privacyCard)); 
/* 604 */     if (this._commercialCustomer != null) values.put("CommercialCustomer", DaoUtils.getXmlSafeFieldValue(-7, this._commercialCustomer)); 
/* 605 */     if (this._contactPref != null) values.put("ContactPref", DaoUtils.getXmlSafeFieldValue(12, this._contactPref)); 
/* 606 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 611 */     super.setValues(argValues);
/* 612 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 614 */       String fieldName = field.getKey();
/* 615 */       String fieldValue = field.getValue();
/* 616 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 620 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 621 */             setOrganizationId((Long)value);
/* 622 */           } catch (Exception ee) {
/* 623 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 629 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 630 */             setPartyId((Long)value);
/* 631 */           } catch (Exception ee) {
/* 632 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 638 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 639 */             setCreateDate((Date)value);
/* 640 */           } catch (Exception ee) {
/* 641 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 647 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 648 */             setCreateUserId((String)value);
/* 649 */           } catch (Exception ee) {
/* 650 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 656 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 657 */             setUpdateDate((Date)value);
/* 658 */           } catch (Exception ee) {
/* 659 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 665 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 666 */             setUpdateUserId((String)value);
/* 667 */           } catch (Exception ee) {
/* 668 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AllegianceRetailLocationId":
/*     */           try {
/* 674 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 675 */             setAllegianceRetailLocationId((Long)value);
/* 676 */           } catch (Exception ee) {
/* 677 */             throw new DtxException("An exception occurred while calling setAllegianceRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BirthDate":
/*     */           try {
/* 683 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 684 */             setBirthDate((Date)value);
/* 685 */           } catch (Exception ee) {
/* 686 */             throw new DtxException("An exception occurred while calling setBirthDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerId":
/*     */           try {
/* 692 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 693 */             setCustomerId((String)value);
/* 694 */           } catch (Exception ee) {
/* 695 */             throw new DtxException("An exception occurred while calling setCustomerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeId":
/*     */           try {
/* 701 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 702 */             setEmployeeId((String)value);
/* 703 */           } catch (Exception ee) {
/* 704 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NationalTaxId":
/*     */           try {
/* 710 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 711 */             setNationalTaxId((String)value);
/* 712 */           } catch (Exception ee) {
/* 713 */             throw new DtxException("An exception occurred while calling setNationalTaxId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstName":
/*     */           try {
/* 719 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 720 */             setFirstName((String)value);
/* 721 */           } catch (Exception ee) {
/* 722 */             throw new DtxException("An exception occurred while calling setFirstName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstName2":
/*     */           try {
/* 728 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 729 */             setFirstName2((String)value);
/* 730 */           } catch (Exception ee) {
/* 731 */             throw new DtxException("An exception occurred while calling setFirstName2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Gender":
/*     */           try {
/* 737 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 738 */             setGender((String)value);
/* 739 */           } catch (Exception ee) {
/* 740 */             throw new DtxException("An exception occurred while calling setGender() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastName":
/*     */           try {
/* 746 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 747 */             setLastName((String)value);
/* 748 */           } catch (Exception ee) {
/* 749 */             throw new DtxException("An exception occurred while calling setLastName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastName2":
/*     */           try {
/* 755 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 756 */             setLastName2((String)value);
/* 757 */           } catch (Exception ee) {
/* 758 */             throw new DtxException("An exception occurred while calling setLastName2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MiddleName":
/*     */           try {
/* 764 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 765 */             setMiddleName((String)value);
/* 766 */           } catch (Exception ee) {
/* 767 */             throw new DtxException("An exception occurred while calling setMiddleName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PreferredLocale":
/*     */           try {
/* 773 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 774 */             setPreferredLocale((String)value);
/* 775 */           } catch (Exception ee) {
/* 776 */             throw new DtxException("An exception occurred while calling setPreferredLocale() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationName":
/*     */           try {
/* 782 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 783 */             setOrganizationName((String)value);
/* 784 */           } catch (Exception ee) {
/* 785 */             throw new DtxException("An exception occurred while calling setOrganizationName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationTypeCode":
/*     */           try {
/* 791 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 792 */             setOrganizationTypeCode((String)value);
/* 793 */           } catch (Exception ee) {
/* 794 */             throw new DtxException("An exception occurred while calling setOrganizationTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyTypeCode":
/*     */           try {
/* 800 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 801 */             setPartyTypeCode((String)value);
/* 802 */           } catch (Exception ee) {
/* 803 */             throw new DtxException("An exception occurred while calling setPartyTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PictureUri":
/*     */           try {
/* 809 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 810 */             setPictureUri((String)value);
/* 811 */           } catch (Exception ee) {
/* 812 */             throw new DtxException("An exception occurred while calling setPictureUri() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Salutation":
/*     */           try {
/* 818 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 819 */             setSalutation((String)value);
/* 820 */           } catch (Exception ee) {
/* 821 */             throw new DtxException("An exception occurred while calling setSalutation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SignUpRetailLocationId":
/*     */           try {
/* 827 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 828 */             setSignUpRetailLocationId((Long)value);
/* 829 */           } catch (Exception ee) {
/* 830 */             throw new DtxException("An exception occurred while calling setSignUpRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SocialSecurityNbr":
/*     */           try {
/* 836 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 837 */             setSocialSecurityNbr((String)value);
/* 838 */           } catch (Exception ee) {
/* 839 */             throw new DtxException("An exception occurred while calling setSocialSecurityNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PersonalTaxId":
/*     */           try {
/* 845 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 846 */             setPersonalTaxId((String)value);
/* 847 */           } catch (Exception ee) {
/* 848 */             throw new DtxException("An exception occurred while calling setPersonalTaxId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Suffix":
/*     */           try {
/* 854 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 855 */             setSuffix((String)value);
/* 856 */           } catch (Exception ee) {
/* 857 */             throw new DtxException("An exception occurred while calling setSuffix() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 863 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 864 */             setVoid((Boolean)value);
/* 865 */           } catch (Exception ee) {
/* 866 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Active":
/*     */           try {
/* 872 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 873 */             setActive((Boolean)value);
/* 874 */           } catch (Exception ee) {
/* 875 */             throw new DtxException("An exception occurred while calling setActive() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailRcpts":
/*     */           try {
/* 881 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 882 */             setEmailRcpts((Boolean)value);
/* 883 */           } catch (Exception ee) {
/* 884 */             throw new DtxException("An exception occurred while calling setEmailRcpts() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AnniversaryDate":
/*     */           try {
/* 890 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 891 */             setAnniversaryDate((Date)value);
/* 892 */           } catch (Exception ee) {
/* 893 */             throw new DtxException("An exception occurred while calling setAnniversaryDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Prospect":
/*     */           try {
/* 899 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 900 */             setProspect((Boolean)value);
/* 901 */           } catch (Exception ee) {
/* 902 */             throw new DtxException("An exception occurred while calling setProspect() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Rent":
/*     */           try {
/* 908 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 909 */             setRent((Boolean)value);
/* 910 */           } catch (Exception ee) {
/* 911 */             throw new DtxException("An exception occurred while calling setRent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PrivacyCard":
/*     */           try {
/* 917 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 918 */             setPrivacyCard((Boolean)value);
/* 919 */           } catch (Exception ee) {
/* 920 */             throw new DtxException("An exception occurred while calling setPrivacyCard() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CommercialCustomer":
/*     */           try {
/* 926 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 927 */             setCommercialCustomer((Boolean)value);
/* 928 */           } catch (Exception ee) {
/* 929 */             throw new DtxException("An exception occurred while calling setCommercialCustomer() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ContactPref":
/*     */           try {
/* 935 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 936 */             setContactPref((String)value);
/* 937 */           } catch (Exception ee) {
/* 938 */             throw new DtxException("An exception occurred while calling setContactPref() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */