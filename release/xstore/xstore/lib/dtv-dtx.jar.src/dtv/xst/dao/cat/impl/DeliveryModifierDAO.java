/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.DeliveryModifierId;
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
/*     */ public class DeliveryModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -2114809077L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DeliveryModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
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
/*     */   private DtvDate _deliveryDate;
/*     */   private DtvDate _startTime;
/*     */   private DtvDate _endTime;
/*     */   private String _geoCode;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   
/*     */   public Long getOrganizationId() {
/*  61 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  65 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  66 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  71 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  75 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  76 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  81 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  85 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  86 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  91 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  95 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  96 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 102 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 106 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 107 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 112 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 116 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 117 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 123 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 127 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 128 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDeliveryType() {
/* 133 */     return this._deliveryType;
/*     */   }
/*     */   
/*     */   public void setDeliveryType(String argDeliveryType) {
/* 137 */     if (changed(argDeliveryType, this._deliveryType, "deliveryType")) {
/* 138 */       this._deliveryType = argDeliveryType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/* 143 */     return this._firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/* 147 */     if (changed(argFirstName, this._firstName, "firstName")) {
/* 148 */       this._firstName = argFirstName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMiddleName() {
/* 153 */     return this._middleName;
/*     */   }
/*     */   
/*     */   public void setMiddleName(String argMiddleName) {
/* 157 */     if (changed(argMiddleName, this._middleName, "middleName")) {
/* 158 */       this._middleName = argMiddleName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLastName() {
/* 163 */     return this._lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 167 */     if (changed(argLastName, this._lastName, "lastName")) {
/* 168 */       this._lastName = argLastName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress1() {
/* 173 */     return this._address1;
/*     */   }
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 177 */     if (changed(argAddress1, this._address1, "address1")) {
/* 178 */       this._address1 = argAddress1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress2() {
/* 183 */     return this._address2;
/*     */   }
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 187 */     if (changed(argAddress2, this._address2, "address2")) {
/* 188 */       this._address2 = argAddress2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress3() {
/* 193 */     return this._address3;
/*     */   }
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 197 */     if (changed(argAddress3, this._address3, "address3")) {
/* 198 */       this._address3 = argAddress3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress4() {
/* 203 */     return this._address4;
/*     */   }
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 207 */     if (changed(argAddress4, this._address4, "address4")) {
/* 208 */       this._address4 = argAddress4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApartment() {
/* 213 */     return this._apartment;
/*     */   }
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 217 */     if (changed(argApartment, this._apartment, "apartment")) {
/* 218 */       this._apartment = argApartment;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCity() {
/* 223 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/* 227 */     if (changed(argCity, this._city, "city")) {
/* 228 */       this._city = argCity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getState() {
/* 233 */     return this._state;
/*     */   }
/*     */   
/*     */   public void setState(String argState) {
/* 237 */     if (changed(argState, this._state, "state")) {
/* 238 */       this._state = argState;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/* 243 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 247 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/* 248 */       this._postalCode = argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountry() {
/* 253 */     return this._country;
/*     */   }
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 257 */     if (changed(argCountry, this._country, "country")) {
/* 258 */       this._country = argCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone1() {
/* 263 */     return this._telephone1;
/*     */   }
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 267 */     if (changed(argTelephone1, this._telephone1, "telephone1")) {
/* 268 */       this._telephone1 = argTelephone1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone2() {
/* 273 */     return this._telephone2;
/*     */   }
/*     */   
/*     */   public void setTelephone2(String argTelephone2) {
/* 277 */     if (changed(argTelephone2, this._telephone2, "telephone2")) {
/* 278 */       this._telephone2 = argTelephone2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone3() {
/* 283 */     return this._telephone3;
/*     */   }
/*     */   
/*     */   public void setTelephone3(String argTelephone3) {
/* 287 */     if (changed(argTelephone3, this._telephone3, "telephone3")) {
/* 288 */       this._telephone3 = argTelephone3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone4() {
/* 293 */     return this._telephone4;
/*     */   }
/*     */   
/*     */   public void setTelephone4(String argTelephone4) {
/* 297 */     if (changed(argTelephone4, this._telephone4, "telephone4")) {
/* 298 */       this._telephone4 = argTelephone4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShippingMethod() {
/* 303 */     return this._shippingMethod;
/*     */   }
/*     */   
/*     */   public void setShippingMethod(String argShippingMethod) {
/* 307 */     if (changed(argShippingMethod, this._shippingMethod, "shippingMethod")) {
/* 308 */       this._shippingMethod = argShippingMethod;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTrackingNumber() {
/* 313 */     return this._trackingNumber;
/*     */   }
/*     */   
/*     */   public void setTrackingNumber(String argTrackingNumber) {
/* 317 */     if (changed(argTrackingNumber, this._trackingNumber, "trackingNumber")) {
/* 318 */       this._trackingNumber = argTrackingNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInstructions() {
/* 323 */     return this._instructions;
/*     */   }
/*     */   
/*     */   public void setInstructions(String argInstructions) {
/* 327 */     if (changed(argInstructions, this._instructions, "instructions")) {
/* 328 */       this._instructions = argInstructions;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExtension() {
/* 333 */     return this._extension;
/*     */   }
/*     */   
/*     */   public void setExtension(String argExtension) {
/* 337 */     if (changed(argExtension, this._extension, "extension")) {
/* 338 */       this._extension = argExtension;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDeliveryDate() {
/* 343 */     return (Date)this._deliveryDate;
/*     */   }
/*     */   
/*     */   public void setDeliveryDate(Date argDeliveryDate) {
/* 347 */     if (changed(argDeliveryDate, this._deliveryDate, "deliveryDate")) {
/* 348 */       this._deliveryDate = (argDeliveryDate == null || argDeliveryDate instanceof DtvDate) ? (DtvDate)argDeliveryDate : new DtvDate(argDeliveryDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/* 354 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 358 */     if (changed(argStartTime, this._startTime, "startTime")) {
/* 359 */       this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 365 */     return (Date)this._endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 369 */     if (changed(argEndTime, this._endTime, "endTime")) {
/* 370 */       this._endTime = (argEndTime == null || argEndTime instanceof DtvDate) ? (DtvDate)argEndTime : new DtvDate(argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGeoCode() {
/* 376 */     return this._geoCode;
/*     */   }
/*     */   
/*     */   public void setGeoCode(String argGeoCode) {
/* 380 */     if (changed(argGeoCode, this._geoCode, "geoCode")) {
/* 381 */       this._geoCode = argGeoCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNeighborhood() {
/* 386 */     return this._neighborhood;
/*     */   }
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 390 */     if (changed(argNeighborhood, this._neighborhood, "neighborhood")) {
/* 391 */       this._neighborhood = argNeighborhood;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCounty() {
/* 396 */     return this._county;
/*     */   }
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 400 */     if (changed(argCounty, this._county, "county")) {
/* 401 */       this._county = argCounty;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 408 */     StringBuilder buf = new StringBuilder(512);
/* 409 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 410 */     if (getOrganizationId() != null) {
/* 411 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 413 */     if (getCustAccountId() != null) {
/* 414 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 416 */     if (getCustAccountCode() != null) {
/* 417 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 419 */     if (getCreateDate() != null) {
/* 420 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 422 */     if (getCreateUserId() != null) {
/* 423 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 425 */     if (getUpdateDate() != null) {
/* 426 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 428 */     if (getUpdateUserId() != null) {
/* 429 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 431 */     if (getDeliveryType() != null) {
/* 432 */       buf.append("deliveryType").append("=").append(getDeliveryType()).append(" ");
/*     */     }
/* 434 */     if (getFirstName() != null) {
/* 435 */       buf.append("firstName").append("=").append(getFirstName()).append(" ");
/*     */     }
/* 437 */     if (getMiddleName() != null) {
/* 438 */       buf.append("middleName").append("=").append(getMiddleName()).append(" ");
/*     */     }
/* 440 */     if (getLastName() != null) {
/* 441 */       buf.append("lastName").append("=").append(getLastName()).append(" ");
/*     */     }
/* 443 */     if (getAddress1() != null) {
/* 444 */       buf.append("address1").append("=").append(getAddress1()).append(" ");
/*     */     }
/* 446 */     if (getAddress2() != null) {
/* 447 */       buf.append("address2").append("=").append(getAddress2()).append(" ");
/*     */     }
/* 449 */     if (getAddress3() != null) {
/* 450 */       buf.append("address3").append("=").append(getAddress3()).append(" ");
/*     */     }
/* 452 */     if (getAddress4() != null) {
/* 453 */       buf.append("address4").append("=").append(getAddress4()).append(" ");
/*     */     }
/* 455 */     if (getApartment() != null) {
/* 456 */       buf.append("apartment").append("=").append(getApartment()).append(" ");
/*     */     }
/* 458 */     if (getCity() != null) {
/* 459 */       buf.append("city").append("=").append(getCity()).append(" ");
/*     */     }
/* 461 */     if (getState() != null) {
/* 462 */       buf.append("state").append("=").append(getState()).append(" ");
/*     */     }
/* 464 */     if (getPostalCode() != null) {
/* 465 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 467 */     if (getCountry() != null) {
/* 468 */       buf.append("country").append("=").append(getCountry()).append(" ");
/*     */     }
/* 470 */     if (getTelephone1() != null) {
/* 471 */       buf.append("telephone1").append("=").append(getTelephone1()).append(" ");
/*     */     }
/* 473 */     if (getTelephone2() != null) {
/* 474 */       buf.append("telephone2").append("=").append(getTelephone2()).append(" ");
/*     */     }
/* 476 */     if (getTelephone3() != null) {
/* 477 */       buf.append("telephone3").append("=").append(getTelephone3()).append(" ");
/*     */     }
/* 479 */     if (getTelephone4() != null) {
/* 480 */       buf.append("telephone4").append("=").append(getTelephone4()).append(" ");
/*     */     }
/* 482 */     if (getShippingMethod() != null) {
/* 483 */       buf.append("shippingMethod").append("=").append(getShippingMethod()).append(" ");
/*     */     }
/* 485 */     if (getTrackingNumber() != null) {
/* 486 */       buf.append("trackingNumber").append("=").append(getTrackingNumber()).append(" ");
/*     */     }
/* 488 */     if (getInstructions() != null) {
/* 489 */       buf.append("instructions").append("=").append(getInstructions()).append(" ");
/*     */     }
/* 491 */     if (getExtension() != null) {
/* 492 */       buf.append("extension").append("=").append(getExtension()).append(" ");
/*     */     }
/* 494 */     if (getDeliveryDate() != null) {
/* 495 */       buf.append("deliveryDate").append("=").append(getDeliveryDate()).append(" ");
/*     */     }
/* 497 */     if (getStartTime() != null) {
/* 498 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 500 */     if (getEndTime() != null) {
/* 501 */       buf.append("endTime").append("=").append(getEndTime()).append(" ");
/*     */     }
/* 503 */     if (getGeoCode() != null) {
/* 504 */       buf.append("geoCode").append("=").append(getGeoCode()).append(" ");
/*     */     }
/* 506 */     if (getNeighborhood() != null) {
/* 507 */       buf.append("neighborhood").append("=").append(getNeighborhood()).append(" ");
/*     */     }
/* 509 */     if (getCounty() != null) {
/* 510 */       buf.append("county").append("=").append(getCounty()).append(" ");
/*     */     }
/*     */     
/* 513 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 517 */     DeliveryModifierId id = new DeliveryModifierId();
/* 518 */     id.setOrganizationId(getOrganizationId());
/* 519 */     id.setCustAccountId(getCustAccountId());
/* 520 */     id.setCustAccountCode(getCustAccountCode());
/* 521 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 525 */     setOrganizationId(((DeliveryModifierId)argObjectId).getOrganizationId());
/* 526 */     setCustAccountId(((DeliveryModifierId)argObjectId).getCustAccountId());
/* 527 */     setCustAccountCode(((DeliveryModifierId)argObjectId).getCustAccountCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 531 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 535 */     StringBuilder buf = new StringBuilder(1700);
/* 536 */     buf.append("<").append("dao").append(" name=\"DeliveryModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 537 */     getFieldsAsXml(buf);
/* 538 */     buf.append("</").append("dao").append(">");
/*     */     
/* 540 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 544 */     Map<String, String> values = super.getValues();
/* 545 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 546 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 547 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 548 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 549 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 550 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 551 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 552 */     if (this._deliveryType != null) values.put("DeliveryType", DaoUtils.getXmlSafeFieldValue(12, this._deliveryType)); 
/* 553 */     if (this._firstName != null) values.put("FirstName", DaoUtils.getXmlSafeFieldValue(12, this._firstName)); 
/* 554 */     if (this._middleName != null) values.put("MiddleName", DaoUtils.getXmlSafeFieldValue(12, this._middleName)); 
/* 555 */     if (this._lastName != null) values.put("LastName", DaoUtils.getXmlSafeFieldValue(12, this._lastName)); 
/* 556 */     if (this._address1 != null) values.put("Address1", DaoUtils.getXmlSafeFieldValue(12, this._address1)); 
/* 557 */     if (this._address2 != null) values.put("Address2", DaoUtils.getXmlSafeFieldValue(12, this._address2)); 
/* 558 */     if (this._address3 != null) values.put("Address3", DaoUtils.getXmlSafeFieldValue(12, this._address3)); 
/* 559 */     if (this._address4 != null) values.put("Address4", DaoUtils.getXmlSafeFieldValue(12, this._address4)); 
/* 560 */     if (this._apartment != null) values.put("Apartment", DaoUtils.getXmlSafeFieldValue(12, this._apartment)); 
/* 561 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/* 562 */     if (this._state != null) values.put("State", DaoUtils.getXmlSafeFieldValue(12, this._state)); 
/* 563 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 564 */     if (this._country != null) values.put("Country", DaoUtils.getXmlSafeFieldValue(12, this._country)); 
/* 565 */     if (this._telephone1 != null) values.put("Telephone1", DaoUtils.getXmlSafeFieldValue(12, this._telephone1)); 
/* 566 */     if (this._telephone2 != null) values.put("Telephone2", DaoUtils.getXmlSafeFieldValue(12, this._telephone2)); 
/* 567 */     if (this._telephone3 != null) values.put("Telephone3", DaoUtils.getXmlSafeFieldValue(12, this._telephone3)); 
/* 568 */     if (this._telephone4 != null) values.put("Telephone4", DaoUtils.getXmlSafeFieldValue(12, this._telephone4)); 
/* 569 */     if (this._shippingMethod != null) values.put("ShippingMethod", DaoUtils.getXmlSafeFieldValue(12, this._shippingMethod)); 
/* 570 */     if (this._trackingNumber != null) values.put("TrackingNumber", DaoUtils.getXmlSafeFieldValue(12, this._trackingNumber)); 
/* 571 */     if (this._instructions != null) values.put("Instructions", DaoUtils.getXmlSafeFieldValue(12, this._instructions)); 
/* 572 */     if (this._extension != null) values.put("Extension", DaoUtils.getXmlSafeFieldValue(12, this._extension)); 
/* 573 */     if (this._deliveryDate != null) values.put("DeliveryDate", DaoUtils.getXmlSafeFieldValue(91, this._deliveryDate)); 
/* 574 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 575 */     if (this._endTime != null) values.put("EndTime", DaoUtils.getXmlSafeFieldValue(91, this._endTime)); 
/* 576 */     if (this._geoCode != null) values.put("GeoCode", DaoUtils.getXmlSafeFieldValue(12, this._geoCode)); 
/* 577 */     if (this._neighborhood != null) values.put("Neighborhood", DaoUtils.getXmlSafeFieldValue(12, this._neighborhood)); 
/* 578 */     if (this._county != null) values.put("County", DaoUtils.getXmlSafeFieldValue(12, this._county)); 
/* 579 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 584 */     super.setValues(argValues);
/* 585 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 587 */       String fieldName = field.getKey();
/* 588 */       String fieldValue = field.getValue();
/* 589 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 593 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 594 */             setOrganizationId((Long)value);
/* 595 */           } catch (Exception ee) {
/* 596 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 602 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 603 */             setCustAccountId((String)value);
/* 604 */           } catch (Exception ee) {
/* 605 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 611 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 612 */             setCustAccountCode((String)value);
/* 613 */           } catch (Exception ee) {
/* 614 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 620 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 621 */             setCreateDate((Date)value);
/* 622 */           } catch (Exception ee) {
/* 623 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 629 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 630 */             setCreateUserId((String)value);
/* 631 */           } catch (Exception ee) {
/* 632 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 638 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 639 */             setUpdateDate((Date)value);
/* 640 */           } catch (Exception ee) {
/* 641 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 647 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 648 */             setUpdateUserId((String)value);
/* 649 */           } catch (Exception ee) {
/* 650 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DeliveryType":
/*     */           try {
/* 656 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 657 */             setDeliveryType((String)value);
/* 658 */           } catch (Exception ee) {
/* 659 */             throw new DtxException("An exception occurred while calling setDeliveryType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstName":
/*     */           try {
/* 665 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 666 */             setFirstName((String)value);
/* 667 */           } catch (Exception ee) {
/* 668 */             throw new DtxException("An exception occurred while calling setFirstName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MiddleName":
/*     */           try {
/* 674 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 675 */             setMiddleName((String)value);
/* 676 */           } catch (Exception ee) {
/* 677 */             throw new DtxException("An exception occurred while calling setMiddleName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastName":
/*     */           try {
/* 683 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 684 */             setLastName((String)value);
/* 685 */           } catch (Exception ee) {
/* 686 */             throw new DtxException("An exception occurred while calling setLastName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address1":
/*     */           try {
/* 692 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 693 */             setAddress1((String)value);
/* 694 */           } catch (Exception ee) {
/* 695 */             throw new DtxException("An exception occurred while calling setAddress1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address2":
/*     */           try {
/* 701 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 702 */             setAddress2((String)value);
/* 703 */           } catch (Exception ee) {
/* 704 */             throw new DtxException("An exception occurred while calling setAddress2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address3":
/*     */           try {
/* 710 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 711 */             setAddress3((String)value);
/* 712 */           } catch (Exception ee) {
/* 713 */             throw new DtxException("An exception occurred while calling setAddress3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address4":
/*     */           try {
/* 719 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 720 */             setAddress4((String)value);
/* 721 */           } catch (Exception ee) {
/* 722 */             throw new DtxException("An exception occurred while calling setAddress4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Apartment":
/*     */           try {
/* 728 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 729 */             setApartment((String)value);
/* 730 */           } catch (Exception ee) {
/* 731 */             throw new DtxException("An exception occurred while calling setApartment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "City":
/*     */           try {
/* 737 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 738 */             setCity((String)value);
/* 739 */           } catch (Exception ee) {
/* 740 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "State":
/*     */           try {
/* 746 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 747 */             setState((String)value);
/* 748 */           } catch (Exception ee) {
/* 749 */             throw new DtxException("An exception occurred while calling setState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 755 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 756 */             setPostalCode((String)value);
/* 757 */           } catch (Exception ee) {
/* 758 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Country":
/*     */           try {
/* 764 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 765 */             setCountry((String)value);
/* 766 */           } catch (Exception ee) {
/* 767 */             throw new DtxException("An exception occurred while calling setCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone1":
/*     */           try {
/* 773 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 774 */             setTelephone1((String)value);
/* 775 */           } catch (Exception ee) {
/* 776 */             throw new DtxException("An exception occurred while calling setTelephone1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone2":
/*     */           try {
/* 782 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 783 */             setTelephone2((String)value);
/* 784 */           } catch (Exception ee) {
/* 785 */             throw new DtxException("An exception occurred while calling setTelephone2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone3":
/*     */           try {
/* 791 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 792 */             setTelephone3((String)value);
/* 793 */           } catch (Exception ee) {
/* 794 */             throw new DtxException("An exception occurred while calling setTelephone3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone4":
/*     */           try {
/* 800 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 801 */             setTelephone4((String)value);
/* 802 */           } catch (Exception ee) {
/* 803 */             throw new DtxException("An exception occurred while calling setTelephone4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShippingMethod":
/*     */           try {
/* 809 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 810 */             setShippingMethod((String)value);
/* 811 */           } catch (Exception ee) {
/* 812 */             throw new DtxException("An exception occurred while calling setShippingMethod() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TrackingNumber":
/*     */           try {
/* 818 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 819 */             setTrackingNumber((String)value);
/* 820 */           } catch (Exception ee) {
/* 821 */             throw new DtxException("An exception occurred while calling setTrackingNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Instructions":
/*     */           try {
/* 827 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 828 */             setInstructions((String)value);
/* 829 */           } catch (Exception ee) {
/* 830 */             throw new DtxException("An exception occurred while calling setInstructions() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Extension":
/*     */           try {
/* 836 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 837 */             setExtension((String)value);
/* 838 */           } catch (Exception ee) {
/* 839 */             throw new DtxException("An exception occurred while calling setExtension() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DeliveryDate":
/*     */           try {
/* 845 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 846 */             setDeliveryDate((Date)value);
/* 847 */           } catch (Exception ee) {
/* 848 */             throw new DtxException("An exception occurred while calling setDeliveryDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 854 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 855 */             setStartTime((Date)value);
/* 856 */           } catch (Exception ee) {
/* 857 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTime":
/*     */           try {
/* 863 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 864 */             setEndTime((Date)value);
/* 865 */           } catch (Exception ee) {
/* 866 */             throw new DtxException("An exception occurred while calling setEndTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GeoCode":
/*     */           try {
/* 872 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 873 */             setGeoCode((String)value);
/* 874 */           } catch (Exception ee) {
/* 875 */             throw new DtxException("An exception occurred while calling setGeoCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Neighborhood":
/*     */           try {
/* 881 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 882 */             setNeighborhood((String)value);
/* 883 */           } catch (Exception ee) {
/* 884 */             throw new DtxException("An exception occurred while calling setNeighborhood() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "County":
/*     */           try {
/* 890 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 891 */             setCounty((String)value);
/* 892 */           } catch (Exception ee) {
/* 893 */             throw new DtxException("An exception occurred while calling setCounty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\DeliveryModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */