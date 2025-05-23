/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxExemptionId;
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
/*     */ public class TaxExemptionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1164693378L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TaxExemptionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _taxExemptionId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _certificateHolderName;
/*     */   private String _certificateNbr;
/*     */   private Long _partyId;
/*     */   private String _reasonCode;
/*     */   private DtvDate _expirationDate;
/*     */   private String _certificateCountry;
/*     */   private String _certificateState;
/*     */   private String _notes;
/*     */   private String _phoneNumber;
/*     */   private String _region;
/*     */   private String _diplomaticTitle;
/*     */   private String _certHolderFirstName;
/*     */   private String _certHolderLastName;
/*     */   private String _addressId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  47 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  51 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  52 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxExemptionId() {
/*  57 */     return this._taxExemptionId;
/*     */   }
/*     */   
/*     */   public void setTaxExemptionId(String argTaxExemptionId) {
/*  61 */     if (changed(argTaxExemptionId, this._taxExemptionId, "taxExemptionId")) {
/*  62 */       this._taxExemptionId = (argTaxExemptionId != null && MANAGE_CASE) ? argTaxExemptionId.toUpperCase() : argTaxExemptionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  67 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  71 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  72 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  78 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  82 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  83 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  88 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  92 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  93 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  99 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 103 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 104 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertificateHolderName() {
/* 109 */     return this._certificateHolderName;
/*     */   }
/*     */   
/*     */   public void setCertificateHolderName(String argCertificateHolderName) {
/* 113 */     if (changed(argCertificateHolderName, this._certificateHolderName, "certificateHolderName")) {
/* 114 */       this._certificateHolderName = argCertificateHolderName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertificateNbr() {
/* 119 */     return this._certificateNbr;
/*     */   }
/*     */   
/*     */   public void setCertificateNbr(String argCertificateNbr) {
/* 123 */     if (changed(argCertificateNbr, this._certificateNbr, "certificateNbr")) {
/* 124 */       this._certificateNbr = argCertificateNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 129 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 133 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 134 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReasonCode() {
/* 139 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 143 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/* 144 */       this._reasonCode = argReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 149 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 153 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 154 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCertificateCountry() {
/* 160 */     return this._certificateCountry;
/*     */   }
/*     */   
/*     */   public void setCertificateCountry(String argCertificateCountry) {
/* 164 */     if (changed(argCertificateCountry, this._certificateCountry, "certificateCountry")) {
/* 165 */       this._certificateCountry = argCertificateCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertificateState() {
/* 170 */     return this._certificateState;
/*     */   }
/*     */   
/*     */   public void setCertificateState(String argCertificateState) {
/* 174 */     if (changed(argCertificateState, this._certificateState, "certificateState")) {
/* 175 */       this._certificateState = argCertificateState;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNotes() {
/* 180 */     return this._notes;
/*     */   }
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 184 */     if (changed(argNotes, this._notes, "notes")) {
/* 185 */       this._notes = argNotes;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPhoneNumber() {
/* 190 */     return this._phoneNumber;
/*     */   }
/*     */   
/*     */   public void setPhoneNumber(String argPhoneNumber) {
/* 194 */     if (changed(argPhoneNumber, this._phoneNumber, "phoneNumber")) {
/* 195 */       this._phoneNumber = argPhoneNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRegion() {
/* 200 */     return this._region;
/*     */   }
/*     */   
/*     */   public void setRegion(String argRegion) {
/* 204 */     if (changed(argRegion, this._region, "region")) {
/* 205 */       this._region = argRegion;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDiplomaticTitle() {
/* 210 */     return this._diplomaticTitle;
/*     */   }
/*     */   
/*     */   public void setDiplomaticTitle(String argDiplomaticTitle) {
/* 214 */     if (changed(argDiplomaticTitle, this._diplomaticTitle, "diplomaticTitle")) {
/* 215 */       this._diplomaticTitle = argDiplomaticTitle;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertHolderFirstName() {
/* 220 */     return this._certHolderFirstName;
/*     */   }
/*     */   
/*     */   public void setCertHolderFirstName(String argCertHolderFirstName) {
/* 224 */     if (changed(argCertHolderFirstName, this._certHolderFirstName, "certHolderFirstName")) {
/* 225 */       this._certHolderFirstName = argCertHolderFirstName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertHolderLastName() {
/* 230 */     return this._certHolderLastName;
/*     */   }
/*     */   
/*     */   public void setCertHolderLastName(String argCertHolderLastName) {
/* 234 */     if (changed(argCertHolderLastName, this._certHolderLastName, "certHolderLastName")) {
/* 235 */       this._certHolderLastName = argCertHolderLastName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddressId() {
/* 240 */     return this._addressId;
/*     */   }
/*     */   
/*     */   public void setAddressId(String argAddressId) {
/* 244 */     if (changed(argAddressId, this._addressId, "addressId")) {
/* 245 */       this._addressId = argAddressId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 252 */     StringBuilder buf = new StringBuilder(512);
/* 253 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 254 */     if (getOrganizationId() != null) {
/* 255 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 257 */     if (getTaxExemptionId() != null) {
/* 258 */       buf.append("taxExemptionId").append("=").append(getTaxExemptionId()).append(" ");
/*     */     }
/* 260 */     if (getCreateDate() != null) {
/* 261 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 263 */     if (getCreateUserId() != null) {
/* 264 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 266 */     if (getUpdateDate() != null) {
/* 267 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 269 */     if (getUpdateUserId() != null) {
/* 270 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 272 */     if (getCertificateHolderName() != null) {
/* 273 */       buf.append("certificateHolderName").append("=").append(getCertificateHolderName()).append(" ");
/*     */     }
/* 275 */     if (getCertificateNbr() != null) {
/* 276 */       buf.append("certificateNbr").append("=").append(getCertificateNbr()).append(" ");
/*     */     }
/* 278 */     if (getPartyId() != null) {
/* 279 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 281 */     if (getReasonCode() != null) {
/* 282 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/* 284 */     if (getExpirationDate() != null) {
/* 285 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 287 */     if (getCertificateCountry() != null) {
/* 288 */       buf.append("certificateCountry").append("=").append(getCertificateCountry()).append(" ");
/*     */     }
/* 290 */     if (getCertificateState() != null) {
/* 291 */       buf.append("certificateState").append("=").append(getCertificateState()).append(" ");
/*     */     }
/* 293 */     if (getNotes() != null) {
/* 294 */       buf.append("notes").append("=").append(getNotes()).append(" ");
/*     */     }
/* 296 */     if (getPhoneNumber() != null) {
/* 297 */       buf.append("phoneNumber").append("=").append(getPhoneNumber()).append(" ");
/*     */     }
/* 299 */     if (getRegion() != null) {
/* 300 */       buf.append("region").append("=").append(getRegion()).append(" ");
/*     */     }
/* 302 */     if (getDiplomaticTitle() != null) {
/* 303 */       buf.append("diplomaticTitle").append("=").append(getDiplomaticTitle()).append(" ");
/*     */     }
/* 305 */     if (getCertHolderFirstName() != null) {
/* 306 */       buf.append("certHolderFirstName").append("=").append(getCertHolderFirstName()).append(" ");
/*     */     }
/* 308 */     if (getCertHolderLastName() != null) {
/* 309 */       buf.append("certHolderLastName").append("=").append(getCertHolderLastName()).append(" ");
/*     */     }
/* 311 */     if (getAddressId() != null) {
/* 312 */       buf.append("addressId").append("=").append(getAddressId()).append(" ");
/*     */     }
/*     */     
/* 315 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 319 */     TaxExemptionId id = new TaxExemptionId();
/* 320 */     id.setOrganizationId(getOrganizationId());
/* 321 */     id.setTaxExemptionId(getTaxExemptionId());
/* 322 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 326 */     setOrganizationId(((TaxExemptionId)argObjectId).getOrganizationId());
/* 327 */     setTaxExemptionId(((TaxExemptionId)argObjectId).getTaxExemptionId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 331 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 335 */     StringBuilder buf = new StringBuilder(1000);
/* 336 */     buf.append("<").append("dao").append(" name=\"TaxExemption\" cmd=\"" + getObjectStateString() + "\">");
/* 337 */     getFieldsAsXml(buf);
/* 338 */     buf.append("</").append("dao").append(">");
/*     */     
/* 340 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 344 */     Map<String, String> values = super.getValues();
/* 345 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 346 */     if (this._taxExemptionId != null) values.put("TaxExemptionId", DaoUtils.getXmlSafeFieldValue(12, this._taxExemptionId)); 
/* 347 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 348 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 349 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 350 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 351 */     if (this._certificateHolderName != null) values.put("CertificateHolderName", DaoUtils.getXmlSafeFieldValue(12, this._certificateHolderName)); 
/* 352 */     if (this._certificateNbr != null) values.put("CertificateNbr", DaoUtils.getXmlSafeFieldValue(12, this._certificateNbr)); 
/* 353 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 354 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 355 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 356 */     if (this._certificateCountry != null) values.put("CertificateCountry", DaoUtils.getXmlSafeFieldValue(12, this._certificateCountry)); 
/* 357 */     if (this._certificateState != null) values.put("CertificateState", DaoUtils.getXmlSafeFieldValue(12, this._certificateState)); 
/* 358 */     if (this._notes != null) values.put("Notes", DaoUtils.getXmlSafeFieldValue(12, this._notes)); 
/* 359 */     if (this._phoneNumber != null) values.put("PhoneNumber", DaoUtils.getXmlSafeFieldValue(12, this._phoneNumber)); 
/* 360 */     if (this._region != null) values.put("Region", DaoUtils.getXmlSafeFieldValue(12, this._region)); 
/* 361 */     if (this._diplomaticTitle != null) values.put("DiplomaticTitle", DaoUtils.getXmlSafeFieldValue(12, this._diplomaticTitle)); 
/* 362 */     if (this._certHolderFirstName != null) values.put("CertHolderFirstName", DaoUtils.getXmlSafeFieldValue(12, this._certHolderFirstName)); 
/* 363 */     if (this._certHolderLastName != null) values.put("CertHolderLastName", DaoUtils.getXmlSafeFieldValue(12, this._certHolderLastName)); 
/* 364 */     if (this._addressId != null) values.put("AddressId", DaoUtils.getXmlSafeFieldValue(12, this._addressId)); 
/* 365 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 370 */     super.setValues(argValues);
/* 371 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 373 */       String fieldName = field.getKey();
/* 374 */       String fieldValue = field.getValue();
/* 375 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 380 */             setOrganizationId((Long)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxExemptionId":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 389 */             setTaxExemptionId((String)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setTaxExemptionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 397 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 398 */             setCreateDate((Date)value);
/* 399 */           } catch (Exception ee) {
/* 400 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 406 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 407 */             setCreateUserId((String)value);
/* 408 */           } catch (Exception ee) {
/* 409 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 415 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 416 */             setUpdateDate((Date)value);
/* 417 */           } catch (Exception ee) {
/* 418 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 424 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 425 */             setUpdateUserId((String)value);
/* 426 */           } catch (Exception ee) {
/* 427 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateHolderName":
/*     */           try {
/* 433 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 434 */             setCertificateHolderName((String)value);
/* 435 */           } catch (Exception ee) {
/* 436 */             throw new DtxException("An exception occurred while calling setCertificateHolderName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateNbr":
/*     */           try {
/* 442 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 443 */             setCertificateNbr((String)value);
/* 444 */           } catch (Exception ee) {
/* 445 */             throw new DtxException("An exception occurred while calling setCertificateNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 451 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 452 */             setPartyId((Long)value);
/* 453 */           } catch (Exception ee) {
/* 454 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 460 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 461 */             setReasonCode((String)value);
/* 462 */           } catch (Exception ee) {
/* 463 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 469 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 470 */             setExpirationDate((Date)value);
/* 471 */           } catch (Exception ee) {
/* 472 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateCountry":
/*     */           try {
/* 478 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 479 */             setCertificateCountry((String)value);
/* 480 */           } catch (Exception ee) {
/* 481 */             throw new DtxException("An exception occurred while calling setCertificateCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateState":
/*     */           try {
/* 487 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 488 */             setCertificateState((String)value);
/* 489 */           } catch (Exception ee) {
/* 490 */             throw new DtxException("An exception occurred while calling setCertificateState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Notes":
/*     */           try {
/* 496 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 497 */             setNotes((String)value);
/* 498 */           } catch (Exception ee) {
/* 499 */             throw new DtxException("An exception occurred while calling setNotes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PhoneNumber":
/*     */           try {
/* 505 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 506 */             setPhoneNumber((String)value);
/* 507 */           } catch (Exception ee) {
/* 508 */             throw new DtxException("An exception occurred while calling setPhoneNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Region":
/*     */           try {
/* 514 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 515 */             setRegion((String)value);
/* 516 */           } catch (Exception ee) {
/* 517 */             throw new DtxException("An exception occurred while calling setRegion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiplomaticTitle":
/*     */           try {
/* 523 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 524 */             setDiplomaticTitle((String)value);
/* 525 */           } catch (Exception ee) {
/* 526 */             throw new DtxException("An exception occurred while calling setDiplomaticTitle() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertHolderFirstName":
/*     */           try {
/* 532 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 533 */             setCertHolderFirstName((String)value);
/* 534 */           } catch (Exception ee) {
/* 535 */             throw new DtxException("An exception occurred while calling setCertHolderFirstName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertHolderLastName":
/*     */           try {
/* 541 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 542 */             setCertHolderLastName((String)value);
/* 543 */           } catch (Exception ee) {
/* 544 */             throw new DtxException("An exception occurred while calling setCertHolderLastName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressId":
/*     */           try {
/* 550 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 551 */             setAddressId((String)value);
/* 552 */           } catch (Exception ee) {
/* 553 */             throw new DtxException("An exception occurred while calling setAddressId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxExemptionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */