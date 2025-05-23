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
/*    */ 
/*    */ public class AuthorizeCondition
/*    */   extends AbstractInvertableCondition
/*    */ {
/*    */   protected boolean conditionMetImpl(Object argSource) {
/* 23 */     boolean met = false;
/*    */     
/* 25 */     if (argSource instanceof ISecurityLogModel) {
/* 26 */       ISecurityLogModel logModel = (ISecurityLogModel)argSource;
/*    */       
/* 28 */       if (logModel.getProcessingStep() != null && logModel.getProcessingStep().isAuthorization()) {
/* 29 */         met = true;
/*    */       }
/*    */     } 
/*    */     
/* 33 */     return met;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\AuthorizeCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */