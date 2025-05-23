/*    */ package dtv.logbuilder.config;
/*    */ 
/*    */ import dtv.logbuilder.writers.ILogEntryWriter;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ParameterConfig;
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
/*    */ public class LogDestinationConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private final Map<String, IConfigObject> parameters_ = new HashMap<>(4);
/*    */ 
/*    */   
/*    */   private LogFileConfig parent_;
/*    */ 
/*    */   
/*    */   private ClassConfig<ILogEntryWriter> implClass_;
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<ILogEntryWriter> getImplementationClass() {
/* 35 */     return this.implClass_.getValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, IConfigObject> getParameters() {
/* 44 */     return this.parameters_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IConfigObject getParamValue(String argKey) {
/* 54 */     return this.parameters_.get(argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LogFileConfig getParent() {
/* 62 */     return this.parent_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 69 */     if ("class".equalsIgnoreCase(argKey) || argValue instanceof ClassConfig) {
/* 70 */       this.implClass_ = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 72 */     else if (argValue instanceof ParameterConfig) {
/* 73 */       ParameterConfig config = (ParameterConfig)argValue;
/* 74 */       this.parameters_.put(config.getName(), config.getValue());
/*    */     } else {
/*    */       
/* 77 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   void setParent(LogFileConfig argParent) {
/* 82 */     this.parent_ = argParent;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\LogDestinationConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */