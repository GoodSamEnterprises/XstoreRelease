/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.hardware.HardwareMgr;
/*    */ import dtv.pos.iframework.XstApplication;
/*    */ import dtv.pos.iframework.type.ExitType;
/*    */ import dtv.pos.iframework.type.IExitType;
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
/*    */ public class KillCommand
/*    */   implements IKeyCommand
/*    */ {
/* 21 */   protected static final Logger logger = Logger.getLogger(KillCommand.class);
/*    */ 
/*    */   
/*    */   public void execute() {
/* 25 */     Thread t = new Thread()
/*    */       {
/*    */         public void run() {
/*    */           try {
/* 29 */             HardwareMgr.getCurrentHardwareMgr().shutdown(false);
/*    */           }
/* 31 */           catch (Exception ex) {
/* 32 */             KillCommand.logger.error("CAUGHT EXCEPTION", ex);
/*    */           } 
/*    */         }
/*    */       };
/* 36 */     t.setPriority(10);
/* 37 */     t.start();
/*    */     
/*    */     try {
/* 40 */       t.join(10000L);
/*    */     }
/* 42 */     catch (InterruptedException ex) {
/* 43 */       logger.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/* 45 */     t = new Thread()
/*    */       {
/*    */         public void run() {
/*    */           try {
/* 49 */             XstApplication.annihilate((IExitType)ExitType.FORCE, "application was forced to exit");
/*    */           }
/* 51 */           catch (Exception ex) {
/* 52 */             KillCommand.logger.error("CAUGHT EXCEPTION", ex);
/*    */           } 
/*    */         }
/*    */       };
/* 56 */     t.start();
/* 57 */     t.setPriority(10);
/*    */     
/*    */     try {
/* 60 */       t.join(10000L);
/*    */     }
/* 62 */     catch (InterruptedException ex) {
/* 63 */       logger.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/*    */ 
/*    */     
/* 67 */     System.exit(ExitType.DISASTER.getExitLevel());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 72 */     return "exitnow";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 77 */     return "forces the application to exit";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\KillCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */