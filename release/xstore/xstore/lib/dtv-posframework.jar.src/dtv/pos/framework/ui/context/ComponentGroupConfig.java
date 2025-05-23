/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ICascadableConfig;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComponentGroupConfig
/*     */   extends AbstractParentConfig
/*     */   implements ICascadableConfig
/*     */ {
/*     */   public static final String MAIN_TAG = "ComponentGroup";
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String NAME_TAG = "name";
/*     */   private static final String REFERENCE_TAG = "ref";
/*     */   private static final String COMPONENT_PROPERTY_SET_TAG = "ComponentPropertySet";
/*     */   private String _name;
/*     */   private String _reference;
/*     */   private List<ComponentPropertySetConfig> componentPropertySetConfigs_;
/*     */   private ComponentPropertySetConfigHelper _componentPropertySetHelper;
/*     */   
/*     */   public void addComponentPropertySetConfig(ComponentPropertySetConfig argConfig) {
/*  41 */     if (argConfig.getReference() != null) {
/*     */       
/*  43 */       ComponentPropertySetConfig config = this._componentPropertySetHelper.getComponentPropertySetConfig(argConfig.getReference());
/*  44 */       argConfig.cascadeValues((IConfigObject)config);
/*     */     } 
/*  46 */     if (this.componentPropertySetConfigs_ == null) {
/*  47 */       this.componentPropertySetConfigs_ = new ArrayList<>();
/*     */     }
/*  49 */     this.componentPropertySetConfigs_.add(argConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cascadeValues(IConfigObject argValue) {
/*  55 */     if (argValue == null) {
/*     */       return;
/*     */     }
/*     */     
/*  59 */     ComponentGroupConfig config = (ComponentGroupConfig)argValue;
/*     */     
/*  61 */     if (getName() == null) {
/*  62 */       setName(config.getName());
/*     */     }
/*  64 */     if (getReference() == null) {
/*  65 */       setReference(config.getReference());
/*     */     }
/*  67 */     setComponentPropertySetConfigs(config.getComponentPropertySetConfigs());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ComponentPropertySetConfig> getComponentPropertySetConfigs() {
/*  76 */     return this.componentPropertySetConfigs_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  84 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReference() {
/*  92 */     return this._reference;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComponentPropertySetConfigs(List<ComponentPropertySetConfig> argConfigs) {
/* 100 */     this.componentPropertySetConfigs_ = argConfigs;
/*     */   }
/*     */   
/*     */   public void setComponentPropertySetHelper(ComponentPropertySetConfigHelper argComponentPropertySetHelper) {
/* 104 */     this._componentPropertySetHelper = argComponentPropertySetHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 110 */     if ("name".equalsIgnoreCase(argKey)) {
/* 111 */       setName(argValue.toString());
/*     */     }
/* 113 */     else if ("ref".equalsIgnoreCase(argKey)) {
/* 114 */       setReference(argValue.toString());
/*     */     }
/* 116 */     else if ("ComponentPropertySet".equalsIgnoreCase(argKey) && 
/* 117 */       argValue instanceof ComponentPropertySetConfig) {
/* 118 */       addComponentPropertySetConfig((ComponentPropertySetConfig)argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argValue) {
/* 128 */     this._name = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReference(String argValue) {
/* 136 */     this._reference = argValue;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */