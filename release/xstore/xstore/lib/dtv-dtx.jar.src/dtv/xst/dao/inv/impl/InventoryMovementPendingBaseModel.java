/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.xst.dao.inv.IInventoryMovementPending;
/*     */ import dtv.xst.dao.inv.IInventoryMovementPendingDetail;
/*     */ import dtv.xst.dao.inv.IInventoryMovementPendingModel;
/*     */ import dtv.xst.dao.inv.IInventoryMovementPendingProperty;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.xom.IOrderModifier;
/*     */ import dtv.xst.daocommon.IInventoryAccountModifier;
/*     */ import dtv.xst.daocommon.IInventoryLocationModifier;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class InventoryMovementPendingBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IInventoryMovementPendingProperty>
/*     */   implements IInventoryMovementPending, IInventoryMovementPendingModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  31 */   private transient BigDecimal quantityNeedingReconciled_ = null;
/*     */   
/*     */   private transient BigDecimal quantityCurrentlyReconciled_;
/*     */   
/*     */   private transient BigDecimal quantityToAllocate_;
/*     */   private transient boolean incomingInventoryProcessed_ = false;
/*     */   
/*     */   public void addInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/*  39 */     if (argModifier instanceof IInventoryMovementPendingDetail) {
/*  40 */       addInventoryMovementPendingDetail((IInventoryMovementPendingDetail)argModifier);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addInventoryMovementPendingDetail(IInventoryMovementPendingDetail inventoryMovementPendingDetail) {
/*  49 */     synchronized (this) {
/*  50 */       inventoryMovementPendingDetail.setPendingSequence((getMovementPendingDetails().size() + 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getAllInventoryLocationModifiers() {
/*  57 */     return getMovementPendingDetails();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IInventoryAccountModifier getInventoryAccountModifier() {
/*  63 */     if (getSaleLineItem() != null) {
/*  64 */       return getSaleLineItem().getInventoryAccountModifier();
/*     */     }
/*  66 */     if (getInventoryTransactionDetail() != null) {
/*  67 */       return getInventoryTransactionDetail().getInventoryAccountModifier();
/*     */     }
/*     */     
/*  70 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getItemPrice() {
/*  77 */     BigDecimal price = null;
/*     */     
/*  79 */     if (getSaleLineItem() != null) {
/*  80 */       price = getSaleLineItem().getUnitPrice();
/*     */     }
/*     */     
/*  83 */     return price;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getNewInventoryLocationModifiers() {
/*  90 */     HistoricalList<? extends IInventoryLocationModifier> invModifiers = (HistoricalList<? extends IInventoryLocationModifier>)getMovementPendingDetails();
/*     */     
/*  92 */     if (invModifiers.getAddedItems() == null) {
/*  93 */       return new ArrayList<>();
/*     */     }
/*     */     
/*  96 */     return invModifiers.getAddedItems();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOrderModifier getOrderModifier() {
/* 103 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantityCurrentlyReconciled() {
/* 109 */     if (this.quantityCurrentlyReconciled_ == null) {
/* 110 */       this.quantityCurrentlyReconciled_ = BigDecimal.ZERO;
/*     */     }
/*     */     
/* 113 */     return this.quantityCurrentlyReconciled_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantityNeedingReconciled() {
/* 119 */     if (this.quantityNeedingReconciled_ == null) {
/* 120 */       BigDecimal quantity = getQuantity();
/*     */       
/* 122 */       for (IInventoryMovementPendingDetail detail : getMovementPendingDetails()) {
/* 123 */         quantity = quantity.subtract(detail.getQuantity());
/*     */       }
/*     */       
/* 126 */       this.quantityNeedingReconciled_ = quantity;
/*     */     } 
/*     */     
/* 129 */     return this.quantityNeedingReconciled_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantityToAllocate() {
/* 135 */     return this.quantityToAllocate_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReturnReasonCode() {
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransactionDate() {
/* 147 */     ISaleReturnLineItem saleLineItem = getSaleLineItem();
/* 148 */     if (saleLineItem == null) {
/* 149 */       return null;
/*     */     }
/* 151 */     return saleLineItem.getTransactionDate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncomingInventoryProcessed() {
/* 157 */     return this.incomingInventoryProcessed_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 164 */     if (argModifier instanceof IInventoryMovementPendingDetail) {
/* 165 */       removeInventoryMovementPendingDetail((IInventoryMovementPendingDetail)argModifier);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncomingInventoryProcessed(boolean argProcessed) {
/* 172 */     this.incomingInventoryProcessed_ = argProcessed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantityCurrentlyReconciled(BigDecimal argQuantity) {
/* 178 */     if ((this.quantityCurrentlyReconciled_ == null && argQuantity != null) || (this.quantityCurrentlyReconciled_ != null && 
/* 179 */       !this.quantityCurrentlyReconciled_.equals(argQuantity))) {
/* 180 */       this.quantityCurrentlyReconciled_ = argQuantity;
/* 181 */       this._events.post(IInventoryMovementPendingModel.SET_QUANTITY_CURRENTLY_RECONCILED, argQuantity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantityToAllocate(BigDecimal argQuantity) {
/* 188 */     this.quantityToAllocate_ = argQuantity;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */