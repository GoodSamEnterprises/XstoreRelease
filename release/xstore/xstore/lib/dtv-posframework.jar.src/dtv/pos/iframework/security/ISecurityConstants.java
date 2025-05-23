/*    */ package dtv.pos.iframework.security;
/*    */ 
/*    */ import dtv.pos.framework.op.req.SecurityRequest;
/*    */ import dtv.pos.framework.scope.ValueKey;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import dtv.util.crypto.EncString;
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
/*    */ public interface ISecurityConstants
/*    */ {
/*    */   public static final byte LOGIN = 1;
/*    */   public static final byte AUTHENTICATE = 2;
/*    */   public static final byte AUTHORIZE = 4;
/*    */   public static final byte LOGOUT = 8;
/*    */   public static final byte AUTOLOGOUT = 16;
/*    */   public static final String ACCOUNT_LOCKED_OUT = "ACCOUNT_LOCKED_OUT";
/*    */   public static final String EMPLOYEE_NOT_AT_STORE = "EMPLOYEE_NOT_AT_STORE";
/*    */   public static final String INVALID_BIO_SCAN = "INVALID_BIO_SCAN";
/*    */   public static final String INVALID_EMP_SCAN = "INVALID_EMP_SCAN";
/*    */   public static final String INVALID_PASSWORD = "INVALID_PASSWORD";
/*    */   public static final String INVALID_USERID = "INVALID_USERID";
/*    */   public static final String PASSWORD_EXPIRED = "PASSWORD_EXPIRED";
/* 46 */   public static final ValueKey<ISystemUser> CURRENT_ADDITIONAL_SECURITY_USER = new ValueKey(ISystemUser.class, "CURRENT_ADDITIONAL_SECURITY_USER");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 53 */   public static final ValueKey<String[]> CURRENT_PRIVILEGES = new ValueKey(String[].class, "CURRENT_PRIVILEGES");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 60 */   public static final ValueKey<ISystemUser> CURRENT_SECOND_PROMPT_USER = new ValueKey(ISystemUser.class, "CURRENT_SECOND_PROMPT_USER");
/*    */ 
/*    */ 
/*    */   
/* 64 */   public static final ValueKey<ProcessingStep> CURRENT_SECURITY_PROCESSING_STEP = new ValueKey(ProcessingStep.class, "CURRENT_PROCESSING_STEP");
/*    */ 
/*    */ 
/*    */   
/* 68 */   public static final ValueKey<SecurityRequest> CURRENT_SECURITY_REQUEST = new ValueKey(SecurityRequest.class, "CURRENT_SECURITY_REQUEST");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 77 */   public static final ValueKey<IAccessLevel> CURRENT_USER_ACCESS_LEVEL = new ValueKey(IAccessLevel.class, "CURRENT_USER_ACCESS_LEVEL");
/*    */ 
/*    */ 
/*    */   
/* 81 */   public static final ValueKey<String> ENTERED_USER_ID = new ValueKey(String.class, "ENTERED_USER_ID");
/*    */ 
/*    */ 
/*    */   
/* 85 */   public static final ValueKey<EncString> ENTERED_USER_PASSWORD = new ValueKey(EncString.class, "ENTERED_USER_PASSWORD");
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecurityConstants.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */