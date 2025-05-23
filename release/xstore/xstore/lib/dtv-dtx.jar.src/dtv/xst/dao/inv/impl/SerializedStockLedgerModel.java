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
/*     */ import dtv.xst.dao.inv.ISerializedStockLedger;
/*     */ import dtv.xst.dao.inv.ISerializedStockLedgerProperty;
/*     */ import dtv.xst.dao.inv.SerializedStockLedgerPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SerializedStockLedgerModel extends AbstractDataModelWithPropertyImpl<ISerializedStockLedgerProperty> implements ISerializedStockLedger {
/*     */   private static final long serialVersionUID = 313200603L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ISerializedStockLedgerProperty> _properties; private transient HistoricalList<ISerializedStockLedgerProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new SerializedStockLedgerDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SerializedStockLedgerDAO getDAO_() {
/*  46 */     return (SerializedStockLedgerDAO)this._daoImpl;
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
/*  70 */       this._events.post(ISerializedStockLedger.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<SerializedStockLedgerPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((SerializedStockLedgerPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(ISerializedStockLedger.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<SerializedStockLedgerPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((SerializedStockLedgerPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public String getInvLocationId() {
/* 148 */     return getDAO_().getInvLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/* 156 */     if (setInvLocationId_noev(argInvLocationId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ISerializedStockLedger.SET_INVLOCATIONID, argInvLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvLocationId_noev(String argInvLocationId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getInvLocationId() == null && argInvLocationId != null) || (
/* 169 */       getDAO_().getInvLocationId() != null && !getDAO_().getInvLocationId().equals(argInvLocationId))) {
/* 170 */       getDAO_().setInvLocationId(argInvLocationId);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<SerializedStockLedgerPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((SerializedStockLedgerPropertyModel)it.next()).setInvLocationId_noev(argInvLocationId);
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
/*     */   public String getItemId() {
/* 190 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 198 */     if (setItemId_noev(argItemId) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(ISerializedStockLedger.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 211 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 212 */       getDAO_().setItemId(argItemId);
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<SerializedStockLedgerPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((SerializedStockLedgerPropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public String getSerialNumber() {
/* 232 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 240 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(ISerializedStockLedger.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 253 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 254 */       getDAO_().setSerialNumber(argSerialNumber);
/* 255 */       ev_postable = true;
/* 256 */       if (this._properties != null) {
/*     */         
/* 258 */         Iterator<SerializedStockLedgerPropertyModel> it = this._properties.iterator();
/* 259 */         while (it.hasNext())
/*     */         {
/* 261 */           ((SerializedStockLedgerPropertyModel)it.next()).setSerialNumber_noev(argSerialNumber);
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
/*     */   public String getBucketId() {
/* 274 */     return getDAO_().getBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/* 282 */     if (setBucketId_noev(argBucketId) && 
/* 283 */       this._events != null && 
/* 284 */       postEventsForChanges()) {
/* 285 */       this._events.post(ISerializedStockLedger.SET_BUCKETID, argBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBucketId_noev(String argBucketId) {
/* 292 */     boolean ev_postable = false;
/*     */     
/* 294 */     if ((getDAO_().getBucketId() == null && argBucketId != null) || (
/* 295 */       getDAO_().getBucketId() != null && !getDAO_().getBucketId().equals(argBucketId))) {
/* 296 */       getDAO_().setBucketId(argBucketId);
/* 297 */       ev_postable = true;
/* 298 */       if (this._properties != null) {
/*     */         
/* 300 */         Iterator<SerializedStockLedgerPropertyModel> it = this._properties.iterator();
/* 301 */         while (it.hasNext())
/*     */         {
/* 303 */           ((SerializedStockLedgerPropertyModel)it.next()).setBucketId_noev(argBucketId);
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
/* 327 */       this._events.post(ISerializedStockLedger.SET_CREATEDATE, argCreateDate);
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
/* 361 */       this._events.post(ISerializedStockLedger.SET_CREATEUSERID, argCreateUserId);
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
/* 395 */       this._events.post(ISerializedStockLedger.SET_UPDATEDATE, argUpdateDate);
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
/* 429 */       this._events.post(ISerializedStockLedger.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   protected ISerializedStockLedgerProperty newProperty(String argPropertyName) {
/* 448 */     SerializedStockLedgerPropertyId id = new SerializedStockLedgerPropertyId();
/*     */     
/* 450 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 451 */     id.setInvLocationId(getInvLocationId());
/* 452 */     id.setItemId(getItemId());
/* 453 */     id.setSerialNumber(getSerialNumber());
/* 454 */     id.setBucketId(getBucketId());
/* 455 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 457 */     ISerializedStockLedgerProperty prop = (ISerializedStockLedgerProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISerializedStockLedgerProperty.class);
/* 458 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISerializedStockLedgerProperty> getProperties() {
/* 467 */     if (this._properties == null) {
/* 468 */       this._properties = new HistoricalList(null);
/*     */     }
/* 470 */     return (List<ISerializedStockLedgerProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISerializedStockLedgerProperty> argProperties) {
/* 474 */     if (this._properties == null) {
/* 475 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 477 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 480 */     for (ISerializedStockLedgerProperty child : this._properties) {
/* 481 */       SerializedStockLedgerPropertyModel model = (SerializedStockLedgerPropertyModel)child;
/* 482 */       model.setOrganizationId_noev(getOrganizationId());
/* 483 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 484 */       model.setInvLocationId_noev(getInvLocationId());
/* 485 */       model.setItemId_noev(getItemId());
/* 486 */       model.setSerialNumber_noev(getSerialNumber());
/* 487 */       model.setBucketId_noev(getBucketId());
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
/*     */   public void addSerializedStockLedgerProperty(ISerializedStockLedgerProperty argSerializedStockLedgerProperty) {
/* 502 */     if (this._properties == null) {
/* 503 */       this._properties = new HistoricalList(null);
/*     */     }
/* 505 */     argSerializedStockLedgerProperty.setOrganizationId(getOrganizationId());
/* 506 */     argSerializedStockLedgerProperty.setRetailLocationId(getRetailLocationId());
/* 507 */     argSerializedStockLedgerProperty.setInvLocationId(getInvLocationId());
/* 508 */     argSerializedStockLedgerProperty.setItemId(getItemId());
/* 509 */     argSerializedStockLedgerProperty.setSerialNumber(getSerialNumber());
/* 510 */     argSerializedStockLedgerProperty.setBucketId(getBucketId());
/* 511 */     if (argSerializedStockLedgerProperty instanceof IDataModelImpl) {
/* 512 */       IDataAccessObject childDao = ((IDataModelImpl)argSerializedStockLedgerProperty).getDAO();
/* 513 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 514 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 515 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 520 */     if (postEventsForChanges()) {
/* 521 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSerializedStockLedgerProperty));
/*     */     }
/*     */     
/* 524 */     this._properties.add(argSerializedStockLedgerProperty);
/* 525 */     if (postEventsForChanges()) {
/* 526 */       this._events.post(ISerializedStockLedger.ADD_PROPERTIES, argSerializedStockLedgerProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSerializedStockLedgerProperty(ISerializedStockLedgerProperty argSerializedStockLedgerProperty) {
/* 531 */     if (this._properties != null) {
/*     */       
/* 533 */       if (postEventsForChanges()) {
/* 534 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSerializedStockLedgerProperty));
/*     */       }
/* 536 */       this._properties.remove(argSerializedStockLedgerProperty);
/* 537 */       if (postEventsForChanges()) {
/* 538 */         this._events.post(ISerializedStockLedger.REMOVE_PROPERTIES, argSerializedStockLedgerProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 545 */     if ("Properties".equals(argFieldId)) {
/* 546 */       return getProperties();
/*     */     }
/* 548 */     if ("SerializedStockLedgerExtension".equals(argFieldId)) {
/* 549 */       return this._myExtension;
/*     */     }
/*     */     
/* 552 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 558 */     if ("Properties".equals(argFieldId)) {
/* 559 */       setProperties(changeToList(argValue, ISerializedStockLedgerProperty.class));
/*     */     }
/* 561 */     else if ("SerializedStockLedgerExtension".equals(argFieldId)) {
/* 562 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 565 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 571 */     this._persistenceDefaults = argPD;
/* 572 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 573 */     this._eventManager = argEM;
/* 574 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 575 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 576 */     if (this._properties != null) {
/* 577 */       for (ISerializedStockLedgerProperty relationship : this._properties) {
/* 578 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSerializedStockLedgerExt() {
/* 584 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSerializedStockLedgerExt(IDataModel argExt) {
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
/* 602 */     this._propertiesSavepoint = this._properties;
/* 603 */     if (this._properties != null) {
/* 604 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 605 */       Iterator<IDataModel> it = this._properties.iterator();
/* 606 */       while (it.hasNext()) {
/* 607 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 612 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 617 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 620 */     super.rollbackChanges();
/*     */     
/* 622 */     this._properties = this._propertiesSavepoint;
/* 623 */     this._propertiesSavepoint = null;
/* 624 */     if (this._properties != null) {
/* 625 */       Iterator<IDataModel> it = this._properties.iterator();
/* 626 */       while (it.hasNext()) {
/* 627 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 635 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 638 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 641 */     super.commitTransaction();
/*     */     
/* 643 */     this._propertiesSavepoint = this._properties;
/* 644 */     if (this._properties != null) {
/* 645 */       Iterator<IDataModel> it = this._properties.iterator();
/* 646 */       while (it.hasNext()) {
/* 647 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 649 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 653 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 658 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\SerializedStockLedgerModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */