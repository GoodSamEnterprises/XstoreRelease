/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.framework.ui.context.ContextConfigHelper;
/*    */ import dtv.pos.framework.ui.context.UIContextDescriptor;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.op.IOpResponse;
/*    */ import dtv.pos.iframework.ui.context.IUIContext;
/*    */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
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
/*    */ public class ContextChangeOp
/*    */   extends Operation
/*    */ {
/*    */   private static final String PARAM_CONTEXT_KEY = "ContextKey";
/* 27 */   private String contextKey_ = null;
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private ContextConfigHelper _contextConfigHelper;
/*    */ 
/*    */ 
/*    */   
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 36 */     UIContextDescriptor uIContextDescriptor = new UIContextDescriptor((IUIContext)this._contextConfigHelper.getContext(getContextKey()));
/* 37 */     ((IModeController)this._modeProvider.get()).getUiController().handleContextTransition((IUIContextDescriptor)uIContextDescriptor, null);
/*    */     
/* 39 */     return this.HELPER.completeResponse();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 45 */     if ("ContextKey".equalsIgnoreCase(argName)) {
/* 46 */       this.contextKey_ = argValue;
/*    */     } else {
/*    */       
/* 49 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getContextKey() {
/* 60 */     return this.contextKey_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\ContextChangeOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */