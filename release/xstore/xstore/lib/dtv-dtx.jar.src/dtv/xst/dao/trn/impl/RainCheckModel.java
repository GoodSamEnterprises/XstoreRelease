/*     */ package dtv.xst.dao.trn.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
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
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.trn.IRainCheck;
/*     */ import dtv.xst.dao.trn.IRainCheckProperty;
/*     */ import dtv.xst.dao.trn.RainCheckPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class RainCheckModel extends AbstractDataModelWithPropertyImpl<IRainCheckProperty> implements IRainCheck {
/*     */   private static final long serialVersionUID = 1279387060L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IItem _item;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient IItem _itemSavepoint; private HistoricalList<IRainCheckProperty> _properties; private transient HistoricalList<IRainCheckProperty> _propertiesSavepoint; protected String _itemDescription; protected BigDecimal _quantityLimit;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new RainCheckDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RainCheckDAO getDAO_() {
/*  47 */     return (RainCheckDAO)this._daoImpl;
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
/*  71 */       this._events.post(IRainCheck.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<RainCheckPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((RainCheckPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getRainCheckId() {
/* 102 */     return getDAO_().getRainCheckId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRainCheckId(String argRainCheckId) {
/* 110 */     if (setRainCheckId_noev(argRainCheckId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IRainCheck.SET_RAINCHECKID, argRainCheckId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRainCheckId_noev(String argRainCheckId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getRainCheckId() == null && argRainCheckId != null) || (
/* 123 */       getDAO_().getRainCheckId() != null && !getDAO_().getRainCheckId().equals(argRainCheckId))) {
/* 124 */       getDAO_().setRainCheckId(argRainCheckId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<RainCheckPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((RainCheckPropertyModel)it.next()).setRainCheckId_noev(argRainCheckId);
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
/*     */   public Date getCreateDate() {
/* 144 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 152 */     if (setCreateDate_noev(argCreateDate) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IRainCheck.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 165 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 166 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 178 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 186 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 187 */       this._events != null && 
/* 188 */       postEventsForChanges()) {
/* 189 */       this._events.post(IRainCheck.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 196 */     boolean ev_postable = false;
/*     */     
/* 198 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 199 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 200 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 212 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 220 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 221 */       this._events != null && 
/* 222 */       postEventsForChanges()) {
/* 223 */       this._events.post(IRainCheck.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 230 */     boolean ev_postable = false;
/*     */     
/* 232 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 233 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 234 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 246 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 254 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 255 */       this._events != null && 
/* 256 */       postEventsForChanges()) {
/* 257 */       this._events.post(IRainCheck.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 264 */     boolean ev_postable = false;
/*     */     
/* 266 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 267 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 268 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getItemId() {
/* 280 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 288 */     if (setItemId_noev(argItemId) && 
/* 289 */       this._events != null && 
/* 290 */       postEventsForChanges()) {
/* 291 */       this._events.post(IRainCheck.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 298 */     boolean ev_postable = false;
/*     */     
/* 300 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 301 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 302 */       getDAO_().setItemId(argItemId);
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
/*     */   public BigDecimal getSalePrice() {
/* 314 */     return getDAO_().getSalePrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSalePrice(BigDecimal argSalePrice) {
/* 322 */     if (setSalePrice_noev(argSalePrice) && 
/* 323 */       this._events != null && 
/* 324 */       postEventsForChanges()) {
/* 325 */       this._events.post(IRainCheck.SET_SALEPRICE, argSalePrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSalePrice_noev(BigDecimal argSalePrice) {
/* 332 */     boolean ev_postable = false;
/*     */     
/* 334 */     if ((getDAO_().getSalePrice() == null && argSalePrice != null) || (
/* 335 */       getDAO_().getSalePrice() != null && !getDAO_().getSalePrice().equals(argSalePrice))) {
/* 336 */       getDAO_().setSalePrice(argSalePrice);
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
/*     */   public Date getExpirationBusinessDate() {
/* 348 */     return getDAO_().getExpirationBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationBusinessDate(Date argExpirationBusinessDate) {
/* 356 */     if (setExpirationBusinessDate_noev(argExpirationBusinessDate) && 
/* 357 */       this._events != null && 
/* 358 */       postEventsForChanges()) {
/* 359 */       this._events.post(IRainCheck.SET_EXPIRATIONBUSINESSDATE, argExpirationBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationBusinessDate_noev(Date argExpirationBusinessDate) {
/* 366 */     boolean ev_postable = false;
/*     */     
/* 368 */     if ((getDAO_().getExpirationBusinessDate() == null && argExpirationBusinessDate != null) || (
/* 369 */       getDAO_().getExpirationBusinessDate() != null && !getDAO_().getExpirationBusinessDate().equals(argExpirationBusinessDate))) {
/* 370 */       getDAO_().setExpirationBusinessDate(argExpirationBusinessDate);
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
/*     */   public boolean getRedeemedFlag() {
/* 382 */     if (getDAO_().getRedeemedFlag() != null) {
/* 383 */       return getDAO_().getRedeemedFlag().booleanValue();
/*     */     }
/*     */     
/* 386 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRedeemedFlag(boolean argRedeemedFlag) {
/* 395 */     if (setRedeemedFlag_noev(argRedeemedFlag) && 
/* 396 */       this._events != null && 
/* 397 */       postEventsForChanges()) {
/* 398 */       this._events.post(IRainCheck.SET_REDEEMEDFLAG, Boolean.valueOf(argRedeemedFlag));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRedeemedFlag_noev(boolean argRedeemedFlag) {
/* 405 */     boolean ev_postable = false;
/*     */     
/* 407 */     if ((getDAO_().getRedeemedFlag() == null && Boolean.valueOf(argRedeemedFlag) != null) || (
/* 408 */       getDAO_().getRedeemedFlag() != null && !getDAO_().getRedeemedFlag().equals(Boolean.valueOf(argRedeemedFlag)))) {
/* 409 */       getDAO_().setRedeemedFlag(Boolean.valueOf(argRedeemedFlag));
/* 410 */       ev_postable = true;
/*     */     } 
/*     */     
/* 413 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 421 */     if (getDAO_().getRetailLocationId() != null) {
/* 422 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 425 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 434 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 435 */       this._events != null && 
/* 436 */       postEventsForChanges()) {
/* 437 */       this._events.post(IRainCheck.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 444 */     boolean ev_postable = false;
/*     */     
/* 446 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 447 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 448 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 449 */       ev_postable = true;
/*     */     } 
/*     */     
/* 452 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IRainCheckProperty newProperty(String argPropertyName) {
/* 456 */     RainCheckPropertyId id = new RainCheckPropertyId();
/*     */     
/* 458 */     id.setRainCheckId(getRainCheckId());
/* 459 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 461 */     IRainCheckProperty prop = (IRainCheckProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRainCheckProperty.class);
/* 462 */     return prop;
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
/* 474 */     return this._item;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItem(IItem argItem) {
/* 479 */     if (argItem == null) {
/*     */       
/* 481 */       getDAO_().setItemId(null);
/* 482 */       if (this._item != null)
/*     */       {
/* 484 */         if (postEventsForChanges()) {
/* 485 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 490 */       getDAO_().setItemId(argItem.getItemId());
/*     */       
/* 492 */       if (postEventsForChanges()) {
/* 493 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*     */       }
/*     */     } 
/*     */     
/* 497 */     this._item = argItem;
/* 498 */     if (postEventsForChanges()) {
/* 499 */       this._events.post(IRainCheck.SET_ITEM, argItem);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IRainCheckProperty> getProperties() {
/* 505 */     if (this._properties == null) {
/* 506 */       this._properties = new HistoricalList(null);
/*     */     }
/* 508 */     return (List<IRainCheckProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IRainCheckProperty> argProperties) {
/* 512 */     if (this._properties == null) {
/* 513 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 515 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 518 */     for (IRainCheckProperty child : this._properties) {
/* 519 */       RainCheckPropertyModel model = (RainCheckPropertyModel)child;
/* 520 */       model.setOrganizationId_noev(getOrganizationId());
/* 521 */       model.setRainCheckId_noev(getRainCheckId());
/* 522 */       if (child instanceof IDataModelImpl) {
/* 523 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 524 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 525 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 526 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 529 */       if (postEventsForChanges()) {
/* 530 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addRainCheckProperty(IRainCheckProperty argRainCheckProperty) {
/* 536 */     if (this._properties == null) {
/* 537 */       this._properties = new HistoricalList(null);
/*     */     }
/* 539 */     argRainCheckProperty.setOrganizationId(getOrganizationId());
/* 540 */     argRainCheckProperty.setRainCheckId(getRainCheckId());
/* 541 */     if (argRainCheckProperty instanceof IDataModelImpl) {
/* 542 */       IDataAccessObject childDao = ((IDataModelImpl)argRainCheckProperty).getDAO();
/* 543 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 544 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 545 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 550 */     if (postEventsForChanges()) {
/* 551 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRainCheckProperty));
/*     */     }
/*     */     
/* 554 */     this._properties.add(argRainCheckProperty);
/* 555 */     if (postEventsForChanges()) {
/* 556 */       this._events.post(IRainCheck.ADD_PROPERTIES, argRainCheckProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRainCheckProperty(IRainCheckProperty argRainCheckProperty) {
/* 561 */     if (this._properties != null) {
/*     */       
/* 563 */       if (postEventsForChanges()) {
/* 564 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRainCheckProperty));
/*     */       }
/* 566 */       this._properties.remove(argRainCheckProperty);
/* 567 */       if (postEventsForChanges()) {
/* 568 */         this._events.post(IRainCheck.REMOVE_PROPERTIES, argRainCheckProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 575 */     if ("Item".equals(argFieldId)) {
/* 576 */       return getItem();
/*     */     }
/* 578 */     if ("Properties".equals(argFieldId)) {
/* 579 */       return getProperties();
/*     */     }
/* 581 */     if ("RainCheckExtension".equals(argFieldId)) {
/* 582 */       return this._myExtension;
/*     */     }
/*     */     
/* 585 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 591 */     if ("Item".equals(argFieldId)) {
/* 592 */       setItem((IItem)argValue);
/*     */     }
/* 594 */     else if ("Properties".equals(argFieldId)) {
/* 595 */       setProperties(changeToList(argValue, IRainCheckProperty.class));
/*     */     }
/* 597 */     else if ("RainCheckExtension".equals(argFieldId)) {
/* 598 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 601 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 607 */     this._persistenceDefaults = argPD;
/* 608 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 609 */     this._eventManager = argEM;
/* 610 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 611 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 612 */     if (this._item != null) {
/* 613 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*     */     }
/* 615 */     if (this._properties != null) {
/* 616 */       for (IRainCheckProperty relationship : this._properties) {
/* 617 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getRainCheckExt() {
/* 623 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setRainCheckExt(IDataModel argExt) {
/* 627 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 632 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 636 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 639 */     super.startTransaction();
/*     */     
/* 641 */     this._itemSavepoint = this._item;
/* 642 */     if (this._item != null) {
/* 643 */       this._item.startTransaction();
/*     */     }
/*     */     
/* 646 */     this._propertiesSavepoint = this._properties;
/* 647 */     if (this._properties != null) {
/* 648 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 649 */       Iterator<IDataModel> it = this._properties.iterator();
/* 650 */       while (it.hasNext()) {
/* 651 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 656 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 661 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 664 */     super.rollbackChanges();
/*     */     
/* 666 */     this._item = this._itemSavepoint;
/* 667 */     this._itemSavepoint = null;
/* 668 */     if (this._item != null) {
/* 669 */       this._item.rollbackChanges();
/*     */     }
/*     */     
/* 672 */     this._properties = this._propertiesSavepoint;
/* 673 */     this._propertiesSavepoint = null;
/* 674 */     if (this._properties != null) {
/* 675 */       Iterator<IDataModel> it = this._properties.iterator();
/* 676 */       while (it.hasNext()) {
/* 677 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 685 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 688 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 691 */     super.commitTransaction();
/*     */     
/* 693 */     this._itemSavepoint = this._item;
/* 694 */     if (this._item != null) {
/* 695 */       this._item.commitTransaction();
/*     */     }
/*     */     
/* 698 */     this._propertiesSavepoint = this._properties;
/* 699 */     if (this._properties != null) {
/* 700 */       Iterator<IDataModel> it = this._properties.iterator();
/* 701 */       while (it.hasNext()) {
/* 702 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 704 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 708 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 713 */     argStream.defaultReadObject();
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
/*     */ 
/*     */   
/*     */   public String getItemDescription() {
/* 729 */     return this._itemDescription;
/*     */   }
/*     */   
/*     */   public void setItemDescription(String argDescription) {
/* 733 */     this._itemDescription = argDescription;
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantityLimit() {
/* 737 */     return this._quantityLimit;
/*     */   }
/*     */   
/*     */   public void setQuantityLimit(BigDecimal argQuantityLimit) {
/* 741 */     this._quantityLimit = argQuantityLimit;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\RainCheckModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */