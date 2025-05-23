/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.AddressPostalCodePropertyId;
/*     */ import dtv.xst.dao.com.IAddressPostalCode;
/*     */ import dtv.xst.dao.com.IAddressPostalCodeProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AddressPostalCodeModel extends AbstractDataModelWithPropertyImpl<IAddressPostalCodeProperty> implements IAddressPostalCode {
/*     */   private static final long serialVersionUID = -1501423540L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAddressPostalCodeProperty> _properties; private transient HistoricalList<IAddressPostalCodeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AddressPostalCodeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AddressPostalCodeDAO getDAO_() {
/*  46 */     return (AddressPostalCodeDAO)this._daoImpl;
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
/*  70 */       this._events.post(IAddressPostalCode.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<AddressPostalCodePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((AddressPostalCodePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCountryId() {
/* 101 */     return getDAO_().getCountryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountryId(String argCountryId) {
/* 109 */     if (setCountryId_noev(argCountryId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IAddressPostalCode.SET_COUNTRYID, argCountryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountryId_noev(String argCountryId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCountryId() == null && argCountryId != null) || (
/* 122 */       getDAO_().getCountryId() != null && !getDAO_().getCountryId().equals(argCountryId))) {
/* 123 */       getDAO_().setCountryId(argCountryId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<AddressPostalCodePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((AddressPostalCodePropertyModel)it.next()).setCountryId_noev(argCountryId);
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
/*     */   public String getPostalCodeId() {
/* 143 */     return getDAO_().getPostalCodeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCodeId(String argPostalCodeId) {
/* 151 */     if (setPostalCodeId_noev(argPostalCodeId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IAddressPostalCode.SET_POSTALCODEID, argPostalCodeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostalCodeId_noev(String argPostalCodeId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getPostalCodeId() == null && argPostalCodeId != null) || (
/* 164 */       getDAO_().getPostalCodeId() != null && !getDAO_().getPostalCodeId().equals(argPostalCodeId))) {
/* 165 */       getDAO_().setPostalCodeId(argPostalCodeId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<AddressPostalCodePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((AddressPostalCodePropertyModel)it.next()).setPostalCodeId_noev(argPostalCodeId);
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
/*     */   public String getAddressMode() {
/* 185 */     return getDAO_().getAddressMode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressMode(String argAddressMode) {
/* 193 */     if (setAddressMode_noev(argAddressMode) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IAddressPostalCode.SET_ADDRESSMODE, argAddressMode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressMode_noev(String argAddressMode) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getAddressMode() == null && argAddressMode != null) || (
/* 206 */       getDAO_().getAddressMode() != null && !getDAO_().getAddressMode().equals(argAddressMode))) {
/* 207 */       getDAO_().setAddressMode(argAddressMode);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<AddressPostalCodePropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((AddressPostalCodePropertyModel)it.next()).setAddressMode_noev(argAddressMode);
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
/*     */   public Date getCreateDate() {
/* 227 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 235 */     if (setCreateDate_noev(argCreateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IAddressPostalCode.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 248 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 249 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 261 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 269 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IAddressPostalCode.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 282 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 283 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 295 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 303 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IAddressPostalCode.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 316 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 317 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 329 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 337 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IAddressPostalCode.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 350 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 351 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getPostalCode() {
/* 363 */     return getDAO_().getPostalCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 371 */     if (setPostalCode_noev(argPostalCode) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IAddressPostalCode.SET_POSTALCODE, argPostalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostalCode_noev(String argPostalCode) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/* 384 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/* 385 */       getDAO_().setPostalCode(argPostalCode);
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
/*     */   public String getStateId() {
/* 397 */     return getDAO_().getStateId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStateId(String argStateId) {
/* 405 */     if (setStateId_noev(argStateId) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IAddressPostalCode.SET_STATEID, argStateId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStateId_noev(String argStateId) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getStateId() == null && argStateId != null) || (
/* 418 */       getDAO_().getStateId() != null && !getDAO_().getStateId().equals(argStateId))) {
/* 419 */       getDAO_().setStateId(argStateId);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCityName() {
/* 431 */     return getDAO_().getCityName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCityName(String argCityName) {
/* 439 */     if (setCityName_noev(argCityName) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IAddressPostalCode.SET_CITYNAME, argCityName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCityName_noev(String argCityName) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getCityName() == null && argCityName != null) || (
/* 452 */       getDAO_().getCityName() != null && !getDAO_().getCityName().equals(argCityName))) {
/* 453 */       getDAO_().setCityName(argCityName);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAddressPostalCodeProperty newProperty(String argPropertyName) {
/* 461 */     AddressPostalCodePropertyId id = new AddressPostalCodePropertyId();
/*     */     
/* 463 */     id.setCountryId(getCountryId());
/* 464 */     id.setPostalCodeId(getPostalCodeId());
/* 465 */     id.setAddressMode(getAddressMode());
/* 466 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 468 */     IAddressPostalCodeProperty prop = (IAddressPostalCodeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAddressPostalCodeProperty.class);
/* 469 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAddressPostalCodeProperty> getProperties() {
/* 478 */     if (this._properties == null) {
/* 479 */       this._properties = new HistoricalList(null);
/*     */     }
/* 481 */     return (List<IAddressPostalCodeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAddressPostalCodeProperty> argProperties) {
/* 485 */     if (this._properties == null) {
/* 486 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 488 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 491 */     for (IAddressPostalCodeProperty child : this._properties) {
/* 492 */       AddressPostalCodePropertyModel model = (AddressPostalCodePropertyModel)child;
/* 493 */       model.setOrganizationId_noev(getOrganizationId());
/* 494 */       model.setCountryId_noev(getCountryId());
/* 495 */       model.setPostalCodeId_noev(getPostalCodeId());
/* 496 */       model.setAddressMode_noev(getAddressMode());
/* 497 */       if (child instanceof IDataModelImpl) {
/* 498 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 499 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 500 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 501 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 504 */       if (postEventsForChanges()) {
/* 505 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAddressPostalCodeProperty(IAddressPostalCodeProperty argAddressPostalCodeProperty) {
/* 511 */     if (this._properties == null) {
/* 512 */       this._properties = new HistoricalList(null);
/*     */     }
/* 514 */     argAddressPostalCodeProperty.setOrganizationId(getOrganizationId());
/* 515 */     argAddressPostalCodeProperty.setCountryId(getCountryId());
/* 516 */     argAddressPostalCodeProperty.setPostalCodeId(getPostalCodeId());
/* 517 */     argAddressPostalCodeProperty.setAddressMode(getAddressMode());
/* 518 */     if (argAddressPostalCodeProperty instanceof IDataModelImpl) {
/* 519 */       IDataAccessObject childDao = ((IDataModelImpl)argAddressPostalCodeProperty).getDAO();
/* 520 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 521 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 522 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 527 */     if (postEventsForChanges()) {
/* 528 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressPostalCodeProperty));
/*     */     }
/*     */     
/* 531 */     this._properties.add(argAddressPostalCodeProperty);
/* 532 */     if (postEventsForChanges()) {
/* 533 */       this._events.post(IAddressPostalCode.ADD_PROPERTIES, argAddressPostalCodeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAddressPostalCodeProperty(IAddressPostalCodeProperty argAddressPostalCodeProperty) {
/* 538 */     if (this._properties != null) {
/*     */       
/* 540 */       if (postEventsForChanges()) {
/* 541 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressPostalCodeProperty));
/*     */       }
/* 543 */       this._properties.remove(argAddressPostalCodeProperty);
/* 544 */       if (postEventsForChanges()) {
/* 545 */         this._events.post(IAddressPostalCode.REMOVE_PROPERTIES, argAddressPostalCodeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 552 */     if ("Properties".equals(argFieldId)) {
/* 553 */       return getProperties();
/*     */     }
/* 555 */     if ("AddressPostalCodeExtension".equals(argFieldId)) {
/* 556 */       return this._myExtension;
/*     */     }
/*     */     
/* 559 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 565 */     if ("Properties".equals(argFieldId)) {
/* 566 */       setProperties(changeToList(argValue, IAddressPostalCodeProperty.class));
/*     */     }
/* 568 */     else if ("AddressPostalCodeExtension".equals(argFieldId)) {
/* 569 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 572 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 578 */     this._persistenceDefaults = argPD;
/* 579 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 580 */     this._eventManager = argEM;
/* 581 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 582 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 583 */     if (this._properties != null) {
/* 584 */       for (IAddressPostalCodeProperty relationship : this._properties) {
/* 585 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAddressPostalCodeExt() {
/* 591 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAddressPostalCodeExt(IDataModel argExt) {
/* 595 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 600 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 604 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 607 */     super.startTransaction();
/*     */     
/* 609 */     this._propertiesSavepoint = this._properties;
/* 610 */     if (this._properties != null) {
/* 611 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 612 */       Iterator<IDataModel> it = this._properties.iterator();
/* 613 */       while (it.hasNext()) {
/* 614 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 619 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 624 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 627 */     super.rollbackChanges();
/*     */     
/* 629 */     this._properties = this._propertiesSavepoint;
/* 630 */     this._propertiesSavepoint = null;
/* 631 */     if (this._properties != null) {
/* 632 */       Iterator<IDataModel> it = this._properties.iterator();
/* 633 */       while (it.hasNext()) {
/* 634 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 642 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 645 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 648 */     super.commitTransaction();
/*     */     
/* 650 */     this._propertiesSavepoint = this._properties;
/* 651 */     if (this._properties != null) {
/* 652 */       Iterator<IDataModel> it = this._properties.iterator();
/* 653 */       while (it.hasNext()) {
/* 654 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 656 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 660 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 665 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressPostalCodeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */