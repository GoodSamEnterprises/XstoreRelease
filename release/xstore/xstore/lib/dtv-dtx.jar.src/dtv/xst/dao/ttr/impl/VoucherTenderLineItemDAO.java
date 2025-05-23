/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ public class VoucherTenderLineItemDAO
/*     */   extends TenderLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -715118007L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VoucherTenderLineItemDAO.class);
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
/*  50 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  54 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  55 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  61 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  65 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  66 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  71 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  75 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  76 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  82 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  86 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  87 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActivityCode() {
/*  92 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/*  96 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/*  97 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAdjudicationCode() {
/* 102 */     return this._adjudicationCode;
/*     */   }
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 106 */     if (changed(argAdjudicationCode, this._adjudicationCode, "adjudicationCode")) {
/* 107 */       this._adjudicationCode = argAdjudicationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationCode() {
/* 112 */     return this._authorizationCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 116 */     if (changed(argAuthorizationCode, this._authorizationCode, "authorizationCode")) {
/* 117 */       this._authorizationCode = argAuthorizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 122 */     return this._authorizationMethodCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 126 */     if (changed(argAuthorizationMethodCode, this._authorizationMethodCode, "authorizationMethodCode")) {
/* 127 */       this._authorizationMethodCode = argAuthorizationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/* 132 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 136 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 137 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherTypeCode() {
/* 142 */     return this._voucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/* 146 */     if (changed(argVoucherTypeCode, this._voucherTypeCode, "voucherTypeCode")) {
/* 147 */       this._voucherTypeCode = argVoucherTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBankReferenceNumber() {
/* 152 */     return this._bankReferenceNumber;
/*     */   }
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 156 */     if (changed(argBankReferenceNumber, this._bankReferenceNumber, "bankReferenceNumber")) {
/* 157 */       this._bankReferenceNumber = argBankReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 162 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 166 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 167 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 173 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 177 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 178 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getFaceValueAmount() {
/* 184 */     return this._faceValueAmount;
/*     */   }
/*     */   
/*     */   public void setFaceValueAmount(BigDecimal argFaceValueAmount) {
/* 188 */     if (changed(argFaceValueAmount, this._faceValueAmount, "faceValueAmount")) {
/* 189 */       this._faceValueAmount = argFaceValueAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getIssueDatetimestamp() {
/* 194 */     return (Date)this._issueDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setIssueDatetimestamp(Date argIssueDatetimestamp) {
/* 198 */     if (changed(argIssueDatetimestamp, this._issueDatetimestamp, "issueDatetimestamp")) {
/* 199 */       this._issueDatetimestamp = (argIssueDatetimestamp == null || argIssueDatetimestamp instanceof DtvDate) ? (DtvDate)argIssueDatetimestamp : new DtvDate(argIssueDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIssueTypeCode() {
/* 205 */     return this._issueTypeCode;
/*     */   }
/*     */   
/*     */   public void setIssueTypeCode(String argIssueTypeCode) {
/* 209 */     if (changed(argIssueTypeCode, this._issueTypeCode, "issueTypeCode")) {
/* 210 */       this._issueTypeCode = argIssueTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnspentBalanceAmount() {
/* 215 */     return this._unspentBalanceAmount;
/*     */   }
/*     */   
/*     */   public void setUnspentBalanceAmount(BigDecimal argUnspentBalanceAmount) {
/* 219 */     if (changed(argUnspentBalanceAmount, this._unspentBalanceAmount, "unspentBalanceAmount")) {
/* 220 */       this._unspentBalanceAmount = argUnspentBalanceAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherStatusCode() {
/* 225 */     return this._voucherStatusCode;
/*     */   }
/*     */   
/*     */   public void setVoucherStatusCode(String argVoucherStatusCode) {
/* 229 */     if (changed(argVoucherStatusCode, this._voucherStatusCode, "voucherStatusCode")) {
/* 230 */       this._voucherStatusCode = argVoucherStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTraceNumber() {
/* 235 */     return this._traceNumber;
/*     */   }
/*     */   
/*     */   public void setTraceNumber(String argTraceNumber) {
/* 239 */     if (changed(argTraceNumber, this._traceNumber, "traceNumber")) {
/* 240 */       this._traceNumber = argTraceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigLocalDateTime() {
/* 245 */     return this._origLocalDateTime;
/*     */   }
/*     */   
/*     */   public void setOrigLocalDateTime(String argOrigLocalDateTime) {
/* 249 */     if (changed(argOrigLocalDateTime, this._origLocalDateTime, "origLocalDateTime")) {
/* 250 */       this._origLocalDateTime = argOrigLocalDateTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigTransmissionDateTime() {
/* 255 */     return this._origTransmissionDateTime;
/*     */   }
/*     */   
/*     */   public void setOrigTransmissionDateTime(String argOrigTransmissionDateTime) {
/* 259 */     if (changed(argOrigTransmissionDateTime, this._origTransmissionDateTime, "origTransmissionDateTime")) {
/* 260 */       this._origTransmissionDateTime = argOrigTransmissionDateTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigSTAN() {
/* 265 */     return this._origSTAN;
/*     */   }
/*     */   
/*     */   public void setOrigSTAN(String argOrigSTAN) {
/* 269 */     if (changed(argOrigSTAN, this._origSTAN, "origSTAN")) {
/* 270 */       this._origSTAN = argOrigSTAN;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchantCategoryCode() {
/* 275 */     return this._merchantCategoryCode;
/*     */   }
/*     */   
/*     */   public void setMerchantCategoryCode(String argMerchantCategoryCode) {
/* 279 */     if (changed(argMerchantCategoryCode, this._merchantCategoryCode, "merchantCategoryCode")) {
/* 280 */       this._merchantCategoryCode = argMerchantCategoryCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 287 */     StringBuilder buf = new StringBuilder(512);
/* 288 */     buf.append(super.toString());
/* 289 */     if (getCreateDate() != null) {
/* 290 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 292 */     if (getCreateUserId() != null) {
/* 293 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 295 */     if (getUpdateDate() != null) {
/* 296 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 298 */     if (getUpdateUserId() != null) {
/* 299 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 301 */     if (getActivityCode() != null) {
/* 302 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/* 304 */     if (getAdjudicationCode() != null) {
/* 305 */       buf.append("adjudicationCode").append("=").append(getAdjudicationCode()).append(" ");
/*     */     }
/* 307 */     if (getAuthorizationCode() != null) {
/* 308 */       buf.append("authorizationCode").append("=").append(getAuthorizationCode()).append(" ");
/*     */     }
/* 310 */     if (getAuthorizationMethodCode() != null) {
/* 311 */       buf.append("authorizationMethodCode").append("=").append(getAuthorizationMethodCode()).append(" ");
/*     */     }
/* 313 */     if (getEntryMethodCode() != null) {
/* 314 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 316 */     if (getVoucherTypeCode() != null) {
/* 317 */       buf.append("voucherTypeCode").append("=").append(getVoucherTypeCode()).append(" ");
/*     */     }
/* 319 */     if (getBankReferenceNumber() != null) {
/* 320 */       buf.append("bankReferenceNumber").append("=").append(getBankReferenceNumber()).append(" ");
/*     */     }
/* 322 */     if (getEffectiveDate() != null) {
/* 323 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 325 */     if (getExpirationDate() != null) {
/* 326 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 328 */     if (getFaceValueAmount() != null) {
/* 329 */       buf.append("faceValueAmount").append("=").append(getFaceValueAmount()).append(" ");
/*     */     }
/* 331 */     if (getIssueDatetimestamp() != null) {
/* 332 */       buf.append("issueDatetimestamp").append("=").append(getIssueDatetimestamp()).append(" ");
/*     */     }
/* 334 */     if (getIssueTypeCode() != null) {
/* 335 */       buf.append("issueTypeCode").append("=").append(getIssueTypeCode()).append(" ");
/*     */     }
/* 337 */     if (getUnspentBalanceAmount() != null) {
/* 338 */       buf.append("unspentBalanceAmount").append("=").append(getUnspentBalanceAmount()).append(" ");
/*     */     }
/* 340 */     if (getVoucherStatusCode() != null) {
/* 341 */       buf.append("voucherStatusCode").append("=").append(getVoucherStatusCode()).append(" ");
/*     */     }
/* 343 */     if (getTraceNumber() != null) {
/* 344 */       buf.append("traceNumber").append("=").append(getTraceNumber()).append(" ");
/*     */     }
/* 346 */     if (getOrigLocalDateTime() != null) {
/* 347 */       buf.append("origLocalDateTime").append("=").append(getOrigLocalDateTime()).append(" ");
/*     */     }
/* 349 */     if (getOrigTransmissionDateTime() != null) {
/* 350 */       buf.append("origTransmissionDateTime").append("=").append(getOrigTransmissionDateTime()).append(" ");
/*     */     }
/* 352 */     if (getOrigSTAN() != null) {
/* 353 */       buf.append("origSTAN").append("=").append(getOrigSTAN()).append(" ");
/*     */     }
/* 355 */     if (getMerchantCategoryCode() != null) {
/* 356 */       buf.append("merchantCategoryCode").append("=").append(getMerchantCategoryCode()).append(" ");
/*     */     }
/*     */     
/* 359 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 364 */     StringBuilder buf = new StringBuilder(2800);
/* 365 */     buf.append("<").append("dao").append(" name=\"VoucherTenderLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 366 */     getFieldsAsXml(buf);
/* 367 */     buf.append("</").append("dao").append(">");
/*     */     
/* 369 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 373 */     Map<String, String> values = super.getValues();
/* 374 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 375 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 376 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 377 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 378 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
/* 379 */     if (this._adjudicationCode != null) values.put("AdjudicationCode", DaoUtils.getXmlSafeFieldValue(12, this._adjudicationCode)); 
/* 380 */     if (this._authorizationCode != null) values.put("AuthorizationCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationCode)); 
/* 381 */     if (this._authorizationMethodCode != null) values.put("AuthorizationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationMethodCode)); 
/* 382 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 383 */     if (this._voucherTypeCode != null) values.put("VoucherTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherTypeCode)); 
/* 384 */     if (this._bankReferenceNumber != null) values.put("BankReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._bankReferenceNumber)); 
/* 385 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 386 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 387 */     if (this._faceValueAmount != null) values.put("FaceValueAmount", DaoUtils.getXmlSafeFieldValue(3, this._faceValueAmount)); 
/* 388 */     if (this._issueDatetimestamp != null) values.put("IssueDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._issueDatetimestamp)); 
/* 389 */     if (this._issueTypeCode != null) values.put("IssueTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._issueTypeCode)); 
/* 390 */     if (this._unspentBalanceAmount != null) values.put("UnspentBalanceAmount", DaoUtils.getXmlSafeFieldValue(3, this._unspentBalanceAmount)); 
/* 391 */     if (this._voucherStatusCode != null) values.put("VoucherStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherStatusCode)); 
/* 392 */     if (this._traceNumber != null) values.put("TraceNumber", DaoUtils.getXmlSafeFieldValue(12, this._traceNumber)); 
/* 393 */     if (this._origLocalDateTime != null) values.put("OrigLocalDateTime", DaoUtils.getXmlSafeFieldValue(12, this._origLocalDateTime)); 
/* 394 */     if (this._origTransmissionDateTime != null) values.put("OrigTransmissionDateTime", DaoUtils.getXmlSafeFieldValue(12, this._origTransmissionDateTime)); 
/* 395 */     if (this._origSTAN != null) values.put("OrigSTAN", DaoUtils.getXmlSafeFieldValue(12, this._origSTAN)); 
/* 396 */     if (this._merchantCategoryCode != null) values.put("MerchantCategoryCode", DaoUtils.getXmlSafeFieldValue(12, this._merchantCategoryCode)); 
/* 397 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 402 */     super.setValues(argValues);
/* 403 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 405 */       String fieldName = field.getKey();
/* 406 */       String fieldValue = field.getValue();
/* 407 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 412 */             setCreateDate((Date)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 421 */             setCreateUserId((String)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 430 */             setUpdateDate((Date)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 439 */             setUpdateUserId((String)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 447 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 448 */             setActivityCode((String)value);
/* 449 */           } catch (Exception ee) {
/* 450 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjudicationCode":
/*     */           try {
/* 456 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 457 */             setAdjudicationCode((String)value);
/* 458 */           } catch (Exception ee) {
/* 459 */             throw new DtxException("An exception occurred while calling setAdjudicationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationCode":
/*     */           try {
/* 465 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 466 */             setAuthorizationCode((String)value);
/* 467 */           } catch (Exception ee) {
/* 468 */             throw new DtxException("An exception occurred while calling setAuthorizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationMethodCode":
/*     */           try {
/* 474 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 475 */             setAuthorizationMethodCode((String)value);
/* 476 */           } catch (Exception ee) {
/* 477 */             throw new DtxException("An exception occurred while calling setAuthorizationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 483 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 484 */             setEntryMethodCode((String)value);
/* 485 */           } catch (Exception ee) {
/* 486 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherTypeCode":
/*     */           try {
/* 492 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 493 */             setVoucherTypeCode((String)value);
/* 494 */           } catch (Exception ee) {
/* 495 */             throw new DtxException("An exception occurred while calling setVoucherTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BankReferenceNumber":
/*     */           try {
/* 501 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 502 */             setBankReferenceNumber((String)value);
/* 503 */           } catch (Exception ee) {
/* 504 */             throw new DtxException("An exception occurred while calling setBankReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 510 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 511 */             setEffectiveDate((Date)value);
/* 512 */           } catch (Exception ee) {
/* 513 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 519 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 520 */             setExpirationDate((Date)value);
/* 521 */           } catch (Exception ee) {
/* 522 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FaceValueAmount":
/*     */           try {
/* 528 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 529 */             setFaceValueAmount((BigDecimal)value);
/* 530 */           } catch (Exception ee) {
/* 531 */             throw new DtxException("An exception occurred while calling setFaceValueAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueDatetimestamp":
/*     */           try {
/* 537 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 538 */             setIssueDatetimestamp((Date)value);
/* 539 */           } catch (Exception ee) {
/* 540 */             throw new DtxException("An exception occurred while calling setIssueDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueTypeCode":
/*     */           try {
/* 546 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 547 */             setIssueTypeCode((String)value);
/* 548 */           } catch (Exception ee) {
/* 549 */             throw new DtxException("An exception occurred while calling setIssueTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnspentBalanceAmount":
/*     */           try {
/* 555 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 556 */             setUnspentBalanceAmount((BigDecimal)value);
/* 557 */           } catch (Exception ee) {
/* 558 */             throw new DtxException("An exception occurred while calling setUnspentBalanceAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherStatusCode":
/*     */           try {
/* 564 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 565 */             setVoucherStatusCode((String)value);
/* 566 */           } catch (Exception ee) {
/* 567 */             throw new DtxException("An exception occurred while calling setVoucherStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TraceNumber":
/*     */           try {
/* 573 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 574 */             setTraceNumber((String)value);
/* 575 */           } catch (Exception ee) {
/* 576 */             throw new DtxException("An exception occurred while calling setTraceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigLocalDateTime":
/*     */           try {
/* 582 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 583 */             setOrigLocalDateTime((String)value);
/* 584 */           } catch (Exception ee) {
/* 585 */             throw new DtxException("An exception occurred while calling setOrigLocalDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigTransmissionDateTime":
/*     */           try {
/* 591 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 592 */             setOrigTransmissionDateTime((String)value);
/* 593 */           } catch (Exception ee) {
/* 594 */             throw new DtxException("An exception occurred while calling setOrigTransmissionDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigSTAN":
/*     */           try {
/* 600 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 601 */             setOrigSTAN((String)value);
/* 602 */           } catch (Exception ee) {
/* 603 */             throw new DtxException("An exception occurred while calling setOrigSTAN() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchantCategoryCode":
/*     */           try {
/* 609 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 610 */             setMerchantCategoryCode((String)value);
/* 611 */           } catch (Exception ee) {
/* 612 */             throw new DtxException("An exception occurred while calling setMerchantCategoryCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherTenderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */