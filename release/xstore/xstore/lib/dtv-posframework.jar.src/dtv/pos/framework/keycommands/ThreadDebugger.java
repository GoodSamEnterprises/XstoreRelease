/*    */ package dtv.pos.framework.keycommands;
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
/*    */ public class ThreadDebugger
/*    */   implements IKeyCommand
/*    */ {
/*    */   public void execute() {
/* 18 */     Thread.currentThread().getThreadGroup().list();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 23 */     return "threads";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 28 */     return "lists the threads that are in the current thread group";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\ThreadDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */