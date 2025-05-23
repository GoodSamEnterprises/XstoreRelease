/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IObjectId;
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
/*    */ public class InstoreSettlementBatchDetailsSearchResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 8675309L;
/*    */   private String tenderID_;
/* 22 */   private BigDecimal lineCount_ = BigDecimal.ZERO;
/* 23 */   private BigDecimal lineAmount_ = BigDecimal.ZERO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getLineAmount() {
/* 31 */     return this.lineAmount_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getLineCount() {
/* 40 */     return this.lineCount_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IDataModel getPopulatedObject() {
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTenderID() {
/* 61 */     return this.tenderID_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setLineAmount(BigDecimal argLineAmount) {
/* 70 */     this.lineAmount_ = argLineAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setLineCount(BigDecimal argLineCount) {
/* 79 */     this.lineCount_ = argLineCount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTenderID(String argTenderID) {
/* 88 */     this.tenderID_ = argTenderID;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 99 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\InstoreSettlementBatchDetailsSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */