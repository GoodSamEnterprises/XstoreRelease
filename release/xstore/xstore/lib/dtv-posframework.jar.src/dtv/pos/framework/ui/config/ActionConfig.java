/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import com.micros.xstore.config.common.Action;
/*     */ import com.micros.xstore.config.common.Parameter;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.action.type.ActionType;
/*     */ import dtv.pos.framework.action.type.FormOptionsKey;
/*     */ import dtv.pos.framework.action.type.SortActionKey;
/*     */ import dtv.pos.framework.action.type.XstChainActionType;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.i18n.config.FormattableConfig;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
/*     */ import dtv.pos.iframework.action.IXstKeyStroke;
/*     */ import dtv.pos.iframework.ui.config.IActionConfig;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.KeyStroke;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ 
/*     */ public class ActionConfig
/*     */   extends AbstractUIConfig implements IActionConfig {
/*     */   public static final String MAIN_TAG = "Action";
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String NAME_TAG = "Name";
/*     */   private static final String REFERENCE_TAG = "Ref";
/*     */   public static final String DATA_KEY_TAG = "DataKey";
/*     */   private static final String CHAIN_KEY_TAG = "ChainKey";
/*     */   private static final String FORM_TAB_KEY_TAG = "FormTabKey";
/*     */   private static final String FORM_OPTIONS_KEY_TAG = "FormOptionsKey";
/*     */   private static final String KEY_STROKE_KEY_TAG = "KeyStrokeKey";
/*     */   private static final String SORT_KEY_TAG = "SortKey";
/*     */   public static final String CHAIN_TYPE_TAG = "ChainType";
/*     */   public static final String DATA_TAG = "Data";
/*     */   public static final String TEXT_KEY_TAG = "TextKey";
/*     */   public static final String KEY_STROKE_TAG = "KeyStroke";
/*     */   private static final String VISIBLE_TAG = "Visible";
/*     */   private static final String CATEGORY_TAG = "Category";
/*     */   private static final String KEYWORDS_TAG = "Keywords";
/*     */   private final List<VisibilityRuleConfig> _visibilityRuleConfigs;
/*     */   private final List<ParameterConfig> _parameterConfigs;
/*     */   private final Set<IXstKeyStroke> _keyStrokes;
/*     */   private final List<IActionConfig> _postActionConfigs;
/*  65 */   private IXstActionType _type = null;
/*  66 */   private IXstActionKey _key = null;
/*  67 */   private IReflectionParameterCapable<?> _data = null;
/*  68 */   private IFormattableConfig _textKey = null;
/*  69 */   private IFormattableConfig _rootTextKey = null;
/*  70 */   private IXstKeyStroke _primaryKeyStroke = null;
/*  71 */   private String _id = null;
/*     */ 
/*     */   
/*     */   private boolean _useDefaultKeyStrokes = false;
/*     */ 
/*     */   
/*     */   private String _iconKey;
/*     */   
/*     */   private boolean _dataIsFinal;
/*     */   
/*  81 */   private Action _realConfigObject = new Action();
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   public ActionConfig() {
/*  87 */     this._keyStrokes = new LinkedHashSet<>();
/*  88 */     this._visibilityRuleConfigs = new ArrayList<>();
/*  89 */     this._parameterConfigs = new ArrayList<>();
/*  90 */     this._postActionConfigs = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public ActionConfig(ActionType actionType) {
/*  94 */     this();
/*  95 */     this._key = actionType.getDefaultKey();
/*  96 */     this._type = actionType.getDefaultType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addKeyStroke(IXstKeyStroke keyStroke) {
/* 102 */     this._useDefaultKeyStrokes = false;
/*     */     
/* 104 */     if (this._primaryKeyStroke == null) {
/* 105 */       this._primaryKeyStroke = keyStroke;
/*     */     }
/* 107 */     this._keyStrokes.add(keyStroke);
/*     */     
/* 109 */     KeyStroke complementaryKeyStroke = getComplementaryKeyStroke(keyStroke);
/* 110 */     if (complementaryKeyStroke != null) {
/* 111 */       this._keyStrokes.add(XstKeyStroke.forKeyStroke(complementaryKeyStroke));
/*     */     }
/* 113 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cascadeValues(IConfigObject argSourceConfig) {
/* 119 */     super.cascadeValues(argSourceConfig);
/* 120 */     ActionConfig other = (ActionConfig)argSourceConfig;
/*     */     
/* 122 */     if (getData() == null) {
/* 123 */       setData(other.getData());
/*     */     }
/* 125 */     if (getKey() == null) {
/* 126 */       setKey(other.getKey());
/*     */     }
/* 128 */     if (this._textKey == null) {
/* 129 */       setTextKey(other._textKey);
/*     */     }
/* 131 */     if (this._rootTextKey == null) {
/* 132 */       setRootTextKey(other._rootTextKey);
/*     */     }
/* 134 */     if (getType() == null) {
/* 135 */       setType(other.getType());
/*     */     }
/* 137 */     if (!this._useDefaultKeyStrokes && getKeyStrokes().isEmpty()) {
/* 138 */       for (IXstKeyStroke keyStroke : other.getKeyStrokes()) {
/* 139 */         addKeyStroke(keyStroke);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     for (ParameterConfig otherParam : other._parameterConfigs) {
/* 148 */       boolean found = false;
/* 149 */       for (ParameterConfig myParam : this._parameterConfigs) {
/* 150 */         if (myParam.getName().equalsIgnoreCase(otherParam.getName())) {
/* 151 */           found = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 156 */       if (!found) {
/* 157 */         this._parameterConfigs.add(otherParam);
/*     */       }
/*     */     } 
/*     */     
/* 161 */     if (this._visibilityRuleConfigs.isEmpty())
/*     */     {
/* 163 */       this._visibilityRuleConfigs.addAll(other._visibilityRuleConfigs);
/*     */     }
/*     */     
/* 166 */     if (this._postActionConfigs.isEmpty()) {
/* 167 */       this._postActionConfigs.addAll(other._postActionConfigs);
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
/*     */   public IXstAction getAction(DataActionGroupKey argContainingGroupKey) {
/*     */     IXstAction action;
/* 180 */     synchronized (this) {
/* 181 */       InjectionHammer.forceAtInjectProcessing(this);
/* 182 */       action = this._actionFactory.getAction(argContainingGroupKey, this._realConfigObject);
/*     */     } 
/*     */     
/* 185 */     if (action == null) {
/* 186 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 190 */     action.setFont(getFontConfig().getFont());
/* 191 */     action.setForeground(getColorGroupConfig().getFgColor());
/* 192 */     action.setBackground(getColorGroupConfig().getBgColor());
/*     */     
/* 194 */     if (getIconGroupConfig().getIconConfig() != null) {
/* 195 */       action.setIconKey(getIconGroupConfig().getIconConfig().getConfigValue());
/*     */     }
/*     */     
/* 198 */     action.setSmallIcon(getIconGroupConfig().getIcon());
/* 199 */     action.setRolloverIcon(getIconGroupConfig().getRollIcon());
/* 200 */     action.setPressedIcon(getIconGroupConfig().getPressIcon());
/* 201 */     action.setDisabledIcon(getIconGroupConfig().getDisabledIcon());
/* 202 */     action.setData(getDataValue());
/* 203 */     action.setDataIsFinal(getDataIsFinal());
/*     */     
/* 205 */     for (IActionConfig postActionCfg : this._postActionConfigs) {
/* 206 */       action.addPostAction((Action)postActionCfg.getAction(argContainingGroupKey));
/*     */     }
/*     */     
/* 209 */     return action;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IReflectionParameterCapable<?> getData() {
/* 215 */     return this._data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDataIsFinal() {
/* 223 */     return this._dataIsFinal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIconKey() {
/* 229 */     return this._iconKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 235 */     return this._id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionKey getKey() {
/* 241 */     return this._key;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstKeyStroke getKeyStroke() {
/* 247 */     return this._primaryKeyStroke;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<IXstKeyStroke> getKeyStrokes() {
/* 253 */     return this._keyStrokes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKeywords() {
/* 259 */     return this._realConfigObject.getKeywords();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReference() {
/* 265 */     return this._realConfigObject.getRef();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getRootTextKey() {
/* 271 */     return (this._rootTextKey == null) ? null : this._rootTextKey.getFormattable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTextKey() {
/* 277 */     return (this._textKey == null) ? null : this._textKey.getFormattable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionType getType() {
/* 283 */     return this._type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/* 289 */     if (super.isDirty()) {
/* 290 */       return true;
/*     */     }
/*     */     
/* 293 */     for (VisibilityRuleConfig visRuleCfg : this._visibilityRuleConfigs) {
/* 294 */       if (visRuleCfg.isDirty()) {
/* 295 */         return true;
/*     */       }
/*     */     } 
/* 298 */     for (ParameterConfig paramCfg : getParameterConfigs()) {
/* 299 */       if (paramCfg.isDirty()) {
/* 300 */         return true;
/*     */       }
/*     */     } 
/* 303 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEquivalent(Object o) {
/* 309 */     return ObjectUtils.equivalent(this._key, ((ActionConfig)o)._key);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 315 */     return ConfigUtils.asBool(this._realConfigObject.getVisible(), true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 321 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 322 */       this._id = argValue.toString();
/* 323 */       this._realConfigObject.setName(argValue.toString());
/*     */     }
/* 325 */     else if ("Ref".equalsIgnoreCase(argKey)) {
/* 326 */       setReference(argValue.toString());
/*     */     }
/* 328 */     else if ("DataKey".equalsIgnoreCase(argKey)) {
/* 329 */       setKey((IXstActionKey)XstDataActionKey.valueOf(argValue.toString()));
/* 330 */       this._realConfigObject.setDataKey(argValue.toString());
/*     */     }
/* 332 */     else if ("ChainKey".equalsIgnoreCase(argKey) || "chain".equalsIgnoreCase(argKey)) {
/* 333 */       setKey((IXstActionKey)OpChainKey.valueOf(argValue.toString()));
/* 334 */       this._realConfigObject.setChainKey(argValue.toString());
/*     */     }
/* 336 */     else if ("FormTabKey".equalsIgnoreCase(argKey) || "tabKey".equalsIgnoreCase(argKey)) {
/* 337 */       setKey((IXstActionKey)FormTabKey.forName(argValue.toString()));
/* 338 */       this._realConfigObject.setTabKey(argValue.toString());
/*     */     }
/* 340 */     else if ("FormOptionsKey".equalsIgnoreCase(argKey)) {
/* 341 */       setKey((IXstActionKey)FormOptionsKey.valueOf(argValue.toString()));
/* 342 */       this._realConfigObject.setFormOptionsKey(argValue.toString());
/*     */     }
/* 344 */     else if ("KeyStrokeKey".equalsIgnoreCase(argKey)) {
/* 345 */       setKey((IXstActionKey)XstKeyStroke.forName(argValue.toString()));
/* 346 */       this._realConfigObject.setKeyStrokeKey(argValue.toString());
/*     */     }
/* 348 */     else if ("SortKey".equalsIgnoreCase(argKey)) {
/* 349 */       setKey((IXstActionKey)SortActionKey.valueOf(argValue.toString()));
/* 350 */       this._realConfigObject.setSortKey(argValue.toString());
/*     */     }
/* 352 */     else if ("ChainType".equalsIgnoreCase(argKey)) {
/* 353 */       setType((IXstActionType)XstChainActionType.forName(argValue));
/* 354 */       this._realConfigObject.setChainType(argValue.toString());
/*     */     }
/* 356 */     else if ("Data".equalsIgnoreCase(argKey) && argValue instanceof IReflectionParameterCapable) {
/* 357 */       setData((IReflectionParameterCapable)argValue);
/* 358 */       this._realConfigObject.setData(argValue.toString());
/*     */     }
/* 360 */     else if ("TextKey".equalsIgnoreCase(argKey) || "text".equalsIgnoreCase(argKey)) {
/* 361 */       setTextKey(FormattableConfig.toFormattableConfig(argValue));
/* 362 */       this._realConfigObject.setText(argValue.toString());
/*     */     }
/* 364 */     else if ("rootText".equalsIgnoreCase(argKey)) {
/* 365 */       setRootTextKey(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 367 */     else if ("KeyStroke".equalsIgnoreCase(argKey)) {
/* 368 */       if ("default".equalsIgnoreCase(argValue.toString())) {
/*     */ 
/*     */         
/* 371 */         this._useDefaultKeyStrokes = true;
/* 372 */         this._keyStrokes.clear();
/* 373 */         this._primaryKeyStroke = null;
/*     */       } else {
/*     */         
/* 376 */         addKeyStroke((IXstKeyStroke)XstKeyStroke.forName(argValue.toString()));
/* 377 */         this._realConfigObject.getKeyStrokes().add(argValue.toString());
/*     */       }
/*     */     
/* 380 */     } else if ("Visible".equalsIgnoreCase(argKey)) {
/* 381 */       setVisible(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 383 */     else if ("Keywords".equalsIgnoreCase(argKey)) {
/* 384 */       setKeywords(argValue.toString());
/*     */     }
/* 386 */     else if (!"Category".equalsIgnoreCase(argKey)) {
/*     */ 
/*     */       
/* 389 */       if ("privilege".equalsIgnoreCase(argKey)) {
/* 390 */         this._realConfigObject.setPrivilege(argValue.toString());
/*     */       }
/* 392 */       else if ("subKey".equalsIgnoreCase(argKey)) {
/* 393 */         this._parameterConfigs.add(new ParameterConfig(argKey, argValue));
/* 394 */         Parameter param = new Parameter();
/* 395 */         param.setName(argKey);
/* 396 */         param.setValue(argValue.toString());
/* 397 */         this._realConfigObject.getParameters().add(param);
/* 398 */         this._realConfigObject.setSubKey(argValue.toString());
/*     */       }
/* 400 */       else if (argValue instanceof VisibilityRuleConfig) {
/* 401 */         VisibilityRuleConfig ruleConfig = (VisibilityRuleConfig)argValue;
/* 402 */         this._visibilityRuleConfigs.add(ruleConfig);
/*     */         
/* 404 */         Action.VisibilityRule visRule = new Action.VisibilityRule();
/* 405 */         visRule.setClazz(ruleConfig.getVisibilityRuleClass());
/*     */         
/* 407 */         for (ParameterConfig paramConfig : ruleConfig.getParameters()) {
/* 408 */           visRule.getParameters().add(convertParameterConfig(paramConfig));
/*     */         }
/*     */         
/* 411 */         this._realConfigObject.getVisibilityRules().add(visRule);
/*     */       }
/* 413 */       else if (argValue instanceof ParameterConfig) {
/* 414 */         ParameterConfig paramConfig = (ParameterConfig)argValue;
/* 415 */         this._parameterConfigs.add(paramConfig);
/* 416 */         this._realConfigObject.getParameters().add(convertParameterConfig(paramConfig));
/*     */       }
/* 418 */       else if (argValue instanceof IActionConfig) {
/* 419 */         this._postActionConfigs.add((IActionConfig)argValue);
/*     */       } else {
/*     */         
/* 422 */         super.setConfigObject(argKey, argValue);
/*     */       } 
/* 424 */     }  setClean();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setData(IReflectionParameterCapable<?> data) {
/* 430 */     this._data = data;
/* 431 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataIsFinal(boolean argIsDataFinal) {
/* 439 */     this._dataIsFinal = argIsDataFinal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIconKey(String argIconKey) {
/* 445 */     this._iconKey = argIconKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(IXstActionKey key) {
/* 451 */     this._key = key;
/* 452 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String key) {
/* 458 */     if (!StringUtils.isEmpty(key)) {
/* 459 */       this._key = this._key.get(key);
/* 460 */       setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyStroke(IXstKeyStroke keyStroke) {
/* 467 */     this._keyStrokes.clear();
/* 468 */     this._primaryKeyStroke = null;
/* 469 */     addKeyStroke(keyStroke);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeywords(String argKeywords) {
/* 475 */     this._realConfigObject.setKeywords(argKeywords);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReference(String argReference) {
/* 481 */     this._realConfigObject.setRef(argReference);
/* 482 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRootTextKey(IFormattableConfig newValue) {
/* 487 */     this._rootTextKey = newValue;
/* 488 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextKey(IFormattableConfig newValue) {
/* 493 */     this._textKey = newValue;
/* 494 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(IXstActionType type) {
/* 500 */     this._type = type;
/* 501 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(Boolean visible) {
/* 507 */     this._realConfigObject.setVisible(visible);
/* 508 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 514 */     return (new ToStringBuilder(this))
/* 515 */       .append(this._id + ((this._realConfigObject.getRef() == null) ? "" : (" <- " + this._realConfigObject.getRef())))
/* 516 */       .append("type", this._type)
/* 517 */       .append("key", this._key)
/* 518 */       .append("text", (this._textKey == null) ? null : this._textKey.getConfigValue())
/* 519 */       .append("keyStroke", this._primaryKeyStroke)
/* 520 */       .toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 528 */     argWriter.writeHeader("Action", "Action");
/* 529 */     argWriter.writeValue("Name", "String", getId());
/* 530 */     argWriter.writeValue("Ref", "String", getReference());
/*     */     
/* 532 */     if (this._key instanceof OpChainKey) {
/* 533 */       argWriter.writeValue("ChainKey", "String", this._key);
/* 534 */       argWriter.writeValue("ChainType", "String", this._type);
/*     */     } 
/* 536 */     if (this._key instanceof XstDataActionKey) {
/* 537 */       argWriter.writeValue("DataKey", "String", this._key);
/*     */     }
/* 539 */     if (this._key instanceof XstKeyStroke) {
/* 540 */       argWriter.writeValue("KeyStrokeKey", "String", this._key);
/*     */     }
/* 542 */     if (this._key instanceof FormTabKey) {
/* 543 */       argWriter.writeValue("FormTabKey", "String", this._key);
/*     */     }
/* 545 */     argWriter.writeValue("Data", getData());
/* 546 */     argWriter.writeValue((ISavableConfig)getIconGroupConfig());
/* 547 */     argWriter
/* 548 */       .writeValue(this._visibilityRuleConfigs.<ISavableConfig>toArray((ISavableConfig[])new VisibilityRuleConfig[this._visibilityRuleConfigs.size()]));
/* 549 */     argWriter.writeValue("TextKey", (IReflectionParameterCapable)this._textKey);
/* 550 */     argWriter.writeValue("KeyStroke", "String", getKeyStroke());
/* 551 */     argWriter.writeValue((ISavableConfig)getFontConfig());
/* 552 */     argWriter.writeValue((ISavableConfig)getColorGroupConfig());
/* 553 */     argWriter.writeValue("Visible", "Boolean", this._realConfigObject.getVisible());
/* 554 */     argWriter.writeValue((ISavableConfig[])this._parameterConfigs.toArray((Object[])new ParameterConfig[0]));
/* 555 */     argWriter.writeValue((ISavableConfig[])this._postActionConfigs.toArray((Object[])new IActionConfig[0]));
/*     */     
/* 557 */     argWriter.writeFooter("Action");
/* 558 */     setClean();
/*     */   }
/*     */   
/*     */   private Parameter convertParameterConfig(ParameterConfig argParamConfig) {
/* 562 */     Parameter param = new Parameter();
/* 563 */     param.setName(argParamConfig.getName());
/* 564 */     param.setValue(argParamConfig.getValue().toString());
/* 565 */     return param;
/*     */   }
/*     */   
/*     */   private KeyStroke getComplementaryKeyStroke(IXstKeyStroke xstKeyStroke) {
/* 569 */     if (xstKeyStroke == null) {
/* 570 */       return null;
/*     */     }
/* 572 */     KeyStroke keyStroke = xstKeyStroke.getKeyStroke();
/*     */     
/* 574 */     if (keyStroke == null) {
/* 575 */       return null;
/*     */     }
/*     */     
/* 578 */     int modifiers = keyStroke.getModifiers();
/* 579 */     boolean onRelease = keyStroke.isOnKeyRelease();
/*     */     
/* 581 */     switch (keyStroke.getKeyCode()) {
/*     */       case 48:
/* 583 */         return KeyStroke.getKeyStroke(96, modifiers, onRelease);
/*     */       case 49:
/* 585 */         return KeyStroke.getKeyStroke(97, modifiers, onRelease);
/*     */       case 50:
/* 587 */         return KeyStroke.getKeyStroke(98, modifiers, onRelease);
/*     */       case 51:
/* 589 */         return KeyStroke.getKeyStroke(99, modifiers, onRelease);
/*     */       case 52:
/* 591 */         return KeyStroke.getKeyStroke(100, modifiers, onRelease);
/*     */       case 53:
/* 593 */         return KeyStroke.getKeyStroke(101, modifiers, onRelease);
/*     */       case 54:
/* 595 */         return KeyStroke.getKeyStroke(102, modifiers, onRelease);
/*     */       case 55:
/* 597 */         return KeyStroke.getKeyStroke(103, modifiers, onRelease);
/*     */       case 56:
/* 599 */         return KeyStroke.getKeyStroke(104, modifiers, onRelease);
/*     */       case 57:
/* 601 */         return KeyStroke.getKeyStroke(105, modifiers, onRelease);
/*     */       case 46:
/* 603 */         return KeyStroke.getKeyStroke(110, modifiers, onRelease);
/*     */       
/*     */       case 96:
/* 606 */         return KeyStroke.getKeyStroke(48, modifiers, onRelease);
/*     */       case 97:
/* 608 */         return KeyStroke.getKeyStroke(49, modifiers, onRelease);
/*     */       case 98:
/* 610 */         return KeyStroke.getKeyStroke(50, modifiers, onRelease);
/*     */       case 99:
/* 612 */         return KeyStroke.getKeyStroke(51, modifiers, onRelease);
/*     */       case 100:
/* 614 */         return KeyStroke.getKeyStroke(52, modifiers, onRelease);
/*     */       case 101:
/* 616 */         return KeyStroke.getKeyStroke(53, modifiers, onRelease);
/*     */       case 102:
/* 618 */         return KeyStroke.getKeyStroke(54, modifiers, onRelease);
/*     */       case 103:
/* 620 */         return KeyStroke.getKeyStroke(55, modifiers, onRelease);
/*     */       case 104:
/* 622 */         return KeyStroke.getKeyStroke(56, modifiers, onRelease);
/*     */       case 105:
/* 624 */         return KeyStroke.getKeyStroke(57, modifiers, onRelease);
/*     */       case 110:
/* 626 */         return KeyStroke.getKeyStroke(46, modifiers, onRelease);
/*     */     } 
/* 628 */     return null;
/*     */   }
/*     */   
/*     */   private Object getDataValue() {
/* 632 */     if (this._data == null) {
/* 633 */       return null;
/*     */     }
/* 635 */     return this._data.getParamValue();
/*     */   }
/*     */   
/*     */   private List<ParameterConfig> getParameterConfigs() {
/* 639 */     return this._parameterConfigs;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */