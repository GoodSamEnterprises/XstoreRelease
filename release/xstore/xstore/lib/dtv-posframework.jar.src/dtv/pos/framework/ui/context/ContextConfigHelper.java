/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.util.config.ConfigHelper;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class ContextConfigHelper
/*     */   extends ConfigHelper<ContextSetConfig>
/*     */ {
/*     */   private static final String DEFAULT_CONTEXT_KEY = "DEFAULT";
/*  26 */   private static final Logger logger_ = Logger.getLogger(ContextConfigHelper.class);
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
/*  40 */   private final ConcurrentHashMap<String, UIContext> contextCache_ = new ConcurrentHashMap<>(10, 0.75F, 1);
/*     */   private Map<String, ContextConfig> contextConfigMap_;
/*     */   
/*     */   public UIContext getContext(String contextKey) {
/*  44 */     UIContext context = this.contextCache_.get(contextKey);
/*  45 */     if (context != null) {
/*  46 */       return context;
/*     */     }
/*     */     
/*  49 */     return getCascadedContext(contextKey);
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ComponentPropertySetConfigHelper _componentPropertySetHelper;
/*     */   @Inject
/*     */   private ComponentGroupConfigHelper _componentGroupHelper;
/*     */   
/*     */   protected synchronized UIContext getCascadedContext(String contextKey) {
/*  59 */     UIContext context = this.contextCache_.get(contextKey);
/*     */ 
/*     */     
/*  62 */     if (context != null) {
/*  63 */       return context;
/*     */     }
/*     */ 
/*     */     
/*  67 */     ContextConfig cfg = getCascadedConfig(contextKey);
/*  68 */     if (cfg == null) {
/*  69 */       return getDefaultContext();
/*     */     }
/*  71 */     context = cfg.getContext();
/*  72 */     UIContext previouslyCachedContext = this.contextCache_.putIfAbsent(contextKey, context);
/*     */     
/*  74 */     return (previouslyCachedContext != null) ? previouslyCachedContext : context;
/*     */   }
/*     */   
/*     */   public UIContext getDefaultContext() {
/*  78 */     return getContext("DEFAULT");
/*     */   }
/*     */ 
/*     */   
/*     */   public void initializeImpl() {
/*  83 */     super.initializeImpl();
/*  84 */     buildContextHash();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/*  93 */     return "ContextConfig";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String argDtype, IConfigObject argParent, String argSourceDescription) {
/* 100 */     IConfigObject configObject = super.getConfigObject(argTagName, argDtype, argParent, argSourceDescription);
/*     */ 
/*     */ 
/*     */     
/* 104 */     if (configObject instanceof ContextConfig) {
/* 105 */       ContextConfig contextConfig = (ContextConfig)configObject;
/* 106 */       contextConfig.setComponentGroupHelper(this._componentGroupHelper);
/* 107 */       contextConfig.setComponentPropertySetHelper(this._componentPropertySetHelper);
/*     */     } 
/*     */     
/* 110 */     return configObject;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void buildContextHash() {
/* 115 */     this.contextConfigMap_ = new HashMap<>();
/* 116 */     Collection<ContextSetConfig> c = getContexts();
/*     */     
/* 118 */     for (Iterator<ContextSetConfig> iter = c.iterator(); iter.hasNext(); ) {
/* 119 */       ContextConfig cfg = (ContextConfig)iter.next();
/* 120 */       cfg.hashPropertySets();
/* 121 */       this.contextConfigMap_.put(cfg.getContextKey(), cfg);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ContextConfig getCascadedConfig(String contextKey) {
/* 127 */     ContextConfig child = this.contextConfigMap_.get(contextKey);
/* 128 */     if (child == null) {
/* 129 */       logger_.warn("No context has been configured for [" + contextKey + "]!");
/* 130 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 134 */     if (child.getParentKey() != null) {
/* 135 */       ContextConfig parent = getCascadedConfig(child.getParentKey());
/*     */       
/* 137 */       if (parent != null)
/*     */       {
/* 139 */         child.cascadeValues((IConfigObject)parent);
/*     */       }
/*     */     } 
/* 142 */     return child;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<ContextSetConfig> getContexts() {
/* 151 */     return getRootChildren(ContextSetConfig.class);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ContextConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */