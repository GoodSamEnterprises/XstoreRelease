/*     */ package dtv.xst.dao.tax.impl;
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
/*     */ import dtv.xst.dao.tax.IRetailLocationTaxMapping;
/*     */ import dtv.xst.dao.tax.IRetailLocationTaxMappingProperty;
/*     */ import dtv.xst.dao.tax.ITaxLocation;
/*     */ import dtv.xst.dao.tax.RetailLocationTaxMappingPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class RetailLocationTaxMappingModel extends AbstractDataModelWithPropertyImpl<IRetailLocationTaxMappingProperty> implements IRetailLocationTaxMapping {
/*     */   private static final long serialVersionUID = 866442939L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private ITaxLocation _taxLocation; private transient ITaxLocation _taxLocationSavepoint; private HistoricalList<IRetailLocationTaxMappingProperty> _properties; private transient HistoricalList<IRetailLocationTaxMappingProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new RetailLocationTaxMappingDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RetailLocationTaxMappingDAO getDAO_() {
/*  47 */     return (RetailLocationTaxMappingDAO)this._daoImpl;
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
/*  71 */       this._events.post(IRetailLocationTaxMapping.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<RetailLocationTaxMappingPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((RetailLocationTaxMappingPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 102 */     if (getDAO_().getRetailLocationId() != null) {
/* 103 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 106 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 115 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 116 */       this._events != null && 
/* 117 */       postEventsForChanges()) {
/* 118 */       this._events.post(IRetailLocationTaxMapping.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 125 */     boolean ev_postable = false;
/*     */     
/* 127 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 128 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 129 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 130 */       ev_postable = true;
/* 131 */       if (this._properties != null) {
/*     */         
/* 133 */         Iterator<RetailLocationTaxMappingPropertyModel> it = this._properties.iterator();
/* 134 */         while (it.hasNext())
/*     */         {
/* 136 */           ((RetailLocationTaxMappingPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 149 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 157 */     if (setCreateDate_noev(argCreateDate) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IRetailLocationTaxMapping.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 170 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 171 */       getDAO_().setCreateDate(argCreateDate);
/* 172 */       ev_postable = true;
/*     */     } 
/*     */     
/* 175 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 183 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 191 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(IRetailLocationTaxMapping.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 204 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 205 */       getDAO_().setCreateUserId(argCreateUserId);
/* 206 */       ev_postable = true;
/*     */     } 
/*     */     
/* 209 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 217 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 225 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(IRetailLocationTaxMapping.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 235 */     boolean ev_postable = false;
/*     */     
/* 237 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 238 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 239 */       getDAO_().setUpdateDate(argUpdateDate);
/* 240 */       ev_postable = true;
/*     */     } 
/*     */     
/* 243 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 251 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 259 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 260 */       this._events != null && 
/* 261 */       postEventsForChanges()) {
/* 262 */       this._events.post(IRetailLocationTaxMapping.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 269 */     boolean ev_postable = false;
/*     */     
/* 271 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 272 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 273 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 274 */       ev_postable = true;
/*     */     } 
/*     */     
/* 277 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxLocationId() {
/* 285 */     return getDAO_().getTaxLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/* 293 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/* 294 */       this._events != null && 
/* 295 */       postEventsForChanges()) {
/* 296 */       this._events.post(IRetailLocationTaxMapping.SET_TAXLOCATIONID, argTaxLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/* 303 */     boolean ev_postable = false;
/*     */     
/* 305 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/* 306 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/* 307 */       getDAO_().setTaxLocationId(argTaxLocationId);
/* 308 */       ev_postable = true;
/*     */     } 
/*     */     
/* 311 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IRetailLocationTaxMappingProperty newProperty(String argPropertyName) {
/* 315 */     RetailLocationTaxMappingPropertyId id = new RetailLocationTaxMappingPropertyId();
/*     */     
/* 317 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 318 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 320 */     IRetailLocationTaxMappingProperty prop = (IRetailLocationTaxMappingProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRetailLocationTaxMappingProperty.class);
/* 321 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "TaxLocation")
/*     */   public ITaxLocation getTaxLocation() {
/* 333 */     return this._taxLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTaxLocation(ITaxLocation argTaxLocation) {
/* 338 */     if (argTaxLocation == null) {
/*     */       
/* 340 */       getDAO_().setTaxLocationId(null);
/* 341 */       if (this._taxLocation != null)
/*     */       {
/* 343 */         if (postEventsForChanges()) {
/* 344 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._taxLocation));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 349 */       getDAO_().setTaxLocationId(argTaxLocation.getTaxLocationId());
/*     */       
/* 351 */       if (postEventsForChanges()) {
/* 352 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxLocation));
/*     */       }
/*     */     } 
/*     */     
/* 356 */     this._taxLocation = argTaxLocation;
/* 357 */     if (postEventsForChanges()) {
/* 358 */       this._events.post(IRetailLocationTaxMapping.SET_TAXLOCATION, argTaxLocation);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IRetailLocationTaxMappingProperty> getProperties() {
/* 364 */     if (this._properties == null) {
/* 365 */       this._properties = new HistoricalList(null);
/*     */     }
/* 367 */     return (List<IRetailLocationTaxMappingProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IRetailLocationTaxMappingProperty> argProperties) {
/* 371 */     if (this._properties == null) {
/* 372 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 374 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 377 */     for (IRetailLocationTaxMappingProperty child : this._properties) {
/* 378 */       RetailLocationTaxMappingPropertyModel model = (RetailLocationTaxMappingPropertyModel)child;
/* 379 */       model.setOrganizationId_noev(getOrganizationId());
/* 380 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 381 */       if (child instanceof IDataModelImpl) {
/* 382 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 383 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 384 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 385 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 388 */       if (postEventsForChanges()) {
/* 389 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addRetailLocationTaxMappingProperty(IRetailLocationTaxMappingProperty argRetailLocationTaxMappingProperty) {
/* 395 */     if (this._properties == null) {
/* 396 */       this._properties = new HistoricalList(null);
/*     */     }
/* 398 */     argRetailLocationTaxMappingProperty.setOrganizationId(getOrganizationId());
/* 399 */     argRetailLocationTaxMappingProperty.setRetailLocationId(getRetailLocationId());
/* 400 */     if (argRetailLocationTaxMappingProperty instanceof IDataModelImpl) {
/* 401 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailLocationTaxMappingProperty).getDAO();
/* 402 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 403 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 404 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 409 */     if (postEventsForChanges()) {
/* 410 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailLocationTaxMappingProperty));
/*     */     }
/*     */     
/* 413 */     this._properties.add(argRetailLocationTaxMappingProperty);
/* 414 */     if (postEventsForChanges()) {
/* 415 */       this._events.post(IRetailLocationTaxMapping.ADD_PROPERTIES, argRetailLocationTaxMappingProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRetailLocationTaxMappingProperty(IRetailLocationTaxMappingProperty argRetailLocationTaxMappingProperty) {
/* 420 */     if (this._properties != null) {
/*     */       
/* 422 */       if (postEventsForChanges()) {
/* 423 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailLocationTaxMappingProperty));
/*     */       }
/* 425 */       this._properties.remove(argRetailLocationTaxMappingProperty);
/* 426 */       if (postEventsForChanges()) {
/* 427 */         this._events.post(IRetailLocationTaxMapping.REMOVE_PROPERTIES, argRetailLocationTaxMappingProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 434 */     if ("TaxLocation".equals(argFieldId)) {
/* 435 */       return getTaxLocation();
/*     */     }
/* 437 */     if ("Properties".equals(argFieldId)) {
/* 438 */       return getProperties();
/*     */     }
/* 440 */     if ("RetailLocationTaxMappingExtension".equals(argFieldId)) {
/* 441 */       return this._myExtension;
/*     */     }
/*     */     
/* 444 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 450 */     if ("TaxLocation".equals(argFieldId)) {
/* 451 */       setTaxLocation((ITaxLocation)argValue);
/*     */     }
/* 453 */     else if ("Properties".equals(argFieldId)) {
/* 454 */       setProperties(changeToList(argValue, IRetailLocationTaxMappingProperty.class));
/*     */     }
/* 456 */     else if ("RetailLocationTaxMappingExtension".equals(argFieldId)) {
/* 457 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 460 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 466 */     this._persistenceDefaults = argPD;
/* 467 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 468 */     this._eventManager = argEM;
/* 469 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 470 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 471 */     if (this._taxLocation != null) {
/* 472 */       ((IDataModelImpl)this._taxLocation).setDependencies(argPD, argEM);
/*     */     }
/* 474 */     if (this._properties != null) {
/* 475 */       for (IRetailLocationTaxMappingProperty relationship : this._properties) {
/* 476 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getRetailLocationTaxMappingExt() {
/* 482 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setRetailLocationTaxMappingExt(IDataModel argExt) {
/* 486 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 491 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 495 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 498 */     super.startTransaction();
/*     */     
/* 500 */     this._taxLocationSavepoint = this._taxLocation;
/* 501 */     if (this._taxLocation != null) {
/* 502 */       this._taxLocation.startTransaction();
/*     */     }
/*     */     
/* 505 */     this._propertiesSavepoint = this._properties;
/* 506 */     if (this._properties != null) {
/* 507 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 508 */       Iterator<IDataModel> it = this._properties.iterator();
/* 509 */       while (it.hasNext()) {
/* 510 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 515 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 520 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 523 */     super.rollbackChanges();
/*     */     
/* 525 */     this._taxLocation = this._taxLocationSavepoint;
/* 526 */     this._taxLocationSavepoint = null;
/* 527 */     if (this._taxLocation != null) {
/* 528 */       this._taxLocation.rollbackChanges();
/*     */     }
/*     */     
/* 531 */     this._properties = this._propertiesSavepoint;
/* 532 */     this._propertiesSavepoint = null;
/* 533 */     if (this._properties != null) {
/* 534 */       Iterator<IDataModel> it = this._properties.iterator();
/* 535 */       while (it.hasNext()) {
/* 536 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 544 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 547 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 550 */     super.commitTransaction();
/*     */     
/* 552 */     this._taxLocationSavepoint = this._taxLocation;
/* 553 */     if (this._taxLocation != null) {
/* 554 */       this._taxLocation.commitTransaction();
/*     */     }
/*     */     
/* 557 */     this._propertiesSavepoint = this._properties;
/* 558 */     if (this._properties != null) {
/* 559 */       Iterator<IDataModel> it = this._properties.iterator();
/* 560 */       while (it.hasNext()) {
/* 561 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 563 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 567 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 572 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\RetailLocationTaxMappingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */