/*     */ package dtv.xst.dao.inv.impl;
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
/*     */ import dtv.xst.dao.inv.IInventoryJournal;
/*     */ import dtv.xst.dao.inv.IInventoryJournalProperty;
/*     */ import dtv.xst.dao.inv.InventoryJournalPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryJournalModel extends AbstractDataModelWithPropertyImpl<IInventoryJournalProperty> implements IInventoryJournal {
/*     */   private static final long serialVersionUID = 85946971L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IInventoryJournalProperty> _properties; private transient HistoricalList<IInventoryJournalProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new InventoryJournalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryJournalDAO getDAO_() {
/*  46 */     return (InventoryJournalDAO)this._daoImpl;
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
/*  70 */       this._events.post(IInventoryJournal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<InventoryJournalPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((InventoryJournalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IInventoryJournal.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<InventoryJournalPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((InventoryJournalPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 164 */       this._events.post(IInventoryJournal.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
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
/* 179 */         Iterator<InventoryJournalPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((InventoryJournalPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/* 206 */       this._events.post(IInventoryJournal.SET_BUSINESSDATE, argBusinessDate);
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
/* 221 */         Iterator<InventoryJournalPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((InventoryJournalPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getTransactionSequence() {
/* 237 */     if (getDAO_().getTransactionSequence() != null) {
/* 238 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 241 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 250 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IInventoryJournal.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 263 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 264 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<InventoryJournalPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((InventoryJournalPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   public long getTransactionLineItemSequence() {
/* 284 */     if (getDAO_().getTransactionLineItemSequence() != null) {
/* 285 */       return getDAO_().getTransactionLineItemSequence().longValue();
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
/*     */   public void setTransactionLineItemSequence(long argTransactionLineItemSequence) {
/* 297 */     if (setTransactionLineItemSequence_noev(argTransactionLineItemSequence) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IInventoryJournal.SET_TRANSACTIONLINEITEMSEQUENCE, Long.valueOf(argTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionLineItemSequence_noev(long argTransactionLineItemSequence) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getTransactionLineItemSequence() == null && Long.valueOf(argTransactionLineItemSequence) != null) || (
/* 310 */       getDAO_().getTransactionLineItemSequence() != null && !getDAO_().getTransactionLineItemSequence().equals(Long.valueOf(argTransactionLineItemSequence)))) {
/* 311 */       getDAO_().setTransactionLineItemSequence(Long.valueOf(argTransactionLineItemSequence));
/* 312 */       ev_postable = true;
/* 313 */       if (this._properties != null) {
/*     */         
/* 315 */         Iterator<InventoryJournalPropertyModel> it = this._properties.iterator();
/* 316 */         while (it.hasNext())
/*     */         {
/* 318 */           ((InventoryJournalPropertyModel)it.next()).setTransactionLineItemSequence_noev(argTransactionLineItemSequence);
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
/* 347 */       this._events.post(IInventoryJournal.SET_JOURNALSEQUENCE, Long.valueOf(argJournalSequence));
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
/* 362 */         Iterator<InventoryJournalPropertyModel> it = this._properties.iterator();
/* 363 */         while (it.hasNext())
/*     */         {
/* 365 */           ((InventoryJournalPropertyModel)it.next()).setJournalSequence_noev(argJournalSequence);
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
/* 389 */       this._events.post(IInventoryJournal.SET_CREATEDATE, argCreateDate);
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
/* 423 */       this._events.post(IInventoryJournal.SET_CREATEUSERID, argCreateUserId);
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
/* 457 */       this._events.post(IInventoryJournal.SET_UPDATEDATE, argUpdateDate);
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
/* 491 */       this._events.post(IInventoryJournal.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getInventoryItemId() {
/* 514 */     return getDAO_().getInventoryItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryItemId(String argInventoryItemId) {
/* 522 */     if (setInventoryItemId_noev(argInventoryItemId) && 
/* 523 */       this._events != null && 
/* 524 */       postEventsForChanges()) {
/* 525 */       this._events.post(IInventoryJournal.SET_INVENTORYITEMID, argInventoryItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryItemId_noev(String argInventoryItemId) {
/* 532 */     boolean ev_postable = false;
/*     */     
/* 534 */     if ((getDAO_().getInventoryItemId() == null && argInventoryItemId != null) || (
/* 535 */       getDAO_().getInventoryItemId() != null && !getDAO_().getInventoryItemId().equals(argInventoryItemId))) {
/* 536 */       getDAO_().setInventoryItemId(argInventoryItemId);
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
/*     */   public String getItemSerialNumber() {
/* 548 */     return getDAO_().getItemSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemSerialNumber(String argItemSerialNumber) {
/* 556 */     if (setItemSerialNumber_noev(argItemSerialNumber) && 
/* 557 */       this._events != null && 
/* 558 */       postEventsForChanges()) {
/* 559 */       this._events.post(IInventoryJournal.SET_ITEMSERIALNUMBER, argItemSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemSerialNumber_noev(String argItemSerialNumber) {
/* 566 */     boolean ev_postable = false;
/*     */     
/* 568 */     if ((getDAO_().getItemSerialNumber() == null && argItemSerialNumber != null) || (
/* 569 */       getDAO_().getItemSerialNumber() != null && !getDAO_().getItemSerialNumber().equals(argItemSerialNumber))) {
/* 570 */       getDAO_().setItemSerialNumber(argItemSerialNumber);
/* 571 */       ev_postable = true;
/*     */     } 
/*     */     
/* 574 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionCode() {
/* 582 */     return getDAO_().getActionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 590 */     if (setActionCode_noev(argActionCode) && 
/* 591 */       this._events != null && 
/* 592 */       postEventsForChanges()) {
/* 593 */       this._events.post(IInventoryJournal.SET_ACTIONCODE, argActionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActionCode_noev(String argActionCode) {
/* 600 */     boolean ev_postable = false;
/*     */     
/* 602 */     if ((getDAO_().getActionCode() == null && argActionCode != null) || (
/* 603 */       getDAO_().getActionCode() != null && !getDAO_().getActionCode().equals(argActionCode))) {
/* 604 */       getDAO_().setActionCode(argActionCode);
/* 605 */       ev_postable = true;
/*     */     } 
/*     */     
/* 608 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 616 */     return getDAO_().getQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 624 */     if (setQuantity_noev(argQuantity) && 
/* 625 */       this._events != null && 
/* 626 */       postEventsForChanges()) {
/* 627 */       this._events.post(IInventoryJournal.SET_QUANTITY, argQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/* 634 */     boolean ev_postable = false;
/*     */     
/* 636 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/* 637 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/* 638 */       getDAO_().setQuantity(argQuantity);
/* 639 */       ev_postable = true;
/*     */     } 
/*     */     
/* 642 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceLocationId() {
/* 650 */     return getDAO_().getSourceLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceLocationId(String argSourceLocationId) {
/* 658 */     if (setSourceLocationId_noev(argSourceLocationId) && 
/* 659 */       this._events != null && 
/* 660 */       postEventsForChanges()) {
/* 661 */       this._events.post(IInventoryJournal.SET_SOURCELOCATIONID, argSourceLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSourceLocationId_noev(String argSourceLocationId) {
/* 668 */     boolean ev_postable = false;
/*     */     
/* 670 */     if ((getDAO_().getSourceLocationId() == null && argSourceLocationId != null) || (
/* 671 */       getDAO_().getSourceLocationId() != null && !getDAO_().getSourceLocationId().equals(argSourceLocationId))) {
/* 672 */       getDAO_().setSourceLocationId(argSourceLocationId);
/* 673 */       ev_postable = true;
/*     */     } 
/*     */     
/* 676 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceBucketId() {
/* 684 */     return getDAO_().getSourceBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceBucketId(String argSourceBucketId) {
/* 692 */     if (setSourceBucketId_noev(argSourceBucketId) && 
/* 693 */       this._events != null && 
/* 694 */       postEventsForChanges()) {
/* 695 */       this._events.post(IInventoryJournal.SET_SOURCEBUCKETID, argSourceBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSourceBucketId_noev(String argSourceBucketId) {
/* 702 */     boolean ev_postable = false;
/*     */     
/* 704 */     if ((getDAO_().getSourceBucketId() == null && argSourceBucketId != null) || (
/* 705 */       getDAO_().getSourceBucketId() != null && !getDAO_().getSourceBucketId().equals(argSourceBucketId))) {
/* 706 */       getDAO_().setSourceBucketId(argSourceBucketId);
/* 707 */       ev_postable = true;
/*     */     } 
/*     */     
/* 710 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDestinationLocationId() {
/* 718 */     return getDAO_().getDestinationLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationLocationId(String argDestinationLocationId) {
/* 726 */     if (setDestinationLocationId_noev(argDestinationLocationId) && 
/* 727 */       this._events != null && 
/* 728 */       postEventsForChanges()) {
/* 729 */       this._events.post(IInventoryJournal.SET_DESTINATIONLOCATIONID, argDestinationLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDestinationLocationId_noev(String argDestinationLocationId) {
/* 736 */     boolean ev_postable = false;
/*     */     
/* 738 */     if ((getDAO_().getDestinationLocationId() == null && argDestinationLocationId != null) || (
/* 739 */       getDAO_().getDestinationLocationId() != null && !getDAO_().getDestinationLocationId().equals(argDestinationLocationId))) {
/* 740 */       getDAO_().setDestinationLocationId(argDestinationLocationId);
/* 741 */       ev_postable = true;
/*     */     } 
/*     */     
/* 744 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDestinationBucketId() {
/* 752 */     return getDAO_().getDestinationBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationBucketId(String argDestinationBucketId) {
/* 760 */     if (setDestinationBucketId_noev(argDestinationBucketId) && 
/* 761 */       this._events != null && 
/* 762 */       postEventsForChanges()) {
/* 763 */       this._events.post(IInventoryJournal.SET_DESTINATIONBUCKETID, argDestinationBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDestinationBucketId_noev(String argDestinationBucketId) {
/* 770 */     boolean ev_postable = false;
/*     */     
/* 772 */     if ((getDAO_().getDestinationBucketId() == null && argDestinationBucketId != null) || (
/* 773 */       getDAO_().getDestinationBucketId() != null && !getDAO_().getDestinationBucketId().equals(argDestinationBucketId))) {
/* 774 */       getDAO_().setDestinationBucketId(argDestinationBucketId);
/* 775 */       ev_postable = true;
/*     */     } 
/*     */     
/* 778 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryJournalProperty newProperty(String argPropertyName) {
/* 782 */     InventoryJournalPropertyId id = new InventoryJournalPropertyId();
/*     */     
/* 784 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 785 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 786 */     id.setBusinessDate(getBusinessDate());
/* 787 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 788 */     id.setTransactionLineItemSequence(Long.valueOf(getTransactionLineItemSequence()));
/* 789 */     id.setJournalSequence(Long.valueOf(getJournalSequence()));
/* 790 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 792 */     IInventoryJournalProperty prop = (IInventoryJournalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryJournalProperty.class);
/* 793 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryJournalProperty> getProperties() {
/* 802 */     if (this._properties == null) {
/* 803 */       this._properties = new HistoricalList(null);
/*     */     }
/* 805 */     return (List<IInventoryJournalProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryJournalProperty> argProperties) {
/* 809 */     if (this._properties == null) {
/* 810 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 812 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 815 */     for (IInventoryJournalProperty child : this._properties) {
/* 816 */       InventoryJournalPropertyModel model = (InventoryJournalPropertyModel)child;
/* 817 */       model.setOrganizationId_noev(getOrganizationId());
/* 818 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 819 */       model.setWorkstationId_noev(getWorkstationId());
/* 820 */       model.setBusinessDate_noev(getBusinessDate());
/* 821 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 822 */       model.setTransactionLineItemSequence_noev(getTransactionLineItemSequence());
/* 823 */       model.setJournalSequence_noev(getJournalSequence());
/* 824 */       if (child instanceof IDataModelImpl) {
/* 825 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 826 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 827 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 828 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 831 */       if (postEventsForChanges()) {
/* 832 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryJournalProperty(IInventoryJournalProperty argInventoryJournalProperty) {
/* 838 */     if (this._properties == null) {
/* 839 */       this._properties = new HistoricalList(null);
/*     */     }
/* 841 */     argInventoryJournalProperty.setOrganizationId(getOrganizationId());
/* 842 */     argInventoryJournalProperty.setRetailLocationId(getRetailLocationId());
/* 843 */     argInventoryJournalProperty.setWorkstationId(getWorkstationId());
/* 844 */     argInventoryJournalProperty.setBusinessDate(getBusinessDate());
/* 845 */     argInventoryJournalProperty.setTransactionSequence(getTransactionSequence());
/* 846 */     argInventoryJournalProperty.setTransactionLineItemSequence(getTransactionLineItemSequence());
/* 847 */     argInventoryJournalProperty.setJournalSequence(getJournalSequence());
/* 848 */     if (argInventoryJournalProperty instanceof IDataModelImpl) {
/* 849 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryJournalProperty).getDAO();
/* 850 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 851 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 852 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 857 */     if (postEventsForChanges()) {
/* 858 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryJournalProperty));
/*     */     }
/*     */     
/* 861 */     this._properties.add(argInventoryJournalProperty);
/* 862 */     if (postEventsForChanges()) {
/* 863 */       this._events.post(IInventoryJournal.ADD_PROPERTIES, argInventoryJournalProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryJournalProperty(IInventoryJournalProperty argInventoryJournalProperty) {
/* 868 */     if (this._properties != null) {
/*     */       
/* 870 */       if (postEventsForChanges()) {
/* 871 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryJournalProperty));
/*     */       }
/* 873 */       this._properties.remove(argInventoryJournalProperty);
/* 874 */       if (postEventsForChanges()) {
/* 875 */         this._events.post(IInventoryJournal.REMOVE_PROPERTIES, argInventoryJournalProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 882 */     if ("Properties".equals(argFieldId)) {
/* 883 */       return getProperties();
/*     */     }
/* 885 */     if ("InventoryJournalExtension".equals(argFieldId)) {
/* 886 */       return this._myExtension;
/*     */     }
/*     */     
/* 889 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 895 */     if ("Properties".equals(argFieldId)) {
/* 896 */       setProperties(changeToList(argValue, IInventoryJournalProperty.class));
/*     */     }
/* 898 */     else if ("InventoryJournalExtension".equals(argFieldId)) {
/* 899 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 902 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 908 */     this._persistenceDefaults = argPD;
/* 909 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 910 */     this._eventManager = argEM;
/* 911 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 912 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 913 */     if (this._properties != null) {
/* 914 */       for (IInventoryJournalProperty relationship : this._properties) {
/* 915 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryJournalExt() {
/* 921 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryJournalExt(IDataModel argExt) {
/* 925 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 930 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 934 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 937 */     super.startTransaction();
/*     */     
/* 939 */     this._propertiesSavepoint = this._properties;
/* 940 */     if (this._properties != null) {
/* 941 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 942 */       Iterator<IDataModel> it = this._properties.iterator();
/* 943 */       while (it.hasNext()) {
/* 944 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 949 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 954 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 957 */     super.rollbackChanges();
/*     */     
/* 959 */     this._properties = this._propertiesSavepoint;
/* 960 */     this._propertiesSavepoint = null;
/* 961 */     if (this._properties != null) {
/* 962 */       Iterator<IDataModel> it = this._properties.iterator();
/* 963 */       while (it.hasNext()) {
/* 964 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 972 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 975 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 978 */     super.commitTransaction();
/*     */     
/* 980 */     this._propertiesSavepoint = this._properties;
/* 981 */     if (this._properties != null) {
/* 982 */       Iterator<IDataModel> it = this._properties.iterator();
/* 983 */       while (it.hasNext()) {
/* 984 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 986 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 990 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 995 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */