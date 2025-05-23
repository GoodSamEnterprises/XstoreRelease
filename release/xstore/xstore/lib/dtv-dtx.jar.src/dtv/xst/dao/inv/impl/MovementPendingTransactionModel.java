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
/*     */ import dtv.xst.dao.inv.IMovementPendingTransaction;
/*     */ import dtv.xst.dao.inv.IMovementPendingTransactionLineItem;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import dtv.xst.daocommon.IInventoriedLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class MovementPendingTransactionModel
/*     */   extends PosTransactionModel
/*     */   implements IMovementPendingTransaction {
/*     */   private static final long serialVersionUID = -1469642762L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new MovementPendingTransactionDAO());
/*     */   }
/*     */   
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IMovementPendingTransactionLineItem> _movementPendingTransactionLineItems;
/*     */   private transient HistoricalList<IMovementPendingTransactionLineItem> _movementPendingTransactionLineItemsSavepoint;
/*     */   
/*     */   private MovementPendingTransactionDAO getDAO_() {
/*  40 */     return (MovementPendingTransactionDAO)this._daoImpl;
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
/*  71 */       this._movementPendingTransactionLineItems != null) {
/*     */       
/*  73 */       Iterator<MovementPendingTransactionLineItemModel> it = this._movementPendingTransactionLineItems.iterator();
/*  74 */       while (it.hasNext())
/*     */       {
/*  76 */         ((MovementPendingTransactionLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 112 */       this._movementPendingTransactionLineItems != null) {
/*     */       
/* 114 */       Iterator<MovementPendingTransactionLineItemModel> it = this._movementPendingTransactionLineItems.iterator();
/* 115 */       while (it.hasNext())
/*     */       {
/* 117 */         ((MovementPendingTransactionLineItemModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 141 */       this._events.post(IMovementPendingTransaction.SET_BUSINESSDATE, argBusinessDate);
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
/* 152 */       this._movementPendingTransactionLineItems != null) {
/*     */       
/* 154 */       Iterator<MovementPendingTransactionLineItemModel> it = this._movementPendingTransactionLineItems.iterator();
/* 155 */       while (it.hasNext())
/*     */       {
/* 157 */         ((MovementPendingTransactionLineItemModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/* 193 */       this._movementPendingTransactionLineItems != null) {
/*     */       
/* 195 */       Iterator<MovementPendingTransactionLineItemModel> it = this._movementPendingTransactionLineItems.iterator();
/* 196 */       while (it.hasNext())
/*     */       {
/* 198 */         ((MovementPendingTransactionLineItemModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/* 227 */       this._events.post(IMovementPendingTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/* 238 */       this._movementPendingTransactionLineItems != null) {
/*     */       
/* 240 */       Iterator<MovementPendingTransactionLineItemModel> it = this._movementPendingTransactionLineItems.iterator();
/* 241 */       while (it.hasNext())
/*     */       {
/* 243 */         ((MovementPendingTransactionLineItemModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   @Relationship(name = "MovementPendingTransactionLineItems")
/*     */   public List<IMovementPendingTransactionLineItem> getMovementPendingTransactionLineItems() {
/* 257 */     if (this._movementPendingTransactionLineItems == null) {
/* 258 */       this._movementPendingTransactionLineItems = new HistoricalList(null);
/*     */     }
/* 260 */     return (List<IMovementPendingTransactionLineItem>)this._movementPendingTransactionLineItems;
/*     */   }
/*     */   
/*     */   public void setMovementPendingTransactionLineItems(List<IMovementPendingTransactionLineItem> argMovementPendingTransactionLineItems) {
/* 264 */     if (this._movementPendingTransactionLineItems == null) {
/* 265 */       this._movementPendingTransactionLineItems = new HistoricalList(argMovementPendingTransactionLineItems);
/*     */     } else {
/* 267 */       this._movementPendingTransactionLineItems.setCurrentList(argMovementPendingTransactionLineItems);
/*     */     } 
/*     */     
/* 270 */     for (IMovementPendingTransactionLineItem child : this._movementPendingTransactionLineItems) {
/* 271 */       MovementPendingTransactionLineItemModel model = (MovementPendingTransactionLineItemModel)child;
/* 272 */       model.setOrganizationId_noev(getOrganizationId());
/* 273 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 274 */       model.setWorkstationId_noev(getWorkstationId());
/* 275 */       model.setBusinessDate_noev(getBusinessDate());
/* 276 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 277 */       if (child instanceof IDataModelImpl) {
/* 278 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 279 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 280 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 281 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 284 */       if (postEventsForChanges()) {
/* 285 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void addMovementPendingTransactionLineItemImpl(IMovementPendingTransactionLineItem argMovementPendingTransactionLineItem) {
/* 291 */     if (this._movementPendingTransactionLineItems == null) {
/* 292 */       this._movementPendingTransactionLineItems = new HistoricalList(null);
/*     */     }
/* 294 */     argMovementPendingTransactionLineItem.setOrganizationId(getOrganizationId());
/* 295 */     argMovementPendingTransactionLineItem.setRetailLocationId(getRetailLocationId());
/* 296 */     argMovementPendingTransactionLineItem.setWorkstationId(getWorkstationId());
/* 297 */     argMovementPendingTransactionLineItem.setBusinessDate(getBusinessDate());
/* 298 */     argMovementPendingTransactionLineItem.setTransactionSequence(getTransactionSequence());
/* 299 */     if (argMovementPendingTransactionLineItem instanceof IDataModelImpl) {
/* 300 */       IDataAccessObject childDao = ((IDataModelImpl)argMovementPendingTransactionLineItem).getDAO();
/* 301 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 302 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 303 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 308 */     if (postEventsForChanges()) {
/* 309 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMovementPendingTransactionLineItem));
/*     */     }
/*     */     
/* 312 */     this._movementPendingTransactionLineItems.add(argMovementPendingTransactionLineItem);
/* 313 */     if (postEventsForChanges()) {
/* 314 */       this._events.post(IMovementPendingTransaction.ADD_MOVEMENTPENDINGTRANSACTIONLINEITEMS, argMovementPendingTransactionLineItem);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeMovementPendingTransactionLineItem(IMovementPendingTransactionLineItem argMovementPendingTransactionLineItem) {
/* 319 */     if (this._movementPendingTransactionLineItems != null) {
/*     */       
/* 321 */       if (postEventsForChanges()) {
/* 322 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMovementPendingTransactionLineItem));
/*     */       }
/* 324 */       this._movementPendingTransactionLineItems.remove(argMovementPendingTransactionLineItem);
/* 325 */       if (postEventsForChanges()) {
/* 326 */         this._events.post(IMovementPendingTransaction.REMOVE_MOVEMENTPENDINGTRANSACTIONLINEITEMS, argMovementPendingTransactionLineItem);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 333 */     if ("MovementPendingTransactionLineItems".equals(argFieldId)) {
/* 334 */       return getMovementPendingTransactionLineItems();
/*     */     }
/* 336 */     if ("MovementPendingTransactionExtension".equals(argFieldId)) {
/* 337 */       return this._myExtension;
/*     */     }
/*     */     
/* 340 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 346 */     if ("MovementPendingTransactionLineItems".equals(argFieldId)) {
/* 347 */       setMovementPendingTransactionLineItems(changeToList(argValue, IMovementPendingTransactionLineItem.class));
/*     */     }
/* 349 */     else if ("MovementPendingTransactionExtension".equals(argFieldId)) {
/* 350 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 353 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 359 */     super.setDependencies(argPD, argEM);
/* 360 */     if (this._movementPendingTransactionLineItems != null) {
/* 361 */       for (IMovementPendingTransactionLineItem relationship : this._movementPendingTransactionLineItems) {
/* 362 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getMovementPendingTransactionExt() {
/* 368 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setMovementPendingTransactionExt(IDataModel argExt) {
/* 372 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 377 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 381 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 384 */     super.startTransaction();
/*     */     
/* 386 */     this._movementPendingTransactionLineItemsSavepoint = this._movementPendingTransactionLineItems;
/* 387 */     if (this._movementPendingTransactionLineItems != null) {
/* 388 */       this._movementPendingTransactionLineItemsSavepoint = new HistoricalList((List)this._movementPendingTransactionLineItems);
/* 389 */       Iterator<IDataModel> it = this._movementPendingTransactionLineItems.iterator();
/* 390 */       while (it.hasNext()) {
/* 391 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 396 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 401 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 404 */     super.rollbackChanges();
/*     */     
/* 406 */     this._movementPendingTransactionLineItems = this._movementPendingTransactionLineItemsSavepoint;
/* 407 */     this._movementPendingTransactionLineItemsSavepoint = null;
/* 408 */     if (this._movementPendingTransactionLineItems != null) {
/* 409 */       Iterator<IDataModel> it = this._movementPendingTransactionLineItems.iterator();
/* 410 */       while (it.hasNext()) {
/* 411 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 419 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 422 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 425 */     super.commitTransaction();
/*     */     
/* 427 */     this._movementPendingTransactionLineItemsSavepoint = this._movementPendingTransactionLineItems;
/* 428 */     if (this._movementPendingTransactionLineItems != null) {
/* 429 */       Iterator<IDataModel> it = this._movementPendingTransactionLineItems.iterator();
/* 430 */       while (it.hasNext()) {
/* 431 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 433 */       this._movementPendingTransactionLineItems = new HistoricalList((List)this._movementPendingTransactionLineItems);
/*     */     } 
/*     */ 
/*     */     
/* 437 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 442 */     argStream.defaultReadObject();
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
/*     */   public void addMovementPendingTransactionLineItem(IMovementPendingTransactionLineItem argLineItem) {
/* 458 */     synchronized (this) {
/* 459 */       argLineItem.setLineItemSequence(getMovementPendingTransactionLineItems().size() + 1);
/*     */     } 
/*     */     
/* 462 */     addMovementPendingTransactionLineItemImpl(argLineItem);
/*     */   }
/*     */   
/*     */   public List<? extends IInventoriedLineItem> getInventoriedLineItems() {
/* 466 */     return (List)getMovementPendingTransactionLineItems();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */