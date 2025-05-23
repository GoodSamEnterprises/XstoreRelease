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
/*     */ import dtv.xst.dao.sch.EmployeeTimeOffPropertyId;
/*     */ import dtv.xst.dao.sch.IEmployeeTimeOff;
/*     */ import dtv.xst.dao.sch.IEmployeeTimeOffProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EmployeeTimeOffModel extends AbstractDataModelWithPropertyImpl<IEmployeeTimeOffProperty> implements IEmployeeTimeOff {
/*     */   private static final long serialVersionUID = -1854604108L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IEmployeeTimeOffProperty> _properties; private transient HistoricalList<IEmployeeTimeOffProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new EmployeeTimeOffDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EmployeeTimeOffDAO getDAO_() {
/*  46 */     return (EmployeeTimeOffDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IEmployeeTimeOff.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<EmployeeTimeOffPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((EmployeeTimeOffPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/* 101 */     return getDAO_().getEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 109 */     if (setEmployeeId_noev(argEmployeeId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IEmployeeTimeOff.SET_EMPLOYEEID, argEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeId_noev(String argEmployeeId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/* 122 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/* 123 */       getDAO_().setEmployeeId(argEmployeeId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<EmployeeTimeOffPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((EmployeeTimeOffPropertyModel)it.next()).setEmployeeId_noev(argEmployeeId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimeOffSeq() {
/* 143 */     if (getDAO_().getTimeOffSeq() != null) {
/* 144 */       return getDAO_().getTimeOffSeq().longValue();
/*     */     }
/*     */     
/* 147 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeOffSeq(long argTimeOffSeq) {
/* 156 */     if (setTimeOffSeq_noev(argTimeOffSeq) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IEmployeeTimeOff.SET_TIMEOFFSEQ, Long.valueOf(argTimeOffSeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimeOffSeq_noev(long argTimeOffSeq) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getTimeOffSeq() == null && Long.valueOf(argTimeOffSeq) != null) || (
/* 169 */       getDAO_().getTimeOffSeq() != null && !getDAO_().getTimeOffSeq().equals(Long.valueOf(argTimeOffSeq)))) {
/* 170 */       getDAO_().setTimeOffSeq(Long.valueOf(argTimeOffSeq));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<EmployeeTimeOffPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((EmployeeTimeOffPropertyModel)it.next()).setTimeOffSeq_noev(argTimeOffSeq);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 190 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 198 */     if (setCreateDate_noev(argCreateDate) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IEmployeeTimeOff.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 211 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 212 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 224 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 232 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(IEmployeeTimeOff.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 245 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 246 */       getDAO_().setCreateUserId(argCreateUserId);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 258 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 266 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(IEmployeeTimeOff.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 279 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 280 */       getDAO_().setUpdateDate(argUpdateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 292 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 300 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(IEmployeeTimeOff.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 313 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 314 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/* 326 */     return getDAO_().getStartTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 334 */     if (setStartTime_noev(argStartTime) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IEmployeeTimeOff.SET_STARTTIME, argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStartTime_noev(Date argStartTime) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getStartTime() == null && argStartTime != null) || (
/* 347 */       getDAO_().getStartTime() != null && !getDAO_().getStartTime().equals(argStartTime))) {
/* 348 */       getDAO_().setStartTime(argStartTime);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 360 */     return getDAO_().getEndTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 368 */     if (setEndTime_noev(argEndTime) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IEmployeeTimeOff.SET_ENDTIME, argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndTime_noev(Date argEndTime) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getEndTime() == null && argEndTime != null) || (
/* 381 */       getDAO_().getEndTime() != null && !getDAO_().getEndTime().equals(argEndTime))) {
/* 382 */       getDAO_().setEndTime(argEndTime);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReasonCode() {
/* 394 */     return getDAO_().getReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 402 */     if (setReasonCode_noev(argReasonCode) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IEmployeeTimeOff.SET_REASONCODE, argReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReasonCode_noev(String argReasonCode) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/* 415 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/* 416 */       getDAO_().setReasonCode(argReasonCode);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 428 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 436 */     if (setTypeCode_noev(argTypeCode) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IEmployeeTimeOff.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 449 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 450 */       getDAO_().setTypeCode(argTypeCode);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 462 */     if (getDAO_().getVoid() != null) {
/* 463 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 466 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 475 */     if (setVoid_noev(argVoid) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IEmployeeTimeOff.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 488 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 489 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEmployeeTimeOffProperty newProperty(String argPropertyName) {
/* 497 */     EmployeeTimeOffPropertyId id = new EmployeeTimeOffPropertyId();
/*     */     
/* 499 */     id.setEmployeeId(getEmployeeId());
/* 500 */     id.setTimeOffSeq(Long.valueOf(getTimeOffSeq()));
/* 501 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 503 */     IEmployeeTimeOffProperty prop = (IEmployeeTimeOffProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeTimeOffProperty.class);
/* 504 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEmployeeTimeOffProperty> getProperties() {
/* 513 */     if (this._properties == null) {
/* 514 */       this._properties = new HistoricalList(null);
/*     */     }
/* 516 */     return (List<IEmployeeTimeOffProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEmployeeTimeOffProperty> argProperties) {
/* 520 */     if (this._properties == null) {
/* 521 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 523 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 526 */     for (IEmployeeTimeOffProperty child : this._properties) {
/* 527 */       EmployeeTimeOffPropertyModel model = (EmployeeTimeOffPropertyModel)child;
/* 528 */       model.setOrganizationId_noev(getOrganizationId());
/* 529 */       model.setEmployeeId_noev(getEmployeeId());
/* 530 */       model.setTimeOffSeq_noev(getTimeOffSeq());
/* 531 */       if (child instanceof IDataModelImpl) {
/* 532 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 533 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 534 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 535 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 538 */       if (postEventsForChanges()) {
/* 539 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEmployeeTimeOffProperty(IEmployeeTimeOffProperty argEmployeeTimeOffProperty) {
/* 545 */     if (this._properties == null) {
/* 546 */       this._properties = new HistoricalList(null);
/*     */     }
/* 548 */     argEmployeeTimeOffProperty.setOrganizationId(getOrganizationId());
/* 549 */     argEmployeeTimeOffProperty.setEmployeeId(getEmployeeId());
/* 550 */     argEmployeeTimeOffProperty.setTimeOffSeq(getTimeOffSeq());
/* 551 */     if (argEmployeeTimeOffProperty instanceof IDataModelImpl) {
/* 552 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeTimeOffProperty).getDAO();
/* 553 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 554 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 555 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 560 */     if (postEventsForChanges()) {
/* 561 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTimeOffProperty));
/*     */     }
/*     */     
/* 564 */     this._properties.add(argEmployeeTimeOffProperty);
/* 565 */     if (postEventsForChanges()) {
/* 566 */       this._events.post(IEmployeeTimeOff.ADD_PROPERTIES, argEmployeeTimeOffProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEmployeeTimeOffProperty(IEmployeeTimeOffProperty argEmployeeTimeOffProperty) {
/* 571 */     if (this._properties != null) {
/*     */       
/* 573 */       if (postEventsForChanges()) {
/* 574 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTimeOffProperty));
/*     */       }
/* 576 */       this._properties.remove(argEmployeeTimeOffProperty);
/* 577 */       if (postEventsForChanges()) {
/* 578 */         this._events.post(IEmployeeTimeOff.REMOVE_PROPERTIES, argEmployeeTimeOffProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 585 */     if ("Properties".equals(argFieldId)) {
/* 586 */       return getProperties();
/*     */     }
/* 588 */     if ("EmployeeTimeOffExtension".equals(argFieldId)) {
/* 589 */       return this._myExtension;
/*     */     }
/*     */     
/* 592 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 598 */     if ("Properties".equals(argFieldId)) {
/* 599 */       setProperties(changeToList(argValue, IEmployeeTimeOffProperty.class));
/*     */     }
/* 601 */     else if ("EmployeeTimeOffExtension".equals(argFieldId)) {
/* 602 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 605 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 611 */     this._persistenceDefaults = argPD;
/* 612 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 613 */     this._eventManager = argEM;
/* 614 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 615 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 616 */     if (this._properties != null) {
/* 617 */       for (IEmployeeTimeOffProperty relationship : this._properties) {
/* 618 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEmployeeTimeOffExt() {
/* 624 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEmployeeTimeOffExt(IDataModel argExt) {
/* 628 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 633 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 637 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 640 */     super.startTransaction();
/*     */     
/* 642 */     this._propertiesSavepoint = this._properties;
/* 643 */     if (this._properties != null) {
/* 644 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 645 */       Iterator<IDataModel> it = this._properties.iterator();
/* 646 */       while (it.hasNext()) {
/* 647 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 652 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 657 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 660 */     super.rollbackChanges();
/*     */     
/* 662 */     this._properties = this._propertiesSavepoint;
/* 663 */     this._propertiesSavepoint = null;
/* 664 */     if (this._properties != null) {
/* 665 */       Iterator<IDataModel> it = this._properties.iterator();
/* 666 */       while (it.hasNext()) {
/* 667 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 675 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 678 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 681 */     super.commitTransaction();
/*     */     
/* 683 */     this._propertiesSavepoint = this._properties;
/* 684 */     if (this._properties != null) {
/* 685 */       Iterator<IDataModel> it = this._properties.iterator();
/* 686 */       while (it.hasNext()) {
/* 687 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 689 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 693 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 698 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\EmployeeTimeOffModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */