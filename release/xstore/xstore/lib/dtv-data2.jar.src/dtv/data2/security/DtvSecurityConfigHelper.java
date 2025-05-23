/*    */ package dtv.data2.security;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.StringConfig;
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
/*    */ public class DtvSecurityConfigHelper
/*    */   extends ConfigHelper<SecurityConfig>
/*    */ {
/* 19 */   public static final String SYSTEM_PROPERTY = DtvSecurityConfigHelper.class.getName();
/*    */   
/*    */   private static DtvSecurityConfigHelper INSTANCE;
/*    */ 
/*    */   
/*    */   static {
/* 25 */     String className = System.getProperty(SYSTEM_PROPERTY);
/*    */     
/*    */     try {
/* 28 */       instance = (DtvSecurityConfigHelper)Class.forName(className).newInstance();
/*    */     }
/* 30 */     catch (Throwable ex) {
/* 31 */       instance = new DtvSecurityConfigHelper();
/*    */     } 
/* 33 */     instance.initialize();
/* 34 */     INSTANCE = instance;
/*    */   }
/*    */ 
/*    */   
/*    */   static {
/*    */     DtvSecurityConfigHelper instance;
/*    */   }
/*    */ 
/*    */   
/*    */   public static DtvSecurityConfigHelper getInstance() {
/* 44 */     return INSTANCE;
/*    */   }
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
/*    */   public IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 58 */     if ("Security".equalsIgnoreCase(argDtype)) {
/* 59 */       return (IConfigObject)new SecurityConfig();
/*    */     }
/* 61 */     if ("ThreadContext".equalsIgnoreCase(argDtype)) {
/* 62 */       return (IConfigObject)new SecurityThreadContextConfig();
/*    */     }
/* 64 */     if ("allow".equalsIgnoreCase(argDtype) || "deny"
/* 65 */       .equalsIgnoreCase(argDtype) || "ignore"
/* 66 */       .equalsIgnoreCase(argDtype)) {
/* 67 */       return (IConfigObject)new StringConfig();
/*    */     }
/*    */     
/* 70 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ 
/*    */   
/*    */   public SecurityThreadContextConfig getContext(String argName) {
/* 75 */     return ((SecurityConfig)getRootConfig()).getContext(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 81 */     return "SecurityConfig";
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\security\DtvSecurityConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */