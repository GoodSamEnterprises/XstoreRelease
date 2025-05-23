/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.xst.dao.ctl.IEventLogEntry;
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
/*     */ public class EventLogEntryModel
/*     */   extends EventLogEntryBaseModel
/*     */   implements IEventLogEntry
/*     */ {
/*     */   private static final long serialVersionUID = 879668264L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  32 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initDAO() {
/*  37 */     setDAO((IDataAccessObject)new EventLogEntryDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EventLogEntryDAO getDAO_() {
/*  45 */     return (EventLogEntryDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  53 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  61 */     if (setCreateDate_noev(argCreateDate) && 
/*  62 */       this._events != null && 
/*  63 */       postEventsForChanges()) {
/*  64 */       this._events.post(IEventLogEntry.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  71 */     boolean ev_postable = false;
/*     */     
/*  73 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  74 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  75 */       getDAO_().setCreateDate(argCreateDate);
/*  76 */       ev_postable = true;
/*     */     } 
/*     */     
/*  79 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  87 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  95 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  96 */       this._events != null && 
/*  97 */       postEventsForChanges()) {
/*  98 */       this._events.post(IEventLogEntry.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 105 */     boolean ev_postable = false;
/*     */     
/* 107 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 108 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 109 */       getDAO_().setCreateUserId(argCreateUserId);
/* 110 */       ev_postable = true;
/*     */     } 
/*     */     
/* 113 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 121 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 129 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 130 */       this._events != null && 
/* 131 */       postEventsForChanges()) {
/* 132 */       this._events.post(IEventLogEntry.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 139 */     boolean ev_postable = false;
/*     */     
/* 141 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 142 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 143 */       getDAO_().setUpdateDate(argUpdateDate);
/* 144 */       ev_postable = true;
/*     */     } 
/*     */     
/* 147 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 155 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 163 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 164 */       this._events != null && 
/* 165 */       postEventsForChanges()) {
/* 166 */       this._events.post(IEventLogEntry.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 173 */     boolean ev_postable = false;
/*     */     
/* 175 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 176 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 177 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 178 */       ev_postable = true;
/*     */     } 
/*     */     
/* 181 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 189 */     if (getDAO_().getOrganizationId() != null) {
/* 190 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 193 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 202 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 211 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 212 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 224 */     if (getDAO_().getRetailLocationId() != null) {
/* 225 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 228 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 237 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 243 */     boolean ev_postable = false;
/*     */     
/* 245 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 246 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 247 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 248 */       ev_postable = true;
/*     */     } 
/*     */     
/* 251 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 259 */     if (getDAO_().getWorkstationId() != null) {
/* 260 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 263 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 272 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 278 */     boolean ev_postable = false;
/*     */     
/* 280 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 281 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 282 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 283 */       ev_postable = true;
/*     */     } 
/*     */     
/* 286 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 294 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 302 */     if (setBusinessDate_noev(argBusinessDate));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 308 */     boolean ev_postable = false;
/*     */     
/* 310 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 311 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 312 */       getDAO_().setBusinessDate(argBusinessDate);
/* 313 */       ev_postable = true;
/*     */     } 
/*     */     
/* 316 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOperatorPartyId() {
/* 324 */     if (getDAO_().getOperatorPartyId() != null) {
/* 325 */       return getDAO_().getOperatorPartyId().longValue();
/*     */     }
/*     */     
/* 328 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOperatorPartyId(long argOperatorPartyId) {
/* 337 */     if (setOperatorPartyId_noev(argOperatorPartyId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOperatorPartyId_noev(long argOperatorPartyId) {
/* 343 */     boolean ev_postable = false;
/*     */     
/* 345 */     if ((getDAO_().getOperatorPartyId() == null && Long.valueOf(argOperatorPartyId) != null) || (
/* 346 */       getDAO_().getOperatorPartyId() != null && !getDAO_().getOperatorPartyId().equals(Long.valueOf(argOperatorPartyId)))) {
/* 347 */       getDAO_().setOperatorPartyId(Long.valueOf(argOperatorPartyId));
/* 348 */       ev_postable = true;
/*     */     } 
/*     */     
/* 351 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLogLevel() {
/* 359 */     return getDAO_().getLogLevel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogLevel(String argLogLevel) {
/* 367 */     if (setLogLevel_noev(argLogLevel));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLogLevel_noev(String argLogLevel) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getLogLevel() == null && argLogLevel != null) || (
/* 376 */       getDAO_().getLogLevel() != null && !getDAO_().getLogLevel().equals(argLogLevel))) {
/* 377 */       getDAO_().setLogLevel(argLogLevel);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLogTimestamp() {
/* 389 */     return getDAO_().getLogTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogTimestamp(Date argLogTimestamp) {
/* 397 */     super.setLogTimestamp(argLogTimestamp);
/*     */     
/* 399 */     if (setLogTimestamp_noev(argLogTimestamp));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLogTimestamp_noev(Date argLogTimestamp) {
/* 405 */     boolean ev_postable = false;
/*     */     
/* 407 */     if ((getDAO_().getLogTimestamp() == null && argLogTimestamp != null) || (
/* 408 */       getDAO_().getLogTimestamp() != null && !getDAO_().getLogTimestamp().equals(argLogTimestamp))) {
/* 409 */       getDAO_().setLogTimestamp(argLogTimestamp);
/* 410 */       ev_postable = true;
/*     */     } 
/*     */     
/* 413 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSource() {
/* 421 */     return getDAO_().getSource();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSource(String argSource) {
/* 429 */     if (setSource_noev(argSource));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSource_noev(String argSource) {
/* 435 */     boolean ev_postable = false;
/*     */     
/* 437 */     if ((getDAO_().getSource() == null && argSource != null) || (
/* 438 */       getDAO_().getSource() != null && !getDAO_().getSource().equals(argSource))) {
/* 439 */       getDAO_().setSource(argSource);
/* 440 */       ev_postable = true;
/*     */     } 
/*     */     
/* 443 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getThreadName() {
/* 451 */     return getDAO_().getThreadName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThreadName(String argThreadName) {
/* 459 */     if (setThreadName_noev(argThreadName));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setThreadName_noev(String argThreadName) {
/* 465 */     boolean ev_postable = false;
/*     */     
/* 467 */     if ((getDAO_().getThreadName() == null && argThreadName != null) || (
/* 468 */       getDAO_().getThreadName() != null && !getDAO_().getThreadName().equals(argThreadName))) {
/* 469 */       getDAO_().setThreadName(argThreadName);
/* 470 */       ev_postable = true;
/*     */     } 
/*     */     
/* 473 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCriticalToDeliver() {
/* 481 */     if (getDAO_().getCriticalToDeliver() != null) {
/* 482 */       return getDAO_().getCriticalToDeliver().booleanValue();
/*     */     }
/*     */     
/* 485 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCriticalToDeliver(boolean argCriticalToDeliver) {
/* 494 */     if (setCriticalToDeliver_noev(argCriticalToDeliver));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCriticalToDeliver_noev(boolean argCriticalToDeliver) {
/* 500 */     boolean ev_postable = false;
/*     */     
/* 502 */     if ((getDAO_().getCriticalToDeliver() == null && Boolean.valueOf(argCriticalToDeliver) != null) || (
/* 503 */       getDAO_().getCriticalToDeliver() != null && !getDAO_().getCriticalToDeliver().equals(Boolean.valueOf(argCriticalToDeliver)))) {
/* 504 */       getDAO_().setCriticalToDeliver(Boolean.valueOf(argCriticalToDeliver));
/* 505 */       ev_postable = true;
/*     */     } 
/*     */     
/* 508 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoggerCategory() {
/* 516 */     return getDAO_().getLoggerCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoggerCategory(String argLoggerCategory) {
/* 524 */     if (setLoggerCategory_noev(argLoggerCategory));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLoggerCategory_noev(String argLoggerCategory) {
/* 530 */     boolean ev_postable = false;
/*     */     
/* 532 */     if ((getDAO_().getLoggerCategory() == null && argLoggerCategory != null) || (
/* 533 */       getDAO_().getLoggerCategory() != null && !getDAO_().getLoggerCategory().equals(argLoggerCategory))) {
/* 534 */       getDAO_().setLoggerCategory(argLoggerCategory);
/* 535 */       ev_postable = true;
/*     */     } 
/*     */     
/* 538 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLogMessage() {
/* 546 */     return getDAO_().getLogMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogMessage(String argLogMessage) {
/* 554 */     if (setLogMessage_noev(argLogMessage));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLogMessage_noev(String argLogMessage) {
/* 560 */     boolean ev_postable = false;
/*     */     
/* 562 */     if ((getDAO_().getLogMessage() == null && argLogMessage != null) || (
/* 563 */       getDAO_().getLogMessage() != null && !getDAO_().getLogMessage().equals(argLogMessage))) {
/* 564 */       getDAO_().setLogMessage(argLogMessage);
/* 565 */       ev_postable = true;
/*     */     } 
/*     */     
/* 568 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getArrivalTimestamp() {
/* 576 */     return getDAO_().getArrivalTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArrivalTimestamp(Date argArrivalTimestamp) {
/* 584 */     if (setArrivalTimestamp_noev(argArrivalTimestamp));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setArrivalTimestamp_noev(Date argArrivalTimestamp) {
/* 590 */     boolean ev_postable = false;
/*     */     
/* 592 */     if ((getDAO_().getArrivalTimestamp() == null && argArrivalTimestamp != null) || (
/* 593 */       getDAO_().getArrivalTimestamp() != null && !getDAO_().getArrivalTimestamp().equals(argArrivalTimestamp))) {
/* 594 */       getDAO_().setArrivalTimestamp(argArrivalTimestamp);
/* 595 */       ev_postable = true;
/*     */     } 
/*     */     
/* 598 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 604 */     if ("EventLogEntryExtension".equals(argFieldId)) {
/* 605 */       return this._myExtension;
/*     */     }
/*     */     
/* 608 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 614 */     if ("EventLogEntryExtension".equals(argFieldId)) {
/* 615 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 618 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 624 */     this._persistenceDefaults = argPD;
/* 625 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 626 */     this._eventManager = argEM;
/* 627 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 628 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */   
/*     */   public IDataModel getEventLogEntryExt() {
/* 632 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEventLogEntryExt(IDataModel argExt) {
/* 636 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 641 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 645 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 648 */     super.startTransaction();
/*     */ 
/*     */     
/* 651 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 656 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 659 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 665 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 668 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 671 */     super.commitTransaction();
/*     */ 
/*     */     
/* 674 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\EventLogEntryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */