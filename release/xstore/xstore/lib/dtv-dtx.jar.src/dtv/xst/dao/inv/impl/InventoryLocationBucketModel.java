/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.exception.DtxException;
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
/*     */ import dtv.xst.dao.inv.IInventoryBucket;
/*     */ import dtv.xst.dao.inv.IInventoryLocation;
/*     */ import dtv.xst.dao.inv.IInventoryLocationBucket;
/*     */ import dtv.xst.dao.inv.IInventoryLocationBucketProperty;
/*     */ import dtv.xst.dao.inv.InventoryLocationBucketPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryLocationBucketModel extends AbstractDataModelWithPropertyImpl<IInventoryLocationBucketProperty> implements IInventoryLocationBucket {
/*     */   private static final long serialVersionUID = 415344219L;
/*     */   private IInventoryLocation _parentLocation;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private IInventoryBucket _inventoryBucket; private transient IInventoryBucket _inventoryBucketSavepoint; private HistoricalList<IInventoryLocationBucketProperty> _properties; private transient HistoricalList<IInventoryLocationBucketProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new InventoryLocationBucketDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryLocationBucketDAO getDAO_() {
/*  49 */     return (InventoryLocationBucketDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(IInventoryLocationBucket.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<InventoryLocationBucketPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((InventoryLocationBucketPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 104 */     if (getDAO_().getRetailLocationId() != null) {
/* 105 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 108 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 117 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 118 */       this._events != null && 
/* 119 */       postEventsForChanges()) {
/* 120 */       this._events.post(IInventoryLocationBucket.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 127 */     boolean ev_postable = false;
/*     */     
/* 129 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 130 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 131 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 132 */       ev_postable = true;
/* 133 */       if (this._properties != null) {
/*     */         
/* 135 */         Iterator<InventoryLocationBucketPropertyModel> it = this._properties.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((InventoryLocationBucketPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationId() {
/* 151 */     return getDAO_().getLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 159 */     if (setLocationId_noev(argLocationId) && 
/* 160 */       this._events != null && 
/* 161 */       postEventsForChanges()) {
/* 162 */       this._events.post(IInventoryLocationBucket.SET_LOCATIONID, argLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationId_noev(String argLocationId) {
/* 169 */     boolean ev_postable = false;
/*     */     
/* 171 */     if ((getDAO_().getLocationId() == null && argLocationId != null) || (
/* 172 */       getDAO_().getLocationId() != null && !getDAO_().getLocationId().equals(argLocationId))) {
/* 173 */       getDAO_().setLocationId(argLocationId);
/* 174 */       ev_postable = true;
/* 175 */       if (this._properties != null) {
/*     */         
/* 177 */         Iterator<InventoryLocationBucketPropertyModel> it = this._properties.iterator();
/* 178 */         while (it.hasNext())
/*     */         {
/* 180 */           ((InventoryLocationBucketPropertyModel)it.next()).setLocationId_noev(argLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBucketId() {
/* 193 */     return getDAO_().getBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/* 201 */     if (setBucketId_noev(argBucketId) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IInventoryLocationBucket.SET_BUCKETID, argBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBucketId_noev(String argBucketId) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getBucketId() == null && argBucketId != null) || (
/* 214 */       getDAO_().getBucketId() != null && !getDAO_().getBucketId().equals(argBucketId))) {
/* 215 */       getDAO_().setBucketId(argBucketId);
/* 216 */       ev_postable = true;
/* 217 */       if (this._properties != null) {
/*     */         
/* 219 */         Iterator<InventoryLocationBucketPropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((InventoryLocationBucketPropertyModel)it.next()).setBucketId_noev(argBucketId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 227 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 235 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 243 */     if (setCreateDate_noev(argCreateDate) && 
/* 244 */       this._events != null && 
/* 245 */       postEventsForChanges()) {
/* 246 */       this._events.post(IInventoryLocationBucket.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 253 */     boolean ev_postable = false;
/*     */     
/* 255 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 256 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 257 */       getDAO_().setCreateDate(argCreateDate);
/* 258 */       ev_postable = true;
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 269 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 277 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(IInventoryLocationBucket.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 290 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 291 */       getDAO_().setCreateUserId(argCreateUserId);
/* 292 */       ev_postable = true;
/*     */     } 
/*     */     
/* 295 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 303 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 311 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 312 */       this._events != null && 
/* 313 */       postEventsForChanges()) {
/* 314 */       this._events.post(IInventoryLocationBucket.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 321 */     boolean ev_postable = false;
/*     */     
/* 323 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 324 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 325 */       getDAO_().setUpdateDate(argUpdateDate);
/* 326 */       ev_postable = true;
/*     */     } 
/*     */     
/* 329 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 337 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 345 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(IInventoryLocationBucket.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 358 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 359 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 360 */       ev_postable = true;
/*     */     } 
/*     */     
/* 363 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTrackingMethod() {
/* 371 */     return getDAO_().getTrackingMethod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrackingMethod(String argTrackingMethod) {
/* 379 */     if (setTrackingMethod_noev(argTrackingMethod) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(IInventoryLocationBucket.SET_TRACKINGMETHOD, argTrackingMethod);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTrackingMethod_noev(String argTrackingMethod) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getTrackingMethod() == null && argTrackingMethod != null) || (
/* 392 */       getDAO_().getTrackingMethod() != null && !getDAO_().getTrackingMethod().equals(argTrackingMethod))) {
/* 393 */       getDAO_().setTrackingMethod(argTrackingMethod);
/* 394 */       ev_postable = true;
/*     */     } 
/*     */     
/* 397 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryLocationBucketProperty newProperty(String argPropertyName) {
/* 401 */     InventoryLocationBucketPropertyId id = new InventoryLocationBucketPropertyId();
/*     */     
/* 403 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 404 */     id.setLocationId(getLocationId());
/* 405 */     id.setBucketId(getBucketId());
/* 406 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 408 */     IInventoryLocationBucketProperty prop = (IInventoryLocationBucketProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryLocationBucketProperty.class);
/* 409 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "InventoryBucket")
/*     */   public IInventoryBucket getInventoryBucket() {
/* 421 */     return this._inventoryBucket;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInventoryBucket(IInventoryBucket argInventoryBucket) {
/* 426 */     if (argInventoryBucket == null) {
/*     */       
/* 428 */       if (this._inventoryBucket != null) {
/* 429 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 432 */       if (this._inventoryBucket != null)
/*     */       {
/* 434 */         if (postEventsForChanges()) {
/* 435 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryBucket));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 441 */     else if (postEventsForChanges()) {
/* 442 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryBucket));
/*     */     } 
/*     */ 
/*     */     
/* 446 */     this._inventoryBucket = argInventoryBucket;
/* 447 */     if (postEventsForChanges()) {
/* 448 */       this._events.post(IInventoryLocationBucket.SET_INVENTORYBUCKET, argInventoryBucket);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryLocationBucketProperty> getProperties() {
/* 454 */     if (this._properties == null) {
/* 455 */       this._properties = new HistoricalList(null);
/*     */     }
/* 457 */     return (List<IInventoryLocationBucketProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryLocationBucketProperty> argProperties) {
/* 461 */     if (this._properties == null) {
/* 462 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 464 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 467 */     for (IInventoryLocationBucketProperty child : this._properties) {
/* 468 */       InventoryLocationBucketPropertyModel model = (InventoryLocationBucketPropertyModel)child;
/* 469 */       model.setOrganizationId_noev(getOrganizationId());
/* 470 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 471 */       model.setLocationId_noev(getLocationId());
/* 472 */       model.setBucketId_noev(getBucketId());
/* 473 */       if (child instanceof IDataModelImpl) {
/* 474 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 475 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 476 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 477 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 480 */       if (postEventsForChanges()) {
/* 481 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryLocationBucketProperty(IInventoryLocationBucketProperty argInventoryLocationBucketProperty) {
/* 487 */     if (this._properties == null) {
/* 488 */       this._properties = new HistoricalList(null);
/*     */     }
/* 490 */     argInventoryLocationBucketProperty.setOrganizationId(getOrganizationId());
/* 491 */     argInventoryLocationBucketProperty.setRetailLocationId(getRetailLocationId());
/* 492 */     argInventoryLocationBucketProperty.setLocationId(getLocationId());
/* 493 */     argInventoryLocationBucketProperty.setBucketId(getBucketId());
/* 494 */     if (argInventoryLocationBucketProperty instanceof IDataModelImpl) {
/* 495 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryLocationBucketProperty).getDAO();
/* 496 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 497 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 498 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 503 */     if (postEventsForChanges()) {
/* 504 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationBucketProperty));
/*     */     }
/*     */     
/* 507 */     this._properties.add(argInventoryLocationBucketProperty);
/* 508 */     if (postEventsForChanges()) {
/* 509 */       this._events.post(IInventoryLocationBucket.ADD_PROPERTIES, argInventoryLocationBucketProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryLocationBucketProperty(IInventoryLocationBucketProperty argInventoryLocationBucketProperty) {
/* 514 */     if (this._properties != null) {
/*     */       
/* 516 */       if (postEventsForChanges()) {
/* 517 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationBucketProperty));
/*     */       }
/* 519 */       this._properties.remove(argInventoryLocationBucketProperty);
/* 520 */       if (postEventsForChanges()) {
/* 521 */         this._events.post(IInventoryLocationBucket.REMOVE_PROPERTIES, argInventoryLocationBucketProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLocation(IInventoryLocation argParentLocation) {
/* 527 */     this._parentLocation = argParentLocation;
/*     */   }
/*     */   
/*     */   public IInventoryLocation getParentLocation() {
/* 531 */     return this._parentLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 536 */     if ("InventoryBucket".equals(argFieldId)) {
/* 537 */       return getInventoryBucket();
/*     */     }
/* 539 */     if ("Properties".equals(argFieldId)) {
/* 540 */       return getProperties();
/*     */     }
/* 542 */     if ("InventoryLocationBucketExtension".equals(argFieldId)) {
/* 543 */       return this._myExtension;
/*     */     }
/*     */     
/* 546 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 552 */     if ("InventoryBucket".equals(argFieldId)) {
/* 553 */       setInventoryBucket((IInventoryBucket)argValue);
/*     */     }
/* 555 */     else if ("Properties".equals(argFieldId)) {
/* 556 */       setProperties(changeToList(argValue, IInventoryLocationBucketProperty.class));
/*     */     }
/* 558 */     else if ("InventoryLocationBucketExtension".equals(argFieldId)) {
/* 559 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 562 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 568 */     this._persistenceDefaults = argPD;
/* 569 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 570 */     this._eventManager = argEM;
/* 571 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 572 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 573 */     if (this._inventoryBucket != null) {
/* 574 */       ((IDataModelImpl)this._inventoryBucket).setDependencies(argPD, argEM);
/*     */     }
/* 576 */     if (this._properties != null) {
/* 577 */       for (IInventoryLocationBucketProperty relationship : this._properties) {
/* 578 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryLocationBucketExt() {
/* 584 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationBucketExt(IDataModel argExt) {
/* 588 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 593 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 597 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 600 */     super.startTransaction();
/*     */     
/* 602 */     this._inventoryBucketSavepoint = this._inventoryBucket;
/* 603 */     if (this._inventoryBucket != null) {
/* 604 */       this._inventoryBucket.startTransaction();
/*     */     }
/*     */     
/* 607 */     this._propertiesSavepoint = this._properties;
/* 608 */     if (this._properties != null) {
/* 609 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 610 */       Iterator<IDataModel> it = this._properties.iterator();
/* 611 */       while (it.hasNext()) {
/* 612 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 617 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 622 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 625 */     super.rollbackChanges();
/*     */     
/* 627 */     this._inventoryBucket = this._inventoryBucketSavepoint;
/* 628 */     this._inventoryBucketSavepoint = null;
/* 629 */     if (this._inventoryBucket != null) {
/* 630 */       this._inventoryBucket.rollbackChanges();
/*     */     }
/*     */     
/* 633 */     this._properties = this._propertiesSavepoint;
/* 634 */     this._propertiesSavepoint = null;
/* 635 */     if (this._properties != null) {
/* 636 */       Iterator<IDataModel> it = this._properties.iterator();
/* 637 */       while (it.hasNext()) {
/* 638 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
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
/* 654 */     this._inventoryBucketSavepoint = this._inventoryBucket;
/* 655 */     if (this._inventoryBucket != null) {
/* 656 */       this._inventoryBucket.commitTransaction();
/*     */     }
/*     */     
/* 659 */     this._propertiesSavepoint = this._properties;
/* 660 */     if (this._properties != null) {
/* 661 */       Iterator<IDataModel> it = this._properties.iterator();
/* 662 */       while (it.hasNext()) {
/* 663 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 665 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 669 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 674 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationBucketModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */