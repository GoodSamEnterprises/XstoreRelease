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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryLocation;
/*     */ import dtv.xst.dao.inv.IInventoryLocationAvailability;
/*     */ import dtv.xst.dao.inv.IInventoryLocationBucket;
/*     */ import dtv.xst.dao.inv.IInventoryLocationProperty;
/*     */ import dtv.xst.dao.inv.InventoryLocationPropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryLocationModel extends InventoryLocationBaseModel implements IInventoryLocation {
/*     */   private static final long serialVersionUID = 1324171537L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IInventoryLocationBucket> _inventoryLocationBuckets;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient HistoricalList<IInventoryLocationBucket> _inventoryLocationBucketsSavepoint; private HistoricalList<IInventoryLocationAvailability> _availabilityCodes; private transient HistoricalList<IInventoryLocationAvailability> _availabilityCodesSavepoint; private HistoricalList<IInventoryLocationProperty> _properties; private transient HistoricalList<IInventoryLocationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new InventoryLocationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryLocationDAO getDAO_() {
/*  47 */     return (InventoryLocationDAO)this._daoImpl;
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
/*  71 */       this._events.post(IInventoryLocation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  84 */       if (this._inventoryLocationBuckets != null) {
/*     */         
/*  86 */         Iterator<InventoryLocationBucketModel> it = this._inventoryLocationBuckets.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((InventoryLocationBucketModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._availabilityCodes != null) {
/*     */         
/*  94 */         Iterator<InventoryLocationAvailabilityModel> it = this._availabilityCodes.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((InventoryLocationAvailabilityModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/* 100 */       if (this._properties != null) {
/*     */         
/* 102 */         Iterator<InventoryLocationPropertyModel> it = this._properties.iterator();
/* 103 */         while (it.hasNext())
/*     */         {
/* 105 */           ((InventoryLocationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 118 */     if (getDAO_().getRetailLocationId() != null) {
/* 119 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 122 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 131 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 132 */       this._events != null && 
/* 133 */       postEventsForChanges()) {
/* 134 */       this._events.post(IInventoryLocation.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 141 */     boolean ev_postable = false;
/*     */     
/* 143 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 144 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 145 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 146 */       ev_postable = true;
/* 147 */       if (this._inventoryLocationBuckets != null) {
/*     */         
/* 149 */         Iterator<InventoryLocationBucketModel> it = this._inventoryLocationBuckets.iterator();
/* 150 */         while (it.hasNext())
/*     */         {
/* 152 */           ((InventoryLocationBucketModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/* 155 */       if (this._availabilityCodes != null) {
/*     */         
/* 157 */         Iterator<InventoryLocationAvailabilityModel> it = this._availabilityCodes.iterator();
/* 158 */         while (it.hasNext())
/*     */         {
/* 160 */           ((InventoryLocationAvailabilityModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/* 163 */       if (this._properties != null) {
/*     */         
/* 165 */         Iterator<InventoryLocationPropertyModel> it = this._properties.iterator();
/* 166 */         while (it.hasNext())
/*     */         {
/* 168 */           ((InventoryLocationPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 173 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationId() {
/* 181 */     return getDAO_().getLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 189 */     if (setLocationId_noev(argLocationId) && 
/* 190 */       this._events != null && 
/* 191 */       postEventsForChanges()) {
/* 192 */       this._events.post(IInventoryLocation.SET_LOCATIONID, argLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationId_noev(String argLocationId) {
/* 199 */     boolean ev_postable = false;
/*     */     
/* 201 */     if ((getDAO_().getLocationId() == null && argLocationId != null) || (
/* 202 */       getDAO_().getLocationId() != null && !getDAO_().getLocationId().equals(argLocationId))) {
/* 203 */       getDAO_().setLocationId(argLocationId);
/* 204 */       ev_postable = true;
/* 205 */       if (this._inventoryLocationBuckets != null) {
/*     */         
/* 207 */         Iterator<InventoryLocationBucketModel> it = this._inventoryLocationBuckets.iterator();
/* 208 */         while (it.hasNext())
/*     */         {
/* 210 */           ((InventoryLocationBucketModel)it.next()).setLocationId_noev(argLocationId);
/*     */         }
/*     */       } 
/* 213 */       if (this._availabilityCodes != null) {
/*     */         
/* 215 */         Iterator<InventoryLocationAvailabilityModel> it = this._availabilityCodes.iterator();
/* 216 */         while (it.hasNext())
/*     */         {
/* 218 */           ((InventoryLocationAvailabilityModel)it.next()).setLocationId_noev(argLocationId);
/*     */         }
/*     */       } 
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<InventoryLocationPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((InventoryLocationPropertyModel)it.next()).setLocationId_noev(argLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 239 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 247 */     if (setCreateDate_noev(argCreateDate) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(IInventoryLocation.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 260 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 261 */       getDAO_().setCreateDate(argCreateDate);
/* 262 */       ev_postable = true;
/*     */     } 
/*     */     
/* 265 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 273 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 281 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 282 */       this._events != null && 
/* 283 */       postEventsForChanges()) {
/* 284 */       this._events.post(IInventoryLocation.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 291 */     boolean ev_postable = false;
/*     */     
/* 293 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 294 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 295 */       getDAO_().setCreateUserId(argCreateUserId);
/* 296 */       ev_postable = true;
/*     */     } 
/*     */     
/* 299 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 307 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 315 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 316 */       this._events != null && 
/* 317 */       postEventsForChanges()) {
/* 318 */       this._events.post(IInventoryLocation.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 325 */     boolean ev_postable = false;
/*     */     
/* 327 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 328 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 329 */       getDAO_().setUpdateDate(argUpdateDate);
/* 330 */       ev_postable = true;
/*     */     } 
/*     */     
/* 333 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 341 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 349 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 350 */       this._events != null && 
/* 351 */       postEventsForChanges()) {
/* 352 */       this._events.post(IInventoryLocation.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 359 */     boolean ev_postable = false;
/*     */     
/* 361 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 362 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 363 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 364 */       ev_postable = true;
/*     */     } 
/*     */     
/* 367 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 375 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 383 */     if (setName_noev(argName) && 
/* 384 */       this._events != null && 
/* 385 */       postEventsForChanges()) {
/* 386 */       this._events.post(IInventoryLocation.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 393 */     boolean ev_postable = false;
/*     */     
/* 395 */     if ((getDAO_().getName() == null && argName != null) || (
/* 396 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 397 */       getDAO_().setName(argName);
/* 398 */       ev_postable = true;
/*     */     } 
/*     */     
/* 401 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSystemLocation() {
/* 409 */     if (getDAO_().getSystemLocation() != null) {
/* 410 */       return getDAO_().getSystemLocation().booleanValue();
/*     */     }
/*     */     
/* 413 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSystemLocation(boolean argSystemLocation) {
/* 422 */     if (setSystemLocation_noev(argSystemLocation) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(IInventoryLocation.SET_SYSTEMLOCATION, Boolean.valueOf(argSystemLocation));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSystemLocation_noev(boolean argSystemLocation) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getSystemLocation() == null && Boolean.valueOf(argSystemLocation) != null) || (
/* 435 */       getDAO_().getSystemLocation() != null && !getDAO_().getSystemLocation().equals(Boolean.valueOf(argSystemLocation)))) {
/* 436 */       getDAO_().setSystemLocation(Boolean.valueOf(argSystemLocation));
/* 437 */       ev_postable = true;
/*     */     } 
/*     */     
/* 440 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getActive() {
/* 448 */     if (getDAO_().getActive() != null) {
/* 449 */       return getDAO_().getActive().booleanValue();
/*     */     }
/*     */     
/* 452 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActive(boolean argActive) {
/* 461 */     if (setActive_noev(argActive) && 
/* 462 */       this._events != null && 
/* 463 */       postEventsForChanges()) {
/* 464 */       this._events.post(IInventoryLocation.SET_ACTIVE, Boolean.valueOf(argActive));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActive_noev(boolean argActive) {
/* 471 */     boolean ev_postable = false;
/*     */     
/* 473 */     if ((getDAO_().getActive() == null && Boolean.valueOf(argActive) != null) || (
/* 474 */       getDAO_().getActive() != null && !getDAO_().getActive().equals(Boolean.valueOf(argActive)))) {
/* 475 */       getDAO_().setActive(Boolean.valueOf(argActive));
/* 476 */       ev_postable = true;
/*     */     } 
/*     */     
/* 479 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryLocationProperty newProperty(String argPropertyName) {
/* 483 */     InventoryLocationPropertyId id = new InventoryLocationPropertyId();
/*     */     
/* 485 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 486 */     id.setLocationId(getLocationId());
/* 487 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 489 */     IInventoryLocationProperty prop = (IInventoryLocationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryLocationProperty.class);
/* 490 */     return prop;
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
/*     */   @Relationship(name = "InventoryLocationBuckets")
/*     */   public List<IInventoryLocationBucket> getInventoryLocationBuckets() {
/* 505 */     if (this._inventoryLocationBuckets == null) {
/* 506 */       this._inventoryLocationBuckets = new HistoricalList(null);
/*     */     }
/* 508 */     return (List<IInventoryLocationBucket>)this._inventoryLocationBuckets;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationBuckets(List<IInventoryLocationBucket> argInventoryLocationBuckets) {
/* 512 */     if (this._inventoryLocationBuckets == null) {
/* 513 */       this._inventoryLocationBuckets = new HistoricalList(argInventoryLocationBuckets);
/*     */     } else {
/* 515 */       this._inventoryLocationBuckets.setCurrentList(argInventoryLocationBuckets);
/*     */     } 
/*     */     
/* 518 */     for (IInventoryLocationBucket child : this._inventoryLocationBuckets) {
/* 519 */       child.setParentLocation(this);
/*     */     }
/*     */ 
/*     */     
/* 523 */     for (IInventoryLocationBucket child : this._inventoryLocationBuckets) {
/* 524 */       InventoryLocationBucketModel model = (InventoryLocationBucketModel)child;
/* 525 */       model.setOrganizationId_noev(getOrganizationId());
/* 526 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 527 */       model.setLocationId_noev(getLocationId());
/* 528 */       if (child instanceof IDataModelImpl) {
/* 529 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 530 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 531 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 532 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 535 */       if (postEventsForChanges()) {
/* 536 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addInventoryLocationBucket(IInventoryLocationBucket argInventoryLocationBucket) {
/* 543 */     argInventoryLocationBucket.setParentLocation(this);
/* 544 */     if (this._inventoryLocationBuckets == null) {
/* 545 */       this._inventoryLocationBuckets = new HistoricalList(null);
/*     */     }
/* 547 */     argInventoryLocationBucket.setOrganizationId(getOrganizationId());
/* 548 */     argInventoryLocationBucket.setRetailLocationId(getRetailLocationId());
/* 549 */     argInventoryLocationBucket.setLocationId(getLocationId());
/* 550 */     if (argInventoryLocationBucket instanceof IDataModelImpl) {
/* 551 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryLocationBucket).getDAO();
/* 552 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 553 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 554 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 559 */     if (postEventsForChanges()) {
/* 560 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationBucket));
/*     */     }
/*     */     
/* 563 */     this._inventoryLocationBuckets.add(argInventoryLocationBucket);
/* 564 */     if (postEventsForChanges()) {
/* 565 */       this._events.post(IInventoryLocation.ADD_INVENTORYLOCATIONBUCKETS, argInventoryLocationBucket);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryLocationBucket(IInventoryLocationBucket argInventoryLocationBucket) {
/* 570 */     if (this._inventoryLocationBuckets != null) {
/*     */       
/* 572 */       if (postEventsForChanges()) {
/* 573 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationBucket));
/*     */       }
/* 575 */       this._inventoryLocationBuckets.remove(argInventoryLocationBucket);
/*     */       
/* 577 */       argInventoryLocationBucket.setParentLocation(null);
/* 578 */       if (postEventsForChanges()) {
/* 579 */         this._events.post(IInventoryLocation.REMOVE_INVENTORYLOCATIONBUCKETS, argInventoryLocationBucket);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "AvailabilityCodes")
/*     */   public List<IInventoryLocationAvailability> getAvailabilityCodes() {
/* 586 */     if (this._availabilityCodes == null) {
/* 587 */       this._availabilityCodes = new HistoricalList(null);
/*     */     }
/* 589 */     return (List<IInventoryLocationAvailability>)this._availabilityCodes;
/*     */   }
/*     */   
/*     */   public void setAvailabilityCodes(List<IInventoryLocationAvailability> argAvailabilityCodes) {
/* 593 */     if (this._availabilityCodes == null) {
/* 594 */       this._availabilityCodes = new HistoricalList(argAvailabilityCodes);
/*     */     } else {
/* 596 */       this._availabilityCodes.setCurrentList(argAvailabilityCodes);
/*     */     } 
/*     */     
/* 599 */     for (IInventoryLocationAvailability child : this._availabilityCodes) {
/* 600 */       InventoryLocationAvailabilityModel model = (InventoryLocationAvailabilityModel)child;
/* 601 */       model.setOrganizationId_noev(getOrganizationId());
/* 602 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 603 */       model.setLocationId_noev(getLocationId());
/* 604 */       if (child instanceof IDataModelImpl) {
/* 605 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 606 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 607 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 608 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 611 */       if (postEventsForChanges()) {
/* 612 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryLocationAvailability(IInventoryLocationAvailability argInventoryLocationAvailability) {
/* 618 */     if (this._availabilityCodes == null) {
/* 619 */       this._availabilityCodes = new HistoricalList(null);
/*     */     }
/* 621 */     argInventoryLocationAvailability.setOrganizationId(getOrganizationId());
/* 622 */     argInventoryLocationAvailability.setRetailLocationId(getRetailLocationId());
/* 623 */     argInventoryLocationAvailability.setLocationId(getLocationId());
/* 624 */     if (argInventoryLocationAvailability instanceof IDataModelImpl) {
/* 625 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryLocationAvailability).getDAO();
/* 626 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 627 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 628 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 633 */     if (postEventsForChanges()) {
/* 634 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationAvailability));
/*     */     }
/*     */     
/* 637 */     this._availabilityCodes.add(argInventoryLocationAvailability);
/* 638 */     if (postEventsForChanges()) {
/* 639 */       this._events.post(IInventoryLocation.ADD_AVAILABILITYCODES, argInventoryLocationAvailability);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryLocationAvailability(IInventoryLocationAvailability argInventoryLocationAvailability) {
/* 644 */     if (this._availabilityCodes != null) {
/*     */       
/* 646 */       if (postEventsForChanges()) {
/* 647 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationAvailability));
/*     */       }
/* 649 */       this._availabilityCodes.remove(argInventoryLocationAvailability);
/* 650 */       if (postEventsForChanges()) {
/* 651 */         this._events.post(IInventoryLocation.REMOVE_AVAILABILITYCODES, argInventoryLocationAvailability);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryLocationProperty> getProperties() {
/* 658 */     if (this._properties == null) {
/* 659 */       this._properties = new HistoricalList(null);
/*     */     }
/* 661 */     return (List<IInventoryLocationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryLocationProperty> argProperties) {
/* 665 */     if (this._properties == null) {
/* 666 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 668 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 671 */     for (IInventoryLocationProperty child : this._properties) {
/* 672 */       InventoryLocationPropertyModel model = (InventoryLocationPropertyModel)child;
/* 673 */       model.setOrganizationId_noev(getOrganizationId());
/* 674 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 675 */       model.setLocationId_noev(getLocationId());
/* 676 */       if (child instanceof IDataModelImpl) {
/* 677 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 678 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 679 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 680 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 683 */       if (postEventsForChanges()) {
/* 684 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryLocationProperty(IInventoryLocationProperty argInventoryLocationProperty) {
/* 690 */     if (this._properties == null) {
/* 691 */       this._properties = new HistoricalList(null);
/*     */     }
/* 693 */     argInventoryLocationProperty.setOrganizationId(getOrganizationId());
/* 694 */     argInventoryLocationProperty.setRetailLocationId(getRetailLocationId());
/* 695 */     argInventoryLocationProperty.setLocationId(getLocationId());
/* 696 */     if (argInventoryLocationProperty instanceof IDataModelImpl) {
/* 697 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryLocationProperty).getDAO();
/* 698 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 699 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 700 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 705 */     if (postEventsForChanges()) {
/* 706 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationProperty));
/*     */     }
/*     */     
/* 709 */     this._properties.add(argInventoryLocationProperty);
/* 710 */     if (postEventsForChanges()) {
/* 711 */       this._events.post(IInventoryLocation.ADD_PROPERTIES, argInventoryLocationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryLocationProperty(IInventoryLocationProperty argInventoryLocationProperty) {
/* 716 */     if (this._properties != null) {
/*     */       
/* 718 */       if (postEventsForChanges()) {
/* 719 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryLocationProperty));
/*     */       }
/* 721 */       this._properties.remove(argInventoryLocationProperty);
/* 722 */       if (postEventsForChanges()) {
/* 723 */         this._events.post(IInventoryLocation.REMOVE_PROPERTIES, argInventoryLocationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 730 */     if ("InventoryLocationBuckets".equals(argFieldId)) {
/* 731 */       return getInventoryLocationBuckets();
/*     */     }
/* 733 */     if ("AvailabilityCodes".equals(argFieldId)) {
/* 734 */       return getAvailabilityCodes();
/*     */     }
/* 736 */     if ("Properties".equals(argFieldId)) {
/* 737 */       return getProperties();
/*     */     }
/* 739 */     if ("InventoryLocationExtension".equals(argFieldId)) {
/* 740 */       return this._myExtension;
/*     */     }
/*     */     
/* 743 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 749 */     if ("InventoryLocationBuckets".equals(argFieldId)) {
/* 750 */       setInventoryLocationBuckets(changeToList(argValue, IInventoryLocationBucket.class));
/*     */     }
/* 752 */     else if ("AvailabilityCodes".equals(argFieldId)) {
/* 753 */       setAvailabilityCodes(changeToList(argValue, IInventoryLocationAvailability.class));
/*     */     }
/* 755 */     else if ("Properties".equals(argFieldId)) {
/* 756 */       setProperties(changeToList(argValue, IInventoryLocationProperty.class));
/*     */     }
/* 758 */     else if ("InventoryLocationExtension".equals(argFieldId)) {
/* 759 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 762 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 768 */     this._persistenceDefaults = argPD;
/* 769 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 770 */     this._eventManager = argEM;
/* 771 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 772 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 773 */     if (this._inventoryLocationBuckets != null) {
/* 774 */       for (IInventoryLocationBucket relationship : this._inventoryLocationBuckets) {
/* 775 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 778 */     if (this._availabilityCodes != null) {
/* 779 */       for (IInventoryLocationAvailability relationship : this._availabilityCodes) {
/* 780 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 783 */     if (this._properties != null) {
/* 784 */       for (IInventoryLocationProperty relationship : this._properties) {
/* 785 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryLocationExt() {
/* 791 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationExt(IDataModel argExt) {
/* 795 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 800 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 804 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 807 */     super.startTransaction();
/*     */     
/* 809 */     this._inventoryLocationBucketsSavepoint = this._inventoryLocationBuckets;
/* 810 */     if (this._inventoryLocationBuckets != null) {
/* 811 */       this._inventoryLocationBucketsSavepoint = new HistoricalList((List)this._inventoryLocationBuckets);
/* 812 */       Iterator<IDataModel> it = this._inventoryLocationBuckets.iterator();
/* 813 */       while (it.hasNext()) {
/* 814 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 818 */     this._availabilityCodesSavepoint = this._availabilityCodes;
/* 819 */     if (this._availabilityCodes != null) {
/* 820 */       this._availabilityCodesSavepoint = new HistoricalList((List)this._availabilityCodes);
/* 821 */       Iterator<IDataModel> it = this._availabilityCodes.iterator();
/* 822 */       while (it.hasNext()) {
/* 823 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 827 */     this._propertiesSavepoint = this._properties;
/* 828 */     if (this._properties != null) {
/* 829 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 830 */       Iterator<IDataModel> it = this._properties.iterator();
/* 831 */       while (it.hasNext()) {
/* 832 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 837 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 842 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 845 */     super.rollbackChanges();
/*     */     
/* 847 */     this._inventoryLocationBuckets = this._inventoryLocationBucketsSavepoint;
/* 848 */     this._inventoryLocationBucketsSavepoint = null;
/* 849 */     if (this._inventoryLocationBuckets != null) {
/* 850 */       Iterator<IDataModel> it = this._inventoryLocationBuckets.iterator();
/* 851 */       while (it.hasNext()) {
/* 852 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 856 */     this._availabilityCodes = this._availabilityCodesSavepoint;
/* 857 */     this._availabilityCodesSavepoint = null;
/* 858 */     if (this._availabilityCodes != null) {
/* 859 */       Iterator<IDataModel> it = this._availabilityCodes.iterator();
/* 860 */       while (it.hasNext()) {
/* 861 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 865 */     this._properties = this._propertiesSavepoint;
/* 866 */     this._propertiesSavepoint = null;
/* 867 */     if (this._properties != null) {
/* 868 */       Iterator<IDataModel> it = this._properties.iterator();
/* 869 */       while (it.hasNext()) {
/* 870 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 878 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 881 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 884 */     super.commitTransaction();
/*     */     
/* 886 */     this._inventoryLocationBucketsSavepoint = this._inventoryLocationBuckets;
/* 887 */     if (this._inventoryLocationBuckets != null) {
/* 888 */       Iterator<IDataModel> it = this._inventoryLocationBuckets.iterator();
/* 889 */       while (it.hasNext()) {
/* 890 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 892 */       this._inventoryLocationBuckets = new HistoricalList((List)this._inventoryLocationBuckets);
/*     */     } 
/*     */     
/* 895 */     this._availabilityCodesSavepoint = this._availabilityCodes;
/* 896 */     if (this._availabilityCodes != null) {
/* 897 */       Iterator<IDataModel> it = this._availabilityCodes.iterator();
/* 898 */       while (it.hasNext()) {
/* 899 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 901 */       this._availabilityCodes = new HistoricalList((List)this._availabilityCodes);
/*     */     } 
/*     */     
/* 904 */     this._propertiesSavepoint = this._properties;
/* 905 */     if (this._properties != null) {
/* 906 */       Iterator<IDataModel> it = this._properties.iterator();
/* 907 */       while (it.hasNext()) {
/* 908 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 910 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 914 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */