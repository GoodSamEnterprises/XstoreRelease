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
/*     */ import dtv.xst.dao.inv.ISerializedStockLedgerProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SerializedStockLedgerPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements ISerializedStockLedgerProperty
/*     */ {
/*     */   private static final long serialVersionUID = -648067376L;
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
/*  36 */     setDAO((IDataAccessObject)new SerializedStockLedgerPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SerializedStockLedgerPropertyDAO getDAO_() {
/*  44 */     return (SerializedStockLedgerPropertyDAO)this._daoImpl;
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
/*  68 */       this._events.post(ISerializedStockLedgerProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 107 */       this._events.post(ISerializedStockLedgerProperty.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/*     */   public String getInvLocationId() {
/* 130 */     return getDAO_().getInvLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/* 138 */     if (setInvLocationId_noev(argInvLocationId) && 
/* 139 */       this._events != null && 
/* 140 */       postEventsForChanges()) {
/* 141 */       this._events.post(ISerializedStockLedgerProperty.SET_INVLOCATIONID, argInvLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvLocationId_noev(String argInvLocationId) {
/* 148 */     boolean ev_postable = false;
/*     */     
/* 150 */     if ((getDAO_().getInvLocationId() == null && argInvLocationId != null) || (
/* 151 */       getDAO_().getInvLocationId() != null && !getDAO_().getInvLocationId().equals(argInvLocationId))) {
/* 152 */       getDAO_().setInvLocationId(argInvLocationId);
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
/*     */   public String getItemId() {
/* 164 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 172 */     if (setItemId_noev(argItemId) && 
/* 173 */       this._events != null && 
/* 174 */       postEventsForChanges()) {
/* 175 */       this._events.post(ISerializedStockLedgerProperty.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 182 */     boolean ev_postable = false;
/*     */     
/* 184 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 185 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 186 */       getDAO_().setItemId(argItemId);
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
/*     */   public String getSerialNumber() {
/* 198 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 206 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 207 */       this._events != null && 
/* 208 */       postEventsForChanges()) {
/* 209 */       this._events.post(ISerializedStockLedgerProperty.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 216 */     boolean ev_postable = false;
/*     */     
/* 218 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 219 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 220 */       getDAO_().setSerialNumber(argSerialNumber);
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
/*     */   public String getBucketId() {
/* 232 */     return getDAO_().getBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/* 240 */     if (setBucketId_noev(argBucketId) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(ISerializedStockLedgerProperty.SET_BUCKETID, argBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBucketId_noev(String argBucketId) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getBucketId() == null && argBucketId != null) || (
/* 253 */       getDAO_().getBucketId() != null && !getDAO_().getBucketId().equals(argBucketId))) {
/* 254 */       getDAO_().setBucketId(argBucketId);
/* 255 */       ev_postable = true;
/*     */     } 
/*     */     
/* 258 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 266 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 274 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(ISerializedStockLedgerProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 287 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 288 */       getDAO_().setPropertyCode(argPropertyCode);
/* 289 */       ev_postable = true;
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 300 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 308 */     if (setType_noev(argType) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(ISerializedStockLedgerProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getType() == null && argType != null) || (
/* 321 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 322 */       getDAO_().setType(argType);
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 334 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 342 */     if (setStringValue_noev(argStringValue) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(ISerializedStockLedgerProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 355 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 356 */       getDAO_().setStringValue(argStringValue);
/* 357 */       ev_postable = true;
/*     */     } 
/*     */     
/* 360 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 368 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 376 */     if (setDateValue_noev(argDateValue) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(ISerializedStockLedgerProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 389 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 390 */       getDAO_().setDateValue(argDateValue);
/* 391 */       ev_postable = true;
/*     */     } 
/*     */     
/* 394 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 402 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 410 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 411 */       this._events != null && 
/* 412 */       postEventsForChanges()) {
/* 413 */       this._events.post(ISerializedStockLedgerProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 420 */     boolean ev_postable = false;
/*     */     
/* 422 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 423 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 424 */       getDAO_().setDecimalValue(argDecimalValue);
/* 425 */       ev_postable = true;
/*     */     } 
/*     */     
/* 428 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 436 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 444 */     if (setCreateDate_noev(argCreateDate) && 
/* 445 */       this._events != null && 
/* 446 */       postEventsForChanges()) {
/* 447 */       this._events.post(ISerializedStockLedgerProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 454 */     boolean ev_postable = false;
/*     */     
/* 456 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 457 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 458 */       getDAO_().setCreateDate(argCreateDate);
/* 459 */       ev_postable = true;
/*     */     } 
/*     */     
/* 462 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 470 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 478 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 479 */       this._events != null && 
/* 480 */       postEventsForChanges()) {
/* 481 */       this._events.post(ISerializedStockLedgerProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 488 */     boolean ev_postable = false;
/*     */     
/* 490 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 491 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 492 */       getDAO_().setCreateUserId(argCreateUserId);
/* 493 */       ev_postable = true;
/*     */     } 
/*     */     
/* 496 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 504 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 512 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 513 */       this._events != null && 
/* 514 */       postEventsForChanges()) {
/* 515 */       this._events.post(ISerializedStockLedgerProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 522 */     boolean ev_postable = false;
/*     */     
/* 524 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 525 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 526 */       getDAO_().setUpdateDate(argUpdateDate);
/* 527 */       ev_postable = true;
/*     */     } 
/*     */     
/* 530 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 538 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 546 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 547 */       this._events != null && 
/* 548 */       postEventsForChanges()) {
/* 549 */       this._events.post(ISerializedStockLedgerProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 556 */     boolean ev_postable = false;
/*     */     
/* 558 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 559 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 560 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 561 */       ev_postable = true;
/*     */     } 
/*     */     
/* 564 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 570 */     if ("SerializedStockLedgerPropertyExtension".equals(argFieldId)) {
/* 571 */       return this._myExtension;
/*     */     }
/*     */     
/* 574 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 580 */     if ("SerializedStockLedgerPropertyExtension".equals(argFieldId)) {
/* 581 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 584 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 590 */     this._persistenceDefaults = argPD;
/* 591 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 592 */     this._eventManager = argEM;
/* 593 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 594 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 599 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 603 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 606 */     super.startTransaction();
/*     */ 
/*     */     
/* 609 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 614 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 617 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 623 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 626 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 629 */     super.commitTransaction();
/*     */ 
/*     */     
/* 632 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 637 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\SerializedStockLedgerPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */