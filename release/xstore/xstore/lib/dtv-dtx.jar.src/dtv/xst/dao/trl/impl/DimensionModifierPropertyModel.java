/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.xst.dao.trl.IDimensionModifierProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DimensionModifierPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IDimensionModifierProperty
/*     */ {
/*     */   private static final long serialVersionUID = 167379762L;
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
/*  36 */     setDAO((IDataAccessObject)new DimensionModifierPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DimensionModifierPropertyDAO getDAO_() {
/*  44 */     return (DimensionModifierPropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  52 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  60 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  61 */       this._events != null && 
/*  62 */       postEventsForChanges()) {
/*  63 */       this._events.post(IDimensionModifierProperty.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  70 */     boolean ev_postable = false;
/*     */     
/*  72 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  73 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  74 */       getDAO_().setBusinessDate(argBusinessDate);
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
/*     */   public String getDimensionCode() {
/*  86 */     return getDAO_().getDimensionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimensionCode(String argDimensionCode) {
/*  94 */     if (setDimensionCode_noev(argDimensionCode) && 
/*  95 */       this._events != null && 
/*  96 */       postEventsForChanges()) {
/*  97 */       this._events.post(IDimensionModifierProperty.SET_DIMENSIONCODE, argDimensionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDimensionCode_noev(String argDimensionCode) {
/* 104 */     boolean ev_postable = false;
/*     */     
/* 106 */     if ((getDAO_().getDimensionCode() == null && argDimensionCode != null) || (
/* 107 */       getDAO_().getDimensionCode() != null && !getDAO_().getDimensionCode().equals(argDimensionCode))) {
/* 108 */       getDAO_().setDimensionCode(argDimensionCode);
/* 109 */       ev_postable = true;
/*     */     } 
/*     */     
/* 112 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 120 */     if (getDAO_().getOrganizationId() != null) {
/* 121 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 124 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 133 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 134 */       this._events != null && 
/* 135 */       postEventsForChanges()) {
/* 136 */       this._events.post(IDimensionModifierProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 143 */     boolean ev_postable = false;
/*     */     
/* 145 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 146 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 147 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
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
/*     */   public long getRetailLocationId() {
/* 159 */     if (getDAO_().getRetailLocationId() != null) {
/* 160 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 163 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 172 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 173 */       this._events != null && 
/* 174 */       postEventsForChanges()) {
/* 175 */       this._events.post(IDimensionModifierProperty.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 182 */     boolean ev_postable = false;
/*     */     
/* 184 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 185 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 186 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 187 */       ev_postable = true;
/*     */     } 
/*     */     
/* 190 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRetailTransactionLineItemSequence() {
/* 198 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 199 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 202 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 211 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 212 */       this._events != null && 
/* 213 */       postEventsForChanges()) {
/* 214 */       this._events.post(IDimensionModifierProperty.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 221 */     boolean ev_postable = false;
/*     */     
/* 223 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 224 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 225 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 226 */       ev_postable = true;
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 237 */     if (getDAO_().getTransactionSequence() != null) {
/* 238 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 241 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 250 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IDimensionModifierProperty.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 263 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 264 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 265 */       ev_postable = true;
/*     */     } 
/*     */     
/* 268 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 276 */     if (getDAO_().getWorkstationId() != null) {
/* 277 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 280 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 289 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(IDimensionModifierProperty.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 302 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 303 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 304 */       ev_postable = true;
/*     */     } 
/*     */     
/* 307 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 315 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 323 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 324 */       this._events != null && 
/* 325 */       postEventsForChanges()) {
/* 326 */       this._events.post(IDimensionModifierProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 333 */     boolean ev_postable = false;
/*     */     
/* 335 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 336 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 337 */       getDAO_().setPropertyCode(argPropertyCode);
/* 338 */       ev_postable = true;
/*     */     } 
/*     */     
/* 341 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 349 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 357 */     if (setType_noev(argType) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(IDimensionModifierProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getType() == null && argType != null) || (
/* 370 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 371 */       getDAO_().setType(argType);
/* 372 */       ev_postable = true;
/*     */     } 
/*     */     
/* 375 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 383 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 391 */     if (setStringValue_noev(argStringValue) && 
/* 392 */       this._events != null && 
/* 393 */       postEventsForChanges()) {
/* 394 */       this._events.post(IDimensionModifierProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 401 */     boolean ev_postable = false;
/*     */     
/* 403 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 404 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 405 */       getDAO_().setStringValue(argStringValue);
/* 406 */       ev_postable = true;
/*     */     } 
/*     */     
/* 409 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 417 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 425 */     if (setDateValue_noev(argDateValue) && 
/* 426 */       this._events != null && 
/* 427 */       postEventsForChanges()) {
/* 428 */       this._events.post(IDimensionModifierProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 435 */     boolean ev_postable = false;
/*     */     
/* 437 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 438 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 439 */       getDAO_().setDateValue(argDateValue);
/* 440 */       ev_postable = true;
/*     */     } 
/*     */     
/* 443 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 451 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 459 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 460 */       this._events != null && 
/* 461 */       postEventsForChanges()) {
/* 462 */       this._events.post(IDimensionModifierProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 469 */     boolean ev_postable = false;
/*     */     
/* 471 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 472 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 473 */       getDAO_().setDecimalValue(argDecimalValue);
/* 474 */       ev_postable = true;
/*     */     } 
/*     */     
/* 477 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 485 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 493 */     if (setCreateDate_noev(argCreateDate) && 
/* 494 */       this._events != null && 
/* 495 */       postEventsForChanges()) {
/* 496 */       this._events.post(IDimensionModifierProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 503 */     boolean ev_postable = false;
/*     */     
/* 505 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 506 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 507 */       getDAO_().setCreateDate(argCreateDate);
/* 508 */       ev_postable = true;
/*     */     } 
/*     */     
/* 511 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 519 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 527 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 528 */       this._events != null && 
/* 529 */       postEventsForChanges()) {
/* 530 */       this._events.post(IDimensionModifierProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 537 */     boolean ev_postable = false;
/*     */     
/* 539 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 540 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 541 */       getDAO_().setCreateUserId(argCreateUserId);
/* 542 */       ev_postable = true;
/*     */     } 
/*     */     
/* 545 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 553 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 561 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 562 */       this._events != null && 
/* 563 */       postEventsForChanges()) {
/* 564 */       this._events.post(IDimensionModifierProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 571 */     boolean ev_postable = false;
/*     */     
/* 573 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 574 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 575 */       getDAO_().setUpdateDate(argUpdateDate);
/* 576 */       ev_postable = true;
/*     */     } 
/*     */     
/* 579 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 587 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 595 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 596 */       this._events != null && 
/* 597 */       postEventsForChanges()) {
/* 598 */       this._events.post(IDimensionModifierProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 605 */     boolean ev_postable = false;
/*     */     
/* 607 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 608 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 609 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 610 */       ev_postable = true;
/*     */     } 
/*     */     
/* 613 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 619 */     if ("DimensionModifierPropertyExtension".equals(argFieldId)) {
/* 620 */       return this._myExtension;
/*     */     }
/*     */     
/* 623 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 629 */     if ("DimensionModifierPropertyExtension".equals(argFieldId)) {
/* 630 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 633 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 639 */     this._persistenceDefaults = argPD;
/* 640 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 641 */     this._eventManager = argEM;
/* 642 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 643 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 648 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 652 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 655 */     super.startTransaction();
/*     */ 
/*     */     
/* 658 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 663 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 666 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 672 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 675 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 678 */     super.commitTransaction();
/*     */ 
/*     */     
/* 681 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 686 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DimensionModifierPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */