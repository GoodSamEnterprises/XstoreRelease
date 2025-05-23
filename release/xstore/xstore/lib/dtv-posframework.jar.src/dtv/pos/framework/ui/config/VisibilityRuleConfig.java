/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VisibilityRuleConfig
/*     */   extends AbstractParentConfig
/*     */   implements IConfigObject, ISavableConfig
/*     */ {
/*  25 */   private static final Logger logger_ = Logger.getLogger(VisibilityRuleConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "VisibilityRule";
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String CLASS_TAG = "class";
/*  31 */   private final List<ParameterConfig> parameters_ = new ArrayList<>();
/*     */   private ClassConfig<IVisibilityRule> ruleClassConfig_;
/*     */   
/*     */   public List<ParameterConfig> getParameters() {
/*  35 */     return this.parameters_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<IVisibilityRule> getVisibilityRuleClass() {
/*  40 */     return (this.ruleClassConfig_ == null) ? null : this.ruleClassConfig_.getValue();
/*     */   }
/*     */   
/*     */   public IVisibilityRule getVisibilityRule() {
/*  44 */     if (this.ruleClassConfig_ == null) {
/*  45 */       return null;
/*     */     }
/*     */     
/*  48 */     Class clazz = null;
/*     */     try {
/*  50 */       clazz = this.ruleClassConfig_.getValue();
/*     */     }
/*  52 */     catch (Exception ex) {
/*  53 */       logger_.error("CAUGHT EXCEPTION with " + this.ruleClassConfig_.getSourceDescription(), ex);
/*     */     } 
/*  55 */     if (clazz == null) {
/*  56 */       return null;
/*     */     }
/*     */     
/*  59 */     IVisibilityRule rule = null;
/*     */     try {
/*  61 */       rule = this.ruleClassConfig_.getValue().newInstance();
/*  62 */       rule.setSourceDescription(getSourceDescription());
/*     */       
/*  64 */       for (ParameterConfig c : this.parameters_) {
/*  65 */         rule.setParameter(c.getName(), c.getValue());
/*     */       }
/*     */     }
/*  68 */     catch (Exception ex) {
/*  69 */       logger_.error("Problem instantiating rule " + this.ruleClassConfig_, ex);
/*     */     } 
/*  71 */     return rule;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  77 */     if ("class".equalsIgnoreCase(argKey) || argValue instanceof ClassConfig) {
/*  78 */       this.ruleClassConfig_ = ConfigUtils.toClassConfig(argValue);
/*     */     }
/*  80 */     else if ("privilege".equalsIgnoreCase(argKey)) {
/*  81 */       this.parameters_.add(new ParameterConfig(argKey, argValue));
/*     */     }
/*  83 */     else if (argValue instanceof ParameterConfig) {
/*  84 */       this.parameters_.add((ParameterConfig)argValue);
/*     */     } else {
/*     */       
/*  87 */       this.parameters_.add(new ParameterConfig(argKey, argValue));
/*     */     } 
/*  89 */     setClean();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/*  96 */     argWriter.writeHeader("VisibilityRule", "VisibilityRule", "class=\"" + this.ruleClassConfig_
/*  97 */         .getConfigValue() + "\"");
/*     */     
/*  99 */     argWriter.writeValue((ISavableConfig[])this.parameters_.toArray((Object[])new ParameterConfig[this.parameters_.size()]));
/* 100 */     argWriter.writeFooter("VisibilityRule");
/* 101 */     setClean();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\VisibilityRuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */