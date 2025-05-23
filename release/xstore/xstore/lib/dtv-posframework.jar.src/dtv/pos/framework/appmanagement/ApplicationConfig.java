/*    */ package dtv.pos.framework.appmanagement;
/*    */ 
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.framework.ApplicationData;
/*    */ import dtv.pos.framework.ui.config.ActionConfig;
/*    */ import dtv.pos.iframework.security.StationState;
/*    */ import dtv.pos.iframework.ui.config.IActionConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import javax.inject.Inject;
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
/*    */ public class ApplicationConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "Application";
/*    */   private static final String KEY_TAG = "Key";
/*    */   private static final String NAME_ATTRIB = "name";
/*    */   private static final String STARTUP_OP_CHAIN_KEY_TAG = "StartupOpChainKey";
/*    */   private static final String NEW_USER_OP_CHAIN_KEY_TAG = "NewUserOpChainKey";
/*    */   private static final String LOGIN_OP_CHAIN_KEY_TAG = "LoginOpChainKey";
/*    */   private static final String APPLICATION_LINK_TAG = "ApplicationLink";
/*    */   private static final String ENABLED = "enabled";
/* 39 */   private final Collection<String> applicationLinks_ = new ArrayList<>();
/*    */   
/*    */   private String _key;
/*    */   
/*    */   private OpChainKey _startupOpChainKey;
/*    */   
/*    */   private OpChainKey _newUserOpChainKey;
/*    */   private OpChainKey _loginOpChainKey;
/*    */   private ActionConfig _actionConfig;
/*    */   private boolean enabled_ = true;
/*    */   @Inject
/*    */   private StationState stationState;
/*    */   
/*    */   public ApplicationData getApplicationData() {
/* 53 */     ApplicationData applicationData = new ApplicationData(this._key, this._startupOpChainKey, this._newUserOpChainKey, this._loginOpChainKey, (IActionConfig)this._actionConfig, this.applicationLinks_, this.stationState);
/*    */ 
/*    */     
/* 56 */     return applicationData;
/*    */   }
/*    */   
/*    */   public boolean getIsEnabled() {
/* 60 */     return this.enabled_;
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 64 */     return this._key;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 70 */     if (argKey.equalsIgnoreCase("Key") || "name".equalsIgnoreCase(argKey)) {
/* 71 */       this._key = argValue.toString();
/*    */     }
/* 73 */     else if (argKey.equalsIgnoreCase("StartupOpChainKey")) {
/* 74 */       this._startupOpChainKey = OpChainKey.valueOf(argValue.toString());
/*    */     }
/* 76 */     else if (argKey.equalsIgnoreCase("NewUserOpChainKey")) {
/* 77 */       this._newUserOpChainKey = OpChainKey.valueOf(argValue.toString());
/*    */     }
/* 79 */     else if (argKey.equalsIgnoreCase("LoginOpChainKey")) {
/* 80 */       this._loginOpChainKey = OpChainKey.valueOf(argValue.toString());
/*    */     }
/* 82 */     else if (argValue instanceof ActionConfig) {
/* 83 */       this._actionConfig = (ActionConfig)argValue;
/*    */     }
/* 85 */     else if (argKey.equalsIgnoreCase("ApplicationLink")) {
/* 86 */       this.applicationLinks_.add(argValue.toString());
/*    */     }
/* 88 */     else if (argKey.equalsIgnoreCase("enabled")) {
/* 89 */       this.enabled_ = ConfigUtils.toBoolean(argValue);
/*    */     } else {
/*    */       
/* 92 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\appmanagement\ApplicationConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */