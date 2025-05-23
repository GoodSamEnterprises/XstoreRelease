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
/*     */ public class VoucherDiscountLineItemDAO
/*     */   extends DiscountLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -379249610L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VoucherDiscountLineItemDAO.class);
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
/*     */   
/*     */   public Date getCreateDate() {
/*  47 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  51 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  52 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  58 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  62 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  63 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  68 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  72 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  73 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  79 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  83 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  84 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActivityCode() {
/*  89 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/*  93 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/*  94 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAdjudicationCode() {
/*  99 */     return this._adjudicationCode;
/*     */   }
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 103 */     if (changed(argAdjudicationCode, this._adjudicationCode, "adjudicationCode")) {
/* 104 */       this._adjudicationCode = argAdjudicationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationCode() {
/* 109 */     return this._authorizationCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 113 */     if (changed(argAuthorizationCode, this._authorizationCode, "authorizationCode")) {
/* 114 */       this._authorizationCode = argAuthorizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 119 */     return this._authorizationMethodCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 123 */     if (changed(argAuthorizationMethodCode, this._authorizationMethodCode, "authorizationMethodCode")) {
/* 124 */       this._authorizationMethodCode = argAuthorizationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/* 129 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 133 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 134 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 139 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 143 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 144 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherTypeCode() {
/* 149 */     return this._voucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/* 153 */     if (changed(argVoucherTypeCode, this._voucherTypeCode, "voucherTypeCode")) {
/* 154 */       this._voucherTypeCode = argVoucherTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBankReferenceNumber() {
/* 159 */     return this._bankReferenceNumber;
/*     */   }
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 163 */     if (changed(argBankReferenceNumber, this._bankReferenceNumber, "bankReferenceNumber")) {
/* 164 */       this._bankReferenceNumber = argBankReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 169 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 173 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 174 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 180 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 184 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 185 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getFaceValueAmount() {
/* 191 */     return this._faceValueAmount;
/*     */   }
/*     */   
/*     */   public void setFaceValueAmount(BigDecimal argFaceValueAmount) {
/* 195 */     if (changed(argFaceValueAmount, this._faceValueAmount, "faceValueAmount")) {
/* 196 */       this._faceValueAmount = argFaceValueAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getIssueDatetimestamp() {
/* 201 */     return (Date)this._issueDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setIssueDatetimestamp(Date argIssueDatetimestamp) {
/* 205 */     if (changed(argIssueDatetimestamp, this._issueDatetimestamp, "issueDatetimestamp")) {
/* 206 */       this._issueDatetimestamp = (argIssueDatetimestamp == null || argIssueDatetimestamp instanceof DtvDate) ? (DtvDate)argIssueDatetimestamp : new DtvDate(argIssueDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIssueTypeCode() {
/* 212 */     return this._issueTypeCode;
/*     */   }
/*     */   
/*     */   public void setIssueTypeCode(String argIssueTypeCode) {
/* 216 */     if (changed(argIssueTypeCode, this._issueTypeCode, "issueTypeCode")) {
/* 217 */       this._issueTypeCode = argIssueTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnspentBalanceAmount() {
/* 222 */     return this._unspentBalanceAmount;
/*     */   }
/*     */   
/*     */   public void setUnspentBalanceAmount(BigDecimal argUnspentBalanceAmount) {
/* 226 */     if (changed(argUnspentBalanceAmount, this._unspentBalanceAmount, "unspentBalanceAmount")) {
/* 227 */       this._unspentBalanceAmount = argUnspentBalanceAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherStatusCode() {
/* 232 */     return this._voucherStatusCode;
/*     */   }
/*     */   
/*     */   public void setVoucherStatusCode(String argVoucherStatusCode) {
/* 236 */     if (changed(argVoucherStatusCode, this._voucherStatusCode, "voucherStatusCode")) {
/* 237 */       this._voucherStatusCode = argVoucherStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTraceNumber() {
/* 242 */     return this._traceNumber;
/*     */   }
/*     */   
/*     */   public void setTraceNumber(String argTraceNumber) {
/* 246 */     if (changed(argTraceNumber, this._traceNumber, "traceNumber")) {
/* 247 */       this._traceNumber = argTraceNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 254 */     StringBuilder buf = new StringBuilder(512);
/* 255 */     buf.append(super.toString());
/* 256 */     if (getCreateDate() != null) {
/* 257 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 259 */     if (getCreateUserId() != null) {
/* 260 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 262 */     if (getUpdateDate() != null) {
/* 263 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 265 */     if (getUpdateUserId() != null) {
/* 266 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 268 */     if (getActivityCode() != null) {
/* 269 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/* 271 */     if (getAdjudicationCode() != null) {
/* 272 */       buf.append("adjudicationCode").append("=").append(getAdjudicationCode()).append(" ");
/*     */     }
/* 274 */     if (getAuthorizationCode() != null) {
/* 275 */       buf.append("authorizationCode").append("=").append(getAuthorizationCode()).append(" ");
/*     */     }
/* 277 */     if (getAuthorizationMethodCode() != null) {
/* 278 */       buf.append("authorizationMethodCode").append("=").append(getAuthorizationMethodCode()).append(" ");
/*     */     }
/* 280 */     if (getEntryMethodCode() != null) {
/* 281 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 283 */     if (getSerialNumber() != null) {
/* 284 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 286 */     if (getVoucherTypeCode() != null) {
/* 287 */       buf.append("voucherTypeCode").append("=").append(getVoucherTypeCode()).append(" ");
/*     */     }
/* 289 */     if (getBankReferenceNumber() != null) {
/* 290 */       buf.append("bankReferenceNumber").append("=").append(getBankReferenceNumber()).append(" ");
/*     */     }
/* 292 */     if (getEffectiveDate() != null) {
/* 293 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 295 */     if (getExpirationDate() != null) {
/* 296 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 298 */     if (getFaceValueAmount() != null) {
/* 299 */       buf.append("faceValueAmount").append("=").append(getFaceValueAmount()).append(" ");
/*     */     }
/* 301 */     if (getIssueDatetimestamp() != null) {
/* 302 */       buf.append("issueDatetimestamp").append("=").append(getIssueDatetimestamp()).append(" ");
/*     */     }
/* 304 */     if (getIssueTypeCode() != null) {
/* 305 */       buf.append("issueTypeCode").append("=").append(getIssueTypeCode()).append(" ");
/*     */     }
/* 307 */     if (getUnspentBalanceAmount() != null) {
/* 308 */       buf.append("unspentBalanceAmount").append("=").append(getUnspentBalanceAmount()).append(" ");
/*     */     }
/* 310 */     if (getVoucherStatusCode() != null) {
/* 311 */       buf.append("voucherStatusCode").append("=").append(getVoucherStatusCode()).append(" ");
/*     */     }
/* 313 */     if (getTraceNumber() != null) {
/* 314 */       buf.append("traceNumber").append("=").append(getTraceNumber()).append(" ");
/*     */     }
/*     */     
/* 317 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 322 */     StringBuilder buf = new StringBuilder(2650);
/* 323 */     buf.append("<").append("dao").append(" name=\"VoucherDiscountLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 324 */     getFieldsAsXml(buf);
/* 325 */     buf.append("</").append("dao").append(">");
/*     */     
/* 327 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 331 */     Map<String, String> values = super.getValues();
/* 332 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 333 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 334 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 335 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 336 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
/* 337 */     if (this._adjudicationCode != null) values.put("AdjudicationCode", DaoUtils.getXmlSafeFieldValue(12, this._adjudicationCode)); 
/* 338 */     if (this._authorizationCode != null) values.put("AuthorizationCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationCode)); 
/* 339 */     if (this._authorizationMethodCode != null) values.put("AuthorizationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationMethodCode)); 
/* 340 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 341 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 342 */     if (this._voucherTypeCode != null) values.put("VoucherTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherTypeCode)); 
/* 343 */     if (this._bankReferenceNumber != null) values.put("BankReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._bankReferenceNumber)); 
/* 344 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 345 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 346 */     if (this._faceValueAmount != null) values.put("FaceValueAmount", DaoUtils.getXmlSafeFieldValue(3, this._faceValueAmount)); 
/* 347 */     if (this._issueDatetimestamp != null) values.put("IssueDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._issueDatetimestamp)); 
/* 348 */     if (this._issueTypeCode != null) values.put("IssueTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._issueTypeCode)); 
/* 349 */     if (this._unspentBalanceAmount != null) values.put("UnspentBalanceAmount", DaoUtils.getXmlSafeFieldValue(3, this._unspentBalanceAmount)); 
/* 350 */     if (this._voucherStatusCode != null) values.put("VoucherStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherStatusCode)); 
/* 351 */     if (this._traceNumber != null) values.put("TraceNumber", DaoUtils.getXmlSafeFieldValue(12, this._traceNumber)); 
/* 352 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 357 */     super.setValues(argValues);
/* 358 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 360 */       String fieldName = field.getKey();
/* 361 */       String fieldValue = field.getValue();
/* 362 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 367 */             setCreateDate((Date)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setCreateUserId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 385 */             setUpdateDate((Date)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 394 */             setUpdateUserId((String)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 403 */             setActivityCode((String)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjudicationCode":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 412 */             setAdjudicationCode((String)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setAdjudicationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationCode":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 421 */             setAuthorizationCode((String)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setAuthorizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationMethodCode":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 430 */             setAuthorizationMethodCode((String)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setAuthorizationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 439 */             setEntryMethodCode((String)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 447 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 448 */             setSerialNumber((String)value);
/* 449 */           } catch (Exception ee) {
/* 450 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherTypeCode":
/*     */           try {
/* 456 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 457 */             setVoucherTypeCode((String)value);
/* 458 */           } catch (Exception ee) {
/* 459 */             throw new DtxException("An exception occurred while calling setVoucherTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BankReferenceNumber":
/*     */           try {
/* 465 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 466 */             setBankReferenceNumber((String)value);
/* 467 */           } catch (Exception ee) {
/* 468 */             throw new DtxException("An exception occurred while calling setBankReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 474 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 475 */             setEffectiveDate((Date)value);
/* 476 */           } catch (Exception ee) {
/* 477 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 483 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 484 */             setExpirationDate((Date)value);
/* 485 */           } catch (Exception ee) {
/* 486 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FaceValueAmount":
/*     */           try {
/* 492 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 493 */             setFaceValueAmount((BigDecimal)value);
/* 494 */           } catch (Exception ee) {
/* 495 */             throw new DtxException("An exception occurred while calling setFaceValueAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueDatetimestamp":
/*     */           try {
/* 501 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 502 */             setIssueDatetimestamp((Date)value);
/* 503 */           } catch (Exception ee) {
/* 504 */             throw new DtxException("An exception occurred while calling setIssueDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueTypeCode":
/*     */           try {
/* 510 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 511 */             setIssueTypeCode((String)value);
/* 512 */           } catch (Exception ee) {
/* 513 */             throw new DtxException("An exception occurred while calling setIssueTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnspentBalanceAmount":
/*     */           try {
/* 519 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 520 */             setUnspentBalanceAmount((BigDecimal)value);
/* 521 */           } catch (Exception ee) {
/* 522 */             throw new DtxException("An exception occurred while calling setUnspentBalanceAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherStatusCode":
/*     */           try {
/* 528 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 529 */             setVoucherStatusCode((String)value);
/* 530 */           } catch (Exception ee) {
/* 531 */             throw new DtxException("An exception occurred while calling setVoucherStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TraceNumber":
/*     */           try {
/* 537 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 538 */             setTraceNumber((String)value);
/* 539 */           } catch (Exception ee) {
/* 540 */             throw new DtxException("An exception occurred while calling setTraceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\VoucherDiscountLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */