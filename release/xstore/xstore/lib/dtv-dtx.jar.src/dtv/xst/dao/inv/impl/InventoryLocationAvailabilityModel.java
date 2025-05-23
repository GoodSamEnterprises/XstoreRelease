/*     */ package dtv.xst.dao.inv.impl;
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
/*     */ import dtv.xst.dao.inv.IInventoryLocationAvailability;
/*     */ import dtv.xst.dao.inv.IInventoryLocationAvailabilityProperty;
/*     */ import dtv.xst.dao.inv.InventoryLocationAvailabilityPropertyId;
/*     */ import dtv.xst.dao.sec.IPrivilege;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryLocationAvailabilityModel extends AbstractDataModelWithPropertyImpl<IInventoryLocationAvailabilityProperty> implements IInventoryLocationAvailability {
/*     */   private static final long serialVersionUID = -274556660L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IPrivilege _privilege; private transient IPrivilege _privilegeSavepoint; private HistoricalList<IInventoryLocationAvailabilityProperty> _properties; private transient HistoricalList<IInventoryLocationAvailabilityProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new InventoryLocationAvailabilityDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryLocationAvailabilityDAO getDAO_() {
/*  47 */     return (InventoryLocationAvailabilityDAO)this._daoImpl;
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
/*  71 */       this._events.post(IInventoryLocationAvailability.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<InventoryLocationAvailabilityPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((InventoryLocationAvailabilityPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 102 */     if (getDAO_().getRetailLocationId() != null) {
/* 103 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 106 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 115 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 116 */       this._events != null && 
/* 117 */       postEventsForChanges()) {
/* 118 */       this._events.post(IInventoryLocationAvailability.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 125 */     boolean ev_postable = false;
/*     */     
/* 127 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 128 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 129 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 130 */       ev_postable = true;
/* 131 */       if (this._properties != null) {
/*     */         
/* 133 */         Iterator<InventoryLocationAvailabilityPropertyModel> it = this._properties.iterator();
/* 134 */         while (it.hasNext())
/*     */         {
/* 136 */           ((InventoryLocationAvailabilityPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationId() {
/* 149 */     return getDAO_().getLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 157 */     if (setLocationId_noev(argLocationId) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IInventoryLocationAvailability.SET_LOCATIONID, argLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationId_noev(String argLocationId) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getLocationId() == null && argLocationId != null) || (
/* 170 */       getDAO_().getLocationId() != null && !getDAO_().getLocationId().equals(argLocationId))) {
/* 171 */       getDAO_().setLocationId(argLocationId);
/* 172 */       ev_postable = true;
/* 173 */       if (this._properties != null) {
/*     */         
/* 175 */         Iterator<InventoryLocationAvailabilityPropertyModel> it = this._properties.iterator();
/* 176 */         while (it.hasNext())
/*     */         {
/* 178 */           ((InventoryLocationAvailabilityPropertyModel)it.next()).setLocationId_noev(argLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAvailabilityCode() {
/* 191 */     return getDAO_().getAvailabilityCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAvailabilityCode(String argAvailabilityCode) {
/* 199 */     if (setAvailabilityCode_noev(argAvailabilityCode) && 
/* 200 */       this._events != null && 
/* 201 */       postEventsForChanges()) {
/* 202 */       this._events.post(IInventoryLocationAvailability.SET_AVAILABILITYCODE, argAvailabilityCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAvailabilityCode_noev(String argAvailabilityCode) {
/* 209 */     boolean ev_postable = false;
/*     */     
/* 211 */     if ((getDAO_().getAvailabilityCode() == null && argAvailabilityCode != null) || (
/* 212 */       getDAO_().getAvailabilityCode() != null && !getDAO_().getAvailabilityCode().equals(argAvailabilityCode))) {
/* 213 */       getDAO_().setAvailabilityCode(argAvailabilityCode);
/* 214 */       ev_postable = true;
/* 215 */       if (this._properties != null) {
/*     */         
/* 217 */         Iterator<InventoryLocationAvailabilityPropertyModel> it = this._properties.iterator();
/* 218 */         while (it.hasNext())
/*     */         {
/* 220 */           ((InventoryLocationAvailabilityPropertyModel)it.next()).setAvailabilityCode_noev(argAvailabilityCode);
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
/* 244 */       this._events.post(IInventoryLocationAvailability.SET_CREATEDATE, argCreateDate);
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
/* 278 */       this._events.post(IInventoryLocationAvailability.SET_CREATEUSERID, argCreateUserId);
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
/* 312 */       this._events.post(IInventoryLocationAvailability.SET_UPDATEDATE, argUpdateDate);
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
/* 346 */       this._events.post(IInventoryLocationAvailability.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getPrivilegeType() {
/* 369 */     return getDAO_().getPrivilegeType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/* 377 */     if (setPrivilegeType_noev(argPrivilegeType) && 
/* 378 */       this._events != null && 
/* 379 */       postEventsForChanges()) {
/* 380 */       this._events.post(IInventoryLocationAvailability.SET_PRIVILEGETYPE, argPrivilegeType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrivilegeType_noev(String argPrivilegeType) {
/* 387 */     boolean ev_postable = false;
/*     */     
/* 389 */     if ((getDAO_().getPrivilegeType() == null && argPrivilegeType != null) || (
/* 390 */       getDAO_().getPrivilegeType() != null && !getDAO_().getPrivilegeType().equals(argPrivilegeType))) {
/* 391 */       getDAO_().setPrivilegeType(argPrivilegeType);
/* 392 */       ev_postable = true;
/*     */     } 
/*     */     
/* 395 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryLocationAvailabilityProperty newProperty(String argPropertyName) {
/* 399 */     InventoryLocationAvailabilityPropertyId id = new InventoryLocationAvailabilityPropertyId();
/*     */     
/* 401 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 402 */     id.setLocationId(getLocationId());
/* 403 */     id.setAvailabilityCode(getAvailabilityCode());
/* 404 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 406 */     IInventoryLocationAvailabilityProperty prop = (IInventoryLocationAvailabilityProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryLocationAvailabilityProperty.class);
/* 407 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Privilege")
/*     */   public IPrivilege getPrivilege() {
/* 419 */     return this._privilege;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrivilege(IPrivilege argPrivilege) {
/* 424 */     if (argPrivilege == null) {
/*     */       
/* 426 */       getDAO_().setPrivilegeType(null);
/* 427 */       if (this._privilege != null)
/*     */       {
/* 429 */         if (postEventsForChanges()) {
/* 430 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._privilege));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 435 */       getDAO_().setPrivilegeType(argPrivilege.getPrivilegeType());
/*     */       
/* 437 */       if (postEventsForChanges()) {
/* 438 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPrivilege));
/*     */       }
/*     */     } 
/*     */     
/* 442 */     this._privilege = argPrivilege;
/* 443 */     if (postEventsForChanges()) {
/* 444 */       this._events.post(IInventoryLocationAvailability.SET_PRIVILEGE, argPrivilege);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryLocationAvailabilityProperty> getProperties() {
/* 450 */     if (this._properties == null) {
/* 451 */       this._properties = new HistoricalList(null);
/*     */     }
/* 453 */     return (List<IInventoryLocationAvailabilityProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryLocationAvailabilityProperty> argProperties) {
/* 457 */     if (this._properties == null) {
/* 458 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 460 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 463 */     for (IInventoryLocationAvailabilityProperty child : this._properties) {
/* 464 */       InventoryLocationAvailabilityPropertyModel model = (InventoryLocationAvailabilityPropertyModel)child;
/* 465 */       model.setOrganizationId_noev(getOrganizationId());
/* 466 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 467 */       model.setLocationId_noev(getLocationId());
/* 468 */       model.setAvailabilityCode_noev(getAvailabilityCode());
/* 469 */       if (child instanceof IDataModelImpl) {
/* 470 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 471 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 472 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 473 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 476 */       if (postEventsForChanges()) {
/* 477 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryLocationAvailabilityProperty(IInventoryLocationAvailabilityProperty argInventoryLocationAvailabilityProperty) {
/* 483 */     if (this._properties == null) {
/* 484 */       this._properties = new HistoricalList(null);
/*     */     }
/* 486 */     argInventoryLocationAvailabilityProperty.setOrganizationId(getOrganizationId());
/* 487 */     argInventoryLocationAvailabilityProperty.setRetailLocationId(getRetailLocationId());
/* 488 */     argInventoryLocationAvailabilityProperty.setLocationId(getLocationId());
/* 489 */     argInventoryLocationAvailabilityProperty.setAvailabilityCode(getAvailabilityCode());
/* 490 */     if (argInventoryLocationAvailabilityProperty instanceof IDataModelImpl) {
/* 491 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryLocationAvailabilityProperty).getDAO();
/* 492 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 493 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 494 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 499 */     if (postEventsForChanges()) {
/* 500 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationAvailabilityProperty));
/*     */     }
/*     */     
/* 503 */     this._properties.add(argInventoryLocationAvailabilityProperty);
/* 504 */     if (postEventsForChanges()) {
/* 505 */       this._events.post(IInventoryLocationAvailability.ADD_PROPERTIES, argInventoryLocationAvailabilityProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryLocationAvailabilityProperty(IInventoryLocationAvailabilityProperty argInventoryLocationAvailabilityProperty) {
/* 510 */     if (this._properties != null) {
/*     */       
/* 512 */       if (postEventsForChanges()) {
/* 513 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationAvailabilityProperty));
/*     */       }
/* 515 */       this._properties.remove(argInventoryLocationAvailabilityProperty);
/* 516 */       if (postEventsForChanges()) {
/* 517 */         this._events.post(IInventoryLocationAvailability.REMOVE_PROPERTIES, argInventoryLocationAvailabilityProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 524 */     if ("Privilege".equals(argFieldId)) {
/* 525 */       return getPrivilege();
/*     */     }
/* 527 */     if ("Properties".equals(argFieldId)) {
/* 528 */       return getProperties();
/*     */     }
/* 530 */     if ("InventoryLocationAvailabilityExtension".equals(argFieldId)) {
/* 531 */       return this._myExtension;
/*     */     }
/*     */     
/* 534 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 540 */     if ("Privilege".equals(argFieldId)) {
/* 541 */       setPrivilege((IPrivilege)argValue);
/*     */     }
/* 543 */     else if ("Properties".equals(argFieldId)) {
/* 544 */       setProperties(changeToList(argValue, IInventoryLocationAvailabilityProperty.class));
/*     */     }
/* 546 */     else if ("InventoryLocationAvailabilityExtension".equals(argFieldId)) {
/* 547 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 550 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 556 */     this._persistenceDefaults = argPD;
/* 557 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 558 */     this._eventManager = argEM;
/* 559 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 560 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 561 */     if (this._privilege != null) {
/* 562 */       ((IDataModelImpl)this._privilege).setDependencies(argPD, argEM);
/*     */     }
/* 564 */     if (this._properties != null) {
/* 565 */       for (IInventoryLocationAvailabilityProperty relationship : this._properties) {
/* 566 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryLocationAvailabilityExt() {
/* 572 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationAvailabilityExt(IDataModel argExt) {
/* 576 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 581 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 585 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 588 */     super.startTransaction();
/*     */     
/* 590 */     this._privilegeSavepoint = this._privilege;
/* 591 */     if (this._privilege != null) {
/* 592 */       this._privilege.startTransaction();
/*     */     }
/*     */     
/* 595 */     this._propertiesSavepoint = this._properties;
/* 596 */     if (this._properties != null) {
/* 597 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 598 */       Iterator<IDataModel> it = this._properties.iterator();
/* 599 */       while (it.hasNext()) {
/* 600 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 605 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 610 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 613 */     super.rollbackChanges();
/*     */     
/* 615 */     this._privilege = this._privilegeSavepoint;
/* 616 */     this._privilegeSavepoint = null;
/* 617 */     if (this._privilege != null) {
/* 618 */       this._privilege.rollbackChanges();
/*     */     }
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
/* 642 */     this._privilegeSavepoint = this._privilege;
/* 643 */     if (this._privilege != null) {
/* 644 */       this._privilege.commitTransaction();
/*     */     }
/*     */     
/* 647 */     this._propertiesSavepoint = this._properties;
/* 648 */     if (this._properties != null) {
/* 649 */       Iterator<IDataModel> it = this._properties.iterator();
/* 650 */       while (it.hasNext()) {
/* 651 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 653 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 657 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 662 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationAvailabilityModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */