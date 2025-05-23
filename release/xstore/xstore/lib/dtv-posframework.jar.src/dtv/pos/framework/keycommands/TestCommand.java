/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.test.ITestHarness;
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
/*    */ public class TestCommand
/*    */   implements IKeyCommand
/*    */ {
/*    */   @Inject
/*    */   private ITestHarness _testHarness;
/*    */   
/*    */   public void execute() {
/* 25 */     if (this._testHarness.isEnabled()) {
/* 26 */       this._testHarness.showConsole();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 32 */     return "test";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 37 */     return "displays the automated test console";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\TestCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */