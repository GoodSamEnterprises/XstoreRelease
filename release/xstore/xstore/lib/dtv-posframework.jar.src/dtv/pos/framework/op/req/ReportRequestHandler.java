/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.framework.reporting.fill.XstEventReportFillListenerAdapter;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.reporting.IReportFill;
/*    */ import dtv.pos.iframework.reporting.IReportFillListener;
/*    */ import dtv.pos.iframework.reporting.IReportMgr;
/*    */ import javax.inject.Inject;
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
/*    */ public class ReportRequestHandler
/*    */   implements IOpReqHandler
/*    */ {
/*    */   @Inject
/*    */   private IReportMgr _reportMgr;
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 33 */     RunReportRequest request = (RunReportRequest)argRequest;
/* 34 */     IReportFill rf = request.getReportFill();
/*    */     
/* 36 */     if (!rf.isBackground()) {
/* 37 */       rf.addFillListener((IReportFillListener)new XstEventReportFillListenerAdapter(argListener));
/*    */     }
/*    */     
/* 40 */     this._reportMgr.fillReport(rf);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\ReportRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */