/*     */ package dtv.xst.dao.thr.impl;
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
/*     */ import dtv.xst.dao.thr.IPayrollNotes;
/*     */ import dtv.xst.dao.thr.IPayrollNotesProperty;
/*     */ import dtv.xst.dao.thr.PayrollNotesPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PayrollNotesModel extends AbstractDataModelWithPropertyImpl<IPayrollNotesProperty> implements IPayrollNotes {
/*     */   private static final long serialVersionUID = 1743357116L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPayrollNotesProperty> _properties; private transient HistoricalList<IPayrollNotesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PayrollNotesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PayrollNotesDAO getDAO_() {
/*  46 */     return (PayrollNotesDAO)this._daoImpl;
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
/*  70 */       this._events.post(IPayrollNotes.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<PayrollNotesPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PayrollNotesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IPayrollNotes.SET_PARTYID, Long.valueOf(argPartyId));
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
/* 132 */         Iterator<PayrollNotesPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((PayrollNotesPropertyModel)it.next()).setPartyId_noev(argPartyId);
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
/*     */   public Date getWeekEndingDate() {
/* 148 */     return getDAO_().getWeekEndingDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/* 156 */     if (setWeekEndingDate_noev(argWeekEndingDate) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IPayrollNotes.SET_WEEKENDINGDATE, argWeekEndingDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWeekEndingDate_noev(Date argWeekEndingDate) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getWeekEndingDate() == null && argWeekEndingDate != null) || (
/* 169 */       getDAO_().getWeekEndingDate() != null && !getDAO_().getWeekEndingDate().equals(argWeekEndingDate))) {
/* 170 */       getDAO_().setWeekEndingDate(argWeekEndingDate);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<PayrollNotesPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((PayrollNotesPropertyModel)it.next()).setWeekEndingDate_noev(argWeekEndingDate);
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
/*     */   public long getNoteSeq() {
/* 190 */     if (getDAO_().getNoteSeq() != null) {
/* 191 */       return getDAO_().getNoteSeq().longValue();
/*     */     }
/*     */     
/* 194 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteSeq(long argNoteSeq) {
/* 203 */     if (setNoteSeq_noev(argNoteSeq) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IPayrollNotes.SET_NOTESEQ, Long.valueOf(argNoteSeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteSeq_noev(long argNoteSeq) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getNoteSeq() == null && Long.valueOf(argNoteSeq) != null) || (
/* 216 */       getDAO_().getNoteSeq() != null && !getDAO_().getNoteSeq().equals(Long.valueOf(argNoteSeq)))) {
/* 217 */       getDAO_().setNoteSeq(Long.valueOf(argNoteSeq));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<PayrollNotesPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((PayrollNotesPropertyModel)it.next()).setNoteSeq_noev(argNoteSeq);
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
/* 248 */       this._events.post(IPayrollNotes.SET_CREATEDATE, argCreateDate);
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
/* 282 */       this._events.post(IPayrollNotes.SET_CREATEUSERID, argCreateUserId);
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
/* 316 */       this._events.post(IPayrollNotes.SET_UPDATEDATE, argUpdateDate);
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
/* 350 */       this._events.post(IPayrollNotes.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNoteText() {
/* 373 */     return getDAO_().getNoteText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteText(String argNoteText) {
/* 381 */     if (setNoteText_noev(argNoteText) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IPayrollNotes.SET_NOTETEXT, argNoteText);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteText_noev(String argNoteText) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getNoteText() == null && argNoteText != null) || (
/* 394 */       getDAO_().getNoteText() != null && !getDAO_().getNoteText().equals(argNoteText))) {
/* 395 */       getDAO_().setNoteText(argNoteText);
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPayrollNotesProperty newProperty(String argPropertyName) {
/* 403 */     PayrollNotesPropertyId id = new PayrollNotesPropertyId();
/*     */     
/* 405 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 406 */     id.setWeekEndingDate(getWeekEndingDate());
/* 407 */     id.setNoteSeq(Long.valueOf(getNoteSeq()));
/* 408 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 410 */     IPayrollNotesProperty prop = (IPayrollNotesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPayrollNotesProperty.class);
/* 411 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPayrollNotesProperty> getProperties() {
/* 420 */     if (this._properties == null) {
/* 421 */       this._properties = new HistoricalList(null);
/*     */     }
/* 423 */     return (List<IPayrollNotesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPayrollNotesProperty> argProperties) {
/* 427 */     if (this._properties == null) {
/* 428 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 430 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 433 */     for (IPayrollNotesProperty child : this._properties) {
/* 434 */       PayrollNotesPropertyModel model = (PayrollNotesPropertyModel)child;
/* 435 */       model.setOrganizationId_noev(getOrganizationId());
/* 436 */       model.setPartyId_noev(getPartyId());
/* 437 */       model.setWeekEndingDate_noev(getWeekEndingDate());
/* 438 */       model.setNoteSeq_noev(getNoteSeq());
/* 439 */       if (child instanceof IDataModelImpl) {
/* 440 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 441 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 442 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 443 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 446 */       if (postEventsForChanges()) {
/* 447 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPayrollNotesProperty(IPayrollNotesProperty argPayrollNotesProperty) {
/* 453 */     if (this._properties == null) {
/* 454 */       this._properties = new HistoricalList(null);
/*     */     }
/* 456 */     argPayrollNotesProperty.setOrganizationId(getOrganizationId());
/* 457 */     argPayrollNotesProperty.setPartyId(getPartyId());
/* 458 */     argPayrollNotesProperty.setWeekEndingDate(getWeekEndingDate());
/* 459 */     argPayrollNotesProperty.setNoteSeq(getNoteSeq());
/* 460 */     if (argPayrollNotesProperty instanceof IDataModelImpl) {
/* 461 */       IDataAccessObject childDao = ((IDataModelImpl)argPayrollNotesProperty).getDAO();
/* 462 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 463 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 464 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 469 */     if (postEventsForChanges()) {
/* 470 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollNotesProperty));
/*     */     }
/*     */     
/* 473 */     this._properties.add(argPayrollNotesProperty);
/* 474 */     if (postEventsForChanges()) {
/* 475 */       this._events.post(IPayrollNotes.ADD_PROPERTIES, argPayrollNotesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePayrollNotesProperty(IPayrollNotesProperty argPayrollNotesProperty) {
/* 480 */     if (this._properties != null) {
/*     */       
/* 482 */       if (postEventsForChanges()) {
/* 483 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollNotesProperty));
/*     */       }
/* 485 */       this._properties.remove(argPayrollNotesProperty);
/* 486 */       if (postEventsForChanges()) {
/* 487 */         this._events.post(IPayrollNotes.REMOVE_PROPERTIES, argPayrollNotesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 494 */     if ("Properties".equals(argFieldId)) {
/* 495 */       return getProperties();
/*     */     }
/* 497 */     if ("PayrollNotesExtension".equals(argFieldId)) {
/* 498 */       return this._myExtension;
/*     */     }
/*     */     
/* 501 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 507 */     if ("Properties".equals(argFieldId)) {
/* 508 */       setProperties(changeToList(argValue, IPayrollNotesProperty.class));
/*     */     }
/* 510 */     else if ("PayrollNotesExtension".equals(argFieldId)) {
/* 511 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 514 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 520 */     this._persistenceDefaults = argPD;
/* 521 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 522 */     this._eventManager = argEM;
/* 523 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 524 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 525 */     if (this._properties != null) {
/* 526 */       for (IPayrollNotesProperty relationship : this._properties) {
/* 527 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPayrollNotesExt() {
/* 533 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPayrollNotesExt(IDataModel argExt) {
/* 537 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 542 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 546 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 549 */     super.startTransaction();
/*     */     
/* 551 */     this._propertiesSavepoint = this._properties;
/* 552 */     if (this._properties != null) {
/* 553 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 554 */       Iterator<IDataModel> it = this._properties.iterator();
/* 555 */       while (it.hasNext()) {
/* 556 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 561 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 566 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 569 */     super.rollbackChanges();
/*     */     
/* 571 */     this._properties = this._propertiesSavepoint;
/* 572 */     this._propertiesSavepoint = null;
/* 573 */     if (this._properties != null) {
/* 574 */       Iterator<IDataModel> it = this._properties.iterator();
/* 575 */       while (it.hasNext()) {
/* 576 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 584 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 587 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 590 */     super.commitTransaction();
/*     */     
/* 592 */     this._propertiesSavepoint = this._properties;
/* 593 */     if (this._properties != null) {
/* 594 */       Iterator<IDataModel> it = this._properties.iterator();
/* 595 */       while (it.hasNext()) {
/* 596 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 598 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 602 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 607 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollNotesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */