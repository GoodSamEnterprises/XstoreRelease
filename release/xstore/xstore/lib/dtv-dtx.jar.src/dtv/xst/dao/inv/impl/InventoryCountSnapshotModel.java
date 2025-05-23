/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryCountSnapshot;
/*     */ import dtv.xst.dao.inv.IInventoryCountSnapshotProperty;
/*     */ import dtv.xst.dao.inv.InventoryCountSnapshotPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCountSnapshotModel extends AbstractDataModelWithPropertyImpl<IInventoryCountSnapshotProperty> implements IInventoryCountSnapshot {
/*     */   private static final long serialVersionUID = 1348133911L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IInventoryCountSnapshotProperty> _properties; private transient HistoricalList<IInventoryCountSnapshotProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new InventoryCountSnapshotDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCountSnapshotDAO getDAO_() {
/*  46 */     return (InventoryCountSnapshotDAO)this._daoImpl;
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
/*  70 */       this._events.post(IInventoryCountSnapshot.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<InventoryCountSnapshotPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((InventoryCountSnapshotPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IInventoryCountSnapshot.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<InventoryCountSnapshotPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((InventoryCountSnapshotPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 159 */       this._events.post(IInventoryCountSnapshot.SET_INVENTORYCOUNTID, argInventoryCountId);
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
/* 174 */         Iterator<InventoryCountSnapshotPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((InventoryCountSnapshotPropertyModel)it.next()).setInventoryCountId_noev(argInventoryCountId);
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
/*     */   public String getInventoryLocationId() {
/* 190 */     return getDAO_().getInventoryLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryLocationId(String argInventoryLocationId) {
/* 198 */     if (setInventoryLocationId_noev(argInventoryLocationId) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IInventoryCountSnapshot.SET_INVENTORYLOCATIONID, argInventoryLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryLocationId_noev(String argInventoryLocationId) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getInventoryLocationId() == null && argInventoryLocationId != null) || (
/* 211 */       getDAO_().getInventoryLocationId() != null && !getDAO_().getInventoryLocationId().equals(argInventoryLocationId))) {
/* 212 */       getDAO_().setInventoryLocationId(argInventoryLocationId);
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<InventoryCountSnapshotPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((InventoryCountSnapshotPropertyModel)it.next()).setInventoryLocationId_noev(argInventoryLocationId);
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
/*     */   public String getInventoryBucketId() {
/* 232 */     return getDAO_().getInventoryBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 240 */     if (setInventoryBucketId_noev(argInventoryBucketId) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IInventoryCountSnapshot.SET_INVENTORYBUCKETID, argInventoryBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketId_noev(String argInventoryBucketId) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getInventoryBucketId() == null && argInventoryBucketId != null) || (
/* 253 */       getDAO_().getInventoryBucketId() != null && !getDAO_().getInventoryBucketId().equals(argInventoryBucketId))) {
/* 254 */       getDAO_().setInventoryBucketId(argInventoryBucketId);
/* 255 */       ev_postable = true;
/* 256 */       if (this._properties != null) {
/*     */         
/* 258 */         Iterator<InventoryCountSnapshotPropertyModel> it = this._properties.iterator();
/* 259 */         while (it.hasNext())
/*     */         {
/* 261 */           ((InventoryCountSnapshotPropertyModel)it.next()).setInventoryBucketId_noev(argInventoryBucketId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 274 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 282 */     if (setItemId_noev(argItemId) && 
/* 283 */       this._events != null && 
/* 284 */       postEventsForChanges()) {
/* 285 */       this._events.post(IInventoryCountSnapshot.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 292 */     boolean ev_postable = false;
/*     */     
/* 294 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 295 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 296 */       getDAO_().setItemId(argItemId);
/* 297 */       ev_postable = true;
/* 298 */       if (this._properties != null) {
/*     */         
/* 300 */         Iterator<InventoryCountSnapshotPropertyModel> it = this._properties.iterator();
/* 301 */         while (it.hasNext())
/*     */         {
/* 303 */           ((InventoryCountSnapshotPropertyModel)it.next()).setItemId_noev(argItemId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 308 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 316 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 324 */     if (setCreateDate_noev(argCreateDate) && 
/* 325 */       this._events != null && 
/* 326 */       postEventsForChanges()) {
/* 327 */       this._events.post(IInventoryCountSnapshot.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 334 */     boolean ev_postable = false;
/*     */     
/* 336 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 337 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 338 */       getDAO_().setCreateDate(argCreateDate);
/* 339 */       ev_postable = true;
/*     */     } 
/*     */     
/* 342 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 350 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 358 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 359 */       this._events != null && 
/* 360 */       postEventsForChanges()) {
/* 361 */       this._events.post(IInventoryCountSnapshot.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 368 */     boolean ev_postable = false;
/*     */     
/* 370 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 371 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 372 */       getDAO_().setCreateUserId(argCreateUserId);
/* 373 */       ev_postable = true;
/*     */     } 
/*     */     
/* 376 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 384 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 392 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 393 */       this._events != null && 
/* 394 */       postEventsForChanges()) {
/* 395 */       this._events.post(IInventoryCountSnapshot.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 402 */     boolean ev_postable = false;
/*     */     
/* 404 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 405 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 406 */       getDAO_().setUpdateDate(argUpdateDate);
/* 407 */       ev_postable = true;
/*     */     } 
/*     */     
/* 410 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 418 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 426 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 427 */       this._events != null && 
/* 428 */       postEventsForChanges()) {
/* 429 */       this._events.post(IInventoryCountSnapshot.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 436 */     boolean ev_postable = false;
/*     */     
/* 438 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 439 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 440 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 441 */       ev_postable = true;
/*     */     } 
/*     */     
/* 444 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getSnapshotDate() {
/* 452 */     return getDAO_().getSnapshotDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSnapshotDate(Date argSnapshotDate) {
/* 460 */     if (setSnapshotDate_noev(argSnapshotDate) && 
/* 461 */       this._events != null && 
/* 462 */       postEventsForChanges()) {
/* 463 */       this._events.post(IInventoryCountSnapshot.SET_SNAPSHOTDATE, argSnapshotDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSnapshotDate_noev(Date argSnapshotDate) {
/* 470 */     boolean ev_postable = false;
/*     */     
/* 472 */     if ((getDAO_().getSnapshotDate() == null && argSnapshotDate != null) || (
/* 473 */       getDAO_().getSnapshotDate() != null && !getDAO_().getSnapshotDate().equals(argSnapshotDate))) {
/* 474 */       getDAO_().setSnapshotDate(argSnapshotDate);
/* 475 */       ev_postable = true;
/*     */     } 
/*     */     
/* 478 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 486 */     return getDAO_().getQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 494 */     if (setQuantity_noev(argQuantity) && 
/* 495 */       this._events != null && 
/* 496 */       postEventsForChanges()) {
/* 497 */       this._events.post(IInventoryCountSnapshot.SET_QUANTITY, argQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/* 504 */     boolean ev_postable = false;
/*     */     
/* 506 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/* 507 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/* 508 */       getDAO_().setQuantity(argQuantity);
/* 509 */       ev_postable = true;
/*     */     } 
/*     */     
/* 512 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCountSnapshotProperty newProperty(String argPropertyName) {
/* 516 */     InventoryCountSnapshotPropertyId id = new InventoryCountSnapshotPropertyId();
/*     */     
/* 518 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 519 */     id.setInventoryCountId(getInventoryCountId());
/* 520 */     id.setInventoryLocationId(getInventoryLocationId());
/* 521 */     id.setInventoryBucketId(getInventoryBucketId());
/* 522 */     id.setItemId(getItemId());
/* 523 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 525 */     IInventoryCountSnapshotProperty prop = (IInventoryCountSnapshotProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCountSnapshotProperty.class);
/* 526 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCountSnapshotProperty> getProperties() {
/* 535 */     if (this._properties == null) {
/* 536 */       this._properties = new HistoricalList(null);
/*     */     }
/* 538 */     return (List<IInventoryCountSnapshotProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCountSnapshotProperty> argProperties) {
/* 542 */     if (this._properties == null) {
/* 543 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 545 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 548 */     for (IInventoryCountSnapshotProperty child : this._properties) {
/* 549 */       InventoryCountSnapshotPropertyModel model = (InventoryCountSnapshotPropertyModel)child;
/* 550 */       model.setOrganizationId_noev(getOrganizationId());
/* 551 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 552 */       model.setInventoryCountId_noev(getInventoryCountId());
/* 553 */       model.setInventoryLocationId_noev(getInventoryLocationId());
/* 554 */       model.setInventoryBucketId_noev(getInventoryBucketId());
/* 555 */       model.setItemId_noev(getItemId());
/* 556 */       if (child instanceof IDataModelImpl) {
/* 557 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 558 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 559 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 560 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 563 */       if (postEventsForChanges()) {
/* 564 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountSnapshotProperty(IInventoryCountSnapshotProperty argInventoryCountSnapshotProperty) {
/* 570 */     if (this._properties == null) {
/* 571 */       this._properties = new HistoricalList(null);
/*     */     }
/* 573 */     argInventoryCountSnapshotProperty.setOrganizationId(getOrganizationId());
/* 574 */     argInventoryCountSnapshotProperty.setRetailLocationId(getRetailLocationId());
/* 575 */     argInventoryCountSnapshotProperty.setInventoryCountId(getInventoryCountId());
/* 576 */     argInventoryCountSnapshotProperty.setInventoryLocationId(getInventoryLocationId());
/* 577 */     argInventoryCountSnapshotProperty.setInventoryBucketId(getInventoryBucketId());
/* 578 */     argInventoryCountSnapshotProperty.setItemId(getItemId());
/* 579 */     if (argInventoryCountSnapshotProperty instanceof IDataModelImpl) {
/* 580 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountSnapshotProperty).getDAO();
/* 581 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 582 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 583 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 588 */     if (postEventsForChanges()) {
/* 589 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSnapshotProperty));
/*     */     }
/*     */     
/* 592 */     this._properties.add(argInventoryCountSnapshotProperty);
/* 593 */     if (postEventsForChanges()) {
/* 594 */       this._events.post(IInventoryCountSnapshot.ADD_PROPERTIES, argInventoryCountSnapshotProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountSnapshotProperty(IInventoryCountSnapshotProperty argInventoryCountSnapshotProperty) {
/* 599 */     if (this._properties != null) {
/*     */       
/* 601 */       if (postEventsForChanges()) {
/* 602 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSnapshotProperty));
/*     */       }
/* 604 */       this._properties.remove(argInventoryCountSnapshotProperty);
/* 605 */       if (postEventsForChanges()) {
/* 606 */         this._events.post(IInventoryCountSnapshot.REMOVE_PROPERTIES, argInventoryCountSnapshotProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 613 */     if ("Properties".equals(argFieldId)) {
/* 614 */       return getProperties();
/*     */     }
/* 616 */     if ("InventoryCountSnapshotExtension".equals(argFieldId)) {
/* 617 */       return this._myExtension;
/*     */     }
/*     */     
/* 620 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 626 */     if ("Properties".equals(argFieldId)) {
/* 627 */       setProperties(changeToList(argValue, IInventoryCountSnapshotProperty.class));
/*     */     }
/* 629 */     else if ("InventoryCountSnapshotExtension".equals(argFieldId)) {
/* 630 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 633 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 639 */     this._persistenceDefaults = argPD;
/* 640 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 641 */     this._eventManager = argEM;
/* 642 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 643 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 644 */     if (this._properties != null) {
/* 645 */       for (IInventoryCountSnapshotProperty relationship : this._properties) {
/* 646 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCountSnapshotExt() {
/* 652 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCountSnapshotExt(IDataModel argExt) {
/* 656 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 661 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 665 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 668 */     super.startTransaction();
/*     */     
/* 670 */     this._propertiesSavepoint = this._properties;
/* 671 */     if (this._properties != null) {
/* 672 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 673 */       Iterator<IDataModel> it = this._properties.iterator();
/* 674 */       while (it.hasNext()) {
/* 675 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 680 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 685 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 688 */     super.rollbackChanges();
/*     */     
/* 690 */     this._properties = this._propertiesSavepoint;
/* 691 */     this._propertiesSavepoint = null;
/* 692 */     if (this._properties != null) {
/* 693 */       Iterator<IDataModel> it = this._properties.iterator();
/* 694 */       while (it.hasNext()) {
/* 695 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 703 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 706 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 709 */     super.commitTransaction();
/*     */     
/* 711 */     this._propertiesSavepoint = this._properties;
/* 712 */     if (this._properties != null) {
/* 713 */       Iterator<IDataModel> it = this._properties.iterator();
/* 714 */       while (it.hasNext()) {
/* 715 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 717 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */     
/* 720 */     getDAO_().setInitQuantity(getQuantity());
/*     */ 
/*     */     
/* 723 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 728 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSnapshotModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */