/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.pos.iframework.IBusyState;
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
/*    */ 
/*    */ 
/*    */ public class BusyDebugger
/*    */   implements IKeyCommand
/*    */ {
/*    */   private boolean busy_ = false;
/*    */   @Inject
/*    */   private IBusyState _busyState;
/*    */   
/*    */   public void execute() {
/* 28 */     if (this.busy_) {
/* 29 */       this._busyState.end();
/*    */     } else {
/*    */       
/* 32 */       this._busyState.start(null);
/*    */     } 
/*    */     
/* 35 */     this.busy_ = !this.busy_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 40 */     return "busy";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 45 */     return "toggles UI busy state";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\BusyDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */