/*    */ package dtv.pos.framework.worker;
/*    */ 
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
/*    */ public abstract class WorkerAdapter
/*    */   implements IWorker
/*    */ {
/* 20 */   private static final Logger _logger = Logger.getLogger(WorkerAdapter.class);
/*    */ 
/*    */   
/*    */   private String _sourceDescription;
/*    */ 
/*    */   
/*    */   public String getLongRunningMessage() {
/* 27 */     return "_pleaseWait";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSourceDescription() {
/* 33 */     return this._sourceDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isApplicable() {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isLongRunning() {
/* 45 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void performWork() throws WorkFailedException {
/* 52 */     logWorkerStatus();
/*    */     
/* 54 */     if (isApplicable()) {
/*    */       try {
/* 56 */         performWorkImpl();
/*    */       }
/* 58 */       catch (Exception ex) {
/* 59 */         _logger.error("An exception was caught performing work.", ex);
/* 60 */         handleException(ex);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSourceDescription(String argLocation) {
/* 68 */     this._sourceDescription = argLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void handleException(Exception argException) {
/* 79 */     if (argException instanceof WorkFailedException) {
/* 80 */       throw (WorkFailedException)argException;
/*    */     }
/*    */     
/* 83 */     throw new WorkFailedException(argException);
/*    */   }
/*    */   
/*    */   protected void logWorkerStatus() {}
/*    */   
/*    */   protected abstract void performWorkImpl() throws Exception;
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\WorkerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */