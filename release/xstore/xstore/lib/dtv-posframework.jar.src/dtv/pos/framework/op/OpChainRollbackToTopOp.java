/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.framework.op.req.AbstractCustomOpRequest;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.IOpResponse;
/*    */ import dtv.pos.iframework.op.OpStatus;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.util.config.ConfigUtils;
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
/*    */ public class OpChainRollbackToTopOp
/*    */   extends Operation
/*    */ {
/* 34 */   private static final Logger logger_ = Logger.getLogger(OpChainRollbackToTopOp.class);
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String PARAM_PROCESS_TOP_CHAIN = "ProcessTopChain";
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean _processTopChain = true;
/*    */ 
/*    */ 
/*    */   
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 47 */     return new OpResponse(OpStatus.COMPLETE, new IOpRequest[] { (IOpRequest)new AbstractCustomOpRequest()
/*    */           {
/*    */             private static final long serialVersionUID = 1L;
/*    */             
/*    */             public void handleRequest(IXstEventListener listener) {
/* 52 */               if (!(listener instanceof OpChainProcessor)) {
/* 53 */                 OpChainRollbackToTopOp.logger_.warn("Listener must be an operation chain processor to perform rollback!");
/*    */                 
/*    */                 return;
/*    */               } 
/* 57 */               ((OpChainProcessor)listener).processRollbackToTop(OpChainRollbackToTopOp.this._processTopChain);
/*    */             }
/*    */           } });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 65 */     if ("ProcessTopChain".equalsIgnoreCase(argName)) {
/* 66 */       this._processTopChain = ConfigUtils.toBoolean(argValue).booleanValue();
/*    */     } else {
/*    */       
/* 69 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainRollbackToTopOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */