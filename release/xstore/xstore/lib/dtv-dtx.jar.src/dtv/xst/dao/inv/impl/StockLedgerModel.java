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
/*     */ import dtv.xst.dao.inv.IStockLedger;
/*     */ import dtv.xst.dao.inv.IStockLedgerProperty;
/*     */ import dtv.xst.dao.inv.StockLedgerPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class StockLedgerModel extends AbstractDataModelWithPropertyImpl<IStockLedgerProperty> implements IStockLedger {
/*     */   private static final long serialVersionUID = 282529791L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IStockLedgerProperty> _properties; private transient HistoricalList<IStockLedgerProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new StockLedgerDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StockLedgerDAO getDAO_() {
/*  46 */     return (StockLedgerDAO)this._daoImpl;
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
/*  70 */       this._events.post(IStockLedger.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<StockLedgerPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((StockLedgerPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IStockLedger.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<StockLedgerPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((StockLedgerPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public String getBucketId() {
/* 148 */     return getDAO_().getBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/* 156 */     if (setBucketId_noev(argBucketId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IStockLedger.SET_BUCKETID, argBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBucketId_noev(String argBucketId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getBucketId() == null && argBucketId != null) || (
/* 169 */       getDAO_().getBucketId() != null && !getDAO_().getBucketId().equals(argBucketId))) {
/* 170 */       getDAO_().setBucketId(argBucketId);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<StockLedgerPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((StockLedgerPropertyModel)it.next()).setBucketId_noev(argBucketId);
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
/*     */   public String getInvLocationId() {
/* 190 */     return getDAO_().getInvLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/* 198 */     if (setInvLocationId_noev(argInvLocationId) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IStockLedger.SET_INVLOCATIONID, argInvLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvLocationId_noev(String argInvLocationId) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getInvLocationId() == null && argInvLocationId != null) || (
/* 211 */       getDAO_().getInvLocationId() != null && !getDAO_().getInvLocationId().equals(argInvLocationId))) {
/* 212 */       getDAO_().setInvLocationId(argInvLocationId);
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<StockLedgerPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((StockLedgerPropertyModel)it.next()).setInvLocationId_noev(argInvLocationId);
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
/*     */   public String getItemId() {
/* 232 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 240 */     if (setItemId_noev(argItemId) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IStockLedger.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 253 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 254 */       getDAO_().setItemId(argItemId);
/* 255 */       ev_postable = true;
/* 256 */       if (this._properties != null) {
/*     */         
/* 258 */         Iterator<StockLedgerPropertyModel> it = this._properties.iterator();
/* 259 */         while (it.hasNext())
/*     */         {
/* 261 */           ((StockLedgerPropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public Date getCreateDate() {
/* 274 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 282 */     if (setCreateDate_noev(argCreateDate) && 
/* 283 */       this._events != null && 
/* 284 */       postEventsForChanges()) {
/* 285 */       this._events.post(IStockLedger.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 292 */     boolean ev_postable = false;
/*     */     
/* 294 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 295 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 296 */       getDAO_().setCreateDate(argCreateDate);
/* 297 */       ev_postable = true;
/*     */     } 
/*     */     
/* 300 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 308 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 316 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 317 */       this._events != null && 
/* 318 */       postEventsForChanges()) {
/* 319 */       this._events.post(IStockLedger.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 326 */     boolean ev_postable = false;
/*     */     
/* 328 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 329 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 330 */       getDAO_().setCreateUserId(argCreateUserId);
/* 331 */       ev_postable = true;
/*     */     } 
/*     */     
/* 334 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 342 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 350 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 351 */       this._events != null && 
/* 352 */       postEventsForChanges()) {
/* 353 */       this._events.post(IStockLedger.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 360 */     boolean ev_postable = false;
/*     */     
/* 362 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 363 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 364 */       getDAO_().setUpdateDate(argUpdateDate);
/* 365 */       ev_postable = true;
/*     */     } 
/*     */     
/* 368 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 376 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 384 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 385 */       this._events != null && 
/* 386 */       postEventsForChanges()) {
/* 387 */       this._events.post(IStockLedger.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 394 */     boolean ev_postable = false;
/*     */     
/* 396 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 397 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 398 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 399 */       ev_postable = true;
/*     */     } 
/*     */     
/* 402 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getUnitcount() {
/* 410 */     return getDAO_().getUnitcount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnitcount(BigDecimal argUnitcount) {
/* 418 */     if (setUnitcount_noev(argUnitcount) && 
/* 419 */       this._events != null && 
/* 420 */       postEventsForChanges()) {
/* 421 */       this._events.post(IStockLedger.SET_UNITCOUNT, argUnitcount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUnitcount_noev(BigDecimal argUnitcount) {
/* 428 */     boolean ev_postable = false;
/*     */     
/* 430 */     if ((getDAO_().getUnitcount() == null && argUnitcount != null) || (
/* 431 */       getDAO_().getUnitcount() != null && !getDAO_().getUnitcount().equals(argUnitcount))) {
/* 432 */       getDAO_().setUnitcount(argUnitcount);
/* 433 */       ev_postable = true;
/*     */     } 
/*     */     
/* 436 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getInventoryValue() {
/* 444 */     return getDAO_().getInventoryValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryValue(BigDecimal argInventoryValue) {
/* 452 */     if (setInventoryValue_noev(argInventoryValue) && 
/* 453 */       this._events != null && 
/* 454 */       postEventsForChanges()) {
/* 455 */       this._events.post(IStockLedger.SET_INVENTORYVALUE, argInventoryValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryValue_noev(BigDecimal argInventoryValue) {
/* 462 */     boolean ev_postable = false;
/*     */     
/* 464 */     if ((getDAO_().getInventoryValue() == null && argInventoryValue != null) || (
/* 465 */       getDAO_().getInventoryValue() != null && !getDAO_().getInventoryValue().equals(argInventoryValue))) {
/* 466 */       getDAO_().setInventoryValue(argInventoryValue);
/* 467 */       ev_postable = true;
/*     */     } 
/*     */     
/* 470 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IStockLedgerProperty newProperty(String argPropertyName) {
/* 474 */     StockLedgerPropertyId id = new StockLedgerPropertyId();
/*     */     
/* 476 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 477 */     id.setBucketId(getBucketId());
/* 478 */     id.setInvLocationId(getInvLocationId());
/* 479 */     id.setItemId(getItemId());
/* 480 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 482 */     IStockLedgerProperty prop = (IStockLedgerProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IStockLedgerProperty.class);
/* 483 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IStockLedgerProperty> getProperties() {
/* 492 */     if (this._properties == null) {
/* 493 */       this._properties = new HistoricalList(null);
/*     */     }
/* 495 */     return (List<IStockLedgerProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IStockLedgerProperty> argProperties) {
/* 499 */     if (this._properties == null) {
/* 500 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 502 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 505 */     for (IStockLedgerProperty child : this._properties) {
/* 506 */       StockLedgerPropertyModel model = (StockLedgerPropertyModel)child;
/* 507 */       model.setOrganizationId_noev(getOrganizationId());
/* 508 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 509 */       model.setBucketId_noev(getBucketId());
/* 510 */       model.setInvLocationId_noev(getInvLocationId());
/* 511 */       model.setItemId_noev(getItemId());
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
/*     */   public void addStockLedgerProperty(IStockLedgerProperty argStockLedgerProperty) {
/* 526 */     if (this._properties == null) {
/* 527 */       this._properties = new HistoricalList(null);
/*     */     }
/* 529 */     argStockLedgerProperty.setOrganizationId(getOrganizationId());
/* 530 */     argStockLedgerProperty.setRetailLocationId(getRetailLocationId());
/* 531 */     argStockLedgerProperty.setBucketId(getBucketId());
/* 532 */     argStockLedgerProperty.setInvLocationId(getInvLocationId());
/* 533 */     argStockLedgerProperty.setItemId(getItemId());
/* 534 */     if (argStockLedgerProperty instanceof IDataModelImpl) {
/* 535 */       IDataAccessObject childDao = ((IDataModelImpl)argStockLedgerProperty).getDAO();
/* 536 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 537 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 538 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 543 */     if (postEventsForChanges()) {
/* 544 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argStockLedgerProperty));
/*     */     }
/*     */     
/* 547 */     this._properties.add(argStockLedgerProperty);
/* 548 */     if (postEventsForChanges()) {
/* 549 */       this._events.post(IStockLedger.ADD_PROPERTIES, argStockLedgerProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeStockLedgerProperty(IStockLedgerProperty argStockLedgerProperty) {
/* 554 */     if (this._properties != null) {
/*     */       
/* 556 */       if (postEventsForChanges()) {
/* 557 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argStockLedgerProperty));
/*     */       }
/* 559 */       this._properties.remove(argStockLedgerProperty);
/* 560 */       if (postEventsForChanges()) {
/* 561 */         this._events.post(IStockLedger.REMOVE_PROPERTIES, argStockLedgerProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 568 */     if ("Properties".equals(argFieldId)) {
/* 569 */       return getProperties();
/*     */     }
/* 571 */     if ("StockLedgerExtension".equals(argFieldId)) {
/* 572 */       return this._myExtension;
/*     */     }
/*     */     
/* 575 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 581 */     if ("Properties".equals(argFieldId)) {
/* 582 */       setProperties(changeToList(argValue, IStockLedgerProperty.class));
/*     */     }
/* 584 */     else if ("StockLedgerExtension".equals(argFieldId)) {
/* 585 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 588 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 594 */     this._persistenceDefaults = argPD;
/* 595 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 596 */     this._eventManager = argEM;
/* 597 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 598 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 599 */     if (this._properties != null) {
/* 600 */       for (IStockLedgerProperty relationship : this._properties) {
/* 601 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getStockLedgerExt() {
/* 607 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setStockLedgerExt(IDataModel argExt) {
/* 611 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 616 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 620 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 623 */     super.startTransaction();
/*     */     
/* 625 */     this._propertiesSavepoint = this._properties;
/* 626 */     if (this._properties != null) {
/* 627 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 628 */       Iterator<IDataModel> it = this._properties.iterator();
/* 629 */       while (it.hasNext()) {
/* 630 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 635 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 640 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 643 */     super.rollbackChanges();
/*     */     
/* 645 */     this._properties = this._propertiesSavepoint;
/* 646 */     this._propertiesSavepoint = null;
/* 647 */     if (this._properties != null) {
/* 648 */       Iterator<IDataModel> it = this._properties.iterator();
/* 649 */       while (it.hasNext()) {
/* 650 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 658 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 661 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 664 */     super.commitTransaction();
/*     */     
/* 666 */     this._propertiesSavepoint = this._properties;
/* 667 */     if (this._properties != null) {
/* 668 */       Iterator<IDataModel> it = this._properties.iterator();
/* 669 */       while (it.hasNext()) {
/* 670 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 672 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */     
/* 675 */     getDAO_().setInitUnitcount(getUnitcount());
/*     */     
/* 677 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 682 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\StockLedgerModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */