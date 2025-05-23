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
/*     */ import dtv.xst.dao.itm.IItemRestrictionMapping;
/*     */ import dtv.xst.dao.itm.IItemRestrictionMappingProperty;
/*     */ import dtv.xst.dao.itm.ItemRestrictionMappingPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemRestrictionMappingModel extends AbstractDataModelWithPropertyImpl<IItemRestrictionMappingProperty> implements IItemRestrictionMapping {
/*     */   private static final long serialVersionUID = 1762616309L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IItemRestrictionMappingProperty> _properties; private transient HistoricalList<IItemRestrictionMappingProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ItemRestrictionMappingDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemRestrictionMappingDAO getDAO_() {
/*  46 */     return (ItemRestrictionMappingDAO)this._daoImpl;
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
/*  70 */       this._events.post(IItemRestrictionMapping.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ItemRestrictionMappingPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ItemRestrictionMappingPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getMerchHierarchyLevel() {
/* 101 */     return getDAO_().getMerchHierarchyLevel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchHierarchyLevel(String argMerchHierarchyLevel) {
/* 109 */     if (setMerchHierarchyLevel_noev(argMerchHierarchyLevel) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IItemRestrictionMapping.SET_MERCHHIERARCHYLEVEL, argMerchHierarchyLevel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMerchHierarchyLevel_noev(String argMerchHierarchyLevel) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getMerchHierarchyLevel() == null && argMerchHierarchyLevel != null) || (
/* 122 */       getDAO_().getMerchHierarchyLevel() != null && !getDAO_().getMerchHierarchyLevel().equals(argMerchHierarchyLevel))) {
/* 123 */       getDAO_().setMerchHierarchyLevel(argMerchHierarchyLevel);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ItemRestrictionMappingPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ItemRestrictionMappingPropertyModel)it.next()).setMerchHierarchyLevel_noev(argMerchHierarchyLevel);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchHierarchyId() {
/* 143 */     return getDAO_().getMerchHierarchyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchHierarchyId(String argMerchHierarchyId) {
/* 151 */     if (setMerchHierarchyId_noev(argMerchHierarchyId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IItemRestrictionMapping.SET_MERCHHIERARCHYID, argMerchHierarchyId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMerchHierarchyId_noev(String argMerchHierarchyId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getMerchHierarchyId() == null && argMerchHierarchyId != null) || (
/* 164 */       getDAO_().getMerchHierarchyId() != null && !getDAO_().getMerchHierarchyId().equals(argMerchHierarchyId))) {
/* 165 */       getDAO_().setMerchHierarchyId(argMerchHierarchyId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ItemRestrictionMappingPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ItemRestrictionMappingPropertyModel)it.next()).setMerchHierarchyId_noev(argMerchHierarchyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRestrictionCategory() {
/* 185 */     return getDAO_().getRestrictionCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/* 193 */     if (setRestrictionCategory_noev(argRestrictionCategory) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IItemRestrictionMapping.SET_RESTRICTIONCATEGORY, argRestrictionCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRestrictionCategory_noev(String argRestrictionCategory) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getRestrictionCategory() == null && argRestrictionCategory != null) || (
/* 206 */       getDAO_().getRestrictionCategory() != null && !getDAO_().getRestrictionCategory().equals(argRestrictionCategory))) {
/* 207 */       getDAO_().setRestrictionCategory(argRestrictionCategory);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<ItemRestrictionMappingPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((ItemRestrictionMappingPropertyModel)it.next()).setRestrictionCategory_noev(argRestrictionCategory);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 227 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 235 */     if (setOrgCode_noev(argOrgCode) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IItemRestrictionMapping.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 248 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 249 */       getDAO_().setOrgCode(argOrgCode);
/* 250 */       ev_postable = true;
/*     */     } 
/*     */     
/* 253 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 261 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 269 */     if (setOrgValue_noev(argOrgValue) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IItemRestrictionMapping.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 282 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 283 */       getDAO_().setOrgValue(argOrgValue);
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 295 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 303 */     if (setCreateDate_noev(argCreateDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IItemRestrictionMapping.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 316 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 317 */       getDAO_().setCreateDate(argCreateDate);
/* 318 */       ev_postable = true;
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 329 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 337 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IItemRestrictionMapping.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 350 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 351 */       getDAO_().setCreateUserId(argCreateUserId);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 363 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 371 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IItemRestrictionMapping.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 384 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 385 */       getDAO_().setUpdateDate(argUpdateDate);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 397 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 405 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IItemRestrictionMapping.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 418 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 419 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemRestrictionMappingProperty newProperty(String argPropertyName) {
/* 427 */     ItemRestrictionMappingPropertyId id = new ItemRestrictionMappingPropertyId();
/*     */     
/* 429 */     id.setMerchHierarchyLevel(getMerchHierarchyLevel());
/* 430 */     id.setMerchHierarchyId(getMerchHierarchyId());
/* 431 */     id.setRestrictionCategory(getRestrictionCategory());
/* 432 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 434 */     IItemRestrictionMappingProperty prop = (IItemRestrictionMappingProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemRestrictionMappingProperty.class);
/* 435 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemRestrictionMappingProperty> getProperties() {
/* 444 */     if (this._properties == null) {
/* 445 */       this._properties = new HistoricalList(null);
/*     */     }
/* 447 */     return (List<IItemRestrictionMappingProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemRestrictionMappingProperty> argProperties) {
/* 451 */     if (this._properties == null) {
/* 452 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 454 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 457 */     for (IItemRestrictionMappingProperty child : this._properties) {
/* 458 */       ItemRestrictionMappingPropertyModel model = (ItemRestrictionMappingPropertyModel)child;
/* 459 */       model.setOrganizationId_noev(getOrganizationId());
/* 460 */       model.setMerchHierarchyLevel_noev(getMerchHierarchyLevel());
/* 461 */       model.setMerchHierarchyId_noev(getMerchHierarchyId());
/* 462 */       model.setRestrictionCategory_noev(getRestrictionCategory());
/* 463 */       if (child instanceof IDataModelImpl) {
/* 464 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 465 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 466 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 467 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 470 */       if (postEventsForChanges()) {
/* 471 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemRestrictionMappingProperty(IItemRestrictionMappingProperty argItemRestrictionMappingProperty) {
/* 477 */     if (this._properties == null) {
/* 478 */       this._properties = new HistoricalList(null);
/*     */     }
/* 480 */     argItemRestrictionMappingProperty.setOrganizationId(getOrganizationId());
/* 481 */     argItemRestrictionMappingProperty.setMerchHierarchyLevel(getMerchHierarchyLevel());
/* 482 */     argItemRestrictionMappingProperty.setMerchHierarchyId(getMerchHierarchyId());
/* 483 */     argItemRestrictionMappingProperty.setRestrictionCategory(getRestrictionCategory());
/* 484 */     if (argItemRestrictionMappingProperty instanceof IDataModelImpl) {
/* 485 */       IDataAccessObject childDao = ((IDataModelImpl)argItemRestrictionMappingProperty).getDAO();
/* 486 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 487 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 488 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 493 */     if (postEventsForChanges()) {
/* 494 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictionMappingProperty));
/*     */     }
/*     */     
/* 497 */     this._properties.add(argItemRestrictionMappingProperty);
/* 498 */     if (postEventsForChanges()) {
/* 499 */       this._events.post(IItemRestrictionMapping.ADD_PROPERTIES, argItemRestrictionMappingProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemRestrictionMappingProperty(IItemRestrictionMappingProperty argItemRestrictionMappingProperty) {
/* 504 */     if (this._properties != null) {
/*     */       
/* 506 */       if (postEventsForChanges()) {
/* 507 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictionMappingProperty));
/*     */       }
/* 509 */       this._properties.remove(argItemRestrictionMappingProperty);
/* 510 */       if (postEventsForChanges()) {
/* 511 */         this._events.post(IItemRestrictionMapping.REMOVE_PROPERTIES, argItemRestrictionMappingProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 518 */     if ("Properties".equals(argFieldId)) {
/* 519 */       return getProperties();
/*     */     }
/* 521 */     if ("ItemRestrictionMappingExtension".equals(argFieldId)) {
/* 522 */       return this._myExtension;
/*     */     }
/*     */     
/* 525 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 531 */     if ("Properties".equals(argFieldId)) {
/* 532 */       setProperties(changeToList(argValue, IItemRestrictionMappingProperty.class));
/*     */     }
/* 534 */     else if ("ItemRestrictionMappingExtension".equals(argFieldId)) {
/* 535 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 538 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 544 */     this._persistenceDefaults = argPD;
/* 545 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 546 */     this._eventManager = argEM;
/* 547 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 548 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 549 */     if (this._properties != null) {
/* 550 */       for (IItemRestrictionMappingProperty relationship : this._properties) {
/* 551 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemRestrictionMappingExt() {
/* 557 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemRestrictionMappingExt(IDataModel argExt) {
/* 561 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 566 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 570 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 573 */     super.startTransaction();
/*     */     
/* 575 */     this._propertiesSavepoint = this._properties;
/* 576 */     if (this._properties != null) {
/* 577 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 578 */       Iterator<IDataModel> it = this._properties.iterator();
/* 579 */       while (it.hasNext()) {
/* 580 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 585 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 590 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 593 */     super.rollbackChanges();
/*     */     
/* 595 */     this._properties = this._propertiesSavepoint;
/* 596 */     this._propertiesSavepoint = null;
/* 597 */     if (this._properties != null) {
/* 598 */       Iterator<IDataModel> it = this._properties.iterator();
/* 599 */       while (it.hasNext()) {
/* 600 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 608 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 611 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 614 */     super.commitTransaction();
/*     */     
/* 616 */     this._propertiesSavepoint = this._properties;
/* 617 */     if (this._properties != null) {
/* 618 */       Iterator<IDataModel> it = this._properties.iterator();
/* 619 */       while (it.hasNext()) {
/* 620 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 622 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 626 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 631 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionMappingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */