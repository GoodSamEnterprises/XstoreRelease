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
/*    */ public class TillSummaryChecksListResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private BigDecimal amount_ = NumberUtils.ZERO;
/*    */ 
/*    */   
/*    */   private String checkNumber_;
/*    */ 
/*    */   
/*    */   private Long transId_;
/*    */ 
/*    */   
/*    */   public BigDecimal getAmount() {
/* 33 */     return this.amount_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCheckNumber() {
/* 42 */     return this.checkNumber_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Long getTransId() {
/* 51 */     return this.transId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAmount(BigDecimal argAmount) {
/* 60 */     this.amount_ = argAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCheckNumber(String argCheckNumber) {
/* 69 */     this.checkNumber_ = argCheckNumber;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTransId(Long argTransId) {
/* 78 */     this.transId_ = argTransId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 84 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\TillSummaryChecksListResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */