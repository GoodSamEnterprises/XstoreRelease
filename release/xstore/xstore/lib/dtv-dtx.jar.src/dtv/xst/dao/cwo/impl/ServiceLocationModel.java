/*     */ package dtv.xst.dao.cwo.impl;
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
/*     */ import dtv.xst.dao.com.IAddress;
/*     */ import dtv.xst.dao.cwo.IServiceLocation;
/*     */ import dtv.xst.dao.cwo.IServiceLocationProperty;
/*     */ import dtv.xst.dao.cwo.ServiceLocationPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ServiceLocationModel extends AbstractDataModelWithPropertyImpl<IServiceLocationProperty> implements IServiceLocation {
/*     */   private static final long serialVersionUID = 2134703466L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IAddress _address; private transient IAddress _addressSavepoint; private HistoricalList<IServiceLocationProperty> _properties; private transient HistoricalList<IServiceLocationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ServiceLocationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ServiceLocationDAO getDAO_() {
/*  47 */     return (ServiceLocationDAO)this._daoImpl;
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
/*  71 */       this._events.post(IServiceLocation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<ServiceLocationPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((ServiceLocationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 113 */       this._events.post(IServiceLocation.SET_SERVICELOCATIONID, argServiceLocationId);
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
/* 128 */         Iterator<ServiceLocationPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((ServiceLocationPropertyModel)it.next()).setServiceLocationId_noev(argServiceLocationId);
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
/* 155 */       this._events.post(IServiceLocation.SET_CREATEDATE, argCreateDate);
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
/* 189 */       this._events.post(IServiceLocation.SET_CREATEUSERID, argCreateUserId);
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
/* 223 */       this._events.post(IServiceLocation.SET_UPDATEDATE, argUpdateDate);
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
/* 257 */       this._events.post(IServiceLocation.SET_UPDATEUSERID, argUpdateUserId);
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
/* 291 */       this._events.post(IServiceLocation.SET_ORGCODE, argOrgCode);
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
/* 325 */       this._events.post(IServiceLocation.SET_ORGVALUE, argOrgValue);
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
/*     */   public String getServiceLocDescription() {
/* 348 */     return getDAO_().getServiceLocDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceLocDescription(String argServiceLocDescription) {
/* 356 */     if (setServiceLocDescription_noev(argServiceLocDescription) && 
/* 357 */       this._events != null && 
/* 358 */       postEventsForChanges()) {
/* 359 */       this._events.post(IServiceLocation.SET_SERVICELOCDESCRIPTION, argServiceLocDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setServiceLocDescription_noev(String argServiceLocDescription) {
/* 366 */     boolean ev_postable = false;
/*     */     
/* 368 */     if ((getDAO_().getServiceLocDescription() == null && argServiceLocDescription != null) || (
/* 369 */       getDAO_().getServiceLocDescription() != null && !getDAO_().getServiceLocDescription().equals(argServiceLocDescription))) {
/* 370 */       getDAO_().setServiceLocDescription(argServiceLocDescription);
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
/*     */   public long getPartyId() {
/* 382 */     if (getDAO_().getPartyId() != null) {
/* 383 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 386 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 395 */     if (setPartyId_noev(argPartyId) && 
/* 396 */       this._events != null && 
/* 397 */       postEventsForChanges()) {
/* 398 */       this._events.post(IServiceLocation.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 405 */     boolean ev_postable = false;
/*     */     
/* 407 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 408 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 409 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
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
/*     */   public String getAddressId() {
/* 421 */     return getDAO_().getAddressId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressId(String argAddressId) {
/* 429 */     if (setAddressId_noev(argAddressId) && 
/* 430 */       this._events != null && 
/* 431 */       postEventsForChanges()) {
/* 432 */       this._events.post(IServiceLocation.SET_ADDRESSID, argAddressId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressId_noev(String argAddressId) {
/* 439 */     boolean ev_postable = false;
/*     */     
/* 441 */     if ((getDAO_().getAddressId() == null && argAddressId != null) || (
/* 442 */       getDAO_().getAddressId() != null && !getDAO_().getAddressId().equals(argAddressId))) {
/* 443 */       getDAO_().setAddressId(argAddressId);
/* 444 */       ev_postable = true;
/*     */     } 
/*     */     
/* 447 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IServiceLocationProperty newProperty(String argPropertyName) {
/* 451 */     ServiceLocationPropertyId id = new ServiceLocationPropertyId();
/*     */     
/* 453 */     id.setServiceLocationId(getServiceLocationId());
/* 454 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 456 */     IServiceLocationProperty prop = (IServiceLocationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IServiceLocationProperty.class);
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
/*     */   @Relationship(name = "Address")
/*     */   public IAddress getAddress() {
/* 469 */     return this._address;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(IAddress argAddress) {
/* 474 */     if (argAddress == null) {
/*     */       
/* 476 */       getDAO_().setAddressId(null);
/* 477 */       if (this._address != null)
/*     */       {
/* 479 */         if (postEventsForChanges()) {
/* 480 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._address));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 485 */       getDAO_().setAddressId(argAddress.getAddressId());
/*     */       
/* 487 */       if (postEventsForChanges()) {
/* 488 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddress));
/*     */       }
/*     */     } 
/*     */     
/* 492 */     this._address = argAddress;
/* 493 */     if (postEventsForChanges()) {
/* 494 */       this._events.post(IServiceLocation.SET_ADDRESS, argAddress);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IServiceLocationProperty> getProperties() {
/* 500 */     if (this._properties == null) {
/* 501 */       this._properties = new HistoricalList(null);
/*     */     }
/* 503 */     return (List<IServiceLocationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IServiceLocationProperty> argProperties) {
/* 507 */     if (this._properties == null) {
/* 508 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 510 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 513 */     for (IServiceLocationProperty child : this._properties) {
/* 514 */       ServiceLocationPropertyModel model = (ServiceLocationPropertyModel)child;
/* 515 */       model.setOrganizationId_noev(getOrganizationId());
/* 516 */       model.setServiceLocationId_noev(getServiceLocationId());
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
/*     */   public void addServiceLocationProperty(IServiceLocationProperty argServiceLocationProperty) {
/* 531 */     if (this._properties == null) {
/* 532 */       this._properties = new HistoricalList(null);
/*     */     }
/* 534 */     argServiceLocationProperty.setOrganizationId(getOrganizationId());
/* 535 */     argServiceLocationProperty.setServiceLocationId(getServiceLocationId());
/* 536 */     if (argServiceLocationProperty instanceof IDataModelImpl) {
/* 537 */       IDataAccessObject childDao = ((IDataModelImpl)argServiceLocationProperty).getDAO();
/* 538 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 539 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 540 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 545 */     if (postEventsForChanges()) {
/* 546 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argServiceLocationProperty));
/*     */     }
/*     */     
/* 549 */     this._properties.add(argServiceLocationProperty);
/* 550 */     if (postEventsForChanges()) {
/* 551 */       this._events.post(IServiceLocation.ADD_PROPERTIES, argServiceLocationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeServiceLocationProperty(IServiceLocationProperty argServiceLocationProperty) {
/* 556 */     if (this._properties != null) {
/*     */       
/* 558 */       if (postEventsForChanges()) {
/* 559 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argServiceLocationProperty));
/*     */       }
/* 561 */       this._properties.remove(argServiceLocationProperty);
/* 562 */       if (postEventsForChanges()) {
/* 563 */         this._events.post(IServiceLocation.REMOVE_PROPERTIES, argServiceLocationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 570 */     if ("Address".equals(argFieldId)) {
/* 571 */       return getAddress();
/*     */     }
/* 573 */     if ("Properties".equals(argFieldId)) {
/* 574 */       return getProperties();
/*     */     }
/* 576 */     if ("ServiceLocationExtension".equals(argFieldId)) {
/* 577 */       return this._myExtension;
/*     */     }
/*     */     
/* 580 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 586 */     if ("Address".equals(argFieldId)) {
/* 587 */       setAddress((IAddress)argValue);
/*     */     }
/* 589 */     else if ("Properties".equals(argFieldId)) {
/* 590 */       setProperties(changeToList(argValue, IServiceLocationProperty.class));
/*     */     }
/* 592 */     else if ("ServiceLocationExtension".equals(argFieldId)) {
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
/* 607 */     if (this._address != null) {
/* 608 */       ((IDataModelImpl)this._address).setDependencies(argPD, argEM);
/*     */     }
/* 610 */     if (this._properties != null) {
/* 611 */       for (IServiceLocationProperty relationship : this._properties) {
/* 612 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getServiceLocationExt() {
/* 618 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setServiceLocationExt(IDataModel argExt) {
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
/* 636 */     this._addressSavepoint = this._address;
/* 637 */     if (this._address != null) {
/* 638 */       this._address.startTransaction();
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
/* 661 */     this._address = this._addressSavepoint;
/* 662 */     this._addressSavepoint = null;
/* 663 */     if (this._address != null) {
/* 664 */       this._address.rollbackChanges();
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
/* 688 */     this._addressSavepoint = this._address;
/* 689 */     if (this._address != null) {
/* 690 */       this._address.commitTransaction();
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\ServiceLocationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */