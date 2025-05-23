/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountJournal;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ public class CustomerItemAccountJournalModel
/*     */   extends CustomerAccountJournalModel
/*     */   implements ICustomerItemAccountJournal
/*     */ {
/*     */   private static final long serialVersionUID = -654891301L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new CustomerItemAccountJournalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerItemAccountJournalDAO getDAO_() {
/*  38 */     return (CustomerItemAccountJournalDAO)this._daoImpl;
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
/*  57 */       this._events.post(ICustomerItemAccountJournal.SET_CREATEDATE, argCreateDate);
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
/*  91 */       this._events.post(ICustomerItemAccountJournal.SET_CREATEUSERID, argCreateUserId);
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
/* 125 */       this._events.post(ICustomerItemAccountJournal.SET_UPDATEDATE, argUpdateDate);
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
/* 159 */       this._events.post(ICustomerItemAccountJournal.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getCustAccountStateCode() {
/* 182 */     return getDAO_().getCustAccountStateCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountStateCode(String argCustAccountStateCode) {
/* 190 */     if (setCustAccountStateCode_noev(argCustAccountStateCode) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(ICustomerItemAccountJournal.SET_CUSTACCOUNTSTATECODE, argCustAccountStateCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountStateCode_noev(String argCustAccountStateCode) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getCustAccountStateCode() == null && argCustAccountStateCode != null) || (
/* 203 */       getDAO_().getCustAccountStateCode() != null && !getDAO_().getCustAccountStateCode().equals(argCustAccountStateCode))) {
/* 204 */       getDAO_().setCustAccountStateCode(argCustAccountStateCode);
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
/*     */   public Date getAccountSetupDate() {
/* 216 */     return getDAO_().getAccountSetupDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountSetupDate(Date argAccountSetupDate) {
/* 224 */     if (setAccountSetupDate_noev(argAccountSetupDate) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(ICustomerItemAccountJournal.SET_ACCOUNTSETUPDATE, argAccountSetupDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountSetupDate_noev(Date argAccountSetupDate) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getAccountSetupDate() == null && argAccountSetupDate != null) || (
/* 237 */       getDAO_().getAccountSetupDate() != null && !getDAO_().getAccountSetupDate().equals(argAccountSetupDate))) {
/* 238 */       getDAO_().setAccountSetupDate(argAccountSetupDate);
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
/*     */   public Date getLastActivityDate() {
/* 250 */     return getDAO_().getLastActivityDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 258 */     if (setLastActivityDate_noev(argLastActivityDate) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(ICustomerItemAccountJournal.SET_LASTACTIVITYDATE, argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLastActivityDate_noev(Date argLastActivityDate) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getLastActivityDate() == null && argLastActivityDate != null) || (
/* 271 */       getDAO_().getLastActivityDate() != null && !getDAO_().getLastActivityDate().equals(argLastActivityDate))) {
/* 272 */       getDAO_().setLastActivityDate(argLastActivityDate);
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
/*     */   public BigDecimal getAccountTotal() {
/* 284 */     return getDAO_().getAccountTotal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountTotal(BigDecimal argAccountTotal) {
/* 292 */     if (setAccountTotal_noev(argAccountTotal) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(ICustomerItemAccountJournal.SET_ACCOUNTTOTAL, argAccountTotal);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountTotal_noev(BigDecimal argAccountTotal) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getAccountTotal() == null && argAccountTotal != null) || (
/* 305 */       getDAO_().getAccountTotal() != null && !getDAO_().getAccountTotal().equals(argAccountTotal))) {
/* 306 */       getDAO_().setAccountTotal(argAccountTotal);
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
/*     */   public BigDecimal getAccountPayments() {
/* 318 */     return getDAO_().getAccountPayments();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountPayments(BigDecimal argAccountPayments) {
/* 326 */     if (setAccountPayments_noev(argAccountPayments) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(ICustomerItemAccountJournal.SET_ACCOUNTPAYMENTS, argAccountPayments);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountPayments_noev(BigDecimal argAccountPayments) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getAccountPayments() == null && argAccountPayments != null) || (
/* 339 */       getDAO_().getAccountPayments() != null && !getDAO_().getAccountPayments().equals(argAccountPayments))) {
/* 340 */       getDAO_().setAccountPayments(argAccountPayments);
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
/*     */   public BigDecimal getActiveAccountPayments() {
/* 352 */     return getDAO_().getActiveAccountPayments();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveAccountPayments(BigDecimal argActiveAccountPayments) {
/* 360 */     if (setActiveAccountPayments_noev(argActiveAccountPayments) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(ICustomerItemAccountJournal.SET_ACTIVEACCOUNTPAYMENTS, argActiveAccountPayments);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActiveAccountPayments_noev(BigDecimal argActiveAccountPayments) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getActiveAccountPayments() == null && argActiveAccountPayments != null) || (
/* 373 */       getDAO_().getActiveAccountPayments() != null && !getDAO_().getActiveAccountPayments().equals(argActiveAccountPayments))) {
/* 374 */       getDAO_().setActiveAccountPayments(argActiveAccountPayments);
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
/*     */   public BigDecimal getActiveAccountTotal() {
/* 386 */     return getDAO_().getActiveAccountTotal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveAccountTotal(BigDecimal argActiveAccountTotal) {
/* 394 */     if (setActiveAccountTotal_noev(argActiveAccountTotal) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(ICustomerItemAccountJournal.SET_ACTIVEACCOUNTTOTAL, argActiveAccountTotal);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActiveAccountTotal_noev(BigDecimal argActiveAccountTotal) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getActiveAccountTotal() == null && argActiveAccountTotal != null) || (
/* 407 */       getDAO_().getActiveAccountTotal() != null && !getDAO_().getActiveAccountTotal().equals(argActiveAccountTotal))) {
/* 408 */       getDAO_().setActiveAccountTotal(argActiveAccountTotal);
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 418 */     if ("CustomerItemAccountJournalExtension".equals(argFieldId)) {
/* 419 */       return this._myExtension;
/*     */     }
/*     */     
/* 422 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 428 */     if ("CustomerItemAccountJournalExtension".equals(argFieldId)) {
/* 429 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 432 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 438 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerItemAccountJournalExt() {
/* 442 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerItemAccountJournalExt(IDataModel argExt) {
/* 446 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 451 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 455 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 458 */     super.startTransaction();
/*     */ 
/*     */     
/* 461 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 466 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 469 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 475 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 478 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 481 */     super.commitTransaction();
/*     */ 
/*     */     
/* 484 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */