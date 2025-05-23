/*     */ package dtv.xst.dao.trn.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
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
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import dtv.xst.dao.trn.ITransactionNotes;
/*     */ import dtv.xst.dao.trn.ITransactionNotesProperty;
/*     */ import dtv.xst.dao.trn.TransactionNotesPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TransactionNotesModel extends AbstractDataModelWithPropertyImpl<ITransactionNotesProperty> implements ITransactionNotes {
/*     */   private static final long serialVersionUID = -349574493L;
/*     */   private IPosTransaction _parentTransaction;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ITransactionNotesProperty> _properties; private transient HistoricalList<ITransactionNotesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new TransactionNotesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TransactionNotesDAO getDAO_() {
/*  48 */     return (TransactionNotesDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  56 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  64 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(ITransactionNotes.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  77 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  78 */       getDAO_().setBusinessDate(argBusinessDate);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<TransactionNotesPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((TransactionNotesPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNoteSequence() {
/*  98 */     if (getDAO_().getNoteSequence() != null) {
/*  99 */       return getDAO_().getNoteSequence().intValue();
/*     */     }
/*     */     
/* 102 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteSequence(int argNoteSequence) {
/* 111 */     if (setNoteSequence_noev(argNoteSequence) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(ITransactionNotes.SET_NOTESEQUENCE, Integer.valueOf(argNoteSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteSequence_noev(int argNoteSequence) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getNoteSequence() == null && Integer.valueOf(argNoteSequence) != null) || (
/* 124 */       getDAO_().getNoteSequence() != null && !getDAO_().getNoteSequence().equals(Integer.valueOf(argNoteSequence)))) {
/* 125 */       getDAO_().setNoteSequence(Integer.valueOf(argNoteSequence));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<TransactionNotesPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((TransactionNotesPropertyModel)it.next()).setNoteSequence_noev(argNoteSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 145 */     if (getDAO_().getOrganizationId() != null) {
/* 146 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 149 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 158 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(ITransactionNotes.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 171 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 172 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<TransactionNotesPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((TransactionNotesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 192 */     if (getDAO_().getRetailLocationId() != null) {
/* 193 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 196 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 205 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(ITransactionNotes.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 218 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 219 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<TransactionNotesPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((TransactionNotesPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 239 */     if (getDAO_().getTransactionSequence() != null) {
/* 240 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 243 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 252 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(ITransactionNotes.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 265 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 266 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 267 */       ev_postable = true;
/* 268 */       if (this._properties != null) {
/*     */         
/* 270 */         Iterator<TransactionNotesPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((TransactionNotesPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 278 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 286 */     if (getDAO_().getWorkstationId() != null) {
/* 287 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 290 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 299 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(ITransactionNotes.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 312 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 313 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 314 */       ev_postable = true;
/* 315 */       if (this._properties != null) {
/*     */         
/* 317 */         Iterator<TransactionNotesPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((TransactionNotesPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 325 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 333 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 341 */     if (setCreateDate_noev(argCreateDate) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(ITransactionNotes.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 354 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 355 */       getDAO_().setCreateDate(argCreateDate);
/* 356 */       ev_postable = true;
/*     */     } 
/*     */     
/* 359 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 367 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 375 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 376 */       this._events != null && 
/* 377 */       postEventsForChanges()) {
/* 378 */       this._events.post(ITransactionNotes.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 385 */     boolean ev_postable = false;
/*     */     
/* 387 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 388 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 389 */       getDAO_().setCreateUserId(argCreateUserId);
/* 390 */       ev_postable = true;
/*     */     } 
/*     */     
/* 393 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 401 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 409 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 410 */       this._events != null && 
/* 411 */       postEventsForChanges()) {
/* 412 */       this._events.post(ITransactionNotes.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 419 */     boolean ev_postable = false;
/*     */     
/* 421 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 422 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 423 */       getDAO_().setUpdateDate(argUpdateDate);
/* 424 */       ev_postable = true;
/*     */     } 
/*     */     
/* 427 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 435 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 443 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 444 */       this._events != null && 
/* 445 */       postEventsForChanges()) {
/* 446 */       this._events.post(ITransactionNotes.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 453 */     boolean ev_postable = false;
/*     */     
/* 455 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 456 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 457 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 458 */       ev_postable = true;
/*     */     } 
/*     */     
/* 461 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 469 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 477 */     if (setNote_noev(argNote) && 
/* 478 */       this._events != null && 
/* 479 */       postEventsForChanges()) {
/* 480 */       this._events.post(ITransactionNotes.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 487 */     boolean ev_postable = false;
/*     */     
/* 489 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 490 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 491 */       getDAO_().setNote(argNote);
/* 492 */       ev_postable = true;
/*     */     } 
/*     */     
/* 495 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getNoteDatetimestamp() {
/* 503 */     return getDAO_().getNoteDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 511 */     if (setNoteDatetimestamp_noev(argNoteDatetimestamp) && 
/* 512 */       this._events != null && 
/* 513 */       postEventsForChanges()) {
/* 514 */       this._events.post(ITransactionNotes.SET_NOTEDATETIMESTAMP, argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteDatetimestamp_noev(Date argNoteDatetimestamp) {
/* 521 */     boolean ev_postable = false;
/*     */     
/* 523 */     if ((getDAO_().getNoteDatetimestamp() == null && argNoteDatetimestamp != null) || (
/* 524 */       getDAO_().getNoteDatetimestamp() != null && !getDAO_().getNoteDatetimestamp().equals(argNoteDatetimestamp))) {
/* 525 */       getDAO_().setNoteDatetimestamp(argNoteDatetimestamp);
/* 526 */       ev_postable = true;
/*     */     } 
/*     */     
/* 529 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPosted() {
/* 537 */     if (getDAO_().getPosted() != null) {
/* 538 */       return getDAO_().getPosted().booleanValue();
/*     */     }
/*     */     
/* 541 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosted(boolean argPosted) {
/* 550 */     if (setPosted_noev(argPosted) && 
/* 551 */       this._events != null && 
/* 552 */       postEventsForChanges()) {
/* 553 */       this._events.post(ITransactionNotes.SET_POSTED, Boolean.valueOf(argPosted));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPosted_noev(boolean argPosted) {
/* 560 */     boolean ev_postable = false;
/*     */     
/* 562 */     if ((getDAO_().getPosted() == null && Boolean.valueOf(argPosted) != null) || (
/* 563 */       getDAO_().getPosted() != null && !getDAO_().getPosted().equals(Boolean.valueOf(argPosted)))) {
/* 564 */       getDAO_().setPosted(Boolean.valueOf(argPosted));
/* 565 */       ev_postable = true;
/*     */     } 
/*     */     
/* 568 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITransactionNotesProperty newProperty(String argPropertyName) {
/* 572 */     TransactionNotesPropertyId id = new TransactionNotesPropertyId();
/*     */     
/* 574 */     id.setBusinessDate(getBusinessDate());
/* 575 */     id.setNoteSequence(Integer.valueOf(getNoteSequence()));
/* 576 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 577 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 578 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 579 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 581 */     ITransactionNotesProperty prop = (ITransactionNotesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITransactionNotesProperty.class);
/* 582 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITransactionNotesProperty> getProperties() {
/* 591 */     if (this._properties == null) {
/* 592 */       this._properties = new HistoricalList(null);
/*     */     }
/* 594 */     return (List<ITransactionNotesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITransactionNotesProperty> argProperties) {
/* 598 */     if (this._properties == null) {
/* 599 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 601 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 604 */     for (ITransactionNotesProperty child : this._properties) {
/* 605 */       TransactionNotesPropertyModel model = (TransactionNotesPropertyModel)child;
/* 606 */       model.setBusinessDate_noev(getBusinessDate());
/* 607 */       model.setNoteSequence_noev(getNoteSequence());
/* 608 */       model.setOrganizationId_noev(getOrganizationId());
/* 609 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 610 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 611 */       model.setWorkstationId_noev(getWorkstationId());
/* 612 */       if (child instanceof IDataModelImpl) {
/* 613 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 614 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 615 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 616 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 619 */       if (postEventsForChanges()) {
/* 620 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTransactionNotesProperty(ITransactionNotesProperty argTransactionNotesProperty) {
/* 626 */     if (this._properties == null) {
/* 627 */       this._properties = new HistoricalList(null);
/*     */     }
/* 629 */     argTransactionNotesProperty.setBusinessDate(getBusinessDate());
/* 630 */     argTransactionNotesProperty.setNoteSequence(getNoteSequence());
/* 631 */     argTransactionNotesProperty.setOrganizationId(getOrganizationId());
/* 632 */     argTransactionNotesProperty.setRetailLocationId(getRetailLocationId());
/* 633 */     argTransactionNotesProperty.setTransactionSequence(getTransactionSequence());
/* 634 */     argTransactionNotesProperty.setWorkstationId(getWorkstationId());
/* 635 */     if (argTransactionNotesProperty instanceof IDataModelImpl) {
/* 636 */       IDataAccessObject childDao = ((IDataModelImpl)argTransactionNotesProperty).getDAO();
/* 637 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 638 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 639 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 644 */     if (postEventsForChanges()) {
/* 645 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionNotesProperty));
/*     */     }
/*     */     
/* 648 */     this._properties.add(argTransactionNotesProperty);
/* 649 */     if (postEventsForChanges()) {
/* 650 */       this._events.post(ITransactionNotes.ADD_PROPERTIES, argTransactionNotesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTransactionNotesProperty(ITransactionNotesProperty argTransactionNotesProperty) {
/* 655 */     if (this._properties != null) {
/*     */       
/* 657 */       if (postEventsForChanges()) {
/* 658 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionNotesProperty));
/*     */       }
/* 660 */       this._properties.remove(argTransactionNotesProperty);
/* 661 */       if (postEventsForChanges()) {
/* 662 */         this._events.post(ITransactionNotes.REMOVE_PROPERTIES, argTransactionNotesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTransaction(IPosTransaction argParentTransaction) {
/* 668 */     this._parentTransaction = argParentTransaction;
/*     */   }
/*     */   
/*     */   public IPosTransaction getParentTransaction() {
/* 672 */     return this._parentTransaction;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 677 */     if ("Properties".equals(argFieldId)) {
/* 678 */       return getProperties();
/*     */     }
/* 680 */     if ("TransactionNotesExtension".equals(argFieldId)) {
/* 681 */       return this._myExtension;
/*     */     }
/*     */     
/* 684 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 690 */     if ("Properties".equals(argFieldId)) {
/* 691 */       setProperties(changeToList(argValue, ITransactionNotesProperty.class));
/*     */     }
/* 693 */     else if ("TransactionNotesExtension".equals(argFieldId)) {
/* 694 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 697 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 703 */     this._persistenceDefaults = argPD;
/* 704 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 705 */     this._eventManager = argEM;
/* 706 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 707 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 708 */     if (this._properties != null) {
/* 709 */       for (ITransactionNotesProperty relationship : this._properties) {
/* 710 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTransactionNotesExt() {
/* 716 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTransactionNotesExt(IDataModel argExt) {
/* 720 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 725 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 729 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 732 */     super.startTransaction();
/*     */     
/* 734 */     this._propertiesSavepoint = this._properties;
/* 735 */     if (this._properties != null) {
/* 736 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 737 */       Iterator<IDataModel> it = this._properties.iterator();
/* 738 */       while (it.hasNext()) {
/* 739 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 744 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 749 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 752 */     super.rollbackChanges();
/*     */     
/* 754 */     this._properties = this._propertiesSavepoint;
/* 755 */     this._propertiesSavepoint = null;
/* 756 */     if (this._properties != null) {
/* 757 */       Iterator<IDataModel> it = this._properties.iterator();
/* 758 */       while (it.hasNext()) {
/* 759 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 767 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 770 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 773 */     super.commitTransaction();
/*     */     
/* 775 */     this._propertiesSavepoint = this._properties;
/* 776 */     if (this._properties != null) {
/* 777 */       Iterator<IDataModel> it = this._properties.iterator();
/* 778 */       while (it.hasNext()) {
/* 779 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 781 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 785 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 790 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionNotesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */