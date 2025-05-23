/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.util.NumberUtils;
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TillSummaryGrossSalesResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private BigDecimal totalAmount_ = NumberUtils.ZERO;
/* 24 */   private BigDecimal quantity_ = NumberUtils.ZERO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getQuantity() {
/* 32 */     return this.quantity_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getTotalAmount() {
/* 41 */     return this.totalAmount_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setQuantity(BigDecimal argQuantity) {
/* 50 */     this.quantity_ = argQuantity;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTotalAmount(BigDecimal argTotalAmount) {
/* 59 */     this.totalAmount_ = argTotalAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\TillSummaryGrossSalesResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */