/*     */ package dtv.xst.dao.thr.impl;
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
/*     */ import dtv.xst.dao.hrs.IWorkCodes;
/*     */ import dtv.xst.dao.hrs.WorkCodesId;
/*     */ import dtv.xst.dao.thr.ITimecardJournal;
/*     */ import dtv.xst.dao.thr.ITimeclockTransaction;
/*     */ import dtv.xst.dao.thr.TimecardJournalId;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TimeclockTransactionModel extends PosTransactionModel implements ITimeclockTransaction {
/*     */   private static final long serialVersionUID = 1261991645L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IWorkCodes _workCode;
/*     */   private transient IWorkCodes _workCodeSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  31 */     setDAO((IDataAccessObject)new TimeclockTransactionDAO());
/*     */   }
/*     */   
/*     */   private transient boolean _updateFlag;
/*     */   private transient IWorkCodes _oldWorkCode;
/*     */   private transient Date _oldClockInDateTime;
/*     */   
/*     */   private TimeclockTransactionDAO getDAO_() {
/*  39 */     return (TimeclockTransactionDAO)this._daoImpl;
/*     */   }
/*     */   
/*     */   private transient Date _oldClockOutDateTime;
/*     */   private transient IWorkCodes _workCodes;
/*     */   private transient ITimecardJournal _journal;
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
/*  58 */       this._events.post(ITimeclockTransaction.SET_CREATEDATE, argCreateDate);
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
/*  92 */       this._events.post(ITimeclockTransaction.SET_CREATEUSERID, argCreateUserId);
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
/* 126 */       this._events.post(ITimeclockTransaction.SET_UPDATEDATE, argUpdateDate);
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
/* 160 */       this._events.post(ITimeclockTransaction.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getTimeclockEntryCodes() {
/* 183 */     return getDAO_().getTimeclockEntryCodes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeclockEntryCodes(String argTimeclockEntryCodes) {
/* 191 */     if (setTimeclockEntryCodes_noev(argTimeclockEntryCodes) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(ITimeclockTransaction.SET_TIMECLOCKENTRYCODES, argTimeclockEntryCodes);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimeclockEntryCodes_noev(String argTimeclockEntryCodes) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getTimeclockEntryCodes() == null && argTimeclockEntryCodes != null) || (
/* 204 */       getDAO_().getTimeclockEntryCodes() != null && !getDAO_().getTimeclockEntryCodes().equals(argTimeclockEntryCodes))) {
/* 205 */       getDAO_().setTimeclockEntryCodes(argTimeclockEntryCodes);
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
/*     */   public long getPartyId() {
/* 217 */     if (getDAO_().getPartyId() != null) {
/* 218 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 221 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 230 */     if (setPartyId_noev(argPartyId) && 
/* 231 */       this._events != null && 
/* 232 */       postEventsForChanges()) {
/* 233 */       this._events.post(ITimeclockTransaction.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 240 */     boolean ev_postable = false;
/*     */     
/* 242 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 243 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 244 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 245 */       ev_postable = true;
/*     */     } 
/*     */     
/* 248 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimecardEntryId() {
/* 256 */     if (getDAO_().getTimecardEntryId() != null) {
/* 257 */       return getDAO_().getTimecardEntryId().longValue();
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
/*     */   public void setTimecardEntryId(long argTimecardEntryId) {
/* 269 */     if (setTimecardEntryId_noev(argTimecardEntryId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(ITimeclockTransaction.SET_TIMECARDENTRYID, Long.valueOf(argTimecardEntryId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimecardEntryId_noev(long argTimecardEntryId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getTimecardEntryId() == null && Long.valueOf(argTimecardEntryId) != null) || (
/* 282 */       getDAO_().getTimecardEntryId() != null && !getDAO_().getTimecardEntryId().equals(Long.valueOf(argTimecardEntryId)))) {
/* 283 */       getDAO_().setTimecardEntryId(Long.valueOf(argTimecardEntryId));
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimecardEntrySeq() {
/* 295 */     if (getDAO_().getTimecardEntrySeq() != null) {
/* 296 */       return getDAO_().getTimecardEntrySeq().longValue();
/*     */     }
/*     */     
/* 299 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimecardEntrySeq(long argTimecardEntrySeq) {
/* 308 */     if (setTimecardEntrySeq_noev(argTimecardEntrySeq) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(ITimeclockTransaction.SET_TIMECARDENTRYSEQ, Long.valueOf(argTimecardEntrySeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimecardEntrySeq_noev(long argTimecardEntrySeq) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getTimecardEntrySeq() == null && Long.valueOf(argTimecardEntrySeq) != null) || (
/* 321 */       getDAO_().getTimecardEntrySeq() != null && !getDAO_().getTimecardEntrySeq().equals(Long.valueOf(argTimecardEntrySeq)))) {
/* 322 */       getDAO_().setTimecardEntrySeq(Long.valueOf(argTimecardEntrySeq));
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
/*     */   public Date getTimecardEntryBusinessDate() {
/* 334 */     return getDAO_().getTimecardEntryBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimecardEntryBusinessDate(Date argTimecardEntryBusinessDate) {
/* 342 */     if (setTimecardEntryBusinessDate_noev(argTimecardEntryBusinessDate) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(ITimeclockTransaction.SET_TIMECARDENTRYBUSINESSDATE, argTimecardEntryBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimecardEntryBusinessDate_noev(Date argTimecardEntryBusinessDate) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getTimecardEntryBusinessDate() == null && argTimecardEntryBusinessDate != null) || (
/* 355 */       getDAO_().getTimecardEntryBusinessDate() != null && !getDAO_().getTimecardEntryBusinessDate().equals(argTimecardEntryBusinessDate))) {
/* 356 */       getDAO_().setTimecardEntryBusinessDate(argTimecardEntryBusinessDate);
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
/*     */   public long getTimecardEntryWorkstationId() {
/* 368 */     if (getDAO_().getTimecardEntryWorkstationId() != null) {
/* 369 */       return getDAO_().getTimecardEntryWorkstationId().longValue();
/*     */     }
/*     */     
/* 372 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimecardEntryWorkstationId(long argTimecardEntryWorkstationId) {
/* 381 */     if (setTimecardEntryWorkstationId_noev(argTimecardEntryWorkstationId) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(ITimeclockTransaction.SET_TIMECARDENTRYWORKSTATIONID, Long.valueOf(argTimecardEntryWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimecardEntryWorkstationId_noev(long argTimecardEntryWorkstationId) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getTimecardEntryWorkstationId() == null && Long.valueOf(argTimecardEntryWorkstationId) != null) || (
/* 394 */       getDAO_().getTimecardEntryWorkstationId() != null && !getDAO_().getTimecardEntryWorkstationId().equals(Long.valueOf(argTimecardEntryWorkstationId)))) {
/* 395 */       getDAO_().setTimecardEntryWorkstationId(Long.valueOf(argTimecardEntryWorkstationId));
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkCodeString() {
/* 407 */     return getDAO_().getWorkCodeString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkCodeString(String argWorkCodeString) {
/* 415 */     if (setWorkCodeString_noev(argWorkCodeString) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(ITimeclockTransaction.SET_WORKCODESTRING, argWorkCodeString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkCodeString_noev(String argWorkCodeString) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getWorkCodeString() == null && argWorkCodeString != null) || (
/* 428 */       getDAO_().getWorkCodeString() != null && !getDAO_().getWorkCodeString().equals(argWorkCodeString))) {
/* 429 */       getDAO_().setWorkCodeString(argWorkCodeString);
/* 430 */       ev_postable = true;
/*     */     } 
/*     */     
/* 433 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "WorkCode")
/*     */   public IWorkCodes getWorkCode() {
/* 442 */     return this._workCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorkCode(IWorkCodes argWorkCode) {
/* 447 */     if (argWorkCode == null) {
/*     */       
/* 449 */       getDAO_().setWorkCodeString(null);
/* 450 */       if (this._workCode != null)
/*     */       {
/* 452 */         if (postEventsForChanges()) {
/* 453 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workCode));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 458 */       getDAO_().setWorkCodeString(argWorkCode.getWorkCode());
/*     */       
/* 460 */       if (postEventsForChanges()) {
/* 461 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkCode));
/*     */       }
/*     */     } 
/*     */     
/* 465 */     this._workCode = argWorkCode;
/* 466 */     if (postEventsForChanges()) {
/* 467 */       this._events.post(ITimeclockTransaction.SET_WORKCODE, argWorkCode);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 473 */     if ("WorkCode".equals(argFieldId)) {
/* 474 */       return getWorkCode();
/*     */     }
/* 476 */     if ("TimeclockTransactionExtension".equals(argFieldId)) {
/* 477 */       return this._myExtension;
/*     */     }
/*     */     
/* 480 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 486 */     if ("WorkCode".equals(argFieldId)) {
/* 487 */       setWorkCode((IWorkCodes)argValue);
/*     */     }
/* 489 */     else if ("TimeclockTransactionExtension".equals(argFieldId)) {
/* 490 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 493 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 499 */     super.setDependencies(argPD, argEM);
/* 500 */     if (this._workCode != null) {
/* 501 */       ((IDataModelImpl)this._workCode).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTimeclockTransactionExt() {
/* 506 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTimeclockTransactionExt(IDataModel argExt) {
/* 510 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 515 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 519 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 522 */     super.startTransaction();
/*     */     
/* 524 */     this._workCodeSavepoint = this._workCode;
/* 525 */     if (this._workCode != null) {
/* 526 */       this._workCode.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 530 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 535 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 538 */     super.rollbackChanges();
/*     */     
/* 540 */     this._workCode = this._workCodeSavepoint;
/* 541 */     this._workCodeSavepoint = null;
/* 542 */     if (this._workCode != null) {
/* 543 */       this._workCode.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 550 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 553 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 556 */     super.commitTransaction();
/*     */     
/* 558 */     this._workCodeSavepoint = this._workCode;
/* 559 */     if (this._workCode != null) {
/* 560 */       this._workCode.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 564 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 569 */     argStream.defaultReadObject();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimecardJournal(ITimecardJournal argJournal) {
/* 589 */     this._journal = argJournal;
/*     */   }
/*     */   
/*     */   public ITimecardJournal getTimecardJournal() {
/* 593 */     return this._journal;
/*     */   }
/*     */   
/*     */   public boolean getUpdateFlag() {
/* 597 */     return this._updateFlag;
/*     */   }
/*     */   
/*     */   public void setUpdateFlag(boolean updflg) {
/* 601 */     this._updateFlag = updflg;
/*     */   }
/*     */   
/*     */   public IWorkCodes getOldWorkCode() {
/* 605 */     return this._oldWorkCode;
/*     */   }
/*     */   
/*     */   public void setOldWorkCode(IWorkCodes argOldWork) {
/* 609 */     this._oldWorkCode = argOldWork;
/*     */   }
/*     */   
/*     */   public void setOldClockInDateTime(Date argOldInDate) {
/* 613 */     this._oldClockInDateTime = argOldInDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getOldClockOutDateTime() {
/* 618 */     return this._oldClockOutDateTime;
/*     */   }
/*     */   
/*     */   public void setOldClockOutDateTime(Date argOldOutDate) {
/* 622 */     this._oldClockOutDateTime = argOldOutDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getOldClockInDateTime() {
/* 627 */     return this._oldClockInDateTime;
/*     */   }
/*     */   
/*     */   public IWorkCodes getWorkCodes() {
/* 631 */     return this._workCodes;
/*     */   }
/*     */   
/*     */   public void setWorkCodes(IWorkCodes argWorkCodes) {
/* 635 */     setWorkCode(argWorkCodes);
/* 636 */     this._workCodes = argWorkCodes;
/*     */   }
/*     */   
/*     */   public TimecardJournalId getTimecardJournalIdObject() {
/* 640 */     TimecardJournalId id = new TimecardJournalId();
/* 641 */     id.setRetailLocationId(new Long(getRetailLocationId()));
/* 642 */     id.setBusinessDate(getTimecardEntryBusinessDate());
/* 643 */     id.setTimecardEntryId(new Long(getTimecardEntryId()));
/* 644 */     id.setTimecardEntrySeq(new Long(getTimecardEntrySeq()));
/* 645 */     id.setPartyId(new Long(getPartyId()));
/* 646 */     id.setWorkstationId(new Long(getTimecardEntryWorkstationId()));
/*     */     
/* 648 */     return id;
/*     */   }
/*     */   
/*     */   public WorkCodesId getWorkCodesIdObject() {
/* 652 */     WorkCodesId id = new WorkCodesId();
/* 653 */     id.setWorkCode(getWorkCodeString());
/* 654 */     return id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimeclockTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */