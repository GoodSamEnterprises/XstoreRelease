/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.pos.framework.touch.TouchConfig;
/*     */ import dtv.pos.framework.ui.config.ViewComponentConfig;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.ITabOrder;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public abstract class AbstractFormComponentConfig
/*     */   extends ViewComponentConfig<IFormComponentConfig>
/*     */   implements IFormComponentConfig<IFormComponentConfig>, ISavableConfig, ITabOrder
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected static final String PARAMETER_TAG = "Parameter";
/*     */   protected static final String TAB_ORDER_TAG = "TabOrder";
/*  33 */   private Integer tabOrder_ = Integer.valueOf(0);
/*     */   private Reference<IFormComponent> activeFormComponent_;
/*     */   private List<TouchConfig> touchConfigs_;
/*  36 */   private List<ParameterConfig> parameterList_ = new ArrayList<>();
/*     */   
/*     */   public void addParameter(ParameterConfig parameter) {
/*  39 */     this.parameterList_.add(parameter);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(IFormComponentConfig<?> other) {
/*  44 */     int comparison = getTabOrder().compareTo(((AbstractFormComponentConfig)other).getTabOrder());
/*  45 */     if (comparison != 0) {
/*  46 */       return comparison;
/*     */     }
/*     */     
/*  49 */     return getEditableLayoutLocation().compareTo(other.getEditableLayoutLocation());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormComponent getActiveFormComponent() {
/*  55 */     if (this.activeFormComponent_ == null) {
/*  56 */       return null;
/*     */     }
/*  58 */     return this.activeFormComponent_.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public ParameterConfig[] getParameters() {
/*  63 */     return this.parameterList_.<ParameterConfig>toArray(new ParameterConfig[this.parameterList_.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getTabOrder() {
/*  68 */     return this.tabOrder_;
/*     */   }
/*     */   
/*     */   public List<TouchConfig> getTouchConfigurations() {
/*  72 */     return this.touchConfigs_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setActiveFormComponent(IFormComponent newValue) {
/*  77 */     this.activeFormComponent_ = new WeakReference<>(newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  87 */     if (argKey.equalsIgnoreCase("TabOrder")) {
/*  88 */       setTabOrder(((IntegerConfig)argValue).getInteger());
/*     */     }
/*  90 */     else if (argValue instanceof TouchConfig) {
/*  91 */       addTouchConfiguration((TouchConfig)argValue);
/*     */     }
/*  93 */     else if (argValue instanceof ParameterConfig && argKey.equalsIgnoreCase("Parameter")) {
/*  94 */       addParameter((ParameterConfig)argValue);
/*     */     } else {
/*     */       
/*  97 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*  99 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTabOrder(Integer newValue) {
/* 104 */     this.tabOrder_ = newValue;
/* 105 */     setDirty();
/*     */   }
/*     */   
/*     */   protected void addTouchConfiguration(TouchConfig config) {
/* 109 */     if (this.touchConfigs_ == null) {
/* 110 */       this.touchConfigs_ = new ArrayList<>();
/*     */     }
/* 112 */     this.touchConfigs_.add(config);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\AbstractFormComponentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */