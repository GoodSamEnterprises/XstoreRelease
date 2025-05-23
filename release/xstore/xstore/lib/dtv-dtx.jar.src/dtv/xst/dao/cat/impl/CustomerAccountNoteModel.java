/*     */ package dtv.xst.dao.cat.impl;
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
/*     */ import dtv.xst.dao.cat.CustomerAccountNotePropertyId;
/*     */ import dtv.xst.dao.cat.ICustomerAccountNote;
/*     */ import dtv.xst.dao.cat.ICustomerAccountNoteProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerAccountNoteModel extends AbstractDataModelWithPropertyImpl<ICustomerAccountNoteProperty> implements ICustomerAccountNote {
/*     */   private static final long serialVersionUID = 1544669409L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICustomerAccountNoteProperty> _properties; private transient HistoricalList<ICustomerAccountNoteProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CustomerAccountNoteDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerAccountNoteDAO getDAO_() {
/*  46 */     return (CustomerAccountNoteDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNoteSequence() {
/*  54 */     if (getDAO_().getNoteSequence() != null) {
/*  55 */       return getDAO_().getNoteSequence().longValue();
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
/*     */   public void setNoteSequence(long argNoteSequence) {
/*  67 */     if (setNoteSequence_noev(argNoteSequence) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(ICustomerAccountNote.SET_NOTESEQUENCE, Long.valueOf(argNoteSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteSequence_noev(long argNoteSequence) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getNoteSequence() == null && Long.valueOf(argNoteSequence) != null) || (
/*  80 */       getDAO_().getNoteSequence() != null && !getDAO_().getNoteSequence().equals(Long.valueOf(argNoteSequence)))) {
/*  81 */       getDAO_().setNoteSequence(Long.valueOf(argNoteSequence));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<CustomerAccountNotePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CustomerAccountNotePropertyModel)it.next()).setNoteSequence_noev(argNoteSequence);
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
/* 117 */       this._events.post(ICustomerAccountNote.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 132 */         Iterator<CustomerAccountNotePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((CustomerAccountNotePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCustAccountId() {
/* 148 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 156 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ICustomerAccountNote.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 169 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 170 */       getDAO_().setCustAccountId(argCustAccountId);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<CustomerAccountNotePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((CustomerAccountNotePropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
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
/*     */   public String getCustAccountCode() {
/* 190 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 198 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(ICustomerAccountNote.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 211 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 212 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<CustomerAccountNotePropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((CustomerAccountNotePropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 232 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 240 */     if (setCreateDate_noev(argCreateDate) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(ICustomerAccountNote.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 253 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 254 */       getDAO_().setCreateDate(argCreateDate);
/* 255 */       ev_postable = true;
/*     */     } 
/*     */     
/* 258 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 266 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 274 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(ICustomerAccountNote.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 287 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 288 */       getDAO_().setCreateUserId(argCreateUserId);
/* 289 */       ev_postable = true;
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 300 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 308 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(ICustomerAccountNote.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 321 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 322 */       getDAO_().setUpdateDate(argUpdateDate);
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 334 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 342 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(ICustomerAccountNote.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 355 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 356 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 357 */       ev_postable = true;
/*     */     } 
/*     */     
/* 360 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEntryTimestamp() {
/* 368 */     return getDAO_().getEntryTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryTimestamp(Date argEntryTimestamp) {
/* 376 */     if (setEntryTimestamp_noev(argEntryTimestamp) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(ICustomerAccountNote.SET_ENTRYTIMESTAMP, argEntryTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryTimestamp_noev(Date argEntryTimestamp) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getEntryTimestamp() == null && argEntryTimestamp != null) || (
/* 389 */       getDAO_().getEntryTimestamp() != null && !getDAO_().getEntryTimestamp().equals(argEntryTimestamp))) {
/* 390 */       getDAO_().setEntryTimestamp(argEntryTimestamp);
/* 391 */       ev_postable = true;
/*     */     } 
/*     */     
/* 394 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getEntryPartyId() {
/* 402 */     if (getDAO_().getEntryPartyId() != null) {
/* 403 */       return getDAO_().getEntryPartyId().longValue();
/*     */     }
/*     */     
/* 406 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryPartyId(long argEntryPartyId) {
/* 415 */     if (setEntryPartyId_noev(argEntryPartyId) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(ICustomerAccountNote.SET_ENTRYPARTYID, Long.valueOf(argEntryPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryPartyId_noev(long argEntryPartyId) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getEntryPartyId() == null && Long.valueOf(argEntryPartyId) != null) || (
/* 428 */       getDAO_().getEntryPartyId() != null && !getDAO_().getEntryPartyId().equals(Long.valueOf(argEntryPartyId)))) {
/* 429 */       getDAO_().setEntryPartyId(Long.valueOf(argEntryPartyId));
/* 430 */       ev_postable = true;
/*     */     } 
/*     */     
/* 433 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 441 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 449 */     if (setNote_noev(argNote) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(ICustomerAccountNote.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 462 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 463 */       getDAO_().setNote(argNote);
/* 464 */       ev_postable = true;
/*     */     } 
/*     */     
/* 467 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerAccountNoteProperty newProperty(String argPropertyName) {
/* 471 */     CustomerAccountNotePropertyId id = new CustomerAccountNotePropertyId();
/*     */     
/* 473 */     id.setNoteSequence(Long.valueOf(getNoteSequence()));
/* 474 */     id.setCustAccountId(getCustAccountId());
/* 475 */     id.setCustAccountCode(getCustAccountCode());
/* 476 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 478 */     ICustomerAccountNoteProperty prop = (ICustomerAccountNoteProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerAccountNoteProperty.class);
/* 479 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerAccountNoteProperty> getProperties() {
/* 488 */     if (this._properties == null) {
/* 489 */       this._properties = new HistoricalList(null);
/*     */     }
/* 491 */     return (List<ICustomerAccountNoteProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerAccountNoteProperty> argProperties) {
/* 495 */     if (this._properties == null) {
/* 496 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 498 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 501 */     for (ICustomerAccountNoteProperty child : this._properties) {
/* 502 */       CustomerAccountNotePropertyModel model = (CustomerAccountNotePropertyModel)child;
/* 503 */       model.setNoteSequence_noev(getNoteSequence());
/* 504 */       model.setOrganizationId_noev(getOrganizationId());
/* 505 */       model.setCustAccountId_noev(getCustAccountId());
/* 506 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 507 */       if (child instanceof IDataModelImpl) {
/* 508 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 509 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 510 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 511 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 514 */       if (postEventsForChanges()) {
/* 515 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerAccountNoteProperty(ICustomerAccountNoteProperty argCustomerAccountNoteProperty) {
/* 521 */     if (this._properties == null) {
/* 522 */       this._properties = new HistoricalList(null);
/*     */     }
/* 524 */     argCustomerAccountNoteProperty.setNoteSequence(getNoteSequence());
/* 525 */     argCustomerAccountNoteProperty.setOrganizationId(getOrganizationId());
/* 526 */     argCustomerAccountNoteProperty.setCustAccountId(getCustAccountId());
/* 527 */     argCustomerAccountNoteProperty.setCustAccountCode(getCustAccountCode());
/* 528 */     if (argCustomerAccountNoteProperty instanceof IDataModelImpl) {
/* 529 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAccountNoteProperty).getDAO();
/* 530 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 531 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 532 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 537 */     if (postEventsForChanges()) {
/* 538 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountNoteProperty));
/*     */     }
/*     */     
/* 541 */     this._properties.add(argCustomerAccountNoteProperty);
/* 542 */     if (postEventsForChanges()) {
/* 543 */       this._events.post(ICustomerAccountNote.ADD_PROPERTIES, argCustomerAccountNoteProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerAccountNoteProperty(ICustomerAccountNoteProperty argCustomerAccountNoteProperty) {
/* 548 */     if (this._properties != null) {
/*     */       
/* 550 */       if (postEventsForChanges()) {
/* 551 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountNoteProperty));
/*     */       }
/* 553 */       this._properties.remove(argCustomerAccountNoteProperty);
/* 554 */       if (postEventsForChanges()) {
/* 555 */         this._events.post(ICustomerAccountNote.REMOVE_PROPERTIES, argCustomerAccountNoteProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 562 */     if ("Properties".equals(argFieldId)) {
/* 563 */       return getProperties();
/*     */     }
/* 565 */     if ("CustomerAccountNoteExtension".equals(argFieldId)) {
/* 566 */       return this._myExtension;
/*     */     }
/*     */     
/* 569 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 575 */     if ("Properties".equals(argFieldId)) {
/* 576 */       setProperties(changeToList(argValue, ICustomerAccountNoteProperty.class));
/*     */     }
/* 578 */     else if ("CustomerAccountNoteExtension".equals(argFieldId)) {
/* 579 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 582 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 588 */     this._persistenceDefaults = argPD;
/* 589 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 590 */     this._eventManager = argEM;
/* 591 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 592 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 593 */     if (this._properties != null) {
/* 594 */       for (ICustomerAccountNoteProperty relationship : this._properties) {
/* 595 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerAccountNoteExt() {
/* 601 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerAccountNoteExt(IDataModel argExt) {
/* 605 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 610 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 614 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 617 */     super.startTransaction();
/*     */     
/* 619 */     this._propertiesSavepoint = this._properties;
/* 620 */     if (this._properties != null) {
/* 621 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 622 */       Iterator<IDataModel> it = this._properties.iterator();
/* 623 */       while (it.hasNext()) {
/* 624 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 629 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 634 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 637 */     super.rollbackChanges();
/*     */     
/* 639 */     this._properties = this._propertiesSavepoint;
/* 640 */     this._propertiesSavepoint = null;
/* 641 */     if (this._properties != null) {
/* 642 */       Iterator<IDataModel> it = this._properties.iterator();
/* 643 */       while (it.hasNext()) {
/* 644 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 652 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 655 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 658 */     super.commitTransaction();
/*     */     
/* 660 */     this._propertiesSavepoint = this._properties;
/* 661 */     if (this._properties != null) {
/* 662 */       Iterator<IDataModel> it = this._properties.iterator();
/* 663 */       while (it.hasNext()) {
/* 664 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 666 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 670 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 675 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountNoteModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */