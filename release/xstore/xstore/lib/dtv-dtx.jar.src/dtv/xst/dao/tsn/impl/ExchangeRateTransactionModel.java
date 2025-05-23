/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import dtv.xst.dao.tsn.IExchangeRateTransLineItem;
/*     */ import dtv.xst.dao.tsn.IExchangeRateTransaction;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ExchangeRateTransactionModel extends PosTransactionModel implements IExchangeRateTransaction {
/*     */   private static final long serialVersionUID = 988281115L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IExchangeRateTransLineItem> _exchangeRateTransLineItems;
/*     */   private transient HistoricalList<IExchangeRateTransLineItem> _exchangeRateTransLineItemsSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new ExchangeRateTransactionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ExchangeRateTransactionDAO getDAO_() {
/*  40 */     return (ExchangeRateTransactionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  48 */     if (getDAO_().getOrganizationId() != null) {
/*  49 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  52 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  61 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  67 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  70 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._exchangeRateTransLineItems != null) {
/*     */       
/*  73 */       Iterator<ExchangeRateTransLineItemModel> it = this._exchangeRateTransLineItems.iterator();
/*  74 */       while (it.hasNext())
/*     */       {
/*  76 */         ((ExchangeRateTransLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  81 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  89 */     if (getDAO_().getRetailLocationId() != null) {
/*  90 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  93 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 102 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 108 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 111 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/* 112 */       this._exchangeRateTransLineItems != null) {
/*     */       
/* 114 */       Iterator<ExchangeRateTransLineItemModel> it = this._exchangeRateTransLineItems.iterator();
/* 115 */       while (it.hasNext())
/*     */       {
/* 117 */         ((ExchangeRateTransLineItemModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 122 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 130 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 138 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 139 */       this._events != null && 
/* 140 */       postEventsForChanges()) {
/* 141 */       this._events.post(IExchangeRateTransaction.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 148 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 151 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/* 152 */       this._exchangeRateTransLineItems != null) {
/*     */       
/* 154 */       Iterator<ExchangeRateTransLineItemModel> it = this._exchangeRateTransLineItems.iterator();
/* 155 */       while (it.hasNext())
/*     */       {
/* 157 */         ((ExchangeRateTransLineItemModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 162 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 170 */     if (getDAO_().getWorkstationId() != null) {
/* 171 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 174 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 183 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 189 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 192 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/* 193 */       this._exchangeRateTransLineItems != null) {
/*     */       
/* 195 */       Iterator<ExchangeRateTransLineItemModel> it = this._exchangeRateTransLineItems.iterator();
/* 196 */       while (it.hasNext())
/*     */       {
/* 198 */         ((ExchangeRateTransLineItemModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 203 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 211 */     if (getDAO_().getTransactionSequence() != null) {
/* 212 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 215 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 224 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(IExchangeRateTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 234 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 237 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/* 238 */       this._exchangeRateTransLineItems != null) {
/*     */       
/* 240 */       Iterator<ExchangeRateTransLineItemModel> it = this._exchangeRateTransLineItems.iterator();
/* 241 */       while (it.hasNext())
/*     */       {
/* 243 */         ((ExchangeRateTransLineItemModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 248 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 256 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 264 */     if (setCreateDate_noev(argCreateDate) && 
/* 265 */       this._events != null && 
/* 266 */       postEventsForChanges()) {
/* 267 */       this._events.post(IExchangeRateTransaction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 274 */     boolean ev_postable = false;
/*     */     
/* 276 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 277 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 278 */       getDAO_().setCreateDate(argCreateDate);
/* 279 */       ev_postable = true;
/*     */     } 
/*     */     
/* 282 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 290 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 298 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 299 */       this._events != null && 
/* 300 */       postEventsForChanges()) {
/* 301 */       this._events.post(IExchangeRateTransaction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 308 */     boolean ev_postable = false;
/*     */     
/* 310 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 311 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 312 */       getDAO_().setCreateUserId(argCreateUserId);
/* 313 */       ev_postable = true;
/*     */     } 
/*     */     
/* 316 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 324 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 332 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 333 */       this._events != null && 
/* 334 */       postEventsForChanges()) {
/* 335 */       this._events.post(IExchangeRateTransaction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 342 */     boolean ev_postable = false;
/*     */     
/* 344 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 345 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 346 */       getDAO_().setUpdateDate(argUpdateDate);
/* 347 */       ev_postable = true;
/*     */     } 
/*     */     
/* 350 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 358 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 366 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 367 */       this._events != null && 
/* 368 */       postEventsForChanges()) {
/* 369 */       this._events.post(IExchangeRateTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 376 */     boolean ev_postable = false;
/*     */     
/* 378 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 379 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 380 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 381 */       ev_postable = true;
/*     */     } 
/*     */     
/* 384 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "ExchangeRateTransLineItems")
/*     */   public List<IExchangeRateTransLineItem> getExchangeRateTransLineItems() {
/* 393 */     if (this._exchangeRateTransLineItems == null) {
/* 394 */       this._exchangeRateTransLineItems = new HistoricalList(null);
/*     */     }
/* 396 */     return (List<IExchangeRateTransLineItem>)this._exchangeRateTransLineItems;
/*     */   }
/*     */   
/*     */   public void setExchangeRateTransLineItems(List<IExchangeRateTransLineItem> argExchangeRateTransLineItems) {
/* 400 */     if (this._exchangeRateTransLineItems == null) {
/* 401 */       this._exchangeRateTransLineItems = new HistoricalList(argExchangeRateTransLineItems);
/*     */     } else {
/* 403 */       this._exchangeRateTransLineItems.setCurrentList(argExchangeRateTransLineItems);
/*     */     } 
/*     */     
/* 406 */     for (IExchangeRateTransLineItem child : this._exchangeRateTransLineItems) {
/* 407 */       child.setParentTransaction(this);
/*     */     }
/*     */     
/* 410 */     for (IExchangeRateTransLineItem child : this._exchangeRateTransLineItems) {
/* 411 */       ExchangeRateTransLineItemModel model = (ExchangeRateTransLineItemModel)child;
/* 412 */       model.setBusinessDate_noev(getBusinessDate());
/* 413 */       model.setOrganizationId_noev(getOrganizationId());
/* 414 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 415 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 416 */       model.setWorkstationId_noev(getWorkstationId());
/* 417 */       if (child instanceof IDataModelImpl) {
/* 418 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 419 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 420 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 421 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 424 */       if (postEventsForChanges()) {
/* 425 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addExchangeRateTransLineItemImpl(IExchangeRateTransLineItem argExchangeRateTransLineItem) {
/* 432 */     argExchangeRateTransLineItem.setParentTransaction(this);
/* 433 */     if (this._exchangeRateTransLineItems == null) {
/* 434 */       this._exchangeRateTransLineItems = new HistoricalList(null);
/*     */     }
/* 436 */     argExchangeRateTransLineItem.setBusinessDate(getBusinessDate());
/* 437 */     argExchangeRateTransLineItem.setOrganizationId(getOrganizationId());
/* 438 */     argExchangeRateTransLineItem.setRetailLocationId(getRetailLocationId());
/* 439 */     argExchangeRateTransLineItem.setTransactionSequence(getTransactionSequence());
/* 440 */     argExchangeRateTransLineItem.setWorkstationId(getWorkstationId());
/* 441 */     if (argExchangeRateTransLineItem instanceof IDataModelImpl) {
/* 442 */       IDataAccessObject childDao = ((IDataModelImpl)argExchangeRateTransLineItem).getDAO();
/* 443 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 444 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 445 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 450 */     if (postEventsForChanges()) {
/* 451 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argExchangeRateTransLineItem));
/*     */     }
/*     */     
/* 454 */     this._exchangeRateTransLineItems.add(argExchangeRateTransLineItem);
/* 455 */     if (postEventsForChanges()) {
/* 456 */       this._events.post(IExchangeRateTransaction.ADD_EXCHANGERATETRANSLINEITEMS, argExchangeRateTransLineItem);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeExchangeRateTransLineItem(IExchangeRateTransLineItem argExchangeRateTransLineItem) {
/* 461 */     if (this._exchangeRateTransLineItems != null) {
/*     */       
/* 463 */       if (postEventsForChanges()) {
/* 464 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argExchangeRateTransLineItem));
/*     */       }
/* 466 */       this._exchangeRateTransLineItems.remove(argExchangeRateTransLineItem);
/*     */       
/* 468 */       argExchangeRateTransLineItem.setParentTransaction(null);
/* 469 */       if (postEventsForChanges()) {
/* 470 */         this._events.post(IExchangeRateTransaction.REMOVE_EXCHANGERATETRANSLINEITEMS, argExchangeRateTransLineItem);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 477 */     if ("ExchangeRateTransLineItems".equals(argFieldId)) {
/* 478 */       return getExchangeRateTransLineItems();
/*     */     }
/* 480 */     if ("ExchangeRateTransactionExtension".equals(argFieldId)) {
/* 481 */       return this._myExtension;
/*     */     }
/*     */     
/* 484 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 490 */     if ("ExchangeRateTransLineItems".equals(argFieldId)) {
/* 491 */       setExchangeRateTransLineItems(changeToList(argValue, IExchangeRateTransLineItem.class));
/*     */     }
/* 493 */     else if ("ExchangeRateTransactionExtension".equals(argFieldId)) {
/* 494 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 497 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 503 */     super.setDependencies(argPD, argEM);
/* 504 */     if (this._exchangeRateTransLineItems != null) {
/* 505 */       for (IExchangeRateTransLineItem relationship : this._exchangeRateTransLineItems) {
/* 506 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getExchangeRateTransactionExt() {
/* 512 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setExchangeRateTransactionExt(IDataModel argExt) {
/* 516 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 521 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 525 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 528 */     super.startTransaction();
/*     */     
/* 530 */     this._exchangeRateTransLineItemsSavepoint = this._exchangeRateTransLineItems;
/* 531 */     if (this._exchangeRateTransLineItems != null) {
/* 532 */       this._exchangeRateTransLineItemsSavepoint = new HistoricalList((List)this._exchangeRateTransLineItems);
/* 533 */       Iterator<IDataModel> it = this._exchangeRateTransLineItems.iterator();
/* 534 */       while (it.hasNext()) {
/* 535 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 540 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 545 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 548 */     super.rollbackChanges();
/*     */     
/* 550 */     this._exchangeRateTransLineItems = this._exchangeRateTransLineItemsSavepoint;
/* 551 */     this._exchangeRateTransLineItemsSavepoint = null;
/* 552 */     if (this._exchangeRateTransLineItems != null) {
/* 553 */       Iterator<IDataModel> it = this._exchangeRateTransLineItems.iterator();
/* 554 */       while (it.hasNext()) {
/* 555 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 563 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 566 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 569 */     super.commitTransaction();
/*     */     
/* 571 */     this._exchangeRateTransLineItemsSavepoint = this._exchangeRateTransLineItems;
/* 572 */     if (this._exchangeRateTransLineItems != null) {
/* 573 */       Iterator<IDataModel> it = this._exchangeRateTransLineItems.iterator();
/* 574 */       while (it.hasNext()) {
/* 575 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 577 */       this._exchangeRateTransLineItems = new HistoricalList((List)this._exchangeRateTransLineItems);
/*     */     } 
/*     */ 
/*     */     
/* 581 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 586 */     argStream.defaultReadObject();
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
/*     */   public void addExchangeRateTransLineItem(IExchangeRateTransLineItem newItem) {
/* 602 */     synchronized (this) {
/* 603 */       newItem.setLineItemSequence((new Integer(getExchangeRateTransLineItems().size() + 1)).intValue());
/* 604 */       addExchangeRateTransLineItemImpl(newItem);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\ExchangeRateTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */