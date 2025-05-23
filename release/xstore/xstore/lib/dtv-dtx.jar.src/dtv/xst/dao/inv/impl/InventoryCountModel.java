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
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryCount;
/*     */ import dtv.xst.dao.inv.IInventoryCountBucket;
/*     */ import dtv.xst.dao.inv.IInventoryCountProperty;
/*     */ import dtv.xst.dao.inv.InventoryCountPropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCountModel extends InventoryCountBaseModel implements IInventoryCount {
/*     */   private static final long serialVersionUID = -1061122765L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IInventoryCountBucket> _inventoryCountBuckets; private transient HistoricalList<IInventoryCountBucket> _inventoryCountBucketsSavepoint; private HistoricalList<IInventoryCountProperty> _properties; private transient HistoricalList<IInventoryCountProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new InventoryCountDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCountDAO getDAO_() {
/*  47 */     return (InventoryCountDAO)this._daoImpl;
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
/*  71 */       this._events.post(IInventoryCount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  84 */       if (this._inventoryCountBuckets != null) {
/*     */         
/*  86 */         Iterator<InventoryCountBucketModel> it = this._inventoryCountBuckets.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((InventoryCountBucketModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._properties != null) {
/*     */         
/*  94 */         Iterator<InventoryCountPropertyModel> it = this._properties.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((InventoryCountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 110 */     if (getDAO_().getRetailLocationId() != null) {
/* 111 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 114 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 123 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 124 */       this._events != null && 
/* 125 */       postEventsForChanges()) {
/* 126 */       this._events.post(IInventoryCount.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 133 */     boolean ev_postable = false;
/*     */     
/* 135 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 136 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 137 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 138 */       ev_postable = true;
/* 139 */       if (this._inventoryCountBuckets != null) {
/*     */         
/* 141 */         Iterator<InventoryCountBucketModel> it = this._inventoryCountBuckets.iterator();
/* 142 */         while (it.hasNext())
/*     */         {
/* 144 */           ((InventoryCountBucketModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/* 147 */       if (this._properties != null) {
/*     */         
/* 149 */         Iterator<InventoryCountPropertyModel> it = this._properties.iterator();
/* 150 */         while (it.hasNext())
/*     */         {
/* 152 */           ((InventoryCountPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryCountId() {
/* 165 */     return getDAO_().getInventoryCountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/* 173 */     if (setInventoryCountId_noev(argInventoryCountId) && 
/* 174 */       this._events != null && 
/* 175 */       postEventsForChanges()) {
/* 176 */       this._events.post(IInventoryCount.SET_INVENTORYCOUNTID, argInventoryCountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryCountId_noev(String argInventoryCountId) {
/* 183 */     boolean ev_postable = false;
/*     */     
/* 185 */     if ((getDAO_().getInventoryCountId() == null && argInventoryCountId != null) || (
/* 186 */       getDAO_().getInventoryCountId() != null && !getDAO_().getInventoryCountId().equals(argInventoryCountId))) {
/* 187 */       getDAO_().setInventoryCountId(argInventoryCountId);
/* 188 */       ev_postable = true;
/* 189 */       if (this._inventoryCountBuckets != null) {
/*     */         
/* 191 */         Iterator<InventoryCountBucketModel> it = this._inventoryCountBuckets.iterator();
/* 192 */         while (it.hasNext())
/*     */         {
/* 194 */           ((InventoryCountBucketModel)it.next()).setInventoryCountId_noev(argInventoryCountId);
/*     */         }
/*     */       } 
/* 197 */       if (this._properties != null) {
/*     */         
/* 199 */         Iterator<InventoryCountPropertyModel> it = this._properties.iterator();
/* 200 */         while (it.hasNext())
/*     */         {
/* 202 */           ((InventoryCountPropertyModel)it.next()).setInventoryCountId_noev(argInventoryCountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 207 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 215 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 223 */     if (setCreateDate_noev(argCreateDate) && 
/* 224 */       this._events != null && 
/* 225 */       postEventsForChanges()) {
/* 226 */       this._events.post(IInventoryCount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 233 */     boolean ev_postable = false;
/*     */     
/* 235 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 236 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 237 */       getDAO_().setCreateDate(argCreateDate);
/* 238 */       ev_postable = true;
/*     */     } 
/*     */     
/* 241 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 249 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 257 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 258 */       this._events != null && 
/* 259 */       postEventsForChanges()) {
/* 260 */       this._events.post(IInventoryCount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 267 */     boolean ev_postable = false;
/*     */     
/* 269 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 270 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 271 */       getDAO_().setCreateUserId(argCreateUserId);
/* 272 */       ev_postable = true;
/*     */     } 
/*     */     
/* 275 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 283 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 291 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 292 */       this._events != null && 
/* 293 */       postEventsForChanges()) {
/* 294 */       this._events.post(IInventoryCount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 301 */     boolean ev_postable = false;
/*     */     
/* 303 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 304 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 305 */       getDAO_().setUpdateDate(argUpdateDate);
/* 306 */       ev_postable = true;
/*     */     } 
/*     */     
/* 309 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 317 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 325 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 326 */       this._events != null && 
/* 327 */       postEventsForChanges()) {
/* 328 */       this._events.post(IInventoryCount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 335 */     boolean ev_postable = false;
/*     */     
/* 337 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 338 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 339 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 340 */       ev_postable = true;
/*     */     } 
/*     */     
/* 343 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 351 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 359 */     if (setDescription_noev(argDescription) && 
/* 360 */       this._events != null && 
/* 361 */       postEventsForChanges()) {
/* 362 */       this._events.post(IInventoryCount.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 369 */     boolean ev_postable = false;
/*     */     
/* 371 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 372 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 373 */       getDAO_().setDescription(argDescription);
/* 374 */       ev_postable = true;
/*     */     } 
/*     */     
/* 377 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 385 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 393 */     if (setTypeCode_noev(argTypeCode) && 
/* 394 */       this._events != null && 
/* 395 */       postEventsForChanges()) {
/* 396 */       this._events.post(IInventoryCount.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 403 */     boolean ev_postable = false;
/*     */     
/* 405 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 406 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 407 */       getDAO_().setTypeCode(argTypeCode);
/* 408 */       ev_postable = true;
/*     */     } 
/*     */     
/* 411 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDate() {
/* 419 */     return getDAO_().getBeginDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDate(Date argBeginDate) {
/* 427 */     if (setBeginDate_noev(argBeginDate) && 
/* 428 */       this._events != null && 
/* 429 */       postEventsForChanges()) {
/* 430 */       this._events.post(IInventoryCount.SET_BEGINDATE, argBeginDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBeginDate_noev(Date argBeginDate) {
/* 437 */     boolean ev_postable = false;
/*     */     
/* 439 */     if ((getDAO_().getBeginDate() == null && argBeginDate != null) || (
/* 440 */       getDAO_().getBeginDate() != null && !getDAO_().getBeginDate().equals(argBeginDate))) {
/* 441 */       getDAO_().setBeginDate(argBeginDate);
/* 442 */       ev_postable = true;
/*     */     } 
/*     */     
/* 445 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 453 */     return getDAO_().getEndDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 461 */     if (setEndDate_noev(argEndDate) && 
/* 462 */       this._events != null && 
/* 463 */       postEventsForChanges()) {
/* 464 */       this._events.post(IInventoryCount.SET_ENDDATE, argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndDate_noev(Date argEndDate) {
/* 471 */     boolean ev_postable = false;
/*     */     
/* 473 */     if ((getDAO_().getEndDate() == null && argEndDate != null) || (
/* 474 */       getDAO_().getEndDate() != null && !getDAO_().getEndDate().equals(argEndDate))) {
/* 475 */       getDAO_().setEndDate(argEndDate);
/* 476 */       ev_postable = true;
/*     */     } 
/*     */     
/* 479 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountStatus() {
/* 487 */     return getDAO_().getCountStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountStatus(String argCountStatus) {
/* 495 */     if (setCountStatus_noev(argCountStatus) && 
/* 496 */       this._events != null && 
/* 497 */       postEventsForChanges()) {
/* 498 */       this._events.post(IInventoryCount.SET_COUNTSTATUS, argCountStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountStatus_noev(String argCountStatus) {
/* 505 */     boolean ev_postable = false;
/*     */     
/* 507 */     if ((getDAO_().getCountStatus() == null && argCountStatus != null) || (
/* 508 */       getDAO_().getCountStatus() != null && !getDAO_().getCountStatus().equals(argCountStatus))) {
/* 509 */       getDAO_().setCountStatus(argCountStatus);
/* 510 */       ev_postable = true;
/*     */     } 
/*     */     
/* 513 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getStoreCreated() {
/* 521 */     if (getDAO_().getStoreCreated() != null) {
/* 522 */       return getDAO_().getStoreCreated().booleanValue();
/*     */     }
/*     */     
/* 525 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStoreCreated(boolean argStoreCreated) {
/* 534 */     if (setStoreCreated_noev(argStoreCreated) && 
/* 535 */       this._events != null && 
/* 536 */       postEventsForChanges()) {
/* 537 */       this._events.post(IInventoryCount.SET_STORECREATED, Boolean.valueOf(argStoreCreated));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStoreCreated_noev(boolean argStoreCreated) {
/* 544 */     boolean ev_postable = false;
/*     */     
/* 546 */     if ((getDAO_().getStoreCreated() == null && Boolean.valueOf(argStoreCreated) != null) || (
/* 547 */       getDAO_().getStoreCreated() != null && !getDAO_().getStoreCreated().equals(Boolean.valueOf(argStoreCreated)))) {
/* 548 */       getDAO_().setStoreCreated(Boolean.valueOf(argStoreCreated));
/* 549 */       ev_postable = true;
/*     */     } 
/*     */     
/* 552 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 560 */     if (getDAO_().getVoid() != null) {
/* 561 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 564 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 573 */     if (setVoid_noev(argVoid) && 
/* 574 */       this._events != null && 
/* 575 */       postEventsForChanges()) {
/* 576 */       this._events.post(IInventoryCount.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 583 */     boolean ev_postable = false;
/*     */     
/* 585 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 586 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 587 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 588 */       ev_postable = true;
/*     */     } 
/*     */     
/* 591 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCountProperty newProperty(String argPropertyName) {
/* 595 */     InventoryCountPropertyId id = new InventoryCountPropertyId();
/*     */     
/* 597 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 598 */     id.setInventoryCountId(getInventoryCountId());
/* 599 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 601 */     IInventoryCountProperty prop = (IInventoryCountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCountProperty.class);
/* 602 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "InventoryCountBuckets")
/*     */   public List<IInventoryCountBucket> getInventoryCountBuckets() {
/* 614 */     if (this._inventoryCountBuckets == null) {
/* 615 */       this._inventoryCountBuckets = new HistoricalList(null);
/*     */     }
/* 617 */     return (List<IInventoryCountBucket>)this._inventoryCountBuckets;
/*     */   }
/*     */   
/*     */   public void setInventoryCountBuckets(List<IInventoryCountBucket> argInventoryCountBuckets) {
/* 621 */     if (this._inventoryCountBuckets == null) {
/* 622 */       this._inventoryCountBuckets = new HistoricalList(argInventoryCountBuckets);
/*     */     } else {
/* 624 */       this._inventoryCountBuckets.setCurrentList(argInventoryCountBuckets);
/*     */     } 
/*     */     
/* 627 */     for (IInventoryCountBucket child : this._inventoryCountBuckets) {
/* 628 */       InventoryCountBucketModel model = (InventoryCountBucketModel)child;
/* 629 */       model.setOrganizationId_noev(getOrganizationId());
/* 630 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 631 */       model.setInventoryCountId_noev(getInventoryCountId());
/* 632 */       if (child instanceof IDataModelImpl) {
/* 633 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 634 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 635 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 636 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 639 */       if (postEventsForChanges()) {
/* 640 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountBucket(IInventoryCountBucket argInventoryCountBucket) {
/* 646 */     if (this._inventoryCountBuckets == null) {
/* 647 */       this._inventoryCountBuckets = new HistoricalList(null);
/*     */     }
/* 649 */     argInventoryCountBucket.setOrganizationId(getOrganizationId());
/* 650 */     argInventoryCountBucket.setRetailLocationId(getRetailLocationId());
/* 651 */     argInventoryCountBucket.setInventoryCountId(getInventoryCountId());
/* 652 */     if (argInventoryCountBucket instanceof IDataModelImpl) {
/* 653 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountBucket).getDAO();
/* 654 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 655 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 656 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 661 */     if (postEventsForChanges()) {
/* 662 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountBucket));
/*     */     }
/*     */     
/* 665 */     this._inventoryCountBuckets.add(argInventoryCountBucket);
/* 666 */     if (postEventsForChanges()) {
/* 667 */       this._events.post(IInventoryCount.ADD_INVENTORYCOUNTBUCKETS, argInventoryCountBucket);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountBucket(IInventoryCountBucket argInventoryCountBucket) {
/* 672 */     if (this._inventoryCountBuckets != null) {
/*     */       
/* 674 */       if (postEventsForChanges()) {
/* 675 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountBucket));
/*     */       }
/* 677 */       this._inventoryCountBuckets.remove(argInventoryCountBucket);
/* 678 */       if (postEventsForChanges()) {
/* 679 */         this._events.post(IInventoryCount.REMOVE_INVENTORYCOUNTBUCKETS, argInventoryCountBucket);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCountProperty> getProperties() {
/* 686 */     if (this._properties == null) {
/* 687 */       this._properties = new HistoricalList(null);
/*     */     }
/* 689 */     return (List<IInventoryCountProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCountProperty> argProperties) {
/* 693 */     if (this._properties == null) {
/* 694 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 696 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 699 */     for (IInventoryCountProperty child : this._properties) {
/* 700 */       InventoryCountPropertyModel model = (InventoryCountPropertyModel)child;
/* 701 */       model.setOrganizationId_noev(getOrganizationId());
/* 702 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 703 */       model.setInventoryCountId_noev(getInventoryCountId());
/* 704 */       if (child instanceof IDataModelImpl) {
/* 705 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 706 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 707 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 708 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 711 */       if (postEventsForChanges()) {
/* 712 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountProperty(IInventoryCountProperty argInventoryCountProperty) {
/* 718 */     if (this._properties == null) {
/* 719 */       this._properties = new HistoricalList(null);
/*     */     }
/* 721 */     argInventoryCountProperty.setOrganizationId(getOrganizationId());
/* 722 */     argInventoryCountProperty.setRetailLocationId(getRetailLocationId());
/* 723 */     argInventoryCountProperty.setInventoryCountId(getInventoryCountId());
/* 724 */     if (argInventoryCountProperty instanceof IDataModelImpl) {
/* 725 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountProperty).getDAO();
/* 726 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 727 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 728 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 733 */     if (postEventsForChanges()) {
/* 734 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountProperty));
/*     */     }
/*     */     
/* 737 */     this._properties.add(argInventoryCountProperty);
/* 738 */     if (postEventsForChanges()) {
/* 739 */       this._events.post(IInventoryCount.ADD_PROPERTIES, argInventoryCountProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountProperty(IInventoryCountProperty argInventoryCountProperty) {
/* 744 */     if (this._properties != null) {
/*     */       
/* 746 */       if (postEventsForChanges()) {
/* 747 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountProperty));
/*     */       }
/* 749 */       this._properties.remove(argInventoryCountProperty);
/* 750 */       if (postEventsForChanges()) {
/* 751 */         this._events.post(IInventoryCount.REMOVE_PROPERTIES, argInventoryCountProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 758 */     if ("InventoryCountBuckets".equals(argFieldId)) {
/* 759 */       return getInventoryCountBuckets();
/*     */     }
/* 761 */     if ("Properties".equals(argFieldId)) {
/* 762 */       return getProperties();
/*     */     }
/* 764 */     if ("InventoryCountExtension".equals(argFieldId)) {
/* 765 */       return this._myExtension;
/*     */     }
/*     */     
/* 768 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 774 */     if ("InventoryCountBuckets".equals(argFieldId)) {
/* 775 */       setInventoryCountBuckets(changeToList(argValue, IInventoryCountBucket.class));
/*     */     }
/* 777 */     else if ("Properties".equals(argFieldId)) {
/* 778 */       setProperties(changeToList(argValue, IInventoryCountProperty.class));
/*     */     }
/* 780 */     else if ("InventoryCountExtension".equals(argFieldId)) {
/* 781 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 784 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 790 */     this._persistenceDefaults = argPD;
/* 791 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 792 */     this._eventManager = argEM;
/* 793 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 794 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 795 */     if (this._inventoryCountBuckets != null) {
/* 796 */       for (IInventoryCountBucket relationship : this._inventoryCountBuckets) {
/* 797 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 800 */     if (this._properties != null) {
/* 801 */       for (IInventoryCountProperty relationship : this._properties) {
/* 802 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCountExt() {
/* 808 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCountExt(IDataModel argExt) {
/* 812 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 817 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 821 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 824 */     super.startTransaction();
/*     */     
/* 826 */     this._inventoryCountBucketsSavepoint = this._inventoryCountBuckets;
/* 827 */     if (this._inventoryCountBuckets != null) {
/* 828 */       this._inventoryCountBucketsSavepoint = new HistoricalList((List)this._inventoryCountBuckets);
/* 829 */       Iterator<IDataModel> it = this._inventoryCountBuckets.iterator();
/* 830 */       while (it.hasNext()) {
/* 831 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 835 */     this._propertiesSavepoint = this._properties;
/* 836 */     if (this._properties != null) {
/* 837 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 838 */       Iterator<IDataModel> it = this._properties.iterator();
/* 839 */       while (it.hasNext()) {
/* 840 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 845 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 850 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 853 */     super.rollbackChanges();
/*     */     
/* 855 */     this._inventoryCountBuckets = this._inventoryCountBucketsSavepoint;
/* 856 */     this._inventoryCountBucketsSavepoint = null;
/* 857 */     if (this._inventoryCountBuckets != null) {
/* 858 */       Iterator<IDataModel> it = this._inventoryCountBuckets.iterator();
/* 859 */       while (it.hasNext()) {
/* 860 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 864 */     this._properties = this._propertiesSavepoint;
/* 865 */     this._propertiesSavepoint = null;
/* 866 */     if (this._properties != null) {
/* 867 */       Iterator<IDataModel> it = this._properties.iterator();
/* 868 */       while (it.hasNext()) {
/* 869 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 877 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 880 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 883 */     super.commitTransaction();
/*     */     
/* 885 */     this._inventoryCountBucketsSavepoint = this._inventoryCountBuckets;
/* 886 */     if (this._inventoryCountBuckets != null) {
/* 887 */       Iterator<IDataModel> it = this._inventoryCountBuckets.iterator();
/* 888 */       while (it.hasNext()) {
/* 889 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 891 */       this._inventoryCountBuckets = new HistoricalList((List)this._inventoryCountBuckets);
/*     */     } 
/*     */     
/* 894 */     this._propertiesSavepoint = this._properties;
/* 895 */     if (this._properties != null) {
/* 896 */       Iterator<IDataModel> it = this._properties.iterator();
/* 897 */       while (it.hasNext()) {
/* 898 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 900 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 904 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */