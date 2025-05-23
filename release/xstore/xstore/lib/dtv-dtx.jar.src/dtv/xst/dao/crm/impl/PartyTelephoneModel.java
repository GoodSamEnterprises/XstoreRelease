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
/*     */ import dtv.xst.dao.crm.IPartyTelephone;
/*     */ import dtv.xst.dao.crm.IPartyTelephoneProperty;
/*     */ import dtv.xst.dao.crm.PartyTelephonePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PartyTelephoneModel extends AbstractDataModelWithPropertyImpl<IPartyTelephoneProperty> implements IPartyTelephone {
/*     */   private static final long serialVersionUID = -158832674L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPartyTelephoneProperty> _properties; private transient HistoricalList<IPartyTelephoneProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PartyTelephoneDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PartyTelephoneDAO getDAO_() {
/*  46 */     return (PartyTelephoneDAO)this._daoImpl;
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
/*  70 */       this._events.post(IPartyTelephone.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<PartyTelephonePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PartyTelephonePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IPartyTelephone.SET_PARTYID, Long.valueOf(argPartyId));
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
/* 132 */         Iterator<PartyTelephonePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((PartyTelephonePropertyModel)it.next()).setPartyId_noev(argPartyId);
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
/*     */   public String getTelephoneType() {
/* 148 */     return getDAO_().getTelephoneType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephoneType(String argTelephoneType) {
/* 156 */     if (setTelephoneType_noev(argTelephoneType) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IPartyTelephone.SET_TELEPHONETYPE, argTelephoneType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTelephoneType_noev(String argTelephoneType) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getTelephoneType() == null && argTelephoneType != null) || (
/* 169 */       getDAO_().getTelephoneType() != null && !getDAO_().getTelephoneType().equals(argTelephoneType))) {
/* 170 */       getDAO_().setTelephoneType(argTelephoneType);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<PartyTelephonePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((PartyTelephonePropertyModel)it.next()).setTelephoneType_noev(argTelephoneType);
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
/* 201 */       this._events.post(IPartyTelephone.SET_CREATEDATE, argCreateDate);
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
/* 235 */       this._events.post(IPartyTelephone.SET_CREATEUSERID, argCreateUserId);
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
/* 269 */       this._events.post(IPartyTelephone.SET_UPDATEDATE, argUpdateDate);
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
/* 303 */       this._events.post(IPartyTelephone.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getContactType() {
/* 326 */     return getDAO_().getContactType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContactType(String argContactType) {
/* 334 */     if (setContactType_noev(argContactType) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IPartyTelephone.SET_CONTACTTYPE, argContactType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setContactType_noev(String argContactType) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getContactType() == null && argContactType != null) || (
/* 347 */       getDAO_().getContactType() != null && !getDAO_().getContactType().equals(argContactType))) {
/* 348 */       getDAO_().setContactType(argContactType);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getContact() {
/* 360 */     if (getDAO_().getContact() != null) {
/* 361 */       return getDAO_().getContact().booleanValue();
/*     */     }
/*     */     
/* 364 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContact(boolean argContact) {
/* 373 */     if (setContact_noev(argContact) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(IPartyTelephone.SET_CONTACT, Boolean.valueOf(argContact));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setContact_noev(boolean argContact) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getContact() == null && Boolean.valueOf(argContact) != null) || (
/* 386 */       getDAO_().getContact() != null && !getDAO_().getContact().equals(Boolean.valueOf(argContact)))) {
/* 387 */       getDAO_().setContact(Boolean.valueOf(argContact));
/* 388 */       ev_postable = true;
/*     */     } 
/*     */     
/* 391 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPrimary() {
/* 399 */     if (getDAO_().getPrimary() != null) {
/* 400 */       return getDAO_().getPrimary().booleanValue();
/*     */     }
/*     */     
/* 403 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimary(boolean argPrimary) {
/* 412 */     if (setPrimary_noev(argPrimary) && 
/* 413 */       this._events != null && 
/* 414 */       postEventsForChanges()) {
/* 415 */       this._events.post(IPartyTelephone.SET_PRIMARY, Boolean.valueOf(argPrimary));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrimary_noev(boolean argPrimary) {
/* 422 */     boolean ev_postable = false;
/*     */     
/* 424 */     if ((getDAO_().getPrimary() == null && Boolean.valueOf(argPrimary) != null) || (
/* 425 */       getDAO_().getPrimary() != null && !getDAO_().getPrimary().equals(Boolean.valueOf(argPrimary)))) {
/* 426 */       getDAO_().setPrimary(Boolean.valueOf(argPrimary));
/* 427 */       ev_postable = true;
/*     */     } 
/*     */     
/* 430 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephoneNumber() {
/* 438 */     return getDAO_().getTelephoneNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephoneNumber(String argTelephoneNumber) {
/* 446 */     if (setTelephoneNumber_noev(argTelephoneNumber) && 
/* 447 */       this._events != null && 
/* 448 */       postEventsForChanges()) {
/* 449 */       this._events.post(IPartyTelephone.SET_TELEPHONENUMBER, argTelephoneNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTelephoneNumber_noev(String argTelephoneNumber) {
/* 456 */     boolean ev_postable = false;
/*     */     
/* 458 */     if ((getDAO_().getTelephoneNumber() == null && argTelephoneNumber != null) || (
/* 459 */       getDAO_().getTelephoneNumber() != null && !getDAO_().getTelephoneNumber().equals(argTelephoneNumber))) {
/* 460 */       getDAO_().setTelephoneNumber(argTelephoneNumber);
/* 461 */       ev_postable = true;
/*     */     } 
/*     */     
/* 464 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPartyTelephoneProperty newProperty(String argPropertyName) {
/* 468 */     PartyTelephonePropertyId id = new PartyTelephonePropertyId();
/*     */     
/* 470 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 471 */     id.setTelephoneType(getTelephoneType());
/* 472 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 474 */     IPartyTelephoneProperty prop = (IPartyTelephoneProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPartyTelephoneProperty.class);
/* 475 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPartyTelephoneProperty> getProperties() {
/* 484 */     if (this._properties == null) {
/* 485 */       this._properties = new HistoricalList(null);
/*     */     }
/* 487 */     return (List<IPartyTelephoneProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPartyTelephoneProperty> argProperties) {
/* 491 */     if (this._properties == null) {
/* 492 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 494 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 497 */     for (IPartyTelephoneProperty child : this._properties) {
/* 498 */       PartyTelephonePropertyModel model = (PartyTelephonePropertyModel)child;
/* 499 */       model.setOrganizationId_noev(getOrganizationId());
/* 500 */       model.setPartyId_noev(getPartyId());
/* 501 */       model.setTelephoneType_noev(getTelephoneType());
/* 502 */       if (child instanceof IDataModelImpl) {
/* 503 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 504 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 505 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 506 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 509 */       if (postEventsForChanges()) {
/* 510 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPartyTelephoneProperty(IPartyTelephoneProperty argPartyTelephoneProperty) {
/* 516 */     if (this._properties == null) {
/* 517 */       this._properties = new HistoricalList(null);
/*     */     }
/* 519 */     argPartyTelephoneProperty.setOrganizationId(getOrganizationId());
/* 520 */     argPartyTelephoneProperty.setPartyId(getPartyId());
/* 521 */     argPartyTelephoneProperty.setTelephoneType(getTelephoneType());
/* 522 */     if (argPartyTelephoneProperty instanceof IDataModelImpl) {
/* 523 */       IDataAccessObject childDao = ((IDataModelImpl)argPartyTelephoneProperty).getDAO();
/* 524 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 525 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 526 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 531 */     if (postEventsForChanges()) {
/* 532 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyTelephoneProperty));
/*     */     }
/*     */     
/* 535 */     this._properties.add(argPartyTelephoneProperty);
/* 536 */     if (postEventsForChanges()) {
/* 537 */       this._events.post(IPartyTelephone.ADD_PROPERTIES, argPartyTelephoneProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePartyTelephoneProperty(IPartyTelephoneProperty argPartyTelephoneProperty) {
/* 542 */     if (this._properties != null) {
/*     */       
/* 544 */       if (postEventsForChanges()) {
/* 545 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPartyTelephoneProperty));
/*     */       }
/* 547 */       this._properties.remove(argPartyTelephoneProperty);
/* 548 */       if (postEventsForChanges()) {
/* 549 */         this._events.post(IPartyTelephone.REMOVE_PROPERTIES, argPartyTelephoneProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 556 */     if ("Properties".equals(argFieldId)) {
/* 557 */       return getProperties();
/*     */     }
/* 559 */     if ("PartyTelephoneExtension".equals(argFieldId)) {
/* 560 */       return this._myExtension;
/*     */     }
/*     */     
/* 563 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 569 */     if ("Properties".equals(argFieldId)) {
/* 570 */       setProperties(changeToList(argValue, IPartyTelephoneProperty.class));
/*     */     }
/* 572 */     else if ("PartyTelephoneExtension".equals(argFieldId)) {
/* 573 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 576 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 582 */     this._persistenceDefaults = argPD;
/* 583 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 584 */     this._eventManager = argEM;
/* 585 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 586 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 587 */     if (this._properties != null) {
/* 588 */       for (IPartyTelephoneProperty relationship : this._properties) {
/* 589 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPartyTelephoneExt() {
/* 595 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPartyTelephoneExt(IDataModel argExt) {
/* 599 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 604 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 608 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 611 */     super.startTransaction();
/*     */     
/* 613 */     this._propertiesSavepoint = this._properties;
/* 614 */     if (this._properties != null) {
/* 615 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 616 */       Iterator<IDataModel> it = this._properties.iterator();
/* 617 */       while (it.hasNext()) {
/* 618 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 623 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 628 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 631 */     super.rollbackChanges();
/*     */     
/* 633 */     this._properties = this._propertiesSavepoint;
/* 634 */     this._propertiesSavepoint = null;
/* 635 */     if (this._properties != null) {
/* 636 */       Iterator<IDataModel> it = this._properties.iterator();
/* 637 */       while (it.hasNext()) {
/* 638 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 646 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 649 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 652 */     super.commitTransaction();
/*     */     
/* 654 */     this._propertiesSavepoint = this._properties;
/* 655 */     if (this._properties != null) {
/* 656 */       Iterator<IDataModel> it = this._properties.iterator();
/* 657 */       while (it.hasNext()) {
/* 658 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 660 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 664 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 669 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyTelephoneModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */