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
/*     */ import dtv.xst.dao.crm.CustomerAffiliationPropertyId;
/*     */ import dtv.xst.dao.crm.ICustomerAffiliation;
/*     */ import dtv.xst.dao.crm.ICustomerAffiliationProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerAffiliationModel extends AbstractDataModelWithPropertyImpl<ICustomerAffiliationProperty> implements ICustomerAffiliation {
/*     */   private static final long serialVersionUID = -1596359662L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICustomerAffiliationProperty> _properties; private transient HistoricalList<ICustomerAffiliationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CustomerAffiliationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerAffiliationDAO getDAO_() {
/*  46 */     return (CustomerAffiliationDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICustomerAffiliation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CustomerAffiliationPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CustomerAffiliationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(ICustomerAffiliation.SET_PARTYID, Long.valueOf(argPartyId));
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
/* 132 */         Iterator<CustomerAffiliationPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((CustomerAffiliationPropertyModel)it.next()).setPartyId_noev(argPartyId);
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
/*     */   public String getCustomerGroupId() {
/* 148 */     return getDAO_().getCustomerGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerGroupId(String argCustomerGroupId) {
/* 156 */     if (setCustomerGroupId_noev(argCustomerGroupId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ICustomerAffiliation.SET_CUSTOMERGROUPID, argCustomerGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerGroupId_noev(String argCustomerGroupId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getCustomerGroupId() == null && argCustomerGroupId != null) || (
/* 169 */       getDAO_().getCustomerGroupId() != null && !getDAO_().getCustomerGroupId().equals(argCustomerGroupId))) {
/* 170 */       getDAO_().setCustomerGroupId(argCustomerGroupId);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<CustomerAffiliationPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((CustomerAffiliationPropertyModel)it.next()).setCustomerGroupId_noev(argCustomerGroupId);
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
/* 201 */       this._events.post(ICustomerAffiliation.SET_CREATEDATE, argCreateDate);
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
/* 235 */       this._events.post(ICustomerAffiliation.SET_CREATEUSERID, argCreateUserId);
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
/* 269 */       this._events.post(ICustomerAffiliation.SET_UPDATEDATE, argUpdateDate);
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
/* 303 */       this._events.post(ICustomerAffiliation.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   protected ICustomerAffiliationProperty newProperty(String argPropertyName) {
/* 322 */     CustomerAffiliationPropertyId id = new CustomerAffiliationPropertyId();
/*     */     
/* 324 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 325 */     id.setCustomerGroupId(getCustomerGroupId());
/* 326 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 328 */     ICustomerAffiliationProperty prop = (ICustomerAffiliationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerAffiliationProperty.class);
/* 329 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerAffiliationProperty> getProperties() {
/* 338 */     if (this._properties == null) {
/* 339 */       this._properties = new HistoricalList(null);
/*     */     }
/* 341 */     return (List<ICustomerAffiliationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerAffiliationProperty> argProperties) {
/* 345 */     if (this._properties == null) {
/* 346 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 348 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 351 */     for (ICustomerAffiliationProperty child : this._properties) {
/* 352 */       CustomerAffiliationPropertyModel model = (CustomerAffiliationPropertyModel)child;
/* 353 */       model.setOrganizationId_noev(getOrganizationId());
/* 354 */       model.setPartyId_noev(getPartyId());
/* 355 */       model.setCustomerGroupId_noev(getCustomerGroupId());
/* 356 */       if (child instanceof IDataModelImpl) {
/* 357 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 358 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 359 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 360 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 363 */       if (postEventsForChanges()) {
/* 364 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerAffiliationProperty(ICustomerAffiliationProperty argCustomerAffiliationProperty) {
/* 370 */     if (this._properties == null) {
/* 371 */       this._properties = new HistoricalList(null);
/*     */     }
/* 373 */     argCustomerAffiliationProperty.setOrganizationId(getOrganizationId());
/* 374 */     argCustomerAffiliationProperty.setPartyId(getPartyId());
/* 375 */     argCustomerAffiliationProperty.setCustomerGroupId(getCustomerGroupId());
/* 376 */     if (argCustomerAffiliationProperty instanceof IDataModelImpl) {
/* 377 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAffiliationProperty).getDAO();
/* 378 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 379 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 380 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 385 */     if (postEventsForChanges()) {
/* 386 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAffiliationProperty));
/*     */     }
/*     */     
/* 389 */     this._properties.add(argCustomerAffiliationProperty);
/* 390 */     if (postEventsForChanges()) {
/* 391 */       this._events.post(ICustomerAffiliation.ADD_PROPERTIES, argCustomerAffiliationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerAffiliationProperty(ICustomerAffiliationProperty argCustomerAffiliationProperty) {
/* 396 */     if (this._properties != null) {
/*     */       
/* 398 */       if (postEventsForChanges()) {
/* 399 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAffiliationProperty));
/*     */       }
/* 401 */       this._properties.remove(argCustomerAffiliationProperty);
/* 402 */       if (postEventsForChanges()) {
/* 403 */         this._events.post(ICustomerAffiliation.REMOVE_PROPERTIES, argCustomerAffiliationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 410 */     if ("Properties".equals(argFieldId)) {
/* 411 */       return getProperties();
/*     */     }
/* 413 */     if ("CustomerAffiliationExtension".equals(argFieldId)) {
/* 414 */       return this._myExtension;
/*     */     }
/*     */     
/* 417 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 423 */     if ("Properties".equals(argFieldId)) {
/* 424 */       setProperties(changeToList(argValue, ICustomerAffiliationProperty.class));
/*     */     }
/* 426 */     else if ("CustomerAffiliationExtension".equals(argFieldId)) {
/* 427 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 430 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 436 */     this._persistenceDefaults = argPD;
/* 437 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 438 */     this._eventManager = argEM;
/* 439 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 440 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 441 */     if (this._properties != null) {
/* 442 */       for (ICustomerAffiliationProperty relationship : this._properties) {
/* 443 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerAffiliationExt() {
/* 449 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerAffiliationExt(IDataModel argExt) {
/* 453 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 458 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 462 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 465 */     super.startTransaction();
/*     */     
/* 467 */     this._propertiesSavepoint = this._properties;
/* 468 */     if (this._properties != null) {
/* 469 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 470 */       Iterator<IDataModel> it = this._properties.iterator();
/* 471 */       while (it.hasNext()) {
/* 472 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 477 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 482 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 485 */     super.rollbackChanges();
/*     */     
/* 487 */     this._properties = this._propertiesSavepoint;
/* 488 */     this._propertiesSavepoint = null;
/* 489 */     if (this._properties != null) {
/* 490 */       Iterator<IDataModel> it = this._properties.iterator();
/* 491 */       while (it.hasNext()) {
/* 492 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 500 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 503 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 506 */     super.commitTransaction();
/*     */     
/* 508 */     this._propertiesSavepoint = this._properties;
/* 509 */     if (this._properties != null) {
/* 510 */       Iterator<IDataModel> it = this._properties.iterator();
/* 511 */       while (it.hasNext()) {
/* 512 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 514 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 518 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 523 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerAffiliationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */