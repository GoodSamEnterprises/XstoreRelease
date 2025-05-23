/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.common.PromptKey;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.op.IOpResponse;
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
/*    */ public class PromptMenuOp
/*    */   extends Operation
/*    */ {
/*    */   private String _menuKey;
/*    */   
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 32 */     IOpResponse response = this.HELPER.getCompletePromptResponse(PromptKey.valueOf(this._menuKey), new dtv.i18n.IFormattable[0]);
/* 33 */     return response;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 39 */     if ("MenuKey".equalsIgnoreCase(argName)) {
/* 40 */       this._menuKey = argValue;
/*    */     } else {
/*    */       
/* 43 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\PromptMenuOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */