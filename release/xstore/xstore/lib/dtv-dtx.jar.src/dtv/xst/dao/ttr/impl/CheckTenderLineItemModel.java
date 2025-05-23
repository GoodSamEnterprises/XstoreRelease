/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.ttr.ICheckTenderLineItem;
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
/*     */ public class CheckTenderLineItemModel
/*     */   extends TenderLineItemModel
/*     */   implements ICheckTenderLineItem
/*     */ {
/*     */   private static final long serialVersionUID = -1404906717L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new CheckTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CheckTenderLineItemDAO getDAO_() {
/*  38 */     return (CheckTenderLineItemDAO)this._daoImpl;
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
/*  57 */       this._events.post(ICheckTenderLineItem.SET_CREATEDATE, argCreateDate);
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
/*  91 */       this._events.post(ICheckTenderLineItem.SET_CREATEUSERID, argCreateUserId);
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
/* 125 */       this._events.post(ICheckTenderLineItem.SET_UPDATEDATE, argUpdateDate);
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
/* 159 */       this._events.post(ICheckTenderLineItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getAdjudicationCode() {
/* 182 */     return getDAO_().getAdjudicationCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 190 */     if (setAdjudicationCode_noev(argAdjudicationCode) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(ICheckTenderLineItem.SET_ADJUDICATIONCODE, argAdjudicationCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAdjudicationCode_noev(String argAdjudicationCode) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getAdjudicationCode() == null && argAdjudicationCode != null) || (
/* 203 */       getDAO_().getAdjudicationCode() != null && !getDAO_().getAdjudicationCode().equals(argAdjudicationCode))) {
/* 204 */       getDAO_().setAdjudicationCode(argAdjudicationCode);
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
/*     */   public String getAuthorizationCode() {
/* 216 */     return getDAO_().getAuthorizationCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 224 */     if (setAuthorizationCode_noev(argAuthorizationCode) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(ICheckTenderLineItem.SET_AUTHORIZATIONCODE, argAuthorizationCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorizationCode_noev(String argAuthorizationCode) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getAuthorizationCode() == null && argAuthorizationCode != null) || (
/* 237 */       getDAO_().getAuthorizationCode() != null && !getDAO_().getAuthorizationCode().equals(argAuthorizationCode))) {
/* 238 */       getDAO_().setAuthorizationCode(argAuthorizationCode);
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
/*     */   public String getAuthorizationMethodCode() {
/* 250 */     return getDAO_().getAuthorizationMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 258 */     if (setAuthorizationMethodCode_noev(argAuthorizationMethodCode) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(ICheckTenderLineItem.SET_AUTHORIZATIONMETHODCODE, argAuthorizationMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorizationMethodCode_noev(String argAuthorizationMethodCode) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getAuthorizationMethodCode() == null && argAuthorizationMethodCode != null) || (
/* 271 */       getDAO_().getAuthorizationMethodCode() != null && !getDAO_().getAuthorizationMethodCode().equals(argAuthorizationMethodCode))) {
/* 272 */       getDAO_().setAuthorizationMethodCode(argAuthorizationMethodCode);
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
/*     */   public String getBankId() {
/* 284 */     return getDAO_().getBankId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBankId(String argBankId) {
/* 292 */     if (setBankId_noev(argBankId) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(ICheckTenderLineItem.SET_BANKID, argBankId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBankId_noev(String argBankId) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getBankId() == null && argBankId != null) || (
/* 305 */       getDAO_().getBankId() != null && !getDAO_().getBankId().equals(argBankId))) {
/* 306 */       getDAO_().setBankId(argBankId);
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
/*     */   public String getCheckAccountNumber() {
/* 318 */     return getDAO_().getCheckAccountNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCheckAccountNumber(String argCheckAccountNumber) {
/* 326 */     if (setCheckAccountNumber_noev(argCheckAccountNumber) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(ICheckTenderLineItem.SET_CHECKACCOUNTNUMBER, argCheckAccountNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCheckAccountNumber_noev(String argCheckAccountNumber) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getCheckAccountNumber() == null && argCheckAccountNumber != null) || (
/* 339 */       getDAO_().getCheckAccountNumber() != null && !getDAO_().getCheckAccountNumber().equals(argCheckAccountNumber))) {
/* 340 */       getDAO_().setCheckAccountNumber(argCheckAccountNumber);
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
/*     */   public String getCheckSequenceNumber() {
/* 352 */     return getDAO_().getCheckSequenceNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCheckSequenceNumber(String argCheckSequenceNumber) {
/* 360 */     if (setCheckSequenceNumber_noev(argCheckSequenceNumber) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(ICheckTenderLineItem.SET_CHECKSEQUENCENUMBER, argCheckSequenceNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCheckSequenceNumber_noev(String argCheckSequenceNumber) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getCheckSequenceNumber() == null && argCheckSequenceNumber != null) || (
/* 373 */       getDAO_().getCheckSequenceNumber() != null && !getDAO_().getCheckSequenceNumber().equals(argCheckSequenceNumber))) {
/* 374 */       getDAO_().setCheckSequenceNumber(argCheckSequenceNumber);
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
/*     */   public Date getCustomerBirthDate() {
/* 386 */     return getDAO_().getCustomerBirthDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerBirthDate(Date argCustomerBirthDate) {
/* 394 */     if (setCustomerBirthDate_noev(argCustomerBirthDate) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(ICheckTenderLineItem.SET_CUSTOMERBIRTHDATE, argCustomerBirthDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerBirthDate_noev(Date argCustomerBirthDate) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getCustomerBirthDate() == null && argCustomerBirthDate != null) || (
/* 407 */       getDAO_().getCustomerBirthDate() != null && !getDAO_().getCustomerBirthDate().equals(argCustomerBirthDate))) {
/* 408 */       getDAO_().setCustomerBirthDate(argCustomerBirthDate);
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
/*     */   public String getEntryMethodCode() {
/* 420 */     return getDAO_().getEntryMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 428 */     if (setEntryMethodCode_noev(argEntryMethodCode) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(ICheckTenderLineItem.SET_ENTRYMETHODCODE, argEntryMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryMethodCode_noev(String argEntryMethodCode) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getEntryMethodCode() == null && argEntryMethodCode != null) || (
/* 441 */       getDAO_().getEntryMethodCode() != null && !getDAO_().getEntryMethodCode().equals(argEntryMethodCode))) {
/* 442 */       getDAO_().setEntryMethodCode(argEntryMethodCode);
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
/*     */   public String getMicrData() {
/* 454 */     return getDAO_().getMicrData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMicrData(String argMicrData) {
/* 462 */     if (setMicrData_noev(argMicrData) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(ICheckTenderLineItem.SET_MICRDATA, argMicrData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMicrData_noev(String argMicrData) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getMicrData() == null && argMicrData != null) || (
/* 475 */       getDAO_().getMicrData() != null && !getDAO_().getMicrData().equals(argMicrData))) {
/* 476 */       getDAO_().setMicrData(argMicrData);
/* 477 */       ev_postable = true;
/*     */     } 
/*     */     
/* 480 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 486 */     if ("CheckTenderLineItemExtension".equals(argFieldId)) {
/* 487 */       return this._myExtension;
/*     */     }
/*     */     
/* 490 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 496 */     if ("CheckTenderLineItemExtension".equals(argFieldId)) {
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
/*     */   public IDataModel getCheckTenderLineItemExt() {
/* 510 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCheckTenderLineItemExt(IDataModel argExt) {
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
/*     */   public String getBankReferenceNumber() {
/* 570 */     return getAdjudicationCode();
/*     */   }
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 574 */     setAdjudicationCode(argBankReferenceNumber);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CheckTenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */