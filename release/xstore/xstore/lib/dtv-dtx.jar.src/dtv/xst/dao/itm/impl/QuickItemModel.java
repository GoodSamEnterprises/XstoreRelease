/*     */ package dtv.xst.dao.itm.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.exception.DtxException;
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
/*     */ import dtv.xst.dao.itm.IQuickItem;
/*     */ import dtv.xst.dao.itm.IQuickItemProperty;
/*     */ import dtv.xst.dao.itm.QuickItemPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class QuickItemModel extends AbstractDataModelWithPropertyImpl<IQuickItemProperty> implements IQuickItem {
/*     */   private static final long serialVersionUID = -990546304L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IItem _item; private transient IItem _itemSavepoint; private HistoricalList<IQuickItemProperty> _properties; private transient HistoricalList<IQuickItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new QuickItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private QuickItemDAO getDAO_() {
/*  47 */     return (QuickItemDAO)this._daoImpl;
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
/*  71 */       this._events.post(IQuickItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<QuickItemPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((QuickItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 102 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 110 */     if (setItemId_noev(argItemId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IQuickItem.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 123 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 124 */       getDAO_().setItemId(argItemId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<QuickItemPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((QuickItemPropertyModel)it.next()).setItemId_noev(argItemId);
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
/* 155 */       this._events.post(IQuickItem.SET_CREATEDATE, argCreateDate);
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
/* 189 */       this._events.post(IQuickItem.SET_CREATEUSERID, argCreateUserId);
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
/* 223 */       this._events.post(IQuickItem.SET_UPDATEDATE, argUpdateDate);
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
/* 257 */       this._events.post(IQuickItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getOrgCode() {
/* 280 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 288 */     if (setOrgCode_noev(argOrgCode) && 
/* 289 */       this._events != null && 
/* 290 */       postEventsForChanges()) {
/* 291 */       this._events.post(IQuickItem.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 298 */     boolean ev_postable = false;
/*     */     
/* 300 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 301 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 302 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 314 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 322 */     if (setOrgValue_noev(argOrgValue) && 
/* 323 */       this._events != null && 
/* 324 */       postEventsForChanges()) {
/* 325 */       this._events.post(IQuickItem.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 332 */     boolean ev_postable = false;
/*     */     
/* 334 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 335 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 336 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public String getParentId() {
/* 348 */     return getDAO_().getParentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentId(String argParentId) {
/* 356 */     if (setParentId_noev(argParentId) && 
/* 357 */       this._events != null && 
/* 358 */       postEventsForChanges()) {
/* 359 */       this._events.post(IQuickItem.SET_PARENTID, argParentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentId_noev(String argParentId) {
/* 366 */     boolean ev_postable = false;
/*     */     
/* 368 */     if ((getDAO_().getParentId() == null && argParentId != null) || (
/* 369 */       getDAO_().getParentId() != null && !getDAO_().getParentId().equals(argParentId))) {
/* 370 */       getDAO_().setParentId(argParentId);
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
/*     */   public String getDescription() {
/* 382 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 390 */     if (setDescription_noev(argDescription) && 
/* 391 */       this._events != null && 
/* 392 */       postEventsForChanges()) {
/* 393 */       this._events.post(IQuickItem.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 400 */     boolean ev_postable = false;
/*     */     
/* 402 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 403 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 404 */       getDAO_().setDescription(argDescription);
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
/*     */   public String getImageUrl() {
/* 416 */     return getDAO_().getImageUrl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 424 */     if (setImageUrl_noev(argImageUrl) && 
/* 425 */       this._events != null && 
/* 426 */       postEventsForChanges()) {
/* 427 */       this._events.post(IQuickItem.SET_IMAGEURL, argImageUrl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setImageUrl_noev(String argImageUrl) {
/* 434 */     boolean ev_postable = false;
/*     */     
/* 436 */     if ((getDAO_().getImageUrl() == null && argImageUrl != null) || (
/* 437 */       getDAO_().getImageUrl() != null && !getDAO_().getImageUrl().equals(argImageUrl))) {
/* 438 */       getDAO_().setImageUrl(argImageUrl);
/* 439 */       ev_postable = true;
/*     */     } 
/*     */     
/* 442 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 450 */     if (getDAO_().getSortOrder() != null) {
/* 451 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 454 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 463 */     if (setSortOrder_noev(argSortOrder) && 
/* 464 */       this._events != null && 
/* 465 */       postEventsForChanges()) {
/* 466 */       this._events.post(IQuickItem.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 473 */     boolean ev_postable = false;
/*     */     
/* 475 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 476 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 477 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 478 */       ev_postable = true;
/*     */     } 
/*     */     
/* 481 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IQuickItemProperty newProperty(String argPropertyName) {
/* 485 */     QuickItemPropertyId id = new QuickItemPropertyId();
/*     */     
/* 487 */     id.setItemId(getItemId());
/* 488 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 490 */     IQuickItemProperty prop = (IQuickItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IQuickItemProperty.class);
/* 491 */     return prop;
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
/* 503 */     return this._item;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItem(IItem argItem) {
/* 508 */     if (argItem == null) {
/*     */       
/* 510 */       if (this._item != null) {
/* 511 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 514 */       if (this._item != null)
/*     */       {
/* 516 */         if (postEventsForChanges()) {
/* 517 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 523 */     else if (postEventsForChanges()) {
/* 524 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*     */     } 
/*     */ 
/*     */     
/* 528 */     this._item = argItem;
/* 529 */     if (postEventsForChanges()) {
/* 530 */       this._events.post(IQuickItem.SET_ITEM, argItem);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IQuickItemProperty> getProperties() {
/* 536 */     if (this._properties == null) {
/* 537 */       this._properties = new HistoricalList(null);
/*     */     }
/* 539 */     return (List<IQuickItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IQuickItemProperty> argProperties) {
/* 543 */     if (this._properties == null) {
/* 544 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 546 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 549 */     for (IQuickItemProperty child : this._properties) {
/* 550 */       QuickItemPropertyModel model = (QuickItemPropertyModel)child;
/* 551 */       model.setOrganizationId_noev(getOrganizationId());
/* 552 */       model.setItemId_noev(getItemId());
/* 553 */       if (child instanceof IDataModelImpl) {
/* 554 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 555 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 556 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 557 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 560 */       if (postEventsForChanges()) {
/* 561 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addQuickItemProperty(IQuickItemProperty argQuickItemProperty) {
/* 567 */     if (this._properties == null) {
/* 568 */       this._properties = new HistoricalList(null);
/*     */     }
/* 570 */     argQuickItemProperty.setOrganizationId(getOrganizationId());
/* 571 */     argQuickItemProperty.setItemId(getItemId());
/* 572 */     if (argQuickItemProperty instanceof IDataModelImpl) {
/* 573 */       IDataAccessObject childDao = ((IDataModelImpl)argQuickItemProperty).getDAO();
/* 574 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 575 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 576 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 581 */     if (postEventsForChanges()) {
/* 582 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argQuickItemProperty));
/*     */     }
/*     */     
/* 585 */     this._properties.add(argQuickItemProperty);
/* 586 */     if (postEventsForChanges()) {
/* 587 */       this._events.post(IQuickItem.ADD_PROPERTIES, argQuickItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeQuickItemProperty(IQuickItemProperty argQuickItemProperty) {
/* 592 */     if (this._properties != null) {
/*     */       
/* 594 */       if (postEventsForChanges()) {
/* 595 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argQuickItemProperty));
/*     */       }
/* 597 */       this._properties.remove(argQuickItemProperty);
/* 598 */       if (postEventsForChanges()) {
/* 599 */         this._events.post(IQuickItem.REMOVE_PROPERTIES, argQuickItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 606 */     if ("Item".equals(argFieldId)) {
/* 607 */       return getItem();
/*     */     }
/* 609 */     if ("Properties".equals(argFieldId)) {
/* 610 */       return getProperties();
/*     */     }
/* 612 */     if ("QuickItemExtension".equals(argFieldId)) {
/* 613 */       return this._myExtension;
/*     */     }
/*     */     
/* 616 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 622 */     if ("Item".equals(argFieldId)) {
/* 623 */       setItem((IItem)argValue);
/*     */     }
/* 625 */     else if ("Properties".equals(argFieldId)) {
/* 626 */       setProperties(changeToList(argValue, IQuickItemProperty.class));
/*     */     }
/* 628 */     else if ("QuickItemExtension".equals(argFieldId)) {
/* 629 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 632 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 638 */     this._persistenceDefaults = argPD;
/* 639 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 640 */     this._eventManager = argEM;
/* 641 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 642 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 643 */     if (this._item != null) {
/* 644 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*     */     }
/* 646 */     if (this._properties != null) {
/* 647 */       for (IQuickItemProperty relationship : this._properties) {
/* 648 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getQuickItemExt() {
/* 654 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setQuickItemExt(IDataModel argExt) {
/* 658 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 663 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 667 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 670 */     super.startTransaction();
/*     */     
/* 672 */     this._itemSavepoint = this._item;
/* 673 */     if (this._item != null) {
/* 674 */       this._item.startTransaction();
/*     */     }
/*     */     
/* 677 */     this._propertiesSavepoint = this._properties;
/* 678 */     if (this._properties != null) {
/* 679 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 680 */       Iterator<IDataModel> it = this._properties.iterator();
/* 681 */       while (it.hasNext()) {
/* 682 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 687 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 692 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 695 */     super.rollbackChanges();
/*     */     
/* 697 */     this._item = this._itemSavepoint;
/* 698 */     this._itemSavepoint = null;
/* 699 */     if (this._item != null) {
/* 700 */       this._item.rollbackChanges();
/*     */     }
/*     */     
/* 703 */     this._properties = this._propertiesSavepoint;
/* 704 */     this._propertiesSavepoint = null;
/* 705 */     if (this._properties != null) {
/* 706 */       Iterator<IDataModel> it = this._properties.iterator();
/* 707 */       while (it.hasNext()) {
/* 708 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 716 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 719 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 722 */     super.commitTransaction();
/*     */     
/* 724 */     this._itemSavepoint = this._item;
/* 725 */     if (this._item != null) {
/* 726 */       this._item.commitTransaction();
/*     */     }
/*     */     
/* 729 */     this._propertiesSavepoint = this._properties;
/* 730 */     if (this._properties != null) {
/* 731 */       Iterator<IDataModel> it = this._properties.iterator();
/* 732 */       while (it.hasNext()) {
/* 733 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 735 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 739 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 744 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\QuickItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */