/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.pos.iframework.security.ISecurityConstants;
/*    */ import dtv.pos.iframework.security.ISecurityLogModel;
/*    */ import dtv.pos.iframework.security.ProcessingStep;
/*    */ import dtv.xst.daocommon.ISystemUser;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
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
/*    */ public class SecurityLogModel
/*    */   extends AbstractSecurityLogModel
/*    */   implements ISecurityLogModel
/*    */ {
/*    */   private final boolean _successful;
/*    */   
/*    */   public SecurityLogModel(boolean argSuccess) {
/* 28 */     this._successful = argSuccess;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ISystemUser getOverridingUser() {
/* 34 */     return getScopedValue(ISecurityConstants.CURRENT_ADDITIONAL_SECURITY_USER);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPreviouslyFailedUserId() {
/* 40 */     return getSuccess() ? null : getScopedValue(ISecurityConstants.ENTERED_USER_ID);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> getPrivileges() {
/* 46 */     return (getScopedValue(ISecurityConstants.CURRENT_PRIVILEGES) != null) ? 
/* 47 */       Arrays.<Object>asList(getScopedValue(ISecurityConstants.CURRENT_PRIVILEGES)) : null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ProcessingStep getProcessingStep() {
/* 53 */     ProcessingStep step = getScopedValue(ISecurityConstants.CURRENT_SECURITY_PROCESSING_STEP);
/* 54 */     if (step == null) {
/* 55 */       return ProcessingStep.INITIAL_STEP;
/*    */     }
/*    */     
/* 58 */     return step;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getSuccess() {
/* 64 */     return this._successful;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ISystemUser getSystemUser() {
/* 73 */     ProcessingStep step = getScopedValue(ISecurityConstants.CURRENT_SECURITY_PROCESSING_STEP);
/*    */     
/* 75 */     if (step == ProcessingStep.OVERRIDE_AUTHENTICATE || step == ProcessingStep.REAUTHENTICATE) {
/* 76 */       return getScopedValue(ISecurityConstants.CURRENT_ADDITIONAL_SECURITY_USER);
/*    */     }
/* 78 */     if (step == ProcessingStep.SECOND_PROMPT) {
/* 79 */       return getScopedValue(ISecurityConstants.CURRENT_SECOND_PROMPT_USER);
/*    */     }
/*    */     
/* 82 */     return this._stationState.getSystemUser();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ISystemUser getTempSystemUser() {
/* 89 */     return this._stationState.getSystemUser();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\SecurityLogModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */