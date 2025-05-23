/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxRateRuleId;
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
/*     */ public class TaxRateRuleDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 133683367L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TaxRateRuleDAO.class);
/*     */   
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
/*     */   private DtvDate _expirationDatetimestamp;
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _taxRateMaxTaxableAmount;
/*     */   private BigDecimal _taxRateMinTaxableAmount;
/*     */   private String _taxBracketId;
/*     */   private String _externalSystem;
/*     */   
/*     */   public Long getOrganizationId() {
/*  49 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  53 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  54 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/*  59 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  63 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/*  64 */       this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  69 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  73 */     if (changed(argTaxLocationId, this._taxLocationId, "taxLocationId")) {
/*  74 */       this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxRateRuleSequence() {
/*  79 */     return this._taxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRateRuleSequence(Integer argTaxRateRuleSequence) {
/*  83 */     if (changed(argTaxRateRuleSequence, this._taxRateRuleSequence, "taxRateRuleSequence")) {
/*  84 */       this._taxRateRuleSequence = argTaxRateRuleSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/*  89 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/*  93 */     if (changed(argTaxRuleSequence, this._taxRuleSequence, "taxRuleSequence")) {
/*  94 */       this._taxRuleSequence = argTaxRuleSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  99 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 103 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 104 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 110 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 114 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 115 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 120 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 124 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 125 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 131 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 135 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 136 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 141 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 145 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 146 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 151 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 155 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 156 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 161 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 165 */     if (changed(argAmount, this._amount, "amount")) {
/* 166 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBreakPointTypeCode() {
/* 171 */     return this._breakPointTypeCode;
/*     */   }
/*     */   
/*     */   public void setBreakPointTypeCode(String argBreakPointTypeCode) {
/* 175 */     if (changed(argBreakPointTypeCode, this._breakPointTypeCode, "breakPointTypeCode")) {
/* 176 */       this._breakPointTypeCode = argBreakPointTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDailyEndTimeDao() {
/* 181 */     return (Date)this._dailyEndTimeDao;
/*     */   }
/*     */   
/*     */   public void setDailyEndTimeDao(Date argDailyEndTimeDao) {
/* 185 */     if (changed(argDailyEndTimeDao, this._dailyEndTimeDao, "dailyEndTimeDao")) {
/* 186 */       this._dailyEndTimeDao = (argDailyEndTimeDao == null || argDailyEndTimeDao instanceof DtvDate) ? (DtvDate)argDailyEndTimeDao : new DtvDate(argDailyEndTimeDao);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDailyStartTimeDao() {
/* 192 */     return (Date)this._dailyStartTimeDao;
/*     */   }
/*     */   
/*     */   public void setDailyStartTimeDao(Date argDailyStartTimeDao) {
/* 196 */     if (changed(argDailyStartTimeDao, this._dailyStartTimeDao, "dailyStartTimeDao")) {
/* 197 */       this._dailyStartTimeDao = (argDailyStartTimeDao == null || argDailyStartTimeDao instanceof DtvDate) ? (DtvDate)argDailyStartTimeDao : new DtvDate(argDailyStartTimeDao);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEffectiveDatetimestamp() {
/* 203 */     return (Date)this._effectiveDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setEffectiveDatetimestamp(Date argEffectiveDatetimestamp) {
/* 207 */     if (changed(argEffectiveDatetimestamp, this._effectiveDatetimestamp, "effectiveDatetimestamp")) {
/* 208 */       this._effectiveDatetimestamp = (argEffectiveDatetimestamp == null || argEffectiveDatetimestamp instanceof DtvDate) ? (DtvDate)argEffectiveDatetimestamp : new DtvDate(argEffectiveDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDatetimestamp() {
/* 214 */     return (Date)this._expirationDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setExpirationDatetimestamp(Date argExpirationDatetimestamp) {
/* 218 */     if (changed(argExpirationDatetimestamp, this._expirationDatetimestamp, "expirationDatetimestamp")) {
/* 219 */       this._expirationDatetimestamp = (argExpirationDatetimestamp == null || argExpirationDatetimestamp instanceof DtvDate) ? (DtvDate)argExpirationDatetimestamp : new DtvDate(argExpirationDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getPercent() {
/* 225 */     return this._percent;
/*     */   }
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/* 229 */     if (changed(argPercent, this._percent, "percent")) {
/* 230 */       this._percent = argPercent;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxRateMaxTaxableAmount() {
/* 235 */     return this._taxRateMaxTaxableAmount;
/*     */   }
/*     */   
/*     */   public void setTaxRateMaxTaxableAmount(BigDecimal argTaxRateMaxTaxableAmount) {
/* 239 */     if (changed(argTaxRateMaxTaxableAmount, this._taxRateMaxTaxableAmount, "taxRateMaxTaxableAmount")) {
/* 240 */       this._taxRateMaxTaxableAmount = argTaxRateMaxTaxableAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxRateMinTaxableAmount() {
/* 245 */     return this._taxRateMinTaxableAmount;
/*     */   }
/*     */   
/*     */   public void setTaxRateMinTaxableAmount(BigDecimal argTaxRateMinTaxableAmount) {
/* 249 */     if (changed(argTaxRateMinTaxableAmount, this._taxRateMinTaxableAmount, "taxRateMinTaxableAmount")) {
/* 250 */       this._taxRateMinTaxableAmount = argTaxRateMinTaxableAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxBracketId() {
/* 255 */     return this._taxBracketId;
/*     */   }
/*     */   
/*     */   public void setTaxBracketId(String argTaxBracketId) {
/* 259 */     if (changed(argTaxBracketId, this._taxBracketId, "taxBracketId")) {
/* 260 */       this._taxBracketId = argTaxBracketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalSystem() {
/* 265 */     return this._externalSystem;
/*     */   }
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 269 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/* 270 */       this._externalSystem = argExternalSystem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 277 */     StringBuilder buf = new StringBuilder(512);
/* 278 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 279 */     if (getOrganizationId() != null) {
/* 280 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 282 */     if (getTaxGroupId() != null) {
/* 283 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*     */     }
/* 285 */     if (getTaxLocationId() != null) {
/* 286 */       buf.append("taxLocationId").append("=").append(getTaxLocationId()).append(" ");
/*     */     }
/* 288 */     if (getTaxRateRuleSequence() != null) {
/* 289 */       buf.append("taxRateRuleSequence").append("=").append(getTaxRateRuleSequence()).append(" ");
/*     */     }
/* 291 */     if (getTaxRuleSequence() != null) {
/* 292 */       buf.append("taxRuleSequence").append("=").append(getTaxRuleSequence()).append(" ");
/*     */     }
/* 294 */     if (getCreateDate() != null) {
/* 295 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 297 */     if (getCreateUserId() != null) {
/* 298 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 300 */     if (getUpdateDate() != null) {
/* 301 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 303 */     if (getUpdateUserId() != null) {
/* 304 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 306 */     if (getOrgCode() != null) {
/* 307 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 309 */     if (getOrgValue() != null) {
/* 310 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 312 */     if (getAmount() != null) {
/* 313 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 315 */     if (getBreakPointTypeCode() != null) {
/* 316 */       buf.append("breakPointTypeCode").append("=").append(getBreakPointTypeCode()).append(" ");
/*     */     }
/* 318 */     if (getDailyEndTimeDao() != null) {
/* 319 */       buf.append("dailyEndTimeDao").append("=").append(getDailyEndTimeDao()).append(" ");
/*     */     }
/* 321 */     if (getDailyStartTimeDao() != null) {
/* 322 */       buf.append("dailyStartTimeDao").append("=").append(getDailyStartTimeDao()).append(" ");
/*     */     }
/* 324 */     if (getEffectiveDatetimestamp() != null) {
/* 325 */       buf.append("effectiveDatetimestamp").append("=").append(getEffectiveDatetimestamp()).append(" ");
/*     */     }
/* 327 */     if (getExpirationDatetimestamp() != null) {
/* 328 */       buf.append("expirationDatetimestamp").append("=").append(getExpirationDatetimestamp()).append(" ");
/*     */     }
/* 330 */     if (getPercent() != null) {
/* 331 */       buf.append("percent").append("=").append(getPercent()).append(" ");
/*     */     }
/* 333 */     if (getTaxRateMaxTaxableAmount() != null) {
/* 334 */       buf.append("taxRateMaxTaxableAmount").append("=").append(getTaxRateMaxTaxableAmount()).append(" ");
/*     */     }
/* 336 */     if (getTaxRateMinTaxableAmount() != null) {
/* 337 */       buf.append("taxRateMinTaxableAmount").append("=").append(getTaxRateMinTaxableAmount()).append(" ");
/*     */     }
/* 339 */     if (getTaxBracketId() != null) {
/* 340 */       buf.append("taxBracketId").append("=").append(getTaxBracketId()).append(" ");
/*     */     }
/* 342 */     if (getExternalSystem() != null) {
/* 343 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*     */     }
/*     */     
/* 346 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 350 */     TaxRateRuleId id = new TaxRateRuleId();
/* 351 */     id.setOrganizationId(getOrganizationId());
/* 352 */     id.setTaxGroupId(getTaxGroupId());
/* 353 */     id.setTaxLocationId(getTaxLocationId());
/* 354 */     id.setTaxRateRuleSequence(getTaxRateRuleSequence());
/* 355 */     id.setTaxRuleSequence(getTaxRuleSequence());
/* 356 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 360 */     setOrganizationId(((TaxRateRuleId)argObjectId).getOrganizationId());
/* 361 */     setTaxGroupId(((TaxRateRuleId)argObjectId).getTaxGroupId());
/* 362 */     setTaxLocationId(((TaxRateRuleId)argObjectId).getTaxLocationId());
/* 363 */     setTaxRateRuleSequence(((TaxRateRuleId)argObjectId).getTaxRateRuleSequence());
/* 364 */     setTaxRuleSequence(((TaxRateRuleId)argObjectId).getTaxRuleSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 368 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 372 */     StringBuilder buf = new StringBuilder(1100);
/* 373 */     buf.append("<").append("dao").append(" name=\"TaxRateRule\" cmd=\"" + getObjectStateString() + "\">");
/* 374 */     getFieldsAsXml(buf);
/* 375 */     buf.append("</").append("dao").append(">");
/*     */     
/* 377 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 381 */     Map<String, String> values = super.getValues();
/* 382 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 383 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/* 384 */     if (this._taxLocationId != null) values.put("TaxLocationId", DaoUtils.getXmlSafeFieldValue(12, this._taxLocationId)); 
/* 385 */     if (this._taxRateRuleSequence != null) values.put("TaxRateRuleSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxRateRuleSequence)); 
/* 386 */     if (this._taxRuleSequence != null) values.put("TaxRuleSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxRuleSequence)); 
/* 387 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 388 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 389 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 390 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 391 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 392 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 393 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 394 */     if (this._breakPointTypeCode != null) values.put("BreakPointTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._breakPointTypeCode)); 
/* 395 */     if (this._dailyEndTimeDao != null) values.put("DailyEndTimeDao", DaoUtils.getXmlSafeFieldValue(91, this._dailyEndTimeDao)); 
/* 396 */     if (this._dailyStartTimeDao != null) values.put("DailyStartTimeDao", DaoUtils.getXmlSafeFieldValue(91, this._dailyStartTimeDao)); 
/* 397 */     if (this._effectiveDatetimestamp != null) values.put("EffectiveDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDatetimestamp)); 
/* 398 */     if (this._expirationDatetimestamp != null) values.put("ExpirationDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._expirationDatetimestamp)); 
/* 399 */     if (this._percent != null) values.put("Percent", DaoUtils.getXmlSafeFieldValue(3, this._percent)); 
/* 400 */     if (this._taxRateMaxTaxableAmount != null) values.put("TaxRateMaxTaxableAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxRateMaxTaxableAmount)); 
/* 401 */     if (this._taxRateMinTaxableAmount != null) values.put("TaxRateMinTaxableAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxRateMinTaxableAmount)); 
/* 402 */     if (this._taxBracketId != null) values.put("TaxBracketId", DaoUtils.getXmlSafeFieldValue(12, this._taxBracketId)); 
/* 403 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
/* 404 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 409 */     super.setValues(argValues);
/* 410 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 412 */       String fieldName = field.getKey();
/* 413 */       String fieldValue = field.getValue();
/* 414 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 418 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 419 */             setOrganizationId((Long)value);
/* 420 */           } catch (Exception ee) {
/* 421 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxGroupId":
/*     */           try {
/* 427 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 428 */             setTaxGroupId((String)value);
/* 429 */           } catch (Exception ee) {
/* 430 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxLocationId":
/*     */           try {
/* 436 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 437 */             setTaxLocationId((String)value);
/* 438 */           } catch (Exception ee) {
/* 439 */             throw new DtxException("An exception occurred while calling setTaxLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRateRuleSequence":
/*     */           try {
/* 445 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 446 */             setTaxRateRuleSequence((Integer)value);
/* 447 */           } catch (Exception ee) {
/* 448 */             throw new DtxException("An exception occurred while calling setTaxRateRuleSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRuleSequence":
/*     */           try {
/* 454 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 455 */             setTaxRuleSequence((Integer)value);
/* 456 */           } catch (Exception ee) {
/* 457 */             throw new DtxException("An exception occurred while calling setTaxRuleSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 463 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 464 */             setCreateDate((Date)value);
/* 465 */           } catch (Exception ee) {
/* 466 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 472 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 473 */             setCreateUserId((String)value);
/* 474 */           } catch (Exception ee) {
/* 475 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 481 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 482 */             setUpdateDate((Date)value);
/* 483 */           } catch (Exception ee) {
/* 484 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 490 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 491 */             setUpdateUserId((String)value);
/* 492 */           } catch (Exception ee) {
/* 493 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 499 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 500 */             setOrgCode((String)value);
/* 501 */           } catch (Exception ee) {
/* 502 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 508 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 509 */             setOrgValue((String)value);
/* 510 */           } catch (Exception ee) {
/* 511 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 517 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 518 */             setAmount((BigDecimal)value);
/* 519 */           } catch (Exception ee) {
/* 520 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BreakPointTypeCode":
/*     */           try {
/* 526 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 527 */             setBreakPointTypeCode((String)value);
/* 528 */           } catch (Exception ee) {
/* 529 */             throw new DtxException("An exception occurred while calling setBreakPointTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DailyEndTimeDao":
/*     */           try {
/* 535 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 536 */             setDailyEndTimeDao((Date)value);
/* 537 */           } catch (Exception ee) {
/* 538 */             throw new DtxException("An exception occurred while calling setDailyEndTimeDao() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DailyStartTimeDao":
/*     */           try {
/* 544 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 545 */             setDailyStartTimeDao((Date)value);
/* 546 */           } catch (Exception ee) {
/* 547 */             throw new DtxException("An exception occurred while calling setDailyStartTimeDao() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDatetimestamp":
/*     */           try {
/* 553 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 554 */             setEffectiveDatetimestamp((Date)value);
/* 555 */           } catch (Exception ee) {
/* 556 */             throw new DtxException("An exception occurred while calling setEffectiveDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDatetimestamp":
/*     */           try {
/* 562 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 563 */             setExpirationDatetimestamp((Date)value);
/* 564 */           } catch (Exception ee) {
/* 565 */             throw new DtxException("An exception occurred while calling setExpirationDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Percent":
/*     */           try {
/* 571 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 572 */             setPercent((BigDecimal)value);
/* 573 */           } catch (Exception ee) {
/* 574 */             throw new DtxException("An exception occurred while calling setPercent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRateMaxTaxableAmount":
/*     */           try {
/* 580 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 581 */             setTaxRateMaxTaxableAmount((BigDecimal)value);
/* 582 */           } catch (Exception ee) {
/* 583 */             throw new DtxException("An exception occurred while calling setTaxRateMaxTaxableAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRateMinTaxableAmount":
/*     */           try {
/* 589 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 590 */             setTaxRateMinTaxableAmount((BigDecimal)value);
/* 591 */           } catch (Exception ee) {
/* 592 */             throw new DtxException("An exception occurred while calling setTaxRateMinTaxableAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxBracketId":
/*     */           try {
/* 598 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 599 */             setTaxBracketId((String)value);
/* 600 */           } catch (Exception ee) {
/* 601 */             throw new DtxException("An exception occurred while calling setTaxBracketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalSystem":
/*     */           try {
/* 607 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 608 */             setExternalSystem((String)value);
/* 609 */           } catch (Exception ee) {
/* 610 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */