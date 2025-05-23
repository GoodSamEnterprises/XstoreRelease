/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.common.PromptKey;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.op.IOpResponse;
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
/*    */ public class ForceMenuSelectionOp
/*    */   extends Operation
/*    */ {
/*    */   public ForceMenuSelectionOp() {
/* 27 */     super(true);
/*    */   }
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
/*    */   public IOpResponse handleOpExec(IXstEvent event) {
/* 42 */     ((IModeController)this._modeProvider.get()).getStationModel().getMenuModel().refreshMenu();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     return ((IModeController)this._modeProvider.get()).getUiController().isInputRestrictedToMenu() ? this.HELPER.waitResponse() : this.HELPER
/* 48 */       .getPromptResponse(PromptKey.valueOf("SELECT_MENU_OPTION"), new dtv.i18n.IFormattable[0]);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\ForceMenuSelectionOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */