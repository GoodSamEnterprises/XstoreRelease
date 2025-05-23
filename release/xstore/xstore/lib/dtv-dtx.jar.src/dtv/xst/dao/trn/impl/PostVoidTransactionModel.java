/*     */ package dtv.xst.dao.trn.impl;
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
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import dtv.xst.dao.trn.IPostVoidTransaction;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class PostVoidTransactionModel
/*     */   extends PosTransactionModel
/*     */   implements IPostVoidTransaction
/*     */ {
/*     */   private static final long serialVersionUID = -906774582L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IPosTransaction _voidedTransaction;
/*     */   private transient IPosTransaction _voidedTransactionSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  31 */     setDAO((IDataAccessObject)new PostVoidTransactionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PostVoidTransactionDAO getDAO_() {
/*  39 */     return (PostVoidTransactionDAO)this._daoImpl;
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
/*  58 */       this._events.post(IPostVoidTransaction.SET_CREATEDATE, argCreateDate);
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
/*  92 */       this._events.post(IPostVoidTransaction.SET_CREATEUSERID, argCreateUserId);
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
/* 126 */       this._events.post(IPostVoidTransaction.SET_UPDATEDATE, argUpdateDate);
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
/* 160 */       this._events.post(IPostVoidTransaction.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getVoidedTransactionEntryCode() {
/* 183 */     return getDAO_().getVoidedTransactionEntryCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedTransactionEntryCode(String argVoidedTransactionEntryCode) {
/* 191 */     if (setVoidedTransactionEntryCode_noev(argVoidedTransactionEntryCode) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(IPostVoidTransaction.SET_VOIDEDTRANSACTIONENTRYCODE, argVoidedTransactionEntryCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoidedTransactionEntryCode_noev(String argVoidedTransactionEntryCode) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getVoidedTransactionEntryCode() == null && argVoidedTransactionEntryCode != null) || (
/* 204 */       getDAO_().getVoidedTransactionEntryCode() != null && !getDAO_().getVoidedTransactionEntryCode().equals(argVoidedTransactionEntryCode))) {
/* 205 */       getDAO_().setVoidedTransactionEntryCode(argVoidedTransactionEntryCode);
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
/*     */   public Date getVoidedBusinessDate() {
/* 217 */     return getDAO_().getVoidedBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedBusinessDate(Date argVoidedBusinessDate) {
/* 225 */     if (setVoidedBusinessDate_noev(argVoidedBusinessDate) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(IPostVoidTransaction.SET_VOIDEDBUSINESSDATE, argVoidedBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoidedBusinessDate_noev(Date argVoidedBusinessDate) {
/* 235 */     boolean ev_postable = false;
/*     */     
/* 237 */     if ((getDAO_().getVoidedBusinessDate() == null && argVoidedBusinessDate != null) || (
/* 238 */       getDAO_().getVoidedBusinessDate() != null && !getDAO_().getVoidedBusinessDate().equals(argVoidedBusinessDate))) {
/* 239 */       getDAO_().setVoidedBusinessDate(argVoidedBusinessDate);
/* 240 */       ev_postable = true;
/* 241 */       if (this._voidedTransaction != null)
/*     */       {
/*     */         
/* 244 */         ((PosTransactionModel)this._voidedTransaction).setBusinessDate_noev(argVoidedBusinessDate);
/*     */       }
/*     */     } 
/*     */     
/* 248 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedWorkstationId() {
/* 256 */     if (getDAO_().getVoidedWorkstationId() != null) {
/* 257 */       return getDAO_().getVoidedWorkstationId().longValue();
/*     */     }
/*     */     
/* 260 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedWorkstationId(long argVoidedWorkstationId) {
/* 269 */     if (setVoidedWorkstationId_noev(argVoidedWorkstationId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IPostVoidTransaction.SET_VOIDEDWORKSTATIONID, Long.valueOf(argVoidedWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoidedWorkstationId_noev(long argVoidedWorkstationId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getVoidedWorkstationId() == null && Long.valueOf(argVoidedWorkstationId) != null) || (
/* 282 */       getDAO_().getVoidedWorkstationId() != null && !getDAO_().getVoidedWorkstationId().equals(Long.valueOf(argVoidedWorkstationId)))) {
/* 283 */       getDAO_().setVoidedWorkstationId(Long.valueOf(argVoidedWorkstationId));
/* 284 */       ev_postable = true;
/* 285 */       if (this._voidedTransaction != null)
/*     */       {
/*     */         
/* 288 */         ((PosTransactionModel)this._voidedTransaction).setWorkstationId_noev(argVoidedWorkstationId);
/*     */       }
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedTransactionId() {
/* 300 */     if (getDAO_().getVoidedTransactionId() != null) {
/* 301 */       return getDAO_().getVoidedTransactionId().longValue();
/*     */     }
/*     */     
/* 304 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedTransactionId(long argVoidedTransactionId) {
/* 313 */     if (setVoidedTransactionId_noev(argVoidedTransactionId) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IPostVoidTransaction.SET_VOIDEDTRANSACTIONID, Long.valueOf(argVoidedTransactionId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoidedTransactionId_noev(long argVoidedTransactionId) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getVoidedTransactionId() == null && Long.valueOf(argVoidedTransactionId) != null) || (
/* 326 */       getDAO_().getVoidedTransactionId() != null && !getDAO_().getVoidedTransactionId().equals(Long.valueOf(argVoidedTransactionId)))) {
/* 327 */       getDAO_().setVoidedTransactionId(Long.valueOf(argVoidedTransactionId));
/* 328 */       ev_postable = true;
/* 329 */       if (this._voidedTransaction != null)
/*     */       {
/*     */         
/* 332 */         ((PosTransactionModel)this._voidedTransaction).setTransactionSequence_noev(argVoidedTransactionId);
/*     */       }
/*     */     } 
/*     */     
/* 336 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedRetailStoreId() {
/* 344 */     if (getDAO_().getVoidedRetailStoreId() != null) {
/* 345 */       return getDAO_().getVoidedRetailStoreId().longValue();
/*     */     }
/*     */     
/* 348 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedRetailStoreId(long argVoidedRetailStoreId) {
/* 357 */     if (setVoidedRetailStoreId_noev(argVoidedRetailStoreId) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(IPostVoidTransaction.SET_VOIDEDRETAILSTOREID, Long.valueOf(argVoidedRetailStoreId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoidedRetailStoreId_noev(long argVoidedRetailStoreId) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getVoidedRetailStoreId() == null && Long.valueOf(argVoidedRetailStoreId) != null) || (
/* 370 */       getDAO_().getVoidedRetailStoreId() != null && !getDAO_().getVoidedRetailStoreId().equals(Long.valueOf(argVoidedRetailStoreId)))) {
/* 371 */       getDAO_().setVoidedRetailStoreId(Long.valueOf(argVoidedRetailStoreId));
/* 372 */       ev_postable = true;
/* 373 */       if (this._voidedTransaction != null)
/*     */       {
/*     */         
/* 376 */         ((PosTransactionModel)this._voidedTransaction).setRetailLocationId_noev(argVoidedRetailStoreId);
/*     */       }
/*     */     } 
/*     */     
/* 380 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedOrganizationId() {
/* 388 */     if (getDAO_().getVoidedOrganizationId() != null) {
/* 389 */       return getDAO_().getVoidedOrganizationId().longValue();
/*     */     }
/*     */     
/* 392 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedOrganizationId(long argVoidedOrganizationId) {
/* 401 */     if (setVoidedOrganizationId_noev(argVoidedOrganizationId) && 
/* 402 */       this._events != null && 
/* 403 */       postEventsForChanges()) {
/* 404 */       this._events.post(IPostVoidTransaction.SET_VOIDEDORGANIZATIONID, Long.valueOf(argVoidedOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoidedOrganizationId_noev(long argVoidedOrganizationId) {
/* 411 */     boolean ev_postable = false;
/*     */     
/* 413 */     if ((getDAO_().getVoidedOrganizationId() == null && Long.valueOf(argVoidedOrganizationId) != null) || (
/* 414 */       getDAO_().getVoidedOrganizationId() != null && !getDAO_().getVoidedOrganizationId().equals(Long.valueOf(argVoidedOrganizationId)))) {
/* 415 */       getDAO_().setVoidedOrganizationId(Long.valueOf(argVoidedOrganizationId));
/* 416 */       ev_postable = true;
/* 417 */       if (this._voidedTransaction != null)
/*     */       {
/*     */         
/* 420 */         ((PosTransactionModel)this._voidedTransaction).setOrganizationId_noev(argVoidedOrganizationId);
/*     */       }
/*     */     } 
/*     */     
/* 424 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostVoidReasonCode() {
/* 432 */     return getDAO_().getPostVoidReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostVoidReasonCode(String argPostVoidReasonCode) {
/* 440 */     if (setPostVoidReasonCode_noev(argPostVoidReasonCode) && 
/* 441 */       this._events != null && 
/* 442 */       postEventsForChanges()) {
/* 443 */       this._events.post(IPostVoidTransaction.SET_POSTVOIDREASONCODE, argPostVoidReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostVoidReasonCode_noev(String argPostVoidReasonCode) {
/* 450 */     boolean ev_postable = false;
/*     */     
/* 452 */     if ((getDAO_().getPostVoidReasonCode() == null && argPostVoidReasonCode != null) || (
/* 453 */       getDAO_().getPostVoidReasonCode() != null && !getDAO_().getPostVoidReasonCode().equals(argPostVoidReasonCode))) {
/* 454 */       getDAO_().setPostVoidReasonCode(argPostVoidReasonCode);
/* 455 */       ev_postable = true;
/*     */     } 
/*     */     
/* 458 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "VoidedTransaction")
/*     */   public IPosTransaction getVoidedTransaction() {
/* 467 */     return this._voidedTransaction;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setVoidedTransactionImpl(IPosTransaction argVoidedTransaction) {
/* 472 */     if (argVoidedTransaction == null) {
/* 473 */       if (this._voidedTransaction != null) {
/*     */         
/* 475 */         if (postEventsForChanges()) {
/* 476 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._voidedTransaction));
/*     */         }
/* 478 */         addDeletedObject((IDataModel)this._voidedTransaction);
/*     */       } 
/*     */     } else {
/*     */       
/* 482 */       argVoidedTransaction.setOrganizationId(getVoidedOrganizationId());
/* 483 */       argVoidedTransaction.setRetailLocationId(getVoidedRetailStoreId());
/* 484 */       argVoidedTransaction.setBusinessDate(getVoidedBusinessDate());
/* 485 */       argVoidedTransaction.setWorkstationId(getVoidedWorkstationId());
/* 486 */       argVoidedTransaction.setTransactionSequence(getVoidedTransactionId());
/*     */ 
/*     */       
/* 489 */       if (postEventsForChanges()) {
/* 490 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVoidedTransaction));
/*     */       }
/*     */     } 
/*     */     
/* 494 */     this._voidedTransaction = argVoidedTransaction;
/* 495 */     if (postEventsForChanges()) {
/* 496 */       this._events.post(IPostVoidTransaction.SET_VOIDEDTRANSACTION, argVoidedTransaction);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 502 */     if ("VoidedTransaction".equals(argFieldId)) {
/* 503 */       return getVoidedTransaction();
/*     */     }
/* 505 */     if ("PostVoidTransactionExtension".equals(argFieldId)) {
/* 506 */       return this._myExtension;
/*     */     }
/*     */     
/* 509 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 515 */     if ("VoidedTransaction".equals(argFieldId)) {
/* 516 */       setVoidedTransaction((IPosTransaction)argValue);
/*     */     }
/* 518 */     else if ("PostVoidTransactionExtension".equals(argFieldId)) {
/* 519 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 522 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 528 */     super.setDependencies(argPD, argEM);
/* 529 */     if (this._voidedTransaction != null) {
/* 530 */       ((IDataModelImpl)this._voidedTransaction).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPostVoidTransactionExt() {
/* 535 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPostVoidTransactionExt(IDataModel argExt) {
/* 539 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 544 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 548 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 551 */     super.startTransaction();
/*     */     
/* 553 */     this._voidedTransactionSavepoint = this._voidedTransaction;
/* 554 */     if (this._voidedTransaction != null) {
/* 555 */       this._voidedTransaction.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 559 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 564 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 567 */     super.rollbackChanges();
/*     */     
/* 569 */     this._voidedTransaction = this._voidedTransactionSavepoint;
/* 570 */     this._voidedTransactionSavepoint = null;
/* 571 */     if (this._voidedTransaction != null) {
/* 572 */       this._voidedTransaction.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 579 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 582 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 585 */     super.commitTransaction();
/*     */     
/* 587 */     this._voidedTransactionSavepoint = this._voidedTransaction;
/* 588 */     if (this._voidedTransaction != null) {
/* 589 */       this._voidedTransaction.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 593 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 598 */     argStream.defaultReadObject();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedTransaction(IPosTransaction argVoidedTransaction) {
/* 614 */     if (argVoidedTransaction != null) {
/* 615 */       setVoidedOrganizationId(argVoidedTransaction.getOrganizationId());
/* 616 */       setVoidedRetailStoreId(argVoidedTransaction.getRetailLocationId());
/* 617 */       setVoidedWorkstationId(argVoidedTransaction.getWorkstationId());
/* 618 */       setVoidedTransactionId(argVoidedTransaction.getTransactionSequence());
/* 619 */       setVoidedBusinessDate(argVoidedTransaction.getBusinessDate());
/*     */     } else {
/* 621 */       getDAO_().setVoidedOrganizationId(null);
/* 622 */       getDAO_().setVoidedRetailStoreId(null);
/* 623 */       getDAO_().setVoidedWorkstationId(null);
/* 624 */       getDAO_().setVoidedTransactionId(null);
/* 625 */       setVoidedBusinessDate((Date)null);
/*     */     } 
/*     */     
/* 628 */     setVoidedTransactionImpl(argVoidedTransaction);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PostVoidTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */