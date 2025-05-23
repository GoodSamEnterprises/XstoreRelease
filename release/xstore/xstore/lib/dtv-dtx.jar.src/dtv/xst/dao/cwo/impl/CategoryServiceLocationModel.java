/*     */ package dtv.xst.dao.cwo.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
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
/*     */ import dtv.xst.dao.cwo.CategoryServiceLocationPropertyId;
/*     */ import dtv.xst.dao.cwo.ICategoryServiceLocation;
/*     */ import dtv.xst.dao.cwo.ICategoryServiceLocationProperty;
/*     */ import dtv.xst.dao.cwo.IServiceLocation;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CategoryServiceLocationModel extends AbstractDataModelWithPropertyImpl<ICategoryServiceLocationProperty> implements ICategoryServiceLocation {
/*     */   private static final long serialVersionUID = 2138160268L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IServiceLocation _categoryServiceLocation; private transient IServiceLocation _categoryServiceLocationSavepoint; private HistoricalList<ICategoryServiceLocationProperty> _properties; private transient HistoricalList<ICategoryServiceLocationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new CategoryServiceLocationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CategoryServiceLocationDAO getDAO_() {
/*  47 */     return (CategoryServiceLocationDAO)this._daoImpl;
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
/*  71 */       this._events.post(ICategoryServiceLocation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<CategoryServiceLocationPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((CategoryServiceLocationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getServiceLocationId() {
/* 102 */     return getDAO_().getServiceLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/* 110 */     if (setServiceLocationId_noev(argServiceLocationId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(ICategoryServiceLocation.SET_SERVICELOCATIONID, argServiceLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setServiceLocationId_noev(String argServiceLocationId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getServiceLocationId() == null && argServiceLocationId != null) || (
/* 123 */       getDAO_().getServiceLocationId() != null && !getDAO_().getServiceLocationId().equals(argServiceLocationId))) {
/* 124 */       getDAO_().setServiceLocationId(argServiceLocationId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<CategoryServiceLocationPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((CategoryServiceLocationPropertyModel)it.next()).setServiceLocationId_noev(argServiceLocationId);
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
/*     */   public String getCategoryId() {
/* 144 */     return getDAO_().getCategoryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategoryId(String argCategoryId) {
/* 152 */     if (setCategoryId_noev(argCategoryId) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(ICategoryServiceLocation.SET_CATEGORYID, argCategoryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCategoryId_noev(String argCategoryId) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getCategoryId() == null && argCategoryId != null) || (
/* 165 */       getDAO_().getCategoryId() != null && !getDAO_().getCategoryId().equals(argCategoryId))) {
/* 166 */       getDAO_().setCategoryId(argCategoryId);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<CategoryServiceLocationPropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((CategoryServiceLocationPropertyModel)it.next()).setCategoryId_noev(argCategoryId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 186 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 194 */     if (setCreateDate_noev(argCreateDate) && 
/* 195 */       this._events != null && 
/* 196 */       postEventsForChanges()) {
/* 197 */       this._events.post(ICategoryServiceLocation.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 204 */     boolean ev_postable = false;
/*     */     
/* 206 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 207 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 208 */       getDAO_().setCreateDate(argCreateDate);
/* 209 */       ev_postable = true;
/*     */     } 
/*     */     
/* 212 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 220 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 228 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 229 */       this._events != null && 
/* 230 */       postEventsForChanges()) {
/* 231 */       this._events.post(ICategoryServiceLocation.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 238 */     boolean ev_postable = false;
/*     */     
/* 240 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 241 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 242 */       getDAO_().setCreateUserId(argCreateUserId);
/* 243 */       ev_postable = true;
/*     */     } 
/*     */     
/* 246 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 254 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 262 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 263 */       this._events != null && 
/* 264 */       postEventsForChanges()) {
/* 265 */       this._events.post(ICategoryServiceLocation.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 272 */     boolean ev_postable = false;
/*     */     
/* 274 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 275 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 276 */       getDAO_().setUpdateDate(argUpdateDate);
/* 277 */       ev_postable = true;
/*     */     } 
/*     */     
/* 280 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 288 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 296 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 297 */       this._events != null && 
/* 298 */       postEventsForChanges()) {
/* 299 */       this._events.post(ICategoryServiceLocation.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 306 */     boolean ev_postable = false;
/*     */     
/* 308 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 309 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 310 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 311 */       ev_postable = true;
/*     */     } 
/*     */     
/* 314 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 322 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 330 */     if (setOrgCode_noev(argOrgCode) && 
/* 331 */       this._events != null && 
/* 332 */       postEventsForChanges()) {
/* 333 */       this._events.post(ICategoryServiceLocation.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 340 */     boolean ev_postable = false;
/*     */     
/* 342 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 343 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 344 */       getDAO_().setOrgCode(argOrgCode);
/* 345 */       ev_postable = true;
/*     */     } 
/*     */     
/* 348 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 356 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 364 */     if (setOrgValue_noev(argOrgValue) && 
/* 365 */       this._events != null && 
/* 366 */       postEventsForChanges()) {
/* 367 */       this._events.post(ICategoryServiceLocation.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 374 */     boolean ev_postable = false;
/*     */     
/* 376 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 377 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 378 */       getDAO_().setOrgValue(argOrgValue);
/* 379 */       ev_postable = true;
/*     */     } 
/*     */     
/* 382 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getLeadTimeQuantity() {
/* 390 */     return getDAO_().getLeadTimeQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeadTimeQuantity(BigDecimal argLeadTimeQuantity) {
/* 398 */     if (setLeadTimeQuantity_noev(argLeadTimeQuantity) && 
/* 399 */       this._events != null && 
/* 400 */       postEventsForChanges()) {
/* 401 */       this._events.post(ICategoryServiceLocation.SET_LEADTIMEQUANTITY, argLeadTimeQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLeadTimeQuantity_noev(BigDecimal argLeadTimeQuantity) {
/* 408 */     boolean ev_postable = false;
/*     */     
/* 410 */     if ((getDAO_().getLeadTimeQuantity() == null && argLeadTimeQuantity != null) || (
/* 411 */       getDAO_().getLeadTimeQuantity() != null && !getDAO_().getLeadTimeQuantity().equals(argLeadTimeQuantity))) {
/* 412 */       getDAO_().setLeadTimeQuantity(argLeadTimeQuantity);
/* 413 */       ev_postable = true;
/*     */     } 
/*     */     
/* 416 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLeadTimeUnit() {
/* 424 */     return getDAO_().getLeadTimeUnit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeadTimeUnit(String argLeadTimeUnit) {
/* 432 */     if (setLeadTimeUnit_noev(argLeadTimeUnit) && 
/* 433 */       this._events != null && 
/* 434 */       postEventsForChanges()) {
/* 435 */       this._events.post(ICategoryServiceLocation.SET_LEADTIMEUNIT, argLeadTimeUnit);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLeadTimeUnit_noev(String argLeadTimeUnit) {
/* 442 */     boolean ev_postable = false;
/*     */     
/* 444 */     if ((getDAO_().getLeadTimeUnit() == null && argLeadTimeUnit != null) || (
/* 445 */       getDAO_().getLeadTimeUnit() != null && !getDAO_().getLeadTimeUnit().equals(argLeadTimeUnit))) {
/* 446 */       getDAO_().setLeadTimeUnit(argLeadTimeUnit);
/* 447 */       ev_postable = true;
/*     */     } 
/*     */     
/* 450 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCreateShipment() {
/* 458 */     if (getDAO_().getCreateShipment() != null) {
/* 459 */       return getDAO_().getCreateShipment().booleanValue();
/*     */     }
/*     */     
/* 462 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateShipment(boolean argCreateShipment) {
/* 471 */     if (setCreateShipment_noev(argCreateShipment) && 
/* 472 */       this._events != null && 
/* 473 */       postEventsForChanges()) {
/* 474 */       this._events.post(ICategoryServiceLocation.SET_CREATESHIPMENT, Boolean.valueOf(argCreateShipment));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateShipment_noev(boolean argCreateShipment) {
/* 481 */     boolean ev_postable = false;
/*     */     
/* 483 */     if ((getDAO_().getCreateShipment() == null && Boolean.valueOf(argCreateShipment) != null) || (
/* 484 */       getDAO_().getCreateShipment() != null && !getDAO_().getCreateShipment().equals(Boolean.valueOf(argCreateShipment)))) {
/* 485 */       getDAO_().setCreateShipment(Boolean.valueOf(argCreateShipment));
/* 486 */       ev_postable = true;
/*     */     } 
/*     */     
/* 489 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICategoryServiceLocationProperty newProperty(String argPropertyName) {
/* 493 */     CategoryServiceLocationPropertyId id = new CategoryServiceLocationPropertyId();
/*     */     
/* 495 */     id.setServiceLocationId(getServiceLocationId());
/* 496 */     id.setCategoryId(getCategoryId());
/* 497 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 499 */     ICategoryServiceLocationProperty prop = (ICategoryServiceLocationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICategoryServiceLocationProperty.class);
/* 500 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "CategoryServiceLocation")
/*     */   public IServiceLocation getCategoryServiceLocation() {
/* 512 */     return this._categoryServiceLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCategoryServiceLocation(IServiceLocation argCategoryServiceLocation) {
/* 517 */     if (argCategoryServiceLocation == null) {
/*     */       
/* 519 */       if (this._categoryServiceLocation != null) {
/* 520 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 523 */       if (this._categoryServiceLocation != null)
/*     */       {
/* 525 */         if (postEventsForChanges()) {
/* 526 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._categoryServiceLocation));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 532 */     else if (postEventsForChanges()) {
/* 533 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCategoryServiceLocation));
/*     */     } 
/*     */ 
/*     */     
/* 537 */     this._categoryServiceLocation = argCategoryServiceLocation;
/* 538 */     if (postEventsForChanges()) {
/* 539 */       this._events.post(ICategoryServiceLocation.SET_CATEGORYSERVICELOCATION, argCategoryServiceLocation);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICategoryServiceLocationProperty> getProperties() {
/* 545 */     if (this._properties == null) {
/* 546 */       this._properties = new HistoricalList(null);
/*     */     }
/* 548 */     return (List<ICategoryServiceLocationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICategoryServiceLocationProperty> argProperties) {
/* 552 */     if (this._properties == null) {
/* 553 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 555 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 558 */     for (ICategoryServiceLocationProperty child : this._properties) {
/* 559 */       CategoryServiceLocationPropertyModel model = (CategoryServiceLocationPropertyModel)child;
/* 560 */       model.setOrganizationId_noev(getOrganizationId());
/* 561 */       model.setServiceLocationId_noev(getServiceLocationId());
/* 562 */       model.setCategoryId_noev(getCategoryId());
/* 563 */       if (child instanceof IDataModelImpl) {
/* 564 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 565 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 566 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 567 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 570 */       if (postEventsForChanges()) {
/* 571 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCategoryServiceLocationProperty(ICategoryServiceLocationProperty argCategoryServiceLocationProperty) {
/* 577 */     if (this._properties == null) {
/* 578 */       this._properties = new HistoricalList(null);
/*     */     }
/* 580 */     argCategoryServiceLocationProperty.setOrganizationId(getOrganizationId());
/* 581 */     argCategoryServiceLocationProperty.setServiceLocationId(getServiceLocationId());
/* 582 */     argCategoryServiceLocationProperty.setCategoryId(getCategoryId());
/* 583 */     if (argCategoryServiceLocationProperty instanceof IDataModelImpl) {
/* 584 */       IDataAccessObject childDao = ((IDataModelImpl)argCategoryServiceLocationProperty).getDAO();
/* 585 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 586 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 587 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 592 */     if (postEventsForChanges()) {
/* 593 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCategoryServiceLocationProperty));
/*     */     }
/*     */     
/* 596 */     this._properties.add(argCategoryServiceLocationProperty);
/* 597 */     if (postEventsForChanges()) {
/* 598 */       this._events.post(ICategoryServiceLocation.ADD_PROPERTIES, argCategoryServiceLocationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCategoryServiceLocationProperty(ICategoryServiceLocationProperty argCategoryServiceLocationProperty) {
/* 603 */     if (this._properties != null) {
/*     */       
/* 605 */       if (postEventsForChanges()) {
/* 606 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCategoryServiceLocationProperty));
/*     */       }
/* 608 */       this._properties.remove(argCategoryServiceLocationProperty);
/* 609 */       if (postEventsForChanges()) {
/* 610 */         this._events.post(ICategoryServiceLocation.REMOVE_PROPERTIES, argCategoryServiceLocationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 617 */     if ("CategoryServiceLocation".equals(argFieldId)) {
/* 618 */       return getCategoryServiceLocation();
/*     */     }
/* 620 */     if ("Properties".equals(argFieldId)) {
/* 621 */       return getProperties();
/*     */     }
/* 623 */     if ("CategoryServiceLocationExtension".equals(argFieldId)) {
/* 624 */       return this._myExtension;
/*     */     }
/*     */     
/* 627 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 633 */     if ("CategoryServiceLocation".equals(argFieldId)) {
/* 634 */       setCategoryServiceLocation((IServiceLocation)argValue);
/*     */     }
/* 636 */     else if ("Properties".equals(argFieldId)) {
/* 637 */       setProperties(changeToList(argValue, ICategoryServiceLocationProperty.class));
/*     */     }
/* 639 */     else if ("CategoryServiceLocationExtension".equals(argFieldId)) {
/* 640 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 643 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 649 */     this._persistenceDefaults = argPD;
/* 650 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 651 */     this._eventManager = argEM;
/* 652 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 653 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 654 */     if (this._categoryServiceLocation != null) {
/* 655 */       ((IDataModelImpl)this._categoryServiceLocation).setDependencies(argPD, argEM);
/*     */     }
/* 657 */     if (this._properties != null) {
/* 658 */       for (ICategoryServiceLocationProperty relationship : this._properties) {
/* 659 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCategoryServiceLocationExt() {
/* 665 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCategoryServiceLocationExt(IDataModel argExt) {
/* 669 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 674 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 678 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 681 */     super.startTransaction();
/*     */     
/* 683 */     this._categoryServiceLocationSavepoint = this._categoryServiceLocation;
/* 684 */     if (this._categoryServiceLocation != null) {
/* 685 */       this._categoryServiceLocation.startTransaction();
/*     */     }
/*     */     
/* 688 */     this._propertiesSavepoint = this._properties;
/* 689 */     if (this._properties != null) {
/* 690 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 691 */       Iterator<IDataModel> it = this._properties.iterator();
/* 692 */       while (it.hasNext()) {
/* 693 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 698 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 703 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 706 */     super.rollbackChanges();
/*     */     
/* 708 */     this._categoryServiceLocation = this._categoryServiceLocationSavepoint;
/* 709 */     this._categoryServiceLocationSavepoint = null;
/* 710 */     if (this._categoryServiceLocation != null) {
/* 711 */       this._categoryServiceLocation.rollbackChanges();
/*     */     }
/*     */     
/* 714 */     this._properties = this._propertiesSavepoint;
/* 715 */     this._propertiesSavepoint = null;
/* 716 */     if (this._properties != null) {
/* 717 */       Iterator<IDataModel> it = this._properties.iterator();
/* 718 */       while (it.hasNext()) {
/* 719 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 727 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 730 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 733 */     super.commitTransaction();
/*     */     
/* 735 */     this._categoryServiceLocationSavepoint = this._categoryServiceLocation;
/* 736 */     if (this._categoryServiceLocation != null) {
/* 737 */       this._categoryServiceLocation.commitTransaction();
/*     */     }
/*     */     
/* 740 */     this._propertiesSavepoint = this._properties;
/* 741 */     if (this._properties != null) {
/* 742 */       Iterator<IDataModel> it = this._properties.iterator();
/* 743 */       while (it.hasNext()) {
/* 744 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 746 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 750 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 755 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\CategoryServiceLocationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */