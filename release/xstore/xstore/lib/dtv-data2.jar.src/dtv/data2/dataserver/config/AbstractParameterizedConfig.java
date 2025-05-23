/*    */ package dtv.data2.dataserver.config;
/*    */ 
/*    */ import dtv.util.IHasParameters;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import dtv.util.config.MapConfig;
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
/*    */ public abstract class AbstractParameterizedConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String PARAMETERS_TAG = "Parameters";
/* 26 */   private final Map<String, Object> _defaultParameters = new HashMap<>();
/*    */   
/* 28 */   private Map<String, Object> _parameters = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, Object> getDefaultParameters() {
/* 36 */     return this._defaultParameters;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, Object> getParameters() {
/* 44 */     return this._parameters;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getParameterValue(String argName) {
/* 53 */     Map<String, Object> parameters = getParameters();
/* 54 */     return parameters.get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 61 */     if ("Parameters".equalsIgnoreCase(argKey) && argValue instanceof MapConfig) {
/* 62 */       this._parameters = ((MapConfig)argValue).getParamValue();
/*    */     }
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
/*    */   public void setDefaultParameters(Map<String, Object> argDefaultParameters) {
/* 75 */     this._defaultParameters.putAll(argDefaultParameters);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addParameters(IHasParameters argParameterizable) {
/* 86 */     Map<String, Object> actualParameters = new HashMap<>();
/* 87 */     actualParameters.putAll(this._defaultParameters);
/*    */     
/* 89 */     if (getParameters() != null) {
/* 90 */       actualParameters.putAll(getParameters());
/*    */     }
/*    */     
/* 93 */     for (Map.Entry<String, Object> parameter : actualParameters.entrySet()) {
/*    */ 
/*    */       
/* 96 */       Object value = (parameter.getValue() instanceof IReflectionParameterCapable) ? ((IReflectionParameterCapable)parameter.getValue()).getParamValue() : parameter.getValue();
/*    */       
/* 98 */       argParameterizable.setParameter(parameter.getKey(), value);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\AbstractParameterizedConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */