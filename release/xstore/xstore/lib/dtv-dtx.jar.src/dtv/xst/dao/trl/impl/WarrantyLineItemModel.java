/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.xst.dao.trl.IWarrantyLineItem;
/*     */ import dtv.xst.dao.trl.IWarrantyModifier;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WarrantyLineItemModel
/*     */   extends SaleReturnLineItemModel implements IWarrantyLineItem {
/*     */   private static final long serialVersionUID = 1958048355L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IWarrantyModifier> _warrantyModifiers;
/*     */   private transient HistoricalList<IWarrantyModifier> _warrantyModifiersSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new WarrantyLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WarrantyLineItemDAO getDAO_() {
/*  40 */     return (WarrantyLineItemDAO)this._daoImpl;
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
/*  61 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  62 */       this._events != null && 
/*  63 */       postEventsForChanges()) {
/*  64 */       this._events.post(IWarrantyLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  71 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  74 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*  75 */       this._warrantyModifiers != null) {
/*     */       
/*  77 */       Iterator<WarrantyModifierModel> it = this._warrantyModifiers.iterator();
/*  78 */       while (it.hasNext())
/*     */       {
/*  80 */         ((WarrantyModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  93 */     if (getDAO_().getRetailLocationId() != null) {
/*  94 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  97 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 106 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 107 */       this._events != null && 
/* 108 */       postEventsForChanges()) {
/* 109 */       this._events.post(IWarrantyLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 116 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 119 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/* 120 */       this._warrantyModifiers != null) {
/*     */       
/* 122 */       Iterator<WarrantyModifierModel> it = this._warrantyModifiers.iterator();
/* 123 */       while (it.hasNext())
/*     */       {
/* 125 */         ((WarrantyModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 130 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 138 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 146 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 147 */       this._events != null && 
/* 148 */       postEventsForChanges()) {
/* 149 */       this._events.post(IWarrantyLineItem.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 156 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 159 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/* 160 */       this._warrantyModifiers != null) {
/*     */       
/* 162 */       Iterator<WarrantyModifierModel> it = this._warrantyModifiers.iterator();
/* 163 */       while (it.hasNext())
/*     */       {
/* 165 */         ((WarrantyModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 170 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 178 */     if (getDAO_().getWorkstationId() != null) {
/* 179 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 182 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 191 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(IWarrantyLineItem.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 201 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 204 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/* 205 */       this._warrantyModifiers != null) {
/*     */       
/* 207 */       Iterator<WarrantyModifierModel> it = this._warrantyModifiers.iterator();
/* 208 */       while (it.hasNext())
/*     */       {
/* 210 */         ((WarrantyModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 215 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 223 */     if (getDAO_().getTransactionSequence() != null) {
/* 224 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 227 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 236 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 237 */       this._events != null && 
/* 238 */       postEventsForChanges()) {
/* 239 */       this._events.post(IWarrantyLineItem.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 246 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 249 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/* 250 */       this._warrantyModifiers != null) {
/*     */       
/* 252 */       Iterator<WarrantyModifierModel> it = this._warrantyModifiers.iterator();
/* 253 */       while (it.hasNext())
/*     */       {
/* 255 */         ((WarrantyModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 260 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRetailTransactionLineItemSequence() {
/* 268 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 269 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 272 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 281 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 282 */       this._events != null && 
/* 283 */       postEventsForChanges()) {
/* 284 */       this._events.post(IWarrantyLineItem.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 291 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 294 */     if (super.setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 295 */       this._warrantyModifiers != null) {
/*     */       
/* 297 */       Iterator<WarrantyModifierModel> it = this._warrantyModifiers.iterator();
/* 298 */       while (it.hasNext())
/*     */       {
/* 300 */         ((WarrantyModifierModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "WarrantyModifiers")
/*     */   public List<IWarrantyModifier> getWarrantyModifiers() {
/* 314 */     if (this._warrantyModifiers == null) {
/* 315 */       this._warrantyModifiers = new HistoricalList(null);
/*     */     }
/* 317 */     return (List<IWarrantyModifier>)this._warrantyModifiers;
/*     */   }
/*     */   
/*     */   public void setWarrantyModifiers(List<IWarrantyModifier> argWarrantyModifiers) {
/* 321 */     if (this._warrantyModifiers == null) {
/* 322 */       this._warrantyModifiers = new HistoricalList(argWarrantyModifiers);
/*     */     } else {
/* 324 */       this._warrantyModifiers.setCurrentList(argWarrantyModifiers);
/*     */     } 
/*     */     
/* 327 */     for (IWarrantyModifier child : this._warrantyModifiers) {
/* 328 */       child.setParentLine(this);
/*     */     }
/*     */     
/* 331 */     for (IWarrantyModifier child : this._warrantyModifiers) {
/* 332 */       WarrantyModifierModel model = (WarrantyModifierModel)child;
/* 333 */       model.setOrganizationId_noev(getOrganizationId());
/* 334 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 335 */       model.setBusinessDate_noev(getBusinessDate());
/* 336 */       model.setWorkstationId_noev(getWorkstationId());
/* 337 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 338 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 339 */       if (child instanceof IDataModelImpl) {
/* 340 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 341 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 342 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 343 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 346 */       if (postEventsForChanges()) {
/* 347 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addWarrantyModifierImpl(IWarrantyModifier argWarrantyModifier) {
/* 354 */     argWarrantyModifier.setParentLine(this);
/* 355 */     if (this._warrantyModifiers == null) {
/* 356 */       this._warrantyModifiers = new HistoricalList(null);
/*     */     }
/* 358 */     argWarrantyModifier.setOrganizationId(getOrganizationId());
/* 359 */     argWarrantyModifier.setRetailLocationId(getRetailLocationId());
/* 360 */     argWarrantyModifier.setBusinessDate(getBusinessDate());
/* 361 */     argWarrantyModifier.setWorkstationId(getWorkstationId());
/* 362 */     argWarrantyModifier.setTransactionSequence(getTransactionSequence());
/* 363 */     argWarrantyModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 364 */     if (argWarrantyModifier instanceof IDataModelImpl) {
/* 365 */       IDataAccessObject childDao = ((IDataModelImpl)argWarrantyModifier).getDAO();
/* 366 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 367 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 368 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 373 */     if (postEventsForChanges()) {
/* 374 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyModifier));
/*     */     }
/*     */     
/* 377 */     this._warrantyModifiers.add(argWarrantyModifier);
/* 378 */     if (postEventsForChanges()) {
/* 379 */       this._events.post(IWarrantyLineItem.ADD_WARRANTYMODIFIERS, argWarrantyModifier);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWarrantyModifier(IWarrantyModifier argWarrantyModifier) {
/* 384 */     if (this._warrantyModifiers != null) {
/*     */       
/* 386 */       if (postEventsForChanges()) {
/* 387 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyModifier));
/*     */       }
/* 389 */       this._warrantyModifiers.remove(argWarrantyModifier);
/*     */       
/* 391 */       argWarrantyModifier.setParentLine(null);
/* 392 */       if (postEventsForChanges()) {
/* 393 */         this._events.post(IWarrantyLineItem.REMOVE_WARRANTYMODIFIERS, argWarrantyModifier);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 400 */     if ("WarrantyModifiers".equals(argFieldId)) {
/* 401 */       return getWarrantyModifiers();
/*     */     }
/* 403 */     if ("WarrantyLineItemExtension".equals(argFieldId)) {
/* 404 */       return this._myExtension;
/*     */     }
/*     */     
/* 407 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 413 */     if ("WarrantyModifiers".equals(argFieldId)) {
/* 414 */       setWarrantyModifiers(changeToList(argValue, IWarrantyModifier.class));
/*     */     }
/* 416 */     else if ("WarrantyLineItemExtension".equals(argFieldId)) {
/* 417 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 420 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 426 */     super.setDependencies(argPD, argEM);
/* 427 */     if (this._warrantyModifiers != null) {
/* 428 */       for (IWarrantyModifier relationship : this._warrantyModifiers) {
/* 429 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWarrantyLineItemExt() {
/* 435 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineItemExt(IDataModel argExt) {
/* 439 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 444 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 448 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 451 */     super.startTransaction();
/*     */     
/* 453 */     this._warrantyModifiersSavepoint = this._warrantyModifiers;
/* 454 */     if (this._warrantyModifiers != null) {
/* 455 */       this._warrantyModifiersSavepoint = new HistoricalList((List)this._warrantyModifiers);
/* 456 */       Iterator<IDataModel> it = this._warrantyModifiers.iterator();
/* 457 */       while (it.hasNext()) {
/* 458 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 463 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 468 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 471 */     super.rollbackChanges();
/*     */     
/* 473 */     this._warrantyModifiers = this._warrantyModifiersSavepoint;
/* 474 */     this._warrantyModifiersSavepoint = null;
/* 475 */     if (this._warrantyModifiers != null) {
/* 476 */       Iterator<IDataModel> it = this._warrantyModifiers.iterator();
/* 477 */       while (it.hasNext()) {
/* 478 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 486 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 489 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 492 */     super.commitTransaction();
/*     */     
/* 494 */     this._warrantyModifiersSavepoint = this._warrantyModifiers;
/* 495 */     if (this._warrantyModifiers != null) {
/* 496 */       Iterator<IDataModel> it = this._warrantyModifiers.iterator();
/* 497 */       while (it.hasNext()) {
/* 498 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 500 */       this._warrantyModifiers = new HistoricalList((List)this._warrantyModifiers);
/*     */     } 
/*     */ 
/*     */     
/* 504 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 509 */     argStream.defaultReadObject();
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
/*     */   public void addWarrantyModifier(IWarrantyModifier argWarrantyModifier) {
/* 526 */     synchronized (this) {
/* 527 */       argWarrantyModifier.setWarrantyModifierSequence(getWarrantyModifiers().size() + 1);
/* 528 */       addWarrantyModifierImpl(argWarrantyModifier);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\WarrantyLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */