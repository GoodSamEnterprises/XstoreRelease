/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.hardware.audio.Sound;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.hardware.audio.ISound;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.config.IActionConfig;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.ui.config.IDataSelectionConfig;
/*     */ import dtv.pos.iframework.ui.config.IIconGroupConfig;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*     */ import dtv.pos.iframework.ui.config.IPromptSectionConfig;
/*     */ import dtv.pos.iframework.ui.config.PromptSectionType;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.ICascadableConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PromptConfig
/*     */   extends AbstractParentConfig implements ICascadableConfig, IPromptConfig {
/*     */   private static final long serialVersionUID = 1L;
/*  33 */   private static final Logger logger_ = Logger.getLogger(PromptConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "Prompt";
/*     */   
/*     */   public static final String PROMPT_KEY_TAG = "PromptKey";
/*     */   
/*     */   private static final String PROMPT_TYPE_TAG = "PromptType";
/*     */   
/*     */   private static final String LIST_VIEW_TYPE_TAG = "ListViewType";
/*     */   
/*     */   private static final String LIST_VIEW_HEADER_TYPE_TAG = "ListViewHeaderType";
/*     */   private static final String LIST_VIEW_RULE_SET_TAG = "ListViewRuleSet";
/*     */   private static final String ACTION_DISPLAY_TYPE_TAG = "ActionDisplayType";
/*     */   private static final String ACTION_GROUP_KEY_TAG = "ActionGroupKey";
/*     */   private static final String SOUND_TAG = "Sound";
/*     */   private static final String FINGERPRINT_ENABLED_TAG = "FingerprintEnabled";
/*     */   private static final String MODAL_TAG = "Modal";
/*     */   private String _dataSourceName;
/*     */   private PromptKey _promptKey;
/*     */   private String _promptType;
/*     */   private IViewElementType _listViewType;
/*     */   private IViewElementType _listViewHeaderType;
/*     */   private String _listViewRuleSet;
/*     */   private IDataFieldConfig _dataFieldConfig;
/*     */   private IDataSelectionConfig _dataSelectionConfig;
/*     */   private IconGroupConfig _iconGroupConfig;
/*     */   private final Collection<PromptSectionConfig> _sections;
/*     */   private final Collection<IActionConfig> _actionConfigs;
/*     */   private ActionDisplayType _actionDisplayType;
/*  62 */   private DataActionGroupKey _actionGroupKey = null;
/*  63 */   private ISound _sound = null;
/*     */   private Map<PromptSectionType, IPromptSectionConfig> _sectionMap;
/*     */   private boolean _dataFieldConfigSet;
/*     */   private boolean _dataSelectionConfigSet;
/*     */   private boolean _sectionMapBuilt;
/*     */   private boolean _fingerprintEnabled = false;
/*     */   private boolean _autoPopDecimalKbdEnabled;
/*  70 */   private Boolean _modal = null;
/*     */   
/*     */   public PromptConfig() {
/*  73 */     this((String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptConfig(String promptType) {
/*  79 */     this._sections = new ArrayList<>();
/*  80 */     this._sectionMap = new HashMap<>();
/*  81 */     synchronized (this) {
/*  82 */       this._actionConfigs = new ArrayList<>();
/*     */     } 
/*     */     
/*  85 */     setPromptType(promptType);
/*     */     
/*  87 */     setTitleSectionConfig(new PromptSectionConfig());
/*  88 */     setMsgSectionConfig(new PromptSectionConfig());
/*  89 */     setSecondaryMsgSectionConfig(new PromptSectionConfig());
/*     */     
/*  91 */     setIconGroupConfig(new IconGroupConfig());
/*     */     
/*  93 */     this._dataFieldConfigSet = false;
/*  94 */     this._dataSelectionConfigSet = false;
/*  95 */     this._sectionMapBuilt = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/* 100 */     if (sourceConfig == null || !(sourceConfig instanceof PromptConfig)) {
/* 101 */       logger_.error("Attempted to cascade from invalid configuration object!");
/*     */       return;
/*     */     } 
/* 104 */     if (getSourceDescription() == null) {
/* 105 */       setSourceInfo(sourceConfig.getSourceUrl(), sourceConfig.getSourceLineNumber());
/*     */     }
/* 107 */     PromptConfig sourcePromptConfig = (PromptConfig)sourceConfig;
/*     */     
/* 109 */     if (getTitleSectionConfig() == null) {
/* 110 */       setTitleSectionConfig(sourcePromptConfig.getTitleSectionConfig());
/*     */     }
/* 112 */     if (getMsgSectionConfig() == null) {
/* 113 */       setMsgSectionConfig(sourcePromptConfig.getMsgSectionConfig());
/*     */     }
/* 115 */     if (getSecondaryMsgSectionConfig() == null) {
/* 116 */       setSecondaryMsgSectionConfig(sourcePromptConfig.getSecondaryMsgSectionConfig());
/*     */     }
/* 118 */     if (getPromptKey() == null) {
/* 119 */       setPromptKey(sourcePromptConfig.getPromptKey());
/*     */     }
/* 121 */     if (getPromptType() == null) {
/* 122 */       setPromptType(sourcePromptConfig.getPromptType());
/*     */     }
/* 124 */     if (getListViewType() == null) {
/* 125 */       setListViewType(sourcePromptConfig.getListViewType());
/*     */     }
/* 127 */     if (getListViewHeaderType(false) == null) {
/* 128 */       setListViewHeaderType(sourcePromptConfig.getListViewHeaderType(false));
/*     */     }
/* 130 */     if (getListViewRuleSet() == null) {
/* 131 */       setListViewRuleSet(sourcePromptConfig.getListViewRuleSet());
/*     */     }
/* 133 */     if (getActionDisplayType() == null) {
/* 134 */       setActionDisplayType(sourcePromptConfig.getActionDisplayType());
/*     */     }
/* 136 */     if (!isAutoPopDecimalKbdEnabled()) {
/* 137 */       this._autoPopDecimalKbdEnabled = sourcePromptConfig.isAutoPopDecimalKbdEnabled();
/*     */     }
/*     */     
/* 140 */     getTitleSectionConfig().cascadeValues((IConfigObject)sourcePromptConfig.getTitleSectionConfig());
/* 141 */     getMsgSectionConfig().cascadeValues((IConfigObject)sourcePromptConfig.getMsgSectionConfig());
/* 142 */     getSecondaryMsgSectionConfig().cascadeValues((IConfigObject)sourcePromptConfig.getSecondaryMsgSectionConfig());
/*     */     
/* 144 */     if (getDataFieldConfig() == null && getDataSelectionConfig() == null) {
/* 145 */       setDataFieldConfig(sourcePromptConfig.getDataFieldConfig());
/* 146 */       setDataSelectionConfig(sourcePromptConfig.getDataSelectionConfig());
/*     */     }
/* 148 */     else if (getDataFieldConfig() != null) {
/* 149 */       getDataFieldConfig().cascadeValues((IConfigObject)sourcePromptConfig.getDataFieldConfig());
/*     */     }
/* 151 */     else if (getDataSelectionConfig() != null) {
/* 152 */       getDataSelectionConfig().cascadeValues((IConfigObject)sourcePromptConfig.getDataSelectionConfig());
/*     */     } 
/*     */     
/* 155 */     if (getActionGroupKey() == null) {
/* 156 */       setActionGroupKey(sourcePromptConfig.getActionGroupKey());
/*     */     }
/*     */     
/* 159 */     if (getPromptActionConfigs() == null || (getPromptActionConfigs()).length == 0) {
/* 160 */       setPromptActionConfigs(sourcePromptConfig.getPromptActionConfigs());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 165 */     if (getIconGroupConfig().getIcon() == null) {
/* 166 */       getIconGroupConfig().cascadeValues((IConfigObject)sourcePromptConfig.getIconGroupConfig());
/*     */     }
/*     */     
/* 169 */     if (getSound() == null) {
/* 170 */       setSound(sourcePromptConfig.getSound());
/*     */     }
/*     */     
/* 173 */     if (!this._fingerprintEnabled) {
/* 174 */       this._fingerprintEnabled = sourcePromptConfig.isFingerprintEnabled();
/*     */     }
/*     */     
/* 177 */     if (getModal() == null) {
/* 178 */       this._modal = sourcePromptConfig.getModal();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 185 */     Collection<IPromptSectionConfig> sections = this._sectionMap.values();
/*     */     
/* 187 */     if (sections != null) {
/* 188 */       for (IPromptSectionConfig section : sections) {
/* 189 */         section.clear();
/*     */       }
/*     */     }
/* 192 */     synchronized (this) {
/* 193 */       this._actionConfigs.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ActionDisplayType getActionDisplayType() {
/* 199 */     return this._actionDisplayType;
/*     */   }
/*     */   
/*     */   public DataActionGroupKey getActionGroupKey() {
/* 203 */     return this._actionGroupKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataFieldConfig getDataFieldConfig() {
/* 208 */     return this._dataFieldConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataSelectionConfig getDataSelectionConfig() {
/* 213 */     return this._dataSelectionConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSourceName() {
/* 219 */     return this._dataSourceName;
/*     */   }
/*     */ 
/*     */   
/*     */   public IIconGroupConfig getIconGroupConfig() {
/* 224 */     return this._iconGroupConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public IViewElementType getListViewHeaderType() {
/* 229 */     return getListViewHeaderType(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getListViewRuleSet() {
/* 234 */     return this._listViewRuleSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public IViewElementType getListViewType() {
/* 239 */     return this._listViewType;
/*     */   }
/*     */   
/*     */   public Boolean getModal() {
/* 243 */     return this._modal;
/*     */   }
/*     */ 
/*     */   
/*     */   public IPromptSectionConfig getMsgSectionConfig() {
/* 248 */     buildSectionMap();
/* 249 */     return this._sectionMap.get(PromptSectionType.MESSAGE);
/*     */   }
/*     */ 
/*     */   
/*     */   public IActionConfig[] getPromptActionConfigs() {
/* 254 */     synchronized (this) {
/* 255 */       return this._actionConfigs.<IActionConfig>toArray((IActionConfig[])new ActionConfig[this._actionConfigs.size()]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getPromptActions() {
/* 262 */     IActionConfig[] actionConfigs = getPromptActionConfigs();
/*     */     
/* 264 */     if (actionConfigs == null || actionConfigs.length == 0) {
/* 265 */       return null;
/*     */     }
/* 267 */     Collection<IXstAction> actions = new ArrayList<>(actionConfigs.length);
/* 268 */     for (IActionConfig c : actionConfigs) {
/* 269 */       DataActionGroupKey actionGroupKey = getActionGroupKey();
/* 270 */       IXstAction action = c.getAction(actionGroupKey);
/* 271 */       actions.add(action);
/*     */     } 
/* 273 */     return actions;
/*     */   }
/*     */ 
/*     */   
/*     */   public PromptKey getPromptKey() {
/* 278 */     return this._promptKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPromptType() {
/* 283 */     return this._promptType;
/*     */   }
/*     */ 
/*     */   
/*     */   public IPromptSectionConfig getSecondaryMsgSectionConfig() {
/* 288 */     buildSectionMap();
/* 289 */     return this._sectionMap.get(PromptSectionType.SECONDARY_MESSAGE);
/*     */   }
/*     */ 
/*     */   
/*     */   public ISound getSound() {
/* 294 */     return this._sound;
/*     */   }
/*     */ 
/*     */   
/*     */   public IPromptSectionConfig getTitleSectionConfig() {
/* 299 */     buildSectionMap();
/* 300 */     return this._sectionMap.get(PromptSectionType.TITLE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAutoPopDecimalKbdEnabled() {
/* 305 */     return this._autoPopDecimalKbdEnabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDataFieldConfigSet() {
/* 310 */     return this._dataFieldConfigSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDataSelectionConfigSet() {
/* 315 */     return this._dataSelectionConfigSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFingerprintEnabled() {
/* 320 */     return this._fingerprintEnabled;
/*     */   }
/*     */   
/*     */   public void setActionGroupKey(DataActionGroupKey argActionGroupKey) {
/* 324 */     this._actionGroupKey = argActionGroupKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 329 */     if (argKey.equalsIgnoreCase("PromptKey") || "name".equalsIgnoreCase(argKey)) {
/* 330 */       setPromptKey(PromptKey.valueOf(argValue.toString()));
/*     */     }
/* 332 */     else if ("type".equalsIgnoreCase(argKey) || argKey.equalsIgnoreCase("PromptType")) {
/* 333 */       setPromptType(argValue.toString());
/*     */     }
/* 335 */     else if (argKey.equalsIgnoreCase("ListViewType")) {
/* 336 */       setListViewType(ViewElementType.valueOf(argValue.toString()));
/*     */     }
/* 338 */     else if (argKey.equalsIgnoreCase("ListViewHeaderType")) {
/* 339 */       setListViewHeaderType(ViewElementType.valueOf(argValue.toString()));
/*     */     }
/* 341 */     else if ("ListViewRuleSet".equalsIgnoreCase(argKey)) {
/* 342 */       setListViewRuleSet(argValue.toString());
/*     */     }
/* 344 */     else if (argKey.equalsIgnoreCase("ActionDisplayType")) {
/* 345 */       setActionDisplayType(ActionDisplayType.forName(argValue));
/*     */     }
/* 347 */     else if (argKey.equalsIgnoreCase("Section") && argValue instanceof PromptSectionConfig) {
/*     */       
/* 349 */       this._sections.add((PromptSectionConfig)argValue);
/*     */     }
/* 351 */     else if (argKey.equalsIgnoreCase("ActionGroupKey")) {
/* 352 */       setActionGroupKey(DataActionGroupKey.forName(argValue));
/*     */     }
/* 354 */     else if (argKey.equalsIgnoreCase("Action") && argValue instanceof ActionConfig) {
/* 355 */       synchronized (this) {
/* 356 */         this._actionConfigs.add((ActionConfig)argValue);
/*     */       }
/*     */     
/* 359 */     } else if (argKey.equalsIgnoreCase("IconGroup") && argValue instanceof IconGroupConfig) {
/* 360 */       setIconGroupConfig((IconGroupConfig)argValue);
/*     */     }
/* 362 */     else if (argKey.equalsIgnoreCase("DataField") && argValue instanceof DataFieldConfig) {
/* 363 */       setDataFieldConfig((DataFieldConfig)argValue);
/*     */     }
/* 365 */     else if (argKey.equalsIgnoreCase("DataSelection") && argValue instanceof DataSelectionConfig) {
/*     */       
/* 367 */       setDataSelectionConfig((DataSelectionConfig)argValue);
/*     */     }
/* 369 */     else if ("Sound".equalsIgnoreCase(argKey)) {
/* 370 */       setSound(argValue.toString());
/*     */     }
/* 372 */     else if ("FingerprintEnabled".equalsIgnoreCase(argKey)) {
/* 373 */       setFingerprintEnabled(argValue);
/*     */     }
/* 375 */     else if (PromptSectionType.TITLE.matches(argKey) || PromptSectionType.MESSAGE.matches(argKey) || PromptSectionType.SECONDARY_MESSAGE.matches(argKey)) {
/* 376 */       PromptSectionConfig section = new PromptSectionConfig(PromptSectionType.find(argKey), argValue.toString());
/* 377 */       this._sections.add(section);
/*     */     }
/* 379 */     else if (argKey.equalsIgnoreCase("autoDecimalKeyboard")) {
/* 380 */       this._autoPopDecimalKbdEnabled = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 382 */     else if ("Modal".equalsIgnoreCase(argKey)) {
/* 383 */       this._modal = Boolean.valueOf(ConfigUtils.toBoolean(argValue));
/*     */     } else {
/*     */       
/* 386 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDataFieldConfig(IDataFieldConfig dataFieldConfig) {
/* 391 */     if (dataFieldConfig != null) {
/* 392 */       this._dataFieldConfigSet = true;
/* 393 */       this._dataFieldConfig = dataFieldConfig;
/* 394 */       this._dataSelectionConfigSet = false;
/* 395 */       this._dataSelectionConfig = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDataSelectionConfig(IDataSelectionConfig dataSelectionConfig) {
/* 400 */     if (dataSelectionConfig != null) {
/* 401 */       this._dataSelectionConfigSet = true;
/* 402 */       this._dataSelectionConfig = dataSelectionConfig;
/* 403 */       this._dataFieldConfigSet = false;
/* 404 */       this._dataFieldConfig = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataSourceName(String argDataSourceName) {
/* 411 */     this._dataSourceName = argDataSourceName;
/*     */   }
/*     */   
/*     */   public void setIconGroupConfig(IconGroupConfig iconGroupConfig) {
/* 415 */     this._iconGroupConfig = iconGroupConfig;
/*     */   }
/*     */   
/*     */   public void setListViewHeaderType(IViewElementType type) {
/* 419 */     this._listViewHeaderType = type;
/*     */   }
/*     */   
/*     */   public void setListViewRuleSet(String argRuleSet) {
/* 423 */     this._listViewRuleSet = argRuleSet;
/*     */   }
/*     */   
/*     */   public void setListViewType(IViewElementType type) {
/* 427 */     this._listViewType = type;
/*     */   }
/*     */   
/*     */   public void setPromptActionConfigs(IActionConfig[] actionConfigs) {
/* 431 */     synchronized (this) {
/* 432 */       this._actionConfigs.clear();
/* 433 */       this._actionConfigs.addAll(Arrays.asList(actionConfigs));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPromptType(String promptType) {
/* 438 */     this._promptType = promptType;
/*     */   }
/*     */   
/*     */   protected void combinePromptActions(IActionConfig[] argBaseActions, IActionConfig[] argOverrideActions) {
/* 442 */     Map<IXstActionKey, IActionConfig> actionMap = new HashMap<>();
/*     */ 
/*     */     
/* 445 */     if (argBaseActions != null) {
/* 446 */       for (IActionConfig actionConfig : argBaseActions) {
/* 447 */         actionMap.put(actionConfig.getKey(), actionConfig);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 452 */     if (argOverrideActions != null) {
/* 453 */       for (IActionConfig actionConfig : argOverrideActions) {
/* 454 */         actionMap.put(actionConfig.getKey(), actionConfig);
/*     */       }
/*     */     }
/*     */     
/* 458 */     Collection<IActionConfig> actions = actionMap.values();
/* 459 */     setPromptActionConfigs(actions.<IActionConfig>toArray(new IActionConfig[actions.size()]));
/*     */   }
/*     */   
/*     */   protected void initialize() {
/* 463 */     buildSectionMap();
/*     */   }
/*     */   
/*     */   protected void setPromptKey(PromptKey promptKey) {
/* 467 */     this._promptKey = promptKey;
/*     */   }
/*     */   
/*     */   private void buildSectionMap() {
/* 471 */     if (this._sectionMapBuilt) {
/*     */       return;
/*     */     }
/* 474 */     if (this._sectionMap == null) {
/* 475 */       this._sectionMap = new HashMap<>();
/*     */     }
/*     */     
/* 478 */     for (PromptSectionConfig promptSection : this._sections) {
/* 479 */       this._sectionMap.put(promptSection.getType(), promptSection);
/*     */     }
/* 481 */     this._sectionMapBuilt = true;
/*     */   }
/*     */   
/*     */   private IViewElementType getListViewHeaderType(boolean defaultToViewType) {
/* 485 */     if (this._listViewHeaderType == null && defaultToViewType) {
/* 486 */       return getListViewType();
/*     */     }
/* 488 */     return this._listViewHeaderType;
/*     */   }
/*     */   
/*     */   private void setActionDisplayType(ActionDisplayType actionDisplayType) {
/* 492 */     this._actionDisplayType = actionDisplayType;
/*     */   }
/*     */   
/*     */   private void setFingerprintEnabled(IConfigObject argValue) {
/* 496 */     this._fingerprintEnabled = ConfigUtils.toBoolean(argValue);
/*     */   }
/*     */   
/*     */   private void setMsgSectionConfig(IPromptSectionConfig promptSection) {
/* 500 */     this._sectionMap.put(PromptSectionType.MESSAGE, promptSection);
/*     */   }
/*     */   
/*     */   private void setSecondaryMsgSectionConfig(IPromptSectionConfig promptSection) {
/* 504 */     this._sectionMap.put(PromptSectionType.SECONDARY_MESSAGE, promptSection);
/*     */   }
/*     */   
/*     */   private void setSound(ISound newValue) {
/* 508 */     this._sound = newValue;
/*     */   }
/*     */   
/*     */   private void setSound(String newValue) {
/* 512 */     this._sound = Sound.create(newValue);
/*     */   }
/*     */   
/*     */   private void setTitleSectionConfig(IPromptSectionConfig promptSection) {
/* 516 */     this._sectionMap.put(PromptSectionType.TITLE, promptSection);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\PromptConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */