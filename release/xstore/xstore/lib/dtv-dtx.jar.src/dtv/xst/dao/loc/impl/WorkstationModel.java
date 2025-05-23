/*     */ package dtv.xst.dao.loc.impl;
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
/*     */ import dtv.xst.dao.loc.IWorkstation;
/*     */ import dtv.xst.dao.loc.IWorkstationProperty;
/*     */ import dtv.xst.dao.loc.WorkstationPropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WorkstationModel extends WorkstationBaseModel implements IWorkstation {
/*     */   private static final long serialVersionUID = -2045510429L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IWorkstationProperty> _properties; private transient HistoricalList<IWorkstationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new WorkstationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorkstationDAO getDAO_() {
/*  47 */     return (WorkstationDAO)this._daoImpl;
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
/*  71 */       this._events.post(IWorkstation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<WorkstationPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((WorkstationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 118 */       this._events.post(IWorkstation.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 133 */         Iterator<WorkstationPropertyModel> it = this._properties.iterator();
/* 134 */         while (it.hasNext())
/*     */         {
/* 136 */           ((WorkstationPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public long getWorkstationId() {
/* 149 */     if (getDAO_().getWorkstationId() != null) {
/* 150 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 153 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 162 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 163 */       this._events != null && 
/* 164 */       postEventsForChanges()) {
/* 165 */       this._events.post(IWorkstation.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 172 */     boolean ev_postable = false;
/*     */     
/* 174 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 175 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 176 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 177 */       ev_postable = true;
/* 178 */       if (this._properties != null) {
/*     */         
/* 180 */         Iterator<WorkstationPropertyModel> it = this._properties.iterator();
/* 181 */         while (it.hasNext())
/*     */         {
/* 183 */           ((WorkstationPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 196 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 204 */     if (setCreateDate_noev(argCreateDate) && 
/* 205 */       this._events != null && 
/* 206 */       postEventsForChanges()) {
/* 207 */       this._events.post(IWorkstation.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 214 */     boolean ev_postable = false;
/*     */     
/* 216 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 217 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 218 */       getDAO_().setCreateDate(argCreateDate);
/* 219 */       ev_postable = true;
/*     */     } 
/*     */     
/* 222 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 230 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 238 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 239 */       this._events != null && 
/* 240 */       postEventsForChanges()) {
/* 241 */       this._events.post(IWorkstation.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 248 */     boolean ev_postable = false;
/*     */     
/* 250 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 251 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 252 */       getDAO_().setCreateUserId(argCreateUserId);
/* 253 */       ev_postable = true;
/*     */     } 
/*     */     
/* 256 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 264 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 272 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 273 */       this._events != null && 
/* 274 */       postEventsForChanges()) {
/* 275 */       this._events.post(IWorkstation.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 282 */     boolean ev_postable = false;
/*     */     
/* 284 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 285 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 286 */       getDAO_().setUpdateDate(argUpdateDate);
/* 287 */       ev_postable = true;
/*     */     } 
/*     */     
/* 290 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 298 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 306 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 307 */       this._events != null && 
/* 308 */       postEventsForChanges()) {
/* 309 */       this._events.post(IWorkstation.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 316 */     boolean ev_postable = false;
/*     */     
/* 318 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 319 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 320 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 321 */       ev_postable = true;
/*     */     } 
/*     */     
/* 324 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWorkstationProperty newProperty(String argPropertyName) {
/* 328 */     WorkstationPropertyId id = new WorkstationPropertyId();
/*     */     
/* 330 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 331 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 332 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 334 */     IWorkstationProperty prop = (IWorkstationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWorkstationProperty.class);
/* 335 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWorkstationProperty> getProperties() {
/* 344 */     if (this._properties == null) {
/* 345 */       this._properties = new HistoricalList(null);
/*     */     }
/* 347 */     return (List<IWorkstationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWorkstationProperty> argProperties) {
/* 351 */     if (this._properties == null) {
/* 352 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 354 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 357 */     for (IWorkstationProperty child : this._properties) {
/* 358 */       WorkstationPropertyModel model = (WorkstationPropertyModel)child;
/* 359 */       model.setOrganizationId_noev(getOrganizationId());
/* 360 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 361 */       model.setWorkstationId_noev(getWorkstationId());
/* 362 */       if (child instanceof IDataModelImpl) {
/* 363 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 364 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 365 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 366 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 369 */       if (postEventsForChanges()) {
/* 370 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWorkstationProperty(IWorkstationProperty argWorkstationProperty) {
/* 376 */     if (this._properties == null) {
/* 377 */       this._properties = new HistoricalList(null);
/*     */     }
/* 379 */     argWorkstationProperty.setOrganizationId(getOrganizationId());
/* 380 */     argWorkstationProperty.setRetailLocationId(getRetailLocationId());
/* 381 */     argWorkstationProperty.setWorkstationId(getWorkstationId());
/* 382 */     if (argWorkstationProperty instanceof IDataModelImpl) {
/* 383 */       IDataAccessObject childDao = ((IDataModelImpl)argWorkstationProperty).getDAO();
/* 384 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 385 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 386 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 391 */     if (postEventsForChanges()) {
/* 392 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkstationProperty));
/*     */     }
/*     */     
/* 395 */     this._properties.add(argWorkstationProperty);
/* 396 */     if (postEventsForChanges()) {
/* 397 */       this._events.post(IWorkstation.ADD_PROPERTIES, argWorkstationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWorkstationProperty(IWorkstationProperty argWorkstationProperty) {
/* 402 */     if (this._properties != null) {
/*     */       
/* 404 */       if (postEventsForChanges()) {
/* 405 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkstationProperty));
/*     */       }
/* 407 */       this._properties.remove(argWorkstationProperty);
/* 408 */       if (postEventsForChanges()) {
/* 409 */         this._events.post(IWorkstation.REMOVE_PROPERTIES, argWorkstationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 416 */     if ("Properties".equals(argFieldId)) {
/* 417 */       return getProperties();
/*     */     }
/* 419 */     if ("WorkstationExtension".equals(argFieldId)) {
/* 420 */       return this._myExtension;
/*     */     }
/*     */     
/* 423 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 429 */     if ("Properties".equals(argFieldId)) {
/* 430 */       setProperties(changeToList(argValue, IWorkstationProperty.class));
/*     */     }
/* 432 */     else if ("WorkstationExtension".equals(argFieldId)) {
/* 433 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 436 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 442 */     this._persistenceDefaults = argPD;
/* 443 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 444 */     this._eventManager = argEM;
/* 445 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 446 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 447 */     if (this._properties != null) {
/* 448 */       for (IWorkstationProperty relationship : this._properties) {
/* 449 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWorkstationExt() {
/* 455 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWorkstationExt(IDataModel argExt) {
/* 459 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 464 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 468 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 471 */     super.startTransaction();
/*     */     
/* 473 */     this._propertiesSavepoint = this._properties;
/* 474 */     if (this._properties != null) {
/* 475 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 476 */       Iterator<IDataModel> it = this._properties.iterator();
/* 477 */       while (it.hasNext()) {
/* 478 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 483 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 488 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 491 */     super.rollbackChanges();
/*     */     
/* 493 */     this._properties = this._propertiesSavepoint;
/* 494 */     this._propertiesSavepoint = null;
/* 495 */     if (this._properties != null) {
/* 496 */       Iterator<IDataModel> it = this._properties.iterator();
/* 497 */       while (it.hasNext()) {
/* 498 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 506 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 509 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 512 */     super.commitTransaction();
/*     */     
/* 514 */     this._propertiesSavepoint = this._properties;
/* 515 */     if (this._properties != null) {
/* 516 */       Iterator<IDataModel> it = this._properties.iterator();
/* 517 */       while (it.hasNext()) {
/* 518 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 520 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 524 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\WorkstationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */