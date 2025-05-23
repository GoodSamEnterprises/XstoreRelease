/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.TranslationHelper;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.i18n.config.FormattableConfig;
/*     */ import dtv.pos.i18n.config.LiteralConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.config.FormPanelType;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionConfig;
/*     */ import dtv.pos.iframework.ui.config.IActionGroupConfig;
/*     */ import dtv.pos.iframework.visibilityrules.IFormVisibilityRule;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class FormViewConfig
/*     */   extends AbstractParentConfig
/*     */   implements IFormViewConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "FormView";
/*     */   private static final String FORM_KEY_TAG = "FormKey";
/*     */   private static final String FORM_LOCATION_TAG = "FormLocation";
/*  50 */   private static final Logger logger_ = Logger.getLogger(FormViewConfig.class); private static final String FORM_LAYOUT_TAG = "FormLayout"; private static final String TITLE_TEXT_TAG = "TitleText"; private static final String INSTRUCTIONS_TAG = "Instructions"; private static final String CUSTOM_VIEW_TAG = "CustomView";
/*     */   private static final String AUTO_ONSCREEN_KEYBOARD = "autoOnScreenKeyboard";
/*  52 */   private static long i = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getFormViewPanelName(IFormViewPanelConfig panel) {
/*  60 */     return getFormViewPanelName(panel.getName(), panel.getPanelType(), panel.getFormTabKey());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getFormViewPanelName(String name, FormPanelType type, FormTabKey tab) {
/*  71 */     if (name == null && type == null && tab == null) {
/*  72 */       return "DEFAULT_PANEL_" + String.valueOf(i++);
/*     */     }
/*  74 */     return (name != null) ? name : (((type != null) ? type.toString() : "DEFAULT") + "::||::" + ((tab != null) ? tab
/*  75 */       .getName() : "DEFAULT"));
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object getGroupKey(IActionGroupConfig group) {
/*  80 */     return getGroupKey(group.getGroupKey(), group.getGroupSubKey());
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object getGroupKey(Object key, Object subKey) {
/*  85 */     return (subKey != null) ? (key + "::||::" + subKey) : key;
/*     */   }
/*     */ 
/*     */   
/*     */   private static IFormattableConfig makeFormattableConfig(String argString) {
/*  90 */     if (argString == null) {
/*  91 */       return null;
/*     */     }
/*  93 */     if (TranslationHelper.getInstance().isTranslationKey(argString)) {
/*  94 */       return (IFormattableConfig)new TranslatableConfig(argString);
/*     */     }
/*     */     
/*  97 */     return (IFormattableConfig)new LiteralConfig(argString);
/*     */   }
/*     */ 
/*     */   
/* 101 */   private final Map<String, IFormViewPanelConfig> viewPanelConfigsMap_ = new LinkedHashMap<>();
/* 102 */   private final Map<String, IActionGroupConfig> actionGroupListMap_ = new LinkedHashMap<>();
/* 103 */   private final Map<String, IFormViewSectionConfig> viewSectionListMap_ = new LinkedHashMap<>();
/*     */   
/*     */   private Map<Object, IActionGroupConfig> actionGroupMap_;
/*     */   
/*     */   private FormKey formKey_;
/*     */   private ClassConfig<?> customViewClassConfig_;
/* 109 */   private FormLocationType formLocation_ = FormLocationType.MULTI_PURPOSE_VIEW;
/*     */ 
/*     */   
/*     */   private IFormattableConfig titleText_;
/*     */ 
/*     */   
/*     */   private IFormattableConfig instructions_;
/*     */ 
/*     */   
/*     */   private String layoutName_;
/*     */   
/*     */   private boolean _autoPopOSKEnabled;
/*     */ 
/*     */   
/*     */   public void addActionGroupConfig(IActionGroupConfig argValue) {
/* 124 */     this.actionGroupMap_ = null;
/* 125 */     this.actionGroupListMap_.put(getGroupKey(argValue).toString(), argValue);
/* 126 */     setDirty();
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
/*     */   public void addViewPanelConfig(IFormViewPanelConfig argPanelConfig) {
/* 139 */     this.viewPanelConfigsMap_.put(getFormViewPanelName(argPanelConfig), argPanelConfig);
/* 140 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addViewSectionConfig(IFormViewSectionConfig argSectionConfig) {
/* 146 */     this.viewSectionListMap_.put(argSectionConfig.getName(), argSectionConfig);
/* 147 */     setDirty();
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
/*     */   public IActionGroupConfig getActionGroupConfig(DataActionGroupKey argActionGroupKey, String argActionGroupSubKey) {
/* 164 */     Map<Object, IActionGroupConfig> actionConfigs = getPromptActionGroupConfigs();
/* 165 */     return actionConfigs.get(getGroupKey(argActionGroupKey, argActionGroupSubKey));
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<IActionGroupConfig> getActionGroupConfigs() {
/* 170 */     return getPromptActionGroupConfigs().values();
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
/*     */   public Class<?> getCustomViewClass() {
/* 188 */     return (this.customViewClassConfig_ != null) ? this.customViewClassConfig_.getValue() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormKey getFormKey() {
/* 197 */     return this.formKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormLayoutName() {
/* 208 */     return this.layoutName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormLocationType getFormLocation() {
/* 218 */     return this.formLocation_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormViewSectionConfig getFormViewSection(String argName) {
/* 224 */     return this.viewSectionListMap_.get(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getInstructions() {
/* 234 */     return (this.instructions_ != null) ? this.instructions_.getFormattable() : IFormattable.EMPTY;
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
/*     */   
/*     */   public Collection<IXstAction> getPromptActions(IEditModel argFormModel, DataActionGroupKey argActionGroupKey) {
/* 253 */     return getPromptActions(argFormModel, argActionGroupKey, (String)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getPromptActions(IEditModel argFormModel, DataActionGroupKey argActionGroupKey, String argActionGroupSubKey) {
/* 275 */     IActionGroupConfig group = getActionGroupConfig(argActionGroupKey, argActionGroupSubKey);
/* 276 */     if (group == null) {
/*     */       
/* 278 */       group = getActionGroupConfig(argActionGroupKey, "DEFAULT");
/* 279 */       if (group == null) {
/*     */         
/* 281 */         group = getActionGroupConfig(argActionGroupKey, (String)null);
/* 282 */         if (group == null) {
/*     */           
/* 284 */           group = getActionGroupConfig(DataActionGroupKey.DEFAULT, argActionGroupSubKey);
/* 285 */           if (group == null) {
/*     */             
/* 287 */             group = getActionGroupConfig(DataActionGroupKey.DEFAULT, "DEFAULT");
/* 288 */             if (group == null) {
/*     */               
/* 290 */               group = getActionGroupConfig(DataActionGroupKey.DEFAULT, (String)null);
/* 291 */               if (group == null)
/*     */               {
/* 293 */                 return new ArrayList<>(0);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 300 */     Collection<IXstAction> actions = group.getActions();
/*     */     
/* 302 */     if (actions.size() == 0) {
/* 303 */       logger_.warn("No actions in action group [" + argActionGroupKey + "] of form config [" + getFormKey() + "]::" + 
/* 304 */           getSourceDescription());
/* 305 */       return actions;
/*     */     } 
/*     */ 
/*     */     
/* 309 */     for (IXstAction action : actions) {
/* 310 */       List<IVisibilityRule> rules = action.getVisibilityRules();
/* 311 */       if (rules != null) {
/* 312 */         for (IVisibilityRule rule : rules) {
/* 313 */           if (rule instanceof IFormVisibilityRule) {
/* 314 */             ((IFormVisibilityRule)rule).setEditModel(argFormModel);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 319 */     return actions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTitleText() {
/* 328 */     return (this.titleText_ != null) ? this.titleText_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormViewPanelConfig<IFormComponentConfig>[] getViewPanelConfigs() {
/* 338 */     return (IFormViewPanelConfig<IFormComponentConfig>[])this.viewPanelConfigsMap_.values().toArray((Object[])new FormViewPanelConfig[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormViewSectionConfig<IFormComponentConfig>[] getViewSectionConfigs() {
/* 344 */     return (IFormViewSectionConfig<IFormComponentConfig>[])this.viewSectionListMap_.values().toArray((Object[])new FormViewSectionConfig[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoPopOnScreenKbdEnabled() {
/* 350 */     return this._autoPopOSKEnabled;
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
/*     */   public boolean isDirty() {
/* 362 */     if (super.isDirty()) {
/* 363 */       return true;
/*     */     }
/*     */     
/* 366 */     for (IActionGroupConfig actionGroupConfig : this.actionGroupListMap_.values()) {
/* 367 */       if (actionGroupConfig.isDirty()) {
/* 368 */         return true;
/*     */       }
/*     */     } 
/* 371 */     for (IFormViewPanelConfig<?> c : this.viewPanelConfigsMap_.values()) {
/* 372 */       if (c.isDirty()) {
/* 373 */         return true;
/*     */       }
/*     */     } 
/* 376 */     for (IFormViewSectionConfig s : this.viewSectionListMap_.values()) {
/* 377 */       if (s.isDirty()) {
/* 378 */         return true;
/*     */       }
/*     */     } 
/* 381 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeViewPanelConfig(IFormViewPanelConfig argPanelConfig) {
/* 391 */     this.viewPanelConfigsMap_.remove(getFormViewPanelName(argPanelConfig));
/* 392 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeViewSectionConfig(IFormViewSectionConfig argSectionConfig) {
/* 398 */     this.viewSectionListMap_.remove(argSectionConfig.getName());
/* 399 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 410 */     if (argKey.equalsIgnoreCase("FormViewPanel")) {
/* 411 */       addViewPanelConfig((FormViewPanelConfig)argValue);
/*     */     }
/* 413 */     else if (argKey.equalsIgnoreCase("FormViewSection")) {
/* 414 */       addViewSectionConfig((FormViewSectionConfig)argValue);
/*     */     }
/* 416 */     else if (argKey.equalsIgnoreCase("CustomView")) {
/* 417 */       setCustomViewClassConfig(ConfigUtils.toClassConfig(argValue));
/*     */     }
/* 419 */     else if (argKey.equalsIgnoreCase("FormKey")) {
/* 420 */       setFormKey(FormKey.valueOf(argValue.toString()));
/*     */     }
/* 422 */     else if (argKey.equalsIgnoreCase("ActionGroup") && argValue instanceof dtv.pos.framework.ui.config.ActionGroupConfig) {
/* 423 */       addActionGroupConfig((IActionGroupConfig)argValue);
/*     */     }
/* 425 */     else if (argKey.equalsIgnoreCase("FormLocation")) {
/* 426 */       FormLocationType t = FormLocationType.forName(argValue);
/* 427 */       if (t != null) {
/* 428 */         setFormLocation(t);
/*     */       }
/*     */     }
/* 431 */     else if (argKey.equalsIgnoreCase("FormLayout")) {
/* 432 */       setFormLayoutName(argValue.toString());
/*     */     }
/* 434 */     else if (argKey.equalsIgnoreCase("TitleText")) {
/* 435 */       setTitleText(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 437 */     else if (argKey.equalsIgnoreCase("Instructions")) {
/* 438 */       setInstructions(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 440 */     else if (argKey.equalsIgnoreCase("autoOnScreenKeyboard")) {
/* 441 */       this._autoPopOSKEnabled = ConfigUtils.toBoolean(argValue);
/*     */     } else {
/*     */       
/* 444 */       warnUnsupported(argKey, argValue);
/*     */     } 
/* 446 */     setClean();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormKey(FormKey argKey) {
/* 456 */     this.formKey_ = argKey;
/* 457 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormLayoutName(String argLayoutName) {
/* 468 */     this.layoutName_ = argLayoutName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormLocation(FormLocationType argLocation) {
/* 478 */     this.formLocation_ = argLocation;
/* 479 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstructions(IFormattableConfig argInstructions) {
/* 489 */     this.instructions_ = argInstructions;
/* 490 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstructions(String argInstructions) {
/* 500 */     this.instructions_ = makeFormattableConfig(argInstructions);
/* 501 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitleText(IFormattableConfig argTitle) {
/* 510 */     this.titleText_ = argTitle;
/* 511 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitleText(String argTitle) {
/* 520 */     this.titleText_ = makeFormattableConfig(argTitle);
/* 521 */     setDirty();
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
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 534 */     StringBuilder attr = new StringBuilder();
/* 535 */     if (getFormKey() != null) {
/* 536 */       attr.append(" formKey=\"").append(getFormKey().toString()).append("\"");
/*     */     }
/* 538 */     if (getFormLocation() != null) {
/* 539 */       attr.append(" formLocation=\"").append(getFormLocation().name()).append("\"");
/*     */     }
/* 541 */     if (!StringUtils.isEmpty(getFormLayoutName())) {
/* 542 */       attr.append(" formLayout=\"").append(getFormLayoutName()).append("\"");
/*     */     }
/* 544 */     argWriter.writeHeader("FormView", "FormView", attr.toString().trim());
/*     */     
/* 546 */     argWriter.writeValue("TitleText", (IReflectionParameterCapable)this.titleText_);
/* 547 */     argWriter.writeValue("Instructions", (IReflectionParameterCapable)this.instructions_);
/*     */     
/* 549 */     argWriter.writeValue("CustomView", (IReflectionParameterCapable)this.customViewClassConfig_);
/*     */     
/* 551 */     IFormViewPanelConfig[] panels = (IFormViewPanelConfig[])this.viewPanelConfigsMap_.values().toArray((Object[])new FormViewPanelConfig[0]);
/* 552 */     Arrays.sort((Object[])panels);
/* 553 */     for (IFormViewPanelConfig panel : panels) {
/* 554 */       if (panel.isDirty()) {
/* 555 */         argWriter.writeValue((ISavableConfig)panel);
/*     */       }
/*     */     } 
/*     */     
/* 559 */     for (IActionGroupConfig actionGroup : this.actionGroupListMap_.values()) {
/* 560 */       if (actionGroup.isDirty()) {
/* 561 */         argWriter.writeValue((ISavableConfig)actionGroup);
/*     */       }
/*     */     } 
/*     */     
/* 565 */     for (IFormViewSectionConfig section : this.viewSectionListMap_.values()) {
/* 566 */       if (section.isDirty()) {
/* 567 */         argWriter.writeValue((ISavableConfig)section);
/*     */       }
/*     */     } 
/*     */     
/* 571 */     argWriter.writeFooter("FormView");
/* 572 */     setClean();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized Map<Object, IActionGroupConfig> getPromptActionGroupConfigs() {
/* 578 */     if (this.actionGroupMap_ == null) {
/* 579 */       Map<Object, IActionGroupConfig> newActionGroupMap = new HashMap<>();
/* 580 */       for (String key : this.actionGroupListMap_.keySet()) {
/* 581 */         IActionGroupConfig group = this.actionGroupListMap_.get(key);
/* 582 */         newActionGroupMap.put(getGroupKey(group), group);
/*     */       } 
/* 584 */       this.actionGroupMap_ = newActionGroupMap;
/*     */     } 
/* 586 */     return this.actionGroupMap_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setCustomViewClassConfig(ClassConfig<?> newValue) {
/* 592 */     this.customViewClassConfig_ = newValue;
/* 593 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormViewConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */