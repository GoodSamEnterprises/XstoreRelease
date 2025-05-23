/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractExtensibleDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class RetailTransactionLineItemDAO
/*     */   extends AbstractExtensibleDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1772623874L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RetailTransactionLineItemDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _className;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDateTimestamp;
/*     */   private DtvDate _endDateTimestamp;
/*     */   private String _lineItemStatusCode;
/*     */   private String _lineItemTypeCode;
/*     */   private String _notes;
/*     */   private String _voidLineItemReasonCode;
/*  42 */   private Boolean _void = Boolean.FALSE;
/*  43 */   private Boolean _genericStorage = Boolean.FALSE;
/*     */   private Integer _tLogSequence;
/*     */   private String _currencyId;
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
/*     */   public Long getRetailLocationId() {
/*  58 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  62 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  63 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  68 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  72 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  73 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  79 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  83 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  84 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  89 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  93 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  94 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  99 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/* 103 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/* 104 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getClassName() {
/* 109 */     return this._className;
/*     */   }
/*     */   
/*     */   public void setClassName(String argClassName) {
/* 113 */     if (changed(argClassName, this._className, "className")) {
/* 114 */       this._className = argClassName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 119 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 123 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 124 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 130 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 134 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 135 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 140 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 144 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 145 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 151 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 155 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 156 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDateTimestamp() {
/* 161 */     return (Date)this._beginDateTimestamp;
/*     */   }
/*     */   
/*     */   public void setBeginDateTimestamp(Date argBeginDateTimestamp) {
/* 165 */     if (changed(argBeginDateTimestamp, this._beginDateTimestamp, "beginDateTimestamp")) {
/* 166 */       this._beginDateTimestamp = (argBeginDateTimestamp == null || argBeginDateTimestamp instanceof DtvDate) ? (DtvDate)argBeginDateTimestamp : new DtvDate(argBeginDateTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDateTimestamp() {
/* 172 */     return (Date)this._endDateTimestamp;
/*     */   }
/*     */   
/*     */   public void setEndDateTimestamp(Date argEndDateTimestamp) {
/* 176 */     if (changed(argEndDateTimestamp, this._endDateTimestamp, "endDateTimestamp")) {
/* 177 */       this._endDateTimestamp = (argEndDateTimestamp == null || argEndDateTimestamp instanceof DtvDate) ? (DtvDate)argEndDateTimestamp : new DtvDate(argEndDateTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLineItemStatusCode() {
/* 183 */     return this._lineItemStatusCode;
/*     */   }
/*     */   
/*     */   public void setLineItemStatusCode(String argLineItemStatusCode) {
/* 187 */     if (changed(argLineItemStatusCode, this._lineItemStatusCode, "lineItemStatusCode")) {
/* 188 */       this._lineItemStatusCode = argLineItemStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLineItemTypeCode() {
/* 193 */     return this._lineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setLineItemTypeCode(String argLineItemTypeCode) {
/* 197 */     if (changed(argLineItemTypeCode, this._lineItemTypeCode, "lineItemTypeCode")) {
/* 198 */       this._lineItemTypeCode = argLineItemTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNotes() {
/* 203 */     return this._notes;
/*     */   }
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 207 */     if (changed(argNotes, this._notes, "notes")) {
/* 208 */       this._notes = argNotes;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoidLineItemReasonCode() {
/* 213 */     return this._voidLineItemReasonCode;
/*     */   }
/*     */   
/*     */   public void setVoidLineItemReasonCode(String argVoidLineItemReasonCode) {
/* 217 */     if (changed(argVoidLineItemReasonCode, this._voidLineItemReasonCode, "voidLineItemReasonCode")) {
/* 218 */       this._voidLineItemReasonCode = argVoidLineItemReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 223 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 227 */     if (changed(argVoid, this._void, "void")) {
/* 228 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getGenericStorage() {
/* 233 */     return this._genericStorage;
/*     */   }
/*     */   
/*     */   public void setGenericStorage(Boolean argGenericStorage) {
/* 237 */     if (changed(argGenericStorage, this._genericStorage, "genericStorage")) {
/* 238 */       this._genericStorage = argGenericStorage;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTLogSequence() {
/* 243 */     return this._tLogSequence;
/*     */   }
/*     */   
/*     */   public void setTLogSequence(Integer argTLogSequence) {
/* 247 */     if (changed(argTLogSequence, this._tLogSequence, "tLogSequence")) {
/* 248 */       this._tLogSequence = argTLogSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCurrencyId() {
/* 253 */     return this._currencyId;
/*     */   }
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 257 */     if (changed(argCurrencyId, this._currencyId, "currencyId")) {
/* 258 */       this._currencyId = argCurrencyId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 265 */     StringBuilder buf = new StringBuilder(512);
/* 266 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 267 */     if (getOrganizationId() != null) {
/* 268 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 270 */     if (getRetailLocationId() != null) {
/* 271 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 273 */     if (getBusinessDate() != null) {
/* 274 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 276 */     if (getWorkstationId() != null) {
/* 277 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 279 */     if (getTransactionSequence() != null) {
/* 280 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 282 */     if (getRetailTransactionLineItemSequence() != null) {
/* 283 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 285 */     if (getClassName() != null) {
/* 286 */       buf.append("className").append("=").append(getClassName()).append(" ");
/*     */     }
/* 288 */     if (getCreateDate() != null) {
/* 289 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 291 */     if (getCreateUserId() != null) {
/* 292 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 294 */     if (getUpdateDate() != null) {
/* 295 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 297 */     if (getUpdateUserId() != null) {
/* 298 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 300 */     if (getBeginDateTimestamp() != null) {
/* 301 */       buf.append("beginDateTimestamp").append("=").append(getBeginDateTimestamp()).append(" ");
/*     */     }
/* 303 */     if (getEndDateTimestamp() != null) {
/* 304 */       buf.append("endDateTimestamp").append("=").append(getEndDateTimestamp()).append(" ");
/*     */     }
/* 306 */     if (getLineItemStatusCode() != null) {
/* 307 */       buf.append("lineItemStatusCode").append("=").append(getLineItemStatusCode()).append(" ");
/*     */     }
/* 309 */     if (getLineItemTypeCode() != null) {
/* 310 */       buf.append("lineItemTypeCode").append("=").append(getLineItemTypeCode()).append(" ");
/*     */     }
/* 312 */     if (getNotes() != null) {
/* 313 */       buf.append("notes").append("=").append(getNotes()).append(" ");
/*     */     }
/* 315 */     if (getVoidLineItemReasonCode() != null) {
/* 316 */       buf.append("voidLineItemReasonCode").append("=").append(getVoidLineItemReasonCode()).append(" ");
/*     */     }
/* 318 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 319 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 321 */     if (getGenericStorage() != null && getGenericStorage().booleanValue()) {
/* 322 */       buf.append("genericStorage").append("=").append(getGenericStorage()).append(" ");
/*     */     }
/* 324 */     if (getTLogSequence() != null) {
/* 325 */       buf.append("tLogSequence").append("=").append(getTLogSequence()).append(" ");
/*     */     }
/* 327 */     if (getCurrencyId() != null) {
/* 328 */       buf.append("currencyId").append("=").append(getCurrencyId()).append(" ");
/*     */     }
/*     */     
/* 331 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 335 */     RetailTransactionLineItemId id = new RetailTransactionLineItemId();
/* 336 */     id.setOrganizationId(getOrganizationId());
/* 337 */     id.setRetailLocationId(getRetailLocationId());
/* 338 */     id.setBusinessDate(getBusinessDate());
/* 339 */     id.setWorkstationId(getWorkstationId());
/* 340 */     id.setTransactionSequence(getTransactionSequence());
/* 341 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 342 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 346 */     setOrganizationId(((RetailTransactionLineItemId)argObjectId).getOrganizationId());
/* 347 */     setRetailLocationId(((RetailTransactionLineItemId)argObjectId).getRetailLocationId());
/* 348 */     setBusinessDate(((RetailTransactionLineItemId)argObjectId).getBusinessDate());
/* 349 */     setWorkstationId(((RetailTransactionLineItemId)argObjectId).getWorkstationId());
/* 350 */     setTransactionSequence(((RetailTransactionLineItemId)argObjectId).getTransactionSequence());
/* 351 */     setRetailTransactionLineItemSequence(((RetailTransactionLineItemId)argObjectId).getRetailTransactionLineItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 355 */     return this._className;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 359 */     StringBuilder buf = new StringBuilder(1050);
/* 360 */     buf.append("<").append("dao").append(" name=\"RetailTransactionLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 361 */     getFieldsAsXml(buf);
/* 362 */     buf.append("</").append("dao").append(">");
/*     */     
/* 364 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 368 */     Map<String, String> values = super.getValues();
/* 369 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 370 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 371 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 372 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 373 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 374 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 375 */     if (this._className != null) values.put("ClassName", DaoUtils.getXmlSafeFieldValue(12, this._className)); 
/* 376 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 377 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 378 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 379 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 380 */     if (this._beginDateTimestamp != null) values.put("BeginDateTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._beginDateTimestamp)); 
/* 381 */     if (this._endDateTimestamp != null) values.put("EndDateTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._endDateTimestamp)); 
/* 382 */     if (this._lineItemStatusCode != null) values.put("LineItemStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._lineItemStatusCode)); 
/* 383 */     if (this._lineItemTypeCode != null) values.put("LineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._lineItemTypeCode)); 
/* 384 */     if (this._notes != null) values.put("Notes", DaoUtils.getXmlSafeFieldValue(12, this._notes)); 
/* 385 */     if (this._voidLineItemReasonCode != null) values.put("VoidLineItemReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._voidLineItemReasonCode)); 
/* 386 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 387 */     if (this._genericStorage != null) values.put("GenericStorage", DaoUtils.getXmlSafeFieldValue(-7, this._genericStorage)); 
/* 388 */     if (this._tLogSequence != null) values.put("TLogSequence", DaoUtils.getXmlSafeFieldValue(4, this._tLogSequence)); 
/* 389 */     if (this._currencyId != null) values.put("CurrencyId", DaoUtils.getXmlSafeFieldValue(12, this._currencyId)); 
/* 390 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 395 */     super.setValues(argValues);
/* 396 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 398 */       String fieldName = field.getKey();
/* 399 */       String fieldValue = field.getValue();
/* 400 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 405 */             setOrganizationId((Long)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 414 */             setRetailLocationId((Long)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 423 */             setBusinessDate((Date)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 432 */             setWorkstationId((Long)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 441 */             setTransactionSequence((Long)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 449 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 450 */             setRetailTransactionLineItemSequence((Integer)value);
/* 451 */           } catch (Exception ee) {
/* 452 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClassName":
/*     */           try {
/* 458 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 459 */             setClassName((String)value);
/* 460 */           } catch (Exception ee) {
/* 461 */             throw new DtxException("An exception occurred while calling setClassName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 467 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 468 */             setCreateDate((Date)value);
/* 469 */           } catch (Exception ee) {
/* 470 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 476 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 477 */             setCreateUserId((String)value);
/* 478 */           } catch (Exception ee) {
/* 479 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 485 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 486 */             setUpdateDate((Date)value);
/* 487 */           } catch (Exception ee) {
/* 488 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 494 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 495 */             setUpdateUserId((String)value);
/* 496 */           } catch (Exception ee) {
/* 497 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDateTimestamp":
/*     */           try {
/* 503 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 504 */             setBeginDateTimestamp((Date)value);
/* 505 */           } catch (Exception ee) {
/* 506 */             throw new DtxException("An exception occurred while calling setBeginDateTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDateTimestamp":
/*     */           try {
/* 512 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 513 */             setEndDateTimestamp((Date)value);
/* 514 */           } catch (Exception ee) {
/* 515 */             throw new DtxException("An exception occurred while calling setEndDateTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemStatusCode":
/*     */           try {
/* 521 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 522 */             setLineItemStatusCode((String)value);
/* 523 */           } catch (Exception ee) {
/* 524 */             throw new DtxException("An exception occurred while calling setLineItemStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemTypeCode":
/*     */           try {
/* 530 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 531 */             setLineItemTypeCode((String)value);
/* 532 */           } catch (Exception ee) {
/* 533 */             throw new DtxException("An exception occurred while calling setLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Notes":
/*     */           try {
/* 539 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 540 */             setNotes((String)value);
/* 541 */           } catch (Exception ee) {
/* 542 */             throw new DtxException("An exception occurred while calling setNotes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoidLineItemReasonCode":
/*     */           try {
/* 548 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 549 */             setVoidLineItemReasonCode((String)value);
/* 550 */           } catch (Exception ee) {
/* 551 */             throw new DtxException("An exception occurred while calling setVoidLineItemReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 557 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 558 */             setVoid((Boolean)value);
/* 559 */           } catch (Exception ee) {
/* 560 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GenericStorage":
/*     */           try {
/* 566 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 567 */             setGenericStorage((Boolean)value);
/* 568 */           } catch (Exception ee) {
/* 569 */             throw new DtxException("An exception occurred while calling setGenericStorage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TLogSequence":
/*     */           try {
/* 575 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 576 */             setTLogSequence((Integer)value);
/* 577 */           } catch (Exception ee) {
/* 578 */             throw new DtxException("An exception occurred while calling setTLogSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CurrencyId":
/*     */           try {
/* 584 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 585 */             setCurrencyId((String)value);
/* 586 */           } catch (Exception ee) {
/* 587 */             throw new DtxException("An exception occurred while calling setCurrencyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */