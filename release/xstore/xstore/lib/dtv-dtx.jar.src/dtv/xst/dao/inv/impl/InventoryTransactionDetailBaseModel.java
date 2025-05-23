/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.xst.dao.inv.IInventoryTransaction;
/*     */ import dtv.xst.dao.inv.IInventoryTransactionDetail;
/*     */ import dtv.xst.dao.inv.IInventoryTransactionDetailModel;
/*     */ import dtv.xst.dao.inv.IInventoryTransactionDetailProperty;
/*     */ import dtv.xst.dao.itm.IItem;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class InventoryTransactionDetailBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IInventoryTransactionDetailProperty>
/*     */   implements IInventoryTransactionDetail, IInventoryTransactionDetailModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private BigDecimal quantityToAllocate_;
/*     */   private transient IInventoryLocationModifier _overrideInvLocMod;
/*     */   
/*     */   public void addInventoryLocationModifier(IInventoryLocationModifier argModifier) {}
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getAllInventoryLocationModifiers() {
/*  42 */     if (this._overrideInvLocMod != null) {
/*  43 */       List<IInventoryLocationModifier> list = new ArrayList<>();
/*  44 */       list.add(this._overrideInvLocMod);
/*  45 */       return list;
/*     */     } 
/*     */     
/*  48 */     return getInventoryDocumentLineItem().getAllInventoryLocationModifiers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IInventoryAccountModifier getInventoryAccountModifier() {
/*  55 */     return (IInventoryAccountModifier)getInventoryDocumentLineItem().getCustomerItemAccountMod();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IItem getItem() {
/*  61 */     return (getInventoryDocumentLineItem() == null) ? null : getInventoryDocumentLineItem().getItem();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  67 */     if (getInventoryDocumentLineItem() != null) {
/*  68 */       return getInventoryDocumentLineItem().getItemId();
/*     */     }
/*     */     
/*  71 */     return getInventoryItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineItemSequence() {
/*  78 */     return getInventoryDetailSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IInventoryLocationModifier> getNewInventoryLocationModifiers() {
/*  84 */     if (this._overrideInvLocMod != null) {
/*  85 */       List<IInventoryLocationModifier> list = new ArrayList<>();
/*  86 */       list.add(this._overrideInvLocMod);
/*  87 */       return list;
/*     */     } 
/*     */     
/*  90 */     return getInventoryDocumentLineItem().getNewInventoryLocationModifiers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOrderModifier getOrderModifier() {
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantityToAllocate() {
/* 103 */     return this.quantityToAllocate_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReturnReasonCode() {
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransactionDate() {
/* 115 */     IInventoryTransaction parentTransaction = getParentTransaction();
/* 116 */     if (parentTransaction != null) {
/* 117 */       return parentTransaction.getTransactionDate();
/*     */     }
/* 119 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncomingInventoryProcessed() {
/* 125 */     return getInventoryDocumentLineItem().isIncomingInventoryProcessed();
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
/* 137 */     getInventoryDocumentLineItem().setIncomingInventoryProcessed(argProcessed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverrideInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 148 */     this._overrideInvLocMod = argModifier;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantityToAllocate(BigDecimal argQuantity) {
/* 154 */     this.quantityToAllocate_ = argQuantity;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionDetailBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */