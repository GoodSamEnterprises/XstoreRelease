/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.FulfillmentModifierId;
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
/*     */ public class FulfillmentModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -914701643L;
/*  23 */   private static final Logger _logger = Logger.getLogger(FulfillmentModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _locationId;
/*     */   private String _organizationName;
/*     */   private String _salutation;
/*     */   private String _locationName1;
/*     */   private String _locationName2;
/*     */   private String _middleName;
/*     */   private String _suffix;
/*     */   private Long _addressSequence;
/*     */   private String _telephone1;
/*     */   private String _emailAddress;
/*     */   
/*     */   public Long getOrganizationId() {
/*  44 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  48 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  49 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderId() {
/*  54 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  58 */     if (changed(argOrderId, this._orderId, "orderId")) {
/*  59 */       this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  64 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  68 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  69 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  74 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  78 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  79 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  85 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  89 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  90 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  95 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  99 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 100 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 106 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 110 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 111 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationId() {
/* 116 */     return this._locationId;
/*     */   }
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 120 */     if (changed(argLocationId, this._locationId, "locationId")) {
/* 121 */       this._locationId = argLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrganizationName() {
/* 126 */     return this._organizationName;
/*     */   }
/*     */   
/*     */   public void setOrganizationName(String argOrganizationName) {
/* 130 */     if (changed(argOrganizationName, this._organizationName, "organizationName")) {
/* 131 */       this._organizationName = argOrganizationName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSalutation() {
/* 136 */     return this._salutation;
/*     */   }
/*     */   
/*     */   public void setSalutation(String argSalutation) {
/* 140 */     if (changed(argSalutation, this._salutation, "salutation")) {
/* 141 */       this._salutation = argSalutation;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationName1() {
/* 146 */     return this._locationName1;
/*     */   }
/*     */   
/*     */   public void setLocationName1(String argLocationName1) {
/* 150 */     if (changed(argLocationName1, this._locationName1, "locationName1")) {
/* 151 */       this._locationName1 = argLocationName1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationName2() {
/* 156 */     return this._locationName2;
/*     */   }
/*     */   
/*     */   public void setLocationName2(String argLocationName2) {
/* 160 */     if (changed(argLocationName2, this._locationName2, "locationName2")) {
/* 161 */       this._locationName2 = argLocationName2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMiddleName() {
/* 166 */     return this._middleName;
/*     */   }
/*     */   
/*     */   public void setMiddleName(String argMiddleName) {
/* 170 */     if (changed(argMiddleName, this._middleName, "middleName")) {
/* 171 */       this._middleName = argMiddleName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSuffix() {
/* 176 */     return this._suffix;
/*     */   }
/*     */   
/*     */   public void setSuffix(String argSuffix) {
/* 180 */     if (changed(argSuffix, this._suffix, "suffix")) {
/* 181 */       this._suffix = argSuffix;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getAddressSequence() {
/* 186 */     return this._addressSequence;
/*     */   }
/*     */   
/*     */   public void setAddressSequence(Long argAddressSequence) {
/* 190 */     if (changed(argAddressSequence, this._addressSequence, "addressSequence")) {
/* 191 */       this._addressSequence = argAddressSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone1() {
/* 196 */     return this._telephone1;
/*     */   }
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 200 */     if (changed(argTelephone1, this._telephone1, "telephone1")) {
/* 201 */       this._telephone1 = argTelephone1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmailAddress() {
/* 206 */     return this._emailAddress;
/*     */   }
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 210 */     if (changed(argEmailAddress, this._emailAddress, "emailAddress")) {
/* 211 */       this._emailAddress = argEmailAddress;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 218 */     StringBuilder buf = new StringBuilder(512);
/* 219 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 220 */     if (getOrganizationId() != null) {
/* 221 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 223 */     if (getOrderId() != null) {
/* 224 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 226 */     if (getSequence() != null) {
/* 227 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 229 */     if (getCreateDate() != null) {
/* 230 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 232 */     if (getCreateUserId() != null) {
/* 233 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 235 */     if (getUpdateDate() != null) {
/* 236 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 238 */     if (getUpdateUserId() != null) {
/* 239 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 241 */     if (getLocationId() != null) {
/* 242 */       buf.append("locationId").append("=").append(getLocationId()).append(" ");
/*     */     }
/* 244 */     if (getOrganizationName() != null) {
/* 245 */       buf.append("organizationName").append("=").append(getOrganizationName()).append(" ");
/*     */     }
/* 247 */     if (getSalutation() != null) {
/* 248 */       buf.append("salutation").append("=").append(getSalutation()).append(" ");
/*     */     }
/* 250 */     if (getLocationName1() != null) {
/* 251 */       buf.append("locationName1").append("=").append(getLocationName1()).append(" ");
/*     */     }
/* 253 */     if (getLocationName2() != null) {
/* 254 */       buf.append("locationName2").append("=").append(getLocationName2()).append(" ");
/*     */     }
/* 256 */     if (getMiddleName() != null) {
/* 257 */       buf.append("middleName").append("=").append(getMiddleName()).append(" ");
/*     */     }
/* 259 */     if (getSuffix() != null) {
/* 260 */       buf.append("suffix").append("=").append(getSuffix()).append(" ");
/*     */     }
/* 262 */     if (getAddressSequence() != null) {
/* 263 */       buf.append("addressSequence").append("=").append(getAddressSequence()).append(" ");
/*     */     }
/* 265 */     if (getTelephone1() != null) {
/* 266 */       buf.append("telephone1").append("=").append(getTelephone1()).append(" ");
/*     */     }
/* 268 */     if (getEmailAddress() != null) {
/* 269 */       buf.append("emailAddress").append("=").append(getEmailAddress()).append(" ");
/*     */     }
/*     */     
/* 272 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 276 */     FulfillmentModifierId id = new FulfillmentModifierId();
/* 277 */     id.setOrganizationId(getOrganizationId());
/* 278 */     id.setOrderId(getOrderId());
/* 279 */     id.setSequence(getSequence());
/* 280 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 284 */     setOrganizationId(((FulfillmentModifierId)argObjectId).getOrganizationId());
/* 285 */     setOrderId(((FulfillmentModifierId)argObjectId).getOrderId());
/* 286 */     setSequence(((FulfillmentModifierId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 290 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 294 */     StringBuilder buf = new StringBuilder(850);
/* 295 */     buf.append("<").append("dao").append(" name=\"FulfillmentModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 296 */     getFieldsAsXml(buf);
/* 297 */     buf.append("</").append("dao").append(">");
/*     */     
/* 299 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 303 */     Map<String, String> values = super.getValues();
/* 304 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 305 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 306 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 307 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 308 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 309 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 310 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 311 */     if (this._locationId != null) values.put("LocationId", DaoUtils.getXmlSafeFieldValue(12, this._locationId)); 
/* 312 */     if (this._organizationName != null) values.put("OrganizationName", DaoUtils.getXmlSafeFieldValue(12, this._organizationName)); 
/* 313 */     if (this._salutation != null) values.put("Salutation", DaoUtils.getXmlSafeFieldValue(12, this._salutation)); 
/* 314 */     if (this._locationName1 != null) values.put("LocationName1", DaoUtils.getXmlSafeFieldValue(12, this._locationName1)); 
/* 315 */     if (this._locationName2 != null) values.put("LocationName2", DaoUtils.getXmlSafeFieldValue(12, this._locationName2)); 
/* 316 */     if (this._middleName != null) values.put("MiddleName", DaoUtils.getXmlSafeFieldValue(12, this._middleName)); 
/* 317 */     if (this._suffix != null) values.put("Suffix", DaoUtils.getXmlSafeFieldValue(12, this._suffix)); 
/* 318 */     if (this._addressSequence != null) values.put("AddressSequence", DaoUtils.getXmlSafeFieldValue(-5, this._addressSequence)); 
/* 319 */     if (this._telephone1 != null) values.put("Telephone1", DaoUtils.getXmlSafeFieldValue(12, this._telephone1)); 
/* 320 */     if (this._emailAddress != null) values.put("EmailAddress", DaoUtils.getXmlSafeFieldValue(12, this._emailAddress)); 
/* 321 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 326 */     super.setValues(argValues);
/* 327 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 329 */       String fieldName = field.getKey();
/* 330 */       String fieldValue = field.getValue();
/* 331 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 336 */             setOrganizationId((Long)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 345 */             setOrderId((String)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 354 */             setSequence((Integer)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setCreateDate((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setCreateUserId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 381 */             setUpdateDate((Date)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setUpdateUserId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationId":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setLocationId((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationName":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setOrganizationName((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setOrganizationName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Salutation":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setSalutation((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setSalutation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationName1":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 426 */             setLocationName1((String)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setLocationName1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationName2":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 435 */             setLocationName2((String)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setLocationName2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MiddleName":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 444 */             setMiddleName((String)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setMiddleName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Suffix":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 453 */             setSuffix((String)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setSuffix() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressSequence":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 462 */             setAddressSequence((Long)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setAddressSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone1":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 471 */             setTelephone1((String)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setTelephone1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailAddress":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setEmailAddress((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setEmailAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\FulfillmentModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */