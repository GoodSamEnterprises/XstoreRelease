/*     */ package dtv.xst.dao.sch.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.hrs.IWorkCodes;
/*     */ import dtv.xst.dao.sch.ISchedule;
/*     */ import dtv.xst.dao.sch.IScheduleProperty;
/*     */ import dtv.xst.dao.sch.SchedulePropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ScheduleModel extends AbstractDataModelWithPropertyImpl<IScheduleProperty> implements ISchedule {
/*     */   private static final long serialVersionUID = -633276745L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IWorkCodes _workCode; private transient IWorkCodes _workCodeSavepoint; private HistoricalList<IScheduleProperty> _properties; private transient HistoricalList<IScheduleProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ScheduleDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ScheduleDAO getDAO_() {
/*  47 */     return (ScheduleDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(ISchedule.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._properties != null) {
/*     */         
/*  86 */         Iterator<SchedulePropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((SchedulePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/* 102 */     return getDAO_().getEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 110 */     if (setEmployeeId_noev(argEmployeeId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(ISchedule.SET_EMPLOYEEID, argEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeId_noev(String argEmployeeId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/* 123 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/* 124 */       getDAO_().setEmployeeId(argEmployeeId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<SchedulePropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((SchedulePropertyModel)it.next()).setEmployeeId_noev(argEmployeeId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 144 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 152 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(ISchedule.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 165 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 166 */       getDAO_().setBusinessDate(argBusinessDate);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<SchedulePropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((SchedulePropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getScheduleSeq() {
/* 186 */     if (getDAO_().getScheduleSeq() != null) {
/* 187 */       return getDAO_().getScheduleSeq().longValue();
/*     */     }
/*     */     
/* 190 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScheduleSeq(long argScheduleSeq) {
/* 199 */     if (setScheduleSeq_noev(argScheduleSeq) && 
/* 200 */       this._events != null && 
/* 201 */       postEventsForChanges()) {
/* 202 */       this._events.post(ISchedule.SET_SCHEDULESEQ, Long.valueOf(argScheduleSeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setScheduleSeq_noev(long argScheduleSeq) {
/* 209 */     boolean ev_postable = false;
/*     */     
/* 211 */     if ((getDAO_().getScheduleSeq() == null && Long.valueOf(argScheduleSeq) != null) || (
/* 212 */       getDAO_().getScheduleSeq() != null && !getDAO_().getScheduleSeq().equals(Long.valueOf(argScheduleSeq)))) {
/* 213 */       getDAO_().setScheduleSeq(Long.valueOf(argScheduleSeq));
/* 214 */       ev_postable = true;
/* 215 */       if (this._properties != null) {
/*     */         
/* 217 */         Iterator<SchedulePropertyModel> it = this._properties.iterator();
/* 218 */         while (it.hasNext())
/*     */         {
/* 220 */           ((SchedulePropertyModel)it.next()).setScheduleSeq_noev(argScheduleSeq);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 225 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 233 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 241 */     if (setCreateDate_noev(argCreateDate) && 
/* 242 */       this._events != null && 
/* 243 */       postEventsForChanges()) {
/* 244 */       this._events.post(ISchedule.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 251 */     boolean ev_postable = false;
/*     */     
/* 253 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 254 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 255 */       getDAO_().setCreateDate(argCreateDate);
/* 256 */       ev_postable = true;
/*     */     } 
/*     */     
/* 259 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 267 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 275 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 276 */       this._events != null && 
/* 277 */       postEventsForChanges()) {
/* 278 */       this._events.post(ISchedule.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 285 */     boolean ev_postable = false;
/*     */     
/* 287 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 288 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 289 */       getDAO_().setCreateUserId(argCreateUserId);
/* 290 */       ev_postable = true;
/*     */     } 
/*     */     
/* 293 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 301 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 309 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 310 */       this._events != null && 
/* 311 */       postEventsForChanges()) {
/* 312 */       this._events.post(ISchedule.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 319 */     boolean ev_postable = false;
/*     */     
/* 321 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 322 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 323 */       getDAO_().setUpdateDate(argUpdateDate);
/* 324 */       ev_postable = true;
/*     */     } 
/*     */     
/* 327 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 335 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 343 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 344 */       this._events != null && 
/* 345 */       postEventsForChanges()) {
/* 346 */       this._events.post(ISchedule.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 353 */     boolean ev_postable = false;
/*     */     
/* 355 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 356 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 357 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 358 */       ev_postable = true;
/*     */     } 
/*     */     
/* 361 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/* 369 */     return getDAO_().getStartTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 377 */     if (setStartTime_noev(argStartTime) && 
/* 378 */       this._events != null && 
/* 379 */       postEventsForChanges()) {
/* 380 */       this._events.post(ISchedule.SET_STARTTIME, argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStartTime_noev(Date argStartTime) {
/* 387 */     boolean ev_postable = false;
/*     */     
/* 389 */     if ((getDAO_().getStartTime() == null && argStartTime != null) || (
/* 390 */       getDAO_().getStartTime() != null && !getDAO_().getStartTime().equals(argStartTime))) {
/* 391 */       getDAO_().setStartTime(argStartTime);
/* 392 */       ev_postable = true;
/*     */     } 
/*     */     
/* 395 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 403 */     return getDAO_().getEndTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 411 */     if (setEndTime_noev(argEndTime) && 
/* 412 */       this._events != null && 
/* 413 */       postEventsForChanges()) {
/* 414 */       this._events.post(ISchedule.SET_ENDTIME, argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndTime_noev(Date argEndTime) {
/* 421 */     boolean ev_postable = false;
/*     */     
/* 423 */     if ((getDAO_().getEndTime() == null && argEndTime != null) || (
/* 424 */       getDAO_().getEndTime() != null && !getDAO_().getEndTime().equals(argEndTime))) {
/* 425 */       getDAO_().setEndTime(argEndTime);
/* 426 */       ev_postable = true;
/*     */     } 
/*     */     
/* 429 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 437 */     if (getDAO_().getVoid() != null) {
/* 438 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 441 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 450 */     if (setVoid_noev(argVoid) && 
/* 451 */       this._events != null && 
/* 452 */       postEventsForChanges()) {
/* 453 */       this._events.post(ISchedule.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 460 */     boolean ev_postable = false;
/*     */     
/* 462 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 463 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 464 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 465 */       ev_postable = true;
/*     */     } 
/*     */     
/* 468 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkCodeString() {
/* 476 */     return getDAO_().getWorkCodeString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkCodeString(String argWorkCodeString) {
/* 484 */     if (setWorkCodeString_noev(argWorkCodeString) && 
/* 485 */       this._events != null && 
/* 486 */       postEventsForChanges()) {
/* 487 */       this._events.post(ISchedule.SET_WORKCODESTRING, argWorkCodeString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkCodeString_noev(String argWorkCodeString) {
/* 494 */     boolean ev_postable = false;
/*     */     
/* 496 */     if ((getDAO_().getWorkCodeString() == null && argWorkCodeString != null) || (
/* 497 */       getDAO_().getWorkCodeString() != null && !getDAO_().getWorkCodeString().equals(argWorkCodeString))) {
/* 498 */       getDAO_().setWorkCodeString(argWorkCodeString);
/* 499 */       ev_postable = true;
/*     */     } 
/*     */     
/* 502 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getScheduleDuration() {
/* 510 */     if (getDAO_().getScheduleDuration() != null) {
/* 511 */       return getDAO_().getScheduleDuration().longValue();
/*     */     }
/*     */     
/* 514 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScheduleDuration(long argScheduleDuration) {
/* 523 */     if (setScheduleDuration_noev(argScheduleDuration) && 
/* 524 */       this._events != null && 
/* 525 */       postEventsForChanges()) {
/* 526 */       this._events.post(ISchedule.SET_SCHEDULEDURATION, Long.valueOf(argScheduleDuration));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setScheduleDuration_noev(long argScheduleDuration) {
/* 533 */     boolean ev_postable = false;
/*     */     
/* 535 */     if ((getDAO_().getScheduleDuration() == null && Long.valueOf(argScheduleDuration) != null) || (
/* 536 */       getDAO_().getScheduleDuration() != null && !getDAO_().getScheduleDuration().equals(Long.valueOf(argScheduleDuration)))) {
/* 537 */       getDAO_().setScheduleDuration(Long.valueOf(argScheduleDuration));
/* 538 */       ev_postable = true;
/*     */     } 
/*     */     
/* 541 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getBreakDuration() {
/* 549 */     if (getDAO_().getBreakDuration() != null) {
/* 550 */       return getDAO_().getBreakDuration().longValue();
/*     */     }
/*     */     
/* 553 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBreakDuration(long argBreakDuration) {
/* 562 */     if (setBreakDuration_noev(argBreakDuration) && 
/* 563 */       this._events != null && 
/* 564 */       postEventsForChanges()) {
/* 565 */       this._events.post(ISchedule.SET_BREAKDURATION, Long.valueOf(argBreakDuration));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBreakDuration_noev(long argBreakDuration) {
/* 572 */     boolean ev_postable = false;
/*     */     
/* 574 */     if ((getDAO_().getBreakDuration() == null && Long.valueOf(argBreakDuration) != null) || (
/* 575 */       getDAO_().getBreakDuration() != null && !getDAO_().getBreakDuration().equals(Long.valueOf(argBreakDuration)))) {
/* 576 */       getDAO_().setBreakDuration(Long.valueOf(argBreakDuration));
/* 577 */       ev_postable = true;
/*     */     } 
/*     */     
/* 580 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IScheduleProperty newProperty(String argPropertyName) {
/* 584 */     SchedulePropertyId id = new SchedulePropertyId();
/*     */     
/* 586 */     id.setEmployeeId(getEmployeeId());
/* 587 */     id.setBusinessDate(getBusinessDate());
/* 588 */     id.setScheduleSeq(Long.valueOf(getScheduleSeq()));
/* 589 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 591 */     IScheduleProperty prop = (IScheduleProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IScheduleProperty.class);
/* 592 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "WorkCode")
/*     */   public IWorkCodes getWorkCode() {
/* 604 */     return this._workCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorkCode(IWorkCodes argWorkCode) {
/* 609 */     if (argWorkCode == null) {
/*     */       
/* 611 */       getDAO_().setWorkCodeString(null);
/* 612 */       if (this._workCode != null)
/*     */       {
/* 614 */         if (postEventsForChanges()) {
/* 615 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workCode));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 620 */       getDAO_().setWorkCodeString(argWorkCode.getWorkCode());
/*     */       
/* 622 */       if (postEventsForChanges()) {
/* 623 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkCode));
/*     */       }
/*     */     } 
/*     */     
/* 627 */     this._workCode = argWorkCode;
/* 628 */     if (postEventsForChanges()) {
/* 629 */       this._events.post(ISchedule.SET_WORKCODE, argWorkCode);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IScheduleProperty> getProperties() {
/* 635 */     if (this._properties == null) {
/* 636 */       this._properties = new HistoricalList(null);
/*     */     }
/* 638 */     return (List<IScheduleProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IScheduleProperty> argProperties) {
/* 642 */     if (this._properties == null) {
/* 643 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 645 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 648 */     for (IScheduleProperty child : this._properties) {
/* 649 */       SchedulePropertyModel model = (SchedulePropertyModel)child;
/* 650 */       model.setOrganizationId_noev(getOrganizationId());
/* 651 */       model.setEmployeeId_noev(getEmployeeId());
/* 652 */       model.setBusinessDate_noev(getBusinessDate());
/* 653 */       model.setScheduleSeq_noev(getScheduleSeq());
/* 654 */       if (child instanceof IDataModelImpl) {
/* 655 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 656 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 657 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 658 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 661 */       if (postEventsForChanges()) {
/* 662 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addScheduleProperty(IScheduleProperty argScheduleProperty) {
/* 668 */     if (this._properties == null) {
/* 669 */       this._properties = new HistoricalList(null);
/*     */     }
/* 671 */     argScheduleProperty.setOrganizationId(getOrganizationId());
/* 672 */     argScheduleProperty.setEmployeeId(getEmployeeId());
/* 673 */     argScheduleProperty.setBusinessDate(getBusinessDate());
/* 674 */     argScheduleProperty.setScheduleSeq(getScheduleSeq());
/* 675 */     if (argScheduleProperty instanceof IDataModelImpl) {
/* 676 */       IDataAccessObject childDao = ((IDataModelImpl)argScheduleProperty).getDAO();
/* 677 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 678 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 679 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 684 */     if (postEventsForChanges()) {
/* 685 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argScheduleProperty));
/*     */     }
/*     */     
/* 688 */     this._properties.add(argScheduleProperty);
/* 689 */     if (postEventsForChanges()) {
/* 690 */       this._events.post(ISchedule.ADD_PROPERTIES, argScheduleProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeScheduleProperty(IScheduleProperty argScheduleProperty) {
/* 695 */     if (this._properties != null) {
/*     */       
/* 697 */       if (postEventsForChanges()) {
/* 698 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argScheduleProperty));
/*     */       }
/* 700 */       this._properties.remove(argScheduleProperty);
/* 701 */       if (postEventsForChanges()) {
/* 702 */         this._events.post(ISchedule.REMOVE_PROPERTIES, argScheduleProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 709 */     if ("WorkCode".equals(argFieldId)) {
/* 710 */       return getWorkCode();
/*     */     }
/* 712 */     if ("Properties".equals(argFieldId)) {
/* 713 */       return getProperties();
/*     */     }
/* 715 */     if ("ScheduleExtension".equals(argFieldId)) {
/* 716 */       return this._myExtension;
/*     */     }
/*     */     
/* 719 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 725 */     if ("WorkCode".equals(argFieldId)) {
/* 726 */       setWorkCode((IWorkCodes)argValue);
/*     */     }
/* 728 */     else if ("Properties".equals(argFieldId)) {
/* 729 */       setProperties(changeToList(argValue, IScheduleProperty.class));
/*     */     }
/* 731 */     else if ("ScheduleExtension".equals(argFieldId)) {
/* 732 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 735 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 741 */     this._persistenceDefaults = argPD;
/* 742 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 743 */     this._eventManager = argEM;
/* 744 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 745 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 746 */     if (this._workCode != null) {
/* 747 */       ((IDataModelImpl)this._workCode).setDependencies(argPD, argEM);
/*     */     }
/* 749 */     if (this._properties != null) {
/* 750 */       for (IScheduleProperty relationship : this._properties) {
/* 751 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getScheduleExt() {
/* 757 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setScheduleExt(IDataModel argExt) {
/* 761 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 766 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 770 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 773 */     super.startTransaction();
/*     */     
/* 775 */     this._workCodeSavepoint = this._workCode;
/* 776 */     if (this._workCode != null) {
/* 777 */       this._workCode.startTransaction();
/*     */     }
/*     */     
/* 780 */     this._propertiesSavepoint = this._properties;
/* 781 */     if (this._properties != null) {
/* 782 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 783 */       Iterator<IDataModel> it = this._properties.iterator();
/* 784 */       while (it.hasNext()) {
/* 785 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 790 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 795 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 798 */     super.rollbackChanges();
/*     */     
/* 800 */     this._workCode = this._workCodeSavepoint;
/* 801 */     this._workCodeSavepoint = null;
/* 802 */     if (this._workCode != null) {
/* 803 */       this._workCode.rollbackChanges();
/*     */     }
/*     */     
/* 806 */     this._properties = this._propertiesSavepoint;
/* 807 */     this._propertiesSavepoint = null;
/* 808 */     if (this._properties != null) {
/* 809 */       Iterator<IDataModel> it = this._properties.iterator();
/* 810 */       while (it.hasNext()) {
/* 811 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 819 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 822 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 825 */     super.commitTransaction();
/*     */     
/* 827 */     this._workCodeSavepoint = this._workCode;
/* 828 */     if (this._workCode != null) {
/* 829 */       this._workCode.commitTransaction();
/*     */     }
/*     */     
/* 832 */     this._propertiesSavepoint = this._properties;
/* 833 */     if (this._properties != null) {
/* 834 */       Iterator<IDataModel> it = this._properties.iterator();
/* 835 */       while (it.hasNext()) {
/* 836 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 838 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 842 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 847 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\ScheduleModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */