/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.framework.action.IXstActionFactory;
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstChainAction;
/*    */ import dtv.pos.iframework.action.IXstChainActionType;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import javax.inject.Inject;
/*    */ import javax.inject.Provider;
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
/*    */ public class ResetCommand
/*    */   implements IKeyCommand
/*    */ {
/*    */   @Inject
/*    */   private Provider<IModeController> _modeProvider;
/*    */   @Inject
/*    */   private IXstActionFactory _actionFactory;
/*    */   
/*    */   public void execute() {
/* 34 */     IXstChainAction iXstChainAction = this._actionFactory.getChainAction(OpChainKey.valueOf("RESET_STATION"), (IXstChainActionType)XstChainActionType.START);
/*    */     
/* 36 */     ((IModeController)this._modeProvider.get()).getEventRouter().fireEvent((IXstEvent)iXstChainAction);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 41 */     return "reset";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 46 */     return "resets the station to a logged off state, escaping from any dead end";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\ResetCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */