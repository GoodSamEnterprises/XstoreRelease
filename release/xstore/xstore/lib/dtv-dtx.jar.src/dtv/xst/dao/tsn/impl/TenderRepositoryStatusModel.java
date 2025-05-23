/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryStatus;
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryStatusProperty;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryStatusPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderRepositoryStatusModel extends AbstractDataModelWithPropertyImpl<ITenderRepositoryStatusProperty> implements ITenderRepositoryStatus {
/*     */   private static final long serialVersionUID = -1132449040L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITenderRepositoryStatusProperty> _properties; private transient HistoricalList<ITenderRepositoryStatusProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TenderRepositoryStatusDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderRepositoryStatusDAO getDAO_() {
/*  46 */     return (TenderRepositoryStatusDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITenderRepositoryStatus.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TenderRepositoryStatusPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TenderRepositoryStatusPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(ITenderRepositoryStatus.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<TenderRepositoryStatusPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((TenderRepositoryStatusPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public String getTenderRepositoryId() {
/* 148 */     return getDAO_().getTenderRepositoryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/* 156 */     if (setTenderRepositoryId_noev(argTenderRepositoryId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ITenderRepositoryStatus.SET_TENDERREPOSITORYID, argTenderRepositoryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderRepositoryId_noev(String argTenderRepositoryId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getTenderRepositoryId() == null && argTenderRepositoryId != null) || (
/* 169 */       getDAO_().getTenderRepositoryId() != null && !getDAO_().getTenderRepositoryId().equals(argTenderRepositoryId))) {
/* 170 */       getDAO_().setTenderRepositoryId(argTenderRepositoryId);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<TenderRepositoryStatusPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((TenderRepositoryStatusPropertyModel)it.next()).setTenderRepositoryId_noev(argTenderRepositoryId);
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
/* 201 */       this._events.post(ITenderRepositoryStatus.SET_CREATEDATE, argCreateDate);
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
/* 235 */       this._events.post(ITenderRepositoryStatus.SET_CREATEUSERID, argCreateUserId);
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
/* 269 */       this._events.post(ITenderRepositoryStatus.SET_UPDATEDATE, argUpdateDate);
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
/* 303 */       this._events.post(ITenderRepositoryStatus.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public boolean getIssued() {
/* 326 */     if (getDAO_().getIssued() != null) {
/* 327 */       return getDAO_().getIssued().booleanValue();
/*     */     }
/*     */     
/* 330 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIssued(boolean argIssued) {
/* 339 */     if (setIssued_noev(argIssued) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(ITenderRepositoryStatus.SET_ISSUED, Boolean.valueOf(argIssued));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIssued_noev(boolean argIssued) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getIssued() == null && Boolean.valueOf(argIssued) != null) || (
/* 352 */       getDAO_().getIssued() != null && !getDAO_().getIssued().equals(Boolean.valueOf(argIssued)))) {
/* 353 */       getDAO_().setIssued(Boolean.valueOf(argIssued));
/* 354 */       ev_postable = true;
/*     */     } 
/*     */     
/* 357 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getActiveSessionId() {
/* 365 */     if (getDAO_().getActiveSessionId() != null) {
/* 366 */       return getDAO_().getActiveSessionId().longValue();
/*     */     }
/*     */     
/* 369 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveSessionId(long argActiveSessionId) {
/* 378 */     if (setActiveSessionId_noev(argActiveSessionId) && 
/* 379 */       this._events != null && 
/* 380 */       postEventsForChanges()) {
/* 381 */       this._events.post(ITenderRepositoryStatus.SET_ACTIVESESSIONID, Long.valueOf(argActiveSessionId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActiveSessionId_noev(long argActiveSessionId) {
/* 388 */     boolean ev_postable = false;
/*     */     
/* 390 */     if ((getDAO_().getActiveSessionId() == null && Long.valueOf(argActiveSessionId) != null) || (
/* 391 */       getDAO_().getActiveSessionId() != null && !getDAO_().getActiveSessionId().equals(Long.valueOf(argActiveSessionId)))) {
/* 392 */       getDAO_().setActiveSessionId(Long.valueOf(argActiveSessionId));
/* 393 */       ev_postable = true;
/*     */     } 
/*     */     
/* 396 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderRepositoryStatusProperty newProperty(String argPropertyName) {
/* 400 */     TenderRepositoryStatusPropertyId id = new TenderRepositoryStatusPropertyId();
/*     */     
/* 402 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 403 */     id.setTenderRepositoryId(getTenderRepositoryId());
/* 404 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 406 */     ITenderRepositoryStatusProperty prop = (ITenderRepositoryStatusProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderRepositoryStatusProperty.class);
/* 407 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderRepositoryStatusProperty> getProperties() {
/* 416 */     if (this._properties == null) {
/* 417 */       this._properties = new HistoricalList(null);
/*     */     }
/* 419 */     return (List<ITenderRepositoryStatusProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderRepositoryStatusProperty> argProperties) {
/* 423 */     if (this._properties == null) {
/* 424 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 426 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 429 */     for (ITenderRepositoryStatusProperty child : this._properties) {
/* 430 */       TenderRepositoryStatusPropertyModel model = (TenderRepositoryStatusPropertyModel)child;
/* 431 */       model.setOrganizationId_noev(getOrganizationId());
/* 432 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 433 */       model.setTenderRepositoryId_noev(getTenderRepositoryId());
/* 434 */       if (child instanceof IDataModelImpl) {
/* 435 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 436 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 437 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 438 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 441 */       if (postEventsForChanges()) {
/* 442 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderRepositoryStatusProperty(ITenderRepositoryStatusProperty argTenderRepositoryStatusProperty) {
/* 448 */     if (this._properties == null) {
/* 449 */       this._properties = new HistoricalList(null);
/*     */     }
/* 451 */     argTenderRepositoryStatusProperty.setOrganizationId(getOrganizationId());
/* 452 */     argTenderRepositoryStatusProperty.setRetailLocationId(getRetailLocationId());
/* 453 */     argTenderRepositoryStatusProperty.setTenderRepositoryId(getTenderRepositoryId());
/* 454 */     if (argTenderRepositoryStatusProperty instanceof IDataModelImpl) {
/* 455 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderRepositoryStatusProperty).getDAO();
/* 456 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 457 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 458 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 463 */     if (postEventsForChanges()) {
/* 464 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryStatusProperty));
/*     */     }
/*     */     
/* 467 */     this._properties.add(argTenderRepositoryStatusProperty);
/* 468 */     if (postEventsForChanges()) {
/* 469 */       this._events.post(ITenderRepositoryStatus.ADD_PROPERTIES, argTenderRepositoryStatusProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderRepositoryStatusProperty(ITenderRepositoryStatusProperty argTenderRepositoryStatusProperty) {
/* 474 */     if (this._properties != null) {
/*     */       
/* 476 */       if (postEventsForChanges()) {
/* 477 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryStatusProperty));
/*     */       }
/* 479 */       this._properties.remove(argTenderRepositoryStatusProperty);
/* 480 */       if (postEventsForChanges()) {
/* 481 */         this._events.post(ITenderRepositoryStatus.REMOVE_PROPERTIES, argTenderRepositoryStatusProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 488 */     if ("Properties".equals(argFieldId)) {
/* 489 */       return getProperties();
/*     */     }
/* 491 */     if ("TenderRepositoryStatusExtension".equals(argFieldId)) {
/* 492 */       return this._myExtension;
/*     */     }
/*     */     
/* 495 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 501 */     if ("Properties".equals(argFieldId)) {
/* 502 */       setProperties(changeToList(argValue, ITenderRepositoryStatusProperty.class));
/*     */     }
/* 504 */     else if ("TenderRepositoryStatusExtension".equals(argFieldId)) {
/* 505 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 508 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 514 */     this._persistenceDefaults = argPD;
/* 515 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 516 */     this._eventManager = argEM;
/* 517 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 518 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 519 */     if (this._properties != null) {
/* 520 */       for (ITenderRepositoryStatusProperty relationship : this._properties) {
/* 521 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderRepositoryStatusExt() {
/* 527 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryStatusExt(IDataModel argExt) {
/* 531 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 536 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 540 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 543 */     super.startTransaction();
/*     */     
/* 545 */     this._propertiesSavepoint = this._properties;
/* 546 */     if (this._properties != null) {
/* 547 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 548 */       Iterator<IDataModel> it = this._properties.iterator();
/* 549 */       while (it.hasNext()) {
/* 550 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 555 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 560 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 563 */     super.rollbackChanges();
/*     */     
/* 565 */     this._properties = this._propertiesSavepoint;
/* 566 */     this._propertiesSavepoint = null;
/* 567 */     if (this._properties != null) {
/* 568 */       Iterator<IDataModel> it = this._properties.iterator();
/* 569 */       while (it.hasNext()) {
/* 570 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 578 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 581 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 584 */     super.commitTransaction();
/*     */     
/* 586 */     this._propertiesSavepoint = this._properties;
/* 587 */     if (this._properties != null) {
/* 588 */       Iterator<IDataModel> it = this._properties.iterator();
/* 589 */       while (it.hasNext()) {
/* 590 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 592 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 596 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 601 */     argStream.defaultReadObject();
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
/*     */   
/*     */   public void clearActiveSessionId() {
/* 622 */     getDAO_().setActiveSessionId(null);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryStatusModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */