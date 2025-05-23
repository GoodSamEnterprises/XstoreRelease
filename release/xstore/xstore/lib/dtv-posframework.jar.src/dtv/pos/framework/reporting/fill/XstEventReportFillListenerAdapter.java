/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import dtv.pos.framework.event.XstEvent;
/*    */ import dtv.pos.framework.reporting.type.ReportEventType;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.event.IXstEventType;
/*    */ import dtv.pos.iframework.reporting.IReportFill;
/*    */ import dtv.pos.iframework.reporting.IReportFillListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XstEventReportFillListenerAdapter
/*    */   implements IReportFillListener
/*    */ {
/*    */   private final IXstEventListener listener_;
/*    */   
/*    */   public XstEventReportFillListenerAdapter(IXstEventListener argListener) {
/* 24 */     this.listener_ = argListener;
/*    */   }
/*    */ 
/*    */   
/*    */   public void fillCanceled(IReportFill argReport) {
/* 29 */     XstEvent e = new XstEvent((IXstEventType)ReportEventType.REPORT_CANCELED, argReport, "report failed", this);
/* 30 */     this.listener_.handleXstEvent((IXstEvent)e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fillFailed(IReportFill argReport) {
/* 35 */     XstEvent e = new XstEvent((IXstEventType)ReportEventType.REPORT_FAILED, argReport, "report failed", this);
/* 36 */     this.listener_.handleXstEvent((IXstEvent)e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fillFinished(IReportFill argReport) {
/* 41 */     XstEvent e = new XstEvent((IXstEventType)ReportEventType.REPORT_READY, argReport, "report ready", this);
/* 42 */     this.listener_.handleXstEvent((IXstEvent)e);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\XstEventReportFillListenerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */