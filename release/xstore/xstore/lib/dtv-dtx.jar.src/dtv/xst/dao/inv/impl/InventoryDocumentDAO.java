/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentId;
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
/*     */ public class InventoryDocumentDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 284848759L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryDocumentDAO.class);
/*     */   
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _completeDateTime;
/*     */   private DtvDate _createDateTime;
/*     */   private String _originatorId;
/*     */   private String _statusCode;
/*     */   private String _documentSubtypeCode;
/*     */   private String _originatorName;
/*     */   private DtvDate _lastActivityDate;
/*     */   private String _poReferenceNumber;
/*     */   private String _recordCreationType;
/*     */   private String _description;
/*     */   private String _controlNumber;
/*     */   private String _originatorAddressId;
/*     */   private DtvDate _submitDate;
/*     */   
/*     */   public String getDocumentId() {
/*  48 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  52 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  53 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  58 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  62 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  63 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  68 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  72 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  73 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  78 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  82 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  83 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCompleteDateTime() {
/* 130 */     return (Date)this._completeDateTime;
/*     */   }
/*     */   
/*     */   public void setCompleteDateTime(Date argCompleteDateTime) {
/* 134 */     if (changed(argCompleteDateTime, this._completeDateTime, "completeDateTime")) {
/* 135 */       this._completeDateTime = (argCompleteDateTime == null || argCompleteDateTime instanceof DtvDate) ? (DtvDate)argCompleteDateTime : new DtvDate(argCompleteDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCreateDateTime() {
/* 141 */     return (Date)this._createDateTime;
/*     */   }
/*     */   
/*     */   public void setCreateDateTime(Date argCreateDateTime) {
/* 145 */     if (changed(argCreateDateTime, this._createDateTime, "createDateTime")) {
/* 146 */       this._createDateTime = (argCreateDateTime == null || argCreateDateTime instanceof DtvDate) ? (DtvDate)argCreateDateTime : new DtvDate(argCreateDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOriginatorId() {
/* 152 */     return this._originatorId;
/*     */   }
/*     */   
/*     */   public void setOriginatorId(String argOriginatorId) {
/* 156 */     if (changed(argOriginatorId, this._originatorId, "originatorId")) {
/* 157 */       this._originatorId = argOriginatorId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCode() {
/* 162 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 166 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 167 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentSubtypeCode() {
/* 172 */     return this._documentSubtypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentSubtypeCode(String argDocumentSubtypeCode) {
/* 176 */     if (changed(argDocumentSubtypeCode, this._documentSubtypeCode, "documentSubtypeCode")) {
/* 177 */       this._documentSubtypeCode = argDocumentSubtypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOriginatorName() {
/* 182 */     return this._originatorName;
/*     */   }
/*     */   
/*     */   public void setOriginatorName(String argOriginatorName) {
/* 186 */     if (changed(argOriginatorName, this._originatorName, "originatorName")) {
/* 187 */       this._originatorName = argOriginatorName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getLastActivityDate() {
/* 192 */     return (Date)this._lastActivityDate;
/*     */   }
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 196 */     if (changed(argLastActivityDate, this._lastActivityDate, "lastActivityDate")) {
/* 197 */       this._lastActivityDate = (argLastActivityDate == null || argLastActivityDate instanceof DtvDate) ? (DtvDate)argLastActivityDate : new DtvDate(argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPoReferenceNumber() {
/* 203 */     return this._poReferenceNumber;
/*     */   }
/*     */   
/*     */   public void setPoReferenceNumber(String argPoReferenceNumber) {
/* 207 */     if (changed(argPoReferenceNumber, this._poReferenceNumber, "poReferenceNumber")) {
/* 208 */       this._poReferenceNumber = argPoReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordCreationType() {
/* 213 */     return this._recordCreationType;
/*     */   }
/*     */   
/*     */   public void setRecordCreationType(String argRecordCreationType) {
/* 217 */     if (changed(argRecordCreationType, this._recordCreationType, "recordCreationType")) {
/* 218 */       this._recordCreationType = argRecordCreationType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 223 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 227 */     if (changed(argDescription, this._description, "description")) {
/* 228 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getControlNumber() {
/* 233 */     return this._controlNumber;
/*     */   }
/*     */   
/*     */   public void setControlNumber(String argControlNumber) {
/* 237 */     if (changed(argControlNumber, this._controlNumber, "controlNumber")) {
/* 238 */       this._controlNumber = argControlNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOriginatorAddressId() {
/* 243 */     return this._originatorAddressId;
/*     */   }
/*     */   
/*     */   public void setOriginatorAddressId(String argOriginatorAddressId) {
/* 247 */     if (changed(argOriginatorAddressId, this._originatorAddressId, "originatorAddressId")) {
/* 248 */       this._originatorAddressId = argOriginatorAddressId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getSubmitDate() {
/* 253 */     return (Date)this._submitDate;
/*     */   }
/*     */   
/*     */   public void setSubmitDate(Date argSubmitDate) {
/* 257 */     if (changed(argSubmitDate, this._submitDate, "submitDate")) {
/* 258 */       this._submitDate = (argSubmitDate == null || argSubmitDate instanceof DtvDate) ? (DtvDate)argSubmitDate : new DtvDate(argSubmitDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 266 */     StringBuilder buf = new StringBuilder(512);
/* 267 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 268 */     if (getDocumentId() != null) {
/* 269 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 271 */     if (getDocumentTypeCode() != null) {
/* 272 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 274 */     if (getOrganizationId() != null) {
/* 275 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 277 */     if (getRetailLocationId() != null) {
/* 278 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 280 */     if (getCreateDate() != null) {
/* 281 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 283 */     if (getCreateUserId() != null) {
/* 284 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 286 */     if (getUpdateDate() != null) {
/* 287 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 289 */     if (getUpdateUserId() != null) {
/* 290 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 292 */     if (getCompleteDateTime() != null) {
/* 293 */       buf.append("completeDateTime").append("=").append(getCompleteDateTime()).append(" ");
/*     */     }
/* 295 */     if (getCreateDateTime() != null) {
/* 296 */       buf.append("createDateTime").append("=").append(getCreateDateTime()).append(" ");
/*     */     }
/* 298 */     if (getOriginatorId() != null) {
/* 299 */       buf.append("originatorId").append("=").append(getOriginatorId()).append(" ");
/*     */     }
/* 301 */     if (getStatusCode() != null) {
/* 302 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 304 */     if (getDocumentSubtypeCode() != null) {
/* 305 */       buf.append("documentSubtypeCode").append("=").append(getDocumentSubtypeCode()).append(" ");
/*     */     }
/* 307 */     if (getOriginatorName() != null) {
/* 308 */       buf.append("originatorName").append("=").append(getOriginatorName()).append(" ");
/*     */     }
/* 310 */     if (getLastActivityDate() != null) {
/* 311 */       buf.append("lastActivityDate").append("=").append(getLastActivityDate()).append(" ");
/*     */     }
/* 313 */     if (getPoReferenceNumber() != null) {
/* 314 */       buf.append("poReferenceNumber").append("=").append(getPoReferenceNumber()).append(" ");
/*     */     }
/* 316 */     if (getRecordCreationType() != null) {
/* 317 */       buf.append("recordCreationType").append("=").append(getRecordCreationType()).append(" ");
/*     */     }
/* 319 */     if (getDescription() != null) {
/* 320 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 322 */     if (getControlNumber() != null) {
/* 323 */       buf.append("controlNumber").append("=").append(getControlNumber()).append(" ");
/*     */     }
/* 325 */     if (getOriginatorAddressId() != null) {
/* 326 */       buf.append("originatorAddressId").append("=").append(getOriginatorAddressId()).append(" ");
/*     */     }
/* 328 */     if (getSubmitDate() != null) {
/* 329 */       buf.append("submitDate").append("=").append(getSubmitDate()).append(" ");
/*     */     }
/*     */     
/* 332 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 336 */     InventoryDocumentId id = new InventoryDocumentId();
/* 337 */     id.setDocumentId(getDocumentId());
/* 338 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 339 */     id.setOrganizationId(getOrganizationId());
/* 340 */     id.setRetailLocationId(getRetailLocationId());
/* 341 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 345 */     setDocumentId(((InventoryDocumentId)argObjectId).getDocumentId());
/* 346 */     setDocumentTypeCode(((InventoryDocumentId)argObjectId).getDocumentTypeCode());
/* 347 */     setOrganizationId(((InventoryDocumentId)argObjectId).getOrganizationId());
/* 348 */     setRetailLocationId(((InventoryDocumentId)argObjectId).getRetailLocationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 352 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 356 */     StringBuilder buf = new StringBuilder(1050);
/* 357 */     buf.append("<").append("dao").append(" name=\"InventoryDocument\" cmd=\"" + getObjectStateString() + "\">");
/* 358 */     getFieldsAsXml(buf);
/* 359 */     buf.append("</").append("dao").append(">");
/*     */     
/* 361 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 365 */     Map<String, String> values = super.getValues();
/* 366 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 367 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 368 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 369 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 370 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 371 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 372 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 373 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 374 */     if (this._completeDateTime != null) values.put("CompleteDateTime", DaoUtils.getXmlSafeFieldValue(91, this._completeDateTime)); 
/* 375 */     if (this._createDateTime != null) values.put("CreateDateTime", DaoUtils.getXmlSafeFieldValue(91, this._createDateTime)); 
/* 376 */     if (this._originatorId != null) values.put("OriginatorId", DaoUtils.getXmlSafeFieldValue(12, this._originatorId)); 
/* 377 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 378 */     if (this._documentSubtypeCode != null) values.put("DocumentSubtypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentSubtypeCode)); 
/* 379 */     if (this._originatorName != null) values.put("OriginatorName", DaoUtils.getXmlSafeFieldValue(12, this._originatorName)); 
/* 380 */     if (this._lastActivityDate != null) values.put("LastActivityDate", DaoUtils.getXmlSafeFieldValue(91, this._lastActivityDate)); 
/* 381 */     if (this._poReferenceNumber != null) values.put("PoReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._poReferenceNumber)); 
/* 382 */     if (this._recordCreationType != null) values.put("RecordCreationType", DaoUtils.getXmlSafeFieldValue(12, this._recordCreationType)); 
/* 383 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 384 */     if (this._controlNumber != null) values.put("ControlNumber", DaoUtils.getXmlSafeFieldValue(12, this._controlNumber)); 
/* 385 */     if (this._originatorAddressId != null) values.put("OriginatorAddressId", DaoUtils.getXmlSafeFieldValue(12, this._originatorAddressId)); 
/* 386 */     if (this._submitDate != null) values.put("SubmitDate", DaoUtils.getXmlSafeFieldValue(91, this._submitDate)); 
/* 387 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 392 */     super.setValues(argValues);
/* 393 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 395 */       String fieldName = field.getKey();
/* 396 */       String fieldValue = field.getValue();
/* 397 */       switch (fieldName) {
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 402 */             setDocumentId((String)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 411 */             setDocumentTypeCode((String)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 420 */             setOrganizationId((Long)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 429 */             setRetailLocationId((Long)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 438 */             setCreateDate((Date)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 447 */             setCreateUserId((String)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 456 */             setUpdateDate((Date)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 464 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 465 */             setUpdateUserId((String)value);
/* 466 */           } catch (Exception ee) {
/* 467 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CompleteDateTime":
/*     */           try {
/* 473 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 474 */             setCompleteDateTime((Date)value);
/* 475 */           } catch (Exception ee) {
/* 476 */             throw new DtxException("An exception occurred while calling setCompleteDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDateTime":
/*     */           try {
/* 482 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 483 */             setCreateDateTime((Date)value);
/* 484 */           } catch (Exception ee) {
/* 485 */             throw new DtxException("An exception occurred while calling setCreateDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginatorId":
/*     */           try {
/* 491 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 492 */             setOriginatorId((String)value);
/* 493 */           } catch (Exception ee) {
/* 494 */             throw new DtxException("An exception occurred while calling setOriginatorId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 500 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 501 */             setStatusCode((String)value);
/* 502 */           } catch (Exception ee) {
/* 503 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentSubtypeCode":
/*     */           try {
/* 509 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 510 */             setDocumentSubtypeCode((String)value);
/* 511 */           } catch (Exception ee) {
/* 512 */             throw new DtxException("An exception occurred while calling setDocumentSubtypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginatorName":
/*     */           try {
/* 518 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 519 */             setOriginatorName((String)value);
/* 520 */           } catch (Exception ee) {
/* 521 */             throw new DtxException("An exception occurred while calling setOriginatorName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastActivityDate":
/*     */           try {
/* 527 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 528 */             setLastActivityDate((Date)value);
/* 529 */           } catch (Exception ee) {
/* 530 */             throw new DtxException("An exception occurred while calling setLastActivityDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PoReferenceNumber":
/*     */           try {
/* 536 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 537 */             setPoReferenceNumber((String)value);
/* 538 */           } catch (Exception ee) {
/* 539 */             throw new DtxException("An exception occurred while calling setPoReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordCreationType":
/*     */           try {
/* 545 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 546 */             setRecordCreationType((String)value);
/* 547 */           } catch (Exception ee) {
/* 548 */             throw new DtxException("An exception occurred while calling setRecordCreationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 554 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 555 */             setDescription((String)value);
/* 556 */           } catch (Exception ee) {
/* 557 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ControlNumber":
/*     */           try {
/* 563 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 564 */             setControlNumber((String)value);
/* 565 */           } catch (Exception ee) {
/* 566 */             throw new DtxException("An exception occurred while calling setControlNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginatorAddressId":
/*     */           try {
/* 572 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 573 */             setOriginatorAddressId((String)value);
/* 574 */           } catch (Exception ee) {
/* 575 */             throw new DtxException("An exception occurred while calling setOriginatorAddressId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SubmitDate":
/*     */           try {
/* 581 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 582 */             setSubmitDate((Date)value);
/* 583 */           } catch (Exception ee) {
/* 584 */             throw new DtxException("An exception occurred while calling setSubmitDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */