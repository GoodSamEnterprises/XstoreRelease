/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipmentAddressId;
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
/*     */ public class ShipmentAddressDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1035118374L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShipmentAddressDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _shipmentSequence;
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
/*     */   private String _state;
/*     */   private String _postalCode;
/*     */   private String _country;
/*     */   private String _telephone1;
/*     */   private String _telephone2;
/*     */   private String _telephone3;
/*     */   private String _telephone4;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   
/*     */   public Long getOrganizationId() {
/*  51 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  55 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  56 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  61 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  65 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  66 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/*  71 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  75 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  76 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  81 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  85 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  86 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getShipmentSequence() {
/*  91 */     return this._shipmentSequence;
/*     */   }
/*     */   
/*     */   public void setShipmentSequence(Integer argShipmentSequence) {
/*  95 */     if (changed(argShipmentSequence, this._shipmentSequence, "shipmentSequence")) {
/*  96 */       this._shipmentSequence = argShipmentSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 101 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 105 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 106 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 112 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 116 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 117 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 122 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 126 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 127 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 133 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 137 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 138 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress1() {
/* 143 */     return this._address1;
/*     */   }
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 147 */     if (changed(argAddress1, this._address1, "address1")) {
/* 148 */       this._address1 = argAddress1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress2() {
/* 153 */     return this._address2;
/*     */   }
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 157 */     if (changed(argAddress2, this._address2, "address2")) {
/* 158 */       this._address2 = argAddress2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress3() {
/* 163 */     return this._address3;
/*     */   }
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 167 */     if (changed(argAddress3, this._address3, "address3")) {
/* 168 */       this._address3 = argAddress3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress4() {
/* 173 */     return this._address4;
/*     */   }
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 177 */     if (changed(argAddress4, this._address4, "address4")) {
/* 178 */       this._address4 = argAddress4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApartment() {
/* 183 */     return this._apartment;
/*     */   }
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 187 */     if (changed(argApartment, this._apartment, "apartment")) {
/* 188 */       this._apartment = argApartment;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCity() {
/* 193 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/* 197 */     if (changed(argCity, this._city, "city")) {
/* 198 */       this._city = argCity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getState() {
/* 203 */     return this._state;
/*     */   }
/*     */   
/*     */   public void setState(String argState) {
/* 207 */     if (changed(argState, this._state, "state")) {
/* 208 */       this._state = argState;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/* 213 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 217 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/* 218 */       this._postalCode = argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountry() {
/* 223 */     return this._country;
/*     */   }
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 227 */     if (changed(argCountry, this._country, "country")) {
/* 228 */       this._country = argCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone1() {
/* 233 */     return this._telephone1;
/*     */   }
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 237 */     if (changed(argTelephone1, this._telephone1, "telephone1")) {
/* 238 */       this._telephone1 = argTelephone1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone2() {
/* 243 */     return this._telephone2;
/*     */   }
/*     */   
/*     */   public void setTelephone2(String argTelephone2) {
/* 247 */     if (changed(argTelephone2, this._telephone2, "telephone2")) {
/* 248 */       this._telephone2 = argTelephone2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone3() {
/* 253 */     return this._telephone3;
/*     */   }
/*     */   
/*     */   public void setTelephone3(String argTelephone3) {
/* 257 */     if (changed(argTelephone3, this._telephone3, "telephone3")) {
/* 258 */       this._telephone3 = argTelephone3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone4() {
/* 263 */     return this._telephone4;
/*     */   }
/*     */   
/*     */   public void setTelephone4(String argTelephone4) {
/* 267 */     if (changed(argTelephone4, this._telephone4, "telephone4")) {
/* 268 */       this._telephone4 = argTelephone4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNeighborhood() {
/* 273 */     return this._neighborhood;
/*     */   }
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 277 */     if (changed(argNeighborhood, this._neighborhood, "neighborhood")) {
/* 278 */       this._neighborhood = argNeighborhood;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCounty() {
/* 283 */     return this._county;
/*     */   }
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 287 */     if (changed(argCounty, this._county, "county")) {
/* 288 */       this._county = argCounty;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 295 */     StringBuilder buf = new StringBuilder(512);
/* 296 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 297 */     if (getOrganizationId() != null) {
/* 298 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 300 */     if (getRetailLocationId() != null) {
/* 301 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 303 */     if (getDocumentId() != null) {
/* 304 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 306 */     if (getDocumentTypeCode() != null) {
/* 307 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 309 */     if (getShipmentSequence() != null) {
/* 310 */       buf.append("shipmentSequence").append("=").append(getShipmentSequence()).append(" ");
/*     */     }
/* 312 */     if (getCreateDate() != null) {
/* 313 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 315 */     if (getCreateUserId() != null) {
/* 316 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 318 */     if (getUpdateDate() != null) {
/* 319 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 321 */     if (getUpdateUserId() != null) {
/* 322 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 324 */     if (getAddress1() != null) {
/* 325 */       buf.append("address1").append("=").append(getAddress1()).append(" ");
/*     */     }
/* 327 */     if (getAddress2() != null) {
/* 328 */       buf.append("address2").append("=").append(getAddress2()).append(" ");
/*     */     }
/* 330 */     if (getAddress3() != null) {
/* 331 */       buf.append("address3").append("=").append(getAddress3()).append(" ");
/*     */     }
/* 333 */     if (getAddress4() != null) {
/* 334 */       buf.append("address4").append("=").append(getAddress4()).append(" ");
/*     */     }
/* 336 */     if (getApartment() != null) {
/* 337 */       buf.append("apartment").append("=").append(getApartment()).append(" ");
/*     */     }
/* 339 */     if (getCity() != null) {
/* 340 */       buf.append("city").append("=").append(getCity()).append(" ");
/*     */     }
/* 342 */     if (getState() != null) {
/* 343 */       buf.append("state").append("=").append(getState()).append(" ");
/*     */     }
/* 345 */     if (getPostalCode() != null) {
/* 346 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 348 */     if (getCountry() != null) {
/* 349 */       buf.append("country").append("=").append(getCountry()).append(" ");
/*     */     }
/* 351 */     if (getTelephone1() != null) {
/* 352 */       buf.append("telephone1").append("=").append(getTelephone1()).append(" ");
/*     */     }
/* 354 */     if (getTelephone2() != null) {
/* 355 */       buf.append("telephone2").append("=").append(getTelephone2()).append(" ");
/*     */     }
/* 357 */     if (getTelephone3() != null) {
/* 358 */       buf.append("telephone3").append("=").append(getTelephone3()).append(" ");
/*     */     }
/* 360 */     if (getTelephone4() != null) {
/* 361 */       buf.append("telephone4").append("=").append(getTelephone4()).append(" ");
/*     */     }
/* 363 */     if (getNeighborhood() != null) {
/* 364 */       buf.append("neighborhood").append("=").append(getNeighborhood()).append(" ");
/*     */     }
/* 366 */     if (getCounty() != null) {
/* 367 */       buf.append("county").append("=").append(getCounty()).append(" ");
/*     */     }
/*     */     
/* 370 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 374 */     ShipmentAddressId id = new ShipmentAddressId();
/* 375 */     id.setOrganizationId(getOrganizationId());
/* 376 */     id.setRetailLocationId(getRetailLocationId());
/* 377 */     id.setDocumentId(getDocumentId());
/* 378 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 379 */     id.setShipmentSequence(getShipmentSequence());
/* 380 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 384 */     setOrganizationId(((ShipmentAddressId)argObjectId).getOrganizationId());
/* 385 */     setRetailLocationId(((ShipmentAddressId)argObjectId).getRetailLocationId());
/* 386 */     setDocumentId(((ShipmentAddressId)argObjectId).getDocumentId());
/* 387 */     setDocumentTypeCode(((ShipmentAddressId)argObjectId).getDocumentTypeCode());
/* 388 */     setShipmentSequence(((ShipmentAddressId)argObjectId).getShipmentSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 392 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 396 */     StringBuilder buf = new StringBuilder(1200);
/* 397 */     buf.append("<").append("dao").append(" name=\"ShipmentAddress\" cmd=\"" + getObjectStateString() + "\">");
/* 398 */     getFieldsAsXml(buf);
/* 399 */     buf.append("</").append("dao").append(">");
/*     */     
/* 401 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 405 */     Map<String, String> values = super.getValues();
/* 406 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 407 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 408 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 409 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 410 */     if (this._shipmentSequence != null) values.put("ShipmentSequence", DaoUtils.getXmlSafeFieldValue(4, this._shipmentSequence)); 
/* 411 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 412 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 413 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 414 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 415 */     if (this._address1 != null) values.put("Address1", DaoUtils.getXmlSafeFieldValue(12, this._address1)); 
/* 416 */     if (this._address2 != null) values.put("Address2", DaoUtils.getXmlSafeFieldValue(12, this._address2)); 
/* 417 */     if (this._address3 != null) values.put("Address3", DaoUtils.getXmlSafeFieldValue(12, this._address3)); 
/* 418 */     if (this._address4 != null) values.put("Address4", DaoUtils.getXmlSafeFieldValue(12, this._address4)); 
/* 419 */     if (this._apartment != null) values.put("Apartment", DaoUtils.getXmlSafeFieldValue(12, this._apartment)); 
/* 420 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/* 421 */     if (this._state != null) values.put("State", DaoUtils.getXmlSafeFieldValue(12, this._state)); 
/* 422 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 423 */     if (this._country != null) values.put("Country", DaoUtils.getXmlSafeFieldValue(12, this._country)); 
/* 424 */     if (this._telephone1 != null) values.put("Telephone1", DaoUtils.getXmlSafeFieldValue(12, this._telephone1)); 
/* 425 */     if (this._telephone2 != null) values.put("Telephone2", DaoUtils.getXmlSafeFieldValue(12, this._telephone2)); 
/* 426 */     if (this._telephone3 != null) values.put("Telephone3", DaoUtils.getXmlSafeFieldValue(12, this._telephone3)); 
/* 427 */     if (this._telephone4 != null) values.put("Telephone4", DaoUtils.getXmlSafeFieldValue(12, this._telephone4)); 
/* 428 */     if (this._neighborhood != null) values.put("Neighborhood", DaoUtils.getXmlSafeFieldValue(12, this._neighborhood)); 
/* 429 */     if (this._county != null) values.put("County", DaoUtils.getXmlSafeFieldValue(12, this._county)); 
/* 430 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 435 */     super.setValues(argValues);
/* 436 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 438 */       String fieldName = field.getKey();
/* 439 */       String fieldValue = field.getValue();
/* 440 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 445 */             setOrganizationId((Long)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 454 */             setRetailLocationId((Long)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 463 */             setDocumentId((String)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 472 */             setDocumentTypeCode((String)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipmentSequence":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 481 */             setShipmentSequence((Integer)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setShipmentSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 490 */             setCreateDate((Date)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 498 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 499 */             setCreateUserId((String)value);
/* 500 */           } catch (Exception ee) {
/* 501 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 507 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 508 */             setUpdateDate((Date)value);
/* 509 */           } catch (Exception ee) {
/* 510 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 516 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 517 */             setUpdateUserId((String)value);
/* 518 */           } catch (Exception ee) {
/* 519 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address1":
/*     */           try {
/* 525 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 526 */             setAddress1((String)value);
/* 527 */           } catch (Exception ee) {
/* 528 */             throw new DtxException("An exception occurred while calling setAddress1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address2":
/*     */           try {
/* 534 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 535 */             setAddress2((String)value);
/* 536 */           } catch (Exception ee) {
/* 537 */             throw new DtxException("An exception occurred while calling setAddress2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address3":
/*     */           try {
/* 543 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 544 */             setAddress3((String)value);
/* 545 */           } catch (Exception ee) {
/* 546 */             throw new DtxException("An exception occurred while calling setAddress3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address4":
/*     */           try {
/* 552 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 553 */             setAddress4((String)value);
/* 554 */           } catch (Exception ee) {
/* 555 */             throw new DtxException("An exception occurred while calling setAddress4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Apartment":
/*     */           try {
/* 561 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 562 */             setApartment((String)value);
/* 563 */           } catch (Exception ee) {
/* 564 */             throw new DtxException("An exception occurred while calling setApartment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "City":
/*     */           try {
/* 570 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 571 */             setCity((String)value);
/* 572 */           } catch (Exception ee) {
/* 573 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "State":
/*     */           try {
/* 579 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 580 */             setState((String)value);
/* 581 */           } catch (Exception ee) {
/* 582 */             throw new DtxException("An exception occurred while calling setState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 588 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 589 */             setPostalCode((String)value);
/* 590 */           } catch (Exception ee) {
/* 591 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Country":
/*     */           try {
/* 597 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 598 */             setCountry((String)value);
/* 599 */           } catch (Exception ee) {
/* 600 */             throw new DtxException("An exception occurred while calling setCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone1":
/*     */           try {
/* 606 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 607 */             setTelephone1((String)value);
/* 608 */           } catch (Exception ee) {
/* 609 */             throw new DtxException("An exception occurred while calling setTelephone1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone2":
/*     */           try {
/* 615 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 616 */             setTelephone2((String)value);
/* 617 */           } catch (Exception ee) {
/* 618 */             throw new DtxException("An exception occurred while calling setTelephone2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone3":
/*     */           try {
/* 624 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 625 */             setTelephone3((String)value);
/* 626 */           } catch (Exception ee) {
/* 627 */             throw new DtxException("An exception occurred while calling setTelephone3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone4":
/*     */           try {
/* 633 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 634 */             setTelephone4((String)value);
/* 635 */           } catch (Exception ee) {
/* 636 */             throw new DtxException("An exception occurred while calling setTelephone4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Neighborhood":
/*     */           try {
/* 642 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 643 */             setNeighborhood((String)value);
/* 644 */           } catch (Exception ee) {
/* 645 */             throw new DtxException("An exception occurred while calling setNeighborhood() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "County":
/*     */           try {
/* 651 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 652 */             setCounty((String)value);
/* 653 */           } catch (Exception ee) {
/* 654 */             throw new DtxException("An exception occurred while calling setCounty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentAddressDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */