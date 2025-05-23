/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import java.util.Date;
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
/*    */ public class UnpostedPayrollResult
/*    */ {
/*    */   private Date businessDate_;
/*    */   private String payrollCategory_;
/*    */   private long partyId_;
/*    */   
/*    */   public UnpostedPayrollResult() {}
/*    */   
/*    */   public UnpostedPayrollResult(Date date, String category, long id) {
/* 36 */     this.businessDate_ = date;
/* 37 */     this.payrollCategory_ = category;
/* 38 */     this.partyId_ = id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getBusinessDate() {
/* 47 */     return this.businessDate_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getPartyId() {
/* 56 */     return this.partyId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPayrollCategory() {
/* 65 */     return this.payrollCategory_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\UnpostedPayrollResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */