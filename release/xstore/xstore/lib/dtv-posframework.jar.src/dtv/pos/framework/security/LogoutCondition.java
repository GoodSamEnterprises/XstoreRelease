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
/*    */ public class LogoutCondition
/*    */   extends AbstractInvertableCondition
/*    */ {
/*    */   protected boolean conditionMetImpl(Object argSource) {
/* 22 */     boolean met = false;
/*    */     
/* 24 */     if (argSource instanceof ISecurityLogModel) {
/* 25 */       ISecurityLogModel logModel = (ISecurityLogModel)argSource;
/*    */       
/* 27 */       if (logModel.getProcessingStep() != null && (logModel
/* 28 */         .getProcessingStep().isLogout() || logModel.getProcessingStep().isAutoLogout())) {
/* 29 */         met = true;
/*    */       }
/*    */     } 
/*    */     
/* 33 */     return met;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\LogoutCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */