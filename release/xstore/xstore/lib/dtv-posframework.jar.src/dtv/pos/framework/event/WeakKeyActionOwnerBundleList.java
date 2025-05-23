/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
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
/*    */ class WeakKeyActionOwnerBundleList
/*    */   extends LinkedList<WeakKeyActionOwnerBundle>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private static final Logger logger_ = Logger.getLogger(WeakKeyActionOwnerBundleList.class);
/* 25 */   private static final boolean isDebugEnabled_ = logger_.isDebugEnabled();
/*    */   
/* 27 */   private final Object mutex_ = this;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WeakKeyActionOwnerBundleList() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WeakKeyActionOwnerBundleList(Collection<? extends WeakKeyActionOwnerBundle> argValues) {
/* 43 */     super(argValues);
/* 44 */     expungeStaleEntries();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<WeakKeyActionOwnerBundle> iterator() {
/* 50 */     expungeStaleEntries();
/* 51 */     return super.iterator();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void expungeStaleEntries() {
/* 59 */     synchronized (this.mutex_) {
/* 60 */       for (Iterator<WeakKeyActionOwnerBundle> iter = super.iterator(); iter.hasNext(); ) {
/* 61 */         WeakKeyActionOwnerBundle bundle = iter.next();
/*    */         
/* 63 */         if (bundle.getAction() == null || bundle.getActionOwner() == null || bundle
/* 64 */           .getKeyStroke() == null) {
/*    */           
/* 66 */           iter.remove();
/* 67 */           if (isDebugEnabled_)
/* 68 */             logger_.debug("Expunged: [" + bundle.getAction() + "@" + bundle.getActionOwner() + ":" + bundle
/* 69 */                 .getKeyStroke() + "]"); 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\WeakKeyActionOwnerBundleList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */