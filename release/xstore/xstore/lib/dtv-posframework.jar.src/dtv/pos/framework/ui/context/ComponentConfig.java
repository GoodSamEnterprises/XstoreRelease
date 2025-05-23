/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterListConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComponentConfig
/*     */   extends AbstractParentConfig
/*     */   implements IConfigObject
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "Component";
/*     */   private static final String NAME_TAG = "Name";
/*     */   private static final String VISIBLE_TAG = "Visible";
/*     */   private static final String ENABLED_TAG = "Enabled";
/*     */   private String name_;
/*     */   private Boolean visible_;
/*     */   private Boolean enabled_;
/*     */   private ParameterListConfig parameters_;
/*     */   
/*     */   public boolean equals(Object obj) {
/*  32 */     if (obj == this) {
/*  33 */       return true;
/*     */     }
/*  35 */     if (!(obj instanceof ComponentConfig)) {
/*  36 */       return false;
/*     */     }
/*  38 */     ComponentConfig compareObj = (ComponentConfig)obj;
/*  39 */     if (compareObj.name_ == null || this.name_ == null) {
/*  40 */       return false;
/*     */     }
/*  42 */     return compareObj.name_.equals(this.name_);
/*     */   }
/*     */   
/*     */   public ComponentState getComponentState() {
/*  46 */     return new ComponentState(getName(), isVisible(), isEnabled(), getParameters());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  51 */     if (this.name_ == null) {
/*  52 */       return super.hashCode();
/*     */     }
/*  54 */     return this.name_.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  59 */     if (argKey.equalsIgnoreCase("Name")) {
/*  60 */       setName(argValue.toString());
/*     */     }
/*  62 */     else if (argKey.equalsIgnoreCase("Visible")) {
/*  63 */       setVisible(((BooleanConfig)argValue).getBoolean());
/*     */     }
/*  65 */     else if (argKey.equalsIgnoreCase("Enabled")) {
/*  66 */       setEnabled(((BooleanConfig)argValue).getBoolean());
/*     */     }
/*  68 */     else if (argValue instanceof ParameterListConfig) {
/*  69 */       setParameters((ParameterListConfig)argValue);
/*     */     } else {
/*     */       
/*  72 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getName() {
/*  77 */     return this.name_;
/*     */   }
/*     */   
/*     */   private ParameterListConfig getParameters() {
/*  81 */     return this.parameters_;
/*     */   }
/*     */   
/*     */   private boolean isEnabled() {
/*  85 */     return ConfigUtils.asBool(this.enabled_, true);
/*     */   }
/*     */   
/*     */   private boolean isVisible() {
/*  89 */     return ConfigUtils.asBool(this.visible_, true);
/*     */   }
/*     */   
/*     */   private void setEnabled(Boolean config) {
/*  93 */     this.enabled_ = config;
/*     */   }
/*     */   
/*     */   private void setName(String config) {
/*  97 */     this.name_ = config;
/*     */   }
/*     */   
/*     */   private void setParameters(ParameterListConfig parameters) {
/* 101 */     this.parameters_ = parameters;
/*     */   }
/*     */   
/*     */   private void setVisible(Boolean config) {
/* 105 */     this.visible_ = config;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */