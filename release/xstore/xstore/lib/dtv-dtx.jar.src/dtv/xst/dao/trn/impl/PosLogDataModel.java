/*     */ package dtv.xst.dao.trn.impl;
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
/*     */ import dtv.xst.dao.trn.IPosLogData;
/*     */ import dtv.xst.dao.trn.IPosLogDataProperty;
/*     */ import dtv.xst.dao.trn.PosLogDataPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PosLogDataModel extends AbstractDataModelWithPropertyImpl<IPosLogDataProperty> implements IPosLogData {
/*     */   private static final long serialVersionUID = -1034551238L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPosLogDataProperty> _properties; private transient HistoricalList<IPosLogDataProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PosLogDataDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PosLogDataDAO getDAO_() {
/*  46 */     return (PosLogDataDAO)this._daoImpl;
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
/*  70 */       this._events.post(IPosLogData.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<PosLogDataPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PosLogDataPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IPosLogData.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<PosLogDataPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((PosLogDataPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 164 */       this._events.post(IPosLogData.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
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
/* 179 */         Iterator<PosLogDataPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((PosLogDataPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*     */   public Date getBusinessDate() {
/* 195 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 203 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IPosLogData.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 216 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 217 */       getDAO_().setBusinessDate(argBusinessDate);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<PosLogDataPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((PosLogDataPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getTransactionSequence() {
/* 237 */     if (getDAO_().getTransactionSequence() != null) {
/* 238 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 241 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 250 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IPosLogData.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 263 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 264 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<PosLogDataPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((PosLogDataPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 284 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 292 */     if (setCreateDate_noev(argCreateDate) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IPosLogData.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 305 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 306 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 318 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 326 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IPosLogData.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 339 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 340 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 352 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 360 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(IPosLogData.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 373 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 374 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 386 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 394 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(IPosLogData.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 407 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 408 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getPoslogData() {
/* 420 */     return getDAO_().getPoslogData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoslogData(String argPoslogData) {
/* 428 */     if (setPoslogData_noev(argPoslogData) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(IPosLogData.SET_POSLOGDATA, argPoslogData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPoslogData_noev(String argPoslogData) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getPoslogData() == null && argPoslogData != null) || (
/* 441 */       getDAO_().getPoslogData() != null && !getDAO_().getPoslogData().equals(argPoslogData))) {
/* 442 */       getDAO_().setPoslogData(argPoslogData);
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPosLogDataProperty newProperty(String argPropertyName) {
/* 450 */     PosLogDataPropertyId id = new PosLogDataPropertyId();
/*     */     
/* 452 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 453 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 454 */     id.setBusinessDate(getBusinessDate());
/* 455 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 456 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 458 */     IPosLogDataProperty prop = (IPosLogDataProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPosLogDataProperty.class);
/* 459 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPosLogDataProperty> getProperties() {
/* 468 */     if (this._properties == null) {
/* 469 */       this._properties = new HistoricalList(null);
/*     */     }
/* 471 */     return (List<IPosLogDataProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPosLogDataProperty> argProperties) {
/* 475 */     if (this._properties == null) {
/* 476 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 478 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 481 */     for (IPosLogDataProperty child : this._properties) {
/* 482 */       PosLogDataPropertyModel model = (PosLogDataPropertyModel)child;
/* 483 */       model.setOrganizationId_noev(getOrganizationId());
/* 484 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 485 */       model.setWorkstationId_noev(getWorkstationId());
/* 486 */       model.setBusinessDate_noev(getBusinessDate());
/* 487 */       model.setTransactionSequence_noev(getTransactionSequence());
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
/*     */   public void addPosLogDataProperty(IPosLogDataProperty argPosLogDataProperty) {
/* 502 */     if (this._properties == null) {
/* 503 */       this._properties = new HistoricalList(null);
/*     */     }
/* 505 */     argPosLogDataProperty.setOrganizationId(getOrganizationId());
/* 506 */     argPosLogDataProperty.setRetailLocationId(getRetailLocationId());
/* 507 */     argPosLogDataProperty.setWorkstationId(getWorkstationId());
/* 508 */     argPosLogDataProperty.setBusinessDate(getBusinessDate());
/* 509 */     argPosLogDataProperty.setTransactionSequence(getTransactionSequence());
/* 510 */     if (argPosLogDataProperty instanceof IDataModelImpl) {
/* 511 */       IDataAccessObject childDao = ((IDataModelImpl)argPosLogDataProperty).getDAO();
/* 512 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 513 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 514 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 519 */     if (postEventsForChanges()) {
/* 520 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosLogDataProperty));
/*     */     }
/*     */     
/* 523 */     this._properties.add(argPosLogDataProperty);
/* 524 */     if (postEventsForChanges()) {
/* 525 */       this._events.post(IPosLogData.ADD_PROPERTIES, argPosLogDataProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePosLogDataProperty(IPosLogDataProperty argPosLogDataProperty) {
/* 530 */     if (this._properties != null) {
/*     */       
/* 532 */       if (postEventsForChanges()) {
/* 533 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosLogDataProperty));
/*     */       }
/* 535 */       this._properties.remove(argPosLogDataProperty);
/* 536 */       if (postEventsForChanges()) {
/* 537 */         this._events.post(IPosLogData.REMOVE_PROPERTIES, argPosLogDataProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 544 */     if ("Properties".equals(argFieldId)) {
/* 545 */       return getProperties();
/*     */     }
/* 547 */     if ("PosLogDataExtension".equals(argFieldId)) {
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
/* 558 */       setProperties(changeToList(argValue, IPosLogDataProperty.class));
/*     */     }
/* 560 */     else if ("PosLogDataExtension".equals(argFieldId)) {
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
/* 576 */       for (IPosLogDataProperty relationship : this._properties) {
/* 577 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPosLogDataExt() {
/* 583 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPosLogDataExt(IDataModel argExt) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosLogDataModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */