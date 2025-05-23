/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.xst.dao.trl.IAccountReceivableSaleLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AccountReceivableSaleLineItemModel
/*     */   extends SaleReturnLineItemModel
/*     */   implements IAccountReceivableSaleLineItem
/*     */ {
/*     */   private static final long serialVersionUID = 2138815799L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new AccountReceivableSaleLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AccountReceivableSaleLineItemDAO getDAO_() {
/*  38 */     return (AccountReceivableSaleLineItemDAO)this._daoImpl;
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
/*  57 */       this._events.post(IAccountReceivableSaleLineItem.SET_CREATEDATE, argCreateDate);
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
/*  91 */       this._events.post(IAccountReceivableSaleLineItem.SET_CREATEUSERID, argCreateUserId);
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
/* 125 */       this._events.post(IAccountReceivableSaleLineItem.SET_UPDATEDATE, argUpdateDate);
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
/* 159 */       this._events.post(IAccountReceivableSaleLineItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getActivityCode() {
/* 182 */     return getDAO_().getActivityCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 190 */     if (setActivityCode_noev(argActivityCode) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(IAccountReceivableSaleLineItem.SET_ACTIVITYCODE, argActivityCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivityCode_noev(String argActivityCode) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getActivityCode() == null && argActivityCode != null) || (
/* 203 */       getDAO_().getActivityCode() != null && !getDAO_().getActivityCode().equals(argActivityCode))) {
/* 204 */       getDAO_().setActivityCode(argActivityCode);
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
/*     */   public String getAdjudicationCode() {
/* 216 */     return getDAO_().getAdjudicationCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 224 */     if (setAdjudicationCode_noev(argAdjudicationCode) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(IAccountReceivableSaleLineItem.SET_ADJUDICATIONCODE, argAdjudicationCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAdjudicationCode_noev(String argAdjudicationCode) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getAdjudicationCode() == null && argAdjudicationCode != null) || (
/* 237 */       getDAO_().getAdjudicationCode() != null && !getDAO_().getAdjudicationCode().equals(argAdjudicationCode))) {
/* 238 */       getDAO_().setAdjudicationCode(argAdjudicationCode);
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
/*     */   public String getAuthorizationCode() {
/* 250 */     return getDAO_().getAuthorizationCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 258 */     if (setAuthorizationCode_noev(argAuthorizationCode) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(IAccountReceivableSaleLineItem.SET_AUTHORIZATIONCODE, argAuthorizationCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorizationCode_noev(String argAuthorizationCode) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getAuthorizationCode() == null && argAuthorizationCode != null) || (
/* 271 */       getDAO_().getAuthorizationCode() != null && !getDAO_().getAuthorizationCode().equals(argAuthorizationCode))) {
/* 272 */       getDAO_().setAuthorizationCode(argAuthorizationCode);
/* 273 */       ev_postable = true;
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 284 */     return getDAO_().getAuthorizationMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 292 */     if (setAuthorizationMethodCode_noev(argAuthorizationMethodCode) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IAccountReceivableSaleLineItem.SET_AUTHORIZATIONMETHODCODE, argAuthorizationMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorizationMethodCode_noev(String argAuthorizationMethodCode) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getAuthorizationMethodCode() == null && argAuthorizationMethodCode != null) || (
/* 305 */       getDAO_().getAuthorizationMethodCode() != null && !getDAO_().getAuthorizationMethodCode().equals(argAuthorizationMethodCode))) {
/* 306 */       getDAO_().setAuthorizationMethodCode(argAuthorizationMethodCode);
/* 307 */       ev_postable = true;
/*     */     } 
/*     */     
/* 310 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEntryMethodCode() {
/* 318 */     return getDAO_().getEntryMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 326 */     if (setEntryMethodCode_noev(argEntryMethodCode) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IAccountReceivableSaleLineItem.SET_ENTRYMETHODCODE, argEntryMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryMethodCode_noev(String argEntryMethodCode) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getEntryMethodCode() == null && argEntryMethodCode != null) || (
/* 339 */       getDAO_().getEntryMethodCode() != null && !getDAO_().getEntryMethodCode().equals(argEntryMethodCode))) {
/* 340 */       getDAO_().setEntryMethodCode(argEntryMethodCode);
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountNumber() {
/* 352 */     return getDAO_().getAccountNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountNumber(String argAccountNumber) {
/* 360 */     if (setAccountNumber_noev(argAccountNumber) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(IAccountReceivableSaleLineItem.SET_ACCOUNTNUMBER, argAccountNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountNumber_noev(String argAccountNumber) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getAccountNumber() == null && argAccountNumber != null) || (
/* 373 */       getDAO_().getAccountNumber() != null && !getDAO_().getAccountNumber().equals(argAccountNumber))) {
/* 374 */       getDAO_().setAccountNumber(argAccountNumber);
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBankReferenceNumber() {
/* 386 */     return getDAO_().getBankReferenceNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 394 */     if (setBankReferenceNumber_noev(argBankReferenceNumber) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(IAccountReceivableSaleLineItem.SET_BANKREFERENCENUMBER, argBankReferenceNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBankReferenceNumber_noev(String argBankReferenceNumber) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getBankReferenceNumber() == null && argBankReferenceNumber != null) || (
/* 407 */       getDAO_().getBankReferenceNumber() != null && !getDAO_().getBankReferenceNumber().equals(argBankReferenceNumber))) {
/* 408 */       getDAO_().setBankReferenceNumber(argBankReferenceNumber);
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserId() {
/* 420 */     return getDAO_().getAccountUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/* 428 */     if (setAccountUserId_noev(argAccountUserId) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(IAccountReceivableSaleLineItem.SET_ACCOUNTUSERID, argAccountUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserId_noev(String argAccountUserId) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getAccountUserId() == null && argAccountUserId != null) || (
/* 441 */       getDAO_().getAccountUserId() != null && !getDAO_().getAccountUserId().equals(argAccountUserId))) {
/* 442 */       getDAO_().setAccountUserId(argAccountUserId);
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserName() {
/* 454 */     return getDAO_().getAccountUserName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserName(String argAccountUserName) {
/* 462 */     if (setAccountUserName_noev(argAccountUserName) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(IAccountReceivableSaleLineItem.SET_ACCOUNTUSERNAME, argAccountUserName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserName_noev(String argAccountUserName) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getAccountUserName() == null && argAccountUserName != null) || (
/* 475 */       getDAO_().getAccountUserName() != null && !getDAO_().getAccountUserName().equals(argAccountUserName))) {
/* 476 */       getDAO_().setAccountUserName(argAccountUserName);
/* 477 */       ev_postable = true;
/*     */     } 
/*     */     
/* 480 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 486 */     if ("AccountReceivableSaleLineItemExtension".equals(argFieldId)) {
/* 487 */       return this._myExtension;
/*     */     }
/*     */     
/* 490 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 496 */     if ("AccountReceivableSaleLineItemExtension".equals(argFieldId)) {
/* 497 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 500 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 506 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getAccountReceivableSaleLineItemExt() {
/* 510 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAccountReceivableSaleLineItemExt(IDataModel argExt) {
/* 514 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 519 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 523 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 526 */     super.startTransaction();
/*     */ 
/*     */     
/* 529 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 534 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 537 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 543 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 546 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 549 */     super.commitTransaction();
/*     */ 
/*     */     
/* 552 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 557 */     argStream.defaultReadObject();
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
/*     */   public BigDecimal getAmount() {
/* 570 */     BigDecimal amount = getExtendedAmount();
/* 571 */     if (!NumberUtils.isZeroOrNull(amount)) {
/* 572 */       return amount;
/*     */     }
/* 574 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAuthorizationToken(String argAuthorizationToken) {}
/*     */ 
/*     */   
/*     */   public String getAuthorizationToken() {
/* 582 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTraceNumber(String argTraceNumber) {}
/*     */ 
/*     */   
/*     */   public String getTraceNumber() {
/* 590 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTransactionReferenceData(String argTransactionReferenceData) {}
/*     */ 
/*     */   
/*     */   public String getTransactionReferenceData() {
/* 598 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\AccountReceivableSaleLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */