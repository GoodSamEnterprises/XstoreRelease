/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.TranslationHelper;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.ui.config.RendererDefConfig;
/*     */ import dtv.pos.i18n.config.FormattableConfig;
/*     */ import dtv.pos.i18n.config.LiteralConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.form.config.ITableColumnsConfig;
/*     */ import dtv.pos.iframework.form.design.type.FormComponentType;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.ScrollingPolicy;
/*     */ import dtv.pos.iframework.ui.SelectionMode;
/*     */ import dtv.pos.iframework.ui.config.IRendererDefConfig;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class FormViewCellConfig
/*     */   extends AbstractFormComponentConfig
/*     */   implements IFormViewCellConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "FormViewCell";
/*     */   private static final String ENTRY_MASKED = "EntryMasked";
/*     */   private static final String ENUM_POSSIBLE_VALUES = "PossibleValues";
/*     */   private static final String FORMATTER_TYPE_TAG = "FormatterType";
/*     */   private static final String HORIZONTAL_SCROLL_POLICY_TAG = "HorizontalScrollPolicy";
/*     */   private static final String NOTIFY_DELAY = "NotifyDelay";
/*     */   private static final String READ_ONLY_TAG = "ReadOnly";
/*     */   private static final String REQUIRED_TAG = "Required";
/*     */   private static final String FIELD_WEIGHT_TAG = "FieldWeight";
/*     */   private static final String RESOURCE_TAG = "Resource";
/*     */   private static final String RESOURCE_LINK_TAG = "ResourceLink";
/*     */   private static final String VALUE_TAG = "Value";
/*     */   private static final String SELECTION_MODE_TAG = "SelectionMode";
/*     */   private static final String TEXT_KEY_TAG = "TextKey";
/*     */   private static final String BORDER_TEXT_KEY_TAG = "BorderTextKey";
/*     */   private static final String VERTICAL_SCROLL_POLICY_TAG = "VerticalScrollPolicy";
/*     */   private static final String ALWAYS_ENABLED_TAG = "AlwaysEnabled";
/*     */   private static final String XML_TAG_TAG = "XmlTag";
/*     */   private static final String HIDE_FROM_XSTOREM_TAG = "HideFromXstoreM";
/*     */   
/*     */   private static boolean isFormPanelType(String argType) {
/*  58 */     return FormComponentType.PANEL.toString().equals(argType);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final String REFRESH_DEPENDENT_VALUES_TAG = "RefreshDependentValues";
/*     */   private static final String VISIBILITY_GROUP_TAG = "VisibilityGroup";
/*     */   private ITableColumnsConfig columns_;
/*     */   private EnumPossibleValues enumPossibleValues_;
/*     */   private FormatterType formatterType_;
/*     */   private ScrollingPolicy horizontalScrollPolicy_;
/*     */   private SelectionMode listSelectionMode_;
/*     */   private Integer notifyDelay_;
/*     */   private Map<String, IRendererDefConfig> rendererMap_;
/*     */   private Boolean required_;
/*     */   private Boolean readOnly_;
/*     */   private Boolean entryMasked_;
/*     */   private Integer fieldWeight_;
/*     */   private String resource_;
/*     */   private IFormattableConfig valueConfig_;
/*     */   private IFormattableConfig textKeyConfig_;
/*     */   private IFormattableConfig borderTextKeyConfig_;
/*     */   private ScrollingPolicy verticalScrollPolicy_;
/*     */   private boolean _alwaysEnabled;
/*     */   private String xmlTag_;
/*     */   private String resourceLink_;
/*     */   private boolean hideFromXstoreM_ = false;
/*     */   private boolean refreshDependentValues_ = false;
/*     */   private String visibilityGroup_;
/*     */   
/*     */   public FormViewCellConfig() {
/*  88 */     this.notifyDelay_ = Integer.valueOf(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean allowsPossibleValues() {
/*  94 */     String type = getType();
/*  95 */     if (FormComponentType.COMBO_BOX.toString().equals(type)) {
/*  96 */       return true;
/*     */     }
/*  98 */     if (FormComponentType.LIST.toString().equals(type)) {
/*  99 */       return Boolean.TRUE.equals(getUseSimpleRenderer());
/*     */     }
/*     */     
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(IFormComponentConfig<?> argOther) {
/* 110 */     if (argOther instanceof FormViewCellConfig) {
/* 111 */       boolean isPanel = isFormPanelType(getType());
/* 112 */       boolean otherIsPanel = isFormPanelType(argOther.getType());
/* 113 */       if (isPanel && !otherIsPanel) {
/* 114 */         return 1;
/*     */       }
/* 116 */       if (!isPanel && otherIsPanel) {
/* 117 */         return -1;
/*     */       }
/*     */     } 
/*     */     
/* 121 */     return super.compareTo(argOther);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getBorderTextKey() {
/* 127 */     return (this.borderTextKeyConfig_ != null) ? this.borderTextKeyConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElementType getCellRendererType() {
/* 137 */     IViewElementType type = null;
/*     */     
/* 139 */     if (usesCellRendering()) {
/* 140 */       IRendererDefConfig def = getRendererDef("Cell");
/* 141 */       if (def != null) {
/* 142 */         type = def.getType();
/*     */       }
/*     */     } 
/* 145 */     return type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElementType getColumnHeaderRendererType() {
/* 155 */     IViewElementType type = null;
/*     */     
/* 157 */     if (usesCellRendering()) {
/* 158 */       IRendererDefConfig def = getRendererDef("ColumnHeader");
/*     */       
/* 160 */       if (def != null) {
/* 161 */         type = def.getType();
/*     */       }
/*     */     } 
/* 164 */     return type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumPossibleValues getEnumPossibleValues() {
/* 170 */     return allowsPossibleValues() ? this.enumPossibleValues_ : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getFieldWeight() {
/* 176 */     return this.fieldWeight_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormatterType getFormatterType() {
/* 182 */     return this.formatterType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHideFromXstoreM() {
/* 188 */     return this.hideFromXstoreM_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ScrollingPolicy getHorizontalScrollingPolicy() {
/* 194 */     return usesScrolling() ? this.horizontalScrollPolicy_ : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getNotifyDelay() {
/* 200 */     return this.notifyDelay_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getReadOnly() {
/* 206 */     return (this.readOnly_ == null) ? Boolean.FALSE : this.readOnly_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getRefreshDependentValues() {
/* 212 */     return this.refreshDependentValues_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IRendererDefConfig getRendererDef(String argRole) {
/* 218 */     return getRendererDef(argRole, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getRequired() {
/* 224 */     return this.required_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResource() {
/* 230 */     return this.resource_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResourceLink() {
/* 236 */     return this.resourceLink_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectionMode getSelectionMode() {
/* 242 */     return usesCellRendering() ? ((this.listSelectionMode_ == null) ? SelectionMode.MULTIPLE_SELECTION : this.listSelectionMode_) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITableColumnsConfig getTableColumnsConfig() {
/* 251 */     return this.columns_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTextKey() {
/* 257 */     return (this.textKeyConfig_ != null) ? this.textKeyConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 263 */     return getClassType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getUseSimpleRenderer() {
/* 274 */     Boolean simple = null;
/*     */     
/* 276 */     if (usesCellRendering()) {
/* 277 */       IRendererDefConfig def = getRendererDef("Cell");
/* 278 */       if (def != null) {
/* 279 */         simple = Boolean.valueOf(def.isSimple());
/*     */       }
/*     */     } 
/* 282 */     return simple;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getValue() {
/* 288 */     return (this.valueConfig_ != null) ? this.valueConfig_.getFormattable() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ScrollingPolicy getVerticalScrollingPolicy() {
/* 294 */     return usesScrolling() ? this.verticalScrollPolicy_ : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVisibilityGroup() {
/* 300 */     return this.visibilityGroup_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXmlTag() {
/* 306 */     return this.xmlTag_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlwaysEnabled() {
/* 315 */     return this._alwaysEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEntryMasked() {
/* 321 */     return ConfigUtils.asBool(this.entryMasked_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEquivalent(Object o) {
/* 327 */     if (!(o instanceof FormViewCellConfig)) {
/* 328 */       return false;
/*     */     }
/* 330 */     FormViewCellConfig other = (FormViewCellConfig)o;
/* 331 */     return other.getLayoutLocation().equals(getLayoutLocation());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 337 */     return ConfigUtils.asBool(this.readOnly_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/* 343 */     return ConfigUtils.asBool(this.required_);
/*     */   }
/*     */   
/*     */   public void setBorderTextKey(IFormattableConfig argTextKeyConfig) {
/* 347 */     this.borderTextKeyConfig_ = argTextKeyConfig;
/* 348 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setBorderTextKey(String textKey) {
/* 352 */     if (StringUtils.isEmpty(textKey)) {
/* 353 */       this.borderTextKeyConfig_ = null;
/*     */     }
/* 355 */     else if (TranslationHelper.getInstance().isTranslationKey(textKey)) {
/* 356 */       this.borderTextKeyConfig_ = (IFormattableConfig)new TranslatableConfig(textKey);
/*     */     } else {
/*     */       
/* 359 */       this.borderTextKeyConfig_ = (IFormattableConfig)new LiteralConfig(textKey);
/*     */     } 
/* 361 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCellRendererType(IViewElementType argRendererType) {
/* 371 */     if (usesCellRendering()) {
/* 372 */       getRendererDef("Cell", true).setType(argRendererType);
/* 373 */       setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 380 */     if (argKey.equalsIgnoreCase("Resource")) {
/* 381 */       setResource(argValue.toString());
/*     */     }
/* 383 */     else if (argKey.equalsIgnoreCase("ResourceLink")) {
/* 384 */       setResourceLink(argValue.toString());
/*     */     }
/* 386 */     else if (argKey.equalsIgnoreCase("HideFromXstoreM")) {
/* 387 */       setHideFromXstoreM(ConfigUtils.toBoolean(argValue, false).booleanValue());
/*     */     }
/* 389 */     else if (argKey.equalsIgnoreCase("RefreshDependentValues")) {
/* 390 */       setRefreshDependentValues(ConfigUtils.toBoolean(argValue, false).booleanValue());
/*     */     }
/* 392 */     else if ("Value".equalsIgnoreCase(argKey)) {
/* 393 */       setValue(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 395 */     else if (argKey.equalsIgnoreCase("TextKey")) {
/* 396 */       setTextKey(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 398 */     else if (argKey.equalsIgnoreCase("BorderTextKey")) {
/* 399 */       setBorderTextKey(FormattableConfig.toFormattableConfig(argValue));
/*     */     }
/* 401 */     else if (argKey.equalsIgnoreCase("Required")) {
/* 402 */       setRequired(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 404 */     else if (argKey.equalsIgnoreCase("FieldWeight")) {
/* 405 */       setFieldWeight(Integer.valueOf(ConfigUtils.toInt(argValue)));
/*     */     }
/* 407 */     else if (argKey.equalsIgnoreCase("ReadOnly")) {
/* 408 */       setReadOnly(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 410 */     else if ("FormatterType".equalsIgnoreCase(argKey)) {
/* 411 */       this.formatterType_ = FormatterType.forName(argValue.toString());
/*     */     }
/* 413 */     else if (argValue instanceof TableColumnsConfig) {
/* 414 */       this.columns_ = (TableColumnsConfig)argValue;
/*     */     }
/* 416 */     else if ("SelectionMode".equalsIgnoreCase(argKey)) {
/* 417 */       this.listSelectionMode_ = SelectionMode.forName(argValue);
/* 418 */       if (this.listSelectionMode_ == null) {
/* 419 */         this.listSelectionMode_ = SelectionMode.MULTIPLE_SELECTION;
/*     */       }
/*     */     }
/* 422 */     else if ("HorizontalScrollPolicy".equalsIgnoreCase(argKey)) {
/* 423 */       setHorizontalScrollingPolicy(ScrollingPolicy.forName(argValue));
/*     */     }
/* 425 */     else if ("VerticalScrollPolicy".equalsIgnoreCase(argKey)) {
/* 426 */       setVerticalScrollingPolicy(ScrollingPolicy.forName(argValue));
/*     */     }
/* 428 */     else if ("PossibleValues".equalsIgnoreCase(argKey)) {
/* 429 */       this.enumPossibleValues_ = EnumPossibleValues.makeFromConfigValue(argValue.toString());
/*     */     }
/* 431 */     else if ("XmlTag".equalsIgnoreCase(argKey)) {
/* 432 */       setXmlTag(argValue.toString());
/*     */     }
/* 434 */     else if ("NotifyDelay".equalsIgnoreCase(argKey)) {
/* 435 */       this.notifyDelay_ = Integer.valueOf(ConfigUtils.toInt(argValue));
/*     */     }
/* 437 */     else if ("EntryMasked".equalsIgnoreCase(argKey)) {
/* 438 */       setEntryMasked(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 440 */     else if (argValue instanceof IRendererDefConfig) {
/* 441 */       setRendererDef((IRendererDefConfig)argValue);
/*     */     }
/* 443 */     else if ("AlwaysEnabled".equalsIgnoreCase(argKey)) {
/* 444 */       this._alwaysEnabled = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 446 */     else if ("VisibilityGroup".equalsIgnoreCase(argKey)) {
/* 447 */       setVisibilityGroup(argValue.toString());
/*     */     } else {
/*     */       
/* 450 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/* 452 */     setClean();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnumPossibleValues(EnumPossibleValues newValue) {
/* 458 */     if (allowsPossibleValues()) {
/* 459 */       this.enumPossibleValues_ = newValue;
/* 460 */       setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldWeight(Integer argFieldWeight) {
/* 467 */     this.fieldWeight_ = argFieldWeight;
/* 468 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatterType(FormatterType newValue) {
/* 474 */     this.formatterType_ = newValue;
/* 475 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeaderRendererType(IViewElementType argRendererType) {
/* 485 */     if (usesCellRendering()) {
/* 486 */       getRendererDef("ColumnHeader", true).setType(argRendererType);
/*     */       
/* 488 */       setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHideFromXstoreM(boolean argHideFromXstoreM) {
/* 495 */     this.hideFromXstoreM_ = argHideFromXstoreM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontalScrollingPolicy(ScrollingPolicy policy) {
/* 501 */     this.horizontalScrollPolicy_ = policy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotifyDelay(Integer argValue) {
/* 507 */     this.notifyDelay_ = (argValue == null) ? Integer.valueOf(0) : argValue;
/* 508 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(Boolean argReadOnly) {
/* 518 */     this.readOnly_ = Boolean.FALSE.equals(argReadOnly) ? null : argReadOnly;
/* 519 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRefreshDependentValues(boolean argRefresh) {
/* 525 */     this.refreshDependentValues_ = argRefresh;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRendererDef(IRendererDefConfig argRendererDef) {
/* 531 */     if (argRendererDef != null) {
/* 532 */       getRendererMap().put(argRendererDef.getRole(), argRendererDef);
/* 533 */       setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(Boolean argRequired) {
/* 544 */     this.required_ = argRequired;
/* 545 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResource(String resource) {
/* 551 */     this.resource_ = (resource == null || resource.trim().length() == 0) ? null : resource.trim();
/* 552 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResourceLink(String argResourceLink) {
/* 558 */     this.resourceLink_ = argResourceLink;
/* 559 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectionMode(SelectionMode newValue) {
/* 565 */     if (usesCellRendering()) {
/* 566 */       this.listSelectionMode_ = newValue;
/* 567 */       setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextKey(IFormattableConfig textKeyConfig) {
/* 574 */     if (this.textKeyConfig_ instanceof LiteralConfig && 
/* 575 */       StringUtils.isEmpty(((LiteralConfig)this.textKeyConfig_).getConfigValue())) {
/* 576 */       this.textKeyConfig_ = null;
/*     */     } else {
/*     */       
/* 579 */       this.textKeyConfig_ = textKeyConfig;
/*     */     } 
/* 581 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextKey(String textKey) {
/* 587 */     if (StringUtils.isEmpty(textKey)) {
/* 588 */       this.textKeyConfig_ = null;
/*     */     }
/* 590 */     else if (FormComponentType.ICON.toString().equals(getType())) {
/* 591 */       this.textKeyConfig_ = (IFormattableConfig)new LiteralConfig();
/* 592 */       this.textKeyConfig_.setValue(textKey);
/*     */     
/*     */     }
/* 595 */     else if (TranslationHelper.getInstance().isTranslationKey(textKey)) {
/* 596 */       this.textKeyConfig_ = (IFormattableConfig)new TranslatableConfig(textKey);
/*     */     } else {
/*     */       
/* 599 */       this.textKeyConfig_ = (IFormattableConfig)new LiteralConfig(textKey);
/*     */     } 
/*     */     
/* 602 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String newValue) {
/* 608 */     setClassType(newValue);
/* 609 */     setTextKey(String.valueOf(getTextKey().getUnformattedData()));
/* 610 */     setDirty();
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
/*     */   public void setUseSimpleRenderer(Boolean argUseSimpleRenderer) {
/* 622 */     if (usesCellRendering()) {
/* 623 */       getRendererDef("Cell", true).setSimple((argUseSimpleRenderer == null) ? false : argUseSimpleRenderer
/* 624 */           .booleanValue());
/*     */       
/* 626 */       setDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(IFormattableConfig argValueConfig) {
/* 633 */     this.valueConfig_ = argValueConfig;
/* 634 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalScrollingPolicy(ScrollingPolicy policy) {
/* 640 */     this.verticalScrollPolicy_ = policy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisibilityGroup(String argVisibilityGroup) {
/* 646 */     this.visibilityGroup_ = argVisibilityGroup;
/* 647 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXmlTag(String argXmlTag) {
/* 653 */     this.xmlTag_ = argXmlTag;
/* 654 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 662 */     StringBuilder attr = new StringBuilder();
/* 663 */     if (getComponentId() != null) {
/* 664 */       attr.append(" componentID=\"").append(getComponentId()).append("\"");
/*     */     }
/* 666 */     if (getEditableLayoutLocation().getHorizontalAlignment() != null && 
/* 667 */       getEditableLayoutLocation().getVerticalAlignment() != null) {
/* 668 */       attr.append(" layoutLocation=\"").append(getEditableLayoutLocation().toString()).append("\"");
/*     */     }
/* 670 */     if (!StringUtils.isEmpty(getType())) {
/* 671 */       attr.append(" type=\"").append(getType()).append("\"");
/*     */     }
/* 673 */     if (getTextKeyConfig() != null && !getTextKeyConfig().getConfigValue().isEmpty()) {
/* 674 */       attr.append(" textKey=\"").append(getTextKeyConfig().getConfigValue()).append("\"");
/*     */     }
/* 676 */     if (!StringUtils.isEmpty(getResource())) {
/* 677 */       attr.append(" resource=\"").append(getResource()).append("\"");
/*     */     }
/* 679 */     if (!StringUtils.isEmpty(getResourceLink())) {
/* 680 */       attr.append(" resourceLink=\"").append(getResourceLink()).append("\"");
/*     */     }
/* 682 */     if (!StringUtils.isEmpty(getVisibilityGroup())) {
/* 683 */       attr.append(" visibilityGroup=\"").append(getVisibilityGroup()).append("\"");
/*     */     }
/* 685 */     argWriter.writeHeader("FormViewCell", "FormViewCell", attr.toString().trim());
/* 686 */     argWriter.writeValue("Value", (IReflectionParameterCapable)getValueConfig());
/* 687 */     argWriter.writeValue("BorderTextKey", (IReflectionParameterCapable)getBorderTextKeyConfig());
/* 688 */     argWriter.writeValue("FormatterType", "String", this.formatterType_);
/*     */     
/* 690 */     Boolean readOnly = getReadOnly();
/* 691 */     if (readOnly != null && readOnly.booleanValue()) {
/* 692 */       argWriter.writeValue("ReadOnly", "Boolean", readOnly);
/*     */     }
/* 694 */     argWriter.writeValue("Required", "Boolean", getRequired());
/* 695 */     Integer tabOrder = getTabOrder();
/* 696 */     if (tabOrder != null && tabOrder.intValue() != 0) {
/* 697 */       argWriter.writeValue("TabOrder", "Integer", tabOrder);
/*     */     }
/* 699 */     argWriter.writeValue((ISavableConfig)this.columns_);
/* 700 */     if (this.fieldWeight_ != null && this.fieldWeight_.intValue() != 0) {
/* 701 */       argWriter.writeValue("FieldWeight", "Integer", this.fieldWeight_);
/*     */     }
/* 703 */     writeParameterConfigs(argWriter);
/* 704 */     argWriter.writeValue((ISavableConfig)this.columns_);
/* 705 */     argWriter.writeValue("Width", "Integer", getWidthObject());
/* 706 */     argWriter.writeValue("Height", "Integer", getHeightObject());
/* 707 */     argWriter.writeValue((ISavableConfig)getDataConfig());
/* 708 */     argWriter.writeValue((ISavableConfig)getFontConfig());
/* 709 */     argWriter.writeValue((ISavableConfig)getColorGroupConfig());
/* 710 */     ParameterConfig[] parameters = getParameters();
/* 711 */     for (ParameterConfig pc : parameters) {
/* 712 */       pc.write(argWriter);
/*     */     }
/*     */     
/* 715 */     for (IRendererDefConfig def : getRendererMap().values()) {
/* 716 */       if (def != null) {
/* 717 */         argWriter.writeValue((ISavableConfig)def);
/*     */       }
/*     */     } 
/* 720 */     argWriter.writeValue("HorizontalScrollPolicy", "String", this.horizontalScrollPolicy_);
/* 721 */     argWriter.writeValue("VerticalScrollPolicy", "String", this.verticalScrollPolicy_);
/*     */     
/* 723 */     argWriter.writeValue("SelectionMode", "String", this.listSelectionMode_);
/* 724 */     argWriter.writeValue("XmlTag", "String", getXmlTag());
/*     */     
/* 726 */     argWriter.writeValue("PossibleValues", "String", getEnumPossibleValues());
/*     */     
/* 728 */     if (this.notifyDelay_ != null && this.notifyDelay_.intValue() > 0) {
/* 729 */       argWriter.writeValue("NotifyDelay", (IReflectionParameterCapable)new IntegerConfig(this.notifyDelay_));
/*     */     }
/* 731 */     argWriter.writeFooter("FormViewCell");
/*     */     
/* 733 */     setClean();
/*     */   }
/*     */   
/*     */   private IFormattableConfig getBorderTextKeyConfig() {
/* 737 */     return this.borderTextKeyConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   private IRendererDefConfig getRendererDef(String argRole, boolean argCreateIfNone) {
/*     */     RendererDefConfig rendererDefConfig;
/* 743 */     IRendererDefConfig def = getRendererMap().get(argRole);
/* 744 */     if (def == null && argCreateIfNone) {
/* 745 */       rendererDefConfig = new RendererDefConfig(argRole);
/* 746 */       setRendererDef((IRendererDefConfig)rendererDefConfig);
/*     */     } 
/* 748 */     return (IRendererDefConfig)rendererDefConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, IRendererDefConfig> getRendererMap() {
/* 754 */     if (this.rendererMap_ == null) {
/* 755 */       this.rendererMap_ = new HashMap<>(3);
/*     */     }
/* 757 */     return this.rendererMap_;
/*     */   }
/*     */   
/*     */   private IFormattableConfig getTextKeyConfig() {
/* 761 */     return this.textKeyConfig_;
/*     */   }
/*     */   
/*     */   private IFormattableConfig getValueConfig() {
/* 765 */     return this.valueConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setEntryMasked(Boolean entryMasked) {
/* 773 */     this.entryMasked_ = entryMasked;
/* 774 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean usesCellRendering() {
/* 779 */     String type = getType();
/* 780 */     if (type.startsWith(FormComponentType.LIST.toString()) || type
/* 781 */       .endsWith(FormComponentType.LIST.toString())) {
/* 782 */       return true;
/*     */     }
/* 784 */     if (type.endsWith(FormComponentType.TABLE.toString())) {
/* 785 */       return true;
/*     */     }
/* 787 */     if (type.endsWith(FormComponentType.GANTT.toString())) {
/* 788 */       return true;
/*     */     }
/* 790 */     if ("ScrollEventFormList".equals(type) || "ScrollEventFormList2".equals(type)) {
/* 791 */       return true;
/*     */     }
/* 793 */     if ("FormBasicList".equals(type)) {
/* 794 */       return true;
/*     */     }
/* 796 */     if ("ScrollableBaseFormList".equals(type)) {
/* 797 */       return true;
/*     */     }
/*     */     
/* 800 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean usesScrolling() {
/* 805 */     String type = getType();
/* 806 */     if (type.endsWith(FormComponentType.LIST.toString())) {
/* 807 */       return true;
/*     */     }
/* 809 */     if (type.endsWith(FormComponentType.TABLE.toString())) {
/* 810 */       return true;
/*     */     }
/* 812 */     if (type.endsWith(FormComponentType.GANTT.toString())) {
/* 813 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 819 */     if ("ScrollEventFormList".equals(type)) {
/* 820 */       return true;
/*     */     }
/* 822 */     if ("ScrollableBaseFormList".equals(type)) {
/* 823 */       return true;
/*     */     }
/*     */     
/* 826 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormViewCellConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */