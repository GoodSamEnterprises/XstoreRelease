/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.prc.DealId;
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
/*     */ public class DealDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2125964L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DealDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*  34 */   private Boolean _consumable = Boolean.FALSE;
/*  35 */   private Boolean _deferred = Boolean.FALSE;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _endDate;
/*     */   private DtvDate _startTime;
/*     */   private DtvDate _endTime;
/*     */   private BigDecimal _generosityCap;
/*     */   private Integer _iterationCap;
/*     */   private Integer _priorityNudge;
/*     */   private BigDecimal _minimumSubtotal;
/*     */   private BigDecimal _maximumSubtotal;
/*     */   private String _transActionType;
/*     */   private BigDecimal _transActionAmount;
/*     */   private String _taxabilityCode;
/*  48 */   private Boolean _higherNonactionAmt = Boolean.FALSE;
/*  49 */   private Boolean _excludePriceOverride = Boolean.FALSE;
/*  50 */   private Boolean _excludeDiscounted = Boolean.FALSE;
/*  51 */   private Boolean _useWeekSchedule = Boolean.FALSE;
/*  52 */   private Boolean _targeted = Boolean.FALSE;
/*     */   private String _promotionId;
/*     */   private Integer _sortOrder;
/*     */   private String _type;
/*     */   private String _groupId;
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
/*     */   public String getDealId() {
/*  69 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  73 */     if (changed(argDealId, this._dealId, "dealId")) {
/*  74 */       this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  79 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  83 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  84 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  89 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  93 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  94 */       this._orgValue = argOrgValue;
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
/*     */   public String getDescription() {
/* 141 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 145 */     if (changed(argDescription, this._description, "description")) {
/* 146 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getConsumable() {
/* 151 */     return this._consumable;
/*     */   }
/*     */   
/*     */   public void setConsumable(Boolean argConsumable) {
/* 155 */     if (changed(argConsumable, this._consumable, "consumable")) {
/* 156 */       this._consumable = argConsumable;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDeferred() {
/* 161 */     return this._deferred;
/*     */   }
/*     */   
/*     */   public void setDeferred(Boolean argDeferred) {
/* 165 */     if (changed(argDeferred, this._deferred, "deferred")) {
/* 166 */       this._deferred = argDeferred;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 171 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 175 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 176 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 182 */     return (Date)this._endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 186 */     if (changed(argEndDate, this._endDate, "endDate")) {
/* 187 */       this._endDate = (argEndDate == null || argEndDate instanceof DtvDate) ? (DtvDate)argEndDate : new DtvDate(argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/* 193 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 197 */     if (changed(argStartTime, this._startTime, "startTime")) {
/* 198 */       this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 204 */     return (Date)this._endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 208 */     if (changed(argEndTime, this._endTime, "endTime")) {
/* 209 */       this._endTime = (argEndTime == null || argEndTime instanceof DtvDate) ? (DtvDate)argEndTime : new DtvDate(argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getGenerosityCap() {
/* 215 */     return this._generosityCap;
/*     */   }
/*     */   
/*     */   public void setGenerosityCap(BigDecimal argGenerosityCap) {
/* 219 */     if (changed(argGenerosityCap, this._generosityCap, "generosityCap")) {
/* 220 */       this._generosityCap = argGenerosityCap;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getIterationCap() {
/* 225 */     return this._iterationCap;
/*     */   }
/*     */   
/*     */   public void setIterationCap(Integer argIterationCap) {
/* 229 */     if (changed(argIterationCap, this._iterationCap, "iterationCap")) {
/* 230 */       this._iterationCap = argIterationCap;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getPriorityNudge() {
/* 235 */     return this._priorityNudge;
/*     */   }
/*     */   
/*     */   public void setPriorityNudge(Integer argPriorityNudge) {
/* 239 */     if (changed(argPriorityNudge, this._priorityNudge, "priorityNudge")) {
/* 240 */       this._priorityNudge = argPriorityNudge;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinimumSubtotal() {
/* 245 */     return this._minimumSubtotal;
/*     */   }
/*     */   
/*     */   public void setMinimumSubtotal(BigDecimal argMinimumSubtotal) {
/* 249 */     if (changed(argMinimumSubtotal, this._minimumSubtotal, "minimumSubtotal")) {
/* 250 */       this._minimumSubtotal = argMinimumSubtotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaximumSubtotal() {
/* 255 */     return this._maximumSubtotal;
/*     */   }
/*     */   
/*     */   public void setMaximumSubtotal(BigDecimal argMaximumSubtotal) {
/* 259 */     if (changed(argMaximumSubtotal, this._maximumSubtotal, "maximumSubtotal")) {
/* 260 */       this._maximumSubtotal = argMaximumSubtotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTransActionType() {
/* 265 */     return this._transActionType;
/*     */   }
/*     */   
/*     */   public void setTransActionType(String argTransActionType) {
/* 269 */     if (changed(argTransActionType, this._transActionType, "transActionType")) {
/* 270 */       this._transActionType = argTransActionType;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTransActionAmount() {
/* 275 */     return this._transActionAmount;
/*     */   }
/*     */   
/*     */   public void setTransActionAmount(BigDecimal argTransActionAmount) {
/* 279 */     if (changed(argTransActionAmount, this._transActionAmount, "transActionAmount")) {
/* 280 */       this._transActionAmount = argTransActionAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxabilityCode() {
/* 285 */     return this._taxabilityCode;
/*     */   }
/*     */   
/*     */   public void setTaxabilityCode(String argTaxabilityCode) {
/* 289 */     if (changed(argTaxabilityCode, this._taxabilityCode, "taxabilityCode")) {
/* 290 */       this._taxabilityCode = argTaxabilityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getHigherNonactionAmt() {
/* 295 */     return this._higherNonactionAmt;
/*     */   }
/*     */   
/*     */   public void setHigherNonactionAmt(Boolean argHigherNonactionAmt) {
/* 299 */     if (changed(argHigherNonactionAmt, this._higherNonactionAmt, "higherNonactionAmt")) {
/* 300 */       this._higherNonactionAmt = argHigherNonactionAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getExcludePriceOverride() {
/* 305 */     return this._excludePriceOverride;
/*     */   }
/*     */   
/*     */   public void setExcludePriceOverride(Boolean argExcludePriceOverride) {
/* 309 */     if (changed(argExcludePriceOverride, this._excludePriceOverride, "excludePriceOverride")) {
/* 310 */       this._excludePriceOverride = argExcludePriceOverride;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getExcludeDiscounted() {
/* 315 */     return this._excludeDiscounted;
/*     */   }
/*     */   
/*     */   public void setExcludeDiscounted(Boolean argExcludeDiscounted) {
/* 319 */     if (changed(argExcludeDiscounted, this._excludeDiscounted, "excludeDiscounted")) {
/* 320 */       this._excludeDiscounted = argExcludeDiscounted;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getUseWeekSchedule() {
/* 325 */     return this._useWeekSchedule;
/*     */   }
/*     */   
/*     */   public void setUseWeekSchedule(Boolean argUseWeekSchedule) {
/* 329 */     if (changed(argUseWeekSchedule, this._useWeekSchedule, "useWeekSchedule")) {
/* 330 */       this._useWeekSchedule = argUseWeekSchedule;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getTargeted() {
/* 335 */     return this._targeted;
/*     */   }
/*     */   
/*     */   public void setTargeted(Boolean argTargeted) {
/* 339 */     if (changed(argTargeted, this._targeted, "targeted")) {
/* 340 */       this._targeted = argTargeted;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromotionId() {
/* 345 */     return this._promotionId;
/*     */   }
/*     */   
/*     */   public void setPromotionId(String argPromotionId) {
/* 349 */     if (changed(argPromotionId, this._promotionId, "promotionId")) {
/* 350 */       this._promotionId = argPromotionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 355 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 359 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 360 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 365 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 369 */     if (changed(argType, this._type, "type")) {
/* 370 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGroupId() {
/* 375 */     return this._groupId;
/*     */   }
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/* 379 */     if (changed(argGroupId, this._groupId, "groupId")) {
/* 380 */       this._groupId = argGroupId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 387 */     StringBuilder buf = new StringBuilder(512);
/* 388 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 389 */     if (getOrganizationId() != null) {
/* 390 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 392 */     if (getDealId() != null) {
/* 393 */       buf.append("dealId").append("=").append(getDealId()).append(" ");
/*     */     }
/* 395 */     if (getOrgCode() != null) {
/* 396 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 398 */     if (getOrgValue() != null) {
/* 399 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 401 */     if (getCreateDate() != null) {
/* 402 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 404 */     if (getCreateUserId() != null) {
/* 405 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 407 */     if (getUpdateDate() != null) {
/* 408 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 410 */     if (getUpdateUserId() != null) {
/* 411 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 413 */     if (getDescription() != null) {
/* 414 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 416 */     if (getConsumable() != null && getConsumable().booleanValue()) {
/* 417 */       buf.append("consumable").append("=").append(getConsumable()).append(" ");
/*     */     }
/* 419 */     if (getDeferred() != null && getDeferred().booleanValue()) {
/* 420 */       buf.append("deferred").append("=").append(getDeferred()).append(" ");
/*     */     }
/* 422 */     if (getEffectiveDate() != null) {
/* 423 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 425 */     if (getEndDate() != null) {
/* 426 */       buf.append("endDate").append("=").append(getEndDate()).append(" ");
/*     */     }
/* 428 */     if (getStartTime() != null) {
/* 429 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 431 */     if (getEndTime() != null) {
/* 432 */       buf.append("endTime").append("=").append(getEndTime()).append(" ");
/*     */     }
/* 434 */     if (getGenerosityCap() != null) {
/* 435 */       buf.append("generosityCap").append("=").append(getGenerosityCap()).append(" ");
/*     */     }
/* 437 */     if (getIterationCap() != null) {
/* 438 */       buf.append("iterationCap").append("=").append(getIterationCap()).append(" ");
/*     */     }
/* 440 */     if (getPriorityNudge() != null) {
/* 441 */       buf.append("priorityNudge").append("=").append(getPriorityNudge()).append(" ");
/*     */     }
/* 443 */     if (getMinimumSubtotal() != null) {
/* 444 */       buf.append("minimumSubtotal").append("=").append(getMinimumSubtotal()).append(" ");
/*     */     }
/* 446 */     if (getMaximumSubtotal() != null) {
/* 447 */       buf.append("maximumSubtotal").append("=").append(getMaximumSubtotal()).append(" ");
/*     */     }
/* 449 */     if (getTransActionType() != null) {
/* 450 */       buf.append("transActionType").append("=").append(getTransActionType()).append(" ");
/*     */     }
/* 452 */     if (getTransActionAmount() != null) {
/* 453 */       buf.append("transActionAmount").append("=").append(getTransActionAmount()).append(" ");
/*     */     }
/* 455 */     if (getTaxabilityCode() != null) {
/* 456 */       buf.append("taxabilityCode").append("=").append(getTaxabilityCode()).append(" ");
/*     */     }
/* 458 */     if (getHigherNonactionAmt() != null && getHigherNonactionAmt().booleanValue()) {
/* 459 */       buf.append("higherNonactionAmt").append("=").append(getHigherNonactionAmt()).append(" ");
/*     */     }
/* 461 */     if (getExcludePriceOverride() != null && getExcludePriceOverride().booleanValue()) {
/* 462 */       buf.append("excludePriceOverride").append("=").append(getExcludePriceOverride()).append(" ");
/*     */     }
/* 464 */     if (getExcludeDiscounted() != null && getExcludeDiscounted().booleanValue()) {
/* 465 */       buf.append("excludeDiscounted").append("=").append(getExcludeDiscounted()).append(" ");
/*     */     }
/* 467 */     if (getUseWeekSchedule() != null && getUseWeekSchedule().booleanValue()) {
/* 468 */       buf.append("useWeekSchedule").append("=").append(getUseWeekSchedule()).append(" ");
/*     */     }
/* 470 */     if (getTargeted() != null && getTargeted().booleanValue()) {
/* 471 */       buf.append("targeted").append("=").append(getTargeted()).append(" ");
/*     */     }
/* 473 */     if (getPromotionId() != null) {
/* 474 */       buf.append("promotionId").append("=").append(getPromotionId()).append(" ");
/*     */     }
/* 476 */     if (getSortOrder() != null) {
/* 477 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 479 */     if (getType() != null) {
/* 480 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 482 */     if (getGroupId() != null) {
/* 483 */       buf.append("groupId").append("=").append(getGroupId()).append(" ");
/*     */     }
/*     */     
/* 486 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 490 */     DealId id = new DealId();
/* 491 */     id.setOrganizationId(getOrganizationId());
/* 492 */     id.setDealId(getDealId());
/* 493 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 497 */     setOrganizationId(((DealId)argObjectId).getOrganizationId());
/* 498 */     setDealId(((DealId)argObjectId).getDealId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 502 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 506 */     StringBuilder buf = new StringBuilder(1600);
/* 507 */     buf.append("<").append("dao").append(" name=\"Deal\" cmd=\"" + getObjectStateString() + "\">");
/* 508 */     getFieldsAsXml(buf);
/* 509 */     buf.append("</").append("dao").append(">");
/*     */     
/* 511 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 515 */     Map<String, String> values = super.getValues();
/* 516 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 517 */     if (this._dealId != null) values.put("DealId", DaoUtils.getXmlSafeFieldValue(12, this._dealId)); 
/* 518 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 519 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 520 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 521 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 522 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 523 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 524 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 525 */     if (this._consumable != null) values.put("Consumable", DaoUtils.getXmlSafeFieldValue(-7, this._consumable)); 
/* 526 */     if (this._deferred != null) values.put("Deferred", DaoUtils.getXmlSafeFieldValue(-7, this._deferred)); 
/* 527 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 528 */     if (this._endDate != null) values.put("EndDate", DaoUtils.getXmlSafeFieldValue(91, this._endDate)); 
/* 529 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 530 */     if (this._endTime != null) values.put("EndTime", DaoUtils.getXmlSafeFieldValue(91, this._endTime)); 
/* 531 */     if (this._generosityCap != null) values.put("GenerosityCap", DaoUtils.getXmlSafeFieldValue(3, this._generosityCap)); 
/* 532 */     if (this._iterationCap != null) values.put("IterationCap", DaoUtils.getXmlSafeFieldValue(4, this._iterationCap)); 
/* 533 */     if (this._priorityNudge != null) values.put("PriorityNudge", DaoUtils.getXmlSafeFieldValue(4, this._priorityNudge)); 
/* 534 */     if (this._minimumSubtotal != null) values.put("MinimumSubtotal", DaoUtils.getXmlSafeFieldValue(3, this._minimumSubtotal)); 
/* 535 */     if (this._maximumSubtotal != null) values.put("MaximumSubtotal", DaoUtils.getXmlSafeFieldValue(3, this._maximumSubtotal)); 
/* 536 */     if (this._transActionType != null) values.put("TransActionType", DaoUtils.getXmlSafeFieldValue(12, this._transActionType)); 
/* 537 */     if (this._transActionAmount != null) values.put("TransActionAmount", DaoUtils.getXmlSafeFieldValue(3, this._transActionAmount)); 
/* 538 */     if (this._taxabilityCode != null) values.put("TaxabilityCode", DaoUtils.getXmlSafeFieldValue(12, this._taxabilityCode)); 
/* 539 */     if (this._higherNonactionAmt != null) values.put("HigherNonactionAmt", DaoUtils.getXmlSafeFieldValue(-7, this._higherNonactionAmt)); 
/* 540 */     if (this._excludePriceOverride != null) values.put("ExcludePriceOverride", DaoUtils.getXmlSafeFieldValue(-7, this._excludePriceOverride)); 
/* 541 */     if (this._excludeDiscounted != null) values.put("ExcludeDiscounted", DaoUtils.getXmlSafeFieldValue(-7, this._excludeDiscounted)); 
/* 542 */     if (this._useWeekSchedule != null) values.put("UseWeekSchedule", DaoUtils.getXmlSafeFieldValue(-7, this._useWeekSchedule)); 
/* 543 */     if (this._targeted != null) values.put("Targeted", DaoUtils.getXmlSafeFieldValue(-7, this._targeted)); 
/* 544 */     if (this._promotionId != null) values.put("PromotionId", DaoUtils.getXmlSafeFieldValue(12, this._promotionId)); 
/* 545 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 546 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 547 */     if (this._groupId != null) values.put("GroupId", DaoUtils.getXmlSafeFieldValue(12, this._groupId)); 
/* 548 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 553 */     super.setValues(argValues);
/* 554 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 556 */       String fieldName = field.getKey();
/* 557 */       String fieldValue = field.getValue();
/* 558 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 562 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 563 */             setOrganizationId((Long)value);
/* 564 */           } catch (Exception ee) {
/* 565 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DealId":
/*     */           try {
/* 571 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 572 */             setDealId((String)value);
/* 573 */           } catch (Exception ee) {
/* 574 */             throw new DtxException("An exception occurred while calling setDealId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 580 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 581 */             setOrgCode((String)value);
/* 582 */           } catch (Exception ee) {
/* 583 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 589 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 590 */             setOrgValue((String)value);
/* 591 */           } catch (Exception ee) {
/* 592 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 598 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 599 */             setCreateDate((Date)value);
/* 600 */           } catch (Exception ee) {
/* 601 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 607 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 608 */             setCreateUserId((String)value);
/* 609 */           } catch (Exception ee) {
/* 610 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 616 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 617 */             setUpdateDate((Date)value);
/* 618 */           } catch (Exception ee) {
/* 619 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 625 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 626 */             setUpdateUserId((String)value);
/* 627 */           } catch (Exception ee) {
/* 628 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 634 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 635 */             setDescription((String)value);
/* 636 */           } catch (Exception ee) {
/* 637 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Consumable":
/*     */           try {
/* 643 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 644 */             setConsumable((Boolean)value);
/* 645 */           } catch (Exception ee) {
/* 646 */             throw new DtxException("An exception occurred while calling setConsumable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Deferred":
/*     */           try {
/* 652 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 653 */             setDeferred((Boolean)value);
/* 654 */           } catch (Exception ee) {
/* 655 */             throw new DtxException("An exception occurred while calling setDeferred() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 661 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 662 */             setEffectiveDate((Date)value);
/* 663 */           } catch (Exception ee) {
/* 664 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDate":
/*     */           try {
/* 670 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 671 */             setEndDate((Date)value);
/* 672 */           } catch (Exception ee) {
/* 673 */             throw new DtxException("An exception occurred while calling setEndDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 679 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 680 */             setStartTime((Date)value);
/* 681 */           } catch (Exception ee) {
/* 682 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTime":
/*     */           try {
/* 688 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 689 */             setEndTime((Date)value);
/* 690 */           } catch (Exception ee) {
/* 691 */             throw new DtxException("An exception occurred while calling setEndTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GenerosityCap":
/*     */           try {
/* 697 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 698 */             setGenerosityCap((BigDecimal)value);
/* 699 */           } catch (Exception ee) {
/* 700 */             throw new DtxException("An exception occurred while calling setGenerosityCap() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IterationCap":
/*     */           try {
/* 706 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 707 */             setIterationCap((Integer)value);
/* 708 */           } catch (Exception ee) {
/* 709 */             throw new DtxException("An exception occurred while calling setIterationCap() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriorityNudge":
/*     */           try {
/* 715 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 716 */             setPriorityNudge((Integer)value);
/* 717 */           } catch (Exception ee) {
/* 718 */             throw new DtxException("An exception occurred while calling setPriorityNudge() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumSubtotal":
/*     */           try {
/* 724 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 725 */             setMinimumSubtotal((BigDecimal)value);
/* 726 */           } catch (Exception ee) {
/* 727 */             throw new DtxException("An exception occurred while calling setMinimumSubtotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumSubtotal":
/*     */           try {
/* 733 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 734 */             setMaximumSubtotal((BigDecimal)value);
/* 735 */           } catch (Exception ee) {
/* 736 */             throw new DtxException("An exception occurred while calling setMaximumSubtotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransActionType":
/*     */           try {
/* 742 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 743 */             setTransActionType((String)value);
/* 744 */           } catch (Exception ee) {
/* 745 */             throw new DtxException("An exception occurred while calling setTransActionType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransActionAmount":
/*     */           try {
/* 751 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 752 */             setTransActionAmount((BigDecimal)value);
/* 753 */           } catch (Exception ee) {
/* 754 */             throw new DtxException("An exception occurred while calling setTransActionAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxabilityCode":
/*     */           try {
/* 760 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 761 */             setTaxabilityCode((String)value);
/* 762 */           } catch (Exception ee) {
/* 763 */             throw new DtxException("An exception occurred while calling setTaxabilityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "HigherNonactionAmt":
/*     */           try {
/* 769 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 770 */             setHigherNonactionAmt((Boolean)value);
/* 771 */           } catch (Exception ee) {
/* 772 */             throw new DtxException("An exception occurred while calling setHigherNonactionAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExcludePriceOverride":
/*     */           try {
/* 778 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 779 */             setExcludePriceOverride((Boolean)value);
/* 780 */           } catch (Exception ee) {
/* 781 */             throw new DtxException("An exception occurred while calling setExcludePriceOverride() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExcludeDiscounted":
/*     */           try {
/* 787 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 788 */             setExcludeDiscounted((Boolean)value);
/* 789 */           } catch (Exception ee) {
/* 790 */             throw new DtxException("An exception occurred while calling setExcludeDiscounted() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UseWeekSchedule":
/*     */           try {
/* 796 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 797 */             setUseWeekSchedule((Boolean)value);
/* 798 */           } catch (Exception ee) {
/* 799 */             throw new DtxException("An exception occurred while calling setUseWeekSchedule() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Targeted":
/*     */           try {
/* 805 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 806 */             setTargeted((Boolean)value);
/* 807 */           } catch (Exception ee) {
/* 808 */             throw new DtxException("An exception occurred while calling setTargeted() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromotionId":
/*     */           try {
/* 814 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 815 */             setPromotionId((String)value);
/* 816 */           } catch (Exception ee) {
/* 817 */             throw new DtxException("An exception occurred while calling setPromotionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 823 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 824 */             setSortOrder((Integer)value);
/* 825 */           } catch (Exception ee) {
/* 826 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 832 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 833 */             setType((String)value);
/* 834 */           } catch (Exception ee) {
/* 835 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GroupId":
/*     */           try {
/* 841 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 842 */             setGroupId((String)value);
/* 843 */           } catch (Exception ee) {
/* 844 */             throw new DtxException("An exception occurred while calling setGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */