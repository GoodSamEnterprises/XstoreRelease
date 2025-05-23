/*    */ package dtv.pos.framework.reporting;
/*    */ 
/*    */ import dtv.pos.iframework.reporting.IReportFill;
/*    */ import java.util.concurrent.Callable;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class ReportFillProcessor
/*    */   implements Callable<Boolean>
/*    */ {
/* 22 */   private static final Logger _logger = Logger.getLogger(ReportFillProcessor.class);
/*    */   
/*    */   protected final IReportFill report_;
/*    */ 
/*    */   
/*    */   public ReportFillProcessor(IReportFill argReport) {
/* 28 */     this.report_ = argReport;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean call() throws Exception {
/* 35 */     Boolean result = Boolean.TRUE;
/*    */     try {
/* 37 */       _logger.info("Filling " + this.report_.getDescription() + "...");
/* 38 */       if (this.report_.isBackground()) {
/* 39 */         Thread.currentThread().setPriority(1);
/*    */       } else {
/*    */         
/* 42 */         Thread.currentThread().setPriority(5);
/*    */       } 
/* 44 */       this.report_.setStatus(ReportFillStatus.RUNNING);
/* 45 */       this.report_.run();
/* 46 */       this.report_.setStatus(ReportFillStatus.SUCCESS);
/*    */       
/* 48 */       _logger.info("Finished " + this.report_.getDescription() + "...");
/*    */     }
/* 50 */     catch (Exception ex) {
/* 51 */       result = Boolean.FALSE;
/* 52 */       if (this.report_.getStatus().equals(ReportFillStatus.CANCELED)) {
/*    */         
/* 54 */         _logger.info("User canceled " + this.report_.getDescription() + "...");
/*    */       }
/*    */       else {
/*    */         
/* 58 */         this.report_.setProblem(ex);
/* 59 */         _logger.error("CAUGHT EXCEPTION", ex);
/*    */       } 
/*    */     } 
/* 62 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportFillProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */