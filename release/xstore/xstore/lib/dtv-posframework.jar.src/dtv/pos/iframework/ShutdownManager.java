/*    */ package dtv.pos.iframework;
/*    */ 
/*    */ import dtv.pos.iframework.event.IExitEvent;
/*    */ import dtv.pos.iframework.event.IExitListener;
/*    */ import dtv.pos.iframework.type.ExitType;
/*    */ import dtv.pos.iframework.type.IExitType;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.WeakHashMap;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
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
/*    */ public class ShutdownManager
/*    */   extends Thread
/*    */ {
/* 28 */   private static final ShutdownManager INSTANCE = new ShutdownManager();
/*    */ 
/*    */   
/*    */   public static final ShutdownManager getInstance() {
/* 32 */     return INSTANCE;
/*    */   }
/*    */   
/* 35 */   private final ShutdownThread shutdownThread_ = new ShutdownThread();
/*    */ 
/*    */   
/* 38 */   private final AtomicBoolean exitListenersNotified_ = new AtomicBoolean(false);
/* 39 */   private final Collection<IExitListener> exitListeners_ = Collections.newSetFromMap(new WeakHashMap<>());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addExitListener(IExitListener argListener) {
/* 46 */     this.exitListeners_.add(argListener);
/*    */   }
/*    */   
/*    */   public void removeExitListener(IExitListener argListener) {
/* 50 */     this.exitListeners_.remove(argListener);
/*    */   }
/*    */   
/*    */   protected void notifyExitListeners(IExitEvent argEvent) {
/* 54 */     if (this.exitListenersNotified_.compareAndSet(false, true)) {
/* 55 */       IExitListener[] s = this.exitListeners_.<IExitListener>toArray(new IExitListener[this.exitListeners_.size()]);
/* 56 */       Arrays.sort(s, new XstApplication.ExitListenerComparator());
/* 57 */       for (IExitListener l : s) {
/* 58 */         l.exiting(argEvent);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private class ShutdownThread
/*    */     extends Thread
/*    */   {
/*    */     ShutdownThread() {
/* 67 */       super("Xstore-Shutdown");
/* 68 */       Runtime.getRuntime().addShutdownHook(this);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void run() {
/* 74 */       ShutdownManager.this.notifyExitListeners(new IExitEvent()
/*    */           {
/*    */             public IExitType getExitType() {
/* 77 */               return (IExitType)ExitType.NORMAL;
/*    */             }
/*    */ 
/*    */             
/*    */             public String getMessage() {
/* 82 */               return "";
/*    */             }
/*    */ 
/*    */             
/*    */             public Throwable getThrowable() {
/* 87 */               return null;
/*    */             }
/*    */           });
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\ShutdownManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */