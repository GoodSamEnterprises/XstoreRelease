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
/*     */ import dtv.xst.dao.inv.IInventoryBucket;
/*     */ import dtv.xst.dao.inv.IInventoryBucketProperty;
/*     */ import dtv.xst.dao.inv.InventoryBucketPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryBucketModel extends AbstractDataModelWithPropertyImpl<IInventoryBucketProperty> implements IInventoryBucket {
/*     */   private static final long serialVersionUID = 1441305158L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IInventoryBucketProperty> _properties; private transient HistoricalList<IInventoryBucketProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new InventoryBucketDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryBucketDAO getDAO_() {
/*  46 */     return (InventoryBucketDAO)this._daoImpl;
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
/*  70 */       this._events.post(IInventoryBucket.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<InventoryBucketPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((InventoryBucketPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IInventoryBucket.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<InventoryBucketPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((InventoryBucketPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 159 */       this._events.post(IInventoryBucket.SET_BUCKETID, argBucketId);
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
/* 174 */         Iterator<InventoryBucketPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((InventoryBucketPropertyModel)it.next()).setBucketId_noev(argBucketId);
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
/* 201 */       this._events.post(IInventoryBucket.SET_CREATEDATE, argCreateDate);
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
/* 235 */       this._events.post(IInventoryBucket.SET_CREATEUSERID, argCreateUserId);
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
/* 269 */       this._events.post(IInventoryBucket.SET_UPDATEDATE, argUpdateDate);
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
/* 303 */       this._events.post(IInventoryBucket.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getName() {
/* 326 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 334 */     if (setName_noev(argName) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IInventoryBucket.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getName() == null && argName != null) || (
/* 347 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 348 */       getDAO_().setName(argName);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFunctionCode() {
/* 360 */     return getDAO_().getFunctionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFunctionCode(String argFunctionCode) {
/* 368 */     if (setFunctionCode_noev(argFunctionCode) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IInventoryBucket.SET_FUNCTIONCODE, argFunctionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFunctionCode_noev(String argFunctionCode) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getFunctionCode() == null && argFunctionCode != null) || (
/* 381 */       getDAO_().getFunctionCode() != null && !getDAO_().getFunctionCode().equals(argFunctionCode))) {
/* 382 */       getDAO_().setFunctionCode(argFunctionCode);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAdjustmentAction() {
/* 394 */     return getDAO_().getAdjustmentAction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAdjustmentAction(String argAdjustmentAction) {
/* 402 */     if (setAdjustmentAction_noev(argAdjustmentAction) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IInventoryBucket.SET_ADJUSTMENTACTION, argAdjustmentAction);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAdjustmentAction_noev(String argAdjustmentAction) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getAdjustmentAction() == null && argAdjustmentAction != null) || (
/* 415 */       getDAO_().getAdjustmentAction() != null && !getDAO_().getAdjustmentAction().equals(argAdjustmentAction))) {
/* 416 */       getDAO_().setAdjustmentAction(argAdjustmentAction);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultLocationId() {
/* 428 */     return getDAO_().getDefaultLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultLocationId(String argDefaultLocationId) {
/* 436 */     if (setDefaultLocationId_noev(argDefaultLocationId) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IInventoryBucket.SET_DEFAULTLOCATIONID, argDefaultLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDefaultLocationId_noev(String argDefaultLocationId) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getDefaultLocationId() == null && argDefaultLocationId != null) || (
/* 449 */       getDAO_().getDefaultLocationId() != null && !getDAO_().getDefaultLocationId().equals(argDefaultLocationId))) {
/* 450 */       getDAO_().setDefaultLocationId(argDefaultLocationId);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSystemBucket() {
/* 462 */     if (getDAO_().getSystemBucket() != null) {
/* 463 */       return getDAO_().getSystemBucket().booleanValue();
/*     */     }
/*     */     
/* 466 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSystemBucket(boolean argSystemBucket) {
/* 475 */     if (setSystemBucket_noev(argSystemBucket) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IInventoryBucket.SET_SYSTEMBUCKET, Boolean.valueOf(argSystemBucket));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSystemBucket_noev(boolean argSystemBucket) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getSystemBucket() == null && Boolean.valueOf(argSystemBucket) != null) || (
/* 488 */       getDAO_().getSystemBucket() != null && !getDAO_().getSystemBucket().equals(Boolean.valueOf(argSystemBucket)))) {
/* 489 */       getDAO_().setSystemBucket(Boolean.valueOf(argSystemBucket));
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryBucketProperty newProperty(String argPropertyName) {
/* 497 */     InventoryBucketPropertyId id = new InventoryBucketPropertyId();
/*     */     
/* 499 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 500 */     id.setBucketId(getBucketId());
/* 501 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 503 */     IInventoryBucketProperty prop = (IInventoryBucketProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryBucketProperty.class);
/* 504 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryBucketProperty> getProperties() {
/* 513 */     if (this._properties == null) {
/* 514 */       this._properties = new HistoricalList(null);
/*     */     }
/* 516 */     return (List<IInventoryBucketProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryBucketProperty> argProperties) {
/* 520 */     if (this._properties == null) {
/* 521 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 523 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 526 */     for (IInventoryBucketProperty child : this._properties) {
/* 527 */       InventoryBucketPropertyModel model = (InventoryBucketPropertyModel)child;
/* 528 */       model.setOrganizationId_noev(getOrganizationId());
/* 529 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 530 */       model.setBucketId_noev(getBucketId());
/* 531 */       if (child instanceof IDataModelImpl) {
/* 532 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 533 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 534 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 535 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 538 */       if (postEventsForChanges()) {
/* 539 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryBucketProperty(IInventoryBucketProperty argInventoryBucketProperty) {
/* 545 */     if (this._properties == null) {
/* 546 */       this._properties = new HistoricalList(null);
/*     */     }
/* 548 */     argInventoryBucketProperty.setOrganizationId(getOrganizationId());
/* 549 */     argInventoryBucketProperty.setRetailLocationId(getRetailLocationId());
/* 550 */     argInventoryBucketProperty.setBucketId(getBucketId());
/* 551 */     if (argInventoryBucketProperty instanceof IDataModelImpl) {
/* 552 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryBucketProperty).getDAO();
/* 553 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 554 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 555 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 560 */     if (postEventsForChanges()) {
/* 561 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryBucketProperty));
/*     */     }
/*     */     
/* 564 */     this._properties.add(argInventoryBucketProperty);
/* 565 */     if (postEventsForChanges()) {
/* 566 */       this._events.post(IInventoryBucket.ADD_PROPERTIES, argInventoryBucketProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryBucketProperty(IInventoryBucketProperty argInventoryBucketProperty) {
/* 571 */     if (this._properties != null) {
/*     */       
/* 573 */       if (postEventsForChanges()) {
/* 574 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryBucketProperty));
/*     */       }
/* 576 */       this._properties.remove(argInventoryBucketProperty);
/* 577 */       if (postEventsForChanges()) {
/* 578 */         this._events.post(IInventoryBucket.REMOVE_PROPERTIES, argInventoryBucketProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 585 */     if ("Properties".equals(argFieldId)) {
/* 586 */       return getProperties();
/*     */     }
/* 588 */     if ("InventoryBucketExtension".equals(argFieldId)) {
/* 589 */       return this._myExtension;
/*     */     }
/*     */     
/* 592 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 598 */     if ("Properties".equals(argFieldId)) {
/* 599 */       setProperties(changeToList(argValue, IInventoryBucketProperty.class));
/*     */     }
/* 601 */     else if ("InventoryBucketExtension".equals(argFieldId)) {
/* 602 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 605 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 611 */     this._persistenceDefaults = argPD;
/* 612 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 613 */     this._eventManager = argEM;
/* 614 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 615 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 616 */     if (this._properties != null) {
/* 617 */       for (IInventoryBucketProperty relationship : this._properties) {
/* 618 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryBucketExt() {
/* 624 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketExt(IDataModel argExt) {
/* 628 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 633 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 637 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 640 */     super.startTransaction();
/*     */     
/* 642 */     this._propertiesSavepoint = this._properties;
/* 643 */     if (this._properties != null) {
/* 644 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 645 */       Iterator<IDataModel> it = this._properties.iterator();
/* 646 */       while (it.hasNext()) {
/* 647 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 652 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 657 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 660 */     super.rollbackChanges();
/*     */     
/* 662 */     this._properties = this._propertiesSavepoint;
/* 663 */     this._propertiesSavepoint = null;
/* 664 */     if (this._properties != null) {
/* 665 */       Iterator<IDataModel> it = this._properties.iterator();
/* 666 */       while (it.hasNext()) {
/* 667 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 675 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 678 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 681 */     super.commitTransaction();
/*     */     
/* 683 */     this._propertiesSavepoint = this._properties;
/* 684 */     if (this._properties != null) {
/* 685 */       Iterator<IDataModel> it = this._properties.iterator();
/* 686 */       while (it.hasNext()) {
/* 687 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 689 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 693 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 698 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryBucketModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */