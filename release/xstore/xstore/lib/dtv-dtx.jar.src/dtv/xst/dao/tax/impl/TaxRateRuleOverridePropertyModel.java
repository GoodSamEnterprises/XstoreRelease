/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelPropertiesImpl;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.xst.dao.tax.ITaxRateRuleOverrideProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaxRateRuleOverridePropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements ITaxRateRuleOverrideProperty
/*     */ {
/*     */   private static final long serialVersionUID = -1185365880L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  31 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initDAO() {
/*  36 */     setDAO((IDataAccessObject)new TaxRateRuleOverridePropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxRateRuleOverridePropertyDAO getDAO_() {
/*  44 */     return (TaxRateRuleOverridePropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDatetimestamp() {
/*  52 */     return getDAO_().getExpirationDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDatetimestamp(Date argExpirationDatetimestamp) {
/*  60 */     if (setExpirationDatetimestamp_noev(argExpirationDatetimestamp) && 
/*  61 */       this._events != null && 
/*  62 */       postEventsForChanges()) {
/*  63 */       this._events.post(ITaxRateRuleOverrideProperty.SET_EXPIRATIONDATETIMESTAMP, argExpirationDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDatetimestamp_noev(Date argExpirationDatetimestamp) {
/*  70 */     boolean ev_postable = false;
/*     */     
/*  72 */     if ((getDAO_().getExpirationDatetimestamp() == null && argExpirationDatetimestamp != null) || (
/*  73 */       getDAO_().getExpirationDatetimestamp() != null && !getDAO_().getExpirationDatetimestamp().equals(argExpirationDatetimestamp))) {
/*  74 */       getDAO_().setExpirationDatetimestamp(argExpirationDatetimestamp);
/*  75 */       ev_postable = true;
/*     */     } 
/*     */     
/*  78 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  86 */     if (getDAO_().getOrganizationId() != null) {
/*  87 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  90 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  99 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 100 */       this._events != null && 
/* 101 */       postEventsForChanges()) {
/* 102 */       this._events.post(ITaxRateRuleOverrideProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 109 */     boolean ev_postable = false;
/*     */     
/* 111 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 112 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 113 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 114 */       ev_postable = true;
/*     */     } 
/*     */     
/* 117 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxGroupId() {
/* 125 */     return getDAO_().getTaxGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/* 133 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/* 134 */       this._events != null && 
/* 135 */       postEventsForChanges()) {
/* 136 */       this._events.post(ITaxRateRuleOverrideProperty.SET_TAXGROUPID, argTaxGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/* 143 */     boolean ev_postable = false;
/*     */     
/* 145 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/* 146 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/* 147 */       getDAO_().setTaxGroupId(argTaxGroupId);
/* 148 */       ev_postable = true;
/*     */     } 
/*     */     
/* 151 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxLocationId() {
/* 159 */     return getDAO_().getTaxLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/* 167 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/* 168 */       this._events != null && 
/* 169 */       postEventsForChanges()) {
/* 170 */       this._events.post(ITaxRateRuleOverrideProperty.SET_TAXLOCATIONID, argTaxLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/* 177 */     boolean ev_postable = false;
/*     */     
/* 179 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/* 180 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/* 181 */       getDAO_().setTaxLocationId(argTaxLocationId);
/* 182 */       ev_postable = true;
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTaxRateRuleSequence() {
/* 193 */     if (getDAO_().getTaxRateRuleSequence() != null) {
/* 194 */       return getDAO_().getTaxRateRuleSequence().intValue();
/*     */     }
/*     */     
/* 197 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxRateRuleSequence(int argTaxRateRuleSequence) {
/* 206 */     if (setTaxRateRuleSequence_noev(argTaxRateRuleSequence) && 
/* 207 */       this._events != null && 
/* 208 */       postEventsForChanges()) {
/* 209 */       this._events.post(ITaxRateRuleOverrideProperty.SET_TAXRATERULESEQUENCE, Integer.valueOf(argTaxRateRuleSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxRateRuleSequence_noev(int argTaxRateRuleSequence) {
/* 216 */     boolean ev_postable = false;
/*     */     
/* 218 */     if ((getDAO_().getTaxRateRuleSequence() == null && Integer.valueOf(argTaxRateRuleSequence) != null) || (
/* 219 */       getDAO_().getTaxRateRuleSequence() != null && !getDAO_().getTaxRateRuleSequence().equals(Integer.valueOf(argTaxRateRuleSequence)))) {
/* 220 */       getDAO_().setTaxRateRuleSequence(Integer.valueOf(argTaxRateRuleSequence));
/* 221 */       ev_postable = true;
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTaxRuleSequence() {
/* 232 */     if (getDAO_().getTaxRuleSequence() != null) {
/* 233 */       return getDAO_().getTaxRuleSequence().intValue();
/*     */     }
/*     */     
/* 236 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxRuleSequence(int argTaxRuleSequence) {
/* 245 */     if (setTaxRuleSequence_noev(argTaxRuleSequence) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(ITaxRateRuleOverrideProperty.SET_TAXRULESEQUENCE, Integer.valueOf(argTaxRuleSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxRuleSequence_noev(int argTaxRuleSequence) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getTaxRuleSequence() == null && Integer.valueOf(argTaxRuleSequence) != null) || (
/* 258 */       getDAO_().getTaxRuleSequence() != null && !getDAO_().getTaxRuleSequence().equals(Integer.valueOf(argTaxRuleSequence)))) {
/* 259 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argTaxRuleSequence));
/* 260 */       ev_postable = true;
/*     */     } 
/*     */     
/* 263 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 271 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 279 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(ITaxRateRuleOverrideProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 292 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 293 */       getDAO_().setPropertyCode(argPropertyCode);
/* 294 */       ev_postable = true;
/*     */     } 
/*     */     
/* 297 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 305 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 313 */     if (setType_noev(argType) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(ITaxRateRuleOverrideProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getType() == null && argType != null) || (
/* 326 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 327 */       getDAO_().setType(argType);
/* 328 */       ev_postable = true;
/*     */     } 
/*     */     
/* 331 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 339 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 347 */     if (setStringValue_noev(argStringValue) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(ITaxRateRuleOverrideProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 360 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 361 */       getDAO_().setStringValue(argStringValue);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 373 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 381 */     if (setDateValue_noev(argDateValue) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(ITaxRateRuleOverrideProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 394 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 395 */       getDAO_().setDateValue(argDateValue);
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 407 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 415 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(ITaxRateRuleOverrideProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 428 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 429 */       getDAO_().setDecimalValue(argDecimalValue);
/* 430 */       ev_postable = true;
/*     */     } 
/*     */     
/* 433 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 441 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 449 */     if (setCreateDate_noev(argCreateDate) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(ITaxRateRuleOverrideProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 462 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 463 */       getDAO_().setCreateDate(argCreateDate);
/* 464 */       ev_postable = true;
/*     */     } 
/*     */     
/* 467 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 475 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 483 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 484 */       this._events != null && 
/* 485 */       postEventsForChanges()) {
/* 486 */       this._events.post(ITaxRateRuleOverrideProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 493 */     boolean ev_postable = false;
/*     */     
/* 495 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 496 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 497 */       getDAO_().setCreateUserId(argCreateUserId);
/* 498 */       ev_postable = true;
/*     */     } 
/*     */     
/* 501 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 509 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 517 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 518 */       this._events != null && 
/* 519 */       postEventsForChanges()) {
/* 520 */       this._events.post(ITaxRateRuleOverrideProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 527 */     boolean ev_postable = false;
/*     */     
/* 529 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 530 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 531 */       getDAO_().setUpdateDate(argUpdateDate);
/* 532 */       ev_postable = true;
/*     */     } 
/*     */     
/* 535 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 543 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 551 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 552 */       this._events != null && 
/* 553 */       postEventsForChanges()) {
/* 554 */       this._events.post(ITaxRateRuleOverrideProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 561 */     boolean ev_postable = false;
/*     */     
/* 563 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 564 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 565 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 566 */       ev_postable = true;
/*     */     } 
/*     */     
/* 569 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 575 */     if ("TaxRateRuleOverridePropertyExtension".equals(argFieldId)) {
/* 576 */       return this._myExtension;
/*     */     }
/*     */     
/* 579 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 585 */     if ("TaxRateRuleOverridePropertyExtension".equals(argFieldId)) {
/* 586 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 589 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 595 */     this._persistenceDefaults = argPD;
/* 596 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 597 */     this._eventManager = argEM;
/* 598 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 599 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 604 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 608 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 611 */     super.startTransaction();
/*     */ 
/*     */     
/* 614 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 619 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 622 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 628 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 631 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 634 */     super.commitTransaction();
/*     */ 
/*     */     
/* 637 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 642 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleOverridePropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */