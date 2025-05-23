/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.ttr.IAccountReceivableTenderLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AccountReceivableTenderLineItemModel
/*     */   extends TenderLineItemModel
/*     */   implements IAccountReceivableTenderLineItem
/*     */ {
/*     */   private static final long serialVersionUID = -42857340L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new AccountReceivableTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AccountReceivableTenderLineItemDAO getDAO_() {
/*  38 */     return (AccountReceivableTenderLineItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  46 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  54 */     if (setCreateDate_noev(argCreateDate) && 
/*  55 */       this._events != null && 
/*  56 */       postEventsForChanges()) {
/*  57 */       this._events.post(IAccountReceivableTenderLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  64 */     boolean ev_postable = false;
/*     */     
/*  66 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  67 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  68 */       getDAO_().setCreateDate(argCreateDate);
/*  69 */       ev_postable = true;
/*     */     } 
/*     */     
/*  72 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  88 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  89 */       this._events != null && 
/*  90 */       postEventsForChanges()) {
/*  91 */       this._events.post(IAccountReceivableTenderLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  98 */     boolean ev_postable = false;
/*     */     
/* 100 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 101 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 102 */       getDAO_().setCreateUserId(argCreateUserId);
/* 103 */       ev_postable = true;
/*     */     } 
/*     */     
/* 106 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 122 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 123 */       this._events != null && 
/* 124 */       postEventsForChanges()) {
/* 125 */       this._events.post(IAccountReceivableTenderLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 132 */     boolean ev_postable = false;
/*     */     
/* 134 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 135 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 136 */       getDAO_().setUpdateDate(argUpdateDate);
/* 137 */       ev_postable = true;
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 148 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 156 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IAccountReceivableTenderLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 169 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 170 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 171 */       ev_postable = true;
/*     */     } 
/*     */     
/* 174 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountNumber() {
/* 182 */     return getDAO_().getAccountNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountNumber(String argAccountNumber) {
/* 190 */     if (setAccountNumber_noev(argAccountNumber) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(IAccountReceivableTenderLineItem.SET_ACCOUNTNUMBER, argAccountNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountNumber_noev(String argAccountNumber) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getAccountNumber() == null && argAccountNumber != null) || (
/* 203 */       getDAO_().getAccountNumber() != null && !getDAO_().getAccountNumber().equals(argAccountNumber))) {
/* 204 */       getDAO_().setAccountNumber(argAccountNumber);
/* 205 */       ev_postable = true;
/*     */     } 
/*     */     
/* 208 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getApprovalCode() {
/* 216 */     return getDAO_().getApprovalCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApprovalCode(String argApprovalCode) {
/* 224 */     if (setApprovalCode_noev(argApprovalCode) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(IAccountReceivableTenderLineItem.SET_APPROVALCODE, argApprovalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setApprovalCode_noev(String argApprovalCode) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getApprovalCode() == null && argApprovalCode != null) || (
/* 237 */       getDAO_().getApprovalCode() != null && !getDAO_().getApprovalCode().equals(argApprovalCode))) {
/* 238 */       getDAO_().setApprovalCode(argApprovalCode);
/* 239 */       ev_postable = true;
/*     */     } 
/*     */     
/* 242 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/* 250 */     if (getDAO_().getPartyId() != null) {
/* 251 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 254 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 263 */     if (setPartyId_noev(argPartyId) && 
/* 264 */       this._events != null && 
/* 265 */       postEventsForChanges()) {
/* 266 */       this._events.post(IAccountReceivableTenderLineItem.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 273 */     boolean ev_postable = false;
/*     */     
/* 275 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 276 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 277 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 278 */       ev_postable = true;
/*     */     } 
/*     */     
/* 281 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserName() {
/* 289 */     return getDAO_().getAccountUserName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserName(String argAccountUserName) {
/* 297 */     if (setAccountUserName_noev(argAccountUserName) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IAccountReceivableTenderLineItem.SET_ACCOUNTUSERNAME, argAccountUserName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserName_noev(String argAccountUserName) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getAccountUserName() == null && argAccountUserName != null) || (
/* 310 */       getDAO_().getAccountUserName() != null && !getDAO_().getAccountUserName().equals(argAccountUserName))) {
/* 311 */       getDAO_().setAccountUserName(argAccountUserName);
/* 312 */       ev_postable = true;
/*     */     } 
/*     */     
/* 315 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPoNumber() {
/* 323 */     return getDAO_().getPoNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoNumber(String argPoNumber) {
/* 331 */     if (setPoNumber_noev(argPoNumber) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(IAccountReceivableTenderLineItem.SET_PONUMBER, argPoNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPoNumber_noev(String argPoNumber) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getPoNumber() == null && argPoNumber != null) || (
/* 344 */       getDAO_().getPoNumber() != null && !getDAO_().getPoNumber().equals(argPoNumber))) {
/* 345 */       getDAO_().setPoNumber(argPoNumber);
/* 346 */       ev_postable = true;
/*     */     } 
/*     */     
/* 349 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAdjudicationCode() {
/* 357 */     return getDAO_().getAdjudicationCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 365 */     if (setAdjudicationCode_noev(argAdjudicationCode) && 
/* 366 */       this._events != null && 
/* 367 */       postEventsForChanges()) {
/* 368 */       this._events.post(IAccountReceivableTenderLineItem.SET_ADJUDICATIONCODE, argAdjudicationCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAdjudicationCode_noev(String argAdjudicationCode) {
/* 375 */     boolean ev_postable = false;
/*     */     
/* 377 */     if ((getDAO_().getAdjudicationCode() == null && argAdjudicationCode != null) || (
/* 378 */       getDAO_().getAdjudicationCode() != null && !getDAO_().getAdjudicationCode().equals(argAdjudicationCode))) {
/* 379 */       getDAO_().setAdjudicationCode(argAdjudicationCode);
/* 380 */       ev_postable = true;
/*     */     } 
/*     */     
/* 383 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 391 */     return getDAO_().getAuthorizationMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 399 */     if (setAuthorizationMethodCode_noev(argAuthorizationMethodCode) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(IAccountReceivableTenderLineItem.SET_AUTHORIZATIONMETHODCODE, argAuthorizationMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorizationMethodCode_noev(String argAuthorizationMethodCode) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getAuthorizationMethodCode() == null && argAuthorizationMethodCode != null) || (
/* 412 */       getDAO_().getAuthorizationMethodCode() != null && !getDAO_().getAuthorizationMethodCode().equals(argAuthorizationMethodCode))) {
/* 413 */       getDAO_().setAuthorizationMethodCode(argAuthorizationMethodCode);
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActivityCode() {
/* 425 */     return getDAO_().getActivityCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 433 */     if (setActivityCode_noev(argActivityCode) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(IAccountReceivableTenderLineItem.SET_ACTIVITYCODE, argActivityCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivityCode_noev(String argActivityCode) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getActivityCode() == null && argActivityCode != null) || (
/* 446 */       getDAO_().getActivityCode() != null && !getDAO_().getActivityCode().equals(argActivityCode))) {
/* 447 */       getDAO_().setActivityCode(argActivityCode);
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEntryMethodCode() {
/* 459 */     return getDAO_().getEntryMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 467 */     if (setEntryMethodCode_noev(argEntryMethodCode) && 
/* 468 */       this._events != null && 
/* 469 */       postEventsForChanges()) {
/* 470 */       this._events.post(IAccountReceivableTenderLineItem.SET_ENTRYMETHODCODE, argEntryMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryMethodCode_noev(String argEntryMethodCode) {
/* 477 */     boolean ev_postable = false;
/*     */     
/* 479 */     if ((getDAO_().getEntryMethodCode() == null && argEntryMethodCode != null) || (
/* 480 */       getDAO_().getEntryMethodCode() != null && !getDAO_().getEntryMethodCode().equals(argEntryMethodCode))) {
/* 481 */       getDAO_().setEntryMethodCode(argEntryMethodCode);
/* 482 */       ev_postable = true;
/*     */     } 
/*     */     
/* 485 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthorizationCode() {
/* 493 */     return getDAO_().getAuthorizationCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 501 */     if (setAuthorizationCode_noev(argAuthorizationCode) && 
/* 502 */       this._events != null && 
/* 503 */       postEventsForChanges()) {
/* 504 */       this._events.post(IAccountReceivableTenderLineItem.SET_AUTHORIZATIONCODE, argAuthorizationCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorizationCode_noev(String argAuthorizationCode) {
/* 511 */     boolean ev_postable = false;
/*     */     
/* 513 */     if ((getDAO_().getAuthorizationCode() == null && argAuthorizationCode != null) || (
/* 514 */       getDAO_().getAuthorizationCode() != null && !getDAO_().getAuthorizationCode().equals(argAuthorizationCode))) {
/* 515 */       getDAO_().setAuthorizationCode(argAuthorizationCode);
/* 516 */       ev_postable = true;
/*     */     } 
/*     */     
/* 519 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserId() {
/* 527 */     return getDAO_().getAccountUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/* 535 */     if (setAccountUserId_noev(argAccountUserId) && 
/* 536 */       this._events != null && 
/* 537 */       postEventsForChanges()) {
/* 538 */       this._events.post(IAccountReceivableTenderLineItem.SET_ACCOUNTUSERID, argAccountUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserId_noev(String argAccountUserId) {
/* 545 */     boolean ev_postable = false;
/*     */     
/* 547 */     if ((getDAO_().getAccountUserId() == null && argAccountUserId != null) || (
/* 548 */       getDAO_().getAccountUserId() != null && !getDAO_().getAccountUserId().equals(argAccountUserId))) {
/* 549 */       getDAO_().setAccountUserId(argAccountUserId);
/* 550 */       ev_postable = true;
/*     */     } 
/*     */     
/* 553 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 559 */     if ("AccountReceivableTenderLineItemExtension".equals(argFieldId)) {
/* 560 */       return this._myExtension;
/*     */     }
/*     */     
/* 563 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 569 */     if ("AccountReceivableTenderLineItemExtension".equals(argFieldId)) {
/* 570 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 573 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 579 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getAccountReceivableTenderLineItemExt() {
/* 583 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAccountReceivableTenderLineItemExt(IDataModel argExt) {
/* 587 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 592 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 596 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 599 */     super.startTransaction();
/*     */ 
/*     */     
/* 602 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 607 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 610 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 616 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 619 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 622 */     super.commitTransaction();
/*     */ 
/*     */     
/* 625 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 630 */     argStream.defaultReadObject();
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
/*     */   public String getBankReferenceNumber() {
/* 643 */     return getAdjudicationCode();
/*     */   }
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 647 */     setAdjudicationCode(argBankReferenceNumber);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAuthorizationToken(String argAuthorizationToken) {}
/*     */ 
/*     */   
/*     */   public String getAuthorizationToken() {
/* 655 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTraceNumber(String argTraceNumber) {}
/*     */ 
/*     */   
/*     */   public String getTraceNumber() {
/* 663 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTransactionReferenceData(String argTransactionReferenceData) {}
/*     */ 
/*     */   
/*     */   public String getTransactionReferenceData() {
/* 671 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\AccountReceivableTenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */