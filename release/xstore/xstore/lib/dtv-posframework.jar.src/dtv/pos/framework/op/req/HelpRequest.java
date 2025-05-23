/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.ui.context.IUIContext;
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
/*    */ public class HelpRequest
/*    */   implements IOpRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final IUIContext _context;
/*    */   
/*    */   public HelpRequest(IUIContext argContext) {
/* 28 */     this._context = argContext;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IUIContext getContext() {
/* 36 */     return this._context;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequestType() {
/* 42 */     return OpRequestType.HELP.name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\HelpRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */