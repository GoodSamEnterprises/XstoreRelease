/*    */ package dtv.data2.security;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class SecurityConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private final Map<String, SecurityThreadContextConfig> threadContexts_ = new HashMap<>();
/*    */ 
/*    */   
/*    */   public SecurityThreadContextConfig getContext(String argName) {
/* 27 */     return this.threadContexts_.get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 33 */     if (argValue instanceof SecurityThreadContextConfig) {
/* 34 */       SecurityThreadContextConfig newConfig = (SecurityThreadContextConfig)argValue;
/* 35 */       SecurityThreadContextConfig prevConfig = this.threadContexts_.get(newConfig.getName());
/* 36 */       newConfig.merge(prevConfig);
/* 37 */       this.threadContexts_.put(newConfig.getName(), newConfig);
/*    */     } else {
/*    */       
/* 40 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\security\SecurityConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */