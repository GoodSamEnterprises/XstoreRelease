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
/*     */ import dtv.xst.dao.hrs.EmployeeTaskNotePropertyId;
/*     */ import dtv.xst.dao.hrs.IEmployeeTaskNote;
/*     */ import dtv.xst.dao.hrs.IEmployeeTaskNoteProperty;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EmployeeTaskNoteModel extends AbstractDataModelWithPropertyImpl<IEmployeeTaskNoteProperty> implements IEmployeeTaskNote {
/*     */   private static final long serialVersionUID = 9048069L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IParty _creatorParty; private transient IParty _creatorPartySavepoint; private HistoricalList<IEmployeeTaskNoteProperty> _properties; private transient HistoricalList<IEmployeeTaskNoteProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new EmployeeTaskNoteDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EmployeeTaskNoteDAO getDAO_() {
/*  47 */     return (EmployeeTaskNoteDAO)this._daoImpl;
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
/*  71 */       this._events.post(IEmployeeTaskNote.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<EmployeeTaskNotePropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((EmployeeTaskNotePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 118 */       this._events.post(IEmployeeTaskNote.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 133 */         Iterator<EmployeeTaskNotePropertyModel> it = this._properties.iterator();
/* 134 */         while (it.hasNext())
/*     */         {
/* 136 */           ((EmployeeTaskNotePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public long getTaskId() {
/* 149 */     if (getDAO_().getTaskId() != null) {
/* 150 */       return getDAO_().getTaskId().longValue();
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
/*     */   public void setTaskId(long argTaskId) {
/* 162 */     if (setTaskId_noev(argTaskId) && 
/* 163 */       this._events != null && 
/* 164 */       postEventsForChanges()) {
/* 165 */       this._events.post(IEmployeeTaskNote.SET_TASKID, Long.valueOf(argTaskId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaskId_noev(long argTaskId) {
/* 172 */     boolean ev_postable = false;
/*     */     
/* 174 */     if ((getDAO_().getTaskId() == null && Long.valueOf(argTaskId) != null) || (
/* 175 */       getDAO_().getTaskId() != null && !getDAO_().getTaskId().equals(Long.valueOf(argTaskId)))) {
/* 176 */       getDAO_().setTaskId(Long.valueOf(argTaskId));
/* 177 */       ev_postable = true;
/* 178 */       if (this._properties != null) {
/*     */         
/* 180 */         Iterator<EmployeeTaskNotePropertyModel> it = this._properties.iterator();
/* 181 */         while (it.hasNext())
/*     */         {
/* 183 */           ((EmployeeTaskNotePropertyModel)it.next()).setTaskId_noev(argTaskId);
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
/*     */   public long getNoteSequence() {
/* 196 */     if (getDAO_().getNoteSequence() != null) {
/* 197 */       return getDAO_().getNoteSequence().longValue();
/*     */     }
/*     */     
/* 200 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteSequence(long argNoteSequence) {
/* 209 */     if (setNoteSequence_noev(argNoteSequence) && 
/* 210 */       this._events != null && 
/* 211 */       postEventsForChanges()) {
/* 212 */       this._events.post(IEmployeeTaskNote.SET_NOTESEQUENCE, Long.valueOf(argNoteSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteSequence_noev(long argNoteSequence) {
/* 219 */     boolean ev_postable = false;
/*     */     
/* 221 */     if ((getDAO_().getNoteSequence() == null && Long.valueOf(argNoteSequence) != null) || (
/* 222 */       getDAO_().getNoteSequence() != null && !getDAO_().getNoteSequence().equals(Long.valueOf(argNoteSequence)))) {
/* 223 */       getDAO_().setNoteSequence(Long.valueOf(argNoteSequence));
/* 224 */       ev_postable = true;
/* 225 */       if (this._properties != null) {
/*     */         
/* 227 */         Iterator<EmployeeTaskNotePropertyModel> it = this._properties.iterator();
/* 228 */         while (it.hasNext())
/*     */         {
/* 230 */           ((EmployeeTaskNotePropertyModel)it.next()).setNoteSequence_noev(argNoteSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 235 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 243 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 251 */     if (setCreateDate_noev(argCreateDate) && 
/* 252 */       this._events != null && 
/* 253 */       postEventsForChanges()) {
/* 254 */       this._events.post(IEmployeeTaskNote.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 261 */     boolean ev_postable = false;
/*     */     
/* 263 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 264 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 265 */       getDAO_().setCreateDate(argCreateDate);
/* 266 */       ev_postable = true;
/*     */     } 
/*     */     
/* 269 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 277 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 285 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 286 */       this._events != null && 
/* 287 */       postEventsForChanges()) {
/* 288 */       this._events.post(IEmployeeTaskNote.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 295 */     boolean ev_postable = false;
/*     */     
/* 297 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 298 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 299 */       getDAO_().setCreateUserId(argCreateUserId);
/* 300 */       ev_postable = true;
/*     */     } 
/*     */     
/* 303 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 311 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 319 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 320 */       this._events != null && 
/* 321 */       postEventsForChanges()) {
/* 322 */       this._events.post(IEmployeeTaskNote.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 329 */     boolean ev_postable = false;
/*     */     
/* 331 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 332 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 333 */       getDAO_().setUpdateDate(argUpdateDate);
/* 334 */       ev_postable = true;
/*     */     } 
/*     */     
/* 337 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 345 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 353 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 354 */       this._events != null && 
/* 355 */       postEventsForChanges()) {
/* 356 */       this._events.post(IEmployeeTaskNote.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 363 */     boolean ev_postable = false;
/*     */     
/* 365 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 366 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 367 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 368 */       ev_postable = true;
/*     */     } 
/*     */     
/* 371 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 379 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 387 */     if (setNote_noev(argNote) && 
/* 388 */       this._events != null && 
/* 389 */       postEventsForChanges()) {
/* 390 */       this._events.post(IEmployeeTaskNote.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 397 */     boolean ev_postable = false;
/*     */     
/* 399 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 400 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 401 */       getDAO_().setNote(argNote);
/* 402 */       ev_postable = true;
/*     */     } 
/*     */     
/* 405 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getNoteTimeStamp() {
/* 413 */     return getDAO_().getNoteTimeStamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteTimeStamp(Date argNoteTimeStamp) {
/* 421 */     if (setNoteTimeStamp_noev(argNoteTimeStamp) && 
/* 422 */       this._events != null && 
/* 423 */       postEventsForChanges()) {
/* 424 */       this._events.post(IEmployeeTaskNote.SET_NOTETIMESTAMP, argNoteTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteTimeStamp_noev(Date argNoteTimeStamp) {
/* 431 */     boolean ev_postable = false;
/*     */     
/* 433 */     if ((getDAO_().getNoteTimeStamp() == null && argNoteTimeStamp != null) || (
/* 434 */       getDAO_().getNoteTimeStamp() != null && !getDAO_().getNoteTimeStamp().equals(argNoteTimeStamp))) {
/* 435 */       getDAO_().setNoteTimeStamp(argNoteTimeStamp);
/* 436 */       ev_postable = true;
/*     */     } 
/*     */     
/* 439 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCreatorPartyId() {
/* 447 */     if (getDAO_().getCreatorPartyId() != null) {
/* 448 */       return getDAO_().getCreatorPartyId().longValue();
/*     */     }
/*     */     
/* 451 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatorPartyId(long argCreatorPartyId) {
/* 460 */     if (setCreatorPartyId_noev(argCreatorPartyId) && 
/* 461 */       this._events != null && 
/* 462 */       postEventsForChanges()) {
/* 463 */       this._events.post(IEmployeeTaskNote.SET_CREATORPARTYID, Long.valueOf(argCreatorPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreatorPartyId_noev(long argCreatorPartyId) {
/* 470 */     boolean ev_postable = false;
/*     */     
/* 472 */     if ((getDAO_().getCreatorPartyId() == null && Long.valueOf(argCreatorPartyId) != null) || (
/* 473 */       getDAO_().getCreatorPartyId() != null && !getDAO_().getCreatorPartyId().equals(Long.valueOf(argCreatorPartyId)))) {
/* 474 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorPartyId));
/* 475 */       ev_postable = true;
/*     */     } 
/*     */     
/* 478 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEmployeeTaskNoteProperty newProperty(String argPropertyName) {
/* 482 */     EmployeeTaskNotePropertyId id = new EmployeeTaskNotePropertyId();
/*     */     
/* 484 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 485 */     id.setTaskId(Long.valueOf(getTaskId()));
/* 486 */     id.setNoteSequence(Long.valueOf(getNoteSequence()));
/* 487 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 489 */     IEmployeeTaskNoteProperty prop = (IEmployeeTaskNoteProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeTaskNoteProperty.class);
/* 490 */     return prop;
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
/* 502 */     return this._creatorParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCreatorParty(IParty argCreatorParty) {
/* 507 */     if (argCreatorParty == null) {
/*     */       
/* 509 */       getDAO_().setCreatorPartyId(null);
/* 510 */       if (this._creatorParty != null)
/*     */       {
/* 512 */         if (postEventsForChanges()) {
/* 513 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._creatorParty));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 518 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorParty.getPartyId()));
/*     */       
/* 520 */       if (postEventsForChanges()) {
/* 521 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCreatorParty));
/*     */       }
/*     */     } 
/*     */     
/* 525 */     this._creatorParty = argCreatorParty;
/* 526 */     if (postEventsForChanges()) {
/* 527 */       this._events.post(IEmployeeTaskNote.SET_CREATORPARTY, argCreatorParty);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEmployeeTaskNoteProperty> getProperties() {
/* 533 */     if (this._properties == null) {
/* 534 */       this._properties = new HistoricalList(null);
/*     */     }
/* 536 */     return (List<IEmployeeTaskNoteProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEmployeeTaskNoteProperty> argProperties) {
/* 540 */     if (this._properties == null) {
/* 541 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 543 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 546 */     for (IEmployeeTaskNoteProperty child : this._properties) {
/* 547 */       EmployeeTaskNotePropertyModel model = (EmployeeTaskNotePropertyModel)child;
/* 548 */       model.setOrganizationId_noev(getOrganizationId());
/* 549 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 550 */       model.setTaskId_noev(getTaskId());
/* 551 */       model.setNoteSequence_noev(getNoteSequence());
/* 552 */       if (child instanceof IDataModelImpl) {
/* 553 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 554 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 555 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 556 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 559 */       if (postEventsForChanges()) {
/* 560 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEmployeeTaskNoteProperty(IEmployeeTaskNoteProperty argEmployeeTaskNoteProperty) {
/* 566 */     if (this._properties == null) {
/* 567 */       this._properties = new HistoricalList(null);
/*     */     }
/* 569 */     argEmployeeTaskNoteProperty.setOrganizationId(getOrganizationId());
/* 570 */     argEmployeeTaskNoteProperty.setRetailLocationId(getRetailLocationId());
/* 571 */     argEmployeeTaskNoteProperty.setTaskId(getTaskId());
/* 572 */     argEmployeeTaskNoteProperty.setNoteSequence(getNoteSequence());
/* 573 */     if (argEmployeeTaskNoteProperty instanceof IDataModelImpl) {
/* 574 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeTaskNoteProperty).getDAO();
/* 575 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 576 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 577 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 582 */     if (postEventsForChanges()) {
/* 583 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTaskNoteProperty));
/*     */     }
/*     */     
/* 586 */     this._properties.add(argEmployeeTaskNoteProperty);
/* 587 */     if (postEventsForChanges()) {
/* 588 */       this._events.post(IEmployeeTaskNote.ADD_PROPERTIES, argEmployeeTaskNoteProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEmployeeTaskNoteProperty(IEmployeeTaskNoteProperty argEmployeeTaskNoteProperty) {
/* 593 */     if (this._properties != null) {
/*     */       
/* 595 */       if (postEventsForChanges()) {
/* 596 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTaskNoteProperty));
/*     */       }
/* 598 */       this._properties.remove(argEmployeeTaskNoteProperty);
/* 599 */       if (postEventsForChanges()) {
/* 600 */         this._events.post(IEmployeeTaskNote.REMOVE_PROPERTIES, argEmployeeTaskNoteProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 607 */     if ("CreatorParty".equals(argFieldId)) {
/* 608 */       return getCreatorParty();
/*     */     }
/* 610 */     if ("Properties".equals(argFieldId)) {
/* 611 */       return getProperties();
/*     */     }
/* 613 */     if ("EmployeeTaskNoteExtension".equals(argFieldId)) {
/* 614 */       return this._myExtension;
/*     */     }
/*     */     
/* 617 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 623 */     if ("CreatorParty".equals(argFieldId)) {
/* 624 */       setCreatorParty((IParty)argValue);
/*     */     }
/* 626 */     else if ("Properties".equals(argFieldId)) {
/* 627 */       setProperties(changeToList(argValue, IEmployeeTaskNoteProperty.class));
/*     */     }
/* 629 */     else if ("EmployeeTaskNoteExtension".equals(argFieldId)) {
/* 630 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 633 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 639 */     this._persistenceDefaults = argPD;
/* 640 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 641 */     this._eventManager = argEM;
/* 642 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 643 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 644 */     if (this._creatorParty != null) {
/* 645 */       ((IDataModelImpl)this._creatorParty).setDependencies(argPD, argEM);
/*     */     }
/* 647 */     if (this._properties != null) {
/* 648 */       for (IEmployeeTaskNoteProperty relationship : this._properties) {
/* 649 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEmployeeTaskNoteExt() {
/* 655 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEmployeeTaskNoteExt(IDataModel argExt) {
/* 659 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 664 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 668 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 671 */     super.startTransaction();
/*     */     
/* 673 */     this._creatorPartySavepoint = this._creatorParty;
/* 674 */     if (this._creatorParty != null) {
/* 675 */       this._creatorParty.startTransaction();
/*     */     }
/*     */     
/* 678 */     this._propertiesSavepoint = this._properties;
/* 679 */     if (this._properties != null) {
/* 680 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 681 */       Iterator<IDataModel> it = this._properties.iterator();
/* 682 */       while (it.hasNext()) {
/* 683 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 688 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 693 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 696 */     super.rollbackChanges();
/*     */     
/* 698 */     this._creatorParty = this._creatorPartySavepoint;
/* 699 */     this._creatorPartySavepoint = null;
/* 700 */     if (this._creatorParty != null) {
/* 701 */       this._creatorParty.rollbackChanges();
/*     */     }
/*     */     
/* 704 */     this._properties = this._propertiesSavepoint;
/* 705 */     this._propertiesSavepoint = null;
/* 706 */     if (this._properties != null) {
/* 707 */       Iterator<IDataModel> it = this._properties.iterator();
/* 708 */       while (it.hasNext()) {
/* 709 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 717 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 720 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 723 */     super.commitTransaction();
/*     */     
/* 725 */     this._creatorPartySavepoint = this._creatorParty;
/* 726 */     if (this._creatorParty != null) {
/* 727 */       this._creatorParty.commitTransaction();
/*     */     }
/*     */     
/* 730 */     this._propertiesSavepoint = this._properties;
/* 731 */     if (this._properties != null) {
/* 732 */       Iterator<IDataModel> it = this._properties.iterator();
/* 733 */       while (it.hasNext()) {
/* 734 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 736 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 740 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 745 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskNoteModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */