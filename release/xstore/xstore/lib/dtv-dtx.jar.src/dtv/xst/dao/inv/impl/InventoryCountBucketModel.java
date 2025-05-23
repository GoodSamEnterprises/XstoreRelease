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
/*     */ import dtv.xst.dao.inv.IInventoryCountBucket;
/*     */ import dtv.xst.dao.inv.IInventoryCountBucketProperty;
/*     */ import dtv.xst.dao.inv.InventoryCountBucketPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCountBucketModel extends AbstractDataModelWithPropertyImpl<IInventoryCountBucketProperty> implements IInventoryCountBucket {
/*     */   private static final long serialVersionUID = 8376573L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IInventoryCountBucketProperty> _properties; private transient HistoricalList<IInventoryCountBucketProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new InventoryCountBucketDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCountBucketDAO getDAO_() {
/*  46 */     return (InventoryCountBucketDAO)this._daoImpl;
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
/*  70 */       this._events.post(IInventoryCountBucket.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<InventoryCountBucketPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((InventoryCountBucketPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IInventoryCountBucket.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<InventoryCountBucketPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((InventoryCountBucketPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public String getInventoryCountId() {
/* 148 */     return getDAO_().getInventoryCountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/* 156 */     if (setInventoryCountId_noev(argInventoryCountId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IInventoryCountBucket.SET_INVENTORYCOUNTID, argInventoryCountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryCountId_noev(String argInventoryCountId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getInventoryCountId() == null && argInventoryCountId != null) || (
/* 169 */       getDAO_().getInventoryCountId() != null && !getDAO_().getInventoryCountId().equals(argInventoryCountId))) {
/* 170 */       getDAO_().setInventoryCountId(argInventoryCountId);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<InventoryCountBucketPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((InventoryCountBucketPropertyModel)it.next()).setInventoryCountId_noev(argInventoryCountId);
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
/*     */   public String getInventoryBucketId() {
/* 190 */     return getDAO_().getInventoryBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 198 */     if (setInventoryBucketId_noev(argInventoryBucketId) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IInventoryCountBucket.SET_INVENTORYBUCKETID, argInventoryBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketId_noev(String argInventoryBucketId) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getInventoryBucketId() == null && argInventoryBucketId != null) || (
/* 211 */       getDAO_().getInventoryBucketId() != null && !getDAO_().getInventoryBucketId().equals(argInventoryBucketId))) {
/* 212 */       getDAO_().setInventoryBucketId(argInventoryBucketId);
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<InventoryCountBucketPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((InventoryCountBucketPropertyModel)it.next()).setInventoryBucketId_noev(argInventoryBucketId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 232 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 240 */     if (setCreateDate_noev(argCreateDate) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IInventoryCountBucket.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 253 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 254 */       getDAO_().setCreateDate(argCreateDate);
/* 255 */       ev_postable = true;
/*     */     } 
/*     */     
/* 258 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 266 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 274 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(IInventoryCountBucket.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 287 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 288 */       getDAO_().setCreateUserId(argCreateUserId);
/* 289 */       ev_postable = true;
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 300 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 308 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(IInventoryCountBucket.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 321 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 322 */       getDAO_().setUpdateDate(argUpdateDate);
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 334 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 342 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(IInventoryCountBucket.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 355 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 356 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 357 */       ev_postable = true;
/*     */     } 
/*     */     
/* 360 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCountCycle() {
/* 368 */     if (getDAO_().getCountCycle() != null) {
/* 369 */       return getDAO_().getCountCycle().intValue();
/*     */     }
/*     */     
/* 372 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountCycle(int argCountCycle) {
/* 381 */     if (setCountCycle_noev(argCountCycle) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IInventoryCountBucket.SET_COUNTCYCLE, Integer.valueOf(argCountCycle));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountCycle_noev(int argCountCycle) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getCountCycle() == null && Integer.valueOf(argCountCycle) != null) || (
/* 394 */       getDAO_().getCountCycle() != null && !getDAO_().getCountCycle().equals(Integer.valueOf(argCountCycle)))) {
/* 395 */       getDAO_().setCountCycle(Integer.valueOf(argCountCycle));
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
/*     */   public String getBucketStatus() {
/* 407 */     return getDAO_().getBucketStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBucketStatus(String argBucketStatus) {
/* 415 */     if (setBucketStatus_noev(argBucketStatus) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(IInventoryCountBucket.SET_BUCKETSTATUS, argBucketStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBucketStatus_noev(String argBucketStatus) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getBucketStatus() == null && argBucketStatus != null) || (
/* 428 */       getDAO_().getBucketStatus() != null && !getDAO_().getBucketStatus().equals(argBucketStatus))) {
/* 429 */       getDAO_().setBucketStatus(argBucketStatus);
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
/*     */   public String getInventoryBucketName() {
/* 441 */     return getDAO_().getInventoryBucketName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketName(String argInventoryBucketName) {
/* 449 */     if (setInventoryBucketName_noev(argInventoryBucketName) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(IInventoryCountBucket.SET_INVENTORYBUCKETNAME, argInventoryBucketName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketName_noev(String argInventoryBucketName) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getInventoryBucketName() == null && argInventoryBucketName != null) || (
/* 462 */       getDAO_().getInventoryBucketName() != null && !getDAO_().getInventoryBucketName().equals(argInventoryBucketName))) {
/* 463 */       getDAO_().setInventoryBucketName(argInventoryBucketName);
/* 464 */       ev_postable = true;
/*     */     } 
/*     */     
/* 467 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCountBucketProperty newProperty(String argPropertyName) {
/* 471 */     InventoryCountBucketPropertyId id = new InventoryCountBucketPropertyId();
/*     */     
/* 473 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 474 */     id.setInventoryCountId(getInventoryCountId());
/* 475 */     id.setInventoryBucketId(getInventoryBucketId());
/* 476 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 478 */     IInventoryCountBucketProperty prop = (IInventoryCountBucketProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCountBucketProperty.class);
/* 479 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCountBucketProperty> getProperties() {
/* 488 */     if (this._properties == null) {
/* 489 */       this._properties = new HistoricalList(null);
/*     */     }
/* 491 */     return (List<IInventoryCountBucketProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCountBucketProperty> argProperties) {
/* 495 */     if (this._properties == null) {
/* 496 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 498 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 501 */     for (IInventoryCountBucketProperty child : this._properties) {
/* 502 */       InventoryCountBucketPropertyModel model = (InventoryCountBucketPropertyModel)child;
/* 503 */       model.setOrganizationId_noev(getOrganizationId());
/* 504 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 505 */       model.setInventoryCountId_noev(getInventoryCountId());
/* 506 */       model.setInventoryBucketId_noev(getInventoryBucketId());
/* 507 */       if (child instanceof IDataModelImpl) {
/* 508 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 509 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 510 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 511 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 514 */       if (postEventsForChanges()) {
/* 515 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountBucketProperty(IInventoryCountBucketProperty argInventoryCountBucketProperty) {
/* 521 */     if (this._properties == null) {
/* 522 */       this._properties = new HistoricalList(null);
/*     */     }
/* 524 */     argInventoryCountBucketProperty.setOrganizationId(getOrganizationId());
/* 525 */     argInventoryCountBucketProperty.setRetailLocationId(getRetailLocationId());
/* 526 */     argInventoryCountBucketProperty.setInventoryCountId(getInventoryCountId());
/* 527 */     argInventoryCountBucketProperty.setInventoryBucketId(getInventoryBucketId());
/* 528 */     if (argInventoryCountBucketProperty instanceof IDataModelImpl) {
/* 529 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountBucketProperty).getDAO();
/* 530 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 531 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 532 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 537 */     if (postEventsForChanges()) {
/* 538 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountBucketProperty));
/*     */     }
/*     */     
/* 541 */     this._properties.add(argInventoryCountBucketProperty);
/* 542 */     if (postEventsForChanges()) {
/* 543 */       this._events.post(IInventoryCountBucket.ADD_PROPERTIES, argInventoryCountBucketProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountBucketProperty(IInventoryCountBucketProperty argInventoryCountBucketProperty) {
/* 548 */     if (this._properties != null) {
/*     */       
/* 550 */       if (postEventsForChanges()) {
/* 551 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountBucketProperty));
/*     */       }
/* 553 */       this._properties.remove(argInventoryCountBucketProperty);
/* 554 */       if (postEventsForChanges()) {
/* 555 */         this._events.post(IInventoryCountBucket.REMOVE_PROPERTIES, argInventoryCountBucketProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 562 */     if ("Properties".equals(argFieldId)) {
/* 563 */       return getProperties();
/*     */     }
/* 565 */     if ("InventoryCountBucketExtension".equals(argFieldId)) {
/* 566 */       return this._myExtension;
/*     */     }
/*     */     
/* 569 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 575 */     if ("Properties".equals(argFieldId)) {
/* 576 */       setProperties(changeToList(argValue, IInventoryCountBucketProperty.class));
/*     */     }
/* 578 */     else if ("InventoryCountBucketExtension".equals(argFieldId)) {
/* 579 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 582 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 588 */     this._persistenceDefaults = argPD;
/* 589 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 590 */     this._eventManager = argEM;
/* 591 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 592 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 593 */     if (this._properties != null) {
/* 594 */       for (IInventoryCountBucketProperty relationship : this._properties) {
/* 595 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCountBucketExt() {
/* 601 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCountBucketExt(IDataModel argExt) {
/* 605 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 610 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 614 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 617 */     super.startTransaction();
/*     */     
/* 619 */     this._propertiesSavepoint = this._properties;
/* 620 */     if (this._properties != null) {
/* 621 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 622 */       Iterator<IDataModel> it = this._properties.iterator();
/* 623 */       while (it.hasNext()) {
/* 624 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 629 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 634 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 637 */     super.rollbackChanges();
/*     */     
/* 639 */     this._properties = this._propertiesSavepoint;
/* 640 */     this._propertiesSavepoint = null;
/* 641 */     if (this._properties != null) {
/* 642 */       Iterator<IDataModel> it = this._properties.iterator();
/* 643 */       while (it.hasNext()) {
/* 644 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 652 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 655 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 658 */     super.commitTransaction();
/*     */     
/* 660 */     this._propertiesSavepoint = this._properties;
/* 661 */     if (this._properties != null) {
/* 662 */       Iterator<IDataModel> it = this._properties.iterator();
/* 663 */       while (it.hasNext()) {
/* 664 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 666 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 670 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 675 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountBucketModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */