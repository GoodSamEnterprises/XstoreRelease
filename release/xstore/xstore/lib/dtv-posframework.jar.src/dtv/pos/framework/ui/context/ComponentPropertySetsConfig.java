/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.util.config.AbstractSetConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Stack;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class ComponentPropertySetsConfig
/*     */   extends AbstractSetConfig<ComponentPropertySetConfig>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  25 */   private static final Logger _logger = Logger.getLogger(ComponentPropertySetsConfig.class);
/*     */   
/*  27 */   private final Map<String, ComponentPropertySetConfig> _namedConfigs = new HashMap<>();
/*     */ 
/*     */   
/*  30 */   private List<ComponentPropertySetConfig> _referencingConfigs = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChild(ComponentPropertySetConfig argChild) {
/*  35 */     super.addChild((IConfigObject)argChild);
/*     */     
/*  37 */     if (!StringUtils.isBlank(argChild.getName())) {
/*  38 */       this._namedConfigs.put(argChild.getName(), argChild);
/*     */     }
/*     */     
/*  41 */     if (!StringUtils.isBlank(argChild.getReference())) {
/*  42 */       this._referencingConfigs.add(argChild);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getChildTag() {
/*  49 */     return "ComponentPropertySet";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, ComponentPropertySetConfig> getNamedConfigs() {
/*  57 */     return this._namedConfigs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/*  65 */     if (this.childList_ != null) {
/*  66 */       for (ComponentPropertySetConfig referencingConfig : this._referencingConfigs) {
/*  67 */         resolveReferences(referencingConfig);
/*     */       }
/*  69 */       this._referencingConfigs = null;
/*  70 */       this.childList_ = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resolveReference(ComponentPropertySetConfig argConfig) {
/*  80 */     ComponentPropertySetConfig referencedCfg = getReferencedConfig(argConfig);
/*     */     
/*  82 */     if (referencedCfg != null) {
/*  83 */       argConfig.cascadeValues((IConfigObject)referencedCfg);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ComponentPropertySetConfig getReferencedConfig(ComponentPropertySetConfig argConfig) {
/*  95 */     ComponentPropertySetConfig referencedCfg = null;
/*  96 */     String reference = argConfig.getReference();
/*     */     
/*  98 */     if (!StringUtils.isBlank(reference)) {
/*  99 */       referencedCfg = this._namedConfigs.get(reference);
/* 100 */       if (referencedCfg == null) {
/* 101 */         _logger.error("No component property set named [" + reference + "]!  Referring component property set [" + argConfig
/* 102 */             .getName() + "] is likely useless! @@ " + argConfig
/* 103 */             .getSourceDescription());
/*     */       }
/*     */     } 
/* 106 */     return referencedCfg;
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
/*     */   private void resolveReferences(ComponentPropertySetConfig argConfig) {
/* 124 */     ComponentPropertySetConfig currentConfig = argConfig;
/*     */ 
/*     */ 
/*     */     
/* 128 */     Stack<ComponentPropertySetConfig> referencedCfgs = new Stack<>();
/*     */     do {
/* 130 */       referencedCfgs.push(currentConfig);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       ComponentPropertySetConfig tempConfig = currentConfig;
/*     */ 
/*     */       
/* 138 */       currentConfig = getReferencedConfig(tempConfig);
/* 139 */       tempConfig.setReference((String)null);
/*     */     }
/* 141 */     while (currentConfig != null);
/*     */     
/* 143 */     while (!referencedCfgs.empty()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       ComponentPropertySetConfig source = referencedCfgs.pop();
/*     */       
/* 151 */       if (!referencedCfgs.empty()) {
/* 152 */         ComponentPropertySetConfig target = referencedCfgs.peek();
/* 153 */         target.cascadeValues((IConfigObject)source);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentPropertySetsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */