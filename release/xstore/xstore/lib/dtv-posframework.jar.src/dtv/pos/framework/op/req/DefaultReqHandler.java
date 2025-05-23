/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.ICustomOpRequest;
/*    */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
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
/*    */ public class DefaultReqHandler
/*    */   implements IOpReqHandler
/*    */ {
/* 21 */   private static final Logger _logger = Logger.getLogger(DefaultReqHandler.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 27 */     if (argRequest instanceof ICustomOpRequest) {
/* 28 */       ((ICustomOpRequest)argRequest).handleRequest(argListener);
/*    */     } else {
/*    */       
/* 31 */       _logger.warn("Default request handler not able to do anything with request" + argRequest);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\DefaultReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */