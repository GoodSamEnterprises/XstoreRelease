/*     */ package dtv.xst.dao.cwo.impl;
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
/*     */ import dtv.xst.dao.cat.ICustomerAccountJournal;
/*     */ import dtv.xst.dao.cat.impl.CustomerItemAccountJournalModel;
/*     */ import dtv.xst.dao.cwo.IServiceLocation;
/*     */ import dtv.xst.dao.cwo.IWorkOrderAccountJournal;
/*     */ import dtv.xst.dao.cwo.IWorkOrderCategory;
/*     */ import dtv.xst.dao.cwo.IWorkOrderPriceCode;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class WorkOrderAccountJournalModel
/*     */   extends CustomerItemAccountJournalModel
/*     */   implements IWorkOrderAccountJournal {
/*     */   private static final long serialVersionUID = 389449799L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IWorkOrderPriceCode _workOrderAccountJournalPriceCode;
/*     */   
/*     */   public void initDAO() {
/*  33 */     setDAO((IDataAccessObject)new WorkOrderAccountJournalDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   private transient IWorkOrderPriceCode _workOrderAccountJournalPriceCodeSavepoint;
/*     */   private IWorkOrderCategory _workOrderAccountJournalCategory;
/*     */   
/*     */   private WorkOrderAccountJournalDAO getDAO_() {
/*  41 */     return (WorkOrderAccountJournalDAO)this._daoImpl;
/*     */   }
/*     */   
/*     */   private transient IWorkOrderCategory _workOrderAccountJournalCategorySavepoint;
/*     */   private IServiceLocation _workOrderAccountJournalServiceLocation;
/*     */   private transient IServiceLocation _workOrderAccountJournalServiceLocationSavepoint;
/*     */   
/*     */   public Date getCreateDate() {
/*  49 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  57 */     if (setCreateDate_noev(argCreateDate) && 
/*  58 */       this._events != null && 
/*  59 */       postEventsForChanges()) {
/*  60 */       this._events.post(IWorkOrderAccountJournal.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  67 */     boolean ev_postable = false;
/*     */     
/*  69 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  70 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  71 */       getDAO_().setCreateDate(argCreateDate);
/*  72 */       ev_postable = true;
/*     */     } 
/*     */     
/*  75 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  83 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  91 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  92 */       this._events != null && 
/*  93 */       postEventsForChanges()) {
/*  94 */       this._events.post(IWorkOrderAccountJournal.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 101 */     boolean ev_postable = false;
/*     */     
/* 103 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 104 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 105 */       getDAO_().setCreateUserId(argCreateUserId);
/* 106 */       ev_postable = true;
/*     */     } 
/*     */     
/* 109 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 117 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 125 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 126 */       this._events != null && 
/* 127 */       postEventsForChanges()) {
/* 128 */       this._events.post(IWorkOrderAccountJournal.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 135 */     boolean ev_postable = false;
/*     */     
/* 137 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 138 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 139 */       getDAO_().setUpdateDate(argUpdateDate);
/* 140 */       ev_postable = true;
/*     */     } 
/*     */     
/* 143 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 151 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 159 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 160 */       this._events != null && 
/* 161 */       postEventsForChanges()) {
/* 162 */       this._events.post(IWorkOrderAccountJournal.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 169 */     boolean ev_postable = false;
/*     */     
/* 171 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 172 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 173 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 174 */       ev_postable = true;
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTotalValue() {
/* 185 */     return getDAO_().getTotalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalValue(BigDecimal argTotalValue) {
/* 193 */     if (setTotalValue_noev(argTotalValue) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IWorkOrderAccountJournal.SET_TOTALVALUE, argTotalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTotalValue_noev(BigDecimal argTotalValue) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getTotalValue() == null && argTotalValue != null) || (
/* 206 */       getDAO_().getTotalValue() != null && !getDAO_().getTotalValue().equals(argTotalValue))) {
/* 207 */       getDAO_().setTotalValue(argTotalValue);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEstimatedCompletionDate() {
/* 219 */     return getDAO_().getEstimatedCompletionDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEstimatedCompletionDate(Date argEstimatedCompletionDate) {
/* 227 */     if (setEstimatedCompletionDate_noev(argEstimatedCompletionDate) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IWorkOrderAccountJournal.SET_ESTIMATEDCOMPLETIONDATE, argEstimatedCompletionDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEstimatedCompletionDate_noev(Date argEstimatedCompletionDate) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getEstimatedCompletionDate() == null && argEstimatedCompletionDate != null) || (
/* 240 */       getDAO_().getEstimatedCompletionDate() != null && !getDAO_().getEstimatedCompletionDate().equals(argEstimatedCompletionDate))) {
/* 241 */       getDAO_().setEstimatedCompletionDate(argEstimatedCompletionDate);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getApprovedWorkAmount() {
/* 253 */     return getDAO_().getApprovedWorkAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApprovedWorkAmount(BigDecimal argApprovedWorkAmount) {
/* 261 */     if (setApprovedWorkAmount_noev(argApprovedWorkAmount) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IWorkOrderAccountJournal.SET_APPROVEDWORKAMOUNT, argApprovedWorkAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setApprovedWorkAmount_noev(BigDecimal argApprovedWorkAmount) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getApprovedWorkAmount() == null && argApprovedWorkAmount != null) || (
/* 274 */       getDAO_().getApprovedWorkAmount() != null && !getDAO_().getApprovedWorkAmount().equals(argApprovedWorkAmount))) {
/* 275 */       getDAO_().setApprovedWorkAmount(argApprovedWorkAmount);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getApprovedWorkDate() {
/* 287 */     return getDAO_().getApprovedWorkDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApprovedWorkDate(Date argApprovedWorkDate) {
/* 295 */     if (setApprovedWorkDate_noev(argApprovedWorkDate) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IWorkOrderAccountJournal.SET_APPROVEDWORKDATE, argApprovedWorkDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setApprovedWorkDate_noev(Date argApprovedWorkDate) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getApprovedWorkDate() == null && argApprovedWorkDate != null) || (
/* 308 */       getDAO_().getApprovedWorkDate() != null && !getDAO_().getApprovedWorkDate().equals(argApprovedWorkDate))) {
/* 309 */       getDAO_().setApprovedWorkDate(argApprovedWorkDate);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPriorityCode() {
/* 321 */     return getDAO_().getPriorityCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriorityCode(String argPriorityCode) {
/* 329 */     if (setPriorityCode_noev(argPriorityCode) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IWorkOrderAccountJournal.SET_PRIORITYCODE, argPriorityCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriorityCode_noev(String argPriorityCode) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getPriorityCode() == null && argPriorityCode != null) || (
/* 342 */       getDAO_().getPriorityCode() != null && !getDAO_().getPriorityCode().equals(argPriorityCode))) {
/* 343 */       getDAO_().setPriorityCode(argPriorityCode);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContactMethod() {
/* 355 */     return getDAO_().getContactMethod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContactMethod(String argContactMethod) {
/* 363 */     if (setContactMethod_noev(argContactMethod) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IWorkOrderAccountJournal.SET_CONTACTMETHOD, argContactMethod);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setContactMethod_noev(String argContactMethod) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getContactMethod() == null && argContactMethod != null) || (
/* 376 */       getDAO_().getContactMethod() != null && !getDAO_().getContactMethod().equals(argContactMethod))) {
/* 377 */       getDAO_().setContactMethod(argContactMethod);
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
/*     */   public Date getLastCustomerNoticeDate() {
/* 389 */     return getDAO_().getLastCustomerNoticeDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastCustomerNoticeDate(Date argLastCustomerNoticeDate) {
/* 397 */     if (setLastCustomerNoticeDate_noev(argLastCustomerNoticeDate) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(IWorkOrderAccountJournal.SET_LASTCUSTOMERNOTICEDATE, argLastCustomerNoticeDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLastCustomerNoticeDate_noev(Date argLastCustomerNoticeDate) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getLastCustomerNoticeDate() == null && argLastCustomerNoticeDate != null) || (
/* 410 */       getDAO_().getLastCustomerNoticeDate() != null && !getDAO_().getLastCustomerNoticeDate().equals(argLastCustomerNoticeDate))) {
/* 411 */       getDAO_().setLastCustomerNoticeDate(argLastCustomerNoticeDate);
/* 412 */       ev_postable = true;
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCategoryId() {
/* 423 */     return getDAO_().getCategoryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategoryId(String argCategoryId) {
/* 431 */     if (setCategoryId_noev(argCategoryId) && 
/* 432 */       this._events != null && 
/* 433 */       postEventsForChanges()) {
/* 434 */       this._events.post(IWorkOrderAccountJournal.SET_CATEGORYID, argCategoryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCategoryId_noev(String argCategoryId) {
/* 441 */     boolean ev_postable = false;
/*     */     
/* 443 */     if ((getDAO_().getCategoryId() == null && argCategoryId != null) || (
/* 444 */       getDAO_().getCategoryId() != null && !getDAO_().getCategoryId().equals(argCategoryId))) {
/* 445 */       getDAO_().setCategoryId(argCategoryId);
/* 446 */       ev_postable = true;
/*     */     } 
/*     */     
/* 449 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServiceLocationId() {
/* 457 */     return getDAO_().getServiceLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/* 465 */     if (setServiceLocationId_noev(argServiceLocationId) && 
/* 466 */       this._events != null && 
/* 467 */       postEventsForChanges()) {
/* 468 */       this._events.post(IWorkOrderAccountJournal.SET_SERVICELOCATIONID, argServiceLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setServiceLocationId_noev(String argServiceLocationId) {
/* 475 */     boolean ev_postable = false;
/*     */     
/* 477 */     if ((getDAO_().getServiceLocationId() == null && argServiceLocationId != null) || (
/* 478 */       getDAO_().getServiceLocationId() != null && !getDAO_().getServiceLocationId().equals(argServiceLocationId))) {
/* 479 */       getDAO_().setServiceLocationId(argServiceLocationId);
/* 480 */       ev_postable = true;
/*     */     } 
/*     */     
/* 483 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPriceCodeString() {
/* 491 */     return getDAO_().getPriceCodeString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriceCodeString(String argPriceCodeString) {
/* 499 */     if (setPriceCodeString_noev(argPriceCodeString) && 
/* 500 */       this._events != null && 
/* 501 */       postEventsForChanges()) {
/* 502 */       this._events.post(IWorkOrderAccountJournal.SET_PRICECODESTRING, argPriceCodeString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriceCodeString_noev(String argPriceCodeString) {
/* 509 */     boolean ev_postable = false;
/*     */     
/* 511 */     if ((getDAO_().getPriceCodeString() == null && argPriceCodeString != null) || (
/* 512 */       getDAO_().getPriceCodeString() != null && !getDAO_().getPriceCodeString().equals(argPriceCodeString))) {
/* 513 */       getDAO_().setPriceCodeString(argPriceCodeString);
/* 514 */       ev_postable = true;
/*     */     } 
/*     */     
/* 517 */     return ev_postable;
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
/*     */   @Relationship(name = "WorkOrderAccountJournalPriceCode")
/*     */   public IWorkOrderPriceCode getWorkOrderAccountJournalPriceCode() {
/* 532 */     return this._workOrderAccountJournalPriceCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorkOrderAccountJournalPriceCode(IWorkOrderPriceCode argWorkOrderAccountJournalPriceCode) {
/* 537 */     if (argWorkOrderAccountJournalPriceCode == null) {
/*     */       
/* 539 */       getDAO_().setPriceCodeString(null);
/* 540 */       if (this._workOrderAccountJournalPriceCode != null)
/*     */       {
/* 542 */         if (postEventsForChanges()) {
/* 543 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workOrderAccountJournalPriceCode));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 548 */       getDAO_().setPriceCodeString(argWorkOrderAccountJournalPriceCode.getPriceCode());
/*     */       
/* 550 */       if (postEventsForChanges()) {
/* 551 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderAccountJournalPriceCode));
/*     */       }
/*     */     } 
/*     */     
/* 555 */     this._workOrderAccountJournalPriceCode = argWorkOrderAccountJournalPriceCode;
/* 556 */     if (postEventsForChanges()) {
/* 557 */       this._events.post(IWorkOrderAccountJournal.SET_WORKORDERACCOUNTJOURNALPRICECODE, argWorkOrderAccountJournalPriceCode);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "WorkOrderAccountJournalCategory")
/*     */   public IWorkOrderCategory getWorkOrderAccountJournalCategory() {
/* 563 */     return this._workOrderAccountJournalCategory;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorkOrderAccountJournalCategory(IWorkOrderCategory argWorkOrderAccountJournalCategory) {
/* 568 */     if (argWorkOrderAccountJournalCategory == null) {
/*     */       
/* 570 */       getDAO_().setCategoryId(null);
/* 571 */       if (this._workOrderAccountJournalCategory != null)
/*     */       {
/* 573 */         if (postEventsForChanges()) {
/* 574 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workOrderAccountJournalCategory));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 579 */       getDAO_().setCategoryId(argWorkOrderAccountJournalCategory.getCategoryId());
/*     */       
/* 581 */       if (postEventsForChanges()) {
/* 582 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderAccountJournalCategory));
/*     */       }
/*     */     } 
/*     */     
/* 586 */     this._workOrderAccountJournalCategory = argWorkOrderAccountJournalCategory;
/* 587 */     if (postEventsForChanges()) {
/* 588 */       this._events.post(IWorkOrderAccountJournal.SET_WORKORDERACCOUNTJOURNALCATEGORY, argWorkOrderAccountJournalCategory);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "WorkOrderAccountJournalServiceLocation")
/*     */   public IServiceLocation getWorkOrderAccountJournalServiceLocation() {
/* 594 */     return this._workOrderAccountJournalServiceLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorkOrderAccountJournalServiceLocation(IServiceLocation argWorkOrderAccountJournalServiceLocation) {
/* 599 */     if (argWorkOrderAccountJournalServiceLocation == null) {
/*     */       
/* 601 */       getDAO_().setServiceLocationId(null);
/* 602 */       if (this._workOrderAccountJournalServiceLocation != null)
/*     */       {
/* 604 */         if (postEventsForChanges()) {
/* 605 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workOrderAccountJournalServiceLocation));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 610 */       getDAO_().setServiceLocationId(argWorkOrderAccountJournalServiceLocation.getServiceLocationId());
/*     */       
/* 612 */       if (postEventsForChanges()) {
/* 613 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderAccountJournalServiceLocation));
/*     */       }
/*     */     } 
/*     */     
/* 617 */     this._workOrderAccountJournalServiceLocation = argWorkOrderAccountJournalServiceLocation;
/* 618 */     if (postEventsForChanges()) {
/* 619 */       this._events.post(IWorkOrderAccountJournal.SET_WORKORDERACCOUNTJOURNALSERVICELOCATION, argWorkOrderAccountJournalServiceLocation);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 625 */     if ("WorkOrderAccountJournalPriceCode".equals(argFieldId)) {
/* 626 */       return getWorkOrderAccountJournalPriceCode();
/*     */     }
/* 628 */     if ("WorkOrderAccountJournalCategory".equals(argFieldId)) {
/* 629 */       return getWorkOrderAccountJournalCategory();
/*     */     }
/* 631 */     if ("WorkOrderAccountJournalServiceLocation".equals(argFieldId)) {
/* 632 */       return getWorkOrderAccountJournalServiceLocation();
/*     */     }
/* 634 */     if ("WorkOrderAccountJournalExtension".equals(argFieldId)) {
/* 635 */       return this._myExtension;
/*     */     }
/*     */     
/* 638 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 644 */     if ("WorkOrderAccountJournalPriceCode".equals(argFieldId)) {
/* 645 */       setWorkOrderAccountJournalPriceCode((IWorkOrderPriceCode)argValue);
/*     */     }
/* 647 */     else if ("WorkOrderAccountJournalCategory".equals(argFieldId)) {
/* 648 */       setWorkOrderAccountJournalCategory((IWorkOrderCategory)argValue);
/*     */     }
/* 650 */     else if ("WorkOrderAccountJournalServiceLocation".equals(argFieldId)) {
/* 651 */       setWorkOrderAccountJournalServiceLocation((IServiceLocation)argValue);
/*     */     }
/* 653 */     else if ("WorkOrderAccountJournalExtension".equals(argFieldId)) {
/* 654 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 657 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 663 */     super.setDependencies(argPD, argEM);
/* 664 */     if (this._workOrderAccountJournalPriceCode != null) {
/* 665 */       ((IDataModelImpl)this._workOrderAccountJournalPriceCode).setDependencies(argPD, argEM);
/*     */     }
/* 667 */     if (this._workOrderAccountJournalCategory != null) {
/* 668 */       ((IDataModelImpl)this._workOrderAccountJournalCategory).setDependencies(argPD, argEM);
/*     */     }
/* 670 */     if (this._workOrderAccountJournalServiceLocation != null) {
/* 671 */       ((IDataModelImpl)this._workOrderAccountJournalServiceLocation).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWorkOrderAccountJournalExt() {
/* 676 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWorkOrderAccountJournalExt(IDataModel argExt) {
/* 680 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 685 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 689 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 692 */     super.startTransaction();
/*     */     
/* 694 */     this._workOrderAccountJournalPriceCodeSavepoint = this._workOrderAccountJournalPriceCode;
/* 695 */     if (this._workOrderAccountJournalPriceCode != null) {
/* 696 */       this._workOrderAccountJournalPriceCode.startTransaction();
/*     */     }
/*     */     
/* 699 */     this._workOrderAccountJournalCategorySavepoint = this._workOrderAccountJournalCategory;
/* 700 */     if (this._workOrderAccountJournalCategory != null) {
/* 701 */       this._workOrderAccountJournalCategory.startTransaction();
/*     */     }
/*     */     
/* 704 */     this._workOrderAccountJournalServiceLocationSavepoint = this._workOrderAccountJournalServiceLocation;
/* 705 */     if (this._workOrderAccountJournalServiceLocation != null) {
/* 706 */       this._workOrderAccountJournalServiceLocation.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 710 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 715 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 718 */     super.rollbackChanges();
/*     */     
/* 720 */     this._workOrderAccountJournalPriceCode = this._workOrderAccountJournalPriceCodeSavepoint;
/* 721 */     this._workOrderAccountJournalPriceCodeSavepoint = null;
/* 722 */     if (this._workOrderAccountJournalPriceCode != null) {
/* 723 */       this._workOrderAccountJournalPriceCode.rollbackChanges();
/*     */     }
/*     */     
/* 726 */     this._workOrderAccountJournalCategory = this._workOrderAccountJournalCategorySavepoint;
/* 727 */     this._workOrderAccountJournalCategorySavepoint = null;
/* 728 */     if (this._workOrderAccountJournalCategory != null) {
/* 729 */       this._workOrderAccountJournalCategory.rollbackChanges();
/*     */     }
/*     */     
/* 732 */     this._workOrderAccountJournalServiceLocation = this._workOrderAccountJournalServiceLocationSavepoint;
/* 733 */     this._workOrderAccountJournalServiceLocationSavepoint = null;
/* 734 */     if (this._workOrderAccountJournalServiceLocation != null) {
/* 735 */       this._workOrderAccountJournalServiceLocation.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 742 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 745 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 748 */     super.commitTransaction();
/*     */     
/* 750 */     this._workOrderAccountJournalPriceCodeSavepoint = this._workOrderAccountJournalPriceCode;
/* 751 */     if (this._workOrderAccountJournalPriceCode != null) {
/* 752 */       this._workOrderAccountJournalPriceCode.commitTransaction();
/*     */     }
/*     */     
/* 755 */     this._workOrderAccountJournalCategorySavepoint = this._workOrderAccountJournalCategory;
/* 756 */     if (this._workOrderAccountJournalCategory != null) {
/* 757 */       this._workOrderAccountJournalCategory.commitTransaction();
/*     */     }
/*     */     
/* 760 */     this._workOrderAccountJournalServiceLocationSavepoint = this._workOrderAccountJournalServiceLocation;
/* 761 */     if (this._workOrderAccountJournalServiceLocation != null) {
/* 762 */       this._workOrderAccountJournalServiceLocation.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 766 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 771 */     argStream.defaultReadObject();
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
/*     */   public void copyTo(ICustomerAccountJournal argJournal) {
/* 784 */     super.copyTo(argJournal);
/*     */     
/* 786 */     if (argJournal instanceof IWorkOrderAccountJournal) {
/* 787 */       IWorkOrderAccountJournal journal = (IWorkOrderAccountJournal)argJournal;
/*     */ 
/*     */       
/* 790 */       journal.setApprovedWorkAmount(getApprovedWorkAmount());
/* 791 */       journal.setApprovedWorkDate(getApprovedWorkDate());
/* 792 */       journal.setContactMethod(getContactMethod());
/* 793 */       journal.setEstimatedCompletionDate(getEstimatedCompletionDate());
/* 794 */       journal.setLastCustomerNoticeDate(getLastCustomerNoticeDate());
/* 795 */       journal.setPriceCodeString(getPriceCodeString());
/* 796 */       journal.setPriorityCode(getPriorityCode());
/* 797 */       journal.setTotalValue(getTotalValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderAccountJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */