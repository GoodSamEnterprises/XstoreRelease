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
/*     */ import dtv.xst.dao.com.AddressStatePropertyId;
/*     */ import dtv.xst.dao.com.IAddressState;
/*     */ import dtv.xst.dao.com.IAddressStateProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AddressStateModel extends AbstractDataModelWithPropertyImpl<IAddressStateProperty> implements IAddressState {
/*     */   private static final long serialVersionUID = 417522973L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAddressStateProperty> _properties; private transient HistoricalList<IAddressStateProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AddressStateDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AddressStateDAO getDAO_() {
/*  46 */     return (AddressStateDAO)this._daoImpl;
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
/*  70 */       this._events.post(IAddressState.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<AddressStatePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((AddressStatePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 112 */       this._events.post(IAddressState.SET_COUNTRYID, argCountryId);
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
/* 127 */         Iterator<AddressStatePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((AddressStatePropertyModel)it.next()).setCountryId_noev(argCountryId);
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
/*     */   public String getStateId() {
/* 143 */     return getDAO_().getStateId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStateId(String argStateId) {
/* 151 */     if (setStateId_noev(argStateId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IAddressState.SET_STATEID, argStateId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStateId_noev(String argStateId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getStateId() == null && argStateId != null) || (
/* 164 */       getDAO_().getStateId() != null && !getDAO_().getStateId().equals(argStateId))) {
/* 165 */       getDAO_().setStateId(argStateId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<AddressStatePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((AddressStatePropertyModel)it.next()).setStateId_noev(argStateId);
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
/* 196 */       this._events.post(IAddressState.SET_ADDRESSMODE, argAddressMode);
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
/* 211 */         Iterator<AddressStatePropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((AddressStatePropertyModel)it.next()).setAddressMode_noev(argAddressMode);
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
/* 238 */       this._events.post(IAddressState.SET_CREATEDATE, argCreateDate);
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
/* 272 */       this._events.post(IAddressState.SET_CREATEUSERID, argCreateUserId);
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
/* 306 */       this._events.post(IAddressState.SET_UPDATEDATE, argUpdateDate);
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
/* 340 */       this._events.post(IAddressState.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getStateName() {
/* 363 */     return getDAO_().getStateName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStateName(String argStateName) {
/* 371 */     if (setStateName_noev(argStateName) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IAddressState.SET_STATENAME, argStateName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStateName_noev(String argStateName) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getStateName() == null && argStateName != null) || (
/* 384 */       getDAO_().getStateName() != null && !getDAO_().getStateName().equals(argStateName))) {
/* 385 */       getDAO_().setStateName(argStateName);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAddressStateProperty newProperty(String argPropertyName) {
/* 393 */     AddressStatePropertyId id = new AddressStatePropertyId();
/*     */     
/* 395 */     id.setCountryId(getCountryId());
/* 396 */     id.setStateId(getStateId());
/* 397 */     id.setAddressMode(getAddressMode());
/* 398 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 400 */     IAddressStateProperty prop = (IAddressStateProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAddressStateProperty.class);
/* 401 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAddressStateProperty> getProperties() {
/* 410 */     if (this._properties == null) {
/* 411 */       this._properties = new HistoricalList(null);
/*     */     }
/* 413 */     return (List<IAddressStateProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAddressStateProperty> argProperties) {
/* 417 */     if (this._properties == null) {
/* 418 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 420 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 423 */     for (IAddressStateProperty child : this._properties) {
/* 424 */       AddressStatePropertyModel model = (AddressStatePropertyModel)child;
/* 425 */       model.setOrganizationId_noev(getOrganizationId());
/* 426 */       model.setCountryId_noev(getCountryId());
/* 427 */       model.setStateId_noev(getStateId());
/* 428 */       model.setAddressMode_noev(getAddressMode());
/* 429 */       if (child instanceof IDataModelImpl) {
/* 430 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 431 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 432 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 433 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 436 */       if (postEventsForChanges()) {
/* 437 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAddressStateProperty(IAddressStateProperty argAddressStateProperty) {
/* 443 */     if (this._properties == null) {
/* 444 */       this._properties = new HistoricalList(null);
/*     */     }
/* 446 */     argAddressStateProperty.setOrganizationId(getOrganizationId());
/* 447 */     argAddressStateProperty.setCountryId(getCountryId());
/* 448 */     argAddressStateProperty.setStateId(getStateId());
/* 449 */     argAddressStateProperty.setAddressMode(getAddressMode());
/* 450 */     if (argAddressStateProperty instanceof IDataModelImpl) {
/* 451 */       IDataAccessObject childDao = ((IDataModelImpl)argAddressStateProperty).getDAO();
/* 452 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 453 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 454 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 459 */     if (postEventsForChanges()) {
/* 460 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressStateProperty));
/*     */     }
/*     */     
/* 463 */     this._properties.add(argAddressStateProperty);
/* 464 */     if (postEventsForChanges()) {
/* 465 */       this._events.post(IAddressState.ADD_PROPERTIES, argAddressStateProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAddressStateProperty(IAddressStateProperty argAddressStateProperty) {
/* 470 */     if (this._properties != null) {
/*     */       
/* 472 */       if (postEventsForChanges()) {
/* 473 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressStateProperty));
/*     */       }
/* 475 */       this._properties.remove(argAddressStateProperty);
/* 476 */       if (postEventsForChanges()) {
/* 477 */         this._events.post(IAddressState.REMOVE_PROPERTIES, argAddressStateProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 484 */     if ("Properties".equals(argFieldId)) {
/* 485 */       return getProperties();
/*     */     }
/* 487 */     if ("AddressStateExtension".equals(argFieldId)) {
/* 488 */       return this._myExtension;
/*     */     }
/*     */     
/* 491 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 497 */     if ("Properties".equals(argFieldId)) {
/* 498 */       setProperties(changeToList(argValue, IAddressStateProperty.class));
/*     */     }
/* 500 */     else if ("AddressStateExtension".equals(argFieldId)) {
/* 501 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 504 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 510 */     this._persistenceDefaults = argPD;
/* 511 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 512 */     this._eventManager = argEM;
/* 513 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 514 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 515 */     if (this._properties != null) {
/* 516 */       for (IAddressStateProperty relationship : this._properties) {
/* 517 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAddressStateExt() {
/* 523 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAddressStateExt(IDataModel argExt) {
/* 527 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 532 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 536 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 539 */     super.startTransaction();
/*     */     
/* 541 */     this._propertiesSavepoint = this._properties;
/* 542 */     if (this._properties != null) {
/* 543 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 544 */       Iterator<IDataModel> it = this._properties.iterator();
/* 545 */       while (it.hasNext()) {
/* 546 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 551 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 556 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 559 */     super.rollbackChanges();
/*     */     
/* 561 */     this._properties = this._propertiesSavepoint;
/* 562 */     this._propertiesSavepoint = null;
/* 563 */     if (this._properties != null) {
/* 564 */       Iterator<IDataModel> it = this._properties.iterator();
/* 565 */       while (it.hasNext()) {
/* 566 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 574 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 577 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 580 */     super.commitTransaction();
/*     */     
/* 582 */     this._propertiesSavepoint = this._properties;
/* 583 */     if (this._properties != null) {
/* 584 */       Iterator<IDataModel> it = this._properties.iterator();
/* 585 */       while (it.hasNext()) {
/* 586 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 588 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 592 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 597 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressStateModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */