/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelImpl;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.xst.dao.sec.ISecurityLog;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SecurityLogModel
/*     */   extends AbstractDataModelImpl
/*     */   implements ISecurityLog
/*     */ {
/*     */   private static final long serialVersionUID = -1077013564L;
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
/*  36 */     setDAO((IDataAccessObject)new SecurityLogDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SecurityLogDAO getDAO_() {
/*  44 */     return (SecurityLogDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  52 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  60 */     if (setCreateDate_noev(argCreateDate) && 
/*  61 */       this._events != null && 
/*  62 */       postEventsForChanges()) {
/*  63 */       this._events.post(ISecurityLog.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  70 */     boolean ev_postable = false;
/*     */     
/*  72 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  73 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  74 */       getDAO_().setCreateDate(argCreateDate);
/*  75 */       ev_postable = true;
/*     */     } 
/*     */     
/*  78 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  86 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  94 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  95 */       this._events != null && 
/*  96 */       postEventsForChanges()) {
/*  97 */       this._events.post(ISecurityLog.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 104 */     boolean ev_postable = false;
/*     */     
/* 106 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 107 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 108 */       getDAO_().setCreateUserId(argCreateUserId);
/* 109 */       ev_postable = true;
/*     */     } 
/*     */     
/* 112 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 120 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 128 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 129 */       this._events != null && 
/* 130 */       postEventsForChanges()) {
/* 131 */       this._events.post(ISecurityLog.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 138 */     boolean ev_postable = false;
/*     */     
/* 140 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 141 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 142 */       getDAO_().setUpdateDate(argUpdateDate);
/* 143 */       ev_postable = true;
/*     */     } 
/*     */     
/* 146 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 154 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 162 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 163 */       this._events != null && 
/* 164 */       postEventsForChanges()) {
/* 165 */       this._events.post(ISecurityLog.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 172 */     boolean ev_postable = false;
/*     */     
/* 174 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 175 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 176 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 177 */       ev_postable = true;
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 188 */     if (getDAO_().getOrganizationId() != null) {
/* 189 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 192 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 201 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(ISecurityLog.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 214 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 215 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 216 */       ev_postable = true;
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 227 */     if (getDAO_().getRetailLocationId() != null) {
/* 228 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 231 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 240 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(ISecurityLog.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 253 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 254 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
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
/*     */   public long getWorkstationId() {
/* 266 */     if (getDAO_().getWorkstationId() != null) {
/* 267 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 270 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 279 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(ISecurityLog.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 292 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 293 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 294 */       ev_postable = true;
/*     */     } 
/*     */     
/* 297 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 305 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 313 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(ISecurityLog.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 326 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 327 */       getDAO_().setBusinessDate(argBusinessDate);
/* 328 */       ev_postable = true;
/*     */     } 
/*     */     
/* 331 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 339 */     if (getDAO_().getTransactionSequence() != null) {
/* 340 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 343 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 352 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 353 */       this._events != null && 
/* 354 */       postEventsForChanges()) {
/* 355 */       this._events.post(ISecurityLog.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 362 */     boolean ev_postable = false;
/*     */     
/* 364 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 365 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 366 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
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
/*     */   public String getActivityType() {
/* 378 */     return getDAO_().getActivityType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityType(String argActivityType) {
/* 386 */     if (setActivityType_noev(argActivityType) && 
/* 387 */       this._events != null && 
/* 388 */       postEventsForChanges()) {
/* 389 */       this._events.post(ISecurityLog.SET_ACTIVITYTYPE, argActivityType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivityType_noev(String argActivityType) {
/* 396 */     boolean ev_postable = false;
/*     */     
/* 398 */     if ((getDAO_().getActivityType() == null && argActivityType != null) || (
/* 399 */       getDAO_().getActivityType() != null && !getDAO_().getActivityType().equals(argActivityType))) {
/* 400 */       getDAO_().setActivityType(argActivityType);
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
/*     */   public boolean getSuccess() {
/* 412 */     if (getDAO_().getSuccess() != null) {
/* 413 */       return getDAO_().getSuccess().booleanValue();
/*     */     }
/*     */     
/* 416 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuccess(boolean argSuccess) {
/* 425 */     if (setSuccess_noev(argSuccess) && 
/* 426 */       this._events != null && 
/* 427 */       postEventsForChanges()) {
/* 428 */       this._events.post(ISecurityLog.SET_SUCCESS, Boolean.valueOf(argSuccess));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSuccess_noev(boolean argSuccess) {
/* 435 */     boolean ev_postable = false;
/*     */     
/* 437 */     if ((getDAO_().getSuccess() == null && Boolean.valueOf(argSuccess) != null) || (
/* 438 */       getDAO_().getSuccess() != null && !getDAO_().getSuccess().equals(Boolean.valueOf(argSuccess)))) {
/* 439 */       getDAO_().setSuccess(Boolean.valueOf(argSuccess));
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
/*     */   public String getEmployeeId() {
/* 451 */     return getDAO_().getEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 459 */     if (setEmployeeId_noev(argEmployeeId) && 
/* 460 */       this._events != null && 
/* 461 */       postEventsForChanges()) {
/* 462 */       this._events.post(ISecurityLog.SET_EMPLOYEEID, argEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeId_noev(String argEmployeeId) {
/* 469 */     boolean ev_postable = false;
/*     */     
/* 471 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/* 472 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/* 473 */       getDAO_().setEmployeeId(argEmployeeId);
/* 474 */       ev_postable = true;
/*     */     } 
/*     */     
/* 477 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOverridingEmployeeId() {
/* 485 */     return getDAO_().getOverridingEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverridingEmployeeId(String argOverridingEmployeeId) {
/* 493 */     if (setOverridingEmployeeId_noev(argOverridingEmployeeId) && 
/* 494 */       this._events != null && 
/* 495 */       postEventsForChanges()) {
/* 496 */       this._events.post(ISecurityLog.SET_OVERRIDINGEMPLOYEEID, argOverridingEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOverridingEmployeeId_noev(String argOverridingEmployeeId) {
/* 503 */     boolean ev_postable = false;
/*     */     
/* 505 */     if ((getDAO_().getOverridingEmployeeId() == null && argOverridingEmployeeId != null) || (
/* 506 */       getDAO_().getOverridingEmployeeId() != null && !getDAO_().getOverridingEmployeeId().equals(argOverridingEmployeeId))) {
/* 507 */       getDAO_().setOverridingEmployeeId(argOverridingEmployeeId);
/* 508 */       ev_postable = true;
/*     */     } 
/*     */     
/* 511 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrivilegeType() {
/* 519 */     return getDAO_().getPrivilegeType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/* 527 */     if (setPrivilegeType_noev(argPrivilegeType) && 
/* 528 */       this._events != null && 
/* 529 */       postEventsForChanges()) {
/* 530 */       this._events.post(ISecurityLog.SET_PRIVILEGETYPE, argPrivilegeType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrivilegeType_noev(String argPrivilegeType) {
/* 537 */     boolean ev_postable = false;
/*     */     
/* 539 */     if ((getDAO_().getPrivilegeType() == null && argPrivilegeType != null) || (
/* 540 */       getDAO_().getPrivilegeType() != null && !getDAO_().getPrivilegeType().equals(argPrivilegeType))) {
/* 541 */       getDAO_().setPrivilegeType(argPrivilegeType);
/* 542 */       ev_postable = true;
/*     */     } 
/*     */     
/* 545 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getSystemDateTime() {
/* 553 */     return getDAO_().getSystemDateTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSystemDateTime(Date argSystemDateTime) {
/* 561 */     if (setSystemDateTime_noev(argSystemDateTime) && 
/* 562 */       this._events != null && 
/* 563 */       postEventsForChanges()) {
/* 564 */       this._events.post(ISecurityLog.SET_SYSTEMDATETIME, argSystemDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSystemDateTime_noev(Date argSystemDateTime) {
/* 571 */     boolean ev_postable = false;
/*     */     
/* 573 */     if ((getDAO_().getSystemDateTime() == null && argSystemDateTime != null) || (
/* 574 */       getDAO_().getSystemDateTime() != null && !getDAO_().getSystemDateTime().equals(argSystemDateTime))) {
/* 575 */       getDAO_().setSystemDateTime(argSystemDateTime);
/* 576 */       ev_postable = true;
/*     */     } 
/*     */     
/* 579 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 585 */     if ("SecurityLogExtension".equals(argFieldId)) {
/* 586 */       return this._myExtension;
/*     */     }
/*     */     
/* 589 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 595 */     if ("SecurityLogExtension".equals(argFieldId)) {
/* 596 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 599 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 605 */     this._persistenceDefaults = argPD;
/* 606 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 607 */     this._eventManager = argEM;
/* 608 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 609 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */   
/*     */   public IDataModel getSecurityLogExt() {
/* 613 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSecurityLogExt(IDataModel argExt) {
/* 617 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 622 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 626 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 629 */     super.startTransaction();
/*     */ 
/*     */     
/* 632 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 637 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 640 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 646 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 649 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 652 */     super.commitTransaction();
/*     */ 
/*     */     
/* 655 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 660 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\SecurityLogModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */