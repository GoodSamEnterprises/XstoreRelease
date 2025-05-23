/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import java.awt.KeyboardFocusManager;
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
/*    */ public class FocusDebugger
/*    */   implements IKeyCommand
/*    */ {
/* 19 */   private static final Logger logger = Logger.getLogger(FocusDebugger.class);
/*    */   
/*    */   public static StringBuffer execute(StringBuffer sb) {
/*    */     try {
/* 23 */       KeyboardFocusManager fm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
/* 24 */       sb.append("\n   focusedWindow:").append(fm.getFocusedWindow());
/* 25 */       sb.append("\n   focusOwner:").append(fm.getFocusOwner());
/* 26 */       sb.append("\n   permanentFocusOwner:").append(fm.getPermanentFocusOwner());
/*    */     }
/* 28 */     catch (Exception ex) {
/* 29 */       logger.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/* 31 */     return sb;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void execute() {
/* 39 */     if (logger.isInfoEnabled()) {
/* 40 */       logger.info(execute(new StringBuffer(1024)));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 46 */     return "focus";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 51 */     return "gets information about the current focus";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\FocusDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */