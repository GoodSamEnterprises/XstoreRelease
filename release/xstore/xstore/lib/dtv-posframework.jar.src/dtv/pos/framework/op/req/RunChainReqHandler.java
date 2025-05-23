/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.framework.action.IXstActionFactory;
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstChainAction;
/*    */ import dtv.pos.iframework.action.IXstChainActionType;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
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
/*    */ public class RunChainReqHandler
/*    */   implements IOpReqHandler
/*    */ {
/*    */   @Inject
/*    */   private IXstActionFactory _actionFactory;
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 33 */     RunChainRequest request = (RunChainRequest)argRequest;
/*    */     
/* 35 */     XstChainActionType type = request.getChainActionType();
/* 36 */     IXstChainAction action = this._actionFactory.getChainAction(request.getOpChainKey(), (IXstChainActionType)type);
/*    */     
/* 38 */     action.setTrigger(request.getEvent());
/* 39 */     action.setRequired(request.isRequired());
/*    */     
/* 41 */     if (request.getEvent() != null) {
/* 42 */       action.setData(request.getEvent().getData());
/*    */     }
/*    */     
/* 45 */     if (argListener != null) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 50 */       argListener.handleXstEvent((IXstEvent)action);
/*    */     }
/*    */     else {
/*    */       
/* 54 */       argModeController.getEventRouter().fireEvent((IXstEvent)action);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\RunChainReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */