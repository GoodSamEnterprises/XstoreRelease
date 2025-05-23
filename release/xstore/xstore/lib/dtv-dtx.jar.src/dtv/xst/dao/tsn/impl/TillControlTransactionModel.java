/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.com.IReasonCode;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import dtv.xst.dao.tsn.ITillControlTransaction;
/*     */ import dtv.xst.dao.tsn.ITillControlTransactionDetail;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TillControlTransactionModel
/*     */   extends PosTransactionModel
/*     */   implements ITillControlTransaction {
/*     */   private static final long serialVersionUID = -62627594L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  33 */     setDAO((IDataAccessObject)new TillControlTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   private HistoricalList<ITillControlTransactionDetail> _tillControlTransactionDetails;
/*     */   private transient HistoricalList<ITillControlTransactionDetail> _tillControlTransactionDetailsSavepoint;
/*     */   
/*     */   private TillControlTransactionDAO getDAO_() {
/*  41 */     return (TillControlTransactionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   private IReasonCode _reasonCodeObject;
/*     */   private transient IReasonCode _reasonCodeObjectSavepoint;
/*     */   
/*     */   public long getOrganizationId() {
/*  49 */     if (getDAO_().getOrganizationId() != null) {
/*  50 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  53 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  62 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  68 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  71 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*  72 */       this._tillControlTransactionDetails != null) {
/*     */       
/*  74 */       Iterator<TillControlTransactionDetailModel> it = this._tillControlTransactionDetails.iterator();
/*  75 */       while (it.hasNext())
/*     */       {
/*  77 */         ((TillControlTransactionDetailModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  82 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  90 */     if (getDAO_().getRetailLocationId() != null) {
/*  91 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  94 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 103 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 109 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 112 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/* 113 */       this._tillControlTransactionDetails != null) {
/*     */       
/* 115 */       Iterator<TillControlTransactionDetailModel> it = this._tillControlTransactionDetails.iterator();
/* 116 */       while (it.hasNext())
/*     */       {
/* 118 */         ((TillControlTransactionDetailModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 123 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 131 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 139 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 140 */       this._events != null && 
/* 141 */       postEventsForChanges()) {
/* 142 */       this._events.post(ITillControlTransaction.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 149 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 152 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/* 153 */       this._tillControlTransactionDetails != null) {
/*     */       
/* 155 */       Iterator<TillControlTransactionDetailModel> it = this._tillControlTransactionDetails.iterator();
/* 156 */       while (it.hasNext())
/*     */       {
/* 158 */         ((TillControlTransactionDetailModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 163 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 171 */     if (getDAO_().getWorkstationId() != null) {
/* 172 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 175 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 184 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 190 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 193 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/* 194 */       this._tillControlTransactionDetails != null) {
/*     */       
/* 196 */       Iterator<TillControlTransactionDetailModel> it = this._tillControlTransactionDetails.iterator();
/* 197 */       while (it.hasNext())
/*     */       {
/* 199 */         ((TillControlTransactionDetailModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 204 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 212 */     if (getDAO_().getTransactionSequence() != null) {
/* 213 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 216 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 225 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(ITillControlTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 235 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 238 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/* 239 */       this._tillControlTransactionDetails != null) {
/*     */       
/* 241 */       Iterator<TillControlTransactionDetailModel> it = this._tillControlTransactionDetails.iterator();
/* 242 */       while (it.hasNext())
/*     */       {
/* 244 */         ((TillControlTransactionDetailModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 249 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 257 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 265 */     if (setCreateDate_noev(argCreateDate) && 
/* 266 */       this._events != null && 
/* 267 */       postEventsForChanges()) {
/* 268 */       this._events.post(ITillControlTransaction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 275 */     boolean ev_postable = false;
/*     */     
/* 277 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 278 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 279 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 291 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 299 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(ITillControlTransaction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 312 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 313 */       getDAO_().setCreateUserId(argCreateUserId);
/* 314 */       ev_postable = true;
/*     */     } 
/*     */     
/* 317 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 325 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 333 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 334 */       this._events != null && 
/* 335 */       postEventsForChanges()) {
/* 336 */       this._events.post(ITillControlTransaction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 343 */     boolean ev_postable = false;
/*     */     
/* 345 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 346 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 347 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 359 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 367 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 368 */       this._events != null && 
/* 369 */       postEventsForChanges()) {
/* 370 */       this._events.post(ITillControlTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 377 */     boolean ev_postable = false;
/*     */     
/* 379 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 380 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 381 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 382 */       ev_postable = true;
/*     */     } 
/*     */     
/* 385 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 393 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 401 */     if (setTypeCode_noev(argTypeCode) && 
/* 402 */       this._events != null && 
/* 403 */       postEventsForChanges()) {
/* 404 */       this._events.post(ITillControlTransaction.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 411 */     boolean ev_postable = false;
/*     */     
/* 413 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 414 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 415 */       getDAO_().setTypeCode(argTypeCode);
/* 416 */       ev_postable = true;
/*     */     } 
/*     */     
/* 419 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/* 427 */     return getDAO_().getEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 435 */     if (setEmployeeId_noev(argEmployeeId) && 
/* 436 */       this._events != null && 
/* 437 */       postEventsForChanges()) {
/* 438 */       this._events.post(ITillControlTransaction.SET_EMPLOYEEID, argEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeId_noev(String argEmployeeId) {
/* 445 */     boolean ev_postable = false;
/*     */     
/* 447 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/* 448 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/* 449 */       getDAO_().setEmployeeId(argEmployeeId);
/* 450 */       ev_postable = true;
/*     */     } 
/*     */     
/* 453 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReasonCode() {
/* 461 */     return getDAO_().getReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 469 */     if (setReasonCode_noev(argReasonCode) && 
/* 470 */       this._events != null && 
/* 471 */       postEventsForChanges()) {
/* 472 */       this._events.post(ITillControlTransaction.SET_REASONCODE, argReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReasonCode_noev(String argReasonCode) {
/* 479 */     boolean ev_postable = false;
/*     */     
/* 481 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/* 482 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/* 483 */       getDAO_().setReasonCode(argReasonCode);
/* 484 */       ev_postable = true;
/*     */     } 
/*     */     
/* 487 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "TillControlTransactionDetails")
/*     */   public List<ITillControlTransactionDetail> getTillControlTransactionDetails() {
/* 499 */     if (this._tillControlTransactionDetails == null) {
/* 500 */       this._tillControlTransactionDetails = new HistoricalList(null);
/*     */     }
/* 502 */     return (List<ITillControlTransactionDetail>)this._tillControlTransactionDetails;
/*     */   }
/*     */   
/*     */   public void setTillControlTransactionDetails(List<ITillControlTransactionDetail> argTillControlTransactionDetails) {
/* 506 */     if (this._tillControlTransactionDetails == null) {
/* 507 */       this._tillControlTransactionDetails = new HistoricalList(argTillControlTransactionDetails);
/*     */     } else {
/* 509 */       this._tillControlTransactionDetails.setCurrentList(argTillControlTransactionDetails);
/*     */     } 
/*     */     
/* 512 */     for (ITillControlTransactionDetail child : this._tillControlTransactionDetails) {
/* 513 */       child.setParentTransaction(this);
/*     */     }
/*     */     
/* 516 */     for (ITillControlTransactionDetail child : this._tillControlTransactionDetails) {
/* 517 */       TillControlTransactionDetailModel model = (TillControlTransactionDetailModel)child;
/* 518 */       model.setOrganizationId_noev(getOrganizationId());
/* 519 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 520 */       model.setWorkstationId_noev(getWorkstationId());
/* 521 */       model.setBusinessDate_noev(getBusinessDate());
/* 522 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 523 */       if (child instanceof IDataModelImpl) {
/* 524 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 525 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 526 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 527 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 530 */       if (postEventsForChanges()) {
/* 531 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addTillControlTransactionDetailImpl(ITillControlTransactionDetail argTillControlTransactionDetail) {
/* 538 */     argTillControlTransactionDetail.setParentTransaction(this);
/* 539 */     if (this._tillControlTransactionDetails == null) {
/* 540 */       this._tillControlTransactionDetails = new HistoricalList(null);
/*     */     }
/* 542 */     argTillControlTransactionDetail.setOrganizationId(getOrganizationId());
/* 543 */     argTillControlTransactionDetail.setRetailLocationId(getRetailLocationId());
/* 544 */     argTillControlTransactionDetail.setWorkstationId(getWorkstationId());
/* 545 */     argTillControlTransactionDetail.setBusinessDate(getBusinessDate());
/* 546 */     argTillControlTransactionDetail.setTransactionSequence(getTransactionSequence());
/* 547 */     if (argTillControlTransactionDetail instanceof IDataModelImpl) {
/* 548 */       IDataAccessObject childDao = ((IDataModelImpl)argTillControlTransactionDetail).getDAO();
/* 549 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 550 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 551 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 556 */     if (postEventsForChanges()) {
/* 557 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTillControlTransactionDetail));
/*     */     }
/*     */     
/* 560 */     this._tillControlTransactionDetails.add(argTillControlTransactionDetail);
/* 561 */     if (postEventsForChanges()) {
/* 562 */       this._events.post(ITillControlTransaction.ADD_TILLCONTROLTRANSACTIONDETAILS, argTillControlTransactionDetail);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTillControlTransactionDetail(ITillControlTransactionDetail argTillControlTransactionDetail) {
/* 567 */     if (this._tillControlTransactionDetails != null) {
/*     */       
/* 569 */       if (postEventsForChanges()) {
/* 570 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTillControlTransactionDetail));
/*     */       }
/* 572 */       this._tillControlTransactionDetails.remove(argTillControlTransactionDetail);
/*     */       
/* 574 */       argTillControlTransactionDetail.setParentTransaction(null);
/* 575 */       if (postEventsForChanges()) {
/* 576 */         this._events.post(ITillControlTransaction.REMOVE_TILLCONTROLTRANSACTIONDETAILS, argTillControlTransactionDetail);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "ReasonCodeObject")
/*     */   public IReasonCode getReasonCodeObject() {
/* 583 */     return this._reasonCodeObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReasonCodeObject(IReasonCode argReasonCodeObject) {
/* 588 */     if (argReasonCodeObject == null) {
/*     */       
/* 590 */       getDAO_().setTypeCode((String)null);
/* 591 */       getDAO_().setReasonCode((String)null);
/* 592 */       if (this._reasonCodeObject != null)
/*     */       {
/* 594 */         if (postEventsForChanges()) {
/* 595 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._reasonCodeObject));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 600 */       getDAO_().setTypeCode(argReasonCodeObject.getReasonTypeCode());
/* 601 */       getDAO_().setReasonCode(argReasonCodeObject.getReasonCode());
/*     */       
/* 603 */       if (postEventsForChanges()) {
/* 604 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReasonCodeObject));
/*     */       }
/*     */     } 
/*     */     
/* 608 */     this._reasonCodeObject = argReasonCodeObject;
/* 609 */     if (postEventsForChanges()) {
/* 610 */       this._events.post(ITillControlTransaction.SET_REASONCODEOBJECT, argReasonCodeObject);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 616 */     if ("TillControlTransactionDetails".equals(argFieldId)) {
/* 617 */       return getTillControlTransactionDetails();
/*     */     }
/* 619 */     if ("ReasonCodeObject".equals(argFieldId)) {
/* 620 */       return getReasonCodeObject();
/*     */     }
/* 622 */     if ("TillControlTransactionExtension".equals(argFieldId)) {
/* 623 */       return this._myExtension;
/*     */     }
/*     */     
/* 626 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 632 */     if ("TillControlTransactionDetails".equals(argFieldId)) {
/* 633 */       setTillControlTransactionDetails(changeToList(argValue, ITillControlTransactionDetail.class));
/*     */     }
/* 635 */     else if ("ReasonCodeObject".equals(argFieldId)) {
/* 636 */       setReasonCodeObject((IReasonCode)argValue);
/*     */     }
/* 638 */     else if ("TillControlTransactionExtension".equals(argFieldId)) {
/* 639 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 642 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 648 */     super.setDependencies(argPD, argEM);
/* 649 */     if (this._tillControlTransactionDetails != null) {
/* 650 */       for (ITillControlTransactionDetail relationship : this._tillControlTransactionDetails) {
/* 651 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 654 */     if (this._reasonCodeObject != null) {
/* 655 */       ((IDataModelImpl)this._reasonCodeObject).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTillControlTransactionExt() {
/* 660 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTillControlTransactionExt(IDataModel argExt) {
/* 664 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 669 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 673 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 676 */     super.startTransaction();
/*     */     
/* 678 */     this._tillControlTransactionDetailsSavepoint = this._tillControlTransactionDetails;
/* 679 */     if (this._tillControlTransactionDetails != null) {
/* 680 */       this._tillControlTransactionDetailsSavepoint = new HistoricalList((List)this._tillControlTransactionDetails);
/* 681 */       Iterator<IDataModel> it = this._tillControlTransactionDetails.iterator();
/* 682 */       while (it.hasNext()) {
/* 683 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 687 */     this._reasonCodeObjectSavepoint = this._reasonCodeObject;
/* 688 */     if (this._reasonCodeObject != null) {
/* 689 */       this._reasonCodeObject.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 693 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 698 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 701 */     super.rollbackChanges();
/*     */     
/* 703 */     this._tillControlTransactionDetails = this._tillControlTransactionDetailsSavepoint;
/* 704 */     this._tillControlTransactionDetailsSavepoint = null;
/* 705 */     if (this._tillControlTransactionDetails != null) {
/* 706 */       Iterator<IDataModel> it = this._tillControlTransactionDetails.iterator();
/* 707 */       while (it.hasNext()) {
/* 708 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 712 */     this._reasonCodeObject = this._reasonCodeObjectSavepoint;
/* 713 */     this._reasonCodeObjectSavepoint = null;
/* 714 */     if (this._reasonCodeObject != null) {
/* 715 */       this._reasonCodeObject.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 722 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 725 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 728 */     super.commitTransaction();
/*     */     
/* 730 */     this._tillControlTransactionDetailsSavepoint = this._tillControlTransactionDetails;
/* 731 */     if (this._tillControlTransactionDetails != null) {
/* 732 */       Iterator<IDataModel> it = this._tillControlTransactionDetails.iterator();
/* 733 */       while (it.hasNext()) {
/* 734 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 736 */       this._tillControlTransactionDetails = new HistoricalList((List)this._tillControlTransactionDetails);
/*     */     } 
/*     */     
/* 739 */     this._reasonCodeObjectSavepoint = this._reasonCodeObject;
/* 740 */     if (this._reasonCodeObject != null) {
/* 741 */       this._reasonCodeObject.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 745 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 750 */     argStream.defaultReadObject();
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
/*     */   public void addTillControlTransactionDetail(ITillControlTransactionDetail argDetail) {
/* 767 */     argDetail.setTransactionLineItemSequence((
/* 768 */         getTillControlTransactionDetails().size() + 1));
/* 769 */     addTillControlTransactionDetailImpl(argDetail);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TillControlTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */