/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.security.ISecurityResponse;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import dtv.xst.daocommon.ISystemUser;
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
/*    */ public class SecurityResponse
/*    */   implements ISecurityResponse
/*    */ {
/*    */   private final boolean successFlag_;
/*    */   private final IOpRequest request_;
/*    */   private final ISystemUser user_;
/*    */   private final IAccessLevel accessLevel_;
/*    */   private final IFormattable failureReason_;
/*    */   
/*    */   public SecurityResponse(IOpRequest request, boolean successFlag) {
/* 28 */     this.successFlag_ = successFlag;
/* 29 */     this.request_ = request;
/* 30 */     this.user_ = null;
/* 31 */     this.accessLevel_ = null;
/* 32 */     this.failureReason_ = IFormattable.EMPTY;
/*    */   }
/*    */   
/*    */   public SecurityResponse(IOpRequest request, boolean successFlag, IAccessLevel token) {
/* 36 */     this.successFlag_ = successFlag;
/* 37 */     this.request_ = request;
/* 38 */     this.user_ = null;
/* 39 */     this.accessLevel_ = token;
/* 40 */     this.failureReason_ = IFormattable.EMPTY;
/*    */   }
/*    */   
/*    */   public SecurityResponse(IOpRequest request, boolean successFlag, IFormattable failureReason) {
/* 44 */     this.successFlag_ = successFlag;
/* 45 */     this.request_ = request;
/* 46 */     this.failureReason_ = failureReason;
/* 47 */     this.user_ = null;
/* 48 */     this.accessLevel_ = null;
/*    */   }
/*    */   
/*    */   public SecurityResponse(IOpRequest request, boolean successFlag, ISystemUser user) {
/* 52 */     this.successFlag_ = successFlag;
/* 53 */     this.request_ = request;
/* 54 */     this.user_ = user;
/* 55 */     this.accessLevel_ = null;
/* 56 */     this.failureReason_ = IFormattable.EMPTY;
/*    */   }
/*    */   
/*    */   public SecurityResponse(IOpRequest request, boolean successFlag, ISystemUser user, IAccessLevel token) {
/* 60 */     this.successFlag_ = successFlag;
/* 61 */     this.request_ = request;
/* 62 */     this.user_ = user;
/* 63 */     this.accessLevel_ = token;
/* 64 */     this.failureReason_ = IFormattable.EMPTY;
/*    */   }
/*    */ 
/*    */   
/*    */   public IAccessLevel getAccessToken() {
/* 69 */     return this.accessLevel_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IFormattable getFailureReason() {
/* 74 */     return this.failureReason_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IOpRequest getRequest() {
/* 79 */     return this.request_;
/*    */   }
/*    */ 
/*    */   
/*    */   public ISystemUser getSystemUser() {
/* 84 */     return this.user_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean successful() {
/* 89 */     return this.successFlag_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\SecurityResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */