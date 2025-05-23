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
/*     */ import dtv.xst.dao.crm.IPartyCrossReference;
/*     */ import dtv.xst.dao.crm.IPartyCrossReferenceProperty;
/*     */ import dtv.xst.dao.crm.PartyCrossReferencePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PartyCrossReferenceModel extends AbstractDataModelWithPropertyImpl<IPartyCrossReferenceProperty> implements IPartyCrossReference {
/*     */   private static final long serialVersionUID = -462769327L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPartyCrossReferenceProperty> _properties; private transient HistoricalList<IPartyCrossReferenceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PartyCrossReferenceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PartyCrossReferenceDAO getDAO_() {
/*  46 */     return (PartyCrossReferenceDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getChildPartyId() {
/*  54 */     if (getDAO_().getChildPartyId() != null) {
/*  55 */       return getDAO_().getChildPartyId().longValue();
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
/*     */   public void setChildPartyId(long argChildPartyId) {
/*  67 */     if (setChildPartyId_noev(argChildPartyId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IPartyCrossReference.SET_CHILDPARTYID, Long.valueOf(argChildPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setChildPartyId_noev(long argChildPartyId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getChildPartyId() == null && Long.valueOf(argChildPartyId) != null) || (
/*  80 */       getDAO_().getChildPartyId() != null && !getDAO_().getChildPartyId().equals(Long.valueOf(argChildPartyId)))) {
/*  81 */       getDAO_().setChildPartyId(Long.valueOf(argChildPartyId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<PartyCrossReferencePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PartyCrossReferencePropertyModel)it.next()).setChildPartyId_noev(argChildPartyId);
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
/*     */   public long getOrganizationId() {
/* 101 */     if (getDAO_().getOrganizationId() != null) {
/* 102 */       return getDAO_().getOrganizationId().longValue();
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
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 114 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IPartyCrossReference.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 127 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 128 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<PartyCrossReferencePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((PartyCrossReferencePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getParentPartyId() {
/* 148 */     if (getDAO_().getParentPartyId() != null) {
/* 149 */       return getDAO_().getParentPartyId().longValue();
/*     */     }
/*     */     
/* 152 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentPartyId(long argParentPartyId) {
/* 161 */     if (setParentPartyId_noev(argParentPartyId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IPartyCrossReference.SET_PARENTPARTYID, Long.valueOf(argParentPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentPartyId_noev(long argParentPartyId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getParentPartyId() == null && Long.valueOf(argParentPartyId) != null) || (
/* 174 */       getDAO_().getParentPartyId() != null && !getDAO_().getParentPartyId().equals(Long.valueOf(argParentPartyId)))) {
/* 175 */       getDAO_().setParentPartyId(Long.valueOf(argParentPartyId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<PartyCrossReferencePropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((PartyCrossReferencePropertyModel)it.next()).setParentPartyId_noev(argParentPartyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPartyRelationshipTypeCode() {
/* 195 */     return getDAO_().getPartyRelationshipTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyRelationshipTypeCode(String argPartyRelationshipTypeCode) {
/* 203 */     if (setPartyRelationshipTypeCode_noev(argPartyRelationshipTypeCode) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IPartyCrossReference.SET_PARTYRELATIONSHIPTYPECODE, argPartyRelationshipTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyRelationshipTypeCode_noev(String argPartyRelationshipTypeCode) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getPartyRelationshipTypeCode() == null && argPartyRelationshipTypeCode != null) || (
/* 216 */       getDAO_().getPartyRelationshipTypeCode() != null && !getDAO_().getPartyRelationshipTypeCode().equals(argPartyRelationshipTypeCode))) {
/* 217 */       getDAO_().setPartyRelationshipTypeCode(argPartyRelationshipTypeCode);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<PartyCrossReferencePropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((PartyCrossReferencePropertyModel)it.next()).setPartyRelationshipTypeCode_noev(argPartyRelationshipTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 237 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 245 */     if (setCreateDate_noev(argCreateDate) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IPartyCrossReference.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 258 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 259 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 271 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 279 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IPartyCrossReference.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 292 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 293 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 305 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 313 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IPartyCrossReference.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 326 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 327 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 339 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 347 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IPartyCrossReference.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 360 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 361 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPartyCrossReferenceProperty newProperty(String argPropertyName) {
/* 369 */     PartyCrossReferencePropertyId id = new PartyCrossReferencePropertyId();
/*     */     
/* 371 */     id.setChildPartyId(Long.valueOf(getChildPartyId()));
/* 372 */     id.setParentPartyId(Long.valueOf(getParentPartyId()));
/* 373 */     id.setPartyRelationshipTypeCode(getPartyRelationshipTypeCode());
/* 374 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 376 */     IPartyCrossReferenceProperty prop = (IPartyCrossReferenceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPartyCrossReferenceProperty.class);
/* 377 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPartyCrossReferenceProperty> getProperties() {
/* 386 */     if (this._properties == null) {
/* 387 */       this._properties = new HistoricalList(null);
/*     */     }
/* 389 */     return (List<IPartyCrossReferenceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPartyCrossReferenceProperty> argProperties) {
/* 393 */     if (this._properties == null) {
/* 394 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 396 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 399 */     for (IPartyCrossReferenceProperty child : this._properties) {
/* 400 */       PartyCrossReferencePropertyModel model = (PartyCrossReferencePropertyModel)child;
/* 401 */       model.setChildPartyId_noev(getChildPartyId());
/* 402 */       model.setOrganizationId_noev(getOrganizationId());
/* 403 */       model.setParentPartyId_noev(getParentPartyId());
/* 404 */       model.setPartyRelationshipTypeCode_noev(getPartyRelationshipTypeCode());
/* 405 */       if (child instanceof IDataModelImpl) {
/* 406 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 407 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 408 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 409 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 412 */       if (postEventsForChanges()) {
/* 413 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPartyCrossReferenceProperty(IPartyCrossReferenceProperty argPartyCrossReferenceProperty) {
/* 419 */     if (this._properties == null) {
/* 420 */       this._properties = new HistoricalList(null);
/*     */     }
/* 422 */     argPartyCrossReferenceProperty.setChildPartyId(getChildPartyId());
/* 423 */     argPartyCrossReferenceProperty.setOrganizationId(getOrganizationId());
/* 424 */     argPartyCrossReferenceProperty.setParentPartyId(getParentPartyId());
/* 425 */     argPartyCrossReferenceProperty.setPartyRelationshipTypeCode(getPartyRelationshipTypeCode());
/* 426 */     if (argPartyCrossReferenceProperty instanceof IDataModelImpl) {
/* 427 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyCrossReferenceProperty).getDAO();
/* 428 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 429 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 430 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 435 */     if (postEventsForChanges()) {
/* 436 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyCrossReferenceProperty));
/*     */     }
/*     */     
/* 439 */     this._properties.add(argPartyCrossReferenceProperty);
/* 440 */     if (postEventsForChanges()) {
/* 441 */       this._events.post(IPartyCrossReference.ADD_PROPERTIES, argPartyCrossReferenceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePartyCrossReferenceProperty(IPartyCrossReferenceProperty argPartyCrossReferenceProperty) {
/* 446 */     if (this._properties != null) {
/*     */       
/* 448 */       if (postEventsForChanges()) {
/* 449 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyCrossReferenceProperty));
/*     */       }
/* 451 */       this._properties.remove(argPartyCrossReferenceProperty);
/* 452 */       if (postEventsForChanges()) {
/* 453 */         this._events.post(IPartyCrossReference.REMOVE_PROPERTIES, argPartyCrossReferenceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 460 */     if ("Properties".equals(argFieldId)) {
/* 461 */       return getProperties();
/*     */     }
/* 463 */     if ("PartyCrossReferenceExtension".equals(argFieldId)) {
/* 464 */       return this._myExtension;
/*     */     }
/*     */     
/* 467 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 473 */     if ("Properties".equals(argFieldId)) {
/* 474 */       setProperties(changeToList(argValue, IPartyCrossReferenceProperty.class));
/*     */     }
/* 476 */     else if ("PartyCrossReferenceExtension".equals(argFieldId)) {
/* 477 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 480 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 486 */     this._persistenceDefaults = argPD;
/* 487 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 488 */     this._eventManager = argEM;
/* 489 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 490 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 491 */     if (this._properties != null) {
/* 492 */       for (IPartyCrossReferenceProperty relationship : this._properties) {
/* 493 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPartyCrossReferenceExt() {
/* 499 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPartyCrossReferenceExt(IDataModel argExt) {
/* 503 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 508 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 512 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 515 */     super.startTransaction();
/*     */     
/* 517 */     this._propertiesSavepoint = this._properties;
/* 518 */     if (this._properties != null) {
/* 519 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 520 */       Iterator<IDataModel> it = this._properties.iterator();
/* 521 */       while (it.hasNext()) {
/* 522 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 527 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 532 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 535 */     super.rollbackChanges();
/*     */     
/* 537 */     this._properties = this._propertiesSavepoint;
/* 538 */     this._propertiesSavepoint = null;
/* 539 */     if (this._properties != null) {
/* 540 */       Iterator<IDataModel> it = this._properties.iterator();
/* 541 */       while (it.hasNext()) {
/* 542 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 550 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 553 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 556 */     super.commitTransaction();
/*     */     
/* 558 */     this._propertiesSavepoint = this._properties;
/* 559 */     if (this._properties != null) {
/* 560 */       Iterator<IDataModel> it = this._properties.iterator();
/* 561 */       while (it.hasNext()) {
/* 562 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 564 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 568 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 573 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyCrossReferenceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */