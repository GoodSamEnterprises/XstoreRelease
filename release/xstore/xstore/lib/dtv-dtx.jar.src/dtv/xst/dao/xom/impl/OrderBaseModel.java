/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.loc.IRetailLocation;
/*     */ import dtv.xst.dao.loc.RetailLocationId;
/*     */ import dtv.xst.dao.xom.IOrder;
/*     */ import dtv.xst.dao.xom.IOrderFee;
/*     */ import dtv.xst.dao.xom.IOrderLine;
/*     */ import dtv.xst.dao.xom.IOrderModel;
/*     */ import dtv.xst.dao.xom.IOrderPayment;
/*     */ import dtv.xst.dao.xom.IOrderProperty;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class OrderBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IOrderProperty>
/*     */   implements IOrderModel, IOrder
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private transient IRetailLocation _orderLocationObject = null;
/*     */   private transient boolean _orderLocationInvalid = false;
/*  29 */   private transient BigDecimal accumulatedRefund = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private transient BigDecimal _totalDeposit = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private transient BigDecimal _fulfilledItemsPayment = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean _hasFulfilledItemFromOtherStore = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean _hasCancelledItem = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   private transient BigDecimal _cancelledItemsTotalRefund = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   private transient BigDecimal cancelledItemsTotalAmt = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private transient BigDecimal cancelledItemsSubTotalAmt = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   private transient BigDecimal cancelledItemsTotalTax = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean shippingDocumentCreated = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean addOrderRefund = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean groupShipment = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean completeOrderTransaction = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOrderFee(IOrderFee argFee) {
/* 130 */     synchronized (this) {
/* 131 */       argFee.setSequence(getFees().size() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOrderPayment(IOrderPayment argPayment) {
/* 139 */     synchronized (this) {
/* 140 */       argPayment.setSequence(getPayments().size() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOrderLine(IOrderLine argLine) {
/* 148 */     synchronized (this) {
/* 149 */       argLine.setSequence(getOrderLines().size() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addOrderRefund() {
/* 156 */     return this.addOrderRefund;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOrderRefund(boolean argAddOrderRefund) {
/* 162 */     this.addOrderRefund = argAddOrderRefund;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean completeOrderTransaction() {
/* 168 */     return this.completeOrderTransaction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void completeOrderTransaction(boolean argCompleteOrderTransaction) {
/* 174 */     this.completeOrderTransaction = argCompleteOrderTransaction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccumulatedRefund() {
/* 180 */     return this.accumulatedRefund;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCancelledItemsSubTotalAmt() {
/* 186 */     return this.cancelledItemsSubTotalAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCancelledItemsTotalAmt() {
/* 192 */     return this.cancelledItemsTotalAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCancelledItemsTotalRefund() {
/* 198 */     return this._cancelledItemsTotalRefund;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCancelledItemsTotalTax() {
/* 204 */     return this.cancelledItemsTotalTax;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getFulfilledItemsPayment() {
/* 210 */     return this._fulfilledItemsPayment;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getGroupShipment() {
/* 216 */     return this.groupShipment;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IRetailLocation getOrderLocationObject() {
/* 222 */     if (!this._orderLocationInvalid && this._orderLocationObject == null && 
/* 223 */       !StringUtils.isEmpty(getOrderLocationId())) {
/*     */       try {
/* 225 */         RetailLocationId locId = new RetailLocationId();
/* 226 */         locId.setRetailLocationId(Long.valueOf(Long.parseLong(getOrderLocationId())));
/* 227 */         this
/* 228 */           ._orderLocationObject = (IRetailLocation)DataFactory.getObjectById((IObjectId)locId);
/*     */       }
/* 230 */       catch (Exception ex) {
/* 231 */         this._orderLocationInvalid = true;
/*     */       } 
/*     */     }
/*     */     
/* 235 */     return this._orderLocationObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getShippingFeeAmount() {
/* 242 */     BigDecimal shippingFee = BigDecimal.ZERO;
/*     */     
/* 244 */     for (IOrderFee fee : getFees()) {
/* 245 */       if (!fee.getVoid() && "SHIPPING".equalsIgnoreCase(fee.getTypeCode())) {
/* 246 */         shippingFee = fee.getAmount();
/*     */       }
/*     */     } 
/* 249 */     return shippingFee;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTotalDeposit() {
/* 255 */     return this._totalDeposit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTotalPaymentAmount() {
/* 262 */     BigDecimal payments = BigDecimal.ZERO;
/*     */     
/* 264 */     for (IOrderPayment payment : getPayments()) {
/* 265 */       if (!payment.getVoid()) {
/* 266 */         payments = payments.add(payment.getAmount());
/*     */       }
/*     */     } 
/* 269 */     return payments;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCancelledItem() {
/* 275 */     return this._hasCancelledItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hasCancelledItem(boolean argHasCancelledItem) {
/* 281 */     this._hasCancelledItem = argHasCancelledItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasFulfilledItemFromOtherStore() {
/* 287 */     return this._hasFulfilledItemFromOtherStore;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hasFulfilledItemFromOtherStore(boolean argHasFulfilledItemFromOtherStore) {
/* 293 */     this._hasFulfilledItemFromOtherStore = argHasFulfilledItemFromOtherStore;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShippingDocumentCreated() {
/* 300 */     return this.shippingDocumentCreated;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccumulatedRefund(BigDecimal argAccumulatedRefund) {
/* 306 */     this.accumulatedRefund = argAccumulatedRefund;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelledItemsSubTotalAmt(BigDecimal argCancelledItemsSubTotalAmt) {
/* 312 */     this.cancelledItemsSubTotalAmt = argCancelledItemsSubTotalAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelledItemsTotalAmt(BigDecimal argCancelledItemsTotalAmt) {
/* 318 */     this.cancelledItemsTotalAmt = argCancelledItemsTotalAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelledItemsTotalRefund(BigDecimal argCancelledItemsTotalRefund) {
/* 324 */     this._cancelledItemsTotalRefund = argCancelledItemsTotalRefund;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelledItemsTotalTax(BigDecimal argCancelledItemsTotalTax) {
/* 330 */     this.cancelledItemsTotalTax = argCancelledItemsTotalTax;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFulfilledItemsPayment(BigDecimal argFulfilledItemsPayment) {
/* 336 */     this._fulfilledItemsPayment = argFulfilledItemsPayment;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupShipment(boolean argGroupShipment) {
/* 342 */     this.groupShipment = argGroupShipment;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShippingDocumentCreated(boolean argShippingDocumentCreated) {
/* 348 */     this.shippingDocumentCreated = argShippingDocumentCreated;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalDeposit(BigDecimal argTotalDeposit) {
/* 354 */     this._totalDeposit = argTotalDeposit;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */