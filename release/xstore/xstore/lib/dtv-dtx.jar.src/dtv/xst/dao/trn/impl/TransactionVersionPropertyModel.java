/*     */ package dtv.xst.dao.trn.impl;
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
/*     */ import dtv.xst.dao.trn.ITransactionVersionProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransactionVersionPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements ITransactionVersionProperty
/*     */ {
/*     */   private static final long serialVersionUID = -926502865L;
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
/*  36 */     setDAO((IDataAccessObject)new TransactionVersionPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TransactionVersionPropertyDAO getDAO_() {
/*  44 */     return (TransactionVersionPropertyDAO)this._daoImpl;
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
/*  68 */       this._events.post(ITransactionVersionProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 107 */       this._events.post(ITransactionVersionProperty.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 141 */       this._events.post(ITransactionVersionProperty.SET_BUSINESSDATE, argBusinessDate);
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
/* 180 */       this._events.post(ITransactionVersionProperty.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
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
/* 219 */       this._events.post(ITransactionVersionProperty.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/*     */   public String getPropertyCode() {
/* 242 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 250 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(ITransactionVersionProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 263 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 264 */       getDAO_().setPropertyCode(argPropertyCode);
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
/*     */   public String getType() {
/* 276 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 284 */     if (setType_noev(argType) && 
/* 285 */       this._events != null && 
/* 286 */       postEventsForChanges()) {
/* 287 */       this._events.post(ITransactionVersionProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 294 */     boolean ev_postable = false;
/*     */     
/* 296 */     if ((getDAO_().getType() == null && argType != null) || (
/* 297 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 298 */       getDAO_().setType(argType);
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
/*     */   public String getStringValue() {
/* 310 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 318 */     if (setStringValue_noev(argStringValue) && 
/* 319 */       this._events != null && 
/* 320 */       postEventsForChanges()) {
/* 321 */       this._events.post(ITransactionVersionProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 328 */     boolean ev_postable = false;
/*     */     
/* 330 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 331 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 332 */       getDAO_().setStringValue(argStringValue);
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
/*     */   public Date getDateValue() {
/* 344 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 352 */     if (setDateValue_noev(argDateValue) && 
/* 353 */       this._events != null && 
/* 354 */       postEventsForChanges()) {
/* 355 */       this._events.post(ITransactionVersionProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 362 */     boolean ev_postable = false;
/*     */     
/* 364 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 365 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 366 */       getDAO_().setDateValue(argDateValue);
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
/*     */   public BigDecimal getDecimalValue() {
/* 378 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 386 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 387 */       this._events != null && 
/* 388 */       postEventsForChanges()) {
/* 389 */       this._events.post(ITransactionVersionProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 396 */     boolean ev_postable = false;
/*     */     
/* 398 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 399 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 400 */       getDAO_().setDecimalValue(argDecimalValue);
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
/*     */   public Date getCreateDate() {
/* 412 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 420 */     if (setCreateDate_noev(argCreateDate) && 
/* 421 */       this._events != null && 
/* 422 */       postEventsForChanges()) {
/* 423 */       this._events.post(ITransactionVersionProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 430 */     boolean ev_postable = false;
/*     */     
/* 432 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 433 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 434 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 446 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 454 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 455 */       this._events != null && 
/* 456 */       postEventsForChanges()) {
/* 457 */       this._events.post(ITransactionVersionProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 464 */     boolean ev_postable = false;
/*     */     
/* 466 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 467 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 468 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 480 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 488 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 489 */       this._events != null && 
/* 490 */       postEventsForChanges()) {
/* 491 */       this._events.post(ITransactionVersionProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 498 */     boolean ev_postable = false;
/*     */     
/* 500 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 501 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 502 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 514 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 522 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 523 */       this._events != null && 
/* 524 */       postEventsForChanges()) {
/* 525 */       this._events.post(ITransactionVersionProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 532 */     boolean ev_postable = false;
/*     */     
/* 534 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 535 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 536 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 537 */       ev_postable = true;
/*     */     } 
/*     */     
/* 540 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 546 */     if ("TransactionVersionPropertyExtension".equals(argFieldId)) {
/* 547 */       return this._myExtension;
/*     */     }
/*     */     
/* 550 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 556 */     if ("TransactionVersionPropertyExtension".equals(argFieldId)) {
/* 557 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 560 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 566 */     this._persistenceDefaults = argPD;
/* 567 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 568 */     this._eventManager = argEM;
/* 569 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 570 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 575 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 579 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 582 */     super.startTransaction();
/*     */ 
/*     */     
/* 585 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 590 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 593 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 599 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 602 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 605 */     super.commitTransaction();
/*     */ 
/*     */     
/* 608 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 613 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionVersionPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */