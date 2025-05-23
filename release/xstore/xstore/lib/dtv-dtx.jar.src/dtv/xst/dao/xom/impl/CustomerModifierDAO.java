/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.CustomerModifierId;
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
/*     */ public class CustomerModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1501991691L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _customerId;
/*     */   private String _organizationName;
/*     */   private String _salutation;
/*     */   private String _firstName;
/*     */   private String _middleName;
/*     */   private String _lastName;
/*     */   private String _suffix;
/*     */   private String _telephone1;
/*     */   private String _telephone2;
/*     */   private String _emailAddress;
/*     */   private Long _addressSequence;
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
/*     */   public Date getCreateDate() {
/*  64 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  68 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  69 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  75 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  79 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  80 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  85 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  89 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  90 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  96 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 100 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 101 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerId() {
/* 106 */     return this._customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(String argCustomerId) {
/* 110 */     if (changed(argCustomerId, this._customerId, "customerId")) {
/* 111 */       this._customerId = argCustomerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrganizationName() {
/* 116 */     return this._organizationName;
/*     */   }
/*     */   
/*     */   public void setOrganizationName(String argOrganizationName) {
/* 120 */     if (changed(argOrganizationName, this._organizationName, "organizationName")) {
/* 121 */       this._organizationName = argOrganizationName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSalutation() {
/* 126 */     return this._salutation;
/*     */   }
/*     */   
/*     */   public void setSalutation(String argSalutation) {
/* 130 */     if (changed(argSalutation, this._salutation, "salutation")) {
/* 131 */       this._salutation = argSalutation;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/* 136 */     return this._firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/* 140 */     if (changed(argFirstName, this._firstName, "firstName")) {
/* 141 */       this._firstName = argFirstName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMiddleName() {
/* 146 */     return this._middleName;
/*     */   }
/*     */   
/*     */   public void setMiddleName(String argMiddleName) {
/* 150 */     if (changed(argMiddleName, this._middleName, "middleName")) {
/* 151 */       this._middleName = argMiddleName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLastName() {
/* 156 */     return this._lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 160 */     if (changed(argLastName, this._lastName, "lastName")) {
/* 161 */       this._lastName = argLastName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSuffix() {
/* 166 */     return this._suffix;
/*     */   }
/*     */   
/*     */   public void setSuffix(String argSuffix) {
/* 170 */     if (changed(argSuffix, this._suffix, "suffix")) {
/* 171 */       this._suffix = argSuffix;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone1() {
/* 176 */     return this._telephone1;
/*     */   }
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 180 */     if (changed(argTelephone1, this._telephone1, "telephone1")) {
/* 181 */       this._telephone1 = argTelephone1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone2() {
/* 186 */     return this._telephone2;
/*     */   }
/*     */   
/*     */   public void setTelephone2(String argTelephone2) {
/* 190 */     if (changed(argTelephone2, this._telephone2, "telephone2")) {
/* 191 */       this._telephone2 = argTelephone2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmailAddress() {
/* 196 */     return this._emailAddress;
/*     */   }
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 200 */     if (changed(argEmailAddress, this._emailAddress, "emailAddress")) {
/* 201 */       this._emailAddress = argEmailAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getAddressSequence() {
/* 206 */     return this._addressSequence;
/*     */   }
/*     */   
/*     */   public void setAddressSequence(Long argAddressSequence) {
/* 210 */     if (changed(argAddressSequence, this._addressSequence, "addressSequence")) {
/* 211 */       this._addressSequence = argAddressSequence;
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
/* 226 */     if (getCreateDate() != null) {
/* 227 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 229 */     if (getCreateUserId() != null) {
/* 230 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 232 */     if (getUpdateDate() != null) {
/* 233 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 235 */     if (getUpdateUserId() != null) {
/* 236 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 238 */     if (getCustomerId() != null) {
/* 239 */       buf.append("customerId").append("=").append(getCustomerId()).append(" ");
/*     */     }
/* 241 */     if (getOrganizationName() != null) {
/* 242 */       buf.append("organizationName").append("=").append(getOrganizationName()).append(" ");
/*     */     }
/* 244 */     if (getSalutation() != null) {
/* 245 */       buf.append("salutation").append("=").append(getSalutation()).append(" ");
/*     */     }
/* 247 */     if (getFirstName() != null) {
/* 248 */       buf.append("firstName").append("=").append(getFirstName()).append(" ");
/*     */     }
/* 250 */     if (getMiddleName() != null) {
/* 251 */       buf.append("middleName").append("=").append(getMiddleName()).append(" ");
/*     */     }
/* 253 */     if (getLastName() != null) {
/* 254 */       buf.append("lastName").append("=").append(getLastName()).append(" ");
/*     */     }
/* 256 */     if (getSuffix() != null) {
/* 257 */       buf.append("suffix").append("=").append(getSuffix()).append(" ");
/*     */     }
/* 259 */     if (getTelephone1() != null) {
/* 260 */       buf.append("telephone1").append("=").append(getTelephone1()).append(" ");
/*     */     }
/* 262 */     if (getTelephone2() != null) {
/* 263 */       buf.append("telephone2").append("=").append(getTelephone2()).append(" ");
/*     */     }
/* 265 */     if (getEmailAddress() != null) {
/* 266 */       buf.append("emailAddress").append("=").append(getEmailAddress()).append(" ");
/*     */     }
/* 268 */     if (getAddressSequence() != null) {
/* 269 */       buf.append("addressSequence").append("=").append(getAddressSequence()).append(" ");
/*     */     }
/*     */     
/* 272 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 276 */     CustomerModifierId id = new CustomerModifierId();
/* 277 */     id.setOrganizationId(getOrganizationId());
/* 278 */     id.setOrderId(getOrderId());
/* 279 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 283 */     setOrganizationId(((CustomerModifierId)argObjectId).getOrganizationId());
/* 284 */     setOrderId(((CustomerModifierId)argObjectId).getOrderId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 292 */     StringBuilder buf = new StringBuilder(850);
/* 293 */     buf.append("<").append("dao").append(" name=\"CustomerModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 294 */     getFieldsAsXml(buf);
/* 295 */     buf.append("</").append("dao").append(">");
/*     */     
/* 297 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 301 */     Map<String, String> values = super.getValues();
/* 302 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 303 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 304 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 305 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 306 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 307 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 308 */     if (this._customerId != null) values.put("CustomerId", DaoUtils.getXmlSafeFieldValue(12, this._customerId)); 
/* 309 */     if (this._organizationName != null) values.put("OrganizationName", DaoUtils.getXmlSafeFieldValue(12, this._organizationName)); 
/* 310 */     if (this._salutation != null) values.put("Salutation", DaoUtils.getXmlSafeFieldValue(12, this._salutation)); 
/* 311 */     if (this._firstName != null) values.put("FirstName", DaoUtils.getXmlSafeFieldValue(12, this._firstName)); 
/* 312 */     if (this._middleName != null) values.put("MiddleName", DaoUtils.getXmlSafeFieldValue(12, this._middleName)); 
/* 313 */     if (this._lastName != null) values.put("LastName", DaoUtils.getXmlSafeFieldValue(12, this._lastName)); 
/* 314 */     if (this._suffix != null) values.put("Suffix", DaoUtils.getXmlSafeFieldValue(12, this._suffix)); 
/* 315 */     if (this._telephone1 != null) values.put("Telephone1", DaoUtils.getXmlSafeFieldValue(12, this._telephone1)); 
/* 316 */     if (this._telephone2 != null) values.put("Telephone2", DaoUtils.getXmlSafeFieldValue(12, this._telephone2)); 
/* 317 */     if (this._emailAddress != null) values.put("EmailAddress", DaoUtils.getXmlSafeFieldValue(12, this._emailAddress)); 
/* 318 */     if (this._addressSequence != null) values.put("AddressSequence", DaoUtils.getXmlSafeFieldValue(-5, this._addressSequence)); 
/* 319 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 324 */     super.setValues(argValues);
/* 325 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 327 */       String fieldName = field.getKey();
/* 328 */       String fieldValue = field.getValue();
/* 329 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 334 */             setOrganizationId((Long)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setOrderId((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 352 */             setCreateDate((Date)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setCreateUserId((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setUpdateDate((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setUpdateUserId((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerId":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setCustomerId((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setCustomerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationName":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setOrganizationName((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setOrganizationName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Salutation":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setSalutation((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setSalutation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstName":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 415 */             setFirstName((String)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setFirstName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MiddleName":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 424 */             setMiddleName((String)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setMiddleName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastName":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setLastName((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setLastName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Suffix":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setSuffix((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setSuffix() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone1":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 451 */             setTelephone1((String)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setTelephone1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone2":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 460 */             setTelephone2((String)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setTelephone2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailAddress":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 469 */             setEmailAddress((String)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setEmailAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressSequence":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 478 */             setAddressSequence((Long)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setAddressSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\CustomerModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */