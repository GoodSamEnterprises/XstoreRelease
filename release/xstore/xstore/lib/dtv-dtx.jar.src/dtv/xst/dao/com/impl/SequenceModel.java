/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.ISequence;
/*     */ import dtv.xst.dao.com.ISequenceProperty;
/*     */ import dtv.xst.dao.com.SequencePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SequenceModel extends AbstractDataModelWithPropertyImpl<ISequenceProperty> implements ISequence {
/*     */   private static final long serialVersionUID = 1414192097L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ISequenceProperty> _properties; private transient HistoricalList<ISequenceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new SequenceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SequenceDAO getDAO_() {
/*  46 */     return (SequenceDAO)this._daoImpl;
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
/*  70 */       this._events.post(ISequence.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<SequencePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((SequencePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 101 */     if (getDAO_().getRetailLocationId() != null) {
/* 102 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 105 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(ISequence.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<SequencePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((SequencePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 148 */     if (getDAO_().getWorkstationId() != null) {
/* 149 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 152 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 161 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(ISequence.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 174 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 175 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<SequencePropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((SequencePropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSequenceId() {
/* 195 */     return getDAO_().getSequenceId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequenceId(String argSequenceId) {
/* 203 */     if (setSequenceId_noev(argSequenceId) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(ISequence.SET_SEQUENCEID, argSequenceId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequenceId_noev(String argSequenceId) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getSequenceId() == null && argSequenceId != null) || (
/* 216 */       getDAO_().getSequenceId() != null && !getDAO_().getSequenceId().equals(argSequenceId))) {
/* 217 */       getDAO_().setSequenceId(argSequenceId);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<SequencePropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((SequencePropertyModel)it.next()).setSequenceId_noev(argSequenceId);
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
/*     */   public String getSequenceMode() {
/* 237 */     return getDAO_().getSequenceMode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequenceMode(String argSequenceMode) {
/* 245 */     if (setSequenceMode_noev(argSequenceMode) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(ISequence.SET_SEQUENCEMODE, argSequenceMode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequenceMode_noev(String argSequenceMode) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getSequenceMode() == null && argSequenceMode != null) || (
/* 258 */       getDAO_().getSequenceMode() != null && !getDAO_().getSequenceMode().equals(argSequenceMode))) {
/* 259 */       getDAO_().setSequenceMode(argSequenceMode);
/* 260 */       ev_postable = true;
/* 261 */       if (this._properties != null) {
/*     */         
/* 263 */         Iterator<SequencePropertyModel> it = this._properties.iterator();
/* 264 */         while (it.hasNext())
/*     */         {
/* 266 */           ((SequencePropertyModel)it.next()).setSequenceMode_noev(argSequenceMode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 279 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 287 */     if (setCreateDate_noev(argCreateDate) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(ISequence.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 300 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 301 */       getDAO_().setCreateDate(argCreateDate);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 313 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 321 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(ISequence.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 334 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 335 */       getDAO_().setCreateUserId(argCreateUserId);
/* 336 */       ev_postable = true;
/*     */     } 
/*     */     
/* 339 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 347 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 355 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(ISequence.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 368 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 369 */       getDAO_().setUpdateDate(argUpdateDate);
/* 370 */       ev_postable = true;
/*     */     } 
/*     */     
/* 373 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 381 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 389 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(ISequence.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 402 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 403 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 404 */       ev_postable = true;
/*     */     } 
/*     */     
/* 407 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSequenceNumber() {
/* 415 */     if (getDAO_().getSequenceNumber() != null) {
/* 416 */       return getDAO_().getSequenceNumber().longValue();
/*     */     }
/*     */     
/* 419 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequenceNumber(long argSequenceNumber) {
/* 428 */     if (setSequenceNumber_noev(argSequenceNumber) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(ISequence.SET_SEQUENCENUMBER, Long.valueOf(argSequenceNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequenceNumber_noev(long argSequenceNumber) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getSequenceNumber() == null && Long.valueOf(argSequenceNumber) != null) || (
/* 441 */       getDAO_().getSequenceNumber() != null && !getDAO_().getSequenceNumber().equals(Long.valueOf(argSequenceNumber)))) {
/* 442 */       getDAO_().setSequenceNumber(Long.valueOf(argSequenceNumber));
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ISequenceProperty newProperty(String argPropertyName) {
/* 450 */     SequencePropertyId id = new SequencePropertyId();
/*     */     
/* 452 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 453 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 454 */     id.setSequenceId(getSequenceId());
/* 455 */     id.setSequenceMode(getSequenceMode());
/* 456 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 458 */     ISequenceProperty prop = (ISequenceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISequenceProperty.class);
/* 459 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISequenceProperty> getProperties() {
/* 468 */     if (this._properties == null) {
/* 469 */       this._properties = new HistoricalList(null);
/*     */     }
/* 471 */     return (List<ISequenceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISequenceProperty> argProperties) {
/* 475 */     if (this._properties == null) {
/* 476 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 478 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 481 */     for (ISequenceProperty child : this._properties) {
/* 482 */       SequencePropertyModel model = (SequencePropertyModel)child;
/* 483 */       model.setOrganizationId_noev(getOrganizationId());
/* 484 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 485 */       model.setWorkstationId_noev(getWorkstationId());
/* 486 */       model.setSequenceId_noev(getSequenceId());
/* 487 */       model.setSequenceMode_noev(getSequenceMode());
/* 488 */       if (child instanceof IDataModelImpl) {
/* 489 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 490 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 491 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 492 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 495 */       if (postEventsForChanges()) {
/* 496 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addSequenceProperty(ISequenceProperty argSequenceProperty) {
/* 502 */     if (this._properties == null) {
/* 503 */       this._properties = new HistoricalList(null);
/*     */     }
/* 505 */     argSequenceProperty.setOrganizationId(getOrganizationId());
/* 506 */     argSequenceProperty.setRetailLocationId(getRetailLocationId());
/* 507 */     argSequenceProperty.setWorkstationId(getWorkstationId());
/* 508 */     argSequenceProperty.setSequenceId(getSequenceId());
/* 509 */     argSequenceProperty.setSequenceMode(getSequenceMode());
/* 510 */     if (argSequenceProperty instanceof IDataModelImpl) {
/* 511 */       IDataAccessObject childDao = ((IDataModelImpl)argSequenceProperty).getDAO();
/* 512 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 513 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 514 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 519 */     if (postEventsForChanges()) {
/* 520 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSequenceProperty));
/*     */     }
/*     */     
/* 523 */     this._properties.add(argSequenceProperty);
/* 524 */     if (postEventsForChanges()) {
/* 525 */       this._events.post(ISequence.ADD_PROPERTIES, argSequenceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSequenceProperty(ISequenceProperty argSequenceProperty) {
/* 530 */     if (this._properties != null) {
/*     */       
/* 532 */       if (postEventsForChanges()) {
/* 533 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSequenceProperty));
/*     */       }
/* 535 */       this._properties.remove(argSequenceProperty);
/* 536 */       if (postEventsForChanges()) {
/* 537 */         this._events.post(ISequence.REMOVE_PROPERTIES, argSequenceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 544 */     if ("Properties".equals(argFieldId)) {
/* 545 */       return getProperties();
/*     */     }
/* 547 */     if ("SequenceExtension".equals(argFieldId)) {
/* 548 */       return this._myExtension;
/*     */     }
/*     */     
/* 551 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 557 */     if ("Properties".equals(argFieldId)) {
/* 558 */       setProperties(changeToList(argValue, ISequenceProperty.class));
/*     */     }
/* 560 */     else if ("SequenceExtension".equals(argFieldId)) {
/* 561 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 564 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 570 */     this._persistenceDefaults = argPD;
/* 571 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 572 */     this._eventManager = argEM;
/* 573 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 574 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 575 */     if (this._properties != null) {
/* 576 */       for (ISequenceProperty relationship : this._properties) {
/* 577 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSequenceExt() {
/* 583 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSequenceExt(IDataModel argExt) {
/* 587 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 592 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 596 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 599 */     super.startTransaction();
/*     */     
/* 601 */     this._propertiesSavepoint = this._properties;
/* 602 */     if (this._properties != null) {
/* 603 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 604 */       Iterator<IDataModel> it = this._properties.iterator();
/* 605 */       while (it.hasNext()) {
/* 606 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 611 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 616 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 619 */     super.rollbackChanges();
/*     */     
/* 621 */     this._properties = this._propertiesSavepoint;
/* 622 */     this._propertiesSavepoint = null;
/* 623 */     if (this._properties != null) {
/* 624 */       Iterator<IDataModel> it = this._properties.iterator();
/* 625 */       while (it.hasNext()) {
/* 626 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 634 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 637 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 640 */     super.commitTransaction();
/*     */     
/* 642 */     this._propertiesSavepoint = this._properties;
/* 643 */     if (this._properties != null) {
/* 644 */       Iterator<IDataModel> it = this._properties.iterator();
/* 645 */       while (it.hasNext()) {
/* 646 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 648 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 652 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 657 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\SequenceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */