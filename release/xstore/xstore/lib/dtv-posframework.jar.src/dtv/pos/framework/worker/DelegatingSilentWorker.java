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
/*    */ public class DelegatingSilentWorker
/*    */   extends WorkerAdapter
/*    */ {
/* 20 */   private static final Logger _logger = Logger.getLogger(DelegatingSilentWorker.class);
/*    */ 
/*    */   
/*    */   private IWorker _delegate;
/*    */ 
/*    */   
/*    */   public String getLongRunningMessage() {
/* 27 */     return this._delegate.getLongRunningMessage();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isApplicable() {
/* 33 */     return this._delegate.isApplicable();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isLongRunning() {
/* 39 */     return this._delegate.isLongRunning();
/*    */   }
/*    */   
/*    */   public void setDelegate(IWorker argDelegate) {
/* 43 */     this._delegate = argDelegate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void handleException(Exception argException) {
/* 50 */     _logger.debug("Worker [" + this._delegate + "] threw an exception while performing work and the exception was handled by [" + 
/* 51 */         getClass().getSimpleName() + "].", argException);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void performWorkImpl() throws Exception {
/* 58 */     this._delegate.performWork();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\DelegatingSilentWorker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */