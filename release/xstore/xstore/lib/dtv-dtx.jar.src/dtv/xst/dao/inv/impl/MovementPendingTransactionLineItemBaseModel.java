/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.xst.dao.inv.IMovementPendingTransactionLineItem;
/*     */ import dtv.xst.dao.inv.IMovementPendingTransactionLineItemProperty;
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.xom.IOrderModifier;
/*     */ import dtv.xst.daocommon.IInventoriedLineItem;
/*     */ import dtv.xst.daocommon.IInventoryAccountModifier;
/*     */ import dtv.xst.daocommon.IInventoryLocationModifier;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MovementPendingTransactionLineItemBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IMovementPendingTransactionLineItemProperty>
/*     */   implements IMovementPendingTransactionLineItem, IInventoriedLineItem
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private BigDecimal quantityToAllocate_;
/*     */   
/*     */   public void addInventoryLocationModifier(IInventoryLocationModifier argModifier) {}
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getAllInventoryLocationModifiers() {
/*  41 */     return getInventoryMovementPending().getAllInventoryLocationModifiers();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IInventoryAccountModifier getInventoryAccountModifier() {
/*  47 */     return getInventoryMovementPending().getInventoryAccountModifier();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IItem getItem() {
/*  53 */     return getInventoryMovementPending().getItem();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  59 */     return getInventoryMovementPending().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getNewInventoryLocationModifiers() {
/*  65 */     return getInventoryMovementPending().getNewInventoryLocationModifiers();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOrderModifier getOrderModifier() {
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantityToAllocate() {
/*  77 */     return this.quantityToAllocate_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReturnReasonCode() {
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncomingInventoryProcessed() {
/*  89 */     return getInventoryMovementPending().isIncomingInventoryProcessed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeInventoryLocationModifier(IInventoryLocationModifier argModifier) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncomingInventoryProcessed(boolean argProcessed) {
/* 101 */     getInventoryMovementPending().setIncomingInventoryProcessed(argProcessed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantityToAllocate(BigDecimal argQuantity) {
/* 107 */     this.quantityToAllocate_ = argQuantity;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionLineItemBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */