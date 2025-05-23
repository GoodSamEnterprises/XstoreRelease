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
/*     */ import dtv.xst.dao.inv.IInventoryMovementPendingDetailProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryMovementPendingDetailPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IInventoryMovementPendingDetailProperty
/*     */ {
/*     */   private static final long serialVersionUID = 128626034L;
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
/*  36 */     setDAO((IDataAccessObject)new InventoryMovementPendingDetailPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryMovementPendingDetailPropertyDAO getDAO_() {
/*  44 */     return (InventoryMovementPendingDetailPropertyDAO)this._daoImpl;
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
/*  65 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  66 */       this._events != null && 
/*  67 */       postEventsForChanges()) {
/*  68 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  78 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  79 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  80 */       ev_postable = true;
/*     */     } 
/*     */     
/*  83 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  91 */     if (getDAO_().getRetailLocationId() != null) {
/*  92 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  95 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 104 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 105 */       this._events != null && 
/* 106 */       postEventsForChanges()) {
/* 107 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 114 */     boolean ev_postable = false;
/*     */     
/* 116 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 117 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 118 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 119 */       ev_postable = true;
/*     */     } 
/*     */     
/* 122 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 130 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 138 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 139 */       this._events != null && 
/* 140 */       postEventsForChanges()) {
/* 141 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 148 */     boolean ev_postable = false;
/*     */     
/* 150 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 151 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 152 */       getDAO_().setBusinessDate(argBusinessDate);
/* 153 */       ev_postable = true;
/*     */     } 
/*     */     
/* 156 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 164 */     if (getDAO_().getWorkstationId() != null) {
/* 165 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 168 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 177 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 178 */       this._events != null && 
/* 179 */       postEventsForChanges()) {
/* 180 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 187 */     boolean ev_postable = false;
/*     */     
/* 189 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 190 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 191 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 192 */       ev_postable = true;
/*     */     } 
/*     */     
/* 195 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 203 */     if (getDAO_().getTransactionSequence() != null) {
/* 204 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 207 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 216 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 217 */       this._events != null && 
/* 218 */       postEventsForChanges()) {
/* 219 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 226 */     boolean ev_postable = false;
/*     */     
/* 228 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 229 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 230 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 231 */       ev_postable = true;
/*     */     } 
/*     */     
/* 234 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLineItemSequence() {
/* 242 */     if (getDAO_().getLineItemSequence() != null) {
/* 243 */       return getDAO_().getLineItemSequence().longValue();
/*     */     }
/*     */     
/* 246 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemSequence(long argLineItemSequence) {
/* 255 */     if (setLineItemSequence_noev(argLineItemSequence) && 
/* 256 */       this._events != null && 
/* 257 */       postEventsForChanges()) {
/* 258 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_LINEITEMSEQUENCE, Long.valueOf(argLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemSequence_noev(long argLineItemSequence) {
/* 265 */     boolean ev_postable = false;
/*     */     
/* 267 */     if ((getDAO_().getLineItemSequence() == null && Long.valueOf(argLineItemSequence) != null) || (
/* 268 */       getDAO_().getLineItemSequence() != null && !getDAO_().getLineItemSequence().equals(Long.valueOf(argLineItemSequence)))) {
/* 269 */       getDAO_().setLineItemSequence(Long.valueOf(argLineItemSequence));
/* 270 */       ev_postable = true;
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPendingSequence() {
/* 281 */     if (getDAO_().getPendingSequence() != null) {
/* 282 */       return getDAO_().getPendingSequence().longValue();
/*     */     }
/*     */     
/* 285 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPendingSequence(long argPendingSequence) {
/* 294 */     if (setPendingSequence_noev(argPendingSequence) && 
/* 295 */       this._events != null && 
/* 296 */       postEventsForChanges()) {
/* 297 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_PENDINGSEQUENCE, Long.valueOf(argPendingSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPendingSequence_noev(long argPendingSequence) {
/* 304 */     boolean ev_postable = false;
/*     */     
/* 306 */     if ((getDAO_().getPendingSequence() == null && Long.valueOf(argPendingSequence) != null) || (
/* 307 */       getDAO_().getPendingSequence() != null && !getDAO_().getPendingSequence().equals(Long.valueOf(argPendingSequence)))) {
/* 308 */       getDAO_().setPendingSequence(Long.valueOf(argPendingSequence));
/* 309 */       ev_postable = true;
/*     */     } 
/*     */     
/* 312 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 320 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 328 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 329 */       this._events != null && 
/* 330 */       postEventsForChanges()) {
/* 331 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 338 */     boolean ev_postable = false;
/*     */     
/* 340 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 341 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 342 */       getDAO_().setPropertyCode(argPropertyCode);
/* 343 */       ev_postable = true;
/*     */     } 
/*     */     
/* 346 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 354 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 362 */     if (setType_noev(argType) && 
/* 363 */       this._events != null && 
/* 364 */       postEventsForChanges()) {
/* 365 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 372 */     boolean ev_postable = false;
/*     */     
/* 374 */     if ((getDAO_().getType() == null && argType != null) || (
/* 375 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 376 */       getDAO_().setType(argType);
/* 377 */       ev_postable = true;
/*     */     } 
/*     */     
/* 380 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 388 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 396 */     if (setStringValue_noev(argStringValue) && 
/* 397 */       this._events != null && 
/* 398 */       postEventsForChanges()) {
/* 399 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 406 */     boolean ev_postable = false;
/*     */     
/* 408 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 409 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 410 */       getDAO_().setStringValue(argStringValue);
/* 411 */       ev_postable = true;
/*     */     } 
/*     */     
/* 414 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 422 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 430 */     if (setDateValue_noev(argDateValue) && 
/* 431 */       this._events != null && 
/* 432 */       postEventsForChanges()) {
/* 433 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 440 */     boolean ev_postable = false;
/*     */     
/* 442 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 443 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 444 */       getDAO_().setDateValue(argDateValue);
/* 445 */       ev_postable = true;
/*     */     } 
/*     */     
/* 448 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 456 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 464 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 465 */       this._events != null && 
/* 466 */       postEventsForChanges()) {
/* 467 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 474 */     boolean ev_postable = false;
/*     */     
/* 476 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 477 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 478 */       getDAO_().setDecimalValue(argDecimalValue);
/* 479 */       ev_postable = true;
/*     */     } 
/*     */     
/* 482 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 490 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 498 */     if (setCreateDate_noev(argCreateDate) && 
/* 499 */       this._events != null && 
/* 500 */       postEventsForChanges()) {
/* 501 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 508 */     boolean ev_postable = false;
/*     */     
/* 510 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 511 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 512 */       getDAO_().setCreateDate(argCreateDate);
/* 513 */       ev_postable = true;
/*     */     } 
/*     */     
/* 516 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 524 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 532 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 533 */       this._events != null && 
/* 534 */       postEventsForChanges()) {
/* 535 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 542 */     boolean ev_postable = false;
/*     */     
/* 544 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 545 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 546 */       getDAO_().setCreateUserId(argCreateUserId);
/* 547 */       ev_postable = true;
/*     */     } 
/*     */     
/* 550 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 558 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 566 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 567 */       this._events != null && 
/* 568 */       postEventsForChanges()) {
/* 569 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 576 */     boolean ev_postable = false;
/*     */     
/* 578 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 579 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 580 */       getDAO_().setUpdateDate(argUpdateDate);
/* 581 */       ev_postable = true;
/*     */     } 
/*     */     
/* 584 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 592 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 600 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 601 */       this._events != null && 
/* 602 */       postEventsForChanges()) {
/* 603 */       this._events.post(IInventoryMovementPendingDetailProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 610 */     boolean ev_postable = false;
/*     */     
/* 612 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 613 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 614 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 615 */       ev_postable = true;
/*     */     } 
/*     */     
/* 618 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 624 */     if ("InventoryMovementPendingDetailPropertyExtension".equals(argFieldId)) {
/* 625 */       return this._myExtension;
/*     */     }
/*     */     
/* 628 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 634 */     if ("InventoryMovementPendingDetailPropertyExtension".equals(argFieldId)) {
/* 635 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 638 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 644 */     this._persistenceDefaults = argPD;
/* 645 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 646 */     this._eventManager = argEM;
/* 647 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 648 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 653 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 657 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 660 */     super.startTransaction();
/*     */ 
/*     */     
/* 663 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 668 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 671 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 677 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 680 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 683 */     super.commitTransaction();
/*     */ 
/*     */     
/* 686 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 691 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingDetailPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */