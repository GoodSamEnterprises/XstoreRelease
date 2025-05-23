/*    */ package dtv.pos.framework.reporting;
/*    */ 
/*    */ import dtv.pos.framework.reporting.config.ReportRunConfigHelper;
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
/*    */ public class ReportMgrImpl
/*    */   extends ReportMgr
/*    */ {
/*    */   @Inject
/*    */   private ReportRunConfigHelper _reportRunConfigHelper;
/*    */   
/*    */   protected ReportRunConfigHelper getReportRunConfigHelper() {
/* 26 */     return this._reportRunConfigHelper;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportMgrImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */