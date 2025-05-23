/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.util.DateRange;
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
/*    */ public class PayrollDateRangeResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 8675309L;
/*    */   private Date businessDate_;
/*    */   private DateRange dateRange_;
/*    */   
/*    */   public Date getBusinessDate() {
/* 32 */     return this.businessDate_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DateRange getDateRange() {
/* 41 */     return this.dateRange_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setBusinessDate(Date argDate) {
/* 50 */     this.businessDate_ = argDate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDateRange(DateRange argDateRange) {
/* 59 */     this.dateRange_ = argDateRange;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\PayrollDateRangeResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */