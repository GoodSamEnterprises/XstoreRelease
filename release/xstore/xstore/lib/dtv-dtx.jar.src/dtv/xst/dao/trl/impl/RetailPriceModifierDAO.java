/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailPriceModifierId;
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
/*     */ public class RetailPriceModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1985659613L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RetailPriceModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailPriceModifierSequenceNbr;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _extendedAmount;
/*     */   private String _notes;
/*     */   private String _serialNumber;
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _priceChangeAmount;
/*     */   private String _priceChangeReasonCode;
/*     */   private String _promotionId;
/*     */   private String _description;
/*     */   private String _retailPriceModifierReasonCode;
/*  46 */   private Boolean _void = Boolean.FALSE;
/*     */   private Integer _discountGroupId;
/*     */   private String _dealId;
/*     */   private String _discountCode;
/*     */   private DtvDate _discBusinessDate;
/*     */   private Long _discRetailLocationId;
/*     */   private Integer _discRetailTransactionLineItemSequence;
/*     */   private Long _discTransactionSequence;
/*     */   private Long _discWorkstationId;
/*     */   private String _discountReasonCode;
/*     */   private String _taxabilityCode;
/*     */   private BigDecimal _dealAmount;
/*     */   
/*     */   public Date getBusinessDate() {
/*  60 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  64 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  65 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  71 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  75 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  76 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  81 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  85 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  86 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailPriceModifierSequenceNbr() {
/*  91 */     return this._retailPriceModifierSequenceNbr;
/*     */   }
/*     */   
/*     */   public void setRetailPriceModifierSequenceNbr(Integer argRetailPriceModifierSequenceNbr) {
/*  95 */     if (changed(argRetailPriceModifierSequenceNbr, this._retailPriceModifierSequenceNbr, "retailPriceModifierSequenceNbr")) {
/*  96 */       this._retailPriceModifierSequenceNbr = argRetailPriceModifierSequenceNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/* 101 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/* 105 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/* 106 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/* 111 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 115 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 116 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 121 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 125 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 126 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 131 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 135 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 136 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 142 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 146 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 147 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 152 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 156 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 157 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 163 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 167 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 168 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 173 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 177 */     if (changed(argAmount, this._amount, "amount")) {
/* 178 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExtendedAmount() {
/* 183 */     return this._extendedAmount;
/*     */   }
/*     */   
/*     */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/* 187 */     if (changed(argExtendedAmount, this._extendedAmount, "extendedAmount")) {
/* 188 */       this._extendedAmount = argExtendedAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNotes() {
/* 193 */     return this._notes;
/*     */   }
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 197 */     if (changed(argNotes, this._notes, "notes")) {
/* 198 */       this._notes = argNotes;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 203 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 207 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 208 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPercent() {
/* 213 */     return this._percent;
/*     */   }
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/* 217 */     if (changed(argPercent, this._percent, "percent")) {
/* 218 */       this._percent = argPercent;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPriceChangeAmount() {
/* 223 */     return this._priceChangeAmount;
/*     */   }
/*     */   
/*     */   public void setPriceChangeAmount(BigDecimal argPriceChangeAmount) {
/* 227 */     if (changed(argPriceChangeAmount, this._priceChangeAmount, "priceChangeAmount")) {
/* 228 */       this._priceChangeAmount = argPriceChangeAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPriceChangeReasonCode() {
/* 233 */     return this._priceChangeReasonCode;
/*     */   }
/*     */   
/*     */   public void setPriceChangeReasonCode(String argPriceChangeReasonCode) {
/* 237 */     if (changed(argPriceChangeReasonCode, this._priceChangeReasonCode, "priceChangeReasonCode")) {
/* 238 */       this._priceChangeReasonCode = argPriceChangeReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromotionId() {
/* 243 */     return this._promotionId;
/*     */   }
/*     */   
/*     */   public void setPromotionId(String argPromotionId) {
/* 247 */     if (changed(argPromotionId, this._promotionId, "promotionId")) {
/* 248 */       this._promotionId = argPromotionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 253 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 257 */     if (changed(argDescription, this._description, "description")) {
/* 258 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRetailPriceModifierReasonCode() {
/* 263 */     return this._retailPriceModifierReasonCode;
/*     */   }
/*     */   
/*     */   public void setRetailPriceModifierReasonCode(String argRetailPriceModifierReasonCode) {
/* 267 */     if (changed(argRetailPriceModifierReasonCode, this._retailPriceModifierReasonCode, "retailPriceModifierReasonCode")) {
/* 268 */       this._retailPriceModifierReasonCode = argRetailPriceModifierReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 273 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 277 */     if (changed(argVoid, this._void, "void")) {
/* 278 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDiscountGroupId() {
/* 283 */     return this._discountGroupId;
/*     */   }
/*     */   
/*     */   public void setDiscountGroupId(Integer argDiscountGroupId) {
/* 287 */     if (changed(argDiscountGroupId, this._discountGroupId, "discountGroupId")) {
/* 288 */       this._discountGroupId = argDiscountGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDealId() {
/* 293 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 297 */     if (changed(argDealId, this._dealId, "dealId")) {
/* 298 */       this._dealId = argDealId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDiscountCode() {
/* 303 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/* 307 */     if (changed(argDiscountCode, this._discountCode, "discountCode")) {
/* 308 */       this._discountCode = argDiscountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDiscBusinessDate() {
/* 313 */     return (Date)this._discBusinessDate;
/*     */   }
/*     */   
/*     */   public void setDiscBusinessDate(Date argDiscBusinessDate) {
/* 317 */     if (changed(argDiscBusinessDate, this._discBusinessDate, "discBusinessDate")) {
/* 318 */       this._discBusinessDate = (argDiscBusinessDate == null || argDiscBusinessDate instanceof DtvDate) ? (DtvDate)argDiscBusinessDate : new DtvDate(argDiscBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getDiscRetailLocationId() {
/* 324 */     return this._discRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setDiscRetailLocationId(Long argDiscRetailLocationId) {
/* 328 */     if (changed(argDiscRetailLocationId, this._discRetailLocationId, "discRetailLocationId")) {
/* 329 */       this._discRetailLocationId = argDiscRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDiscRetailTransactionLineItemSequence() {
/* 334 */     return this._discRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setDiscRetailTransactionLineItemSequence(Integer argDiscRetailTransactionLineItemSequence) {
/* 338 */     if (changed(argDiscRetailTransactionLineItemSequence, this._discRetailTransactionLineItemSequence, "discRetailTransactionLineItemSequence")) {
/* 339 */       this._discRetailTransactionLineItemSequence = argDiscRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getDiscTransactionSequence() {
/* 344 */     return this._discTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setDiscTransactionSequence(Long argDiscTransactionSequence) {
/* 348 */     if (changed(argDiscTransactionSequence, this._discTransactionSequence, "discTransactionSequence")) {
/* 349 */       this._discTransactionSequence = argDiscTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getDiscWorkstationId() {
/* 354 */     return this._discWorkstationId;
/*     */   }
/*     */   
/*     */   public void setDiscWorkstationId(Long argDiscWorkstationId) {
/* 358 */     if (changed(argDiscWorkstationId, this._discWorkstationId, "discWorkstationId")) {
/* 359 */       this._discWorkstationId = argDiscWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDiscountReasonCode() {
/* 364 */     return this._discountReasonCode;
/*     */   }
/*     */   
/*     */   public void setDiscountReasonCode(String argDiscountReasonCode) {
/* 368 */     if (changed(argDiscountReasonCode, this._discountReasonCode, "discountReasonCode")) {
/* 369 */       this._discountReasonCode = argDiscountReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxabilityCode() {
/* 374 */     return this._taxabilityCode;
/*     */   }
/*     */   
/*     */   public void setTaxabilityCode(String argTaxabilityCode) {
/* 378 */     if (changed(argTaxabilityCode, this._taxabilityCode, "taxabilityCode")) {
/* 379 */       this._taxabilityCode = argTaxabilityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDealAmount() {
/* 384 */     return this._dealAmount;
/*     */   }
/*     */   
/*     */   public void setDealAmount(BigDecimal argDealAmount) {
/* 388 */     if (changed(argDealAmount, this._dealAmount, "dealAmount")) {
/* 389 */       this._dealAmount = argDealAmount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 396 */     StringBuilder buf = new StringBuilder(512);
/* 397 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 398 */     if (getBusinessDate() != null) {
/* 399 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 401 */     if (getOrganizationId() != null) {
/* 402 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 404 */     if (getRetailLocationId() != null) {
/* 405 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 407 */     if (getRetailPriceModifierSequenceNbr() != null) {
/* 408 */       buf.append("retailPriceModifierSequenceNbr").append("=").append(getRetailPriceModifierSequenceNbr()).append(" ");
/*     */     }
/* 410 */     if (getRetailTransactionLineItemSequence() != null) {
/* 411 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 413 */     if (getTransactionSequence() != null) {
/* 414 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 416 */     if (getWorkstationId() != null) {
/* 417 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 419 */     if (getCreateDate() != null) {
/* 420 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 422 */     if (getCreateUserId() != null) {
/* 423 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 425 */     if (getUpdateDate() != null) {
/* 426 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 428 */     if (getUpdateUserId() != null) {
/* 429 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 431 */     if (getAmount() != null) {
/* 432 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 434 */     if (getExtendedAmount() != null) {
/* 435 */       buf.append("extendedAmount").append("=").append(getExtendedAmount()).append(" ");
/*     */     }
/* 437 */     if (getNotes() != null) {
/* 438 */       buf.append("notes").append("=").append(getNotes()).append(" ");
/*     */     }
/* 440 */     if (getSerialNumber() != null) {
/* 441 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 443 */     if (getPercent() != null) {
/* 444 */       buf.append("percent").append("=").append(getPercent()).append(" ");
/*     */     }
/* 446 */     if (getPriceChangeAmount() != null) {
/* 447 */       buf.append("priceChangeAmount").append("=").append(getPriceChangeAmount()).append(" ");
/*     */     }
/* 449 */     if (getPriceChangeReasonCode() != null) {
/* 450 */       buf.append("priceChangeReasonCode").append("=").append(getPriceChangeReasonCode()).append(" ");
/*     */     }
/* 452 */     if (getPromotionId() != null) {
/* 453 */       buf.append("promotionId").append("=").append(getPromotionId()).append(" ");
/*     */     }
/* 455 */     if (getDescription() != null) {
/* 456 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 458 */     if (getRetailPriceModifierReasonCode() != null) {
/* 459 */       buf.append("retailPriceModifierReasonCode").append("=").append(getRetailPriceModifierReasonCode()).append(" ");
/*     */     }
/* 461 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 462 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 464 */     if (getDiscountGroupId() != null) {
/* 465 */       buf.append("discountGroupId").append("=").append(getDiscountGroupId()).append(" ");
/*     */     }
/* 467 */     if (getDealId() != null) {
/* 468 */       buf.append("dealId").append("=").append(getDealId()).append(" ");
/*     */     }
/* 470 */     if (getDiscountCode() != null) {
/* 471 */       buf.append("discountCode").append("=").append(getDiscountCode()).append(" ");
/*     */     }
/* 473 */     if (getDiscBusinessDate() != null) {
/* 474 */       buf.append("discBusinessDate").append("=").append(getDiscBusinessDate()).append(" ");
/*     */     }
/* 476 */     if (getDiscRetailLocationId() != null) {
/* 477 */       buf.append("discRetailLocationId").append("=").append(getDiscRetailLocationId()).append(" ");
/*     */     }
/* 479 */     if (getDiscRetailTransactionLineItemSequence() != null) {
/* 480 */       buf.append("discRetailTransactionLineItemSequence").append("=").append(getDiscRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 482 */     if (getDiscTransactionSequence() != null) {
/* 483 */       buf.append("discTransactionSequence").append("=").append(getDiscTransactionSequence()).append(" ");
/*     */     }
/* 485 */     if (getDiscWorkstationId() != null) {
/* 486 */       buf.append("discWorkstationId").append("=").append(getDiscWorkstationId()).append(" ");
/*     */     }
/* 488 */     if (getDiscountReasonCode() != null) {
/* 489 */       buf.append("discountReasonCode").append("=").append(getDiscountReasonCode()).append(" ");
/*     */     }
/* 491 */     if (getTaxabilityCode() != null) {
/* 492 */       buf.append("taxabilityCode").append("=").append(getTaxabilityCode()).append(" ");
/*     */     }
/* 494 */     if (getDealAmount() != null) {
/* 495 */       buf.append("dealAmount").append("=").append(getDealAmount()).append(" ");
/*     */     }
/*     */     
/* 498 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 502 */     RetailPriceModifierId id = new RetailPriceModifierId();
/* 503 */     id.setBusinessDate(getBusinessDate());
/* 504 */     id.setOrganizationId(getOrganizationId());
/* 505 */     id.setRetailLocationId(getRetailLocationId());
/* 506 */     id.setRetailPriceModifierSequenceNbr(getRetailPriceModifierSequenceNbr());
/* 507 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 508 */     id.setTransactionSequence(getTransactionSequence());
/* 509 */     id.setWorkstationId(getWorkstationId());
/* 510 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 514 */     setBusinessDate(((RetailPriceModifierId)argObjectId).getBusinessDate());
/* 515 */     setOrganizationId(((RetailPriceModifierId)argObjectId).getOrganizationId());
/* 516 */     setRetailLocationId(((RetailPriceModifierId)argObjectId).getRetailLocationId());
/* 517 */     setRetailPriceModifierSequenceNbr(((RetailPriceModifierId)argObjectId).getRetailPriceModifierSequenceNbr());
/* 518 */     setRetailTransactionLineItemSequence(((RetailPriceModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 519 */     setTransactionSequence(((RetailPriceModifierId)argObjectId).getTransactionSequence());
/* 520 */     setWorkstationId(((RetailPriceModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 524 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 528 */     StringBuilder buf = new StringBuilder(1650);
/* 529 */     buf.append("<").append("dao").append(" name=\"RetailPriceModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 530 */     getFieldsAsXml(buf);
/* 531 */     buf.append("</").append("dao").append(">");
/*     */     
/* 533 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 537 */     Map<String, String> values = super.getValues();
/* 538 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 539 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 540 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 541 */     if (this._retailPriceModifierSequenceNbr != null) values.put("RetailPriceModifierSequenceNbr", DaoUtils.getXmlSafeFieldValue(4, this._retailPriceModifierSequenceNbr)); 
/* 542 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 543 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 544 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 545 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 546 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 547 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 548 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 549 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 550 */     if (this._extendedAmount != null) values.put("ExtendedAmount", DaoUtils.getXmlSafeFieldValue(3, this._extendedAmount)); 
/* 551 */     if (this._notes != null) values.put("Notes", DaoUtils.getXmlSafeFieldValue(12, this._notes)); 
/* 552 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 553 */     if (this._percent != null) values.put("Percent", DaoUtils.getXmlSafeFieldValue(3, this._percent)); 
/* 554 */     if (this._priceChangeAmount != null) values.put("PriceChangeAmount", DaoUtils.getXmlSafeFieldValue(3, this._priceChangeAmount)); 
/* 555 */     if (this._priceChangeReasonCode != null) values.put("PriceChangeReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._priceChangeReasonCode)); 
/* 556 */     if (this._promotionId != null) values.put("PromotionId", DaoUtils.getXmlSafeFieldValue(12, this._promotionId)); 
/* 557 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 558 */     if (this._retailPriceModifierReasonCode != null) values.put("RetailPriceModifierReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._retailPriceModifierReasonCode)); 
/* 559 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 560 */     if (this._discountGroupId != null) values.put("DiscountGroupId", DaoUtils.getXmlSafeFieldValue(4, this._discountGroupId)); 
/* 561 */     if (this._dealId != null) values.put("DealId", DaoUtils.getXmlSafeFieldValue(12, this._dealId)); 
/* 562 */     if (this._discountCode != null) values.put("DiscountCode", DaoUtils.getXmlSafeFieldValue(12, this._discountCode)); 
/* 563 */     if (this._discBusinessDate != null) values.put("DiscBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._discBusinessDate)); 
/* 564 */     if (this._discRetailLocationId != null) values.put("DiscRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._discRetailLocationId)); 
/* 565 */     if (this._discRetailTransactionLineItemSequence != null) values.put("DiscRetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._discRetailTransactionLineItemSequence)); 
/* 566 */     if (this._discTransactionSequence != null) values.put("DiscTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._discTransactionSequence)); 
/* 567 */     if (this._discWorkstationId != null) values.put("DiscWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._discWorkstationId)); 
/* 568 */     if (this._discountReasonCode != null) values.put("DiscountReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._discountReasonCode)); 
/* 569 */     if (this._taxabilityCode != null) values.put("TaxabilityCode", DaoUtils.getXmlSafeFieldValue(12, this._taxabilityCode)); 
/* 570 */     if (this._dealAmount != null) values.put("DealAmount", DaoUtils.getXmlSafeFieldValue(3, this._dealAmount)); 
/* 571 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 576 */     super.setValues(argValues);
/* 577 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 579 */       String fieldName = field.getKey();
/* 580 */       String fieldValue = field.getValue();
/* 581 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 585 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 586 */             setBusinessDate((Date)value);
/* 587 */           } catch (Exception ee) {
/* 588 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 594 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 595 */             setOrganizationId((Long)value);
/* 596 */           } catch (Exception ee) {
/* 597 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 603 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 604 */             setRetailLocationId((Long)value);
/* 605 */           } catch (Exception ee) {
/* 606 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailPriceModifierSequenceNbr":
/*     */           try {
/* 612 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 613 */             setRetailPriceModifierSequenceNbr((Integer)value);
/* 614 */           } catch (Exception ee) {
/* 615 */             throw new DtxException("An exception occurred while calling setRetailPriceModifierSequenceNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 621 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 622 */             setRetailTransactionLineItemSequence((Integer)value);
/* 623 */           } catch (Exception ee) {
/* 624 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 630 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 631 */             setTransactionSequence((Long)value);
/* 632 */           } catch (Exception ee) {
/* 633 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 639 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 640 */             setWorkstationId((Long)value);
/* 641 */           } catch (Exception ee) {
/* 642 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 648 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 649 */             setCreateDate((Date)value);
/* 650 */           } catch (Exception ee) {
/* 651 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 657 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 658 */             setCreateUserId((String)value);
/* 659 */           } catch (Exception ee) {
/* 660 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 666 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 667 */             setUpdateDate((Date)value);
/* 668 */           } catch (Exception ee) {
/* 669 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 675 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 676 */             setUpdateUserId((String)value);
/* 677 */           } catch (Exception ee) {
/* 678 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 684 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 685 */             setAmount((BigDecimal)value);
/* 686 */           } catch (Exception ee) {
/* 687 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExtendedAmount":
/*     */           try {
/* 693 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 694 */             setExtendedAmount((BigDecimal)value);
/* 695 */           } catch (Exception ee) {
/* 696 */             throw new DtxException("An exception occurred while calling setExtendedAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Notes":
/*     */           try {
/* 702 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 703 */             setNotes((String)value);
/* 704 */           } catch (Exception ee) {
/* 705 */             throw new DtxException("An exception occurred while calling setNotes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 711 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 712 */             setSerialNumber((String)value);
/* 713 */           } catch (Exception ee) {
/* 714 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Percent":
/*     */           try {
/* 720 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 721 */             setPercent((BigDecimal)value);
/* 722 */           } catch (Exception ee) {
/* 723 */             throw new DtxException("An exception occurred while calling setPercent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriceChangeAmount":
/*     */           try {
/* 729 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 730 */             setPriceChangeAmount((BigDecimal)value);
/* 731 */           } catch (Exception ee) {
/* 732 */             throw new DtxException("An exception occurred while calling setPriceChangeAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriceChangeReasonCode":
/*     */           try {
/* 738 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 739 */             setPriceChangeReasonCode((String)value);
/* 740 */           } catch (Exception ee) {
/* 741 */             throw new DtxException("An exception occurred while calling setPriceChangeReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromotionId":
/*     */           try {
/* 747 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 748 */             setPromotionId((String)value);
/* 749 */           } catch (Exception ee) {
/* 750 */             throw new DtxException("An exception occurred while calling setPromotionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 756 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 757 */             setDescription((String)value);
/* 758 */           } catch (Exception ee) {
/* 759 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailPriceModifierReasonCode":
/*     */           try {
/* 765 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 766 */             setRetailPriceModifierReasonCode((String)value);
/* 767 */           } catch (Exception ee) {
/* 768 */             throw new DtxException("An exception occurred while calling setRetailPriceModifierReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 774 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 775 */             setVoid((Boolean)value);
/* 776 */           } catch (Exception ee) {
/* 777 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscountGroupId":
/*     */           try {
/* 783 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 784 */             setDiscountGroupId((Integer)value);
/* 785 */           } catch (Exception ee) {
/* 786 */             throw new DtxException("An exception occurred while calling setDiscountGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DealId":
/*     */           try {
/* 792 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 793 */             setDealId((String)value);
/* 794 */           } catch (Exception ee) {
/* 795 */             throw new DtxException("An exception occurred while calling setDealId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscountCode":
/*     */           try {
/* 801 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 802 */             setDiscountCode((String)value);
/* 803 */           } catch (Exception ee) {
/* 804 */             throw new DtxException("An exception occurred while calling setDiscountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscBusinessDate":
/*     */           try {
/* 810 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 811 */             setDiscBusinessDate((Date)value);
/* 812 */           } catch (Exception ee) {
/* 813 */             throw new DtxException("An exception occurred while calling setDiscBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscRetailLocationId":
/*     */           try {
/* 819 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 820 */             setDiscRetailLocationId((Long)value);
/* 821 */           } catch (Exception ee) {
/* 822 */             throw new DtxException("An exception occurred while calling setDiscRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscRetailTransactionLineItemSequence":
/*     */           try {
/* 828 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 829 */             setDiscRetailTransactionLineItemSequence((Integer)value);
/* 830 */           } catch (Exception ee) {
/* 831 */             throw new DtxException("An exception occurred while calling setDiscRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscTransactionSequence":
/*     */           try {
/* 837 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 838 */             setDiscTransactionSequence((Long)value);
/* 839 */           } catch (Exception ee) {
/* 840 */             throw new DtxException("An exception occurred while calling setDiscTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscWorkstationId":
/*     */           try {
/* 846 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 847 */             setDiscWorkstationId((Long)value);
/* 848 */           } catch (Exception ee) {
/* 849 */             throw new DtxException("An exception occurred while calling setDiscWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscountReasonCode":
/*     */           try {
/* 855 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 856 */             setDiscountReasonCode((String)value);
/* 857 */           } catch (Exception ee) {
/* 858 */             throw new DtxException("An exception occurred while calling setDiscountReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxabilityCode":
/*     */           try {
/* 864 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 865 */             setTaxabilityCode((String)value);
/* 866 */           } catch (Exception ee) {
/* 867 */             throw new DtxException("An exception occurred while calling setTaxabilityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DealAmount":
/*     */           try {
/* 873 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 874 */             setDealAmount((BigDecimal)value);
/* 875 */           } catch (Exception ee) {
/* 876 */             throw new DtxException("An exception occurred while calling setDealAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailPriceModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */