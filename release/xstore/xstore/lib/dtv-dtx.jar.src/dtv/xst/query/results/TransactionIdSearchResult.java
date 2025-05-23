/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import java.math.BigDecimal;
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
/*     */ public class TransactionIdSearchResult
/*     */   extends DefaultTransactionSummaryModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String itemId_;
/*     */   private String saleItemType_;
/*     */   private Long lineItemSeq_;
/*     */   private String itemDescription_;
/*     */   private BigDecimal qty_;
/*     */   
/*     */   public String getItemDescription() {
/*  31 */     return this.itemDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  40 */     return this.itemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getLineItemSeq() {
/*  49 */     return this.lineItemSeq_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQty() {
/*  58 */     return this.qty_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSaleItemType() {
/*  67 */     return this.saleItemType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemDescription(String argDesc) {
/*  76 */     this.itemDescription_ = argDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argId) {
/*  85 */     this.itemId_ = argId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemSeq(Long argLineItemSeq) {
/*  94 */     this.lineItemSeq_ = argLineItemSeq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQty(BigDecimal argQty) {
/* 103 */     this.qty_ = argQty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaleItemType(String argSaleItemType) {
/* 112 */     this.saleItemType_ = argSaleItemType;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\TransactionIdSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */