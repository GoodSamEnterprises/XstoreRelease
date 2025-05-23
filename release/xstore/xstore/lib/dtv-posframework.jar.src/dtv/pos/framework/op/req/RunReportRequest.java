/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.op.req.IRunRequest;
/*    */ import dtv.pos.iframework.reporting.IReportFill;
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
/*    */ public class RunReportRequest
/*    */   implements IRunRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final IReportFill reportFill_;
/*    */   
/*    */   public RunReportRequest(IReportFill argReportFill) {
/* 24 */     this.reportFill_ = argReportFill;
/*    */   }
/*    */   
/*    */   public IReportFill getReportFill() {
/* 28 */     return this.reportFill_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequestType() {
/* 34 */     return OpRequestType.RUN_REPORT.name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\RunReportRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */