/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.framework.action.XstMenuAction;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import java.awt.event.ActionListener;
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
/*    */ public class MenuReqHandler
/*    */   implements IOpReqHandler
/*    */ {
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 28 */     XstMenuAction request = (XstMenuAction)argRequest;
/* 29 */     ActionListener menuListener = request.getActionListener();
/* 30 */     menuListener.actionPerformed(request.getMenuEvent());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\MenuReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */