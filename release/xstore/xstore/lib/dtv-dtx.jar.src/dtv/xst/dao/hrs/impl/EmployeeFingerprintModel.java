/*     */ package dtv.xst.dao.hrs.impl;
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
/*     */ import dtv.xst.dao.hrs.EmployeeFingerprintPropertyId;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprint;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprintProperty;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EmployeeFingerprintModel extends EmployeeFingerprintBaseModel implements IEmployeeFingerprint {
/*     */   private static final long serialVersionUID = -2130044618L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IEmployeeFingerprintProperty> _properties; private transient HistoricalList<IEmployeeFingerprintProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new EmployeeFingerprintDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EmployeeFingerprintDAO getDAO_() {
/*  47 */     return (EmployeeFingerprintDAO)this._daoImpl;
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
/*  71 */       this._events.post(IEmployeeFingerprint.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<EmployeeFingerprintPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((EmployeeFingerprintPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getEmployeeId() {
/* 102 */     return getDAO_().getEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 110 */     if (setEmployeeId_noev(argEmployeeId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IEmployeeFingerprint.SET_EMPLOYEEID, argEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeId_noev(String argEmployeeId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/* 123 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/* 124 */       getDAO_().setEmployeeId(argEmployeeId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<EmployeeFingerprintPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((EmployeeFingerprintPropertyModel)it.next()).setEmployeeId_noev(argEmployeeId);
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
/*     */   public int getSequence() {
/* 144 */     if (getDAO_().getSequence() != null) {
/* 145 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 148 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 157 */     if (setSequence_noev(argSequence) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IEmployeeFingerprint.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 170 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 171 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 172 */       ev_postable = true;
/* 173 */       if (this._properties != null) {
/*     */         
/* 175 */         Iterator<EmployeeFingerprintPropertyModel> it = this._properties.iterator();
/* 176 */         while (it.hasNext())
/*     */         {
/* 178 */           ((EmployeeFingerprintPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 191 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 199 */     if (setCreateDate_noev(argCreateDate) && 
/* 200 */       this._events != null && 
/* 201 */       postEventsForChanges()) {
/* 202 */       this._events.post(IEmployeeFingerprint.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 209 */     boolean ev_postable = false;
/*     */     
/* 211 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 212 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 213 */       getDAO_().setCreateDate(argCreateDate);
/* 214 */       ev_postable = true;
/*     */     } 
/*     */     
/* 217 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 225 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 233 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 234 */       this._events != null && 
/* 235 */       postEventsForChanges()) {
/* 236 */       this._events.post(IEmployeeFingerprint.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 243 */     boolean ev_postable = false;
/*     */     
/* 245 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 246 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 247 */       getDAO_().setCreateUserId(argCreateUserId);
/* 248 */       ev_postable = true;
/*     */     } 
/*     */     
/* 251 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 259 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 267 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 268 */       this._events != null && 
/* 269 */       postEventsForChanges()) {
/* 270 */       this._events.post(IEmployeeFingerprint.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 277 */     boolean ev_postable = false;
/*     */     
/* 279 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 280 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 281 */       getDAO_().setUpdateDate(argUpdateDate);
/* 282 */       ev_postable = true;
/*     */     } 
/*     */     
/* 285 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 293 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 301 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 302 */       this._events != null && 
/* 303 */       postEventsForChanges()) {
/* 304 */       this._events.post(IEmployeeFingerprint.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 311 */     boolean ev_postable = false;
/*     */     
/* 313 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 314 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 315 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 316 */       ev_postable = true;
/*     */     } 
/*     */     
/* 319 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBiometricStorage() {
/* 327 */     return getDAO_().getBiometricStorage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBiometricStorage(String argBiometricStorage) {
/* 335 */     if (setBiometricStorage_noev(argBiometricStorage) && 
/* 336 */       this._events != null && 
/* 337 */       postEventsForChanges()) {
/* 338 */       this._events.post(IEmployeeFingerprint.SET_BIOMETRICSTORAGE, argBiometricStorage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBiometricStorage_noev(String argBiometricStorage) {
/* 345 */     boolean ev_postable = false;
/*     */     
/* 347 */     if ((getDAO_().getBiometricStorage() == null && argBiometricStorage != null) || (
/* 348 */       getDAO_().getBiometricStorage() != null && !getDAO_().getBiometricStorage().equals(argBiometricStorage))) {
/* 349 */       getDAO_().setBiometricStorage(argBiometricStorage);
/* 350 */       ev_postable = true;
/*     */     } 
/*     */     
/* 353 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEmployeeFingerprintProperty newProperty(String argPropertyName) {
/* 357 */     EmployeeFingerprintPropertyId id = new EmployeeFingerprintPropertyId();
/*     */     
/* 359 */     id.setEmployeeId(getEmployeeId());
/* 360 */     id.setSequence(Integer.valueOf(getSequence()));
/* 361 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 363 */     IEmployeeFingerprintProperty prop = (IEmployeeFingerprintProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeFingerprintProperty.class);
/* 364 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEmployeeFingerprintProperty> getProperties() {
/* 373 */     if (this._properties == null) {
/* 374 */       this._properties = new HistoricalList(null);
/*     */     }
/* 376 */     return (List<IEmployeeFingerprintProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEmployeeFingerprintProperty> argProperties) {
/* 380 */     if (this._properties == null) {
/* 381 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 383 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 386 */     for (IEmployeeFingerprintProperty child : this._properties) {
/* 387 */       EmployeeFingerprintPropertyModel model = (EmployeeFingerprintPropertyModel)child;
/* 388 */       model.setOrganizationId_noev(getOrganizationId());
/* 389 */       model.setEmployeeId_noev(getEmployeeId());
/* 390 */       model.setSequence_noev(getSequence());
/* 391 */       if (child instanceof IDataModelImpl) {
/* 392 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 393 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 394 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 395 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 398 */       if (postEventsForChanges()) {
/* 399 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEmployeeFingerprintProperty(IEmployeeFingerprintProperty argEmployeeFingerprintProperty) {
/* 405 */     if (this._properties == null) {
/* 406 */       this._properties = new HistoricalList(null);
/*     */     }
/* 408 */     argEmployeeFingerprintProperty.setOrganizationId(getOrganizationId());
/* 409 */     argEmployeeFingerprintProperty.setEmployeeId(getEmployeeId());
/* 410 */     argEmployeeFingerprintProperty.setSequence(getSequence());
/* 411 */     if (argEmployeeFingerprintProperty instanceof IDataModelImpl) {
/* 412 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeFingerprintProperty).getDAO();
/* 413 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 414 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 415 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 420 */     if (postEventsForChanges()) {
/* 421 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeFingerprintProperty));
/*     */     }
/*     */     
/* 424 */     this._properties.add(argEmployeeFingerprintProperty);
/* 425 */     if (postEventsForChanges()) {
/* 426 */       this._events.post(IEmployeeFingerprint.ADD_PROPERTIES, argEmployeeFingerprintProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEmployeeFingerprintProperty(IEmployeeFingerprintProperty argEmployeeFingerprintProperty) {
/* 431 */     if (this._properties != null) {
/*     */       
/* 433 */       if (postEventsForChanges()) {
/* 434 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeFingerprintProperty));
/*     */       }
/* 436 */       this._properties.remove(argEmployeeFingerprintProperty);
/* 437 */       if (postEventsForChanges()) {
/* 438 */         this._events.post(IEmployeeFingerprint.REMOVE_PROPERTIES, argEmployeeFingerprintProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 445 */     if ("Properties".equals(argFieldId)) {
/* 446 */       return getProperties();
/*     */     }
/* 448 */     if ("EmployeeFingerprintExtension".equals(argFieldId)) {
/* 449 */       return this._myExtension;
/*     */     }
/*     */     
/* 452 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 458 */     if ("Properties".equals(argFieldId)) {
/* 459 */       setProperties(changeToList(argValue, IEmployeeFingerprintProperty.class));
/*     */     }
/* 461 */     else if ("EmployeeFingerprintExtension".equals(argFieldId)) {
/* 462 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 465 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 471 */     this._persistenceDefaults = argPD;
/* 472 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 473 */     this._eventManager = argEM;
/* 474 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 475 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 476 */     if (this._properties != null) {
/* 477 */       for (IEmployeeFingerprintProperty relationship : this._properties) {
/* 478 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEmployeeFingerprintExt() {
/* 484 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEmployeeFingerprintExt(IDataModel argExt) {
/* 488 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 493 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 497 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 500 */     super.startTransaction();
/*     */     
/* 502 */     this._propertiesSavepoint = this._properties;
/* 503 */     if (this._properties != null) {
/* 504 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 505 */       Iterator<IDataModel> it = this._properties.iterator();
/* 506 */       while (it.hasNext()) {
/* 507 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 512 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 517 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 520 */     super.rollbackChanges();
/*     */     
/* 522 */     this._properties = this._propertiesSavepoint;
/* 523 */     this._propertiesSavepoint = null;
/* 524 */     if (this._properties != null) {
/* 525 */       Iterator<IDataModel> it = this._properties.iterator();
/* 526 */       while (it.hasNext()) {
/* 527 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 535 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 538 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 541 */     super.commitTransaction();
/*     */     
/* 543 */     this._propertiesSavepoint = this._properties;
/* 544 */     if (this._properties != null) {
/* 545 */       Iterator<IDataModel> it = this._properties.iterator();
/* 546 */       while (it.hasNext()) {
/* 547 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 549 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 553 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeFingerprintModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */