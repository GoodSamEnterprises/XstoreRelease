/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.security.ISecureAction;
/*     */ import dtv.pos.iframework.security.ISecurityRequest;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.security.ISecured;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SecurityRequest
/*     */   implements ISecurityRequest
/*     */ {
/*     */   public static final int ACTION = 5;
/*     */   public static final int AUTHENTICATE = 3;
/*     */   public static final int AUTHORIZE = 4;
/*     */   public static final int LOGIN = 1;
/*     */   public static final int LOGOUT = 2;
/*     */   private static final long serialVersionUID = 1L;
/*     */   private IOpRequest _postSuccessRequest;
/*     */   private ISecureAction action_;
/*     */   private final int actionType_;
/*     */   private IFormattable message_;
/*     */   private String[] privilegeTypes_;
/*     */   private String toString;
/*     */   
/*     */   public static SecurityRequest getActionRequest(ISecureAction argAction) {
/*  58 */     return getActionRequest(argAction, null);
/*     */   }
/*     */   
/*     */   public static SecurityRequest getActionRequest(ISecureAction argAction, String argType) {
/*  62 */     SecurityRequest request = new SecurityRequest(5);
/*  63 */     request.setAction(argAction);
/*  64 */     if (argType == null) {
/*  65 */       request.setPrivilegeType((ISecured)argAction);
/*     */     } else {
/*     */       
/*  68 */       request.setPrivilegeType(argType);
/*     */     } 
/*  70 */     return request;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SecurityRequest getAuthenticateRequest(String argType) {
/*  79 */     SecurityRequest request = new SecurityRequest(3);
/*  80 */     request.setPrivilegeType(argType);
/*  81 */     return request;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SecurityRequest getAuthorizeRequest(String argPrivilegeType) {
/*  90 */     SecurityRequest request = new SecurityRequest(4);
/*  91 */     request.setPrivilegeType(argPrivilegeType);
/*  92 */     return request;
/*     */   }
/*     */   
/*     */   public static SecurityRequest getAuthorizeRequest(String[] argPrivilegeTypes) {
/*  96 */     SecurityRequest request = new SecurityRequest(4);
/*  97 */     request.setPrivilegeTypes(argPrivilegeTypes);
/*  98 */     return request;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SecurityRequest getLoginRequest() {
/* 106 */     return new SecurityRequest(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SecurityRequest getLogoutRequest() {
/* 114 */     return new SecurityRequest(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SecurityRequest(int argActionType) {
/* 131 */     this.actionType_ = argActionType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISecureAction getAction() {
/* 140 */     return this.action_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getActionType() {
/* 149 */     return this.actionType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getMessage() {
/* 158 */     return this.message_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpRequest getPostSuccessRequest() {
/* 167 */     return this._postSuccessRequest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getPrivilegeTypes() {
/* 176 */     return Arrays.asList(this.privilegeTypes_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRequestType() {
/* 186 */     return OpRequestType.SECURITY.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessage(IFormattable message) {
/* 195 */     this.message_ = message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostSuccessRequest(IOpRequest argRequest) {
/* 204 */     this._postSuccessRequest = argRequest;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 209 */     if (this.toString == null) {
/* 210 */       StringBuilder sb = new StringBuilder(getClass().getName());
/* 211 */       sb.append("::PrivilegeTypes = ");
/* 212 */       sb.append(ArrayUtils.toString((Object[])this.privilegeTypes_));
/* 213 */       sb.append("::ActionType = ").append(this.actionType_);
/* 214 */       sb.append("::Action = ").append(this.action_);
/* 215 */       sb.append("::Message = ").append(this.message_);
/* 216 */       this.toString = sb.toString();
/*     */     } 
/*     */     
/* 219 */     return this.toString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setAction(ISecureAction argAction) {
/* 227 */     this.action_ = argAction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setPrivilegeType(ISecured argSecured) {
/* 235 */     this.privilegeTypes_ = new String[] { argSecured.getPrivilege() };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setPrivilegeType(String argType) {
/* 243 */     this.privilegeTypes_ = new String[] { argType };
/*     */   }
/*     */   
/*     */   protected void setPrivilegeTypes(String[] argTypes) {
/* 247 */     this.privilegeTypes_ = argTypes;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\SecurityRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */