/*     */ package dtv.xst.dao.trl.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.trl.IReturnedItemJournal;
/*     */ import dtv.xst.dao.trl.IReturnedItemJournalProperty;
/*     */ import dtv.xst.dao.trl.ReturnedItemJournalPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ReturnedItemJournalModel extends AbstractDataModelWithPropertyImpl<IReturnedItemJournalProperty> implements IReturnedItemJournal {
/*     */   private static final long serialVersionUID = 769133365L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IReturnedItemJournalProperty> _properties; private transient HistoricalList<IReturnedItemJournalProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReturnedItemJournalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReturnedItemJournalDAO getDAO_() {
/*  46 */     return (ReturnedItemJournalDAO)this._daoImpl;
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
/*  70 */       this._events.post(IReturnedItemJournal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ReturnedItemJournalPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReturnedItemJournalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 101 */     if (getDAO_().getRetailLocationId() != null) {
/* 102 */       return getDAO_().getRetailLocationId().longValue();
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
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IReturnedItemJournal.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<ReturnedItemJournalPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((ReturnedItemJournalPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public long getWorkstationId() {
/* 148 */     if (getDAO_().getWorkstationId() != null) {
/* 149 */       return getDAO_().getWorkstationId().longValue();
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
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 161 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IReturnedItemJournal.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 174 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 175 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<ReturnedItemJournalPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((ReturnedItemJournalPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*     */   public Date getBusinessDate() {
/* 195 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 203 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IReturnedItemJournal.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 216 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 217 */       getDAO_().setBusinessDate(argBusinessDate);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<ReturnedItemJournalPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((ReturnedItemJournalPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 237 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 238 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 241 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 250 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IReturnedItemJournal.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 263 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 264 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<ReturnedItemJournalPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((ReturnedItemJournalPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 284 */     if (getDAO_().getTransactionSequence() != null) {
/* 285 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 288 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 297 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IReturnedItemJournal.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 310 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 311 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 312 */       ev_postable = true;
/* 313 */       if (this._properties != null) {
/*     */         
/* 315 */         Iterator<ReturnedItemJournalPropertyModel> it = this._properties.iterator();
/* 316 */         while (it.hasNext())
/*     */         {
/* 318 */           ((ReturnedItemJournalPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getJournalSequence() {
/* 331 */     if (getDAO_().getJournalSequence() != null) {
/* 332 */       return getDAO_().getJournalSequence().longValue();
/*     */     }
/*     */     
/* 335 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJournalSequence(long argJournalSequence) {
/* 344 */     if (setJournalSequence_noev(argJournalSequence) && 
/* 345 */       this._events != null && 
/* 346 */       postEventsForChanges()) {
/* 347 */       this._events.post(IReturnedItemJournal.SET_JOURNALSEQUENCE, Long.valueOf(argJournalSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setJournalSequence_noev(long argJournalSequence) {
/* 354 */     boolean ev_postable = false;
/*     */     
/* 356 */     if ((getDAO_().getJournalSequence() == null && Long.valueOf(argJournalSequence) != null) || (
/* 357 */       getDAO_().getJournalSequence() != null && !getDAO_().getJournalSequence().equals(Long.valueOf(argJournalSequence)))) {
/* 358 */       getDAO_().setJournalSequence(Long.valueOf(argJournalSequence));
/* 359 */       ev_postable = true;
/* 360 */       if (this._properties != null) {
/*     */         
/* 362 */         Iterator<ReturnedItemJournalPropertyModel> it = this._properties.iterator();
/* 363 */         while (it.hasNext())
/*     */         {
/* 365 */           ((ReturnedItemJournalPropertyModel)it.next()).setJournalSequence_noev(argJournalSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 370 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 378 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 386 */     if (setCreateDate_noev(argCreateDate) && 
/* 387 */       this._events != null && 
/* 388 */       postEventsForChanges()) {
/* 389 */       this._events.post(IReturnedItemJournal.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 396 */     boolean ev_postable = false;
/*     */     
/* 398 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 399 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 400 */       getDAO_().setCreateDate(argCreateDate);
/* 401 */       ev_postable = true;
/*     */     } 
/*     */     
/* 404 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 412 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 420 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 421 */       this._events != null && 
/* 422 */       postEventsForChanges()) {
/* 423 */       this._events.post(IReturnedItemJournal.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 430 */     boolean ev_postable = false;
/*     */     
/* 432 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 433 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 434 */       getDAO_().setCreateUserId(argCreateUserId);
/* 435 */       ev_postable = true;
/*     */     } 
/*     */     
/* 438 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 446 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 454 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 455 */       this._events != null && 
/* 456 */       postEventsForChanges()) {
/* 457 */       this._events.post(IReturnedItemJournal.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 464 */     boolean ev_postable = false;
/*     */     
/* 466 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 467 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 468 */       getDAO_().setUpdateDate(argUpdateDate);
/* 469 */       ev_postable = true;
/*     */     } 
/*     */     
/* 472 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 480 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 488 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 489 */       this._events != null && 
/* 490 */       postEventsForChanges()) {
/* 491 */       this._events.post(IReturnedItemJournal.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 498 */     boolean ev_postable = false;
/*     */     
/* 500 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 501 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 502 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 503 */       ev_postable = true;
/*     */     } 
/*     */     
/* 506 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getReturnedCount() {
/* 514 */     return getDAO_().getReturnedCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnedCount(BigDecimal argReturnedCount) {
/* 522 */     if (setReturnedCount_noev(argReturnedCount) && 
/* 523 */       this._events != null && 
/* 524 */       postEventsForChanges()) {
/* 525 */       this._events.post(IReturnedItemJournal.SET_RETURNEDCOUNT, argReturnedCount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnedCount_noev(BigDecimal argReturnedCount) {
/* 532 */     boolean ev_postable = false;
/*     */     
/* 534 */     if ((getDAO_().getReturnedCount() == null && argReturnedCount != null) || (
/* 535 */       getDAO_().getReturnedCount() != null && !getDAO_().getReturnedCount().equals(argReturnedCount))) {
/* 536 */       getDAO_().setReturnedCount(argReturnedCount);
/* 537 */       ev_postable = true;
/*     */     } 
/*     */     
/* 540 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getReturnedRetailLocationId() {
/* 548 */     if (getDAO_().getReturnedRetailLocationId() != null) {
/* 549 */       return getDAO_().getReturnedRetailLocationId().longValue();
/*     */     }
/*     */     
/* 552 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnedRetailLocationId(long argReturnedRetailLocationId) {
/* 561 */     if (setReturnedRetailLocationId_noev(argReturnedRetailLocationId) && 
/* 562 */       this._events != null && 
/* 563 */       postEventsForChanges()) {
/* 564 */       this._events.post(IReturnedItemJournal.SET_RETURNEDRETAILLOCATIONID, Long.valueOf(argReturnedRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnedRetailLocationId_noev(long argReturnedRetailLocationId) {
/* 571 */     boolean ev_postable = false;
/*     */     
/* 573 */     if ((getDAO_().getReturnedRetailLocationId() == null && Long.valueOf(argReturnedRetailLocationId) != null) || (
/* 574 */       getDAO_().getReturnedRetailLocationId() != null && !getDAO_().getReturnedRetailLocationId().equals(Long.valueOf(argReturnedRetailLocationId)))) {
/* 575 */       getDAO_().setReturnedRetailLocationId(Long.valueOf(argReturnedRetailLocationId));
/* 576 */       ev_postable = true;
/*     */     } 
/*     */     
/* 579 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getReturnedWorkstationId() {
/* 587 */     if (getDAO_().getReturnedWorkstationId() != null) {
/* 588 */       return getDAO_().getReturnedWorkstationId().longValue();
/*     */     }
/*     */     
/* 591 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnedWorkstationId(long argReturnedWorkstationId) {
/* 600 */     if (setReturnedWorkstationId_noev(argReturnedWorkstationId) && 
/* 601 */       this._events != null && 
/* 602 */       postEventsForChanges()) {
/* 603 */       this._events.post(IReturnedItemJournal.SET_RETURNEDWORKSTATIONID, Long.valueOf(argReturnedWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnedWorkstationId_noev(long argReturnedWorkstationId) {
/* 610 */     boolean ev_postable = false;
/*     */     
/* 612 */     if ((getDAO_().getReturnedWorkstationId() == null && Long.valueOf(argReturnedWorkstationId) != null) || (
/* 613 */       getDAO_().getReturnedWorkstationId() != null && !getDAO_().getReturnedWorkstationId().equals(Long.valueOf(argReturnedWorkstationId)))) {
/* 614 */       getDAO_().setReturnedWorkstationId(Long.valueOf(argReturnedWorkstationId));
/* 615 */       ev_postable = true;
/*     */     } 
/*     */     
/* 618 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getReturnedBusinessDate() {
/* 626 */     return getDAO_().getReturnedBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnedBusinessDate(Date argReturnedBusinessDate) {
/* 634 */     if (setReturnedBusinessDate_noev(argReturnedBusinessDate) && 
/* 635 */       this._events != null && 
/* 636 */       postEventsForChanges()) {
/* 637 */       this._events.post(IReturnedItemJournal.SET_RETURNEDBUSINESSDATE, argReturnedBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnedBusinessDate_noev(Date argReturnedBusinessDate) {
/* 644 */     boolean ev_postable = false;
/*     */     
/* 646 */     if ((getDAO_().getReturnedBusinessDate() == null && argReturnedBusinessDate != null) || (
/* 647 */       getDAO_().getReturnedBusinessDate() != null && !getDAO_().getReturnedBusinessDate().equals(argReturnedBusinessDate))) {
/* 648 */       getDAO_().setReturnedBusinessDate(argReturnedBusinessDate);
/* 649 */       ev_postable = true;
/*     */     } 
/*     */     
/* 652 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReturnedRetailTransactionLineItemSequence() {
/* 660 */     if (getDAO_().getReturnedRetailTransactionLineItemSequence() != null) {
/* 661 */       return getDAO_().getReturnedRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 664 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnedRetailTransactionLineItemSequence(int argReturnedRetailTransactionLineItemSequence) {
/* 673 */     if (setReturnedRetailTransactionLineItemSequence_noev(argReturnedRetailTransactionLineItemSequence) && 
/* 674 */       this._events != null && 
/* 675 */       postEventsForChanges()) {
/* 676 */       this._events.post(IReturnedItemJournal.SET_RETURNEDRETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argReturnedRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnedRetailTransactionLineItemSequence_noev(int argReturnedRetailTransactionLineItemSequence) {
/* 683 */     boolean ev_postable = false;
/*     */     
/* 685 */     if ((getDAO_().getReturnedRetailTransactionLineItemSequence() == null && Integer.valueOf(argReturnedRetailTransactionLineItemSequence) != null) || (
/* 686 */       getDAO_().getReturnedRetailTransactionLineItemSequence() != null && !getDAO_().getReturnedRetailTransactionLineItemSequence().equals(Integer.valueOf(argReturnedRetailTransactionLineItemSequence)))) {
/* 687 */       getDAO_().setReturnedRetailTransactionLineItemSequence(Integer.valueOf(argReturnedRetailTransactionLineItemSequence));
/* 688 */       ev_postable = true;
/*     */     } 
/*     */     
/* 691 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getReturnedTransactionSequence() {
/* 699 */     if (getDAO_().getReturnedTransactionSequence() != null) {
/* 700 */       return getDAO_().getReturnedTransactionSequence().longValue();
/*     */     }
/*     */     
/* 703 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnedTransactionSequence(long argReturnedTransactionSequence) {
/* 712 */     if (setReturnedTransactionSequence_noev(argReturnedTransactionSequence) && 
/* 713 */       this._events != null && 
/* 714 */       postEventsForChanges()) {
/* 715 */       this._events.post(IReturnedItemJournal.SET_RETURNEDTRANSACTIONSEQUENCE, Long.valueOf(argReturnedTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnedTransactionSequence_noev(long argReturnedTransactionSequence) {
/* 722 */     boolean ev_postable = false;
/*     */     
/* 724 */     if ((getDAO_().getReturnedTransactionSequence() == null && Long.valueOf(argReturnedTransactionSequence) != null) || (
/* 725 */       getDAO_().getReturnedTransactionSequence() != null && !getDAO_().getReturnedTransactionSequence().equals(Long.valueOf(argReturnedTransactionSequence)))) {
/* 726 */       getDAO_().setReturnedTransactionSequence(Long.valueOf(argReturnedTransactionSequence));
/* 727 */       ev_postable = true;
/*     */     } 
/*     */     
/* 730 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReturnedItemJournalProperty newProperty(String argPropertyName) {
/* 734 */     ReturnedItemJournalPropertyId id = new ReturnedItemJournalPropertyId();
/*     */     
/* 736 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 737 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 738 */     id.setBusinessDate(getBusinessDate());
/* 739 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 740 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 741 */     id.setJournalSequence(Long.valueOf(getJournalSequence()));
/* 742 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 744 */     IReturnedItemJournalProperty prop = (IReturnedItemJournalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReturnedItemJournalProperty.class);
/* 745 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReturnedItemJournalProperty> getProperties() {
/* 754 */     if (this._properties == null) {
/* 755 */       this._properties = new HistoricalList(null);
/*     */     }
/* 757 */     return (List<IReturnedItemJournalProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReturnedItemJournalProperty> argProperties) {
/* 761 */     if (this._properties == null) {
/* 762 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 764 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 767 */     for (IReturnedItemJournalProperty child : this._properties) {
/* 768 */       ReturnedItemJournalPropertyModel model = (ReturnedItemJournalPropertyModel)child;
/* 769 */       model.setOrganizationId_noev(getOrganizationId());
/* 770 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 771 */       model.setWorkstationId_noev(getWorkstationId());
/* 772 */       model.setBusinessDate_noev(getBusinessDate());
/* 773 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 774 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 775 */       model.setJournalSequence_noev(getJournalSequence());
/* 776 */       if (child instanceof IDataModelImpl) {
/* 777 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 778 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 779 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 780 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 783 */       if (postEventsForChanges()) {
/* 784 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReturnedItemJournalProperty(IReturnedItemJournalProperty argReturnedItemJournalProperty) {
/* 790 */     if (this._properties == null) {
/* 791 */       this._properties = new HistoricalList(null);
/*     */     }
/* 793 */     argReturnedItemJournalProperty.setOrganizationId(getOrganizationId());
/* 794 */     argReturnedItemJournalProperty.setRetailLocationId(getRetailLocationId());
/* 795 */     argReturnedItemJournalProperty.setWorkstationId(getWorkstationId());
/* 796 */     argReturnedItemJournalProperty.setBusinessDate(getBusinessDate());
/* 797 */     argReturnedItemJournalProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 798 */     argReturnedItemJournalProperty.setTransactionSequence(getTransactionSequence());
/* 799 */     argReturnedItemJournalProperty.setJournalSequence(getJournalSequence());
/* 800 */     if (argReturnedItemJournalProperty instanceof IDataModelImpl) {
/* 801 */       IDataAccessObject childDao = ((IDataModelImpl)argReturnedItemJournalProperty).getDAO();
/* 802 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 803 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 804 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 809 */     if (postEventsForChanges()) {
/* 810 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReturnedItemJournalProperty));
/*     */     }
/*     */     
/* 813 */     this._properties.add(argReturnedItemJournalProperty);
/* 814 */     if (postEventsForChanges()) {
/* 815 */       this._events.post(IReturnedItemJournal.ADD_PROPERTIES, argReturnedItemJournalProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReturnedItemJournalProperty(IReturnedItemJournalProperty argReturnedItemJournalProperty) {
/* 820 */     if (this._properties != null) {
/*     */       
/* 822 */       if (postEventsForChanges()) {
/* 823 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReturnedItemJournalProperty));
/*     */       }
/* 825 */       this._properties.remove(argReturnedItemJournalProperty);
/* 826 */       if (postEventsForChanges()) {
/* 827 */         this._events.post(IReturnedItemJournal.REMOVE_PROPERTIES, argReturnedItemJournalProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 834 */     if ("Properties".equals(argFieldId)) {
/* 835 */       return getProperties();
/*     */     }
/* 837 */     if ("ReturnedItemJournalExtension".equals(argFieldId)) {
/* 838 */       return this._myExtension;
/*     */     }
/*     */     
/* 841 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 847 */     if ("Properties".equals(argFieldId)) {
/* 848 */       setProperties(changeToList(argValue, IReturnedItemJournalProperty.class));
/*     */     }
/* 850 */     else if ("ReturnedItemJournalExtension".equals(argFieldId)) {
/* 851 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 854 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 860 */     this._persistenceDefaults = argPD;
/* 861 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 862 */     this._eventManager = argEM;
/* 863 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 864 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 865 */     if (this._properties != null) {
/* 866 */       for (IReturnedItemJournalProperty relationship : this._properties) {
/* 867 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReturnedItemJournalExt() {
/* 873 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReturnedItemJournalExt(IDataModel argExt) {
/* 877 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 882 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 886 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 889 */     super.startTransaction();
/*     */     
/* 891 */     this._propertiesSavepoint = this._properties;
/* 892 */     if (this._properties != null) {
/* 893 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 894 */       Iterator<IDataModel> it = this._properties.iterator();
/* 895 */       while (it.hasNext()) {
/* 896 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 901 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 906 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 909 */     super.rollbackChanges();
/*     */     
/* 911 */     this._properties = this._propertiesSavepoint;
/* 912 */     this._propertiesSavepoint = null;
/* 913 */     if (this._properties != null) {
/* 914 */       Iterator<IDataModel> it = this._properties.iterator();
/* 915 */       while (it.hasNext()) {
/* 916 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 924 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 927 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 930 */     super.commitTransaction();
/*     */     
/* 932 */     this._propertiesSavepoint = this._properties;
/* 933 */     if (this._properties != null) {
/* 934 */       Iterator<IDataModel> it = this._properties.iterator();
/* 935 */       while (it.hasNext()) {
/* 936 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 938 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 942 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 947 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\ReturnedItemJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */