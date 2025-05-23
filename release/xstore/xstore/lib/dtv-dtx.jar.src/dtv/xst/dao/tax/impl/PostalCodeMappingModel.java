/*     */ package dtv.xst.dao.tax.impl;
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
/*     */ import dtv.xst.dao.tax.IPostalCodeMapping;
/*     */ import dtv.xst.dao.tax.IPostalCodeMappingProperty;
/*     */ import dtv.xst.dao.tax.ITaxLocation;
/*     */ import dtv.xst.dao.tax.PostalCodeMappingPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PostalCodeMappingModel extends AbstractDataModelWithPropertyImpl<IPostalCodeMappingProperty> implements IPostalCodeMapping {
/*     */   private static final long serialVersionUID = -1218085834L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private ITaxLocation _postalTaxLocation; private transient ITaxLocation _postalTaxLocationSavepoint; private HistoricalList<IPostalCodeMappingProperty> _properties; private transient HistoricalList<IPostalCodeMappingProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new PostalCodeMappingDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PostalCodeMappingDAO getDAO_() {
/*  47 */     return (PostalCodeMappingDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/*  55 */     return getDAO_().getCity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCity(String argCity) {
/*  63 */     if (setCity_noev(argCity) && 
/*  64 */       this._events != null && 
/*  65 */       postEventsForChanges()) {
/*  66 */       this._events.post(IPostalCodeMapping.SET_CITY, argCity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCity_noev(String argCity) {
/*  73 */     boolean ev_postable = false;
/*     */     
/*  75 */     if ((getDAO_().getCity() == null && argCity != null) || (
/*  76 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/*  77 */       getDAO_().setCity(argCity);
/*  78 */       ev_postable = true;
/*  79 */       if (this._properties != null) {
/*     */         
/*  81 */         Iterator<PostalCodeMappingPropertyModel> it = this._properties.iterator();
/*  82 */         while (it.hasNext())
/*     */         {
/*  84 */           ((PostalCodeMappingPropertyModel)it.next()).setCity_noev(argCity);
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
/* 113 */       this._events.post(IPostalCodeMapping.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 128 */         Iterator<PostalCodeMappingPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((PostalCodeMappingPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getPostalCode() {
/* 144 */     return getDAO_().getPostalCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 152 */     if (setPostalCode_noev(argPostalCode) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IPostalCodeMapping.SET_POSTALCODE, argPostalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostalCode_noev(String argPostalCode) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/* 165 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/* 166 */       getDAO_().setPostalCode(argPostalCode);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<PostalCodeMappingPropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((PostalCodeMappingPropertyModel)it.next()).setPostalCode_noev(argPostalCode);
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
/*     */   public String getTaxLocationId() {
/* 186 */     return getDAO_().getTaxLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/* 194 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/* 195 */       this._events != null && 
/* 196 */       postEventsForChanges()) {
/* 197 */       this._events.post(IPostalCodeMapping.SET_TAXLOCATIONID, argTaxLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/* 204 */     boolean ev_postable = false;
/*     */     
/* 206 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/* 207 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/* 208 */       getDAO_().setTaxLocationId(argTaxLocationId);
/* 209 */       ev_postable = true;
/* 210 */       if (this._properties != null) {
/*     */         
/* 212 */         Iterator<PostalCodeMappingPropertyModel> it = this._properties.iterator();
/* 213 */         while (it.hasNext())
/*     */         {
/* 215 */           ((PostalCodeMappingPropertyModel)it.next()).setTaxLocationId_noev(argTaxLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 220 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 228 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 236 */     if (setCreateDate_noev(argCreateDate) && 
/* 237 */       this._events != null && 
/* 238 */       postEventsForChanges()) {
/* 239 */       this._events.post(IPostalCodeMapping.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 246 */     boolean ev_postable = false;
/*     */     
/* 248 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 249 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 250 */       getDAO_().setCreateDate(argCreateDate);
/* 251 */       ev_postable = true;
/*     */     } 
/*     */     
/* 254 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 262 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 270 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 271 */       this._events != null && 
/* 272 */       postEventsForChanges()) {
/* 273 */       this._events.post(IPostalCodeMapping.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 280 */     boolean ev_postable = false;
/*     */     
/* 282 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 283 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 284 */       getDAO_().setCreateUserId(argCreateUserId);
/* 285 */       ev_postable = true;
/*     */     } 
/*     */     
/* 288 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 296 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 304 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 305 */       this._events != null && 
/* 306 */       postEventsForChanges()) {
/* 307 */       this._events.post(IPostalCodeMapping.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 314 */     boolean ev_postable = false;
/*     */     
/* 316 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 317 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 318 */       getDAO_().setUpdateDate(argUpdateDate);
/* 319 */       ev_postable = true;
/*     */     } 
/*     */     
/* 322 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 330 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 338 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 339 */       this._events != null && 
/* 340 */       postEventsForChanges()) {
/* 341 */       this._events.post(IPostalCodeMapping.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 348 */     boolean ev_postable = false;
/*     */     
/* 350 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 351 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 352 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 353 */       ev_postable = true;
/*     */     } 
/*     */     
/* 356 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPostalCodeMappingProperty newProperty(String argPropertyName) {
/* 360 */     PostalCodeMappingPropertyId id = new PostalCodeMappingPropertyId();
/*     */     
/* 362 */     id.setCity(getCity());
/* 363 */     id.setPostalCode(getPostalCode());
/* 364 */     id.setTaxLocationId(getTaxLocationId());
/* 365 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 367 */     IPostalCodeMappingProperty prop = (IPostalCodeMappingProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPostalCodeMappingProperty.class);
/* 368 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "PostalTaxLocation")
/*     */   public ITaxLocation getPostalTaxLocation() {
/* 380 */     return this._postalTaxLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPostalTaxLocation(ITaxLocation argPostalTaxLocation) {
/* 385 */     if (argPostalTaxLocation == null) {
/*     */       
/* 387 */       if (this._postalTaxLocation != null) {
/* 388 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 391 */       if (this._postalTaxLocation != null)
/*     */       {
/* 393 */         if (postEventsForChanges()) {
/* 394 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._postalTaxLocation));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 400 */     else if (postEventsForChanges()) {
/* 401 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPostalTaxLocation));
/*     */     } 
/*     */ 
/*     */     
/* 405 */     this._postalTaxLocation = argPostalTaxLocation;
/* 406 */     if (postEventsForChanges()) {
/* 407 */       this._events.post(IPostalCodeMapping.SET_POSTALTAXLOCATION, argPostalTaxLocation);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPostalCodeMappingProperty> getProperties() {
/* 413 */     if (this._properties == null) {
/* 414 */       this._properties = new HistoricalList(null);
/*     */     }
/* 416 */     return (List<IPostalCodeMappingProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPostalCodeMappingProperty> argProperties) {
/* 420 */     if (this._properties == null) {
/* 421 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 423 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 426 */     for (IPostalCodeMappingProperty child : this._properties) {
/* 427 */       PostalCodeMappingPropertyModel model = (PostalCodeMappingPropertyModel)child;
/* 428 */       model.setCity_noev(getCity());
/* 429 */       model.setOrganizationId_noev(getOrganizationId());
/* 430 */       model.setPostalCode_noev(getPostalCode());
/* 431 */       model.setTaxLocationId_noev(getTaxLocationId());
/* 432 */       if (child instanceof IDataModelImpl) {
/* 433 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 434 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 435 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 436 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 439 */       if (postEventsForChanges()) {
/* 440 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPostalCodeMappingProperty(IPostalCodeMappingProperty argPostalCodeMappingProperty) {
/* 446 */     if (this._properties == null) {
/* 447 */       this._properties = new HistoricalList(null);
/*     */     }
/* 449 */     argPostalCodeMappingProperty.setCity(getCity());
/* 450 */     argPostalCodeMappingProperty.setOrganizationId(getOrganizationId());
/* 451 */     argPostalCodeMappingProperty.setPostalCode(getPostalCode());
/* 452 */     argPostalCodeMappingProperty.setTaxLocationId(getTaxLocationId());
/* 453 */     if (argPostalCodeMappingProperty instanceof IDataModelImpl) {
/* 454 */       IDataAccessObject childDao = ((IDataModelImpl)argPostalCodeMappingProperty).getDAO();
/* 455 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 456 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 457 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 462 */     if (postEventsForChanges()) {
/* 463 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPostalCodeMappingProperty));
/*     */     }
/*     */     
/* 466 */     this._properties.add(argPostalCodeMappingProperty);
/* 467 */     if (postEventsForChanges()) {
/* 468 */       this._events.post(IPostalCodeMapping.ADD_PROPERTIES, argPostalCodeMappingProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePostalCodeMappingProperty(IPostalCodeMappingProperty argPostalCodeMappingProperty) {
/* 473 */     if (this._properties != null) {
/*     */       
/* 475 */       if (postEventsForChanges()) {
/* 476 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPostalCodeMappingProperty));
/*     */       }
/* 478 */       this._properties.remove(argPostalCodeMappingProperty);
/* 479 */       if (postEventsForChanges()) {
/* 480 */         this._events.post(IPostalCodeMapping.REMOVE_PROPERTIES, argPostalCodeMappingProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 487 */     if ("PostalTaxLocation".equals(argFieldId)) {
/* 488 */       return getPostalTaxLocation();
/*     */     }
/* 490 */     if ("Properties".equals(argFieldId)) {
/* 491 */       return getProperties();
/*     */     }
/* 493 */     if ("PostalCodeMappingExtension".equals(argFieldId)) {
/* 494 */       return this._myExtension;
/*     */     }
/*     */     
/* 497 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 503 */     if ("PostalTaxLocation".equals(argFieldId)) {
/* 504 */       setPostalTaxLocation((ITaxLocation)argValue);
/*     */     }
/* 506 */     else if ("Properties".equals(argFieldId)) {
/* 507 */       setProperties(changeToList(argValue, IPostalCodeMappingProperty.class));
/*     */     }
/* 509 */     else if ("PostalCodeMappingExtension".equals(argFieldId)) {
/* 510 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 513 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 519 */     this._persistenceDefaults = argPD;
/* 520 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 521 */     this._eventManager = argEM;
/* 522 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 523 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 524 */     if (this._postalTaxLocation != null) {
/* 525 */       ((IDataModelImpl)this._postalTaxLocation).setDependencies(argPD, argEM);
/*     */     }
/* 527 */     if (this._properties != null) {
/* 528 */       for (IPostalCodeMappingProperty relationship : this._properties) {
/* 529 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPostalCodeMappingExt() {
/* 535 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPostalCodeMappingExt(IDataModel argExt) {
/* 539 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 544 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 548 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 551 */     super.startTransaction();
/*     */     
/* 553 */     this._postalTaxLocationSavepoint = this._postalTaxLocation;
/* 554 */     if (this._postalTaxLocation != null) {
/* 555 */       this._postalTaxLocation.startTransaction();
/*     */     }
/*     */     
/* 558 */     this._propertiesSavepoint = this._properties;
/* 559 */     if (this._properties != null) {
/* 560 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 561 */       Iterator<IDataModel> it = this._properties.iterator();
/* 562 */       while (it.hasNext()) {
/* 563 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 568 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 573 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 576 */     super.rollbackChanges();
/*     */     
/* 578 */     this._postalTaxLocation = this._postalTaxLocationSavepoint;
/* 579 */     this._postalTaxLocationSavepoint = null;
/* 580 */     if (this._postalTaxLocation != null) {
/* 581 */       this._postalTaxLocation.rollbackChanges();
/*     */     }
/*     */     
/* 584 */     this._properties = this._propertiesSavepoint;
/* 585 */     this._propertiesSavepoint = null;
/* 586 */     if (this._properties != null) {
/* 587 */       Iterator<IDataModel> it = this._properties.iterator();
/* 588 */       while (it.hasNext()) {
/* 589 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 597 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 600 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 603 */     super.commitTransaction();
/*     */     
/* 605 */     this._postalTaxLocationSavepoint = this._postalTaxLocation;
/* 606 */     if (this._postalTaxLocation != null) {
/* 607 */       this._postalTaxLocation.commitTransaction();
/*     */     }
/*     */     
/* 610 */     this._propertiesSavepoint = this._properties;
/* 611 */     if (this._properties != null) {
/* 612 */       Iterator<IDataModel> it = this._properties.iterator();
/* 613 */       while (it.hasNext()) {
/* 614 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 616 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 620 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 625 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\PostalCodeMappingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */