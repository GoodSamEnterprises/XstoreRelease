/*     */ package dtv.xst.dao.inv.impl;
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
/*     */ import dtv.xst.dao.inv.IInventorySummaryCountTransactionDetailProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventorySummaryCountTransactionDetailPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IInventorySummaryCountTransactionDetailProperty
/*     */ {
/*     */   private static final long serialVersionUID = -2047589665L;
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
/*  36 */     setDAO((IDataAccessObject)new InventorySummaryCountTransactionDetailPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventorySummaryCountTransactionDetailPropertyDAO getDAO_() {
/*  44 */     return (InventorySummaryCountTransactionDetailPropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  52 */     if (getDAO_().getOrganizationId() != null) {
/*  53 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  56 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  65 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  71 */     boolean ev_postable = false;
/*     */     
/*  73 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  74 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  75 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  76 */       ev_postable = true;
/*     */     } 
/*     */     
/*  79 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  87 */     if (getDAO_().getRetailLocationId() != null) {
/*  88 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  91 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 100 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 106 */     boolean ev_postable = false;
/*     */     
/* 108 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 109 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 110 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 111 */       ev_postable = true;
/*     */     } 
/*     */     
/* 114 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 122 */     if (getDAO_().getWorkstationId() != null) {
/* 123 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 126 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 135 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 141 */     boolean ev_postable = false;
/*     */     
/* 143 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 144 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 145 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 146 */       ev_postable = true;
/*     */     } 
/*     */     
/* 149 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 157 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 165 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 166 */       this._events != null && 
/* 167 */       postEventsForChanges()) {
/* 168 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 175 */     boolean ev_postable = false;
/*     */     
/* 177 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 178 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 179 */       getDAO_().setBusinessDate(argBusinessDate);
/* 180 */       ev_postable = true;
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 191 */     if (getDAO_().getTransactionSequence() != null) {
/* 192 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 195 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 204 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 205 */       this._events != null && 
/* 206 */       postEventsForChanges()) {
/* 207 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 214 */     boolean ev_postable = false;
/*     */     
/* 216 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 217 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 218 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 219 */       ev_postable = true;
/*     */     } 
/*     */     
/* 222 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTransLineSequence() {
/* 230 */     if (getDAO_().getTransLineSequence() != null) {
/* 231 */       return getDAO_().getTransLineSequence().intValue();
/*     */     }
/*     */     
/* 234 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransLineSequence(int argTransLineSequence) {
/* 243 */     if (setTransLineSequence_noev(argTransLineSequence) && 
/* 244 */       this._events != null && 
/* 245 */       postEventsForChanges()) {
/* 246 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_TRANSLINESEQUENCE, Integer.valueOf(argTransLineSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransLineSequence_noev(int argTransLineSequence) {
/* 253 */     boolean ev_postable = false;
/*     */     
/* 255 */     if ((getDAO_().getTransLineSequence() == null && Integer.valueOf(argTransLineSequence) != null) || (
/* 256 */       getDAO_().getTransLineSequence() != null && !getDAO_().getTransLineSequence().equals(Integer.valueOf(argTransLineSequence)))) {
/* 257 */       getDAO_().setTransLineSequence(Integer.valueOf(argTransLineSequence));
/* 258 */       ev_postable = true;
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 269 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 277 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 290 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 291 */       getDAO_().setPropertyCode(argPropertyCode);
/* 292 */       ev_postable = true;
/*     */     } 
/*     */     
/* 295 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 303 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 311 */     if (setType_noev(argType) && 
/* 312 */       this._events != null && 
/* 313 */       postEventsForChanges()) {
/* 314 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 321 */     boolean ev_postable = false;
/*     */     
/* 323 */     if ((getDAO_().getType() == null && argType != null) || (
/* 324 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 325 */       getDAO_().setType(argType);
/* 326 */       ev_postable = true;
/*     */     } 
/*     */     
/* 329 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 337 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 345 */     if (setStringValue_noev(argStringValue) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 358 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 359 */       getDAO_().setStringValue(argStringValue);
/* 360 */       ev_postable = true;
/*     */     } 
/*     */     
/* 363 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 371 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 379 */     if (setDateValue_noev(argDateValue) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 392 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 393 */       getDAO_().setDateValue(argDateValue);
/* 394 */       ev_postable = true;
/*     */     } 
/*     */     
/* 397 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 405 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 413 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 414 */       this._events != null && 
/* 415 */       postEventsForChanges()) {
/* 416 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 423 */     boolean ev_postable = false;
/*     */     
/* 425 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 426 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 427 */       getDAO_().setDecimalValue(argDecimalValue);
/* 428 */       ev_postable = true;
/*     */     } 
/*     */     
/* 431 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 439 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 447 */     if (setCreateDate_noev(argCreateDate) && 
/* 448 */       this._events != null && 
/* 449 */       postEventsForChanges()) {
/* 450 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 457 */     boolean ev_postable = false;
/*     */     
/* 459 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 460 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 461 */       getDAO_().setCreateDate(argCreateDate);
/* 462 */       ev_postable = true;
/*     */     } 
/*     */     
/* 465 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 473 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 481 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 482 */       this._events != null && 
/* 483 */       postEventsForChanges()) {
/* 484 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 491 */     boolean ev_postable = false;
/*     */     
/* 493 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 494 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 495 */       getDAO_().setCreateUserId(argCreateUserId);
/* 496 */       ev_postable = true;
/*     */     } 
/*     */     
/* 499 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 507 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 515 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 516 */       this._events != null && 
/* 517 */       postEventsForChanges()) {
/* 518 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 525 */     boolean ev_postable = false;
/*     */     
/* 527 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 528 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 529 */       getDAO_().setUpdateDate(argUpdateDate);
/* 530 */       ev_postable = true;
/*     */     } 
/*     */     
/* 533 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 541 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 549 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 550 */       this._events != null && 
/* 551 */       postEventsForChanges()) {
/* 552 */       this._events.post(IInventorySummaryCountTransactionDetailProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 559 */     boolean ev_postable = false;
/*     */     
/* 561 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 562 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 563 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 564 */       ev_postable = true;
/*     */     } 
/*     */     
/* 567 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 573 */     if ("InventorySummaryCountTransactionDetailPropertyExtension".equals(argFieldId)) {
/* 574 */       return this._myExtension;
/*     */     }
/*     */     
/* 577 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 583 */     if ("InventorySummaryCountTransactionDetailPropertyExtension".equals(argFieldId)) {
/* 584 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 587 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 593 */     this._persistenceDefaults = argPD;
/* 594 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 595 */     this._eventManager = argEM;
/* 596 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 597 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 602 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 606 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 609 */     super.startTransaction();
/*     */ 
/*     */     
/* 612 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 617 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 620 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 626 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 629 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 632 */     super.commitTransaction();
/*     */ 
/*     */     
/* 635 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 640 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventorySummaryCountTransactionDetailPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */