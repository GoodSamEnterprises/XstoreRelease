/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.TenderAuthLogId;
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
/*     */ public class TenderAuthLogDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1325511960L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderAuthLogDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Integer _attemptSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _responseCode;
/*     */   private String _approvalCode;
/*     */   private String _authType;
/*     */   private String _customerName;
/*     */   private String _referenceNumber;
/*     */   private String _errorCode;
/*     */   private String _errorText;
/*     */   private DtvDate _startTimestamp;
/*     */   private DtvDate _endTimestamp;
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
/*     */   public Long getRetailLocationId() {
/*  57 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  61 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  62 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  67 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  71 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  72 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  77 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  81 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  82 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  88 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  92 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  93 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  98 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/* 102 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/* 103 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getAttemptSequence() {
/* 108 */     return this._attemptSequence;
/*     */   }
/*     */   
/*     */   public void setAttemptSequence(Integer argAttemptSequence) {
/* 112 */     if (changed(argAttemptSequence, this._attemptSequence, "attemptSequence")) {
/* 113 */       this._attemptSequence = argAttemptSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 118 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 122 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 123 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 129 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 133 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 134 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 139 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 143 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 144 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 150 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 154 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 155 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getResponseCode() {
/* 160 */     return this._responseCode;
/*     */   }
/*     */   
/*     */   public void setResponseCode(String argResponseCode) {
/* 164 */     if (changed(argResponseCode, this._responseCode, "responseCode")) {
/* 165 */       this._responseCode = argResponseCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApprovalCode() {
/* 170 */     return this._approvalCode;
/*     */   }
/*     */   
/*     */   public void setApprovalCode(String argApprovalCode) {
/* 174 */     if (changed(argApprovalCode, this._approvalCode, "approvalCode")) {
/* 175 */       this._approvalCode = argApprovalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthType() {
/* 180 */     return this._authType;
/*     */   }
/*     */   
/*     */   public void setAuthType(String argAuthType) {
/* 184 */     if (changed(argAuthType, this._authType, "authType")) {
/* 185 */       this._authType = argAuthType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerName() {
/* 190 */     return this._customerName;
/*     */   }
/*     */   
/*     */   public void setCustomerName(String argCustomerName) {
/* 194 */     if (changed(argCustomerName, this._customerName, "customerName")) {
/* 195 */       this._customerName = argCustomerName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReferenceNumber() {
/* 200 */     return this._referenceNumber;
/*     */   }
/*     */   
/*     */   public void setReferenceNumber(String argReferenceNumber) {
/* 204 */     if (changed(argReferenceNumber, this._referenceNumber, "referenceNumber")) {
/* 205 */       this._referenceNumber = argReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getErrorCode() {
/* 210 */     return this._errorCode;
/*     */   }
/*     */   
/*     */   public void setErrorCode(String argErrorCode) {
/* 214 */     if (changed(argErrorCode, this._errorCode, "errorCode")) {
/* 215 */       this._errorCode = argErrorCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getErrorText() {
/* 220 */     return this._errorText;
/*     */   }
/*     */   
/*     */   public void setErrorText(String argErrorText) {
/* 224 */     if (changed(argErrorText, this._errorText, "errorText")) {
/* 225 */       this._errorText = argErrorText;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartTimestamp() {
/* 230 */     return (Date)this._startTimestamp;
/*     */   }
/*     */   
/*     */   public void setStartTimestamp(Date argStartTimestamp) {
/* 234 */     if (changed(argStartTimestamp, this._startTimestamp, "startTimestamp")) {
/* 235 */       this._startTimestamp = (argStartTimestamp == null || argStartTimestamp instanceof DtvDate) ? (DtvDate)argStartTimestamp : new DtvDate(argStartTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndTimestamp() {
/* 241 */     return (Date)this._endTimestamp;
/*     */   }
/*     */   
/*     */   public void setEndTimestamp(Date argEndTimestamp) {
/* 245 */     if (changed(argEndTimestamp, this._endTimestamp, "endTimestamp")) {
/* 246 */       this._endTimestamp = (argEndTimestamp == null || argEndTimestamp instanceof DtvDate) ? (DtvDate)argEndTimestamp : new DtvDate(argEndTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 254 */     StringBuilder buf = new StringBuilder(512);
/* 255 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 256 */     if (getOrganizationId() != null) {
/* 257 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 259 */     if (getRetailLocationId() != null) {
/* 260 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 262 */     if (getWorkstationId() != null) {
/* 263 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 265 */     if (getBusinessDate() != null) {
/* 266 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 268 */     if (getTransactionSequence() != null) {
/* 269 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 271 */     if (getRetailTransactionLineItemSequence() != null) {
/* 272 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 274 */     if (getAttemptSequence() != null) {
/* 275 */       buf.append("attemptSequence").append("=").append(getAttemptSequence()).append(" ");
/*     */     }
/* 277 */     if (getCreateDate() != null) {
/* 278 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 280 */     if (getCreateUserId() != null) {
/* 281 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 283 */     if (getUpdateDate() != null) {
/* 284 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 286 */     if (getUpdateUserId() != null) {
/* 287 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 289 */     if (getResponseCode() != null) {
/* 290 */       buf.append("responseCode").append("=").append(getResponseCode()).append(" ");
/*     */     }
/* 292 */     if (getApprovalCode() != null) {
/* 293 */       buf.append("approvalCode").append("=").append(getApprovalCode()).append(" ");
/*     */     }
/* 295 */     if (getAuthType() != null) {
/* 296 */       buf.append("authType").append("=").append(getAuthType()).append(" ");
/*     */     }
/* 298 */     if (getCustomerName() != null) {
/* 299 */       buf.append("customerName").append("=").append(getCustomerName()).append(" ");
/*     */     }
/* 301 */     if (getReferenceNumber() != null) {
/* 302 */       buf.append("referenceNumber").append("=").append(getReferenceNumber()).append(" ");
/*     */     }
/* 304 */     if (getErrorCode() != null) {
/* 305 */       buf.append("errorCode").append("=").append(getErrorCode()).append(" ");
/*     */     }
/* 307 */     if (getErrorText() != null) {
/* 308 */       buf.append("errorText").append("=").append(getErrorText()).append(" ");
/*     */     }
/* 310 */     if (getStartTimestamp() != null) {
/* 311 */       buf.append("startTimestamp").append("=").append(getStartTimestamp()).append(" ");
/*     */     }
/* 313 */     if (getEndTimestamp() != null) {
/* 314 */       buf.append("endTimestamp").append("=").append(getEndTimestamp()).append(" ");
/*     */     }
/*     */     
/* 317 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 321 */     TenderAuthLogId id = new TenderAuthLogId();
/* 322 */     id.setOrganizationId(getOrganizationId());
/* 323 */     id.setRetailLocationId(getRetailLocationId());
/* 324 */     id.setWorkstationId(getWorkstationId());
/* 325 */     id.setBusinessDate(getBusinessDate());
/* 326 */     id.setTransactionSequence(getTransactionSequence());
/* 327 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 328 */     id.setAttemptSequence(getAttemptSequence());
/* 329 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 333 */     setOrganizationId(((TenderAuthLogId)argObjectId).getOrganizationId());
/* 334 */     setRetailLocationId(((TenderAuthLogId)argObjectId).getRetailLocationId());
/* 335 */     setWorkstationId(((TenderAuthLogId)argObjectId).getWorkstationId());
/* 336 */     setBusinessDate(((TenderAuthLogId)argObjectId).getBusinessDate());
/* 337 */     setTransactionSequence(((TenderAuthLogId)argObjectId).getTransactionSequence());
/* 338 */     setRetailTransactionLineItemSequence(((TenderAuthLogId)argObjectId).getRetailTransactionLineItemSequence());
/* 339 */     setAttemptSequence(((TenderAuthLogId)argObjectId).getAttemptSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 343 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 347 */     StringBuilder buf = new StringBuilder(1000);
/* 348 */     buf.append("<").append("dao").append(" name=\"TenderAuthLog\" cmd=\"" + getObjectStateString() + "\">");
/* 349 */     getFieldsAsXml(buf);
/* 350 */     buf.append("</").append("dao").append(">");
/*     */     
/* 352 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 356 */     Map<String, String> values = super.getValues();
/* 357 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 358 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 359 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 360 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 361 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 362 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 363 */     if (this._attemptSequence != null) values.put("AttemptSequence", DaoUtils.getXmlSafeFieldValue(4, this._attemptSequence)); 
/* 364 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 365 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 366 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 367 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 368 */     if (this._responseCode != null) values.put("ResponseCode", DaoUtils.getXmlSafeFieldValue(12, this._responseCode)); 
/* 369 */     if (this._approvalCode != null) values.put("ApprovalCode", DaoUtils.getXmlSafeFieldValue(12, this._approvalCode)); 
/* 370 */     if (this._authType != null) values.put("AuthType", DaoUtils.getXmlSafeFieldValue(12, this._authType)); 
/* 371 */     if (this._customerName != null) values.put("CustomerName", DaoUtils.getXmlSafeFieldValue(12, this._customerName)); 
/* 372 */     if (this._referenceNumber != null) values.put("ReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._referenceNumber)); 
/* 373 */     if (this._errorCode != null) values.put("ErrorCode", DaoUtils.getXmlSafeFieldValue(12, this._errorCode)); 
/* 374 */     if (this._errorText != null) values.put("ErrorText", DaoUtils.getXmlSafeFieldValue(12, this._errorText)); 
/* 375 */     if (this._startTimestamp != null) values.put("StartTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._startTimestamp)); 
/* 376 */     if (this._endTimestamp != null) values.put("EndTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._endTimestamp)); 
/* 377 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 382 */     super.setValues(argValues);
/* 383 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 385 */       String fieldName = field.getKey();
/* 386 */       String fieldValue = field.getValue();
/* 387 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 392 */             setOrganizationId((Long)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 400 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 401 */             setRetailLocationId((Long)value);
/* 402 */           } catch (Exception ee) {
/* 403 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 409 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 410 */             setWorkstationId((Long)value);
/* 411 */           } catch (Exception ee) {
/* 412 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 418 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 419 */             setBusinessDate((Date)value);
/* 420 */           } catch (Exception ee) {
/* 421 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 427 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 428 */             setTransactionSequence((Long)value);
/* 429 */           } catch (Exception ee) {
/* 430 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 436 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 437 */             setRetailTransactionLineItemSequence((Integer)value);
/* 438 */           } catch (Exception ee) {
/* 439 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AttemptSequence":
/*     */           try {
/* 445 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 446 */             setAttemptSequence((Integer)value);
/* 447 */           } catch (Exception ee) {
/* 448 */             throw new DtxException("An exception occurred while calling setAttemptSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 454 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 455 */             setCreateDate((Date)value);
/* 456 */           } catch (Exception ee) {
/* 457 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 463 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 464 */             setCreateUserId((String)value);
/* 465 */           } catch (Exception ee) {
/* 466 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 472 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 473 */             setUpdateDate((Date)value);
/* 474 */           } catch (Exception ee) {
/* 475 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 481 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 482 */             setUpdateUserId((String)value);
/* 483 */           } catch (Exception ee) {
/* 484 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ResponseCode":
/*     */           try {
/* 490 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 491 */             setResponseCode((String)value);
/* 492 */           } catch (Exception ee) {
/* 493 */             throw new DtxException("An exception occurred while calling setResponseCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ApprovalCode":
/*     */           try {
/* 499 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 500 */             setApprovalCode((String)value);
/* 501 */           } catch (Exception ee) {
/* 502 */             throw new DtxException("An exception occurred while calling setApprovalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthType":
/*     */           try {
/* 508 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 509 */             setAuthType((String)value);
/* 510 */           } catch (Exception ee) {
/* 511 */             throw new DtxException("An exception occurred while calling setAuthType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerName":
/*     */           try {
/* 517 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 518 */             setCustomerName((String)value);
/* 519 */           } catch (Exception ee) {
/* 520 */             throw new DtxException("An exception occurred while calling setCustomerName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReferenceNumber":
/*     */           try {
/* 526 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 527 */             setReferenceNumber((String)value);
/* 528 */           } catch (Exception ee) {
/* 529 */             throw new DtxException("An exception occurred while calling setReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ErrorCode":
/*     */           try {
/* 535 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 536 */             setErrorCode((String)value);
/* 537 */           } catch (Exception ee) {
/* 538 */             throw new DtxException("An exception occurred while calling setErrorCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ErrorText":
/*     */           try {
/* 544 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 545 */             setErrorText((String)value);
/* 546 */           } catch (Exception ee) {
/* 547 */             throw new DtxException("An exception occurred while calling setErrorText() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTimestamp":
/*     */           try {
/* 553 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 554 */             setStartTimestamp((Date)value);
/* 555 */           } catch (Exception ee) {
/* 556 */             throw new DtxException("An exception occurred while calling setStartTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTimestamp":
/*     */           try {
/* 562 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 563 */             setEndTimestamp((Date)value);
/* 564 */           } catch (Exception ee) {
/* 565 */             throw new DtxException("An exception occurred while calling setEndTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\TenderAuthLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */