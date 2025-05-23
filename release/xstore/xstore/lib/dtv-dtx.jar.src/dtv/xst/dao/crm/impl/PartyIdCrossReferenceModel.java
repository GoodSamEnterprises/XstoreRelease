/*     */ package dtv.xst.dao.crm.impl;
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
/*     */ import dtv.xst.dao.crm.IPartyIdCrossReference;
/*     */ import dtv.xst.dao.crm.IPartyIdCrossReferenceProperty;
/*     */ import dtv.xst.dao.crm.PartyIdCrossReferencePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PartyIdCrossReferenceModel extends AbstractDataModelWithPropertyImpl<IPartyIdCrossReferenceProperty> implements IPartyIdCrossReference {
/*     */   private static final long serialVersionUID = 1914929100L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPartyIdCrossReferenceProperty> _properties; private transient HistoricalList<IPartyIdCrossReferenceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PartyIdCrossReferenceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PartyIdCrossReferenceDAO getDAO_() {
/*  46 */     return (PartyIdCrossReferenceDAO)this._daoImpl;
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
/*  70 */       this._events.post(IPartyIdCrossReference.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<PartyIdCrossReferencePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PartyIdCrossReferencePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getPartyId() {
/* 101 */     if (getDAO_().getPartyId() != null) {
/* 102 */       return getDAO_().getPartyId().longValue();
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
/*     */   public void setPartyId(long argPartyId) {
/* 114 */     if (setPartyId_noev(argPartyId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IPartyIdCrossReference.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 127 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 128 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<PartyIdCrossReferencePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((PartyIdCrossReferencePropertyModel)it.next()).setPartyId_noev(argPartyId);
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
/*     */   public String getAlternateIdOwner() {
/* 148 */     return getDAO_().getAlternateIdOwner();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlternateIdOwner(String argAlternateIdOwner) {
/* 156 */     if (setAlternateIdOwner_noev(argAlternateIdOwner) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IPartyIdCrossReference.SET_ALTERNATEIDOWNER, argAlternateIdOwner);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAlternateIdOwner_noev(String argAlternateIdOwner) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getAlternateIdOwner() == null && argAlternateIdOwner != null) || (
/* 169 */       getDAO_().getAlternateIdOwner() != null && !getDAO_().getAlternateIdOwner().equals(argAlternateIdOwner))) {
/* 170 */       getDAO_().setAlternateIdOwner(argAlternateIdOwner);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<PartyIdCrossReferencePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((PartyIdCrossReferencePropertyModel)it.next()).setAlternateIdOwner_noev(argAlternateIdOwner);
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
/* 201 */       this._events.post(IPartyIdCrossReference.SET_CREATEDATE, argCreateDate);
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
/* 235 */       this._events.post(IPartyIdCrossReference.SET_CREATEUSERID, argCreateUserId);
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
/* 269 */       this._events.post(IPartyIdCrossReference.SET_UPDATEDATE, argUpdateDate);
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
/* 303 */       this._events.post(IPartyIdCrossReference.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getAlternateId() {
/* 326 */     return getDAO_().getAlternateId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlternateId(String argAlternateId) {
/* 334 */     if (setAlternateId_noev(argAlternateId) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IPartyIdCrossReference.SET_ALTERNATEID, argAlternateId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAlternateId_noev(String argAlternateId) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getAlternateId() == null && argAlternateId != null) || (
/* 347 */       getDAO_().getAlternateId() != null && !getDAO_().getAlternateId().equals(argAlternateId))) {
/* 348 */       getDAO_().setAlternateId(argAlternateId);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPartyIdCrossReferenceProperty newProperty(String argPropertyName) {
/* 356 */     PartyIdCrossReferencePropertyId id = new PartyIdCrossReferencePropertyId();
/*     */     
/* 358 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 359 */     id.setAlternateIdOwner(getAlternateIdOwner());
/* 360 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 362 */     IPartyIdCrossReferenceProperty prop = (IPartyIdCrossReferenceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPartyIdCrossReferenceProperty.class);
/* 363 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPartyIdCrossReferenceProperty> getProperties() {
/* 372 */     if (this._properties == null) {
/* 373 */       this._properties = new HistoricalList(null);
/*     */     }
/* 375 */     return (List<IPartyIdCrossReferenceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPartyIdCrossReferenceProperty> argProperties) {
/* 379 */     if (this._properties == null) {
/* 380 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 382 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 385 */     for (IPartyIdCrossReferenceProperty child : this._properties) {
/* 386 */       PartyIdCrossReferencePropertyModel model = (PartyIdCrossReferencePropertyModel)child;
/* 387 */       model.setOrganizationId_noev(getOrganizationId());
/* 388 */       model.setPartyId_noev(getPartyId());
/* 389 */       model.setAlternateIdOwner_noev(getAlternateIdOwner());
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
/*     */   public void addPartyIdCrossReferenceProperty(IPartyIdCrossReferenceProperty argPartyIdCrossReferenceProperty) {
/* 404 */     if (this._properties == null) {
/* 405 */       this._properties = new HistoricalList(null);
/*     */     }
/* 407 */     argPartyIdCrossReferenceProperty.setOrganizationId(getOrganizationId());
/* 408 */     argPartyIdCrossReferenceProperty.setPartyId(getPartyId());
/* 409 */     argPartyIdCrossReferenceProperty.setAlternateIdOwner(getAlternateIdOwner());
/* 410 */     if (argPartyIdCrossReferenceProperty instanceof IDataModelImpl) {
/* 411 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyIdCrossReferenceProperty).getDAO();
/* 412 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 413 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 414 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 419 */     if (postEventsForChanges()) {
/* 420 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyIdCrossReferenceProperty));
/*     */     }
/*     */     
/* 423 */     this._properties.add(argPartyIdCrossReferenceProperty);
/* 424 */     if (postEventsForChanges()) {
/* 425 */       this._events.post(IPartyIdCrossReference.ADD_PROPERTIES, argPartyIdCrossReferenceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePartyIdCrossReferenceProperty(IPartyIdCrossReferenceProperty argPartyIdCrossReferenceProperty) {
/* 430 */     if (this._properties != null) {
/*     */       
/* 432 */       if (postEventsForChanges()) {
/* 433 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyIdCrossReferenceProperty));
/*     */       }
/* 435 */       this._properties.remove(argPartyIdCrossReferenceProperty);
/* 436 */       if (postEventsForChanges()) {
/* 437 */         this._events.post(IPartyIdCrossReference.REMOVE_PROPERTIES, argPartyIdCrossReferenceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 444 */     if ("Properties".equals(argFieldId)) {
/* 445 */       return getProperties();
/*     */     }
/* 447 */     if ("PartyIdCrossReferenceExtension".equals(argFieldId)) {
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
/* 458 */       setProperties(changeToList(argValue, IPartyIdCrossReferenceProperty.class));
/*     */     }
/* 460 */     else if ("PartyIdCrossReferenceExtension".equals(argFieldId)) {
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
/* 476 */       for (IPartyIdCrossReferenceProperty relationship : this._properties) {
/* 477 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPartyIdCrossReferenceExt() {
/* 483 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPartyIdCrossReferenceExt(IDataModel argExt) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyIdCrossReferenceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */