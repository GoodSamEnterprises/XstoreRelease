/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxRateRuleOverrideId;
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
/*     */ public class TaxRateRuleOverrideDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1162493549L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TaxRateRuleOverrideDAO.class);
/*     */   
/*     */   private DtvDate _expirationDatetimestamp;
/*     */   private Long _organizationId;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRateRuleSequence;
/*     */   private Integer _taxRuleSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _amount;
/*     */   private String _breakPointTypeCode;
/*     */   private DtvDate _dailyEndTimeDao;
/*     */   private DtvDate _dailyStartTimeDao;
/*     */   private DtvDate _effectiveDatetimestamp;
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _taxRateMaxTaxableAmount;
/*     */   private BigDecimal _taxRateMinTaxableAmount;
/*     */   private String _taxBracketId;
/*     */   
/*     */   public Date getExpirationDatetimestamp() {
/*  48 */     return (Date)this._expirationDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setExpirationDatetimestamp(Date argExpirationDatetimestamp) {
/*  52 */     if (changed(argExpirationDatetimestamp, this._expirationDatetimestamp, "expirationDatetimestamp")) {
/*  53 */       this._expirationDatetimestamp = (argExpirationDatetimestamp == null || argExpirationDatetimestamp instanceof DtvDate) ? (DtvDate)argExpirationDatetimestamp : new DtvDate(argExpirationDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  59 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  63 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  64 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/*  69 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  73 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/*  74 */       this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  79 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  83 */     if (changed(argTaxLocationId, this._taxLocationId, "taxLocationId")) {
/*  84 */       this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxRateRuleSequence() {
/*  89 */     return this._taxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRateRuleSequence(Integer argTaxRateRuleSequence) {
/*  93 */     if (changed(argTaxRateRuleSequence, this._taxRateRuleSequence, "taxRateRuleSequence")) {
/*  94 */       this._taxRateRuleSequence = argTaxRateRuleSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/*  99 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/* 103 */     if (changed(argTaxRuleSequence, this._taxRuleSequence, "taxRuleSequence")) {
/* 104 */       this._taxRuleSequence = argTaxRuleSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 109 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 113 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 114 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 120 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 124 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 125 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 130 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 134 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 135 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 141 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 145 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 146 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 151 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 155 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 156 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 161 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 165 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 166 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 171 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 175 */     if (changed(argAmount, this._amount, "amount")) {
/* 176 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBreakPointTypeCode() {
/* 181 */     return this._breakPointTypeCode;
/*     */   }
/*     */   
/*     */   public void setBreakPointTypeCode(String argBreakPointTypeCode) {
/* 185 */     if (changed(argBreakPointTypeCode, this._breakPointTypeCode, "breakPointTypeCode")) {
/* 186 */       this._breakPointTypeCode = argBreakPointTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDailyEndTimeDao() {
/* 191 */     return (Date)this._dailyEndTimeDao;
/*     */   }
/*     */   
/*     */   public void setDailyEndTimeDao(Date argDailyEndTimeDao) {
/* 195 */     if (changed(argDailyEndTimeDao, this._dailyEndTimeDao, "dailyEndTimeDao")) {
/* 196 */       this._dailyEndTimeDao = (argDailyEndTimeDao == null || argDailyEndTimeDao instanceof DtvDate) ? (DtvDate)argDailyEndTimeDao : new DtvDate(argDailyEndTimeDao);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDailyStartTimeDao() {
/* 202 */     return (Date)this._dailyStartTimeDao;
/*     */   }
/*     */   
/*     */   public void setDailyStartTimeDao(Date argDailyStartTimeDao) {
/* 206 */     if (changed(argDailyStartTimeDao, this._dailyStartTimeDao, "dailyStartTimeDao")) {
/* 207 */       this._dailyStartTimeDao = (argDailyStartTimeDao == null || argDailyStartTimeDao instanceof DtvDate) ? (DtvDate)argDailyStartTimeDao : new DtvDate(argDailyStartTimeDao);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEffectiveDatetimestamp() {
/* 213 */     return (Date)this._effectiveDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setEffectiveDatetimestamp(Date argEffectiveDatetimestamp) {
/* 217 */     if (changed(argEffectiveDatetimestamp, this._effectiveDatetimestamp, "effectiveDatetimestamp")) {
/* 218 */       this._effectiveDatetimestamp = (argEffectiveDatetimestamp == null || argEffectiveDatetimestamp instanceof DtvDate) ? (DtvDate)argEffectiveDatetimestamp : new DtvDate(argEffectiveDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getPercent() {
/* 224 */     return this._percent;
/*     */   }
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/* 228 */     if (changed(argPercent, this._percent, "percent")) {
/* 229 */       this._percent = argPercent;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxRateMaxTaxableAmount() {
/* 234 */     return this._taxRateMaxTaxableAmount;
/*     */   }
/*     */   
/*     */   public void setTaxRateMaxTaxableAmount(BigDecimal argTaxRateMaxTaxableAmount) {
/* 238 */     if (changed(argTaxRateMaxTaxableAmount, this._taxRateMaxTaxableAmount, "taxRateMaxTaxableAmount")) {
/* 239 */       this._taxRateMaxTaxableAmount = argTaxRateMaxTaxableAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxRateMinTaxableAmount() {
/* 244 */     return this._taxRateMinTaxableAmount;
/*     */   }
/*     */   
/*     */   public void setTaxRateMinTaxableAmount(BigDecimal argTaxRateMinTaxableAmount) {
/* 248 */     if (changed(argTaxRateMinTaxableAmount, this._taxRateMinTaxableAmount, "taxRateMinTaxableAmount")) {
/* 249 */       this._taxRateMinTaxableAmount = argTaxRateMinTaxableAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxBracketId() {
/* 254 */     return this._taxBracketId;
/*     */   }
/*     */   
/*     */   public void setTaxBracketId(String argTaxBracketId) {
/* 258 */     if (changed(argTaxBracketId, this._taxBracketId, "taxBracketId")) {
/* 259 */       this._taxBracketId = argTaxBracketId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 266 */     StringBuilder buf = new StringBuilder(512);
/* 267 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 268 */     if (getExpirationDatetimestamp() != null) {
/* 269 */       buf.append("expirationDatetimestamp").append("=").append(getExpirationDatetimestamp()).append(" ");
/*     */     }
/* 271 */     if (getOrganizationId() != null) {
/* 272 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 274 */     if (getTaxGroupId() != null) {
/* 275 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*     */     }
/* 277 */     if (getTaxLocationId() != null) {
/* 278 */       buf.append("taxLocationId").append("=").append(getTaxLocationId()).append(" ");
/*     */     }
/* 280 */     if (getTaxRateRuleSequence() != null) {
/* 281 */       buf.append("taxRateRuleSequence").append("=").append(getTaxRateRuleSequence()).append(" ");
/*     */     }
/* 283 */     if (getTaxRuleSequence() != null) {
/* 284 */       buf.append("taxRuleSequence").append("=").append(getTaxRuleSequence()).append(" ");
/*     */     }
/* 286 */     if (getCreateDate() != null) {
/* 287 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 289 */     if (getCreateUserId() != null) {
/* 290 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 292 */     if (getUpdateDate() != null) {
/* 293 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 295 */     if (getUpdateUserId() != null) {
/* 296 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 298 */     if (getOrgCode() != null) {
/* 299 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 301 */     if (getOrgValue() != null) {
/* 302 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 304 */     if (getAmount() != null) {
/* 305 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 307 */     if (getBreakPointTypeCode() != null) {
/* 308 */       buf.append("breakPointTypeCode").append("=").append(getBreakPointTypeCode()).append(" ");
/*     */     }
/* 310 */     if (getDailyEndTimeDao() != null) {
/* 311 */       buf.append("dailyEndTimeDao").append("=").append(getDailyEndTimeDao()).append(" ");
/*     */     }
/* 313 */     if (getDailyStartTimeDao() != null) {
/* 314 */       buf.append("dailyStartTimeDao").append("=").append(getDailyStartTimeDao()).append(" ");
/*     */     }
/* 316 */     if (getEffectiveDatetimestamp() != null) {
/* 317 */       buf.append("effectiveDatetimestamp").append("=").append(getEffectiveDatetimestamp()).append(" ");
/*     */     }
/* 319 */     if (getPercent() != null) {
/* 320 */       buf.append("percent").append("=").append(getPercent()).append(" ");
/*     */     }
/* 322 */     if (getTaxRateMaxTaxableAmount() != null) {
/* 323 */       buf.append("taxRateMaxTaxableAmount").append("=").append(getTaxRateMaxTaxableAmount()).append(" ");
/*     */     }
/* 325 */     if (getTaxRateMinTaxableAmount() != null) {
/* 326 */       buf.append("taxRateMinTaxableAmount").append("=").append(getTaxRateMinTaxableAmount()).append(" ");
/*     */     }
/* 328 */     if (getTaxBracketId() != null) {
/* 329 */       buf.append("taxBracketId").append("=").append(getTaxBracketId()).append(" ");
/*     */     }
/*     */     
/* 332 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 336 */     TaxRateRuleOverrideId id = new TaxRateRuleOverrideId();
/* 337 */     id.setExpirationDatetimestamp(getExpirationDatetimestamp());
/* 338 */     id.setOrganizationId(getOrganizationId());
/* 339 */     id.setTaxGroupId(getTaxGroupId());
/* 340 */     id.setTaxLocationId(getTaxLocationId());
/* 341 */     id.setTaxRateRuleSequence(getTaxRateRuleSequence());
/* 342 */     id.setTaxRuleSequence(getTaxRuleSequence());
/* 343 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 347 */     setExpirationDatetimestamp(((TaxRateRuleOverrideId)argObjectId).getExpirationDatetimestamp());
/* 348 */     setOrganizationId(((TaxRateRuleOverrideId)argObjectId).getOrganizationId());
/* 349 */     setTaxGroupId(((TaxRateRuleOverrideId)argObjectId).getTaxGroupId());
/* 350 */     setTaxLocationId(((TaxRateRuleOverrideId)argObjectId).getTaxLocationId());
/* 351 */     setTaxRateRuleSequence(((TaxRateRuleOverrideId)argObjectId).getTaxRateRuleSequence());
/* 352 */     setTaxRuleSequence(((TaxRateRuleOverrideId)argObjectId).getTaxRuleSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 356 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 360 */     StringBuilder buf = new StringBuilder(1050);
/* 361 */     buf.append("<").append("dao").append(" name=\"TaxRateRuleOverride\" cmd=\"" + getObjectStateString() + "\">");
/* 362 */     getFieldsAsXml(buf);
/* 363 */     buf.append("</").append("dao").append(">");
/*     */     
/* 365 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 369 */     Map<String, String> values = super.getValues();
/* 370 */     if (this._expirationDatetimestamp != null) values.put("ExpirationDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._expirationDatetimestamp)); 
/* 371 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 372 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/* 373 */     if (this._taxLocationId != null) values.put("TaxLocationId", DaoUtils.getXmlSafeFieldValue(12, this._taxLocationId)); 
/* 374 */     if (this._taxRateRuleSequence != null) values.put("TaxRateRuleSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxRateRuleSequence)); 
/* 375 */     if (this._taxRuleSequence != null) values.put("TaxRuleSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxRuleSequence)); 
/* 376 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 377 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 378 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 379 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 380 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 381 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 382 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 383 */     if (this._breakPointTypeCode != null) values.put("BreakPointTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._breakPointTypeCode)); 
/* 384 */     if (this._dailyEndTimeDao != null) values.put("DailyEndTimeDao", DaoUtils.getXmlSafeFieldValue(91, this._dailyEndTimeDao)); 
/* 385 */     if (this._dailyStartTimeDao != null) values.put("DailyStartTimeDao", DaoUtils.getXmlSafeFieldValue(91, this._dailyStartTimeDao)); 
/* 386 */     if (this._effectiveDatetimestamp != null) values.put("EffectiveDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDatetimestamp)); 
/* 387 */     if (this._percent != null) values.put("Percent", DaoUtils.getXmlSafeFieldValue(3, this._percent)); 
/* 388 */     if (this._taxRateMaxTaxableAmount != null) values.put("TaxRateMaxTaxableAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxRateMaxTaxableAmount)); 
/* 389 */     if (this._taxRateMinTaxableAmount != null) values.put("TaxRateMinTaxableAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxRateMinTaxableAmount)); 
/* 390 */     if (this._taxBracketId != null) values.put("TaxBracketId", DaoUtils.getXmlSafeFieldValue(12, this._taxBracketId)); 
/* 391 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 396 */     super.setValues(argValues);
/* 397 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 399 */       String fieldName = field.getKey();
/* 400 */       String fieldValue = field.getValue();
/* 401 */       switch (fieldName) {
/*     */         
/*     */         case "ExpirationDatetimestamp":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 406 */             setExpirationDatetimestamp((Date)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setExpirationDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 415 */             setOrganizationId((Long)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxGroupId":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 424 */             setTaxGroupId((String)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxLocationId":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setTaxLocationId((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setTaxLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRateRuleSequence":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 442 */             setTaxRateRuleSequence((Integer)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setTaxRateRuleSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRuleSequence":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 451 */             setTaxRuleSequence((Integer)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setTaxRuleSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 460 */             setCreateDate((Date)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 469 */             setCreateUserId((String)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 478 */             setUpdateDate((Date)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 486 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 487 */             setUpdateUserId((String)value);
/* 488 */           } catch (Exception ee) {
/* 489 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 495 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 496 */             setOrgCode((String)value);
/* 497 */           } catch (Exception ee) {
/* 498 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 504 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 505 */             setOrgValue((String)value);
/* 506 */           } catch (Exception ee) {
/* 507 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 513 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 514 */             setAmount((BigDecimal)value);
/* 515 */           } catch (Exception ee) {
/* 516 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BreakPointTypeCode":
/*     */           try {
/* 522 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 523 */             setBreakPointTypeCode((String)value);
/* 524 */           } catch (Exception ee) {
/* 525 */             throw new DtxException("An exception occurred while calling setBreakPointTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DailyEndTimeDao":
/*     */           try {
/* 531 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 532 */             setDailyEndTimeDao((Date)value);
/* 533 */           } catch (Exception ee) {
/* 534 */             throw new DtxException("An exception occurred while calling setDailyEndTimeDao() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DailyStartTimeDao":
/*     */           try {
/* 540 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 541 */             setDailyStartTimeDao((Date)value);
/* 542 */           } catch (Exception ee) {
/* 543 */             throw new DtxException("An exception occurred while calling setDailyStartTimeDao() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDatetimestamp":
/*     */           try {
/* 549 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 550 */             setEffectiveDatetimestamp((Date)value);
/* 551 */           } catch (Exception ee) {
/* 552 */             throw new DtxException("An exception occurred while calling setEffectiveDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Percent":
/*     */           try {
/* 558 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 559 */             setPercent((BigDecimal)value);
/* 560 */           } catch (Exception ee) {
/* 561 */             throw new DtxException("An exception occurred while calling setPercent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRateMaxTaxableAmount":
/*     */           try {
/* 567 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 568 */             setTaxRateMaxTaxableAmount((BigDecimal)value);
/* 569 */           } catch (Exception ee) {
/* 570 */             throw new DtxException("An exception occurred while calling setTaxRateMaxTaxableAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRateMinTaxableAmount":
/*     */           try {
/* 576 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 577 */             setTaxRateMinTaxableAmount((BigDecimal)value);
/* 578 */           } catch (Exception ee) {
/* 579 */             throw new DtxException("An exception occurred while calling setTaxRateMinTaxableAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxBracketId":
/*     */           try {
/* 585 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 586 */             setTaxBracketId((String)value);
/* 587 */           } catch (Exception ee) {
/* 588 */             throw new DtxException("An exception occurred while calling setTaxBracketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleOverrideDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */