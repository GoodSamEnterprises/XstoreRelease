/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountActivity;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountDetail;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountDetailModel;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountDetailProperty;
/*     */ import dtv.xst.dao.trl.IRetailPriceModifier;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItemNotes;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import dtv.xst.dao.ttr.ITenderLineItem;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CustomerItemAccountDetailBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<ICustomerItemAccountDetailProperty>
/*     */   implements ICustomerItemAccountDetail, ICustomerItemAccountDetailModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public void addCustomerItemAccountActivity(ICustomerItemAccountActivity argCustomerItemAccountActivity) {
/*  28 */     synchronized (this) {
/*  29 */       argCustomerItemAccountActivity.setSequenceNumber((getCustItemAccountActivities().size() + 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PosTransactionId createTransactionId() {
/*  36 */     PosTransactionId transId = new PosTransactionId();
/*     */     
/*  38 */     transId.setOrganizationId(Long.valueOf(getOrganizationId()));
/*  39 */     transId.setBusinessDate(getBusinessDate());
/*  40 */     transId.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  41 */     transId.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  42 */     transId.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*     */     
/*  44 */     return transId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  53 */     if (getRetailLineItem() instanceof ISaleReturnLineItem) {
/*     */       
/*  55 */       ISaleReturnLineItem lineItem = (ISaleReturnLineItem)getRetailLineItem();
/*     */       
/*  57 */       return StringUtils.isEmpty(lineItem.getEnteredDescription()) ? lineItem
/*  58 */         .getItem().getDescription() : lineItem.getEnteredDescription();
/*     */     } 
/*  60 */     if (getRetailLineItem() instanceof ITenderLineItem) {
/*  61 */       return ((ITenderLineItem)getRetailLineItem()).getTender().getDescription();
/*     */     }
/*     */     
/*  64 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  73 */     if (getRetailLineItem() instanceof ISaleReturnLineItem) {
/*  74 */       return ((ISaleReturnLineItem)getRetailLineItem()).getItem().getItemId();
/*     */     }
/*     */     
/*  77 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IRetailTransactionLineItemNotes> getNoteSeq() {
/*  86 */     if (getRetailLineItem() instanceof ISaleReturnLineItem) {
/*  87 */       return ((ISaleReturnLineItem)getRetailLineItem()).getNoteSeq();
/*     */     }
/*     */     
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantity() {
/*  96 */     BigDecimal quantity = BigDecimal.ONE;
/*     */     
/*  98 */     if (getRetailLineItem() instanceof ISaleReturnLineItem) {
/*  99 */       quantity = ((ISaleReturnLineItem)getRetailLineItem()).getQuantity();
/*     */     }
/*     */     
/* 102 */     return quantity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IRetailPriceModifier> getRetailPriceModifiers() {
/* 111 */     if (getRetailLineItem() instanceof ISaleReturnLineItem) {
/* 112 */       return ((ISaleReturnLineItem)getRetailLineItem()).getRetailPriceModifiers();
/*     */     }
/*     */     
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/* 124 */     if (getRetailLineItem() instanceof ISaleReturnLineItem) {
/* 125 */       return ((ISaleReturnLineItem)getRetailLineItem()).getSerialNumber();
/*     */     }
/*     */     
/* 128 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getUnitPrice() {
/* 134 */     if (getRetailLineItem() instanceof ISaleReturnLineItem) {
/* 135 */       return ((ISaleReturnLineItem)getRetailLineItem()).getUnitPrice();
/*     */     }
/* 137 */     if (getRetailLineItem() instanceof ITenderLineItem) {
/* 138 */       return ((ITenderLineItem)getRetailLineItem()).getAmount();
/*     */     }
/*     */     
/* 141 */     return BigDecimal.ZERO;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountDetailBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */