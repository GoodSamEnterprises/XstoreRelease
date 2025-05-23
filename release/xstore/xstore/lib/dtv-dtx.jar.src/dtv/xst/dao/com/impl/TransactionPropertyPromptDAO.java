/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.TransactionPropertyPromptId;
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
/*     */ public class TransactionPropertyPromptDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1510887927L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TransactionPropertyPromptDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _promptPropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _expirationDate;
/*     */   private String _promptMethodCode;
/*     */   private String _codeCategory;
/*     */   private String _promptTitleKey;
/*     */   private String _promptMessageKey;
/*  39 */   private Boolean _required = Boolean.FALSE;
/*     */   private Integer _sortOrder;
/*     */   private String _promptEditPattern;
/*     */   private String _validationRuleKey;
/*     */   private String _promptKey;
/*     */   private String _chainKey;
/*     */   private String _transactionState;
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
/*     */   public String getPromptPropertyCode() {
/*  58 */     return this._promptPropertyCode;
/*     */   }
/*     */   
/*     */   public void setPromptPropertyCode(String argPromptPropertyCode) {
/*  62 */     if (changed(argPromptPropertyCode, this._promptPropertyCode, "promptPropertyCode")) {
/*  63 */       this._promptPropertyCode = (argPromptPropertyCode != null && MANAGE_CASE) ? argPromptPropertyCode.toUpperCase() : argPromptPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  68 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  72 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  73 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  79 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  83 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  84 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  90 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  94 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  95 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 100 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 104 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 105 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 111 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 115 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 116 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 121 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 125 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 126 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 131 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 135 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 136 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 141 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 145 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 146 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPromptMethodCode() {
/* 152 */     return this._promptMethodCode;
/*     */   }
/*     */   
/*     */   public void setPromptMethodCode(String argPromptMethodCode) {
/* 156 */     if (changed(argPromptMethodCode, this._promptMethodCode, "promptMethodCode")) {
/* 157 */       this._promptMethodCode = argPromptMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCodeCategory() {
/* 162 */     return this._codeCategory;
/*     */   }
/*     */   
/*     */   public void setCodeCategory(String argCodeCategory) {
/* 166 */     if (changed(argCodeCategory, this._codeCategory, "codeCategory")) {
/* 167 */       this._codeCategory = argCodeCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptTitleKey() {
/* 172 */     return this._promptTitleKey;
/*     */   }
/*     */   
/*     */   public void setPromptTitleKey(String argPromptTitleKey) {
/* 176 */     if (changed(argPromptTitleKey, this._promptTitleKey, "promptTitleKey")) {
/* 177 */       this._promptTitleKey = argPromptTitleKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptMessageKey() {
/* 182 */     return this._promptMessageKey;
/*     */   }
/*     */   
/*     */   public void setPromptMessageKey(String argPromptMessageKey) {
/* 186 */     if (changed(argPromptMessageKey, this._promptMessageKey, "promptMessageKey")) {
/* 187 */       this._promptMessageKey = argPromptMessageKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getRequired() {
/* 192 */     return this._required;
/*     */   }
/*     */   
/*     */   public void setRequired(Boolean argRequired) {
/* 196 */     if (changed(argRequired, this._required, "required")) {
/* 197 */       this._required = argRequired;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 202 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 206 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 207 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptEditPattern() {
/* 212 */     return this._promptEditPattern;
/*     */   }
/*     */   
/*     */   public void setPromptEditPattern(String argPromptEditPattern) {
/* 216 */     if (changed(argPromptEditPattern, this._promptEditPattern, "promptEditPattern")) {
/* 217 */       this._promptEditPattern = argPromptEditPattern;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getValidationRuleKey() {
/* 222 */     return this._validationRuleKey;
/*     */   }
/*     */   
/*     */   public void setValidationRuleKey(String argValidationRuleKey) {
/* 226 */     if (changed(argValidationRuleKey, this._validationRuleKey, "validationRuleKey")) {
/* 227 */       this._validationRuleKey = argValidationRuleKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptKey() {
/* 232 */     return this._promptKey;
/*     */   }
/*     */   
/*     */   public void setPromptKey(String argPromptKey) {
/* 236 */     if (changed(argPromptKey, this._promptKey, "promptKey")) {
/* 237 */       this._promptKey = argPromptKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getChainKey() {
/* 242 */     return this._chainKey;
/*     */   }
/*     */   
/*     */   public void setChainKey(String argChainKey) {
/* 246 */     if (changed(argChainKey, this._chainKey, "chainKey")) {
/* 247 */       this._chainKey = argChainKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTransactionState() {
/* 252 */     return this._transactionState;
/*     */   }
/*     */   
/*     */   public void setTransactionState(String argTransactionState) {
/* 256 */     if (changed(argTransactionState, this._transactionState, "transactionState")) {
/* 257 */       this._transactionState = argTransactionState;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 264 */     StringBuilder buf = new StringBuilder(512);
/* 265 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 266 */     if (getOrganizationId() != null) {
/* 267 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 269 */     if (getPromptPropertyCode() != null) {
/* 270 */       buf.append("promptPropertyCode").append("=").append(getPromptPropertyCode()).append(" ");
/*     */     }
/* 272 */     if (getEffectiveDate() != null) {
/* 273 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 275 */     if (getCreateDate() != null) {
/* 276 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 278 */     if (getCreateUserId() != null) {
/* 279 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 281 */     if (getUpdateDate() != null) {
/* 282 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 284 */     if (getUpdateUserId() != null) {
/* 285 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 287 */     if (getOrgCode() != null) {
/* 288 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 290 */     if (getOrgValue() != null) {
/* 291 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 293 */     if (getExpirationDate() != null) {
/* 294 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 296 */     if (getPromptMethodCode() != null) {
/* 297 */       buf.append("promptMethodCode").append("=").append(getPromptMethodCode()).append(" ");
/*     */     }
/* 299 */     if (getCodeCategory() != null) {
/* 300 */       buf.append("codeCategory").append("=").append(getCodeCategory()).append(" ");
/*     */     }
/* 302 */     if (getPromptTitleKey() != null) {
/* 303 */       buf.append("promptTitleKey").append("=").append(getPromptTitleKey()).append(" ");
/*     */     }
/* 305 */     if (getPromptMessageKey() != null) {
/* 306 */       buf.append("promptMessageKey").append("=").append(getPromptMessageKey()).append(" ");
/*     */     }
/* 308 */     if (getRequired() != null && getRequired().booleanValue()) {
/* 309 */       buf.append("required").append("=").append(getRequired()).append(" ");
/*     */     }
/* 311 */     if (getSortOrder() != null) {
/* 312 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 314 */     if (getPromptEditPattern() != null) {
/* 315 */       buf.append("promptEditPattern").append("=").append(getPromptEditPattern()).append(" ");
/*     */     }
/* 317 */     if (getValidationRuleKey() != null) {
/* 318 */       buf.append("validationRuleKey").append("=").append(getValidationRuleKey()).append(" ");
/*     */     }
/* 320 */     if (getPromptKey() != null) {
/* 321 */       buf.append("promptKey").append("=").append(getPromptKey()).append(" ");
/*     */     }
/* 323 */     if (getChainKey() != null) {
/* 324 */       buf.append("chainKey").append("=").append(getChainKey()).append(" ");
/*     */     }
/* 326 */     if (getTransactionState() != null) {
/* 327 */       buf.append("transactionState").append("=").append(getTransactionState()).append(" ");
/*     */     }
/*     */     
/* 330 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 334 */     TransactionPropertyPromptId id = new TransactionPropertyPromptId();
/* 335 */     id.setOrganizationId(getOrganizationId());
/* 336 */     id.setPromptPropertyCode(getPromptPropertyCode());
/* 337 */     id.setEffectiveDate(getEffectiveDate());
/* 338 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 342 */     setOrganizationId(((TransactionPropertyPromptId)argObjectId).getOrganizationId());
/* 343 */     setPromptPropertyCode(((TransactionPropertyPromptId)argObjectId).getPromptPropertyCode());
/* 344 */     setEffectiveDate(((TransactionPropertyPromptId)argObjectId).getEffectiveDate());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 348 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 352 */     StringBuilder buf = new StringBuilder(1050);
/* 353 */     buf.append("<").append("dao").append(" name=\"TransactionPropertyPrompt\" cmd=\"" + getObjectStateString() + "\">");
/* 354 */     getFieldsAsXml(buf);
/* 355 */     buf.append("</").append("dao").append(">");
/*     */     
/* 357 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 361 */     Map<String, String> values = super.getValues();
/* 362 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 363 */     if (this._promptPropertyCode != null) values.put("PromptPropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._promptPropertyCode)); 
/* 364 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 365 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 366 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 367 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 368 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 369 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 370 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 371 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 372 */     if (this._promptMethodCode != null) values.put("PromptMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._promptMethodCode)); 
/* 373 */     if (this._codeCategory != null) values.put("CodeCategory", DaoUtils.getXmlSafeFieldValue(12, this._codeCategory)); 
/* 374 */     if (this._promptTitleKey != null) values.put("PromptTitleKey", DaoUtils.getXmlSafeFieldValue(12, this._promptTitleKey)); 
/* 375 */     if (this._promptMessageKey != null) values.put("PromptMessageKey", DaoUtils.getXmlSafeFieldValue(12, this._promptMessageKey)); 
/* 376 */     if (this._required != null) values.put("Required", DaoUtils.getXmlSafeFieldValue(-7, this._required)); 
/* 377 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 378 */     if (this._promptEditPattern != null) values.put("PromptEditPattern", DaoUtils.getXmlSafeFieldValue(12, this._promptEditPattern)); 
/* 379 */     if (this._validationRuleKey != null) values.put("ValidationRuleKey", DaoUtils.getXmlSafeFieldValue(12, this._validationRuleKey)); 
/* 380 */     if (this._promptKey != null) values.put("PromptKey", DaoUtils.getXmlSafeFieldValue(12, this._promptKey)); 
/* 381 */     if (this._chainKey != null) values.put("ChainKey", DaoUtils.getXmlSafeFieldValue(12, this._chainKey)); 
/* 382 */     if (this._transactionState != null) values.put("TransactionState", DaoUtils.getXmlSafeFieldValue(12, this._transactionState)); 
/* 383 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 388 */     super.setValues(argValues);
/* 389 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 391 */       String fieldName = field.getKey();
/* 392 */       String fieldValue = field.getValue();
/* 393 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 397 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 398 */             setOrganizationId((Long)value);
/* 399 */           } catch (Exception ee) {
/* 400 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptPropertyCode":
/*     */           try {
/* 406 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 407 */             setPromptPropertyCode((String)value);
/* 408 */           } catch (Exception ee) {
/* 409 */             throw new DtxException("An exception occurred while calling setPromptPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 415 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 416 */             setEffectiveDate((Date)value);
/* 417 */           } catch (Exception ee) {
/* 418 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 424 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 425 */             setCreateDate((Date)value);
/* 426 */           } catch (Exception ee) {
/* 427 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 433 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 434 */             setCreateUserId((String)value);
/* 435 */           } catch (Exception ee) {
/* 436 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 442 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 443 */             setUpdateDate((Date)value);
/* 444 */           } catch (Exception ee) {
/* 445 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 451 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 452 */             setUpdateUserId((String)value);
/* 453 */           } catch (Exception ee) {
/* 454 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 460 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 461 */             setOrgCode((String)value);
/* 462 */           } catch (Exception ee) {
/* 463 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 469 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 470 */             setOrgValue((String)value);
/* 471 */           } catch (Exception ee) {
/* 472 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 478 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 479 */             setExpirationDate((Date)value);
/* 480 */           } catch (Exception ee) {
/* 481 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptMethodCode":
/*     */           try {
/* 487 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 488 */             setPromptMethodCode((String)value);
/* 489 */           } catch (Exception ee) {
/* 490 */             throw new DtxException("An exception occurred while calling setPromptMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CodeCategory":
/*     */           try {
/* 496 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 497 */             setCodeCategory((String)value);
/* 498 */           } catch (Exception ee) {
/* 499 */             throw new DtxException("An exception occurred while calling setCodeCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptTitleKey":
/*     */           try {
/* 505 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 506 */             setPromptTitleKey((String)value);
/* 507 */           } catch (Exception ee) {
/* 508 */             throw new DtxException("An exception occurred while calling setPromptTitleKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptMessageKey":
/*     */           try {
/* 514 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 515 */             setPromptMessageKey((String)value);
/* 516 */           } catch (Exception ee) {
/* 517 */             throw new DtxException("An exception occurred while calling setPromptMessageKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Required":
/*     */           try {
/* 523 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 524 */             setRequired((Boolean)value);
/* 525 */           } catch (Exception ee) {
/* 526 */             throw new DtxException("An exception occurred while calling setRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 532 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 533 */             setSortOrder((Integer)value);
/* 534 */           } catch (Exception ee) {
/* 535 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptEditPattern":
/*     */           try {
/* 541 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 542 */             setPromptEditPattern((String)value);
/* 543 */           } catch (Exception ee) {
/* 544 */             throw new DtxException("An exception occurred while calling setPromptEditPattern() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ValidationRuleKey":
/*     */           try {
/* 550 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 551 */             setValidationRuleKey((String)value);
/* 552 */           } catch (Exception ee) {
/* 553 */             throw new DtxException("An exception occurred while calling setValidationRuleKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptKey":
/*     */           try {
/* 559 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 560 */             setPromptKey((String)value);
/* 561 */           } catch (Exception ee) {
/* 562 */             throw new DtxException("An exception occurred while calling setPromptKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChainKey":
/*     */           try {
/* 568 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 569 */             setChainKey((String)value);
/* 570 */           } catch (Exception ee) {
/* 571 */             throw new DtxException("An exception occurred while calling setChainKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionState":
/*     */           try {
/* 577 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 578 */             setTransactionState((String)value);
/* 579 */           } catch (Exception ee) {
/* 580 */             throw new DtxException("An exception occurred while calling setTransactionState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\TransactionPropertyPromptDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */