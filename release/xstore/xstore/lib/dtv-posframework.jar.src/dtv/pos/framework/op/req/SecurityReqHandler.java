/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.framework.action.IXstActionFactory;
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
/*    */ import dtv.pos.framework.action.type.XstDataActionKey;
/*    */ import dtv.pos.framework.scope.OperationDefaultScope;
/*    */ import dtv.pos.framework.security.SecondPromptSettings;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstChainActionType;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.security.ISecurityConstants;
/*    */ import dtv.pos.iframework.security.ISecurityMgr;
/*    */ import dtv.pos.iframework.security.ProcessingStep;
/*    */ import javax.inject.Inject;
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
/*    */ public class SecurityReqHandler
/*    */   implements IOpReqHandler
/*    */ {
/* 32 */   private static final Logger _logger = Logger.getLogger(SecurityReqHandler.class);
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private OperationDefaultScope _defaultScope;
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private IXstActionFactory _actionFactory;
/*    */   
/*    */   @Inject
/*    */   private ISecurityMgr _securityMgr;
/*    */ 
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 47 */     if (!(argRequest instanceof SecurityRequest)) {
/* 48 */       _logger.warn("Invalid request passed to Security Manager. [Invalid Type]");
/* 49 */       argListener.handleXstEvent((IXstEvent)this._actionFactory.getDataAction(XstDataActionKey.ACCEPT));
/*    */       
/*    */       return;
/*    */     } 
/* 53 */     SecurityRequest securityRequest = (SecurityRequest)argRequest;
/* 54 */     String[] privileges = securityRequest.getPrivilegeTypes().<String>toArray(new String[0]);
/* 55 */     this._defaultScope.setValue(ISecurityConstants.CURRENT_PRIVILEGES, privileges);
/*    */     
/* 57 */     switch (securityRequest.getActionType()) {
/*    */       
/*    */       case 1:
/* 60 */         this._securityMgr.setRequestType((byte)11);
/*    */         break;
/*    */ 
/*    */       
/*    */       case 2:
/* 65 */         this._securityMgr.setRequestType((byte)8);
/*    */         break;
/*    */       
/*    */       case 3:
/* 69 */         this._securityMgr.setRequestType((byte)6);
/*    */         break;
/*    */       
/*    */       case 4:
/* 73 */         this._securityMgr.setRequestType((byte)4);
/*    */         break;
/*    */       
/*    */       case 5:
/* 77 */         this._securityMgr.setRequestType((byte)4);
/*    */         break;
/*    */       
/*    */       default:
/* 81 */         _logger.warn("Invalid request passed to Security Manager. [Unknown Action:" + securityRequest
/* 82 */             .getActionType() + "]");
/*    */         break;
/*    */     } 
/* 85 */     this._defaultScope.setValue(ISecurityConstants.CURRENT_SECURITY_REQUEST, securityRequest);
/* 86 */     this._defaultScope.setValue(ISecurityConstants.CURRENT_SECURITY_PROCESSING_STEP, ProcessingStep.INITIAL_STEP);
/* 87 */     this._securityMgr.setRetryCount(0);
/* 88 */     this._securityMgr.setSecondPromptSettings(SecondPromptSettings.NO_PROMPT);
/* 89 */     this._securityMgr.setLoginFailureMessage(null);
/*    */     
/* 91 */     if (securityRequest.getMessage() != null) {
/* 92 */       this._securityMgr.setSecurityPromptMessage(securityRequest.getMessage());
/*    */     } else {
/*    */       
/* 95 */       this._securityMgr.setSecurityPromptMessage(null);
/*    */     } 
/*    */     
/* 98 */     argListener.handleXstEvent((IXstEvent)this._actionFactory
/* 99 */         .getChainAction(OpChainKey.valueOf("SECURITY"), (IXstChainActionType)XstChainActionType.STACK));
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\SecurityReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */