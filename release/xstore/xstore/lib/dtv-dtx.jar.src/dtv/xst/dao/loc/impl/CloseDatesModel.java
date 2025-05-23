/*     */ package dtv.xst.dao.loc.impl;
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
/*     */ import dtv.xst.dao.loc.CloseDatesPropertyId;
/*     */ import dtv.xst.dao.loc.ICloseDates;
/*     */ import dtv.xst.dao.loc.ICloseDatesProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CloseDatesModel extends AbstractDataModelWithPropertyImpl<ICloseDatesProperty> implements ICloseDates {
/*     */   private static final long serialVersionUID = -93581427L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICloseDatesProperty> _properties; private transient HistoricalList<ICloseDatesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CloseDatesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CloseDatesDAO getDAO_() {
/*  46 */     return (CloseDatesDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICloseDates.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CloseDatesPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CloseDatesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(ICloseDates.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<CloseDatesPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((CloseDatesPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public Date getCloseDate() {
/* 148 */     return getDAO_().getCloseDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCloseDate(Date argCloseDate) {
/* 156 */     if (setCloseDate_noev(argCloseDate) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ICloseDates.SET_CLOSEDATE, argCloseDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCloseDate_noev(Date argCloseDate) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getCloseDate() == null && argCloseDate != null) || (
/* 169 */       getDAO_().getCloseDate() != null && !getDAO_().getCloseDate().equals(argCloseDate))) {
/* 170 */       getDAO_().setCloseDate(argCloseDate);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<CloseDatesPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((CloseDatesPropertyModel)it.next()).setCloseDate_noev(argCloseDate);
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
/*     */   public Date getCreateDate() {
/* 190 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 198 */     if (setCreateDate_noev(argCreateDate) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(ICloseDates.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 211 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 212 */       getDAO_().setCreateDate(argCreateDate);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 224 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 232 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(ICloseDates.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 245 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 246 */       getDAO_().setCreateUserId(argCreateUserId);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 258 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 266 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(ICloseDates.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 279 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 280 */       getDAO_().setUpdateDate(argUpdateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 292 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 300 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(ICloseDates.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 313 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 314 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReasonCode() {
/* 326 */     return getDAO_().getReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 334 */     if (setReasonCode_noev(argReasonCode) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(ICloseDates.SET_REASONCODE, argReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReasonCode_noev(String argReasonCode) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/* 347 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/* 348 */       getDAO_().setReasonCode(argReasonCode);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICloseDatesProperty newProperty(String argPropertyName) {
/* 356 */     CloseDatesPropertyId id = new CloseDatesPropertyId();
/*     */     
/* 358 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 359 */     id.setCloseDate(getCloseDate());
/* 360 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 362 */     ICloseDatesProperty prop = (ICloseDatesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICloseDatesProperty.class);
/* 363 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICloseDatesProperty> getProperties() {
/* 372 */     if (this._properties == null) {
/* 373 */       this._properties = new HistoricalList(null);
/*     */     }
/* 375 */     return (List<ICloseDatesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICloseDatesProperty> argProperties) {
/* 379 */     if (this._properties == null) {
/* 380 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 382 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 385 */     for (ICloseDatesProperty child : this._properties) {
/* 386 */       CloseDatesPropertyModel model = (CloseDatesPropertyModel)child;
/* 387 */       model.setOrganizationId_noev(getOrganizationId());
/* 388 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 389 */       model.setCloseDate_noev(getCloseDate());
/* 390 */       if (child instanceof IDataModelImpl) {
/* 391 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 392 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 393 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 394 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 397 */       if (postEventsForChanges()) {
/* 398 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCloseDatesProperty(ICloseDatesProperty argCloseDatesProperty) {
/* 404 */     if (this._properties == null) {
/* 405 */       this._properties = new HistoricalList(null);
/*     */     }
/* 407 */     argCloseDatesProperty.setOrganizationId(getOrganizationId());
/* 408 */     argCloseDatesProperty.setRetailLocationId(getRetailLocationId());
/* 409 */     argCloseDatesProperty.setCloseDate(getCloseDate());
/* 410 */     if (argCloseDatesProperty instanceof IDataModelImpl) {
/* 411 */       IDataAccessObject childDao = ((IDataModelImpl)argCloseDatesProperty).getDAO();
/* 412 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 413 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 414 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 419 */     if (postEventsForChanges()) {
/* 420 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCloseDatesProperty));
/*     */     }
/*     */     
/* 423 */     this._properties.add(argCloseDatesProperty);
/* 424 */     if (postEventsForChanges()) {
/* 425 */       this._events.post(ICloseDates.ADD_PROPERTIES, argCloseDatesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCloseDatesProperty(ICloseDatesProperty argCloseDatesProperty) {
/* 430 */     if (this._properties != null) {
/*     */       
/* 432 */       if (postEventsForChanges()) {
/* 433 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCloseDatesProperty));
/*     */       }
/* 435 */       this._properties.remove(argCloseDatesProperty);
/* 436 */       if (postEventsForChanges()) {
/* 437 */         this._events.post(ICloseDates.REMOVE_PROPERTIES, argCloseDatesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 444 */     if ("Properties".equals(argFieldId)) {
/* 445 */       return getProperties();
/*     */     }
/* 447 */     if ("CloseDatesExtension".equals(argFieldId)) {
/* 448 */       return this._myExtension;
/*     */     }
/*     */     
/* 451 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 457 */     if ("Properties".equals(argFieldId)) {
/* 458 */       setProperties(changeToList(argValue, ICloseDatesProperty.class));
/*     */     }
/* 460 */     else if ("CloseDatesExtension".equals(argFieldId)) {
/* 461 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 464 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 470 */     this._persistenceDefaults = argPD;
/* 471 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 472 */     this._eventManager = argEM;
/* 473 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 474 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 475 */     if (this._properties != null) {
/* 476 */       for (ICloseDatesProperty relationship : this._properties) {
/* 477 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCloseDatesExt() {
/* 483 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCloseDatesExt(IDataModel argExt) {
/* 487 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 492 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 496 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 499 */     super.startTransaction();
/*     */     
/* 501 */     this._propertiesSavepoint = this._properties;
/* 502 */     if (this._properties != null) {
/* 503 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 504 */       Iterator<IDataModel> it = this._properties.iterator();
/* 505 */       while (it.hasNext()) {
/* 506 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 511 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 516 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 519 */     super.rollbackChanges();
/*     */     
/* 521 */     this._properties = this._propertiesSavepoint;
/* 522 */     this._propertiesSavepoint = null;
/* 523 */     if (this._properties != null) {
/* 524 */       Iterator<IDataModel> it = this._properties.iterator();
/* 525 */       while (it.hasNext()) {
/* 526 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 534 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 537 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 540 */     super.commitTransaction();
/*     */     
/* 542 */     this._propertiesSavepoint = this._properties;
/* 543 */     if (this._properties != null) {
/* 544 */       Iterator<IDataModel> it = this._properties.iterator();
/* 545 */       while (it.hasNext()) {
/* 546 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 548 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 552 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 557 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CloseDatesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */