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
/*     */ import dtv.xst.dao.crm.CustomerNotePropertyId;
/*     */ import dtv.xst.dao.crm.ICustomerNote;
/*     */ import dtv.xst.dao.crm.ICustomerNoteProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerNoteModel extends AbstractDataModelWithPropertyImpl<ICustomerNoteProperty> implements ICustomerNote {
/*     */   private static final long serialVersionUID = 1064491280L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICustomerNoteProperty> _properties; private transient HistoricalList<ICustomerNoteProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CustomerNoteDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerNoteDAO getDAO_() {
/*  46 */     return (CustomerNoteDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICustomerNote.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CustomerNotePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CustomerNotePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(ICustomerNote.SET_PARTYID, Long.valueOf(argPartyId));
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
/* 132 */         Iterator<CustomerNotePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((CustomerNotePropertyModel)it.next()).setPartyId_noev(argPartyId);
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
/*     */   public long getNoteSequence() {
/* 148 */     if (getDAO_().getNoteSequence() != null) {
/* 149 */       return getDAO_().getNoteSequence().longValue();
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
/*     */   public void setNoteSequence(long argNoteSequence) {
/* 161 */     if (setNoteSequence_noev(argNoteSequence) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(ICustomerNote.SET_NOTESEQUENCE, Long.valueOf(argNoteSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteSequence_noev(long argNoteSequence) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getNoteSequence() == null && Long.valueOf(argNoteSequence) != null) || (
/* 174 */       getDAO_().getNoteSequence() != null && !getDAO_().getNoteSequence().equals(Long.valueOf(argNoteSequence)))) {
/* 175 */       getDAO_().setNoteSequence(Long.valueOf(argNoteSequence));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<CustomerNotePropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((CustomerNotePropertyModel)it.next()).setNoteSequence_noev(argNoteSequence);
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
/*     */   public Date getCreateDate() {
/* 195 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 203 */     if (setCreateDate_noev(argCreateDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(ICustomerNote.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 216 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 217 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 229 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 237 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 238 */       this._events != null && 
/* 239 */       postEventsForChanges()) {
/* 240 */       this._events.post(ICustomerNote.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 247 */     boolean ev_postable = false;
/*     */     
/* 249 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 250 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 251 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 263 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 271 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 272 */       this._events != null && 
/* 273 */       postEventsForChanges()) {
/* 274 */       this._events.post(ICustomerNote.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 281 */     boolean ev_postable = false;
/*     */     
/* 283 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 284 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 285 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 297 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 305 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 306 */       this._events != null && 
/* 307 */       postEventsForChanges()) {
/* 308 */       this._events.post(ICustomerNote.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 315 */     boolean ev_postable = false;
/*     */     
/* 317 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 318 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 319 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getCreatorId() {
/* 331 */     return getDAO_().getCreatorId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatorId(String argCreatorId) {
/* 339 */     if (setCreatorId_noev(argCreatorId) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(ICustomerNote.SET_CREATORID, argCreatorId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreatorId_noev(String argCreatorId) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getCreatorId() == null && argCreatorId != null) || (
/* 352 */       getDAO_().getCreatorId() != null && !getDAO_().getCreatorId().equals(argCreatorId))) {
/* 353 */       getDAO_().setCreatorId(argCreatorId);
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
/*     */   public String getNote() {
/* 365 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 373 */     if (setNote_noev(argNote) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(ICustomerNote.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 386 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 387 */       getDAO_().setNote(argNote);
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
/*     */   public Date getNoteTimeStamp() {
/* 399 */     return getDAO_().getNoteTimeStamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteTimeStamp(Date argNoteTimeStamp) {
/* 407 */     if (setNoteTimeStamp_noev(argNoteTimeStamp) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(ICustomerNote.SET_NOTETIMESTAMP, argNoteTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteTimeStamp_noev(Date argNoteTimeStamp) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getNoteTimeStamp() == null && argNoteTimeStamp != null) || (
/* 420 */       getDAO_().getNoteTimeStamp() != null && !getDAO_().getNoteTimeStamp().equals(argNoteTimeStamp))) {
/* 421 */       getDAO_().setNoteTimeStamp(argNoteTimeStamp);
/* 422 */       ev_postable = true;
/*     */     } 
/*     */     
/* 425 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerNoteProperty newProperty(String argPropertyName) {
/* 429 */     CustomerNotePropertyId id = new CustomerNotePropertyId();
/*     */     
/* 431 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 432 */     id.setNoteSequence(Long.valueOf(getNoteSequence()));
/* 433 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 435 */     ICustomerNoteProperty prop = (ICustomerNoteProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerNoteProperty.class);
/* 436 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerNoteProperty> getProperties() {
/* 445 */     if (this._properties == null) {
/* 446 */       this._properties = new HistoricalList(null);
/*     */     }
/* 448 */     return (List<ICustomerNoteProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerNoteProperty> argProperties) {
/* 452 */     if (this._properties == null) {
/* 453 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 455 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 458 */     for (ICustomerNoteProperty child : this._properties) {
/* 459 */       CustomerNotePropertyModel model = (CustomerNotePropertyModel)child;
/* 460 */       model.setOrganizationId_noev(getOrganizationId());
/* 461 */       model.setPartyId_noev(getPartyId());
/* 462 */       model.setNoteSequence_noev(getNoteSequence());
/* 463 */       if (child instanceof IDataModelImpl) {
/* 464 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 465 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 466 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 467 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 470 */       if (postEventsForChanges()) {
/* 471 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerNoteProperty(ICustomerNoteProperty argCustomerNoteProperty) {
/* 477 */     if (this._properties == null) {
/* 478 */       this._properties = new HistoricalList(null);
/*     */     }
/* 480 */     argCustomerNoteProperty.setOrganizationId(getOrganizationId());
/* 481 */     argCustomerNoteProperty.setPartyId(getPartyId());
/* 482 */     argCustomerNoteProperty.setNoteSequence(getNoteSequence());
/* 483 */     if (argCustomerNoteProperty instanceof IDataModelImpl) {
/* 484 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerNoteProperty).getDAO();
/* 485 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 486 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 487 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 492 */     if (postEventsForChanges()) {
/* 493 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerNoteProperty));
/*     */     }
/*     */     
/* 496 */     this._properties.add(argCustomerNoteProperty);
/* 497 */     if (postEventsForChanges()) {
/* 498 */       this._events.post(ICustomerNote.ADD_PROPERTIES, argCustomerNoteProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerNoteProperty(ICustomerNoteProperty argCustomerNoteProperty) {
/* 503 */     if (this._properties != null) {
/*     */       
/* 505 */       if (postEventsForChanges()) {
/* 506 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerNoteProperty));
/*     */       }
/* 508 */       this._properties.remove(argCustomerNoteProperty);
/* 509 */       if (postEventsForChanges()) {
/* 510 */         this._events.post(ICustomerNote.REMOVE_PROPERTIES, argCustomerNoteProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 517 */     if ("Properties".equals(argFieldId)) {
/* 518 */       return getProperties();
/*     */     }
/* 520 */     if ("CustomerNoteExtension".equals(argFieldId)) {
/* 521 */       return this._myExtension;
/*     */     }
/*     */     
/* 524 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 530 */     if ("Properties".equals(argFieldId)) {
/* 531 */       setProperties(changeToList(argValue, ICustomerNoteProperty.class));
/*     */     }
/* 533 */     else if ("CustomerNoteExtension".equals(argFieldId)) {
/* 534 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 537 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 543 */     this._persistenceDefaults = argPD;
/* 544 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 545 */     this._eventManager = argEM;
/* 546 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 547 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 548 */     if (this._properties != null) {
/* 549 */       for (ICustomerNoteProperty relationship : this._properties) {
/* 550 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerNoteExt() {
/* 556 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerNoteExt(IDataModel argExt) {
/* 560 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 565 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 569 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 572 */     super.startTransaction();
/*     */     
/* 574 */     this._propertiesSavepoint = this._properties;
/* 575 */     if (this._properties != null) {
/* 576 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 577 */       Iterator<IDataModel> it = this._properties.iterator();
/* 578 */       while (it.hasNext()) {
/* 579 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 584 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 589 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 592 */     super.rollbackChanges();
/*     */     
/* 594 */     this._properties = this._propertiesSavepoint;
/* 595 */     this._propertiesSavepoint = null;
/* 596 */     if (this._properties != null) {
/* 597 */       Iterator<IDataModel> it = this._properties.iterator();
/* 598 */       while (it.hasNext()) {
/* 599 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 607 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 610 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 613 */     super.commitTransaction();
/*     */     
/* 615 */     this._propertiesSavepoint = this._properties;
/* 616 */     if (this._properties != null) {
/* 617 */       Iterator<IDataModel> it = this._properties.iterator();
/* 618 */       while (it.hasNext()) {
/* 619 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 621 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 625 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 630 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerNoteModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */