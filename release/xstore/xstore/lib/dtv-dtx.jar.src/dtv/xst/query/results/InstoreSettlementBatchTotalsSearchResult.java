/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
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
/*    */ 
/*    */ 
/*    */ public class InstoreSettlementBatchTotalsSearchResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 8675309L;
/*    */   private String organizationID_;
/* 23 */   private BigDecimal totalcount = BigDecimal.ZERO;
/* 24 */   private BigDecimal totalamount = BigDecimal.ZERO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getOrganizationID() {
/* 32 */     return this.organizationID_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getTotalamount() {
/* 41 */     return this.totalamount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getTotalcount() {
/* 50 */     return this.totalcount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOrganizationID(String argOrganizationID) {
/* 59 */     this.organizationID_ = argOrganizationID;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTotalamount(BigDecimal argTotalAmount) {
/* 68 */     this.totalamount = argTotalAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTotalcount(BigDecimal argTotalCount) {
/* 77 */     this.totalcount = argTotalCount;
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
/* 88 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\InstoreSettlementBatchTotalsSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */