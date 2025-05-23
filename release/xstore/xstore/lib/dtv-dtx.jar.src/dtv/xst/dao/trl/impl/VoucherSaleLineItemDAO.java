/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VoucherSaleLineItemDAO
/*     */   extends SaleReturnLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = 24152124L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VoucherSaleLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _activityCode;
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _entryMethodCode;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private String _bankReferenceNumber;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   private BigDecimal _faceValueAmount;
/*     */   private DtvDate _issueDatetimestamp;
/*     */   private String _issueTypeCode;
/*     */   private BigDecimal _unspentBalanceAmount;
/*     */   private String _voucherStatusCode;
/*     */   private String _traceNumber;
/*     */   private String _origLocalDateTime;
/*     */   private String _origTransmissionDateTime;
/*     */   private String _origSTAN;
/*     */   private String _merchantCategoryCode;
/*     */   
/*     */   public Date getCreateDate() {
/*  51 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  55 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  56 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  62 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  66 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  67 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  72 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  76 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  77 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  83 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  87 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  88 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActivityCode() {
/*  93 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/*  97 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/*  98 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAdjudicationCode() {
/* 103 */     return this._adjudicationCode;
/*     */   }
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 107 */     if (changed(argAdjudicationCode, this._adjudicationCode, "adjudicationCode")) {
/* 108 */       this._adjudicationCode = argAdjudicationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationCode() {
/* 113 */     return this._authorizationCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 117 */     if (changed(argAuthorizationCode, this._authorizationCode, "authorizationCode")) {
/* 118 */       this._authorizationCode = argAuthorizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 123 */     return this._authorizationMethodCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 127 */     if (changed(argAuthorizationMethodCode, this._authorizationMethodCode, "authorizationMethodCode")) {
/* 128 */       this._authorizationMethodCode = argAuthorizationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/* 133 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 137 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 138 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 143 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 147 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 148 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherTypeCode() {
/* 153 */     return this._voucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/* 157 */     if (changed(argVoucherTypeCode, this._voucherTypeCode, "voucherTypeCode")) {
/* 158 */       this._voucherTypeCode = argVoucherTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBankReferenceNumber() {
/* 163 */     return this._bankReferenceNumber;
/*     */   }
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 167 */     if (changed(argBankReferenceNumber, this._bankReferenceNumber, "bankReferenceNumber")) {
/* 168 */       this._bankReferenceNumber = argBankReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 173 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 177 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 178 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 184 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 188 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 189 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getFaceValueAmount() {
/* 195 */     return this._faceValueAmount;
/*     */   }
/*     */   
/*     */   public void setFaceValueAmount(BigDecimal argFaceValueAmount) {
/* 199 */     if (changed(argFaceValueAmount, this._faceValueAmount, "faceValueAmount")) {
/* 200 */       this._faceValueAmount = argFaceValueAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getIssueDatetimestamp() {
/* 205 */     return (Date)this._issueDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setIssueDatetimestamp(Date argIssueDatetimestamp) {
/* 209 */     if (changed(argIssueDatetimestamp, this._issueDatetimestamp, "issueDatetimestamp")) {
/* 210 */       this._issueDatetimestamp = (argIssueDatetimestamp == null || argIssueDatetimestamp instanceof DtvDate) ? (DtvDate)argIssueDatetimestamp : new DtvDate(argIssueDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIssueTypeCode() {
/* 216 */     return this._issueTypeCode;
/*     */   }
/*     */   
/*     */   public void setIssueTypeCode(String argIssueTypeCode) {
/* 220 */     if (changed(argIssueTypeCode, this._issueTypeCode, "issueTypeCode")) {
/* 221 */       this._issueTypeCode = argIssueTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnspentBalanceAmount() {
/* 226 */     return this._unspentBalanceAmount;
/*     */   }
/*     */   
/*     */   public void setUnspentBalanceAmount(BigDecimal argUnspentBalanceAmount) {
/* 230 */     if (changed(argUnspentBalanceAmount, this._unspentBalanceAmount, "unspentBalanceAmount")) {
/* 231 */       this._unspentBalanceAmount = argUnspentBalanceAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherStatusCode() {
/* 236 */     return this._voucherStatusCode;
/*     */   }
/*     */   
/*     */   public void setVoucherStatusCode(String argVoucherStatusCode) {
/* 240 */     if (changed(argVoucherStatusCode, this._voucherStatusCode, "voucherStatusCode")) {
/* 241 */       this._voucherStatusCode = argVoucherStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTraceNumber() {
/* 246 */     return this._traceNumber;
/*     */   }
/*     */   
/*     */   public void setTraceNumber(String argTraceNumber) {
/* 250 */     if (changed(argTraceNumber, this._traceNumber, "traceNumber")) {
/* 251 */       this._traceNumber = argTraceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigLocalDateTime() {
/* 256 */     return this._origLocalDateTime;
/*     */   }
/*     */   
/*     */   public void setOrigLocalDateTime(String argOrigLocalDateTime) {
/* 260 */     if (changed(argOrigLocalDateTime, this._origLocalDateTime, "origLocalDateTime")) {
/* 261 */       this._origLocalDateTime = argOrigLocalDateTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigTransmissionDateTime() {
/* 266 */     return this._origTransmissionDateTime;
/*     */   }
/*     */   
/*     */   public void setOrigTransmissionDateTime(String argOrigTransmissionDateTime) {
/* 270 */     if (changed(argOrigTransmissionDateTime, this._origTransmissionDateTime, "origTransmissionDateTime")) {
/* 271 */       this._origTransmissionDateTime = argOrigTransmissionDateTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigSTAN() {
/* 276 */     return this._origSTAN;
/*     */   }
/*     */   
/*     */   public void setOrigSTAN(String argOrigSTAN) {
/* 280 */     if (changed(argOrigSTAN, this._origSTAN, "origSTAN")) {
/* 281 */       this._origSTAN = argOrigSTAN;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchantCategoryCode() {
/* 286 */     return this._merchantCategoryCode;
/*     */   }
/*     */   
/*     */   public void setMerchantCategoryCode(String argMerchantCategoryCode) {
/* 290 */     if (changed(argMerchantCategoryCode, this._merchantCategoryCode, "merchantCategoryCode")) {
/* 291 */       this._merchantCategoryCode = argMerchantCategoryCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 298 */     StringBuilder buf = new StringBuilder(512);
/* 299 */     buf.append(super.toString());
/* 300 */     if (getCreateDate() != null) {
/* 301 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 303 */     if (getCreateUserId() != null) {
/* 304 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 306 */     if (getUpdateDate() != null) {
/* 307 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 309 */     if (getUpdateUserId() != null) {
/* 310 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 312 */     if (getActivityCode() != null) {
/* 313 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/* 315 */     if (getAdjudicationCode() != null) {
/* 316 */       buf.append("adjudicationCode").append("=").append(getAdjudicationCode()).append(" ");
/*     */     }
/* 318 */     if (getAuthorizationCode() != null) {
/* 319 */       buf.append("authorizationCode").append("=").append(getAuthorizationCode()).append(" ");
/*     */     }
/* 321 */     if (getAuthorizationMethodCode() != null) {
/* 322 */       buf.append("authorizationMethodCode").append("=").append(getAuthorizationMethodCode()).append(" ");
/*     */     }
/* 324 */     if (getEntryMethodCode() != null) {
/* 325 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 327 */     if (getSerialNumber() != null) {
/* 328 */       buf.append("serialNumber").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 330 */     if (getVoucherTypeCode() != null) {
/* 331 */       buf.append("voucherTypeCode").append("=").append(getVoucherTypeCode()).append(" ");
/*     */     }
/* 333 */     if (getBankReferenceNumber() != null) {
/* 334 */       buf.append("bankReferenceNumber").append("=").append(getBankReferenceNumber()).append(" ");
/*     */     }
/* 336 */     if (getEffectiveDate() != null) {
/* 337 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 339 */     if (getExpirationDate() != null) {
/* 340 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 342 */     if (getFaceValueAmount() != null) {
/* 343 */       buf.append("faceValueAmount").append("=").append(getFaceValueAmount()).append(" ");
/*     */     }
/* 345 */     if (getIssueDatetimestamp() != null) {
/* 346 */       buf.append("issueDatetimestamp").append("=").append(getIssueDatetimestamp()).append(" ");
/*     */     }
/* 348 */     if (getIssueTypeCode() != null) {
/* 349 */       buf.append("issueTypeCode").append("=").append(getIssueTypeCode()).append(" ");
/*     */     }
/* 351 */     if (getUnspentBalanceAmount() != null) {
/* 352 */       buf.append("unspentBalanceAmount").append("=").append(getUnspentBalanceAmount()).append(" ");
/*     */     }
/* 354 */     if (getVoucherStatusCode() != null) {
/* 355 */       buf.append("voucherStatusCode").append("=").append(getVoucherStatusCode()).append(" ");
/*     */     }
/* 357 */     if (getTraceNumber() != null) {
/* 358 */       buf.append("traceNumber").append("=").append(getTraceNumber()).append(" ");
/*     */     }
/* 360 */     if (getOrigLocalDateTime() != null) {
/* 361 */       buf.append("origLocalDateTime").append("=").append(getOrigLocalDateTime()).append(" ");
/*     */     }
/* 363 */     if (getOrigTransmissionDateTime() != null) {
/* 364 */       buf.append("origTransmissionDateTime").append("=").append(getOrigTransmissionDateTime()).append(" ");
/*     */     }
/* 366 */     if (getOrigSTAN() != null) {
/* 367 */       buf.append("origSTAN").append("=").append(getOrigSTAN()).append(" ");
/*     */     }
/* 369 */     if (getMerchantCategoryCode() != null) {
/* 370 */       buf.append("merchantCategoryCode").append("=").append(getMerchantCategoryCode()).append(" ");
/*     */     }
/*     */     
/* 373 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 378 */     StringBuilder buf = new StringBuilder(4850);
/* 379 */     buf.append("<").append("dao").append(" name=\"VoucherSaleLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 380 */     getFieldsAsXml(buf);
/* 381 */     buf.append("</").append("dao").append(">");
/*     */     
/* 383 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 387 */     Map<String, String> values = super.getValues();
/* 388 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 389 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 390 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 391 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 392 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
/* 393 */     if (this._adjudicationCode != null) values.put("AdjudicationCode", DaoUtils.getXmlSafeFieldValue(12, this._adjudicationCode)); 
/* 394 */     if (this._authorizationCode != null) values.put("AuthorizationCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationCode)); 
/* 395 */     if (this._authorizationMethodCode != null) values.put("AuthorizationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationMethodCode)); 
/* 396 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 397 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 398 */     if (this._voucherTypeCode != null) values.put("VoucherTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherTypeCode)); 
/* 399 */     if (this._bankReferenceNumber != null) values.put("BankReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._bankReferenceNumber)); 
/* 400 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 401 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 402 */     if (this._faceValueAmount != null) values.put("FaceValueAmount", DaoUtils.getXmlSafeFieldValue(3, this._faceValueAmount)); 
/* 403 */     if (this._issueDatetimestamp != null) values.put("IssueDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._issueDatetimestamp)); 
/* 404 */     if (this._issueTypeCode != null) values.put("IssueTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._issueTypeCode)); 
/* 405 */     if (this._unspentBalanceAmount != null) values.put("UnspentBalanceAmount", DaoUtils.getXmlSafeFieldValue(3, this._unspentBalanceAmount)); 
/* 406 */     if (this._voucherStatusCode != null) values.put("VoucherStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherStatusCode)); 
/* 407 */     if (this._traceNumber != null) values.put("TraceNumber", DaoUtils.getXmlSafeFieldValue(12, this._traceNumber)); 
/* 408 */     if (this._origLocalDateTime != null) values.put("OrigLocalDateTime", DaoUtils.getXmlSafeFieldValue(12, this._origLocalDateTime)); 
/* 409 */     if (this._origTransmissionDateTime != null) values.put("OrigTransmissionDateTime", DaoUtils.getXmlSafeFieldValue(12, this._origTransmissionDateTime)); 
/* 410 */     if (this._origSTAN != null) values.put("OrigSTAN", DaoUtils.getXmlSafeFieldValue(12, this._origSTAN)); 
/* 411 */     if (this._merchantCategoryCode != null) values.put("MerchantCategoryCode", DaoUtils.getXmlSafeFieldValue(12, this._merchantCategoryCode)); 
/* 412 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 417 */     super.setValues(argValues);
/* 418 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 420 */       String fieldName = field.getKey();
/* 421 */       String fieldValue = field.getValue();
/* 422 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 427 */             setCreateDate((Date)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 436 */             setCreateUserId((String)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 445 */             setUpdateDate((Date)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 454 */             setUpdateUserId((String)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 463 */             setActivityCode((String)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjudicationCode":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 472 */             setAdjudicationCode((String)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setAdjudicationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationCode":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 481 */             setAuthorizationCode((String)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setAuthorizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationMethodCode":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 490 */             setAuthorizationMethodCode((String)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setAuthorizationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 498 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 499 */             setEntryMethodCode((String)value);
/* 500 */           } catch (Exception ee) {
/* 501 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 507 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 508 */             setSerialNumber((String)value);
/* 509 */           } catch (Exception ee) {
/* 510 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherTypeCode":
/*     */           try {
/* 516 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 517 */             setVoucherTypeCode((String)value);
/* 518 */           } catch (Exception ee) {
/* 519 */             throw new DtxException("An exception occurred while calling setVoucherTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BankReferenceNumber":
/*     */           try {
/* 525 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 526 */             setBankReferenceNumber((String)value);
/* 527 */           } catch (Exception ee) {
/* 528 */             throw new DtxException("An exception occurred while calling setBankReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 534 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 535 */             setEffectiveDate((Date)value);
/* 536 */           } catch (Exception ee) {
/* 537 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 543 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 544 */             setExpirationDate((Date)value);
/* 545 */           } catch (Exception ee) {
/* 546 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FaceValueAmount":
/*     */           try {
/* 552 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 553 */             setFaceValueAmount((BigDecimal)value);
/* 554 */           } catch (Exception ee) {
/* 555 */             throw new DtxException("An exception occurred while calling setFaceValueAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueDatetimestamp":
/*     */           try {
/* 561 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 562 */             setIssueDatetimestamp((Date)value);
/* 563 */           } catch (Exception ee) {
/* 564 */             throw new DtxException("An exception occurred while calling setIssueDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueTypeCode":
/*     */           try {
/* 570 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 571 */             setIssueTypeCode((String)value);
/* 572 */           } catch (Exception ee) {
/* 573 */             throw new DtxException("An exception occurred while calling setIssueTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnspentBalanceAmount":
/*     */           try {
/* 579 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 580 */             setUnspentBalanceAmount((BigDecimal)value);
/* 581 */           } catch (Exception ee) {
/* 582 */             throw new DtxException("An exception occurred while calling setUnspentBalanceAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherStatusCode":
/*     */           try {
/* 588 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 589 */             setVoucherStatusCode((String)value);
/* 590 */           } catch (Exception ee) {
/* 591 */             throw new DtxException("An exception occurred while calling setVoucherStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TraceNumber":
/*     */           try {
/* 597 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 598 */             setTraceNumber((String)value);
/* 599 */           } catch (Exception ee) {
/* 600 */             throw new DtxException("An exception occurred while calling setTraceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigLocalDateTime":
/*     */           try {
/* 606 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 607 */             setOrigLocalDateTime((String)value);
/* 608 */           } catch (Exception ee) {
/* 609 */             throw new DtxException("An exception occurred while calling setOrigLocalDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigTransmissionDateTime":
/*     */           try {
/* 615 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 616 */             setOrigTransmissionDateTime((String)value);
/* 617 */           } catch (Exception ee) {
/* 618 */             throw new DtxException("An exception occurred while calling setOrigTransmissionDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigSTAN":
/*     */           try {
/* 624 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 625 */             setOrigSTAN((String)value);
/* 626 */           } catch (Exception ee) {
/* 627 */             throw new DtxException("An exception occurred while calling setOrigSTAN() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchantCategoryCode":
/*     */           try {
/* 633 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 634 */             setMerchantCategoryCode((String)value);
/* 635 */           } catch (Exception ee) {
/* 636 */             throw new DtxException("An exception occurred while calling setMerchantCategoryCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\VoucherSaleLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */