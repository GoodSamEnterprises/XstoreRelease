/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
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
/*     */ import dtv.xst.dao.itm.IItemDimensionType;
/*     */ import dtv.xst.dao.itm.IItemDimensionValue;
/*     */ import dtv.xst.dao.itm.IItemDimensionValueProperty;
/*     */ import dtv.xst.dao.itm.ItemDimensionValuePropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemDimensionValueModel
/*     */   extends ItemDimensionValueBaseModel implements IItemDimensionValue {
/*     */   private static final long serialVersionUID = -1859499586L;
/*     */   private IItemDimensionType _parentDimensionType;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IItemDimensionValueProperty> _properties; private transient HistoricalList<IItemDimensionValueProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new ItemDimensionValueDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemDimensionValueDAO getDAO_() {
/*  49 */     return (ItemDimensionValueDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(IItemDimensionValue.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<ItemDimensionValuePropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((ItemDimensionValuePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimensionSystem() {
/* 104 */     return getDAO_().getDimensionSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/* 112 */     if (setDimensionSystem_noev(argDimensionSystem) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(IItemDimensionValue.SET_DIMENSIONSYSTEM, argDimensionSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDimensionSystem_noev(String argDimensionSystem) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getDimensionSystem() == null && argDimensionSystem != null) || (
/* 125 */       getDAO_().getDimensionSystem() != null && !getDAO_().getDimensionSystem().equals(argDimensionSystem))) {
/* 126 */       getDAO_().setDimensionSystem(argDimensionSystem);
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<ItemDimensionValuePropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((ItemDimensionValuePropertyModel)it.next()).setDimensionSystem_noev(argDimensionSystem);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension() {
/* 146 */     return getDAO_().getDimension();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension(String argDimension) {
/* 154 */     if (setDimension_noev(argDimension) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(IItemDimensionValue.SET_DIMENSION, argDimension);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDimension_noev(String argDimension) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getDimension() == null && argDimension != null) || (
/* 167 */       getDAO_().getDimension() != null && !getDAO_().getDimension().equals(argDimension))) {
/* 168 */       getDAO_().setDimension(argDimension);
/* 169 */       ev_postable = true;
/* 170 */       if (this._properties != null) {
/*     */         
/* 172 */         Iterator<ItemDimensionValuePropertyModel> it = this._properties.iterator();
/* 173 */         while (it.hasNext())
/*     */         {
/* 175 */           ((ItemDimensionValuePropertyModel)it.next()).setDimension_noev(argDimension);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimensionValue() {
/* 188 */     return getDAO_().getDimensionValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimensionValue(String argDimensionValue) {
/* 196 */     if (setDimensionValue_noev(argDimensionValue) && 
/* 197 */       this._events != null && 
/* 198 */       postEventsForChanges()) {
/* 199 */       this._events.post(IItemDimensionValue.SET_DIMENSIONVALUE, argDimensionValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDimensionValue_noev(String argDimensionValue) {
/* 206 */     boolean ev_postable = false;
/*     */     
/* 208 */     if ((getDAO_().getDimensionValue() == null && argDimensionValue != null) || (
/* 209 */       getDAO_().getDimensionValue() != null && !getDAO_().getDimensionValue().equals(argDimensionValue))) {
/* 210 */       getDAO_().setDimensionValue(argDimensionValue);
/* 211 */       ev_postable = true;
/* 212 */       if (this._properties != null) {
/*     */         
/* 214 */         Iterator<ItemDimensionValuePropertyModel> it = this._properties.iterator();
/* 215 */         while (it.hasNext())
/*     */         {
/* 217 */           ((ItemDimensionValuePropertyModel)it.next()).setDimensionValue_noev(argDimensionValue);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 222 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 230 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 238 */     if (setOrgCode_noev(argOrgCode) && 
/* 239 */       this._events != null && 
/* 240 */       postEventsForChanges()) {
/* 241 */       this._events.post(IItemDimensionValue.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 248 */     boolean ev_postable = false;
/*     */     
/* 250 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 251 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 252 */       getDAO_().setOrgCode(argOrgCode);
/* 253 */       ev_postable = true;
/*     */     } 
/*     */     
/* 256 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 264 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 272 */     if (setOrgValue_noev(argOrgValue) && 
/* 273 */       this._events != null && 
/* 274 */       postEventsForChanges()) {
/* 275 */       this._events.post(IItemDimensionValue.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 282 */     boolean ev_postable = false;
/*     */     
/* 284 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 285 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 286 */       getDAO_().setOrgValue(argOrgValue);
/* 287 */       ev_postable = true;
/*     */     } 
/*     */     
/* 290 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 298 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 306 */     if (setCreateDate_noev(argCreateDate) && 
/* 307 */       this._events != null && 
/* 308 */       postEventsForChanges()) {
/* 309 */       this._events.post(IItemDimensionValue.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 316 */     boolean ev_postable = false;
/*     */     
/* 318 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 319 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 320 */       getDAO_().setCreateDate(argCreateDate);
/* 321 */       ev_postable = true;
/*     */     } 
/*     */     
/* 324 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 332 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 340 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 341 */       this._events != null && 
/* 342 */       postEventsForChanges()) {
/* 343 */       this._events.post(IItemDimensionValue.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 350 */     boolean ev_postable = false;
/*     */     
/* 352 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 353 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 354 */       getDAO_().setCreateUserId(argCreateUserId);
/* 355 */       ev_postable = true;
/*     */     } 
/*     */     
/* 358 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 366 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 374 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 375 */       this._events != null && 
/* 376 */       postEventsForChanges()) {
/* 377 */       this._events.post(IItemDimensionValue.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 384 */     boolean ev_postable = false;
/*     */     
/* 386 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 387 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 388 */       getDAO_().setUpdateDate(argUpdateDate);
/* 389 */       ev_postable = true;
/*     */     } 
/*     */     
/* 392 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 400 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 408 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 409 */       this._events != null && 
/* 410 */       postEventsForChanges()) {
/* 411 */       this._events.post(IItemDimensionValue.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 418 */     boolean ev_postable = false;
/*     */     
/* 420 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 421 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 422 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 423 */       ev_postable = true;
/*     */     } 
/*     */     
/* 426 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 434 */     if (getDAO_().getSortOrder() != null) {
/* 435 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 438 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 447 */     if (setSortOrder_noev(argSortOrder) && 
/* 448 */       this._events != null && 
/* 449 */       postEventsForChanges()) {
/* 450 */       this._events.post(IItemDimensionValue.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 457 */     boolean ev_postable = false;
/*     */     
/* 459 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 460 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 461 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 462 */       ev_postable = true;
/*     */     } 
/*     */     
/* 465 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 473 */     if (setDescription_noev(argDescription) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(IItemDimensionValue.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 486 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 487 */       getDAO_().setDescription(argDescription);
/* 488 */       ev_postable = true;
/*     */     } 
/*     */     
/* 491 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemDimensionValueProperty newProperty(String argPropertyName) {
/* 495 */     ItemDimensionValuePropertyId id = new ItemDimensionValuePropertyId();
/*     */     
/* 497 */     id.setDimensionSystem(getDimensionSystem());
/* 498 */     id.setDimension(getDimension());
/* 499 */     id.setDimensionValue(getDimensionValue());
/* 500 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 502 */     IItemDimensionValueProperty prop = (IItemDimensionValueProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemDimensionValueProperty.class);
/* 503 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemDimensionValueProperty> getProperties() {
/* 512 */     if (this._properties == null) {
/* 513 */       this._properties = new HistoricalList(null);
/*     */     }
/* 515 */     return (List<IItemDimensionValueProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemDimensionValueProperty> argProperties) {
/* 519 */     if (this._properties == null) {
/* 520 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 522 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 525 */     for (IItemDimensionValueProperty child : this._properties) {
/* 526 */       ItemDimensionValuePropertyModel model = (ItemDimensionValuePropertyModel)child;
/* 527 */       model.setOrganizationId_noev(getOrganizationId());
/* 528 */       model.setDimensionSystem_noev(getDimensionSystem());
/* 529 */       model.setDimension_noev(getDimension());
/* 530 */       model.setDimensionValue_noev(getDimensionValue());
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
/*     */   public void addItemDimensionValueProperty(IItemDimensionValueProperty argItemDimensionValueProperty) {
/* 545 */     if (this._properties == null) {
/* 546 */       this._properties = new HistoricalList(null);
/*     */     }
/* 548 */     argItemDimensionValueProperty.setOrganizationId(getOrganizationId());
/* 549 */     argItemDimensionValueProperty.setDimensionSystem(getDimensionSystem());
/* 550 */     argItemDimensionValueProperty.setDimension(getDimension());
/* 551 */     argItemDimensionValueProperty.setDimensionValue(getDimensionValue());
/* 552 */     if (argItemDimensionValueProperty instanceof IDataModelImpl) {
/* 553 */       IDataAccessObject childDao = ((IDataModelImpl)argItemDimensionValueProperty).getDAO();
/* 554 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 555 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 556 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 561 */     if (postEventsForChanges()) {
/* 562 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionValueProperty));
/*     */     }
/*     */     
/* 565 */     this._properties.add(argItemDimensionValueProperty);
/* 566 */     if (postEventsForChanges()) {
/* 567 */       this._events.post(IItemDimensionValue.ADD_PROPERTIES, argItemDimensionValueProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemDimensionValueProperty(IItemDimensionValueProperty argItemDimensionValueProperty) {
/* 572 */     if (this._properties != null) {
/*     */       
/* 574 */       if (postEventsForChanges()) {
/* 575 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionValueProperty));
/*     */       }
/* 577 */       this._properties.remove(argItemDimensionValueProperty);
/* 578 */       if (postEventsForChanges()) {
/* 579 */         this._events.post(IItemDimensionValue.REMOVE_PROPERTIES, argItemDimensionValueProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentDimensionType(IItemDimensionType argParentDimensionType) {
/* 585 */     this._parentDimensionType = argParentDimensionType;
/*     */   }
/*     */   
/*     */   public IItemDimensionType getParentDimensionType() {
/* 589 */     return this._parentDimensionType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 594 */     if ("Properties".equals(argFieldId)) {
/* 595 */       return getProperties();
/*     */     }
/* 597 */     if ("ItemDimensionValueExtension".equals(argFieldId)) {
/* 598 */       return this._myExtension;
/*     */     }
/*     */     
/* 601 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 607 */     if ("Properties".equals(argFieldId)) {
/* 608 */       setProperties(changeToList(argValue, IItemDimensionValueProperty.class));
/*     */     }
/* 610 */     else if ("ItemDimensionValueExtension".equals(argFieldId)) {
/* 611 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 614 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 620 */     this._persistenceDefaults = argPD;
/* 621 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 622 */     this._eventManager = argEM;
/* 623 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 624 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 625 */     if (this._properties != null) {
/* 626 */       for (IItemDimensionValueProperty relationship : this._properties) {
/* 627 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemDimensionValueExt() {
/* 633 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemDimensionValueExt(IDataModel argExt) {
/* 637 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 642 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 646 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 649 */     super.startTransaction();
/*     */     
/* 651 */     this._propertiesSavepoint = this._properties;
/* 652 */     if (this._properties != null) {
/* 653 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 654 */       Iterator<IDataModel> it = this._properties.iterator();
/* 655 */       while (it.hasNext()) {
/* 656 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 661 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 666 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 669 */     super.rollbackChanges();
/*     */     
/* 671 */     this._properties = this._propertiesSavepoint;
/* 672 */     this._propertiesSavepoint = null;
/* 673 */     if (this._properties != null) {
/* 674 */       Iterator<IDataModel> it = this._properties.iterator();
/* 675 */       while (it.hasNext()) {
/* 676 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 684 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 687 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 690 */     super.commitTransaction();
/*     */     
/* 692 */     this._propertiesSavepoint = this._properties;
/* 693 */     if (this._properties != null) {
/* 694 */       Iterator<IDataModel> it = this._properties.iterator();
/* 695 */       while (it.hasNext()) {
/* 696 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 698 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 702 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionValueModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */