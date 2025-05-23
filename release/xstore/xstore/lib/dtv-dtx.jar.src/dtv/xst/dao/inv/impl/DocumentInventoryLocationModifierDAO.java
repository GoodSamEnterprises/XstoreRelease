/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.DocumentInventoryLocationModifierId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentInventoryLocationModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 432445997L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DocumentInventoryLocationModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Long _documentLineNumber;
/*     */   private Long _modifierSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _serialNumber;
/*     */   private String _sourceLocationId;
/*     */   private String _sourceBucketId;
/*     */   private String _destinationLocationId;
/*     */   private String _destinationBucketId;
/*     */   private String _itemId;
/*     */   private BigDecimal _quantity;
/*     */   private String _actionCode;
/*     */   private BigDecimal _cost;
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
/*     */   public Long getRetailLocationId() {
/*  56 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  60 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  61 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/*  66 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  70 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  71 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  76 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  80 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  81 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getDocumentLineNumber() {
/*  86 */     return this._documentLineNumber;
/*     */   }
/*     */   
/*     */   public void setDocumentLineNumber(Long argDocumentLineNumber) {
/*  90 */     if (changed(argDocumentLineNumber, this._documentLineNumber, "documentLineNumber")) {
/*  91 */       this._documentLineNumber = argDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getModifierSequence() {
/*  96 */     return this._modifierSequence;
/*     */   }
/*     */   
/*     */   public void setModifierSequence(Long argModifierSequence) {
/* 100 */     if (changed(argModifierSequence, this._modifierSequence, "modifierSequence")) {
/* 101 */       this._modifierSequence = argModifierSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 106 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 110 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 111 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 117 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 121 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 122 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 127 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 131 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 132 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 138 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 142 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 143 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 148 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 152 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 153 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceLocationId() {
/* 158 */     return this._sourceLocationId;
/*     */   }
/*     */   
/*     */   public void setSourceLocationId(String argSourceLocationId) {
/* 162 */     if (changed(argSourceLocationId, this._sourceLocationId, "sourceLocationId")) {
/* 163 */       this._sourceLocationId = argSourceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceBucketId() {
/* 168 */     return this._sourceBucketId;
/*     */   }
/*     */   
/*     */   public void setSourceBucketId(String argSourceBucketId) {
/* 172 */     if (changed(argSourceBucketId, this._sourceBucketId, "sourceBucketId")) {
/* 173 */       this._sourceBucketId = argSourceBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationLocationId() {
/* 178 */     return this._destinationLocationId;
/*     */   }
/*     */   
/*     */   public void setDestinationLocationId(String argDestinationLocationId) {
/* 182 */     if (changed(argDestinationLocationId, this._destinationLocationId, "destinationLocationId")) {
/* 183 */       this._destinationLocationId = argDestinationLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationBucketId() {
/* 188 */     return this._destinationBucketId;
/*     */   }
/*     */   
/*     */   public void setDestinationBucketId(String argDestinationBucketId) {
/* 192 */     if (changed(argDestinationBucketId, this._destinationBucketId, "destinationBucketId")) {
/* 193 */       this._destinationBucketId = argDestinationBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 198 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 202 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 203 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 208 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 212 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 213 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActionCode() {
/* 218 */     return this._actionCode;
/*     */   }
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 222 */     if (changed(argActionCode, this._actionCode, "actionCode")) {
/* 223 */       this._actionCode = argActionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getCost() {
/* 228 */     return this._cost;
/*     */   }
/*     */   
/*     */   public void setCost(BigDecimal argCost) {
/* 232 */     if (changed(argCost, this._cost, "cost")) {
/* 233 */       this._cost = argCost;
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
/* 245 */     if (getRetailLocationId() != null) {
/* 246 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 248 */     if (getDocumentId() != null) {
/* 249 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 251 */     if (getDocumentTypeCode() != null) {
/* 252 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 254 */     if (getDocumentLineNumber() != null) {
/* 255 */       buf.append("documentLineNumber").append("=").append(getDocumentLineNumber()).append(" ");
/*     */     }
/* 257 */     if (getModifierSequence() != null) {
/* 258 */       buf.append("modifierSequence").append("=").append(getModifierSequence()).append(" ");
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
/* 272 */     if (getSerialNumber() != null) {
/* 273 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 275 */     if (getSourceLocationId() != null) {
/* 276 */       buf.append("sourceLocationId").append("=").append(getSourceLocationId()).append(" ");
/*     */     }
/* 278 */     if (getSourceBucketId() != null) {
/* 279 */       buf.append("sourceBucketId").append("=").append(getSourceBucketId()).append(" ");
/*     */     }
/* 281 */     if (getDestinationLocationId() != null) {
/* 282 */       buf.append("destinationLocationId").append("=").append(getDestinationLocationId()).append(" ");
/*     */     }
/* 284 */     if (getDestinationBucketId() != null) {
/* 285 */       buf.append("destinationBucketId").append("=").append(getDestinationBucketId()).append(" ");
/*     */     }
/* 287 */     if (getItemId() != null) {
/* 288 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 290 */     if (getQuantity() != null) {
/* 291 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/* 293 */     if (getActionCode() != null) {
/* 294 */       buf.append("actionCode").append("=").append(getActionCode()).append(" ");
/*     */     }
/* 296 */     if (getCost() != null) {
/* 297 */       buf.append("cost").append("=").append(getCost()).append(" ");
/*     */     }
/*     */     
/* 300 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 304 */     DocumentInventoryLocationModifierId id = new DocumentInventoryLocationModifierId();
/* 305 */     id.setOrganizationId(getOrganizationId());
/* 306 */     id.setRetailLocationId(getRetailLocationId());
/* 307 */     id.setDocumentId(getDocumentId());
/* 308 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 309 */     id.setDocumentLineNumber(getDocumentLineNumber());
/* 310 */     id.setModifierSequence(getModifierSequence());
/* 311 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 315 */     setOrganizationId(((DocumentInventoryLocationModifierId)argObjectId).getOrganizationId());
/* 316 */     setRetailLocationId(((DocumentInventoryLocationModifierId)argObjectId).getRetailLocationId());
/* 317 */     setDocumentId(((DocumentInventoryLocationModifierId)argObjectId).getDocumentId());
/* 318 */     setDocumentTypeCode(((DocumentInventoryLocationModifierId)argObjectId).getDocumentTypeCode());
/* 319 */     setDocumentLineNumber(((DocumentInventoryLocationModifierId)argObjectId).getDocumentLineNumber());
/* 320 */     setModifierSequence(((DocumentInventoryLocationModifierId)argObjectId).getModifierSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 324 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 328 */     StringBuilder buf = new StringBuilder(950);
/* 329 */     buf.append("<").append("dao").append(" name=\"DocumentInventoryLocationModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 330 */     getFieldsAsXml(buf);
/* 331 */     buf.append("</").append("dao").append(">");
/*     */     
/* 333 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 337 */     Map<String, String> values = super.getValues();
/* 338 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 339 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 340 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 341 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 342 */     if (this._documentLineNumber != null) values.put("DocumentLineNumber", DaoUtils.getXmlSafeFieldValue(-5, this._documentLineNumber)); 
/* 343 */     if (this._modifierSequence != null) values.put("ModifierSequence", DaoUtils.getXmlSafeFieldValue(-5, this._modifierSequence)); 
/* 344 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 345 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 346 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 347 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 348 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 349 */     if (this._sourceLocationId != null) values.put("SourceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._sourceLocationId)); 
/* 350 */     if (this._sourceBucketId != null) values.put("SourceBucketId", DaoUtils.getXmlSafeFieldValue(12, this._sourceBucketId)); 
/* 351 */     if (this._destinationLocationId != null) values.put("DestinationLocationId", DaoUtils.getXmlSafeFieldValue(12, this._destinationLocationId)); 
/* 352 */     if (this._destinationBucketId != null) values.put("DestinationBucketId", DaoUtils.getXmlSafeFieldValue(12, this._destinationBucketId)); 
/* 353 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 354 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/* 355 */     if (this._actionCode != null) values.put("ActionCode", DaoUtils.getXmlSafeFieldValue(12, this._actionCode)); 
/* 356 */     if (this._cost != null) values.put("Cost", DaoUtils.getXmlSafeFieldValue(3, this._cost)); 
/* 357 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 362 */     super.setValues(argValues);
/* 363 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 365 */       String fieldName = field.getKey();
/* 366 */       String fieldValue = field.getValue();
/* 367 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 372 */             setOrganizationId((Long)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 381 */             setRetailLocationId((Long)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setDocumentId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setDocumentTypeCode((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentLineNumber":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 408 */             setDocumentLineNumber((Long)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ModifierSequence":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 417 */             setModifierSequence((Long)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setModifierSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setCreateDate((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 435 */             setCreateUserId((String)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 444 */             setUpdateDate((Date)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 453 */             setUpdateUserId((String)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 462 */             setSerialNumber((String)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceLocationId":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 471 */             setSourceLocationId((String)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setSourceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceBucketId":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setSourceBucketId((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setSourceBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationLocationId":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 489 */             setDestinationLocationId((String)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setDestinationLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationBucketId":
/*     */           try {
/* 497 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 498 */             setDestinationBucketId((String)value);
/* 499 */           } catch (Exception ee) {
/* 500 */             throw new DtxException("An exception occurred while calling setDestinationBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 506 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 507 */             setItemId((String)value);
/* 508 */           } catch (Exception ee) {
/* 509 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 515 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 516 */             setQuantity((BigDecimal)value);
/* 517 */           } catch (Exception ee) {
/* 518 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionCode":
/*     */           try {
/* 524 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 525 */             setActionCode((String)value);
/* 526 */           } catch (Exception ee) {
/* 527 */             throw new DtxException("An exception occurred while calling setActionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Cost":
/*     */           try {
/* 533 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 534 */             setCost((BigDecimal)value);
/* 535 */           } catch (Exception ee) {
/* 536 */             throw new DtxException("An exception occurred while calling setCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentInventoryLocationModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */