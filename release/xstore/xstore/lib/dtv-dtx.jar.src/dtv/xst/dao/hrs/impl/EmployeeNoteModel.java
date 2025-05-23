/*     */ package dtv.xst.dao.hrs.impl;
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
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.hrs.EmployeeNotePropertyId;
/*     */ import dtv.xst.dao.hrs.IEmployeeNote;
/*     */ import dtv.xst.dao.hrs.IEmployeeNoteProperty;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EmployeeNoteModel extends AbstractDataModelWithPropertyImpl<IEmployeeNoteProperty> implements IEmployeeNote {
/*     */   private static final long serialVersionUID = -1564190752L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IParty _creatorParty; private transient IParty _creatorPartySavepoint; private HistoricalList<IEmployeeNoteProperty> _properties; private transient HistoricalList<IEmployeeNoteProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new EmployeeNoteDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EmployeeNoteDAO getDAO_() {
/*  47 */     return (EmployeeNoteDAO)this._daoImpl;
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
/*  71 */       this._events.post(IEmployeeNote.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<EmployeeNotePropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((EmployeeNotePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getEmployeeId() {
/* 102 */     return getDAO_().getEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 110 */     if (setEmployeeId_noev(argEmployeeId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IEmployeeNote.SET_EMPLOYEEID, argEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeId_noev(String argEmployeeId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/* 123 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/* 124 */       getDAO_().setEmployeeId(argEmployeeId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<EmployeeNotePropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((EmployeeNotePropertyModel)it.next()).setEmployeeId_noev(argEmployeeId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNoteSequence() {
/* 144 */     if (getDAO_().getNoteSequence() != null) {
/* 145 */       return getDAO_().getNoteSequence().longValue();
/*     */     }
/*     */     
/* 148 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteSequence(long argNoteSequence) {
/* 157 */     if (setNoteSequence_noev(argNoteSequence) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IEmployeeNote.SET_NOTESEQUENCE, Long.valueOf(argNoteSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteSequence_noev(long argNoteSequence) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getNoteSequence() == null && Long.valueOf(argNoteSequence) != null) || (
/* 170 */       getDAO_().getNoteSequence() != null && !getDAO_().getNoteSequence().equals(Long.valueOf(argNoteSequence)))) {
/* 171 */       getDAO_().setNoteSequence(Long.valueOf(argNoteSequence));
/* 172 */       ev_postable = true;
/* 173 */       if (this._properties != null) {
/*     */         
/* 175 */         Iterator<EmployeeNotePropertyModel> it = this._properties.iterator();
/* 176 */         while (it.hasNext())
/*     */         {
/* 178 */           ((EmployeeNotePropertyModel)it.next()).setNoteSequence_noev(argNoteSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 191 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 199 */     if (setCreateDate_noev(argCreateDate) && 
/* 200 */       this._events != null && 
/* 201 */       postEventsForChanges()) {
/* 202 */       this._events.post(IEmployeeNote.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 209 */     boolean ev_postable = false;
/*     */     
/* 211 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 212 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 213 */       getDAO_().setCreateDate(argCreateDate);
/* 214 */       ev_postable = true;
/*     */     } 
/*     */     
/* 217 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 225 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 233 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 234 */       this._events != null && 
/* 235 */       postEventsForChanges()) {
/* 236 */       this._events.post(IEmployeeNote.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 243 */     boolean ev_postable = false;
/*     */     
/* 245 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 246 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 247 */       getDAO_().setCreateUserId(argCreateUserId);
/* 248 */       ev_postable = true;
/*     */     } 
/*     */     
/* 251 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 259 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 267 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 268 */       this._events != null && 
/* 269 */       postEventsForChanges()) {
/* 270 */       this._events.post(IEmployeeNote.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 277 */     boolean ev_postable = false;
/*     */     
/* 279 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 280 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 281 */       getDAO_().setUpdateDate(argUpdateDate);
/* 282 */       ev_postable = true;
/*     */     } 
/*     */     
/* 285 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 293 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 301 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 302 */       this._events != null && 
/* 303 */       postEventsForChanges()) {
/* 304 */       this._events.post(IEmployeeNote.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 311 */     boolean ev_postable = false;
/*     */     
/* 313 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 314 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 315 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 316 */       ev_postable = true;
/*     */     } 
/*     */     
/* 319 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 327 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 335 */     if (setNote_noev(argNote) && 
/* 336 */       this._events != null && 
/* 337 */       postEventsForChanges()) {
/* 338 */       this._events.post(IEmployeeNote.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 345 */     boolean ev_postable = false;
/*     */     
/* 347 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 348 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 349 */       getDAO_().setNote(argNote);
/* 350 */       ev_postable = true;
/*     */     } 
/*     */     
/* 353 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getNoteTimeStamp() {
/* 361 */     return getDAO_().getNoteTimeStamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteTimeStamp(Date argNoteTimeStamp) {
/* 369 */     if (setNoteTimeStamp_noev(argNoteTimeStamp) && 
/* 370 */       this._events != null && 
/* 371 */       postEventsForChanges()) {
/* 372 */       this._events.post(IEmployeeNote.SET_NOTETIMESTAMP, argNoteTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteTimeStamp_noev(Date argNoteTimeStamp) {
/* 379 */     boolean ev_postable = false;
/*     */     
/* 381 */     if ((getDAO_().getNoteTimeStamp() == null && argNoteTimeStamp != null) || (
/* 382 */       getDAO_().getNoteTimeStamp() != null && !getDAO_().getNoteTimeStamp().equals(argNoteTimeStamp))) {
/* 383 */       getDAO_().setNoteTimeStamp(argNoteTimeStamp);
/* 384 */       ev_postable = true;
/*     */     } 
/*     */     
/* 387 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCreatorPartyId() {
/* 395 */     if (getDAO_().getCreatorPartyId() != null) {
/* 396 */       return getDAO_().getCreatorPartyId().longValue();
/*     */     }
/*     */     
/* 399 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatorPartyId(long argCreatorPartyId) {
/* 408 */     if (setCreatorPartyId_noev(argCreatorPartyId) && 
/* 409 */       this._events != null && 
/* 410 */       postEventsForChanges()) {
/* 411 */       this._events.post(IEmployeeNote.SET_CREATORPARTYID, Long.valueOf(argCreatorPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreatorPartyId_noev(long argCreatorPartyId) {
/* 418 */     boolean ev_postable = false;
/*     */     
/* 420 */     if ((getDAO_().getCreatorPartyId() == null && Long.valueOf(argCreatorPartyId) != null) || (
/* 421 */       getDAO_().getCreatorPartyId() != null && !getDAO_().getCreatorPartyId().equals(Long.valueOf(argCreatorPartyId)))) {
/* 422 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorPartyId));
/* 423 */       ev_postable = true;
/*     */     } 
/*     */     
/* 426 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEmployeeNoteProperty newProperty(String argPropertyName) {
/* 430 */     EmployeeNotePropertyId id = new EmployeeNotePropertyId();
/*     */     
/* 432 */     id.setEmployeeId(getEmployeeId());
/* 433 */     id.setNoteSequence(Long.valueOf(getNoteSequence()));
/* 434 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 436 */     IEmployeeNoteProperty prop = (IEmployeeNoteProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeNoteProperty.class);
/* 437 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "CreatorParty")
/*     */   public IParty getCreatorParty() {
/* 449 */     return this._creatorParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCreatorParty(IParty argCreatorParty) {
/* 454 */     if (argCreatorParty == null) {
/*     */       
/* 456 */       getDAO_().setCreatorPartyId(null);
/* 457 */       if (this._creatorParty != null)
/*     */       {
/* 459 */         if (postEventsForChanges()) {
/* 460 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._creatorParty));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 465 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorParty.getPartyId()));
/*     */       
/* 467 */       if (postEventsForChanges()) {
/* 468 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCreatorParty));
/*     */       }
/*     */     } 
/*     */     
/* 472 */     this._creatorParty = argCreatorParty;
/* 473 */     if (postEventsForChanges()) {
/* 474 */       this._events.post(IEmployeeNote.SET_CREATORPARTY, argCreatorParty);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEmployeeNoteProperty> getProperties() {
/* 480 */     if (this._properties == null) {
/* 481 */       this._properties = new HistoricalList(null);
/*     */     }
/* 483 */     return (List<IEmployeeNoteProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEmployeeNoteProperty> argProperties) {
/* 487 */     if (this._properties == null) {
/* 488 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 490 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 493 */     for (IEmployeeNoteProperty child : this._properties) {
/* 494 */       EmployeeNotePropertyModel model = (EmployeeNotePropertyModel)child;
/* 495 */       model.setOrganizationId_noev(getOrganizationId());
/* 496 */       model.setEmployeeId_noev(getEmployeeId());
/* 497 */       model.setNoteSequence_noev(getNoteSequence());
/* 498 */       if (child instanceof IDataModelImpl) {
/* 499 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 500 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 501 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 502 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 505 */       if (postEventsForChanges()) {
/* 506 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEmployeeNoteProperty(IEmployeeNoteProperty argEmployeeNoteProperty) {
/* 512 */     if (this._properties == null) {
/* 513 */       this._properties = new HistoricalList(null);
/*     */     }
/* 515 */     argEmployeeNoteProperty.setOrganizationId(getOrganizationId());
/* 516 */     argEmployeeNoteProperty.setEmployeeId(getEmployeeId());
/* 517 */     argEmployeeNoteProperty.setNoteSequence(getNoteSequence());
/* 518 */     if (argEmployeeNoteProperty instanceof IDataModelImpl) {
/* 519 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeNoteProperty).getDAO();
/* 520 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 521 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 522 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 527 */     if (postEventsForChanges()) {
/* 528 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeNoteProperty));
/*     */     }
/*     */     
/* 531 */     this._properties.add(argEmployeeNoteProperty);
/* 532 */     if (postEventsForChanges()) {
/* 533 */       this._events.post(IEmployeeNote.ADD_PROPERTIES, argEmployeeNoteProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEmployeeNoteProperty(IEmployeeNoteProperty argEmployeeNoteProperty) {
/* 538 */     if (this._properties != null) {
/*     */       
/* 540 */       if (postEventsForChanges()) {
/* 541 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeNoteProperty));
/*     */       }
/* 543 */       this._properties.remove(argEmployeeNoteProperty);
/* 544 */       if (postEventsForChanges()) {
/* 545 */         this._events.post(IEmployeeNote.REMOVE_PROPERTIES, argEmployeeNoteProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 552 */     if ("CreatorParty".equals(argFieldId)) {
/* 553 */       return getCreatorParty();
/*     */     }
/* 555 */     if ("Properties".equals(argFieldId)) {
/* 556 */       return getProperties();
/*     */     }
/* 558 */     if ("EmployeeNoteExtension".equals(argFieldId)) {
/* 559 */       return this._myExtension;
/*     */     }
/*     */     
/* 562 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 568 */     if ("CreatorParty".equals(argFieldId)) {
/* 569 */       setCreatorParty((IParty)argValue);
/*     */     }
/* 571 */     else if ("Properties".equals(argFieldId)) {
/* 572 */       setProperties(changeToList(argValue, IEmployeeNoteProperty.class));
/*     */     }
/* 574 */     else if ("EmployeeNoteExtension".equals(argFieldId)) {
/* 575 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 578 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 584 */     this._persistenceDefaults = argPD;
/* 585 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 586 */     this._eventManager = argEM;
/* 587 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 588 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 589 */     if (this._creatorParty != null) {
/* 590 */       ((IDataModelImpl)this._creatorParty).setDependencies(argPD, argEM);
/*     */     }
/* 592 */     if (this._properties != null) {
/* 593 */       for (IEmployeeNoteProperty relationship : this._properties) {
/* 594 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEmployeeNoteExt() {
/* 600 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEmployeeNoteExt(IDataModel argExt) {
/* 604 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 609 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 613 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 616 */     super.startTransaction();
/*     */     
/* 618 */     this._creatorPartySavepoint = this._creatorParty;
/* 619 */     if (this._creatorParty != null) {
/* 620 */       this._creatorParty.startTransaction();
/*     */     }
/*     */     
/* 623 */     this._propertiesSavepoint = this._properties;
/* 624 */     if (this._properties != null) {
/* 625 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 626 */       Iterator<IDataModel> it = this._properties.iterator();
/* 627 */       while (it.hasNext()) {
/* 628 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 633 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 638 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 641 */     super.rollbackChanges();
/*     */     
/* 643 */     this._creatorParty = this._creatorPartySavepoint;
/* 644 */     this._creatorPartySavepoint = null;
/* 645 */     if (this._creatorParty != null) {
/* 646 */       this._creatorParty.rollbackChanges();
/*     */     }
/*     */     
/* 649 */     this._properties = this._propertiesSavepoint;
/* 650 */     this._propertiesSavepoint = null;
/* 651 */     if (this._properties != null) {
/* 652 */       Iterator<IDataModel> it = this._properties.iterator();
/* 653 */       while (it.hasNext()) {
/* 654 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 662 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 665 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 668 */     super.commitTransaction();
/*     */     
/* 670 */     this._creatorPartySavepoint = this._creatorParty;
/* 671 */     if (this._creatorParty != null) {
/* 672 */       this._creatorParty.commitTransaction();
/*     */     }
/*     */     
/* 675 */     this._propertiesSavepoint = this._properties;
/* 676 */     if (this._properties != null) {
/* 677 */       Iterator<IDataModel> it = this._properties.iterator();
/* 678 */       while (it.hasNext()) {
/* 679 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 681 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 685 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 690 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeNoteModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */