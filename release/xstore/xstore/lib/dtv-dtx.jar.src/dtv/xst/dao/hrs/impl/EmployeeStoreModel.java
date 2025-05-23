/*     */ package dtv.xst.dao.hrs.impl;
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
/*     */ import dtv.xst.dao.hrs.EmployeeStorePropertyId;
/*     */ import dtv.xst.dao.hrs.IEmployeeStore;
/*     */ import dtv.xst.dao.hrs.IEmployeeStoreProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EmployeeStoreModel extends AbstractDataModelWithPropertyImpl<IEmployeeStoreProperty> implements IEmployeeStore {
/*     */   private static final long serialVersionUID = -1240510797L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IEmployeeStoreProperty> _properties; private transient HistoricalList<IEmployeeStoreProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new EmployeeStoreDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EmployeeStoreDAO getDAO_() {
/*  46 */     return (EmployeeStoreDAO)this._daoImpl;
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
/*  70 */       this._events.post(IEmployeeStore.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<EmployeeStorePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((EmployeeStorePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 112 */       this._events.post(IEmployeeStore.SET_EMPLOYEEID, argEmployeeId);
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
/* 127 */         Iterator<EmployeeStorePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((EmployeeStorePropertyModel)it.next()).setEmployeeId_noev(argEmployeeId);
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
/*     */   public long getRetailLocationId() {
/* 143 */     if (getDAO_().getRetailLocationId() != null) {
/* 144 */       return getDAO_().getRetailLocationId().longValue();
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
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 156 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IEmployeeStore.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 169 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 170 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<EmployeeStorePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((EmployeeStorePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public int getEmployeeStoreSequence() {
/* 190 */     if (getDAO_().getEmployeeStoreSequence() != null) {
/* 191 */       return getDAO_().getEmployeeStoreSequence().intValue();
/*     */     }
/*     */     
/* 194 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeStoreSequence(int argEmployeeStoreSequence) {
/* 203 */     if (setEmployeeStoreSequence_noev(argEmployeeStoreSequence) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IEmployeeStore.SET_EMPLOYEESTORESEQUENCE, Integer.valueOf(argEmployeeStoreSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeStoreSequence_noev(int argEmployeeStoreSequence) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getEmployeeStoreSequence() == null && Integer.valueOf(argEmployeeStoreSequence) != null) || (
/* 216 */       getDAO_().getEmployeeStoreSequence() != null && !getDAO_().getEmployeeStoreSequence().equals(Integer.valueOf(argEmployeeStoreSequence)))) {
/* 217 */       getDAO_().setEmployeeStoreSequence(Integer.valueOf(argEmployeeStoreSequence));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<EmployeeStorePropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((EmployeeStorePropertyModel)it.next()).setEmployeeStoreSequence_noev(argEmployeeStoreSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 237 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 245 */     if (setCreateDate_noev(argCreateDate) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IEmployeeStore.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 258 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 259 */       getDAO_().setCreateDate(argCreateDate);
/* 260 */       ev_postable = true;
/*     */     } 
/*     */     
/* 263 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 271 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 279 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IEmployeeStore.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 292 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 293 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 305 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 313 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IEmployeeStore.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 326 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 327 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 339 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 347 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IEmployeeStore.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 360 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 361 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDate() {
/* 373 */     return getDAO_().getBeginDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDate(Date argBeginDate) {
/* 381 */     if (setBeginDate_noev(argBeginDate) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IEmployeeStore.SET_BEGINDATE, argBeginDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBeginDate_noev(Date argBeginDate) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getBeginDate() == null && argBeginDate != null) || (
/* 394 */       getDAO_().getBeginDate() != null && !getDAO_().getBeginDate().equals(argBeginDate))) {
/* 395 */       getDAO_().setBeginDate(argBeginDate);
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
/*     */   public Date getEndDate() {
/* 407 */     return getDAO_().getEndDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 415 */     if (setEndDate_noev(argEndDate) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(IEmployeeStore.SET_ENDDATE, argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndDate_noev(Date argEndDate) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getEndDate() == null && argEndDate != null) || (
/* 428 */       getDAO_().getEndDate() != null && !getDAO_().getEndDate().equals(argEndDate))) {
/* 429 */       getDAO_().setEndDate(argEndDate);
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
/*     */   public boolean getTemporaryAssignment() {
/* 441 */     if (getDAO_().getTemporaryAssignment() != null) {
/* 442 */       return getDAO_().getTemporaryAssignment().booleanValue();
/*     */     }
/*     */     
/* 445 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTemporaryAssignment(boolean argTemporaryAssignment) {
/* 454 */     if (setTemporaryAssignment_noev(argTemporaryAssignment) && 
/* 455 */       this._events != null && 
/* 456 */       postEventsForChanges()) {
/* 457 */       this._events.post(IEmployeeStore.SET_TEMPORARYASSIGNMENT, Boolean.valueOf(argTemporaryAssignment));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTemporaryAssignment_noev(boolean argTemporaryAssignment) {
/* 464 */     boolean ev_postable = false;
/*     */     
/* 466 */     if ((getDAO_().getTemporaryAssignment() == null && Boolean.valueOf(argTemporaryAssignment) != null) || (
/* 467 */       getDAO_().getTemporaryAssignment() != null && !getDAO_().getTemporaryAssignment().equals(Boolean.valueOf(argTemporaryAssignment)))) {
/* 468 */       getDAO_().setTemporaryAssignment(Boolean.valueOf(argTemporaryAssignment));
/* 469 */       ev_postable = true;
/*     */     } 
/*     */     
/* 472 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEmployeeStoreProperty newProperty(String argPropertyName) {
/* 476 */     EmployeeStorePropertyId id = new EmployeeStorePropertyId();
/*     */     
/* 478 */     id.setEmployeeId(getEmployeeId());
/* 479 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 480 */     id.setEmployeeStoreSequence(Integer.valueOf(getEmployeeStoreSequence()));
/* 481 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 483 */     IEmployeeStoreProperty prop = (IEmployeeStoreProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeStoreProperty.class);
/* 484 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEmployeeStoreProperty> getProperties() {
/* 493 */     if (this._properties == null) {
/* 494 */       this._properties = new HistoricalList(null);
/*     */     }
/* 496 */     return (List<IEmployeeStoreProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEmployeeStoreProperty> argProperties) {
/* 500 */     if (this._properties == null) {
/* 501 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 503 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 506 */     for (IEmployeeStoreProperty child : this._properties) {
/* 507 */       EmployeeStorePropertyModel model = (EmployeeStorePropertyModel)child;
/* 508 */       model.setOrganizationId_noev(getOrganizationId());
/* 509 */       model.setEmployeeId_noev(getEmployeeId());
/* 510 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 511 */       model.setEmployeeStoreSequence_noev(getEmployeeStoreSequence());
/* 512 */       if (child instanceof IDataModelImpl) {
/* 513 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 514 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 515 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 516 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 519 */       if (postEventsForChanges()) {
/* 520 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEmployeeStoreProperty(IEmployeeStoreProperty argEmployeeStoreProperty) {
/* 526 */     if (this._properties == null) {
/* 527 */       this._properties = new HistoricalList(null);
/*     */     }
/* 529 */     argEmployeeStoreProperty.setOrganizationId(getOrganizationId());
/* 530 */     argEmployeeStoreProperty.setEmployeeId(getEmployeeId());
/* 531 */     argEmployeeStoreProperty.setRetailLocationId(getRetailLocationId());
/* 532 */     argEmployeeStoreProperty.setEmployeeStoreSequence(getEmployeeStoreSequence());
/* 533 */     if (argEmployeeStoreProperty instanceof IDataModelImpl) {
/* 534 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeStoreProperty).getDAO();
/* 535 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 536 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 537 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 542 */     if (postEventsForChanges()) {
/* 543 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeStoreProperty));
/*     */     }
/*     */     
/* 546 */     this._properties.add(argEmployeeStoreProperty);
/* 547 */     if (postEventsForChanges()) {
/* 548 */       this._events.post(IEmployeeStore.ADD_PROPERTIES, argEmployeeStoreProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEmployeeStoreProperty(IEmployeeStoreProperty argEmployeeStoreProperty) {
/* 553 */     if (this._properties != null) {
/*     */       
/* 555 */       if (postEventsForChanges()) {
/* 556 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeStoreProperty));
/*     */       }
/* 558 */       this._properties.remove(argEmployeeStoreProperty);
/* 559 */       if (postEventsForChanges()) {
/* 560 */         this._events.post(IEmployeeStore.REMOVE_PROPERTIES, argEmployeeStoreProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 567 */     if ("Properties".equals(argFieldId)) {
/* 568 */       return getProperties();
/*     */     }
/* 570 */     if ("EmployeeStoreExtension".equals(argFieldId)) {
/* 571 */       return this._myExtension;
/*     */     }
/*     */     
/* 574 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 580 */     if ("Properties".equals(argFieldId)) {
/* 581 */       setProperties(changeToList(argValue, IEmployeeStoreProperty.class));
/*     */     }
/* 583 */     else if ("EmployeeStoreExtension".equals(argFieldId)) {
/* 584 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 587 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 593 */     this._persistenceDefaults = argPD;
/* 594 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 595 */     this._eventManager = argEM;
/* 596 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 597 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 598 */     if (this._properties != null) {
/* 599 */       for (IEmployeeStoreProperty relationship : this._properties) {
/* 600 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEmployeeStoreExt() {
/* 606 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEmployeeStoreExt(IDataModel argExt) {
/* 610 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 615 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 619 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 622 */     super.startTransaction();
/*     */     
/* 624 */     this._propertiesSavepoint = this._properties;
/* 625 */     if (this._properties != null) {
/* 626 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 627 */       Iterator<IDataModel> it = this._properties.iterator();
/* 628 */       while (it.hasNext()) {
/* 629 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 634 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 639 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 642 */     super.rollbackChanges();
/*     */     
/* 644 */     this._properties = this._propertiesSavepoint;
/* 645 */     this._propertiesSavepoint = null;
/* 646 */     if (this._properties != null) {
/* 647 */       Iterator<IDataModel> it = this._properties.iterator();
/* 648 */       while (it.hasNext()) {
/* 649 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 657 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 660 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 663 */     super.commitTransaction();
/*     */     
/* 665 */     this._propertiesSavepoint = this._properties;
/* 666 */     if (this._properties != null) {
/* 667 */       Iterator<IDataModel> it = this._properties.iterator();
/* 668 */       while (it.hasNext()) {
/* 669 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 671 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 675 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 680 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeStoreModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */