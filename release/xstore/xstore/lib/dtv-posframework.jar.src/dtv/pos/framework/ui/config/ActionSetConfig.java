/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.ui.config.IActionConfig;
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
/*     */ public class ActionSetConfig
/*     */   extends AbstractSetConfig<IActionConfig>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private static final Logger _logger = Logger.getLogger(ActionSetConfig.class);
/*     */   
/*  28 */   private final Map<String, IActionConfig> _namedConfigs = new HashMap<>();
/*     */   
/*  30 */   private List<IActionConfig> _referencingConfigs = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChild(IActionConfig argChild) {
/*  35 */     super.addChild((IConfigObject)argChild);
/*     */     
/*  37 */     if (!StringUtils.isBlank(argChild.getId())) {
/*  38 */       IActionConfig replaced = this._namedConfigs.put(argChild.getId(), argChild);
/*     */ 
/*     */ 
/*     */       
/*  42 */       if (replaced != null) {
/*  43 */         argChild.cascadeValues((IConfigObject)replaced);
/*     */       }
/*     */     } 
/*     */     
/*  47 */     if (!StringUtils.isBlank(argChild.getReference())) {
/*  48 */       this._referencingConfigs.add(argChild);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getChildTag() {
/*  55 */     return "Action";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, IActionConfig> getNamedConfigs() {
/*  63 */     return this._namedConfigs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/*  71 */     if (this.childList_ != null) {
/*  72 */       for (IActionConfig referencingConfig : this._referencingConfigs) {
/*  73 */         resolveReferences(referencingConfig);
/*     */       }
/*  75 */       this._referencingConfigs = null;
/*  76 */       this.childList_ = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resolveReference(IActionConfig argConfig) {
/*  87 */     IActionConfig referencedCfg = getReferencedConfig(argConfig);
/*     */     
/*  89 */     if (referencedCfg != null) {
/*  90 */       argConfig.cascadeValues((IConfigObject)referencedCfg);
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
/*     */   private IActionConfig getReferencedConfig(IActionConfig argConfig) {
/* 102 */     IActionConfig referencedCfg = null;
/* 103 */     String reference = argConfig.getReference();
/*     */     
/* 105 */     if (!StringUtils.isBlank(reference)) {
/* 106 */       referencedCfg = this._namedConfigs.get(reference);
/* 107 */       if (referencedCfg == null) {
/* 108 */         _logger.error("No action named [" + reference + "]!  Referring action [" + argConfig.getId() + "] is likely useless! @@ " + argConfig
/* 109 */             .getSourceDescription());
/*     */       }
/*     */     } 
/* 112 */     return referencedCfg;
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
/*     */   private void resolveReferences(IActionConfig argConfig) {
/* 130 */     IActionConfig currentConfig = argConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     Stack<IActionConfig> referencedCfgs = new Stack<>();
/*     */     do {
/* 137 */       referencedCfgs.push(currentConfig);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       IActionConfig tempConfig = currentConfig;
/*     */ 
/*     */       
/* 145 */       currentConfig = getReferencedConfig(tempConfig);
/* 146 */       tempConfig.setReference(null);
/*     */     }
/* 148 */     while (currentConfig != null);
/*     */     
/* 150 */     while (!referencedCfgs.empty()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       IActionConfig source = referencedCfgs.pop();
/*     */       
/* 158 */       if (!referencedCfgs.empty()) {
/* 159 */         IActionConfig target = referencedCfgs.peek();
/* 160 */         target.cascadeValues((IConfigObject)source);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ActionSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */