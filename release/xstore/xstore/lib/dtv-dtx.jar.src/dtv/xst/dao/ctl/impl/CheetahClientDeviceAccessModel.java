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
/*     */ import dtv.xst.dao.ctl.CheetahClientDeviceAccessPropertyId;
/*     */ import dtv.xst.dao.ctl.ICheetahClientDeviceAccess;
/*     */ import dtv.xst.dao.ctl.ICheetahClientDeviceAccessProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CheetahClientDeviceAccessModel extends AbstractDataModelWithPropertyImpl<ICheetahClientDeviceAccessProperty> implements ICheetahClientDeviceAccess {
/*     */   private static final long serialVersionUID = -1641526533L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICheetahClientDeviceAccessProperty> _properties; private transient HistoricalList<ICheetahClientDeviceAccessProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CheetahClientDeviceAccessDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CheetahClientDeviceAccessDAO getDAO_() {
/*  46 */     return (CheetahClientDeviceAccessDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICheetahClientDeviceAccess.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CheetahClientDeviceAccessPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CheetahClientDeviceAccessPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 101 */     if (getDAO_().getRetailLocationId() != null) {
/* 102 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 105 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(ICheetahClientDeviceAccess.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<CheetahClientDeviceAccessPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((CheetahClientDeviceAccessPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getToken() {
/* 148 */     return getDAO_().getToken();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setToken(String argToken) {
/* 156 */     if (setToken_noev(argToken) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ICheetahClientDeviceAccess.SET_TOKEN, argToken);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setToken_noev(String argToken) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getToken() == null && argToken != null) || (
/* 169 */       getDAO_().getToken() != null && !getDAO_().getToken().equals(argToken))) {
/* 170 */       getDAO_().setToken(argToken);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<CheetahClientDeviceAccessPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((CheetahClientDeviceAccessPropertyModel)it.next()).setToken_noev(argToken);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 190 */     if (getDAO_().getWorkstationId() != null) {
/* 191 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 194 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 203 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(ICheetahClientDeviceAccess.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 216 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 217 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 218 */       ev_postable = true;
/*     */     } 
/*     */     
/* 221 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatus() {
/* 229 */     return getDAO_().getStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatus(String argStatus) {
/* 237 */     if (setStatus_noev(argStatus) && 
/* 238 */       this._events != null && 
/* 239 */       postEventsForChanges()) {
/* 240 */       this._events.post(ICheetahClientDeviceAccess.SET_STATUS, argStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStatus_noev(String argStatus) {
/* 247 */     boolean ev_postable = false;
/*     */     
/* 249 */     if ((getDAO_().getStatus() == null && argStatus != null) || (
/* 250 */       getDAO_().getStatus() != null && !getDAO_().getStatus().equals(argStatus))) {
/* 251 */       getDAO_().setStatus(argStatus);
/* 252 */       ev_postable = true;
/*     */     } 
/*     */     
/* 255 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 263 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 271 */     if (setCreateDate_noev(argCreateDate) && 
/* 272 */       this._events != null && 
/* 273 */       postEventsForChanges()) {
/* 274 */       this._events.post(ICheetahClientDeviceAccess.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 281 */     boolean ev_postable = false;
/*     */     
/* 283 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 284 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 285 */       getDAO_().setCreateDate(argCreateDate);
/* 286 */       ev_postable = true;
/*     */     } 
/*     */     
/* 289 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 297 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 305 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 306 */       this._events != null && 
/* 307 */       postEventsForChanges()) {
/* 308 */       this._events.post(ICheetahClientDeviceAccess.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 315 */     boolean ev_postable = false;
/*     */     
/* 317 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 318 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 319 */       getDAO_().setCreateUserId(argCreateUserId);
/* 320 */       ev_postable = true;
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 331 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 339 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(ICheetahClientDeviceAccess.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 352 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 353 */       getDAO_().setUpdateDate(argUpdateDate);
/* 354 */       ev_postable = true;
/*     */     } 
/*     */     
/* 357 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 365 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 373 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(ICheetahClientDeviceAccess.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 386 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 387 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 388 */       ev_postable = true;
/*     */     } 
/*     */     
/* 391 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICheetahClientDeviceAccessProperty newProperty(String argPropertyName) {
/* 395 */     CheetahClientDeviceAccessPropertyId id = new CheetahClientDeviceAccessPropertyId();
/*     */     
/* 397 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 398 */     id.setToken(getToken());
/* 399 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 401 */     ICheetahClientDeviceAccessProperty prop = (ICheetahClientDeviceAccessProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICheetahClientDeviceAccessProperty.class);
/* 402 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICheetahClientDeviceAccessProperty> getProperties() {
/* 411 */     if (this._properties == null) {
/* 412 */       this._properties = new HistoricalList(null);
/*     */     }
/* 414 */     return (List<ICheetahClientDeviceAccessProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICheetahClientDeviceAccessProperty> argProperties) {
/* 418 */     if (this._properties == null) {
/* 419 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 421 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 424 */     for (ICheetahClientDeviceAccessProperty child : this._properties) {
/* 425 */       CheetahClientDeviceAccessPropertyModel model = (CheetahClientDeviceAccessPropertyModel)child;
/* 426 */       model.setOrganizationId_noev(getOrganizationId());
/* 427 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 428 */       model.setToken_noev(getToken());
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
/*     */   public void addCheetahClientDeviceAccessProperty(ICheetahClientDeviceAccessProperty argCheetahClientDeviceAccessProperty) {
/* 443 */     if (this._properties == null) {
/* 444 */       this._properties = new HistoricalList(null);
/*     */     }
/* 446 */     argCheetahClientDeviceAccessProperty.setOrganizationId(getOrganizationId());
/* 447 */     argCheetahClientDeviceAccessProperty.setRetailLocationId(getRetailLocationId());
/* 448 */     argCheetahClientDeviceAccessProperty.setToken(getToken());
/* 449 */     if (argCheetahClientDeviceAccessProperty instanceof IDataModelImpl) {
/* 450 */       IDataAccessObject childDao = ((IDataModelImpl)argCheetahClientDeviceAccessProperty).getDAO();
/* 451 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 452 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 453 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 458 */     if (postEventsForChanges()) {
/* 459 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCheetahClientDeviceAccessProperty));
/*     */     }
/*     */     
/* 462 */     this._properties.add(argCheetahClientDeviceAccessProperty);
/* 463 */     if (postEventsForChanges()) {
/* 464 */       this._events.post(ICheetahClientDeviceAccess.ADD_PROPERTIES, argCheetahClientDeviceAccessProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCheetahClientDeviceAccessProperty(ICheetahClientDeviceAccessProperty argCheetahClientDeviceAccessProperty) {
/* 469 */     if (this._properties != null) {
/*     */       
/* 471 */       if (postEventsForChanges()) {
/* 472 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCheetahClientDeviceAccessProperty));
/*     */       }
/* 474 */       this._properties.remove(argCheetahClientDeviceAccessProperty);
/* 475 */       if (postEventsForChanges()) {
/* 476 */         this._events.post(ICheetahClientDeviceAccess.REMOVE_PROPERTIES, argCheetahClientDeviceAccessProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 483 */     if ("Properties".equals(argFieldId)) {
/* 484 */       return getProperties();
/*     */     }
/* 486 */     if ("CheetahClientDeviceAccessExtension".equals(argFieldId)) {
/* 487 */       return this._myExtension;
/*     */     }
/*     */     
/* 490 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 496 */     if ("Properties".equals(argFieldId)) {
/* 497 */       setProperties(changeToList(argValue, ICheetahClientDeviceAccessProperty.class));
/*     */     }
/* 499 */     else if ("CheetahClientDeviceAccessExtension".equals(argFieldId)) {
/* 500 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 503 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 509 */     this._persistenceDefaults = argPD;
/* 510 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 511 */     this._eventManager = argEM;
/* 512 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 513 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 514 */     if (this._properties != null) {
/* 515 */       for (ICheetahClientDeviceAccessProperty relationship : this._properties) {
/* 516 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCheetahClientDeviceAccessExt() {
/* 522 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCheetahClientDeviceAccessExt(IDataModel argExt) {
/* 526 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 531 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 535 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 538 */     super.startTransaction();
/*     */     
/* 540 */     this._propertiesSavepoint = this._properties;
/* 541 */     if (this._properties != null) {
/* 542 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 543 */       Iterator<IDataModel> it = this._properties.iterator();
/* 544 */       while (it.hasNext()) {
/* 545 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 550 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 555 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 558 */     super.rollbackChanges();
/*     */     
/* 560 */     this._properties = this._propertiesSavepoint;
/* 561 */     this._propertiesSavepoint = null;
/* 562 */     if (this._properties != null) {
/* 563 */       Iterator<IDataModel> it = this._properties.iterator();
/* 564 */       while (it.hasNext()) {
/* 565 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 573 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 576 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 579 */     super.commitTransaction();
/*     */     
/* 581 */     this._propertiesSavepoint = this._properties;
/* 582 */     if (this._properties != null) {
/* 583 */       Iterator<IDataModel> it = this._properties.iterator();
/* 584 */       while (it.hasNext()) {
/* 585 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 587 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 591 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 596 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\CheetahClientDeviceAccessModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */