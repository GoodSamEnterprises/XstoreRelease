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
/*     */ public class ComponentGroupSetConfig
/*     */   extends AbstractSetConfig<ComponentGroupConfig>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  25 */   private static final Logger _logger = Logger.getLogger(ComponentGroupSetConfig.class);
/*     */   
/*  27 */   private final Map<String, ComponentGroupConfig> _namedConfigs = new HashMap<>();
/*     */   
/*  29 */   private List<ComponentGroupConfig> _referencingConfigs = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChild(ComponentGroupConfig argChild) {
/*  34 */     super.addChild((IConfigObject)argChild);
/*     */     
/*  36 */     if (!StringUtils.isBlank(argChild.getName())) {
/*  37 */       ComponentGroupConfig replaced = this._namedConfigs.put(argChild.getName(), argChild);
/*     */ 
/*     */ 
/*     */       
/*  41 */       if (replaced != null) {
/*  42 */         argChild.cascadeValues((IConfigObject)replaced);
/*     */       }
/*     */     } 
/*     */     
/*  46 */     if (!StringUtils.isBlank(argChild.getReference())) {
/*  47 */       this._referencingConfigs.add(argChild);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getChildTag() {
/*  54 */     return "ComponentGroup";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, ComponentGroupConfig> getNamedConfigs() {
/*  62 */     return this._namedConfigs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/*  70 */     if (this.childList_ != null) {
/*  71 */       for (ComponentGroupConfig referencingConfig : this._referencingConfigs) {
/*  72 */         resolveReferences(referencingConfig);
/*     */       }
/*  74 */       this._referencingConfigs = null;
/*  75 */       this.childList_ = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resolveReference(ComponentGroupConfig argConfig) {
/*  85 */     ComponentGroupConfig referencedCfg = getReferencedConfig(argConfig);
/*     */     
/*  87 */     if (referencedCfg != null) {
/*  88 */       argConfig.cascadeValues((IConfigObject)referencedCfg);
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
/*     */   private ComponentGroupConfig getReferencedConfig(ComponentGroupConfig argConfig) {
/* 100 */     ComponentGroupConfig referencedCfg = null;
/* 101 */     String reference = argConfig.getReference();
/*     */     
/* 103 */     if (!StringUtils.isBlank(reference)) {
/* 104 */       referencedCfg = this._namedConfigs.get(reference);
/* 105 */       if (referencedCfg == null) {
/* 106 */         _logger.error("No component group named [" + reference + "]!  Referring component group [" + argConfig
/* 107 */             .getName() + "] is likely useless! @@ " + argConfig.getSourceDescription());
/*     */       }
/*     */     } 
/* 110 */     return referencedCfg;
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
/*     */   private void resolveReferences(ComponentGroupConfig argConfig) {
/* 128 */     ComponentGroupConfig currentConfig = argConfig;
/*     */ 
/*     */ 
/*     */     
/* 132 */     Stack<ComponentGroupConfig> referencedCfgs = new Stack<>();
/*     */     do {
/* 134 */       referencedCfgs.push(currentConfig);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       ComponentGroupConfig tempConfig = currentConfig;
/*     */ 
/*     */       
/* 142 */       currentConfig = getReferencedConfig(tempConfig);
/* 143 */       tempConfig.setReference((String)null);
/*     */     }
/* 145 */     while (currentConfig != null);
/*     */     
/* 147 */     while (!referencedCfgs.empty()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       ComponentGroupConfig source = referencedCfgs.pop();
/*     */       
/* 155 */       if (!referencedCfgs.empty()) {
/* 156 */         ComponentGroupConfig target = referencedCfgs.peek();
/* 157 */         target.cascadeValues((IConfigObject)source);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentGroupSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */