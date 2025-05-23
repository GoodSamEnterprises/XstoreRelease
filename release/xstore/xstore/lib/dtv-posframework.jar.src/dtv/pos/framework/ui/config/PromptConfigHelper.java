/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
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
/*     */ public class PromptConfigHelper
/*     */   extends ConfigHelper
/*     */ {
/*  26 */   private static final PromptConfigReloader PROMPT_CONFIG_RELOADER = new PromptConfigReloader();
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<PromptKey, IPromptConfig> _promptMap;
/*     */ 
/*     */ 
/*     */   
/*     */   private PromptConfigHelper() {
/*  35 */     initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPromptConfig getPromptConfig(PromptKey argPromptKey) {
/*  46 */     return getPromptConfig(argPromptKey, (PromptConfig)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptConfig getPromptConfig(PromptKey argPromptKey, PromptConfig argOverrideConfig) {
/*  65 */     if (PROMPT_CONFIG_RELOADER.reloadIfNeeded()) {
/*  66 */       initialize();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     PromptConfig retVal = (argOverrideConfig == null) ? new PromptConfig() : argOverrideConfig;
/*     */ 
/*     */     
/*  75 */     IPromptConfig config = this._promptMap.get(argPromptKey);
/*  76 */     if (config == null) {
/*  77 */       config = new PromptConfig(null);
/*     */     }
/*  79 */     retVal.cascadeValues((IConfigObject)config);
/*  80 */     return retVal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeImpl() {
/*  86 */     super.initializeImpl();
/*  87 */     Map<String, IPromptConfig> defaultPromptMap = new HashMap<>();
/*     */     
/*  89 */     for (IPromptConfig config : ((PromptSetConfig)getRootConfig()).getChildren()) {
/*  90 */       PromptKey promptKey = config.getPromptKey();
/*  91 */       if (promptKey == PromptKey.DEFAULT) {
/*  92 */         defaultPromptMap.put(config.getPromptType(), config);
/*     */ 
/*     */ 
/*     */         
/*  96 */         if (config instanceof PromptConfig) {
/*  97 */           ((PromptConfig)config).initialize();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     Map<PromptKey, IPromptConfig> newPromptMap = new HashMap<>();
/* 103 */     for (IPromptConfig config : ((PromptSetConfig)getRootConfig()).getChildren()) {
/* 104 */       PromptKey promptKey = config.getPromptKey();
/* 105 */       if (promptKey != PromptKey.DEFAULT) {
/* 106 */         newPromptMap.put(promptKey, config);
/*     */ 
/*     */         
/* 109 */         if (config instanceof PromptConfig) {
/* 110 */           ((PromptConfig)config).initialize();
/*     */         }
/*     */ 
/*     */         
/* 114 */         config.cascadeValues((IConfigObject)defaultPromptMap.get(config.getPromptType()));
/*     */       } 
/*     */     } 
/* 117 */     this._promptMap = newPromptMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/* 123 */     return "PromptConfig";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 129 */     if ("default".equalsIgnoreCase(argDtype)) {
/* 130 */       return null;
/*     */     }
/* 132 */     if ("PromptSet".equalsIgnoreCase(argDtype)) {
/* 133 */       return (IConfigObject)new PromptSetConfig();
/*     */     }
/* 135 */     if ("Prompt".equalsIgnoreCase(argDtype)) {
/* 136 */       return (IConfigObject)new PromptConfig();
/*     */     }
/* 138 */     if ("Section".equalsIgnoreCase(argDtype) || "PromptSection".equalsIgnoreCase(argDtype)) {
/* 139 */       return (IConfigObject)new PromptSectionConfig();
/*     */     }
/* 141 */     if ("DataSelection".equalsIgnoreCase(argDtype)) {
/* 142 */       return (IConfigObject)new DataSelectionConfig();
/*     */     }
/*     */     
/* 145 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\PromptConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */