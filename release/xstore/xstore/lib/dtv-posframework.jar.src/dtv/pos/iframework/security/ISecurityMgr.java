/*    */ package dtv.pos.iframework.security;
/*    */ 
/*    */ import dtv.data2.access.IQueryKey;
/*    */ import dtv.data2.access.QueryKey;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.common.PromptKey;
/*    */ import dtv.pos.iframework.IModel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import dtv.xst.dao.sec.IPrivilege;
/*    */ import dtv.xst.daocommon.ISystemUser;
/*    */ import javax.security.auth.login.LoginException;
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
/*    */ public interface ISecurityMgr
/*    */   extends IModel, ISecurityCallback
/*    */ {
/* 28 */   public static final IQueryKey<IPrivilege> SECURITY_PRIVILEGES = (IQueryKey<IPrivilege>)new QueryKey("SECURITY_PRIVILEGES", IPrivilege.class);
/*    */ 
/*    */ 
/*    */   
/* 32 */   public static final EventEnum LOGIN = new EventEnum("LOGIN");
/* 33 */   public static final EventEnum LOGOUT = new EventEnum("LOGOUT");
/*    */   
/*    */   ISystemUser authenticate(long paramLong);
/*    */   
/*    */   ISystemUser authenticateUser(String paramString) throws LoginException;
/*    */   
/*    */   IAccessLevel authorize(ISystemUser paramISystemUser, String... paramVarArgs);
/*    */   
/*    */   IFormattable getLoginFailureMessage();
/*    */   
/*    */   byte getLoginRequestType();
/*    */   
/*    */   byte getLogoutRequestType();
/*    */   
/*    */   byte[] getOverridePromptGroupMembership();
/*    */   
/*    */   ISecondPromptSettings getOverridePromptSettings();
/*    */   
/*    */   String getPreviouslyFailedUserId();
/*    */   
/*    */   byte getRequestType();
/*    */   
/*    */   ISecondPromptSettings getSecondPromptSetting(String paramString1, String paramString2);
/*    */   
/*    */   IFormattable getSecurityPromptDescription();
/*    */   
/*    */   IFormattable getSecurityPromptMessage();
/*    */   
/*    */   PromptKey getUserIdPromptKey();
/*    */   
/*    */   PromptKey getUserPasswordPromptKey();
/*    */   
/*    */   boolean isAuthenticatedUser(ISystemUser paramISystemUser1, ISystemUser paramISystemUser2);
/*    */   
/*    */   boolean isCurrentUserDefault(ISystemUser paramISystemUser);
/*    */   
/*    */   boolean isLoginSuccessful();
/*    */   
/*    */   boolean isPasswordExpired();
/*    */   
/*    */   boolean isReAuthenticationRequired(String[] paramArrayOfString);
/*    */   
/*    */   boolean isSecondPromptRequireDifferentEmployee(String[] paramArrayOfString);
/*    */   
/*    */   boolean isSecurityOverrideRequired(IAccessLevel paramIAccessLevel);
/*    */   
/*    */   void logSecurityAction(boolean paramBoolean);
/*    */   
/*    */   IAccessLevel merge(IAccessLevel paramIAccessLevel1, IAccessLevel paramIAccessLevel2);
/*    */   
/*    */   ISecondPromptSettings merge(ISecondPromptSettings paramISecondPromptSettings1, ISecondPromptSettings paramISecondPromptSettings2);
/*    */   
/*    */   void notifyUserLogin(ISystemUser paramISystemUser);
/*    */   
/*    */   void notifyUserLogout();
/*    */   
/*    */   void setChallengingQuestionRetryCount(int paramInt);
/*    */   
/*    */   void setLoginSuccessful(boolean paramBoolean);
/*    */   
/*    */   void setOverridePromptGroupMembership(byte[] paramArrayOfbyte);
/*    */   
/*    */   void setPreviouslyFailedUserId(String paramString);
/*    */   
/*    */   void setRequestType(byte paramByte);
/*    */   
/*    */   void setRetryCount(int paramInt);
/*    */   
/*    */   void setSecondPromptSettings(ISecondPromptSettings paramISecondPromptSettings);
/*    */   
/*    */   void setSecurityPromptDescription(IFormattable paramIFormattable);
/*    */   
/*    */   void setSecurityPromptMessage(IFormattable paramIFormattable);
/*    */   
/*    */   void setUserIdPromptKey(PromptKey paramPromptKey);
/*    */   
/*    */   void setUserPasswordPromptKey(PromptKey paramPromptKey);
/*    */   
/*    */   boolean getOneStepAuthenticate();
/*    */   
/*    */   void setOneStepAuthenticate(boolean paramBoolean);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecurityMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */