/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.xst.dao.tax.ITaxGroupRule;
/*     */ import dtv.xst.dao.trl.ITaxLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TaxLineItemModel
/*     */   extends RetailTransactionLineItemModel
/*     */   implements ITaxLineItem
/*     */ {
/*     */   private static final long serialVersionUID = 899773906L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private ITaxGroupRule _saleTaxGroupRule;
/*     */   private transient ITaxGroupRule _saleTaxGroupRuleSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  31 */     setDAO((IDataAccessObject)new TaxLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxLineItemDAO getDAO_() {
/*  39 */     return (TaxLineItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  47 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  55 */     if (setCreateDate_noev(argCreateDate) && 
/*  56 */       this._events != null && 
/*  57 */       postEventsForChanges()) {
/*  58 */       this._events.post(ITaxLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  65 */     boolean ev_postable = false;
/*     */     
/*  67 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  68 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  69 */       getDAO_().setCreateDate(argCreateDate);
/*  70 */       ev_postable = true;
/*     */     } 
/*     */     
/*  73 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  81 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  89 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  90 */       this._events != null && 
/*  91 */       postEventsForChanges()) {
/*  92 */       this._events.post(ITaxLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  99 */     boolean ev_postable = false;
/*     */     
/* 101 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 102 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 103 */       getDAO_().setCreateUserId(argCreateUserId);
/* 104 */       ev_postable = true;
/*     */     } 
/*     */     
/* 107 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 115 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 123 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 124 */       this._events != null && 
/* 125 */       postEventsForChanges()) {
/* 126 */       this._events.post(ITaxLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 133 */     boolean ev_postable = false;
/*     */     
/* 135 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 136 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 137 */       getDAO_().setUpdateDate(argUpdateDate);
/* 138 */       ev_postable = true;
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 149 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 157 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(ITaxLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 170 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 171 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 172 */       ev_postable = true;
/*     */     } 
/*     */     
/* 175 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getTaxAmountImpl() {
/* 183 */     return getDAO_().getTaxAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setTaxAmountImpl(BigDecimal argTaxAmount) {
/* 191 */     if (setTaxAmount_noev(argTaxAmount) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(ITaxLineItem.SET_TAXAMOUNT, argTaxAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/* 204 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/* 205 */       getDAO_().setTaxAmount(argTaxAmount);
/* 206 */       ev_postable = true;
/*     */     } 
/*     */     
/* 209 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTaxPercentage() {
/* 217 */     return getDAO_().getTaxPercentage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxPercentage(BigDecimal argTaxPercentage) {
/* 225 */     if (setTaxPercentage_noev(argTaxPercentage) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(ITaxLineItem.SET_TAXPERCENTAGE, argTaxPercentage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxPercentage_noev(BigDecimal argTaxPercentage) {
/* 235 */     boolean ev_postable = false;
/*     */     
/* 237 */     if ((getDAO_().getTaxPercentage() == null && argTaxPercentage != null) || (
/* 238 */       getDAO_().getTaxPercentage() != null && !getDAO_().getTaxPercentage().equals(argTaxPercentage))) {
/* 239 */       getDAO_().setTaxPercentage(argTaxPercentage);
/* 240 */       ev_postable = true;
/*     */     } 
/*     */     
/* 243 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getRawTaxAmountImpl() {
/* 251 */     return getDAO_().getRawTaxAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setRawTaxAmountImpl(BigDecimal argRawTaxAmount) {
/* 259 */     if (setRawTaxAmount_noev(argRawTaxAmount) && 
/* 260 */       this._events != null && 
/* 261 */       postEventsForChanges()) {
/* 262 */       this._events.post(ITaxLineItem.SET_RAWTAXAMOUNT, argRawTaxAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRawTaxAmount_noev(BigDecimal argRawTaxAmount) {
/* 269 */     boolean ev_postable = false;
/*     */     
/* 271 */     if ((getDAO_().getRawTaxAmount() == null && argRawTaxAmount != null) || (
/* 272 */       getDAO_().getRawTaxAmount() != null && !getDAO_().getRawTaxAmount().equals(argRawTaxAmount))) {
/* 273 */       getDAO_().setRawTaxAmount(argRawTaxAmount);
/* 274 */       ev_postable = true;
/*     */     } 
/*     */     
/* 277 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getRawTaxPercentage() {
/* 285 */     return getDAO_().getRawTaxPercentage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRawTaxPercentage(BigDecimal argRawTaxPercentage) {
/* 293 */     if (setRawTaxPercentage_noev(argRawTaxPercentage) && 
/* 294 */       this._events != null && 
/* 295 */       postEventsForChanges()) {
/* 296 */       this._events.post(ITaxLineItem.SET_RAWTAXPERCENTAGE, argRawTaxPercentage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRawTaxPercentage_noev(BigDecimal argRawTaxPercentage) {
/* 303 */     boolean ev_postable = false;
/*     */     
/* 305 */     if ((getDAO_().getRawTaxPercentage() == null && argRawTaxPercentage != null) || (
/* 306 */       getDAO_().getRawTaxPercentage() != null && !getDAO_().getRawTaxPercentage().equals(argRawTaxPercentage))) {
/* 307 */       getDAO_().setRawTaxPercentage(argRawTaxPercentage);
/* 308 */       ev_postable = true;
/*     */     } 
/*     */     
/* 311 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getTaxOverrideAmountImpl() {
/* 319 */     return getDAO_().getTaxOverrideAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setTaxOverrideAmountImpl(BigDecimal argTaxOverrideAmount) {
/* 327 */     if (setTaxOverrideAmount_noev(argTaxOverrideAmount) && 
/* 328 */       this._events != null && 
/* 329 */       postEventsForChanges()) {
/* 330 */       this._events.post(ITaxLineItem.SET_TAXOVERRIDEAMOUNT, argTaxOverrideAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxOverrideAmount_noev(BigDecimal argTaxOverrideAmount) {
/* 337 */     boolean ev_postable = false;
/*     */     
/* 339 */     if ((getDAO_().getTaxOverrideAmount() == null && argTaxOverrideAmount != null) || (
/* 340 */       getDAO_().getTaxOverrideAmount() != null && !getDAO_().getTaxOverrideAmount().equals(argTaxOverrideAmount))) {
/* 341 */       getDAO_().setTaxOverrideAmount(argTaxOverrideAmount);
/* 342 */       ev_postable = true;
/*     */     } 
/*     */     
/* 345 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTaxOverride() {
/* 353 */     if (getDAO_().getTaxOverride() != null) {
/* 354 */       return getDAO_().getTaxOverride().booleanValue();
/*     */     }
/*     */     
/* 357 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxOverride(boolean argTaxOverride) {
/* 366 */     if (setTaxOverride_noev(argTaxOverride) && 
/* 367 */       this._events != null && 
/* 368 */       postEventsForChanges()) {
/* 369 */       this._events.post(ITaxLineItem.SET_TAXOVERRIDE, Boolean.valueOf(argTaxOverride));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxOverride_noev(boolean argTaxOverride) {
/* 376 */     boolean ev_postable = false;
/*     */     
/* 378 */     if ((getDAO_().getTaxOverride() == null && Boolean.valueOf(argTaxOverride) != null) || (
/* 379 */       getDAO_().getTaxOverride() != null && !getDAO_().getTaxOverride().equals(Boolean.valueOf(argTaxOverride)))) {
/* 380 */       getDAO_().setTaxOverride(Boolean.valueOf(argTaxOverride));
/* 381 */       ev_postable = true;
/*     */     } 
/*     */     
/* 384 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTaxOverridePercentage() {
/* 392 */     return getDAO_().getTaxOverridePercentage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxOverridePercentage(BigDecimal argTaxOverridePercentage) {
/* 400 */     if (setTaxOverridePercentage_noev(argTaxOverridePercentage) && 
/* 401 */       this._events != null && 
/* 402 */       postEventsForChanges()) {
/* 403 */       this._events.post(ITaxLineItem.SET_TAXOVERRIDEPERCENTAGE, argTaxOverridePercentage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxOverridePercentage_noev(BigDecimal argTaxOverridePercentage) {
/* 410 */     boolean ev_postable = false;
/*     */     
/* 412 */     if ((getDAO_().getTaxOverridePercentage() == null && argTaxOverridePercentage != null) || (
/* 413 */       getDAO_().getTaxOverridePercentage() != null && !getDAO_().getTaxOverridePercentage().equals(argTaxOverridePercentage))) {
/* 414 */       getDAO_().setTaxOverridePercentage(argTaxOverridePercentage);
/* 415 */       ev_postable = true;
/*     */     } 
/*     */     
/* 418 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxOverrideReasonCode() {
/* 426 */     return getDAO_().getTaxOverrideReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxOverrideReasonCode(String argTaxOverrideReasonCode) {
/* 434 */     if (setTaxOverrideReasonCode_noev(argTaxOverrideReasonCode) && 
/* 435 */       this._events != null && 
/* 436 */       postEventsForChanges()) {
/* 437 */       this._events.post(ITaxLineItem.SET_TAXOVERRIDEREASONCODE, argTaxOverrideReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxOverrideReasonCode_noev(String argTaxOverrideReasonCode) {
/* 444 */     boolean ev_postable = false;
/*     */     
/* 446 */     if ((getDAO_().getTaxOverrideReasonCode() == null && argTaxOverrideReasonCode != null) || (
/* 447 */       getDAO_().getTaxOverrideReasonCode() != null && !getDAO_().getTaxOverrideReasonCode().equals(argTaxOverrideReasonCode))) {
/* 448 */       getDAO_().setTaxOverrideReasonCode(argTaxOverrideReasonCode);
/* 449 */       ev_postable = true;
/*     */     } 
/*     */     
/* 452 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getTaxableAmountImpl() {
/* 460 */     return getDAO_().getTaxableAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setTaxableAmountImpl(BigDecimal argTaxableAmount) {
/* 468 */     if (setTaxableAmount_noev(argTaxableAmount) && 
/* 469 */       this._events != null && 
/* 470 */       postEventsForChanges()) {
/* 471 */       this._events.post(ITaxLineItem.SET_TAXABLEAMOUNT, argTaxableAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxableAmount_noev(BigDecimal argTaxableAmount) {
/* 478 */     boolean ev_postable = false;
/*     */     
/* 480 */     if ((getDAO_().getTaxableAmount() == null && argTaxableAmount != null) || (
/* 481 */       getDAO_().getTaxableAmount() != null && !getDAO_().getTaxableAmount().equals(argTaxableAmount))) {
/* 482 */       getDAO_().setTaxableAmount(argTaxableAmount);
/* 483 */       ev_postable = true;
/*     */     } 
/*     */     
/* 486 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxGroupId() {
/* 494 */     return getDAO_().getTaxGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/* 502 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/* 503 */       this._events != null && 
/* 504 */       postEventsForChanges()) {
/* 505 */       this._events.post(ITaxLineItem.SET_TAXGROUPID, argTaxGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/* 512 */     boolean ev_postable = false;
/*     */     
/* 514 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/* 515 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/* 516 */       getDAO_().setTaxGroupId(argTaxGroupId);
/* 517 */       ev_postable = true;
/*     */     } 
/*     */     
/* 520 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxLocationId() {
/* 528 */     return getDAO_().getTaxLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/* 536 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/* 537 */       this._events != null && 
/* 538 */       postEventsForChanges()) {
/* 539 */       this._events.post(ITaxLineItem.SET_TAXLOCATIONID, argTaxLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/* 546 */     boolean ev_postable = false;
/*     */     
/* 548 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/* 549 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/* 550 */       getDAO_().setTaxLocationId(argTaxLocationId);
/* 551 */       ev_postable = true;
/*     */     } 
/*     */     
/* 554 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTaxRuleSequence() {
/* 562 */     if (getDAO_().getTaxRuleSequence() != null) {
/* 563 */       return getDAO_().getTaxRuleSequence().intValue();
/*     */     }
/*     */     
/* 566 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxRuleSequence(int argTaxRuleSequence) {
/* 575 */     if (setTaxRuleSequence_noev(argTaxRuleSequence) && 
/* 576 */       this._events != null && 
/* 577 */       postEventsForChanges()) {
/* 578 */       this._events.post(ITaxLineItem.SET_TAXRULESEQUENCE, Integer.valueOf(argTaxRuleSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxRuleSequence_noev(int argTaxRuleSequence) {
/* 585 */     boolean ev_postable = false;
/*     */     
/* 587 */     if ((getDAO_().getTaxRuleSequence() == null && Integer.valueOf(argTaxRuleSequence) != null) || (
/* 588 */       getDAO_().getTaxRuleSequence() != null && !getDAO_().getTaxRuleSequence().equals(Integer.valueOf(argTaxRuleSequence)))) {
/* 589 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argTaxRuleSequence));
/* 590 */       ev_postable = true;
/*     */     } 
/*     */     
/* 593 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthorityId() {
/* 601 */     return getDAO_().getAuthorityId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorityId(String argAuthorityId) {
/* 609 */     if (setAuthorityId_noev(argAuthorityId) && 
/* 610 */       this._events != null && 
/* 611 */       postEventsForChanges()) {
/* 612 */       this._events.post(ITaxLineItem.SET_AUTHORITYID, argAuthorityId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorityId_noev(String argAuthorityId) {
/* 619 */     boolean ev_postable = false;
/*     */     
/* 621 */     if ((getDAO_().getAuthorityId() == null && argAuthorityId != null) || (
/* 622 */       getDAO_().getAuthorityId() != null && !getDAO_().getAuthorityId().equals(argAuthorityId))) {
/* 623 */       getDAO_().setAuthorityId(argAuthorityId);
/* 624 */       ev_postable = true;
/*     */     } 
/*     */     
/* 627 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthorityName() {
/* 635 */     return getDAO_().getAuthorityName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorityName(String argAuthorityName) {
/* 643 */     if (setAuthorityName_noev(argAuthorityName) && 
/* 644 */       this._events != null && 
/* 645 */       postEventsForChanges()) {
/* 646 */       this._events.post(ITaxLineItem.SET_AUTHORITYNAME, argAuthorityName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorityName_noev(String argAuthorityName) {
/* 653 */     boolean ev_postable = false;
/*     */     
/* 655 */     if ((getDAO_().getAuthorityName() == null && argAuthorityName != null) || (
/* 656 */       getDAO_().getAuthorityName() != null && !getDAO_().getAuthorityName().equals(argAuthorityName))) {
/* 657 */       getDAO_().setAuthorityName(argAuthorityName);
/* 658 */       ev_postable = true;
/*     */     } 
/*     */     
/* 661 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthorityTypeCode() {
/* 669 */     return getDAO_().getAuthorityTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorityTypeCode(String argAuthorityTypeCode) {
/* 677 */     if (setAuthorityTypeCode_noev(argAuthorityTypeCode) && 
/* 678 */       this._events != null && 
/* 679 */       postEventsForChanges()) {
/* 680 */       this._events.post(ITaxLineItem.SET_AUTHORITYTYPECODE, argAuthorityTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorityTypeCode_noev(String argAuthorityTypeCode) {
/* 687 */     boolean ev_postable = false;
/*     */     
/* 689 */     if ((getDAO_().getAuthorityTypeCode() == null && argAuthorityTypeCode != null) || (
/* 690 */       getDAO_().getAuthorityTypeCode() != null && !getDAO_().getAuthorityTypeCode().equals(argAuthorityTypeCode))) {
/* 691 */       getDAO_().setAuthorityTypeCode(argAuthorityTypeCode);
/* 692 */       ev_postable = true;
/*     */     } 
/*     */     
/* 695 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "SaleTaxGroupRule")
/*     */   public ITaxGroupRule getSaleTaxGroupRule() {
/* 704 */     return this._saleTaxGroupRule;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaleTaxGroupRule(ITaxGroupRule argSaleTaxGroupRule) {
/* 709 */     if (argSaleTaxGroupRule == null) {
/*     */       
/* 711 */       getDAO_().setTaxGroupId(null);
/* 712 */       getDAO_().setTaxLocationId(null);
/* 713 */       getDAO_().setTaxRuleSequence(null);
/* 714 */       if (this._saleTaxGroupRule != null)
/*     */       {
/* 716 */         if (postEventsForChanges()) {
/* 717 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._saleTaxGroupRule));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 722 */       getDAO_().setTaxGroupId(argSaleTaxGroupRule.getTaxGroupId());
/* 723 */       getDAO_().setTaxLocationId(argSaleTaxGroupRule.getTaxLocationId());
/* 724 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argSaleTaxGroupRule.getTaxRuleSequence()));
/*     */       
/* 726 */       if (postEventsForChanges()) {
/* 727 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSaleTaxGroupRule));
/*     */       }
/*     */     } 
/*     */     
/* 731 */     this._saleTaxGroupRule = argSaleTaxGroupRule;
/* 732 */     if (postEventsForChanges()) {
/* 733 */       this._events.post(ITaxLineItem.SET_SALETAXGROUPRULE, argSaleTaxGroupRule);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 739 */     if ("SaleTaxGroupRule".equals(argFieldId)) {
/* 740 */       return getSaleTaxGroupRule();
/*     */     }
/* 742 */     if ("TaxLineItemExtension".equals(argFieldId)) {
/* 743 */       return this._myExtension;
/*     */     }
/*     */     
/* 746 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 752 */     if ("SaleTaxGroupRule".equals(argFieldId)) {
/* 753 */       setSaleTaxGroupRule((ITaxGroupRule)argValue);
/*     */     }
/* 755 */     else if ("TaxLineItemExtension".equals(argFieldId)) {
/* 756 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 759 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 765 */     super.setDependencies(argPD, argEM);
/* 766 */     if (this._saleTaxGroupRule != null) {
/* 767 */       ((IDataModelImpl)this._saleTaxGroupRule).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTaxLineItemExt() {
/* 772 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTaxLineItemExt(IDataModel argExt) {
/* 776 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 781 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 785 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 788 */     super.startTransaction();
/*     */     
/* 790 */     this._saleTaxGroupRuleSavepoint = this._saleTaxGroupRule;
/* 791 */     if (this._saleTaxGroupRule != null) {
/* 792 */       this._saleTaxGroupRule.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 796 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 801 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 804 */     super.rollbackChanges();
/*     */     
/* 806 */     this._saleTaxGroupRule = this._saleTaxGroupRuleSavepoint;
/* 807 */     this._saleTaxGroupRuleSavepoint = null;
/* 808 */     if (this._saleTaxGroupRule != null) {
/* 809 */       this._saleTaxGroupRule.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 816 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 819 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 822 */     super.commitTransaction();
/*     */     
/* 824 */     this._saleTaxGroupRuleSavepoint = this._saleTaxGroupRule;
/* 825 */     if (this._saleTaxGroupRule != null) {
/* 826 */       this._saleTaxGroupRule.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 830 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 835 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxDescription() {
/* 848 */     return (getSaleTaxGroupRule().getDescription() == null || getSaleTaxGroupRule().getDescription().length() == 0) ? "Tax" : 
/* 849 */       getSaleTaxGroupRule().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getRawTaxAmount() {
/* 856 */     return getLocalizedAmount(getRawTaxAmountImpl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRawTaxAmount(BigDecimal argRawTaxAmount) {
/* 863 */     BigDecimal relativeAmount = getRelativeAmount(argRawTaxAmount);
/* 864 */     setRawTaxAmountImpl(relativeAmount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTaxableAmount() {
/* 871 */     return getLocalizedAmount(getTaxableAmountImpl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxableAmount(BigDecimal argTaxableAmount) {
/* 878 */     BigDecimal relativeAmount = getRelativeAmount(argTaxableAmount);
/* 879 */     setTaxableAmountImpl(relativeAmount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/* 886 */     return getLocalizedAmount(getTaxAmountImpl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 893 */     BigDecimal relativeAmount = getRelativeAmount(argTaxAmount);
/* 894 */     setTaxAmountImpl(relativeAmount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTaxOverrideAmount() {
/* 901 */     return getLocalizedAmount(getTaxOverrideAmountImpl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxOverrideAmount(BigDecimal argTaxOverrideAmount) {
/* 908 */     BigDecimal relativeAmount = getRelativeAmount(argTaxOverrideAmount);
/* 909 */     setTaxOverrideAmountImpl(relativeAmount);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\TaxLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */