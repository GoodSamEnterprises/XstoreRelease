/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.inv.ICarton;
/*     */ import dtv.xst.dao.inv.ICartonModel;
/*     */ import dtv.xst.dao.inv.ICartonProperty;
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
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
/*     */ public abstract class CartonBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<ICartonProperty>
/*     */   implements ICarton, ICartonModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient String tempCartonStatusCode_;
/*     */   private Integer unvoidedLineCount_;
/*     */   
/*     */   public void addInventoryDocumentLineItem(IInventoryDocumentLineItem lineItem) {
/*  35 */     IInventoryDocument cd = getParentDocument();
/*     */     
/*  37 */     if (cd == null) {
/*  38 */       throw new IllegalStateException("Inventory Control Document link must be established before line items can be added.");
/*     */     }
/*     */ 
/*     */     
/*  42 */     synchronized (this) {
/*     */ 
/*     */       
/*  45 */       lineItem.setCartonId(getCartonId());
/*  46 */       cd.addInventoryDocumentLineItem(lineItem);
/*     */ 
/*     */       
/*  49 */       if (!isInactiveStatus(lineItem.getTempStatusCode())) {
/*  50 */         lineItem.setTempStatusCode(getTempCartonStatusCode());
/*     */       }
/*     */       
/*  53 */       this.unvoidedLineCount_ = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTemp() {
/*  60 */     if (this.tempCartonStatusCode_ != null && 
/*  61 */       !ObjectUtils.equivalent(getCartonStatusCode(), this.tempCartonStatusCode_))
/*     */     {
/*  63 */       setCartonStatusCode(this.tempCartonStatusCode_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IInventoryDocumentLineItem> getLineItems() {
/*  70 */     IInventoryDocument parentDoc = getParentDocument();
/*     */     
/*  72 */     if (parentDoc == null) {
/*  73 */       throw new IllegalStateException("Inventory Control Document link must be established before line items can be added.");
/*     */     }
/*     */ 
/*     */     
/*  77 */     List<IInventoryDocumentLineItem> cartonItems = new ArrayList<>();
/*     */     
/*  79 */     for (IInventoryDocumentLineItem docItem : parentDoc.getInventoryDocumentLineItems()) {
/*  80 */       if (getCartonId().equals(docItem.getCartonId())) {
/*  81 */         cartonItems.add(docItem);
/*     */       }
/*     */     } 
/*     */     
/*  85 */     return cartonItems;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTempCartonStatusCode() {
/*  91 */     return this.tempCartonStatusCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUnvoidedLineCount() {
/*  97 */     updateUnvoidedLineCount();
/*  98 */     return this.unvoidedLineCount_.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getUnvoidedQuantityCount() {
/* 104 */     List<IInventoryDocumentLineItem> lines = getLineItems();
/* 105 */     BigDecimal count = BigDecimal.ZERO;
/*     */     
/* 107 */     for (IInventoryDocumentLineItem line : lines) {
/* 108 */       if (!"VOID".equals(line.getTempStatusCode())) {
/* 109 */         count = count.add(NumberUtils.nonNull(line.getExpectedCount()));
/*     */       }
/*     */     } 
/*     */     
/* 113 */     return count.doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempCartonStatusCode(String argNewValue) {
/* 119 */     if (setTempCartonStatusCode_noev(argNewValue)) {
/* 120 */       this._events.post(ICartonModel.SET_TEMPCARTONSTATUSCODE, argNewValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTempCartonStatusCode_noev(String argNewValue) {
/* 131 */     boolean ev_postable = false;
/* 132 */     if ((this.tempCartonStatusCode_ == null && argNewValue != null) || (this.tempCartonStatusCode_ != null && 
/* 133 */       !this.tempCartonStatusCode_.equals(argNewValue))) {
/*     */       
/* 135 */       this.tempCartonStatusCode_ = argNewValue;
/* 136 */       ev_postable = true;
/*     */     } 
/*     */     
/* 139 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startTemp() {
/* 145 */     if (getCartonStatusCode() != null) {
/* 146 */       this.tempCartonStatusCode_ = getCartonStatusCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isInactiveStatus(String argStatus) {
/* 157 */     return ("CLOSED".equalsIgnoreCase(argStatus) || "VOID"
/* 158 */       .equalsIgnoreCase(argStatus));
/*     */   }
/*     */   
/*     */   private void updateUnvoidedLineCount() {
/* 162 */     int count = 0;
/* 163 */     for (IInventoryDocumentLineItem line : getLineItems()) {
/* 164 */       if (!"VOID".equals(line.getTempStatusCode())) {
/* 165 */         count++;
/*     */       }
/*     */     } 
/*     */     
/* 169 */     this.unvoidedLineCount_ = Integer.valueOf(count);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\CartonBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */