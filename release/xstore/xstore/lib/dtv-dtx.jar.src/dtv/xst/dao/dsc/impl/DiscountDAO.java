/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractExtensibleDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.dsc.DiscountId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DiscountDAO
/*     */   extends AbstractExtensibleDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = 337828193L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DiscountDAO.class);
/*     */   
/*     */   private String _discountCode;
/*     */   private Long _organizationId;
/*     */   private String _className;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private BigDecimal _amount;
/*     */   private String _applicationMethodCode;
/*     */   private String _calculationMethodCode;
/*     */   private String _description;
/*     */   private DtvDate _effectiveDatetime;
/*  38 */   private Boolean _exclusiveDiscount = Boolean.FALSE;
/*     */   private DtvDate _expirationDatetime;
/*     */   private Long _maximumTransactionCount;
/*     */   private BigDecimal _minimumEligiblePrice;
/*     */   private BigDecimal _percent;
/*     */   private String _prompt;
/*     */   private String _sound;
/*     */   private String _typeCode;
/*  46 */   private Boolean _serializedDiscount = Boolean.FALSE;
/*     */   private String _privilegeType;
/*     */   private String _taxabilityCode;
/*     */   private BigDecimal _maxDiscount;
/*     */   private BigDecimal _maxAmount;
/*     */   private BigDecimal _maxPercentage;
/*     */   private Integer _sortOrder;
/*  53 */   private Boolean _disallowChange = Boolean.FALSE;
/*     */   
/*     */   public String getDiscountCode() {
/*  56 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  60 */     if (changed(argDiscountCode, this._discountCode, "discountCode")) {
/*  61 */       this._discountCode = (argDiscountCode != null && MANAGE_CASE) ? argDiscountCode.toUpperCase() : argDiscountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  66 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  70 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  71 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getClassName() {
/*  76 */     return this._className;
/*     */   }
/*     */   
/*     */   public void setClassName(String argClassName) {
/*  80 */     if (changed(argClassName, this._className, "className")) {
/*  81 */       this._className = argClassName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  86 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  90 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  91 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  97 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 101 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 102 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 107 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 111 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 112 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 118 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 122 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 123 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/* 128 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 132 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/* 133 */       this._configElement = argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 138 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 142 */     if (changed(argAmount, this._amount, "amount")) {
/* 143 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApplicationMethodCode() {
/* 148 */     return this._applicationMethodCode;
/*     */   }
/*     */   
/*     */   public void setApplicationMethodCode(String argApplicationMethodCode) {
/* 152 */     if (changed(argApplicationMethodCode, this._applicationMethodCode, "applicationMethodCode")) {
/* 153 */       this._applicationMethodCode = argApplicationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCalculationMethodCode() {
/* 158 */     return this._calculationMethodCode;
/*     */   }
/*     */   
/*     */   public void setCalculationMethodCode(String argCalculationMethodCode) {
/* 162 */     if (changed(argCalculationMethodCode, this._calculationMethodCode, "calculationMethodCode")) {
/* 163 */       this._calculationMethodCode = argCalculationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 168 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 172 */     if (changed(argDescription, this._description, "description")) {
/* 173 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDatetime() {
/* 178 */     return (Date)this._effectiveDatetime;
/*     */   }
/*     */   
/*     */   public void setEffectiveDatetime(Date argEffectiveDatetime) {
/* 182 */     if (changed(argEffectiveDatetime, this._effectiveDatetime, "effectiveDatetime")) {
/* 183 */       this._effectiveDatetime = (argEffectiveDatetime == null || argEffectiveDatetime instanceof DtvDate) ? (DtvDate)argEffectiveDatetime : new DtvDate(argEffectiveDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getExclusiveDiscount() {
/* 189 */     return this._exclusiveDiscount;
/*     */   }
/*     */   
/*     */   public void setExclusiveDiscount(Boolean argExclusiveDiscount) {
/* 193 */     if (changed(argExclusiveDiscount, this._exclusiveDiscount, "exclusiveDiscount")) {
/* 194 */       this._exclusiveDiscount = argExclusiveDiscount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDatetime() {
/* 199 */     return (Date)this._expirationDatetime;
/*     */   }
/*     */   
/*     */   public void setExpirationDatetime(Date argExpirationDatetime) {
/* 203 */     if (changed(argExpirationDatetime, this._expirationDatetime, "expirationDatetime")) {
/* 204 */       this._expirationDatetime = (argExpirationDatetime == null || argExpirationDatetime instanceof DtvDate) ? (DtvDate)argExpirationDatetime : new DtvDate(argExpirationDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getMaximumTransactionCount() {
/* 210 */     return this._maximumTransactionCount;
/*     */   }
/*     */   
/*     */   public void setMaximumTransactionCount(Long argMaximumTransactionCount) {
/* 214 */     if (changed(argMaximumTransactionCount, this._maximumTransactionCount, "maximumTransactionCount")) {
/* 215 */       this._maximumTransactionCount = argMaximumTransactionCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinimumEligiblePrice() {
/* 220 */     return this._minimumEligiblePrice;
/*     */   }
/*     */   
/*     */   public void setMinimumEligiblePrice(BigDecimal argMinimumEligiblePrice) {
/* 224 */     if (changed(argMinimumEligiblePrice, this._minimumEligiblePrice, "minimumEligiblePrice")) {
/* 225 */       this._minimumEligiblePrice = argMinimumEligiblePrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPercent() {
/* 230 */     return this._percent;
/*     */   }
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/* 234 */     if (changed(argPercent, this._percent, "percent")) {
/* 235 */       this._percent = argPercent;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPrompt() {
/* 240 */     return this._prompt;
/*     */   }
/*     */   
/*     */   public void setPrompt(String argPrompt) {
/* 244 */     if (changed(argPrompt, this._prompt, "prompt")) {
/* 245 */       this._prompt = argPrompt;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSound() {
/* 250 */     return this._sound;
/*     */   }
/*     */   
/*     */   public void setSound(String argSound) {
/* 254 */     if (changed(argSound, this._sound, "sound")) {
/* 255 */       this._sound = argSound;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 260 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 264 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 265 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSerializedDiscount() {
/* 270 */     return this._serializedDiscount;
/*     */   }
/*     */   
/*     */   public void setSerializedDiscount(Boolean argSerializedDiscount) {
/* 274 */     if (changed(argSerializedDiscount, this._serializedDiscount, "serializedDiscount")) {
/* 275 */       this._serializedDiscount = argSerializedDiscount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPrivilegeType() {
/* 280 */     return this._privilegeType;
/*     */   }
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/* 284 */     if (changed(argPrivilegeType, this._privilegeType, "privilegeType")) {
/* 285 */       this._privilegeType = argPrivilegeType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxabilityCode() {
/* 290 */     return this._taxabilityCode;
/*     */   }
/*     */   
/*     */   public void setTaxabilityCode(String argTaxabilityCode) {
/* 294 */     if (changed(argTaxabilityCode, this._taxabilityCode, "taxabilityCode")) {
/* 295 */       this._taxabilityCode = argTaxabilityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaxDiscount() {
/* 300 */     return this._maxDiscount;
/*     */   }
/*     */   
/*     */   public void setMaxDiscount(BigDecimal argMaxDiscount) {
/* 304 */     if (changed(argMaxDiscount, this._maxDiscount, "maxDiscount")) {
/* 305 */       this._maxDiscount = argMaxDiscount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaxAmount() {
/* 310 */     return this._maxAmount;
/*     */   }
/*     */   
/*     */   public void setMaxAmount(BigDecimal argMaxAmount) {
/* 314 */     if (changed(argMaxAmount, this._maxAmount, "maxAmount")) {
/* 315 */       this._maxAmount = argMaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaxPercentage() {
/* 320 */     return this._maxPercentage;
/*     */   }
/*     */   
/*     */   public void setMaxPercentage(BigDecimal argMaxPercentage) {
/* 324 */     if (changed(argMaxPercentage, this._maxPercentage, "maxPercentage")) {
/* 325 */       this._maxPercentage = argMaxPercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 330 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 334 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 335 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDisallowChange() {
/* 340 */     return this._disallowChange;
/*     */   }
/*     */   
/*     */   public void setDisallowChange(Boolean argDisallowChange) {
/* 344 */     if (changed(argDisallowChange, this._disallowChange, "disallowChange")) {
/* 345 */       this._disallowChange = argDisallowChange;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 352 */     StringBuilder buf = new StringBuilder(512);
/* 353 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 354 */     if (getDiscountCode() != null) {
/* 355 */       buf.append("discountCode").append("=").append(getDiscountCode()).append(" ");
/*     */     }
/* 357 */     if (getOrganizationId() != null) {
/* 358 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 360 */     if (getClassName() != null) {
/* 361 */       buf.append("className").append("=").append(getClassName()).append(" ");
/*     */     }
/* 363 */     if (getCreateDate() != null) {
/* 364 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 366 */     if (getCreateUserId() != null) {
/* 367 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 369 */     if (getUpdateDate() != null) {
/* 370 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 372 */     if (getUpdateUserId() != null) {
/* 373 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 375 */     if (getConfigElement() != null) {
/* 376 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 378 */     if (getAmount() != null) {
/* 379 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 381 */     if (getApplicationMethodCode() != null) {
/* 382 */       buf.append("applicationMethodCode").append("=").append(getApplicationMethodCode()).append(" ");
/*     */     }
/* 384 */     if (getCalculationMethodCode() != null) {
/* 385 */       buf.append("calculationMethodCode").append("=").append(getCalculationMethodCode()).append(" ");
/*     */     }
/* 387 */     if (getDescription() != null) {
/* 388 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 390 */     if (getEffectiveDatetime() != null) {
/* 391 */       buf.append("effectiveDatetime").append("=").append(getEffectiveDatetime()).append(" ");
/*     */     }
/* 393 */     if (getExclusiveDiscount() != null && getExclusiveDiscount().booleanValue()) {
/* 394 */       buf.append("exclusiveDiscount").append("=").append(getExclusiveDiscount()).append(" ");
/*     */     }
/* 396 */     if (getExpirationDatetime() != null) {
/* 397 */       buf.append("expirationDatetime").append("=").append(getExpirationDatetime()).append(" ");
/*     */     }
/* 399 */     if (getMaximumTransactionCount() != null) {
/* 400 */       buf.append("maximumTransactionCount").append("=").append(getMaximumTransactionCount()).append(" ");
/*     */     }
/* 402 */     if (getMinimumEligiblePrice() != null) {
/* 403 */       buf.append("minimumEligiblePrice").append("=").append(getMinimumEligiblePrice()).append(" ");
/*     */     }
/* 405 */     if (getPercent() != null) {
/* 406 */       buf.append("percent").append("=").append(getPercent()).append(" ");
/*     */     }
/* 408 */     if (getPrompt() != null) {
/* 409 */       buf.append("prompt").append("=").append(getPrompt()).append(" ");
/*     */     }
/* 411 */     if (getSound() != null) {
/* 412 */       buf.append("sound").append("=").append(getSound()).append(" ");
/*     */     }
/* 414 */     if (getTypeCode() != null) {
/* 415 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 417 */     if (getSerializedDiscount() != null && getSerializedDiscount().booleanValue()) {
/* 418 */       buf.append("serializedDiscount").append("=").append(getSerializedDiscount()).append(" ");
/*     */     }
/* 420 */     if (getPrivilegeType() != null) {
/* 421 */       buf.append("privilegeType").append("=").append(getPrivilegeType()).append(" ");
/*     */     }
/* 423 */     if (getTaxabilityCode() != null) {
/* 424 */       buf.append("taxabilityCode").append("=").append(getTaxabilityCode()).append(" ");
/*     */     }
/* 426 */     if (getMaxDiscount() != null) {
/* 427 */       buf.append("maxDiscount").append("=").append(getMaxDiscount()).append(" ");
/*     */     }
/* 429 */     if (getMaxAmount() != null) {
/* 430 */       buf.append("maxAmount").append("=").append(getMaxAmount()).append(" ");
/*     */     }
/* 432 */     if (getMaxPercentage() != null) {
/* 433 */       buf.append("maxPercentage").append("=").append(getMaxPercentage()).append(" ");
/*     */     }
/* 435 */     if (getSortOrder() != null) {
/* 436 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 438 */     if (getDisallowChange() != null && getDisallowChange().booleanValue()) {
/* 439 */       buf.append("disallowChange").append("=").append(getDisallowChange()).append(" ");
/*     */     }
/*     */     
/* 442 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 446 */     DiscountId id = new DiscountId();
/* 447 */     id.setDiscountCode(getDiscountCode());
/* 448 */     id.setOrganizationId(getOrganizationId());
/* 449 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 453 */     setDiscountCode(((DiscountId)argObjectId).getDiscountCode());
/* 454 */     setOrganizationId(((DiscountId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 458 */     return this._className;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 462 */     StringBuilder buf = new StringBuilder(1450);
/* 463 */     buf.append("<").append("dao").append(" name=\"Discount\" cmd=\"" + getObjectStateString() + "\">");
/* 464 */     getFieldsAsXml(buf);
/* 465 */     buf.append("</").append("dao").append(">");
/*     */     
/* 467 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 471 */     Map<String, String> values = super.getValues();
/* 472 */     if (this._discountCode != null) values.put("DiscountCode", DaoUtils.getXmlSafeFieldValue(12, this._discountCode)); 
/* 473 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 474 */     if (this._className != null) values.put("ClassName", DaoUtils.getXmlSafeFieldValue(12, this._className)); 
/* 475 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 476 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 477 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 478 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 479 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 480 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 481 */     if (this._applicationMethodCode != null) values.put("ApplicationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._applicationMethodCode)); 
/* 482 */     if (this._calculationMethodCode != null) values.put("CalculationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._calculationMethodCode)); 
/* 483 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 484 */     if (this._effectiveDatetime != null) values.put("EffectiveDatetime", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDatetime)); 
/* 485 */     if (this._exclusiveDiscount != null) values.put("ExclusiveDiscount", DaoUtils.getXmlSafeFieldValue(-7, this._exclusiveDiscount)); 
/* 486 */     if (this._expirationDatetime != null) values.put("ExpirationDatetime", DaoUtils.getXmlSafeFieldValue(91, this._expirationDatetime)); 
/* 487 */     if (this._maximumTransactionCount != null) values.put("MaximumTransactionCount", DaoUtils.getXmlSafeFieldValue(-5, this._maximumTransactionCount)); 
/* 488 */     if (this._minimumEligiblePrice != null) values.put("MinimumEligiblePrice", DaoUtils.getXmlSafeFieldValue(3, this._minimumEligiblePrice)); 
/* 489 */     if (this._percent != null) values.put("Percent", DaoUtils.getXmlSafeFieldValue(3, this._percent)); 
/* 490 */     if (this._prompt != null) values.put("Prompt", DaoUtils.getXmlSafeFieldValue(12, this._prompt)); 
/* 491 */     if (this._sound != null) values.put("Sound", DaoUtils.getXmlSafeFieldValue(12, this._sound)); 
/* 492 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 493 */     if (this._serializedDiscount != null) values.put("SerializedDiscount", DaoUtils.getXmlSafeFieldValue(-7, this._serializedDiscount)); 
/* 494 */     if (this._privilegeType != null) values.put("PrivilegeType", DaoUtils.getXmlSafeFieldValue(12, this._privilegeType)); 
/* 495 */     if (this._taxabilityCode != null) values.put("TaxabilityCode", DaoUtils.getXmlSafeFieldValue(12, this._taxabilityCode)); 
/* 496 */     if (this._maxDiscount != null) values.put("MaxDiscount", DaoUtils.getXmlSafeFieldValue(3, this._maxDiscount)); 
/* 497 */     if (this._maxAmount != null) values.put("MaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._maxAmount)); 
/* 498 */     if (this._maxPercentage != null) values.put("MaxPercentage", DaoUtils.getXmlSafeFieldValue(3, this._maxPercentage)); 
/* 499 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 500 */     if (this._disallowChange != null) values.put("DisallowChange", DaoUtils.getXmlSafeFieldValue(-7, this._disallowChange)); 
/* 501 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 506 */     super.setValues(argValues);
/* 507 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 509 */       String fieldName = field.getKey();
/* 510 */       String fieldValue = field.getValue();
/* 511 */       switch (fieldName) {
/*     */         
/*     */         case "DiscountCode":
/*     */           try {
/* 515 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 516 */             setDiscountCode((String)value);
/* 517 */           } catch (Exception ee) {
/* 518 */             throw new DtxException("An exception occurred while calling setDiscountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 524 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 525 */             setOrganizationId((Long)value);
/* 526 */           } catch (Exception ee) {
/* 527 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClassName":
/*     */           try {
/* 533 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 534 */             setClassName((String)value);
/* 535 */           } catch (Exception ee) {
/* 536 */             throw new DtxException("An exception occurred while calling setClassName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 542 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 543 */             setCreateDate((Date)value);
/* 544 */           } catch (Exception ee) {
/* 545 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 551 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 552 */             setCreateUserId((String)value);
/* 553 */           } catch (Exception ee) {
/* 554 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 560 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 561 */             setUpdateDate((Date)value);
/* 562 */           } catch (Exception ee) {
/* 563 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 569 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 570 */             setUpdateUserId((String)value);
/* 571 */           } catch (Exception ee) {
/* 572 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 578 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 579 */             setConfigElement((String)value);
/* 580 */           } catch (Exception ee) {
/* 581 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 587 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 588 */             setAmount((BigDecimal)value);
/* 589 */           } catch (Exception ee) {
/* 590 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ApplicationMethodCode":
/*     */           try {
/* 596 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 597 */             setApplicationMethodCode((String)value);
/* 598 */           } catch (Exception ee) {
/* 599 */             throw new DtxException("An exception occurred while calling setApplicationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CalculationMethodCode":
/*     */           try {
/* 605 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 606 */             setCalculationMethodCode((String)value);
/* 607 */           } catch (Exception ee) {
/* 608 */             throw new DtxException("An exception occurred while calling setCalculationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 614 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 615 */             setDescription((String)value);
/* 616 */           } catch (Exception ee) {
/* 617 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDatetime":
/*     */           try {
/* 623 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 624 */             setEffectiveDatetime((Date)value);
/* 625 */           } catch (Exception ee) {
/* 626 */             throw new DtxException("An exception occurred while calling setEffectiveDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExclusiveDiscount":
/*     */           try {
/* 632 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 633 */             setExclusiveDiscount((Boolean)value);
/* 634 */           } catch (Exception ee) {
/* 635 */             throw new DtxException("An exception occurred while calling setExclusiveDiscount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDatetime":
/*     */           try {
/* 641 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 642 */             setExpirationDatetime((Date)value);
/* 643 */           } catch (Exception ee) {
/* 644 */             throw new DtxException("An exception occurred while calling setExpirationDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumTransactionCount":
/*     */           try {
/* 650 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 651 */             setMaximumTransactionCount((Long)value);
/* 652 */           } catch (Exception ee) {
/* 653 */             throw new DtxException("An exception occurred while calling setMaximumTransactionCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumEligiblePrice":
/*     */           try {
/* 659 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 660 */             setMinimumEligiblePrice((BigDecimal)value);
/* 661 */           } catch (Exception ee) {
/* 662 */             throw new DtxException("An exception occurred while calling setMinimumEligiblePrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Percent":
/*     */           try {
/* 668 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 669 */             setPercent((BigDecimal)value);
/* 670 */           } catch (Exception ee) {
/* 671 */             throw new DtxException("An exception occurred while calling setPercent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Prompt":
/*     */           try {
/* 677 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 678 */             setPrompt((String)value);
/* 679 */           } catch (Exception ee) {
/* 680 */             throw new DtxException("An exception occurred while calling setPrompt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sound":
/*     */           try {
/* 686 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 687 */             setSound((String)value);
/* 688 */           } catch (Exception ee) {
/* 689 */             throw new DtxException("An exception occurred while calling setSound() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 695 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 696 */             setTypeCode((String)value);
/* 697 */           } catch (Exception ee) {
/* 698 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerializedDiscount":
/*     */           try {
/* 704 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 705 */             setSerializedDiscount((Boolean)value);
/* 706 */           } catch (Exception ee) {
/* 707 */             throw new DtxException("An exception occurred while calling setSerializedDiscount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PrivilegeType":
/*     */           try {
/* 713 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 714 */             setPrivilegeType((String)value);
/* 715 */           } catch (Exception ee) {
/* 716 */             throw new DtxException("An exception occurred while calling setPrivilegeType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxabilityCode":
/*     */           try {
/* 722 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 723 */             setTaxabilityCode((String)value);
/* 724 */           } catch (Exception ee) {
/* 725 */             throw new DtxException("An exception occurred while calling setTaxabilityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxDiscount":
/*     */           try {
/* 731 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 732 */             setMaxDiscount((BigDecimal)value);
/* 733 */           } catch (Exception ee) {
/* 734 */             throw new DtxException("An exception occurred while calling setMaxDiscount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxAmount":
/*     */           try {
/* 740 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 741 */             setMaxAmount((BigDecimal)value);
/* 742 */           } catch (Exception ee) {
/* 743 */             throw new DtxException("An exception occurred while calling setMaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxPercentage":
/*     */           try {
/* 749 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 750 */             setMaxPercentage((BigDecimal)value);
/* 751 */           } catch (Exception ee) {
/* 752 */             throw new DtxException("An exception occurred while calling setMaxPercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 758 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 759 */             setSortOrder((Integer)value);
/* 760 */           } catch (Exception ee) {
/* 761 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisallowChange":
/*     */           try {
/* 767 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 768 */             setDisallowChange((Boolean)value);
/* 769 */           } catch (Exception ee) {
/* 770 */             throw new DtxException("An exception occurred while calling setDisallowChange() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */