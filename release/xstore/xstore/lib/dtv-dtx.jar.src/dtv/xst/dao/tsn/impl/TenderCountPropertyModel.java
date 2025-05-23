/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.xst.dao.tsn.ITenderCountProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderCountPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements ITenderCountProperty
/*     */ {
/*     */   private static final long serialVersionUID = -1781313168L;
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
/*  36 */     setDAO((IDataAccessObject)new TenderCountPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderCountPropertyDAO getDAO_() {
/*  44 */     return (TenderCountPropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  52 */     return getDAO_().getBusinessDayDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  60 */     if (setBusinessDayDate_noev(argBusinessDayDate) && 
/*  61 */       this._events != null && 
/*  62 */       postEventsForChanges()) {
/*  63 */       this._events.post(ITenderCountProperty.SET_BUSINESSDAYDATE, argBusinessDayDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDayDate_noev(Date argBusinessDayDate) {
/*  70 */     boolean ev_postable = false;
/*     */     
/*  72 */     if ((getDAO_().getBusinessDayDate() == null && argBusinessDayDate != null) || (
/*  73 */       getDAO_().getBusinessDayDate() != null && !getDAO_().getBusinessDayDate().equals(argBusinessDayDate))) {
/*  74 */       getDAO_().setBusinessDayDate(argBusinessDayDate);
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
/* 102 */       this._events.post(ITenderCountProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*     */   public long getRetailLocationId() {
/* 125 */     if (getDAO_().getRetailLocationId() != null) {
/* 126 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 129 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 138 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 139 */       this._events != null && 
/* 140 */       postEventsForChanges()) {
/* 141 */       this._events.post(ITenderCountProperty.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 148 */     boolean ev_postable = false;
/*     */     
/* 150 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 151 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 152 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
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
/*     */   public String getTenderId() {
/* 164 */     return getDAO_().getTenderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 172 */     if (setTenderId_noev(argTenderId) && 
/* 173 */       this._events != null && 
/* 174 */       postEventsForChanges()) {
/* 175 */       this._events.post(ITenderCountProperty.SET_TENDERID, argTenderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderId_noev(String argTenderId) {
/* 182 */     boolean ev_postable = false;
/*     */     
/* 184 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/* 185 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/* 186 */       getDAO_().setTenderId(argTenderId);
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
/*     */   public String getTenderTypeCode() {
/* 198 */     return getDAO_().getTenderTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/* 206 */     if (setTenderTypeCode_noev(argTenderTypeCode) && 
/* 207 */       this._events != null && 
/* 208 */       postEventsForChanges()) {
/* 209 */       this._events.post(ITenderCountProperty.SET_TENDERTYPECODE, argTenderTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderTypeCode_noev(String argTenderTypeCode) {
/* 216 */     boolean ev_postable = false;
/*     */     
/* 218 */     if ((getDAO_().getTenderTypeCode() == null && argTenderTypeCode != null) || (
/* 219 */       getDAO_().getTenderTypeCode() != null && !getDAO_().getTenderTypeCode().equals(argTenderTypeCode))) {
/* 220 */       getDAO_().setTenderTypeCode(argTenderTypeCode);
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
/*     */   public long getTransactionSequence() {
/* 232 */     if (getDAO_().getTransactionSequence() != null) {
/* 233 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 236 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 245 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(ITenderCountProperty.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 258 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 259 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
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
/*     */   public long getWorkstationId() {
/* 271 */     if (getDAO_().getWorkstationId() != null) {
/* 272 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 275 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 284 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 285 */       this._events != null && 
/* 286 */       postEventsForChanges()) {
/* 287 */       this._events.post(ITenderCountProperty.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 294 */     boolean ev_postable = false;
/*     */     
/* 296 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 297 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 298 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 299 */       ev_postable = true;
/*     */     } 
/*     */     
/* 302 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 310 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 318 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 319 */       this._events != null && 
/* 320 */       postEventsForChanges()) {
/* 321 */       this._events.post(ITenderCountProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 328 */     boolean ev_postable = false;
/*     */     
/* 330 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 331 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 332 */       getDAO_().setPropertyCode(argPropertyCode);
/* 333 */       ev_postable = true;
/*     */     } 
/*     */     
/* 336 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 344 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 352 */     if (setType_noev(argType) && 
/* 353 */       this._events != null && 
/* 354 */       postEventsForChanges()) {
/* 355 */       this._events.post(ITenderCountProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 362 */     boolean ev_postable = false;
/*     */     
/* 364 */     if ((getDAO_().getType() == null && argType != null) || (
/* 365 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 366 */       getDAO_().setType(argType);
/* 367 */       ev_postable = true;
/*     */     } 
/*     */     
/* 370 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 378 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 386 */     if (setStringValue_noev(argStringValue) && 
/* 387 */       this._events != null && 
/* 388 */       postEventsForChanges()) {
/* 389 */       this._events.post(ITenderCountProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 396 */     boolean ev_postable = false;
/*     */     
/* 398 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 399 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 400 */       getDAO_().setStringValue(argStringValue);
/* 401 */       ev_postable = true;
/*     */     } 
/*     */     
/* 404 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 412 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 420 */     if (setDateValue_noev(argDateValue) && 
/* 421 */       this._events != null && 
/* 422 */       postEventsForChanges()) {
/* 423 */       this._events.post(ITenderCountProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 430 */     boolean ev_postable = false;
/*     */     
/* 432 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 433 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 434 */       getDAO_().setDateValue(argDateValue);
/* 435 */       ev_postable = true;
/*     */     } 
/*     */     
/* 438 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 446 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 454 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 455 */       this._events != null && 
/* 456 */       postEventsForChanges()) {
/* 457 */       this._events.post(ITenderCountProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 464 */     boolean ev_postable = false;
/*     */     
/* 466 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 467 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 468 */       getDAO_().setDecimalValue(argDecimalValue);
/* 469 */       ev_postable = true;
/*     */     } 
/*     */     
/* 472 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 480 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 488 */     if (setCreateDate_noev(argCreateDate) && 
/* 489 */       this._events != null && 
/* 490 */       postEventsForChanges()) {
/* 491 */       this._events.post(ITenderCountProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 498 */     boolean ev_postable = false;
/*     */     
/* 500 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 501 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 502 */       getDAO_().setCreateDate(argCreateDate);
/* 503 */       ev_postable = true;
/*     */     } 
/*     */     
/* 506 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 514 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 522 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 523 */       this._events != null && 
/* 524 */       postEventsForChanges()) {
/* 525 */       this._events.post(ITenderCountProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 532 */     boolean ev_postable = false;
/*     */     
/* 534 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 535 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 536 */       getDAO_().setCreateUserId(argCreateUserId);
/* 537 */       ev_postable = true;
/*     */     } 
/*     */     
/* 540 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 548 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 556 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 557 */       this._events != null && 
/* 558 */       postEventsForChanges()) {
/* 559 */       this._events.post(ITenderCountProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 566 */     boolean ev_postable = false;
/*     */     
/* 568 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 569 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 570 */       getDAO_().setUpdateDate(argUpdateDate);
/* 571 */       ev_postable = true;
/*     */     } 
/*     */     
/* 574 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 582 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 590 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 591 */       this._events != null && 
/* 592 */       postEventsForChanges()) {
/* 593 */       this._events.post(ITenderCountProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 600 */     boolean ev_postable = false;
/*     */     
/* 602 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 603 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 604 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 605 */       ev_postable = true;
/*     */     } 
/*     */     
/* 608 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 614 */     if ("TenderCountPropertyExtension".equals(argFieldId)) {
/* 615 */       return this._myExtension;
/*     */     }
/*     */     
/* 618 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 624 */     if ("TenderCountPropertyExtension".equals(argFieldId)) {
/* 625 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 628 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 634 */     this._persistenceDefaults = argPD;
/* 635 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 636 */     this._eventManager = argEM;
/* 637 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 638 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 643 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 647 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 650 */     super.startTransaction();
/*     */ 
/*     */     
/* 653 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 658 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 661 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 667 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 670 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 673 */     super.commitTransaction();
/*     */ 
/*     */     
/* 676 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 681 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderCountPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */