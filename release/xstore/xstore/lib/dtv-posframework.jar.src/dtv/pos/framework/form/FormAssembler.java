/*     */ package dtv.pos.framework.form;
/*     */ import com.micros.xstore.config.IConfigMgr;
/*     */ import com.micros.xstore.config.common.Action;
/*     */ import com.micros.xstore.config.form.ActionGroupType;
/*     */ import com.micros.xstore.config.form.FormSet;
/*     */ import com.micros.xstore.config.form.FormType;
/*     */ import com.micros.xstore.config.form.FormTypeEnum;
/*     */ import com.micros.xstore.config.form.HeaderType;
/*     */ import com.micros.xstore.config.form.PageType;
/*     */ import com.micros.xstore.config.form.PanelType;
/*     */ import com.micros.xstore.config.form.field.FieldSet;
/*     */ import com.micros.xstore.config.form.field.FieldType;
/*     */ import com.micros.xstore.config.form.field.FieldTypeEnumeration;
/*     */ import com.micros.xstore.config.form.field.FormParameterType;
/*     */ import com.micros.xstore.config.form.fieldlayout.ColumnType;
/*     */ import com.micros.xstore.config.form.fieldlayout.FieldLayoutSet;
/*     */ import com.micros.xstore.config.form.fieldlayout.FieldLayoutType;
/*     */ import com.micros.xstore.config.form.fieldlayout.HorizontalAlignmentEnum;
/*     */ import com.micros.xstore.config.form.fieldlayout.LayoutEnumType;
/*     */ import com.micros.xstore.config.form.fieldlayout.RowType;
/*     */ import com.micros.xstore.config.form.fieldlayout.VerticalAlignmentEnum;
/*     */ import com.micros.xstore.config.form.font.FontConfigSet;
/*     */ import com.micros.xstore.config.form.font.FontType;
/*     */ import com.micros.xstore.config.impl.ConfigLoadingException;
/*     */ import com.micros.xstore.config.impl.LocatableObject;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.form.component.AbstractFormComponent;
/*     */ import dtv.pos.framework.form.component.FormPanel;
/*     */ import dtv.pos.framework.form.component.IMasterDetailFormPanel;
/*     */ import dtv.pos.framework.ui.config.DataFieldConfig;
/*     */ import dtv.pos.framework.ui.config.FontConfig;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.layout.FieldLayoutConstraints;
/*     */ import dtv.ui.layout.FieldLayoutTraversalPolicy;
/*     */ import dtv.ui.layout.ListFieldLayout;
/*     */ import dtv.ui.layout.PageLayout;
/*     */ import dtv.ui.layout.PageLayoutConstraints;
/*     */ import dtv.ui.layout.SimpleFieldLayout;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigException;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.FocusTraversalPolicy;
/*     */ import java.awt.Font;
/*     */ import java.awt.Insets;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Predicate;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class FormAssembler {
/*     */   public static final String LABEL = "FormLabel";
/*     */   public static final String WRAPPING_LABEL = "FormLabelWrapping";
/*     */   public static final String TEXT = "FormTextField";
/*     */   public static final String TEXT_AREA = "FormLongTextField";
/*  76 */   private static final Logger _logger = Logger.getLogger(FormAssembler.class); public static final String COMBO_BOX = "FormComboBox"; public static final String CHECK_BOX = "FormCheckBox"; public static final String IMAGE = "FormIcon"; public static final String LIST = "FormList"; public static final String ANCHOR = "FormAnchor"; public static final String TABLE = "FormTable"; public static final String FORM_PANEL_CLASS = "Panel"; public static final String GROUPING_LIST = "FormGroupingList"; public static final String MORE_AUTH_INFO = "MoreAuthInfoPanel"; public static final String CHART = "FormTimeSeriesChart"; public static final String PROGRESS_BAR = "FormProgress";
/*     */   public static final String SIGNATURE = "FormSignature";
/*  78 */   private Map<String, FormType> _formsMap = new HashMap<>();
/*  79 */   private Map<String, FieldLayoutType> _fieldLayoutsMap = new HashMap<>();
/*  80 */   private Map<String, FieldType> _fieldDefsMap = new HashMap<>();
/*  81 */   private Map<String, FontType> _fontDefsMap = new HashMap<>();
/*     */   
/*     */   private IConfigMgr<FormSet> _formConfigMgr;
/*     */   
/*     */   private IConfigMgr<FieldLayoutSet> _fieldLayoutConfigMgr;
/*     */   private IConfigMgr<FieldSet> _fieldDefConfigMgr;
/*     */   private IConfigMgr<FontConfigSet> _fontConfigMgr;
/*  88 */   private IXstViewComponentFactory _componentFactory = XstViewComponentFactory.getInstance();
/*     */   
/*     */   private List<Component> _formComponents;
/*     */   
/*     */   @Inject
/*     */   private FormattableFactory _formatter;
/*     */   
/*     */   @Inject
/*     */   private FormLayoutConfigHelper _formLayoutConfigHelper;
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   @Inject
/*     */   private IVisibilityRuleLocator _visibilityRuleLocator;
/*     */   
/*     */   public FormAssembler(IConfigMgr<FormSet> argFormConfigMgr, IConfigMgr<FieldLayoutSet> argFieldLayConfigMgr, IConfigMgr<FieldSet> argFieldDefMgr, IConfigMgr<FontConfigSet> argFontDefMgr) {
/* 105 */     this._formConfigMgr = argFormConfigMgr;
/* 106 */     this._fieldLayoutConfigMgr = argFieldLayConfigMgr;
/* 107 */     this._fieldDefConfigMgr = argFieldDefMgr;
/* 108 */     this._fontConfigMgr = argFontDefMgr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormPanel assembleForm(FormKey argFormKey) {
/* 118 */     FormPanel panel = buildFormConfiguration(argFormKey.toString());
/* 119 */     return panel;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getActions(IEditModel argEditModel, DataActionGroupKey argActionGroupKey, FormKey argFormKey, String argPageName, boolean argIncludeHelpAction) {
/* 124 */     if (argEditModel == null) {
/* 125 */       return null;
/*     */     }
/* 127 */     FormType formConf = getFormConfiguration(argFormKey.toString().toUpperCase());
/* 128 */     PageType page = null;
/*     */     
/* 130 */     if (!StringUtils.isEmpty(argPageName)) {
/* 131 */       for (PageType pageType : formConf.getPages()) {
/* 132 */         if (argPageName.equalsIgnoreCase(pageType.getName())) {
/* 133 */           page = pageType;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 139 */       page = formConf.getPages().get(0);
/*     */     } 
/*     */     
/* 142 */     return getActions(argEditModel, formConf, page, argActionGroupKey, argIncludeHelpAction);
/*     */   }
/*     */   
/*     */   public FieldType getFieldDefinitionConfiguration(String argFieldDefName) {
/* 146 */     if (argFieldDefName == null) {
/* 147 */       return null;
/*     */     }
/*     */     
/* 150 */     return this._fieldDefsMap.get(argFieldDefName);
/*     */   }
/*     */   
/*     */   public FieldLayoutType getFieldLayoutConfiguration(String argFieldLayoutName) {
/* 154 */     if (argFieldLayoutName == null) {
/* 155 */       return null;
/*     */     }
/*     */     
/* 158 */     return this._fieldLayoutsMap.get(argFieldLayoutName);
/*     */   }
/*     */   
/*     */   public FontType getFontConfiguration(String argFontConfigName) {
/* 162 */     if (argFontConfigName == null) {
/* 163 */       return null;
/*     */     }
/*     */     
/* 166 */     return this._fontDefsMap.get(argFontConfigName);
/*     */   }
/*     */   
/*     */   public FormType getFormConfiguration(String argFormKey) {
/* 170 */     if (argFormKey == null) {
/* 171 */       return null;
/*     */     }
/*     */     
/* 174 */     return this._formsMap.get(argFormKey);
/*     */   }
/*     */   
/*     */   public FormLocationType getFormLocationType(FormTypeEnum argFormType) {
/* 178 */     switch (argFormType) {
/*     */       case LIST_LAYOUT:
/* 180 */         return FormLocationType.MESSAGE_AREA;
/*     */       case SIMPLE_LAYOUT:
/* 182 */         return FormLocationType.MULTI_PURPOSE_VIEW;
/*     */       case null:
/* 184 */         return FormLocationType.POPUP_VIEW_PANEL;
/*     */       case null:
/* 186 */         return FormLocationType.TRANSACTION_LIST_AREA;
/*     */     } 
/* 188 */     _logger.error("Invalid form location [" + argFormType.toString() + "]");
/* 189 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IVisibilityRule> getVisibilityRules(PageType argPage) {
/* 195 */     List<IVisibilityRule> rules = new ArrayList<>();
/* 196 */     if (argPage == null) {
/* 197 */       return rules;
/*     */     }
/*     */     
/*     */     try {
/* 201 */       if (!StringUtils.isEmpty(argPage.getConditionRef())) {
/* 202 */         IVisibilityRule rule = this._visibilityRuleLocator.getVisibilityRule(argPage.getConditionRef());
/* 203 */         rules.add(rule);
/*     */       }
/*     */     
/* 206 */     } catch (Exception ex) {
/* 207 */       _logger.warn("CAUGHT EXCEPTION :", ex);
/*     */     } 
/*     */     
/* 210 */     return rules;
/*     */   }
/*     */   
/*     */   public boolean hasFormConfiguration(FormKey argFormKey) {
/* 214 */     if (argFormKey == null) {
/* 215 */       return false;
/*     */     }
/* 217 */     FormType formConf = getFormConfiguration(argFormKey.toString().toUpperCase());
/* 218 */     return (formConf != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initialize() {
/*     */     try {
/* 224 */       FormSet formSet = (FormSet)this._formConfigMgr.getResolvedConfigs();
/* 225 */       for (FormType formType : formSet.getForms()) {
/* 226 */         this._formsMap.put(formType.getName().toUpperCase(), formType);
/*     */       }
/*     */     }
/* 229 */     catch (ConfigLoadingException ex) {
/* 230 */       throw new ConfigException("An error occurred while processing form configurations.", ex);
/*     */     } 
/*     */     
/*     */     try {
/* 234 */       FieldLayoutSet fieldLayoutSet = (FieldLayoutSet)this._fieldLayoutConfigMgr.getResolvedConfigs();
/* 235 */       for (FieldLayoutType type : fieldLayoutSet.getFieldLayouts()) {
/* 236 */         this._fieldLayoutsMap.put(type.getName(), type);
/*     */       }
/*     */     }
/* 239 */     catch (ConfigLoadingException ex) {
/* 240 */       throw new ConfigException("An error occurred while processing field layout configurations.", ex);
/*     */     } 
/*     */     
/*     */     try {
/* 244 */       FieldSet fieldSet = (FieldSet)this._fieldDefConfigMgr.getResolvedConfigs();
/* 245 */       for (FieldType field : fieldSet.getFields()) {
/* 246 */         this._fieldDefsMap.put(field.getName(), field);
/*     */       }
/*     */     }
/* 249 */     catch (ConfigLoadingException ex) {
/* 250 */       throw new ConfigException("An error occurred while processing field definitions.", ex);
/*     */     } 
/*     */     
/*     */     try {
/* 254 */       FontConfigSet fontSet = (FontConfigSet)this._fontConfigMgr.getResolvedConfigs();
/* 255 */       for (FontType font : fontSet.getFontConfigs()) {
/* 256 */         this._fontDefsMap.put(font.getName(), font);
/*     */       }
/*     */     }
/* 259 */     catch (ConfigLoadingException ex) {
/* 260 */       throw new ConfigException("An error occurred while processing font configurations", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFieldVisible(String argVisibilityGroup) {
/* 265 */     if (StringUtils.isEmpty(argVisibilityGroup)) {
/* 266 */       return true;
/*     */     }
/*     */     
/*     */     try {
/* 270 */       IVisibilityRule rule = this._visibilityRuleLocator.getVisibilityRule(argVisibilityGroup);
/* 271 */       return rule.checkVisibility().isGranted();
/*     */     }
/* 273 */     catch (Exception ex) {
/* 274 */       _logger.warn("VisibilityGroup [" + argVisibilityGroup + "] was referenced in the form, but could not be found in configuration.");
/*     */       
/* 276 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Font resolveFontConfiguration(FontType argFontConfiguration) {
/* 282 */     Font baseFont = UIResourceManager.getInstance().getFont("_fontLabelMedium");
/* 283 */     if (argFontConfiguration == null) {
/* 284 */       return baseFont;
/*     */     }
/*     */     
/* 287 */     Font parentFont = UIResourceManager.getInstance().getFont(argFontConfiguration.getKey());
/* 288 */     FontConfig fontConfig = new FontConfig();
/*     */     
/* 290 */     if (argFontConfiguration.getSize() != null) {
/* 291 */       fontConfig.setConfigObject("FontSize", (IConfigObject)new StringConfig(argFontConfiguration.getSize()));
/*     */     }
/*     */     
/* 294 */     if (argFontConfiguration.getStyle() != null) {
/* 295 */       fontConfig.setConfigObject("FontStyle", (IConfigObject)new StringConfig(argFontConfiguration.getStyle().name()));
/*     */     }
/*     */     
/* 298 */     if (parentFont != null) {
/* 299 */       return fontConfig.getFont(parentFont);
/*     */     }
/*     */     
/* 302 */     return fontConfig.getFont(baseFont);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormPanel buildFormConfiguration(String argFormName) {
/* 308 */     FormType formConf = getFormConfiguration(argFormName);
/*     */ 
/*     */     
/* 311 */     if (formConf != null) {
/* 312 */       FormPanel formPanel; boolean titledPanel = FormTypeEnum.POPUP_VIEW_PANEL.equals(formConf.getType());
/* 313 */       if (formConf.getPages().size() > 1 || (formConf.getPages() != null && formConf.getHeader() != null)) {
/*     */ 
/*     */         
/* 316 */         IMasterDetailFormPanel mainPanel = this._componentFactory.createMultiTabFormPanel(this._formLayoutConfigHelper
/* 317 */             .getFormLayout(formConf.getFormLayoutRef()), titledPanel);
/*     */ 
/*     */         
/* 320 */         HeaderType header = formConf.getHeader();
/* 321 */         if (header != null) {
/* 322 */           this._formComponents = new ArrayList<>();
/*     */           
/* 324 */           List<IXstAction> touchActions = new ArrayList<>();
/*     */           
/* 326 */           if (!StringUtils.isEmpty(header.getViewAction())) {
/* 327 */             IXstAction action = this._actionFactory.getAction(header.getViewAction());
/* 328 */             touchActions.add(action);
/*     */           } 
/*     */           
/* 331 */           if (!StringUtils.isEmpty(header.getEditAction())) {
/* 332 */             IXstAction action = this._actionFactory.getAction(header.getEditAction());
/* 333 */             touchActions.add(action);
/*     */           } 
/*     */           
/* 336 */           FormPanel headerPanel = createFormPanel(formConf.getName().concat("_header").toUpperCase(), formConf
/* 337 */               .getType(), false, null, null, touchActions);
/*     */           
/* 339 */           for (PanelType panel : header.getPanels()) {
/*     */             
/* 341 */             FieldLayoutType fieldLayout = getFieldLayoutConfiguration(panel.getFieldLayoutRef());
/*     */             
/* 343 */             if (fieldLayout != null) {
/*     */               
/* 345 */               FontType fontType = null;
/* 346 */               if (!StringUtils.isEmpty(panel.getFontRef())) {
/* 347 */                 fontType = getFontConfiguration(panel.getFontRef());
/*     */               }
/*     */               
/* 350 */               AbstractFormComponent layoutPanel = createFieldLayout(fieldLayout, headerPanel, fontType, 
/* 351 */                   convertStringToPaddingInsets(panel.getPadding(), (LocatableObject)panel), null, true, panel
/* 352 */                   .getVerticalAlignment());
/* 353 */               headerPanel.addFormComponent((IFormComponent)layoutPanel, fieldLayout.getName());
/* 354 */               headerPanel.getContainer().add(layoutPanel.getDisplayComponent(), new PageLayoutConstraints(panel
/* 355 */                     .getStartX(), panel.getStartY(), panel.getWidth(), panel.getHeight()));
/*     */             } 
/*     */           } 
/*     */           
/* 359 */           mainPanel.setMasterView(headerPanel);
/*     */         } 
/*     */ 
/*     */         
/* 363 */         for (PageType page : formConf.getPages()) {
/*     */           
/* 365 */           if (!page.getEnabled().booleanValue()) {
/*     */             continue;
/*     */           }
/*     */ 
/*     */           
/* 370 */           this._formComponents = new ArrayList<>();
/* 371 */           IFormattable formattedText = null;
/* 372 */           if (page.getText() != null) {
/* 373 */             formattedText = this._formatter.getSimpleFormattable(page.getText());
/*     */           }
/* 375 */           FormPanel pagePanel = createFormPanel(page.getName().toUpperCase(), formConf.getType(), false, formattedText, null, null);
/*     */ 
/*     */           
/* 378 */           for (PanelType panel : page.getPanels()) {
/* 379 */             String fieldLayoutRef = panel.getFieldLayoutRef();
/* 380 */             AbstractFormComponent layoutPanel = null;
/*     */             
/* 382 */             if (!StringUtils.isEmpty(fieldLayoutRef)) {
/* 383 */               FieldLayoutType fieldLayout = getFieldLayoutConfiguration(fieldLayoutRef);
/* 384 */               if (fieldLayout != null) {
/*     */                 
/* 386 */                 FontType fontType = null;
/* 387 */                 if (!StringUtils.isEmpty(panel.getFontRef())) {
/* 388 */                   fontType = getFontConfiguration(panel.getFontRef());
/*     */                 }
/*     */                 
/* 391 */                 layoutPanel = createFieldLayout(fieldLayout, pagePanel, fontType, 
/* 392 */                     convertStringToPaddingInsets(panel.getPadding(), (LocatableObject)panel), null, false, panel
/* 393 */                     .getVerticalAlignment());
/* 394 */                 pagePanel.addFormComponent((IFormComponent)layoutPanel, fieldLayout.getName());
/*     */               } else {
/*     */                 
/* 397 */                 _logger.error("Requested field layout [" + panel.getFieldLayoutRef() + "] is missing. Unable to complete the assembly of the form [" + argFormName + "]");
/*     */               }
/*     */             
/*     */             } else {
/*     */               
/* 402 */               throw new ConfigException("A panel should refer to a field layout.");
/*     */             } 
/*     */             
/* 405 */             pagePanel.getContainer().add(layoutPanel.getDisplayComponent(), new PageLayoutConstraints(panel
/* 406 */                   .getStartX(), panel.getStartY(), panel.getWidth(), panel.getHeight()));
/*     */           } 
/* 408 */           pagePanel.setActionSubGroupKey(page.getName().toUpperCase());
/*     */           
/* 410 */           if (formConf.getPages().size() == 1) {
/* 411 */             mainPanel.setDetailView(pagePanel);
/*     */             continue;
/*     */           } 
/* 414 */           mainPanel.addDetailView(pagePanel);
/*     */         } 
/*     */ 
/*     */         
/* 418 */         formPanel = (FormPanel)mainPanel;
/*     */       }
/*     */       else {
/*     */         
/* 422 */         PageType page = formConf.getPages().get(0);
/* 423 */         this._formComponents = new ArrayList<>();
/* 424 */         IFormattable formattedText = null;
/* 425 */         if (page.getText() != null) {
/* 426 */           formattedText = this._formatter.getSimpleFormattable(page.getText());
/*     */         }
/* 428 */         formPanel = createFormPanel(formConf.getName().toUpperCase(), formConf.getType(), titledPanel, formattedText, null, null);
/*     */         
/* 430 */         List<PanelType> panels = page.getPanels();
/* 431 */         for (PanelType panel : panels) {
/* 432 */           String fieldLayoutRef = panel.getFieldLayoutRef();
/* 433 */           AbstractFormComponent layoutPanel = null;
/*     */           
/* 435 */           if (!StringUtils.isEmpty(fieldLayoutRef)) {
/* 436 */             FieldLayoutType fieldLayout = getFieldLayoutConfiguration(fieldLayoutRef);
/* 437 */             if (fieldLayout != null) {
/* 438 */               FontType fontType = null;
/* 439 */               if (!StringUtils.isEmpty(panel.getFontRef())) {
/* 440 */                 fontType = getFontConfiguration(panel.getFontRef());
/*     */               }
/* 442 */               layoutPanel = createFieldLayout(fieldLayout, formPanel, fontType, 
/* 443 */                   convertStringToPaddingInsets(panel.getPadding(), (LocatableObject)panel), null, false, panel
/* 444 */                   .getVerticalAlignment());
/* 445 */               formPanel.addFormComponent((IFormComponent)layoutPanel, fieldLayout.getName());
/*     */             } else {
/*     */               
/* 448 */               _logger.error("Requested field layout [" + panel.getFieldLayoutRef() + "] is missing. Unable to complete the assembly of the form [" + argFormName + "]");
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 453 */             throw new ConfigException("A panel should refer to a field layout.");
/*     */           } 
/* 455 */           formPanel.getContainer().add(layoutPanel.getDisplayComponent(), new PageLayoutConstraints(panel
/* 456 */                 .getStartX(), panel.getStartY(), panel.getWidth(), panel.getHeight()));
/*     */         } 
/*     */       } 
/* 459 */       return formPanel;
/*     */     } 
/*     */     
/* 462 */     _logger.error("No form definition exists for the given form key [" + argFormName + "].");
/* 463 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResolvedFieldConfig createFieldDefinition(FieldType argFieldType, FontType argFontConfig, boolean argIsFieldRequired, HorizontalAlignmentEnum argHorizontalAlignment, VerticalAlignmentEnum argVerticalAlignment) {
/*     */     DataFieldConfig dataFieldConfig;
/* 471 */     FormatterType formatterType = null;
/* 472 */     if (argFieldType.getFormatterRef() != null) {
/* 473 */       formatterType = FormatterType.forName(argFieldType.getFormatterRef());
/*     */     }
/*     */     
/* 476 */     Font fontConfig = resolveFontConfiguration(argFontConfig);
/*     */     
/* 478 */     Color fgColor = null;
/* 479 */     if (argFontConfig != null && argFontConfig.getColorRef() != null) {
/* 480 */       fgColor = UIResourceManager.getInstance().getRGBColor(argFontConfig.getColorRef());
/*     */     }
/*     */     
/* 483 */     IDataFieldConfig dataFieldConf = null;
/* 484 */     if (argFieldType.getDataFieldRef() != null) {
/* 485 */       dataFieldConfig = DataFieldConfigHelper.getFieldConfig(argFieldType.getDataFieldRef());
/*     */     }
/*     */     
/* 488 */     String fieldType = null;
/*     */     try {
/* 490 */       boolean wrapText = Boolean.valueOf(
/* 491 */           getFormParameter(argFieldType.getParameters(), FormParameterTypeEnumeration.WRAP_TEXT.value())).booleanValue();
/* 492 */       if (argFieldType.getType() == FieldTypeEnumeration.LABEL && wrapText) {
/* 493 */         fieldType = "FormLabelWrapping";
/*     */       }
/* 495 */       else if (argFieldType.getType() == FieldTypeEnumeration.TEXT && wrapText) {
/* 496 */         fieldType = "FormLongTextField";
/*     */       } else {
/*     */         
/* 499 */         Field classField = getClass().getDeclaredField(argFieldType.getType().name());
/* 500 */         if (classField != null) {
/* 501 */           fieldType = (String)classField.get(null);
/*     */         }
/*     */       }
/*     */     
/* 505 */     } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException ex) {
/* 506 */       throw new ConfigException("Field [" + argFieldType.getName() + "] has an unsupported field type.", ex);
/*     */     } 
/*     */     
/* 509 */     IFormattable formattedText = null;
/* 510 */     if (argFieldType.getText() != null) {
/* 511 */       formattedText = this._formatter.getSimpleFormattable(argFieldType.getText());
/*     */     }
/*     */     
/* 514 */     ResolvedFieldConfig resolvedConfig = new ResolvedFieldConfig();
/* 515 */     if (!StringUtils.isEmpty(argFieldType.getText()))
/*     */     {
/* 517 */       resolvedConfig.setForegroundColor(Color.DARK_GRAY);
/*     */     }
/*     */     
/* 520 */     resolvedConfig.setFieldType(argFieldType.getType());
/* 521 */     resolvedConfig.setFont(fontConfig);
/* 522 */     resolvedConfig.setFormatter(formatterType);
/* 523 */     resolvedConfig.setName(argFieldType.getName());
/* 524 */     resolvedConfig.setResource(argFieldType.getResource());
/* 525 */     resolvedConfig.setText(formattedText);
/* 526 */     resolvedConfig.setDataField((IDataFieldConfig)dataFieldConfig);
/* 527 */     resolvedConfig.setRequired(argIsFieldRequired);
/* 528 */     resolvedConfig.setType(fieldType);
/* 529 */     if (fgColor != null) {
/* 530 */       resolvedConfig.setForegroundColor(fgColor);
/*     */     }
/* 532 */     resolvedConfig.setParameters(argFieldType.getParameters());
/*     */     
/* 534 */     switch (argHorizontalAlignment) {
/*     */       case LIST_LAYOUT:
/* 536 */         resolvedConfig.setHorizontalAlignment(2);
/*     */         break;
/*     */       case SIMPLE_LAYOUT:
/* 539 */         resolvedConfig.setHorizontalAlignment(4);
/*     */         break;
/*     */       case null:
/* 542 */         resolvedConfig.setHorizontalAlignment(0);
/*     */         break;
/*     */     } 
/*     */     
/* 546 */     switch (argVerticalAlignment) {
/*     */       case LIST_LAYOUT:
/* 548 */         resolvedConfig.setVerticalAlignment(1);
/*     */         break;
/*     */       case SIMPLE_LAYOUT:
/* 551 */         resolvedConfig.setVerticalAlignment(0);
/*     */         break;
/*     */       case null:
/* 554 */         resolvedConfig.setVerticalAlignment(3);
/*     */         break;
/*     */     } 
/*     */     
/* 558 */     return resolvedConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractFormComponent createFieldLayout(FieldLayoutType argFieldLayoutConf, FormPanel argParentFormPanel, FontType argFontConfig, Insets argPadding, String argComponentId, boolean argIsHeaderField, VerticalAlignmentEnum argVerticalAlignment) {
/*     */     ListFieldLayout listFieldLayout;
/*     */     SimpleFieldLayout simpleFieldLayout;
/* 566 */     ResolvedFieldConfig layoutDef = new ResolvedFieldConfig();
/* 567 */     layoutDef.setRequired(false);
/* 568 */     layoutDef.setName(argFieldLayoutConf.getName());
/* 569 */     layoutDef.setType(argFieldLayoutConf.getType().toString());
/*     */     
/* 571 */     ComponentID formCompId = null;
/* 572 */     if (argComponentId != null) {
/* 573 */       formCompId = new ComponentID(argComponentId);
/*     */     }
/*     */ 
/*     */     
/* 577 */     FormPanel fieldLayoutPanel = this._componentFactory.createFormPanel(layoutDef, "Panel", false, formCompId, null);
/* 578 */     AbstractFieldLayout fieldLayout = null;
/*     */     
/* 580 */     switch (argFieldLayoutConf.getType()) {
/*     */       case LIST_LAYOUT:
/* 582 */         listFieldLayout = new ListFieldLayout(3, argPadding);
/*     */         break;
/*     */       case SIMPLE_LAYOUT:
/* 585 */         simpleFieldLayout = new SimpleFieldLayout(3, argPadding);
/*     */         break;
/*     */       default:
/* 588 */         throw new ConfigException("Unsupported layout type: " + argFieldLayoutConf.getType());
/*     */     } 
/*     */     
/* 591 */     if (argVerticalAlignment != null) {
/* 592 */       simpleFieldLayout.setFieldOrientation(argVerticalAlignment);
/*     */     }
/*     */     
/* 595 */     fieldLayoutPanel.getContainer().setLayout((LayoutManager2)simpleFieldLayout);
/* 596 */     FieldLayoutTraversalPolicy travelPolicy = new FieldLayoutTraversalPolicy(this._formComponents);
/* 597 */     fieldLayoutPanel.getDisplayComponent().setFocusTraversalPolicy((FocusTraversalPolicy)travelPolicy);
/* 598 */     createFields(fieldLayoutPanel, argFieldLayoutConf, argParentFormPanel, argFontConfig, argIsHeaderField);
/* 599 */     return (AbstractFormComponent)fieldLayoutPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createFields(FormPanel fieldLayout, FieldLayoutType fieldLayoutConf, FormPanel argParentFormPanel, FontType argFontConfig, boolean argIsHeaderField) {
/* 605 */     int rowNumber = 0;
/* 606 */     for (RowType row : fieldLayoutConf.getRows()) {
/* 607 */       if (fieldLayoutConf.getType() == LayoutEnumType.SIMPLE_LAYOUT) {
/* 608 */         boolean columnFillPresent = row.getColumns().stream().anyMatch(p -> p.getFill().booleanValue());
/*     */         
/* 610 */         if (row.getColumns().size() == 1) {
/* 611 */           if (!columnFillPresent) {
/* 612 */             throw new ConfigException(fieldLayoutConf.getName() + " is an invalid simple field layout. If only one column is specified, that column must be marked with the 'fill' attribute equal to 'true'. If the desire simply is not to have a label, then include an empty column as the first one.");
/*     */           }
/*     */         } else {
/*     */           
/* 616 */           if (row.getColumns().size() > 1 && columnFillPresent) {
/* 617 */             throw new ConfigException(fieldLayoutConf.getName() + " is in invalid simple field layout. A 'fill' attribute of 'true' on a column in a simple layout only is supported when there are no others columns in the row.");
/*     */           }
/*     */           
/* 620 */           if (row.getColumns().size() != 2) {
/* 621 */             throw new ConfigException(fieldLayoutConf.getName() + " is an invalid simple field layout. Each row in 'SimpleLayout' should contain two columns. If you want only one column and you do not want a label to be present, then include a blank column. If you want one column to fill both the label and the value space, then mark that column with 'fill' attribute equal to 'true'.");
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 626 */       int columnIndex = 0;
/*     */       
/* 628 */       for (ColumnType col : row.getColumns()) {
/* 629 */         if (col.getFieldRef() == null || !isFieldVisible(col.getVisibilityGroup())) {
/* 630 */           columnIndex++;
/*     */           
/*     */           continue;
/*     */         } 
/* 634 */         FieldType fieldConf = getFieldDefinitionConfiguration(col.getFieldRef());
/*     */         
/* 636 */         if (fieldConf != null) {
/* 637 */           FontType fontType = null;
/* 638 */           if (col.getFontRef() != null) {
/* 639 */             fontType = getFontConfiguration(col.getFontRef());
/*     */           }
/*     */           
/* 642 */           if (fontType == null) {
/* 643 */             fontType = argFontConfig;
/*     */           }
/*     */           
/* 646 */           ResolvedFieldConfig resolvedField = createFieldDefinition(fieldConf, fontType, col.getRequired().booleanValue(), col
/* 647 */               .getHorizontalAlignment(), col.getVerticalAlignment());
/* 648 */           if (resolvedField != null) {
/* 649 */             IFormComponent comp = this._componentFactory.createFormComponent(resolvedField);
/* 650 */             this._formComponents.add(comp.getFocusComponent());
/*     */             
/* 652 */             argParentFormPanel.addFormComponent(comp, resolvedField.getResource());
/*     */ 
/*     */             
/* 655 */             FieldLayoutConstraints constraint = new FieldLayoutConstraints(col.getStart(), col.getWidth(), rowNumber, col.getVerticalAlignment(), col.getHorizontalAlignment(), row.getFill().booleanValue(), col.getFill().booleanValue());
/* 656 */             constraint.setColumn(columnIndex);
/* 657 */             fieldLayout.getContainer().add(comp.getDisplayComponent(), constraint);
/*     */           } 
/*     */           continue;
/*     */         } 
/* 661 */         _logger.warn("Field will be excluded since its field definition does not exist [" + col
/* 662 */             .getFieldRef() + "] @@ " + fieldLayoutConf.getFile());
/*     */       } 
/*     */ 
/*     */       
/* 666 */       rowNumber++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormPanel createFormPanel(String argFormName, FormTypeEnum argFormType, boolean argIsTitled, IFormattable argTitle, String argComponentId, List<IXstAction> argTouchActions) {
/* 675 */     ResolvedFieldConfig formDef = new ResolvedFieldConfig();
/* 676 */     formDef.setRequired(false);
/* 677 */     formDef.setText(argTitle);
/* 678 */     formDef.setName(argFormName);
/* 679 */     formDef.setType(argFormType.toString());
/*     */     
/* 681 */     ComponentID formCompId = null;
/* 682 */     if (argComponentId != null) {
/* 683 */       formCompId = new ComponentID(argComponentId);
/*     */     }
/*     */     
/* 686 */     FieldLayoutTraversalPolicy travelPolicy = new FieldLayoutTraversalPolicy(this._formComponents);
/*     */     
/* 688 */     FormPanel formPanel = this._componentFactory.createFormPanel(formDef, "Panel", argIsTitled, formCompId, argTouchActions);
/*     */     
/* 690 */     PageLayout pageLayout = new PageLayout(new Insets(0, 0, 0, 0));
/* 691 */     formPanel.getContainer().setLayout((LayoutManager)pageLayout);
/* 692 */     formPanel.getContainer().setFocusTraversalPolicy((FocusTraversalPolicy)travelPolicy);
/* 693 */     return formPanel;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Collection<IXstAction> getActions(IEditModel argEditModel, FormType argFormType, PageType argPage, DataActionGroupKey argActionGroupKey, boolean argIncludeHelpAction) {
/* 698 */     String actionGroupReference = null;
/*     */     
/* 700 */     if (DataActionGroupKey.DEFAULT.equals(argActionGroupKey) || DataActionGroupKey.VIEW
/* 701 */       .equals(argActionGroupKey)) {
/* 702 */       if (argPage.getActionGroups() != null) {
/* 703 */         actionGroupReference = argPage.getActionGroups().getView();
/*     */       }
/*     */     }
/* 706 */     else if (DataActionGroupKey.EDIT.equals(argActionGroupKey)) {
/* 707 */       if (argPage.getActionGroups() != null) {
/* 708 */         actionGroupReference = argPage.getActionGroups().getEdit();
/*     */       
/*     */       }
/*     */     }
/* 712 */     else if (argActionGroupKey != null) {
/* 713 */       actionGroupReference = argActionGroupKey.toString();
/*     */     } 
/*     */ 
/*     */     
/* 717 */     if (actionGroupReference == null) {
/* 718 */       actionGroupReference = DataActionGroupKey.DEFAULT.toString();
/*     */     }
/*     */     
/* 721 */     ActionGroupType actionGroup = null;
/* 722 */     for (ActionGroupType actionGrp : argFormType.getActionGroups()) {
/* 723 */       if (actionGroupReference.equalsIgnoreCase(actionGrp.getName())) {
/* 724 */         actionGroup = actionGrp;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 730 */     List<IXstAction> actions = new ArrayList<>();
/* 731 */     for (Action actionConfig : actionGroup.getActions()) {
/* 732 */       IXstAction action = this._actionFactory.getAction(argActionGroupKey, actionConfig);
/*     */       
/* 734 */       if (action == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 738 */       if (!action.isValid()) {
/* 739 */         _logger.info("Menu item will be excluded, as its action key does not exist [" + action.getActionKey() + "] @@ " + actionConfig
/* 740 */             .getSourceDescription());
/*     */         
/*     */         continue;
/*     */       } 
/* 744 */       for (IVisibilityRule rule : action.getVisibilityRules()) {
/* 745 */         if (rule instanceof IFormVisibilityRule) {
/* 746 */           ((IFormVisibilityRule)rule).setEditModel(argEditModel);
/*     */         }
/*     */       } 
/*     */       
/* 750 */       actions.add(action);
/*     */     } 
/*     */     
/* 753 */     IXstAction helpAction = this._actionFactory.getHelpAction();
/* 754 */     if (argIncludeHelpAction && helpAction != null) {
/* 755 */       actions.add(helpAction);
/*     */     }
/*     */     
/* 758 */     return actions;
/*     */   }
/*     */   
/*     */   private Insets convertStringToPaddingInsets(String argPaddingString, LocatableObject argSourceInformation) {
/* 762 */     if (StringUtils.isEmpty(argPaddingString)) {
/* 763 */       return new Insets(0, 0, 0, 0);
/*     */     }
/*     */     
/* 766 */     Insets padding = null;
/*     */     
/* 768 */     String[] paddingVals = argPaddingString.split(",");
/* 769 */     if (paddingVals.length == 4) {
/*     */       try {
/* 771 */         int[] paddingInts = new int[4];
/* 772 */         int index = 0;
/* 773 */         for (String pad : paddingVals) {
/* 774 */           paddingInts[index++] = Integer.valueOf(pad.trim()).intValue();
/*     */         }
/*     */         
/* 777 */         padding = new Insets(paddingInts[0], paddingInts[3], paddingInts[2], paddingInts[1]);
/*     */       }
/* 779 */       catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 784 */     if (padding == null) {
/* 785 */       _logger.error("Ignored invalid padding in " + argSourceInformation.getFile() + " at line " + argSourceInformation
/* 786 */           .getLineNumber() + " and column " + argSourceInformation.getColumnNumber() + ". Correct format is \"top, right, bottom, left\", Eg: \"5,5,5,5\"");
/*     */       
/* 788 */       padding = new Insets(0, 0, 0, 0);
/*     */     } 
/*     */     
/* 791 */     return padding;
/*     */   }
/*     */   
/*     */   private String getFormParameter(List<FormParameterType> argParameters, String argParamType) {
/* 795 */     if (argParameters == null || argParameters.isEmpty()) {
/* 796 */       return null;
/*     */     }
/*     */     
/* 799 */     Predicate<FormParameterType> paramTypeCheckPredicate = p -> p.getName().equalsIgnoreCase(argParamType);
/* 800 */     Optional<FormParameterType> result = argParameters.stream().filter(paramTypeCheckPredicate).findFirst();
/*     */     
/* 802 */     return result.isPresent() ? ((FormParameterType)result.get()).getValue() : null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\FormAssembler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */