/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.SaleTaxModifierId;
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
/*     */ public class SaleTaxModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 698796219L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SaleTaxModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Integer _saleTaxModifierSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _taxPercentage;
/*     */   private BigDecimal _rawTaxAmount;
/*     */   private BigDecimal _rawTaxPercentage;
/*     */   private BigDecimal _exemptTaxAmount;
/*     */   private BigDecimal _taxExemptAmount;
/*     */   private String _taxExemptionId;
/*     */   private BigDecimal _taxOverrideAmount;
/*  44 */   private Boolean _taxOverride = Boolean.FALSE;
/*     */   private BigDecimal _taxOverridePercentage;
/*     */   private String _taxOverrideReasonCode;
/*     */   private String _taxOverrideComment;
/*     */   private BigDecimal _taxableAmount;
/*  49 */   private Boolean _void = Boolean.FALSE;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRuleSequence;
/*     */   private String _authorityId;
/*     */   private String _authorityName;
/*     */   private String _authorityTypeCode;
/*     */   private String _taxOverrideBracket;
/*     */   private BigDecimal _origTaxableAmount;
/*     */   private String _origTaxGroupId;
/*     */   
/*     */   public Date getBusinessDate() {
/*  61 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  65 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  66 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  72 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  76 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  77 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  82 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  86 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  87 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  92 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  96 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  97 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSaleTaxModifierSequence() {
/* 102 */     return this._saleTaxModifierSequence;
/*     */   }
/*     */   
/*     */   public void setSaleTaxModifierSequence(Integer argSaleTaxModifierSequence) {
/* 106 */     if (changed(argSaleTaxModifierSequence, this._saleTaxModifierSequence, "saleTaxModifierSequence")) {
/* 107 */       this._saleTaxModifierSequence = argSaleTaxModifierSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/* 112 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 116 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 117 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 122 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 126 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 127 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 132 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 136 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 137 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 143 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 147 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 148 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 153 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 157 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 158 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 164 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 168 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 169 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/* 174 */     return this._taxAmount;
/*     */   }
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 178 */     if (changed(argTaxAmount, this._taxAmount, "taxAmount")) {
/* 179 */       this._taxAmount = argTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxPercentage() {
/* 184 */     return this._taxPercentage;
/*     */   }
/*     */   
/*     */   public void setTaxPercentage(BigDecimal argTaxPercentage) {
/* 188 */     if (changed(argTaxPercentage, this._taxPercentage, "taxPercentage")) {
/* 189 */       this._taxPercentage = argTaxPercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getRawTaxAmount() {
/* 194 */     return this._rawTaxAmount;
/*     */   }
/*     */   
/*     */   public void setRawTaxAmount(BigDecimal argRawTaxAmount) {
/* 198 */     if (changed(argRawTaxAmount, this._rawTaxAmount, "rawTaxAmount")) {
/* 199 */       this._rawTaxAmount = argRawTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getRawTaxPercentage() {
/* 204 */     return this._rawTaxPercentage;
/*     */   }
/*     */   
/*     */   public void setRawTaxPercentage(BigDecimal argRawTaxPercentage) {
/* 208 */     if (changed(argRawTaxPercentage, this._rawTaxPercentage, "rawTaxPercentage")) {
/* 209 */       this._rawTaxPercentage = argRawTaxPercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExemptTaxAmount() {
/* 214 */     return this._exemptTaxAmount;
/*     */   }
/*     */   
/*     */   public void setExemptTaxAmount(BigDecimal argExemptTaxAmount) {
/* 218 */     if (changed(argExemptTaxAmount, this._exemptTaxAmount, "exemptTaxAmount")) {
/* 219 */       this._exemptTaxAmount = argExemptTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxExemptAmount() {
/* 224 */     return this._taxExemptAmount;
/*     */   }
/*     */   
/*     */   public void setTaxExemptAmount(BigDecimal argTaxExemptAmount) {
/* 228 */     if (changed(argTaxExemptAmount, this._taxExemptAmount, "taxExemptAmount")) {
/* 229 */       this._taxExemptAmount = argTaxExemptAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxExemptionId() {
/* 234 */     return this._taxExemptionId;
/*     */   }
/*     */   
/*     */   public void setTaxExemptionId(String argTaxExemptionId) {
/* 238 */     if (changed(argTaxExemptionId, this._taxExemptionId, "taxExemptionId")) {
/* 239 */       this._taxExemptionId = argTaxExemptionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxOverrideAmount() {
/* 244 */     return this._taxOverrideAmount;
/*     */   }
/*     */   
/*     */   public void setTaxOverrideAmount(BigDecimal argTaxOverrideAmount) {
/* 248 */     if (changed(argTaxOverrideAmount, this._taxOverrideAmount, "taxOverrideAmount")) {
/* 249 */       this._taxOverrideAmount = argTaxOverrideAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getTaxOverride() {
/* 254 */     return this._taxOverride;
/*     */   }
/*     */   
/*     */   public void setTaxOverride(Boolean argTaxOverride) {
/* 258 */     if (changed(argTaxOverride, this._taxOverride, "taxOverride")) {
/* 259 */       this._taxOverride = argTaxOverride;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxOverridePercentage() {
/* 264 */     return this._taxOverridePercentage;
/*     */   }
/*     */   
/*     */   public void setTaxOverridePercentage(BigDecimal argTaxOverridePercentage) {
/* 268 */     if (changed(argTaxOverridePercentage, this._taxOverridePercentage, "taxOverridePercentage")) {
/* 269 */       this._taxOverridePercentage = argTaxOverridePercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxOverrideReasonCode() {
/* 274 */     return this._taxOverrideReasonCode;
/*     */   }
/*     */   
/*     */   public void setTaxOverrideReasonCode(String argTaxOverrideReasonCode) {
/* 278 */     if (changed(argTaxOverrideReasonCode, this._taxOverrideReasonCode, "taxOverrideReasonCode")) {
/* 279 */       this._taxOverrideReasonCode = argTaxOverrideReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxOverrideComment() {
/* 284 */     return this._taxOverrideComment;
/*     */   }
/*     */   
/*     */   public void setTaxOverrideComment(String argTaxOverrideComment) {
/* 288 */     if (changed(argTaxOverrideComment, this._taxOverrideComment, "taxOverrideComment")) {
/* 289 */       this._taxOverrideComment = argTaxOverrideComment;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxableAmount() {
/* 294 */     return this._taxableAmount;
/*     */   }
/*     */   
/*     */   public void setTaxableAmount(BigDecimal argTaxableAmount) {
/* 298 */     if (changed(argTaxableAmount, this._taxableAmount, "taxableAmount")) {
/* 299 */       this._taxableAmount = argTaxableAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 304 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 308 */     if (changed(argVoid, this._void, "void")) {
/* 309 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/* 314 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/* 318 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/* 319 */       this._taxGroupId = argTaxGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/* 324 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/* 328 */     if (changed(argTaxLocationId, this._taxLocationId, "taxLocationId")) {
/* 329 */       this._taxLocationId = argTaxLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/* 334 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/* 338 */     if (changed(argTaxRuleSequence, this._taxRuleSequence, "taxRuleSequence")) {
/* 339 */       this._taxRuleSequence = argTaxRuleSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorityId() {
/* 344 */     return this._authorityId;
/*     */   }
/*     */   
/*     */   public void setAuthorityId(String argAuthorityId) {
/* 348 */     if (changed(argAuthorityId, this._authorityId, "authorityId")) {
/* 349 */       this._authorityId = argAuthorityId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorityName() {
/* 354 */     return this._authorityName;
/*     */   }
/*     */   
/*     */   public void setAuthorityName(String argAuthorityName) {
/* 358 */     if (changed(argAuthorityName, this._authorityName, "authorityName")) {
/* 359 */       this._authorityName = argAuthorityName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorityTypeCode() {
/* 364 */     return this._authorityTypeCode;
/*     */   }
/*     */   
/*     */   public void setAuthorityTypeCode(String argAuthorityTypeCode) {
/* 368 */     if (changed(argAuthorityTypeCode, this._authorityTypeCode, "authorityTypeCode")) {
/* 369 */       this._authorityTypeCode = argAuthorityTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxOverrideBracket() {
/* 374 */     return this._taxOverrideBracket;
/*     */   }
/*     */   
/*     */   public void setTaxOverrideBracket(String argTaxOverrideBracket) {
/* 378 */     if (changed(argTaxOverrideBracket, this._taxOverrideBracket, "taxOverrideBracket")) {
/* 379 */       this._taxOverrideBracket = argTaxOverrideBracket;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOrigTaxableAmount() {
/* 384 */     return this._origTaxableAmount;
/*     */   }
/*     */   
/*     */   public void setOrigTaxableAmount(BigDecimal argOrigTaxableAmount) {
/* 388 */     if (changed(argOrigTaxableAmount, this._origTaxableAmount, "origTaxableAmount")) {
/* 389 */       this._origTaxableAmount = argOrigTaxableAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigTaxGroupId() {
/* 394 */     return this._origTaxGroupId;
/*     */   }
/*     */   
/*     */   public void setOrigTaxGroupId(String argOrigTaxGroupId) {
/* 398 */     if (changed(argOrigTaxGroupId, this._origTaxGroupId, "origTaxGroupId")) {
/* 399 */       this._origTaxGroupId = argOrigTaxGroupId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 406 */     StringBuilder buf = new StringBuilder(512);
/* 407 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 408 */     if (getBusinessDate() != null) {
/* 409 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 411 */     if (getOrganizationId() != null) {
/* 412 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 414 */     if (getRetailLocationId() != null) {
/* 415 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 417 */     if (getRetailTransactionLineItemSequence() != null) {
/* 418 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 420 */     if (getSaleTaxModifierSequence() != null) {
/* 421 */       buf.append("saleTaxModifierSequence").append("=").append(getSaleTaxModifierSequence()).append(" ");
/*     */     }
/* 423 */     if (getTransactionSequence() != null) {
/* 424 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 426 */     if (getWorkstationId() != null) {
/* 427 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 429 */     if (getCreateDate() != null) {
/* 430 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 432 */     if (getCreateUserId() != null) {
/* 433 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 435 */     if (getUpdateDate() != null) {
/* 436 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 438 */     if (getUpdateUserId() != null) {
/* 439 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 441 */     if (getTaxAmount() != null) {
/* 442 */       buf.append("taxAmount").append("=").append(getTaxAmount()).append(" ");
/*     */     }
/* 444 */     if (getTaxPercentage() != null) {
/* 445 */       buf.append("taxPercentage").append("=").append(getTaxPercentage()).append(" ");
/*     */     }
/* 447 */     if (getRawTaxAmount() != null) {
/* 448 */       buf.append("rawTaxAmount").append("=").append(getRawTaxAmount()).append(" ");
/*     */     }
/* 450 */     if (getRawTaxPercentage() != null) {
/* 451 */       buf.append("rawTaxPercentage").append("=").append(getRawTaxPercentage()).append(" ");
/*     */     }
/* 453 */     if (getExemptTaxAmount() != null) {
/* 454 */       buf.append("exemptTaxAmount").append("=").append(getExemptTaxAmount()).append(" ");
/*     */     }
/* 456 */     if (getTaxExemptAmount() != null) {
/* 457 */       buf.append("taxExemptAmount").append("=").append(getTaxExemptAmount()).append(" ");
/*     */     }
/* 459 */     if (getTaxExemptionId() != null) {
/* 460 */       buf.append("taxExemptionId").append("=").append(getTaxExemptionId()).append(" ");
/*     */     }
/* 462 */     if (getTaxOverrideAmount() != null) {
/* 463 */       buf.append("taxOverrideAmount").append("=").append(getTaxOverrideAmount()).append(" ");
/*     */     }
/* 465 */     if (getTaxOverride() != null && getTaxOverride().booleanValue()) {
/* 466 */       buf.append("taxOverride").append("=").append(getTaxOverride()).append(" ");
/*     */     }
/* 468 */     if (getTaxOverridePercentage() != null) {
/* 469 */       buf.append("taxOverridePercentage").append("=").append(getTaxOverridePercentage()).append(" ");
/*     */     }
/* 471 */     if (getTaxOverrideReasonCode() != null) {
/* 472 */       buf.append("taxOverrideReasonCode").append("=").append(getTaxOverrideReasonCode()).append(" ");
/*     */     }
/* 474 */     if (getTaxOverrideComment() != null) {
/* 475 */       buf.append("taxOverrideComment").append("=").append(getTaxOverrideComment()).append(" ");
/*     */     }
/* 477 */     if (getTaxableAmount() != null) {
/* 478 */       buf.append("taxableAmount").append("=").append(getTaxableAmount()).append(" ");
/*     */     }
/* 480 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 481 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 483 */     if (getTaxGroupId() != null) {
/* 484 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*     */     }
/* 486 */     if (getTaxLocationId() != null) {
/* 487 */       buf.append("taxLocationId").append("=").append(getTaxLocationId()).append(" ");
/*     */     }
/* 489 */     if (getTaxRuleSequence() != null) {
/* 490 */       buf.append("taxRuleSequence").append("=").append(getTaxRuleSequence()).append(" ");
/*     */     }
/* 492 */     if (getAuthorityId() != null) {
/* 493 */       buf.append("authorityId").append("=").append(getAuthorityId()).append(" ");
/*     */     }
/* 495 */     if (getAuthorityName() != null) {
/* 496 */       buf.append("authorityName").append("=").append(getAuthorityName()).append(" ");
/*     */     }
/* 498 */     if (getAuthorityTypeCode() != null) {
/* 499 */       buf.append("authorityTypeCode").append("=").append(getAuthorityTypeCode()).append(" ");
/*     */     }
/* 501 */     if (getTaxOverrideBracket() != null) {
/* 502 */       buf.append("taxOverrideBracket").append("=").append(getTaxOverrideBracket()).append(" ");
/*     */     }
/* 504 */     if (getOrigTaxableAmount() != null) {
/* 505 */       buf.append("origTaxableAmount").append("=").append(getOrigTaxableAmount()).append(" ");
/*     */     }
/* 507 */     if (getOrigTaxGroupId() != null) {
/* 508 */       buf.append("origTaxGroupId").append("=").append(getOrigTaxGroupId()).append(" ");
/*     */     }
/*     */     
/* 511 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 515 */     SaleTaxModifierId id = new SaleTaxModifierId();
/* 516 */     id.setBusinessDate(getBusinessDate());
/* 517 */     id.setOrganizationId(getOrganizationId());
/* 518 */     id.setRetailLocationId(getRetailLocationId());
/* 519 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 520 */     id.setSaleTaxModifierSequence(getSaleTaxModifierSequence());
/* 521 */     id.setTransactionSequence(getTransactionSequence());
/* 522 */     id.setWorkstationId(getWorkstationId());
/* 523 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 527 */     setBusinessDate(((SaleTaxModifierId)argObjectId).getBusinessDate());
/* 528 */     setOrganizationId(((SaleTaxModifierId)argObjectId).getOrganizationId());
/* 529 */     setRetailLocationId(((SaleTaxModifierId)argObjectId).getRetailLocationId());
/* 530 */     setRetailTransactionLineItemSequence(((SaleTaxModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 531 */     setSaleTaxModifierSequence(((SaleTaxModifierId)argObjectId).getSaleTaxModifierSequence());
/* 532 */     setTransactionSequence(((SaleTaxModifierId)argObjectId).getTransactionSequence());
/* 533 */     setWorkstationId(((SaleTaxModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 537 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 541 */     StringBuilder buf = new StringBuilder(1700);
/* 542 */     buf.append("<").append("dao").append(" name=\"SaleTaxModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 543 */     getFieldsAsXml(buf);
/* 544 */     buf.append("</").append("dao").append(">");
/*     */     
/* 546 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 550 */     Map<String, String> values = super.getValues();
/* 551 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 552 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 553 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 554 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 555 */     if (this._saleTaxModifierSequence != null) values.put("SaleTaxModifierSequence", DaoUtils.getXmlSafeFieldValue(4, this._saleTaxModifierSequence)); 
/* 556 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 557 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 558 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 559 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 560 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 561 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 562 */     if (this._taxAmount != null) values.put("TaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxAmount)); 
/* 563 */     if (this._taxPercentage != null) values.put("TaxPercentage", DaoUtils.getXmlSafeFieldValue(3, this._taxPercentage)); 
/* 564 */     if (this._rawTaxAmount != null) values.put("RawTaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._rawTaxAmount)); 
/* 565 */     if (this._rawTaxPercentage != null) values.put("RawTaxPercentage", DaoUtils.getXmlSafeFieldValue(3, this._rawTaxPercentage)); 
/* 566 */     if (this._exemptTaxAmount != null) values.put("ExemptTaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._exemptTaxAmount)); 
/* 567 */     if (this._taxExemptAmount != null) values.put("TaxExemptAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxExemptAmount)); 
/* 568 */     if (this._taxExemptionId != null) values.put("TaxExemptionId", DaoUtils.getXmlSafeFieldValue(12, this._taxExemptionId)); 
/* 569 */     if (this._taxOverrideAmount != null) values.put("TaxOverrideAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxOverrideAmount)); 
/* 570 */     if (this._taxOverride != null) values.put("TaxOverride", DaoUtils.getXmlSafeFieldValue(-7, this._taxOverride)); 
/* 571 */     if (this._taxOverridePercentage != null) values.put("TaxOverridePercentage", DaoUtils.getXmlSafeFieldValue(3, this._taxOverridePercentage)); 
/* 572 */     if (this._taxOverrideReasonCode != null) values.put("TaxOverrideReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._taxOverrideReasonCode)); 
/* 573 */     if (this._taxOverrideComment != null) values.put("TaxOverrideComment", DaoUtils.getXmlSafeFieldValue(12, this._taxOverrideComment)); 
/* 574 */     if (this._taxableAmount != null) values.put("TaxableAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxableAmount)); 
/* 575 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 576 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/* 577 */     if (this._taxLocationId != null) values.put("TaxLocationId", DaoUtils.getXmlSafeFieldValue(12, this._taxLocationId)); 
/* 578 */     if (this._taxRuleSequence != null) values.put("TaxRuleSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxRuleSequence)); 
/* 579 */     if (this._authorityId != null) values.put("AuthorityId", DaoUtils.getXmlSafeFieldValue(12, this._authorityId)); 
/* 580 */     if (this._authorityName != null) values.put("AuthorityName", DaoUtils.getXmlSafeFieldValue(12, this._authorityName)); 
/* 581 */     if (this._authorityTypeCode != null) values.put("AuthorityTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._authorityTypeCode)); 
/* 582 */     if (this._taxOverrideBracket != null) values.put("TaxOverrideBracket", DaoUtils.getXmlSafeFieldValue(12, this._taxOverrideBracket)); 
/* 583 */     if (this._origTaxableAmount != null) values.put("OrigTaxableAmount", DaoUtils.getXmlSafeFieldValue(3, this._origTaxableAmount)); 
/* 584 */     if (this._origTaxGroupId != null) values.put("OrigTaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._origTaxGroupId)); 
/* 585 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 590 */     super.setValues(argValues);
/* 591 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 593 */       String fieldName = field.getKey();
/* 594 */       String fieldValue = field.getValue();
/* 595 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 599 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 600 */             setBusinessDate((Date)value);
/* 601 */           } catch (Exception ee) {
/* 602 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 608 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 609 */             setOrganizationId((Long)value);
/* 610 */           } catch (Exception ee) {
/* 611 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 617 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 618 */             setRetailLocationId((Long)value);
/* 619 */           } catch (Exception ee) {
/* 620 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 626 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 627 */             setRetailTransactionLineItemSequence((Integer)value);
/* 628 */           } catch (Exception ee) {
/* 629 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SaleTaxModifierSequence":
/*     */           try {
/* 635 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 636 */             setSaleTaxModifierSequence((Integer)value);
/* 637 */           } catch (Exception ee) {
/* 638 */             throw new DtxException("An exception occurred while calling setSaleTaxModifierSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 644 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 645 */             setTransactionSequence((Long)value);
/* 646 */           } catch (Exception ee) {
/* 647 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 653 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 654 */             setWorkstationId((Long)value);
/* 655 */           } catch (Exception ee) {
/* 656 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 662 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 663 */             setCreateDate((Date)value);
/* 664 */           } catch (Exception ee) {
/* 665 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 671 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 672 */             setCreateUserId((String)value);
/* 673 */           } catch (Exception ee) {
/* 674 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 680 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 681 */             setUpdateDate((Date)value);
/* 682 */           } catch (Exception ee) {
/* 683 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 689 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 690 */             setUpdateUserId((String)value);
/* 691 */           } catch (Exception ee) {
/* 692 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAmount":
/*     */           try {
/* 698 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 699 */             setTaxAmount((BigDecimal)value);
/* 700 */           } catch (Exception ee) {
/* 701 */             throw new DtxException("An exception occurred while calling setTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxPercentage":
/*     */           try {
/* 707 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 708 */             setTaxPercentage((BigDecimal)value);
/* 709 */           } catch (Exception ee) {
/* 710 */             throw new DtxException("An exception occurred while calling setTaxPercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RawTaxAmount":
/*     */           try {
/* 716 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 717 */             setRawTaxAmount((BigDecimal)value);
/* 718 */           } catch (Exception ee) {
/* 719 */             throw new DtxException("An exception occurred while calling setRawTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RawTaxPercentage":
/*     */           try {
/* 725 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 726 */             setRawTaxPercentage((BigDecimal)value);
/* 727 */           } catch (Exception ee) {
/* 728 */             throw new DtxException("An exception occurred while calling setRawTaxPercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExemptTaxAmount":
/*     */           try {
/* 734 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 735 */             setExemptTaxAmount((BigDecimal)value);
/* 736 */           } catch (Exception ee) {
/* 737 */             throw new DtxException("An exception occurred while calling setExemptTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxExemptAmount":
/*     */           try {
/* 743 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 744 */             setTaxExemptAmount((BigDecimal)value);
/* 745 */           } catch (Exception ee) {
/* 746 */             throw new DtxException("An exception occurred while calling setTaxExemptAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxExemptionId":
/*     */           try {
/* 752 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 753 */             setTaxExemptionId((String)value);
/* 754 */           } catch (Exception ee) {
/* 755 */             throw new DtxException("An exception occurred while calling setTaxExemptionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverrideAmount":
/*     */           try {
/* 761 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 762 */             setTaxOverrideAmount((BigDecimal)value);
/* 763 */           } catch (Exception ee) {
/* 764 */             throw new DtxException("An exception occurred while calling setTaxOverrideAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverride":
/*     */           try {
/* 770 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 771 */             setTaxOverride((Boolean)value);
/* 772 */           } catch (Exception ee) {
/* 773 */             throw new DtxException("An exception occurred while calling setTaxOverride() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverridePercentage":
/*     */           try {
/* 779 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 780 */             setTaxOverridePercentage((BigDecimal)value);
/* 781 */           } catch (Exception ee) {
/* 782 */             throw new DtxException("An exception occurred while calling setTaxOverridePercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverrideReasonCode":
/*     */           try {
/* 788 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 789 */             setTaxOverrideReasonCode((String)value);
/* 790 */           } catch (Exception ee) {
/* 791 */             throw new DtxException("An exception occurred while calling setTaxOverrideReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverrideComment":
/*     */           try {
/* 797 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 798 */             setTaxOverrideComment((String)value);
/* 799 */           } catch (Exception ee) {
/* 800 */             throw new DtxException("An exception occurred while calling setTaxOverrideComment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxableAmount":
/*     */           try {
/* 806 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 807 */             setTaxableAmount((BigDecimal)value);
/* 808 */           } catch (Exception ee) {
/* 809 */             throw new DtxException("An exception occurred while calling setTaxableAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 815 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 816 */             setVoid((Boolean)value);
/* 817 */           } catch (Exception ee) {
/* 818 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxGroupId":
/*     */           try {
/* 824 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 825 */             setTaxGroupId((String)value);
/* 826 */           } catch (Exception ee) {
/* 827 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxLocationId":
/*     */           try {
/* 833 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 834 */             setTaxLocationId((String)value);
/* 835 */           } catch (Exception ee) {
/* 836 */             throw new DtxException("An exception occurred while calling setTaxLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRuleSequence":
/*     */           try {
/* 842 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 843 */             setTaxRuleSequence((Integer)value);
/* 844 */           } catch (Exception ee) {
/* 845 */             throw new DtxException("An exception occurred while calling setTaxRuleSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorityId":
/*     */           try {
/* 851 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 852 */             setAuthorityId((String)value);
/* 853 */           } catch (Exception ee) {
/* 854 */             throw new DtxException("An exception occurred while calling setAuthorityId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorityName":
/*     */           try {
/* 860 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 861 */             setAuthorityName((String)value);
/* 862 */           } catch (Exception ee) {
/* 863 */             throw new DtxException("An exception occurred while calling setAuthorityName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorityTypeCode":
/*     */           try {
/* 869 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 870 */             setAuthorityTypeCode((String)value);
/* 871 */           } catch (Exception ee) {
/* 872 */             throw new DtxException("An exception occurred while calling setAuthorityTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxOverrideBracket":
/*     */           try {
/* 878 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 879 */             setTaxOverrideBracket((String)value);
/* 880 */           } catch (Exception ee) {
/* 881 */             throw new DtxException("An exception occurred while calling setTaxOverrideBracket() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigTaxableAmount":
/*     */           try {
/* 887 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 888 */             setOrigTaxableAmount((BigDecimal)value);
/* 889 */           } catch (Exception ee) {
/* 890 */             throw new DtxException("An exception occurred while calling setOrigTaxableAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigTaxGroupId":
/*     */           try {
/* 896 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 897 */             setOrigTaxGroupId((String)value);
/* 898 */           } catch (Exception ee) {
/* 899 */             throw new DtxException("An exception occurred while calling setOrigTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleTaxModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */