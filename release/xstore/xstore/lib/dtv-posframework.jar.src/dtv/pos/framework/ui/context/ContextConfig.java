/*     */ package dtv.pos.framework.ui.context;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.ui.config.ColorGroupConfig;
/*     */ import dtv.pos.i18n.config.FormattableConfig;
/*     */ import dtv.pos.iframework.form.IListEditModel;
/*     */ import dtv.pos.iframework.type.ModelKey;
/*     */ import dtv.pos.iframework.ui.context.IComponentState;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.ICascadableConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class ContextConfig
/*     */   extends AbstractParentConfig
/*     */   implements ICascadableConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  30 */   private static final Logger _logger = Logger.getLogger(ContextConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "Context";
/*     */   
/*     */   private static final String CONTEXT_KEY_TAG = "ContextKey";
/*     */   
/*     */   private static final String PARENT_KEY_TAG = "ParentContext";
/*     */   
/*     */   private static final String TITLE_TAG = "Title";
/*     */   
/*     */   private static final String TEXT1_TAG = "Text1";
/*     */   
/*     */   private static final String TEXT2_TAG = "Text2";
/*     */   
/*     */   private static final String HELP_KEY_TAG = "HelpKey";
/*     */   
/*     */   private static final String MENU_KEY_TAG = "MenuKey";
/*     */   
/*     */   private static final String LIST_MODEL_KEY_TAG = "ListModelKey";
/*     */   
/*     */   private static final String SECOND_DISPLAY_MODE = "SecondDisplayMode";
/*     */   
/*     */   private static final String SECOND_DISPLAY_TRANSITION_ENABLED = "SecondDisplayTransitionEnabled";
/*     */   
/*     */   private IFormattableConfig titleConfig_;
/*     */   private IFormattableConfig text1Config_;
/*     */   private IFormattableConfig text2Config_;
/*     */   private IFormattableConfig helpKeyConfig_;
/*     */   private String contextKey_;
/*     */   private String parentKey_;
/*     */   private String menuKey_;
/*     */   private ModelKey<? extends IListEditModel<Object>> listModelKey_;
/*     */   private SecondDisplayMode secondDisplayMode_;
/*     */   private Boolean secondDisplayTransitionEnabled_;
/*     */   private Set<ComponentConfig> components_;
/*  65 */   private ColorGroupConfig colorGroupConfig_ = new ColorGroupConfig();
/*  66 */   private final List<ComponentPropertySetConfig> propertySets_ = new ArrayList<>();
/*     */   private Map<ComponentID, ComponentPropertySetConfig> propertySetsHash_;
/*     */   private ComponentPropertySetConfigHelper _componentPropertySetHelper;
/*     */   private ComponentGroupConfigHelper _componentGroupHelper;
/*     */   
/*     */   public void cascadeValues(IConfigObject source) {
/*  72 */     if (source instanceof ContextConfig) {
/*  73 */       ContextConfig cfg = (ContextConfig)source;
/*  74 */       getComponents().addAll(cfg.getComponents());
/*     */       
/*  76 */       if (getTitleConfig() == null) {
/*  77 */         setTitleConfig(cfg.getTitleConfig());
/*     */       }
/*  79 */       if (getText1Config() == null) {
/*  80 */         setText1Config(cfg.getText1Config());
/*     */       }
/*  82 */       if (getText2Config() == null) {
/*  83 */         setText2Config(cfg.getText2Config());
/*     */       }
/*  85 */       if (getHelpKeyConfig() == null) {
/*  86 */         setHelpKeyConfig(cfg.getHelpKeyConfig());
/*     */       }
/*  88 */       if (getMenuKey() == null) {
/*  89 */         setMenuKey(cfg.getMenuKey());
/*     */       }
/*  91 */       if (this.listModelKey_ == null) {
/*  92 */         this.listModelKey_ = cfg.listModelKey_;
/*     */       }
/*  94 */       if (this.secondDisplayMode_ == null) {
/*  95 */         this.secondDisplayMode_ = cfg.secondDisplayMode_;
/*     */       }
/*  97 */       if (this.secondDisplayTransitionEnabled_ == null) {
/*  98 */         this.secondDisplayTransitionEnabled_ = cfg.secondDisplayTransitionEnabled_;
/*     */       }
/* 100 */       if (getComponents().size() == 0) {
/* 101 */         setComponents(cfg.getComponents());
/*     */       }
/*     */       
/* 104 */       if (getColorGroupConfig() == null) {
/* 105 */         setColorGroupConfig(cfg.getColorGroupConfig());
/*     */       } else {
/*     */         
/* 108 */         getColorGroupConfig().cascadeValues((IConfigObject)cfg.getColorGroupConfig());
/*     */       } 
/*     */       
/* 111 */       hashPropertySets();
/*     */       
/* 113 */       Collection<ComponentPropertySetConfig> configs = cfg.propertySetsHash_.values();
/* 114 */       if (configs != null) {
/* 115 */         Iterator<ComponentPropertySetConfig> it = configs.iterator();
/* 116 */         while (it.hasNext()) {
/* 117 */           ComponentPropertySetConfig cp = it.next();
/* 118 */           if (this.propertySetsHash_.get(cp.getComponentID()) == null) {
/* 119 */             this.propertySetsHash_.put(cp.getComponentID(), cp);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIContext getContext() {
/* 131 */     ComponentState[] comps = new ComponentState[getComponents().size()];
/* 132 */     int i = 0;
/*     */     
/* 134 */     for (ComponentConfig element : getComponents()) {
/* 135 */       comps[i++] = ((ComponentConfig)element).getComponentState();
/*     */     }
/* 137 */     UIContext context = new UIContext(getContextKey());
/* 138 */     context.setHelpKey(getHelpKey());
/* 139 */     context.setTitle(getTitle());
/* 140 */     context.setText1(getText1());
/* 141 */     context.setText2(getText2());
/* 142 */     context.setMenuKey(getMenuKey());
/* 143 */     context.setListModelKey(this.listModelKey_);
/* 144 */     context.setSecondDisplayMode(getSecondDisplayMode());
/* 145 */     context.setSecondDisplayTransitionEnabled(isSecondDisplayTransitionEnabled());
/* 146 */     context.setComponentStates((IComponentState[])comps);
/*     */     
/* 148 */     Iterator<ComponentPropertySetConfig> it = this.propertySetsHash_.values().iterator();
/* 149 */     while (it.hasNext()) {
/* 150 */       ComponentPropertySetConfig set = it.next();
/* 151 */       context.putPropertySet(set.getComponentID(), set.getPropertySet());
/*     */     } 
/*     */     
/* 154 */     ColorGroupConfig colorGroupConfig = getColorGroupConfig();
/* 155 */     if (colorGroupConfig != null) {
/* 156 */       context.setBackgroundColor(colorGroupConfig.getBgColor());
/* 157 */       context.setBackgroundColor2(colorGroupConfig.getBgColor2());
/* 158 */       context.setForegroundColor(colorGroupConfig.getFgColor());
/* 159 */       context.setHighlightColor(colorGroupConfig.getHighlightColor());
/*     */     } 
/* 161 */     return context;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContextKey() {
/* 169 */     return this.contextKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentKey() {
/* 177 */     return this.parentKey_;
/*     */   }
/*     */   
/*     */   public SecondDisplayMode getSecondDisplayMode() {
/* 181 */     return this.secondDisplayMode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hashPropertySets() {
/* 189 */     this.propertySetsHash_ = new HashMap<>();
/* 190 */     for (ComponentPropertySetConfig cp : this.propertySets_) {
/* 191 */       if (this.propertySetsHash_.get(cp.getComponentID()) != null) {
/* 192 */         ComponentPropertySetConfig config = this.propertySetsHash_.get(cp.getComponentID());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 201 */           ComponentPropertySetConfig clonedConfig = config.clone();
/* 202 */           this.propertySetsHash_.remove(cp.getComponentID());
/* 203 */           clonedConfig.cascadeValues((IConfigObject)cp);
/* 204 */           this.propertySetsHash_.put(cp.getComponentID(), clonedConfig);
/*     */         }
/* 206 */         catch (CloneNotSupportedException ex) {
/* 207 */           config.cascadeValues((IConfigObject)cp);
/*     */         } 
/*     */         continue;
/*     */       } 
/* 211 */       this.propertySetsHash_.put(cp.getComponentID(), cp);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecondDisplayTransitionEnabled() {
/* 218 */     return ((this.secondDisplayTransitionEnabled_ == null) ? Boolean.TRUE : this.secondDisplayTransitionEnabled_).booleanValue();
/*     */   }
/*     */   
/*     */   public void setComponentGroupHelper(ComponentGroupConfigHelper argComponentGroupHelper) {
/* 222 */     this._componentGroupHelper = argComponentGroupHelper;
/*     */   }
/*     */   
/*     */   public void setComponentPropertySetHelper(ComponentPropertySetConfigHelper argComponentPropertySetHelper) {
/* 226 */     this._componentPropertySetHelper = argComponentPropertySetHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 232 */     if ("name".equalsIgnoreCase(argKey) || argKey.equalsIgnoreCase("ContextKey")) {
/* 233 */       setContextKey(argValue.toString());
/*     */     }
/* 235 */     else if (argKey.equalsIgnoreCase("ParentContext")) {
/* 236 */       setParentKey(argValue.toString());
/*     */     }
/* 238 */     else if (argKey.equalsIgnoreCase("Title")) {
/* 239 */       setTitleConfig(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 241 */     else if (argKey.equalsIgnoreCase("Text1")) {
/* 242 */       setText1Config(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 244 */     else if (argKey.equalsIgnoreCase("Text2")) {
/* 245 */       setText2Config(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 247 */     else if (argKey.equalsIgnoreCase("HelpKey")) {
/* 248 */       setHelpKeyConfig(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 250 */     else if (argKey.equalsIgnoreCase("MenuKey")) {
/* 251 */       setMenuKey(argValue.toString());
/*     */     }
/* 253 */     else if (argKey.equalsIgnoreCase("Component")) {
/* 254 */       addComponent((ComponentConfig)argValue);
/*     */     }
/* 256 */     else if (argKey.equalsIgnoreCase("ComponentGroup")) {
/* 257 */       addComponentPropertySet((ComponentGroupConfig)argValue);
/*     */     }
/* 259 */     else if (argKey.equalsIgnoreCase("ComponentPropertySet")) {
/* 260 */       addComponentPropertySet((ComponentPropertySetConfig)argValue);
/*     */     }
/* 262 */     else if ("ListModelKey".equalsIgnoreCase(argKey)) {
/* 263 */       this.listModelKey_ = new ModelKey(argValue.toString());
/*     */     }
/* 265 */     else if ("SecondDisplayMode".equalsIgnoreCase(argKey)) {
/*     */       try {
/* 267 */         this.secondDisplayMode_ = SecondDisplayMode.valueOf(argValue.toString());
/*     */       }
/* 269 */       catch (Exception ex) {
/* 270 */         _logger.error("No supported screen mode named [" + argValue + "]!", ex);
/*     */       }
/*     */     
/* 273 */     } else if ("SecondDisplayTransitionEnabled".equalsIgnoreCase(argKey)) {
/* 274 */       this.secondDisplayTransitionEnabled_ = Boolean.valueOf(ConfigUtils.toBoolean(argValue));
/*     */     }
/* 276 */     else if (argValue instanceof ColorGroupConfig) {
/* 277 */       setColorGroupConfig((ColorGroupConfig)argValue);
/*     */     } else {
/*     */       
/* 280 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addComponent(ComponentConfig config) {
/* 289 */     getComponents().add(config);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addComponentPropertySet(ComponentGroupConfig argConfig) {
/* 297 */     if (argConfig.getReference() != null) {
/* 298 */       ComponentGroupConfig config = this._componentGroupHelper.getComponentGroupConfig(argConfig.getReference());
/* 299 */       argConfig.cascadeValues((IConfigObject)config);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 304 */     for (ComponentPropertySetConfig set : argConfig.getComponentPropertySetConfigs()) {
/* 305 */       addComponentPropertySet(set);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addComponentPropertySet(ComponentPropertySetConfig set) {
/* 310 */     if (set.getReference() != null) {
/*     */       
/* 312 */       ComponentPropertySetConfig config = this._componentPropertySetHelper.getComponentPropertySetConfig(set.getReference());
/* 313 */       set.cascadeValues((IConfigObject)config);
/*     */     } 
/*     */ 
/*     */     
/* 317 */     this.propertySets_.add(set);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ColorGroupConfig getColorGroupConfig() {
/* 325 */     return this.colorGroupConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<ComponentConfig> getComponents() {
/* 333 */     if (this.components_ == null) {
/* 334 */       this.components_ = new HashSet<>();
/*     */     }
/*     */     
/* 337 */     return this.components_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattable getHelpKey() {
/* 345 */     return (this.helpKeyConfig_ != null) ? this.helpKeyConfig_.getFormattable() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattableConfig getHelpKeyConfig() {
/* 353 */     return this.helpKeyConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getMenuKey() {
/* 361 */     return this.menuKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattable getText1() {
/* 369 */     return (this.text1Config_ != null) ? this.text1Config_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattableConfig getText1Config() {
/* 377 */     return this.text1Config_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattable getText2() {
/* 385 */     return (this.text2Config_ != null) ? this.text2Config_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattableConfig getText2Config() {
/* 393 */     return this.text2Config_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattable getTitle() {
/* 401 */     return (this.titleConfig_ != null) ? this.titleConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattableConfig getTitleConfig() {
/* 409 */     return this.titleConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setColorGroupConfig(ColorGroupConfig colorGroupConfig) {
/* 417 */     this.colorGroupConfig_ = colorGroupConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setComponents(Set<ComponentConfig> components) {
/* 425 */     this.components_ = components;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setContextKey(String config) {
/* 433 */     this.contextKey_ = config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setHelpKeyConfig(IFormattableConfig config) {
/* 441 */     this.helpKeyConfig_ = config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setMenuKey(String config) {
/* 449 */     this.menuKey_ = config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setParentKey(String config) {
/* 457 */     this.parentKey_ = config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setText1Config(IFormattableConfig config) {
/* 465 */     this.text1Config_ = config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setText2Config(IFormattableConfig config) {
/* 473 */     this.text2Config_ = config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setTitleConfig(IFormattableConfig config) {
/* 481 */     this.titleConfig_ = config;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ContextConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */