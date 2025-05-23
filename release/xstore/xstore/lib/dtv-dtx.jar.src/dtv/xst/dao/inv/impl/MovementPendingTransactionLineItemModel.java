/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryMovementPending;
/*     */ import dtv.xst.dao.inv.IMovementPendingTransactionLineItem;
/*     */ import dtv.xst.dao.inv.IMovementPendingTransactionLineItemProperty;
/*     */ import dtv.xst.dao.inv.MovementPendingTransactionLineItemPropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class MovementPendingTransactionLineItemModel extends MovementPendingTransactionLineItemBaseModel implements IMovementPendingTransactionLineItem {
/*     */   private static final long serialVersionUID = -186541251L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IInventoryMovementPending _inventoryMovementPending; private transient IInventoryMovementPending _inventoryMovementPendingSavepoint; private HistoricalList<IMovementPendingTransactionLineItemProperty> _properties; private transient HistoricalList<IMovementPendingTransactionLineItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new MovementPendingTransactionLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MovementPendingTransactionLineItemDAO getDAO_() {
/*  48 */     return (MovementPendingTransactionLineItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(IMovementPendingTransactionLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<MovementPendingTransactionLineItemPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((MovementPendingTransactionLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 103 */     if (getDAO_().getRetailLocationId() != null) {
/* 104 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 107 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 116 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 117 */       this._events != null && 
/* 118 */       postEventsForChanges()) {
/* 119 */       this._events.post(IMovementPendingTransactionLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 126 */     boolean ev_postable = false;
/*     */     
/* 128 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 129 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 130 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 131 */       ev_postable = true;
/* 132 */       if (this._properties != null) {
/*     */         
/* 134 */         Iterator<MovementPendingTransactionLineItemPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((MovementPendingTransactionLineItemPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 150 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 158 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IMovementPendingTransactionLineItem.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 171 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 172 */       getDAO_().setBusinessDate(argBusinessDate);
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<MovementPendingTransactionLineItemPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((MovementPendingTransactionLineItemPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getWorkstationId() {
/* 192 */     if (getDAO_().getWorkstationId() != null) {
/* 193 */       return getDAO_().getWorkstationId().longValue();
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
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 205 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IMovementPendingTransactionLineItem.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 218 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 219 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<MovementPendingTransactionLineItemPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((MovementPendingTransactionLineItemPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/* 255 */       this._events.post(IMovementPendingTransactionLineItem.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/* 270 */         Iterator<MovementPendingTransactionLineItemPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((MovementPendingTransactionLineItemPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   public int getLineItemSequence() {
/* 286 */     if (getDAO_().getLineItemSequence() != null) {
/* 287 */       return getDAO_().getLineItemSequence().intValue();
/*     */     }
/*     */     
/* 290 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemSequence(int argLineItemSequence) {
/* 299 */     if (setLineItemSequence_noev(argLineItemSequence) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(IMovementPendingTransactionLineItem.SET_LINEITEMSEQUENCE, Integer.valueOf(argLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemSequence_noev(int argLineItemSequence) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getLineItemSequence() == null && Integer.valueOf(argLineItemSequence) != null) || (
/* 312 */       getDAO_().getLineItemSequence() != null && !getDAO_().getLineItemSequence().equals(Integer.valueOf(argLineItemSequence)))) {
/* 313 */       getDAO_().setLineItemSequence(Integer.valueOf(argLineItemSequence));
/* 314 */       ev_postable = true;
/* 315 */       if (this._properties != null) {
/*     */         
/* 317 */         Iterator<MovementPendingTransactionLineItemPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((MovementPendingTransactionLineItemPropertyModel)it.next()).setLineItemSequence_noev(argLineItemSequence);
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
/* 344 */       this._events.post(IMovementPendingTransactionLineItem.SET_CREATEDATE, argCreateDate);
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
/* 378 */       this._events.post(IMovementPendingTransactionLineItem.SET_CREATEUSERID, argCreateUserId);
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
/* 412 */       this._events.post(IMovementPendingTransactionLineItem.SET_UPDATEDATE, argUpdateDate);
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
/* 446 */       this._events.post(IMovementPendingTransactionLineItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public long getOriginalRetailLocationId() {
/* 469 */     if (getDAO_().getOriginalRetailLocationId() != null) {
/* 470 */       return getDAO_().getOriginalRetailLocationId().longValue();
/*     */     }
/*     */     
/* 473 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalRetailLocationId(long argOriginalRetailLocationId) {
/* 482 */     if (setOriginalRetailLocationId_noev(argOriginalRetailLocationId) && 
/* 483 */       this._events != null && 
/* 484 */       postEventsForChanges()) {
/* 485 */       this._events.post(IMovementPendingTransactionLineItem.SET_ORIGINALRETAILLOCATIONID, Long.valueOf(argOriginalRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOriginalRetailLocationId_noev(long argOriginalRetailLocationId) {
/* 492 */     boolean ev_postable = false;
/*     */     
/* 494 */     if ((getDAO_().getOriginalRetailLocationId() == null && Long.valueOf(argOriginalRetailLocationId) != null) || (
/* 495 */       getDAO_().getOriginalRetailLocationId() != null && !getDAO_().getOriginalRetailLocationId().equals(Long.valueOf(argOriginalRetailLocationId)))) {
/* 496 */       getDAO_().setOriginalRetailLocationId(Long.valueOf(argOriginalRetailLocationId));
/* 497 */       ev_postable = true;
/*     */     } 
/*     */     
/* 500 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOriginalWorkstationId() {
/* 508 */     if (getDAO_().getOriginalWorkstationId() != null) {
/* 509 */       return getDAO_().getOriginalWorkstationId().longValue();
/*     */     }
/*     */     
/* 512 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalWorkstationId(long argOriginalWorkstationId) {
/* 521 */     if (setOriginalWorkstationId_noev(argOriginalWorkstationId) && 
/* 522 */       this._events != null && 
/* 523 */       postEventsForChanges()) {
/* 524 */       this._events.post(IMovementPendingTransactionLineItem.SET_ORIGINALWORKSTATIONID, Long.valueOf(argOriginalWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOriginalWorkstationId_noev(long argOriginalWorkstationId) {
/* 531 */     boolean ev_postable = false;
/*     */     
/* 533 */     if ((getDAO_().getOriginalWorkstationId() == null && Long.valueOf(argOriginalWorkstationId) != null) || (
/* 534 */       getDAO_().getOriginalWorkstationId() != null && !getDAO_().getOriginalWorkstationId().equals(Long.valueOf(argOriginalWorkstationId)))) {
/* 535 */       getDAO_().setOriginalWorkstationId(Long.valueOf(argOriginalWorkstationId));
/* 536 */       ev_postable = true;
/*     */     } 
/*     */     
/* 539 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getOriginalBusinessDate() {
/* 547 */     return getDAO_().getOriginalBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalBusinessDate(Date argOriginalBusinessDate) {
/* 555 */     if (setOriginalBusinessDate_noev(argOriginalBusinessDate) && 
/* 556 */       this._events != null && 
/* 557 */       postEventsForChanges()) {
/* 558 */       this._events.post(IMovementPendingTransactionLineItem.SET_ORIGINALBUSINESSDATE, argOriginalBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOriginalBusinessDate_noev(Date argOriginalBusinessDate) {
/* 565 */     boolean ev_postable = false;
/*     */     
/* 567 */     if ((getDAO_().getOriginalBusinessDate() == null && argOriginalBusinessDate != null) || (
/* 568 */       getDAO_().getOriginalBusinessDate() != null && !getDAO_().getOriginalBusinessDate().equals(argOriginalBusinessDate))) {
/* 569 */       getDAO_().setOriginalBusinessDate(argOriginalBusinessDate);
/* 570 */       ev_postable = true;
/*     */     } 
/*     */     
/* 573 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOriginalTransactionSequence() {
/* 581 */     if (getDAO_().getOriginalTransactionSequence() != null) {
/* 582 */       return getDAO_().getOriginalTransactionSequence().longValue();
/*     */     }
/*     */     
/* 585 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalTransactionSequence(long argOriginalTransactionSequence) {
/* 594 */     if (setOriginalTransactionSequence_noev(argOriginalTransactionSequence) && 
/* 595 */       this._events != null && 
/* 596 */       postEventsForChanges()) {
/* 597 */       this._events.post(IMovementPendingTransactionLineItem.SET_ORIGINALTRANSACTIONSEQUENCE, Long.valueOf(argOriginalTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOriginalTransactionSequence_noev(long argOriginalTransactionSequence) {
/* 604 */     boolean ev_postable = false;
/*     */     
/* 606 */     if ((getDAO_().getOriginalTransactionSequence() == null && Long.valueOf(argOriginalTransactionSequence) != null) || (
/* 607 */       getDAO_().getOriginalTransactionSequence() != null && !getDAO_().getOriginalTransactionSequence().equals(Long.valueOf(argOriginalTransactionSequence)))) {
/* 608 */       getDAO_().setOriginalTransactionSequence(Long.valueOf(argOriginalTransactionSequence));
/* 609 */       ev_postable = true;
/*     */     } 
/*     */     
/* 612 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOriginalLineItemSequence() {
/* 620 */     if (getDAO_().getOriginalLineItemSequence() != null) {
/* 621 */       return getDAO_().getOriginalLineItemSequence().intValue();
/*     */     }
/*     */     
/* 624 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalLineItemSequence(int argOriginalLineItemSequence) {
/* 633 */     if (setOriginalLineItemSequence_noev(argOriginalLineItemSequence) && 
/* 634 */       this._events != null && 
/* 635 */       postEventsForChanges()) {
/* 636 */       this._events.post(IMovementPendingTransactionLineItem.SET_ORIGINALLINEITEMSEQUENCE, Integer.valueOf(argOriginalLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOriginalLineItemSequence_noev(int argOriginalLineItemSequence) {
/* 643 */     boolean ev_postable = false;
/*     */     
/* 645 */     if ((getDAO_().getOriginalLineItemSequence() == null && Integer.valueOf(argOriginalLineItemSequence) != null) || (
/* 646 */       getDAO_().getOriginalLineItemSequence() != null && !getDAO_().getOriginalLineItemSequence().equals(Integer.valueOf(argOriginalLineItemSequence)))) {
/* 647 */       getDAO_().setOriginalLineItemSequence(Integer.valueOf(argOriginalLineItemSequence));
/* 648 */       ev_postable = true;
/*     */     } 
/*     */     
/* 651 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantityReconciled() {
/* 659 */     return getDAO_().getQuantityReconciled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantityReconciled(BigDecimal argQuantityReconciled) {
/* 667 */     if (setQuantityReconciled_noev(argQuantityReconciled) && 
/* 668 */       this._events != null && 
/* 669 */       postEventsForChanges()) {
/* 670 */       this._events.post(IMovementPendingTransactionLineItem.SET_QUANTITYRECONCILED, argQuantityReconciled);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuantityReconciled_noev(BigDecimal argQuantityReconciled) {
/* 677 */     boolean ev_postable = false;
/*     */     
/* 679 */     if ((getDAO_().getQuantityReconciled() == null && argQuantityReconciled != null) || (
/* 680 */       getDAO_().getQuantityReconciled() != null && !getDAO_().getQuantityReconciled().equals(argQuantityReconciled))) {
/* 681 */       getDAO_().setQuantityReconciled(argQuantityReconciled);
/* 682 */       ev_postable = true;
/*     */     } 
/*     */     
/* 685 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IMovementPendingTransactionLineItemProperty newProperty(String argPropertyName) {
/* 689 */     MovementPendingTransactionLineItemPropertyId id = new MovementPendingTransactionLineItemPropertyId();
/*     */     
/* 691 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 692 */     id.setBusinessDate(getBusinessDate());
/* 693 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 694 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 695 */     id.setLineItemSequence(Integer.valueOf(getLineItemSequence()));
/* 696 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 698 */     IMovementPendingTransactionLineItemProperty prop = (IMovementPendingTransactionLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IMovementPendingTransactionLineItemProperty.class);
/* 699 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "InventoryMovementPending")
/*     */   public IInventoryMovementPending getInventoryMovementPending() {
/* 711 */     return this._inventoryMovementPending;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInventoryMovementPending(IInventoryMovementPending argInventoryMovementPending) {
/* 716 */     if (argInventoryMovementPending == null) {
/*     */       
/* 718 */       getDAO_().setOriginalRetailLocationId(null);
/* 719 */       getDAO_().setOriginalBusinessDate(null);
/* 720 */       getDAO_().setOriginalWorkstationId(null);
/* 721 */       getDAO_().setOriginalTransactionSequence(null);
/* 722 */       getDAO_().setOriginalLineItemSequence(null);
/* 723 */       if (this._inventoryMovementPending != null)
/*     */       {
/* 725 */         if (postEventsForChanges()) {
/* 726 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryMovementPending));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 731 */       getDAO_().setOriginalRetailLocationId(Long.valueOf(argInventoryMovementPending.getRetailLocationId()));
/* 732 */       getDAO_().setOriginalBusinessDate(argInventoryMovementPending.getBusinessDate());
/* 733 */       getDAO_().setOriginalWorkstationId(Long.valueOf(argInventoryMovementPending.getWorkstationId()));
/* 734 */       getDAO_().setOriginalTransactionSequence(Long.valueOf(argInventoryMovementPending.getTransactionSequence()));
/* 735 */       getDAO_().setOriginalLineItemSequence(Integer.valueOf(argInventoryMovementPending.getLineItemSequence()));
/*     */       
/* 737 */       if (postEventsForChanges()) {
/* 738 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryMovementPending));
/*     */       }
/*     */     } 
/*     */     
/* 742 */     this._inventoryMovementPending = argInventoryMovementPending;
/* 743 */     if (postEventsForChanges()) {
/* 744 */       this._events.post(IMovementPendingTransactionLineItem.SET_INVENTORYMOVEMENTPENDING, argInventoryMovementPending);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IMovementPendingTransactionLineItemProperty> getProperties() {
/* 750 */     if (this._properties == null) {
/* 751 */       this._properties = new HistoricalList(null);
/*     */     }
/* 753 */     return (List<IMovementPendingTransactionLineItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IMovementPendingTransactionLineItemProperty> argProperties) {
/* 757 */     if (this._properties == null) {
/* 758 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 760 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 763 */     for (IMovementPendingTransactionLineItemProperty child : this._properties) {
/* 764 */       MovementPendingTransactionLineItemPropertyModel model = (MovementPendingTransactionLineItemPropertyModel)child;
/* 765 */       model.setOrganizationId_noev(getOrganizationId());
/* 766 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 767 */       model.setBusinessDate_noev(getBusinessDate());
/* 768 */       model.setWorkstationId_noev(getWorkstationId());
/* 769 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 770 */       model.setLineItemSequence_noev(getLineItemSequence());
/* 771 */       if (child instanceof IDataModelImpl) {
/* 772 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 773 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 774 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 775 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 778 */       if (postEventsForChanges()) {
/* 779 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addMovementPendingTransactionLineItemProperty(IMovementPendingTransactionLineItemProperty argMovementPendingTransactionLineItemProperty) {
/* 785 */     if (this._properties == null) {
/* 786 */       this._properties = new HistoricalList(null);
/*     */     }
/* 788 */     argMovementPendingTransactionLineItemProperty.setOrganizationId(getOrganizationId());
/* 789 */     argMovementPendingTransactionLineItemProperty.setRetailLocationId(getRetailLocationId());
/* 790 */     argMovementPendingTransactionLineItemProperty.setBusinessDate(getBusinessDate());
/* 791 */     argMovementPendingTransactionLineItemProperty.setWorkstationId(getWorkstationId());
/* 792 */     argMovementPendingTransactionLineItemProperty.setTransactionSequence(getTransactionSequence());
/* 793 */     argMovementPendingTransactionLineItemProperty.setLineItemSequence(getLineItemSequence());
/* 794 */     if (argMovementPendingTransactionLineItemProperty instanceof IDataModelImpl) {
/* 795 */       IDataAccessObject childDao = ((IDataModelImpl)argMovementPendingTransactionLineItemProperty).getDAO();
/* 796 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 797 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 798 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 803 */     if (postEventsForChanges()) {
/* 804 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMovementPendingTransactionLineItemProperty));
/*     */     }
/*     */     
/* 807 */     this._properties.add(argMovementPendingTransactionLineItemProperty);
/* 808 */     if (postEventsForChanges()) {
/* 809 */       this._events.post(IMovementPendingTransactionLineItem.ADD_PROPERTIES, argMovementPendingTransactionLineItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeMovementPendingTransactionLineItemProperty(IMovementPendingTransactionLineItemProperty argMovementPendingTransactionLineItemProperty) {
/* 814 */     if (this._properties != null) {
/*     */       
/* 816 */       if (postEventsForChanges()) {
/* 817 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMovementPendingTransactionLineItemProperty));
/*     */       }
/* 819 */       this._properties.remove(argMovementPendingTransactionLineItemProperty);
/* 820 */       if (postEventsForChanges()) {
/* 821 */         this._events.post(IMovementPendingTransactionLineItem.REMOVE_PROPERTIES, argMovementPendingTransactionLineItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 828 */     if ("InventoryMovementPending".equals(argFieldId)) {
/* 829 */       return getInventoryMovementPending();
/*     */     }
/* 831 */     if ("Properties".equals(argFieldId)) {
/* 832 */       return getProperties();
/*     */     }
/* 834 */     if ("MovementPendingTransactionLineItemExtension".equals(argFieldId)) {
/* 835 */       return this._myExtension;
/*     */     }
/*     */     
/* 838 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 844 */     if ("InventoryMovementPending".equals(argFieldId)) {
/* 845 */       setInventoryMovementPending((IInventoryMovementPending)argValue);
/*     */     }
/* 847 */     else if ("Properties".equals(argFieldId)) {
/* 848 */       setProperties(changeToList(argValue, IMovementPendingTransactionLineItemProperty.class));
/*     */     }
/* 850 */     else if ("MovementPendingTransactionLineItemExtension".equals(argFieldId)) {
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
/* 865 */     if (this._inventoryMovementPending != null) {
/* 866 */       ((IDataModelImpl)this._inventoryMovementPending).setDependencies(argPD, argEM);
/*     */     }
/* 868 */     if (this._properties != null) {
/* 869 */       for (IMovementPendingTransactionLineItemProperty relationship : this._properties) {
/* 870 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getMovementPendingTransactionLineItemExt() {
/* 876 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setMovementPendingTransactionLineItemExt(IDataModel argExt) {
/* 880 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 885 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 889 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 892 */     super.startTransaction();
/*     */     
/* 894 */     this._inventoryMovementPendingSavepoint = this._inventoryMovementPending;
/* 895 */     if (this._inventoryMovementPending != null) {
/* 896 */       this._inventoryMovementPending.startTransaction();
/*     */     }
/*     */     
/* 899 */     this._propertiesSavepoint = this._properties;
/* 900 */     if (this._properties != null) {
/* 901 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 902 */       Iterator<IDataModel> it = this._properties.iterator();
/* 903 */       while (it.hasNext()) {
/* 904 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 909 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 914 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 917 */     super.rollbackChanges();
/*     */     
/* 919 */     this._inventoryMovementPending = this._inventoryMovementPendingSavepoint;
/* 920 */     this._inventoryMovementPendingSavepoint = null;
/* 921 */     if (this._inventoryMovementPending != null) {
/* 922 */       this._inventoryMovementPending.rollbackChanges();
/*     */     }
/*     */     
/* 925 */     this._properties = this._propertiesSavepoint;
/* 926 */     this._propertiesSavepoint = null;
/* 927 */     if (this._properties != null) {
/* 928 */       Iterator<IDataModel> it = this._properties.iterator();
/* 929 */       while (it.hasNext()) {
/* 930 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 938 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 941 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 944 */     super.commitTransaction();
/*     */     
/* 946 */     this._inventoryMovementPendingSavepoint = this._inventoryMovementPending;
/* 947 */     if (this._inventoryMovementPending != null) {
/* 948 */       this._inventoryMovementPending.commitTransaction();
/*     */     }
/*     */     
/* 951 */     this._propertiesSavepoint = this._properties;
/* 952 */     if (this._properties != null) {
/* 953 */       Iterator<IDataModel> it = this._properties.iterator();
/* 954 */       while (it.hasNext()) {
/* 955 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 957 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 961 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */