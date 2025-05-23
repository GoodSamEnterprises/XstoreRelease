/*     */ package dtv.xst.dao.trl.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.tax.ITaxExemption;
/*     */ import dtv.xst.dao.trl.IInventoryDocumentModifier;
/*     */ import dtv.xst.dao.trl.IRetailTransaction;
/*     */ import dtv.xst.dao.trl.IRetailTransactionFlightInfo;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*     */ import dtv.xst.daocommon.IInventoriedLineItem;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class RetailTransactionModel extends PosTransactionModel implements IRetailTransaction {
/*     */   private static final long serialVersionUID = 388307387L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  35 */     setDAO((IDataAccessObject)new RetailTransactionDAO());
/*     */   }
/*     */   private IParty _customerParty; private transient IParty _customerPartySavepoint; private HistoricalList<IInventoryDocumentModifier> _inventoryDocumentModifiers; private transient HistoricalList<IInventoryDocumentModifier> _inventoryDocumentModifiersSavepoint; private ITaxExemption _taxExemption; private transient ITaxExemption _taxExemptionSavepoint; private IRetailTransactionFlightInfo _flightInformation; private transient IRetailTransactionFlightInfo _flightInformationSavepoint; private transient BigDecimal _discountAmount;
/*     */   private transient boolean _officialReceipt;
/*     */   private transient long _officialReceiptSeq;
/*     */   private transient ICustomerLoyaltyCard _loyaltyCard;
/*     */   
/*     */   private RetailTransactionDAO getDAO_() {
/*  43 */     return (RetailTransactionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  51 */     if (getDAO_().getOrganizationId() != null) {
/*  52 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  55 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  64 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  70 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  73 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*  74 */       this._inventoryDocumentModifiers != null) {
/*     */       
/*  76 */       Iterator<InventoryDocumentModifierModel> it = this._inventoryDocumentModifiers.iterator();
/*  77 */       while (it.hasNext())
/*     */       {
/*  79 */         ((InventoryDocumentModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  84 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  92 */     if (getDAO_().getRetailLocationId() != null) {
/*  93 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  96 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 105 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 111 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 114 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/* 115 */       this._inventoryDocumentModifiers != null) {
/*     */       
/* 117 */       Iterator<InventoryDocumentModifierModel> it = this._inventoryDocumentModifiers.iterator();
/* 118 */       while (it.hasNext())
/*     */       {
/* 120 */         ((InventoryDocumentModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 125 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 133 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 141 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 142 */       this._events != null && 
/* 143 */       postEventsForChanges()) {
/* 144 */       this._events.post(IRetailTransaction.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 151 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 154 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/* 155 */       this._inventoryDocumentModifiers != null) {
/*     */       
/* 157 */       Iterator<InventoryDocumentModifierModel> it = this._inventoryDocumentModifiers.iterator();
/* 158 */       while (it.hasNext())
/*     */       {
/* 160 */         ((InventoryDocumentModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 165 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 173 */     if (getDAO_().getWorkstationId() != null) {
/* 174 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 177 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 186 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 192 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 195 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/* 196 */       this._inventoryDocumentModifiers != null) {
/*     */       
/* 198 */       Iterator<InventoryDocumentModifierModel> it = this._inventoryDocumentModifiers.iterator();
/* 199 */       while (it.hasNext())
/*     */       {
/* 201 */         ((InventoryDocumentModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 206 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 214 */     if (getDAO_().getTransactionSequence() != null) {
/* 215 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 218 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 227 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IRetailTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 237 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 240 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/* 241 */       this._inventoryDocumentModifiers != null) {
/*     */       
/* 243 */       Iterator<InventoryDocumentModifierModel> it = this._inventoryDocumentModifiers.iterator();
/* 244 */       while (it.hasNext())
/*     */       {
/* 246 */         ((InventoryDocumentModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 251 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 259 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 267 */     if (setCreateDate_noev(argCreateDate) && 
/* 268 */       this._events != null && 
/* 269 */       postEventsForChanges()) {
/* 270 */       this._events.post(IRetailTransaction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 277 */     boolean ev_postable = false;
/*     */     
/* 279 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 280 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 281 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 293 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 301 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 302 */       this._events != null && 
/* 303 */       postEventsForChanges()) {
/* 304 */       this._events.post(IRetailTransaction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 311 */     boolean ev_postable = false;
/*     */     
/* 313 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 314 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 315 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 327 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 335 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 336 */       this._events != null && 
/* 337 */       postEventsForChanges()) {
/* 338 */       this._events.post(IRetailTransaction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 345 */     boolean ev_postable = false;
/*     */     
/* 347 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 348 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 349 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 361 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 369 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 370 */       this._events != null && 
/* 371 */       postEventsForChanges()) {
/* 372 */       this._events.post(IRetailTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 379 */     boolean ev_postable = false;
/*     */     
/* 381 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 382 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 383 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getLoyaltyCard() {
/* 395 */     return getDAO_().getLoyaltyCard();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoyaltyCard(String argLoyaltyCard) {
/* 403 */     if (setLoyaltyCard_noev(argLoyaltyCard) && 
/* 404 */       this._events != null && 
/* 405 */       postEventsForChanges()) {
/* 406 */       this._events.post(IRetailTransaction.SET_LOYALTYCARD, argLoyaltyCard);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLoyaltyCard_noev(String argLoyaltyCard) {
/* 413 */     boolean ev_postable = false;
/*     */     
/* 415 */     if ((getDAO_().getLoyaltyCard() == null && argLoyaltyCard != null) || (
/* 416 */       getDAO_().getLoyaltyCard() != null && !getDAO_().getLoyaltyCard().equals(argLoyaltyCard))) {
/* 417 */       getDAO_().setLoyaltyCard(argLoyaltyCard);
/* 418 */       ev_postable = true;
/*     */     } 
/*     */     
/* 421 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCustomerPartyId() {
/* 429 */     if (getDAO_().getCustomerPartyId() != null) {
/* 430 */       return getDAO_().getCustomerPartyId().longValue();
/*     */     }
/*     */     
/* 433 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerPartyId(long argCustomerPartyId) {
/* 442 */     if (setCustomerPartyId_noev(argCustomerPartyId) && 
/* 443 */       this._events != null && 
/* 444 */       postEventsForChanges()) {
/* 445 */       this._events.post(IRetailTransaction.SET_CUSTOMERPARTYID, Long.valueOf(argCustomerPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerPartyId_noev(long argCustomerPartyId) {
/* 452 */     boolean ev_postable = false;
/*     */     
/* 454 */     if ((getDAO_().getCustomerPartyId() == null && Long.valueOf(argCustomerPartyId) != null) || (
/* 455 */       getDAO_().getCustomerPartyId() != null && !getDAO_().getCustomerPartyId().equals(Long.valueOf(argCustomerPartyId)))) {
/* 456 */       getDAO_().setCustomerPartyId(Long.valueOf(argCustomerPartyId));
/* 457 */       ev_postable = true;
/*     */     } 
/*     */     
/* 460 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxExemptionId() {
/* 468 */     return getDAO_().getTaxExemptionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxExemptionId(String argTaxExemptionId) {
/* 476 */     if (setTaxExemptionId_noev(argTaxExemptionId) && 
/* 477 */       this._events != null && 
/* 478 */       postEventsForChanges()) {
/* 479 */       this._events.post(IRetailTransaction.SET_TAXEXEMPTIONID, argTaxExemptionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxExemptionId_noev(String argTaxExemptionId) {
/* 486 */     boolean ev_postable = false;
/*     */     
/* 488 */     if ((getDAO_().getTaxExemptionId() == null && argTaxExemptionId != null) || (
/* 489 */       getDAO_().getTaxExemptionId() != null && !getDAO_().getTaxExemptionId().equals(argTaxExemptionId))) {
/* 490 */       getDAO_().setTaxExemptionId(argTaxExemptionId);
/* 491 */       ev_postable = true;
/*     */     } 
/*     */     
/* 494 */     return ev_postable;
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
/*     */   @Relationship(name = "CustomerParty")
/*     */   public IParty getCustomerParty() {
/* 512 */     return this._customerParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomerParty(IParty argCustomerParty) {
/* 517 */     if (argCustomerParty == null) {
/*     */       
/* 519 */       getDAO_().setCustomerPartyId((Long)null);
/* 520 */       if (this._customerParty != null)
/*     */       {
/* 522 */         if (postEventsForChanges()) {
/* 523 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._customerParty));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 528 */       getDAO_().setCustomerPartyId(Long.valueOf(argCustomerParty.getPartyId()));
/*     */       
/* 530 */       if (postEventsForChanges()) {
/* 531 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerParty));
/*     */       }
/*     */     } 
/*     */     
/* 535 */     this._customerParty = argCustomerParty;
/* 536 */     if (postEventsForChanges()) {
/* 537 */       this._events.post(IRetailTransaction.SET_CUSTOMERPARTY, argCustomerParty);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "InventoryDocumentModifiers")
/*     */   public List<IInventoryDocumentModifier> getInventoryDocumentModifiers() {
/* 543 */     if (this._inventoryDocumentModifiers == null) {
/* 544 */       this._inventoryDocumentModifiers = new HistoricalList(null);
/*     */     }
/* 546 */     return (List<IInventoryDocumentModifier>)this._inventoryDocumentModifiers;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentModifiers(List<IInventoryDocumentModifier> argInventoryDocumentModifiers) {
/* 550 */     if (this._inventoryDocumentModifiers == null) {
/* 551 */       this._inventoryDocumentModifiers = new HistoricalList(argInventoryDocumentModifiers);
/*     */     } else {
/* 553 */       this._inventoryDocumentModifiers.setCurrentList(argInventoryDocumentModifiers);
/*     */     } 
/*     */     
/* 556 */     for (IInventoryDocumentModifier child : this._inventoryDocumentModifiers) {
/* 557 */       InventoryDocumentModifierModel model = (InventoryDocumentModifierModel)child;
/* 558 */       model.setOrganizationId_noev(getOrganizationId());
/* 559 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 560 */       model.setBusinessDate_noev(getBusinessDate());
/* 561 */       model.setWorkstationId_noev(getWorkstationId());
/* 562 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 563 */       if (child instanceof IDataModelImpl) {
/* 564 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 565 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 566 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 567 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 570 */       if (postEventsForChanges()) {
/* 571 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void addInventoryDocumentModifierImpl(IInventoryDocumentModifier argInventoryDocumentModifier) {
/* 577 */     if (this._inventoryDocumentModifiers == null) {
/* 578 */       this._inventoryDocumentModifiers = new HistoricalList(null);
/*     */     }
/* 580 */     argInventoryDocumentModifier.setOrganizationId(getOrganizationId());
/* 581 */     argInventoryDocumentModifier.setRetailLocationId(getRetailLocationId());
/* 582 */     argInventoryDocumentModifier.setBusinessDate(getBusinessDate());
/* 583 */     argInventoryDocumentModifier.setWorkstationId(getWorkstationId());
/* 584 */     argInventoryDocumentModifier.setTransactionSequence(getTransactionSequence());
/* 585 */     if (argInventoryDocumentModifier instanceof IDataModelImpl) {
/* 586 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentModifier).getDAO();
/* 587 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 588 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 589 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 594 */     if (postEventsForChanges()) {
/* 595 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentModifier));
/*     */     }
/*     */     
/* 598 */     this._inventoryDocumentModifiers.add(argInventoryDocumentModifier);
/* 599 */     if (postEventsForChanges()) {
/* 600 */       this._events.post(IRetailTransaction.ADD_INVENTORYDOCUMENTMODIFIERS, argInventoryDocumentModifier);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryDocumentModifier(IInventoryDocumentModifier argInventoryDocumentModifier) {
/* 605 */     if (this._inventoryDocumentModifiers != null) {
/*     */       
/* 607 */       if (postEventsForChanges()) {
/* 608 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentModifier));
/*     */       }
/* 610 */       this._inventoryDocumentModifiers.remove(argInventoryDocumentModifier);
/* 611 */       if (postEventsForChanges()) {
/* 612 */         this._events.post(IRetailTransaction.REMOVE_INVENTORYDOCUMENTMODIFIERS, argInventoryDocumentModifier);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "TaxExemption")
/*     */   public ITaxExemption getTaxExemption() {
/* 619 */     return this._taxExemption;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTaxExemption(ITaxExemption argTaxExemption) {
/* 624 */     if (argTaxExemption == null) {
/*     */       
/* 626 */       getDAO_().setTaxExemptionId((String)null);
/* 627 */       if (this._taxExemption != null)
/*     */       {
/* 629 */         if (postEventsForChanges()) {
/* 630 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._taxExemption));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 635 */       getDAO_().setTaxExemptionId(argTaxExemption.getTaxExemptionId());
/*     */       
/* 637 */       if (postEventsForChanges()) {
/* 638 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxExemption));
/*     */       }
/*     */     } 
/*     */     
/* 642 */     this._taxExemption = argTaxExemption;
/* 643 */     if (postEventsForChanges()) {
/* 644 */       this._events.post(IRetailTransaction.SET_TAXEXEMPTION, argTaxExemption);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "FlightInformation")
/*     */   public IRetailTransactionFlightInfo getFlightInformation() {
/* 650 */     return this._flightInformation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFlightInformation(IRetailTransactionFlightInfo argFlightInformation) {
/* 655 */     if (argFlightInformation == null) {
/*     */       
/* 657 */       if (this._flightInformation != null) {
/* 658 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 661 */       if (this._flightInformation != null)
/*     */       {
/* 663 */         if (postEventsForChanges()) {
/* 664 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._flightInformation));
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 670 */       argFlightInformation.setParentTransaction(this);
/*     */ 
/*     */       
/* 673 */       if (postEventsForChanges()) {
/* 674 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFlightInformation));
/*     */       }
/*     */     } 
/*     */     
/* 678 */     this._flightInformation = argFlightInformation;
/* 679 */     if (postEventsForChanges()) {
/* 680 */       this._events.post(IRetailTransaction.SET_FLIGHTINFORMATION, argFlightInformation);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 686 */     if ("CustomerParty".equals(argFieldId)) {
/* 687 */       return getCustomerParty();
/*     */     }
/* 689 */     if ("InventoryDocumentModifiers".equals(argFieldId)) {
/* 690 */       return getInventoryDocumentModifiers();
/*     */     }
/* 692 */     if ("TaxExemption".equals(argFieldId)) {
/* 693 */       return getTaxExemption();
/*     */     }
/* 695 */     if ("FlightInformation".equals(argFieldId)) {
/* 696 */       return getFlightInformation();
/*     */     }
/* 698 */     if ("RetailTransactionExtension".equals(argFieldId)) {
/* 699 */       return this._myExtension;
/*     */     }
/*     */     
/* 702 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 708 */     if ("CustomerParty".equals(argFieldId)) {
/* 709 */       setCustomerParty((IParty)argValue);
/*     */     }
/* 711 */     else if ("InventoryDocumentModifiers".equals(argFieldId)) {
/* 712 */       setInventoryDocumentModifiers(changeToList(argValue, IInventoryDocumentModifier.class));
/*     */     }
/* 714 */     else if ("TaxExemption".equals(argFieldId)) {
/* 715 */       setTaxExemption((ITaxExemption)argValue);
/*     */     }
/* 717 */     else if ("FlightInformation".equals(argFieldId)) {
/* 718 */       setFlightInformation((IRetailTransactionFlightInfo)argValue);
/*     */     }
/* 720 */     else if ("RetailTransactionExtension".equals(argFieldId)) {
/* 721 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 724 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 730 */     super.setDependencies(argPD, argEM);
/* 731 */     if (this._customerParty != null) {
/* 732 */       ((IDataModelImpl)this._customerParty).setDependencies(argPD, argEM);
/*     */     }
/* 734 */     if (this._inventoryDocumentModifiers != null) {
/* 735 */       for (IInventoryDocumentModifier relationship : this._inventoryDocumentModifiers) {
/* 736 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 739 */     if (this._taxExemption != null) {
/* 740 */       ((IDataModelImpl)this._taxExemption).setDependencies(argPD, argEM);
/*     */     }
/* 742 */     if (this._flightInformation != null) {
/* 743 */       ((IDataModelImpl)this._flightInformation).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getRetailTransactionExt() {
/* 748 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionExt(IDataModel argExt) {
/* 752 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 757 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 761 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 764 */     super.startTransaction();
/*     */     
/* 766 */     this._customerPartySavepoint = this._customerParty;
/* 767 */     if (this._customerParty != null) {
/* 768 */       this._customerParty.startTransaction();
/*     */     }
/*     */     
/* 771 */     this._inventoryDocumentModifiersSavepoint = this._inventoryDocumentModifiers;
/* 772 */     if (this._inventoryDocumentModifiers != null) {
/* 773 */       this._inventoryDocumentModifiersSavepoint = new HistoricalList((List)this._inventoryDocumentModifiers);
/* 774 */       Iterator<IDataModel> it = this._inventoryDocumentModifiers.iterator();
/* 775 */       while (it.hasNext()) {
/* 776 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 780 */     this._taxExemptionSavepoint = this._taxExemption;
/* 781 */     if (this._taxExemption != null) {
/* 782 */       this._taxExemption.startTransaction();
/*     */     }
/*     */     
/* 785 */     this._flightInformationSavepoint = this._flightInformation;
/* 786 */     if (this._flightInformation != null) {
/* 787 */       this._flightInformation.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 791 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 796 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 799 */     super.rollbackChanges();
/*     */     
/* 801 */     this._customerParty = this._customerPartySavepoint;
/* 802 */     this._customerPartySavepoint = null;
/* 803 */     if (this._customerParty != null) {
/* 804 */       this._customerParty.rollbackChanges();
/*     */     }
/*     */     
/* 807 */     this._inventoryDocumentModifiers = this._inventoryDocumentModifiersSavepoint;
/* 808 */     this._inventoryDocumentModifiersSavepoint = null;
/* 809 */     if (this._inventoryDocumentModifiers != null) {
/* 810 */       Iterator<IDataModel> it = this._inventoryDocumentModifiers.iterator();
/* 811 */       while (it.hasNext()) {
/* 812 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 816 */     this._taxExemption = this._taxExemptionSavepoint;
/* 817 */     this._taxExemptionSavepoint = null;
/* 818 */     if (this._taxExemption != null) {
/* 819 */       this._taxExemption.rollbackChanges();
/*     */     }
/*     */     
/* 822 */     this._flightInformation = this._flightInformationSavepoint;
/* 823 */     this._flightInformationSavepoint = null;
/* 824 */     if (this._flightInformation != null) {
/* 825 */       this._flightInformation.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 832 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 835 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 838 */     super.commitTransaction();
/*     */     
/* 840 */     this._customerPartySavepoint = this._customerParty;
/* 841 */     if (this._customerParty != null) {
/* 842 */       this._customerParty.commitTransaction();
/*     */     }
/*     */     
/* 845 */     this._inventoryDocumentModifiersSavepoint = this._inventoryDocumentModifiers;
/* 846 */     if (this._inventoryDocumentModifiers != null) {
/* 847 */       Iterator<IDataModel> it = this._inventoryDocumentModifiers.iterator();
/* 848 */       while (it.hasNext()) {
/* 849 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 851 */       this._inventoryDocumentModifiers = new HistoricalList((List)this._inventoryDocumentModifiers);
/*     */     } 
/*     */     
/* 854 */     this._taxExemptionSavepoint = this._taxExemption;
/* 855 */     if (this._taxExemption != null) {
/* 856 */       this._taxExemption.commitTransaction();
/*     */     }
/*     */     
/* 859 */     this._flightInformationSavepoint = this._flightInformation;
/* 860 */     if (this._flightInformation != null) {
/* 861 */       this._flightInformation.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 865 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 870 */     argStream.defaultReadObject();
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
/*     */   public BigDecimal getDiscountAmount() {
/* 888 */     return this._discountAmount;
/*     */   }
/*     */   
/*     */   public void setDiscountAmount(BigDecimal argDiscountAmount) {
/* 892 */     this._discountAmount = argDiscountAmount;
/*     */   }
/*     */   
/*     */   public void setOfficialReceipt(boolean argFlag) {
/* 896 */     this._officialReceipt = argFlag;
/*     */   }
/*     */   
/*     */   public boolean getOfficialReceipt() {
/* 900 */     return this._officialReceipt;
/*     */   }
/*     */   
/*     */   public void setOfficialReceiptSeq(long argSeq) {
/* 904 */     this._officialReceiptSeq = argSeq;
/*     */   }
/*     */   
/*     */   public long getOfficialReceiptSeq() {
/* 908 */     return this._officialReceiptSeq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addInventoryDocumentModifier(IInventoryDocumentModifier newItem) {
/* 916 */     synchronized (this) {
/* 917 */       newItem.setDocumentModifierSequence(getInventoryDocumentModifiers().size() + 1);
/*     */       
/* 919 */       addInventoryDocumentModifierImpl(newItem);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<? extends IInventoriedLineItem> getInventoriedLineItems() {
/* 924 */     List<IInventoriedLineItem> inventoried = new ArrayList<>();
/*     */ 
/*     */     
/* 927 */     for (IRetailTransactionLineItem lineItem : getRetailTransactionLineItems()) {
/* 928 */       if (!lineItem.getVoid() && lineItem instanceof IInventoriedLineItem) {
/* 929 */         inventoried.add((IInventoriedLineItem)lineItem);
/*     */       }
/*     */     } 
/*     */     
/* 933 */     return inventoried;
/*     */   }
/*     */   
/*     */   public ICustomerLoyaltyCard getLoyaltyCardObject() {
/* 937 */     return this._loyaltyCard;
/*     */   }
/*     */   
/* 940 */   private transient String _loyaltyCardProgramId = null;
/*     */   
/*     */   public void setLoyaltyCardObject(ICustomerLoyaltyCard argLoyaltyCard) {
/* 943 */     this._loyaltyCard = argLoyaltyCard;
/*     */     
/* 945 */     if (this._loyaltyCard != null)
/* 946 */       setLoyaltyCard(this._loyaltyCard.getCardNumber()); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */