/*    */ package dtv.pos.framework.reporting.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ReportActionConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String dataKey_;
/* 23 */   private final List<ParameterConfig> parameters_ = new ArrayList<>();
/*    */   
/*    */   public String getDataKey() {
/* 26 */     return this.dataKey_;
/*    */   }
/*    */   
/*    */   public ParameterConfig[] getParameters() {
/* 30 */     return this.parameters_.<ParameterConfig>toArray(new ParameterConfig[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 35 */     if ("DataKey".equalsIgnoreCase(argKey)) {
/* 36 */       this.dataKey_ = argValue.toString();
/*    */     }
/* 38 */     else if (argValue instanceof ParameterConfig) {
/* 39 */       this.parameters_.add((ParameterConfig)argValue);
/*    */     } else {
/*    */       
/* 42 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\config\ReportActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */