/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import dtv.hardware.config.HardwareConfigMgr;
/*    */ import dtv.pos.framework.reporting.ReportUtils;
/*    */ import dtv.pos.iframework.reporting.IReportFill;
/*    */ import dtv.pos.iframework.reporting.IReportFillListener;
/*    */ import javax.print.attribute.AttributeSet;
/*    */ import javax.print.attribute.PrintRequestAttributeSet;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.apache.pdfbox.pdmodel.PDDocument;
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
/*    */ public class BackgroundPrintFillListener
/*    */   implements IReportFillListener, Runnable
/*    */ {
/*    */   private static int theadIndex_;
/* 26 */   private static final Logger logger_ = Logger.getLogger(BackgroundPrintFillListener.class);
/*    */   private final IReportFill reportFill_;
/*    */   
/*    */   public BackgroundPrintFillListener(IReportFill argReportFill) {
/* 30 */     this.reportFill_ = argReportFill;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void fillCanceled(IReportFill argReport) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void fillFailed(IReportFill argReport) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void fillFinished(IReportFill argReport) {
/* 45 */     if (argReport == this.reportFill_) {
/* 46 */       (new Thread(this, "ReportBackgroundPrintThread-" + ++theadIndex_)).start();
/*    */     } else {
/*    */       
/* 49 */       logger_.warn("unexpected notification");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 55 */     PDDocument print = (PDDocument)this.reportFill_.getResults();
/* 56 */     if (print == null) {
/* 57 */       logger_.warn("nothing to print");
/*    */     } else {
/*    */       
/*    */       try {
/* 61 */         boolean showDialog = HardwareConfigMgr.getInstance().getShowPrinterDialog();
/* 62 */         AttributeSet printerAttributeSet = this.reportFill_.getPrinterAttributeSet();
/* 63 */         PrintRequestAttributeSet printRequestAttributeSet = this.reportFill_.getPrintRequestAttributeSet();
/* 64 */         if (!ReportUtils.printPages(print, showDialog, printerAttributeSet, printRequestAttributeSet, 1)) {
/* 65 */           logger_.warn(this.reportFill_ + " didn't print!!");
/*    */         }
/*    */       }
/* 68 */       catch (Exception ex) {
/* 69 */         logger_.error("CAUGHT EXCEPTION trying to background print", ex);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\BackgroundPrintFillListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */