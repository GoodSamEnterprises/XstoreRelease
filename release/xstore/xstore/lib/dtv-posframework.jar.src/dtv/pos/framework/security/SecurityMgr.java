/*     */ package dtv.pos.framework.security;
/*     */ 
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleHelper;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.logbuilder.ILogBuilder;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.security.IAuthenticationModule;
/*     */ import dtv.pos.iframework.security.IAuthenticationModuleFactory;
/*     */ import dtv.pos.iframework.security.ISecondPromptSettings;
/*     */ import dtv.pos.iframework.security.ISecurityCallback;
/*     */ import dtv.pos.iframework.security.ISecurityLogModel;
/*     */ import dtv.pos.iframework.security.ISecurityMgr;
/*     */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.TypeSafeMapKey;
/*     */ import dtv.xst.dao.hrs.IEmployee;
/*     */ import dtv.xst.dao.sec.IPrivilege;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import javax.security.auth.login.LoginException;
/*     */ import org.apache.commons.lang3.LocaleUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class SecurityMgr implements ISecurityMgr, IModel {
/*  38 */   public static final EventEnum SET_SYSTEM_USER_EVENT = new EventEnum("set systemUser");
/*     */   
/*  40 */   private static final Logger _logger = Logger.getLogger(SecurityMgr.class);
/*     */   
/*     */   private PromptKey _userIdPromptKey;
/*     */   
/*     */   private PromptKey _userPasswordPromptKey;
/*     */   
/*     */   private boolean _oneStepAuthenticate;
/*     */   
/*     */   private byte _requestType;
/*     */   
/*     */   private byte[] _overridePromptGroupMembership;
/*     */   
/*     */   private boolean _loginSuccessful;
/*     */   
/*     */   private int _retryCount;
/*     */   
/*     */   private int _challengingQuestionRetryCount;
/*     */   
/*     */   private String _previouslyFailedUserId;
/*     */   
/*     */   private String _loginFailureReasonCode;
/*     */   
/*     */   private ISecondPromptSettings _overridePromptSettings;
/*     */   private IFormattable _loginFailureMessage;
/*     */   private IFormattable _securityPromptMessage;
/*     */   private IFormattable _securityPromptDescription;
/*     */   private IAuthenticationModuleFactory _authenticationModuleFactory;
/*     */   @Inject
/*     */   private ILogBuilder _logBuilder;
/*     */   @Inject
/*     */   private LocaleHelper _localeHelper;
/*     */   @Inject
/*     */   private LocaleManager _localeManager;
/*     */   @Inject
/*     */   private SecurityUtil _securityUtil;
/*     */   @Inject
/*     */   private FormattableFactory _FF;
/*     */   
/*     */   public SecurityMgr(IAuthenticationModuleFactory argAuthenticationModuleFactory) {
/*  79 */     this._authenticationModuleFactory = argAuthenticationModuleFactory;
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
/*     */   public ISystemUser authenticate(long argRetailLocationId) {
/*  92 */     ISystemUser authenticatedUser = null;
/*     */     
/*  94 */     List<IAuthenticationModule> authenticationModules = this._authenticationModuleFactory.createModules(IAuthenticationModule.AuthenticationModuleType.STANDARD.name());
/*     */     
/*  96 */     if (authenticationModules == null || authenticationModules.isEmpty()) {
/*  97 */       throw new IllegalArgumentException("No authentication modules were provided to the security manager. At least one module is required.");
/*     */     }
/*     */ 
/*     */     
/* 101 */     for (IAuthenticationModule module : authenticationModules) {
/* 102 */       if (module.isApplicable()) {
/* 103 */         module.setSecurityCallback((ISecurityCallback)this);
/* 104 */         authenticatedUser = module.authenticate();
/*     */         
/* 106 */         if (authenticatedUser == null && !isPasswordExpired()) {
/* 107 */           return null;
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 114 */     IEmployee employee = (IEmployee)authenticatedUser;
/*     */     
/* 116 */     if (employee == null || employee.isTerminated(DateUtils.clearTime(DateUtils.getNewDate()))) {
/* 117 */       return null;
/*     */     }
/*     */     
/* 120 */     if (!employee.isActiveForStore(argRetailLocationId, DateUtils.clearTime(DateUtils.getNewDate()))) {
/* 121 */       setLoginFailureMessage(this._FF.getTranslatable("_employeeNotAtThisStore"));
/* 122 */       setLoginFailureReasonCode("EMPLOYEE_NOT_AT_STORE");
/* 123 */       return null;
/*     */     } 
/*     */     
/* 126 */     return authenticatedUser;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISystemUser authenticateUser(String argPrivilegeType) throws LoginException {
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAccessLevel authorize(ISystemUser argUser, String... argPrivileges) {
/* 142 */     IAccessLevel level = null;
/* 143 */     ISecondPromptSettings secondPromptSettings = SecondPromptSettings.NO_PROMPT;
/*     */     
/* 145 */     for (String element : argPrivileges) {
/*     */       
/* 147 */       IPrivilege privilege = this._securityUtil.getPrivilege(element);
/*     */       
/* 149 */       if (privilege == null) {
/* 150 */         _logger.error("Missing privilege in database [" + element + "]");
/* 151 */         return (IAccessLevel)AccessLevel.DENIED;
/*     */       } 
/*     */       
/* 154 */       if (argUser != null) {
/* 155 */         level = merge(level, this._securityUtil.getAccessLevel(element, argUser.getGroupMembership()));
/*     */       }
/*     */ 
/*     */       
/* 159 */       secondPromptSettings = merge(secondPromptSettings, getSecondPromptSetting(element, privilege.getSecondPromptSettings()));
/*     */       
/* 161 */       if (secondPromptSettings.isRequireGroupMembership()) {
/* 162 */         setOverridePromptGroupMembership(privilege.getSecondPromptGroupMembership());
/*     */       } else {
/*     */         
/* 165 */         setOverridePromptGroupMembership(null);
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     setSecondPromptSettings(secondPromptSettings);
/*     */ 
/*     */     
/* 172 */     if (_logger.isInfoEnabled()) {
/* 173 */       _logger.info("Authentication attempt: [" + level.toString() + "]");
/*     */     }
/*     */     
/* 176 */     return level;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getChallengingQuestionRetryCount() {
/* 182 */     return this._challengingQuestionRetryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getLoginFailureMessage() {
/* 188 */     return this._loginFailureMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoginFailureReasonCode() {
/* 194 */     return this._loginFailureReasonCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getLoginRequestType() {
/* 200 */     return 11;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getLogoutRequestType() {
/* 206 */     return 8;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getOneStepAuthenticate() {
/* 212 */     return this._oneStepAuthenticate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getOverridePromptGroupMembership() {
/* 218 */     return this._overridePromptGroupMembership;
/*     */   }
/*     */ 
/*     */   
/*     */   public ISecondPromptSettings getOverridePromptSettings() {
/* 223 */     return this._overridePromptSettings;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPreviouslyFailedUserId() {
/* 228 */     return this._previouslyFailedUserId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getRequestType() {
/* 234 */     return this._requestType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRetryCount() {
/* 240 */     return this._retryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISecondPromptSettings getSecondPromptSetting(String privilegeName, String secondPromptSettingName) {
/* 248 */     if ("NO_PROMPT".equalsIgnoreCase(secondPromptSettingName) || 
/* 249 */       StringUtils.isEmpty(secondPromptSettingName)) {
/* 250 */       return SecondPromptSettings.NO_PROMPT;
/*     */     }
/* 252 */     if ("REQUIRE_GRP_MEMBERSHIP".equalsIgnoreCase(secondPromptSettingName)) {
/* 253 */       return SecondPromptSettings.REQUIRE_GRP_MEMBERSHIP;
/*     */     }
/* 255 */     if ("ANY_EMP_OK".equalsIgnoreCase(secondPromptSettingName)) {
/* 256 */       return SecondPromptSettings.ANY_EMP_OK;
/*     */     }
/*     */     
/* 259 */     _logger.warn("Unexpected second prompt setting for privilege " + privilegeName + ".  Second prompt setting = " + secondPromptSettingName);
/*     */ 
/*     */     
/* 262 */     return SecondPromptSettings.NO_PROMPT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getSecurityPromptDescription() {
/* 268 */     return this._securityPromptDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getSecurityPromptMessage() {
/* 274 */     return this._securityPromptMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptKey getUserIdPromptKey() {
/* 280 */     return this._userIdPromptKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptKey getUserPasswordPromptKey() {
/* 286 */     return this._userPasswordPromptKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAuthenticatedUser(ISystemUser argLoggedInUser, ISystemUser argUser) {
/* 292 */     if (argUser == null) {
/* 293 */       return false;
/*     */     }
/* 295 */     if (argLoggedInUser == null) {
/* 296 */       return false;
/*     */     }
/* 298 */     return (argUser.getOperatorId() == argLoggedInUser.getOperatorId());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentUserDefault(ISystemUser argCurrentUser) {
/* 304 */     return (argCurrentUser == DefaultSystemUser.INSTANCE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLoginSuccessful() {
/* 310 */     return this._loginSuccessful;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPasswordExpired() {
/* 316 */     return "PASSWORD_EXPIRED".equalsIgnoreCase(getLoginFailureReasonCode());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReAuthenticationRequired(String[] argPrivileges) {
/* 322 */     if (argPrivileges == null) {
/* 323 */       return false;
/*     */     }
/* 325 */     boolean reauthenticate = false;
/* 326 */     for (String privilegeString : argPrivileges) {
/* 327 */       IPrivilege privilege = this._securityUtil.getPrivilege(privilegeString);
/* 328 */       if (privilege.getAuthenticationRequired()) {
/* 329 */         reauthenticate = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 334 */     return reauthenticate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecondPromptRequireDifferentEmployee(String[] argPrivileges) {
/* 340 */     if (argPrivileges == null) {
/* 341 */       return false;
/*     */     }
/*     */     
/* 344 */     for (String privilegeString : argPrivileges) {
/* 345 */       IPrivilege privilege = this._securityUtil.getPrivilege(privilegeString);
/* 346 */       if (privilege.getSecondPromptReqrDiffEmp()) {
/* 347 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 351 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSecurityOverrideRequired(IAccessLevel argAccessLevel) {
/* 356 */     if (argAccessLevel == null) {
/* 357 */       return false;
/*     */     }
/* 359 */     return AccessLevel.DENIED_OVERRIDABLE.equals(argAccessLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUserDefault(ISystemUser user) {
/* 368 */     return user instanceof DefaultSystemUser;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logSecurityAction(boolean argSuccessful) {
/* 374 */     ISecurityLogModel logModel = new SecurityLogModel(argSuccessful);
/* 375 */     Map<TypeSafeMapKey<?>, Object> settings = new HashMap<>();
/* 376 */     settings.put(ISecurityLogModel.PROP_SECURITY_LOG_MODEL, logModel);
/*     */     
/* 378 */     this._logBuilder.saveLogEntry(logModel, settings);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAccessLevel merge(IAccessLevel al1, IAccessLevel al2) {
/* 384 */     if (al1 == null) {
/* 385 */       return al2;
/*     */     }
/* 387 */     if (al2 == null) {
/* 388 */       return al1;
/*     */     }
/*     */     
/* 391 */     if (al1.compareTo(al2) > 0)
/*     */     {
/* 393 */       return al2;
/*     */     }
/*     */     
/* 396 */     return al1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISecondPromptSettings merge(ISecondPromptSettings sps1, ISecondPromptSettings sps2) {
/* 403 */     if (sps1 == null) {
/* 404 */       return sps2;
/*     */     }
/* 406 */     if (sps2 == null) {
/* 407 */       return sps1;
/*     */     }
/*     */ 
/*     */     
/* 411 */     if (sps1.compareTo(sps2) > 0) {
/* 412 */       return sps2;
/*     */     }
/*     */     
/* 415 */     return sps1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyUserLogin(ISystemUser argUser) {
/* 422 */     DefaultEventor defaultEventor = new DefaultEventor((IEventSource)this);
/* 423 */     Locale newLocale = LocaleUtils.toLocale(argUser.getPreferredLocale());
/* 424 */     this._localeManager.setLocale(newLocale, OutputContextType.VIEW);
/* 425 */     defaultEventor.post(ISecurityMgr.LOGIN, argUser);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyUserLogout() {
/* 431 */     DefaultEventor defaultEventor = new DefaultEventor((IEventSource)this);
/* 432 */     Locale newLocale = this._localeHelper.getDefaultLocale(OutputContextType.VIEW);
/* 433 */     this._localeManager.setLocale(newLocale, OutputContextType.VIEW);
/* 434 */     defaultEventor.post(ISecurityMgr.LOGOUT, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChallengingQuestionRetryCount(int argChallengingQuestionRetryCount) {
/* 443 */     this._challengingQuestionRetryCount = argChallengingQuestionRetryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginFailureMessage(IFormattable argLoginFailureMessage) {
/* 452 */     this._loginFailureMessage = argLoginFailureMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginFailureReasonCode(String argLoginFailureReasonCode) {
/* 458 */     this._loginFailureReasonCode = argLoginFailureReasonCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginSuccessful(boolean argLoginSuccessful) {
/* 464 */     this._loginSuccessful = argLoginSuccessful;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOneStepAuthenticate(boolean argOneStepAuthenticate) {
/* 470 */     this._oneStepAuthenticate = argOneStepAuthenticate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverridePromptGroupMembership(byte[] argSecondPromptGroup) {
/* 476 */     this._overridePromptGroupMembership = argSecondPromptGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPreviouslyFailedUserId(String argPreviouslyFailedUserId) {
/* 482 */     this._previouslyFailedUserId = argPreviouslyFailedUserId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequestType(byte argRequestType) {
/* 488 */     this._requestType = argRequestType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetryCount(int argRetryCount) {
/* 494 */     this._retryCount = argRetryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecondPromptSettings(ISecondPromptSettings argSecondPromptSettings) {
/* 500 */     this._overridePromptSettings = argSecondPromptSettings;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecurityPromptDescription(IFormattable argSecurityDescription) {
/* 506 */     this._securityPromptDescription = argSecurityDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecurityPromptMessage(IFormattable argSecurityFailureMessage) {
/* 512 */     this._securityPromptMessage = argSecurityFailureMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserIdPromptKey(PromptKey argUserIdPromptKey) {
/* 518 */     this._userIdPromptKey = argUserIdPromptKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserPasswordPromptKey(PromptKey argUserPasswordPromptKey) {
/* 524 */     this._userPasswordPromptKey = argUserPasswordPromptKey;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\SecurityMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */