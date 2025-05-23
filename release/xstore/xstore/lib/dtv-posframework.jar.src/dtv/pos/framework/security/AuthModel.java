/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.logbuilder.model.IAuthModel;
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
/*    */ public class AuthModel
/*    */   extends AbstractSecurityLogModel
/*    */   implements IAuthModel
/*    */ {
/*    */   private final boolean success_;
/*    */   
/*    */   public AuthModel(boolean argSuccess) {
/* 23 */     this.success_ = argSuccess;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final String getPreviouslyFailedUserId() {
/* 29 */     return getSuccess() ? null : getSecurityMgr().getPreviouslyFailedUserId();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean getSuccess() {
/* 35 */     return this.success_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\AuthModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */