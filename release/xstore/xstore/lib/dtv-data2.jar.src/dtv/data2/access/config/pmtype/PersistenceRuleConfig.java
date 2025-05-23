/*    */ package dtv.data2.access.config.pmtype;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
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
/*    */ public class PersistenceRuleConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private final List<ParameterConfig> _parameters = new ArrayList<>();
/*    */ 
/*    */   
/*    */   private ClassConfig<?> _classConfig;
/*    */ 
/*    */   
/*    */   private String _beanName;
/*    */ 
/*    */ 
/*    */   
/*    */   public List<ParameterConfig> getParameters() {
/* 35 */     return this._parameters;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRuleBeanName() {
/* 43 */     return this._beanName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> getRuleClass() {
/* 53 */     return (this._classConfig == null) ? null : this._classConfig.getValue();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 59 */     if ("Class".equalsIgnoreCase(argKey)) {
/* 60 */       this._classConfig = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 62 */     else if (argValue instanceof ParameterConfig) {
/* 63 */       this._parameters.add((ParameterConfig)argValue);
/*    */     }
/* 65 */     else if ("BeanName".equalsIgnoreCase(argKey)) {
/* 66 */       this._beanName = argValue.toString();
/*    */     } else {
/*    */       
/* 69 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\PersistenceRuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */