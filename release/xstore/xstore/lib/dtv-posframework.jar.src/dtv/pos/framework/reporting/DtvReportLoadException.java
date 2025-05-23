/*    */ package dtv.pos.framework.reporting;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class DtvReportLoadException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public DtvReportLoadException() {}
/*    */   
/*    */   public DtvReportLoadException(String argMessage) {
/* 32 */     super(argMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DtvReportLoadException(String argMessage, Throwable argCause) {
/* 42 */     super(argMessage);
/* 43 */     initCause(argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DtvReportLoadException(Throwable argCause) {
/* 53 */     initCause(argCause);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\DtvReportLoadException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */