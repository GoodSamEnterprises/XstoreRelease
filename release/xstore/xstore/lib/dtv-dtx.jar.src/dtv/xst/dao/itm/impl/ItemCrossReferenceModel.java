/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.IItemCrossReference;
/*     */ import dtv.xst.dao.itm.IItemCrossReferenceProperty;
/*     */ import dtv.xst.dao.itm.ItemCrossReferencePropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemCrossReferenceModel extends AbstractDataModelWithPropertyImpl<IItemCrossReferenceProperty> implements IItemCrossReference {
/*     */   private static final long serialVersionUID = 1694348542L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IItem _item; private transient IItem _itemSavepoint; private HistoricalList<IItemCrossReferenceProperty> _properties; private transient HistoricalList<IItemCrossReferenceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ItemCrossReferenceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemCrossReferenceDAO getDAO_() {
/*  47 */     return (ItemCrossReferenceDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturerUpc() {
/*  55 */     return getDAO_().getManufacturerUpc();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManufacturerUpc(String argManufacturerUpc) {
/*  63 */     if (setManufacturerUpc_noev(argManufacturerUpc) && 
/*  64 */       this._events != null && 
/*  65 */       postEventsForChanges()) {
/*  66 */       this._events.post(IItemCrossReference.SET_MANUFACTURERUPC, argManufacturerUpc);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setManufacturerUpc_noev(String argManufacturerUpc) {
/*  73 */     boolean ev_postable = false;
/*     */     
/*  75 */     if ((getDAO_().getManufacturerUpc() == null && argManufacturerUpc != null) || (
/*  76 */       getDAO_().getManufacturerUpc() != null && !getDAO_().getManufacturerUpc().equals(argManufacturerUpc))) {
/*  77 */       getDAO_().setManufacturerUpc(argManufacturerUpc);
/*  78 */       ev_postable = true;
/*  79 */       if (this._properties != null) {
/*     */         
/*  81 */         Iterator<ItemCrossReferencePropertyModel> it = this._properties.iterator();
/*  82 */         while (it.hasNext())
/*     */         {
/*  84 */           ((ItemCrossReferencePropertyModel)it.next()).setManufacturerUpc_noev(argManufacturerUpc);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  97 */     if (getDAO_().getOrganizationId() != null) {
/*  98 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 101 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 110 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IItemCrossReference.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 123 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 124 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<ItemCrossReferencePropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((ItemCrossReferencePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 144 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 152 */     if (setOrgCode_noev(argOrgCode) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IItemCrossReference.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 165 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 166 */       getDAO_().setOrgCode(argOrgCode);
/* 167 */       ev_postable = true;
/*     */     } 
/*     */     
/* 170 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 178 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 186 */     if (setOrgValue_noev(argOrgValue) && 
/* 187 */       this._events != null && 
/* 188 */       postEventsForChanges()) {
/* 189 */       this._events.post(IItemCrossReference.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 196 */     boolean ev_postable = false;
/*     */     
/* 198 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 199 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 200 */       getDAO_().setOrgValue(argOrgValue);
/* 201 */       ev_postable = true;
/*     */     } 
/*     */     
/* 204 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 212 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 220 */     if (setCreateDate_noev(argCreateDate) && 
/* 221 */       this._events != null && 
/* 222 */       postEventsForChanges()) {
/* 223 */       this._events.post(IItemCrossReference.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 230 */     boolean ev_postable = false;
/*     */     
/* 232 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 233 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 234 */       getDAO_().setCreateDate(argCreateDate);
/* 235 */       ev_postable = true;
/*     */     } 
/*     */     
/* 238 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 246 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 254 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 255 */       this._events != null && 
/* 256 */       postEventsForChanges()) {
/* 257 */       this._events.post(IItemCrossReference.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 264 */     boolean ev_postable = false;
/*     */     
/* 266 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 267 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 268 */       getDAO_().setCreateUserId(argCreateUserId);
/* 269 */       ev_postable = true;
/*     */     } 
/*     */     
/* 272 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 280 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 288 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 289 */       this._events != null && 
/* 290 */       postEventsForChanges()) {
/* 291 */       this._events.post(IItemCrossReference.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 298 */     boolean ev_postable = false;
/*     */     
/* 300 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 301 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 302 */       getDAO_().setUpdateDate(argUpdateDate);
/* 303 */       ev_postable = true;
/*     */     } 
/*     */     
/* 306 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 314 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 322 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 323 */       this._events != null && 
/* 324 */       postEventsForChanges()) {
/* 325 */       this._events.post(IItemCrossReference.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 332 */     boolean ev_postable = false;
/*     */     
/* 334 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 335 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 336 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 337 */       ev_postable = true;
/*     */     } 
/*     */     
/* 340 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/* 348 */     return getDAO_().getManufacturer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManufacturer(String argManufacturer) {
/* 356 */     if (setManufacturer_noev(argManufacturer) && 
/* 357 */       this._events != null && 
/* 358 */       postEventsForChanges()) {
/* 359 */       this._events.post(IItemCrossReference.SET_MANUFACTURER, argManufacturer);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setManufacturer_noev(String argManufacturer) {
/* 366 */     boolean ev_postable = false;
/*     */     
/* 368 */     if ((getDAO_().getManufacturer() == null && argManufacturer != null) || (
/* 369 */       getDAO_().getManufacturer() != null && !getDAO_().getManufacturer().equals(argManufacturer))) {
/* 370 */       getDAO_().setManufacturer(argManufacturer);
/* 371 */       ev_postable = true;
/*     */     } 
/*     */     
/* 374 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 382 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 390 */     if (setItemId_noev(argItemId) && 
/* 391 */       this._events != null && 
/* 392 */       postEventsForChanges()) {
/* 393 */       this._events.post(IItemCrossReference.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 400 */     boolean ev_postable = false;
/*     */     
/* 402 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 403 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 404 */       getDAO_().setItemId(argItemId);
/* 405 */       ev_postable = true;
/*     */     } 
/*     */     
/* 408 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPrimaryFlag() {
/* 416 */     if (getDAO_().getPrimaryFlag() != null) {
/* 417 */       return getDAO_().getPrimaryFlag().booleanValue();
/*     */     }
/*     */     
/* 420 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimaryFlag(boolean argPrimaryFlag) {
/* 429 */     if (setPrimaryFlag_noev(argPrimaryFlag) && 
/* 430 */       this._events != null && 
/* 431 */       postEventsForChanges()) {
/* 432 */       this._events.post(IItemCrossReference.SET_PRIMARYFLAG, Boolean.valueOf(argPrimaryFlag));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrimaryFlag_noev(boolean argPrimaryFlag) {
/* 439 */     boolean ev_postable = false;
/*     */     
/* 441 */     if ((getDAO_().getPrimaryFlag() == null && Boolean.valueOf(argPrimaryFlag) != null) || (
/* 442 */       getDAO_().getPrimaryFlag() != null && !getDAO_().getPrimaryFlag().equals(Boolean.valueOf(argPrimaryFlag)))) {
/* 443 */       getDAO_().setPrimaryFlag(Boolean.valueOf(argPrimaryFlag));
/* 444 */       ev_postable = true;
/*     */     } 
/*     */     
/* 447 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemCrossReferenceProperty newProperty(String argPropertyName) {
/* 451 */     ItemCrossReferencePropertyId id = new ItemCrossReferencePropertyId();
/*     */     
/* 453 */     id.setManufacturerUpc(getManufacturerUpc());
/* 454 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 456 */     IItemCrossReferenceProperty prop = (IItemCrossReferenceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemCrossReferenceProperty.class);
/* 457 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Item")
/*     */   public IItem getItem() {
/* 469 */     return this._item;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItem(IItem argItem) {
/* 474 */     if (argItem == null) {
/*     */       
/* 476 */       getDAO_().setItemId(null);
/* 477 */       if (this._item != null)
/*     */       {
/* 479 */         if (postEventsForChanges()) {
/* 480 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 485 */       getDAO_().setItemId(argItem.getItemId());
/*     */       
/* 487 */       if (postEventsForChanges()) {
/* 488 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*     */       }
/*     */     } 
/*     */     
/* 492 */     this._item = argItem;
/* 493 */     if (postEventsForChanges()) {
/* 494 */       this._events.post(IItemCrossReference.SET_ITEM, argItem);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemCrossReferenceProperty> getProperties() {
/* 500 */     if (this._properties == null) {
/* 501 */       this._properties = new HistoricalList(null);
/*     */     }
/* 503 */     return (List<IItemCrossReferenceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemCrossReferenceProperty> argProperties) {
/* 507 */     if (this._properties == null) {
/* 508 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 510 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 513 */     for (IItemCrossReferenceProperty child : this._properties) {
/* 514 */       ItemCrossReferencePropertyModel model = (ItemCrossReferencePropertyModel)child;
/* 515 */       model.setManufacturerUpc_noev(getManufacturerUpc());
/* 516 */       model.setOrganizationId_noev(getOrganizationId());
/* 517 */       if (child instanceof IDataModelImpl) {
/* 518 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 519 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 520 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 521 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 524 */       if (postEventsForChanges()) {
/* 525 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemCrossReferenceProperty(IItemCrossReferenceProperty argItemCrossReferenceProperty) {
/* 531 */     if (this._properties == null) {
/* 532 */       this._properties = new HistoricalList(null);
/*     */     }
/* 534 */     argItemCrossReferenceProperty.setManufacturerUpc(getManufacturerUpc());
/* 535 */     argItemCrossReferenceProperty.setOrganizationId(getOrganizationId());
/* 536 */     if (argItemCrossReferenceProperty instanceof IDataModelImpl) {
/* 537 */       IDataAccessObject childDao = ((IDataModelImpl)argItemCrossReferenceProperty).getDAO();
/* 538 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 539 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 540 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 545 */     if (postEventsForChanges()) {
/* 546 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemCrossReferenceProperty));
/*     */     }
/*     */     
/* 549 */     this._properties.add(argItemCrossReferenceProperty);
/* 550 */     if (postEventsForChanges()) {
/* 551 */       this._events.post(IItemCrossReference.ADD_PROPERTIES, argItemCrossReferenceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemCrossReferenceProperty(IItemCrossReferenceProperty argItemCrossReferenceProperty) {
/* 556 */     if (this._properties != null) {
/*     */       
/* 558 */       if (postEventsForChanges()) {
/* 559 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemCrossReferenceProperty));
/*     */       }
/* 561 */       this._properties.remove(argItemCrossReferenceProperty);
/* 562 */       if (postEventsForChanges()) {
/* 563 */         this._events.post(IItemCrossReference.REMOVE_PROPERTIES, argItemCrossReferenceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 570 */     if ("Item".equals(argFieldId)) {
/* 571 */       return getItem();
/*     */     }
/* 573 */     if ("Properties".equals(argFieldId)) {
/* 574 */       return getProperties();
/*     */     }
/* 576 */     if ("ItemCrossReferenceExtension".equals(argFieldId)) {
/* 577 */       return this._myExtension;
/*     */     }
/*     */     
/* 580 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 586 */     if ("Item".equals(argFieldId)) {
/* 587 */       setItem((IItem)argValue);
/*     */     }
/* 589 */     else if ("Properties".equals(argFieldId)) {
/* 590 */       setProperties(changeToList(argValue, IItemCrossReferenceProperty.class));
/*     */     }
/* 592 */     else if ("ItemCrossReferenceExtension".equals(argFieldId)) {
/* 593 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 596 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 602 */     this._persistenceDefaults = argPD;
/* 603 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 604 */     this._eventManager = argEM;
/* 605 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 606 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 607 */     if (this._item != null) {
/* 608 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*     */     }
/* 610 */     if (this._properties != null) {
/* 611 */       for (IItemCrossReferenceProperty relationship : this._properties) {
/* 612 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemCrossReferenceExt() {
/* 618 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemCrossReferenceExt(IDataModel argExt) {
/* 622 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 627 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 631 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 634 */     super.startTransaction();
/*     */     
/* 636 */     this._itemSavepoint = this._item;
/* 637 */     if (this._item != null) {
/* 638 */       this._item.startTransaction();
/*     */     }
/*     */     
/* 641 */     this._propertiesSavepoint = this._properties;
/* 642 */     if (this._properties != null) {
/* 643 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 644 */       Iterator<IDataModel> it = this._properties.iterator();
/* 645 */       while (it.hasNext()) {
/* 646 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 651 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 656 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 659 */     super.rollbackChanges();
/*     */     
/* 661 */     this._item = this._itemSavepoint;
/* 662 */     this._itemSavepoint = null;
/* 663 */     if (this._item != null) {
/* 664 */       this._item.rollbackChanges();
/*     */     }
/*     */     
/* 667 */     this._properties = this._propertiesSavepoint;
/* 668 */     this._propertiesSavepoint = null;
/* 669 */     if (this._properties != null) {
/* 670 */       Iterator<IDataModel> it = this._properties.iterator();
/* 671 */       while (it.hasNext()) {
/* 672 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 680 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 683 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 686 */     super.commitTransaction();
/*     */     
/* 688 */     this._itemSavepoint = this._item;
/* 689 */     if (this._item != null) {
/* 690 */       this._item.commitTransaction();
/*     */     }
/*     */     
/* 693 */     this._propertiesSavepoint = this._properties;
/* 694 */     if (this._properties != null) {
/* 695 */       Iterator<IDataModel> it = this._properties.iterator();
/* 696 */       while (it.hasNext()) {
/* 697 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 699 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 703 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 708 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemCrossReferenceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */