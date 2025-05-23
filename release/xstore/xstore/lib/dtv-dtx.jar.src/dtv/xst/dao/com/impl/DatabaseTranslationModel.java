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
/*     */ import dtv.xst.dao.com.DatabaseTranslationPropertyId;
/*     */ import dtv.xst.dao.com.IDatabaseTranslation;
/*     */ import dtv.xst.dao.com.IDatabaseTranslationProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DatabaseTranslationModel extends AbstractDataModelWithPropertyImpl<IDatabaseTranslationProperty> implements IDatabaseTranslation {
/*     */   private static final long serialVersionUID = 1081353750L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDatabaseTranslationProperty> _properties; private transient HistoricalList<IDatabaseTranslationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DatabaseTranslationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DatabaseTranslationDAO getDAO_() {
/*  46 */     return (DatabaseTranslationDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDatabaseTranslation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DatabaseTranslationPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DatabaseTranslationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getLocale() {
/* 101 */     return getDAO_().getLocale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocale(String argLocale) {
/* 109 */     if (setLocale_noev(argLocale) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IDatabaseTranslation.SET_LOCALE, argLocale);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocale_noev(String argLocale) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getLocale() == null && argLocale != null) || (
/* 122 */       getDAO_().getLocale() != null && !getDAO_().getLocale().equals(argLocale))) {
/* 123 */       getDAO_().setLocale(argLocale);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<DatabaseTranslationPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DatabaseTranslationPropertyModel)it.next()).setLocale_noev(argLocale);
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
/*     */   public String getTranslationKey() {
/* 143 */     return getDAO_().getTranslationKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTranslationKey(String argTranslationKey) {
/* 151 */     if (setTranslationKey_noev(argTranslationKey) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IDatabaseTranslation.SET_TRANSLATIONKEY, argTranslationKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTranslationKey_noev(String argTranslationKey) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getTranslationKey() == null && argTranslationKey != null) || (
/* 164 */       getDAO_().getTranslationKey() != null && !getDAO_().getTranslationKey().equals(argTranslationKey))) {
/* 165 */       getDAO_().setTranslationKey(argTranslationKey);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<DatabaseTranslationPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((DatabaseTranslationPropertyModel)it.next()).setTranslationKey_noev(argTranslationKey);
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
/*     */   public Date getCreateDate() {
/* 185 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 193 */     if (setCreateDate_noev(argCreateDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IDatabaseTranslation.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 207 */       getDAO_().setCreateDate(argCreateDate);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 219 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 227 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IDatabaseTranslation.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 241 */       getDAO_().setCreateUserId(argCreateUserId);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 253 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 261 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IDatabaseTranslation.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 275 */       getDAO_().setUpdateDate(argUpdateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 287 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IDatabaseTranslation.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 309 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 321 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 329 */     if (setOrgCode_noev(argOrgCode) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IDatabaseTranslation.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 342 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 343 */       getDAO_().setOrgCode(argOrgCode);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 355 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 363 */     if (setOrgValue_noev(argOrgValue) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IDatabaseTranslation.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 376 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 377 */       getDAO_().setOrgValue(argOrgValue);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTranslation() {
/* 389 */     return getDAO_().getTranslation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTranslation(String argTranslation) {
/* 397 */     if (setTranslation_noev(argTranslation) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(IDatabaseTranslation.SET_TRANSLATION, argTranslation);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTranslation_noev(String argTranslation) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getTranslation() == null && argTranslation != null) || (
/* 410 */       getDAO_().getTranslation() != null && !getDAO_().getTranslation().equals(argTranslation))) {
/* 411 */       getDAO_().setTranslation(argTranslation);
/* 412 */       ev_postable = true;
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalSystem() {
/* 423 */     return getDAO_().getExternalSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 431 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 432 */       this._events != null && 
/* 433 */       postEventsForChanges()) {
/* 434 */       this._events.post(IDatabaseTranslation.SET_EXTERNALSYSTEM, argExternalSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 441 */     boolean ev_postable = false;
/*     */     
/* 443 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 444 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 445 */       getDAO_().setExternalSystem(argExternalSystem);
/* 446 */       ev_postable = true;
/*     */     } 
/*     */     
/* 449 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDatabaseTranslationProperty newProperty(String argPropertyName) {
/* 453 */     DatabaseTranslationPropertyId id = new DatabaseTranslationPropertyId();
/*     */     
/* 455 */     id.setLocale(getLocale());
/* 456 */     id.setTranslationKey(getTranslationKey());
/* 457 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 459 */     IDatabaseTranslationProperty prop = (IDatabaseTranslationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDatabaseTranslationProperty.class);
/* 460 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDatabaseTranslationProperty> getProperties() {
/* 469 */     if (this._properties == null) {
/* 470 */       this._properties = new HistoricalList(null);
/*     */     }
/* 472 */     return (List<IDatabaseTranslationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDatabaseTranslationProperty> argProperties) {
/* 476 */     if (this._properties == null) {
/* 477 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 479 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 482 */     for (IDatabaseTranslationProperty child : this._properties) {
/* 483 */       DatabaseTranslationPropertyModel model = (DatabaseTranslationPropertyModel)child;
/* 484 */       model.setOrganizationId_noev(getOrganizationId());
/* 485 */       model.setLocale_noev(getLocale());
/* 486 */       model.setTranslationKey_noev(getTranslationKey());
/* 487 */       if (child instanceof IDataModelImpl) {
/* 488 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 489 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 490 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 491 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 494 */       if (postEventsForChanges()) {
/* 495 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDatabaseTranslationProperty(IDatabaseTranslationProperty argDatabaseTranslationProperty) {
/* 501 */     if (this._properties == null) {
/* 502 */       this._properties = new HistoricalList(null);
/*     */     }
/* 504 */     argDatabaseTranslationProperty.setOrganizationId(getOrganizationId());
/* 505 */     argDatabaseTranslationProperty.setLocale(getLocale());
/* 506 */     argDatabaseTranslationProperty.setTranslationKey(getTranslationKey());
/* 507 */     if (argDatabaseTranslationProperty instanceof IDataModelImpl) {
/* 508 */       IDataAccessObject childDao = ((IDataModelImpl)argDatabaseTranslationProperty).getDAO();
/* 509 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 510 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 511 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 516 */     if (postEventsForChanges()) {
/* 517 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDatabaseTranslationProperty));
/*     */     }
/*     */     
/* 520 */     this._properties.add(argDatabaseTranslationProperty);
/* 521 */     if (postEventsForChanges()) {
/* 522 */       this._events.post(IDatabaseTranslation.ADD_PROPERTIES, argDatabaseTranslationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDatabaseTranslationProperty(IDatabaseTranslationProperty argDatabaseTranslationProperty) {
/* 527 */     if (this._properties != null) {
/*     */       
/* 529 */       if (postEventsForChanges()) {
/* 530 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDatabaseTranslationProperty));
/*     */       }
/* 532 */       this._properties.remove(argDatabaseTranslationProperty);
/* 533 */       if (postEventsForChanges()) {
/* 534 */         this._events.post(IDatabaseTranslation.REMOVE_PROPERTIES, argDatabaseTranslationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 541 */     if ("Properties".equals(argFieldId)) {
/* 542 */       return getProperties();
/*     */     }
/* 544 */     if ("DatabaseTranslationExtension".equals(argFieldId)) {
/* 545 */       return this._myExtension;
/*     */     }
/*     */     
/* 548 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 554 */     if ("Properties".equals(argFieldId)) {
/* 555 */       setProperties(changeToList(argValue, IDatabaseTranslationProperty.class));
/*     */     }
/* 557 */     else if ("DatabaseTranslationExtension".equals(argFieldId)) {
/* 558 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 561 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 567 */     this._persistenceDefaults = argPD;
/* 568 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 569 */     this._eventManager = argEM;
/* 570 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 571 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 572 */     if (this._properties != null) {
/* 573 */       for (IDatabaseTranslationProperty relationship : this._properties) {
/* 574 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDatabaseTranslationExt() {
/* 580 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDatabaseTranslationExt(IDataModel argExt) {
/* 584 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 589 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 593 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 596 */     super.startTransaction();
/*     */     
/* 598 */     this._propertiesSavepoint = this._properties;
/* 599 */     if (this._properties != null) {
/* 600 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 601 */       Iterator<IDataModel> it = this._properties.iterator();
/* 602 */       while (it.hasNext()) {
/* 603 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 608 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 613 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 616 */     super.rollbackChanges();
/*     */     
/* 618 */     this._properties = this._propertiesSavepoint;
/* 619 */     this._propertiesSavepoint = null;
/* 620 */     if (this._properties != null) {
/* 621 */       Iterator<IDataModel> it = this._properties.iterator();
/* 622 */       while (it.hasNext()) {
/* 623 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 631 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 634 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 637 */     super.commitTransaction();
/*     */     
/* 639 */     this._propertiesSavepoint = this._properties;
/* 640 */     if (this._properties != null) {
/* 641 */       Iterator<IDataModel> it = this._properties.iterator();
/* 642 */       while (it.hasNext()) {
/* 643 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 645 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 649 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 654 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\DatabaseTranslationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */