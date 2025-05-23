/*     */ package dtv.xst.dao.ctl.impl;
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
/*     */ import dtv.xst.dao.ctl.IVersion;
/*     */ import dtv.xst.dao.ctl.IVersionProperty;
/*     */ import dtv.xst.dao.ctl.VersionPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class VersionModel extends AbstractDataModelWithPropertyImpl<IVersionProperty> implements IVersion {
/*     */   private static final long serialVersionUID = 2016261304L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IVersionProperty> _properties; private transient HistoricalList<IVersionProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new VersionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private VersionDAO getDAO_() {
/*  46 */     return (VersionDAO)this._daoImpl;
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
/*  70 */       this._events.post(IVersion.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<VersionPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((VersionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public Date getCreateDate() {
/* 101 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 109 */     if (setCreateDate_noev(argCreateDate) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IVersion.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 122 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 123 */       getDAO_().setCreateDate(argCreateDate);
/* 124 */       ev_postable = true;
/*     */     } 
/*     */     
/* 127 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 135 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 143 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 144 */       this._events != null && 
/* 145 */       postEventsForChanges()) {
/* 146 */       this._events.post(IVersion.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 153 */     boolean ev_postable = false;
/*     */     
/* 155 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 156 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 157 */       getDAO_().setCreateUserId(argCreateUserId);
/* 158 */       ev_postable = true;
/*     */     } 
/*     */     
/* 161 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 169 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 177 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 178 */       this._events != null && 
/* 179 */       postEventsForChanges()) {
/* 180 */       this._events.post(IVersion.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 187 */     boolean ev_postable = false;
/*     */     
/* 189 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 190 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 191 */       getDAO_().setUpdateDate(argUpdateDate);
/* 192 */       ev_postable = true;
/*     */     } 
/*     */     
/* 195 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 203 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 211 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 212 */       this._events != null && 
/* 213 */       postEventsForChanges()) {
/* 214 */       this._events.post(IVersion.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 221 */     boolean ev_postable = false;
/*     */     
/* 223 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 224 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 225 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 226 */       ev_postable = true;
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseSchemaVersion() {
/* 237 */     return getDAO_().getBaseSchemaVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseSchemaVersion(String argBaseSchemaVersion) {
/* 245 */     if (setBaseSchemaVersion_noev(argBaseSchemaVersion) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IVersion.SET_BASESCHEMAVERSION, argBaseSchemaVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseSchemaVersion_noev(String argBaseSchemaVersion) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getBaseSchemaVersion() == null && argBaseSchemaVersion != null) || (
/* 258 */       getDAO_().getBaseSchemaVersion() != null && !getDAO_().getBaseSchemaVersion().equals(argBaseSchemaVersion))) {
/* 259 */       getDAO_().setBaseSchemaVersion(argBaseSchemaVersion);
/* 260 */       ev_postable = true;
/*     */     } 
/*     */     
/* 263 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerSchemaVersion() {
/* 271 */     return getDAO_().getCustomerSchemaVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerSchemaVersion(String argCustomerSchemaVersion) {
/* 279 */     if (setCustomerSchemaVersion_noev(argCustomerSchemaVersion) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IVersion.SET_CUSTOMERSCHEMAVERSION, argCustomerSchemaVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerSchemaVersion_noev(String argCustomerSchemaVersion) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getCustomerSchemaVersion() == null && argCustomerSchemaVersion != null) || (
/* 292 */       getDAO_().getCustomerSchemaVersion() != null && !getDAO_().getCustomerSchemaVersion().equals(argCustomerSchemaVersion))) {
/* 293 */       getDAO_().setCustomerSchemaVersion(argCustomerSchemaVersion);
/* 294 */       ev_postable = true;
/*     */     } 
/*     */     
/* 297 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomer() {
/* 305 */     return getDAO_().getCustomer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomer(String argCustomer) {
/* 313 */     if (setCustomer_noev(argCustomer) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IVersion.SET_CUSTOMER, argCustomer);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomer_noev(String argCustomer) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getCustomer() == null && argCustomer != null) || (
/* 326 */       getDAO_().getCustomer() != null && !getDAO_().getCustomer().equals(argCustomer))) {
/* 327 */       getDAO_().setCustomer(argCustomer);
/* 328 */       ev_postable = true;
/*     */     } 
/*     */     
/* 331 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBaseSchemaDate() {
/* 339 */     return getDAO_().getBaseSchemaDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseSchemaDate(Date argBaseSchemaDate) {
/* 347 */     if (setBaseSchemaDate_noev(argBaseSchemaDate) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IVersion.SET_BASESCHEMADATE, argBaseSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseSchemaDate_noev(Date argBaseSchemaDate) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getBaseSchemaDate() == null && argBaseSchemaDate != null) || (
/* 360 */       getDAO_().getBaseSchemaDate() != null && !getDAO_().getBaseSchemaDate().equals(argBaseSchemaDate))) {
/* 361 */       getDAO_().setBaseSchemaDate(argBaseSchemaDate);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCustomerSchemaDate() {
/* 373 */     return getDAO_().getCustomerSchemaDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerSchemaDate(Date argCustomerSchemaDate) {
/* 381 */     if (setCustomerSchemaDate_noev(argCustomerSchemaDate) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IVersion.SET_CUSTOMERSCHEMADATE, argCustomerSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerSchemaDate_noev(Date argCustomerSchemaDate) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getCustomerSchemaDate() == null && argCustomerSchemaDate != null) || (
/* 394 */       getDAO_().getCustomerSchemaDate() != null && !getDAO_().getCustomerSchemaDate().equals(argCustomerSchemaDate))) {
/* 395 */       getDAO_().setCustomerSchemaDate(argCustomerSchemaDate);
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IVersionProperty newProperty(String argPropertyName) {
/* 403 */     VersionPropertyId id = new VersionPropertyId();
/*     */     
/* 405 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 407 */     IVersionProperty prop = (IVersionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IVersionProperty.class);
/* 408 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IVersionProperty> getProperties() {
/* 417 */     if (this._properties == null) {
/* 418 */       this._properties = new HistoricalList(null);
/*     */     }
/* 420 */     return (List<IVersionProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IVersionProperty> argProperties) {
/* 424 */     if (this._properties == null) {
/* 425 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 427 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 430 */     for (IVersionProperty child : this._properties) {
/* 431 */       VersionPropertyModel model = (VersionPropertyModel)child;
/* 432 */       model.setOrganizationId_noev(getOrganizationId());
/* 433 */       if (child instanceof IDataModelImpl) {
/* 434 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 435 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 436 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 437 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 440 */       if (postEventsForChanges()) {
/* 441 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addVersionProperty(IVersionProperty argVersionProperty) {
/* 447 */     if (this._properties == null) {
/* 448 */       this._properties = new HistoricalList(null);
/*     */     }
/* 450 */     argVersionProperty.setOrganizationId(getOrganizationId());
/* 451 */     if (argVersionProperty instanceof IDataModelImpl) {
/* 452 */       IDataAccessObject childDao = ((IDataModelImpl)argVersionProperty).getDAO();
/* 453 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 454 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 455 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 460 */     if (postEventsForChanges()) {
/* 461 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVersionProperty));
/*     */     }
/*     */     
/* 464 */     this._properties.add(argVersionProperty);
/* 465 */     if (postEventsForChanges()) {
/* 466 */       this._events.post(IVersion.ADD_PROPERTIES, argVersionProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeVersionProperty(IVersionProperty argVersionProperty) {
/* 471 */     if (this._properties != null) {
/*     */       
/* 473 */       if (postEventsForChanges()) {
/* 474 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVersionProperty));
/*     */       }
/* 476 */       this._properties.remove(argVersionProperty);
/* 477 */       if (postEventsForChanges()) {
/* 478 */         this._events.post(IVersion.REMOVE_PROPERTIES, argVersionProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 485 */     if ("Properties".equals(argFieldId)) {
/* 486 */       return getProperties();
/*     */     }
/* 488 */     if ("VersionExtension".equals(argFieldId)) {
/* 489 */       return this._myExtension;
/*     */     }
/*     */     
/* 492 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 498 */     if ("Properties".equals(argFieldId)) {
/* 499 */       setProperties(changeToList(argValue, IVersionProperty.class));
/*     */     }
/* 501 */     else if ("VersionExtension".equals(argFieldId)) {
/* 502 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 505 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 511 */     this._persistenceDefaults = argPD;
/* 512 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 513 */     this._eventManager = argEM;
/* 514 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 515 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 516 */     if (this._properties != null) {
/* 517 */       for (IVersionProperty relationship : this._properties) {
/* 518 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getVersionExt() {
/* 524 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setVersionExt(IDataModel argExt) {
/* 528 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 533 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 537 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 540 */     super.startTransaction();
/*     */     
/* 542 */     this._propertiesSavepoint = this._properties;
/* 543 */     if (this._properties != null) {
/* 544 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 545 */       Iterator<IDataModel> it = this._properties.iterator();
/* 546 */       while (it.hasNext()) {
/* 547 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 552 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 557 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 560 */     super.rollbackChanges();
/*     */     
/* 562 */     this._properties = this._propertiesSavepoint;
/* 563 */     this._propertiesSavepoint = null;
/* 564 */     if (this._properties != null) {
/* 565 */       Iterator<IDataModel> it = this._properties.iterator();
/* 566 */       while (it.hasNext()) {
/* 567 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 575 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 578 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 581 */     super.commitTransaction();
/*     */     
/* 583 */     this._propertiesSavepoint = this._properties;
/* 584 */     if (this._properties != null) {
/* 585 */       Iterator<IDataModel> it = this._properties.iterator();
/* 586 */       while (it.hasNext()) {
/* 587 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 589 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 593 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 598 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\VersionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */