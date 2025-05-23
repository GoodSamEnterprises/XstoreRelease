/*     */ package dtv.pos.iframework;
/*     */ 
/*     */ import dtv.pos.iframework.event.IExitEvent;
/*     */ import dtv.pos.iframework.event.IExitListener;
/*     */ import dtv.pos.iframework.type.ExitType;
/*     */ import dtv.pos.iframework.type.IExitType;
/*     */ import java.util.Comparator;
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
/*     */ 
/*     */ public abstract class XstApplication
/*     */ {
/*  22 */   private static final Logger logger_ = Logger.getLogger(XstApplication.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addExitListener(IExitListener argListener) {
/*  30 */     ShutdownManager.getInstance().addExitListener(argListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void annihilate() {
/*  38 */     annihilate((IExitType)ExitType.NORMAL, "", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void annihilate(IExitType argErrorStatus) {
/*  47 */     annihilate(argErrorStatus, "", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void annihilate(IExitType argErrorStatus, String argUserErrorMessage) {
/*  58 */     annihilate(argErrorStatus, argUserErrorMessage, null);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void annihilate(final IExitType argErrorStatus, final String argUserMessage, final Throwable argUserException) {
/*  78 */     notifyExitListeners(new IExitEvent()
/*     */         {
/*     */           public IExitType getExitType()
/*     */           {
/*  82 */             return argErrorStatus;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public String getMessage() {
/*  88 */             return argUserMessage;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public Throwable getThrowable() {
/*  94 */             return argUserException;
/*     */           }
/*     */         });
/*     */     
/*     */     try {
/*  99 */       System.exit(argErrorStatus.getExitLevel());
/*     */     }
/* 101 */     catch (SecurityException ex) {
/*     */       
/* 103 */       logger_.debug("CAUGHT EXCEPTION", ex);
/*     */     }
/*     */     finally {
/*     */       
/* 107 */       System.exit(-5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void annihilate(IExitType argErrorStatus, Throwable argUserException) {
/* 118 */     annihilate(argErrorStatus, argUserException.getMessage(), argUserException);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeExitListener(IExitListener argListener) {
/* 127 */     ShutdownManager.getInstance().removeExitListener(argListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void notifyExitListeners(IExitEvent argEvent) {
/* 135 */     ShutdownManager.getInstance().notifyExitListeners(argEvent);
/*     */   }
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
/*     */   static class ExitListenerComparator
/*     */     implements Comparator<IExitListener>
/*     */   {
/*     */     public int compare(IExitListener o1, IExitListener o2) {
/* 151 */       int i1 = 0, i2 = 0;
/* 152 */       if (o1 instanceof IExitListener.IPrioritizedExitListener) {
/* 153 */         i1 = ((IExitListener.IPrioritizedExitListener)o1).priority();
/*     */       }
/* 155 */       if (o2 instanceof IExitListener.IPrioritizedExitListener) {
/* 156 */         i2 = ((IExitListener.IPrioritizedExitListener)o2).priority();
/*     */       }
/* 158 */       if (i1 == i2) {
/* 159 */         return 0;
/*     */       }
/* 161 */       if (i1 < i2) {
/* 162 */         return -1;
/*     */       }
/* 164 */       return 1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\XstApplication.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */