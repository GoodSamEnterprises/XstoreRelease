/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
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
/*    */ public class InfoMessageReqHandler
/*    */   implements IOpReqHandler
/*    */ {
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 25 */     InfoMessageRequest request = (InfoMessageRequest)argRequest;
/*    */     
/* 27 */     if (request != null)
/* 28 */       request.process(argModeController.getStationModel().getMessageModel()); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\InfoMessageReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */