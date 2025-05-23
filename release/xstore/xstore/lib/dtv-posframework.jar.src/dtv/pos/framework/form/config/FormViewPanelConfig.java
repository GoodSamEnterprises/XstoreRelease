/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.touch.TouchConfig;
/*     */ import dtv.pos.framework.ui.config.PrivilegeVisibilityRuleConfig;
/*     */ import dtv.pos.framework.ui.config.VisibilityRuleConfig;
/*     */ import dtv.pos.i18n.config.LiteralConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.form.config.FormPanelType;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.ui.config.IColorGroupConfig;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.io.IOException;
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
/*     */ public class FormViewPanelConfig
/*     */   extends AbstractFormComponentConfig
/*     */   implements IFormViewPanelConfig<IFormComponentConfig>
/*     */ {
/*     */   public static final String MAIN_TAG = "FormViewPanel";
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String PANEL_TYPE_TAG = "PanelType";
/*     */   private static final String FORM_TAB_KEY_TAG = "FormTabKey";
/*     */   private static final String RESOURCE_TAG = "Resource";
/*     */   private static final String TEXT_KEY_TAG = "TextKey";
/*     */   private static final String CUSTOM_VIEW_TAG = "CustomView";
/*     */   private static final String ACTION_SUB_GROUP_KEY_TAG = "ActionSubGroupKey";
/*     */   private static final String CHAIN_KEY_TAG = "ChainKey";
/*     */   private static final String DATA_KEY_TAG = "DataKey";
/*     */   private static final String BASE_CLASS_TAG = "class";
/*  54 */   private final List<VisibilityRuleConfig> _visibilityRuleConfigs = new ArrayList<>();
/*     */   
/*     */   private String resource_;
/*  57 */   private FormTabKey formTabKey_ = null;
/*  58 */   private IFormattableConfig textKeyConfig_ = (IFormattableConfig)new TranslatableConfig();
/*  59 */   private FormPanelType panelType_ = null;
/*     */   private ClassConfig<?> customViewClassConfig_;
/*  61 */   private String defaultClass_ = "Panel";
/*     */   
/*     */   private String _actionSubGroupKey;
/*     */   
/*     */   private IXstActionKey _chainKey;
/*     */   private IXstActionKey _dataKey;
/*     */   
/*     */   public int compareTo(IFormComponentConfig<?> o) {
/*  69 */     if (o instanceof FormViewPanelConfig) {
/*  70 */       FormViewPanelConfig other = (FormViewPanelConfig)o;
/*  71 */       return 1000 * getPanelType().compareTo((Enum)other.getPanelType()) + 
/*  72 */         getTabOrder().compareTo(other.getTabOrder());
/*     */     } 
/*     */     
/*  75 */     return super.compareTo(o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionSubGroupKey() {
/*  82 */     return this._actionSubGroupKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionKey getAdditionalActionKey() {
/*  88 */     return (this._dataKey != null) ? this._dataKey : this._chainKey;
/*     */   }
/*     */   
/*     */   public IXstActionKey getChainKey() {
/*  92 */     return this._chainKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClassType() {
/*  98 */     return this.defaultClass_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getCustomViewClass() {
/* 104 */     return (this.customViewClassConfig_ != null) ? this.customViewClassConfig_.getValue() : null;
/*     */   }
/*     */   
/*     */   public IXstActionKey getDataKey() {
/* 108 */     return this._dataKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getFieldWeight() {
/* 114 */     return Integer.valueOf(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormTabKey getFormTabKey() {
/* 120 */     return (this.formTabKey_ == null) ? FormTabKey.DEFAULT : this.formTabKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormPanelType getPanelType() {
/* 126 */     return (this.panelType_ == null) ? FormPanelType.DETAIL : this.panelType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResource() {
/* 132 */     return this.resource_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTextKey() {
/* 138 */     return (this.textKeyConfig_ != null) ? this.textKeyConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTitle() {
/* 144 */     return (this.textKeyConfig_ != null) ? this.textKeyConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 150 */     return super.getClassType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getValue() {
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IVisibilityRule> getVisibilityRules() {
/* 165 */     List<IVisibilityRule> visibilityRules = new ArrayList<>();
/*     */     
/* 167 */     for (VisibilityRuleConfig vrc : this._visibilityRuleConfigs) {
/* 168 */       if (vrc.getVisibilityRule() != null) {
/* 169 */         visibilityRules.add(vrc.getVisibilityRule());
/*     */       }
/*     */     } 
/* 172 */     return visibilityRules;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlwaysEnabled() {
/* 178 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEquivalent(Object o) {
/* 184 */     if (!(o instanceof FormViewPanelConfig)) {
/* 185 */       return false;
/*     */     }
/* 187 */     FormViewPanelConfig other = (FormViewPanelConfig)o;
/*     */     
/* 189 */     return (ObjectUtils.equivalent(other.getPanelType(), getPanelType()) && 
/* 190 */       ObjectUtils.equivalent(other.getFormTabKey(), getFormTabKey()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 200 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/* 210 */     return false;
/*     */   }
/*     */   
/*     */   public void setActionSubGroupKeyTag(String argActionSubGroupKey) {
/* 214 */     this._actionSubGroupKey = argActionSubGroupKey;
/*     */   }
/*     */   
/*     */   public void setBaseClass(String argClass) {
/* 218 */     this.defaultClass_ = argClass;
/*     */   }
/*     */   
/*     */   public void setChainKey(String argKeyValue) {
/* 222 */     this._chainKey = (IXstActionKey)OpChainKey.valueOf(argKeyValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 228 */     if (argValue instanceof IFormComponentConfig && (argKey
/* 229 */       .equalsIgnoreCase("FormViewPanel") || argKey
/* 230 */       .equalsIgnoreCase("FormViewCell") || argKey
/* 231 */       .equalsIgnoreCase("FormViewSectionRef"))) {
/*     */       
/* 233 */       addChild((IViewComponentConfig)argValue);
/*     */     }
/* 235 */     else if ("Resource".equalsIgnoreCase(argKey)) {
/* 236 */       setResource(argValue.toString());
/*     */     }
/* 238 */     else if ("TextKey".equalsIgnoreCase(argKey)) {
/* 239 */       setTextKeyConfig((IFormattableConfig)argValue);
/*     */     }
/* 241 */     else if ("FormTabKey".equalsIgnoreCase(argKey)) {
/* 242 */       setFormTabKey(argValue.toString());
/*     */     }
/* 244 */     else if ("class".equalsIgnoreCase(argKey)) {
/* 245 */       setBaseClass(argValue.toString());
/*     */     }
/* 247 */     else if ("PanelType".equalsIgnoreCase(argKey)) {
/* 248 */       FormPanelType type = FormPanelType.forName(argValue);
/* 249 */       if (type != null) {
/* 250 */         setPanelType(type);
/*     */       }
/*     */     }
/* 253 */     else if (argKey.equalsIgnoreCase("CustomView")) {
/* 254 */       setCustomViewClassConfig((ClassConfig)argValue);
/*     */     }
/* 256 */     else if (argKey.equalsIgnoreCase("ActionSubGroupKey")) {
/* 257 */       setActionSubGroupKeyTag(argValue.toString());
/*     */     }
/* 259 */     else if (argKey.equalsIgnoreCase("ChainKey")) {
/* 260 */       setChainKey(argValue.toString());
/*     */     }
/* 262 */     else if (argKey.equalsIgnoreCase("DataKey")) {
/* 263 */       setDataKey(argValue.toString());
/*     */     }
/* 265 */     else if ("privilege".equalsIgnoreCase(argKey)) {
/* 266 */       this._visibilityRuleConfigs.add(new PrivilegeVisibilityRuleConfig((IConfigObject)this, argValue.toString()));
/*     */     }
/* 268 */     else if (argValue instanceof VisibilityRuleConfig) {
/* 269 */       this._visibilityRuleConfigs.add((VisibilityRuleConfig)argValue);
/*     */     } else {
/*     */       
/* 272 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/* 274 */     setClean();
/*     */   }
/*     */   
/*     */   public void setDataKey(String argKeyValue) {
/* 278 */     this._dataKey = (IXstActionKey)XstDataActionKey.valueOf(argKeyValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormTabKey(String argValue) {
/* 284 */     this.formTabKey_ = FormTabKey.forName(argValue);
/* 285 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPanelType(FormPanelType newValue) {
/* 291 */     this.panelType_ = newValue;
/* 292 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResource(String argValue) {
/* 298 */     this.resource_ = argValue;
/* 299 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextKey(String newValue) {
/* 305 */     if (newValue == null || newValue.trim().length() == 0) {
/* 306 */       this.textKeyConfig_ = null;
/*     */     }
/* 308 */     else if (newValue.startsWith("_")) {
/* 309 */       this.textKeyConfig_ = (IFormattableConfig)new TranslatableConfig(newValue);
/*     */     } else {
/*     */       
/* 312 */       this.textKeyConfig_ = (IFormattableConfig)new LiteralConfig(newValue);
/*     */     } 
/* 314 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 321 */     StringBuilder attr = new StringBuilder();
/* 322 */     if (!StringUtils.isEmpty(getName())) {
/* 323 */       attr.append(" name=\"").append(getName()).append("\"");
/*     */     }
/* 325 */     if (this.panelType_ != null) {
/* 326 */       attr.append(" panelType=\"").append(this.panelType_.name()).append("\"");
/*     */     }
/* 328 */     if (this.formTabKey_ != null) {
/* 329 */       attr.append(" formTabKey=\"").append(this.formTabKey_.getName()).append("\"");
/*     */     }
/* 331 */     if (!getVisible()) {
/* 332 */       attr.append(" visible=\"false\"");
/*     */     }
/* 334 */     argWriter.writeHeader("FormViewPanel", "FormViewPanel", attr.toString().trim());
/* 335 */     List<TouchConfig> touchConfigurations = getTouchConfigurations();
/* 336 */     if (touchConfigurations != null) {
/* 337 */       for (TouchConfig touchConfig : touchConfigurations) {
/* 338 */         touchConfig.write(argWriter);
/*     */       }
/*     */     }
/* 341 */     argWriter.writeValue("ActionSubGroupKey", "String", getActionSubGroupKey());
/* 342 */     argWriter.writeValue("ChainKey", "String", getChainKey());
/* 343 */     argWriter.writeValue("DataKey", "String", getDataKey());
/* 344 */     argWriter.writeValue("Resource", "String", this.resource_);
/* 345 */     argWriter.writeValue("TextKey", (IReflectionParameterCapable)getTextKeyConfig());
/* 346 */     argWriter
/* 347 */       .writeValue((ISavableConfig[])this._visibilityRuleConfigs.toArray((Object[])new VisibilityRuleConfig[this._visibilityRuleConfigs.size()]));
/* 348 */     writeLayout(argWriter);
/* 349 */     argWriter.writeValue("LayoutLocation", "String", getLayoutLocation());
/* 350 */     argWriter.writeValue((ISavableConfig)getEditableLayoutParameters());
/*     */     
/* 352 */     Integer tabOrder = getTabOrder();
/* 353 */     if (tabOrder != null && tabOrder.intValue() != 0) {
/* 354 */       argWriter.writeValue("TabOrder", "Integer", tabOrder);
/*     */     }
/*     */     
/* 357 */     writeParameterConfigs(argWriter);
/* 358 */     IColorGroupConfig colorGroupConfig = getColorGroupConfig();
/* 359 */     if (colorGroupConfig != null) {
/* 360 */       colorGroupConfig.write(argWriter);
/*     */     }
/* 362 */     argWriter.writeValue((ISavableConfig[])getChildren().toArray((Object[])new ISavableConfig[0]));
/* 363 */     argWriter.writeValue("CustomView", (IReflectionParameterCapable)this.customViewClassConfig_);
/* 364 */     argWriter.writeFooter("FormViewPanel");
/* 365 */     setClean();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean sortChildren() {
/* 371 */     return true;
/*     */   }
/*     */   
/*     */   private IFormattableConfig getTextKeyConfig() {
/* 375 */     return this.textKeyConfig_;
/*     */   }
/*     */   
/*     */   private void setCustomViewClassConfig(ClassConfig<?> argConfig) {
/* 379 */     this.customViewClassConfig_ = argConfig;
/* 380 */     setDirty();
/*     */   }
/*     */   
/*     */   private void setTextKeyConfig(IFormattableConfig textKeyConfig) {
/* 384 */     this.textKeyConfig_ = textKeyConfig;
/* 385 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormViewPanelConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */