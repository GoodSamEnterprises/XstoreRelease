/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import dtv.xst.dao.inv.IInventoryTransaction;
/*     */ import dtv.xst.dao.inv.IInventoryTransactionDetail;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import dtv.xst.daocommon.IInventoriedLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryTransactionModel
/*     */   extends PosTransactionModel implements IInventoryTransaction {
/*     */   private static final long serialVersionUID = 708666370L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  33 */     setDAO((IDataAccessObject)new InventoryTransactionDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   private IInventoryDocument _inventoryDocument;
/*     */   private transient IInventoryDocument _inventoryDocumentSavepoint;
/*     */   
/*     */   private InventoryTransactionDAO getDAO_() {
/*  41 */     return (InventoryTransactionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   private HistoricalList<IInventoryTransactionDetail> _inventoryTransactionDetails;
/*     */   private transient HistoricalList<IInventoryTransactionDetail> _inventoryTransactionDetailsSavepoint;
/*     */   
/*     */   public long getOrganizationId() {
/*  49 */     if (getDAO_().getOrganizationId() != null) {
/*  50 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  53 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  62 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  68 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  71 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*  72 */       this._inventoryTransactionDetails != null) {
/*     */       
/*  74 */       Iterator<InventoryTransactionDetailModel> it = this._inventoryTransactionDetails.iterator();
/*  75 */       while (it.hasNext())
/*     */       {
/*  77 */         ((InventoryTransactionDetailModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  82 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  90 */     if (getDAO_().getRetailLocationId() != null) {
/*  91 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  94 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 103 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 109 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 112 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/* 113 */       this._inventoryTransactionDetails != null) {
/*     */       
/* 115 */       Iterator<InventoryTransactionDetailModel> it = this._inventoryTransactionDetails.iterator();
/* 116 */       while (it.hasNext())
/*     */       {
/* 118 */         ((InventoryTransactionDetailModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 123 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 131 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 139 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 140 */       this._events != null && 
/* 141 */       postEventsForChanges()) {
/* 142 */       this._events.post(IInventoryTransaction.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 149 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 152 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/* 153 */       this._inventoryTransactionDetails != null) {
/*     */       
/* 155 */       Iterator<InventoryTransactionDetailModel> it = this._inventoryTransactionDetails.iterator();
/* 156 */       while (it.hasNext())
/*     */       {
/* 158 */         ((InventoryTransactionDetailModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 163 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 171 */     if (getDAO_().getWorkstationId() != null) {
/* 172 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 175 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 184 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 190 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 193 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/* 194 */       this._inventoryTransactionDetails != null) {
/*     */       
/* 196 */       Iterator<InventoryTransactionDetailModel> it = this._inventoryTransactionDetails.iterator();
/* 197 */       while (it.hasNext())
/*     */       {
/* 199 */         ((InventoryTransactionDetailModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 204 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 212 */     if (getDAO_().getTransactionSequence() != null) {
/* 213 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 216 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 225 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(IInventoryTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 235 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 238 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/* 239 */       this._inventoryTransactionDetails != null) {
/*     */       
/* 241 */       Iterator<InventoryTransactionDetailModel> it = this._inventoryTransactionDetails.iterator();
/* 242 */       while (it.hasNext())
/*     */       {
/* 244 */         ((InventoryTransactionDetailModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 249 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 257 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 265 */     if (setCreateDate_noev(argCreateDate) && 
/* 266 */       this._events != null && 
/* 267 */       postEventsForChanges()) {
/* 268 */       this._events.post(IInventoryTransaction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 275 */     boolean ev_postable = false;
/*     */     
/* 277 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 278 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 279 */       getDAO_().setCreateDate(argCreateDate);
/* 280 */       ev_postable = true;
/*     */     } 
/*     */     
/* 283 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 291 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 299 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(IInventoryTransaction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 312 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 313 */       getDAO_().setCreateUserId(argCreateUserId);
/* 314 */       ev_postable = true;
/*     */     } 
/*     */     
/* 317 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 325 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 333 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 334 */       this._events != null && 
/* 335 */       postEventsForChanges()) {
/* 336 */       this._events.post(IInventoryTransaction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 343 */     boolean ev_postable = false;
/*     */     
/* 345 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 346 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 347 */       getDAO_().setUpdateDate(argUpdateDate);
/* 348 */       ev_postable = true;
/*     */     } 
/*     */     
/* 351 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 359 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 367 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 368 */       this._events != null && 
/* 369 */       postEventsForChanges()) {
/* 370 */       this._events.post(IInventoryTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 377 */     boolean ev_postable = false;
/*     */     
/* 379 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 380 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 381 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 382 */       ev_postable = true;
/*     */     } 
/*     */     
/* 385 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOldStatusCode() {
/* 393 */     return getDAO_().getOldStatusCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOldStatusCode(String argOldStatusCode) {
/* 401 */     if (setOldStatusCode_noev(argOldStatusCode) && 
/* 402 */       this._events != null && 
/* 403 */       postEventsForChanges()) {
/* 404 */       this._events.post(IInventoryTransaction.SET_OLDSTATUSCODE, argOldStatusCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOldStatusCode_noev(String argOldStatusCode) {
/* 411 */     boolean ev_postable = false;
/*     */     
/* 413 */     if ((getDAO_().getOldStatusCode() == null && argOldStatusCode != null) || (
/* 414 */       getDAO_().getOldStatusCode() != null && !getDAO_().getOldStatusCode().equals(argOldStatusCode))) {
/* 415 */       getDAO_().setOldStatusCode(argOldStatusCode);
/* 416 */       ev_postable = true;
/*     */     } 
/*     */     
/* 419 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNewStatusCode() {
/* 427 */     return getDAO_().getNewStatusCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewStatusCode(String argNewStatusCode) {
/* 435 */     if (setNewStatusCode_noev(argNewStatusCode) && 
/* 436 */       this._events != null && 
/* 437 */       postEventsForChanges()) {
/* 438 */       this._events.post(IInventoryTransaction.SET_NEWSTATUSCODE, argNewStatusCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNewStatusCode_noev(String argNewStatusCode) {
/* 445 */     boolean ev_postable = false;
/*     */     
/* 447 */     if ((getDAO_().getNewStatusCode() == null && argNewStatusCode != null) || (
/* 448 */       getDAO_().getNewStatusCode() != null && !getDAO_().getNewStatusCode().equals(argNewStatusCode))) {
/* 449 */       getDAO_().setNewStatusCode(argNewStatusCode);
/* 450 */       ev_postable = true;
/*     */     } 
/*     */     
/* 453 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReasonCode() {
/* 461 */     return getDAO_().getReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 469 */     if (setReasonCode_noev(argReasonCode) && 
/* 470 */       this._events != null && 
/* 471 */       postEventsForChanges()) {
/* 472 */       this._events.post(IInventoryTransaction.SET_REASONCODE, argReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReasonCode_noev(String argReasonCode) {
/* 479 */     boolean ev_postable = false;
/*     */     
/* 481 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/* 482 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/* 483 */       getDAO_().setReasonCode(argReasonCode);
/* 484 */       ev_postable = true;
/*     */     } 
/*     */     
/* 487 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getInventoryDocumentRetailLocationId() {
/* 495 */     if (getDAO_().getInventoryDocumentRetailLocationId() != null) {
/* 496 */       return getDAO_().getInventoryDocumentRetailLocationId().longValue();
/*     */     }
/*     */     
/* 499 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryDocumentRetailLocationId(long argInventoryDocumentRetailLocationId) {
/* 508 */     if (setInventoryDocumentRetailLocationId_noev(argInventoryDocumentRetailLocationId) && 
/* 509 */       this._events != null && 
/* 510 */       postEventsForChanges()) {
/* 511 */       this._events.post(IInventoryTransaction.SET_INVENTORYDOCUMENTRETAILLOCATIONID, Long.valueOf(argInventoryDocumentRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryDocumentRetailLocationId_noev(long argInventoryDocumentRetailLocationId) {
/* 518 */     boolean ev_postable = false;
/*     */     
/* 520 */     if ((getDAO_().getInventoryDocumentRetailLocationId() == null && Long.valueOf(argInventoryDocumentRetailLocationId) != null) || (
/* 521 */       getDAO_().getInventoryDocumentRetailLocationId() != null && !getDAO_().getInventoryDocumentRetailLocationId().equals(Long.valueOf(argInventoryDocumentRetailLocationId)))) {
/* 522 */       getDAO_().setInventoryDocumentRetailLocationId(Long.valueOf(argInventoryDocumentRetailLocationId));
/* 523 */       ev_postable = true;
/*     */     } 
/*     */     
/* 526 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 534 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 542 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 543 */       this._events != null && 
/* 544 */       postEventsForChanges()) {
/* 545 */       this._events.post(IInventoryTransaction.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 552 */     boolean ev_postable = false;
/*     */     
/* 554 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 555 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 556 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 557 */       ev_postable = true;
/*     */     } 
/*     */     
/* 560 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/* 568 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 576 */     if (setDocumentId_noev(argDocumentId) && 
/* 577 */       this._events != null && 
/* 578 */       postEventsForChanges()) {
/* 579 */       this._events.post(IInventoryTransaction.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 586 */     boolean ev_postable = false;
/*     */     
/* 588 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 589 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 590 */       getDAO_().setDocumentId(argDocumentId);
/* 591 */       ev_postable = true;
/*     */     } 
/*     */     
/* 594 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDocumentDate() {
/* 602 */     return getDAO_().getDocumentDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentDate(Date argDocumentDate) {
/* 610 */     if (setDocumentDate_noev(argDocumentDate) && 
/* 611 */       this._events != null && 
/* 612 */       postEventsForChanges()) {
/* 613 */       this._events.post(IInventoryTransaction.SET_DOCUMENTDATE, argDocumentDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentDate_noev(Date argDocumentDate) {
/* 620 */     boolean ev_postable = false;
/*     */     
/* 622 */     if ((getDAO_().getDocumentDate() == null && argDocumentDate != null) || (
/* 623 */       getDAO_().getDocumentDate() != null && !getDAO_().getDocumentDate().equals(argDocumentDate))) {
/* 624 */       getDAO_().setDocumentDate(argDocumentDate);
/* 625 */       ev_postable = true;
/*     */     } 
/*     */     
/* 628 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "InventoryDocument")
/*     */   public IInventoryDocument getInventoryDocument() {
/* 640 */     return this._inventoryDocument;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInventoryDocument(IInventoryDocument argInventoryDocument) {
/* 645 */     if (argInventoryDocument == null) {
/*     */       
/* 647 */       getDAO_().setDocumentId((String)null);
/* 648 */       getDAO_().setDocumentTypeCode((String)null);
/* 649 */       getDAO_().setInventoryDocumentRetailLocationId((Long)null);
/* 650 */       if (this._inventoryDocument != null)
/*     */       {
/* 652 */         if (postEventsForChanges()) {
/* 653 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryDocument));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 658 */       getDAO_().setDocumentId(argInventoryDocument.getDocumentId());
/* 659 */       getDAO_().setDocumentTypeCode(argInventoryDocument.getDocumentTypeCode());
/* 660 */       getDAO_().setInventoryDocumentRetailLocationId(Long.valueOf(argInventoryDocument.getRetailLocationId()));
/*     */       
/* 662 */       if (postEventsForChanges()) {
/* 663 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocument));
/*     */       }
/*     */     } 
/*     */     
/* 667 */     this._inventoryDocument = argInventoryDocument;
/* 668 */     if (postEventsForChanges()) {
/* 669 */       this._events.post(IInventoryTransaction.SET_INVENTORYDOCUMENT, argInventoryDocument);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "InventoryTransactionDetails")
/*     */   public List<IInventoryTransactionDetail> getInventoryTransactionDetails() {
/* 675 */     if (this._inventoryTransactionDetails == null) {
/* 676 */       this._inventoryTransactionDetails = new HistoricalList(null);
/*     */     }
/* 678 */     return (List<IInventoryTransactionDetail>)this._inventoryTransactionDetails;
/*     */   }
/*     */   
/*     */   public void setInventoryTransactionDetails(List<IInventoryTransactionDetail> argInventoryTransactionDetails) {
/* 682 */     if (this._inventoryTransactionDetails == null) {
/* 683 */       this._inventoryTransactionDetails = new HistoricalList(argInventoryTransactionDetails);
/*     */     } else {
/* 685 */       this._inventoryTransactionDetails.setCurrentList(argInventoryTransactionDetails);
/*     */     } 
/*     */     
/* 688 */     for (IInventoryTransactionDetail child : this._inventoryTransactionDetails) {
/* 689 */       child.setParentTransaction(this);
/*     */     }
/*     */     
/* 692 */     for (IInventoryTransactionDetail child : this._inventoryTransactionDetails) {
/* 693 */       InventoryTransactionDetailModel model = (InventoryTransactionDetailModel)child;
/* 694 */       model.setOrganizationId_noev(getOrganizationId());
/* 695 */       model.setWorkstationId_noev(getWorkstationId());
/* 696 */       model.setBusinessDate_noev(getBusinessDate());
/* 697 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 698 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 699 */       if (child instanceof IDataModelImpl) {
/* 700 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 701 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 702 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 703 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 706 */       if (postEventsForChanges()) {
/* 707 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addInventoryTransactionDetailImpl(IInventoryTransactionDetail argInventoryTransactionDetail) {
/* 714 */     argInventoryTransactionDetail.setParentTransaction(this);
/* 715 */     if (this._inventoryTransactionDetails == null) {
/* 716 */       this._inventoryTransactionDetails = new HistoricalList(null);
/*     */     }
/* 718 */     argInventoryTransactionDetail.setOrganizationId(getOrganizationId());
/* 719 */     argInventoryTransactionDetail.setWorkstationId(getWorkstationId());
/* 720 */     argInventoryTransactionDetail.setBusinessDate(getBusinessDate());
/* 721 */     argInventoryTransactionDetail.setRetailLocationId(getRetailLocationId());
/* 722 */     argInventoryTransactionDetail.setTransactionSequence(getTransactionSequence());
/* 723 */     if (argInventoryTransactionDetail instanceof IDataModelImpl) {
/* 724 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryTransactionDetail).getDAO();
/* 725 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 726 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 727 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 732 */     if (postEventsForChanges()) {
/* 733 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryTransactionDetail));
/*     */     }
/*     */     
/* 736 */     this._inventoryTransactionDetails.add(argInventoryTransactionDetail);
/* 737 */     if (postEventsForChanges()) {
/* 738 */       this._events.post(IInventoryTransaction.ADD_INVENTORYTRANSACTIONDETAILS, argInventoryTransactionDetail);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryTransactionDetail(IInventoryTransactionDetail argInventoryTransactionDetail) {
/* 743 */     if (this._inventoryTransactionDetails != null) {
/*     */       
/* 745 */       if (postEventsForChanges()) {
/* 746 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryTransactionDetail));
/*     */       }
/* 748 */       this._inventoryTransactionDetails.remove(argInventoryTransactionDetail);
/*     */       
/* 750 */       argInventoryTransactionDetail.setParentTransaction(null);
/* 751 */       if (postEventsForChanges()) {
/* 752 */         this._events.post(IInventoryTransaction.REMOVE_INVENTORYTRANSACTIONDETAILS, argInventoryTransactionDetail);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 759 */     if ("InventoryDocument".equals(argFieldId)) {
/* 760 */       return getInventoryDocument();
/*     */     }
/* 762 */     if ("InventoryTransactionDetails".equals(argFieldId)) {
/* 763 */       return getInventoryTransactionDetails();
/*     */     }
/* 765 */     if ("InventoryTransactionExtension".equals(argFieldId)) {
/* 766 */       return this._myExtension;
/*     */     }
/*     */     
/* 769 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 775 */     if ("InventoryDocument".equals(argFieldId)) {
/* 776 */       setInventoryDocument((IInventoryDocument)argValue);
/*     */     }
/* 778 */     else if ("InventoryTransactionDetails".equals(argFieldId)) {
/* 779 */       setInventoryTransactionDetails(changeToList(argValue, IInventoryTransactionDetail.class));
/*     */     }
/* 781 */     else if ("InventoryTransactionExtension".equals(argFieldId)) {
/* 782 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 785 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 791 */     super.setDependencies(argPD, argEM);
/* 792 */     if (this._inventoryDocument != null) {
/* 793 */       ((IDataModelImpl)this._inventoryDocument).setDependencies(argPD, argEM);
/*     */     }
/* 795 */     if (this._inventoryTransactionDetails != null) {
/* 796 */       for (IInventoryTransactionDetail relationship : this._inventoryTransactionDetails) {
/* 797 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryTransactionExt() {
/* 803 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryTransactionExt(IDataModel argExt) {
/* 807 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 812 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 816 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 819 */     super.startTransaction();
/*     */     
/* 821 */     this._inventoryDocumentSavepoint = this._inventoryDocument;
/* 822 */     if (this._inventoryDocument != null) {
/* 823 */       this._inventoryDocument.startTransaction();
/*     */     }
/*     */     
/* 826 */     this._inventoryTransactionDetailsSavepoint = this._inventoryTransactionDetails;
/* 827 */     if (this._inventoryTransactionDetails != null) {
/* 828 */       this._inventoryTransactionDetailsSavepoint = new HistoricalList((List)this._inventoryTransactionDetails);
/* 829 */       Iterator<IDataModel> it = this._inventoryTransactionDetails.iterator();
/* 830 */       while (it.hasNext()) {
/* 831 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 836 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 841 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 844 */     super.rollbackChanges();
/*     */     
/* 846 */     this._inventoryDocument = this._inventoryDocumentSavepoint;
/* 847 */     this._inventoryDocumentSavepoint = null;
/* 848 */     if (this._inventoryDocument != null) {
/* 849 */       this._inventoryDocument.rollbackChanges();
/*     */     }
/*     */     
/* 852 */     this._inventoryTransactionDetails = this._inventoryTransactionDetailsSavepoint;
/* 853 */     this._inventoryTransactionDetailsSavepoint = null;
/* 854 */     if (this._inventoryTransactionDetails != null) {
/* 855 */       Iterator<IDataModel> it = this._inventoryTransactionDetails.iterator();
/* 856 */       while (it.hasNext()) {
/* 857 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 865 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 868 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 871 */     super.commitTransaction();
/*     */     
/* 873 */     this._inventoryDocumentSavepoint = this._inventoryDocument;
/* 874 */     if (this._inventoryDocument != null) {
/* 875 */       this._inventoryDocument.commitTransaction();
/*     */     }
/*     */     
/* 878 */     this._inventoryTransactionDetailsSavepoint = this._inventoryTransactionDetails;
/* 879 */     if (this._inventoryTransactionDetails != null) {
/* 880 */       Iterator<IDataModel> it = this._inventoryTransactionDetails.iterator();
/* 881 */       while (it.hasNext()) {
/* 882 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 884 */       this._inventoryTransactionDetails = new HistoricalList((List)this._inventoryTransactionDetails);
/*     */     } 
/*     */ 
/*     */     
/* 888 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 893 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addInventoryTransactionDetail(IInventoryTransactionDetail inventoryTransactionDetail) {
/* 911 */     synchronized (this) {
/* 912 */       inventoryTransactionDetail.setInventoryDetailSequence(getInventoryTransactionDetails().size() + 1);
/*     */     } 
/*     */     
/* 915 */     addInventoryTransactionDetailImpl(inventoryTransactionDetail);
/*     */   }
/*     */   
/*     */   public List<? extends IInventoriedLineItem> getInventoriedLineItems() {
/* 919 */     return (List)getInventoryTransactionDetails();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */