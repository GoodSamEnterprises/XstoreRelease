/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItemNotes;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItemNotesProperty;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemNotesPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class RetailTransactionLineItemNotesModel extends AbstractDataModelWithPropertyImpl<IRetailTransactionLineItemNotesProperty> implements IRetailTransactionLineItemNotes {
/*     */   private static final long serialVersionUID = 1536161759L;
/*     */   private ISaleReturnLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IRetailTransactionLineItemNotesProperty> _properties; private transient HistoricalList<IRetailTransactionLineItemNotesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new RetailTransactionLineItemNotesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RetailTransactionLineItemNotesDAO getDAO_() {
/*  48 */     return (RetailTransactionLineItemNotesDAO)this._daoImpl;
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
/*  67 */       this._events.post(IRetailTransactionLineItemNotes.SET_BUSINESSDATE, argBusinessDate);
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
/*  82 */         Iterator<RetailTransactionLineItemNotesPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((RetailTransactionLineItemNotesPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getOrganizationId() {
/*  98 */     if (getDAO_().getOrganizationId() != null) {
/*  99 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 102 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 111 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IRetailTransactionLineItemNotes.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<RetailTransactionLineItemNotesPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((RetailTransactionLineItemNotesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 145 */     if (getDAO_().getRetailLocationId() != null) {
/* 146 */       return getDAO_().getRetailLocationId().longValue();
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
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 158 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IRetailTransactionLineItemNotes.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 171 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 172 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<RetailTransactionLineItemNotesPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((RetailTransactionLineItemNotesPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 192 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 193 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 196 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 205 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IRetailTransactionLineItemNotes.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 218 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 219 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<RetailTransactionLineItemNotesPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((RetailTransactionLineItemNotesPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
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
/* 255 */       this._events.post(IRetailTransactionLineItemNotes.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/* 270 */         Iterator<RetailTransactionLineItemNotesPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((RetailTransactionLineItemNotesPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/* 302 */       this._events.post(IRetailTransactionLineItemNotes.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
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
/* 317 */         Iterator<RetailTransactionLineItemNotesPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((RetailTransactionLineItemNotesPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*     */   public long getNoteSeq() {
/* 333 */     if (getDAO_().getNoteSeq() != null) {
/* 334 */       return getDAO_().getNoteSeq().longValue();
/*     */     }
/*     */     
/* 337 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteSeq(long argNoteSeq) {
/* 346 */     if (setNoteSeq_noev(argNoteSeq) && 
/* 347 */       this._events != null && 
/* 348 */       postEventsForChanges()) {
/* 349 */       this._events.post(IRetailTransactionLineItemNotes.SET_NOTESEQ, Long.valueOf(argNoteSeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteSeq_noev(long argNoteSeq) {
/* 356 */     boolean ev_postable = false;
/*     */     
/* 358 */     if ((getDAO_().getNoteSeq() == null && Long.valueOf(argNoteSeq) != null) || (
/* 359 */       getDAO_().getNoteSeq() != null && !getDAO_().getNoteSeq().equals(Long.valueOf(argNoteSeq)))) {
/* 360 */       getDAO_().setNoteSeq(Long.valueOf(argNoteSeq));
/* 361 */       ev_postable = true;
/* 362 */       if (this._properties != null) {
/*     */         
/* 364 */         Iterator<RetailTransactionLineItemNotesPropertyModel> it = this._properties.iterator();
/* 365 */         while (it.hasNext())
/*     */         {
/* 367 */           ((RetailTransactionLineItemNotesPropertyModel)it.next()).setNoteSeq_noev(argNoteSeq);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 372 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 380 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 388 */     if (setCreateDate_noev(argCreateDate) && 
/* 389 */       this._events != null && 
/* 390 */       postEventsForChanges()) {
/* 391 */       this._events.post(IRetailTransactionLineItemNotes.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 398 */     boolean ev_postable = false;
/*     */     
/* 400 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 401 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 402 */       getDAO_().setCreateDate(argCreateDate);
/* 403 */       ev_postable = true;
/*     */     } 
/*     */     
/* 406 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 414 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 422 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(IRetailTransactionLineItemNotes.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 435 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 436 */       getDAO_().setCreateUserId(argCreateUserId);
/* 437 */       ev_postable = true;
/*     */     } 
/*     */     
/* 440 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 448 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 456 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 457 */       this._events != null && 
/* 458 */       postEventsForChanges()) {
/* 459 */       this._events.post(IRetailTransactionLineItemNotes.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 466 */     boolean ev_postable = false;
/*     */     
/* 468 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 469 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 470 */       getDAO_().setUpdateDate(argUpdateDate);
/* 471 */       ev_postable = true;
/*     */     } 
/*     */     
/* 474 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 482 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 490 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 491 */       this._events != null && 
/* 492 */       postEventsForChanges()) {
/* 493 */       this._events.post(IRetailTransactionLineItemNotes.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 500 */     boolean ev_postable = false;
/*     */     
/* 502 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 503 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 504 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 505 */       ev_postable = true;
/*     */     } 
/*     */     
/* 508 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 516 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 524 */     if (setNote_noev(argNote) && 
/* 525 */       this._events != null && 
/* 526 */       postEventsForChanges()) {
/* 527 */       this._events.post(IRetailTransactionLineItemNotes.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 534 */     boolean ev_postable = false;
/*     */     
/* 536 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 537 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 538 */       getDAO_().setNote(argNote);
/* 539 */       ev_postable = true;
/*     */     } 
/*     */     
/* 542 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getNoteDatetimestamp() {
/* 550 */     return getDAO_().getNoteDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 558 */     if (setNoteDatetimestamp_noev(argNoteDatetimestamp) && 
/* 559 */       this._events != null && 
/* 560 */       postEventsForChanges()) {
/* 561 */       this._events.post(IRetailTransactionLineItemNotes.SET_NOTEDATETIMESTAMP, argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteDatetimestamp_noev(Date argNoteDatetimestamp) {
/* 568 */     boolean ev_postable = false;
/*     */     
/* 570 */     if ((getDAO_().getNoteDatetimestamp() == null && argNoteDatetimestamp != null) || (
/* 571 */       getDAO_().getNoteDatetimestamp() != null && !getDAO_().getNoteDatetimestamp().equals(argNoteDatetimestamp))) {
/* 572 */       getDAO_().setNoteDatetimestamp(argNoteDatetimestamp);
/* 573 */       ev_postable = true;
/*     */     } 
/*     */     
/* 576 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPosted() {
/* 584 */     if (getDAO_().getPosted() != null) {
/* 585 */       return getDAO_().getPosted().booleanValue();
/*     */     }
/*     */     
/* 588 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosted(boolean argPosted) {
/* 597 */     if (setPosted_noev(argPosted) && 
/* 598 */       this._events != null && 
/* 599 */       postEventsForChanges()) {
/* 600 */       this._events.post(IRetailTransactionLineItemNotes.SET_POSTED, Boolean.valueOf(argPosted));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPosted_noev(boolean argPosted) {
/* 607 */     boolean ev_postable = false;
/*     */     
/* 609 */     if ((getDAO_().getPosted() == null && Boolean.valueOf(argPosted) != null) || (
/* 610 */       getDAO_().getPosted() != null && !getDAO_().getPosted().equals(Boolean.valueOf(argPosted)))) {
/* 611 */       getDAO_().setPosted(Boolean.valueOf(argPosted));
/* 612 */       ev_postable = true;
/*     */     } 
/*     */     
/* 615 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IRetailTransactionLineItemNotesProperty newProperty(String argPropertyName) {
/* 619 */     RetailTransactionLineItemNotesPropertyId id = new RetailTransactionLineItemNotesPropertyId();
/*     */     
/* 621 */     id.setBusinessDate(getBusinessDate());
/* 622 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 623 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 624 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 625 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 626 */     id.setNoteSeq(Long.valueOf(getNoteSeq()));
/* 627 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 629 */     IRetailTransactionLineItemNotesProperty prop = (IRetailTransactionLineItemNotesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRetailTransactionLineItemNotesProperty.class);
/* 630 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IRetailTransactionLineItemNotesProperty> getProperties() {
/* 639 */     if (this._properties == null) {
/* 640 */       this._properties = new HistoricalList(null);
/*     */     }
/* 642 */     return (List<IRetailTransactionLineItemNotesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IRetailTransactionLineItemNotesProperty> argProperties) {
/* 646 */     if (this._properties == null) {
/* 647 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 649 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 652 */     for (IRetailTransactionLineItemNotesProperty child : this._properties) {
/* 653 */       RetailTransactionLineItemNotesPropertyModel model = (RetailTransactionLineItemNotesPropertyModel)child;
/* 654 */       model.setBusinessDate_noev(getBusinessDate());
/* 655 */       model.setOrganizationId_noev(getOrganizationId());
/* 656 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 657 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 658 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 659 */       model.setWorkstationId_noev(getWorkstationId());
/* 660 */       model.setNoteSeq_noev(getNoteSeq());
/* 661 */       if (child instanceof IDataModelImpl) {
/* 662 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 663 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 664 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 665 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 668 */       if (postEventsForChanges()) {
/* 669 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addRetailTransactionLineItemNotesProperty(IRetailTransactionLineItemNotesProperty argRetailTransactionLineItemNotesProperty) {
/* 675 */     if (this._properties == null) {
/* 676 */       this._properties = new HistoricalList(null);
/*     */     }
/* 678 */     argRetailTransactionLineItemNotesProperty.setBusinessDate(getBusinessDate());
/* 679 */     argRetailTransactionLineItemNotesProperty.setOrganizationId(getOrganizationId());
/* 680 */     argRetailTransactionLineItemNotesProperty.setRetailLocationId(getRetailLocationId());
/* 681 */     argRetailTransactionLineItemNotesProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 682 */     argRetailTransactionLineItemNotesProperty.setTransactionSequence(getTransactionSequence());
/* 683 */     argRetailTransactionLineItemNotesProperty.setWorkstationId(getWorkstationId());
/* 684 */     argRetailTransactionLineItemNotesProperty.setNoteSeq(getNoteSeq());
/* 685 */     if (argRetailTransactionLineItemNotesProperty instanceof IDataModelImpl) {
/* 686 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailTransactionLineItemNotesProperty).getDAO();
/* 687 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 688 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 689 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 694 */     if (postEventsForChanges()) {
/* 695 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItemNotesProperty));
/*     */     }
/*     */     
/* 698 */     this._properties.add(argRetailTransactionLineItemNotesProperty);
/* 699 */     if (postEventsForChanges()) {
/* 700 */       this._events.post(IRetailTransactionLineItemNotes.ADD_PROPERTIES, argRetailTransactionLineItemNotesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRetailTransactionLineItemNotesProperty(IRetailTransactionLineItemNotesProperty argRetailTransactionLineItemNotesProperty) {
/* 705 */     if (this._properties != null) {
/*     */       
/* 707 */       if (postEventsForChanges()) {
/* 708 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItemNotesProperty));
/*     */       }
/* 710 */       this._properties.remove(argRetailTransactionLineItemNotesProperty);
/* 711 */       if (postEventsForChanges()) {
/* 712 */         this._events.post(IRetailTransactionLineItemNotes.REMOVE_PROPERTIES, argRetailTransactionLineItemNotesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/* 718 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public ISaleReturnLineItem getParentLine() {
/* 722 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 727 */     if ("Properties".equals(argFieldId)) {
/* 728 */       return getProperties();
/*     */     }
/* 730 */     if ("RetailTransactionLineItemNotesExtension".equals(argFieldId)) {
/* 731 */       return this._myExtension;
/*     */     }
/*     */     
/* 734 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 740 */     if ("Properties".equals(argFieldId)) {
/* 741 */       setProperties(changeToList(argValue, IRetailTransactionLineItemNotesProperty.class));
/*     */     }
/* 743 */     else if ("RetailTransactionLineItemNotesExtension".equals(argFieldId)) {
/* 744 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 747 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 753 */     this._persistenceDefaults = argPD;
/* 754 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 755 */     this._eventManager = argEM;
/* 756 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 757 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 758 */     if (this._properties != null) {
/* 759 */       for (IRetailTransactionLineItemNotesProperty relationship : this._properties) {
/* 760 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getRetailTransactionLineItemNotesExt() {
/* 766 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemNotesExt(IDataModel argExt) {
/* 770 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 775 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 779 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 782 */     super.startTransaction();
/*     */     
/* 784 */     this._propertiesSavepoint = this._properties;
/* 785 */     if (this._properties != null) {
/* 786 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 787 */       Iterator<IDataModel> it = this._properties.iterator();
/* 788 */       while (it.hasNext()) {
/* 789 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 794 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 799 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 802 */     super.rollbackChanges();
/*     */     
/* 804 */     this._properties = this._propertiesSavepoint;
/* 805 */     this._propertiesSavepoint = null;
/* 806 */     if (this._properties != null) {
/* 807 */       Iterator<IDataModel> it = this._properties.iterator();
/* 808 */       while (it.hasNext()) {
/* 809 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 817 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 820 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 823 */     super.commitTransaction();
/*     */     
/* 825 */     this._propertiesSavepoint = this._properties;
/* 826 */     if (this._properties != null) {
/* 827 */       Iterator<IDataModel> it = this._properties.iterator();
/* 828 */       while (it.hasNext()) {
/* 829 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 831 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 835 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 840 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemNotesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */