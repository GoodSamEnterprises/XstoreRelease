/*     */ package dtv.xst.dao.sec.impl;
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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.sec.AccessControlListPropertyId;
/*     */ import dtv.xst.dao.sec.IAccessControlList;
/*     */ import dtv.xst.dao.sec.IAccessControlListProperty;
/*     */ import dtv.xst.dao.sec.IAclAccessType;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AccessControlListModel extends AbstractDataModelWithPropertyImpl<IAccessControlListProperty> implements IAccessControlList {
/*     */   private static final long serialVersionUID = 699875191L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IAclAccessType> _aclEntries; private transient HistoricalList<IAclAccessType> _aclEntriesSavepoint; private HistoricalList<IAccessControlListProperty> _properties; private transient HistoricalList<IAccessControlListProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AccessControlListDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AccessControlListDAO getDAO_() {
/*  46 */     return (AccessControlListDAO)this._daoImpl;
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
/*  70 */       this._events.post(IAccessControlList.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  83 */       if (this._aclEntries != null) {
/*     */         
/*  85 */         Iterator<AclAccessTypeModel> it = this._aclEntries.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((AclAccessTypeModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  91 */       if (this._properties != null) {
/*     */         
/*  93 */         Iterator<AccessControlListPropertyModel> it = this._properties.iterator();
/*  94 */         while (it.hasNext())
/*     */         {
/*  96 */           ((AccessControlListPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 101 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSecuredObjectId() {
/* 109 */     return getDAO_().getSecuredObjectId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecuredObjectId(String argSecuredObjectId) {
/* 117 */     if (setSecuredObjectId_noev(argSecuredObjectId) && 
/* 118 */       this._events != null && 
/* 119 */       postEventsForChanges()) {
/* 120 */       this._events.post(IAccessControlList.SET_SECUREDOBJECTID, argSecuredObjectId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSecuredObjectId_noev(String argSecuredObjectId) {
/* 127 */     boolean ev_postable = false;
/*     */     
/* 129 */     if ((getDAO_().getSecuredObjectId() == null && argSecuredObjectId != null) || (
/* 130 */       getDAO_().getSecuredObjectId() != null && !getDAO_().getSecuredObjectId().equals(argSecuredObjectId))) {
/* 131 */       getDAO_().setSecuredObjectId(argSecuredObjectId);
/* 132 */       ev_postable = true;
/* 133 */       if (this._aclEntries != null) {
/*     */         
/* 135 */         Iterator<AclAccessTypeModel> it = this._aclEntries.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((AclAccessTypeModel)it.next()).setSecuredObjectId_noev(argSecuredObjectId);
/*     */         }
/*     */       } 
/* 141 */       if (this._properties != null) {
/*     */         
/* 143 */         Iterator<AccessControlListPropertyModel> it = this._properties.iterator();
/* 144 */         while (it.hasNext())
/*     */         {
/* 146 */           ((AccessControlListPropertyModel)it.next()).setSecuredObjectId_noev(argSecuredObjectId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 159 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 167 */     if (setCreateDate_noev(argCreateDate) && 
/* 168 */       this._events != null && 
/* 169 */       postEventsForChanges()) {
/* 170 */       this._events.post(IAccessControlList.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 177 */     boolean ev_postable = false;
/*     */     
/* 179 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 180 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 181 */       getDAO_().setCreateDate(argCreateDate);
/* 182 */       ev_postable = true;
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 193 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 201 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IAccessControlList.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 214 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 215 */       getDAO_().setCreateUserId(argCreateUserId);
/* 216 */       ev_postable = true;
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 227 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 235 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IAccessControlList.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 248 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 249 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 261 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 269 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IAccessControlList.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 282 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 283 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public boolean getAuthenticationRequired() {
/* 295 */     if (getDAO_().getAuthenticationRequired() != null) {
/* 296 */       return getDAO_().getAuthenticationRequired().booleanValue();
/*     */     }
/*     */     
/* 299 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthenticationRequired(boolean argAuthenticationRequired) {
/* 308 */     if (setAuthenticationRequired_noev(argAuthenticationRequired) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(IAccessControlList.SET_AUTHENTICATIONREQUIRED, Boolean.valueOf(argAuthenticationRequired));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthenticationRequired_noev(boolean argAuthenticationRequired) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getAuthenticationRequired() == null && Boolean.valueOf(argAuthenticationRequired) != null) || (
/* 321 */       getDAO_().getAuthenticationRequired() != null && !getDAO_().getAuthenticationRequired().equals(Boolean.valueOf(argAuthenticationRequired)))) {
/* 322 */       getDAO_().setAuthenticationRequired(Boolean.valueOf(argAuthenticationRequired));
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAccessControlListProperty newProperty(String argPropertyName) {
/* 330 */     AccessControlListPropertyId id = new AccessControlListPropertyId();
/*     */     
/* 332 */     id.setSecuredObjectId(getSecuredObjectId());
/* 333 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 335 */     IAccessControlListProperty prop = (IAccessControlListProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAccessControlListProperty.class);
/* 336 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "AclEntries")
/*     */   public List<IAclAccessType> getAclEntries() {
/* 348 */     if (this._aclEntries == null) {
/* 349 */       this._aclEntries = new HistoricalList(null);
/*     */     }
/* 351 */     return (List<IAclAccessType>)this._aclEntries;
/*     */   }
/*     */   
/*     */   public void setAclEntries(List<IAclAccessType> argAclEntries) {
/* 355 */     if (this._aclEntries == null) {
/* 356 */       this._aclEntries = new HistoricalList(argAclEntries);
/*     */     } else {
/* 358 */       this._aclEntries.setCurrentList(argAclEntries);
/*     */     } 
/*     */     
/* 361 */     for (IAclAccessType child : this._aclEntries) {
/* 362 */       AclAccessTypeModel model = (AclAccessTypeModel)child;
/* 363 */       model.setOrganizationId_noev(getOrganizationId());
/* 364 */       model.setSecuredObjectId_noev(getSecuredObjectId());
/* 365 */       if (child instanceof IDataModelImpl) {
/* 366 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 367 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 368 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 369 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 372 */       if (postEventsForChanges()) {
/* 373 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAclAccessType(IAclAccessType argAclAccessType) {
/* 379 */     if (this._aclEntries == null) {
/* 380 */       this._aclEntries = new HistoricalList(null);
/*     */     }
/* 382 */     argAclAccessType.setOrganizationId(getOrganizationId());
/* 383 */     argAclAccessType.setSecuredObjectId(getSecuredObjectId());
/* 384 */     if (argAclAccessType instanceof IDataModelImpl) {
/* 385 */       IDataAccessObject childDao = ((IDataModelImpl)argAclAccessType).getDAO();
/* 386 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 387 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 388 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 393 */     if (postEventsForChanges()) {
/* 394 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAclAccessType));
/*     */     }
/*     */     
/* 397 */     this._aclEntries.add(argAclAccessType);
/* 398 */     if (postEventsForChanges()) {
/* 399 */       this._events.post(IAccessControlList.ADD_ACLENTRIES, argAclAccessType);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAclAccessType(IAclAccessType argAclAccessType) {
/* 404 */     if (this._aclEntries != null) {
/*     */       
/* 406 */       if (postEventsForChanges()) {
/* 407 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAclAccessType));
/*     */       }
/* 409 */       this._aclEntries.remove(argAclAccessType);
/* 410 */       if (postEventsForChanges()) {
/* 411 */         this._events.post(IAccessControlList.REMOVE_ACLENTRIES, argAclAccessType);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAccessControlListProperty> getProperties() {
/* 418 */     if (this._properties == null) {
/* 419 */       this._properties = new HistoricalList(null);
/*     */     }
/* 421 */     return (List<IAccessControlListProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAccessControlListProperty> argProperties) {
/* 425 */     if (this._properties == null) {
/* 426 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 428 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 431 */     for (IAccessControlListProperty child : this._properties) {
/* 432 */       AccessControlListPropertyModel model = (AccessControlListPropertyModel)child;
/* 433 */       model.setOrganizationId_noev(getOrganizationId());
/* 434 */       model.setSecuredObjectId_noev(getSecuredObjectId());
/* 435 */       if (child instanceof IDataModelImpl) {
/* 436 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 437 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 438 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 439 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 442 */       if (postEventsForChanges()) {
/* 443 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAccessControlListProperty(IAccessControlListProperty argAccessControlListProperty) {
/* 449 */     if (this._properties == null) {
/* 450 */       this._properties = new HistoricalList(null);
/*     */     }
/* 452 */     argAccessControlListProperty.setOrganizationId(getOrganizationId());
/* 453 */     argAccessControlListProperty.setSecuredObjectId(getSecuredObjectId());
/* 454 */     if (argAccessControlListProperty instanceof IDataModelImpl) {
/* 455 */       IDataAccessObject childDao = ((IDataModelImpl)argAccessControlListProperty).getDAO();
/* 456 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 457 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 458 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 463 */     if (postEventsForChanges()) {
/* 464 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAccessControlListProperty));
/*     */     }
/*     */     
/* 467 */     this._properties.add(argAccessControlListProperty);
/* 468 */     if (postEventsForChanges()) {
/* 469 */       this._events.post(IAccessControlList.ADD_PROPERTIES, argAccessControlListProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAccessControlListProperty(IAccessControlListProperty argAccessControlListProperty) {
/* 474 */     if (this._properties != null) {
/*     */       
/* 476 */       if (postEventsForChanges()) {
/* 477 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAccessControlListProperty));
/*     */       }
/* 479 */       this._properties.remove(argAccessControlListProperty);
/* 480 */       if (postEventsForChanges()) {
/* 481 */         this._events.post(IAccessControlList.REMOVE_PROPERTIES, argAccessControlListProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 488 */     if ("AclEntries".equals(argFieldId)) {
/* 489 */       return getAclEntries();
/*     */     }
/* 491 */     if ("Properties".equals(argFieldId)) {
/* 492 */       return getProperties();
/*     */     }
/* 494 */     if ("AccessControlListExtension".equals(argFieldId)) {
/* 495 */       return this._myExtension;
/*     */     }
/*     */     
/* 498 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 504 */     if ("AclEntries".equals(argFieldId)) {
/* 505 */       setAclEntries(changeToList(argValue, IAclAccessType.class));
/*     */     }
/* 507 */     else if ("Properties".equals(argFieldId)) {
/* 508 */       setProperties(changeToList(argValue, IAccessControlListProperty.class));
/*     */     }
/* 510 */     else if ("AccessControlListExtension".equals(argFieldId)) {
/* 511 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 514 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 520 */     this._persistenceDefaults = argPD;
/* 521 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 522 */     this._eventManager = argEM;
/* 523 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 524 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 525 */     if (this._aclEntries != null) {
/* 526 */       for (IAclAccessType relationship : this._aclEntries) {
/* 527 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 530 */     if (this._properties != null) {
/* 531 */       for (IAccessControlListProperty relationship : this._properties) {
/* 532 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAccessControlListExt() {
/* 538 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAccessControlListExt(IDataModel argExt) {
/* 542 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 547 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 551 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 554 */     super.startTransaction();
/*     */     
/* 556 */     this._aclEntriesSavepoint = this._aclEntries;
/* 557 */     if (this._aclEntries != null) {
/* 558 */       this._aclEntriesSavepoint = new HistoricalList((List)this._aclEntries);
/* 559 */       Iterator<IDataModel> it = this._aclEntries.iterator();
/* 560 */       while (it.hasNext()) {
/* 561 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 565 */     this._propertiesSavepoint = this._properties;
/* 566 */     if (this._properties != null) {
/* 567 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 568 */       Iterator<IDataModel> it = this._properties.iterator();
/* 569 */       while (it.hasNext()) {
/* 570 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 575 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 580 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 583 */     super.rollbackChanges();
/*     */     
/* 585 */     this._aclEntries = this._aclEntriesSavepoint;
/* 586 */     this._aclEntriesSavepoint = null;
/* 587 */     if (this._aclEntries != null) {
/* 588 */       Iterator<IDataModel> it = this._aclEntries.iterator();
/* 589 */       while (it.hasNext()) {
/* 590 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 594 */     this._properties = this._propertiesSavepoint;
/* 595 */     this._propertiesSavepoint = null;
/* 596 */     if (this._properties != null) {
/* 597 */       Iterator<IDataModel> it = this._properties.iterator();
/* 598 */       while (it.hasNext()) {
/* 599 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 607 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 610 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 613 */     super.commitTransaction();
/*     */     
/* 615 */     this._aclEntriesSavepoint = this._aclEntries;
/* 616 */     if (this._aclEntries != null) {
/* 617 */       Iterator<IDataModel> it = this._aclEntries.iterator();
/* 618 */       while (it.hasNext()) {
/* 619 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 621 */       this._aclEntries = new HistoricalList((List)this._aclEntries);
/*     */     } 
/*     */     
/* 624 */     this._propertiesSavepoint = this._properties;
/* 625 */     if (this._properties != null) {
/* 626 */       Iterator<IDataModel> it = this._properties.iterator();
/* 627 */       while (it.hasNext()) {
/* 628 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 630 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 634 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 639 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\AccessControlListModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */