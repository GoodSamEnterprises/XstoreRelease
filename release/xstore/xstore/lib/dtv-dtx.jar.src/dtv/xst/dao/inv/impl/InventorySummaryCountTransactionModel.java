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
/*     */ import dtv.xst.dao.inv.IInventorySummaryCountTransaction;
/*     */ import dtv.xst.dao.inv.IInventorySummaryCountTransactionDetail;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventorySummaryCountTransactionModel extends PosTransactionModel implements IInventorySummaryCountTransaction {
/*     */   private static final long serialVersionUID = -629533383L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IInventorySummaryCountTransactionDetail> _inventorySummaryCountTransactionDetails;
/*     */   private transient HistoricalList<IInventorySummaryCountTransactionDetail> _inventorySummaryCountTransactionDetailsSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new InventorySummaryCountTransactionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventorySummaryCountTransactionDAO getDAO_() {
/*  40 */     return (InventorySummaryCountTransactionDAO)this._daoImpl;
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
/*  71 */       this._inventorySummaryCountTransactionDetails != null) {
/*     */       
/*  73 */       Iterator<InventorySummaryCountTransactionDetailModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/*  74 */       while (it.hasNext())
/*     */       {
/*  76 */         ((InventorySummaryCountTransactionDetailModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 112 */       this._inventorySummaryCountTransactionDetails != null) {
/*     */       
/* 114 */       Iterator<InventorySummaryCountTransactionDetailModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/* 115 */       while (it.hasNext())
/*     */       {
/* 117 */         ((InventorySummaryCountTransactionDetailModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 141 */       this._events.post(IInventorySummaryCountTransaction.SET_BUSINESSDATE, argBusinessDate);
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
/* 152 */       this._inventorySummaryCountTransactionDetails != null) {
/*     */       
/* 154 */       Iterator<InventorySummaryCountTransactionDetailModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/* 155 */       while (it.hasNext())
/*     */       {
/* 157 */         ((InventorySummaryCountTransactionDetailModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/* 193 */       this._inventorySummaryCountTransactionDetails != null) {
/*     */       
/* 195 */       Iterator<InventorySummaryCountTransactionDetailModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/* 196 */       while (it.hasNext())
/*     */       {
/* 198 */         ((InventorySummaryCountTransactionDetailModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/* 227 */       this._events.post(IInventorySummaryCountTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/* 238 */       this._inventorySummaryCountTransactionDetails != null) {
/*     */       
/* 240 */       Iterator<InventorySummaryCountTransactionDetailModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/* 241 */       while (it.hasNext())
/*     */       {
/* 243 */         ((InventorySummaryCountTransactionDetailModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   @Relationship(name = "InventorySummaryCountTransactionDetails")
/*     */   public List<IInventorySummaryCountTransactionDetail> getInventorySummaryCountTransactionDetails() {
/* 257 */     if (this._inventorySummaryCountTransactionDetails == null) {
/* 258 */       this._inventorySummaryCountTransactionDetails = new HistoricalList(null);
/*     */     }
/* 260 */     return (List<IInventorySummaryCountTransactionDetail>)this._inventorySummaryCountTransactionDetails;
/*     */   }
/*     */   
/*     */   public void setInventorySummaryCountTransactionDetails(List<IInventorySummaryCountTransactionDetail> argInventorySummaryCountTransactionDetails) {
/* 264 */     if (this._inventorySummaryCountTransactionDetails == null) {
/* 265 */       this._inventorySummaryCountTransactionDetails = new HistoricalList(argInventorySummaryCountTransactionDetails);
/*     */     } else {
/* 267 */       this._inventorySummaryCountTransactionDetails.setCurrentList(argInventorySummaryCountTransactionDetails);
/*     */     } 
/*     */     
/* 270 */     for (IInventorySummaryCountTransactionDetail child : this._inventorySummaryCountTransactionDetails) {
/* 271 */       child.setParentTransaction(this);
/*     */     }
/*     */     
/* 274 */     for (IInventorySummaryCountTransactionDetail child : this._inventorySummaryCountTransactionDetails) {
/* 275 */       InventorySummaryCountTransactionDetailModel model = (InventorySummaryCountTransactionDetailModel)child;
/* 276 */       model.setOrganizationId_noev(getOrganizationId());
/* 277 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 278 */       model.setWorkstationId_noev(getWorkstationId());
/* 279 */       model.setBusinessDate_noev(getBusinessDate());
/* 280 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 281 */       if (child instanceof IDataModelImpl) {
/* 282 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 283 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 284 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 285 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 288 */       if (postEventsForChanges()) {
/* 289 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addInventorySummaryCountTransactionDetailImpl(IInventorySummaryCountTransactionDetail argInventorySummaryCountTransactionDetail) {
/* 296 */     argInventorySummaryCountTransactionDetail.setParentTransaction(this);
/* 297 */     if (this._inventorySummaryCountTransactionDetails == null) {
/* 298 */       this._inventorySummaryCountTransactionDetails = new HistoricalList(null);
/*     */     }
/* 300 */     argInventorySummaryCountTransactionDetail.setOrganizationId(getOrganizationId());
/* 301 */     argInventorySummaryCountTransactionDetail.setRetailLocationId(getRetailLocationId());
/* 302 */     argInventorySummaryCountTransactionDetail.setWorkstationId(getWorkstationId());
/* 303 */     argInventorySummaryCountTransactionDetail.setBusinessDate(getBusinessDate());
/* 304 */     argInventorySummaryCountTransactionDetail.setTransactionSequence(getTransactionSequence());
/* 305 */     if (argInventorySummaryCountTransactionDetail instanceof IDataModelImpl) {
/* 306 */       IDataAccessObject childDao = ((IDataModelImpl)argInventorySummaryCountTransactionDetail).getDAO();
/* 307 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 308 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 309 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 314 */     if (postEventsForChanges()) {
/* 315 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventorySummaryCountTransactionDetail));
/*     */     }
/*     */     
/* 318 */     this._inventorySummaryCountTransactionDetails.add(argInventorySummaryCountTransactionDetail);
/* 319 */     if (postEventsForChanges()) {
/* 320 */       this._events.post(IInventorySummaryCountTransaction.ADD_INVENTORYSUMMARYCOUNTTRANSACTIONDETAILS, argInventorySummaryCountTransactionDetail);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventorySummaryCountTransactionDetail(IInventorySummaryCountTransactionDetail argInventorySummaryCountTransactionDetail) {
/* 325 */     if (this._inventorySummaryCountTransactionDetails != null) {
/*     */       
/* 327 */       if (postEventsForChanges()) {
/* 328 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventorySummaryCountTransactionDetail));
/*     */       }
/* 330 */       this._inventorySummaryCountTransactionDetails.remove(argInventorySummaryCountTransactionDetail);
/*     */       
/* 332 */       argInventorySummaryCountTransactionDetail.setParentTransaction(null);
/* 333 */       if (postEventsForChanges()) {
/* 334 */         this._events.post(IInventorySummaryCountTransaction.REMOVE_INVENTORYSUMMARYCOUNTTRANSACTIONDETAILS, argInventorySummaryCountTransactionDetail);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 341 */     if ("InventorySummaryCountTransactionDetails".equals(argFieldId)) {
/* 342 */       return getInventorySummaryCountTransactionDetails();
/*     */     }
/* 344 */     if ("InventorySummaryCountTransactionExtension".equals(argFieldId)) {
/* 345 */       return this._myExtension;
/*     */     }
/*     */     
/* 348 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 354 */     if ("InventorySummaryCountTransactionDetails".equals(argFieldId)) {
/* 355 */       setInventorySummaryCountTransactionDetails(changeToList(argValue, IInventorySummaryCountTransactionDetail.class));
/*     */     }
/* 357 */     else if ("InventorySummaryCountTransactionExtension".equals(argFieldId)) {
/* 358 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 361 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 367 */     super.setDependencies(argPD, argEM);
/* 368 */     if (this._inventorySummaryCountTransactionDetails != null) {
/* 369 */       for (IInventorySummaryCountTransactionDetail relationship : this._inventorySummaryCountTransactionDetails) {
/* 370 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventorySummaryCountTransactionExt() {
/* 376 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventorySummaryCountTransactionExt(IDataModel argExt) {
/* 380 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 385 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 389 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 392 */     super.startTransaction();
/*     */     
/* 394 */     this._inventorySummaryCountTransactionDetailsSavepoint = this._inventorySummaryCountTransactionDetails;
/* 395 */     if (this._inventorySummaryCountTransactionDetails != null) {
/* 396 */       this._inventorySummaryCountTransactionDetailsSavepoint = new HistoricalList((List)this._inventorySummaryCountTransactionDetails);
/* 397 */       Iterator<IDataModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/* 398 */       while (it.hasNext()) {
/* 399 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 404 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 409 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 412 */     super.rollbackChanges();
/*     */     
/* 414 */     this._inventorySummaryCountTransactionDetails = this._inventorySummaryCountTransactionDetailsSavepoint;
/* 415 */     this._inventorySummaryCountTransactionDetailsSavepoint = null;
/* 416 */     if (this._inventorySummaryCountTransactionDetails != null) {
/* 417 */       Iterator<IDataModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/* 418 */       while (it.hasNext()) {
/* 419 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 427 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 430 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 433 */     super.commitTransaction();
/*     */     
/* 435 */     this._inventorySummaryCountTransactionDetailsSavepoint = this._inventorySummaryCountTransactionDetails;
/* 436 */     if (this._inventorySummaryCountTransactionDetails != null) {
/* 437 */       Iterator<IDataModel> it = this._inventorySummaryCountTransactionDetails.iterator();
/* 438 */       while (it.hasNext()) {
/* 439 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 441 */       this._inventorySummaryCountTransactionDetails = new HistoricalList((List)this._inventorySummaryCountTransactionDetails);
/*     */     } 
/*     */ 
/*     */     
/* 445 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 450 */     argStream.defaultReadObject();
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
/*     */   public void addInventorySummaryCountTransactionDetail(IInventorySummaryCountTransactionDetail argDetail) {
/* 467 */     synchronized (this) {
/* 468 */       argDetail.setTransLineSequence(getInventorySummaryCountTransactionDetails().size() + 1);
/*     */     } 
/*     */     
/* 471 */     addInventorySummaryCountTransactionDetailImpl(argDetail);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventorySummaryCountTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */