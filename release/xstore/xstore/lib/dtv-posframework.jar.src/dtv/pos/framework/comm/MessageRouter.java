/*     */ package dtv.pos.framework.comm;
/*     */ 
/*     */ import dtv.util.WeakEventListenerList;
/*     */ import dtv.util.message.IMessageConstraint;
/*     */ import dtv.util.message.IMessageListener;
/*     */ import dtv.util.message.Message;
/*     */ import dtv.util.message.constraint.AlwaysSatisfiedMessageConstraint;
/*     */ import java.util.EventListener;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MessageRouter
/*     */ {
/*  25 */   private static final IMessageConstraint DEFAULT_CONSTRAINT = AlwaysSatisfiedMessageConstraint.getInstance();
/*     */ 
/*     */   
/*  28 */   private static final Logger logger_ = Logger.getLogger(MessageRouter.class);
/*     */ 
/*     */   
/*  31 */   private static final MessageRouter INSTANCE = new MessageRouter();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MessageRouter getInstance() {
/*  38 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*  42 */   private final WeakEventListenerList listeners_ = new WeakEventListenerList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private final Map<IMessageListener, IMessageConstraint> constraintMap_ = new WeakHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMessageListener(IMessageListener listener) {
/*  59 */     addMessageListener(listener, DEFAULT_CONSTRAINT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMessageListener(IMessageListener listener, IMessageConstraint argConstraint) {
/*  69 */     if (listener == null) {
/*     */       return;
/*     */     }
/*  72 */     this.listeners_.add(IMessageListener.class, (EventListener)listener);
/*  73 */     this.constraintMap_.put(listener, (argConstraint == null) ? DEFAULT_CONSTRAINT : argConstraint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshMessageStatus() {
/*  80 */     Map<String, String> params = new HashMap<>();
/*  81 */     params.put("status", "REFRESH");
/*  82 */     routeMessage(new Message("", params));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeMessageListener(IMessageListener listener) {
/*  91 */     this.listeners_.remove(IMessageListener.class, (EventListener)listener);
/*  92 */     this.constraintMap_.remove(listener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void routeMessage(Message msg) {
/* 100 */     if (logger_.isInfoEnabled()) {
/* 101 */       logger_.info("Routing message: " + msg);
/*     */     }
/* 103 */     IMessageListener[] listeners = (IMessageListener[])this.listeners_.getListeners(IMessageListener.class);
/*     */     
/* 105 */     if (listeners != null)
/* 106 */       for (IMessageListener listener : listeners) {
/* 107 */         IMessageConstraint constraint = this.constraintMap_.get(listener);
/*     */         
/* 109 */         if (constraint.isSatisfied(msg)) {
/* 110 */           if (logger_.isDebugEnabled()) {
/* 111 */             logger_.debug("     Routing event to: " + listener);
/*     */           }
/* 113 */           listener.handleMessage(msg);
/*     */         } 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\MessageRouter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */