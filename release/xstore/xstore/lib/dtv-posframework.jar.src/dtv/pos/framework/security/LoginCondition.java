/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.docbuilding.conditions.AbstractInvertableCondition;
/*    */ import dtv.pos.iframework.security.ISecurityLogModel;
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
/*    */ public class LoginCondition
/*    */   extends AbstractInvertableCondition
/*    */ {
/*    */   protected boolean conditionMetImpl(Object argSource) {
/* 22 */     boolean met = false;
/*    */     
/* 24 */     if (argSource instanceof ISecurityLogModel) {
/* 25 */       ISecurityLogModel logModel = (ISecurityLogModel)argSource;
/*    */       
/* 27 */       if (logModel.getProcessingStep() != null && logModel.getProcessingStep().isLogin()) {
/* 28 */         met = true;
/*    */       }
/*    */     } 
/*    */     
/* 32 */     return met;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\LoginCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */