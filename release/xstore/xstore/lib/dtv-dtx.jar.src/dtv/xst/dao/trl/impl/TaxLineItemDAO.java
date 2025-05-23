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
/*     */ public class TaxLineItemDAO
/*     */   extends RetailTransactionLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = 899773906L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TaxLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _taxPercentage;
/*     */   private BigDecimal _rawTaxAmount;
/*     */   private BigDecimal _rawTaxPercentage;
/*     */   private BigDecimal _taxOverrideAmount;
/*  34 */   private Boolean _taxOverride = Boolean.FALSE;
/*     */   private BigDecimal _taxOverridePercentage;
/*     */   private String _taxOverrideReasonCode;
/*     */   private BigDecimal _taxableAmount;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRuleSequence;
/*     */   private String _authorityId;
/*     */   private String _authorityName;
/*     */   private String _authorityTypeCode;
/*     */   
/*     */   public Date getCreateDate() {
/*  46 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  50 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  51 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  57 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  61 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  62 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  67 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  71 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  72 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  78 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  82 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  83 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/*  88 */     return this._taxAmount;
/*     */   }
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/*  92 */     if (changed(argTaxAmount, this._taxAmount, "taxAmount")) {
/*  93 */       this._taxAmount = argTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxPercentage() {
/*  98 */     return this._taxPercentage;
/*     */   }
/*     */   
/*     */   public void setTaxPercentage(BigDecimal argTaxPercentage) {
/* 102 */     if (changed(argTaxPercentage, this._taxPercentage, "taxPercentage")) {
/* 103 */       this._taxPercentage = argTaxPercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getRawTaxAmount() {
/* 108 */     return this._rawTaxAmount;
/*     */   }
/*     */   
/*     */   public void setRawTaxAmount(BigDecimal argRawTaxAmount) {
/* 112 */     if (changed(argRawTaxAmount, this._rawTaxAmount, "rawTaxAmount")) {
/* 113 */       this._rawTaxAmount = argRawTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getRawTaxPercentage() {
/* 118 */     return this._rawTaxPercentage;
/*     */   }
/*     */   
/*     */   public void setRawTaxPercentage(BigDecimal argRawTaxPercentage) {
/* 122 */     if (changed(argRawTaxPercentage, this._rawTaxPercentage, "rawTaxPercentage")) {
/* 123 */       this._rawTaxPercentage = argRawTaxPercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxOverrideAmount() {
/* 128 */     return this._taxOverrideAmount;
/*     */   }
/*     */   
/*     */   public void setTaxOverrideAmount(BigDecimal argTaxOverrideAmount) {
/* 132 */     if (changed(argTaxOverrideAmount, this._taxOverrideAmount, "taxOverrideAmount")) {
/* 133 */       this._taxOverrideAmount = argTaxOverrideAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getTaxOverride() {
/* 138 */     return this._taxOverride;
/*     */   }
/*     */   
/*     */   public void setTaxOverride(Boolean argTaxOverride) {
/* 142 */     if (changed(argTaxOverride, this._taxOverride, "taxOverride")) {
/* 143 */       this._taxOverride = argTaxOverride;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxOverridePercentage() {
/* 148 */     return this._taxOverridePercentage;
/*     */   }
/*     */   
/*     */   public void setTaxOverridePercentage(BigDecimal argTaxOverridePercentage) {
/* 152 */     if (changed(argTaxOverridePercentage, this._taxOverridePercentage, "taxOverridePercentage")) {
/* 153 */       this._taxOverridePercentage = argTaxOverridePercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxOverrideReasonCode() {
/* 158 */     return this._taxOverrideReasonCode;
/*     */   }
/*     */   
/*     */   public void setTaxOverrideReasonCode(String argTaxOverrideReasonCode) {
/* 162 */     if (changed(argTaxOverrideReasonCode, this._taxOverrideReasonCode, "taxOverrideReasonCode")) {
/* 163 */       this._taxOverrideReasonCode = argTaxOverrideReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxableAmount() {
/* 168 */     return this._taxableAmount;
/*     */   }
/*     */   
/*     */   public void setTaxableAmount(BigDecimal argTaxableAmount) {
/* 172 */     if (changed(argTaxableAmount, this._taxableAmount, "taxableAmount")) {
/* 173 */       this._taxableAmount = argTaxableAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/* 178 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/* 182 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/* 183 */       this._taxGroupId = argTaxGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/* 188 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/* 192 */     if (changed(argTaxLocationId, this._taxLocationId, "taxLocationId")) {
/* 193 */       this._taxLocationId = argTaxLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/* 198 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/* 202 */     if (changed(argTaxRuleSequence, this._taxRuleSequence, "taxRuleSequence")) {
/* 203 */       this._taxRuleSequence = argTaxRuleSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorityId() {
/* 208 */     return this._authorityId;
/*     */   }
/*     */   
/*     */   public void setAuthorityId(String argAuthorityId) {
/* 212 */     if (changed(argAuthorityId, this._authorityId, "authorityId")) {
/* 213 */       this._authorityId = argAuthorityId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorityName() {
/* 218 */     return this._authorityName;
/*     */   }
/*     */   
/*     */   public void setAuthorityName(String argAuthorityName) {
/* 222 */     if (changed(argAuthorityName, this._authorityName, "authorityName")) {
/* 223 */       this._authorityName = argAuthorityName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorityTypeCode() {
/* 228 */     return this._authorityTypeCode;
/*     */   }
/*     */   
/*     */   public void setAuthorityTypeCode(String argAuthorityTypeCode) {
/* 232 */     if (changed(argAuthorityTypeCode, this._authorityTypeCode, "authorityTypeCode")) {
/* 233 */       this._authorityTypeCode = argAuthorityTypeCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 240 */     StringBuilder buf = new StringBuilder(512);
/* 241 */     buf.append(super.toString());
/* 242 */     if (getCreateDate() != null) {
/* 243 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 245 */     if (getCreateUserId() != null) {
/* 246 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 248 */     if (getUpdateDate() != null) {
/* 249 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 251 */     if (getUpdateUserId() != null) {
/* 252 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 254 */     if (getTaxAmount() != null) {
/* 255 */       buf.append("taxAmount").append("=").append(getTaxAmount()).append(" ");
/*     */     }
/* 257 */     if (getTaxPercentage() != null) {
/* 258 */       buf.append("taxPercentage").append("=").append(getTaxPercentage()).append(" ");
/*     */     }
/* 260 */     if (getRawTaxAmount() != null) {
/* 261 */       buf.append("rawTaxAmount").append("=").append(getRawTaxAmount()).append(" ");
/*     */     }
/* 263 */     if (getRawTaxPercentage() != null) {
/* 264 */       buf.append("rawTaxPercentage").append("=").append(getRawTaxPercentage()).append(" ");
/*     */     }
/* 266 */     if (getTaxOverrideAmount() != null) {
/* 267 */       buf.append("taxOverrideAmount").append("=").append(getTaxOverrideAmount()).append(" ");
/*     */     }
/* 269 */     if (getTaxOverride() != null && getTaxOverride().booleanValue()) {
/* 270 */       buf.append("taxOverride").append("=").append(getTaxOverride()).append(" ");
/*     */     }
/* 272 */     if (getTaxOverridePercentage() != null) {
/* 273 */       buf.append("taxOverridePercentage").append("=").append(getTaxOverridePercentage()).append(" ");
/*     */     }
/* 275 */     if (getTaxOverrideReasonCode() != null) {
/* 276 */       buf.append("taxOverrideReasonCode").append("=").append(getTaxOverrideReasonCode()).append(" ");
/*     */     }
/* 278 */     if (getTaxableAmount() != null) {
/* 279 */       buf.append("taxableAmount").append("=").append(getTaxableAmount()).append(" ");
/*     */     }
/* 281 */     if (getTaxGroupId() != null) {
/* 282 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*     */     }
/* 284 */     if (getTaxLocationId() != null) {
/* 285 */       buf.append("taxLocationId").append("=").append(getTaxLocationId()).append(" ");
/*     */     }
/* 287 */     if (getTaxRuleSequence() != null) {
/* 288 */       buf.append("taxRuleSequence").append("=").append(getTaxRuleSequence()).append(" ");
/*     */     }
/* 290 */     if (getAuthorityId() != null) {
/* 291 */       buf.append("authorityId").append("=").append(getAuthorityId()).append(" ");
/*     */     }
/* 293 */     if (getAuthorityName() != null) {
/* 294 */       buf.append("authorityName").append("=").append(getAuthorityName()).append(" ");
/*     */     }
/* 296 */     if (getAuthorityTypeCode() != null) {
/* 297 */       buf.append("authorityTypeCode").append("=").append(getAuthorityTypeCode()).append(" ");
/*     */     }
/*     */     
/* 300 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 305 */     StringBuilder buf = new StringBuilder(2000);
/* 306 */     buf.append("<").append("dao").append(" name=\"TaxLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 307 */     getFieldsAsXml(buf);
/* 308 */     buf.append("</").append("dao").append(">");
/*     */     
/* 310 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 314 */     Map<String, String> values = super.getValues();
/* 315 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 316 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 317 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 318 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 319 */     if (this._taxAmount != null) values.put("TaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxAmount)); 
/* 320 */     if (this._taxPercentage != null) values.put("TaxPercentage", DaoUtils.getXmlSafeFieldValue(3, this._taxPercentage)); 
/* 321 */     if (this._rawTaxAmount != null) values.put("RawTaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._rawTaxAmount)); 
/* 322 */     if (this._rawTaxPercentage != null) values.put("RawTaxPercentage", DaoUtils.getXmlSafeFieldValue(3, this._rawTaxPercentage)); 
/* 323 */     if (this._taxOverrideAmount != null) values.put("TaxOverrideAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxOverrideAmount)); 
/* 324 */     if (this._taxOverride != null) values.put("TaxOverride", DaoUtils.getXmlSafeFieldValue(-7, this._taxOverride)); 
/* 325 */     if (this._taxOverridePercentage != null) values.put("TaxOverridePercentage", DaoUtils.getXmlSafeFieldValue(3, this._taxOverridePercentage)); 
/* 326 */     if (this._taxOverrideReasonCode != null) values.put("TaxOverrideReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._taxOverrideReasonCode)); 
/* 327 */     if (this._taxableAmount != null) values.put("TaxableAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxableAmount)); 
/* 328 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/* 329 */     if (this._taxLocationId != null) values.put("TaxLocationId", DaoUtils.getXmlSafeFieldValue(12, this._taxLocationId)); 
/* 330 */     if (this._taxRuleSequence != null) values.put("TaxRuleSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxRuleSequence)); 
/* 331 */     if (this._authorityId != null) values.put("AuthorityId", DaoUtils.getXmlSafeFieldValue(12, this._authorityId)); 
/* 332 */     if (this._authorityName != null) values.put("AuthorityName", DaoUtils.getXmlSafeFieldValue(12, this._authorityName)); 
/* 333 */     if (this._authorityTypeCode != null) values.put("AuthorityTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._authorityTypeCode)); 
/* 334 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 339 */     super.setValues(argValues);
/* 340 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 342 */       String fieldName = field.getKey();
/* 343 */       String fieldValue = field.getValue();
/* 344 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 349 */             setCreateDate((Date)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 358 */             setCreateUserId((String)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 367 */             setUpdateDate((Date)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setUpdateUserId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAmount":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 385 */             setTaxAmount((BigDecimal)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxPercentage":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 394 */             setTaxPercentage((BigDecimal)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setTaxPercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RawTaxAmount":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 403 */             setRawTaxAmount((BigDecimal)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setRawTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RawTaxPercentage":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 412 */             setRawTaxPercentage((BigDecimal)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setRawTaxPercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverrideAmount":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 421 */             setTaxOverrideAmount((BigDecimal)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setTaxOverrideAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverride":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 430 */             setTaxOverride((Boolean)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setTaxOverride() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverridePercentage":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 439 */             setTaxOverridePercentage((BigDecimal)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setTaxOverridePercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverrideReasonCode":
/*     */           try {
/* 447 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 448 */             setTaxOverrideReasonCode((String)value);
/* 449 */           } catch (Exception ee) {
/* 450 */             throw new DtxException("An exception occurred while calling setTaxOverrideReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxableAmount":
/*     */           try {
/* 456 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 457 */             setTaxableAmount((BigDecimal)value);
/* 458 */           } catch (Exception ee) {
/* 459 */             throw new DtxException("An exception occurred while calling setTaxableAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxGroupId":
/*     */           try {
/* 465 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 466 */             setTaxGroupId((String)value);
/* 467 */           } catch (Exception ee) {
/* 468 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxLocationId":
/*     */           try {
/* 474 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 475 */             setTaxLocationId((String)value);
/* 476 */           } catch (Exception ee) {
/* 477 */             throw new DtxException("An exception occurred while calling setTaxLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRuleSequence":
/*     */           try {
/* 483 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 484 */             setTaxRuleSequence((Integer)value);
/* 485 */           } catch (Exception ee) {
/* 486 */             throw new DtxException("An exception occurred while calling setTaxRuleSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorityId":
/*     */           try {
/* 492 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 493 */             setAuthorityId((String)value);
/* 494 */           } catch (Exception ee) {
/* 495 */             throw new DtxException("An exception occurred while calling setAuthorityId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorityName":
/*     */           try {
/* 501 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 502 */             setAuthorityName((String)value);
/* 503 */           } catch (Exception ee) {
/* 504 */             throw new DtxException("An exception occurred while calling setAuthorityName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorityTypeCode":
/*     */           try {
/* 510 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 511 */             setAuthorityTypeCode((String)value);
/* 512 */           } catch (Exception ee) {
/* 513 */             throw new DtxException("An exception occurred while calling setAuthorityTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\TaxLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */