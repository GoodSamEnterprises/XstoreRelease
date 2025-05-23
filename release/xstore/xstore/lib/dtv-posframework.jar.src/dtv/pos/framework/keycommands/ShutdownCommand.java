/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.ipc.server.IIpcService;
/*    */ import dtv.ipc.server.IpcRequest;
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.framework.action.IXstActionFactory;
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstChainAction;
/*    */ import dtv.pos.iframework.action.IXstChainActionType;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import java.util.Map;
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
/*    */ public class ShutdownCommand
/*    */   implements IKeyCommand, IIpcService
/*    */ {
/*    */   @Inject
/*    */   private Provider<IModeController> _modeProvider;
/*    */   @Inject
/*    */   private IXstActionFactory _actionFactory;
/*    */   
/*    */   public void execute() {
/* 37 */     IXstChainAction iXstChainAction = this._actionFactory.getChainAction(OpChainKey.valueOf("REGISTER_SHUTDOWN"), (IXstChainActionType)XstChainActionType.SYSTEM);
/*    */     
/* 39 */     ((IModeController)this._modeProvider.get()).getEventRouter().fireEvent((IXstEvent)iXstChainAction);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 44 */     return "exit";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 49 */     return "exits the application gracefully";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, String> invoke(IpcRequest argRequest) {
/* 55 */     execute();
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\ShutdownCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */