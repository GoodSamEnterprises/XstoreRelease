/*    */ package dtv.pos.framework.systemcycle;
/*    */ 
/*    */ import dtv.pos.common.EnvironmentHelper;
/*    */ import dtv.util.DtvThreadFactory;
/*    */ import java.util.concurrent.Executor;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ import javax.inject.Inject;
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
/*    */ public class UpdateProcessor
/*    */ {
/* 26 */   private static final Logger _logger = Logger.getLogger(UpdateProcessor.class);
/*    */   @Inject
/*    */   private ActivityTracker _activityTracker;
/* 29 */   private final AtomicBoolean _running = new AtomicBoolean(false);
/*    */   
/* 31 */   private final Executor _exec = Executors.newSingleThreadExecutor((ThreadFactory)DtvThreadFactory.makeForDaemons("dtv.pos.environment.UpdateProcessor"));
/*    */   
/*    */   @Inject
/*    */   private EnvironmentHelper _environmentHelper;
/*    */   
/* 36 */   private final AtomicBoolean _messageSent = new AtomicBoolean(false);
/*    */ 
/*    */   
/*    */   public void startIfNeeded() {
/* 40 */     if (this._environmentHelper.isEnvironmentEnabled() && 
/* 41 */       !this._running.getAndSet(true) && 
/* 42 */       this._environmentHelper.hasUpdateGracePeriodExpired()) {
/* 43 */       this._exec.execute(new UpdateWorker());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private class UpdateWorker
/*    */     implements Runnable
/*    */   {
/*    */     private UpdateWorker() {}
/*    */     
/*    */     public void run() {
/* 54 */       if (!UpdateProcessor.this._messageSent.get()) {
/*    */         try {
/* 56 */           UpdateProcessor.this._activityTracker.waitForInactive(UpdateProcessor.this._environmentHelper.getUpdateRequiredExpiryTime());
/* 57 */           UpdateProcessor._logger.info("All registers have completed transactions or required period has expired, asking Xenvironment to apply updates.");
/*    */           
/* 59 */           applyUpdate();
/*    */         }
/* 61 */         catch (Throwable ex) {
/* 62 */           UpdateProcessor._logger.error("CAUGHT EXCEPTION", ex);
/*    */         } finally {
/*    */           
/* 65 */           UpdateProcessor.this._running.set(false);
/*    */         } 
/*    */       }
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     private void applyUpdate() {
/* 75 */       UpdateProcessor.this._environmentHelper.notifyReadyForUpdate();
/* 76 */       UpdateProcessor.this._messageSent.set(true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\UpdateProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */