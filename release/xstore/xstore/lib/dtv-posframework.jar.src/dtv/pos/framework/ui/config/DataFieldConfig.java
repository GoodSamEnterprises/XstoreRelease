/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.ui.config.IEditFormatterParams;
/*     */ import dtv.pos.ui.text.TextFieldFormatterFactory;
/*     */ import dtv.pos.ui.text.TextFieldFormatters;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import dtv.pos.ui.text.formatter.IDtvTextFormatter;
/*     */ import dtv.ui.swing.text.IStyler;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Currency;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public final class DataFieldConfig
/*     */   extends AbstractUIConfig
/*     */   implements IDataFieldConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  37 */   private static final TextFieldFormatterFactory TFFF = TextFieldFormatterFactory.getInstance();
/*  38 */   private static final Logger logger_ = Logger.getLogger(DataFieldConfig.class);
/*     */   
/*     */   public static final String MAIN_TAG = "DataField";
/*     */   
/*     */   private static final String NAME_TAG = "Name";
/*     */   
/*     */   private static final String REF_TAG = "Ref";
/*     */   
/*     */   private static final String EDIT_FORMAT_TAG = "EditFormat";
/*     */   private static final String EDIT_PATTERN_TAG = "EditPattern";
/*     */   private static final String DISPLAY_FORMAT_TAG = "DisplayFormat";
/*     */   private static final String DISPLAY_PATTERN_TAG = "DisplayPattern";
/*     */   private static final String DISPLAY_END_OF_VALUE_TAG = "DisplayEndOfValue";
/*     */   private static final String MAX_CHARACTERS_TAG = "MaxCharacters";
/*     */   private static final String ENTRY_MASKED = "EntryMasked";
/*     */   private static final String ENTRY_DISABLED = "EntryDisabled";
/*     */   private static final String TEXT_KEY_TAG = "TextKey";
/*     */   private static final String VALUE_TAG = "Value";
/*  56 */   private final Map<String, ParameterConfig> editFormatterParams_ = new HashMap<>();
/*     */   private String name_;
/*     */   private TextFieldInputType editFormatType_;
/*     */   private TextFieldInputType displayFormatType_;
/*     */   private MutableString editPattern_;
/*     */   private MutableString displayPattern_;
/*     */   private IFormattableConfig textKeyConfig_;
/*     */   private IStyler styler_;
/*     */   private Integer maxCharacters_;
/*     */   private Boolean isEntryMasked_;
/*     */   private Boolean isEntryDisabled_;
/*     */   private Boolean isEndOfValueDisplayed_;
/*     */   private Object value_;
/*     */   private String toString_;
/*     */   private String ref_;
/*     */   private Boolean _editable;
/*     */   
/*     */   public void cascadeValues(IConfigObject sourceConfig) {
/*  74 */     if (!(sourceConfig instanceof DataFieldConfig)) {
/*  75 */       if (sourceConfig != null) {
/*  76 */         logger_
/*  77 */           .error("Attempted to cascade from invalid configuration object::" + 
/*     */             
/*  79 */             getSourceDescription(sourceConfig) + "-->" + getSourceDescription(), new Throwable("STACK TRACE"));
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*  84 */     super.cascadeValues(sourceConfig);
/*  85 */     DataFieldConfig config = (DataFieldConfig)sourceConfig;
/*     */     
/*  87 */     if (MutableString.isEmpty(getDisplayPattern())) {
/*  88 */       this.displayPattern_ = config.getDisplayPattern();
/*     */     }
/*  90 */     if (MutableString.isEmpty(getEditPattern())) {
/*  91 */       this.editPattern_ = config.getEditPattern();
/*     */     }
/*  93 */     if (getDisplayFormatType() == null) {
/*  94 */       setDisplayFormatType(config.getDisplayFormatType());
/*     */     }
/*  96 */     if (getFormatType() == null) {
/*  97 */       setFormatType(config.getFormatType());
/*     */     }
/*  99 */     if (internalMaxCharacters() == null) {
/* 100 */       setMaxCharacters(config.internalMaxCharacters());
/*     */     }
/* 102 */     if (getTextKeyConfig() == null) {
/* 103 */       setTextKeyConfig(config.getTextKeyConfig());
/*     */     }
/* 105 */     if (getValue() == null) {
/* 106 */       setDefaultValue(config.getValue());
/*     */     }
/* 108 */     if (this.isEntryMasked_ == null) {
/* 109 */       setEntryMasked(Boolean.valueOf(config.isEntryMasked()));
/*     */     }
/* 111 */     if (this.isEntryDisabled_ == null) {
/* 112 */       setEntryDisabled(config.isEntryDisabled());
/*     */     }
/* 114 */     if (this.isEndOfValueDisplayed_ == null) {
/* 115 */       setEndOfValueDisplayed(config.isEndOfValueDisplayed());
/*     */     }
/* 117 */     if (this.editFormatterParams_.isEmpty()) {
/* 118 */       this.editFormatterParams_.putAll(config.editFormatterParams_);
/*     */     }
/* 120 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public TextFieldInputType getDisplayFormatType() {
/* 125 */     return (this.displayFormatType_ != null) ? this.displayFormatType_ : this.editFormatType_;
/*     */   }
/*     */   
/*     */   public MutableString getDisplayPattern() {
/* 129 */     return (this.displayPattern_ != null) ? this.displayPattern_ : getEditPattern();
/*     */   }
/*     */ 
/*     */   
/*     */   public IEditFormatterParams getEditFormatterParams() {
/* 134 */     return new EditFormatterParams(getEditFormatterParamsAsArray());
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableString getEditPattern() {
/* 139 */     return (this.editPattern_ != null) ? this.editPattern_ : MutableString.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextFieldFormatters getFormatters() {
/* 145 */     JFormattedTextField.AbstractFormatter editFormatter = TFFF.getFormatter(getFormatType(), getEditPattern());
/*     */     
/* 147 */     if (editFormatter instanceof IDtvTextFormatter) {
/* 148 */       IDtvTextFormatter dtvFormatter = (IDtvTextFormatter)editFormatter;
/* 149 */       for (ParameterConfig config : this.editFormatterParams_.values()) {
/* 150 */         Object value = config.getValue();
/*     */         
/* 152 */         if (value instanceof IReflectionParameterCapable) {
/* 153 */           value = ((IReflectionParameterCapable)value).getParamValue();
/*     */         }
/* 155 */         dtvFormatter.setParameter(config.getName(), value);
/*     */       } 
/* 157 */       if (this.maxCharacters_ != null) {
/* 158 */         dtvFormatter.setParameter("MaxCharacters", this.maxCharacters_);
/*     */       }
/*     */     } 
/* 161 */     JFormattedTextField.AbstractFormatter displayFormatter = TFFF.getFormatter(getDisplayFormatType(), getDisplayPattern());
/*     */     
/* 163 */     return new TextFieldFormatters(editFormatter, displayFormatter);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextFieldInputType getFormatType() {
/* 168 */     return this.editFormatType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxCharacters() {
/* 174 */     return ConfigUtils.asInt(this.maxCharacters_, 0);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 178 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IStyler getStyler() {
/* 184 */     return this.styler_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getTextKey() {
/* 189 */     return (this.textKeyConfig_ != null) ? this.textKeyConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue() {
/* 194 */     return this.value_;
/*     */   }
/*     */   
/*     */   public boolean hasChanges() {
/* 198 */     return (this.editFormatType_ != null || this.displayFormatType_ != null || getEditFormatterParams().hasChanges());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean isEditable() {
/* 204 */     return this._editable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEndOfValueDisplayed() {
/* 210 */     return ConfigUtils.asBool(this.isEndOfValueDisplayed_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEntryDisabled() {
/* 215 */     return ConfigUtils.asBool(this.isEntryDisabled_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEntryMasked() {
/* 220 */     return ConfigUtils.asBool(this.isEntryMasked_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 225 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 226 */       this.name_ = argValue.toString();
/*     */     }
/* 228 */     else if ("Ref".equalsIgnoreCase(argKey)) {
/* 229 */       this.ref_ = argValue.toString();
/* 230 */       DataFieldConfig refConfig = DataFieldConfigHelper.getFieldConfig(this.ref_);
/* 231 */       if (refConfig == null) {
/* 232 */         logger_.error(argValue.toString() + " is not a valid Data Field reference @@ " + argValue
/* 233 */             .getSourceDescription());
/*     */         return;
/*     */       } 
/* 236 */       cascadeValues((IConfigObject)refConfig);
/*     */     }
/* 238 */     else if (argKey.equalsIgnoreCase("DisplayFormat")) {
/* 239 */       setDisplayFormatType(TextFieldInputType.forName(argValue.toString()));
/*     */     }
/* 241 */     else if (argKey.equalsIgnoreCase("DisplayPattern")) {
/* 242 */       setDisplayPattern(argValue.toString());
/*     */     }
/* 244 */     else if (argKey.equalsIgnoreCase("DisplayEndOfValue")) {
/* 245 */       setEndOfValueDisplayed(Boolean.valueOf(ConfigUtils.toBoolean(argValue)).booleanValue());
/*     */     }
/* 247 */     else if (argKey.equalsIgnoreCase("EditFormat")) {
/* 248 */       setFormatType(TextFieldInputType.forName(argValue.toString()));
/*     */     }
/* 250 */     else if (argKey.equalsIgnoreCase("EditPattern")) {
/* 251 */       setEditPattern(argValue.toString());
/*     */     }
/* 253 */     else if (argKey.equalsIgnoreCase("MaxCharacters")) {
/* 254 */       setMaxCharacters(Integer.valueOf(ConfigUtils.toInt(argValue)));
/*     */     }
/* 256 */     else if (argKey.equalsIgnoreCase("EntryMasked")) {
/* 257 */       setEntryMasked(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 259 */     else if (argKey.equalsIgnoreCase("EntryDisabled")) {
/* 260 */       setEntryDisabled(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 262 */     else if (argKey.equalsIgnoreCase("TextKey") && argValue instanceof IFormattableConfig) {
/* 263 */       setTextKeyConfig((IFormattableConfig)argValue);
/*     */     }
/* 265 */     else if (argKey.equalsIgnoreCase("Value")) {
/* 266 */       setDefaultValue(argValue.toString());
/*     */     }
/* 268 */     else if (argKey.equalsIgnoreCase("Editable")) {
/* 269 */       this._editable = Boolean.valueOf(ConfigUtils.toBoolean(argValue));
/*     */     }
/* 271 */     else if (argValue instanceof ParameterConfig) {
/* 272 */       addEditParameter((ParameterConfig)argValue);
/*     */     } else {
/*     */       
/* 275 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/* 277 */     setClean();
/* 278 */     this.toString_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrency(Currency argCurrency) {
/* 284 */     ParameterConfig currencyConfig = new ParameterConfig(new StringConfig("currency"), (IConfigObject)new StringConfig(argCurrency.getCurrencyCode()));
/*     */     
/* 286 */     addEditParameter(currencyConfig);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDefaultValue(Object value) {
/* 291 */     this.value_ = value;
/* 292 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDirty() {
/* 297 */     this.toString_ = null;
/* 298 */     super.setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisplayFormatType(TextFieldInputType formatType) {
/* 303 */     this.displayFormatType_ = formatType;
/* 304 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setDisplayPattern(String pattern) {
/* 308 */     this.displayPattern_ = LocaleManager.getInstance().getRegisteredString(pattern);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEditFormatterParams(IEditFormatterParams newValue) {
/* 313 */     this.editFormatterParams_.clear();
/* 314 */     addEditParameters(Arrays.asList(newValue.getConfigs()));
/* 315 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEditPattern(String pattern) {
/* 320 */     this.editPattern_ = LocaleManager.getInstance().getRegisteredString(pattern);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndOfValueDisplayed(boolean argDisplayEndOfValue) {
/* 326 */     this.isEndOfValueDisplayed_ = Boolean.valueOf(argDisplayEndOfValue);
/* 327 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setEntryDisabled(boolean argEntryDisabled) {
/* 331 */     this.isEntryDisabled_ = Boolean.valueOf(argEntryDisabled);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFormatType(TextFieldInputType formatType) {
/* 336 */     this.editFormatType_ = formatType;
/* 337 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxCharacters(int maxCharacters) {
/* 342 */     setMaxCharacters(Integer.valueOf(maxCharacters));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyler(IStyler argStyler) {
/* 348 */     this.styler_ = argStyler;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextKey(String textKey) {
/* 353 */     this.textKeyConfig_ = (IFormattableConfig)new TranslatableConfig();
/* 354 */     this.textKeyConfig_.setValue(textKey);
/*     */     
/* 356 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 361 */     if (this.toString_ == null) {
/* 362 */       IEditFormatterParams p = getEditFormatterParams();
/* 363 */       StringBuffer sb = new StringBuffer();
/* 364 */       sb.append("[edit=");
/* 365 */       sb.append(this.editFormatType_);
/* 366 */       sb.append(",edit.pattern=");
/* 367 */       sb.append(getEditPattern());
/*     */       
/* 369 */       if (p.getMaxCharacters() != null) {
/* 370 */         sb.append(",max char=");
/* 371 */         sb.append(p.getMaxCharacters());
/*     */       } 
/* 373 */       if (p.getMaximumIntegerDigits() != null) {
/* 374 */         sb.append(",max int=");
/* 375 */         sb.append(p.getMaximumIntegerDigits());
/*     */       } 
/* 377 */       if (p.getRegexPolicy() != null) {
/* 378 */         sb.append(",regex=");
/* 379 */         sb.append(p.getRegexPolicy());
/*     */       } 
/* 381 */       if (p.getMaximumFractionalDigits() != null) {
/* 382 */         sb.append(",max fract=");
/* 383 */         sb.append(p.getMaximumFractionalDigits());
/*     */       } 
/* 385 */       if (p.getAllowNull() != null) {
/* 386 */         sb.append(",null ok=");
/* 387 */         sb.append(p.getAllowNull());
/*     */       } 
/* 389 */       if (p.getAllowNegative() != null) {
/* 390 */         sb.append(",negs=");
/* 391 */         sb.append(p.getAllowNegative());
/*     */       } 
/* 393 */       if (this.displayFormatType_ != null) {
/* 394 */         sb.append(",display=");
/* 395 */         sb.append(this.displayFormatType_);
/*     */       } 
/* 397 */       sb.append(",display.pattern=");
/* 398 */       sb.append(getDisplayPattern());
/*     */       
/* 400 */       if (p.getMaximumAllowedValue() != null) {
/* 401 */         sb.append(",max.value=");
/* 402 */         sb.append(p.getMaximumAllowedValue());
/*     */       } 
/* 404 */       if (p.getMinimumAllowedValue() != null) {
/* 405 */         sb.append(",min.value=");
/* 406 */         sb.append(p.getMinimumAllowedValue());
/*     */       } 
/* 408 */       sb.append("]");
/*     */       
/* 410 */       this.toString_ = sb.toString();
/*     */     } 
/* 412 */     return this.toString_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 419 */     if (this.ref_ == null) {
/* 420 */       argWriter.writeHeader("DataField", "DataField", "EditFormat=\"" + this.editFormatType_ + "\"");
/*     */       
/* 422 */       argWriter.writeValue((ISavableConfig)getFontConfig());
/* 423 */       argWriter.writeValue((ISavableConfig)getColorGroupConfig());
/* 424 */       if (!MutableString.isEmpty(this.editPattern_)) {
/* 425 */         argWriter.writeValue("EditPattern", "String", this.editPattern_.toString());
/*     */       }
/* 427 */       argWriter.writeValue("DisplayFormat", "String", this.displayFormatType_);
/* 428 */       if (!MutableString.isEmpty(this.displayPattern_)) {
/* 429 */         argWriter.writeValue("DisplayPattern", "String", this.displayPattern_.toString());
/*     */       }
/* 431 */       argWriter.writeValue((ISavableConfig[])getEditFormatterParamsAsArray());
/* 432 */       argWriter.writeValue("MaxCharacters", "Integer", this.maxCharacters_);
/* 433 */       argWriter.writeValue("EntryMasked", "Boolean", this.isEntryMasked_);
/* 434 */       argWriter.writeValue("EntryDisabled", "Boolean", this.isEntryDisabled_);
/* 435 */       argWriter.writeValue("DisplayEndOfValue", "Boolean", this.isEndOfValueDisplayed_);
/*     */       
/* 437 */       argWriter.writeFooter("DataField");
/*     */     } else {
/*     */       
/* 440 */       argWriter.writeElement("DataField", "Ref=\"" + this.ref_ + "\"");
/*     */     } 
/* 442 */     setClean();
/*     */   }
/*     */   
/*     */   protected Integer internalMaxCharacters() {
/* 446 */     return this.maxCharacters_;
/*     */   }
/*     */   
/*     */   private void addEditParameter(ParameterConfig argParam) {
/* 450 */     this.editFormatterParams_.put(argParam.getName(), argParam);
/*     */   }
/*     */   
/*     */   private void addEditParameters(Collection<? extends ParameterConfig> argParams) {
/* 454 */     for (ParameterConfig param : argParams) {
/* 455 */       this.editFormatterParams_.put(param.getName(), param);
/*     */     }
/*     */   }
/*     */   
/*     */   private ParameterConfig[] getEditFormatterParamsAsArray() {
/* 460 */     return (ParameterConfig[])this.editFormatterParams_.values().toArray((Object[])new ParameterConfig[this.editFormatterParams_.size()]);
/*     */   }
/*     */   
/*     */   private IFormattableConfig getTextKeyConfig() {
/* 464 */     return this.textKeyConfig_;
/*     */   }
/*     */   
/*     */   private void setEntryDisabled(Boolean entryDisabled) {
/* 468 */     this.isEntryDisabled_ = entryDisabled;
/* 469 */     setDirty();
/*     */   }
/*     */   
/*     */   private void setEntryMasked(Boolean entryMasked) {
/* 473 */     this.isEntryMasked_ = entryMasked;
/* 474 */     setDirty();
/*     */   }
/*     */   
/*     */   private void setMaxCharacters(Integer maxCharacters) {
/* 478 */     this.maxCharacters_ = maxCharacters;
/* 479 */     setDirty();
/*     */   }
/*     */   
/*     */   private void setTextKeyConfig(IFormattableConfig textKeyConfig) {
/* 483 */     this.textKeyConfig_ = textKeyConfig;
/* 484 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\DataFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */