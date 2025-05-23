/*    */ package dtv.pos.framework.reporting.config;
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
/*    */ public class ReportNotFoundException
/*    */   extends ReportingConfigException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public ReportNotFoundException() {}
/*    */   
/*    */   public ReportNotFoundException(String argMessage) {
/* 20 */     super(argMessage);
/*    */   }
/*    */   
/*    */   public ReportNotFoundException(String argMessage, Throwable argCause) {
/* 24 */     super(argMessage, argCause);
/*    */   }
/*    */   
/*    */   public ReportNotFoundException(Throwable argCause) {
/* 28 */     super(argCause);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\config\ReportNotFoundException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */