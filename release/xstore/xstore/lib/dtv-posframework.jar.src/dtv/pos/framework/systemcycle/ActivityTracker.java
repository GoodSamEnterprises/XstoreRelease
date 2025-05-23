/*    */ package dtv.pos.framework.systemcycle;
/*    */ 
/*    */ import java.time.LocalDateTime;
/*    */ import java.time.ZoneId;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
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
/*    */ public class ActivityTracker
/*    */ {
/* 19 */   private final Map<Long, Long> _activeWorkstationMap = new ConcurrentHashMap<>();
/* 20 */   private final Object _sync = new Object();
/*    */   
/*    */   public boolean hasActive() {
/* 23 */     return !this._activeWorkstationMap.isEmpty();
/*    */   }
/*    */   
/*    */   public void register(long argWorkstationId) {
/* 27 */     this._activeWorkstationMap.put(Long.valueOf(argWorkstationId), Long.valueOf(System.currentTimeMillis()));
/*    */   }
/*    */   
/*    */   public void unregister(long argWorkstationId) {
/* 31 */     this._activeWorkstationMap.remove(Long.valueOf(argWorkstationId));
/* 32 */     synchronized (this._sync) {
/* 33 */       this._sync.notifyAll();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void waitForInactive(LocalDateTime argTimeout) throws InterruptedException {
/* 39 */     while (hasActive() && argTimeout.isBefore(LocalDateTime.now(ZoneId.systemDefault()))) {
/* 40 */       synchronized (this._sync) {
/*    */         
/* 42 */         long remaining = argTimeout.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() - System.currentTimeMillis();
/* 43 */         if (remaining > 0L) {
/* 44 */           this._sync.wait(remaining);
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 49 */     this._sync.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\ActivityTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */