/*    */ package dtv.pos.framework;
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
/*    */ public class PosArgs
/*    */ {
/* 30 */   private static final Logger logger_ = Logger.getLogger(PosArgs.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PosArgs(String[] args) {
/*    */     try {
/* 40 */       for (int i = 0; i < args.length; i++) {
/* 41 */         if (args[i].startsWith("-") || args[i].startsWith("/")) {
/* 42 */           switch (args[i].charAt(1)) {
/*    */             
/*    */             case 'f':
/* 45 */               System.setProperty("dtv.pos.ui.useFrame", "true");
/* 46 */               System.err.println("consider setting system property dtv.pos.ui.useFrame=true instead");
/*    */               break;
/*    */             
/*    */             case 'p':
/* 50 */               System.setProperty("dtv.pos.disablePaintLimiting", "true");
/* 51 */               System.err
/* 52 */                 .println("consider setting system property dtv.pos.disablePaintLimiting=true instead");
/*    */               break;
/*    */             
/*    */             case 's':
/* 56 */               System.setProperty("dtv.pos.screenNumber", args[++i]);
/* 57 */               System.err.println("consider setting system property dtv.pos.screenNumber instead");
/*    */               break;
/*    */             
/*    */             case 'd':
/* 61 */               System.setProperty("dtv.pos.deleteCacheOnStartup", "true");
/* 62 */               System.err
/* 63 */                 .println("consider setting system property dtv.pos.deleteCacheOnStartup=true instead");
/*    */               break;
/*    */           } 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         } else {
/* 71 */           logger_.error("invalid command line argument '" + args[i] + "'");
/*    */         }
/*    */       
/*    */       } 
/* 75 */     } catch (Exception ex) {
/* 76 */       logger_.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\PosArgs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */