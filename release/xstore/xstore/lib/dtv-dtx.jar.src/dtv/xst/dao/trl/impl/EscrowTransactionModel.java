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
/*     */ import dtv.xst.dao.cat.IEscrowAccountActivity;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.trl.IEscrowTransaction;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class EscrowTransactionModel extends PosTransactionModel implements IEscrowTransaction {
/*     */   private static final long serialVersionUID = 1213959481L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IParty _customerParty;
/*     */   private transient IParty _customerPartySavepoint;
/*     */   private IEscrowAccountActivity _escrowAccountActivity;
/*     */   private transient IEscrowAccountActivity _escrowAccountActivitySavepoint;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new EscrowTransactionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EscrowTransactionDAO getDAO_() {
/*  40 */     return (EscrowTransactionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  48 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  56 */     if (setCreateDate_noev(argCreateDate) && 
/*  57 */       this._events != null && 
/*  58 */       postEventsForChanges()) {
/*  59 */       this._events.post(IEscrowTransaction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  66 */     boolean ev_postable = false;
/*     */     
/*  68 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  69 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  70 */       getDAO_().setCreateDate(argCreateDate);
/*  71 */       ev_postable = true;
/*     */     } 
/*     */     
/*  74 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  82 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  90 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  91 */       this._events != null && 
/*  92 */       postEventsForChanges()) {
/*  93 */       this._events.post(IEscrowTransaction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 100 */     boolean ev_postable = false;
/*     */     
/* 102 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 103 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 104 */       getDAO_().setCreateUserId(argCreateUserId);
/* 105 */       ev_postable = true;
/*     */     } 
/*     */     
/* 108 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 116 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 124 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 125 */       this._events != null && 
/* 126 */       postEventsForChanges()) {
/* 127 */       this._events.post(IEscrowTransaction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 134 */     boolean ev_postable = false;
/*     */     
/* 136 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 137 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 138 */       getDAO_().setUpdateDate(argUpdateDate);
/* 139 */       ev_postable = true;
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 150 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 158 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IEscrowTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 171 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 172 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 173 */       ev_postable = true;
/*     */     } 
/*     */     
/* 176 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 184 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 192 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 193 */       this._events != null && 
/* 194 */       postEventsForChanges()) {
/* 195 */       this._events.post(IEscrowTransaction.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 202 */     boolean ev_postable = false;
/*     */     
/* 204 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 205 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 206 */       getDAO_().setCustAccountId(argCustAccountId);
/* 207 */       ev_postable = true;
/*     */     } 
/*     */     
/* 210 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getActivitySequenceNumber() {
/* 218 */     if (getDAO_().getActivitySequenceNumber() != null) {
/* 219 */       return getDAO_().getActivitySequenceNumber().longValue();
/*     */     }
/*     */     
/* 222 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivitySequenceNumber(long argActivitySequenceNumber) {
/* 231 */     if (setActivitySequenceNumber_noev(argActivitySequenceNumber) && 
/* 232 */       this._events != null && 
/* 233 */       postEventsForChanges()) {
/* 234 */       this._events.post(IEscrowTransaction.SET_ACTIVITYSEQUENCENUMBER, Long.valueOf(argActivitySequenceNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivitySequenceNumber_noev(long argActivitySequenceNumber) {
/* 241 */     boolean ev_postable = false;
/*     */     
/* 243 */     if ((getDAO_().getActivitySequenceNumber() == null && Long.valueOf(argActivitySequenceNumber) != null) || (
/* 244 */       getDAO_().getActivitySequenceNumber() != null && !getDAO_().getActivitySequenceNumber().equals(Long.valueOf(argActivitySequenceNumber)))) {
/* 245 */       getDAO_().setActivitySequenceNumber(Long.valueOf(argActivitySequenceNumber));
/* 246 */       ev_postable = true;
/*     */     } 
/*     */     
/* 249 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getEscrowAmount() {
/* 257 */     return getDAO_().getEscrowAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscrowAmount(BigDecimal argEscrowAmount) {
/* 265 */     if (setEscrowAmount_noev(argEscrowAmount) && 
/* 266 */       this._events != null && 
/* 267 */       postEventsForChanges()) {
/* 268 */       this._events.post(IEscrowTransaction.SET_ESCROWAMOUNT, argEscrowAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEscrowAmount_noev(BigDecimal argEscrowAmount) {
/* 275 */     boolean ev_postable = false;
/*     */     
/* 277 */     if ((getDAO_().getEscrowAmount() == null && argEscrowAmount != null) || (
/* 278 */       getDAO_().getEscrowAmount() != null && !getDAO_().getEscrowAmount().equals(argEscrowAmount))) {
/* 279 */       getDAO_().setEscrowAmount(argEscrowAmount);
/* 280 */       ev_postable = true;
/*     */     } 
/*     */     
/* 283 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCustomerPartyId() {
/* 291 */     if (getDAO_().getCustomerPartyId() != null) {
/* 292 */       return getDAO_().getCustomerPartyId().longValue();
/*     */     }
/*     */     
/* 295 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerPartyId(long argCustomerPartyId) {
/* 304 */     if (setCustomerPartyId_noev(argCustomerPartyId) && 
/* 305 */       this._events != null && 
/* 306 */       postEventsForChanges()) {
/* 307 */       this._events.post(IEscrowTransaction.SET_CUSTOMERPARTYID, Long.valueOf(argCustomerPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerPartyId_noev(long argCustomerPartyId) {
/* 314 */     boolean ev_postable = false;
/*     */     
/* 316 */     if ((getDAO_().getCustomerPartyId() == null && Long.valueOf(argCustomerPartyId) != null) || (
/* 317 */       getDAO_().getCustomerPartyId() != null && !getDAO_().getCustomerPartyId().equals(Long.valueOf(argCustomerPartyId)))) {
/* 318 */       getDAO_().setCustomerPartyId(Long.valueOf(argCustomerPartyId));
/* 319 */       ev_postable = true;
/*     */     } 
/*     */     
/* 322 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "CustomerParty")
/*     */   public IParty getCustomerParty() {
/* 334 */     return this._customerParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomerParty(IParty argCustomerParty) {
/* 339 */     if (argCustomerParty == null) {
/*     */       
/* 341 */       getDAO_().setCustomerPartyId(null);
/* 342 */       if (this._customerParty != null)
/*     */       {
/* 344 */         if (postEventsForChanges()) {
/* 345 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._customerParty));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 350 */       getDAO_().setCustomerPartyId(Long.valueOf(argCustomerParty.getPartyId()));
/*     */       
/* 352 */       if (postEventsForChanges()) {
/* 353 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerParty));
/*     */       }
/*     */     } 
/*     */     
/* 357 */     this._customerParty = argCustomerParty;
/* 358 */     if (postEventsForChanges()) {
/* 359 */       this._events.post(IEscrowTransaction.SET_CUSTOMERPARTY, argCustomerParty);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "EscrowAccountActivity")
/*     */   public IEscrowAccountActivity getEscrowAccountActivity() {
/* 365 */     return this._escrowAccountActivity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEscrowAccountActivity(IEscrowAccountActivity argEscrowAccountActivity) {
/* 370 */     if (argEscrowAccountActivity == null) {
/*     */       
/* 372 */       getDAO_().setCustAccountId(null);
/* 373 */       getDAO_().setActivitySequenceNumber(null);
/* 374 */       if (this._escrowAccountActivity != null)
/*     */       {
/* 376 */         if (postEventsForChanges()) {
/* 377 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._escrowAccountActivity));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 382 */       getDAO_().setCustAccountId(argEscrowAccountActivity.getCustAccountId());
/* 383 */       getDAO_().setActivitySequenceNumber(Long.valueOf(argEscrowAccountActivity.getSeqNbr()));
/*     */       
/* 385 */       if (postEventsForChanges()) {
/* 386 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEscrowAccountActivity));
/*     */       }
/*     */     } 
/*     */     
/* 390 */     this._escrowAccountActivity = argEscrowAccountActivity;
/* 391 */     if (postEventsForChanges()) {
/* 392 */       this._events.post(IEscrowTransaction.SET_ESCROWACCOUNTACTIVITY, argEscrowAccountActivity);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 398 */     if ("CustomerParty".equals(argFieldId)) {
/* 399 */       return getCustomerParty();
/*     */     }
/* 401 */     if ("EscrowAccountActivity".equals(argFieldId)) {
/* 402 */       return getEscrowAccountActivity();
/*     */     }
/* 404 */     if ("EscrowTransactionExtension".equals(argFieldId)) {
/* 405 */       return this._myExtension;
/*     */     }
/*     */     
/* 408 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 414 */     if ("CustomerParty".equals(argFieldId)) {
/* 415 */       setCustomerParty((IParty)argValue);
/*     */     }
/* 417 */     else if ("EscrowAccountActivity".equals(argFieldId)) {
/* 418 */       setEscrowAccountActivity((IEscrowAccountActivity)argValue);
/*     */     }
/* 420 */     else if ("EscrowTransactionExtension".equals(argFieldId)) {
/* 421 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 424 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 430 */     super.setDependencies(argPD, argEM);
/* 431 */     if (this._customerParty != null) {
/* 432 */       ((IDataModelImpl)this._customerParty).setDependencies(argPD, argEM);
/*     */     }
/* 434 */     if (this._escrowAccountActivity != null) {
/* 435 */       ((IDataModelImpl)this._escrowAccountActivity).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEscrowTransactionExt() {
/* 440 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEscrowTransactionExt(IDataModel argExt) {
/* 444 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 449 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 453 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 456 */     super.startTransaction();
/*     */     
/* 458 */     this._customerPartySavepoint = this._customerParty;
/* 459 */     if (this._customerParty != null) {
/* 460 */       this._customerParty.startTransaction();
/*     */     }
/*     */     
/* 463 */     this._escrowAccountActivitySavepoint = this._escrowAccountActivity;
/* 464 */     if (this._escrowAccountActivity != null) {
/* 465 */       this._escrowAccountActivity.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 469 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 474 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 477 */     super.rollbackChanges();
/*     */     
/* 479 */     this._customerParty = this._customerPartySavepoint;
/* 480 */     this._customerPartySavepoint = null;
/* 481 */     if (this._customerParty != null) {
/* 482 */       this._customerParty.rollbackChanges();
/*     */     }
/*     */     
/* 485 */     this._escrowAccountActivity = this._escrowAccountActivitySavepoint;
/* 486 */     this._escrowAccountActivitySavepoint = null;
/* 487 */     if (this._escrowAccountActivity != null) {
/* 488 */       this._escrowAccountActivity.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 495 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 498 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 501 */     super.commitTransaction();
/*     */     
/* 503 */     this._customerPartySavepoint = this._customerParty;
/* 504 */     if (this._customerParty != null) {
/* 505 */       this._customerParty.commitTransaction();
/*     */     }
/*     */     
/* 508 */     this._escrowAccountActivitySavepoint = this._escrowAccountActivity;
/* 509 */     if (this._escrowAccountActivity != null) {
/* 510 */       this._escrowAccountActivity.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 514 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 519 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\EscrowTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */