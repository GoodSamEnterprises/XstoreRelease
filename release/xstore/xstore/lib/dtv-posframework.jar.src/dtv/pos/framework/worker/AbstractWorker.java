/*    */ package dtv.pos.framework.worker;
/*    */ 
/*    */ import dtv.pos.framework.logging.ProcessLogger;
/*    */ import dtv.pos.framework.scope.DefaultScope;
/*    */ import dtv.pos.framework.scope.ValueKey;
/*    */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*    */ import dtv.pos.iframework.security.StationState;
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
/*    */ 
/*    */ public abstract class AbstractWorker
/*    */   extends WorkerAdapter
/*    */ {
/*    */   @Inject
/*    */   private DefaultScope _defaultScope;
/*    */   @Inject
/*    */   private ProcessLogger _flowLogger;
/*    */   @Inject
/*    */   protected StationState _stationState;
/*    */   @Inject
/*    */   protected TransDateProvider _transDateProvider;
/*    */   
/*    */   protected <T> T getScopedValue(ValueKey<T> argValueKey) {
/* 57 */     return (T)this._defaultScope.getValue(argValueKey);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void logWorkerStatus() {
/* 63 */     this._flowLogger.info("Worker", getClass(), this, isApplicable() ? "+" : "-", null);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\AbstractWorker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */