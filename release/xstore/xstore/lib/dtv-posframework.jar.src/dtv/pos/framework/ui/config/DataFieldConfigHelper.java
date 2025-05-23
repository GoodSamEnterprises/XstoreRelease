/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractSetConfig;
/*     */ import dtv.util.config.ConfigHelper;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataFieldConfigHelper
/*     */   extends ConfigHelper<DataFieldConfigHelper.DataFieldSetConfig>
/*     */ {
/*  26 */   private static final DataFieldConfigHelper _instance = new DataFieldConfigHelper(); static {
/*  27 */     _instance.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataFieldConfig getFieldConfig(String argName) {
/*  38 */     return _instance.getFieldConfigImpl(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String normalize(String argName) {
/*  44 */     return argName.trim().toUpperCase();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/*  50 */     return "DataFieldConfig";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/*  56 */     if ("DataFields".equalsIgnoreCase(argDtype)) {
/*  57 */       return (IConfigObject)new DataFieldSetConfig();
/*     */     }
/*  59 */     if ("DataField".equalsIgnoreCase(argDtype)) {
/*  60 */       return (IConfigObject)new DataFieldConfig();
/*     */     }
/*     */     
/*  63 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
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
/*     */   protected DataFieldConfig getFieldConfigImpl(String argName) {
/*  75 */     return ((DataFieldSetConfig)getRootConfig()).getDataFields().get(normalize(argName));
/*     */   }
/*     */ 
/*     */   
/*     */   protected static class DataFieldSetConfig
/*     */     extends AbstractSetConfig<DataFieldConfig>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*  84 */     private Map<String, DataFieldConfig> _configs = null;
/*     */ 
/*     */ 
/*     */     
/*     */     public String getChildTag() {
/*  89 */       return "DataField";
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Map<String, DataFieldConfig> getDataFields() {
/*  97 */       if (this._configs == null) {
/*  98 */         this._configs = new HashMap<>();
/*     */         
/* 100 */         for (DataFieldConfig config : getChildren()) {
/* 101 */           if (!StringUtils.isEmpty(config.getName())) {
/* 102 */             this._configs.put(DataFieldConfigHelper.normalize(config.getName()), config);
/*     */           }
/*     */         } 
/*     */       } 
/* 106 */       return this._configs;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\DataFieldConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */